package com.gmcc.pboss.biz.info.rewardtd.monthremuneration.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.RequestUtils;

import com.gmcc.pboss.biz.info.rewardtd.monthremuneration.service.MonthRemunerationService;
import com.gmcc.pboss.biz.info.rewardtd.monthremuneration.support.MonthRemuneration;
import com.gmcc.pboss.biz.info.rewardtd.monthremuneration.support.MonthRemunerationQueryParameter;
import com.gmcc.pboss.biz.info.rewardtd.monthremuneration.support.WayrewardOther;
import com.gmcc.pboss.common.action.AbstractAction;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.dictionary.PageLoction;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceType;
import com.gmcc.pboss.common.support.QueryParameter;

public class MonthRemunerationAction extends AbstractAction {

	private QueryParameter parameter;
	private List retlist;
	private MonthRemunerationService monthRemunerationService;

	//private RewardAdSucService  rewardAdSucService;
	//酬金类型查询
	//private Map dictItem;
	public QueryParameter getParameter() {
		// TODO Auto-generated method stub
		parameter = parameter == null ? new MonthRemunerationQueryParameter  ()
				: parameter;
		// 设置页码，仅在明细查询时使用，统计汇总不使用
//		if (this.getPageNo() != null)
//			parameter.setNo(getPageNo().intValue());// 设置页码
//		if (this.getPageSize() != null)
//			parameter.setSize(getPageSize().intValue());// 设置大小
		LoginMember logMem = this.getMember();
		if (logMem.getIsnet() == 1) {// 店主只允许查询自身酬金信息
			((MonthRemunerationQueryParameter) parameter).setWayid(logMem
					.getWayid());
		}

		return parameter;
	}

	public void prepare() throws Exception {
		// TODO Auto-generated method stub

	}

	 

	public String doStat() {
		if(this.getLogMember().getIsnet()!=4){//店主
			this.setTitle(PageLoction.MONTHREMUN);
		}else{//经理人员
			this.setTitle(PageLoction.MAG_MONTHREMUN);
		}
		
		//默认查询上个月的数据
		 SimpleDateFormat format = new SimpleDateFormat("yyyyMM"); 
		 Calendar objCalendar = Calendar.getInstance(); 
		 objCalendar.add(Calendar.MONTH, -1); 
		 format.format(objCalendar.getTime());
		((MonthRemunerationQueryParameter)this.getParameter()).setRwmon(format.format(objCalendar.getTime()));
		return SUCCESS; 
	}

