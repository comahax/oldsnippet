package com.gmcc.pboss.biz.info.reward.action;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.gmcc.pboss.biz.info.reward.service.FailService;
import com.gmcc.pboss.biz.info.reward.support.RewardFailQueryParameter;
import com.gmcc.pboss.common.action.AbstractAction;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.constant.Constant;
import com.gmcc.pboss.common.dictionary.ConstantsType;
import com.gmcc.pboss.common.dictionary.PageLoction;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceType;
import com.gmcc.pboss.common.support.ColumnSet;
import com.gmcc.pboss.common.support.ExcelColumn;
import com.gmcc.pboss.common.support.QueryAction;
import com.gmcc.pboss.common.support.QueryParameter;

public class RewardVerifiedAction extends AbstractAction {
	RewardFailQueryParameter parameter;

	private FailService service;
	/**
	 * @param parameter the parameter to set
	 */
	public void setParameter(RewardFailQueryParameter parameter) {
		this.parameter = parameter;
	}
	public QueryParameter getParameter() {
		parameter = parameter == null ? new RewardFailQueryParameter() : parameter;
		// 设置页码
		if (this.getPageNo() != null)
			parameter.setNo(getPageNo().intValue());// 设置页码
		if (this.getPageSize() != null)
			parameter.setSize(getPageSize().intValue());// 设置大小
		
		LoginMember member = getMember();
		parameter.setWayid(member.getWayid());
		return parameter;
	}
	/**
	 * Ajax方法
	 */
	public String doQuery() {

		LoginMember member = getMember();
		// 启动查询
		ServiceResult result = getService().transact(member, getParameter(), ServiceType.QUERY);
		// 回写JSON
		this.writeJSONServicePage(result, getsetCols());

		return null;
	}
	/**
	 * 生成页面
	 */
	public String doList() {

		setTitle(PageLoction.RewardVerifiedList);
		return SUCCESS;
	}

	public List getsetCols() {

		List setCols = new ArrayList();
//		setCols.add(new ColumnSet("seq","主键"));
		setCols.add(new ColumnSet("rewardtypeName","酬金类型"));
		setCols.add(new ColumnSet("calcmonth","结算月份"));
		setCols.add(new ColumnSet("opnname","业务名称"));
		setCols.add(new ColumnSet("mobile","业务发生手机号"));
		setCols.add(new ColumnSet("oprtime","业务发生时间"));
		setCols.add(new ColumnSet("remark","失败原因"));
		
		return setCols;
	}

	public Map getRewareType(){
		Map rtn = new LinkedHashMap();
		rtn.put("", "请选择");
		Map consMap = Constant.getConstantsMap(ConstantsType.SOCIETY_REWARDVERIFIED_TPYPE);
		if (consMap!=null) rtn.putAll(consMap);
		return rtn;
		
	}
	
	/**
	 * 导出Excel
	 */
	public String doExcelExport(){
		LoginMember member = getMember();
		QueryParameter param = getParameter();
		param.setAction(QueryAction.ALL);
		// 启动查询
		ServiceResult result = getService().transact(member, param, ServiceType.QUERY);
		if (result.isSuccess() && result.getRetResult() != null && result.getRetResult().getData() != null && result.getRetResult().getData().size() > 0) {
			this.exportExcel(result.getRetResult().getData());
		}		
		return null;
	}
	/**
	 * 返回导出Excel文件的名称
	 */
	protected String getExcelTitle(){
		String type = ((RewardFailQueryParameter)getParameter()).getType();
		return Constant.getConstantName(ConstantsType.SOCIETY_REWARDVERIFIED_TPYPE,type);
	}
	/**
	 * 返回导出excel的列的信息
	 * @return
	 */
	protected List<ExcelColumn> getExcelColumn(){
		List<ExcelColumn> cols = new ArrayList<ExcelColumn>();
		cols.add(new ExcelColumn("rewardtypeName","酬金类型",20));
		cols.add(new ExcelColumn("calcmonth","结算月份",8));
		cols.add(new ExcelColumn("opnname","业务名称",15));
		cols.add(new ExcelColumn("mobile","业务发生手机号",13));
		cols.add(new ExcelColumn("oprtime","业务发生时间",13,"yyyy-MM-dd"));
		cols.add(new ExcelColumn("remark","失败原因",50));		
		return cols;
	}
	
	/**
	 * @return the service
	 */
	public FailService getService() {
		return service;
	}
	/**
	 * @param service the service to set
	 */
	public void setService(FailService service) {
		this.service = service;
	}
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		
	}
}
