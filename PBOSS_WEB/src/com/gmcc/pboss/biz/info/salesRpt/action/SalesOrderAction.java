package com.gmcc.pboss.biz.info.salesRpt.action;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import com.gmcc.pboss.biz.basic.dictItem.service.DictItemService;
import com.gmcc.pboss.biz.basic.dictItem.support.DictItemQueryParameter;
import com.gmcc.pboss.biz.communi.service.CommunicatePlateauOperation;
import com.gmcc.pboss.biz.communi.service.CommunicatePlateauService;
import com.gmcc.pboss.biz.communi.support.CommunicatePlateauParameter;
import com.gmcc.pboss.biz.info.salesRpt.service.SalesOperation;
import com.gmcc.pboss.biz.info.salesRpt.service.SalesRptService;
import com.gmcc.pboss.biz.info.salesRpt.support.OrderDtlQueryParameter;
import com.gmcc.pboss.biz.info.salesRpt.support.SalesOrderQueryParameter;
import com.gmcc.pboss.common.action.AbstractAction;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.constant.Constant;
import com.gmcc.pboss.common.dictionary.CodeReverseKey;
import com.gmcc.pboss.common.dictionary.ConstantsType;
import com.gmcc.pboss.common.dictionary.PageLoction;
import com.gmcc.pboss.common.exception.TransactionProcessionException;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceType;
import com.gmcc.pboss.common.support.ColumnSet;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.model.sales.FxSwOrder;
import com.gmcc.pboss.biz.basic.goods.service.IbGlSysparamService;

public class SalesOrderAction extends AbstractAction {

	private SalesOrderQueryParameter parameter;

	private SalesRptService service;

	//商品种类查询
	private DictItemService dictItemService;
	/**
	 * 订单信息查询
	 */
	private SalesRptService orderDtlService;
	
	/**
	 * 沟通平台Serverice
	 */
	private CommunicatePlateauService communicatePlateauService;
	
	/**
	 * 系统参数查询
	 */
	private IbGlSysparamService ibGlSysparamService;
	
	private Map dictItem;
	private String _backURL;
	
	/**
	 * 订单ID，只在明细页面中使用
	 */
	private String orderid;
	/**
	 * 明细页面 只在明细页面中使用
	 */
	private FxSwOrder orderDtl;
	/**
	 * 订购商品种类 只在明细页面中使用
	 */
	private List comcates;
	/**
	 * 订购资源明细 只在明细页面中使用
	 */
	private List resdets;
	
	/**
	 * 订单是否待确认状态
	 */
	private boolean waitCon = false;
	
	/**
	 * 待办ID
	 */
	private Long advId;
	
	public QueryParameter getParameter() {

		parameter = parameter == null ? new SalesOrderQueryParameter() : parameter;
		// parameter.setStartMonth("200905");
		// parameter.setEndMonth("200908");
		// 设置页码
		if (this.getPageNo() != null)
			parameter.setNo(getPageNo().intValue());// 设置页码
		if (this.getPageSize() != null)
			parameter.setSize(getPageSize().intValue());// 设置大小
		LoginMember member = getMember();

		parameter.setWayid(member.getWayid());
		
		//针对订单状态屏蔽，设置订单状态为固定选项“已完成”
		//如果IE版本高于IE6，可以不需要下面4行代码
		String systemParam = this.ibGlSysparamService.getSysValue(4, "pboss_Web");
		if(systemParam!=null && systemParam.equals("1")){
			parameter.setOrderstate("FINISHED");
		}
		
		return parameter;
	}

	/**
	 * @param parameter the parameter to set
	 */
	public void setParameter(SalesOrderQueryParameter parameter) {
		this.parameter = parameter;
	}

	/**
	 * @return the service
	 */
	public SalesRptService getService() {
		return service;
	}

	/**
	 * @param service the service to set
	 */
	public void setService(SalesRptService service) {
		this.service = service;
	}

	/**
	 * @return the dictItemService
	 */
	public DictItemService getDictItemService() {
		return dictItemService;
	}

	/**
	 * @param dictItemService the dictItemService to set
	 */
	public void setDictItemService(DictItemService dictItemService) {
		this.dictItemService = dictItemService;
	}

