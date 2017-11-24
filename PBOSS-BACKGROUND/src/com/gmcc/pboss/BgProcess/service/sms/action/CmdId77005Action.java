package com.gmcc.pboss.BgProcess.service.sms.action;

import org.apache.log4j.Logger;

import com.gmcc.pboss.BgProcess.service.sms.SMSProtocol;
import com.gmcc.pboss.BgProcess.service.sms.annotation.MethodLevelPointcut;
import com.gmcc.pboss.control.service.sms.disformfinishenrol.SMSDisformFinishenrol;
import com.gmcc.pboss.control.service.sms.disformfinishenrol.SMSDisformFinishenrolBO;
import com.gmcc.pboss.service.sms.exception.SMSException;
import com.gmcc.pboss.service.sms.result.DisformFinishenrolResult;
import com.gmcc.pboss.service.sms.result.SMSResult;
import com.gmcc.pboss.service.sms.utils.SMSUtils;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;

/**
 * 【配送完成登记】短信营业厅接口逻辑
 * @author wefrogll
 *
 */
public class CmdId77005Action extends BaseSocketAction {

	private static Logger logger = Logger.getLogger(CmdId77005Action.class);
	
	@MethodLevelPointcut
	public void execute() {
		// TODO Auto-generated method stub
		String result = disformFinish(getRequest().getDataTrans());
		getResponse().setDataTrans(result);
	}

	/*
	 * 77005 命令字格式 :用户号码~工号~返回格式~订单号~;
	 */
	public String disformFinish(String contextStr){
		String[] datatrans = StringUtils.split(contextStr, SMSProtocol.WORD_SLIT_SYMBOL);
		if(datatrans.length < 4){
			return SMSProtocol.WRONG_FORMAT;
		}
		DBAccessUser user = super.getDbAccessUser();
		if(StringUtils.isEmpty(user.getCityid())) {
			throw new SMSException(SMSResult.RET_MESSAGE_FAIL_1,
					SMSResult.RET_TYPE_FAIL_1);
		}
		try{
			SMSDisformFinishenrol bo = (SMSDisformFinishenrolBO) BOFactory.build(SMSDisformFinishenrolBO.class,user);
			return bo.doResult(datatrans[0], datatrans[3]);
		}catch(SMSException e){
			return SMSUtils.getErrorResult(e, logger);
		}catch(Exception e){
			return SMSUtils.getErrorResult(new SMSException("失败",DisformFinishenrolResult.RET_TYPE_FAIL_111), logger);
		}
		
	}
}
