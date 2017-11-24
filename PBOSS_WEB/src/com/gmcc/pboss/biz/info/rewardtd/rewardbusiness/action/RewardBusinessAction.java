package com.gmcc.pboss.biz.info.rewardtd.rewardbusiness.action;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.gmcc.pboss.biz.info.rewardtd.rewardbusiness.service.RewardBusinessService;
import com.gmcc.pboss.biz.info.rewardtd.rewardbusiness.support.RewardBusinessOther;
import com.gmcc.pboss.biz.info.rewardtd.rewardbusiness.support.RewardBusinessQueryParameter;
import com.gmcc.pboss.common.action.AbstractAction;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.dictionary.PageLoction;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceType;
import com.gmcc.pboss.common.support.QueryParameter;

public class RewardBusinessAction extends AbstractAction {

	private QueryParameter parameter;
	private List retlist;
	private RewardBusinessService rewardBusinessService;

	public QueryParameter getParameter() {
		// TODO Auto-generated method stub
		parameter = parameter == null ? new RewardBusinessQueryParameter  ()
				: parameter;
		// 设置页码，仅在明细查询时使用，统计汇总不使用
//		if (this.getPageNo() != null)
//			parameter.setNo(getPageNo().intValue());// 设置页码
//		if (this.getPageSize() != null)
//			parameter.setSize(getPageSize().intValue());// 设置大小
		LoginMember logMem = this.getMember();
		if (logMem.getIsnet() == 1) {// 店主只允许查询自身酬金信息
			((RewardBusinessQueryParameter) parameter).setWayid(logMem
					.getWayid());
		}

		return parameter;
	}

	public void prepare() throws Exception {
		// TODO Auto-generated method stub

	}

	 

	public String doStat() {
		if(this.getLogMember().getIsnet()!=4){//店主
			this.setTitle(PageLoction.REWARDBUSINESS);
		}else{//经理人员
			this.setTitle(PageLoction.MAG_REWARDBUSINESS);
		}
//		
		
		
		//默认查询上个月的数据
		 SimpleDateFormat format = new SimpleDateFormat("yyyyMM"); 
		 Calendar objCalendar = Calendar.getInstance(); 
		 objCalendar.add(Calendar.MONTH, -1); 
		 format.format(objCalendar.getTime());
		((RewardBusinessQueryParameter)this.getParameter()).setOprmon(format.format(objCalendar.getTime()));
		return SUCCESS; 
	}

