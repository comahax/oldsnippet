package com.gmcc.pboss.biz.info.salesRpt.service.impl;

import org.apache.log4j.Logger;
import org.springframework.orm.ObjectRetrievalFailureException;

import com.gmcc.pboss.biz.communi.service.CommunicatePlateauService;
import com.gmcc.pboss.biz.communi.support.CommunicatePlateauParameter;
import com.gmcc.pboss.biz.info.salesRpt.dao.OrderProceDao;
import com.gmcc.pboss.biz.info.salesRpt.service.SalesRptService;
import com.gmcc.pboss.biz.info.salesRpt.service.SalesrServiceRetCode;
import com.gmcc.pboss.biz.info.salesRpt.support.SalesOrderQueryParameter;
import com.gmcc.pboss.biz.info.salesRpt.support.processor.SalesOrderParameterProcessor;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.dictionary.ConstantsType;
import com.gmcc.pboss.common.log.Log;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.impl.QueryBaseServiceImpl;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.util.Assert;
import com.gmcc.pboss.model.sales.FxRuOrderproce;
import com.gmcc.pboss.model.sales.FxSwOrder;
import com.gmcc.pboss.service.WebSiteService;
import com.gmcc.pboss.service.result.RetResult;

public class SalesOrderServiceImpl extends QueryBaseServiceImpl implements SalesRptService {

	private OrderProceDao orderProceDao;
	private CommunicatePlateauService communicatePlateauService;

	private static Logger logger = Logger.getLogger(SalesOrderServiceImpl.class);
	/**
	 * Զ�̽ӿ�
	 */
	private WebSiteService httpWebRemote;
	
	public SalesOrderServiceImpl() {
		serviceName = "������Ϣ";
		serviceCode = ServiceCode.SALESORDER;
		isNeedLogin = true;

		setProcessor(new SalesOrderParameterProcessor());
	}

	/**
	 * ��ȡ����
	 */
	public ServiceResult initiate(LoginMember member, QueryParameter parameter) {
		// TODO Auto-generated method stub
		SalesOrderQueryParameter param = (SalesOrderQueryParameter)parameter;
		ServiceResult result = new ServiceResult();
		result.setSuccess(false);
		result.setRetCode(SalesrServiceRetCode.FAIL);
		
		//ID��֤
		Assert.notBlank(param.getOrderid(), SalesrServiceRetCode.ID_Empty, "ID�����ڣ�");
		
		try{
			FxSwOrder obj = (FxSwOrder) get(param.getOrderid());
			//��֤�û�Ȩ��
			Assert.isTrue(member.getWayid().equals(obj.getWayid()), SalesrServiceRetCode.WAY_FAIL, "ID����ȷ��");
			
//
//			//�жϴ˶����Ƿ��ȷ��״̬
//			if (!ConstantsType.ORDERSTATE_WAITCON.equals(obj.getOrderstate())){
//				//�򿪴���ʱ���ж��������жϲ���"WAITCON"[��ȷ��]�Ļ��� ����ر�
//				if (param.getAdvId()!=null) this.closePandingTask(param.getAdvId(), member.getEmployeeid());
//			}
			
			//��ѯ
			result.setRetObject(obj);
			
			result.setSuccess(true);
			result.setRetCode(SalesrServiceRetCode.SUCCESS);
		}catch(ObjectRetrievalFailureException e){
			//���󲻴����쳣
			result.setSuccess(false);
			result.setRetCode(SalesrServiceRetCode.INIT_FAIL);//5���������SALESORDER_5
		}
		
		return result;
	}

	/**
	 * ȷ�϶���ҵ������
	 * 
	 */
	@Override
	public ServiceResult modify(LoginMember member, QueryParameter parameter) {
		// TODO Auto-generated method stub
		SalesOrderQueryParameter param = (SalesOrderQueryParameter)parameter;
		ServiceResult result = new ServiceResult();
		result.setSuccess(false);
		result.setRetCode(SalesrServiceRetCode.FAIL);
		
		//ID��֤
		Assert.notBlank(param.getOrderid(), SalesrServiceRetCode.ID_Empty, "ID�����ڣ�");
		//��ȡ����
		FxSwOrder obj = (FxSwOrder) get(param.getOrderid());
		//��֤�û�Ȩ��
		Assert.isTrue(member.getWayid().equals(obj.getWayid()), SalesrServiceRetCode.WAY_FAIL, "����������������");
		
		//��鶩��״̬��FX_SW_ORDER.ORDERSTAT���Ƿ���ڡ�WAITCON������ȷ�ϣ�
		if (!ConstantsType.ORDERSTATE_WAITCON.equals(obj.getOrderstate())){
			return this.rtnCheckError(result, SalesrServiceRetCode.ORDERSTAT_ERROR);
		}
		
		//��[���̱��]��[���״̬] ��ȡ��ѯ�������̲����
		FxRuOrderproce proce = this.orderProceDao.getByFlowidInstate(obj.getFlowid(), ConstantsType.ORDERSTATE_WAITCON);
		
		//����������򷵻���ʾ���������̴�������ϵ����Ա������ֹ����
		if ((proce == null)){
			return this.rtnCheckError(result, SalesrServiceRetCode.ORDERSTAT_ERROR);
		}
		
		obj.setOrderstate(proce.getOutstate());
		//���Ƿ�ȷ���޸�Ϊ1���ǣ�
		obj.setConfirmflag(ConstantsType.Confirmflag_YES);
		
		this.getDao().update(obj);//���µ����ݿ�
		
//		//���á�������һ�������ӿڣ����жϴ�����
//		RetResult rmtRslt = httpWebRemote.doOrderNextProc(member.getWayid(), obj.getOrderid());
//		//��¼�ӿڵ������
//		logger.info("[��Ʒ����-������һ������]:"+ rmtRslt.getRetCode()+'('+ rmtRslt.getMessage() +')');
//		Log.remoteLog(serviceCode, serviceCode, "doOrderNextProc������һ������", 
//				member.getWayid()+"["+ obj.getOrderid() +"]", rmtRslt.getRetCode(),rmtRslt.getMessage());
		
		//�Ѷ�Ӧ�Ĵ�����Ϣ�޸�Ϊ�ر�״̬
		this.closePandingTask(param.getAdvId(),member.getEmployeeid());
		
		result.setRetObject(obj);
		result.setSuccess(true);
		result.setRetCode(SalesrServiceRetCode.ORDERCNFRM_SUCCESS);
		
		return result;
	}
	
