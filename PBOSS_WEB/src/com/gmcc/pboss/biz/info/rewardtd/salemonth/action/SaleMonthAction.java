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
		// ����ҳ�룬������ϸ��ѯʱʹ�ã�ͳ�ƻ��ܲ�ʹ��
		if (this.getPageNo() != null)
			parameter.setNo(getPageNo().intValue());// ����ҳ��
		if (this.getPageSize() != null)
			parameter.setSize(getPageSize().intValue());// ���ô�С
		LoginMember logMem = this.getMember();
		if (logMem.getIsnet() == 1) {// ����ֻ�����ѯ��������Ϣ
			((SaleMonthQueryParameter) parameter).setWayid(logMem
					.getWayid());
		}

		return parameter;
	}

	public void prepare() throws Exception {
		// TODO Auto-generated method stub

	}

	 

	public String doStat() {
		if(this.getLogMember().getIsnet()!=4){//����
			this.setTitle(PageLoction.SALEMONTH);
		}else{//������Ա
			this.setTitle(PageLoction.MAG_SALEMONTH);
		}
		
		//��ȡ��Ʒ����
//		Map c =(Map)rewardAdSucService.getDictitemRestype();
//		this.setDictItem(c);
		
		//Ĭ�ϲ�ѯ�ϸ��µ�����
		 SimpleDateFormat format = new SimpleDateFormat("yyyyMM"); 
		 Calendar objCalendar = Calendar.getInstance(); 
		 objCalendar.add(Calendar.MONTH, -1); 
		 format.format(objCalendar.getTime());
		((SaleMonthQueryParameter)this.getParameter()).setOprmon(format.format(objCalendar.getTime()));
		return SUCCESS; 
	}

	public String doAjax() {
		if(this.getLogMember().getIsnet()!=4){//����
			this.setTitle(PageLoction.SALEMONTH);
		}else{//������Ա
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
	 * ��ñ�ͷ �������⣩
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
				setCols.add(new ColumnSet("oprmon", "ҵ�����·�"));
				setCols.add(new ColumnSet("imei", "�ն�IMEI"));
				setCols.add(new ColumnSet("comname", "��Ʒ����"));
				setCols.add(new ColumnSet("rwtypename", "�������"));
				setCols.add(new ColumnSet("tmoney1", tmoney1+"��"));
				setCols.add(new ColumnSet("tmoney2", tmoney2+"��"));
				setCols.add(new ColumnSet("tmoney3", tmoney3+"��"));
				setCols.add(new ColumnSet("tmoney4", tmoney4+"��"));
				setCols.add(new ColumnSet("tmoney5", tmoney5+"��"));
				setCols.add(new ColumnSet("tmoney6", tmoney6+"��"));
				setCols.add(new ColumnSet("tmoney7", tmoney7+"��"));
//				setCols.add(new ColumnSet("tmoney1", format.format(calender.getTime())));
//				setCols.add(new ColumnSet("tmoney2", format.format(calender.getTime())));
//				setCols.add(new ColumnSet("tmoney3", format.format(calender.getTime())));
//				setCols.add(new ColumnSet("tmoney4", format.format(calender.getTime())));
//				setCols.add(new ColumnSet("tmoney5", format.format(calender.getTime())));
//				setCols.add(new ColumnSet("tmoney6", format.format(calender.getTime())));
//				setCols.add(new ColumnSet("tmoney7", format.format(calender.getTime())));
			
//			for(int i = 0;i<maxcount;i++){ 
//				System.out.println("����    i = "+i);
//				
//				calender.add(Calendar.MONTH, i);
//				String tmoney = format.format(calender.getTime());
//				System.out.println("����    i = "+i);
//				setCols.add(new ColumnSet("tmoney"+i, tmoney));
//				
//			}
		
		return setCols;
	}
	
	/**
	 * ҵ����ϸ����������ά�ȣ�-����excel
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
		return "ҵ����ϸ����������ά�ȣ�";
	}
	
	//����excel�б�ͷ
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
		Cols.add(new ExcelColumn("oprmon","ҵ�����·�",10)); 
		Cols.add(new ExcelColumn("imei","�ն�IMEI",10)); 
		Cols.add(new ExcelColumn("comname","��Ʒ����",10)); 
		Cols.add(new ExcelColumn("rwtypename","�������",10));
		Cols.add(new ExcelColumn("tmoney1",tmoney1+"��",10));
		Cols.add(new ExcelColumn("tmoney2",tmoney2+"��",10));
		Cols.add(new ExcelColumn("tmoney3",tmoney3+"��",10));
		Cols.add(new ExcelColumn("tmoney4",tmoney4+"��",10));
		Cols.add(new ExcelColumn("tmoney5",tmoney5+"��",10));
		Cols.add(new ExcelColumn("tmoney6",tmoney6+"��",10));
		Cols.add(new ExcelColumn("tmoney7",tmoney7+"��",10));
		return Cols;
	}  
	

	/**
	 * ����ҳ����ʾ��Ч��
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