	public String doAjax() {
		if(this.getLogMember().getIsnet()!=4){//店主
			this.setTitle(PageLoction.REWARDBUSINESS);
		}else{//经理人员
			this.setTitle(PageLoction.MAG_REWARDBUSINESS);
		}
		ServiceResult result = isLogin();
		RewardBusinessQueryParameter param = (RewardBusinessQueryParameter) parameter; 
		RewardBusinessOther rbOther = new RewardBusinessOther();
		//获取生成报表数据
		if (result.isSuccess())
			result = this.rewardBusinessService.transact(getMember(),
					getParameter(), ServiceType.OTHER);
		if(result.getRetResult().getData().size() != 0){
			
		
		this.retlist = result.getRetResult().getData();
		
		//获取酬金合计
		List busistat = this.rewardBusinessService.getBusistat(param.getWayid(), param.getOprmon());
		if(busistat!=null && busistat.size()>0){
			Object[] obj = (Object[])busistat.get(0);
			
//			rbOther.setRwmon((String)obj[0].toString());
//			rbOther.setCusttype((String)obj[1].toString());
			rbOther.setTrwmoney1((String)obj[1].toString());
			rbOther.setTrwmoney2((String)obj[2].toString());
			rbOther.setTrwmoney3((String)obj[3].toString());
			rbOther.setTrwmoney4((String)obj[4].toString());
			rbOther.setTrwmoney5((String)obj[5].toString());
			rbOther.setTrwmoney6((String)obj[6].toString());
			rbOther.setTrwmoney7((String)obj[7].toString());
			
		}
		
			
		SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
		 Calendar calender = Calendar.getInstance(); 

		Date date;
		String oprmon1 = "";
		String oprmon2 = "";
		String oprmon3 = "";
		String oprmon4 = "";
		String oprmon5 = "";
		String oprmon6 = "";
		String oprmon7 = "";
		try {
//			rbOther info = new rbOther();   
			 date = format.parse(param.getOprmon());
			
			 calender.setTime(date);
			 calender.add(Calendar.MONTH, 1); 
			 oprmon1= format.format(calender.getTime());
			 rbOther.setOprmon1(oprmon1);
			 
			 calender.add(Calendar.MONTH, 1); 
			 oprmon2= format.format(calender.getTime());
			 rbOther.setOprmon2(oprmon2);
			 
			 calender.add(Calendar.MONTH, 1); 
			 oprmon3= format.format(calender.getTime());
			 rbOther.setOprmon3(oprmon3);
			 
			 calender.add(Calendar.MONTH, 1); 
			 oprmon4= format.format(calender.getTime());
			 rbOther.setOprmon4(oprmon4);
			 
			 calender.add(Calendar.MONTH, 1); 
			 oprmon5= format.format(calender.getTime());
			 rbOther.setOprmon5(oprmon5);
			 
			 calender.add(Calendar.MONTH, 1); 
			 oprmon6= format.format(calender.getTime());
			 rbOther.setOprmon6(oprmon6);
			 
			 calender.add(Calendar.MONTH, 1); 
			 oprmon7= format.format(calender.getTime());
			 rbOther.setOprmon7(oprmon7);
			 
			 getRequest().setAttribute("info", rbOther);
			 System.out.println("MONTH ========="+format.format(calender.getTime()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
//		this.writeJSONServicePage(result, getsetCols());
		return SUCCESS;
	}

	/**
	 * 导出EXCEL
	 * @param request
	 * @param response
	 * @return
	 */
	public String doExcelExport() {
		if(this.getLogMember().getIsnet()!=4){//店主
			this.setTitle(PageLoction.REWARDBUSINESS);
		}else{//经理人员
			this.setTitle(PageLoction.MAG_REWARDBUSINESS);
		}
		ServiceResult result = isLogin();
		RewardBusinessQueryParameter param = (RewardBusinessQueryParameter) parameter; 
		RewardBusinessOther rbOther = new RewardBusinessOther();
		//获取生成报表数据
		if (result.isSuccess())
			result = this.rewardBusinessService.transact(getMember(),
					getParameter(), ServiceType.OTHER);
		if(result.getRetResult().getData().size() != 0){
			
		
		this.retlist = result.getRetResult().getData();
		
		//获取酬金合计
		List busistat = this.rewardBusinessService.getBusistat(param.getWayid(), param.getOprmon());
		if(busistat!=null && busistat.size()>0){
			Object[] obj = (Object[])busistat.get(0);
			
//			rbOther.setRwmon((String)obj[0].toString());
//			rbOther.setCusttype((String)obj[1].toString());
			rbOther.setTrwmoney1((String)obj[1].toString());
			rbOther.setTrwmoney2((String)obj[2].toString());
			rbOther.setTrwmoney3((String)obj[3].toString());
			rbOther.setTrwmoney4((String)obj[4].toString());
			rbOther.setTrwmoney5((String)obj[5].toString());
			rbOther.setTrwmoney6((String)obj[6].toString());
			rbOther.setTrwmoney7((String)obj[7].toString());
			
		}
		
			
		SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
		 Calendar calender = Calendar.getInstance(); 

		Date date;
		String oprmon1 = "";
		String oprmon2 = "";
		String oprmon3 = "";
		String oprmon4 = "";
		String oprmon5 = "";
		String oprmon6 = "";
		String oprmon7 = "";
		try {
//			rbOther info = new rbOther();   
			 date = format.parse(param.getOprmon());
			
			 calender.setTime(date);
			 calender.add(Calendar.MONTH, 1); 
			 oprmon1= format.format(calender.getTime());
			 rbOther.setOprmon1(oprmon1);
			 
			 calender.add(Calendar.MONTH, 1); 
			 oprmon2= format.format(calender.getTime());
			 rbOther.setOprmon2(oprmon2);
			 
			 calender.add(Calendar.MONTH, 1); 
			 oprmon3= format.format(calender.getTime());
			 rbOther.setOprmon3(oprmon3);
			 
			 calender.add(Calendar.MONTH, 1); 
			 oprmon4= format.format(calender.getTime());
			 rbOther.setOprmon4(oprmon4);
			 
			 calender.add(Calendar.MONTH, 1); 
			 oprmon5= format.format(calender.getTime());
			 rbOther.setOprmon5(oprmon5);
			 
			 calender.add(Calendar.MONTH, 1); 
			 oprmon6= format.format(calender.getTime());
			 rbOther.setOprmon6(oprmon6);
			 
			 calender.add(Calendar.MONTH, 1); 
			 oprmon7= format.format(calender.getTime());
			 rbOther.setOprmon7(oprmon7);
			 
			 System.out.println("MONTH ========="+format.format(calender.getTime()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		 getRequest().setAttribute("retlist", this.retlist);
		 getRequest().setAttribute("info", rbOther);
	 getRequest().setAttribute("fileName", "业务办理酬金分期表.xls"); 
		
		
		return SUCCESS;
	}
	
	/**
	 * 获得表头 （表格标题）
	 * 
	 * @return
	 */
//	public List<ColumnSet> getsetCols() {
//		List<ColumnSet> setCols = new ArrayList<ColumnSet>();
//		setCols.add(new ColumnSet("name", "业务名称"));
//		//setCols.add(new ColumnSet("rewardtype", "酬金类型"));
//		setCols.add(new ColumnSet("comname", "商品名称"));
//		setCols.add(new ColumnSet("bakinfo", "终端IMEI"));
//		setCols.add(new ColumnSet("mobile", "业务发生号码"));
//		setCols.add(new ColumnSet("oprtime", "业务发生时间"));
//		setCols.add(new ColumnSet("rewardmonth", "结算月份"));
//		setCols.add(new ColumnSet("acctype", "计酬方式"));
//		setCols.add(new ColumnSet("rewardstd", "酬金标准"));
//		setCols.add(new ColumnSet("paysum", "应发金额"));
//		setCols.add(new ColumnSet("assegrade", "计酬比例"));
//		setCols.add(new ColumnSet("wrapfee", "承诺低消"));
//		setCols.add(new ColumnSet("assegrade2", "低价值占比"));
//		//setCols.add(new ColumnSet("repairmonth", "补算月"));
//		setCols.add(new ColumnSet("noncyc", "结算期数"));
//		setCols.add(new ColumnSet("bakinfo7", "总流量"));
//		setCols.add(new ColumnSet("bakinfo8", "ARPU值"));
//		setCols.add(new ColumnSet("failreason", "计酬结果"));
//		return setCols;
//	}
	
	/**
	 * 月度应发酬金报表-导出excel
	 * @return
	 */
//	public String doExcelExport(){
//		LoginMember member = getMember();
//		QueryParameter param = getParameter();
//		param.setAction(QueryAction.ALL);
//		ServiceResult result = this.rewardBusinessService.transact(member, param,ServiceType.OTHER);
//		if (result.isSuccess() && result.getRetResult() != null
//				&& result.getRetResult().getData() != null
//				&& result.getRetResult().getData().size() > 0) {
//			exportExcel(result.getRetResult().getData());
//		}
//		return null;
//	} 
//	protected String getExcelTitle() {
//		return "月度应发酬金报表";
//	}
	
//	//导出excel列表头
//	protected List<ExcelColumn> getExcelColumn(){
//		List<ExcelColumn> Cols = new ArrayList<ExcelColumn>(); 
//		Cols.add(new ExcelColumn("name","业务名称",10)); 
//		//Cols.add(new ExcelColumn("rewardtype","酬金类型",10));
//		Cols.add(new ExcelColumn("comname","商品名称",10));
//		Cols.add(new ExcelColumn("bakinfo","终端IMEI",10));
//		Cols.add(new ExcelColumn("mobile","业务发生号码",10)); 
//		Cols.add(new ExcelColumn("oprtime","业务发生时间",10)); 
//		Cols.add(new ExcelColumn("rewardmonth","结算月份",10)); 
//		Cols.add(new ExcelColumn("acctype","计酬方式",10));  
//		Cols.add(new ExcelColumn("rewardstd","酬金标准",10)); 
//		Cols.add(new ExcelColumn("paysum","应发金额",10));  
//		Cols.add(new ExcelColumn("assegrade","计酬比例",10));
//		Cols.add(new ExcelColumn("wrapfee","承诺低消",10));
//		Cols.add(new ExcelColumn("assegrade2","低价值占比",10)); 
//		//Cols.add(new ExcelColumn("repairmonth","补算月",10)); 
//		Cols.add(new ExcelColumn("noncyc","结算期数",10)); 
//		Cols.add(new ExcelColumn("bakinfo7","总流量",10));
//		Cols.add(new ExcelColumn("bakinfo8","ARPU值",10));
//		Cols.add(new ExcelColumn("failreason","计酬结果",10));  
//		return Cols;
//	}  
//	

	/**
	 * 返回页面显示的效果
	 * 
	 * @return the colSet
	 */
//	public String getShowCols() {
//		return JSONArray.fromObject(getsetCols()).toString();
//	}

	public List getRetlist() {
		return retlist;
	}

	public void setRetlist(List retlist) {
		this.retlist = retlist;
	}

	public RewardBusinessService getRewardBusinessService() {
		return rewardBusinessService;
	}

	public void setRewardBusinessService(RewardBusinessService rewardBusinessService) {
		this.rewardBusinessService = rewardBusinessService;
	}

	
}
