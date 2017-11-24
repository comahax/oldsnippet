package com.gmcc.pboss.biz.info.delivery.service.impl;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import org.springframework.orm.ObjectRetrievalFailureException;

import com.gmcc.pboss.biz.basic.goods.dao.IbGlSysparamDao;
import com.gmcc.pboss.biz.info.delivery.dao.ChSmsSmstmplDao;
import com.gmcc.pboss.biz.info.delivery.dao.ChSmsWaitreqDao;
import com.gmcc.pboss.biz.info.delivery.dao.DeliveryDao;
import com.gmcc.pboss.biz.info.delivery.dao.FxSwSmsconfirmDao;
import com.gmcc.pboss.biz.info.delivery.service.BatchDeliveryService;
import com.gmcc.pboss.biz.info.delivery.support.BatchDeliveryParameter;
import com.gmcc.pboss.biz.info.salesRpt.dao.SalesOrderDao;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.dictionary.ConstantsType;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceRetCode;
import com.gmcc.pboss.common.service.impl.BaseServiceImpl;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.util.DateUtil;
import com.gmcc.pboss.model.delivery.FxSwDisform;
import com.gmcc.pboss.model.sales.FxSwOrder;
import com.gmcc.pboss.model.sms.ChSmsSmstmpl;
import com.gmcc.pboss.model.sms.ChSmsWaitreq;
import com.gmcc.pboss.model.sms.FxSwSmsconfirm;
import com.gmcc.pboss.biz.info.delivery.support.BatchProcessResult;

public class BatchDeliveryServiceImpl extends BaseServiceImpl implements BatchDeliveryService {
	
	/**
	 * ����������ServiceCode��ServiceName��ֵ
	 */
	public BatchDeliveryServiceImpl(){
		super();
		this.serviceName = "�������ʹ���";
		this.serviceCode = ServiceCode.BatchDelivery;
		this.isNeedLogin = true;
		this.setProcessor(null);
	}
	
	private DeliveryDao deliveryDao;

	private FxSwSmsconfirmDao fxSwSmsconfirmDao;
	
	private IbGlSysparamDao ibGlSysparamDao;
	
	private ChSmsSmstmplDao chSmsSmstmplDao;
	
	private ChSmsWaitreqDao chSmsWaitreqDao;
	
	private SalesOrderDao salesOrderDao;
	
	public ServiceResult modify(LoginMember member, QueryParameter parameter) {
		ServiceResult result = new ServiceResult();
		result.setSuccess(false);
		result.setRetCode(ServiceRetCode.FAIL);
		
		BatchDeliveryParameter param = (BatchDeliveryParameter)parameter;
		String content = param.getContent().trim().replaceAll("\\s", "");//ȥ��ǰ��ո�ȥ���Ǵ�ӡ�ַ�
		String type = param.getType();
		List<BatchProcessResult> processResults = null;
		if(type.equals("1")){
			processResults = this.doBatchDisover(member, content);
		}
		else if(type.equals("2")){
			processResults = this.doBatchSMSSign(member, content);
		}
		else if(type.equals("3")){
			processResults = this.doBatchLogiMod(member, content);
		}
//		else{
//			processResults = new ArrayList<BatchProcessResult>();
//		}
		
		//����
		BatchProcessResult[] notSort = processResults.toArray(new BatchProcessResult[]{new BatchProcessResult()});
		Arrays.sort(notSort);
		processResults = Arrays.asList(notSort);
		
		result.setSuccess(true);
		result.setRetObject(processResults);
		result.setRetResult(null);
		result.setRetCode(ServiceRetCode.SUCCESS);
		
		return result;
	}
	
