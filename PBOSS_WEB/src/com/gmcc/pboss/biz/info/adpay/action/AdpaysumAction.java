package com.gmcc.pboss.biz.info.adpay.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import org.apache.commons.lang.time.DateUtils;

import com.gmcc.pboss.biz.basic.dictItem.service.DictItemService;
import com.gmcc.pboss.biz.info.adpay.service.AdpaydtlService;
import com.gmcc.pboss.biz.info.adpay.service.AdpaysumService;
import com.gmcc.pboss.biz.info.adpay.support.AdpaydtlQueryParameter;
import com.gmcc.pboss.biz.info.adpay.support.AdpaysumQueryParameter;
import com.gmcc.pboss.common.action.AbstractAction;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.constant.Constant;
import com.gmcc.pboss.common.dictionary.CodeReverseKey;
import com.gmcc.pboss.common.dictionary.PageLoction;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceType;
import com.gmcc.pboss.common.support.ColumnSet;
import com.gmcc.pboss.common.support.ExcelColumn;
import com.gmcc.pboss.common.support.QueryAction;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.model.adpay.FxSwAdpaysum;

/**
 * ���ʶ�������Ա
 * 
 * @author yangwenshen
 * 
 */
public class AdpaysumAction extends AbstractAction {

	private AdpaysumQueryParameter parameter;

	private AdpaysumService service;
	
	private AdpaydtlService adpaydtlService;

	private DictItemService dictItemService;
	
	private FxSwAdpaysum adpaysum;
	
	private Long sumid;
	
	/**
	 * ���ʵ�״̬dropdown
	 * @return
	 */
	public Map getSumstate() {
		return Constant.getConstantsMap(CodeReverseKey.SUMSTATE);
	}

	public QueryParameter getParameter() {
		parameter = parameter == null ? new AdpaysumQueryParameter()
				: parameter;
		// ����ҳ��
		if (this.getPageNo() != null)
			parameter.setNo(getPageNo().intValue()
					);// ����ҳ��
		if (this.getPageSize() != null)
			parameter.setSize(getPageSize().intValue());// ���ô�С
		parameter.setDiscomcode(getMember().getWayid());
		return parameter;
	}

	/**
	 * ��ѯ���ʵ�
	 * @return
	 */
	public String doQuery() {
		LoginMember member = getMember();
		ServiceResult result = service.transact(member, getParameter(),
				ServiceType.QUERY);
		
		if (result.isSuccess() && result.getRetResult() != null
				&& result.getRetResult().getData() != null
				&& result.getRetResult().getData().size() > 0) {
			for (Iterator<FxSwAdpaysum> it = result.getRetResult().getData().iterator(); it.hasNext();) {
				FxSwAdpaysum adpaysum = it.next();
				adpaysum.setStrState(Constant.getConstantsMap(CodeReverseKey.SUMSTATE).get(adpaysum.getState()));
			}
		}
		// ��дJSON
		this.writeJSONServicePage(result, getsetCols());
		return null;
	}

	/**
	 * �б�ҳ��
	 */
	public String doList() {
		this.setTitle(PageLoction.AdpaysumQuery);
		Date d = new Date();
		parameter = new AdpaysumQueryParameter();
		parameter.setCreateTimeFrom(d);
		parameter.setCreateTimeTo(DateUtils.addDays(d, 3));
		parameter.setState("WAITSUBMIT");
		return super.doList();
	}
	
	/**
	 * �鵥����¼
	 */
	public String doLoad() {
		ServiceResult result = service.transact(getMember(), parameter, ServiceType.QUERY_ONE);
		if (result.isSuccess()){
			adpaysum = ((FxSwAdpaysum) result.getRetObject());
			if(adpaysum!=null&&adpaysum.getState()!=null){
				adpaysum.setStrState(Constant.getConstantsMap(CodeReverseKey.SUMSTATE).get(adpaysum.getState()));
			}
			return this.execute();
		}else{
			this.setMessage(result.getMessage());
			return ERROR;
		}
	}
	
