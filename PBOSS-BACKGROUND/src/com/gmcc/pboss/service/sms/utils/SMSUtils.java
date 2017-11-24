package com.gmcc.pboss.service.sms.utils;

import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;

import com.gmcc.pboss.BgProcess.service.sms.SMSProtocol;
import com.gmcc.pboss.service.sms.exception.SMSException;
import com.gmcc.pboss.service.sms.result.SMSResult;
import com.sunrise.jop.common.utils.lang.LoggerUtils;

public class SMSUtils {

	/**
	 * ���ؼ�¼�쳣��־,���ش�����
	 * @param e
	 * @param logger
	 * @return
	 */
	public static String getErrorResult(Exception e, Logger logger){
		if(e instanceof SMSException){
			logger.info(e.getMessage());
			return ((SMSException)e).getErrCode() + SMSProtocol.WORD_SLIT_SYMBOL + ((SMSException)e).getMessage() + SMSProtocol.WORD_END_SYMBOL;
		}else{
			LoggerUtils.error(e, logger);
			return SMSResult.RET_TYPE_FAIL_111 + SMSProtocol.WORD_SLIT_SYMBOL + "ϵͳ����,����ϵ����Ա!" + SMSProtocol.WORD_END_SYMBOL;
		}
	}
	
	/**
	 * ���ؼ�¼�쳣��־,���ش�����
	 * @param e
	 * @param logger
	 * @param errType
	 * @return
	 */
	public static String getErrorResult(Exception e, Log logger){
		if(e instanceof SMSException){
			logger.info(e.getMessage());
			return ((SMSException)e).getErrCode() + SMSProtocol.WORD_SLIT_SYMBOL + ((SMSException)e).getMessage() + SMSProtocol.WORD_END_SYMBOL;
		}else{
			LoggerUtils.error(e, logger);
			return SMSResult.RET_TYPE_FAIL_111 + SMSProtocol.WORD_SLIT_SYMBOL + "ϵͳ����,����ϵ����Ա!" + SMSProtocol.WORD_END_SYMBOL;
		}
	}
	
}
