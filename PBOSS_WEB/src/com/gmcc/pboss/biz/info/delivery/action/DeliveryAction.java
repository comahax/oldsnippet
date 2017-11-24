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
 * �����̹���
 * @author yuwenjun
 *
 */
public class DeliveryAction extends AbstractAction {

	private DeliveryQueryParameter parameter;

	private DeliveryService service;
	/**
	 * �̶�����Service
	 */
	private ConstantService constantService;
	//��Ʒ�����ѯ
	private DictItemService dictItemService;
	private SalesRptService salesOrderService;
	/**
	 * ������Ϣ��ѯ
	 */
	private SalesRptService orderDtlService;
	
	private String _backURL;
	
	/**
	 * ����ID��ֻ����ϸҳ����ʹ��
	 */
	private String orderid;
	/**
	 * ���͵�ID��ֻ����ϸҳ����ʹ��
	 */
	private String recid;
	/**
	 * ��ϸҳ�� ֻ����ϸҳ����ʹ��
	 */
	private FxSwDisform orderDtl;
	/**
	 * ������Ʒ���� ֻ����ϸҳ����ʹ��
	 */
	private List<FxSwOrdercomcate> comcates;
	
	private final String selValue = ConstantsType.DISSTATE_WAITDIS;
	/**
	 * ����״̬
	 */
	private Map<String,String> orderState;
	
	/**
	 * �ӳټ��ز��ֵ�¼��Ϣ�����������ϡ��ϼ����������˵���
	 */
	private IDelayLoadService delayLoadService;
	
