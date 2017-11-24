package com.gmcc.pboss.biz.info.delivery.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import net.sf.json.JSONArray;
import com.gmcc.pboss.biz.basic.dictItem.service.DictItemService;
import com.gmcc.pboss.biz.info.delivery.service.DeliveryService;
import com.gmcc.pboss.biz.info.delivery.support.DeliveryQueryParameter;
import com.gmcc.pboss.biz.info.salesRpt.service.SalesRptService;
import com.gmcc.pboss.biz.info.salesRpt.support.OrderDtlQueryParameter;
import com.gmcc.pboss.common.action.AbstractAction;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.constant.Constant;
import com.gmcc.pboss.common.constant.service.ConstantService;
import com.gmcc.pboss.common.dictionary.CodeReverseKey;
import com.gmcc.pboss.common.dictionary.ConstantsType;
import com.gmcc.pboss.common.dictionary.HttpDictionary;
import com.gmcc.pboss.common.dictionary.PageLoction;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceType;
import com.gmcc.pboss.common.support.ColumnSet;
import com.gmcc.pboss.common.support.ExcelColumn;
import com.gmcc.pboss.common.support.QueryAction;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.member.service.IDelayLoadService;
import com.gmcc.pboss.model.constant.ChPwCntycompany;
import com.gmcc.pboss.model.delivery.FxSwDisform;
import com.gmcc.pboss.model.sales.FxSwOrdercomcate;

/**
 * 配送商管理
 * @author yuwenjun
 *
 */
public class DeliveryAction extends AbstractAction {

	private DeliveryQueryParameter parameter;

	private DeliveryService service;
	/**
	 * 固定参数Service
	 */
	private ConstantService constantService;
	//商品种类查询
	private DictItemService dictItemService;
	private SalesRptService salesOrderService;
	/**
	 * 订单信息查询
	 */
	private SalesRptService orderDtlService;
	
	private String _backURL;
	
	/**
	 * 订单ID，只在明细页面中使用
	 */
	private String orderid;
	/**
	 * 配送单ID，只在明细页面中使用
	 */
	private String recid;
	/**
	 * 明细页面 只在明细页面中使用
	 */
	private FxSwDisform orderDtl;
	/**
	 * 订购商品种类 只在明细页面中使用
	 */
	private List<FxSwOrdercomcate> comcates;
	
	private final String selValue = ConstantsType.DISSTATE_WAITDIS;
	/**
	 * 订单状态
	 */
	private Map<String,String> orderState;
	
	/**
	 * 延迟加载部分登录信息：合作商资料、上级渠道经理、菜单栏
	 */
	private IDelayLoadService delayLoadService;
	
	public QueryParameter getParameter() {

		parameter = parameter == null ? new DeliveryQueryParameter() : parameter;
		// parameter.setStartMonth("200905");
		// parameter.setEndMonth("200908");
		// 设置页码
		if (this.getPageNo() != null)
			parameter.setNo(getPageNo().intValue());// 设置页码
		if (this.getPageSize() != null)
			parameter.setSize(getPageSize().intValue());// 设置大小
		LoginMember member = getMember();

		parameter.setWayid(member.getWayid());

		return parameter;
	}

	/**
	 * @param parameter the parameter to set
	 */
	public void setParameter(DeliveryQueryParameter parameter) {
		this.parameter = parameter;
	}


	/**
	 * @return the service
	 */
	public DeliveryService getService() {
		return service;
	}

	/**
	 * @param service the service to set
	 */
	public void setService(DeliveryService service) {
		this.service = service;
	}

	/**
	 * @return the salesOrderService
	 */
	public SalesRptService getSalesOrderService() {
		return salesOrderService;
	}

