package com.gmcc.pboss.biz.info.rewardtd.settlementmonth.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import net.sf.json.JSONArray;

import com.gmcc.pboss.biz.info.rewardtd.settlementmonth.service.SettlementMonthService;
import com.gmcc.pboss.biz.info.rewardtd.settlementmonth.support.SettlementMonthQueryParameter;
import com.gmcc.pboss.common.action.AbstractAction;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.dictionary.PageLoction;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceType;
import com.gmcc.pboss.common.support.ColumnSet;
import com.gmcc.pboss.common.support.ExcelColumn;
import com.gmcc.pboss.common.support.QueryAction;
import com.gmcc.pboss.common.support.QueryParameter;

public class SettlementMonthAction extends AbstractAction {

	private QueryParameter parameter;
	private List retlist;
	private SettlementMonthService settlementMonthService;

	//private RewardAdSucService  rewardAdSucService;
	//酬金类型查询
	//private Map dictItem;
	public QueryParameter getParameter() {
		// TODO Auto-generated method stub
		parameter = parameter == null ? new SettlementMonthQueryParameter  ()
				: parameter;
		// 设置页码，仅在明细查询时使用，统计汇总不使用
		if (this.getPageNo() != null)
			parameter.setNo(getPageNo().intValue());// 设置页码
		if (this.getPageSize() != null)
			parameter.setSize(getPageSize().intValue());// 设置大小
		LoginMember logMem = this.getMember();
		if (logMem.getIsnet() == 1) {// 店主只允许查询自身酬金信息
			((SettlementMonthQueryParameter) parameter).setWayid(logMem
					.getWayid());
		}

		return parameter;
	}

	public void prepare() throws Exception {
		// TODO Auto-generated method stub

	}

	 

	public String doStat() {
		
		if(this.getLogMember().getIsnet()!=4){//店主
			this.setTitle(PageLoction.SETTLEMENTMONTH);
		}else{//经理人员
			this.setTitle(PageLoction.MAG_SETTLEMENTMONTH);
		}
		//提取商品类型
//		Map c =(Map)rewardAdSucService.getDictitemRestype();
//		this.setDictItem(c);
		
		//默认查询上个月的数据
		 SimpleDateFormat format = new SimpleDateFormat("yyyyMM"); 
		 Calendar objCalendar = Calendar.getInstance(); 
		 objCalendar.add(Calendar.MONTH, -1); 
		 format.format(objCalendar.getTime());
		((SettlementMonthQueryParameter)this.getParameter()).setRwmon(format.format(objCalendar.getTime()));
		return SUCCESS; 
	}

	public String doAjax() {
		if(this.getLogMember().getIsnet()!=4){//店主
			this.setTitle(PageLoction.SETTLEMENTMONTH);
		}else{//经理人员
			this.setTitle(PageLoction.MAG_SETTLEMENTMONTH);
		}
		ServiceResult result = isLogin();
		if (result.isSuccess())
			result = this.settlementMonthService.transact(getMember(),
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
		setCols.add(new ColumnSet("oprmon", "业务发生月份"));
		setCols.add(new ColumnSet("rwmon", "结酬月份"));
		setCols.add(new ColumnSet("rwtypename", "酬金名称"));
		setCols.add(new ColumnSet("imei", "终端IMEI"));
		setCols.add(new ColumnSet("comname", "商品名称"));
		setCols.add(new ColumnSet("mainno", "主要使用号码"));
		setCols.add(new ColumnSet("bchksucc", "是否稽核通过"));
		setCols.add(new ColumnSet("rwmoney", "实发酬金金额"));
		setCols.add(new ColumnSet("failrsn", "稽核失败原因"));
		
		return setCols;
	}
	
	/**
	 * 终端计酬失败明细-导出excel
	 * @return
	 */
	public String doExcelExport(){
		LoginMember member = getMember();
		QueryParameter param = getParameter();
		param.setAction(QueryAction.ALL);
		ServiceResult result = this.settlementMonthService.transact(member, param,ServiceType.OTHER);
		if (result.isSuccess() && result.getRetResult() != null
				&& result.getRetResult().getData() != null
				&& result.getRetResult().getData().size() > 0) {
			exportExcel(result.getRetResult().getData());
		}
		return null;
	} 
	protected String getExcelTitle() {
		return "业务明细报表（结算月维度）";
	}
	
	//导出excel列表头
	protected List<ExcelColumn> getExcelColumn(){
		List<ExcelColumn> Cols = new ArrayList<ExcelColumn>(); 
		Cols.add(new ExcelColumn("oprmon","业务发生月份",10)); 
		Cols.add(new ExcelColumn("rwmon","结酬月份",10));
		Cols.add(new ExcelColumn("rwtypename","酬金名称",10));
		Cols.add(new ExcelColumn("imei","终端IMEI",10)); 
		Cols.add(new ExcelColumn("comname","商品名称",10)); 
		Cols.add(new ExcelColumn("mainno","主要使用号码",10)); 
		Cols.add(new ExcelColumn("bchksucc","是否稽核通过",10));  
		Cols.add(new ExcelColumn("rwmoney","实发酬金金额",10)); 
		Cols.add(new ExcelColumn("failrsn","稽核失败原因",10));  
		
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

	public SettlementMonthService getSettlementMonthService() {
		return settlementMonthService;
	}

	public void setSettlementMonthService(
			SettlementMonthService settlementMonthService) {
		this.settlementMonthService = settlementMonthService;
	}



//	public RewardAdSucService getRewardAdSucService() {
//		return rewardAdSucService;
//	}
//
//	public void setRewardAdSucService(RewardAdSucService rewardAdSucService) {
//		this.rewardAdSucService = rewardAdSucService;
//	}
//
//	public void setDictItem(Map dictItem) {
//		this.dictItem = dictItem;
//	}
	/**
	 * 提取酬金类型
	 * @return
	 */
//	public Map getDictItem() {
//		Map t = new LinkedHashMap();
//		t.put("", "");
//		t.putAll(dictItem);
//		return t;
//	}
}
