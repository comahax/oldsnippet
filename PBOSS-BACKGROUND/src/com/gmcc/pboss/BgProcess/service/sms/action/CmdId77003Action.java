package com.gmcc.pboss.BgProcess.service.sms.action;


import org.apache.log4j.Logger;

import com.gmcc.pboss.BgProcess.service.sms.SMSProtocol;
import com.gmcc.pboss.BgProcess.service.sms.annotation.MethodLevelPointcut;
import com.gmcc.pboss.control.service.sms.orderquery.SMSOrderQuery;
import com.gmcc.pboss.control.service.sms.orderquery.SMSOrderQueryBO;
import com.gmcc.pboss.service.sms.exception.SMSException;
import com.gmcc.pboss.service.sms.result.SMSResult;
import com.gmcc.pboss.service.sms.utils.SMSUtils;
import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;


/**
 * 【订单查询】短信营业厅接口逻辑
 * @author Canigar
 * @since 2009-12-28
 */
public class CmdId77003Action extends BaseSocketAction {

	private static Logger logger = Logger.getLogger(CmdId77003Action.class);
	
	@MethodLevelPointcut
	public void execute() {
		String result = orderQuery(getRequest().getDataTrans());
		getResponse().setDataTrans(result);
	}
	
	/**
	 * 77003命令字格式:用户号码~工号~返回格式~订单号~;
	 * @param contextStr
	 * @return
	 */
	private String orderQuery(String contextStr){
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
			SMSOrderQuery orderQuery = (SMSOrderQuery)BOFactory.build(SMSOrderQueryBO.class, user);
			return orderQuery.doResult(datatrans[0],datatrans[3]).toString();
		}catch (Exception e) {
			return SMSUtils.getErrorResult(e, logger);
		}
	}
}
