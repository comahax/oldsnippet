package com.gmcc.pboss.control.sales.bgcontrol.realtimereceive;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import com.gmcc.pboss.business.base.smstmpl.SmstmplVO;
import com.gmcc.pboss.business.channel.bondform.BondformVO;
import com.gmcc.pboss.business.channel.waitreq.WaitreqVO;
import com.gmcc.pboss.business.sales.adpaysum.AdpaysumVO;
import com.gmcc.pboss.business.sales.bankdeduct.BankdeductVO;
import com.gmcc.pboss.business.sales.order.OrderVO;
import com.gmcc.pboss.business.sales.ordertask.OrdertaskVO;
import com.gmcc.pboss.common.bankunite.BankUniteProcessCom;
import com.gmcc.pboss.common.bankunite.model.realtimereceive.request.RealTimeReceiveRequest;
import com.gmcc.pboss.common.bankunite.model.realtimereceive.response.RealTimeReceiveResponse;
import com.gmcc.pboss.common.bankunite.model.realtimereceive.response.RealTimeReceiveDetailsRes;
import com.gmcc.pboss.common.bankunite.model.realtimereceive.request.RealTimeReceiveDetailsReq;
import com.gmcc.pboss.common.bankunite.model.realtimereceive.request.RealTimeReceiveInfoReq;
import com.gmcc.pboss.common.bankunite.model.realtimereceive.request.RealTimeReceiveSumReq;
import com.gmcc.pboss.control.base.smstmpl.SmstmplBO;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.channel.bondform.Bondform;
import com.gmcc.pboss.control.channel.bondform.BondformBO;
import com.gmcc.pboss.control.channel.waitreq.WaitreqBO;
import com.gmcc.pboss.control.sales.adpaysum.Adpaysum;
import com.gmcc.pboss.control.sales.adpaysum.AdpaysumBO;
import com.gmcc.pboss.control.sales.bankdeduct.Bankdeduct;
import com.gmcc.pboss.control.sales.bankdeduct.BankdeductBO;
import com.gmcc.pboss.control.sales.order.Order;
import com.gmcc.pboss.control.sales.order.OrderBO;
import com.gmcc.pboss.control.sales.ordertask.Ordertask;
import com.gmcc.pboss.control.sales.ordertask.OrdertaskBO;
import com.sunrise.jop.common.utils.lang.Code2NameUtils;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;

