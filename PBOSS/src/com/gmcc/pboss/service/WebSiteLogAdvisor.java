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
	
	private static final long allPerSecond = 60;  //限制后台周期
	private static final long allMaxTimes = 1000000;  //限制后台访问次数
	
	private static final int userPerSecond = 60; //限制单个用户周期
	private static final int userMaxTimes = 3;   //限制单个用户访问次数
	
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object result = null;
		
		try {
			// 防御攻击
			boolean flag = true;
			
			//防御单个用户登录过多攻击
//			String ip = InetAddress.getLocalHost().getHostAddress();
//			if(userMap.get(ip) == null){
//				userMap.put(ip, new WebsiteCounter());
//			}
//			flag = countInvokeTimes(userMap.get(ip),userPerSecond,userMaxTimes);
			
			//防御后台压力过大
			if(flag){
				flag = countInvokeTimes(allCounter,allPerSecond,allMaxTimes);
			}
			
			// 记录请求信息日志（未完成）

			// 处理
			if(flag){
				result = invocation.proceed();
				return result;
			}else{
				Object obj = invocation.getMethod().getReturnType().newInstance();
				BeanUtils.setProperty(obj, "retCode", RetResult.ERROR);
				BeanUtils.setProperty(obj, "message", "系统繁忙,请稍后再试...");
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
