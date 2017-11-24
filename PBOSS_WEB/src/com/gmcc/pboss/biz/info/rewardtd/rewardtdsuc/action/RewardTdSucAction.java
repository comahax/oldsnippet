package com.gmcc.pboss.biz.info.rewardtd.rewardtdsuc.action;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;

import com.gmcc.pboss.biz.info.rewardtd.rewardtdsuc.service.RewardTdSucService;
import com.gmcc.pboss.biz.info.rewardtd.rewardtdsuc.support.RewardTdSucQueryParameter;
import com.gmcc.pboss.common.action.AbstractAction;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.dictionary.PageLoction;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceType;
import com.gmcc.pboss.common.support.ColumnSet;
import com.gmcc.pboss.common.support.ExcelColumn;
import com.gmcc.pboss.common.support.QueryAction;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.SessionFactoryContextHolder;

public class RewardTdSucAction extends AbstractAction {

	private QueryParameter parameter;
	private List retlist;
	private RewardTdSucService  rewardTdSucService;

	public QueryParameter getParameter() {
		// TODO Auto-generated method stub
		parameter = parameter == null ? new RewardTdSucQueryParameter()
				: parameter;
		// ����ҳ�룬������ϸ��ѯʱʹ�ã�ͳ�ƻ��ܲ�ʹ��
		if (this.getPageNo() != null)
			parameter.setNo(getPageNo().intValue());// ����ҳ��
		if (this.getPageSize() != null)
			parameter.setSize(getPageSize().intValue());// ���ô�С
		LoginMember logMem = this.getMember();
		if (logMem.getIsnet() == 1) {// ����ֻ�����ѯ��������Ϣ
			((RewardTdSucQueryParameter) parameter).setWayid(logMem
					.getWayid());
		}

		return parameter;
	}

	public void prepare() throws Exception {
		// TODO Auto-generated method stub

	}
 

	public String doStat() {
		if(this.getLogMember().getIsnet()==5){//ʡ����Ա
			this.setTitle(PageLoction.GD_REWARDTD_SUC);
		}else if(this.getLogMember().getIsnet()==6){//�й���Ա
			this.setTitle(PageLoction.CITY_REWARDTD_SUC);
		}else{
			this.setTitle(PageLoction.REWARDTD_SUC); 
		}
		return SUCCESS;
	}

	public String doAjax() {
		ServiceResult result = isLogin();
		RewardTdSucQueryParameter param = (RewardTdSucQueryParameter) parameter; 
		if(this.getLogMember().getIsnet()==5){//ʡ����Ա
			this.setTitle(PageLoction.GD_REWARDTD_SUC);
			//�л�������
			SessionFactoryContextHolder.setSessionFactoryContext(null);
			//�л����п�
			SessionFactoryContextHolder.setSessionFactoryContext(param.getCity());
			if (result.isSuccess())
				result = this.rewardTdSucService.transact(getMember(),
						getParameter(), ServiceType.OTHER);
			
			
			this.writeJSONServicePage(result, getsetCols());
			
		}else if(this.getLogMember().getIsnet()==6){//�й���Ա
			this.setTitle(PageLoction.CITY_REWARDTD_SUC);
			
			if (result.isSuccess())
				result = this.rewardTdSucService.transact(getMember(),
						getParameter(), ServiceType.OTHER);
			this.writeJSONServicePage(result, getsetCols());
			
		}else{
			this.setTitle(PageLoction.REWARDTD_SUC); 
			if (result.isSuccess())
				result = this.rewardTdSucService.transact(getMember(),
						getParameter(), ServiceType.OTHER);
			this.writeJSONServicePage(result, getsetCols());
		}
		
		return null;
	}

