/**
 * 
 */
package com.gmcc.pboss.service;

import java.util.HashMap;
import java.util.Map;

import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.beanutils.BeanUtils;

import com.gmcc.pboss.service.result.RetResult;
import com.sunrise.jop.common.spring.AbstractAdvisor;

/**
 * @author hbm
 * 
 */
public class WebSiteLogAdvisor extends AbstractAdvisor {
	
	private static WebsiteCounter allCounter = new WebsiteCounter();
	private static Map<String,WebsiteCounter> userMap = new HashMap<String,WebsiteCounter>();
	
	private static final long allPerSecond = 60;  //���ƺ�̨����
	private static final long allMaxTimes = 1000000;  //���ƺ�̨���ʴ���
	
	private static final int userPerSecond = 60; //���Ƶ����û�����
	private static final int userMaxTimes = 3;   //���Ƶ����û����ʴ���
	
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object result = null;
		
		try {
			// ��������
			boolean flag = true;
			
			//���������û���¼���๥��
//			String ip = InetAddress.getLocalHost().getHostAddress();
//			if(userMap.get(ip) == null){
//				userMap.put(ip, new WebsiteCounter());
//			}
//			flag = countInvokeTimes(userMap.get(ip),userPerSecond,userMaxTimes);
			
			//������̨ѹ������
			if(flag){
				flag = countInvokeTimes(allCounter,allPerSecond,allMaxTimes);
			}
			
			// ��¼������Ϣ��־��δ��ɣ�

			// ����
			if(flag){
				result = invocation.proceed();
				return result;
			}else{
				Object obj = invocation.getMethod().getReturnType().newInstance();
				BeanUtils.setProperty(obj, "retCode", RetResult.ERROR);
				BeanUtils.setProperty(obj, "message", "ϵͳ��æ,���Ժ�����...");
				return obj;
			}
		} finally {

		}
		
	}
	
	private boolean countInvokeTimes(WebsiteCounter counter, long perSecond, long maxTimes){
		boolean flag = true;
		if(counter.getThreadLocal().get() == null){
			counter.getThreadLocal().set(System.currentTimeMillis());
			counter.setTimes(counter.getTimes()+1);
		}else if(System.currentTimeMillis() - counter.getThreadLocal().get() > 1000 * perSecond){
			counter.getThreadLocal().set(System.currentTimeMillis());
			counter.setTimes(0);
		}else{
			counter.setTimes(counter.getTimes()+1);
		}
		if(counter.getTimes() > maxTimes) flag = false;
		return flag;
	}
	
}