	private List<BatchProcessResult> doBatchDisover(LoginMember member, String content){
		List<BatchProcessResult> processResults = new ArrayList<BatchProcessResult>();
		String[] codes = content.split(",");		
		String discomcode = member.getChannel().getWayid();
		for(String code : codes){
			BatchProcessResult processResult = null;
			Long id = null;
			try{
				if(code.trim().length()>14){//������0��"���͵��������"					
					processResult = new BatchProcessResult(0,code,"���͵��������");
					processResults.add(processResult);
					continue;
				}else{
					id = new Long(code);
				}				
			}catch(Exception e){//�������ݲ��Ǵ�����
				processResult = new BatchProcessResult(0,code,"���͵��������");//������0��"���͵��������"
				processResults.add(processResult);
				continue;
			}
			
			FxSwDisform o = null;
			try{
				o = (FxSwDisform)this.deliveryDao.getDisform(id, discomcode);
			}catch(Exception e){//��ѯ����ʧ��	
				e.printStackTrace();
				processResult = new BatchProcessResult(0,code,"���͵�������");
				processResults.add(processResult);
				continue;
			}
			if(o==null){//������0��"���͵�������"
				processResult = new BatchProcessResult(0,code,"���͵�������");
				processResults.add(processResult);
				continue;
			}
			if( !ConstantsType.DISSTATE_DISING.equals(o.getDisstate())){//״̬��Ϊ������
				//������2��"���͵�״̬����ȷ��������״̬�����������"
				processResult = new BatchProcessResult(2,code,"���͵�״̬����ȷ��������״̬�����������");
				processResults.add(processResult);
				continue;
			}			
			
			//дȷ�϶���
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
			
			//���и�������
			//��״̬�޸�Ϊ"�������"
			o.setDisstate(ConstantsType.DISSTATE_DISOVER);
			this.deliveryDao.update(o);			
			//����������ɣ��޸������Ϣ
			//���¶�����FX_SW_ORDER�е��������ʱ��DISOVERTIMEΪϵͳ��ǰʱ��
			Date currentDate = new Date(System.currentTimeMillis());
			String orderId = o.getOrderid();
			FxSwOrder order = this.salesOrderDao.getById(orderId);
			order.setDisovertime(currentDate);
			this.salesOrderDao.update(order);
			//дȷ�϶���
			fxSwSmsconfirmDao.save(smsconfirm);
			
			//֪ͨ������ǩ��
			ChSmsWaitreq smsWaitreq = new ChSmsWaitreq();
			//��������ȡ3
			smsWaitreq.setSmstype(new Long(3));
			//��ѯϵͳ�������ñ�IB_GL_SYSPARAM����ƥ���������Ϊ��pboss_fx����������ʶΪ��42�������ͺ���ȡ����ֵ
			String sendNO = this.ibGlSysparamDao.getSysValue(42L, "pboss_fx");
			if(sendNO==null ||"".equals(sendNO.trim())){//������0��"��������ͣ���֪ͨ����ʧ�ܣ����ͺ���Ϊ��"				
				processResult = new BatchProcessResult(0,code,"��������ͣ���֪ͨ����ʧ�ܣ����ͺ���Ϊ��");
				processResults.add(processResult);
				continue;				
			}
			//���ͺ��� 
			smsWaitreq.setSendno(sendNO);
			//����ȡ���͵��е��ջ��˵绰
			if(o.getRecetel()==null ||"".equals(o.getRecetel().trim())){//������0��"��������ͣ���֪ͨ����ʧ�ܣ����պ���Ϊ��"				
				processResult = new BatchProcessResult(0,code,"��������ͣ���֪ͨ����ʧ�ܣ����պ���Ϊ��");
				processResults.add(processResult);
				continue;				
			}
			smsWaitreq.setRecno(o.getRecetel());
			ChSmsSmstmpl chSmsSmstmpl = null;
			try {
				chSmsSmstmpl = (ChSmsSmstmpl)chSmsSmstmplDao.get("FX_ORDER_PARSIGNCON");
			} catch (ObjectRetrievalFailureException e) {
				//�Ҳ�������ģ�岻������������Ϊ�գ���������
				e.printStackTrace();
				processResult = new BatchProcessResult(0,code,"��������ͣ���֪ͨ����ʧ�ܣ���������Ϊ��");
				processResults.add(processResult);	
				continue;
			}
			//��ѯģ�治Ϊ�գ���ģ�����ݲ�Ϊ�ջ��߿��ַ���
			if(chSmsSmstmpl!=null && chSmsSmstmpl.getScontent()!=null && !"".equals(chSmsSmstmpl.getScontent().trim())){
				String scontent = chSmsSmstmpl.getScontent().trim();
				
				String employeeName = "�ͻ�";
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
				String logi = o.getLogisticsno()==null?"":o.getLogisticsno();
				scontent = scontent.replace("{LOGISTICSINFO}", logi);
				
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
			}else{
				//������0��"��������ͣ���֪ͨ����ʧ�ܣ���������Ϊ��"
				processResult = new BatchProcessResult(0,code,"��������ͣ���֪ͨ����ʧ�ܣ���������Ϊ��");
				processResults.add(processResult);	
				continue;
			}	
			
			//�����ǡ�1������ʾ��Ϣ��������ɡ�
			processResult = new BatchProcessResult(1,code,"�������");
			processResults.add(processResult);
		}	
		
		return processResults;
	}
	
