package com.gmcc.pboss.biz.info.rewardtd.rewardadfail.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import net.sf.json.JSONArray;

import com.gmcc.pboss.biz.info.rewardtd.rewardadfail.service.RewardAdFailService;
import com.gmcc.pboss.biz.info.rewardtd.rewardadfail.support.RewardAdFailQueryParameter;
import com.gmcc.pboss.common.action.AbstractAction;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.dictionary.PageLoction;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceType;
import com.gmcc.pboss.common.support.ColumnSet;
import com.gmcc.pboss.common.support.ExcelColumn;
import com.gmcc.pboss.common.support.QueryAction;
import com.gmcc.pboss.common.support.QueryParameter;

public class RewardAdFailAction extends AbstractAction {

	private QueryParameter parameter;
	private List retlist;
	private RewardAdFailService rewardAdFailService;

	//private RewardAdSucService  rewardAdSucService;
	//酬金类型查询
	//private Map dictItem;
	public QueryParameter getParameter() {
		// TODO Auto-generated method stub
		parameter = parameter == null ? new RewardAdFailQueryParameter  ()
				: parameter;
		// 设置页码，仅在明细查询时使用，统计汇总不使用
		if (this.getPageNo() != null)
			parameter.setNo(getPageNo().intValue());// 设置页码
		if (this.getPageSize() != null)
			parameter.setSize(getPageSize().intValue());// 设置大小
		LoginMember logMem = this.getMember();
		if (logMem.getIsnet() == 1) {// 店主只允许查询自身酬金信息
			((RewardAdFailQueryParameter) parameter).setWayid(logMem
					.getWayid());
		}

		return parameter;
	}

	public void prepare() throws Exception {
		// TODO Auto-generated method stub

	}

	 

	public String doStat() {
		this.setTitle(PageLoction.REWARDAD_FAIL);
		
		//提取商品类型
//		Map c =(Map)rewardAdSucService.getDictitemRestype();
//		this.setDictItem(c);
		
		//默认查询上个月的数据
		 SimpleDateFormat format = new SimpleDateFormat("yyyyMM"); 
		 Calendar objCalendar = Calendar.getInstance(); 
		 objCalendar.add(Calendar.MONTH, -1); 
		 format.format(objCalendar.getTime());
		((RewardAdFailQueryParameter)this.getParameter()).setRewardmonth(format.format(objCalendar.getTime()));
		return SUCCESS; 
	}

	public String doAjax() {
		ServiceResult result = isLogin();
		if (result.isSuccess())
			result = this.rewardAdFailService.transact(getMember(),
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
		//setCols.add(new ColumnSet("rewardtype", "酬金类型"));
		setCols.add(new ColumnSet("comname", "商品名称"));
		setCols.add(new ColumnSet("bakinfo", "终端IMEI"));
		setCols.add(new ColumnSet("mobile", "业务发生号码"));
		setCols.add(new ColumnSet("oprtime", "业务发生时间"));
		setCols.add(new ColumnSet("rewardmonth", "结算月份"));
		setCols.add(new ColumnSet("acctype", "计酬方式"));
		setCols.add(new ColumnSet("rewardstd", "酬金标准"));
		setCols.add(new ColumnSet("paysum", "应发金额"));
		setCols.add(new ColumnSet("assegrade", "计酬比例"));
		setCols.add(new ColumnSet("wrapfee", "承诺低消"));
		setCols.add(new ColumnSet("assegrade2", "低价值占比"));
		//setCols.add(new ColumnSet("repairmonth", "补算月"));
		setCols.add(new ColumnSet("noncyc", "结算期数"));
		setCols.add(new ColumnSet("bakinfo7", "总流量"));
		setCols.add(new ColumnSet("bakinfo8", "ARPU值"));
		setCols.add(new ColumnSet("failreason", "计酬结果"));
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
		ServiceResult result = this.rewardAdFailService.transact(member, param,ServiceType.OTHER);
		if (result.isSuccess() && result.getRetResult() != null
				&& result.getRetResult().getData() != null
				&& result.getRetResult().getData().size() > 0) {
			exportExcel(result.getRetResult().getData());
		}
		return null;
	} 
	protected String getExcelTitle() {
		return "终端预发计酬失败数据明细";
	}
	
	//导出excel列表头
	protected List<ExcelColumn> getExcelColumn(){
		List<ExcelColumn> Cols = new ArrayList<ExcelColumn>(); 
		Cols.add(new ExcelColumn("name","业务名称",10)); 
		//Cols.add(new ExcelColumn("rewardtype","酬金类型",10));
		Cols.add(new ExcelColumn("comname","商品名称",10));
		Cols.add(new ExcelColumn("bakinfo","终端IMEI",10));
		Cols.add(new ExcelColumn("mobile","业务发生号码",10)); 
		Cols.add(new ExcelColumn("oprtime","业务发生时间",10)); 
		Cols.add(new ExcelColumn("rewardmonth","结算月份",10)); 
		Cols.add(new ExcelColumn("acctype","计酬方式",10));  
		Cols.add(new ExcelColumn("rewardstd","酬金标准",10)); 
		Cols.add(new ExcelColumn("paysum","应发金额",10));  
		Cols.add(new ExcelColumn("assegrade","计酬比例",10));
		Cols.add(new ExcelColumn("wrapfee","承诺低消",10));
		Cols.add(new ExcelColumn("assegrade2","低价值占比",10)); 
		//Cols.add(new ExcelColumn("repairmonth","补算月",10)); 
		Cols.add(new ExcelColumn("noncyc","结算期数",10)); 
		Cols.add(new ExcelColumn("bakinfo7","总流量",10));
		Cols.add(new ExcelColumn("bakinfo8","ARPU值",10));
		Cols.add(new ExcelColumn("failreason","计酬结果",10));  
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

	public RewardAdFailService getRewardAdFailService() {
		return rewardAdFailService;
	}

	public void setRewardAdFailService(RewardAdFailService rewardAdFailService) {
		this.rewardAdFailService = rewardAdFailService;
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
