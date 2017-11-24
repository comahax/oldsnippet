package com.gmcc.pboss.BgProcess.service.sms.advise;

import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Logger;

import com.atomikos.jdbc.AtomikosSQLException;
import com.gmcc.pboss.BgProcess.service.sms.SMSProtocol;
import com.gmcc.pboss.BgProcess.service.sms.action.BaseSocketAction;
import com.gmcc.pboss.control.service.sms.ServiceSmsBOHelper;
import com.gmcc.pboss.service.sms.utils.SMSUtils;
import com.sunrise.jop.common.spring.AbstractAdvisor;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.common.utils.logging.LoggingConstant;
import com.sunrise.jop.infrastructure.db.CityMappingUtil;
import com.sunrise.jop.infrastructure.db.DBAccessUser;

/**
 * <pre>
 * ������ݿ����ӵ�Advise
 * ��������Ҫ�󾫶Ȳ��ߣ�����Ϊ���̰߳�ȫ
 * </pre>
 * @author zhangsiwei
 *
 */
public class DBConnectionMonitorAdvise extends AbstractAdvisor {
	
	private static Logger log = Logger.getLogger(DBConnectionMonitorAdvise.class);
	public static Map<String,Integer> countMap = new HashMap<String,Integer>(); // ��¼�������е����ݿ�����������
	private static Map<String,Integer> usingMap = new HashMap<String,Integer>(); // ��¼������������ʹ�õ����ݿ�������
	private static Map<String,Integer> poolsizeMap = new HashMap<String,Integer>(); // �������е����ݿ����ӳص����������
	private final static Properties properties = new Properties(); // SMSService.properties�������ļ���Ϣ
	private static Map<String,String[]> trackTimeMap = new HashMap<String,String[]>(); // ���� ������������ʹ�����ӽ��������ֵʱ��ʱ���
	private static double alarmRate = 0.0; // Ԥ������
	
	static {
		init();
	}
	
	private static void init(){
		String cityid = null;
		try {
			InputStream is = DBConnectionMonitorAdvise.class.getResourceAsStream("/service/sms/SMSService.properties");
			properties.load(is);
			is.close();
			alarmRate = Double.parseDouble(properties.getProperty("sms_alarmrate"));
		
			for(Iterator it = CityMappingUtil.getMap().keySet().iterator();it.hasNext();) {
				cityid = (String)it.next();
				if("DB_COMMON".equals(cityid) || "GD".equals(cityid)) {
					continue;
				}
				countMap.put(cityid, 0);
				usingMap.put(cityid, 0);
				poolsizeMap.put(cityid, Integer.parseInt(properties.getProperty(cityid + "_sms_db_poolsize")));
				trackTimeMap.put(cityid, new String[2]);
			}
		}catch(Exception ex) {
			log.info(ex);
		}
	}
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object result = null;
		
		Object target = invocation.getThis();
		String cityid = null;
		Logger monitorlog = null;
		try {
			monitorlog = ServiceSmsBOHelper.createChildLogger(
					LoggingConstant.MONITOR_DB_CONN_LOGNAME,DBConnectionMonitorAdvise.class.getSimpleName());
			if(target instanceof BaseSocketAction) {
				BaseSocketAction action = (BaseSocketAction)target;
				cityid = initDbAccessUesr(action);
			}
//			if(target instanceof AbstractDAO) {
//				AbstractDAO dao = (AbstractDAO)target;
//				cityid = dao.getDbFlag();
//			}
			int usingAmount_0 = 0;
			try {
				if(!usingMap.containsKey(cityid)) {
					monitorlog.warn("Ҫ��صĵ��� ["+cityid+"] ������");
				} else {
//					synchronized(this) {
						usingAmount_0 = usingMap.get(cityid);
						
						if(usingAmount_0 == 0) {
							trackTimeMap.get(cityid)[0] = PublicUtils.formatUtilDate(new Date(), "yyyy/MM/dd HH:mm:ss");
						}
						usingMap.put(cityid, ++usingAmount_0);
						if(usingAmount_0 >= Math.ceil(poolsizeMap.get(cityid) * alarmRate)) {
							trackTimeMap.get(cityid)[1] = PublicUtils.formatUtilDate(new Date(), "yyyy/MM/dd HH:mm:ss");
							logPoolSizeAlarm(monitorlog, cityid, usingAmount_0,
									poolsizeMap.get(cityid), trackTimeMap
											.get(cityid)[0], trackTimeMap
											.get(cityid)[1]);
						}
					}
//				}
				result = invocation.proceed();
			}catch(Exception e) {
				if(target instanceof BaseSocketAction) {
					String message = SMSUtils.getErrorResult(e, log);
					((BaseSocketAction)target).getResponse().setDataTrans(message);
				}
			}
//			synchronized(this) {
				if(!usingMap.containsKey(cityid)) {
					monitorlog.warn("Ҫ��صĵ��� ["+cityid+"] ������");
				} else {
					int usingAmount_1 = usingMap.get(cityid);
					usingMap.put(cityid, --usingAmount_1);
				}
//			}
			
			if(!countMap.containsKey(cityid)) {
				monitorlog.warn("Ҫ��صĵ��� ["+cityid+"] ������");
			}else {
				Integer count = countMap.get(cityid);
				countMap.put(cityid, count+1);
			}
			return result;
			
		}catch(Exception e) {
			log.error(e.getMessage());
			try {
				result = invocation.proceed();
			}catch(Exception ex) {
				if(target instanceof BaseSocketAction) {
					String message = SMSUtils.getErrorResult(ex, log);
					((BaseSocketAction)target).getResponse().setDataTrans(message);
				}
			}
			return result;
		}
	}
	
	private String initDbAccessUesr(BaseSocketAction action) throws Exception {
		String contextStr = action.getRequest().getDataTrans();
		String[] datatrans = StringUtils.split(contextStr, SMSProtocol.WORD_SLIT_SYMBOL);
		String mobile = datatrans[0];
		DBAccessUser user = new DBAccessUser();
		action.setDbAccessUser(user);
		String cityid = ServiceSmsBOHelper.getMobileArea(mobile,DBAccessUser.getInnerUser());
		user.setCityid(cityid);
		user.setOprcode("PBOSS-BG");
		return cityid;
	}
	
	private void logPoolSizeAlarm(Logger monitorlog, String cityid,
			int usingAmount, int maxAmount, String begintime,
			String endtime) {
		monitorlog.info("-------------���ݿ�������Ԥ�� begin-------------");
		monitorlog.info("ע: ����������������(Connection pool exhausted)������������ʱ�����");
		monitorlog.info("[ÿ���������ͬʱ���������(A)=��ǰ������/���������] ���������������,����1�������������ͬʱ����A������");
		monitorlog.info("");
		monitorlog.info("����		��ǰ������		���������		ʱ����(��¼��ʼʱ��--��¼����ʱ��)");
		monitorlog.info(cityid + "		" + usingAmount + "				" + maxAmount + "			"
				+ "(" + begintime + "--" + endtime + ")");
		monitorlog.info("-------------���ݿ�������Ԥ�� end-------------");
		monitorlog.info("");
	}

}
