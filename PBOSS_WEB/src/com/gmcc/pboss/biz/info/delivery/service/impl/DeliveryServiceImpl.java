package com.gmcc.pboss.biz.info.delivery.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.orm.ObjectRetrievalFailureException;

import com.gmcc.pboss.biz.basic.goods.dao.IbGlSysparamDao;
import com.gmcc.pboss.biz.info.delivery.dao.ChSmsSmstmplDao;
import com.gmcc.pboss.biz.info.delivery.dao.ChSmsWaitreqDao;
import com.gmcc.pboss.biz.info.delivery.dao.DeliveryDao;
import com.gmcc.pboss.biz.info.delivery.dao.FxSwSmsconfirmDao;
import com.gmcc.pboss.biz.info.delivery.service.DeliveryService;
import com.gmcc.pboss.biz.info.delivery.support.DeliveryQueryParameter;
import com.gmcc.pboss.biz.info.delivery.support.processor.DeliveryParameterProcessor;
import com.gmcc.pboss.biz.info.salesRpt.service.SalesrServiceRetCode;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.constant.Constant;
import com.gmcc.pboss.common.dictionary.CodeReverseKey;
import com.gmcc.pboss.common.dictionary.ConstantsType;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.impl.QueryBaseServiceImpl;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryResult;
import com.gmcc.pboss.common.support.SessionFactoryContextHolder;
import com.gmcc.pboss.common.util.Assert;
import com.gmcc.pboss.common.util.DateUtil;
import com.gmcc.pboss.member.model.Employee;
import com.gmcc.pboss.model.constant.IbGlSysparam;
import com.gmcc.pboss.model.constant.IbGlSysparamId;
import com.gmcc.pboss.model.delivery.FxSwDisform;
import com.gmcc.pboss.model.sales.FxSwOrdercomcate;
import com.gmcc.pboss.model.sms.ChSmsSmstmpl;
import com.gmcc.pboss.model.sms.ChSmsWaitreq;
import com.gmcc.pboss.model.sms.FxSwSmsconfirm;
import com.gmcc.pboss.biz.info.salesRpt.dao.SalesOrderDao;
import com.gmcc.pboss.model.sales.FxSwOrder;

public class DeliveryServiceImpl extends QueryBaseServiceImpl implements DeliveryService {

	private static Logger logger = Logger.getLogger(DeliveryServiceImpl.class);
	public DeliveryServiceImpl() {
		serviceName = "�����̹���";
		serviceCode = ServiceCode.DELIVERY;
		isNeedLogin = true;

		setProcessor(new DeliveryParameterProcessor());
	}
	
	private FxSwSmsconfirmDao fxSwSmsconfirmDao;
	
	private IbGlSysparamDao ibGlSysparamDao;
	
	private ChSmsSmstmplDao chSmsSmstmplDao;
	
	private ChSmsWaitreqDao chSmsWaitreqDao;
	
	private SalesOrderDao salesOrderDao;
	
