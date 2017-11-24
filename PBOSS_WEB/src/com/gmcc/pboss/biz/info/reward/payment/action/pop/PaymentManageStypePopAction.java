package com.gmcc.pboss.biz.info.reward.payment.action.pop;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import net.sf.json.JSONArray;

import com.gmcc.pboss.biz.info.reward.payment.service.PaymentStypeService;
import com.gmcc.pboss.biz.info.reward.payment.support.PaymentStypeQueryParameter;
import com.gmcc.pboss.biz.info.reward.payment.util.Provice;
import com.gmcc.pboss.common.action.AbstractAction;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.dictionary.PageLoction;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceType;
import com.gmcc.pboss.common.support.ColumnSet;
import com.gmcc.pboss.common.support.QueryParameter;

public class PaymentManageStypePopAction extends AbstractAction {
	private String stype;

	private String ltype;

	private String cityid;

	private PaymentStypeService stypeService;

	private Map<String, String> cityMap;

	private PaymentStypeQueryParameter parameter;

	private String pageTitle = PageLoction.GD_REWARD_PAYMENT_MANAGE;

	public String getStype() {
		return stype;
	}

	public void setStype(String stype) {
		this.stype = stype;
	}

	public String getLtype() {
		return ltype;
	}

	public void setLtype(String ltype) {
		this.ltype = ltype;
	}

	public String getCityid() {
		return cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

	public PaymentStypeService getStypeService() {
		return stypeService;
	}

	public void setStypeService(PaymentStypeService stypeService) {
		this.stypeService = stypeService;
	}

	public Map<String, String> getCityMap() {
		return cityMap;
	}

	public void setCityMap(Map<String, String> cityMap) {
		this.cityMap = Provice.getCityMap();
	}

	public QueryParameter getParameter() {
		if (parameter == null) {
			parameter = new PaymentStypeQueryParameter();
		}

		// 设置页码
		if (this.getPageNo() != null) {
			parameter.setNo(getPageNo().intValue());
		}
		// 设置大小
		if (this.getPageSize() != null) {
			parameter.setSize(getPageSize().intValue());
		}

		if (StringUtils.isNotBlank(this.getCityid())) {
			parameter.setCityid(this.getCityid());
		}

		if (StringUtils.isNotBlank(this.getLtype())) {
			parameter.setLtype(this.getLtype());
		}
		if (StringUtils.isNotBlank(this.getStype())) {
			parameter.setStype(this.getStype());
		}

		return parameter;
	}

	public PaymentManageStypePopAction() {
		this.setTitle(pageTitle);
		
		setCityMap(null);
	}

	public String doStypeList() {
		getParameter();
		return SUCCESS;
	}

	public String doStypeAjax() {
		LoginMember member = getMember();

		ServiceResult result = isLogin();
		if (result.isSuccess()) {
			result = stypeService
					.transact(member, getParameter(), ServiceType.QUERY);
		}

		// 回写JSON
		this.writeJSONServicePage(result, getsetCols());

		return null;
	}

	public String doLtypeList() {
		return SUCCESS;
	}

	public String doLtypeAjax() {
		LoginMember member = getMember();

		ServiceResult result = isLogin();
		if (result.isSuccess()) {
			result = stypeService
					.transact(member, getParameter(), ServiceType.QUERY);
		}

		// 回写JSON
		this.writeJSONServicePage(result, getsetCols());

		return null;
	}

	/**
	 * 获得表头
	 * 
	 * @return
	 */
	public List<ColumnSet> getsetCols() {
		List<ColumnSet> setCols = new ArrayList<ColumnSet>();
		setCols.add(new ColumnSet("cityid", "所属地市"));
		setCols.add(new ColumnSet("ltype", "酬金大类"));
		setCols.add(new ColumnSet("stype", "酬金小类"));

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

	public void prepare() throws Exception {
		// TODO Auto-generated method stub

	}
}
