 /**
 * auto-generated code
 * Wed Oct 14 17:29:02 CST 2009
 */
package com.gmcc.pboss.control.sales.disform;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import com.gmcc.pboss.business.channel.employee.EmployeeDBParam;
import com.gmcc.pboss.business.channel.employee.EmployeeVO;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.resource.com.ComDBParam;
import com.gmcc.pboss.business.resource.com.ComVO;
import com.gmcc.pboss.business.resource.comcategoryrela.ComcategoryrelaDBParam;
import com.gmcc.pboss.business.resource.comcategoryrela.ComcategoryrelaVO;
import com.gmcc.pboss.business.resource.comressmp.ComressmpDBParam;
import com.gmcc.pboss.business.resource.comressmp.ComressmpVO;
import com.gmcc.pboss.business.sales.comprice.CompriceDBParam;
import com.gmcc.pboss.business.sales.comprice.CompriceVO;
import com.gmcc.pboss.business.sales.disform.DisformDAO;
import com.gmcc.pboss.business.sales.disform.DisformDBParam;
import com.gmcc.pboss.business.sales.disform.DisformVO;
import com.gmcc.pboss.business.sales.disform.GDisformDAO;
import com.gmcc.pboss.business.sales.disform.GDisformVO;
import com.gmcc.pboss.business.sales.disform.PDisformDAO;
import com.gmcc.pboss.business.sales.disform.PDisformVO;
import com.gmcc.pboss.business.sales.disform.SDisformDAO;
import com.gmcc.pboss.business.sales.disform.VDisformDAO;
import com.gmcc.pboss.business.sales.order.OrderVO;
import com.gmcc.pboss.business.sales.orderresdet.OrderresdetDBParam;
import com.gmcc.pboss.business.sales.orderresdet.OrderresdetVO;
import com.gmcc.pboss.business.sales.smsconfirm.SmsconfirmVO;
import com.gmcc.pboss.business.sales.wayassistant.WayassistantVO;
import com.gmcc.pboss.control.base.smstmpl.Smstmpl;
import com.gmcc.pboss.control.base.smstmpl.SmstmplBO;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.channel.employee.Employee;
import com.gmcc.pboss.control.channel.employee.EmployeeBO;
import com.gmcc.pboss.control.channel.waitreq.Waitreq;
import com.gmcc.pboss.control.channel.waitreq.WaitreqBO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.resource.com.ComBO;
import com.gmcc.pboss.control.resource.comcategoryrela.ComcategoryrelaBO;
import com.gmcc.pboss.control.resource.comressmp.ComressmpBO;
import com.gmcc.pboss.control.sales.comprice.CompriceBO;
import com.gmcc.pboss.control.sales.order.OrderBO;
import com.gmcc.pboss.control.sales.orderresdet.OrderresdetBO;
import com.gmcc.pboss.control.sales.smsconfirm.Smsconfirm;
import com.gmcc.pboss.control.sales.smsconfirm.SmsconfirmBO;
import com.gmcc.pboss.control.sales.wayassistant.WayassistantBO;
import com.sunrise.jop.common.utils.lang.Code2NameUtils;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>
 * Title: DisformBO
 * </p>;
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author LiZhaoLiang
 * @version 1.0
 */
