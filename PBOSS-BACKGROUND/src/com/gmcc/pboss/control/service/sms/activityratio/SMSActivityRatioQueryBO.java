package com.gmcc.pboss.control.service.sms.activityratio;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import com.gmcc.pboss.BgProcess.service.sms.SMSProtocol;
import com.gmcc.pboss.business.channel.employee.EmployeeDBParam;
import com.gmcc.pboss.business.channel.employee.EmployeeVO;
import com.gmcc.pboss.business.sales.activerate.ActiverateDBParam;
import com.gmcc.pboss.business.sales.activerate.ActiverateVO;
import com.gmcc.pboss.control.channel.employee.Employee;
import com.gmcc.pboss.control.channel.employee.EmployeeBO;
import com.gmcc.pboss.control.sales.activerate.Activerate;
import com.gmcc.pboss.control.sales.activerate.ActiverateBO;
import com.gmcc.pboss.control.service.sms.ServiceSmsBOHelper;
import com.gmcc.pboss.service.sms.exception.SMSException;
import com.gmcc.pboss.service.sms.result.ActivityRatioResult;
import com.sunrise.jop.common.utils.lang.Code2NameUtils;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.common.utils.logging.LoggingConstant;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class SMSActivityRatioQueryBO extends AbstractControlBean implements SMSActivityRatioQuery{

	private static Logger logger = Logger.getLogger(SMSActivityRatioQueryBO.class);
	
	private String doGetWayid(String mobile) throws Exception{
		//号段表
		logger = ServiceSmsBOHelper.createChildLogger(user.getCityid()
				+ LoggingConstant.SMS_CITY_LOG_ROOT_NAME, this.getClass()
				.getSimpleName());
		//雇员表
		Employee employee = (Employee)BOFactory.build(EmployeeBO.class, user);
		EmployeeDBParam employeeDBParam = new EmployeeDBParam();
		employeeDBParam.set_se_officetel(mobile);
		employeeDBParam.set_ne_empstatus("0");
		DataPackage dp = employee.doQuery(employeeDBParam);
		if(dp.getDatas().size() == 0){
			throw new SMSException("号码未登记",ActivityRatioResult.RET_TYPE_FAIL_1);
		}
		EmployeeVO vo = (EmployeeVO)dp.getDatas().get(0);
		if(vo.getIsnet() == null || !"1".equals(vo.getIsnet().toString())){
			throw new SMSException("非店主号码无权限",ActivityRatioResult.RET_TYPE_FAIL_2);
		}
		return vo.getWayid();
	}
	
	private ActivityRatioResult doReturnSuccVal(String wayid) throws Exception{
		Activerate activerate = (Activerate)BOFactory.build(ActiverateBO.class, user);
		ActiverateDBParam param = new ActiverateDBParam();
		param.set_se_wayid(wayid);
		DataPackage dp = activerate.doQuery(param);
		if(dp.getDatas().size() == 0){
			throw new SMSException("套卡激活率信息不存在",ActivityRatioResult.RET_TYPE_FAIL_3);
		}
		
		List<String> list = new ArrayList<String>();
		NumberFormat nf = NumberFormat.getPercentInstance();
		//true表示AllBrand, false反之
		boolean flag = false;
		
		for(Iterator<ActiverateVO> itt = dp.getDatas().iterator(); itt.hasNext();){
			ActiverateVO vo = itt.next();
			if("AllBrand".equals(vo.getBrand())){
				list.clear();
				list.add(vo.getBrand()+SMSProtocol.WORD_SLIT_SYMBOL+nf.format(vo.getRate()));
				flag = true;
				break;
			}else{
				list.add(Code2NameUtils.code2Name("$FX_SMPBRAND", vo.getBrand(), user.getCityid())+SMSProtocol.WORD_SLIT_SYMBOL+nf.format(vo.getRate()));
			}
		}
		
		ActivityRatioResult result = new ActivityRatioResult();
		if(flag){
			result.setRet(ActivityRatioResult.RET_TYPE_SUCC_000);
		}else{
			result.setRet(ActivityRatioResult.RET_TYPE_SUCC_0);
		}
		result.setMessage("成功");
		result.setDatas(list);
		return result;
	}

	public String doResult(String mobile) throws Exception{
		try{
		// TODO Auto-generated method stub
			return doReturnSuccVal(doGetWayid(mobile)).toString();
		}catch (Exception e) {
			LoggerUtils.error(e, logger);
			throw e;
		}
	}
	
}