	/**
	 * @param salesOrderService the salesOrderService to set
	 */
	public void setSalesOrderService(SalesRptService salesOrderService) {
		this.salesOrderService = salesOrderService;
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
	public FxSwDisform getOrderDtl() {
		return orderDtl;
	}

	/**
	 * @param orderDtl the orderDtl to set
	 */
	public void setOrderDtl(FxSwDisform orderDtl) {
		this.orderDtl = orderDtl;
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
	public String doQuery() throws ParseException {
		ServiceResult result = new ServiceResult();
		Calendar calendar = Calendar.getInstance();
		int YEAR = calendar.get(Calendar.YEAR);
		int MONTH = calendar.get(Calendar.MONTH) + 1;
		if (MONTH >= 1 && MONTH <= 3) {
			String dateStr = (YEAR - 1) + "-10-01";
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
			if (parameter.getStartDate().before(date)) {
				result.setSuccess(false);
				result.setMessage("不能查询去年10月前的数据！");
				this.writeJSONServicePage(result, getsetCols());
				return null;
			}
		} else {
			String dateStr = YEAR + "-01-01";
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
			if (parameter.getStartDate().before(date)) {
				result.setSuccess(false);
				result.setMessage("不能查询今年1月份前的数据！");
				this.writeJSONServicePage(result, getsetCols());
				return null;
			}
		}

		LoginMember member = getMember();
		result = service.transact(member, getParameter(), ServiceType.QUERY);
		// 回写JSON
		this.writeJSONServicePage(result, getsetCols());
		
		return null;
	}
	
	public String doExportExcel(){
		LoginMember member = getMember();
		QueryParameter param = getParameter();
		param.setAction(QueryAction.ALL);
		ServiceResult result = service.transact(member, param,ServiceType.QUERY);
		
		if (result.isSuccess() && result.getRetResult() != null
				&& result.getRetResult().getData() != null
				&& result.getRetResult().getData().size() > 0) {
			exportExcel(result.getRetResult().getData());
		}
		return null;
	}
	
	/**
	 * 批量修改状态
	 * @return
	 */
	public String doModify(){
		LoginMember member = getMember();
		DeliveryQueryParameter parm = (DeliveryQueryParameter)getParameter();
		ServiceResult result = null;
		if(parm.getModlogi()){//修改物流单号
			String logi = parm.getLogisticsno();
			if(logi.length() != logi.getBytes().length){//含非字母、数字字符，如中文
				result = new ServiceResult();
				result.setSuccess(false);
				result.setMessage("物流单号只能包含字母和数字");
				
				// 回写JSON
				this.writeJSONServiceData(result);
				return null;
			}			
		}
		
		try{
			result = service.transactionProcessing(member, parm, ServiceType.MODIFY);
		}catch(Exception e){
			result = new ServiceResult();
			result.setSuccess(false);
			result.setMessage(e.getMessage());
		}
		
		// 回写JSON
		this.writeJSONServiceData(result);
		return null;
	}
	
	/**
	 * 列表页面 
	 */
	public String doList() {
		LoginMember member = this.getMember();
		if( !member.isInfoloaded()){//待延迟加载的信息尚未加载，加载这些信息
			member = this.delayLoadService.fillMember(member);
			//获取菜单项
			Map<String,ArrayList> menuMap = member.getMenuMap();
	 		this.getSession().setAttribute("menuMap", menuMap);//将菜单信息放入session中
	 		member.setMenuMap(null);//避免在session中放置2次
	 		this.getSession().setAttribute(HttpDictionary.USER_NAME, member);
		}
		
		this.setTitle(PageLoction.DeliveryQuery);//商品订购历史查询
		this.orderState = Constant.getConstantsMap(CodeReverseKey.DISSTATE);
		//去掉配送中状态
		orderState.remove(ConstantsType.DISSTATE_WAITOUT);
		
		parameter = parameter == null ? new DeliveryQueryParameter() : parameter;
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DATE, 1);
		parameter.setStartDate(calendar.getTime());
		calendar.roll(Calendar.DATE, -1);
		parameter.setEndDate(calendar.getTime());
		
		return super.doList();
	}//doList
	/**
	 * 提取订单状态
	 * @return
	 */
	public Map<String,String> getDisstate() {
		Map<String,String> t = new LinkedHashMap<String,String>();
		t.put("", "请选择");
		t.putAll(orderState);
		return t;
	}
	
	/**
	 * 提取缴费方式
	 * @return
	 */
	public Map<String,String> getPayType() {
		Map<String, String> payType = Constant.getConstantsMap(CodeReverseKey.PAYTYPE);
		
		Map<String,String> t = new LinkedHashMap<String,String>();
		t.put("", "请选择");
		t.putAll(payType);
		return t;
	}
	/**
	 * 提取修改的订单状态
	 * @return
	 */
	public Map<String,String> getMdyDisstate() {
		return orderState;
	}

	/**
	 * 配送单分公司信息加载
	 * @return
	 */
	public Map<String,String> getCntyComd() {
		//提取当然登录用户信息
		LoginMember member = this.getMember();
		LinkedHashMap<String, String> rtn = new LinkedHashMap<String, String>();

		rtn.put("", "请选择");
		
		Map<String, ChPwCntycompany> map = this.constantService.getBranchCntyComps(member.getCityid());
		
		//分公司信息不存在时，直接返回原来的MAP
		if (map == null) return rtn;
		//遍历Map
		Iterator<String> allKey = map.keySet().iterator();
		while (allKey.hasNext()){
			String key = allKey.next();
			ChPwCntycompany value = map.get(key);
			rtn.put(key, value.getCountycompname());
		}
		return rtn;
	}
	/**
	 * 返回订购商品种类页面显示的效果
	 * 
	 * @return the colSet
	public String getNonShowDisstate() {
		Map map = ConfigUtil.getConstants(CodeReverseKey.CNNT_DISSTATE);
		
		return JSONArray.fromObject(map.keySet()).toString();
	}
	 */
	
	/**
	 * 明细页面
	 */
	public String doLoad() {
		LoginMember member = getMember();
		this.parameter = new DeliveryQueryParameter();
//		this.parameter.setOrderid(orderid);
		this.parameter.setRecid(this.getRecid());
		this.parameter.setWayid(member.getWayid());
		
		ServiceResult result = this.service.transact(this.getMember(), parameter, ServiceType.INITIATE);
		if (result.isSuccess()){
			this.setOrderDtl((FxSwDisform) result.getRetObject());
			String countyid = (String)getOrderDtl().getDatas().get("countyid");
			if(countyid!=null)
				getOrderDtl().getDatas().put("countyName", getCntyComd().get(countyid));
			//提取明细
			this.parameter.setOrderid(this.getOrderDtl().getOrderid());
			ServiceResult dtlResult = this.service.transact(getMember(), parameter, ServiceType.OTHER);
			if (dtlResult.isSuccess()){
				this.setComcates(dtlResult.getRetResult().getData());
			}
			return this.execute();
		}else{
			this.setMessage(result.getMessage());
//			this.set_backURL("/salesOrder/query.do");
			return ERROR;
		}
	}//doLoad
	public String getWayname(){
		LoginMember member = this.getMember();
		return member.getChannel().getWayname();
	}
	public List<ColumnSet> getsetCols() {
		List<ColumnSet> setCols = new ArrayList<ColumnSet>();
		setCols.add(new ColumnSet("sel", "<input type=\"checkbox\" id=\"selectCheck\" onclick=\"selectCheck()\">",true,"6%"));
		setCols.add(new ColumnSet("recid", "配送单号","9%"));
		setCols.add(new ColumnSet("orderid", "订单编号","9%"));
		setCols.add(new ColumnSet("datas.wayname", "收货网点","10%"));
		setCols.add(new ColumnSet("datasCountyName", "分公司","8%"));
		setCols.add(new ColumnSet("arrivetime", "要求到达时间","13%"));
		setCols.add(new ColumnSet("paytypeName", "缴费方式","10%"));
		setCols.add(new ColumnSet("signstateName", "签收状态","9%"));
//		setCols.add(new ColumnSet("recename", "收货人姓名"));
//		setCols.add(new ColumnSet("recetel", "收货人电话"));
		setCols.add(new ColumnSet("createtime", "建单时间","9%"));
		setCols.add(new ColumnSet("disstateName", "单状态","8%"));
		setCols.add(new ColumnSet("orderInfo", "订单信息"));
//		setCols.add(new ColumnSet("oper", "操作",true));
		setCols.add(new ColumnSet("disstate", "配送单状态",false,true));
//		要求到达时间、缴费方式、
		return setCols;
	}//getsetCols
	
	@Override
	protected List<ExcelColumn> getExcelColumn() {
		List<ExcelColumn> cols = new ArrayList<ExcelColumn>();
		cols.add(new ExcelColumn("recid","配送单号",10));
		cols.add(new ExcelColumn("orderid", "订单编号",15));
		cols.add(new ExcelColumn("datas.wayname", "收货网点",12));
		cols.add(new ExcelColumn("datasCountyName", "分公司",12));
		cols.add(new ExcelColumn("arrivetime", "要求到达时间",15,"yyyy-MM-dd HH:mm"));
		cols.add(new ExcelColumn("paytypeName", "缴费方式",10));
		cols.add(new ExcelColumn("signstateName", "签收状态",10));
		cols.add(new ExcelColumn("createtime", "建单时间",15,"yyyy-MM-dd HH:mm"));
		cols.add(new ExcelColumn("disstateName", "配送单状态",10));
		cols.add(new ExcelColumn("orderInfo", "订单信息",10));
		return cols;
	}
	
	@Override
	protected String getExcelTitle() {
		return "配送单";
	}
	
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
	public List<ColumnSet> getSetComcatesCols() {
		List<ColumnSet> setCols = new ArrayList<ColumnSet>();
		setCols.add(new ColumnSet("comcategoryName", "商品类型"));
		setCols.add(new ColumnSet("orderamt", "订购数量"));
		setCols.add(new ColumnSet("unitprice", "商品单价"));
		setCols.add(new ColumnSet("totalprice", "商品总价"));
		setCols.add(new ColumnSet("ordercomtype", "备注"));

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
//		dtlParam.setWayid(member.getWayid());
		dtlParam.setOrderid(this.getOrderid());
		dtlParam.setSelecType(ConstantsType.SALES_SELECTYPE_RESDETS);

		if (this.getPageNo() != null)
			dtlParam.setNo(getPageNo().intValue());// 设置页码
		if (this.getPageSize() != null)
			dtlParam.setSize(getPageSize().intValue());// 设置大小
		
		ServiceResult result = this.orderDtlService.transact(member, dtlParam, ServiceType.QUERY);
		// 回写JSON
		this.writeJSONServicePage(result, getSetResdetsCols());
		
		return null;
	}

	public List<ColumnSet> getSetResdetsCols() {
		List<ColumnSet> setCols = new ArrayList<ColumnSet>();
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
	 * @return the selValue
	 */
	public String getSelValue() {
		return selValue;
	}

	/**
	 * @return the recid
	 */
	public String getRecid() {
		return recid;
	}

	/**
	 * @param recid the recid to set
	 */
	public void setRecid(String recid) {
		this.recid = recid;
	}

	/**
	 * @return the comcates
	 */
	public List<FxSwOrdercomcate> getComcates() {
		return comcates;
	}

	/**
	 * @param comcates the comcates to set
	 */
	public void setComcates(List<FxSwOrdercomcate> comcates) {
		this.comcates = comcates;
	}

	/**
	 * @return the constantService
	 */
	public ConstantService getConstantService() {
		return constantService;
	}

	/**
	 * @param constantService the constantService to set
	 */
	public void setConstantService(ConstantService constantService) {
		this.constantService = constantService;
	}

	public void setDelayLoadService(IDelayLoadService delayLoadService) {
		this.delayLoadService = delayLoadService;
	}

}