	public String doAjax() {
		if(this.getLogMember().getIsnet()!=4){//店主
			this.setTitle(PageLoction.MONTHREMUN);
		}else{//经理人员
			this.setTitle(PageLoction.MAG_MONTHREMUN);
		}
		ServiceResult result = isLogin();
		MonthRemunerationQueryParameter param = (MonthRemunerationQueryParameter) parameter; 
		WayrewardOther wayrewardOther = new WayrewardOther();
		//获取生成报表数据
		if (result.isSuccess())
			result = this.monthRemunerationService.transact(getMember(),
					getParameter(), ServiceType.OTHER);
		if(result.getRetResult().getData().size() != 0){
			
		
		this.retlist = result.getRetResult().getData();
		//获取酬金合计
		List busistat = this.monthRemunerationService.getBusistat(param.getWayid(), param.getRwmon());
		if(busistat!=null && busistat.size()>0){
			Object[] obj = (Object[])busistat.get(0);
			
			wayrewardOther.setRwmon((String)obj[0].toString());
//			wayrewardOther.setCusttype((String)obj[1].toString());
			wayrewardOther.setTrwmoney7(null==obj[2] ||("").equals(obj[2])?0:(new BigDecimal(obj[2].toString())).doubleValue());
			wayrewardOther.setTrwmoney6(null==obj[3] ||("").equals(obj[3])?0:(new BigDecimal(obj[3].toString())).doubleValue());
			wayrewardOther.setTrwmoney5(null==obj[4] ||("").equals(obj[4])?0:(new BigDecimal(obj[4].toString())).doubleValue());
			wayrewardOther.setTrwmoney4(null==obj[5] ||("").equals(obj[5])?0:(new BigDecimal(obj[5].toString())).doubleValue());
			wayrewardOther.setTrwmoney3(null==obj[6] ||("").equals(obj[6])?0:(new BigDecimal(obj[6].toString())).doubleValue());
			wayrewardOther.setTrwmoney2(null==obj[7] ||("").equals(obj[7])?0:(new BigDecimal(obj[7].toString())).doubleValue());
			wayrewardOther.setTrwmoney1(null==obj[8] ||("").equals(obj[8])?0:(new BigDecimal(obj[8].toString())).doubleValue());
			wayrewardOther.setSumrwmoney(null==obj[9] ||("").equals(obj[9])?0:(new BigDecimal(obj[9].toString())).doubleValue());
		
		}
		
		//获取其他酬金合计
		List otherList = this.monthRemunerationService.getOtherList(param.getWayid(), param.getRwmon());
		if(otherList!=null && otherList.size()>0){
			Object[] obje = (Object[])otherList.get(0);
			
//			wayrewardOther.setRwmon((String)obj[0].toString());
			wayrewardOther.setOtherrwmoney(null==obje[1] ||("").equals(obje[1])?0:(new BigDecimal(obje[1].toString())).doubleValue());
			
		}
		
		//获取合计
		List count = this.monthRemunerationService.getCountList(param.getWayid(), param.getRwmon());
		if(count!=null && count.size()>0){
			Object[] obje = (Object[])count.get(0);
			
//			wayrewardOther.setRwmon((String)obj[0].toString());
			wayrewardOther.setSumpaymoney1(null==obje[1] ||("").equals(obje[1])?0:(new BigDecimal(obje[1].toString())).doubleValue());
			
		}
			
		SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
		 Calendar calender = Calendar.getInstance(); 

		Date date;
		String rwmon1 = "";
		String rwmon2 = "";
		String rwmon3 = "";
		String rwmon4 = "";
		String rwmon5 = "";
		String rwmon6 = "";
		String rwmon7 = "";
		try {
//			WayrewardOther info = new WayrewardOther();   
			 date = format.parse(param.getRwmon());
			
			 calender.setTime(date);
			 calender.add(Calendar.MONTH, -1); 
			 rwmon1= format.format(calender.getTime());
			 wayrewardOther.setRwmon1(rwmon1);
			 
			 calender.add(Calendar.MONTH, -1); 
			 rwmon2= format.format(calender.getTime());
			 wayrewardOther.setRwmon2(rwmon2);
			 
			 calender.add(Calendar.MONTH, -1); 
			 rwmon3= format.format(calender.getTime());
			 wayrewardOther.setRwmon3(rwmon3);
			 
			 calender.add(Calendar.MONTH, -1); 
			 rwmon4= format.format(calender.getTime());
			 wayrewardOther.setRwmon4(rwmon4);
			 
			 calender.add(Calendar.MONTH, -1); 
			 rwmon5= format.format(calender.getTime());
			 wayrewardOther.setRwmon5(rwmon5);
			 
			 calender.add(Calendar.MONTH, -1); 
			 rwmon6= format.format(calender.getTime());
			 wayrewardOther.setRwmon6(rwmon6);
			 
			 calender.add(Calendar.MONTH, -1); 
			 rwmon7= format.format(calender.getTime());
			 wayrewardOther.setRwmon7(rwmon7);
			 
			 getRequest().setAttribute("info", wayrewardOther);
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
			this.setTitle(PageLoction.MONTHREMUN);
		}else{//经理人员
			this.setTitle(PageLoction.MAG_MONTHREMUN);
		}
		ServiceResult result = isLogin();
		MonthRemunerationQueryParameter param = (MonthRemunerationQueryParameter) parameter; 
		WayrewardOther wayrewardOther = new WayrewardOther();
		//获取生成报表数据
		if (result.isSuccess())
			result = this.monthRemunerationService.transact(getMember(),
					getParameter(), ServiceType.OTHER);
		if(result.getRetResult().getData().size() != 0){
			
		
		this.retlist = result.getRetResult().getData();
		
		//获取酬金合计
		List busistat = this.monthRemunerationService.getBusistat(param.getWayid(), param.getRwmon());
		if(busistat!=null && busistat.size()>0){
			Object[] obj = (Object[])busistat.get(0);
			
			wayrewardOther.setRwmon((String)obj[0].toString());
//			wayrewardOther.setCusttype((String)obj[1].toString());
			wayrewardOther.setTrwmoney7(null==obj[2] ||("").equals(obj[2])?0:(new BigDecimal(obj[2].toString())).doubleValue());
			wayrewardOther.setTrwmoney6(null==obj[3] ||("").equals(obj[3])?0:(new BigDecimal(obj[3].toString())).doubleValue());
			wayrewardOther.setTrwmoney5(null==obj[4] ||("").equals(obj[4])?0:(new BigDecimal(obj[4].toString())).doubleValue());
			wayrewardOther.setTrwmoney4(null==obj[5] ||("").equals(obj[5])?0:(new BigDecimal(obj[5].toString())).doubleValue());
			wayrewardOther.setTrwmoney3(null==obj[6] ||("").equals(obj[6])?0:(new BigDecimal(obj[6].toString())).doubleValue());
			wayrewardOther.setTrwmoney2(null==obj[7] ||("").equals(obj[7])?0:(new BigDecimal(obj[7].toString())).doubleValue());
			wayrewardOther.setTrwmoney1(null==obj[8] ||("").equals(obj[8])?0:(new BigDecimal(obj[8].toString())).doubleValue());
			wayrewardOther.setSumrwmoney(null==obj[9] ||("").equals(obj[9])?0:(new BigDecimal(obj[9].toString())).doubleValue());
		
		}
		
		//获取其他酬金合计
		List otherList = this.monthRemunerationService.getOtherList(param.getWayid(), param.getRwmon());
		if(otherList!=null && otherList.size()>0){
			Object[] obje = (Object[])otherList.get(0);
			
//			wayrewardOther.setRwmon((String)obj[0].toString());
			wayrewardOther.setOtherrwmoney(null==obje[1] ||("").equals(obje[1])?0:(new BigDecimal(obje[1].toString())).doubleValue());
			
		}
		
		//获取合计
		List count = this.monthRemunerationService.getCountList(param.getWayid(), param.getRwmon());
		if(count!=null && count.size()>0){
			Object[] obje = (Object[])count.get(0);
			
//			wayrewardOther.setRwmon((String)obj[0].toString());
			wayrewardOther.setSumpaymoney1(null==obje[1] ||("").equals(obje[1])?0:(new BigDecimal(obje[1].toString())).doubleValue());
			
		}
			
		SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
		 Calendar calender = Calendar.getInstance(); 

		Date date;
		String rwmon1 = "";
		String rwmon2 = "";
		String rwmon3 = "";
		String rwmon4 = "";
		String rwmon5 = "";
		String rwmon6 = "";
		String rwmon7 = "";
		try {
//			WayrewardOther info = new WayrewardOther();   
			 date = format.parse(param.getRwmon());
			
			 calender.setTime(date);
			 calender.add(Calendar.MONTH, -1); 
			 rwmon1= format.format(calender.getTime());
			 wayrewardOther.setRwmon1(rwmon1);
			 
			 calender.add(Calendar.MONTH, -1); 
			 rwmon2= format.format(calender.getTime());
			 wayrewardOther.setRwmon2(rwmon2);
			 
			 calender.add(Calendar.MONTH, -1); 
			 rwmon3= format.format(calender.getTime());
			 wayrewardOther.setRwmon3(rwmon3);
			 
			 calender.add(Calendar.MONTH, -1); 
			 rwmon4= format.format(calender.getTime());
			 wayrewardOther.setRwmon4(rwmon4);
			 
			 calender.add(Calendar.MONTH, -1); 
			 rwmon5= format.format(calender.getTime());
			 wayrewardOther.setRwmon5(rwmon5);
			 
			 calender.add(Calendar.MONTH, -1); 
			 rwmon6= format.format(calender.getTime());
			 wayrewardOther.setRwmon6(rwmon6);
			 
			 calender.add(Calendar.MONTH, -1); 
			 rwmon7= format.format(calender.getTime());
			 wayrewardOther.setRwmon7(rwmon7);
			 
			 System.out.println("MONTH ========="+format.format(calender.getTime()));
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		 getRequest().setAttribute("retlist", this.retlist);
		 getRequest().setAttribute("info", wayrewardOther);
		 getRequest().setAttribute("fileName", "月度应发酬金报表.xls"); 
		 
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
//		ServiceResult result = this.monthRemunerationService.transact(member, param,ServiceType.OTHER);
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

	public MonthRemunerationService getMonthRemunerationService() {
		return monthRemunerationService;
	}

	public void setMonthRemunerationService(
			MonthRemunerationService monthRemunerationService) {
		this.monthRemunerationService = monthRemunerationService;
	}

}
