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
	//������Ͳ�ѯ
	//private Map dictItem;
	public QueryParameter getParameter() {
		// TODO Auto-generated method stub
		parameter = parameter == null ? new SettlementMonthQueryParameter  ()
				: parameter;
		// ����ҳ�룬������ϸ��ѯʱʹ�ã�ͳ�ƻ��ܲ�ʹ��
		if (this.getPageNo() != null)
			parameter.setNo(getPageNo().intValue());// ����ҳ��
		if (this.getPageSize() != null)
			parameter.setSize(getPageSize().intValue());// ���ô�С
		LoginMember logMem = this.getMember();
		if (logMem.getIsnet() == 1) {// ����ֻ�����ѯ��������Ϣ
			((SettlementMonthQueryParameter) parameter).setWayid(logMem
					.getWayid());
		}

		return parameter;
	}

	public void prepare() throws Exception {
		// TODO Auto-generated method stub

	}

	 

	public String doStat() {
		
		if(this.getLogMember().getIsnet()!=4){//����
			this.setTitle(PageLoction.SETTLEMENTMONTH);
		}else{//������Ա
			this.setTitle(PageLoction.MAG_SETTLEMENTMONTH);
		}
		//��ȡ��Ʒ����
//		Map c =(Map)rewardAdSucService.getDictitemRestype();
//		this.setDictItem(c);
		
		//Ĭ�ϲ�ѯ�ϸ��µ�����
		 SimpleDateFormat format = new SimpleDateFormat("yyyyMM"); 
		 Calendar objCalendar = Calendar.getInstance(); 
		 objCalendar.add(Calendar.MONTH, -1); 
		 format.format(objCalendar.getTime());
		((SettlementMonthQueryParameter)this.getParameter()).setRwmon(format.format(objCalendar.getTime()));
		return SUCCESS; 
	}

	public String doAjax() {
		if(this.getLogMember().getIsnet()!=4){//����
			this.setTitle(PageLoction.SETTLEMENTMONTH);
		}else{//������Ա
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
	 * ��ñ�ͷ �������⣩
	 * 
	 * @return
	 */
	public List<ColumnSet> getsetCols() {
		List<ColumnSet> setCols = new ArrayList<ColumnSet>();
		setCols.add(new ColumnSet("oprmon", "ҵ�����·�"));
		setCols.add(new ColumnSet("rwmon", "����·�"));
		setCols.add(new ColumnSet("rwtypename", "�������"));
		setCols.add(new ColumnSet("imei", "�ն�IMEI"));
		setCols.add(new ColumnSet("comname", "��Ʒ����"));
		setCols.add(new ColumnSet("mainno", "��Ҫʹ�ú���"));
		setCols.add(new ColumnSet("bchksucc", "�Ƿ����ͨ��"));
		setCols.add(new ColumnSet("rwmoney", "ʵ�������"));
		setCols.add(new ColumnSet("failrsn", "����ʧ��ԭ��"));
		
		return setCols;
	}
	
	/**
	 * �ն˼Ƴ�ʧ����ϸ-����excel
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
		return "ҵ����ϸ����������ά�ȣ�";
	}
	
	//����excel�б�ͷ
	protected List<ExcelColumn> getExcelColumn(){
		List<ExcelColumn> Cols = new ArrayList<ExcelColumn>(); 
		Cols.add(new ExcelColumn("oprmon","ҵ�����·�",10)); 
		Cols.add(new ExcelColumn("rwmon","����·�",10));
		Cols.add(new ExcelColumn("rwtypename","�������",10));
		Cols.add(new ExcelColumn("imei","�ն�IMEI",10)); 
		Cols.add(new ExcelColumn("comname","��Ʒ����",10)); 
		Cols.add(new ExcelColumn("mainno","��Ҫʹ�ú���",10)); 
		Cols.add(new ExcelColumn("bchksucc","�Ƿ����ͨ��",10));  
		Cols.add(new ExcelColumn("rwmoney","ʵ�������",10)); 
		Cols.add(new ExcelColumn("failrsn","����ʧ��ԭ��",10));  
		
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
	 * ��ȡ�������
	 * @return
	 */
//	public Map getDictItem() {
//		Map t = new LinkedHashMap();
//		t.put("", "");
//		t.putAll(dictItem);
//		return t;
//	}
}
