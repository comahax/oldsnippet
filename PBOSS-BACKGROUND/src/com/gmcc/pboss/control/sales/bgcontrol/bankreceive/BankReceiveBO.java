package com.gmcc.pboss.control.sales.bgcontrol.bankreceive;

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
import com.gmcc.pboss.common.bankunite.model.base.response.BaseResponse;
import com.gmcc.pboss.common.bankunite.model.receivebatch.request.RecBatchDetailsReq;
import com.gmcc.pboss.common.bankunite.model.receivebatch.request.RecBatchInfoReq;
import com.gmcc.pboss.common.bankunite.model.receivebatch.request.RecBatchRequest;
import com.gmcc.pboss.common.bankunite.model.receivebatch.request.RecBatchSumReq;
import com.gmcc.pboss.common.bankunite.model.receivebatch.response.RecBatchDetailsRes;
import com.gmcc.pboss.common.bankunite.model.receivebatch.response.RecBatchResponse;
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
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.common.utils.lang.Code2NameUtils;
import com.sunrise.jop.infrastructure.config.CoreConfigInfo;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;

public class BankReceiveBO extends AbstractControlBean implements BankReceive {

	private Logger log = Logger.getLogger(BankReceiveBO.class);

	public List<RecBatchRequest> doProcess(List list,String username,String password,String sendmax) throws Exception {

		dealState(list);

		// ��װ���ݲ���������
		return packData(list,username,password,sendmax);

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
	 * ��������ʧ�ܺ󣬻ع����л��ۼ�¼��Ļ��ۼ�¼
	 */
	
	public void rollBackBankDeduct(List list) throws Exception{
		
		Bankdeduct bankdeduct = (Bankdeduct) BOFactory.build(
				BankdeductBO.class, user);

		for (Iterator it = list.iterator(); it.hasNext();) {
			BankdeductVO bankdeductVO = (BankdeductVO) it.next();
			bankdeductVO.setState("WAITPROC");
			bankdeductVO.setStatechgtime(new Date(System.currentTimeMillis()));
			bankdeduct.doUpdate(bankdeductVO);
		}
		
	}
	
	

	/**
	 * ����¼��װ�ɴ��������������,����������
	 */
	public List<RecBatchRequest> packData(List list,String username,String password,String sendmax) throws Exception {
		double TOTAL_SUM = 0;
		
		//��װ��������������һ�η���100���̻�
		List<RecBatchRequest> recBatchRequestlist = new ArrayList<RecBatchRequest>();
		
		
		java.text.DecimalFormat df = new java.text.DecimalFormat("#");
		Date date = new Date(System.currentTimeMillis());
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
				"yyyyMMddHHmmss");
		String sdate = sdf.format(date);

		java.text.SimpleDateFormat sdfs = new java.text.SimpleDateFormat(
				"yyyyMMddHHmmssSS");
		String sdates = sdfs.format(date);

		RecBatchRequest recBatchRequest = new RecBatchRequest();
		RecBatchInfoReq recBatchInfoReq = new RecBatchInfoReq();
		RecBatchSumReq recBatchSumReq = new RecBatchSumReq();

		List<RecBatchDetailsReq> trans_Details = null;

		recBatchInfoReq.setUser_name(username);
		recBatchInfoReq.setUser_pass(password);
		recBatchInfoReq.setTrx_code("100001");
		recBatchInfoReq.setSigned_msg("");
		recBatchInfoReq.setLevel(Short.parseShort("5"));
		recBatchInfoReq.setData_type(Short.parseShort("2"));
		recBatchInfoReq.setVersion("04");

		recBatchSumReq.setBusiness_code("14900");
		recBatchSumReq.setSubmit_time(sdate);

		List<String> str = sortBank(list);

		for (int i = 0; i < str.size(); i++) {
			recBatchInfoReq.setReq_sn("GDCM" + user.getCityid() + sdates);
			int count = 0;
			trans_Details = new ArrayList<RecBatchDetailsReq>();
			for (Iterator it = list.iterator(); it.hasNext();) {
				BankdeductVO bankdeductVO = (BankdeductVO) it.next();

				if (str.get(i).equals(bankdeductVO.getShopnum())) {
					count += 1;
					RecBatchDetailsReq RecBatchDetailsReq = new RecBatchDetailsReq();

					RecBatchDetailsReq.setAccount_no(bankdeductVO.getAcctnum());
					RecBatchDetailsReq.setAccount_name(bankdeductVO
							.getAcctname());
					RecBatchDetailsReq.setBank_code(bankdeductVO.getBankid());
					RecBatchDetailsReq
							.setAmount(Long.parseLong(df.format(bankdeductVO.getDeductamt() * 100)));
					RecBatchDetailsReq.setSn(bankdeductVO.getDeductid()
							.toString());
					RecBatchDetailsReq.setAccount_type("00");
					RecBatchDetailsReq.setAccount_prop("0");
					RecBatchDetailsReq.setProvince("�㶫");
					RecBatchDetailsReq.setCity(Code2NameUtils.code2Name(
							"CITYNAME", user.getCityid(), user.getCityid()));
					trans_Details.add(RecBatchDetailsReq);
					TOTAL_SUM += RecBatchDetailsReq.getAmount();
				}

				// ����¼���ﵽ���޵�ʱ��ͷ�������
				if (count == Integer.parseInt(sendmax)) {
					recBatchSumReq.setTotal_item((long) count);

					recBatchSumReq.setMerchant_id(str.get(i));
					recBatchSumReq.setTotal_sum(Long.parseLong(df
							.format(TOTAL_SUM)));
					
					//��װ�������
					RecBatchRequest rrecBatchRequest = new RecBatchRequest();
					
					RecBatchInfoReq rrecBatchInfoReq = new RecBatchInfoReq();
					RecBatchSumReq rrecBatchSumReq = new RecBatchSumReq();
					List<RecBatchDetailsReq> rlist = new ArrayList<RecBatchDetailsReq>();
					
					BeanUtils.copyProperties(rrecBatchInfoReq, recBatchInfoReq);
					BeanUtils.copyProperties(rrecBatchSumReq, recBatchSumReq);
					BeanUtils.copyProperties(rlist, trans_Details);
					
					rrecBatchRequest.setInfo(rrecBatchInfoReq);
					rrecBatchRequest.setTrans_Sum(rrecBatchSumReq);
					rrecBatchRequest.setTrans_Details(rlist);
					
					
					recBatchRequestlist.add(rrecBatchRequest);
					
					//���֮ǰĳ�ε�ֵ
					count = 0;
					trans_Details = new ArrayList<RecBatchDetailsReq>();
				}

			}

			if (count != 0) {
				recBatchSumReq.setTotal_item((long) count);

				recBatchSumReq.setMerchant_id(str.get(i));
				recBatchSumReq.setTotal_sum(Long
						.parseLong(df.format(TOTAL_SUM)));

				recBatchRequest.setInfo(recBatchInfoReq);
				recBatchRequest.setTrans_Sum(recBatchSumReq);
				recBatchRequest.setTrans_Details(trans_Details);
				recBatchRequestlist.add(recBatchRequest);
			
			}

		}
		
		return recBatchRequestlist;
	}
	
	
	
