package com.gmcc.pboss.control.service.sms.resetpassword;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.gmcc.pboss.BgProcess.service.sms.SMSProtocol;
import com.gmcc.pboss.business.channel.employee.EmployeeDBParam;
import com.gmcc.pboss.business.channel.employee.EmployeeVO;
import com.gmcc.pboss.business.channel.employeeextend.EmployeeextendVO;
import com.gmcc.pboss.business.channel.smsloghis.SmsloghisVO;
import com.gmcc.pboss.business.channel.way.WayDBParam;
import com.gmcc.pboss.control.channel.employee.Employee;
import com.gmcc.pboss.control.channel.employee.EmployeeBO;
import com.gmcc.pboss.control.channel.employeeextend.Employeeextend;
import com.gmcc.pboss.control.channel.employeeextend.EmployeeextendBO;
import com.gmcc.pboss.control.channel.smsloghis.Smsloghis;
import com.gmcc.pboss.control.channel.smsloghis.SmsloghisBO;
import com.gmcc.pboss.control.channel.waitchange.Waitchange;
import com.gmcc.pboss.control.channel.waitchange.WaitchangeBO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.service.sms.exception.SMSException;
import com.gmcc.pboss.service.sms.result.ResetPasswordResult;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;

public class SMSResetPasswordPrBO extends AbstractControlBean implements SMSResetPasswordPr {
	private static Logger logger = Logger.getLogger(SMSResetPasswordPrBO.class);

	public String doResetPassword(String mobile,String cityid)
			throws Exception {
		// TODO Auto-generated method stub
		try {
			/*logger = ServiceSmsBOHelper.createChildLogger(user.getCityid()
					+ LoggingConstant.SMS_CITY_LOG_ROOT_NAME, this.getClass()
					.getSimpleName());*/
			//1、	判断手机号码是否存在
			logger.info("=============1、	判断手机号码是否存在===开始=======");
			User newuser = new User();
			newuser.setCityid(cityid);
			newuser.setOpername("PBOSS-BG");
			Employee employee = (Employee)BOFactory.build(EmployeeBO.class, newuser);
			EmployeeDBParam empparam = new EmployeeDBParam();
			empparam.set_se_officetel(mobile);
			empparam.set_ne_empstatus("0");
			empparam.setDataOnly(true);
			ArrayList<Short> _nin_isnet = new ArrayList<Short>();
			_nin_isnet.add(Short.parseShort("0"));
			_nin_isnet.add(Short.parseShort("1"));
			_nin_isnet.add(Short.parseShort("4"));
			empparam.set_nin_isnet(_nin_isnet);
			EmployeeVO employeevo = new EmployeeVO();
			DataPackage dp = employee.doQuery(empparam);
			if(null!=dp&&dp.getDatas().size()>0){
				employeevo = (EmployeeVO)dp.getDatas().iterator().next();
			}else{
				Map<String,String> map = new HashMap<String,String>();
				Waitchange  waitchangeBO = (WaitchangeBO) BOFactory.build(WaitchangeBO.class,user);
				waitchangeBO.doInsertForCj("CJ_025", map, mobile);
				return doRecordSmshisAndReturnSuccVal(mobile,cityid,"CJ_025").toString();
			}
			
			//2、	判断号码权限
			logger.info("=============2、	判断号码权限===开始=======");
			Way way = (Way)BOFactory.build(WayBO.class,user);
			WayDBParam wayparam = new WayDBParam();
			wayparam.set_se_wayid(employeevo.getWayid());
			if(employeevo.getIsnet()!=4){
				wayparam.set_se_waytype("AG");
			}
			wayparam.set_ne_waystate("1");
			DataPackage dp2 = way.doQuery(wayparam);
			if(null==dp2 || dp2.getDatas().size()==0){
				Map<String,String> map = new HashMap<String,String>();
				Waitchange  waitchangeBO = (WaitchangeBO) BOFactory.build(WaitchangeBO.class,user);
				waitchangeBO.doInsertForCj("CJ_026", map, mobile);
				return doRecordSmshisAndReturnSuccVal(mobile,cityid,"CJ_026").toString();
			}
						
			// 3、	重置密码
			logger.info("============3、	重置密码===开始=======");
			String randompassword = doReset(employeevo, mobile);
			
			// 4、 记录上行短信日志历史，返回短信营业厅
			logger.info("=============4、 记录上行短信日志历史，返回短信营业厅===开始=======");
			return doRecordSmshisAndReturnSuccVal(mobile,cityid,"CJ_027").toString();
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
	 * 3、	重置密码
	 * 
	 * @throws Exception
	 */
	public String doReset(EmployeeVO employeevo,String mobile) throws Exception {
		String randompassword = String.valueOf((int)((Math.random()*9+1)*100000));//随机六位数字
		Employeeextend bo = (Employeeextend)BOFactory.build(EmployeeextendBO.class, user);
		EmployeeextendVO evo = new EmployeeextendVO();
		evo = bo.doFindByPk(employeevo.getEmployeeid());
		if(null==evo){
			evo = new EmployeeextendVO();
			evo.setEmployeeid(employeevo.getEmployeeid());
			evo.setPassword(randompassword);
			bo.doCreate(evo);
		}else{
			evo.setPassword(randompassword);
			bo.doUpdate(evo);
		}
		Map<String,String> map = new HashMap<String,String>();
		map.put("PASSWORD", randompassword);
		Waitchange  waitchangeBO = (WaitchangeBO) BOFactory.build(WaitchangeBO.class,user);
		waitchangeBO.doInsertForCj("CJ_027", map, mobile);
		return randompassword;
	}
	
	/**
	 * 4、	记录上行短信日志历史，返回短信营业厅
	 * 
	 * @throws Exception
	 */
	public ResetPasswordResult doRecordSmshisAndReturnSuccVal (String mobile,String cityid,String templateid)
			throws Exception {
		Smsloghis smsloghis = (Smsloghis)BOFactory.build(SmsloghisBO.class, user);
		SmsloghisVO smsvo = new SmsloghisVO();
		smsvo.setMobile(mobile);
		smsvo.setCityid(cityid);
		smsvo.setSmsno("10086111");
		smsvo.setCommandid("77011");
		smsvo.setSmsseq("-1");
		smsvo.setScontent("CZMM");
		smsvo.setSstate(new Short("0"));
		smsvo.setOprtime(new Date());
		smsvo.setRemark(templateid);
		smsvo.setSmstype(new Short("1"));
		smsloghis.doCreate(smsvo);
		
		ResetPasswordResult result = new ResetPasswordResult();
		result.setRet(ResetPasswordResult.RET_TYPE_SUCC_0);
		result.setMessage("成功");
		return result;
	}
	
}