	/**
	 * Զ�̶�����һ������
	 */
	public ServiceResult other(LoginMember member, QueryParameter parameter) {
		//���á�������һ�������ӿڣ����жϴ�����
		SalesOrderQueryParameter param = (SalesOrderQueryParameter)parameter;
		RetResult rmtRslt = httpWebRemote.doOrderNextProc(member.getWayid(), param.getOrderid());
		//��¼�ӿڵ������
		logger.info("[��Ʒ����-������һ������]:"+ rmtRslt.getRetCode()+'('+ rmtRslt.getMessage() +')');
		Log.remoteLog(serviceCode, serviceCode, "doOrderNextProc������һ������", 
				member.getWayid()+"["+ param.getOrderid() +"]", rmtRslt.getRetCode(),rmtRslt.getMessage());
		ServiceResult result = new ServiceResult();
		result.setSuccess(true);
		result.setRetCode(SalesrServiceRetCode.ORDERCNFRM_SUCCESS);
		return result;
	}

	/**
	 * ��������ҵ������
	 * */
	@Override
	public ServiceResult cancel(LoginMember member, QueryParameter parameter) {
		// TODO Auto-generated method stub		// TODO Auto-generated method stub
		SalesOrderQueryParameter param = (SalesOrderQueryParameter)parameter;
		ServiceResult result = new ServiceResult();
		result.setSuccess(false);
		result.setRetCode(SalesrServiceRetCode.FAIL);
		
		//ID��֤
		Assert.notBlank(param.getOrderid(), SalesrServiceRetCode.ID_Empty, "ID�����ڣ�");
		//��ȡ����
		FxSwOrder obj = (FxSwOrder) get(param.getOrderid());
		//��֤�û�Ȩ��
		Assert.isTrue(member.getWayid().equals(obj.getWayid()), SalesrServiceRetCode.WAY_FAIL, "����������������");
		
		//��鶩��״̬��FX_SW_ORDER.ORDERSTAT���Ƿ���ڡ�WAITCON������ȷ�ϣ�
		if (!ConstantsType.ORDERSTATE_WAITCON.equals(obj.getOrderstate())){
			return this.rtnCheckError(result, SalesrServiceRetCode.ORDERSTAT_ERROR);
		}
		
		//�޸Ķ������е��Ƿ�ȷ��Ϊ0���񣩡�����״̬Ϊ��CANCEL�������ϣ�����עΪ��������������ͬʱ�ǼǶ�����־��
		obj.setOrderstate(ConstantsType.ORDERSTATE_CANCEL);
		obj.setConfirmflag(ConstantsType.Confirmflag_NO);
		obj.setMemo("��������");
		this.getDao().update(obj);//���µ����ݿ�

		
		//�Ѷ�Ӧ�Ĵ�����Ϣ�޸�Ϊ�ر�״̬
		this.closePandingTask(param.getAdvId(),member.getEmployeeid());
		
		result.setSuccess(true);
		result.setRetCode(SalesrServiceRetCode.ORDERCANCEL_SUCCESS);
		
		return result;
	}
	
	private void closePandingTask(Long advinfoid,String employeeid){
		if (advinfoid == null) return;
		CommunicatePlateauParameter param = new CommunicatePlateauParameter();
		param.setAdvinfoid(advinfoid);
		param.setEmployeeid(employeeid);
		communicatePlateauService.finishPendingTask(param);
	}
	/**
	 * ͳһ�жϷ�����
	 */
	private ServiceResult rtnCheckError(ServiceResult rtn,int rtnCode){
//		rtn.setMessage(message);
		rtn.setRetCode(rtnCode);
		return rtn;
	}
	/**
	 * @return the orderProceDao
	 */
	public OrderProceDao getOrderProceDao() {
		return orderProceDao;
	}

	/**
	 * @param orderProceDao the orderProceDao to set
	 */
	public void setOrderProceDao(OrderProceDao orderProceDao) {
		this.orderProceDao = orderProceDao;
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

	/**
	 * @return the httpWebRemote
	 */
	public WebSiteService getHttpWebRemote() {
		return httpWebRemote;
	}

	/**
	 * @param httpWebRemote the httpWebRemote to set
	 */
	public void setHttpWebRemote(WebSiteService httpWebRemote) {
		this.httpWebRemote = httpWebRemote;
	}

	
	
}
