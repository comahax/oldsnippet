package com.gmcc.pboss.common.businesslog;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Map;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;

import com.common.util.bean.BeanUtils;
import com.gmcc.pboss.common.bean.AutoLogBean;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.businesslog.dao.AutoLogDao;
import com.gmcc.pboss.common.dictionary.HttpDictionary;
import com.gmcc.pboss.common.service.AbstractAdvisor;
import com.opensymphony.xwork2.ActionContext;

/**
 * �Զ���־��¼BEAN
 * �Զ�����ͨ��AOPע�룬Ŀǰֻ�ṩ��After-returning��ע�봦��
 * @author yuwenjun
 */
public class BusinessLogAdvisor extends AbstractAdvisor {
	
	/**
	 *VO ��Σ�������ȡVO����
	 */
	private Object voObj;
	
	private AutoLogDao autoLogDao;
	
	private static Logger logger = Logger.getLogger(BusinessLogAdvisor.class);
	/* (non-Javadoc)
	 * @see com.gmcc.pboss.common.service.AbstractAdvisor#afterReturning(java.lang.Object, java.lang.reflect.Method, java.lang.Object[], java.lang.Object)
	 */
	@Override
	public void afterReturning(Object returnValue, Method method,
			Object[] args, Object target) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("ע��afterReturning!");
//		super.afterReturning(returnValue, method, args, target);
	}
	
	/**
	 * ͨ��<aop>���õ�ע��
	 * ͳһ������־����
	 * @param jp -- ���ӵ������Ϣ
	 * @param retVal -- ע���෵��ֵ
	 */
	public void autoSaveLog(JoinPoint jp,Object retVal){
		this.doLog(jp, retVal, "create");
	}
	
	/**
	 * ͨ��<aop>����ע�����еĸ��·���
	 * @param jp -- ���ӵ������Ϣ
	 */
	public void autoUpdateLog(JoinPoint jp){
		this.doLog(jp, null, "update");
	
	}
	/**
	 * ִ���Զ���־����
	 * @param jp
	 * @param retVal
	 * @param type
	 * @throws Throwable 
	 */
	private void doLog(JoinPoint jp,Object retVal,String type) {
		if (this.isAutoLog(jp)){
			//�����Զ���־�����������Զ���־����
			//������־�Ĺ�������
//			setLogCommonProperties();
			try {
				AutoLogBean logBean = (AutoLogBean) this.voObj;
				String[] logPropreties = logBean.getLogProperties();
				Class logClass = logBean.getLogClass();
				Object logVO = logClass.newInstance();
				BeanUtils.copyProperties(logVO, this.voObj);
				this.setCommonProperties(logVO,type,logPropreties);
				
				//���ֲ���
				autoLogDao.setLogClass(logClass);
				autoLogDao.save(logVO);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				throw new BusinessLogException(e);
			}
		}
	}
	
	/**
	 * ����LogVo�Ĺ�������
	 * @param logVO
	 * @param type
	 */
	private void setCommonProperties(Object logVO,String type,String[] logProperties){
		Serializable s = (Serializable) logVO;
		//��ȡ��ǰ������
		Map session = ActionContext.getContext().getSession();

		Object obj = session.get(HttpDictionary.USER_NAME);
		LoginMember member = (obj != null)?(LoginMember)obj:null;
		
		try {
			Date now = new Date();
			BeanUtils.setProperty(s, logProperties[AutoLogBean.opntime], now); 
			BeanUtils.setProperty(s, logProperties[AutoLogBean.oprtype], type);
			if (member != null){
				//��ǰ�����ߴ��ڣ�����ȡ��Ȼ�����˹���
				BeanUtils.setProperty(s, logProperties[AutoLogBean.opncode], member.getEmployeeid());
			}
			//�ж��Ƿ����Success����ֶ�
			if (logProperties.length>AutoLogBean.success){
				//��ǰ�����ߴ��ڣ�����ȡ��Ȼ�����˹���
				BeanUtils.setProperty(s, logProperties[AutoLogBean.success], "success");				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new BusinessLogException(e);
		}
		
	}
	
	/**
	 * �ж�������Ƿ�����Զ���־������
	 * @param jp --�������Ϣ����ȡVO�Ĵ��������
	 * @return true-�����Զ���¼��־
	 */
	private boolean isAutoLog(JoinPoint jp){

		//��ȡ�����ݹ����Ĳ���
		Object[] inArg = jp.getArgs();
		if (inArg.length>0){
			//��һ������ΪVO
			this.voObj = inArg[0];
			return AutoLogBean.class.isAssignableFrom(this.voObj.getClass());
		}
		return false;
	}

	/**
	 * @return the autoLogDao
	 */
	public AutoLogDao getAutoLogDao() {
		return autoLogDao;
	}

	/**
	 * @param autoLogDao the autoLogDao to set
	 */
	public void setAutoLogDao(AutoLogDao autoLogDao) {
		this.autoLogDao = autoLogDao;
	}

}
