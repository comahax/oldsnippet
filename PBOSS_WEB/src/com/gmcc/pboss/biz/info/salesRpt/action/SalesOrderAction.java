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

	//��Ʒ�����ѯ
	private DictItemService dictItemService;
	/**
	 * ������Ϣ��ѯ
	 */
	private SalesRptService orderDtlService;
	
	/**
	 * ��ͨƽ̨Serverice
	 */
	private CommunicatePlateauService communicatePlateauService;
	
	/**
	 * ϵͳ������ѯ
	 */
	private IbGlSysparamService ibGlSysparamService;
	
	private Map dictItem;
	private String _backURL;
	
	/**
	 * ����ID��ֻ����ϸҳ����ʹ��
	 */
	private String orderid;
	/**
	 * ��ϸҳ�� ֻ����ϸҳ����ʹ��
	 */
	private FxSwOrder orderDtl;
	/**
	 * ������Ʒ���� ֻ����ϸҳ����ʹ��
	 */
	private List comcates;
	/**
	 * ������Դ��ϸ ֻ����ϸҳ����ʹ��
	 */
	private List resdets;
	
	/**
	 * �����Ƿ��ȷ��״̬
	 */
	private boolean waitCon = false;
	
	/**
	 * ����ID
	 */
	private Long advId;
	
	public QueryParameter getParameter() {

		parameter = parameter == null ? new SalesOrderQueryParameter() : parameter;
		// parameter.setStartMonth("200905");
		// parameter.setEndMonth("200908");
		// ����ҳ��
		if (this.getPageNo() != null)
			parameter.setNo(getPageNo().intValue());// ����ҳ��
		if (this.getPageSize() != null)
			parameter.setSize(getPageSize().intValue());// ���ô�С
		LoginMember member = getMember();

		parameter.setWayid(member.getWayid());
		
		//��Զ���״̬���Σ����ö���״̬Ϊ�̶�ѡ�����ɡ�
		//���IE�汾����IE6�����Բ���Ҫ����4�д���
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

	//ϵͳ������ѯ����
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
	 * ��ȡ����״̬
	 * @return
	 */
	public Map getOrderstate() {
		Map t = new LinkedHashMap();	
		//ʵ�ַ���1�����ص�Map�а������ж���״̬ѡ�ͨ��JSP�еĽű����ε�����Ҫ��ʾ������
		/** �ű���δʵ�֣���ʱѡ�÷���2 */
		//t.put("", "��ѡ��");
		//Map orderState = Constant.getConstantsMap(CodeReverseKey.ORDERFSTATE);
		//t.putAll(orderState);
		
		//ʵ�ַ���2������ϵͳ�������������������ز�ͬMap
		/**��ѯϵͳ������ȷ���Ƿ���ʾ����״̬����ȫ��ѡ��*/
		String systemParam = this.ibGlSysparamService.getSysValue(4, "pboss_Web");
		if(systemParam!=null && systemParam.equals("1")){
			t.put("FINISHED", "�����");
		}
		else{
			t.put("", "��ѡ��");
			Map orderState = Constant.getConstantsMap(CodeReverseKey.ORDERFSTATE);
			t.putAll(orderState);
		}
		//System.out.println(t.toString());
		return t;
	}
	
	public String doQuery() {
		
		LoginMember member = getMember();
		ServiceResult result = service.transact(member, getParameter(), ServiceType.QUERY);
		// ��дJSON
		this.writeJSONServicePage(result, getsetCols());
		
		return null;
	}
	
	public String doList() {
		this.setTitle(PageLoction.SalesOrder);//��Ʒ������ʷ��ѯ
		//��ȡ��Ʒ����
		Map c =(Map)dictItemService.transact(this.getMember(), new DictItemQueryParameter(), ServiceType.QUERY).getRetObject();
		//(null, getParameter()).getRetObject();
		this.setDictItem(c);
		
		return super.doList();
	}//doList
		
	/**
	 * ��ϸҳ��
	 */
	public String doLoad() {
		this.setTitle(PageLoction.SalesOrderDtl);//��Ʒ������ʷ��ѯ
		this.parameter = new SalesOrderQueryParameter();
		this.parameter.setOrderid(orderid);
		this.parameter.setAdvId(advId);
		this.parameter.setOperation(SalesOperation.ORDER_DETAILS);
		
		ServiceResult result = service.transact(this.getMember(), parameter, ServiceType.INITIATE);
		if (result.isSuccess()){
			this.setOrderDtl((FxSwOrder) result.getRetObject());
			//�жϴ˶����Ƿ��ȷ��״̬
			if (ConstantsType.ORDERSTATE_WAITCON.equals(this.getOrderDtl().getOrderstate())){
				this.setWaitCon(true);
			}else{
				//�򿪴���ʱ���ж��������жϲ���"WAITCON"[��ȷ��]�Ļ��� ����ر�
				if (this.getAdvId()!=null) {
					//��װ����
					logger.info("��������ɣ��Զ��ر�!");
//					System.out.println("��������ɣ��Զ��ر�!");
					CommunicatePlateauParameter parm = new CommunicatePlateauParameter();
					parm.setOperation(CommunicatePlateauOperation.FINISH_PENDING_TASK);
					parm.setAdvinfoid(advId);//����ID
					parm.setEmployeeid(this.getMember().getEmployeeid());//��Ա
					
					this.communicatePlateauService.transactionProcessing(getMember(), parm, ServiceType.OTHER);
//					(getAdvId(), this.getMember().getEmployeeid());
				}
			}
			
			//�ֽ���ϸ
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
	 * ����ȷ��
	 * @return
	 */
	public String doCnfmOdr(){
		this.setTitle(PageLoction.SalesOrderDtl);//��Ʒ������ʷ��ѯ
		this.parameter = new SalesOrderQueryParameter();
		this.parameter.setOrderid(this.getOrderid());
		this.parameter.setAdvId(this.getAdvId());
		this.set_backURL(INDEX);
		//ִ�ж���ȷ��ҵ��
		try{
			ServiceResult result = service.transactionProcessing(this.getMember(), parameter, ServiceType.MODIFY);
			service.transact(this.getMember(), parameter, ServiceType.OTHER);
			this.setMessage(result.getMessage());
			return this.execute();
		}catch (TransactionProcessionException e){
			//ҵ���쳣
			this.setMessage(e.getMessage());
			return ERROR;
		}
		
	}//doCnfmOdr
	
	
	/**
	 * ��������
	 * @return
	 */
	public String doCancelOdr(){
		this.setTitle(PageLoction.SalesOrderDtl);//��Ʒ������ʷ��ѯ
		this.parameter = new SalesOrderQueryParameter();
		this.parameter.setOrderid(this.getOrderid());
		this.parameter.setAdvId(this.getAdvId());
		this.set_backURL(INDEX);
		//ִ�ж���ȷ��ҵ��
		try{
			ServiceResult result = service.transactionProcessing(this.getMember(), parameter, ServiceType.CANCEL);
			this.setMessage(result.getMessage());
			return this.execute();
		}catch (TransactionProcessionException e){
			//ҵ���쳣
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
		setCols.add(new ColumnSet("orderid", "�������"));
		setCols.add(new ColumnSet("orderstateName", "����״̬"));
		setCols.add(new ColumnSet("orderaveName", "����;��"));
		setCols.add(new ColumnSet("delitypeName", "�ͻ���ʽ"));
		setCols.add(new ColumnSet("paytypeName", "�ɷѷ�ʽ"));
		setCols.add(new ColumnSet("recamt", "Ӧ�����"));
		setCols.add(new ColumnSet("actamt", "�Ѹ����"));
		setCols.add(new ColumnSet("createtime", "��������ʱ��"));

		return setCols;
	}//getsetCols
	
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
		dtlParam.setOperation(SalesOperation.COMCATEKID_QUERY);
		
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
	public List getSetComcatesCols() {
		List setCols = new ArrayList();
		setCols.add(new ColumnSet("comcategoryName", "��Ʒ����"));
		setCols.add(new ColumnSet("orderamt", "��������"));
		setCols.add(new ColumnSet("unitprice", "��Ʒ����"));
		setCols.add(new ColumnSet("totalprice", "��Ʒ�ܼ�"));
		setCols.add(new ColumnSet("ordercomtypeName", "��ע"));

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
		dtlParam.setWayid(member.getWayid());
		dtlParam.setOrderid(this.getOrderid());
		dtlParam.setSelecType(ConstantsType.SALES_SELECTYPE_RESDETS);
		dtlParam.setOperation(SalesOperation.ORDERSOURCE_DETAILS);
		
		if (this.getPageNo() != null)
			dtlParam.setNo(getPageNo().intValue());// ����ҳ��
		if (this.getPageSize() != null)
			dtlParam.setSize(getPageSize().intValue());// ���ô�С
		
		ServiceResult result = this.orderDtlService.transact(member, dtlParam, ServiceType.QUERY);
		// ��дJSON
		this.writeJSONServicePage(result, getSetResdetsCols());
		
		return null;
	}

	public List getSetResdetsCols() {
		List setCols = new ArrayList();
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
