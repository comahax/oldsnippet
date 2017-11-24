/**
 * 
 */
package com.sunrise.jop.common.businesslog;

import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sunrise.jop.common.commoncontrol.CommonBO;
import com.sunrise.jop.common.commoncontrol.CommonControl;
import com.sunrise.jop.common.spring.AbstractAdvisor;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.sysadmin.BusinessLog;
import com.sunrise.jop.infrastructure.sysadmin.BusinessLogException;
import com.sunrise.jop.infrastructure.sysadmin.BusinessRepointLog;
import com.sunrise.jop.infrastructure.sysadmin.ManageLog;

/**
 * ҵ����־������
 * 
 * @author
 * 
 */
public class BusinessLogAdvisor extends AbstractAdvisor {

	private static Log log = LogFactory.getLog(BusinessLogAdvisor.class);

	private static StringBuffer methods;
	private static final String notBlank = "\\S*"; //�ǿ��ַ�,��ͬdoCreate*��*
	private static final String or = "|";
	
	private static final String METHOD_CREATE = "doCreate";
	private static final String METHOD_UPDATE = "doUpdate";
	private static final String METHOD_REMOVE = "doRemove";
	private static final String METHOD_REMOVEBYVO = "doRemoveByVO";
	private static final String METHOD_REMOVEBYPK = "doRemoveByPK";
	
	private static Pattern pattern;
	
	static {
		methods = new StringBuffer("");
		//������ʽ���һ�����ܼ�|,�����Ҫ������֤�������ǰ��
		methods.append("(").append(METHOD_CREATE).append(notBlank).append(")").append(or);
		methods.append("(").append(METHOD_UPDATE).append(notBlank).append(")").append(or);
		methods.append("(").append(METHOD_REMOVE).append(notBlank).append(")").append(or);
		methods.append("(").append(METHOD_REMOVEBYVO).append(notBlank).append(")").append(or);
		methods.append("(").append(METHOD_REMOVEBYPK).append(notBlank).append(")");
		pattern = Pattern.compile(methods.toString());
	}

	private boolean checkArgs(Method method, Object[] args) {
		boolean requireLog = false;

		if (pattern.matcher(method.getName()).find())
			requireLog = true;

		if (args == null || args.length == 0) {
			throw new BusinessLogException("������ʧ�� " + method.getName());
		}

		if (args[0] == null)
			throw new BusinessLogException("��һ������VO ��ʧ�� " + method.getName());

		if (METHOD_REMOVEBYPK.equals(method.getName())) {
			if (!(args[0] instanceof Serializable)) {
				throw new BusinessLogException("��һ������VO ����ʵ�� Serializable �ӿڣ� "
						+ method.getName());
			}

			String voClassName = StringUtils.replace(method.getDeclaringClass()
					.getName(), ".control.", ".business.");
			voClassName = StringUtils.replace(voClassName, "BO", "VO");

			try {
				Class cls = Class.forName(voClassName);
				Object obj = cls.newInstance();
				if (obj instanceof BusinessLog)
					requireLog = true;
				else
					requireLog = false;
			} catch (Exception e) {
				throw new BusinessLogException(e.getMessage(), e);
			}

		} else {
			if (!(args[0] instanceof BaseVO))
				throw new BusinessLogException("��һ������VO ������BaseVO�����࣡ "
						+ method.getName());

			if (!((args[0] instanceof ManageLog) || (args[0] instanceof BusinessLog)))
				requireLog = false;
		}

		return requireLog;
	}

	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object result = null;

		Object object = invocation.getThis();
		Method method = invocation.getMethod();
		Object[] args = invocation.getArguments();
		Object target = invocation.getStaticPart();

		boolean requireLog = false; // ����Ƿ���Ҫ��¼��־
		try {
			requireLog = checkArgs(method, args);
		} catch (BusinessLogException e) {
			if (log.isErrorEnabled())
				log.error("��¼ҵ����־�����������Ϲ淶,��ҵ������Ի��������־�������¼:" + e.getMessage());
		}