	/**
	 * @param dictItem the dictItem to set
	 */
	public void setDictItem(Map dictItem) {
		this.dictItem = dictItem;
	}

	/**
	 * @return the orderid
	 */
	public String getOrderid() {
		return orderid;
	}

	/**
	 * @param orderid the orderid to set
	 */
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	/**
	 * @return the orderDtl
	 */
	public FxSwOrder getOrderDtl() {
		return orderDtl;
	}

	/**
	 * @param orderDtl the orderDtl to set
	 */
	public void setOrderDtl(FxSwOrder orderDtl) {
		this.orderDtl = orderDtl;
	}

	//系统参数查询服务
	public IbGlSysparamService getIbGlSysparamService(){
		return this.ibGlSysparamService;
	}
	public void setIbGlSysparamService(IbGlSysparamService ibGlSysparamService){
		this.ibGlSysparamService = ibGlSysparamService;
	}
	
	/**
	 * @return the _backURL
	 */
	public String get_backURL() {
		return _backURL;
	}

	/**
	 * @param _backurl the _backURL to set
	 */
	public void set_backURL(String _backurl) {
		_backURL = _backurl;
	}

	/**
	 * @return the comcates
	 */
	public List getComcates() {
		return comcates;
	}

	/**
	 * @param comcates the comcates to set
	 */
	public void setComcates(List comcates) {
		this.comcates = comcates;
	}

	/**
	 * @return the resdets
	 */
	public List getResdets() {
		return resdets;
	}

	/**
	 * @param resdets the resdets to set
	 */
	public void setResdets(List resdets) {
		this.resdets = resdets;
	}

	/**
	 * @return the orderDtlService
	 */
	public SalesRptService getOrderDtlService() {
		return orderDtlService;
	}

	/**
	 * @param orderDtlService the orderDtlService to set
	 */
	public void setOrderDtlService(SalesRptService orderDtlService) {
		this.orderDtlService = orderDtlService;
	}

	public void prepare() throws Exception {

	}
	/**
	 * 提取订单状态
	 * @return
	 */
	public Map getOrderstate() {
		Map t = new LinkedHashMap();	
		//实现方法1：返回的Map中包含所有订单状态选项，通过JSP中的脚本屏蔽掉不需要显示的内容
		/** 脚本尚未实现，暂时选用方法2 */
		//t.put("", "请选择");
		//Map orderState = Constant.getConstantsMap(CodeReverseKey.ORDERFSTATE);
		//t.putAll(orderState);
		
		//实现方法2：根据系统参数表限制条件，返回不同Map
		/**查询系统参数表，确定是否显示订单状态栏的全部选项*/
		String systemParam = this.ibGlSysparamService.getSysValue(4, "pboss_Web");
		if(systemParam!=null && systemParam.equals("1")){
			t.put("FINISHED", "已完成");
		}
		else{
			t.put("", "请选择");
			Map orderState = Constant.getConstantsMap(CodeReverseKey.ORDERFSTATE);
			t.putAll(orderState);
		}
		//System.out.println(t.toString());
		return t;
	}
	
	public String doQuery() {
		
		LoginMember member = getMember();
		ServiceResult result = service.transact(member, getParameter(), ServiceType.QUERY);
		// 回写JSON
		this.writeJSONServicePage(result, getsetCols());
		
		return null;
	}
	
	public String doList() {
		this.setTitle(PageLoction.SalesOrder);//商品订购历史查询
		//提取商品类型
		Map c =(Map)dictItemService.transact(this.getMember(), new DictItemQueryParameter(), ServiceType.QUERY).getRetObject();
		//(null, getParameter()).getRetObject();
		this.setDictItem(c);
		
		return super.doList();
	}//doList
		
