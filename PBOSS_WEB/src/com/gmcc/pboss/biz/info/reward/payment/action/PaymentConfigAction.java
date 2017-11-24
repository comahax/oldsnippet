package com.gmcc.pboss.biz.info.reward.payment.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.biz.info.reward.payment.model.ChCwConfig;
import com.gmcc.pboss.biz.info.reward.payment.model.ChCwConfiglog;
import com.gmcc.pboss.biz.info.reward.payment.service.PaymentConfigService;
import com.gmcc.pboss.biz.info.reward.payment.support.PaymentConfigQueryParameter;
import com.gmcc.pboss.common.action.AbstractAction;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.dictionary.PageLoction;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceType;
import com.gmcc.pboss.common.support.ColumnSet;
import com.gmcc.pboss.common.support.QueryParameter;

/**
 * <p>
 * Title: PaymentManageAction
 * </p>
 * <p>
 * Description:【我的酬金】-【酬金一体化】-【酬金一体化配置】
 * </p>
 * <p>
 * Copyright: Copyright (c) 2015
 * </p>
 * <p>
 * </p>
 * 
 * @author caiwr
 * @version 1.0
 */
public class PaymentConfigAction extends AbstractAction {

	private PaymentConfigQueryParameter parameter;
	private PaymentConfigService service;

	private String pageTitle = PageLoction.GD_REWARD_PAYMENT_CONFIG;

	private final String key = "PAYMENT_CHK_SWITCH";

	private String chkswitch;

	// private LoginMember member;

	public void setService(PaymentConfigService service) {
		this.service = service;
	}

	public String getChkswitch() {
		return chkswitch;
	}

	public void setChkswitch(String chkswitch) {
		this.chkswitch = chkswitch;
	}

	public PaymentConfigService getService() {
		return service;
	}

	public QueryParameter getParameter() {
		if (parameter == null) {
			parameter = new PaymentConfigQueryParameter();
		}

		// 设置页码
		if (this.getPageNo() != null) {
			parameter.setNo(getPageNo().intValue());
		}
		// 设置大小
		if (this.getPageSize() != null) {
			parameter.setSize(getPageSize().intValue());
		}

		// if (this.getChkswitch() != null) {
		// parameter.setValue(this.getChkswitch());
		// }

		return parameter;
	}

	public void setParameter(PaymentConfigQueryParameter parameter) {
		this.parameter = parameter;
	}

	public PaymentConfigAction() {
		this.setTitle(pageTitle);
	}

	public HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}

	public String doList() {
		// this.member = getMember();
		//
		// System.out.println(member.getCityid() + "--" + member.getEmployeeid()
		// + "--" + member.getEmployeename());

		// HttpServletRequest request = getRequest();

		// ChCwConfig config = service.getConfigByQuery(key);
		// System.out.println(config.getKey());

		return SUCCESS;
	}

	private boolean saveConfiglog(String key, String value, String explain) {
		boolean flag = false;
		ChCwConfiglog configlog = new ChCwConfiglog();
		configlog.setOprcode(getMember().getOprcode());
		configlog.setOprtype("create");
		configlog.setSuccess("success");
		configlog.setKey(key);
		configlog.setValue(value);
		configlog.setExplain(explain);
		try {
			service.saveConfiglog(configlog);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}

	public String doUpdate() {
		String value = this.getChkswitch();

		ChCwConfig config = service.getConfigByQuery(key);
		config.setValue(value);
		service.updateConfig(config);

		saveConfiglog(key, value, config.getExplain());

		doAjax();

		return SUCCESS;
	}

	public List getsetCols() {
		List setCols = new ArrayList();
		setCols.add(new ColumnSet("key", "参数"));
		setCols.add(new ColumnSet("value", "参数值"));
		setCols.add(new ColumnSet("explain", "说明"));

		return setCols;
	}

	/**
	 * 返回页面显示的效果
	 * 
	 * @return the colSet
	 */
	public String getShowCols() {
		return JSONArray.fromObject(getsetCols()).toString();
	}

	public String doAjax() {
		LoginMember member = getMember();
		((PaymentConfigQueryParameter) getParameter()).setKey(key);
		ServiceResult result = service.transact(member, parameter,
				ServiceType.QUERY);
		// 回写JSON
		this.writeJSONServicePage(result, getsetCols());

		return null;
	}

	public void prepare() throws Exception {
		// TODO Auto-generated method stub
	}
}
