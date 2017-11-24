package com.gmcc.pboss.biz.info.rewardtd.salemonth.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;

import com.gmcc.pboss.biz.info.rewardtd.salemonth.service.SaleMonthService;
import com.gmcc.pboss.biz.info.rewardtd.salemonth.support.SaleMonthQueryParameter;
import com.gmcc.pboss.common.action.AbstractAction;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.dictionary.PageLoction;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceType;
import com.gmcc.pboss.common.support.ColumnSet;
import com.gmcc.pboss.common.support.ExcelColumn;
import com.gmcc.pboss.common.support.QueryAction;
import com.gmcc.pboss.common.support.QueryParameter;

public class SaleMonthAction extends AbstractAction {

	private QueryParameter parameter;
	private List retlist;
	private SaleMonthService saleMonthService;


	public QueryParameter getParameter() {
		// TODO Auto-generated method stub
		parameter = parameter == null ? new SaleMonthQueryParameter  ()
				: parameter;
		// 设置页码，仅在明细查询时使用，统计汇总不使用
		if (this.getPageNo() != null)
			parameter.setNo(getPageNo().intValue());// 设置页码
		if (this.getPageSize() != null)
			parameter.setSize(getPageSize().intValue());// 设置大小
		LoginMember logMem = this.getMember();
		if (logMem.getIsnet() == 1) {// 店主只允许查询自身酬金信息
			((SaleMonthQueryParameter) parameter).setWayid(logMem
					.getWayid());
		}

		return parameter;
	}

	public void prepare() throws Exception {
		// TODO Auto-generated method stub

	}

	 

	public String doStat() {
		if(this.getLogMember().getIsnet()!=4){//店主
			this.setTitle(PageLoction.SALEMONTH);
		}else{//经理人员
			this.setTitle(PageLoction.MAG_SALEMONTH);
		}
		
		//提取商品类型
//		Map c =(Map)rewardAdSucService.getDictitemRestype();
//		this.setDictItem(c);
		
		//默认查询上个月的数据
		 SimpleDateFormat format = new SimpleDateFormat("yyyyMM"); 
		 Calendar objCalendar = Calendar.getInstance(); 
		 objCalendar.add(Calendar.MONTH, -1); 
		 format.format(objCalendar.getTime());
		((SaleMonthQueryParameter)this.getParameter()).setOprmon(format.format(objCalendar.getTime()));
		return SUCCESS; 
	}

