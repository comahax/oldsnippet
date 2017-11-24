package com.gmcc.pboss.biz.info.reward.action;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;

import com.gmcc.pboss.biz.info.reward.service.RewardService;
import com.gmcc.pboss.biz.info.reward.support.RewardQueryParameter;
import com.gmcc.pboss.common.action.AbstractAction;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.dictionary.PageLoction;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceType;
import com.gmcc.pboss.common.support.ColumnSet;
import com.gmcc.pboss.common.support.ExcelColumn;
import com.gmcc.pboss.common.support.QueryAction;
import com.gmcc.pboss.common.support.QueryParameter;

public class RewardRecordAction extends AbstractAction {

	private RewardQueryParameter parameter;

	private RewardService service;

	public QueryParameter getParameter() {

		parameter = parameter == null ? new RewardQueryParameter() : parameter;
		// ����ҳ��
		if (this.getPageNo() != null)
			parameter.setNo(getPageNo().intValue());// ����ҳ��
		if (this.getPageSize() != null)
			parameter.setSize(getPageSize().intValue());// ���ô�С

		LoginMember member = getMember();
		parameter.setWayid(member.getWayid());

		return parameter;
	}

	public void setParameter(RewardQueryParameter parameter) {
		this.parameter = parameter;
	}

	public RewardService getService() {
		return service;
	}

	public void setService(RewardService service) {
		this.service = service;
	}

	public void prepare() throws Exception {

	}

	public List getsetCols() {

		List setCols = new ArrayList();
		// ColumnSet colset = new ColumnSet("id","ID");
		// setCols.add(new ColumnSet("operseq", "ҵ����ˮ"));
//		setCols.add(new ColumnSet("opnid", "ҵ�����"));
		setCols.add(new ColumnSet("opnname", "ҵ������"));
		setCols.add(new ColumnSet("mobile", "�ֻ�����"));
		// setCols.add(new ColumnSet("wayid", "������ʶ"));
//		setCols.add(new ColumnSet("slv", "�Ǽ�"));
		setCols.add(new ColumnSet("rewardtypeName", "�������"));
		setCols.add(new ColumnSet("rewardmonth", "�����·�"));
		// setCols.add(new ColumnSet("mobile", "ҵ��������"));
		setCols.add(new ColumnSet("acctypeName", "�Ƴ귽ʽ"));
		setCols.add(new ColumnSet("rewardstd", "����׼"));
		setCols.add(new ColumnSet("totalsum", "������"));
		setCols.add(new ColumnSet("assegrade", "����ϵ��"));
		setCols.add(new ColumnSet("paysum", "Ӧ�����"));
		setCols.add(new ColumnSet("runtime", "����ʱ��"));
		//setCols.add(new ColumnSet("opermobile", "��Ա�ֻ�����"));
		return setCols;
	}

	/**
	 * ����ҳ����ʾ��Ч��
	 * 
	 * @return the colSet
	 */
	public String getShowCols() {

		return JSONArray.fromObject(getsetCols()).toString();
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
	 * 
	 * @see com.gmcc.pboss.common.action.AbstractAction#doList()
	 */
	public String doList() {
		// TODO Auto-generated method stub
		this.setTitle(PageLoction.RewardRecordList);
		return super.doList();
	}
	
	public String doExportExcel(){
		LoginMember member = getMember();
		QueryParameter param = getParameter();
		param.setAction(QueryAction.ALL);
		ServiceResult result = service.transact(member, param, ServiceType.QUERY);
		if(result.isSuccess()){
			exportExcel(result.getRetResult().getData());
		}
		return null;
		
	}
	
	protected String[][] beforeWrite() {
//		return new String[][]{
//				new String[]{"aaa","bbb"},
//				new String[]{"ccc","ddd"}
//			};
		return super.beforeWrite();
	}
	@Override
	protected String[][] afterWrite() {
//		return new String[][]{
//				new String[]{"aaa","bbb"},
//				new String[]{"ccc","ddd"}
//			};
		return super.afterWrite();
	}

	@Override
	protected String getExcelTitle() {
		return "�����ϸ��ѯ";
	}
	
	protected List<ExcelColumn> getExcelColumn(){
		List<ExcelColumn> cols = new ArrayList<ExcelColumn>();
		cols.add(new ExcelColumn("opnname","ҵ������",10));
		cols.add(new ExcelColumn("mobile", "�ֻ�����",10));
		cols.add(new ExcelColumn("rewardtypeName", "�������",10));
		cols.add(new ExcelColumn("rewardmonth", "�����·�",10));
		cols.add(new ExcelColumn("acctypeName", "�Ƴ귽ʽ",10));
		cols.add(new ExcelColumn("rewardstd", "����׼",10));
		cols.add(new ExcelColumn("totalsum", "������",10));
		cols.add(new ExcelColumn("assegrade", "����ϵ��",10));
		cols.add(new ExcelColumn("paysum", "Ӧ�����",10));
		cols.add(new ExcelColumn("runtime", "����ʱ��",10));
		return cols;
	}
}
