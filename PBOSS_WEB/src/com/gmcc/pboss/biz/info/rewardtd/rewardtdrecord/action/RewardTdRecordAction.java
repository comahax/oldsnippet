package com.gmcc.pboss.biz.info.rewardtd.rewardtdrecord.action;

import java.util.ArrayList;
import java.util.List;
import net.sf.json.JSONArray;
import com.gmcc.pboss.biz.info.rewardtd.rewardtdrecord.service.RewardTdRecordService;
import com.gmcc.pboss.biz.info.rewardtd.rewardtdrecord.support.RewardTdRecordQueryParameter;
import com.gmcc.pboss.common.action.AbstractAction;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.dictionary.PageLoction;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceType;
import com.gmcc.pboss.common.support.ColumnSet;
import com.gmcc.pboss.common.support.ExcelColumn;
import com.gmcc.pboss.common.support.QueryAction;
import com.gmcc.pboss.common.support.QueryParameter;

public class RewardTdRecordAction extends AbstractAction {

	private QueryParameter parameter;
	private List retlist;
	private RewardTdRecordService rewardTdRecordService;

	public QueryParameter getParameter() {
		// TODO Auto-generated method stub
		parameter = parameter == null ? new RewardTdRecordQueryParameter()
				: parameter;
		// 设置页码，仅在明细查询时使用，统计汇总不使用
		if (this.getPageNo() != null)
			parameter.setNo(getPageNo().intValue());// 设置页码
		if (this.getPageSize() != null)
			parameter.setSize(getPageSize().intValue());// 设置大小
		LoginMember logMem = this.getMember();
		if (logMem.getIsnet() == 1) {// 店主只允许查询自身酬金信息
			((RewardTdRecordQueryParameter) parameter).setWayid(logMem
					.getWayid());
		}

		return parameter;
	}

	public void prepare() throws Exception {
		// TODO Auto-generated method stub 
	}

	 

	public String doStat() {
		 this.setTitle(PageLoction.REWARDTD_SUC_DATA);  
		return SUCCESS;
		 
	}
 

       //动态获取下列表中数据	
	public String doAjax() {
		ServiceResult result = isLogin();
		if (result.isSuccess())
			result = this.rewardTdRecordService.transact(getMember(),
					getParameter(), ServiceType.OTHER);
		this.writeJSONServicePage(result, getsetCols());
		return null;
	}

	/**
	 * 获得表头 （表格标题）
	 * 
	 * @return
	 */
	public List<ColumnSet> getsetCols() {
		List<ColumnSet> setCols = new ArrayList<ColumnSet>();
		setCols.add(new ColumnSet("name", "业务名称"));
		setCols.add(new ColumnSet("rewardtype", "酬金类型"));
		setCols.add(new ColumnSet("oprtime", "业务发生时间"));
		setCols.add(new ColumnSet("rewardmonth", "结算月份"));
		setCols.add(new ColumnSet("paysum", "应发金额"));
		return setCols;
	}
	
	/**
	 * 终端计酬成功数据汇总-导出excel
	 * @return
	 */
	public String doExcelExport(){
		LoginMember member = getMember();
		QueryParameter param = getParameter();
		param.setAction(QueryAction.ALL);
		ServiceResult result = this.rewardTdRecordService.transact(member, param,ServiceType.OTHER);
		if (result.isSuccess() && result.getRetResult() != null
				&& result.getRetResult().getData() != null
				&& result.getRetResult().getData().size() > 0) {
			exportExcel(result.getRetResult().getData());
		}
		return null;
	}  
	
	protected String getExcelTitle() {
		return "终端计酬成功数据汇总";
	}
	
	protected List<ExcelColumn> getExcelColumn(){
		List<ExcelColumn> Cols = new ArrayList<ExcelColumn>(); 
		Cols.add(new ExcelColumn("name","业务名称",10)); 
		Cols.add(new ExcelColumn("rewardtype","酬金类型",10));
		Cols.add(new ExcelColumn("oprtime","业务发生时间",10));
		Cols.add(new ExcelColumn("rewardmonth","结算月份",10));
		Cols.add(new ExcelColumn("paysum","应发金额",10)); 
		return Cols;
	} 

	/**
	 * 返回页面显示的效果
	 * 
	 * @return the colSet
	 */
	public String getShowCols() {
		return JSONArray.fromObject(getsetCols()).toString();
	}

	public List getRetlist() {
		return retlist;
	}

	public void setRetlist(List retlist) {
		this.retlist = retlist;
	}

	public RewardTdRecordService getRewardTdRecordService() {
		return rewardTdRecordService;
	}

	public void setRewardTdRecordService(
			RewardTdRecordService rewardTdRecordService) {
		this.rewardTdRecordService = rewardTdRecordService;
	}

}
