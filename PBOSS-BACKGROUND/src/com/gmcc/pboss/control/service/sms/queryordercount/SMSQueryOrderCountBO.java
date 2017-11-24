package com.gmcc.pboss.control.service.sms.queryordercount;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.gmcc.pboss.BgProcess.service.sms.SMSProtocol;
import com.gmcc.pboss.business.channel.employee.EmployeeDBParam;
import com.gmcc.pboss.business.channel.employee.EmployeeVO;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.sales.canorderinfo.CanorderinfoVO;
import com.gmcc.pboss.control.base.smstmpl.Smstmpl;
import com.gmcc.pboss.control.base.smstmpl.SmstmplBO;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.channel.employee.Employee;
import com.gmcc.pboss.control.channel.employee.EmployeeBO;
import com.gmcc.pboss.control.channel.waitreq.Waitreq;
import com.gmcc.pboss.control.channel.waitreq.WaitreqBO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.sales.canorderinfo.Canorderinfo;
import com.gmcc.pboss.control.sales.canorderinfo.CanorderinfoBO;
import com.gmcc.pboss.control.service.sms.ServiceSmsBOHelper;
import com.gmcc.pboss.service.sms.exception.SMSException;
import com.gmcc.pboss.service.sms.result.PassAuditResult;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.common.utils.logging.LoggingConstant;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * 【订购上限查询】短厅接口逻辑
 * @author yangdaren
 *
 */
public class SMSQueryOrderCountBO extends AbstractControlBean implements SMSQueryOrderCount {

	private static Logger logger = Logger.getLogger(SMSQueryOrderCountBO.class);
	
	public String doQueryOrderCount(String mobile) throws Exception {
		try {
			logger = ServiceSmsBOHelper.createChildLogger(user.getCityid()
					+ LoggingConstant.SMS_CITY_LOG_ROOT_NAME, this.getClass()
					.getSimpleName());
			// 1.获取归属地市
			
			// 2.检查合作商资料
			Employee employee = (Employee) BOFactory.build(EmployeeBO.class, user);
			EmployeeVO customer = new EmployeeVO();
			EmployeeDBParam params = new EmployeeDBParam();
			params.set_ne_empstatus("0");
			params.set_se_officetel(mobile);
			DataPackage dp = employee.doQuery(params);
			List list = dp.getDatas();
			if (list.size() > 0) {
				customer = (EmployeeVO) list.get(0);
			} else {
				Map<String,String> map = new HashMap<String,String>();
				Map<String,Object> parammap = new HashMap<String,Object>();
				parammap.put("sid", "FX_ORDER_NUMBERUNREG");
				parammap.put("keyvaluemap", map);
				parammap.put("defaultsms", "尊敬的客户，您的手机号码尚未登记，无法为您提供服务。如需帮助，请联系渠道经理或拨打服务热线。");
				parammap.put("receiveno", mobile);
				sendSms(parammap);
				throw new SMSException("号码未登记","2");
			}
			
			// 获取可订购量
			WayVO wayvo = new WayVO();
			Way way = (Way) BOFactory.build(WayBO.class, user);
			if (customer.getWayid() == null || "".equals(customer.getWayid())) {
				throw new Exception("号码["+ mobile +"]没有填写所属渠道");
			}
			wayvo = way.doFindByPk(customer.getWayid());//wayvo.setWayid("ESWCQS568");
			if (wayvo == null) {
				throw new Exception("号码["+ mobile +"]所属渠道["+ customer.getWayid() +"]在系统中不存在");
			}
			
			Canorderinfo canorderinfo = (Canorderinfo) BOFactory.build(CanorderinfoBO.class,user);
			CanorderinfoVO coiVO = canorderinfo.doNotceOne(user, wayvo);
			WaitreqBO waitreqBO = (WaitreqBO)BOFactory.build(WaitreqBO.class,user);
			waitreqBO.doInsert2(new Short("3"), coiVO.getSmsContent(),
					coiVO.getSendNum(),coiVO.getOfficetel());
			
			// 5.返回短信营业厅:返回码取“0”，说明取“成功”。
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
			
	private PassAuditResult doReturnSuccVal()
		throws Exception {
		PassAuditResult result = new PassAuditResult();
		result.setRet(PassAuditResult.RET_TYPE_SUCC_0);
		result.setMessage("成功");
		return result;
	}
	
	//写短信待发送表
	private void sendSms(Map<String,Object> parammap){
		try{
			String sid = (String)parammap.get("sid");
			Map<String,String> keyvaluemap = (Map<String,String>)(parammap.get("keyvaluemap"));
			String defaultsms = (String)parammap.get("defaultsms");
			String receiveno = (String)parammap.get("receiveno");
			Sysparam SysparamBO = (SysparamBO) BOFactory.build(SysparamBO.class,user);
			String sendno = SysparamBO.doFindByID("42", "pboss_fx");
			if(StringUtils.isBlank(sendno))
				sendno = "10086116";
			Smstmpl smstmplBO = (SmstmplBO)BOFactory.build(SmstmplBO.class,user);
			String smsContent = smstmplBO.doGenSMS(sid, keyvaluemap);
			if( null == smsContent || "".equals(smsContent.trim()))
				smsContent = defaultsms;
			Waitreq  waitreqBO = (WaitreqBO) BOFactory.build(WaitreqBO.class,user);
			waitreqBO.doInsert2(new Short("3"), smsContent, sendno,receiveno);
		}catch (Exception e) {
			e.printStackTrace();
			LoggerUtils.error(e, logger);
		}
	}
	
}
