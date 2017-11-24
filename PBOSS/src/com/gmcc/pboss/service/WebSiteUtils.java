package com.gmcc.pboss.service;

import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;

import com.gmcc.pboss.service.exception.WebSiteException;
import com.gmcc.pboss.service.result.RetResult;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.exception.business.SaleException;

public class WebSiteUtils {

	/**
	 * 本地记录异常日志,返回错误结果
	 * @param e
	 * @param logger
	 * @return
	 */
	public static RetResult getErrorResult(Exception e, Logger logger){
		RetResult result = new RetResult();
		if(e instanceof WebSiteException){
			logger.info(e.getMessage());
			result.setMessage(e.getMessage());
			result.setRetCode(((WebSiteException)e).getErrCode());
		}else if(e instanceof SaleException){
			logger.info(e.getMessage());
			result.setMessage(e.getMessage());
			result.setRetCode(RetResult.FAILURE);
		}else{
			LoggerUtils.error(e, logger);
			result.setMessage("系统出错,请联系管理员!");
			result.setRetCode(RetResult.ERROR);
		}
		return result;
	}
	
	/**
	 * 本地记录异常日志,返回错误结果
	 * @param e
	 * @param logger
	 * @param errType
	 * @return
	 */
	public static RetResult getErrorResult(Exception e, Log logger){
		RetResult result = new RetResult();
		if(e instanceof WebSiteException){
			logger.info(e.getMessage());
			result.setMessage(e.getMessage());
			result.setRetCode(((WebSiteException)e).getErrCode());
		}else if(e instanceof SaleException){
			logger.info(e.getMessage());
			result.setMessage(e.getMessage());
			result.setRetCode(RetResult.FAILURE);
		}else{
			LoggerUtils.error(e, logger);
			result.setMessage("系统出错,请联系管理员!");
			result.setRetCode(RetResult.ERROR);
		}
		return result;
	}
	
}