public class RealTimeReceiveBO extends AbstractControlBean implements
		RealTimeReceive {

	private Logger log = Logger.getLogger(RealTimeReceiveBO.class);

	public void doProcess(List list) throws Exception {

		dealState(list);
	}

	/**
	 * �������л��ۼ�¼��[FX_SW_BANKDEDUCT]������Ӧ��¼�ġ�����״̬[STATE]������Ϊ��������[PROCESSING]����
	 * ��״̬���ʱ��[STATECHGTIME]��Ϊ��ǰʱ��
	 * 
	 * @throws Exception
	 */
	public void dealState(List list) throws Exception {

		Bankdeduct bankdeduct = (Bankdeduct) BOFactory.build(
				BankdeductBO.class, user);

		for (Iterator it = list.iterator(); it.hasNext();) {
			BankdeductVO bankdeductVO = (BankdeductVO) it.next();
			bankdeductVO.setState("PROCESSING");
			bankdeductVO.setStatechgtime(new Date(System.currentTimeMillis()));
			bankdeduct.doUpdate(bankdeductVO);
		}

	}



	/**
	 * ��������ʧ�ܺ󣬻ع����л��ۼ�¼��Ļ��ۼ�¼���˷�������ʵʱ���մ�������ʧ�ܣ�
	 */

	public void realTimeRollBackBankDeduct(BankdeductVO bankdeductvo)
			throws Exception {

		Bankdeduct bankdeduct = (Bankdeduct) BOFactory.build(
				BankdeductBO.class, user);

		BankdeductVO bankdeductVO = bankdeductvo;
		bankdeductVO.setState("WAITPROC");
		bankdeductVO.setStatechgtime(new Date(System.currentTimeMillis()));
		bankdeduct.doUpdate(bankdeductVO);

	}

	/**
	 * ��װʵʱ�����������
	 * 
	 * @param list
	 * @param username
	 * @param password
	 * @param sendmax
	 * @return
	 * @throws Exception
	 */
	public RealTimeReceiveRequest packData(BankdeductVO bankdeductVO,
			String username, String password, String sendmax) throws Exception {

		java.text.DecimalFormat df = new java.text.DecimalFormat("#");
		Date date = new Date(System.currentTimeMillis());
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
				"yyyyMMddHHmmss");
		String sdate = sdf.format(date);

		java.text.SimpleDateFormat sdfs = new java.text.SimpleDateFormat(
				"yyyyMMddHHmmssSS");
		String sdates = sdfs.format(date);

		
		
		RealTimeReceiveRequest realTimeReceiveRequest = new RealTimeReceiveRequest();
		RealTimeReceiveInfoReq realTimeReceiveInfoReq = new RealTimeReceiveInfoReq();
		RealTimeReceiveSumReq realTimeReceiveSumReq = new RealTimeReceiveSumReq();
		RealTimeReceiveDetailsReq realTimeReceiveDetailsReq = new RealTimeReceiveDetailsReq();
		List<RealTimeReceiveDetailsReq> trans_Details = new ArrayList<RealTimeReceiveDetailsReq>();

		
		//ͷ��Ϣ
		realTimeReceiveInfoReq.setUser_name(username);
		realTimeReceiveInfoReq.setUser_pass(password);
		realTimeReceiveInfoReq.setTrx_code("100004");
		realTimeReceiveInfoReq.setSigned_msg("");
		realTimeReceiveInfoReq.setLevel(Short.parseShort("0"));
		realTimeReceiveInfoReq.setData_type(Short.parseShort("2"));
		realTimeReceiveInfoReq.setVersion("04");
		realTimeReceiveInfoReq.setReq_sn("GDCM" + user.getCityid() + sdates);

		
		//ͳ����Ϣ
		realTimeReceiveSumReq.setBusiness_code("14900");
		realTimeReceiveSumReq.setSubmit_time(sdate);
		realTimeReceiveSumReq.setTotal_item((long) 1);
		realTimeReceiveSumReq.setMerchant_id(bankdeductVO.getShopnum());

		//��ϸ��Ϣ
		realTimeReceiveDetailsReq.setAccount_no(bankdeductVO.getAcctnum());
		realTimeReceiveDetailsReq.setAccount_name(bankdeductVO.getAcctname());
		realTimeReceiveDetailsReq.setBank_code(bankdeductVO.getBankid());
		realTimeReceiveDetailsReq.setAmount(Long.parseLong(df
				.format(bankdeductVO.getDeductamt() * 100)));
		realTimeReceiveDetailsReq.setSn(bankdeductVO.getDeductid().toString());
		realTimeReceiveDetailsReq.setAccount_type("00");
		realTimeReceiveDetailsReq.setAccount_prop("0");
		realTimeReceiveDetailsReq.setProvince("�㶫");
		realTimeReceiveDetailsReq.setCity(Code2NameUtils.code2Name("CITYNAME",
				user.getCityid(), user.getCityid()));

		
		trans_Details.add(realTimeReceiveDetailsReq);

		
		realTimeReceiveSumReq.setTotal_sum(Long.parseLong(df
				.format(realTimeReceiveDetailsReq.getAmount())));

		
		//�������
		realTimeReceiveRequest.setInfo(realTimeReceiveInfoReq);
		realTimeReceiveRequest.setTrans_Sum(realTimeReceiveSumReq);
		realTimeReceiveRequest.setTrans_Details(trans_Details);

		return realTimeReceiveRequest;
	}

	
	/**
	 * ��������
	 */
	public RealTimeReceiveResponse sendInfo(RealTimeReceiveRequest realTimeReceiveRequest)
			throws Exception {

		// ��������
		BankUniteProcessCom bankUniteProcessCom = new BankUniteProcessCom();
		bankUniteProcessCom.initPropertie(user.getCityid());
		bankUniteProcessCom.setLog(log);
		RealTimeReceiveResponse recBatchResponse = (RealTimeReceiveResponse) bankUniteProcessCom
				.sendMsg(realTimeReceiveRequest, true, RealTimeReceiveResponse.class);

		return recBatchResponse;
	}

	/**
	 * ������շ��ص�����
	 */
	public void dealResponse(RealTimeReceiveResponse realTimeReceiveResponse)
			throws Exception {

		Bankdeduct bankdeduct = (Bankdeduct) BOFactory.build(
				BankdeductBO.class, user);

		for (Iterator<RealTimeReceiveDetailsRes> it = realTimeReceiveResponse
				.getRet_Details().iterator(); it.hasNext();) {
			RealTimeReceiveDetailsRes realTimeReceiveDetailsRes = it.next();

			// ���ݷ��صļ�¼��ţ����ۼ�¼�ţ��ҵ���Ӧ�����л��ۼ�¼�����¡����л��ۼ�¼��[FX_SW_BANKDEDUCT]���С�����״̬[STATE]��Ϊ�������[PROCOVER]����
			// ��״̬���ʱ��[STATECHGTIME]��Ϊ��ǰʱ�䣻
			BankdeductVO bankdeductVO = bankdeduct.doFindByPk(Long
					.parseLong(realTimeReceiveDetailsRes.getSn()));
			bankdeductVO.setState("PROCOVER");
			bankdeductVO.setStatechgtime(new Date(System.currentTimeMillis()));
			bankdeductVO.setReqsn(realTimeReceiveResponse.getInfo().getReq_sn());
			
			if (realTimeReceiveDetailsRes.getRet_code().equals("0000")) {
				// ������������
				Short sh = bankdeductVO.getFormtype();

				if (sh == null) {

				} else if (sh == 0) {
					// 1�������л��ۼ�¼��Ϣ�Ĺ���������Ϊ����[0]ʱ�����¡�������[FX_SW_ORDER]����ġ�����״̬[DEDUCTSTATE]��Ϊ���ɹ�[SUCCESS]����
					// ��ʵ�ս��[ACTAMT]��Ϊ���л��ۼ�¼���еĻ��۽�������ʱ��[PAYTIME]��Ϊ��ǰ�ӿ���Ӧʱ�䣬������״̬[ORDERSTATE]��Ϊ�����շ�[CHARGED]����
					//						
					// �������ݵ����������[FX_SW_ORDERTASK]�����ȡ������У����б�ʶȡ��ǰ���У���GZ��SW�����������ȡ��ǰ������ţ���Ч��ȡ��Ч[1]��
					// ����ʱ��ȡ��ǰʱ�䣻

					Order order = (Order) BOFactory.build(OrderBO.class, user);
					OrderVO ordervo = order.doFindByPk(bankdeductVO
							.getOrderid());
					if (ordervo != null) {
						ordervo.setDeductstate("SUCCESS");
						if (bankdeductVO.getDeductamt() != null)
							ordervo.setActamt(bankdeductVO.getDeductamt());
						ordervo
								.setPaytime(new Date(System.currentTimeMillis()));
						ordervo.setOrderstate("CHARGED");

						order.doUpdate(ordervo);

						Ordertask ordertaskBO = (Ordertask) BOFactory.build(
								OrdertaskBO.class, user);
						OrdertaskVO ordertaskVO = new OrdertaskVO();
						ordertaskVO.setCityid(user.getCityid());
						if (ordervo.getOrderid() != null)
							ordertaskVO.setOrderid(ordervo.getOrderid());
						ordertaskVO.setCreatetime(new Date(System
								.currentTimeMillis()));
						ordertaskVO.setEffective(Short.parseShort("1"));

						ordertaskBO.doCreate(ordertaskVO);
						
//						�����۳ɹ��ͻ��۹���������Ϊ����ʱ�������á�������һ�������÷�������
						order.doNextProcess(ordervo.getOrderid());
						
					}
				} else if (sh == 1) {
					// 2�������л��ۼ�¼��Ϣ�Ĺ���������Ϊ���ʵ���1��ʱ�����µ��ʶ������ܱ�
					// (FX_SW_ADPAYSUM)��״̬Ϊ����֧��[PAYMENT]��;

					Adpaysum adpaysumBO = (Adpaysum) BOFactory.build(
							AdpaysumBO.class, user);
					AdpaysumVO adpaysumVO = adpaysumBO.doFindByPk(Long
							.parseLong(bankdeductVO.getOrderid()));
					if (adpaysumVO != null)
						adpaysumVO.setState("PAYMENT");

					adpaysumBO.doUpdate(adpaysumVO);

				} else if (sh == 2) {
					// 3�������л��ۼ�¼��Ϣ�Ĺ���������Ϊ��֤���Ͻɵ���2��ʱ�����±�֤�����뵥��(FX_SW_BONDFORM)��״̬Ϊ����֧��[8]��;

					Bondform bondformBO = (Bondform) BOFactory.build(
							BondformBO.class, user);
					BondformVO bondformVO = bondformBO.doFindByPk(Long.parseLong(bankdeductVO
							.getOrderid()));
					if (bondformVO != null) {
						bondformVO.setState(Short.parseShort("8"));

						bondformBO.doUpdate(bondformVO);
					}
				}

				bankdeductVO.setRespcode(realTimeReceiveDetailsRes.getRet_code());

			} else {
				bankdeductVO.setRespcode(realTimeReceiveDetailsRes.getRet_code());
				bankdeductVO.setErrmsg(realTimeReceiveDetailsRes.getErr_msg());

				WaitreqVO waitreqVO = new WaitreqVO();
				waitreqVO.setSmstype(Short.parseShort("3"));// ��������
				waitreqVO.setAreacode(user.getCityid());// �����ʶ
				waitreqVO.setCreattime(new Date(System.currentTimeMillis()));// ����ʱ��
				if (bankdeductVO.getCallnum() != null)
					waitreqVO.setRecno(bankdeductVO.getCallnum());// ���ͺ���
				waitreqVO.setDealcount(Short.parseShort("0"));// �������
				waitreqVO.setIssuccess(Short.parseShort("0"));// ����״̬
				// ���ͺ���
				SysparamBO sysparamBO = (SysparamBO) BOFactory.build(
						SysparamBO.class, user);
				String sysstr = sysparamBO.doFindByID(42L, "pboss_fx");
				waitreqVO.setSendno(sysstr);
				// ����ģ��
				SmstmplBO smstmplBO = (SmstmplBO) BOFactory.build(
						SmstmplBO.class, user);
				SmstmplVO smstmplVO = smstmplBO.doFindByPk("FX_DEDUCTFAIL");
				waitreqVO.setMessage(smstmplVO.getScontent());

				WaitreqBO waitreqBO = (WaitreqBO) BOFactory.build(
						WaitreqBO.class, user);

				// ������Ŵ����ͱ�
				if (waitreqVO.getRecno() == null
						|| waitreqVO.getRecno().equals("")
						|| waitreqVO.getSendno() == null
						|| waitreqVO.getSendno().equals("")
						|| waitreqVO.getMessage() == null
						|| waitreqVO.getMessage().equals("")) {
					throw new Exception("���ͺ���/���պ���/��������Ϊ�գ�");
				} else {
					waitreqBO.doInsert3(waitreqVO.getSmstype(), waitreqVO
							.getMessage(), waitreqVO.getSendno(), waitreqVO
							.getRecno(), new Date(System.currentTimeMillis()));
				}

				// ������������
				Short sh = bankdeductVO.getFormtype();
				if (sh == null) {

				} else if (sh == 0) {
					Order order = (Order) BOFactory.build(OrderBO.class, user);
					OrderVO ordervo = order.doFindByPk(bankdeductVO
							.getOrderid());
					if (ordervo != null) {
						ordervo.setDeductstate("FAIL");

						order.doUpdate(ordervo);
						
						//������Ϊʧ�ܺͻ��۹���������Ϊ����ʱ,��ѯϵͳ���������ö��������߼�
						SysparamBO sysparambo = (SysparamBO)BOFactory.build(SysparamBO.class, user);
						String paramvalue=sysparambo.doFindByID("78", "pboss_fx");
						if(paramvalue != null && paramvalue.equals("1")){
							//���ö��������߼�
							String [] orderid = new String[1];
							orderid[0] = ordervo.getOrderid();
							order.cancleOrder(orderid, "����ʧ��", null); 
							//order.doCancle(ordervo);
						}
						
					}
				}
			}
			bankdeduct.doUpdate(bankdeductVO);
		}
	}

}
