package com.gmcc.pboss.BgProcess.service.sms.action;

import org.apache.log4j.Logger;

import com.gmcc.pboss.BgProcess.service.sms.SMSProtocol;
import com.gmcc.pboss.BgProcess.service.sms.annotation.MethodLevelPointcut;
import com.gmcc.pboss.control.service.sms.querybusicountfornet.SMSQueryBusiCountForNet;
import com.gmcc.pboss.control.service.sms.querybusicountfornet.SMSQueryBusiCountForNetBO;
import com.gmcc.pboss.service.sms.utils.SMSUtils;
import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
/**
 * 【网点业务量查询】短厅接口逻辑
 * @author Yedaoe
 *
 */
public class CmdId77015Action extends BaseSocketAction {

	private static Logger logger = Logger.getLogger(CmdId77015Action.class);
	@Override
	@MethodLevelPointcut
	public void execute() {
		// TODO Auto-generated method stub
		String result = queryBusiCountForNet(getRequest().getDataTrans());
		getResponse().setDataTrans(result);
	}
	/**
	 * 77015命令字格式:
	 * 用户号码~地市~返回格式~短信内容
	 * @param contextStr
	 * @return
	 */
	private String queryBusiCountForNet(String contextStr) {
		String[] datatrans = StringUtils.split(contextStr, SMSProtocol.WORD_SLIT_SYMBOL);
		if(datatrans.length < 4){
			return SMSProtocol.WRONG_FORMAT;
		}
		DBAccessUser user = super.getDbAccessUser();
		try {
			SMSQueryBusiCountForNet bo = (SMSQueryBusiCountForNet) BOFactory.build(
					SMSQueryBusiCountForNetBO.class, user);
			return bo.doQueryBusiCountForNet(datatrans[0],datatrans[1],datatrans[3]);
		}catch(Exception e) {
			return SMSUtils.getErrorResult(e, logger);
		}
	}

}
