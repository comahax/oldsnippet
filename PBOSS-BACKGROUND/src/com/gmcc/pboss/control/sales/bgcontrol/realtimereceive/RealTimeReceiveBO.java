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
	 * 当请求发送失败后，回滚银行划扣记录表的划扣记录（此方法处理实时代收处理请求失败）
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
	 * 封装实时代收请求对象
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

		
		//头信息
		realTimeReceiveInfoReq.setUser_name(username);
		realTimeReceiveInfoReq.setUser_pass(password);
		realTimeReceiveInfoReq.setTrx_code("100004");
		realTimeReceiveInfoReq.setSigned_msg("");
		realTimeReceiveInfoReq.setLevel(Short.parseShort("0"));
		realTimeReceiveInfoReq.setData_type(Short.parseShort("2"));
		realTimeReceiveInfoReq.setVersion("04");
		realTimeReceiveInfoReq.setReq_sn("GDCM" + user.getCityid() + sdates);

		
		//统计信息
		realTimeReceiveSumReq.setBusiness_code("14900");
		realTimeReceiveSumReq.setSubmit_time(sdate);
		realTimeReceiveSumReq.setTotal_item((long) 1);
		realTimeReceiveSumReq.setMerchant_id(bankdeductVO.getShopnum());

		//详细信息
		realTimeReceiveDetailsReq.setAccount_no(bankdeductVO.getAcctnum());
		realTimeReceiveDetailsReq.setAccount_name(bankdeductVO.getAcctname());
		realTimeReceiveDetailsReq.setBank_code(bankdeductVO.getBankid());
		realTimeReceiveDetailsReq.setAmount(Long.parseLong(df
				.format(bankdeductVO.getDeductamt() * 100)));
		realTimeReceiveDetailsReq.setSn(bankdeductVO.getDeductid().toString());
		realTimeReceiveDetailsReq.setAccount_type("00");
		realTimeReceiveDetailsReq.setAccount_prop("0");
		realTimeReceiveDetailsReq.setProvince("广东");
		realTimeReceiveDetailsReq.setCity(Code2NameUtils.code2Name("CITYNAME",
				user.getCityid(), user.getCityid()));

		
		trans_Details.add(realTimeReceiveDetailsReq);

		
		realTimeReceiveSumReq.setTotal_sum(Long.parseLong(df
				.format(realTimeReceiveDetailsReq.getAmount())));

		
		//请求对象
		realTimeReceiveRequest.setInfo(realTimeReceiveInfoReq);
		realTimeReceiveRequest.setTrans_Sum(realTimeReceiveSumReq);
		realTimeReceiveRequest.setTrans_Details(trans_Details);

		return realTimeReceiveRequest;
	}

	
	/**
	 * 发送请求
	 */
	public RealTimeReceiveResponse sendInfo(RealTimeReceiveRequest realTimeReceiveRequest)
			throws Exception {

		// 发送请求
		BankUniteProcessCom bankUniteProcessCom = new BankUniteProcessCom();
		bankUniteProcessCom.initPropertie(user.getCityid());
		bankUniteProcessCom.setLog(log);
		RealTimeReceiveResponse recBatchResponse = (RealTimeReceiveResponse) bankUniteProcessCom
				.sendMsg(realTimeReceiveRequest, true, RealTimeReceiveResponse.class);

		return recBatchResponse;
	}

	/**
	 * 处理代收返回的内容
	 */
	public void dealResponse(RealTimeReceiveResponse realTimeReceiveResponse)
			throws Exception {

		Bankdeduct bankdeduct = (Bankdeduct) BOFactory.build(
				BankdeductBO.class, user);

		for (Iterator<RealTimeReceiveDetailsRes> it = realTimeReceiveResponse
				.getRet_Details().iterator(); it.hasNext();) {
			RealTimeReceiveDetailsRes realTimeReceiveDetailsRes = it.next();

			// 根据返回的记录序号（划扣记录号）找到响应的银行划扣记录，更新“银行划扣记录表[FX_SW_BANKDEDUCT]”中“处理状态[STATE]”为“已完成[PROCOVER]”、
			// “状态变更时间[STATECHGTIME]”为当前时间；
			BankdeductVO bankdeductVO = bankdeduct.doFindByPk(Long
					.parseLong(realTimeReceiveDetailsRes.getSn()));
			bankdeductVO.setState("PROCOVER");
			bankdeductVO.setStatechgtime(new Date(System.currentTimeMillis()));
			bankdeductVO.setReqsn(realTimeReceiveResponse.getInfo().getReq_sn());
			
			if (realTimeReceiveDetailsRes.getRet_code().equals("0000")) {
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
						
//						当划扣成功和划扣关联单类型为订单时，最后调用【订单下一步处理公用方法】。
						order.doNextProcess(ordervo.getOrderid());
						
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
					waitreqBO.doInsert3(waitreqVO.getSmstype(), waitreqVO
							.getMessage(), waitreqVO.getSendno(), waitreqVO
							.getRecno(), new Date(System.currentTimeMillis()));
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
						
						//当划扣为失败和划扣关联单类型为订单时,查询系统参数，调用订单作废逻辑
						SysparamBO sysparambo = (SysparamBO)BOFactory.build(SysparamBO.class, user);
						String paramvalue=sysparambo.doFindByID("78", "pboss_fx");
						if(paramvalue != null && paramvalue.equals("1")){
							//调用订单作废逻辑
							String [] orderid = new String[1];
							orderid[0] = ordervo.getOrderid();
							order.cancleOrder(orderid, "划扣失败", null); 
							//order.doCancle(ordervo);
						}
						
					}
				}
			}
			bankdeduct.doUpdate(bankdeductVO);
		}
	}

}