	private List<BatchProcessResult> doBatchSMSSign(LoginMember member, String content ){
		List<BatchProcessResult> processResults = new ArrayList<BatchProcessResult>();
		String[] codes = content.split(",");		
		String discomcode = member.getChannel().getWayid();
		for(String code : codes){
			BatchProcessResult processResult = null;
			Long id = null;
			try{
				if(code.trim().length()>14){//������0��"���͵��������"					
					processResult = new BatchProcessResult(0,code,"���͵��������");
					processResults.add(processResult);
					continue;
				}else{
					id = new Long(code);
				}				
			}catch(Exception e){//�������ݲ��Ǵ�����
				processResult = new BatchProcessResult(0,code,"���͵��������");//������0��"���͵��������"
				processResults.add(processResult);
				continue;
			}
			
			FxSwDisform o = null;
			try{
				o = (FxSwDisform)this.deliveryDao.getDisform(id, discomcode);
			}catch(Exception e){//��ѯ����ʧ��
				e.printStackTrace();
				processResult = new BatchProcessResult(0,code,"���͵�������");
				processResults.add(processResult);
				continue;
			}
			if(o==null){//������0��"���͵�������"				
				processResult = new BatchProcessResult(0,code,"���͵�������");
				processResults.add(processResult);
				continue;
			}
			if( !ConstantsType.DISSTATE_DISOVER.equals(o.getDisstate())){//״̬�Ƿ�����������״̬
				processResult = new BatchProcessResult(2,code,"���͵�״̬����");//������2��"���͵�״̬����"
				processResults.add(processResult);
				continue;
			}			
			
			//�ǼǶ���ȷ�ϼ�¼
			// �������ͣ�������ǩ�գ����ֻ����루���͵��е��ջ��˵绰����
			//������š�״̬�����ظ�����ѯ��������ȷ�ϱ�FX_SW_SMSCONFIRM��
			Date d = new Date();//��ǰ����ʱ��		
			FxSwSmsconfirm smsconfirm = fxSwSmsconfirmDao.getSmsconfirm(//�˱���Ψһ����:����+������+״̬
					ConstantsType.FX_SMSCONTYPE_PARSIGN, //����-������ǩ��
					o.getRecetel(), //�ֻ�����-���͵��ջ��˺���
					o.getOrderid(), //�������
					ConstantsType.FX_SMSREPSTATE_WAITREP //״̬-���ظ�
					);
			if(smsconfirm==null){//���ݲ����ڣ�����һ����¼
				smsconfirm = new FxSwSmsconfirm();
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
				//֪ͨʱ��ȡ��ǰʱ��
				smsconfirm.setSendtime(d);
			}else{//��¼�Ѵ���
				smsconfirm.setSendtime(d);
			}
			//дȷ�϶���
			fxSwSmsconfirmDao.save(smsconfirm);
			
			//֪ͨ������ǩ��
			ChSmsWaitreq smsWaitreq = new ChSmsWaitreq();
			//��������ȡ3
			smsWaitreq.setSmstype(new Long(3));
			//��ѯϵͳ�������ñ�IB_GL_SYSPARAM����ƥ���������Ϊ��pboss_fx����������ʶΪ��42�������ͺ���ȡ����ֵ
			String sendNO = this.ibGlSysparamDao.getSysValue(42L, "pboss_fx");
			if(sendNO==null ||"".equals(sendNO.trim())){//������0��"���ͺ���Ϊ��"				
				processResult = new BatchProcessResult(0,code,"���ͺ���Ϊ��");
				processResults.add(processResult);
				continue;				
			}
			//���ͺ��� 
			smsWaitreq.setSendno(sendNO);
			//����ȡ���͵��е��ջ��˵绰
			if(o.getRecetel()==null ||"".equals(o.getRecetel().trim())){//������0��"���պ���Ϊ��"				
				processResult = new BatchProcessResult(0,code,"���պ���Ϊ��");
				processResults.add(processResult);
				continue;				
			}
			smsWaitreq.setRecno(o.getRecetel());
			ChSmsSmstmpl chSmsSmstmpl = null;
			try {
				chSmsSmstmpl = (ChSmsSmstmpl)chSmsSmstmplDao.get("FX_ORDER_PARSIGNCON");
			} catch (ObjectRetrievalFailureException e) {//�Ҳ�������ģ�岻������������Ϊ�գ���������				
				e.printStackTrace();
				processResult = new BatchProcessResult(0,code,"��������Ϊ��");
				processResults.add(processResult);	
				continue;
			}
			//��ѯģ�治Ϊ�գ���ģ�����ݲ�Ϊ�ջ��߿��ַ���
			if(chSmsSmstmpl!=null && chSmsSmstmpl.getScontent()!=null && !"".equals(chSmsSmstmpl.getScontent().trim())){
				String scontent = chSmsSmstmpl.getScontent().trim();				
				String employeeName = "�ͻ�";
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
				String logi = o.getLogisticsno()==null?"":o.getLogisticsno();
				scontent = scontent.replace("{LOGISTICSINFO}", logi);
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
			}else{
				//������0��"��������Ϊ��"
				processResult = new BatchProcessResult(0,code,"��������Ϊ��");
				processResults.add(processResult);	
				continue;
			}
			
			//�����ǡ�1������ʾ��Ϣ"����ǩ�ն��ųɹ�"
			processResult = new BatchProcessResult(1,code,"����ǩ�ն��ųɹ�");
			processResults.add(processResult);			
		}
		
		return processResults;
	}
	
