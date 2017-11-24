package com.gmcc.pboss.control.service.sms;

import org.apache.log4j.Logger;

import com.gmcc.pboss.BgProcess.base.MdbgBase;
import com.gmcc.pboss.business.resource.nosect.NosectDBParam;
import com.gmcc.pboss.business.resource.nosect.NosectVO;
import com.gmcc.pboss.control.resource.nosect.Nosect;
import com.gmcc.pboss.control.resource.nosect.NosectBO;
import com.gmcc.pboss.service.sms.exception.SMSException;
import com.gmcc.pboss.service.sms.result.SMSResult;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * 短信营业厅接口BO帮助类
 * @author zsw
 *
 */
public class ServiceSmsBOHelper {

	/**
	 * 获取号码归属地市
	 * @param mobile
	 * @return
	 * @throws Exception
	 */
	public static String getMobileArea(String mobile,DBAccessUser user) throws Exception {
		
		Nosect nosect = (Nosect)BOFactory.build(NosectBO.class, user);
		NosectDBParam nosectDBParam = new NosectDBParam();
		nosectDBParam.set_snm_beginno(mobile);
		nosectDBParam.set_snl_endno(mobile);
		DataPackage nosectDp = nosect.doQuery(nosectDBParam);
		if(nosectDp.getDatas().size() <= 0){
			throw new SMSException(SMSResult.RET_MESSAGE_FAIL_1,SMSResult.RET_TYPE_FAIL_1);
		}
		NosectVO nosectVO = (NosectVO)nosectDp.getDatas().get(0);
		String cityid = nosectVO.getBossarea();
		return cityid;
	}
	/**
	 * 为指定的Logger对象创建其子Logger对象
	 * @param parentLogName 
	 * @param childLogName	
	 * @return
	 * @throws Exception
	 */
	public static Logger createChildLogger(String parentLogName,String childLogName) throws Exception {
		Logger parentLogger = MdbgBase.getLogger(parentLogName);
		MdbgBase.changeLogFileAttribute(parentLogger);
		return Logger.getLogger(parentLogName+"."+childLogName);
	}
}
