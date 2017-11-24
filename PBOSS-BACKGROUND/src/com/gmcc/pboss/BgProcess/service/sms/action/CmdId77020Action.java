package com.gmcc.pboss.BgProcess.service.sms.action;

import org.apache.log4j.Logger;

import com.gmcc.pboss.BgProcess.service.sms.SMSProtocol;
import com.gmcc.pboss.BgProcess.service.sms.annotation.MethodLevelPointcut;
import com.gmcc.pboss.control.service.sms.invoiceinvite.InvoiceInvite;
import com.gmcc.pboss.control.service.sms.invoiceinvite.InvoiceInviteBO;
import com.gmcc.pboss.service.sms.exception.SMSException;
import com.gmcc.pboss.service.sms.result.DisformFinishenrolResult;
import com.gmcc.pboss.service.sms.result.SMSResult;
import com.gmcc.pboss.service.sms.utils.SMSUtils;
import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;

/**
 * 
 * 新增【发票请领】短厅接口
 * 功能描述：提供渠道向汕头移动发起请领卡类物资的发票功能。
 * @author dengxingxin
 *
 */
public class CmdId77020Action extends BaseSocketAction {
	
	private static Logger logger = Logger.getLogger(CmdId77020Action.class);
	
	@Override
	@MethodLevelPointcut
	public void execute() {
		String result = invite(getRequest().getDataTrans());
		getResponse().setDataTrans(result);

	}
	/**
	 * 77020命令字格式:
	 * 发送报文：用户号码~工号~返回格式
	 * @param contextStr
	 * @return
	 */
	private String invite(String contextStr){
		try {
			String[] datatrans = StringUtils.split(contextStr, SMSProtocol.WORD_SLIT_SYMBOL);
			if(datatrans.length < 3){
				return SMSProtocol.WRONG_FORMAT;
			}
			DBAccessUser user = super.getDbAccessUser();
			if(StringUtils.isEmpty(user.getCityid())) {
				throw new SMSException("尊敬的客户，您的手机号码归属地信息未知，无法为您提供服务。如需帮助，请联系渠道经理或拨打服务热线。",
						SMSResult.RET_TYPE_FAIL_1);
			}
			
			InvoiceInvite bo = (InvoiceInvite) BOFactory.build(
					InvoiceInviteBO.class, user);
			return bo.doInvite(datatrans[0]);
		}catch(SMSException e){
			return SMSUtils.getErrorResult(e, logger);
		}catch(Exception e){
			return SMSUtils.getErrorResult(new SMSException("失败",DisformFinishenrolResult.RET_TYPE_FAIL_111), logger);
		}
	}

}
