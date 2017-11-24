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

		// 封装数据并发送请求
		return packData(list,username,password,sendmax);

	}

	/**
	 * 将“银行划扣记录表[FX_SW_BANKDEDUCT]”中相应记录的“处理状态[STATE]”更改为“处理中[PROCESSING]”，
	 * “状态变更时间[STATECHGTIME]”为当前时间
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
	 * 当请求发送失败后，回滚银行划扣记录表的划扣记录
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
	 * 将记录封装成代收请求参数对象,并发送请求
	 */
	public List<RecBatchRequest> packData(List list,String username,String password,String sendmax) throws Exception {
		double TOTAL_SUM = 0;
		
		//封装请求对象。现在最多一次发送100个商户
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
					RecBatchDetailsReq.setProvince("广东");
					RecBatchDetailsReq.setCity(Code2NameUtils.code2Name(
							"CITYNAME", user.getCityid(), user.getCityid()));
					trans_Details.add(RecBatchDetailsReq);
					TOTAL_SUM += RecBatchDetailsReq.getAmount();
				}

				// 当记录数达到上限的时候就发送请求
				if (count == Integer.parseInt(sendmax)) {
					recBatchSumReq.setTotal_item((long) count);

					recBatchSumReq.setMerchant_id(str.get(i));
					recBatchSumReq.setTotal_sum(Long.parseLong(df
							.format(TOTAL_SUM)));
					
					//封装请求对象
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
					
					//清空之前某段的值
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
	 * 发送请求
	 */
	public RecBatchResponse sendInfo(RecBatchRequest recBatchRequest) throws Exception {
		
		// 发送请求
		BankUniteProcessCom bankUniteProcessCom = new BankUniteProcessCom();
		bankUniteProcessCom.initPropertie(user.getCityid());
		bankUniteProcessCom.setLog(log);
		RecBatchResponse recBatchResponse = (RecBatchResponse) bankUniteProcessCom
				.sendMsg(recBatchRequest, true, RecBatchResponse.class);
		
		return recBatchResponse;
	}
	

	
	
	/**
	 * 处理返回的内容
	 */
	public void dealResponse(RecBatchResponse recBatchResponse)
			throws Exception {

		Bankdeduct bankdeduct = (Bankdeduct) BOFactory.build(
				BankdeductBO.class, user);

		for (Iterator<RecBatchDetailsRes> it = recBatchResponse
				.getRet_Details().iterator(); it.hasNext();) {
			RecBatchDetailsRes recBatchDetailsRes = it.next();

			// 根据返回的记录序号（划扣记录号）找到响应的银行划扣记录，更新“银行划扣记录表[FX_SW_BANKDEDUCT]”中“处理状态[STATE]”为“已完成[PROCOVER]”、
			// “状态变更时间[STATECHGTIME]”为当前时间；
			BankdeductVO bankdeductVO = bankdeduct.doFindByPk(Long
					.parseLong(recBatchDetailsRes.getSn()));
			bankdeductVO.setState("PROCOVER");
			bankdeductVO.setStatechgtime(new Date(System.currentTimeMillis()));

			if (recBatchDetailsRes.getRet_code().equals("0000")) {
				// 关联订单类型
				Short sh = bankdeductVO.getFormtype();

				if (sh == null) {

				} else if (sh == 0) {
					// 1、当银行划扣记录信息的关联单类型为订单[0]时，更新“订单表[FX_SW_ORDER]”表的“划扣状态[DEDUCTSTATE]”为“成功[SUCCESS]”，
					// “实收金额[ACTAMT]”为银行划扣记录表中的划扣金额，“到账时间[PAYTIME]”为当前接口响应时间，“订单状态[ORDERSTATE]”为“已收费[CHARGED]”；
					//						
					// 新增数据到订单任务表[FX_SW_ORDERTASK]，编号取库表序列，地市标识取当前地市（如GZ、SW），订单编号取当前订单编号，有效性取有效[1]；
					// 创建时间取当前时间；

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
					// 2、当银行划扣记录信息的关联单类型为垫资单（1）时，更新垫资订单汇总表
					// (FX_SW_ADPAYSUM)的状态为“已支付[PAYMENT]”;

					Adpaysum adpaysumBO = (Adpaysum) BOFactory.build(
							AdpaysumBO.class, user);
					AdpaysumVO adpaysumVO = adpaysumBO.doFindByPk(Long
							.parseLong(bankdeductVO.getOrderid()));
					if (adpaysumVO != null)
						adpaysumVO.setState("PAYMENT");

					 adpaysumBO.doUpdate(adpaysumVO);

				} else if (sh == 2) {
					// 3、当银行划扣记录信息的关联单类型为保证金上缴单（2）时，更新保证金申请单表(FX_SW_BONDFORM)的状态为“已支付[8]”;

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
				waitreqVO.setSmstype(Short.parseShort("3"));// 短信类型
				waitreqVO.setAreacode(user.getCityid());// 区域标识
				waitreqVO.setCreattime(new Date(System.currentTimeMillis()));// 生成时间
				if (bankdeductVO.getCallnum() != null)
					waitreqVO.setRecno(bankdeductVO.getCallnum());// 发送号码
				waitreqVO.setDealcount(Short.parseShort("0"));// 处理次数
				waitreqVO.setIssuccess(Short.parseShort("0"));// 处理状态
				// 发送号码
				SysparamBO sysparamBO = (SysparamBO) BOFactory.build(
						SysparamBO.class, user);
				String sysstr = sysparamBO.doFindByID(42L, "pboss_fx");
				waitreqVO.setSendno(sysstr);
				// 短信模版
				SmstmplBO smstmplBO = (SmstmplBO) BOFactory.build(
						SmstmplBO.class, user);
				SmstmplVO smstmplVO = smstmplBO.doFindByPk("FX_DEDUCTFAIL");
				waitreqVO.setMessage(smstmplVO.getScontent());

				WaitreqBO waitreqBO = (WaitreqBO) BOFactory.build(
						WaitreqBO.class, user);

				// 插入短信待发送表
				if (waitreqVO.getRecno() == null
						|| waitreqVO.getRecno().equals("")
						|| waitreqVO.getSendno() == null
						|| waitreqVO.getSendno().equals("")
						|| waitreqVO.getMessage() == null
						|| waitreqVO.getMessage().equals("")) {
					throw new Exception("发送号码/接收号码/短信内容为空！");
				} else {
					 waitreqBO.doInsert3(waitreqVO.getSmstype(),
					 waitreqVO.getMessage(), waitreqVO.getSendno(),
					 waitreqVO.getRecno(), new
					 Date(System.currentTimeMillis()));
				}

				// 关联订单类型
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

	
	// 对银行划扣记录进行分类
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