	/**
	 * �ն˼Ƴ�ɹ���ϸ-����excel
	 * @return
	 */
	public String doExcelExport(){
		LoginMember member = getMember();
		QueryParameter param = getParameter();
		RewardTdSucQueryParameter param1 = (RewardTdSucQueryParameter) parameter; 
		param.setAction(QueryAction.ALL);
		if(this.getLogMember().getIsnet()==5){//ʡ����Ա
			//�л�������
			SessionFactoryContextHolder.setSessionFactoryContext(null);
			//�л����п�
			SessionFactoryContextHolder.setSessionFactoryContext(param1.getCity());
			
			ServiceResult result = this.rewardTdSucService.transact(member, param,ServiceType.OTHER);
			//�л�������
//			SessionFactoryContextHolder.setSessionFactoryContext(null);
			if (result.isSuccess() && result.getRetResult() != null
					&& result.getRetResult().getData() != null
					&& result.getRetResult().getData().size() > 0){
				exportExcel(result.getRetResult().getData());
			}
		}else{
			ServiceResult result = this.rewardTdSucService.transact(member, param,ServiceType.OTHER);
			if (result.isSuccess() && result.getRetResult() != null
					&& result.getRetResult().getData() != null
					&& result.getRetResult().getData().size() > 0) {
				exportExcel(result.getRetResult().getData());
			}
		}
		
		return null;
	}  
	
	/**
	 * ��ñ�ͷ �������⣩
	 * 
	 * @return
	 */
	public List<ColumnSet> getsetCols() {
		List<ColumnSet> setCols = new ArrayList<ColumnSet>();
		setCols.add(new ColumnSet("name", "ҵ������"));
		setCols.add(new ColumnSet("rewardtype", "�������"));
		setCols.add(new ColumnSet("comname", "��Ʒ����"));
		setCols.add(new ColumnSet("bakinfo", "�ն�IMEI"));
		setCols.add(new ColumnSet("mobile", "ҵ��������"));
		setCols.add(new ColumnSet("oprtime", "ҵ����ʱ��"));
		setCols.add(new ColumnSet("rewardmonth", "�����·�"));
		setCols.add(new ColumnSet("acctype", "�Ƴ귽ʽ"));
		setCols.add(new ColumnSet("rewardstd", "����׼"));
		setCols.add(new ColumnSet("paysum", "Ӧ�����"));
		setCols.add(new ColumnSet("assegrade", "�Ƴ����"));
		setCols.add(new ColumnSet("wrapfee", "��ŵ����"));
		setCols.add(new ColumnSet("assegrade2", "�ͼ�ֵռ��"));
		setCols.add(new ColumnSet("repairmonth", "������"));
		setCols.add(new ColumnSet("noncyc", "��������"));
		setCols.add(new ColumnSet("bakinfo7", "������"));
		setCols.add(new ColumnSet("bakinfo8", "ARPUֵ"));
		setCols.add(new ColumnSet("failreason", "�Ƴ���")); 
		return setCols;
	}  
	
	protected String getExcelTitle() {
		return "�ն˼Ƴ�ɹ�������ϸ";
	}
	
	//����excel�б�ͷ
	protected List<ExcelColumn> getExcelColumn(){
		List<ExcelColumn> Cols = new ArrayList<ExcelColumn>(); 
		Cols.add(new ExcelColumn("name","ҵ������",10)); 
		Cols.add(new ExcelColumn("rewardtype","�������",10));
		Cols.add(new ExcelColumn("comname","��Ʒ����",10));
		Cols.add(new ExcelColumn("bakinfo","�ն�IMEI",10));
		Cols.add(new ExcelColumn("mobile","ҵ��������",10)); 
		Cols.add(new ExcelColumn("oprtime","ҵ����ʱ��",10)); 
		Cols.add(new ExcelColumn("rewardmonth","�����·�",10)); 
		Cols.add(new ExcelColumn("acctype","�Ƴ귽ʽ",10));  
		Cols.add(new ExcelColumn("rewardstd","����׼",10)); 
		Cols.add(new ExcelColumn("paysum","Ӧ�����",10));  
		Cols.add(new ExcelColumn("assegrade","�Ƴ����",10));
		Cols.add(new ExcelColumn("wrapfee","��ŵ����",10));
		Cols.add(new ExcelColumn("assegrade2","�ͼ�ֵռ��",10)); 
		Cols.add(new ExcelColumn("repairmonth","������",10)); 
		Cols.add(new ExcelColumn("noncyc","��������",10)); 
		Cols.add(new ExcelColumn("bakinfo7","������",10));
		Cols.add(new ExcelColumn("bakinfo8","ARPUֵ",10));
		Cols.add(new ExcelColumn("failreason","�Ƴ���",10));  
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

	public RewardTdSucService getRewardTdSucService() {
		return rewardTdSucService;
	}

	public void setRewardTdSucService(RewardTdSucService rewardTdSucService) {
		this.rewardTdSucService = rewardTdSucService;
	} 

}