		if (requireLog == false) { // ����Ҫ���޷���¼��־�������ҵ������Ի����
			try {
				result = invocation.proceed();
				return result;
			} catch (Exception e) {
				throw e;
			}
		}
		// �����������������Ҫ��¼ҵ����־
		boolean success = true;//ҵ������Ƿ�ɹ�
		try {
			if ((method.getName().equals(METHOD_REMOVEBYPK))
					|| (method.getName().equals(METHOD_REMOVEBYVO))) {

				AbstractControl control = (AbstractControl) object;
				DBAccessUser user = control.getUser();

				int objectCount = countObjectToRemove(object, method, args,
						user);
				if (objectCount > 0) { // ��Ҫɾ�������ݣ� ����
					try {
						doLog(object, method, args, target, success);
					} finally {
						result = invocation.proceed();
						success = true;
					}

				} else {
					if (log.isDebugEnabled())
						log.debug("û��Ҫɾ��������, ����¼ҵ����־:" + object + ",����:"
								+ method.getName());
					return null; // ����ֱ�ӷ���
				}

			} else {
				result = invocation.proceed();
				doLog(object, method, args, target,success);
			}

			if (log.isDebugEnabled())
				log.debug("��¼�ɹ�ҵ����־:" + object + ",����:" + method.getName());
			// ��¼�ɹ�
		} catch (Exception e) {
			// ��¼ʧ��
			success = false;
			if (!(e instanceof BusinessLogException)) {
				String failcause = null;
				if (e.getMessage() != null) {
					int len = e.getMessage().length();
					failcause = len > 256 ? e.getMessage().substring(len - 256)
							: e.getMessage();
				}

				try {
					doLog(object, method, args, target, success);
					if (log.isDebugEnabled())
						log.debug("��¼ʧ��ҵ����־:" + object + ",����:"
								+ method.getName() + ",ԭ��:" + e.getMessage());

				} catch (BusinessLogException e2) {
					if (log.isWarnEnabled()) {
						log.warn("ҵ�����ʧ�ܣ������޷���¼ҵ����־:" + e2.getMessage()
								+ object + ",����:" + method.getName());
					}
				}
				throw e;
			} else {
				if (log.isWarnEnabled()) {
					if (success)
						log.warn("ҵ������ɹ������޷���¼ҵ����־:" + e.getMessage() + ",����:"
								+ object + ",����:" + method.getName(), e);
					else
						log.warn("ҵ�����ʧ�ܣ������޷���¼ҵ����־:" + e.getMessage() + ",����:"
								+ object + ",����:" + method.getName(), e);
				}

			}
		}
		return result;
	}

	private int countObjectToRemove(Object object, Method method,
			Object[] args, DBAccessUser user) {
		try {
			Serializable pk = (Serializable) args[0];
			CommonControl commonControl = (CommonControl) BOFactory.build(
					CommonBO.class, user);
			String voClassName = object.getClass().getName();
			voClassName = StringUtils.replace(voClassName, ".control.",
					".business."); // �滻����
			voClassName = StringUtils.replace(voClassName, "BO", "VO"); // �滻ΪVO��
			commonControl.setVoClass(Class.forName(voClassName));
			BaseVO baseVO = (BaseVO) commonControl.doFindByPk(pk); // Ϊ���Ч�ʣ��Ժ��Ϊ
			// count����
			if (baseVO != null)
				return 1;
			else
				return 0;

		} catch (Throwable t) {
			throw new BusinessLogException(t.getMessage(), t);
		}

	}

	private void doLog(Object object, Method method, Object[] args,
			Object target, boolean success) throws BusinessLogException {
		try {
			AbstractControl control = (AbstractControl) object;
			DBAccessUser user = control.getUser();
			Serializable logObject = (Serializable) args[0];
			if (logObject instanceof ManageLog) { // ��¼������־
				manageLog(method, logObject, user);
			} else { // ��¼ҵ����־
				businessLog(method, logObject, success, user);
			}
		} catch (Throwable t) {
			throw new BusinessLogException(t.getMessage(), t);
		}

	}

	private void manageLog(Method method, Serializable logObject,
			DBAccessUser user) throws Exception {
		// Managelog control = (Managelog) BOFactory.build(ManagelogBO.class,
		// user);
		// ManagelogVO logvo = new ManagelogVO();
		//				
		// logvo.setOprtime(new Date());
		// logvo.setOprcode(user.getOprcode());
		// logvo.setIp(user.getIp());
		// logvo.setOprstate( oprstate );
		// logvo.setOpraction( getOprAction(method.getName()));
		// //ʧ��ԭ��
		// if(oprstate.byteValue() == BusinessLog.STATE_FAIL.byteValue() &&
		// failcause!=null)
		// logvo.setFailcause(failcause);
		//				
		// if( logObject instanceof BaseVO) { //��¼����ΪVO
		// BaseVO baseVO = (BaseVO)logObject;
		// String shortName =
		// ClassUtils.getShortClassName(logObject.getClass().getName());
		// shortName = StringUtils.remove(shortName, "VO");
		// logvo.setOprtype( StringUtils.upperCase(shortName) );
		// ToStringStyle style =new ManageLogToStringStyle();
		// logvo.setOprdata( ReflectionToStringBuilder.toString(baseVO, style));
		//					
		// control.doRecordLog(logvo); //
		// ע�⣺����ʹ��ManageLogControl.doRecordLog����¼ҵ����־, ʹ��
		// ManageLogControl.doCreate �������ᱻ�ظ����ؼ�¼������־
		//					
		// }else if(METHOD_REMOVEBYPK.equals(method.getName())){ //
		// ��¼����ΪSerializable, ���磺doRemoveByPK �����Ĳ���PK
		//					
		// String voClassName = StringUtils.replace(
		// method.getDeclaringClass().getName(), ".control.", ".persistent.");
		// //�滻����
		// voClassName = StringUtils.replace(voClassName, "ControlBean", "VO");
		// //�滻ΪVO��
		// log.info("voClassName " + voClassName);
		// voClassName = StringUtils.replace(voClassName, "Control", "VO");
		// //�滻ΪVO��
		// String shortName = ClassUtils.getShortClassName(voClassName);
		// shortName = StringUtils.remove(shortName, "VO");
		// logvo.setOprtype(shortName);
		// logvo.setOprdata("PK:" + logObject);
		//					
		// control.doRecordLog(logvo); //
		// ע�⣺����ʹ��ManageLogControl.doRecordLog����¼ҵ����־, ʹ��
		// ManageLogControl.doCreate �������ᱻ�ظ����ؼ�¼������־
		// }
		throw new BusinessLogException("ManageLog�ӿ���δʵ��   " + method.getName());
	}

	protected void businessLog(Method method, Serializable baseVO,boolean success,
			DBAccessUser user) {
		try {
			if (baseVO instanceof BusinessLog) {
				BusinessLog businessLog = (BusinessLog) baseVO;
				Class logVOClass = businessLog.logVOClass();
				Object logVO = logVOClass.newInstance();
				String methodname = method.getName();
				
				String[] properties = BusinessRepointLog.logProperties;
				if(businessLog instanceof BusinessRepointLog){
					properties = ((BusinessRepointLog)businessLog).repointLogProperites();
					if(properties == null || properties.length != 5){
						throw new BusinessLogException("VO " + baseVO
								+ " δ�趨 repointLogProperites ֵ����ָ�����Ը���������5�������ܼ�¼ҵ����־ ");
					}
				}
				logVO = setLogProperties(logVO, methodname, user, properties, success);
				BeanUtils.copyProperties(logVO, baseVO);
				BusinessLogControl control = (BusinessLogControl) BOFactory
						.build(BusinessLogBO.class, user);
				String voClassName = logVOClass.getName();
				control.setVoClass(Class.forName(voClassName));
				control.doLogCreate(logVO);
			} else if (METHOD_REMOVEBYPK.equals(method.getName())) {//doRemoveByPK�����������ֵ
				String voClassName = StringUtils.replace(method
						.getDeclaringClass().getName(), ".control.",
						".business.");
				voClassName = StringUtils.replace(voClassName, "BO", "VO");
				CommonControl commonControl = (CommonControl) BOFactory.build(
						CommonBO.class, user);
				commonControl.setVoClass(Class.forName(voClassName));
				Object baseVO2 = commonControl.doFindByPk(baseVO);
				BusinessLog businessLog = (BusinessLog) baseVO2;
				if (businessLog.logVOClass() == null) {
					throw new BusinessLogException("VO " + baseVO2
							+ " δ�趨 logVOClass ֵ�����ܼ�¼ҵ����־ ");
				}
				Class logVOClass = businessLog.logVOClass();
				Object logVO = logVOClass.newInstance();
				String methodname = method.getName();
				
				String[] properties = BusinessRepointLog.logProperties;
				if(businessLog instanceof BusinessRepointLog){
					properties = ((BusinessRepointLog)businessLog).repointLogProperites();
					if(properties == null || properties.length != 5){
						throw new BusinessLogException("VO " + baseVO2
								+ " δ�趨 repointLogProperites ֵ����ָ�����Ը����������5��,���������û�и�������ֵΪnull,���ܼ�¼ҵ����־ ");
					}
				}
				Object logVO2 = setLogProperties(logVO, methodname, user, properties, success);
				BeanUtils.copyProperties(logVO2, baseVO2);
				BusinessLogControl control = (BusinessLogControl) BOFactory
						.build(BusinessLogBO.class, user);
				String logvoClassName = logVOClass.getName();
				control.setVoClass(Class.forName(logvoClassName));
				control.doLogCreate(logVO2);
			}
		} catch (Throwable t) {
			throw new BusinessLogException(t.getMessage(), t);
		}
	}

	/**
	 * ����־�Ĺ������Խ�������
	 * @param properties 
	 */
	protected Object setLogProperties(Object obj, String methodName,
			DBAccessUser user, String[] properties, boolean success) throws IllegalAccessException,
			InvocationTargetException, NoSuchMethodException {
		Serializable s = (Serializable) obj;
		PropertyDescriptor optimePty = PropertyUtils.getPropertyDescriptor(s,
				properties[BusinessRepointLog.optime]);
		java.util.Date optimeValue = new java.util.Date();
		String optimeString = PublicUtils.formatUtilDate(optimeValue,
				"yyyy-MM-dd HH:mm:ss");
		if (optimePty != null) {
			Class optimeType = optimePty.getPropertyType();
			if (java.sql.Date.class.isAssignableFrom(optimeType)) {
				optimeValue = new java.sql.Date(System.currentTimeMillis());
				optimeString = PublicUtils.formatUtilDate(optimeValue,
						"yyyy-MM-dd");
			} else if (java.sql.Timestamp.class.isAssignableFrom(optimeType)) {
				optimeValue = new java.sql.Timestamp(System.currentTimeMillis());
				optimeString = PublicUtils.formatUtilDate(optimeValue,
						"yyyy-MM-dd HH:mm:ss");
			}
		}
		String oprtype = getOprtype(methodName);
		String issuccess = (success==true?"success":"failure");
		if(StringUtils.isNotEmpty(properties[BusinessRepointLog.optime]))
			BeanUtils.setProperty(s, properties[BusinessRepointLog.optime], optimeString);
		if(StringUtils.isNotEmpty(properties[BusinessRepointLog.oprcode]))
			BeanUtils.setProperty(s, properties[BusinessRepointLog.oprcode], user.getOprcode());
		if(StringUtils.isNotEmpty(properties[BusinessRepointLog.oprtype]))
			BeanUtils.setProperty(s, properties[BusinessRepointLog.oprtype], oprtype);
		if(StringUtils.isNotEmpty(properties[BusinessRepointLog.success]))
			BeanUtils.setProperty(s, properties[BusinessRepointLog.success], issuccess);
		
		return s;
	}

	private String getOprtype(String methodName) {
		if (methodName.startsWith(METHOD_CREATE)) {
			return new String("create");
		} else if (methodName.startsWith(METHOD_UPDATE)) {
			return new String("update");
		} else if (methodName.startsWith(METHOD_REMOVE)) { // doRemove*
			return new String("remove");
		} else
			return new String("unknown");
	}

}
