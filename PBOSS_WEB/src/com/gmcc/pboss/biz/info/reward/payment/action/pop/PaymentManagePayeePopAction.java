package com.gmcc.pboss.biz.info.reward.payment.action.pop;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import org.apache.commons.lang3.StringUtils;

import com.gmcc.pboss.biz.info.reward.payment.service.PaymentPayeeService;
import com.gmcc.pboss.biz.info.reward.payment.support.PaymentPayeeQueryParameter;
import com.gmcc.pboss.biz.info.reward.payment.util.CityId;
import com.gmcc.pboss.biz.info.reward.payment.util.Provice;
import com.gmcc.pboss.common.action.AbstractAction;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.dictionary.PageLoction;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceType;
import com.gmcc.pboss.common.support.ColumnSet;
import com.gmcc.pboss.common.support.QueryParameter;

public class PaymentManagePayeePopAction extends AbstractAction {
	private String payee;

	private String cityid;

	private PaymentPayeeService payeeService;

	private Map<String, String> cityMap;

	private PaymentPayeeQueryParameter parameter;

	private String pageTitle = PageLoction.GD_REWARD_PAYMENT_MANAGE;

	public String getPayee() {
		return payee;
	}

	public void setPayee(String payee) {
		this.payee = payee;
	}

	public String getCityid() {
		return cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

	public PaymentPayeeService getPayeeService() {
		return payeeService;
	}

	public void setPayeeService(PaymentPayeeService payeeService) {
		this.payeeService = payeeService;
	}

	public Map<String, String> getCityMap() {
		return cityMap;
	}

	public void setCityMap(Map<String, String> cityMap) {
		this.cityMap = CityId.getCityMap();
	}

	public QueryParameter getParameter() {
		if (parameter == null) {
			parameter = new PaymentPayeeQueryParameter();
		}

		// ����ҳ��
		if (this.getPageNo() != null) {
			parameter.setNo(getPageNo().intValue());
		}
		// ���ô�С
		if (this.getPageSize() != null) {
			parameter.setSize(getPageSize().intValue());
		}

		if (StringUtils.isNotBlank(this.getCityid())) {
			parameter.setCityid(this.getCityid());
		}

		if (StringUtils.isNotBlank(this.getPayee())) {
			parameter.setPayee(this.getPayee());
		}

		return parameter;
	}

	public PaymentManagePayeePopAction() {
		this.setTitle(pageTitle);
		setCityMap(null);
	}

	public String doList() {
		getParameter();
		
		return SUCCESS;
	}

	public String doAjax() {
		LoginMember member = getMember();

		ServiceResult result = isLogin();
		if (result.isSuccess()) {
			result = payeeService
					.transact(member, getParameter(), ServiceType.QUERY);
		}

		// ��дJSON
		this.writeJSONServicePage(result, getsetCols());

		return null;
	}

	/**
	 * ��ñ�ͷ
	 * 
	 * @return
	 */
	public List<ColumnSet> getsetCols() {
		List<ColumnSet> setCols = new ArrayList<ColumnSet>();
		setCols.add(new ColumnSet("cityid", "��������"));
		setCols.add(new ColumnSet("payee", "�տλ"));
		setCols.add(new ColumnSet("wayid", "��������"));

		return setCols;
	}

	/**
	 * ����ҳ����ʾ��Ч��
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
