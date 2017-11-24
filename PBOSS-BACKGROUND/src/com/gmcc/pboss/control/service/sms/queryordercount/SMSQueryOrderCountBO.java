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
 * ���������޲�ѯ�������ӿ��߼�
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
			// 1.��ȡ��������
			
			// 2.������������
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
				parammap.put("defaultsms", "�𾴵Ŀͻ��������ֻ�������δ�Ǽǣ��޷�Ϊ���ṩ�����������������ϵ��������򲦴�������ߡ�");
				parammap.put("receiveno", mobile);
				sendSms(parammap);
				throw new SMSException("����δ�Ǽ�","2");
			}
			
			// ��ȡ�ɶ�����
			WayVO wayvo = new WayVO();
			Way way = (Way) BOFactory.build(WayBO.class, user);
			if (customer.getWayid() == null || "".equals(customer.getWayid())) {
				throw new Exception("����["+ mobile +"]û����д��������");
			}
			wayvo = way.doFindByPk(customer.getWayid());//wayvo.setWayid("ESWCQS568");
			if (wayvo == null) {
				throw new Exception("����["+ mobile +"]��������["+ customer.getWayid() +"]��ϵͳ�в�����");
			}
			
			Canorderinfo canorderinfo = (Canorderinfo) BOFactory.build(CanorderinfoBO.class,user);
			CanorderinfoVO coiVO = canorderinfo.doNotceOne(user, wayvo);
			WaitreqBO waitreqBO = (WaitreqBO)BOFactory.build(WaitreqBO.class,user);
			waitreqBO.doInsert2(new Short("3"), coiVO.getSmsContent(),
					coiVO.getSendNum(),coiVO.getOfficetel());
			
			// 5.���ض���Ӫҵ��:������ȡ��0����˵��ȡ���ɹ�����
			return doReturnSuccVal().toString();

		} catch (SMSException e) {
			// SMSException ����Ҫ�ع�����
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
		result.setMessage("�ɹ�");
		return result;
	}
	
	//д���Ŵ����ͱ�
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
