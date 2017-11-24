/**
 * auto-generated code
 * Wed Nov 18 17:19:05 CST 2009
 */
package com.gmcc.pboss.control.sales.orderrequestdeal;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.gmcc.pboss.business.base.sysparam.SysparamDBParam;
import com.gmcc.pboss.business.base.sysparam.SysparamVO;
import com.gmcc.pboss.business.channel.waitreq.WaitreqVO;
import com.gmcc.pboss.business.channel.way.WayDBParam;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.sales.comorder.ComorderVO;
import com.gmcc.pboss.business.sales.order.OrderVO;
import com.gmcc.pboss.business.sales.orderreq.OrderreqVO;
import com.gmcc.pboss.business.sales.orderresdet.OrderresdetDBParam;
import com.gmcc.pboss.business.sales.reqcomcate.ReqcomcateDBParam;
import com.gmcc.pboss.business.sales.reqcomcate.ReqcomcateVO;
import com.gmcc.pboss.business.sales.smsconfirm.SmsconfirmVO;
import com.gmcc.pboss.business.sales.wayassistant.WayassistantVO;
import com.gmcc.pboss.common.sms.ComOrderSms;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.channel.waitreq.Waitreq;
import com.gmcc.pboss.control.channel.waitreq.WaitreqBO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.sales.comorder.Comorder;
import com.gmcc.pboss.control.sales.comorder.ComorderBO;
import com.gmcc.pboss.control.sales.orderreq.Orderreq;
import com.gmcc.pboss.control.sales.orderreq.OrderreqBO;
import com.gmcc.pboss.control.sales.orderresdet.Orderresdet;
import com.gmcc.pboss.control.sales.orderresdet.OrderresdetBO;
import com.gmcc.pboss.control.sales.reqcomcate.Reqcomcate;
import com.gmcc.pboss.control.sales.reqcomcate.ReqcomcateBO;
import com.gmcc.pboss.control.sales.smsconfirm.Smsconfirm;
import com.gmcc.pboss.control.sales.smsconfirm.SmsconfirmBO;
import com.gmcc.pboss.control.sales.wayassistant.Wayassistant;
import com.gmcc.pboss.control.sales.wayassistant.WayassistantBO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.exception.business.SaleException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: OrderreqBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class OrderRequestDealBO extends AbstractControlBean implements
		OrderRequestDeal {
	private static final String STATE_INVALID = "0";
	private static final String STATE_EFFECTIVE = "1";
	private static final String PARAMTYPE_PBOSS_FX = "pboss_fx";
	private static final String SYSTEMID_RESDET = "15";
	//类型（社会渠道）
	private static final String WAYTYPE_AG = "AG";
	
	public void doProcess(OrderreqVO orderreqVO) throws Exception{
		try {
			Waitreq waitreq = (Waitreq)BOFactory.build(WaitreqBO.class, user);
			Orderreq orderreq = (Orderreq)BOFactory.build(OrderreqBO.class, user);
			
			String wayid = orderreqVO.getWayid();
			
	    	//1)获取合作商资料
			Way way = (Way)BOFactory.build(WayBO.class, user);
			WayDBParam param = new WayDBParam();
			param.set_se_wayid(wayid);
			param.set_se_waytype(WAYTYPE_AG);
			DataPackage dp = way.doQuery(param);
			
			//无数据，则更新商品订购请求表状态为0-无效、备注为“合作商基本信息不存在”
			if(null==dp ||dp.getDatas().size()==0){
				orderreq = (Orderreq)BOFactory.build(OrderreqBO.class, user, BOFactory.PROPAGATION_REQUIRES_NEW);
				orderreqVO.setState(Short.valueOf(STATE_INVALID));
				orderreqVO.setMemo("合作商基本信息不存在!");
				orderreq.doUpdate(orderreqVO);
				throw new Exception("合作商基本信息不存在!");
			}
			WayVO wayVO = ((List<WayVO>)dp.getDatas()).get(0);
			
			//获取paytype 和 delitype
			Wayassistant wayassistant = (Wayassistant) BOFactory.build(WayassistantBO.class, user);
			WayassistantVO wayassistantVO = wayassistant.doFindByPk(wayid);
			wayVO.setPaytype(wayassistantVO.getPaytype());
			wayVO.setDelitype(wayassistantVO.getDelitype());
			
			//2)商品订购检查
			String reqid = orderreqVO.getReqid();
			Reqcomcate reqcomcate = (Reqcomcate)BOFactory.build(ReqcomcateBO.class, user);
			ReqcomcateDBParam param2 = new ReqcomcateDBParam();
			param2.set_se_reqid(reqid);
			DataPackage dp2 = reqcomcate.doQuery(param2);
			if(null==dp2 ||dp2.getDatas().size()==0)
			{
				orderreq = (Orderreq)BOFactory.build(OrderreqBO.class, user, BOFactory.PROPAGATION_REQUIRES_NEW);
				orderreqVO.setState(Short.valueOf(STATE_INVALID));
				orderreqVO.setMemo("订购商品种类不存在!");
				orderreq.doUpdate(orderreqVO);
				throw new Exception("订购商品种类不存在!");
			}
			
			Comorder comorder = (Comorder)BOFactory.build(ComorderBO.class, user);
			//将查到的订购请求列表信息放入订购列表
			List<ComorderVO> comorderList = new LinkedList<ComorderVO>();
			List<ReqcomcateVO> reqcomcateList = (List<ReqcomcateVO>)dp2.getDatas();
			Double unitprice = null;
			try{
				for(ReqcomcateVO reqcomcateVO : reqcomcateList)
				{
					ComorderVO comorderVO = new ComorderVO();
					comorderVO.setComcategory(reqcomcateVO.getComcategory());
					comorderVO.setOrderamount(reqcomcateVO.getOrderamt());
					
					//unitprice = comorder.doGetUnitprice(wayid, reqcomcateVO.getComcategory());
					Map map = comorder.doGetUnitpriceAndPlancode(wayid, reqcomcateVO.getComcategory());
					String planCode = (String)map.get("planCode");
					comorderVO.setPlanCode(planCode);
					String unitpriceString = (String)map.get("unitprice");					
					if(unitpriceString != null && !"".equals(unitpriceString)){
						unitprice = Double.parseDouble(unitpriceString);
					}
					
					comorderVO.setUnitprice(unitprice);
					comorderVO.setTotalprice(unitprice*reqcomcateVO.getOrderamt());
					comorderList.add(comorderVO);
				}
			}catch(SaleException e){
				waitreq = (Waitreq)BOFactory.build(WaitreqBO.class, user, BOFactory.PROPAGATION_REQUIRES_NEW);
				orderreq = (Orderreq)BOFactory.build(OrderreqBO.class, user, BOFactory.PROPAGATION_REQUIRES_NEW);
				
				ComOrderSms sms = new ComOrderSms();
				orderreqVO.setState(Short.valueOf(STATE_INVALID));
				orderreqVO.setMemo(e.getMessage());
				orderreq.doUpdate(orderreqVO);
				
				waitreq.doInsert(Short.valueOf("3"), sms.getBusiSms(e,user), orderreqVO.getMobileno());
				throw new Exception("订购请求" + reqid + "未检查通过，原因为："+e.getMessage());
			} catch (Exception ex) {
				ex.printStackTrace();
				throw ex;
			}
			
			//渠道检查
			Set<String> brandSet = null;
			try{
				String storarea = comorder.doGetStorArea(wayVO);
				//订单检查
				brandSet = comorder.comOrderCheck(wayid, comorderList, storarea);
			}catch(SaleException e){
				waitreq = (Waitreq)BOFactory.build(WaitreqBO.class, user, BOFactory.PROPAGATION_REQUIRES_NEW);
				orderreq = (Orderreq)BOFactory.build(OrderreqBO.class, user, BOFactory.PROPAGATION_REQUIRES_NEW);
				
				ComOrderSms sms = new ComOrderSms();
				orderreqVO.setState(Short.valueOf(STATE_INVALID));
				orderreqVO.setMemo(e.getMessage());
				orderreq.doUpdate(orderreqVO);
				
				waitreq.doInsert(Short.valueOf("3"), sms.getBusiSms(e,user), orderreqVO.getMobileno());
				throw new Exception("订购请求" + reqid + "未检查通过，原因为："+e.getMessage());
			}catch (Exception ex) {
				ex.printStackTrace();
				throw ex;
			}
			
			//3)创建订单
			String orderid = orderreqVO.getReqid();
			try{
				String storarea = comorder.doGetStorArea(wayVO);
				comorder.doBuildOrder(orderid, wayVO, storarea, comorderList, brandSet, orderreqVO.getOrderave(),null);
			}catch(SaleException e){
				waitreq = (Waitreq)BOFactory.build(WaitreqBO.class, user, BOFactory.PROPAGATION_REQUIRES_NEW);
				orderreq = (Orderreq)BOFactory.build(OrderreqBO.class, user, BOFactory.PROPAGATION_REQUIRES_NEW);
				
				ComOrderSms sms = new ComOrderSms();
				orderreqVO.setState(Short.valueOf(STATE_INVALID));
				orderreqVO.setMemo(e.getMessage());
				orderreq.doUpdate(orderreqVO);
				
				waitreq.doInsert(Short.valueOf("3"), sms.getBusiSms(e,user), orderreqVO.getMobileno());
				throw new Exception("订购请求" + reqid + "未检查通过，原因为："+e.getMessage());
			}catch (Exception ex) {
				ex.printStackTrace();
				throw ex;
			}
			
			//4)商品资源抽取
			Sysparam sysparam = (Sysparam)BOFactory.build(SysparamBO.class, user);
			SysparamDBParam param3 = new SysparamDBParam();
			param3.set_se_paramtype(PARAMTYPE_PBOSS_FX);
			param3.set_ne_systemid(SYSTEMID_RESDET);
			DataPackage dp3 = sysparam.doQuery(param3);
			
			//如果无数据或参数值错误（空值、不等于0或1），则更新商品订购请求表状态为0-无效、备注为“资源明细查看参数设置错误”
			if(null==dp3 ||dp3.getDatas().size()==0){
				orderreq = (Orderreq)BOFactory.build(OrderreqBO.class, user, BOFactory.PROPAGATION_REQUIRES_NEW);
				orderreqVO.setState(Short.valueOf(STATE_INVALID));
				orderreqVO.setMemo("资源明细查看参数设置错误!");
				orderreq.doUpdate(orderreqVO);
				throw new Exception("资源明细查看参数设置错误!");
			}
			else
			{
				String paramValue = ((List<SysparamVO>)dp3.getDatas()).get(0).getParamvalue();
				if(null!=paramValue && (paramValue.equals(STATE_INVALID)||paramValue.equals(STATE_EFFECTIVE)))
				{
					if(paramValue.equals(STATE_EFFECTIVE))
					{
						try{
							//抽取资源
							Orderresdet orderresdet = (Orderresdet)BOFactory.build(OrderresdetBO.class,user);
							OrderresdetDBParam orderresdetDBParam=new OrderresdetDBParam();
							orderresdetDBParam.set_se_orderid(orderid);
							orderresdet.doResdraw(orderresdetDBParam,false);//抽取方法
							
						}catch(SaleException e){
							waitreq = (Waitreq)BOFactory.build(WaitreqBO.class, user, BOFactory.PROPAGATION_REQUIRES_NEW);
							orderreq = (Orderreq)BOFactory.build(OrderreqBO.class, user, BOFactory.PROPAGATION_REQUIRES_NEW);
							
							ComOrderSms sms = new ComOrderSms();
							orderreqVO.setState(Short.valueOf(STATE_INVALID));
							orderreqVO.setMemo(e.getMessage());
							orderreq.doUpdate(orderreqVO);
							
							waitreq.doInsert(Short.valueOf("3"), sms.getBusiSms(e,user), orderreqVO.getMobileno());
							throw new Exception("订购请求" + reqid + "未检查通过，原因为："+e.getMessage());
						}catch (Exception ex) {
							ex.printStackTrace();
							throw ex;
						}
					}
				}
				else
				{
					orderreq = (Orderreq)BOFactory.build(OrderreqBO.class, user, BOFactory.PROPAGATION_REQUIRES_NEW);
					orderreqVO.setState(Short.valueOf(STATE_INVALID));
					orderreqVO.setMemo("资源明细查看参数设置错误!");
					orderreq.doUpdate(orderreqVO);
					throw new Exception("资源明细查看参数设置错误!");
				}
			}
			
			//5)更新订购请求
			orderreqVO.setState(Short.valueOf(STATE_INVALID));
			orderreqVO.setMemo("订单已建立");
			orderreq.doUpdate(orderreqVO);
			
			//发送短信
			//ComOrderSms sms = new ComOrderSms();
			/*//waitreq.doInsert(Short.valueOf("3"), sms.getSuccessSms(orderid,user), orderreqVO.getMobileno());
			Order orderBO=(Order) BOFactory.build(OrderBO.class,user);
			OrderVO orderVO=orderBO.doFindByPk(orderid);
			doSaveConfirmSms(orderVO,orderreqVO.getMobileno());
		*/
			//调用【订单下一步处理公用方法】
			comorder.doNextProcess(orderid);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}
	public void doSaveConfirmSms(OrderVO orderVO,String moblieno) throws Exception{
		Sysparam sysparamBO=(Sysparam)BOFactory.build(SysparamBO.class,user);
		Waitreq  waitreqBO=(Waitreq)BOFactory.build(WaitreqBO.class,user);
		//获取短信发送号码
		String sysparamvalue42=sysparamBO.doFindByID("42", "pboss_fx");
		WaitreqVO waitreqVO=null;
		ComOrderSms comOrderSms=new ComOrderSms();
		waitreqVO.setSmstype((short)3);
		waitreqVO.setAreacode(user.getCityid());
		waitreqVO.setCreattime(new java.util.Date());
		waitreqVO.setSendno(sysparamvalue42);
		waitreqVO.setRecno(moblieno);
		if(!"WAITCON".equals(orderVO.getOrderstate())){
			waitreqVO.setMessage(comOrderSms.getSuccessSms(orderVO.getOrderid(), user));//短信内容调用商品订购短信公用方法（订购成功短信）获取。
		}else{
			SmsconfirmVO smsconvo=new SmsconfirmVO();
			smsconvo.setType("ORDERCON");//类型取订购二次确认
			smsconvo.setStream(orderVO.getOrderid().substring(orderVO.getOrderid().length()-4, orderVO.getOrderid().length()));//确认流水号取订单末尾4位
			smsconvo.setOrderid(orderVO.getOrderid());//关联订单号取订单编号
			smsconvo.setState("WAITREP");//状态取待回复
			smsconvo.setSendtime(new Date());//通知时间取当前时间
			smsconvo.setMobileno(moblieno);
			Smsconfirm  smsconfirmBO=(Smsconfirm) BOFactory.build(SmsconfirmBO.class,user);
			smsconfirmBO.doCreate(smsconvo);
			waitreqVO.setMessage(comOrderSms.getConfirmSms(orderVO.getOrderid(), user));//短信内容调用商品订购短信公用方法获取“订购确认通知”
		}
		waitreqBO.doCreate(waitreqVO);
	}

}