	/**
	 * 明细页面
	 */
	public String doLoad() {
		this.setTitle(PageLoction.SalesOrderDtl);//商品订购历史查询
		this.parameter = new SalesOrderQueryParameter();
		this.parameter.setOrderid(orderid);
		this.parameter.setAdvId(advId);
		this.parameter.setOperation(SalesOperation.ORDER_DETAILS);
		
		ServiceResult result = service.transact(this.getMember(), parameter, ServiceType.INITIATE);
		if (result.isSuccess()){
			this.setOrderDtl((FxSwOrder) result.getRetObject());
			//判断此订单是否待确认状态
			if (ConstantsType.ORDERSTATE_WAITCON.equals(this.getOrderDtl().getOrderstate())){
				this.setWaitCon(true);
			}else{
				//打开待办时，判断若订单判断不是"WAITCON"[待确认]的话， 待办关闭
				if (this.getAdvId()!=null) {
					//封装参数
					logger.info("待办已完成，自动关闭!");
//					System.out.println("待办已完成，自动关闭!");
					CommunicatePlateauParameter parm = new CommunicatePlateauParameter();
					parm.setOperation(CommunicatePlateauOperation.FINISH_PENDING_TASK);
					parm.setAdvinfoid(advId);//待办ID
					parm.setEmployeeid(this.getMember().getEmployeeid());//人员
					
					this.communicatePlateauService.transactionProcessing(getMember(), parm, ServiceType.OTHER);
//					(getAdvId(), this.getMember().getEmployeeid());
				}
			}
			
			//分解明细
//			if (orderDtl.getComcates().size()>0){
//				this.setComcates(new ArrayList(orderDtl.getComcates()));
//			}
//			if (orderDtl.getResdets().size()>0){
//				this.setResdets(new ArrayList(orderDtl.getResdets()));
//			}
			return this.execute();
		}else{
			this.setMessage(result.getMessage());
//			this.set_backURL("/salesOrder/query.do");
			return ERROR;
		}
	}//doLoad
	

	/**
	 * 订购确认
	 * @return
	 */
	public String doCnfmOdr(){
		this.setTitle(PageLoction.SalesOrderDtl);//商品订购历史查询
		this.parameter = new SalesOrderQueryParameter();
		this.parameter.setOrderid(this.getOrderid());
		this.parameter.setAdvId(this.getAdvId());
		this.set_backURL(INDEX);
		//执行订购确认业务
		try{
			ServiceResult result = service.transactionProcessing(this.getMember(), parameter, ServiceType.MODIFY);
			service.transact(this.getMember(), parameter, ServiceType.OTHER);
			this.setMessage(result.getMessage());
			return this.execute();
		}catch (TransactionProcessionException e){
			//业务异常
			this.setMessage(e.getMessage());
			return ERROR;
		}
		
	}//doCnfmOdr
	
	
	/**
	 * 放弃订购
	 * @return
	 */
	public String doCancelOdr(){
		this.setTitle(PageLoction.SalesOrderDtl);//商品订购历史查询
		this.parameter = new SalesOrderQueryParameter();
		this.parameter.setOrderid(this.getOrderid());
		this.parameter.setAdvId(this.getAdvId());
		this.set_backURL(INDEX);
		//执行订购确认业务
		try{
			ServiceResult result = service.transactionProcessing(this.getMember(), parameter, ServiceType.CANCEL);
			this.setMessage(result.getMessage());
			return this.execute();
		}catch (TransactionProcessionException e){
			//业务异常
			this.setMessage(e.getMessage());
			return ERROR;
		}
	}//doCancelOdr
	
	public String getWayname(){
		LoginMember member = this.getMember();
		return member.getChannel().getWayname();
	}
	public List getsetCols() {
		List setCols = new ArrayList();
		setCols.add(new ColumnSet("orderid", "订单编号"));
		setCols.add(new ColumnSet("orderstateName", "订单状态"));
		setCols.add(new ColumnSet("orderaveName", "订购途径"));
		setCols.add(new ColumnSet("delitypeName", "送货方式"));
		setCols.add(new ColumnSet("paytypeName", "缴费方式"));
		setCols.add(new ColumnSet("recamt", "应付金额"));
		setCols.add(new ColumnSet("actamt", "已付金额"));
		setCols.add(new ColumnSet("createtime", "订单生成时间"));

		return setCols;
	}//getsetCols
	
