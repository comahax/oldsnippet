package com.gmcc.pboss.control.service.sms.registerSmsbusi;

import java.util.Date;

import org.apache.log4j.Logger;

import com.gmcc.pboss.BgProcess.service.sms.SMSProtocol;
import com.gmcc.pboss.business.channel.smslog.SmslogVO;
import com.gmcc.pboss.control.channel.smslog.Smslog;
import com.gmcc.pboss.control.channel.smslog.SmslogBO;
import com.gmcc.pboss.control.service.sms.ServiceSmsBOHelper;
import com.gmcc.pboss.service.sms.exception.SMSException;
import com.gmcc.pboss.service.sms.result.RegisterSmsbusiResult;
import com.gmcc.pboss.service.sms.result.ResetPasswordResult;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.common.utils.logging.LoggingConstant;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;

public class SMSRegisterSmsbusiBO extends AbstractControlBean implements SMSRegisterSmsbusi {
	private static Logger logger = Logger.getLogger(SMSRegisterSmsbusiBO.class);

	public String doRegisterSmsbusi(String mobile,String cityid,String smscontent)
			throws Exception {
		// TODO Auto-generated method stub
		try {
			logger = ServiceSmsBOHelper.createChildLogger(user.getCityid()
					+ LoggingConstant.SMS_CITY_LOG_ROOT_NAME, this.getClass()
					.getSimpleName());
			Smslog smslog = (Smslog)BOFactory.build(SmslogBO.class, user);
			SmslogVO smslogvo = new SmslogVO();
			smslogvo.setMobile(mobile);
			smslogvo.setCityid(cityid);
			smslogvo.setSmsno("10086111");
			smslogvo.setCommandid("77013");
			smslogvo.setSmsseq("-1");
			smslogvo.setScontent(smscontent);
			smslogvo.setOprtime(new Date());
			smslog.doCreate(smslogvo);
			//返回短信营业厅
			return doReturnSuccVal().toString();
		} catch (SMSException e) {
			// SMSException 不需要回滚事务
			logger.info(e.getMessage());
			return ((SMSException) e).getErrCode()+ SMSProtocol.WORD_SLIT_SYMBOL+ ((SMSException) e).getMessage()+ SMSProtocol.WORD_END_SYMBOL;
		} catch (Exception e) {
			LoggerUtils.error(e, logger);
			throw e;
		}

	}
	
	/**
	 * 返回短信营业厅
	 * 
	 * @throws Exception
	 */
	private RegisterSmsbusiResult doReturnSuccVal ()
			throws Exception {
		RegisterSmsbusiResult result = new RegisterSmsbusiResult();
		result.setRet(ResetPasswordResult.RET_TYPE_SUCC_0);
		result.setMessage("成功");
		return result;
	}
}