	/**
	 * ���ʻ��ܵ��ύȷ��
	 * @return
	 */
	public String doSubmit(){
		LoginMember member = getMember();
		ServiceResult result = null;
		try{
			result = service.transactionProcessing(member, parameter, ServiceType.MODIFY);
		}catch(Exception e){
			e.printStackTrace();
			result = new ServiceResult();
			result.setSuccess(false);
			result.setMessage(e.getMessage());
		}
		// ��дJSON
		this.writeJSONServiceData(result);
		return null;
	}
	/**
	 * ajax��ѯ����
	 * @return
	 */
	public String doOrderDtl(){
		LoginMember member = getMember();
		
		AdpaydtlQueryParameter param = new AdpaydtlQueryParameter();
		
		if (this.getPageNo() != null)
			param.setNo(getPageNo().intValue());// ����ҳ��
		if (this.getPageSize() != null)
			param.setSize(getPageSize().intValue());// ���ô�С
		
		param.setSumid(getSumid());
		ServiceResult result = this.adpaydtlService.transact(member, param, ServiceType.QUERY);
		// ��дJSON
		this.writeJSONServicePage(result, getOrderDtlCols());
		return null;
	}
	/**
	 * ���ʻ��ܵ�����excel
	 * @return
	 */
	public String doExportExcel(){
		LoginMember member = getMember();
		QueryParameter param = getParameter();
		param.setAction(QueryAction.ALL);
		ServiceResult result = service.transact(member, param,ServiceType.QUERY);
		if (result.isSuccess() && result.getRetResult() != null
				&& result.getRetResult().getData() != null
				&& result.getRetResult().getData().size() > 0) {
			for (Iterator<FxSwAdpaysum> it = result.getRetResult().getData().iterator(); it.hasNext();) {
				FxSwAdpaysum adpaysum = it.next();
				adpaysum.setStrState(Constant.getConstantsMap(CodeReverseKey.SUMSTATE).get(adpaysum.getState()));
			}
			exportExcel(result.getRetResult().getData());
		}
		return null;
	}

	
	public List<ColumnSet> getsetCols() {
		List<ColumnSet> setCols = new ArrayList<ColumnSet>();
//		setCols.add(new ColumnSet("sumid", "���ܱ��"));
//		setCols.add(new ColumnSet("beginTime", "��ʼʱ��"));
//		setCols.add(new ColumnSet("endTime", "����ʱ��"));
//		setCols.add(new ColumnSet("submitTime", "�ύʱ��"));
//		setCols.add(new ColumnSet("submitCode", "�ύ��"));
//		setCols.add(new ColumnSet("orderAmt", "�������"));
//		setCols.add(new ColumnSet("state", "", false,true));
//		setCols.add(new ColumnSet("strState", "״̬"));
//		setCols.add(new ColumnSet("operation", "����", true));
		
		setCols.add(new ColumnSet("sumid", "���ܱ��"));
		setCols.add(new ColumnSet("beginTime", "��ʼʱ��"));
		setCols.add(new ColumnSet("endTime", "����ʱ��"));
		setCols.add(new ColumnSet("submitTime", "�ύʱ��"));
		setCols.add(new ColumnSet("confirmTime", "ȷ��ʱ��"));
		setCols.add(new ColumnSet("confirmCode", "ȷ����"));
		setCols.add(new ColumnSet("orderAmt", "�������"));
		setCols.add(new ColumnSet("state", "", false,true));
		setCols.add(new ColumnSet("strState", "״̬"));
		setCols.add(new ColumnSet("operation", "����", true));
		return setCols;
	}
	
	public List<ColumnSet> getOrderDtlCols(){
		List<ColumnSet> setCols = new ArrayList<ColumnSet>();
		setCols.add(new ColumnSet("orderid", "������"));
		setCols.add(new ColumnSet("datas.wayname", "������"));
		setCols.add(new ColumnSet("createtime", "����ʱ��"));
		setCols.add(new ColumnSet("recamt", "�������"));
		return setCols;
	}
	
	protected List<ExcelColumn> getExcelColumn(){
		List<ExcelColumn> cols = new ArrayList<ExcelColumn>();
		cols.add(new ExcelColumn("sumid","���ܱ��",10));
		cols.add(new ExcelColumn("beginTime", "��ʼʱ��",15,"yyyy-MM-dd HH:mm"));
		cols.add(new ExcelColumn("endTime", "����ʱ��",15,"yyyy-MM-dd HH:mm"));
		cols.add(new ExcelColumn("submitTime", "�ύʱ��",15,"yyyy-MM-dd HH:mm"));
		cols.add(new ExcelColumn("confirmTime", "ȷ��ʱ��",15,"yyyy-MM-dd HH:mm"));
		cols.add(new ExcelColumn("confirmCode", "ȷ����",10));
		cols.add(new ExcelColumn("orderAmt", "�������",10));
		cols.add(new ExcelColumn("strState", "״̬",10));
		return cols;
	}
	
	protected String getExcelTitle(){
		return "���ʻ��ܵ�";
	}
	
	public String getOrderdtlColsString(){
		return JSONArray.fromObject(getOrderDtlCols()).toString();	
	}

	public void prepare() throws Exception {

	}

	public AdpaysumService getService() {
		return service;
	}

	public void setService(AdpaysumService service) {
		this.service = service;
	}

	public void setParameter(AdpaysumQueryParameter parameter) {
		this.parameter = parameter;
	}

	public DictItemService getDictItemService() {
		return dictItemService;
	}

	public void setDictItemService(DictItemService dictItemService) {
		this.dictItemService = dictItemService;
	}

	public FxSwAdpaysum getAdpaysum() {
		return adpaysum;
	}

	public void setAdpaysum(FxSwAdpaysum adpaysum) {
		this.adpaysum = adpaysum;
	}

	public Long getSumid() {
		return sumid;
	}

	public void setSumid(Long sumid) {
		this.sumid = sumid;
	}

	public AdpaydtlService getAdpaydtlService() {
		return adpaydtlService;
	}

	public void setAdpaydtlService(AdpaydtlService adpaydtlService) {
		this.adpaydtlService = adpaydtlService;
	}

}
