package com.gmcc.pboss.biz.info.reward.payment.action.pop;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import org.apache.commons.lang3.StringUtils;

import com.gmcc.pboss.biz.info.reward.payment.service.PaymentWayService;
import com.gmcc.pboss.biz.info.reward.payment.support.PaymentWayQueryParameter;
import com.gmcc.pboss.biz.info.reward.payment.util.Provice;
import com.gmcc.pboss.common.action.AbstractAction;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.dictionary.PageLoction;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceType;
import com.gmcc.pboss.common.support.ColumnSet;
import com.gmcc.pboss.common.support.QueryParameter;

public class PaymentManageWayPopAction extends AbstractAction {

	private String wayid;
	
	private String wayname;

	private String cityid;

	private PaymentWayService wayService;

	private Map<String, String> cityMap;

	private PaymentWayQueryParameter parameter;

	private String pageTitle = PageLoction.GD_REWARD_PAYMENT_MANAGE;

	public String getWayid() {
		return wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

	public String getWayname() {
		return wayname;
	}

	public void setWayname(String wayname) {
		this.wayname = wayname;
	}

	public PaymentWayService getWayService() {
		return wayService;
	}

	public void setWayService(PaymentWayService wayService) {
		this.wayService = wayService;
	}

	public String getCityid() {
		return cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

	public Map<String, String> getCityMap() {
		return cityMap;
	}

	public void setCityMap(Map<String, String> cityMap) {
		this.cityMap = Provice.getCityMap();
	}

	public QueryParameter getParameter() {
		if (parameter == null) {
			parameter = new PaymentWayQueryParameter();
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

		if (StringUtils.isNotBlank(this.getWayid())) {
			parameter.setWayid(this.getWayid());
		}
		
		if (StringUtils.isNotBlank(this.getWayname())) {
			parameter.setWayname(this.getWayname());
		}

		return parameter;
	}

	public PaymentManageWayPopAction() {
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
			result = wayService
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
		setCols.add(new ColumnSet("wayid", "��������"));
		setCols.add(new ColumnSet("wayname", "��������"));

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