	private List<BatchProcessResult> doBatchLogiMod(LoginMember member, String content ){
		List<BatchProcessResult> processResults = new ArrayList<BatchProcessResult>();
		String[] infos = content.split(",");		
		String discomcode = member.getChannel().getWayid();
		for(String info : infos ){
			BatchProcessResult processResult = null;
			Long id = null;
			
			String[] recid_logi = info.trim().split("\\|");
			if(recid_logi.length!=2 || recid_logi[0].trim().equals("")){
				processResult = new BatchProcessResult(0,info,"��ʽ����\"���͵�����|��������\"");
				processResults.add(processResult);
				continue;
			}
			String recid = recid_logi[0].trim();
			String logi = recid_logi[1].trim();
			
			try{//���͵������ʽ���
				if(recid.length()>14){//������0��"���͵��������"					
					processResult = new BatchProcessResult(0,info,"���͵��������");
					processResults.add(processResult);
					continue;
				}else{
					id = new Long(recid);
				}				
			}catch(Exception e){//�������ݲ��Ǵ�����
				processResult = new BatchProcessResult(0,info,"���͵��������");//������0��"���͵��������"
				processResults.add(processResult);
				continue;
			}
			
			//�������Ÿ�ʽ���
			if(logi.getBytes().length != logi.length()){
				processResult = new BatchProcessResult(0,info,"���������������ֻ����������ĸ������");//������0��"���͵��������"
				processResults.add(processResult);
				continue;
			}
			if(logi.getBytes().length>32){
				processResult = new BatchProcessResult(0,info,"���������������");//������0��"���͵��������"
				processResults.add(processResult);
				continue;
			}
			
			FxSwDisform o = null;
			try{
				o = (FxSwDisform)this.deliveryDao.getDisform(id, discomcode);
			}catch(Exception e){//��ѯ����ʧ��
				e.printStackTrace();
				processResult = new BatchProcessResult(0,info,"���͵�������");
				processResults.add(processResult);
				continue;
			}
			if(o==null){//������0��"���͵�������"				
				processResult = new BatchProcessResult(0,info,"���͵�������");
				processResults.add(processResult);
				continue;
			}
			
			o.setLogisticsno(logi);
			this.deliveryDao.save(o);
			processResult = new BatchProcessResult(1,info,"��������¼��ɹ�");
			processResults.add(processResult);
		}
		return processResults;
	}
	
	public DeliveryDao getDeliveryDao() {
		return deliveryDao;
	}

	public void setDeliveryDao(DeliveryDao deliveryDao) {
		this.deliveryDao = deliveryDao;
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

	public SalesOrderDao getSalesOrderDao() {
		return salesOrderDao;
	}

	public void setSalesOrderDao(SalesOrderDao salesOrderDao) {
		this.salesOrderDao = salesOrderDao;
	}


}