	/**
	 * ��������
	 */
	public RecBatchResponse sendInfo(RecBatchRequest recBatchRequest) throws Exception {
		
		// ��������
		BankUniteProcessCom bankUniteProcessCom = new BankUniteProcessCom();
		bankUniteProcessCom.initPropertie(user.getCityid());
		bankUniteProcessCom.setLog(log);
		RecBatchResponse recBatchResponse = (RecBatchResponse) bankUniteProcessCom
				.sendMsg(recBatchRequest, true, RecBatchResponse.class);
		
		return recBatchResponse;
	}
	

	
	
	/**
	 * �����ص�����
	 */
	public void dealResponse(RecBatchResponse recBatchResponse)
			throws Exception {

		Bankdeduct bankdeduct = (Bankdeduct) BOFactory.build(
				BankdeductBO.class, user);

		for (Iterator<RecBatchDetailsRes> it = recBatchResponse
				.getRet_Details().iterator(); it.hasNext();) {
			RecBatchDetailsRes recBatchDetailsRes = it.next();

			// ���ݷ��صļ�¼��ţ����ۼ�¼�ţ��ҵ���Ӧ�����л��ۼ�¼�����¡����л��ۼ�¼��[FX_SW_BANKDEDUCT]���С�����״̬[STATE]��Ϊ�������[PROCOVER]����
			// ��״̬���ʱ��[STATECHGTIME]��Ϊ��ǰʱ�䣻
			BankdeductVO bankdeductVO = bankdeduct.doFindByPk(Long
					.parseLong(recBatchDetailsRes.getSn()));
			bankdeductVO.setState("PROCOVER");
			bankdeductVO.setStatechgtime(new Date(System.currentTimeMillis()));

			if (recBatchDetailsRes.getRet_code().equals("0000")) {
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
					BondformVO bondformVO = bondformBO.doFindByPk(bankdeductVO
							.getOrderid());
					if (bondformVO != null) {
						bondformVO.setState(Short.parseShort("8"));

						 bondformBO.doUpdate(bondformVO);
					}
				}

				bankdeductVO.setRespcode(recBatchDetailsRes.getRet_code());

			} else {
				bankdeductVO.setRespcode(recBatchDetailsRes.getRet_code());
				bankdeductVO.setErrmsg(recBatchDetailsRes.getErr_msg());

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
					 waitreqBO.doInsert3(waitreqVO.getSmstype(),
					 waitreqVO.getMessage(), waitreqVO.getSendno(),
					 waitreqVO.getRecno(), new
					 Date(System.currentTimeMillis()));
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
					}
				}
			}
			 bankdeduct.doUpdate(bankdeductVO);
		}
	}

	
	// �����л��ۼ�¼���з���
	public List<String> sortBank(List list) {
		List<String> sortlist = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			BankdeductVO bankdeductVO = (BankdeductVO) list.get(i);

			boolean bo = true;
			for (int j = 0; j < sortlist.size(); j++) {
				if (bankdeductVO.getShopnum() != null
						&& bankdeductVO.getShopnum().equals(sortlist.get(j))) {
					bo = false;
				}
			}
			if (bo) {
				sortlist.add(bankdeductVO.getShopnum());
			}
		}
		return sortlist;
	}

}
