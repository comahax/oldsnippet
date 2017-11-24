package com.gmcc.pboss.biz.info.reward.action;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;

import com.gmcc.pboss.biz.info.reward.service.RewardService;
import com.gmcc.pboss.biz.info.reward.support.RewardQueryParameter;
import com.gmcc.pboss.common.action.AbstractAction;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.dictionary.PageLoction;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceType;
import com.gmcc.pboss.common.support.ColumnSet;
import com.gmcc.pboss.common.support.ExcelColumn;
import com.gmcc.pboss.common.support.QueryAction;
import com.gmcc.pboss.common.support.QueryParameter;

public class RewardRecordAction extends AbstractAction {

	private RewardQueryParameter parameter;

	private RewardService service;

	public QueryParameter getParameter() {

		parameter = parameter == null ? new RewardQueryParameter() : parameter;
		// 设置页码
		if (this.getPageNo() != null)
			parameter.setNo(getPageNo().intValue());// 设置页码
		if (this.getPageSize() != null)
			parameter.setSize(getPageSize().intValue());// 设置大小

		LoginMember member = getMember();
		parameter.setWayid(member.getWayid());

		return parameter;
	}

	public void setParameter(RewardQueryParameter parameter) {
		this.parameter = parameter;
	}

	public RewardService getService() {
		return service;
	}

	public void setService(RewardService service) {
		this.service = service;
	}

	public void prepare() throws Exception {

	}

	public List getsetCols() {

		List setCols = new ArrayList();
		// ColumnSet colset = new ColumnSet("id","ID");
		// setCols.add(new ColumnSet("operseq", "业务流水"));
//		setCols.add(new ColumnSet("opnid", "业务代码"));
		setCols.add(new ColumnSet("opnname", "业务名称"));
		setCols.add(new ColumnSet("mobile", "手机号码"));
		// setCols.add(new ColumnSet("wayid", "渠道标识"));
//		setCols.add(new ColumnSet("slv", "星级"));
		setCols.add(new ColumnSet("rewardtypeName", "酬金类型"));
		setCols.add(new ColumnSet("rewardmonth", "结算月份"));
		// setCols.add(new ColumnSet("mobile", "业务发生号码"));
		setCols.add(new ColumnSet("acctypeName", "计酬方式"));
		setCols.add(new ColumnSet("rewardstd", "酬金标准"));
		setCols.add(new ColumnSet("totalsum", "计算金额"));
		setCols.add(new ColumnSet("assegrade", "考核系数"));
		setCols.add(new ColumnSet("paysum", "应发金额"));
		setCols.add(new ColumnSet("runtime", "计算时间"));
		//setCols.add(new ColumnSet("opermobile", "人员手机号码"));
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

	public String doQuery() {

		LoginMember member = getMember();
		// 启动查询
		ServiceResult result = service.transact(member, getParameter(), ServiceType.QUERY);
		// 回写JSON
		this.writeJSONServicePage(result, getsetCols());

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gmcc.pboss.common.action.AbstractAction#doList()
	 */
	public String doList() {
		// TODO Auto-generated method stub
		this.setTitle(PageLoction.RewardRecordList);
		return super.doList();
	}
	
	public String doExportExcel(){
		LoginMember member = getMember();
		QueryParameter param = getParameter();
		param.setAction(QueryAction.ALL);
		ServiceResult result = service.transact(member, param, ServiceType.QUERY);
		if(result.isSuccess()){
			exportExcel(result.getRetResult().getData());
		}
		return null;
		
	}
	
	protected String[][] beforeWrite() {
//		return new String[][]{
//				new String[]{"aaa","bbb"},
//				new String[]{"ccc","ddd"}
//			};
		return super.beforeWrite();
	}
	@Override
	protected String[][] afterWrite() {
//		return new String[][]{
//				new String[]{"aaa","bbb"},
//				new String[]{"ccc","ddd"}
//			};
		return super.afterWrite();
	}

	@Override
	protected String getExcelTitle() {
		return "酬金明细查询";
	}
	
	protected List<ExcelColumn> getExcelColumn(){
		List<ExcelColumn> cols = new ArrayList<ExcelColumn>();
		cols.add(new ExcelColumn("opnname","业务名称",10));
		cols.add(new ExcelColumn("mobile", "手机号码",10));
		cols.add(new ExcelColumn("rewardtypeName", "酬金类型",10));
		cols.add(new ExcelColumn("rewardmonth", "结算月份",10));
		cols.add(new ExcelColumn("acctypeName", "计酬方式",10));
		cols.add(new ExcelColumn("rewardstd", "酬金标准",10));
		cols.add(new ExcelColumn("totalsum", "计算金额",10));
		cols.add(new ExcelColumn("assegrade", "考核系数",10));
		cols.add(new ExcelColumn("paysum", "应发金额",10));
		cols.add(new ExcelColumn("runtime", "计算时间",10));
		return cols;
	}
}
