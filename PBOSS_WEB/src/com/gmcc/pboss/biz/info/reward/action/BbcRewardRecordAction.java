package com.gmcc.pboss.biz.info.reward.action;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.gmcc.pboss.biz.info.reward.service.RewardService;
import com.gmcc.pboss.biz.info.reward.support.BbcRewardQueryParameter;
import com.gmcc.pboss.biz.info.reward.support.RewardKind;
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

public class BbcRewardRecordAction extends RewardRecordAction {

	private RewardService service;

	private BbcRewardQueryParameter parameter;
	
	//酬金种类：B2M-2,UNPB-3
	private int wayType;
	public int getWayType() {
		return wayType;
	}
	public void setWayType(int wayType) {
		this.wayType = wayType;
	}


	public QueryParameter getParameter() {

		parameter = parameter == null ? new BbcRewardQueryParameter() : parameter;
		// 设置页码
		if (this.getPageNo() != null)
			parameter.setNo(getPageNo().intValue());// 设置页码
		if (this.getPageSize() != null)
			parameter.setSize(getPageSize().intValue());// 设置大小

		LoginMember member = getMember();
		parameter.setWayid(member.getWayid());
		if(wayType==2){
			parameter.setRewardKind(RewardKind.B2M);
		}
		else if(wayType==3){//wayType.equals("UNPB")
			parameter.setRewardKind(RewardKind.UNPB);
		}

		return parameter;
	}


	public List getsetCols() {

		List setCols = new ArrayList();
		// ColumnSet colset = new ColumnSet("id","ID");
		// setCols.add(new ColumnSet("operseq", "业务流水"));
		setCols.add(new ColumnSet("opnid", "业务代码"));
		setCols.add(new ColumnSet("opnname", "业务名称"));
		//setCols.add(new ColumnSet("wayid","way.shortname", "渠道名称",""));
		//setCols.add(new ColumnSet("slv","way.starlevel", "星级",""));
		setCols.add(new ColumnSet("rewardstd", "酬金标准"));
		setCols.add(new ColumnSet("rewardtypeName", "酬金类型"));
		setCols.add(new ColumnSet("rewardmonth", "结算月份"));
		// setCols.add(new ColumnSet("mobile", "业务发生号码"));
//		setCols.add(new ColumnSet("acctype", "计酬方式"));
		setCols.add(new ColumnSet("totalsum", "计算金额"));
//		setCols.add(new ColumnSet("assegrade", "考核系数"));
//		setCols.add(new ColumnSet("paysum", "应发金额"));
		setCols.add(new ColumnSet("runtime", "计算时间"));
//		setCols.add(new ColumnSet("opermobile", "人员手机号码"));
		return setCols;
	}
	/* (non-Javadoc)
	 * @see com.gmcc.pboss.common.action.AbstractAction#doList()
	 */
	public String doList() {
		// TODO Auto-generated method stub
		this.setTitle(PageLoction.BbcRewardRecordList);
		return super.execute();
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
	 * @see com.gmcc.pboss.biz.info.reward.action.RewardRecordAction#doBbcExportExcel()
	 */
	public String doBbcExportExcel(){
		LoginMember member = getMember();
		QueryParameter param = getParameter();
		param.setAction(QueryAction.ALL);
		ServiceResult result = service.transact(member, param, ServiceType.QUERY);
		if(result.isSuccess()){
			exportExcel(result.getRetResult().getData());
		}
		return null;
		
	}
	
	/**
	 * 返回导出Excel文件的名称
	 */
	protected String getExcelTitle(){
	  String flag="";
		if(wayType==2){
		  flag= "B2M酬金明细清单";
		}
		if(wayType==3){
		  flag= "创新联盟酬金明细清单";
		}
		return flag;
	}
	/**
	 * 返回导出excel的列的信息
	 * @return
	 */
	protected List<ExcelColumn> getExcelColumn(){
		List<ExcelColumn> cols = new ArrayList<ExcelColumn>();
		cols.add(new ExcelColumn("opnid","业务代码",10));
		cols.add(new ExcelColumn("opnname", "业务名称",15));
		cols.add(new ExcelColumn("rewardstd", "酬金标准",10));
		cols.add(new ExcelColumn("rewardtypeName", "酬金类型",20));
		cols.add(new ExcelColumn("rewardmonth", "结算月份",10));
		cols.add(new ExcelColumn("totalsum", "计算金额",10));
		cols.add(new ExcelColumn("runtime", "计算时间",10)); 
		return cols;
	}
	
	/**
	 * @return the service
	 */
	public RewardService getService() {
		return service;
	}

	/**
	 * @param service the service to set
	 */
	public void setService(RewardService service) {
		this.service = service;
	}
	public Map getRewareType(){
		Map rtn = new LinkedHashMap();
//		rtn.put("", "请选择");
		Map consMap = Constant.getConstantsMap(ConstantsType.BBC_REWARD_TPYPE);
		if (consMap!=null) rtn.putAll(consMap);
		return rtn;
		
	}
}