	public String doAjax() {
		if(this.getLogMember().getIsnet()!=4){//店主
			this.setTitle(PageLoction.SALEMONTH);
		}else{//经理人员
			this.setTitle(PageLoction.MAG_SALEMONTH);
		}
		ServiceResult result = isLogin();
//		String maxcount ="";
		SaleMonthQueryParameter param = (SaleMonthQueryParameter) parameter; 
		if (result.isSuccess())
//			 maxcount = this.saleMonthService.getMaxcount(param);
//			System.out.println("maxcount===="+maxcount);
//			if(maxcount == null || maxcount == ""){
//				param.setMaxcount("1");
//			}else{
//				param.setMaxcount(maxcount);
//			}
		
			result = this.saleMonthService.transact(getMember(),
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
				SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
				 Calendar calender = Calendar.getInstance(); 
				SaleMonthQueryParameter param = (SaleMonthQueryParameter) parameter; 
		
				Date date;
				String tmoney1 = "";
				String tmoney2 = "";
				String tmoney3 = "";
				String tmoney4 = "";
				String tmoney5 = "";
				String tmoney6 = "";
				String tmoney7 = "";
				try {
					 date = format.parse(param.getOprmon());
					
					 calender.setTime(date);
					 calender.add(Calendar.MONTH, 1); 
					 tmoney1= format.format(calender.getTime()).substring(4, 6);
					 calender.add(Calendar.MONTH, 1); 
					 tmoney2= format.format(calender.getTime()).substring(4, 6);
					 calender.add(Calendar.MONTH, 1); 
					 tmoney3= format.format(calender.getTime()).substring(4, 6);
					 calender.add(Calendar.MONTH, 1); 
					 tmoney4= format.format(calender.getTime()).substring(4, 6);
					 calender.add(Calendar.MONTH, 1); 
					 tmoney5= format.format(calender.getTime()).substring(4, 6);
					 calender.add(Calendar.MONTH, 1); 
					 tmoney6= format.format(calender.getTime()).substring(4, 6);
					 calender.add(Calendar.MONTH, 1); 
					 tmoney7= format.format(calender.getTime()).substring(4, 6);
					 System.out.println("MONTH ========="+format.format(calender.getTime()));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		//		System.out.println("param.getMaxcount ========="+param.getMaxcount());
		//		int oprmon = Integer.parseInt(param.getOprmon());
				List<ColumnSet> setCols = new ArrayList<ColumnSet>();
				setCols.add(new ColumnSet("oprmon", "业务发生月份"));
				setCols.add(new ColumnSet("imei", "终端IMEI"));
				setCols.add(new ColumnSet("comname", "商品名称"));
				setCols.add(new ColumnSet("rwtypename", "酬金名称"));
				setCols.add(new ColumnSet("tmoney1", tmoney1+"月"));
				setCols.add(new ColumnSet("tmoney2", tmoney2+"月"));
				setCols.add(new ColumnSet("tmoney3", tmoney3+"月"));
				setCols.add(new ColumnSet("tmoney4", tmoney4+"月"));
				setCols.add(new ColumnSet("tmoney5", tmoney5+"月"));
				setCols.add(new ColumnSet("tmoney6", tmoney6+"月"));
				setCols.add(new ColumnSet("tmoney7", tmoney7+"月"));
//				setCols.add(new ColumnSet("tmoney1", format.format(calender.getTime())));
//				setCols.add(new ColumnSet("tmoney2", format.format(calender.getTime())));
//				setCols.add(new ColumnSet("tmoney3", format.format(calender.getTime())));
//				setCols.add(new ColumnSet("tmoney4", format.format(calender.getTime())));
//				setCols.add(new ColumnSet("tmoney5", format.format(calender.getTime())));
//				setCols.add(new ColumnSet("tmoney6", format.format(calender.getTime())));
//				setCols.add(new ColumnSet("tmoney7", format.format(calender.getTime())));
			
//			for(int i = 0;i<maxcount;i++){ 
//				System.out.println("进来    i = "+i);
//				
//				calender.add(Calendar.MONTH, i);
//				String tmoney = format.format(calender.getTime());
//				System.out.println("进来    i = "+i);
//				setCols.add(new ColumnSet("tmoney"+i, tmoney));
//				
//			}
		
		return setCols;
	}
	
	/**
	 * 业务明细报表（销售月维度）-导出excel
	 * @return
	 */
	public String doExcelExport(){
		LoginMember member = getMember();
		QueryParameter param = getParameter();
		param.setAction(QueryAction.ALL);
//		String maxcount ="";
//		SaleMonthQueryParameter param1 = (SaleMonthQueryParameter) parameter; 
//			 maxcount = this.saleMonthService.getMaxcount(param1);
//			
//			param1.setMaxcount(maxcount);
			
		ServiceResult result = this.saleMonthService.transact(member, param,ServiceType.OTHER);
		if (result.isSuccess() && result.getRetResult() != null
				&& result.getRetResult().getData() != null
				&& result.getRetResult().getData().size() > 0) {
			exportExcel(result.getRetResult().getData());
		}
		return null;
	} 
	protected String getExcelTitle() {
		return "业务明细报表（销售月维度）";
	}
	
	//导出excel列表头
	protected List<ExcelColumn> getExcelColumn(){
		
		SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
		 Calendar calender = Calendar.getInstance(); 
		SaleMonthQueryParameter param = (SaleMonthQueryParameter) parameter; 

		Date date;
		String tmoney1 = "";
		String tmoney2 = "";
		String tmoney3 = "";
		String tmoney4 = "";
		String tmoney5 = "";
		String tmoney6 = "";
		String tmoney7 = "";
		try {
			 date = format.parse(param.getOprmon());
			
			 calender.setTime(date);
			 calender.add(Calendar.MONTH, 1); 
			 tmoney1= format.format(calender.getTime()).substring(4, 6);
			 calender.add(Calendar.MONTH, 1); 
			 tmoney2= format.format(calender.getTime()).substring(4, 6);
			 calender.add(Calendar.MONTH, 1); 
			 tmoney3= format.format(calender.getTime()).substring(4, 6);
			 calender.add(Calendar.MONTH, 1); 
			 tmoney4= format.format(calender.getTime()).substring(4, 6);
			 calender.add(Calendar.MONTH, 1); 
			 tmoney5= format.format(calender.getTime()).substring(4, 6);
			 calender.add(Calendar.MONTH, 1); 
			 tmoney6= format.format(calender.getTime()).substring(4, 6);
			 calender.add(Calendar.MONTH, 1); 
			 tmoney7= format.format(calender.getTime()).substring(4, 6);
			 System.out.println("MONTH ========="+format.format(calender.getTime()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<ExcelColumn> Cols = new ArrayList<ExcelColumn>(); 
		Cols.add(new ExcelColumn("oprmon","业务发生月份",10)); 
		Cols.add(new ExcelColumn("imei","终端IMEI",10)); 
		Cols.add(new ExcelColumn("comname","商品名称",10)); 
		Cols.add(new ExcelColumn("rwtypename","酬金名称",10));
		Cols.add(new ExcelColumn("tmoney1",tmoney1+"月",10));
		Cols.add(new ExcelColumn("tmoney2",tmoney2+"月",10));
		Cols.add(new ExcelColumn("tmoney3",tmoney3+"月",10));
		Cols.add(new ExcelColumn("tmoney4",tmoney4+"月",10));
		Cols.add(new ExcelColumn("tmoney5",tmoney5+"月",10));
		Cols.add(new ExcelColumn("tmoney6",tmoney6+"月",10));
		Cols.add(new ExcelColumn("tmoney7",tmoney7+"月",10));
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

	public SaleMonthService getSaleMonthService() {
		return saleMonthService;
	}

	public void setSaleMonthService(SaleMonthService saleMonthService) {
		this.saleMonthService = saleMonthService;
	}

}
