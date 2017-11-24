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
 * 自动日志记录BEAN
 * 自动处理通过AOP注入，目前只提供对After-returning的注入处理
 * @author yuwenjun
 */
public class BusinessLogAdvisor extends AbstractAdvisor {
	
	/**
	 *VO 入参，用于提取VO对象
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
		System.out.println("注入afterReturning!");
//		super.afterReturning(returnValue, method, args, target);
	}
	
	/**
	 * 通过<aop>配置的注入
	 * 统一插入日志处理
	 * @param jp -- 连接点相关信息
	 * @param retVal -- 注入类返回值
	 */
	public void autoSaveLog(JoinPoint jp,Object retVal){
		this.doLog(jp, retVal, "create");
	}
	
	/**
	 * 通过<aop>配置注入所有的更新方法
	 * @param jp -- 连接点相关信息
	 */
	public void autoUpdateLog(JoinPoint jp){
		this.doLog(jp, null, "update");
	
	}
	/**
	 * 执行自动日志操作
	 * @param jp
	 * @param retVal
	 * @param type
	 * @throws Throwable 
	 */
	private void doLog(JoinPoint jp,Object retVal,String type) {
		if (this.isAutoLog(jp)){
			//符合自动日志条件，启动自动日志过程
			//设置日志的公共属性
//			setLogCommonProperties();
			try {
				AutoLogBean logBean = (AutoLogBean) this.voObj;
				String[] logPropreties = logBean.getLogProperties();
				Class logClass = logBean.getLogClass();
				Object logVO = logClass.newInstance();
				BeanUtils.copyProperties(logVO, this.voObj);
				this.setCommonProperties(logVO,type,logPropreties);
				
				//保持操作
				autoLogDao.setLogClass(logClass);
				autoLogDao.save(logVO);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				throw new BusinessLogException(e);
			}
		}
	}
	
	/**
	 * 设置LogVo的公共属性
	 * @param logVO
	 * @param type
	 */
	private void setCommonProperties(Object logVO,String type,String[] logProperties){
		Serializable s = (Serializable) logVO;
		//提取当前操作人
		Map session = ActionContext.getContext().getSession();

		Object obj = session.get(HttpDictionary.USER_NAME);
		LoginMember member = (obj != null)?(LoginMember)obj:null;
		
		try {
			Date now = new Date();
			BeanUtils.setProperty(s, logProperties[AutoLogBean.opntime], now); 
			BeanUtils.setProperty(s, logProperties[AutoLogBean.oprtype], type);
			if (member != null){
				//当前操作者存在，则提取当然操作人工号
				BeanUtils.setProperty(s, logProperties[AutoLogBean.opncode], member.getEmployeeid());
			}
			//判断是否存在Success这个字段
			if (logProperties.length>AutoLogBean.success){
				//当前操作者存在，则提取当然操作人工号
				BeanUtils.setProperty(s, logProperties[AutoLogBean.success], "success");				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new BusinessLogException(e);
		}
		
	}
	
	/**
	 * 判断切入点是否符合自动日志的条件
	 * @param jp --切入点信息（提取VO的传入参数）
	 * @return true-符合自动记录日志
	 */
	private boolean isAutoLog(JoinPoint jp){

		//提取传传递过来的参数
		Object[] inArg = jp.getArgs();
		if (inArg.length>0){
			//第一个参数为VO
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