/**
 * @ejb.bean local-jndi-name="com/sunrise/jop/business/sales/disform/control/DisformBO"
 *           name="Disform" view-type="local" type="Stateless"
 * 
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class DisformBO extends AbstractControlBean implements Disform {
	public static final String DISFORM_SIGNED = "SIGNED";

	public DisformVO doCreate(DisformVO vo) throws Exception {
		try {
			DisformDAO dao = (DisformDAO) DAOFactory.build(DisformDAO.class,
					user);
			// TODO set the pk */
			return (DisformVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(DisformVO vo) throws Exception {
		try {
			DisformDAO dao = (DisformDAO) DAOFactory.build(DisformDAO.class,
					user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			DisformDAO dao = (DisformDAO) DAOFactory.build(DisformDAO.class,
					user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public DisformVO doUpdate(DisformVO vo) throws Exception {
		try {
			DisformDAO dao = (DisformDAO) DAOFactory.build(DisformDAO.class,
					user);
			return (DisformVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	/**
	 * 更新配送单和订单状态并新增数据到短信待发送表
	 */
	public void doUpdateOrder(DisformVO vo) throws Exception {
		try {
			DisformBO dfbo = (DisformBO) BOFactory.build(DisformBO.class, user);
			OrderBO orderbo = (OrderBO) BOFactory.build(OrderBO.class, user);
			Smstmpl smsBO = (Smstmpl) BOFactory.build(SmstmplBO.class, user);
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
			OrderVO ordervo = orderbo.doFindByPk(vo.getOrderid());
			if (ordervo != null) {
				ordervo.setSignstate("WAITSIGN");
				// 更新订单状态
				orderbo.doUpdate(ordervo);
				// 更新配送单状态
				dfbo.doUpdate(vo);
			} else {
				throw new JOPException(" 订单信息不存在! ");
			}
			// 短信改造版本 TODO
			EmployeeBO employbo = (EmployeeBO) BOFactory.build(
					EmployeeBO.class, user);
			EmployeeDBParam employparam = new EmployeeDBParam();
			employparam.set_se_wayid(ordervo.getWayid());
			// 店主
			employparam.set_ne_isnet("1");
			// 在岗
			employparam.set_ne_empstatus("0");

			DataPackage emdp = employbo.doQuery(employparam);
			if (emdp != null && emdp.getDatas().size() > 0) {
				EmployeeVO empvo = (EmployeeVO) emdp.getDatas().get(0);
				String mobile = empvo.getOfficetel();
				// 如果人员姓名无数据或为空，则默认取“客户”
				if ("".equals(empvo.getEmployeename())
						|| null == empvo.getEmployeename()) {
					empvo.setEmployeename("客户");
				}
				// 8位年月日yyyyMMdd
				String date = format.format(new Date());
				String year = date.substring(0, 4);
				String month = date.substring(4, 6);
				String day = date.substring(6, 8);
				// 分公司取自订单表，要求进行中文翻译
				String countryid = Code2NameUtils.code2Name("#CNTYCOMPANY",
						ordervo.getCountyid(), user.getCityid());
				//物流单信息内容取物流单号，如果无数据则为空 
				String logisticsinfo = vo.getLogisticsno(); 
				if (null == logisticsinfo || ("").equals(logisticsinfo)) {
					logisticsinfo = " ";
				}
				String sId = "FX_ORDER_PARSIGNREM";
				Map<String, String> keyAndValue = new HashMap<String, String>();
				keyAndValue.put("CUSTNAME", empvo.getEmployeename());
				keyAndValue.put("YEAR", year);
				keyAndValue.put("MONTH", month);
				keyAndValue.put("DAY", day);
				keyAndValue.put("COUNTYID", countryid); 
				keyAndValue.put("LOGISTICSINFO", logisticsinfo);
				  
				// 生成短信内容
				String content = smsBO.doGenSMS(sId, keyAndValue);
				if (!"".equals(mobile) && !"".equals(content)) {
					Waitreq waitreq = (Waitreq) BOFactory.build(
							WaitreqBO.class, user);
					waitreq.doInsert(Waitreq.SMS_FX, content, mobile);
				}
			}
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public DisformVO doFindByPk(Serializable pk) throws Exception {
		DisformDAO dao = (DisformDAO) DAOFactory.build(DisformDAO.class, user);
		return (DisformVO) dao.findByPk(pk);
	}

	/**
	 * 查询配送单列表结果集
	 * 
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public DataPackage doQuery(DisformDBParam params) throws Exception {
		DisformDAO dao = (DisformDAO) DAOFactory.build(DisformDAO.class, user);
		return dao.query(params);
	}

	/**
	 * 配送单列表查询
	 * 
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public DataPackage doQuerydp(DisformDBParam params) throws Exception {
		VDisformDAO dao = (VDisformDAO) DAOFactory.build(VDisformDAO.class,
				user);
		return dao.doDisformList(params);
	}

	/**
	 * 查询打印配送单信息结果集
	 * 
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public DataPackage doQueryPrint(DisformDBParam params) throws Exception {
		PDisformDAO dao = (PDisformDAO) DAOFactory.build(PDisformDAO.class,
				user);
		return dao.doDisformPrint(params);
	}

	public DataPackage doGatherPrintDp(DisformDBParam params) throws Exception {
		GDisformDAO dao = (GDisformDAO) DAOFactory.build(GDisformDAO.class,
				user);
		return dao.doGatherPrintDp(params);
	}

	/**
	 * 查询打印配送单列表结果集
	 * 
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public DataPackage doQueryPrintDp(DisformDBParam params) throws Exception {
		PDisformDAO dao = (PDisformDAO) DAOFactory.build(PDisformDAO.class,
				user);
		return dao.doDisformPrintDp(params);
	}

	/**
	 * 物品编号查询结果集-"批次-包号(数量)"
	 * 
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public DataPackage doBatchnoBoxnumDp(OrderresdetDBParam params)
			throws Exception {
		PDisformDAO dao = (PDisformDAO) DAOFactory.build(PDisformDAO.class,
				user);
//		ComressmpDBParam smpparams = new ComressmpDBParam();
//		PDisformVO vo = new PDisformVO();
//		DataPackage dp = dao.doBatchnoBoxnumDp(params);
//		if(dp!=null||dp.getDatas().size()>0){
//			for(int i=0;i<dp.getDatas().size();i++){
//				vo = (PDisformVO) dp.getDatas().get(0);
//				smpparams.set_se_batchno(vo.getBatchno());
//				smpparams.set_se_boxnum(vo.getBoxnum());
//			}
//		}
		
		return dao.doBatchnoBoxnumDp(params);
//		return null;
	}

	/**
	 * 物品编号查询结果集-"最大~最小(数量)"
	 * 
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public DataPackage doMinMaxComresidDp(OrderresdetDBParam params)
			throws Exception {
		PDisformDAO dao = (PDisformDAO) DAOFactory.build(PDisformDAO.class,
				user);
		return dao.doMinMaxComresidDp(params);
	}
	
	public DataPackage doQueryDisState(DisformDBParam params) throws Exception {
		SDisformDAO dao = (SDisformDAO) DAOFactory.build(SDisformDAO.class,
				user);
		return dao.doDisformState(params);
	}
	
	public DataPackage doQuerySignnum(DisformDBParam params) throws Exception{
		SDisformDAO dao = (SDisformDAO) DAOFactory.build(SDisformDAO.class,
				user);
		return dao.doQuerySignnum(params);
	}

	/**
	 * 查询"批次号-包号(数量)"相同的记录数
	 * 
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public String doGetBatchnoBoxnum(PDisformVO vo) throws Exception {
		try {
			String result = "";
			String tempresult = "";
			DisformBO dfbo = (DisformBO) BOFactory.build(DisformBO.class, user);
			ComressmpBO resbo = (ComressmpBO) BOFactory.build(
					ComressmpBO.class, user);
			OrderresdetDBParam detparams = new OrderresdetDBParam();
			
			ComressmpVO comressmpvo = new ComressmpVO();
			detparams.set_se_orderid(vo.getOrderid());
			detparams.set_se_ordercomtype(vo.getOrdercomtype());
			detparams.set_se_comcategory(vo.getComcategory());
			DataPackage dp = dfbo.doBatchnoBoxnumDp(detparams);
			if (dp != null && dp.getDatas().size() > 0) {
				for (int i = 0; i < dp.getDatas().size(); i++) {
					ComressmpDBParam resparams = new ComressmpDBParam();
					PDisformVO detvo = (PDisformVO) dp.getDatas().get(i);
					resparams.set_se_batchno(detvo.getBatchno());
					resparams.set_se_boxnum(detvo.getBoxnum());
					if (detvo.getInsideseq() == 0) {
						DataPackage comressmpdp = resbo.doQuery(resparams);
						comressmpvo = (ComressmpVO) comressmpdp.getDatas().get(
								0);
						detvo.setComresid(comressmpvo.getComresid());
					} else {
						resparams.set_ne_insideseq(detvo.getInsideseq()
								.toString());
						DataPackage comressmpdp = resbo.doQuery(resparams);
						comressmpvo = (ComressmpVO) comressmpdp.getDatas().get(
								0);
						detvo.setComresid(comressmpvo.getComresid());
					}
					tempresult = tempresult + detvo.getBatchno() + "-"
							+ detvo.getBoxnum() + "(" + detvo.getNum() + ")"
							+ " " + detvo.getComresid() + ",<br/>";
				}
				// 拼装结果集, 去掉最后一个逗号。
				result = tempresult.substring(0, tempresult.length() - 6) + "&nbsp;";
			}
			return result;
		} catch (Exception ex) {
			throw new JOPException(ex);
		}

	}

	/**
	 * 查询最小资源编号~最打资源编号(数量)
	 */
	public String doGetMinMaxComresid(PDisformVO vo) throws Exception {
		String result = "";
		OrderresdetBO detBO = (OrderresdetBO) BOFactory.build(OrderresdetBO.class, user);
		OrderresdetDBParam detparams = new OrderresdetDBParam();
		detparams.set_se_orderid(vo.getOrderid());
		detparams.set_se_ordercomtype(vo.getOrdercomtype());
		detparams.set_se_comcategory(vo.getComcategory());
		detparams.set_orderby("comresid");
		detparams.set_desc("0"); //升序
		detparams.set_pagesize("0"); //查询所有，不分页
		
		DataPackage dp = detBO.doQuery(detparams);
		if (dp != null && dp.getDatas().size() > 0) {
			long beginValue = -1;
			long preValue = -1;
			long nowValue = -1;
			for (int i = 0; i < dp.getDatas().size(); i++) {
				OrderresdetVO detVO = (OrderresdetVO) dp.getDatas().get(i);
				if (null != detVO.getComresid() && detVO.getComresid().trim().length() > 0) {
					nowValue = new Long(detVO.getComresid().trim()).longValue();
					if (beginValue == -1) { //首次
						beginValue = nowValue;
						preValue = nowValue;
						continue;
					}
					if (nowValue == (preValue + 1)) { // 连续
						preValue = nowValue;
					} else if (beginValue == preValue) {
						result += beginValue + "(1),\n";
						beginValue = nowValue;
						preValue = nowValue;
					} else {
						result += beginValue + "~" + preValue + "("+ (preValue-beginValue+1) +"),\n";
						beginValue = nowValue;
						preValue = nowValue;
					}
				}
			}
			
			if (beginValue > 0) { //最后处理
				if (beginValue == preValue) {
					result += beginValue + "(1),\n";
				} else {
					result += beginValue + "~" + preValue + "("+ (preValue-beginValue+1) +"),\n";
				}
				result = result.substring(0, result.length() - 2); //拼装结果集, 去掉最后一个逗号。
			}
		}
		return result;
	}

	/**
	 * 商品种类组合关系表（IM_PR_COMCATEGORYRELA），获取商品种类；根据商品种类查询商品售价表（FX_RU_COMPRICE），匹配售价区分方式为“无区分”，取售价1(price1)字段值。
	 */
	public Double doQuerySellingprice(GDisformVO vo) throws Exception {
		try {
			Double sellingprice = new Double("0");
			ComcategoryrelaBO bo = (ComcategoryrelaBO) BOFactory.build(
					ComcategoryrelaBO.class, user);
			CompriceBO compricebo = (CompriceBO) BOFactory.build(
					CompriceBO.class, user);
			ComcategoryrelaDBParam params = new ComcategoryrelaDBParam();
			CompriceDBParam compriceparams = new CompriceDBParam();
			params.set_ne_comid(vo.getComid().toString());
			DataPackage dp = bo.doQuery(params);
			//如果为空, 则默认销售价为0
			if (dp != null && dp.getDatas().size() > 0) {
				ComcategoryrelaVO relavo = (ComcategoryrelaVO) dp.getDatas()
						.get(0);
				compriceparams.set_se_comcategory(relavo.getComcategory());
				compriceparams.set_se_pricediftype("NODIF");
				compriceparams.set_se_cityid(user.getCityid());
				DataPackage compricedp = compricebo.doQuery(compriceparams);
				//如果为空, 则默认销售价为0
				if (compricedp != null && compricedp.getDatas().size() > 0) {
					CompriceVO compricevo = (CompriceVO) compricedp.getDatas()
							.get(0);
					sellingprice = compricevo.getPrice1();
				} else {
					sellingprice = new Double("0");
				}
			} else {
				sellingprice = new Double("0");
			}
			return sellingprice;
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	/**
	 * 查询商品表(IM_PR_COM)获取单价Comprice
	 */
	public Long getQueryComprice(String comid) throws Exception {
		try {
			Long comprice = new Long(0);
			ComBO combo = (ComBO) BOFactory.build(ComBO.class, user);
			ComDBParam comparams = new ComDBParam();
			comparams.set_ne_comid(comid);
			DataPackage comdp = combo.doQuery(comparams);
			ComVO vo = (ComVO) comdp.getDatas().get(0);
			comprice = vo.getComprice();
			return comprice;
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void dosSendMsg(DisformVO updatevo) throws Exception {
		Sysparam sysparamBO = (SysparamBO)BOFactory.build(SysparamBO.class,user);
		String param72 = sysparamBO.doFindByID("72", "pboss_fx");
		
		if(param72 != null && "1".equals(param72)){
			try{
				//新增数据到分销短信确认表（FX_SW_SMSCONFIRM）
				Smsconfirm smsconfirmBO = (SmsconfirmBO) BOFactory.build(SmsconfirmBO.class, user);
				SmsconfirmVO smsconfirmVO = new SmsconfirmVO();
				String orderid = updatevo.getOrderid();
				String subOrderID = "";
				if(orderid != null && orderid.length() >= 4){
					subOrderID = orderid.substring(orderid.length()-4);
				}
				String receTel = updatevo.getRecetel();//接收号码
				smsconfirmVO.setType("PARSIGN");//类型取合作商签收
				smsconfirmVO.setStream(subOrderID);//确认流水号取订单末尾4位
				smsconfirmVO.setMobileno(receTel);//手机号码取配送单中的收货人电话
				smsconfirmVO.setOrderid(orderid);//关联订单号取订单编号
				smsconfirmVO.setState("WAITREP");//状态取待回复
				smsconfirmVO.setSendtime(new Date());//通知时间取当前时间
				
				
				//回复时间和回复描述留空
				
				smsconfirmBO.doCreate(smsconfirmVO);
				
				//新增数据到短信待发送表(CH_SMS_WAITREQ)
				String param42 = sysparamBO.doFindByID("42", "pboss_fx");//发送号码
				if(param42 != null && !"".equals(param42)){
					
				}else{//处理下一条
					return;
				}
				
				if(receTel != null && !"".equals(receTel)){
					
				}else{//处理下一条
					return;
				}
				String recename = updatevo.getRecename();//客户名称取配送单中的收货人姓名
				if(recename != null && !"".equals(recename)){
					
				}else{
					recename = "客户";
				}
				//物流单信息内容取物流单号，如果无数据则为空
				String logisticsno = updatevo.getLogisticsno(); 
				if (null == logisticsno || ("").equals(logisticsno)) {
					logisticsno = " ";
				}
				
				//短信内容
				//尊敬的{CUSTNAME}，{YEAR}年{MONTH}月{DAY}日配送的物资（订单号：{ ORDERID }）
				//是否收到，回复"Q{STREAM}"确认签收，回复"N{STREAM}"拒绝签收。广东移动。
				Calendar calendar = Calendar.getInstance();		
				Map<String,String> map = new HashMap<String,String>();
				map.put("CUSTNAME", recename);
				map.put("YEAR", ""+calendar.get(Calendar.YEAR));
				map.put("MONTH", calendar.get(Calendar.MONTH)+1+"");
				map.put("DAY", ""+calendar.get(Calendar.DAY_OF_MONTH));
				map.put("ORDERID", orderid);
				map.put("STREAM", subOrderID);
				map.put("LOGISTICSINFO", logisticsno);
				Smstmpl smstmplBO = (SmstmplBO)BOFactory.build(SmstmplBO.class,user);
				String smsContent = smstmplBO.doGenSMS("FX_ORDER_PARSIGNCON", map);
				if( null == smsContent || "".equals(smsContent.trim())){//处理下一条
					return;
				}
					
				Waitreq  waitreqBO = (WaitreqBO) BOFactory.build(WaitreqBO.class,user);
				waitreqBO.doInsert2(new Short("3"), smsContent, param42,receTel);
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	   public void doComfirmSignMsg(DisformVO disformVO) throws Exception{  
		   Sysparam sysparamBO = (SysparamBO)BOFactory.build(SysparamBO.class,user);
				try{ 
					Way wayBO = (WayBO)BOFactory.build(WayBO.class,user);				
					//新增数据到短信待发送表(CH_SMS_WAITREQ)
					String param42 = sysparamBO.doFindByID("42", "pboss_fx");//发送号码
					if(param42 != null && !"".equals(param42)){
						
					}else{//处理下一条
						return;
					}
					String wayid = disformVO.getDiscomcode(); //配送商编码
					WayVO wayVO = wayBO.doFindByPk(wayid);
					
					//配送商名称
					String recename = null;
					if (wayVO!=null) {
						recename = wayVO.getWayname();
					}else{
						recename = "客户";
					}
					
					//接收号码    
					Employee employeeBO = (Employee) BOFactory.build(EmployeeBO.class, user);
					EmployeeDBParam employeeDBParam = new EmployeeDBParam();
					employeeDBParam.set_se_wayid(wayid);
					employeeDBParam.set_ne_isnet("3");// 配送商
					employeeDBParam.set_ne_empstatus("0");// 在岗
					String receTel = null;
					DataPackage dp1 = employeeBO.doQuery(employeeDBParam);
					if (null != dp1 && dp1.getDatas().size() > 0) {
						EmployeeVO vo = (EmployeeVO) dp1.getDatas().get(0);
						receTel = vo.getOfficetel();
						if (null == receTel || ("").equals(receTel)) {
							throw new JOPException ("配送商手机号码不能为空！");
						}
					} 
					
					String orderid = disformVO.getOrderid(); 
					//物流单信息内容取物流单号，如果无数据则为空
					String logisticsno = disformVO.getLogisticsno(); 
					if (null == logisticsno || ("").equals(logisticsno)) {
						logisticsno = " ";
					}
					
					//短信内容
					//尊敬的{CUSTNAME}，{YEAR}年{MONTH}月{DAY}日配送的物资（订单号：{ ORDERID }）
					//是否收到，回复"Q{STREAM}"确认签收，回复"N{STREAM}"拒绝签收。广东移动。
					Calendar calendar = Calendar.getInstance();		
					Map<String,String> map = new HashMap<String,String>();
					map.put("CUSTNAME", recename);
					map.put("YEAR", ""+calendar.get(Calendar.YEAR));
					map.put("MONTH", calendar.get(Calendar.MONTH)+1+"");
					map.put("DAY", ""+calendar.get(Calendar.DAY_OF_MONTH));
					map.put("ORDERID", orderid);
					map.put("LOGISTICSINFO", logisticsno);
					Smstmpl smstmplBO = (SmstmplBO)BOFactory.build(SmstmplBO.class,user);
					String smsContent = smstmplBO.doGenSMS("FX_ORDER_COMPDIS", map);
					if( null == smsContent || "".equals(smsContent.trim())){//处理下一条
						return;
					}
						
					Waitreq  waitreqBO = (WaitreqBO) BOFactory.build(WaitreqBO.class,user);
					waitreqBO.doInsert2(new Short("3"), smsContent, param42,receTel);
					
				}catch (Exception e) {
					e.printStackTrace();
				} 
		   
	   }
	   
	   public void doDealOrderBySys(String[] selectArray) throws Exception{
		   try{
			   
		   DisformBO dfbo = (DisformBO) BOFactory.build(DisformBO.class,user); 
		   Sysparam sysparamBO = (SysparamBO)BOFactory.build(SysparamBO.class,user);
			String paramvalue = sysparamBO.doFindByID(new Long("76"), "pboss_fx");
			//如果参数值为1时则执行以下完成配送通知配送商，否则跳过
			 if (paramvalue != null && "1".equals(paramvalue)) { 
				 for (int i = 0; i < selectArray.length; i++) {
					 DisformVO dfvo = dfbo.doFindByPk(new Long(selectArray[i])); 
					 if ( dfvo != null) {
						 this.doComfirmSignMsg(dfvo);
					 }
				 }
			 }
			 //如果参数值为1时则更新订单表的订单状态为“已签收”
			 String sysvalue = sysparamBO.doFindByID(new Long("77"), "pboss_fx");
			 if ( sysvalue != null && "1".equals(sysvalue)) {
				 for (int i = 0; i < selectArray.length; i++) {
					 OrderBO orderbo = (OrderBO) BOFactory.build(OrderBO.class,user); 
					   DisformVO dfvo = dfbo.doFindByPk(new Long(selectArray[i]));
						OrderVO ordervo = orderbo.doFindByPk(dfvo.getOrderid());
						this.doUpdateOrderState(ordervo);
					}
			 }
		   
	   }catch (Exception e) {
			e.printStackTrace();
		} 

}
	   
	   public void doUpdateOrderState(OrderVO ordervo) throws Exception{
		   try{
			   OrderBO orderbo = (OrderBO) BOFactory.build(OrderBO.class,user); 
				if (ordervo != null) {
					if(ordervo.getOrderstate() != null && !ordervo.getOrderstate().equals("FINISHED")){
						ordervo.setOrderstate(DISFORM_SIGNED);
						ordervo.setStatechgtime(new Date());
						orderbo.doUpdate(ordervo);	
						
						// 参数类型为"pboss_fx"，参数标识为"84"，如果参数值为1时判断是否可发起订购
						doUpdateWayassistant(ordervo);
						
						//然后调用【订单下一步处理公用方法】，否则跳过
						orderbo.doNextProcess(ordervo.getOrderid());
					}
				}
		   }catch (Exception e) {
				e.printStackTrace();
			} 
		   }

	/**
	 * 查询系统参数配置表（IB_GL_SYSPARAM），匹配参数类型为"pboss_fx"，参数标识为"84"，如果参数值为1时
	 * 则取得订单表（fx_sw_order）中的渠道，根据渠道编码查询商品订购辅助信息表 (FX_RU_WAYASSISTANT)，
	 * 判断是否可发起订购值是否为"1"，不为"1"则修改成1，否则跳过
	 */
    public void doUpdateWayassistant(OrderVO ordervo) throws Exception {
		try {
			Sysparam sysparamBO = (SysparamBO) BOFactory.build(SysparamBO.class, user);
			String sysvalue = sysparamBO.doFindByID(new Long("84"), "pboss_fx");
			if (sysvalue != null && "1".equals(sysvalue)) {
				WayassistantBO assistantbo = (WayassistantBO) BOFactory.build(WayassistantBO.class, user);
				WayassistantVO assistantvo = assistantbo.doFindByPk(ordervo.getWayid());
				if (assistantvo.getCanorder() != 1) {
					assistantvo.setCanorder(new Short("1"));
					assistantbo.doUpdate(assistantvo);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}