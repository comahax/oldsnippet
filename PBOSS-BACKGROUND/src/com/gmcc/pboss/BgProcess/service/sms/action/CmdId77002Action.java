package com.gmcc.pboss.BgProcess.service.sms.action;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.gmcc.pboss.BgProcess.service.sms.SMSProtocol;
import com.gmcc.pboss.BgProcess.service.sms.annotation.MethodLevelPointcut;
import com.gmcc.pboss.control.service.sms.comorder.SMSComOrderCommit;
import com.gmcc.pboss.control.service.sms.comorder.SMSComOrderCommitBO;
import com.gmcc.pboss.service.sms.exception.SMSException;
import com.gmcc.pboss.service.sms.result.SMSResult;
import com.gmcc.pboss.service.sms.utils.SMSUtils;
import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;


/**
 * ����Ʒ����������Ӫҵ���ӿ��߼�
 * @author Canigar
 * @since 2009-12-28
 */
public class CmdId77002Action extends BaseSocketAction {

	private static Logger logger = Logger.getLogger(CmdId77002Action.class);
	
	@MethodLevelPointcut
	public void execute() {
		String result = comOrder(getRequest().getDataTrans());
		getResponse().setDataTrans(result);
	}
	
	/**
	 * 77002�����ָ�ʽ:�û�����~����~���ظ�ʽ~��Ʒ����1^����1#��Ʒ����2^����2#����#��Ʒ����N^����N#;
	 * @param contextStr
	 * @return
	 */
	private String comOrder(String contextStr){
		String[] datatrans = StringUtils.split(contextStr, SMSProtocol.WORD_SLIT_SYMBOL);
		if(datatrans.length < 4){
			return SMSProtocol.WRONG_FORMAT;
		}
		DBAccessUser user = super.getDbAccessUser();
		if(StringUtils.isEmpty(user.getCityid())) {
			throw new SMSException(SMSResult.RET_MESSAGE_FAIL_1,
					SMSResult.RET_TYPE_FAIL_1);
		}
		
		List<String> dataList = Arrays.asList(StringUtils.split(datatrans[3], SMSProtocol.DATA_SLIT_SYMBOL));
 		try{
			SMSComOrderCommit comOrderCommit = (SMSComOrderCommit)BOFactory.build(SMSComOrderCommitBO.class, user);
			return comOrderCommit.doResult(datatrans[0],dataList).toString();
		}catch (Exception e) {
			return SMSUtils.getErrorResult(e, logger);
		}
	}
}
