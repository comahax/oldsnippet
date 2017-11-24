package com.gmcc.pboss.BgProcess.service.sms.action;

import org.apache.log4j.Logger;

import com.gmcc.pboss.BgProcess.service.sms.SMSProtocol;
import com.gmcc.pboss.BgProcess.service.sms.annotation.MethodLevelPointcut;
import com.gmcc.pboss.control.service.sms.bondconfirm.BondConfirm;
import com.gmcc.pboss.control.service.sms.bondconfirm.BondConfirmBO;
import com.gmcc.pboss.service.sms.exception.SMSException;
import com.gmcc.pboss.service.sms.result.DisformFinishenrolResult;
import com.gmcc.pboss.service.sms.result.SMSResult;
import com.gmcc.pboss.service.sms.utils.SMSUtils;
import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;

/**
 * 
 * 新增【保证金上缴申请单确认】短厅接口逻辑
 * 功能描述：配送商通过回复短信确认结果信息
 * @author dengxingxin
 *
 */
public class CmdId77019Action extends BaseSocketAction {
	
	private static Logger logger = Logger.getLogger(CmdId77019Action.class);
	
	@Override
	@MethodLevelPointcut
	public void execute() {
		String result = bondConfirm(getRequest().getDataTrans());
		getResponse().setDataTrans(result);

	}
	/**
	 * 77019命令字格式:
	 * 发送报文：用户号码~工号~返回格式~短厅内容
	 * 短厅内容：SJ+申请单号+#+确认结果，示例，SJ1234#Y
	 * @param contextStr
	 * @return
	 */
	private String bondConfirm(String contextStr){
		try {
			String[] datatrans = StringUtils.split(contextStr, SMSProtocol.WORD_SLIT_SYMBOL);
			if(datatrans.length < 4){
				return SMSProtocol.WRONG_FORMAT;
			}
			DBAccessUser user = super.getDbAccessUser();
			if(StringUtils.isEmpty(user.getCityid())) {
				throw new SMSException("尊敬的客户，您的手机号码归属地信息未知，无法为您提供服务。如需帮助，请联系渠道经理或拨打服务热线。",
						SMSResult.RET_TYPE_FAIL_1);
			}
			
			BondConfirm bo = (BondConfirm) BOFactory.build(
					BondConfirmBO.class, user);
			return bo.doConfirm(contextStr);
		}catch(SMSException e){
			return SMSUtils.getErrorResult(e, logger);
		}catch(Exception e){
			return SMSUtils.getErrorResult(new SMSException("失败",DisformFinishenrolResult.RET_TYPE_FAIL_111), logger);
		}
	}

}
