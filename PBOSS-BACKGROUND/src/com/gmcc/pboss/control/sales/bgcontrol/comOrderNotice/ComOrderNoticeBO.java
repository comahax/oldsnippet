package com.gmcc.pboss.control.sales.bgcontrol.comOrderNotice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.gmcc.pboss.business.base.smstmpl.SmstmplDBParam;
import com.gmcc.pboss.business.base.smstmpl.SmstmplVO;
import com.gmcc.pboss.business.channel.employee.EmployeeDBParam;
import com.gmcc.pboss.business.channel.employee.EmployeeVO;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.sales.wayassistant.WayassistantDBParam;
import com.gmcc.pboss.business.sales.wayassistant.WayassistantVO;
import com.gmcc.pboss.control.base.smstmpl.Smstmpl;
import com.gmcc.pboss.control.base.smstmpl.SmstmplBO;
import com.gmcc.pboss.control.channel.employee.Employee;
import com.gmcc.pboss.control.channel.employee.EmployeeBO;
import com.gmcc.pboss.control.channel.waitreq.Waitreq;
import com.gmcc.pboss.control.channel.waitreq.WaitreqBO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.sales.comorder.Comorder;
import com.gmcc.pboss.control.sales.comorder.ComorderBO;
import com.gmcc.pboss.control.sales.comorder.ComorderCheckBO;
import com.gmcc.pboss.control.sales.wayassistant.Wayassistant;
import com.gmcc.pboss.control.sales.wayassistant.WayassistantBO;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.exception.business.SaleException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class ComOrderNoticeBO extends AbstractControlBean implements ComOrderNotice {
	
	private Logger log = Logger.getLogger(ComOrderNoticeBO.class);
	
	public void doProcess() throws Exception {
		SmstmplVO smstemlVO = doGetSmsTemplete();
		Wayassistant wayassistantbo = (Wayassistant) BOFactory.build(
				WayassistantBO.class, user);
		WayassistantDBParam wsparam = new WayassistantDBParam();
		wsparam.set_ne_canorder("1");
		wsparam.set_pagesize("0");
		DataPackage dp = wayassistantbo.doQuery(wsparam);
		if (null != dp && null != dp.getDatas() && dp.getDatas().size() > 0) {
			Comorder comorder = (Comorder) BOFactory.build(ComorderBO.class,
					user);
			ComorderCheckBO checkbo = (ComorderCheckBO) BOFactory.build(
					ComorderCheckBO.class, user);
			Way waybo = (Way) BOFactory.build(WayBO.class, user);

			List<WayassistantVO> list = dp.getDatas();
			for (WayassistantVO wsvo : list) {
				String wayid = wsvo.getWayid();
				WayVO wayvo = waybo.doFindByPk(wayid);
				try {
					comorder.checkMonthBookTimes(wayid);
				} catch (SaleException ex) {
					log.info("渠道"+wayid+"月订购次数检查不通过");
					continue;
				} catch (Exception ex) {
					LoggerUtils.error(ex, log);
					continue;
				}
				try {
					checkbo.checkLimitTime(wayvo);
				} catch (SaleException ex) {
					if (!"SALE-104003".equals(ex.getErrorCode())){
						log.info("渠道"+wayid+"订购时段检查不通过");
						continue;
					}
				} catch (Exception ex) {
					LoggerUtils.error(ex, log);
					continue;
				}
				
				String userName = "客户";
				String officetel = "";
				Employee employeeBO = (EmployeeBO) BOFactory.build(EmployeeBO.class,user);
				EmployeeDBParam employeeParam = new EmployeeDBParam();
				employeeParam.setDataOnly(true);
				employeeParam.setQueryAll(true);
				employeeParam.set_se_wayid(wayid);
				employeeParam.set_ne_isnet("1");
				employeeParam.set_ne_empstatus("0");
				DataPackage edp = employeeBO.doQuery(employeeParam);
				if(null!= edp && edp.getDatas().size()>0){
					EmployeeVO employeevo = (EmployeeVO)edp.getDatas().get(0);
					if (StringUtils.isNotBlank(employeevo.getEmployeename())){
						userName = employeevo.getEmployeename();
					}
					if(StringUtils.isBlank(employeevo.getOfficetel()) || employeevo.getOfficetel().length()!=11 ){
						log.info("渠道"+wayid+"在人员表中对应的店主无公务机号码或公务机号码长度错误.");
						continue;
					}
					officetel = employeevo.getOfficetel();
				}
				if(StringUtils.isBlank(officetel)){
					log.info("渠道"+wayid+"无法取得店主的公务机号码.");
					continue;
				}
				try {
					Waitreq  waitreqBO = (WaitreqBO) BOFactory.build(WaitreqBO.class,user,BOFactory.PROPAGATION_REQUIRES_NEW);
					Map<String,String> map = new HashMap<String,String>();
					map.put("CUSTNAME", userName);
					Smstmpl smstmplBO = (SmstmplBO)BOFactory.build(SmstmplBO.class,user);
					String smsContent = smstmplBO.doGenSMS("FX_ORDER_NOTICE", map);
					waitreqBO.doInsert(new Short("3"), smsContent, officetel);
				} catch (Exception e) {
					LoggerUtils.error(e, log);
				}
				
			}
		}

	}
	
	/*
	 * 1、	获取短信模板
	 * 根据标识（FX_ORDER_NOTICE）、生效状态（1）查询短信模板表（CH_SMS_SMSTMPL），获取模板内容，如果无数据或内容为空，则提示并退出
	 */
	public SmstmplVO doGetSmsTemplete() throws Exception {
		Smstmpl smstmplBO = (SmstmplBO) BOFactory.build(SmstmplBO.class, user);
		SmstmplDBParam param = new SmstmplDBParam();
		param.setDataOnly(true);
		param.set_se_sid("FX_ORDER_NOTICE");
		param.set_se_sstate("1");
		DataPackage dp = smstmplBO.doQuery(param);
		if (null == dp
				|| null == dp.getDatas()
				|| dp.getDatas().size() < 1
				|| ((SmstmplVO) dp.getDatas().get(0)).getScontent().trim()
						.length() == 0)
			throw new Exception("无符合条件的模板数据");
		return (SmstmplVO) dp.getDatas().get(0);
	}
	
	
}
