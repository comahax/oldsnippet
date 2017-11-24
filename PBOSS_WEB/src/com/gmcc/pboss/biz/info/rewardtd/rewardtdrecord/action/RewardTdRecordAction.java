package com.gmcc.pboss.biz.info.rewardtd.rewardtdrecord.action;

import java.util.ArrayList;
import java.util.List;
import net.sf.json.JSONArray;
import com.gmcc.pboss.biz.info.rewardtd.rewardtdrecord.service.RewardTdRecordService;
import com.gmcc.pboss.biz.info.rewardtd.rewardtdrecord.support.RewardTdRecordQueryParameter;
import com.gmcc.pboss.common.action.AbstractAction;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.dictionary.PageLoction;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceType;
import com.gmcc.pboss.common.support.ColumnSet;
import com.gmcc.pboss.common.support.ExcelColumn;
import com.gmcc.pboss.common.support.QueryAction;
import com.gmcc.pboss.common.support.QueryParameter;

public class RewardTdRecordAction extends AbstractAction {

	private QueryParameter parameter;
	private List retlist;
	private RewardTdRecordService rewardTdRecordService;

	public QueryParameter getParameter() {
		// TODO Auto-generated method stub
		parameter = parameter == null ? new RewardTdRecordQueryParameter()
				: parameter;
		// ����ҳ�룬������ϸ��ѯʱʹ�ã�ͳ�ƻ��ܲ�ʹ��
		if (this.getPageNo() != null)
			parameter.setNo(getPageNo().intValue());// ����ҳ��
		if (this.getPageSize() != null)
			parameter.setSize(getPageSize().intValue());// ���ô�С
		LoginMember logMem = this.getMember();
		if (logMem.getIsnet() == 1) {// ����ֻ�����ѯ��������Ϣ
			((RewardTdRecordQueryParameter) parameter).setWayid(logMem
					.getWayid());
		}

		return parameter;
	}

	public void prepare() throws Exception {
		// TODO Auto-generated method stub 
	}

	 

	public String doStat() {
		 this.setTitle(PageLoction.REWARDTD_SUC_DATA);  
		return SUCCESS;
		 
	}
 

       //��̬��ȡ���б�������	
	public String doAjax() {
		ServiceResult result = isLogin();
		if (result.isSuccess())
			result = this.rewardTdRecordService.transact(getMember(),
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
		setCols.add(new ColumnSet("name", "ҵ������"));
		setCols.add(new ColumnSet("rewardtype", "�������"));
		setCols.add(new ColumnSet("oprtime", "ҵ����ʱ��"));
		setCols.add(new ColumnSet("rewardmonth", "�����·�"));
		setCols.add(new ColumnSet("paysum", "Ӧ�����"));
		return setCols;
	}
	
	/**
	 * �ն˼Ƴ�ɹ����ݻ���-����excel
	 * @return
	 */
	public String doExcelExport(){
		LoginMember member = getMember();
		QueryParameter param = getParameter();
		param.setAction(QueryAction.ALL);
		ServiceResult result = this.rewardTdRecordService.transact(member, param,ServiceType.OTHER);
		if (result.isSuccess() && result.getRetResult() != null
				&& result.getRetResult().getData() != null
				&& result.getRetResult().getData().size() > 0) {
			exportExcel(result.getRetResult().getData());
		}
		return null;
	}  
	
	protected String getExcelTitle() {
		return "�ն˼Ƴ�ɹ����ݻ���";
	}
	
	protected List<ExcelColumn> getExcelColumn(){
		List<ExcelColumn> Cols = new ArrayList<ExcelColumn>(); 
		Cols.add(new ExcelColumn("name","ҵ������",10)); 
		Cols.add(new ExcelColumn("rewardtype","�������",10));
		Cols.add(new ExcelColumn("oprtime","ҵ����ʱ��",10));
		Cols.add(new ExcelColumn("rewardmonth","�����·�",10));
		Cols.add(new ExcelColumn("paysum","Ӧ�����",10)); 
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

	public RewardTdRecordService getRewardTdRecordService() {
		return rewardTdRecordService;
	}

	public void setRewardTdRecordService(
			RewardTdRecordService rewardTdRecordService) {
		this.rewardTdRecordService = rewardTdRecordService;
	}

}
