package com.gmcc.pboss.biz.info.reward.action;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.gmcc.pboss.biz.info.reward.service.RewardService;
import com.gmcc.pboss.biz.info.reward.support.BbcRewardQueryParameter;
import com.gmcc.pboss.biz.info.reward.support.RewardKind;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.constant.Constant;
import com.gmcc.pboss.common.dictionary.ConstantsType;
import com.gmcc.pboss.common.dictionary.PageLoction;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceType;
import com.gmcc.pboss.common.support.ColumnSet;
import com.gmcc.pboss.common.support.ExcelColumn;
import com.gmcc.pboss.common.support.QueryAction;
import com.gmcc.pboss.common.support.QueryParameter;

public class BbcRewardRecordAction extends RewardRecordAction {

	private RewardService service;

	private BbcRewardQueryParameter parameter;
	
	//������ࣺB2M-2,UNPB-3
	private int wayType;
	public int getWayType() {
		return wayType;
	}
	public void setWayType(int wayType) {
		this.wayType = wayType;
	}


	public QueryParameter getParameter() {

		parameter = parameter == null ? new BbcRewardQueryParameter() : parameter;
		// ����ҳ��
		if (this.getPageNo() != null)
			parameter.setNo(getPageNo().intValue());// ����ҳ��
		if (this.getPageSize() != null)
			parameter.setSize(getPageSize().intValue());// ���ô�С

		LoginMember member = getMember();
		parameter.setWayid(member.getWayid());
		if(wayType==2){
			parameter.setRewardKind(RewardKind.B2M);
		}
		else if(wayType==3){//wayType.equals("UNPB")
			parameter.setRewardKind(RewardKind.UNPB);
		}

		return parameter;
	}


	public List getsetCols() {

		List setCols = new ArrayList();
		// ColumnSet colset = new ColumnSet("id","ID");
		// setCols.add(new ColumnSet("operseq", "ҵ����ˮ"));
		setCols.add(new ColumnSet("opnid", "ҵ�����"));
		setCols.add(new ColumnSet("opnname", "ҵ������"));
		//setCols.add(new ColumnSet("wayid","way.shortname", "��������",""));
		//setCols.add(new ColumnSet("slv","way.starlevel", "�Ǽ�",""));
		setCols.add(new ColumnSet("rewardstd", "����׼"));
		setCols.add(new ColumnSet("rewardtypeName", "�������"));
		setCols.add(new ColumnSet("rewardmonth", "�����·�"));
		// setCols.add(new ColumnSet("mobile", "ҵ��������"));
//		setCols.add(new ColumnSet("acctype", "�Ƴ귽ʽ"));
		setCols.add(new ColumnSet("totalsum", "������"));
//		setCols.add(new ColumnSet("assegrade", "����ϵ��"));
//		setCols.add(new ColumnSet("paysum", "Ӧ�����"));
		setCols.add(new ColumnSet("runtime", "����ʱ��"));
//		setCols.add(new ColumnSet("opermobile", "��Ա�ֻ�����"));
		return setCols;
	}
	/* (non-Javadoc)
	 * @see com.gmcc.pboss.common.action.AbstractAction#doList()
	 */
	public String doList() {
		// TODO Auto-generated method stub
		this.setTitle(PageLoction.BbcRewardRecordList);
		return super.execute();
	}

	public String doQuery() {

		LoginMember member = getMember();
		// ������ѯ
		
		ServiceResult result = service.transact(member, getParameter(), ServiceType.QUERY);
		// ��дJSON
		this.writeJSONServicePage(result, getsetCols());

		return null;
	}
	/*
	 * (non-Javadoc)
	 * @see com.gmcc.pboss.biz.info.reward.action.RewardRecordAction#doBbcExportExcel()
	 */
	public String doBbcExportExcel(){
		LoginMember member = getMember();
		QueryParameter param = getParameter();
		param.setAction(QueryAction.ALL);
		ServiceResult result = service.transact(member, param, ServiceType.QUERY);
		if(result.isSuccess()){
			exportExcel(result.getRetResult().getData());
		}
		return null;
		
	}
	
	/**
	 * ���ص���Excel�ļ�������
	 */
	protected String getExcelTitle(){
	  String flag="";
		if(wayType==2){
		  flag= "B2M�����ϸ�嵥";
		}
		if(wayType==3){
		  flag= "�������˳����ϸ�嵥";
		}
		return flag;
	}
	/**
	 * ���ص���excel���е���Ϣ
	 * @return
	 */
	protected List<ExcelColumn> getExcelColumn(){
		List<ExcelColumn> cols = new ArrayList<ExcelColumn>();
		cols.add(new ExcelColumn("opnid","ҵ�����",10));
		cols.add(new ExcelColumn("opnname", "ҵ������",15));
		cols.add(new ExcelColumn("rewardstd", "����׼",10));
		cols.add(new ExcelColumn("rewardtypeName", "�������",20));
		cols.add(new ExcelColumn("rewardmonth", "�����·�",10));
		cols.add(new ExcelColumn("totalsum", "������",10));
		cols.add(new ExcelColumn("runtime", "����ʱ��",10)); 
		return cols;
	}
	
	/**
	 * @return the service
	 */
	public RewardService getService() {
		return service;
	}

	/**
	 * @param service the service to set
	 */
	public void setService(RewardService service) {
		this.service = service;
	}
	public Map getRewareType(){
		Map rtn = new LinkedHashMap();
//		rtn.put("", "��ѡ��");
		Map consMap = Constant.getConstantsMap(ConstantsType.BBC_REWARD_TPYPE);
		if (consMap!=null) rtn.putAll(consMap);
		return rtn;
		
	}
}