	public QueryParameter getParameter() {

		parameter = parameter == null ? new DeliveryQueryParameter() : parameter;
		// parameter.setStartMonth("200905");
		// parameter.setEndMonth("200908");
		// ����ҳ��
		if (this.getPageNo() != null)
			parameter.setNo(getPageNo().intValue());// ����ҳ��
		if (this.getPageSize() != null)
			parameter.setSize(getPageSize().intValue());// ���ô�С
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
				result.setMessage("���ܲ�ѯȥ��10��ǰ�����ݣ�");
				this.writeJSONServicePage(result, getsetCols());
				return null;
			}
		} else {
			String dateStr = YEAR + "-01-01";
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
			if (parameter.getStartDate().before(date)) {
				result.setSuccess(false);
				result.setMessage("���ܲ�ѯ����1�·�ǰ�����ݣ�");
				this.writeJSONServicePage(result, getsetCols());
				return null;
			}
		}

		LoginMember member = getMember();
		result = service.transact(member, getParameter(), ServiceType.QUERY);
		// ��дJSON
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
	 * �����޸�״̬
	 * @return
	 */
	public String doModify(){
		LoginMember member = getMember();
		DeliveryQueryParameter parm = (DeliveryQueryParameter)getParameter();
		ServiceResult result = null;
		if(parm.getModlogi()){//�޸���������
			String logi = parm.getLogisticsno();
			if(logi.length() != logi.getBytes().length){//������ĸ�������ַ���������
				result = new ServiceResult();
				result.setSuccess(false);
				result.setMessage("��������ֻ�ܰ�����ĸ������");
				
				// ��дJSON
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
		
		// ��дJSON
		this.writeJSONServiceData(result);
		return null;
	}
	
	/**
	 * �б�ҳ�� 
	 */
	public String doList() {
		LoginMember member = this.getMember();
		if( !member.isInfoloaded()){//���ӳټ��ص���Ϣ��δ���أ�������Щ��Ϣ
			member = this.delayLoadService.fillMember(member);
			//��ȡ�˵���
			Map<String,ArrayList> menuMap = member.getMenuMap();
	 		this.getSession().setAttribute("menuMap", menuMap);//���˵���Ϣ����session��
	 		member.setMenuMap(null);//������session�з���2��
	 		this.getSession().setAttribute(HttpDictionary.USER_NAME, member);
		}
		
		this.setTitle(PageLoction.DeliveryQuery);//��Ʒ������ʷ��ѯ
		this.orderState = Constant.getConstantsMap(CodeReverseKey.DISSTATE);
		//ȥ��������״̬
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
	 * ��ȡ����״̬
	 * @return
	 */
	public Map<String,String> getDisstate() {
		Map<String,String> t = new LinkedHashMap<String,String>();
		t.put("", "��ѡ��");
		t.putAll(orderState);
		return t;
	}
	
	/**
	 * ��ȡ�ɷѷ�ʽ
	 * @return
	 */
	public Map<String,String> getPayType() {
		Map<String, String> payType = Constant.getConstantsMap(CodeReverseKey.PAYTYPE);
		
		Map<String,String> t = new LinkedHashMap<String,String>();
		t.put("", "��ѡ��");
		t.putAll(payType);
		return t;
	}
	/**
	 * ��ȡ�޸ĵĶ���״̬
	 * @return
	 */
	public Map<String,String> getMdyDisstate() {
		return orderState;
	}

	/**
	 * ���͵��ֹ�˾��Ϣ����
	 * @return
	 */
	public Map<String,String> getCntyComd() {
		//��ȡ��Ȼ��¼�û���Ϣ
		LoginMember member = this.getMember();
		LinkedHashMap<String, String> rtn = new LinkedHashMap<String, String>();

		rtn.put("", "��ѡ��");
		
		Map<String, ChPwCntycompany> map = this.constantService.getBranchCntyComps(member.getCityid());
		
		//�ֹ�˾��Ϣ������ʱ��ֱ�ӷ���ԭ����MAP
		if (map == null) return rtn;
		//����Map
		Iterator<String> allKey = map.keySet().iterator();
		while (allKey.hasNext()){
			String key = allKey.next();
			ChPwCntycompany value = map.get(key);
			rtn.put(key, value.getCountycompname());
		}
		return rtn;
	}
	/**
	 * ���ض�����Ʒ����ҳ����ʾ��Ч��
	 * 
	 * @return the colSet
	public String getNonShowDisstate() {
		Map map = ConfigUtil.getConstants(CodeReverseKey.CNNT_DISSTATE);
		
		return JSONArray.fromObject(map.keySet()).toString();
	}
	 */
	
	/**
	 * ��ϸҳ��
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
			//��ȡ��ϸ
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
		setCols.add(new ColumnSet("recid", "���͵���","9%"));
		setCols.add(new ColumnSet("orderid", "�������","9%"));
		setCols.add(new ColumnSet("datas.wayname", "�ջ�����","10%"));
		setCols.add(new ColumnSet("datasCountyName", "�ֹ�˾","8%"));
		setCols.add(new ColumnSet("arrivetime", "Ҫ�󵽴�ʱ��","13%"));
		setCols.add(new ColumnSet("paytypeName", "�ɷѷ�ʽ","10%"));
		setCols.add(new ColumnSet("signstateName", "ǩ��״̬","9%"));
//		setCols.add(new ColumnSet("recename", "�ջ�������"));
//		setCols.add(new ColumnSet("recetel", "�ջ��˵绰"));
		setCols.add(new ColumnSet("createtime", "����ʱ��","9%"));
		setCols.add(new ColumnSet("disstateName", "��״̬","8%"));
		setCols.add(new ColumnSet("orderInfo", "������Ϣ"));
//		setCols.add(new ColumnSet("oper", "����",true));
		setCols.add(new ColumnSet("disstate", "���͵�״̬",false,true));
//		Ҫ�󵽴�ʱ�䡢�ɷѷ�ʽ��
		return setCols;
	}//getsetCols
	
	@Override
	protected List<ExcelColumn> getExcelColumn() {
		List<ExcelColumn> cols = new ArrayList<ExcelColumn>();
		cols.add(new ExcelColumn("recid","���͵���",10));
		cols.add(new ExcelColumn("orderid", "�������",15));
		cols.add(new ExcelColumn("datas.wayname", "�ջ�����",12));
		cols.add(new ExcelColumn("datasCountyName", "�ֹ�˾",12));
		cols.add(new ExcelColumn("arrivetime", "Ҫ�󵽴�ʱ��",15,"yyyy-MM-dd HH:mm"));
		cols.add(new ExcelColumn("paytypeName", "�ɷѷ�ʽ",10));
		cols.add(new ExcelColumn("signstateName", "ǩ��״̬",10));
		cols.add(new ExcelColumn("createtime", "����ʱ��",15,"yyyy-MM-dd HH:mm"));
		cols.add(new ExcelColumn("disstateName", "���͵�״̬",10));
		cols.add(new ExcelColumn("orderInfo", "������Ϣ",10));
		return cols;
	}
	
	@Override
	protected String getExcelTitle() {
		return "���͵�";
	}
	
	/**
	 *  AJAX���ض�����Ʒ����Comcates�б�
	 * @return
	 */
	public String doComcateQuery() {
		
		LoginMember member = getMember();
		OrderDtlQueryParameter dtlParam = new OrderDtlQueryParameter();
		dtlParam.setWayid(member.getWayid());
		dtlParam.setOrderid(this.getOrderid());
		dtlParam.setSelecType(ConstantsType.SALES_SELECTYPE_COMCATE);

		if (this.getPageNo() != null)
			dtlParam.setNo(getPageNo().intValue());// ����ҳ��
		if (this.getPageSize() != null)
			dtlParam.setSize(getPageSize().intValue());// ���ô�С
		
		ServiceResult result = this.orderDtlService.transact(member, dtlParam, ServiceType.QUERY);
		// ��дJSON
		this.writeJSONServicePage(result, getSetComcatesCols());
		
		return null;
	}
	/**
	 * ������Ʒ������ʾ��Ϣ Comcates�б�
	 * @return
	 */
	public List<ColumnSet> getSetComcatesCols() {
		List<ColumnSet> setCols = new ArrayList<ColumnSet>();
		setCols.add(new ColumnSet("comcategoryName", "��Ʒ����"));
		setCols.add(new ColumnSet("orderamt", "��������"));
		setCols.add(new ColumnSet("unitprice", "��Ʒ����"));
		setCols.add(new ColumnSet("totalprice", "��Ʒ�ܼ�"));
		setCols.add(new ColumnSet("ordercomtype", "��ע"));

		return setCols;
	}//getsetCols

	/**
	 * ���ض�����Ʒ����ҳ����ʾ��Ч��
	 * 
	 * @return the colSet
	 */
	public String getShowComcatesCols() {

		return JSONArray.fromObject(getSetComcatesCols()).toString();
	}
	

	/**
	 *	ajax ������Դ��ϸ Resdets
	 * @return
	 */
	public String doResdetsQuery(){

		LoginMember member = getMember();
		OrderDtlQueryParameter dtlParam = new OrderDtlQueryParameter();
//		dtlParam.setWayid(member.getWayid());
		dtlParam.setOrderid(this.getOrderid());
		dtlParam.setSelecType(ConstantsType.SALES_SELECTYPE_RESDETS);

		if (this.getPageNo() != null)
			dtlParam.setNo(getPageNo().intValue());// ����ҳ��
		if (this.getPageSize() != null)
			dtlParam.setSize(getPageSize().intValue());// ���ô�С
		
		ServiceResult result = this.orderDtlService.transact(member, dtlParam, ServiceType.QUERY);
		// ��дJSON
		this.writeJSONServicePage(result, getSetResdetsCols());
		
		return null;
	}

	public List<ColumnSet> getSetResdetsCols() {
		List<ColumnSet> setCols = new ArrayList<ColumnSet>();
		setCols.add(new ColumnSet("comcategoryName", "��Ʒ����"));
		setCols.add(new ColumnSet("comresid", "�׿�/��ֵ������"));
		setCols.add(new ColumnSet("boxnum", "��������"));

		return setCols;
	}//getsetCols

	/**
	 * ���ض�����Ʒ����ҳ����ʾ��Ч��
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