	/**
	 * ��ȡ����
	 */
	public ServiceResult initiate(LoginMember member, QueryParameter parameter) {
		// TODO Auto-generated method stub
		DeliveryQueryParameter param = (DeliveryQueryParameter)parameter;
		ServiceResult result = new ServiceResult();
		result.setSuccess(false);
		result.setRetCode(SalesrServiceRetCode.FAIL);
		DeliveryDao dao = (DeliveryDao) this.getDao();
		//ID��֤
		Assert.notBlank(param.getRecid(), SalesrServiceRetCode.ID_Empty, "ID�����ڣ�");
		
		try{
//			FxSwDisform obj = (FxSwDisform) get(param.getOrderid());
//			String propertyNames[] = new String[1];
//			String values[] = new String[1];
//			propertyNames[0] = "orderid";values[0]=param.getOrderid();
			FxSwDisform obj = (FxSwDisform) dao.getOne(this.getProcessor(), param);
			//ͨ��HQL��ȡVO����
//			this.getOne(propertyNames, values);
			//��֤�û�Ȩ��
			Assert.isTrue(member.getWayid().equals(obj.getDiscomcode()), SalesrServiceRetCode.AUTHOR_FAIL, "ID����ȷ��");
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

	/* (non-Javadoc)
	 * @see com.gmcc.pboss.common.service.impl.BaseServiceImpl#modify(com.gmcc.pboss.common.bean.LoginMember, com.gmcc.pboss.common.support.QueryParameter)
	 */
	public ServiceResult modify(LoginMember member, QueryParameter parameter) {
		DeliveryQueryParameter param = (DeliveryQueryParameter)parameter;
		if(param.getModlogi()){//20120328�������������š�
			return this.modigyLogs(member, parameter);
		}else{//20120328�޸�ǰ�����������͡���������߼�
			return this.modify1(member, parameter);
		}
	}//modify
	
	//�������͡��������
	private ServiceResult modify1(LoginMember member, QueryParameter parameter) {
		// TODO Auto-generated method stub
		DeliveryQueryParameter param = (DeliveryQueryParameter)parameter;
		ServiceResult result = new ServiceResult();
		result.setSuccess(false);
		result.setRetCode(SalesrServiceRetCode.FAIL);
		//�жϲ���
		Assert.notBlank(param.getRecids(), SalesrServiceRetCode.ID_Empty, "ID��ʧ!");
		Assert.notBlank(param.getDisstate(), SalesrServiceRetCode.State_Empty, "״̬������!");
		//��ȡ����
		Map cnntDisstate = Constant.getConstantsMap(CodeReverseKey.CNNT_DISSTATE);

		SessionFactoryContextHolder.setSessionFactoryContext(member.getCityid());
		
		//�ύ�޸��б�
		String[] recids = param.getRecids().split(",");
		if (recids.length < 1)	Assert.isTrue(false, SalesrServiceRetCode.ID_Empty, "ID��ʧ!");
		List saveList = new ArrayList();
		for (int i=0;i<recids.length;i++){
			Long id = null;
			try{
				id = new Long(recids[i]);
			}catch(Exception e){
				logger.error("DeliveryServiceImpl.modify[�޸�״̬IDת������]:"+e.getMessage());
			}
			if (id!=null){
				if(ConstantsType.DISSTATE_DISING.equals(param.getDisstate())){//�������Ͳ���
					try{
						FxSwDisform obj = (FxSwDisform) this.get(id);
						if (member.getWayid()!= null && member.getWayid().equals(obj.getDiscomcode())){
							if (!cnntDisstate.containsKey(obj.getDisstate())){
								//�޸�״̬:��״̬��"������"��Ϊ"������"
								obj.setDisstate(param.getDisstate());
								saveList.add(obj);							
							}//״̬�ж�
						}//Wayid �ж�
					}catch(Exception e){
						//���󲻴���
						logger.error("DeliveryServiceImpl.modify[���󲻴���(id:"+ id +")]:"+e.getMessage());
					}
				}else{//������Ͳ���
					FxSwDisform o = (FxSwDisform) this.get(id);
					if(ConstantsType.DISSTATE_WAITDIS.equals(o.getDisstate())||ConstantsType.DISSTATE_DISING.equals(o.getDisstate())){
						//��״̬�޸�Ϊ"�������"
						o.setDisstate(ConstantsType.DISSTATE_DISOVER);
						//�ǼǶ���ȷ�ϼ�¼
						FxSwSmsconfirm smsconfirm = new FxSwSmsconfirm();
						//����ȡ������ǩ��
						smsconfirm.setType(ConstantsType.FX_SMSCONTYPE_PARSIGN);
						//ȷ����ˮ��ȡ����ĩβ4λ
						smsconfirm.setStream(o.getOrderid().substring(o.getOrderid().length()-4));
						//�ֻ�����ȡ���͵��е��ջ��˵绰
						smsconfirm.setMobileno(o.getRecetel());
						//����������ȡ�������
						smsconfirm.setOrderid(o.getOrderid());
						//״̬ȡ���ظ�
						smsconfirm.setState(ConstantsType.FX_SMSREPSTATE_WAITREP);
						Date d = new Date();
						//֪ͨʱ��ȡ��ǰʱ��
						smsconfirm.setSendtime(d);
						fxSwSmsconfirmDao.save(smsconfirm);
						
						//֪ͨ������ǩ��
						ChSmsWaitreq smsWaitreq = new ChSmsWaitreq();
						//��������ȡ3
						smsWaitreq.setSmstype(new Long(3));
						//��ѯϵͳ�������ñ�IB_GL_SYSPARAM����ƥ���������Ϊ��pboss_fx����������ʶΪ��42�������ͺ���ȡ����ֵ
						IbGlSysparamId ibGlSysparamId = new IbGlSysparamId();
						ibGlSysparamId.setParamtype("pboss_fx");
						ibGlSysparamId.setSystemid(new Long(42));
						IbGlSysparam ibGlSysparam = (IbGlSysparam )ibGlSysparamDao.get(ibGlSysparamId);
						//���ͺ���
						smsWaitreq.setSendno(ibGlSysparam.getParamvalue());
						//ȡ���͵��е��ջ��˵绰
						smsWaitreq.setRecno(o.getRecetel());
						ChSmsSmstmpl chSmsSmstmpl = null;
						try {
							//������Ʒ�������Ź��÷�����������ǩ��ȷ�ϣ���ȡ���ͻ����ƻ�ȡ�߼���
							//���ݺ����̱����ѯ������Ա������Ϣ��CH_PW_EMPLOYEE����ƥ���Ƿ�Ϊ�����ֶ�Ϊ�ǣ���ISNET=1����
							//�ù�״̬Ϊ�ڸڣ���EMPSTATUS=0�����ͻ�����ȡ��������������ݻ�����Ϊ�գ�
							//��Ĭ��ȡ���ͻ���������ȡ��ǰʱ�䣻ȷ����ˮ��ȡ����ĩβ��λ��
							chSmsSmstmpl = (ChSmsSmstmpl)chSmsSmstmplDao.get("FX_ORDER_PARSIGNCON");
						} catch (ObjectRetrievalFailureException e) {
							//�Ҳ�������ģ�岻���������������
						}
						if(chSmsSmstmpl!=null){
							String scontent = chSmsSmstmpl.getScontent();
							//ȡ�ͻ���
//							Employee employee = ((DeliveryDao)getDao()).getWayNetEmployee(member.getWayid());
							
							String employeeName = "�ͻ�";
//							if(employee!=null){
//								employeeName = employee.getEmployeename()!=null&&
//								!"".equals(employee.getEmployeename().trim())?employee.getEmployeename():"�ͻ�";	
//							}
							if(o.getRecename()!=null&&!"".equals(o.getRecename().trim())){
								employeeName = o.getRecename();
							}
							//����
							String[] arrayDate = DateUtil.convertDateToString(d).split("-");

							scontent = scontent.replace("{CUSTNAME}", employeeName);
							scontent = scontent.replace("{YEAR}", arrayDate[0]);
							scontent = scontent.replace("{MONTH}", arrayDate[1]);
							scontent = scontent.replace("{DAY}", arrayDate[2]);
							scontent = scontent.replace("{ORDERID}", o.getOrderid());
							scontent = scontent.replace("{STREAM}", o.getOrderid().substring(o.getOrderid().length()-4));
							//��������
							smsWaitreq.setMessage(scontent);
							smsWaitreq.setCreattime(d);
							//������
							smsWaitreq.setAreacode(member.getCityid());
							//�������
							smsWaitreq.setDealcount((long)0);
							//����״̬
							smsWaitreq.setIssuccess((long)0);
							if(smsWaitreq.getSendno()!=null&&!"".equals(smsWaitreq.getSendno().trim())
									&&smsWaitreq.getRecno()!=null&&!"".equals(smsWaitreq.getRecno().trim())
									&&smsWaitreq.getMessage()!=null&&!"".equals(smsWaitreq.getMessage().trim())){
								chSmsWaitreqDao.save(smsWaitreq);
							}							
						}

						result.setSuccess(true);
						result.setRetCode(SalesrServiceRetCode.SUCCESS);
						
						//����������ɣ��޸������Ϣ
						//���¶�����FX_SW_ORDER�е��������ʱ��DISOVERTIMEΪϵͳ��ǰʱ��
							Date currentDate = new Date(System.currentTimeMillis());
							String orderId = o.getOrderid();
							FxSwOrder order = this.salesOrderDao.getById(orderId);
							order.setDisovertime(currentDate);
							this.salesOrderDao.update(order);
					}else if(ConstantsType.DISSTATE_DISOVER.equals(o.getDisstate())){
						result.setRetCode(SalesrServiceRetCode.State_Error_108);
					}else {
						result.setRetCode(SalesrServiceRetCode.State_Error);
					}
				}
			}//id ת��
		}//for
		if(ConstantsType.DISSTATE_DISING.equals(param.getDisstate())){
			if (saveList.size()<1) {
//				Assert.isTrue(false, SalesrServiceRetCode.State_Error, "״̬����!");
				result.setRetObject(new Integer(0));
				result.setRetCode(SalesrServiceRetCode.State_Error);
			}else{
				result.setSuccess(true);
				result.setRetObject(new Integer(saveList.size()));
				result.setRetCode(SalesrServiceRetCode.SUCCESS);
			}
		}
		return result;
	}

	private ServiceResult modigyLogs(LoginMember member, QueryParameter parameter){
		DeliveryQueryParameter param = (DeliveryQueryParameter)parameter;
		ServiceResult result = new ServiceResult();
		result.setSuccess(false);
		result.setRetCode(SalesrServiceRetCode.FAIL);
		//�жϲ���
		Assert.notBlank(param.getRecid(), SalesrServiceRetCode.ID_Empty, "ID��ʧ!");
		
		DeliveryDao dao = (DeliveryDao) this.getDao();
		
		try{
			FxSwDisform obj = (FxSwDisform)dao.get(Long.parseLong(param.getRecid()));
			String logi = param.getLogisticsno();
			if(logi.getBytes().length<=32){
				obj.setLogisticsno(param.getLogisticsno());
				dao.save(obj);
				result.setSuccess(true);
				result.setRetCode(SalesrServiceRetCode.SUCCESS);
			}else{
				result.setSuccess(false);
				result.setRetCode(SalesrServiceRetCode.MOD_LOGI_ERROR);
			}
		}catch(ObjectRetrievalFailureException e){
			//���󲻴����쳣
			result.setSuccess(false);
			result.setRetCode(SalesrServiceRetCode.INIT_FAIL);//5���������SALESORDER_5
		}catch(Exception e){
			e.printStackTrace();
			result.setSuccess(false);
			result.setRetCode(SalesrServiceRetCode.MOD_LOGI_ERROR);
		}
		
		return result;
	}
	
	/* (non-Javadoc)
	 * @see com.gmcc.pboss.common.service.impl.BaseServiceImpl#other(com.gmcc.pboss.common.bean.LoginMember, com.gmcc.pboss.common.support.QueryParameter)
	 */
	/**
	 * ����Other������ִ�����͵���ϸ�Ӳ�ѯ����ϸ�б�
	 */
	@Override
	public ServiceResult other(LoginMember member, QueryParameter parameter) {
		// TODO Auto-generated method stub
		//���巵����Ϣ
		DeliveryQueryParameter param = (DeliveryQueryParameter)parameter;
		//ID��֤
		Assert.notBlank(param.getOrderid(), SalesrServiceRetCode.ID_Empty, "ID�����ڣ�");
		ServiceResult result = new ServiceResult();
		result.setSuccess(false);
		result.setRetCode(SalesrServiceRetCode.FAIL);
		//������ѯ

		try{
			DeliveryDao dao = (DeliveryDao) this.getDao();
			List<FxSwOrdercomcate> lst = dao.getOrderComcateDtl(param.getOrderid());
			QueryResult retResult = new QueryResult(null, lst);
			//��װ���ؽ��
			result.setRetResult(retResult);
			result.setSuccess(true);
			result.setRetCode(SalesrServiceRetCode.SUCCESS);
		}catch(Exception e){
			//���󲻴����쳣
			result.setSuccess(false);
			result.setRetCode(SalesrServiceRetCode.INIT_FAIL);//5���������SALESORDER_5
		}
		
//		this.getDao().get
		return result;
	}

	public FxSwSmsconfirmDao getFxSwSmsconfirmDao() {
		return fxSwSmsconfirmDao;
	}

	public void setFxSwSmsconfirmDao(FxSwSmsconfirmDao fxSwSmsconfirmDao) {
		this.fxSwSmsconfirmDao = fxSwSmsconfirmDao;
	}

	public IbGlSysparamDao getIbGlSysparamDao() {
		return ibGlSysparamDao;
	}

	public void setIbGlSysparamDao(IbGlSysparamDao ibGlSysparamDao) {
		this.ibGlSysparamDao = ibGlSysparamDao;
	}

	public ChSmsSmstmplDao getChSmsSmstmplDao() {
		return chSmsSmstmplDao;
	}
	public void setChSmsSmstmplDao(ChSmsSmstmplDao chSmsSmstmplDao) {
		this.chSmsSmstmplDao = chSmsSmstmplDao;
	}
	public ChSmsWaitreqDao getChSmsWaitreqDao() {
		return chSmsWaitreqDao;
	}
	public void setChSmsWaitreqDao(ChSmsWaitreqDao chSmsWaitreqDao) {
		this.chSmsWaitreqDao = chSmsWaitreqDao;
	}
	public SalesOrderDao getSalesOrderDao(){
		return this.salesOrderDao;
	}
	public void setSalesOrderDao(SalesOrderDao salesOrderDao){
		this.salesOrderDao = salesOrderDao;
	}
}