	/**
	 *  AJAX加载订购商品种类Comcates列表
	 * @return
	 */
	public String doComcateQuery() {
		
		LoginMember member = getMember();
		OrderDtlQueryParameter dtlParam = new OrderDtlQueryParameter();
		dtlParam.setWayid(member.getWayid());
		dtlParam.setOrderid(this.getOrderid());
		dtlParam.setSelecType(ConstantsType.SALES_SELECTYPE_COMCATE);
		dtlParam.setOperation(SalesOperation.COMCATEKID_QUERY);
		
		if (this.getPageNo() != null)
			dtlParam.setNo(getPageNo().intValue());// 设置页码
		if (this.getPageSize() != null)
			dtlParam.setSize(getPageSize().intValue());// 设置大小
		
		ServiceResult result = this.orderDtlService.transact(member, dtlParam, ServiceType.QUERY);
		// 回写JSON
		this.writeJSONServicePage(result, getSetComcatesCols());
		
		return null;
	}
	/**
	 * 订购商品种类显示信息 Comcates列表
	 * @return
	 */
	public List getSetComcatesCols() {
		List setCols = new ArrayList();
		setCols.add(new ColumnSet("comcategoryName", "商品类型"));
		setCols.add(new ColumnSet("orderamt", "订购数量"));
		setCols.add(new ColumnSet("unitprice", "商品单价"));
		setCols.add(new ColumnSet("totalprice", "商品总价"));
		setCols.add(new ColumnSet("ordercomtypeName", "备注"));

		return setCols;
	}//getsetCols

	/**
	 * 返回订购商品种类页面显示的效果
	 * 
	 * @return the colSet
	 */
	public String getShowComcatesCols() {

		return JSONArray.fromObject(getSetComcatesCols()).toString();
	}
	

	/**
	 *	ajax 订购资源明细 Resdets
	 * @return
	 */
	public String doResdetsQuery(){

		LoginMember member = getMember();
		OrderDtlQueryParameter dtlParam = new OrderDtlQueryParameter();
		dtlParam.setWayid(member.getWayid());
		dtlParam.setOrderid(this.getOrderid());
		dtlParam.setSelecType(ConstantsType.SALES_SELECTYPE_RESDETS);
		dtlParam.setOperation(SalesOperation.ORDERSOURCE_DETAILS);
		
		if (this.getPageNo() != null)
			dtlParam.setNo(getPageNo().intValue());// 设置页码
		if (this.getPageSize() != null)
			dtlParam.setSize(getPageSize().intValue());// 设置大小
		
		ServiceResult result = this.orderDtlService.transact(member, dtlParam, ServiceType.QUERY);
		// 回写JSON
		this.writeJSONServicePage(result, getSetResdetsCols());
		
		return null;
	}

	public List getSetResdetsCols() {
		List setCols = new ArrayList();
		setCols.add(new ColumnSet("comcategoryName", "商品类型"));
		setCols.add(new ColumnSet("comresid", "套卡/充值卡号码"));
		setCols.add(new ColumnSet("boxnum", "所属包号"));

		return setCols;
	}//getsetCols

	/**
	 * 返回订购商品种类页面显示的效果
	 * 
	 * @return the colSet
	 */
	public String getShowResdetsCols() {

		return JSONArray.fromObject(getSetResdetsCols()).toString();
	}

	/**
	 * @return the advId
	 */
	public Long getAdvId() {
		return advId;
	}

	/**
	 * @param advId the advId to set
	 */
	public void setAdvId(Long advId) {
		this.advId = advId;
	}

	/**
	 * @return the waitCon
	 */
	public boolean isWaitCon() {
		return waitCon;
	}

	/**
	 * @param waitCon the waitCon to set
	 */
	public void setWaitCon(boolean waitCon) {
		this.waitCon = waitCon;
	}

	/**
	 * @return the communicatePlateauService
	 */
	public CommunicatePlateauService getCommunicatePlateauService() {
		return communicatePlateauService;
	}

	/**
	 * @param communicatePlateauService the communicatePlateauService to set
	 */
	public void setCommunicatePlateauService(
			CommunicatePlateauService communicatePlateauService) {
		this.communicatePlateauService = communicatePlateauService;
	}
	


}
