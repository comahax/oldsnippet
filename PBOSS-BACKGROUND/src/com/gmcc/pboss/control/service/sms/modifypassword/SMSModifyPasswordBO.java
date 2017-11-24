package com.gmcc.pboss.control.service.sms.modifypassword;

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
import com.gmcc.pboss.control.channel.waitreq.Waitreq;
import com.gmcc.pboss.control.channel.waitreq.WaitreqBO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.service.sms.ServiceSmsBOHelper;
import com.gmcc.pboss.service.sms.exception.SMSException;
import com.gmcc.pboss.service.sms.result.ModifyPasswordResult;
import com.gmcc.pboss.service.sms.result.ResetPasswordResult;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.common.utils.logging.LoggingConstant;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;

public class SMSModifyPasswordBO extends AbstractControlBean implements SMSModifyPassword {
	private static Logger logger = Logger.getLogger(SMSModifyPasswordBO.class);

	public String doModifyPassword(String mobile,String cityid,String smscontent)
			throws Exception {
		// TODO Auto-generated method stub
		try {
			logger = ServiceSmsBOHelper.createChildLogger(user.getCityid()
					+ LoggingConstant.SMS_CITY_LOG_ROOT_NAME, this.getClass()
					.getSimpleName());
			//1、	验证短信内容是否合法
			String[] content = StringUtils.split(smscontent, SMSProtocol.DATA_SLIT_SYMBOL);
			if(content.length!=3){
				Map<String,String> map = new HashMap<String,String>();
				Waitreq  waitreqBO = (WaitreqBO) BOFactory.build(WaitreqBO.class,user);
				waitreqBO.doInsertForCj("CJ_016", map, mobile);
				return doRecordSmshisAndReturnSuccVal (mobile, cityid, smscontent,"CJ_016").toString();
			}
			//2、	判断手机号码是否存在 
			User newuser = new User();
			newuser.setCityid(cityid);
			newuser.setOpername("PBOSS-BG");
			Employee employee = (Employee)BOFactory.build(EmployeeBO.class, newuser);
			EmployeeDBParam empparam = new EmployeeDBParam();
			empparam.set_se_officetel(mobile);
			empparam.set_ne_empstatus("0");
			empparam.setDataOnly(true);
			EmployeeVO employeevo = new EmployeeVO();
			DataPackage dp = employee.doQuery(empparam);
			if(null!=dp&&dp.getDatas().size()>0){
				employeevo = (EmployeeVO)dp.getDatas().iterator().next();
			}else{
				Map<String,String> map = new HashMap<String,String>();
				Waitreq  waitreqBO = (WaitreqBO) BOFactory.build(WaitreqBO.class,user);
				waitreqBO.doInsertForCj("CJ_025", map, mobile);
				return doRecordSmshisAndReturnSuccVal(mobile,cityid,smscontent,"CJ_025").toString();
			}
			
			//3、	判断号码权限
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
				Waitreq  waitreqBO = (WaitreqBO) BOFactory.build(WaitreqBO.class,user);
				waitreqBO.doInsertForCj("CJ_026", map, mobile);
				return doRecordSmshisAndReturnSuccVal(mobile,cityid,smscontent,"CJ_026").toString();
			}
			
			//4、	验证原密码正确性
			Employeeextend bo = (Employeeextend)BOFactory.build(EmployeeextendBO.class, user);
			EmployeeextendVO evo = bo.doFindByPk(employeevo.getEmployeeid());
			if(null==evo || !content[1].equals(evo.getPassword())){
				Map<String,String> map = new HashMap<String,String>();
				Waitreq  waitreqBO = (WaitreqBO) BOFactory.build(WaitreqBO.class,user);
				waitreqBO.doInsertForCj("CJ_028", map, mobile);
				return doRecordSmshisAndReturnSuccVal(mobile,cityid,smscontent,"CJ_028").toString();
			}
			//5、	判断新密码规则正确性
			if(content[2].length()>64 || StringUtils.isBlank(content[2])){
				Map<String,String> map = new HashMap<String,String>();
				Waitreq  waitreqBO = (WaitreqBO) BOFactory.build(WaitreqBO.class,user);
				waitreqBO.doInsertForCj("CJ_029", map, mobile);
				return doRecordSmshisAndReturnSuccVal(mobile,cityid,smscontent,"CJ_029").toString();
			}
			
			// 6、	修改密码
			evo.setPassword(content[2]);
			bo.doUpdate(evo);
			Map<String,String> map = new HashMap<String,String>();
			Waitreq  waitreqBO = (WaitreqBO) BOFactory.build(WaitreqBO.class,user);
			waitreqBO.doInsertForCj("CJ_030", map, mobile);
			//  7、	记录上行短信日志历史，返回短信营业厅
			return doRecordSmshisAndReturnSuccVal(mobile,cityid,smscontent,"CJ_030").toString();
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
	 * 7、	记录上行短信日志历史，返回短信营业厅
	 * 
	 * @throws Exception
	 */
	private ModifyPasswordResult doRecordSmshisAndReturnSuccVal (String mobile,String cityid,String smscontent,String templateid)
			throws Exception {
		Smsloghis smsloghis = (Smsloghis)BOFactory.build(SmsloghisBO.class, user);
		SmsloghisVO smsvo = new SmsloghisVO();
		smsvo.setMobile(mobile);
		smsvo.setCityid(cityid);
		smsvo.setSmsno("10086111");
		smsvo.setCommandid("77012");
		smsvo.setSmsseq("-1");
		smsvo.setScontent(smscontent);
		smsvo.setSstate(new Short("0"));
		smsvo.setOprtime(new Date());
		smsvo.setRemark(templateid);
		smsloghis.doCreate(smsvo);
		
		ModifyPasswordResult result = new ModifyPasswordResult();
		result.setRet(ResetPasswordResult.RET_TYPE_SUCC_0);
		result.setMessage("成功");
		return result;
	}
}
