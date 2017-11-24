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
 * 垫资订单管理员
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
	 * 垫资单状态dropdown
	 * @return
	 */
	public Map getSumstate() {
		return Constant.getConstantsMap(CodeReverseKey.SUMSTATE);
	}

	public QueryParameter getParameter() {
		parameter = parameter == null ? new AdpaysumQueryParameter()
				: parameter;
		// 设置页码
		if (this.getPageNo() != null)
			parameter.setNo(getPageNo().intValue()
					);// 设置页码
		if (this.getPageSize() != null)
			parameter.setSize(getPageSize().intValue());// 设置大小
		parameter.setDiscomcode(getMember().getWayid());
		return parameter;
	}

	/**
	 * 查询垫资单
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
		// 回写JSON
		this.writeJSONServicePage(result, getsetCols());
		return null;
	}

	/**
	 * 列表页面
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
	 * 查单条记录
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
	 * 垫资汇总单提交确认
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
		// 回写JSON
		this.writeJSONServiceData(result);
		return null;
	}
	/**
	 * ajax查询订单
	 * @return
	 */
	public String doOrderDtl(){
		LoginMember member = getMember();
		
		AdpaydtlQueryParameter param = new AdpaydtlQueryParameter();
		
		if (this.getPageNo() != null)
			param.setNo(getPageNo().intValue());// 设置页码
		if (this.getPageSize() != null)
			param.setSize(getPageSize().intValue());// 设置大小
		
		param.setSumid(getSumid());
		ServiceResult result = this.adpaydtlService.transact(member, param, ServiceType.QUERY);
		// 回写JSON
		this.writeJSONServicePage(result, getOrderDtlCols());
		return null;
	}
	/**
	 * 垫资汇总单导出excel
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
//		setCols.add(new ColumnSet("sumid", "汇总编号"));
//		setCols.add(new ColumnSet("beginTime", "开始时间"));
//		setCols.add(new ColumnSet("endTime", "结束时间"));
//		setCols.add(new ColumnSet("submitTime", "提交时间"));
//		setCols.add(new ColumnSet("submitCode", "提交人"));
//		setCols.add(new ColumnSet("orderAmt", "订单金额"));
//		setCols.add(new ColumnSet("state", "", false,true));
//		setCols.add(new ColumnSet("strState", "状态"));
//		setCols.add(new ColumnSet("operation", "操作", true));
		
		setCols.add(new ColumnSet("sumid", "汇总编号"));
		setCols.add(new ColumnSet("beginTime", "开始时间"));
		setCols.add(new ColumnSet("endTime", "结束时间"));
		setCols.add(new ColumnSet("submitTime", "提交时间"));
		setCols.add(new ColumnSet("confirmTime", "确认时间"));
		setCols.add(new ColumnSet("confirmCode", "确认人"));
		setCols.add(new ColumnSet("orderAmt", "订单金额"));
		setCols.add(new ColumnSet("state", "", false,true));
		setCols.add(new ColumnSet("strState", "状态"));
		setCols.add(new ColumnSet("operation", "操作", true));
		return setCols;
	}
	
	public List<ColumnSet> getOrderDtlCols(){
		List<ColumnSet> setCols = new ArrayList<ColumnSet>();
		setCols.add(new ColumnSet("orderid", "订单号"));
		setCols.add(new ColumnSet("datas.wayname", "合作商"));
		setCols.add(new ColumnSet("createtime", "订购时间"));
		setCols.add(new ColumnSet("recamt", "订购金额"));
		return setCols;
	}
	
	protected List<ExcelColumn> getExcelColumn(){
		List<ExcelColumn> cols = new ArrayList<ExcelColumn>();
		cols.add(new ExcelColumn("sumid","汇总编号",10));
		cols.add(new ExcelColumn("beginTime", "开始时间",15,"yyyy-MM-dd HH:mm"));
		cols.add(new ExcelColumn("endTime", "结束时间",15,"yyyy-MM-dd HH:mm"));
		cols.add(new ExcelColumn("submitTime", "提交时间",15,"yyyy-MM-dd HH:mm"));
		cols.add(new ExcelColumn("confirmTime", "确认时间",15,"yyyy-MM-dd HH:mm"));
		cols.add(new ExcelColumn("confirmCode", "确认人",10));
		cols.add(new ExcelColumn("orderAmt", "订单金额",10));
		cols.add(new ExcelColumn("strState", "状态",10));
		return cols;
	}
	
	protected String getExcelTitle(){
		return "垫资汇总单";
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
