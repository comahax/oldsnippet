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
		// ����ҳ�룬������ϸ��ѯʱʹ�ã�ͳ�ƻ��ܲ�ʹ��
//		if (this.getPageNo() != null)
//			parameter.setNo(getPageNo().intValue());// ����ҳ��
//		if (this.getPageSize() != null)
//			parameter.setSize(getPageSize().intValue());// ���ô�С
		LoginMember logMem = this.getMember();
		if (logMem.getIsnet() == 1) {// ����ֻ�����ѯ��������Ϣ
			((RewardBusinessQueryParameter) parameter).setWayid(logMem
					.getWayid());
		}

		return parameter;
	}

	public void prepare() throws Exception {
		// TODO Auto-generated method stub

	}

	 

	public String doStat() {
		if(this.getLogMember().getIsnet()!=4){//����
			this.setTitle(PageLoction.REWARDBUSINESS);
		}else{//������Ա
			this.setTitle(PageLoction.MAG_REWARDBUSINESS);
		}
//		
		
		
		//Ĭ�ϲ�ѯ�ϸ��µ�����
		 SimpleDateFormat format = new SimpleDateFormat("yyyyMM"); 
		 Calendar objCalendar = Calendar.getInstance(); 
		 objCalendar.add(Calendar.MONTH, -1); 
		 format.format(objCalendar.getTime());
		((RewardBusinessQueryParameter)this.getParameter()).setOprmon(format.format(objCalendar.getTime()));
		return SUCCESS; 
	}

	public String doAjax() {
		if(this.getLogMember().getIsnet()!=4){//����
			this.setTitle(PageLoction.REWARDBUSINESS);
		}else{//������Ա
			this.setTitle(PageLoction.MAG_REWARDBUSINESS);
		}
		ServiceResult result = isLogin();
		RewardBusinessQueryParameter param = (RewardBusinessQueryParameter) parameter; 
		RewardBusinessOther rbOther = new RewardBusinessOther();
		//��ȡ���ɱ�������
		if (result.isSuccess())
			result = this.rewardBusinessService.transact(getMember(),
					getParameter(), ServiceType.OTHER);
		if(result.getRetResult().getData().size() != 0){
			
		
		this.retlist = result.getRetResult().getData();
		
		//��ȡ���ϼ�
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
	 * ����EXCEL
	 * @param request
	 * @param response
	 * @return
	 */
	public String doExcelExport() {
		if(this.getLogMember().getIsnet()!=4){//����
			this.setTitle(PageLoction.REWARDBUSINESS);
		}else{//������Ա
			this.setTitle(PageLoction.MAG_REWARDBUSINESS);
		}
		ServiceResult result = isLogin();
		RewardBusinessQueryParameter param = (RewardBusinessQueryParameter) parameter; 
		RewardBusinessOther rbOther = new RewardBusinessOther();
		//��ȡ���ɱ�������
		if (result.isSuccess())
			result = this.rewardBusinessService.transact(getMember(),
					getParameter(), ServiceType.OTHER);
		if(result.getRetResult().getData().size() != 0){
			
		
		this.retlist = result.getRetResult().getData();
		
		//��ȡ���ϼ�
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
	 getRequest().setAttribute("fileName", "ҵ���������ڱ�.xls"); 
		
		
		return SUCCESS;
	}
	
	/**
	 * ��ñ�ͷ �������⣩
	 * 
	 * @return
	 */
//	public List<ColumnSet> getsetCols() {
//		List<ColumnSet> setCols = new ArrayList<ColumnSet>();
//		setCols.add(new ColumnSet("name", "ҵ������"));
//		//setCols.add(new ColumnSet("rewardtype", "�������"));
//		setCols.add(new ColumnSet("comname", "��Ʒ����"));
//		setCols.add(new ColumnSet("bakinfo", "�ն�IMEI"));
//		setCols.add(new ColumnSet("mobile", "ҵ��������"));
//		setCols.add(new ColumnSet("oprtime", "ҵ����ʱ��"));
//		setCols.add(new ColumnSet("rewardmonth", "�����·�"));
//		setCols.add(new ColumnSet("acctype", "�Ƴ귽ʽ"));
//		setCols.add(new ColumnSet("rewardstd", "����׼"));
//		setCols.add(new ColumnSet("paysum", "Ӧ�����"));
//		setCols.add(new ColumnSet("assegrade", "�Ƴ����"));
//		setCols.add(new ColumnSet("wrapfee", "��ŵ����"));
//		setCols.add(new ColumnSet("assegrade2", "�ͼ�ֵռ��"));
//		//setCols.add(new ColumnSet("repairmonth", "������"));
//		setCols.add(new ColumnSet("noncyc", "��������"));
//		setCols.add(new ColumnSet("bakinfo7", "������"));
//		setCols.add(new ColumnSet("bakinfo8", "ARPUֵ"));
//		setCols.add(new ColumnSet("failreason", "�Ƴ���"));
//		return setCols;
//	}
	
	/**
	 * �¶�Ӧ����𱨱�-����excel
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
//		return "�¶�Ӧ����𱨱�";
//	}
	
//	//����excel�б�ͷ
//	protected List<ExcelColumn> getExcelColumn(){
//		List<ExcelColumn> Cols = new ArrayList<ExcelColumn>(); 
//		Cols.add(new ExcelColumn("name","ҵ������",10)); 
//		//Cols.add(new ExcelColumn("rewardtype","�������",10));
//		Cols.add(new ExcelColumn("comname","��Ʒ����",10));
//		Cols.add(new ExcelColumn("bakinfo","�ն�IMEI",10));
//		Cols.add(new ExcelColumn("mobile","ҵ��������",10)); 
//		Cols.add(new ExcelColumn("oprtime","ҵ����ʱ��",10)); 
//		Cols.add(new ExcelColumn("rewardmonth","�����·�",10)); 
//		Cols.add(new ExcelColumn("acctype","�Ƴ귽ʽ",10));  
//		Cols.add(new ExcelColumn("rewardstd","����׼",10)); 
//		Cols.add(new ExcelColumn("paysum","Ӧ�����",10));  
//		Cols.add(new ExcelColumn("assegrade","�Ƴ����",10));
//		Cols.add(new ExcelColumn("wrapfee","��ŵ����",10));
//		Cols.add(new ExcelColumn("assegrade2","�ͼ�ֵռ��",10)); 
//		//Cols.add(new ExcelColumn("repairmonth","������",10)); 
//		Cols.add(new ExcelColumn("noncyc","��������",10)); 
//		Cols.add(new ExcelColumn("bakinfo7","������",10));
//		Cols.add(new ExcelColumn("bakinfo8","ARPUֵ",10));
//		Cols.add(new ExcelColumn("failreason","�Ƴ���",10));  
//		return Cols;
//	}  
//	

	/**
	 * ����ҳ����ʾ��Ч��
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
