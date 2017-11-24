/**
 * auto-generated code
 * Tue Oct 13 12:38:53 CST 2009
 */
package com.gmcc.pboss.control.sales.ordercomcate;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.gmcc.pboss.business.resource.comcategoryrela.ComcategoryrelaDBParam;
import com.gmcc.pboss.business.resource.comcategoryrela.ComcategoryrelaVO;
import com.gmcc.pboss.business.sales.alaordercol.AlaordercolDBParam;
import com.gmcc.pboss.business.sales.alaordercol.AlaordercolVO;
import com.gmcc.pboss.business.sales.ordcomlog.OrdcomlogVO;
import com.gmcc.pboss.business.sales.order.OrderVO;
import com.gmcc.pboss.business.sales.ordercomcate.OrdercomcateDAO;
import com.gmcc.pboss.business.sales.ordercomcate.OrdercomcateDBParam;
import com.gmcc.pboss.business.sales.ordercomcate.OrdercomcateStocksVO;
import com.gmcc.pboss.business.sales.ordercomcate.OrdercomcateVO;
import com.gmcc.pboss.business.sales.realtimeamt.RealtimeamtDBParam;
import com.gmcc.pboss.business.sales.realtimeamt.RealtimeamtVO;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.resource.comcategoryrela.Comcategoryrela;
import com.gmcc.pboss.control.resource.comcategoryrela.ComcategoryrelaBO;
import com.gmcc.pboss.control.sales.alaordercol.Alaordercol;
import com.gmcc.pboss.control.sales.alaordercol.AlaordercolBO;
import com.gmcc.pboss.control.sales.comorder.Comorder;
import com.gmcc.pboss.control.sales.comorder.ComorderBO;
import com.gmcc.pboss.control.sales.ordcomlog.Ordcomlog;
import com.gmcc.pboss.control.sales.ordcomlog.OrdcomlogBO;
import com.gmcc.pboss.control.sales.order.Order;
import com.gmcc.pboss.control.sales.order.OrderBO;
import com.gmcc.pboss.control.sales.realtimeamt.Realtimeamt;
import com.gmcc.pboss.control.sales.realtimeamt.RealtimeamtBO;
import com.sunrise.jop.common.utils.lang.Code2NameUtils;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: OrdercomcateBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class OrdercomcateBO extends AbstractControlBean implements
		Ordercomcate {

	public OrdercomcateVO doCreate(OrdercomcateVO vo) throws Exception {
		try {
			OrdercomcateDAO dao = (OrdercomcateDAO) DAOFactory.build(OrdercomcateDAO.class, user);
			// TODO set the pk */
			return (OrdercomcateVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(OrdercomcateVO vo) throws Exception {
		try {
			OrdercomcateDAO dao = (OrdercomcateDAO) DAOFactory.build(OrdercomcateDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			OrdercomcateDAO dao = (OrdercomcateDAO) DAOFactory.build(OrdercomcateDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public OrdercomcateVO doUpdate(OrdercomcateVO vo) throws Exception {
		try {
			OrdercomcateDAO dao = (OrdercomcateDAO) DAOFactory.build(OrdercomcateDAO.class,user);
			return (OrdercomcateVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public OrdercomcateVO doFindByPk(Serializable pk) throws Exception {
		OrdercomcateDAO dao = (OrdercomcateDAO) DAOFactory.build(OrdercomcateDAO.class,user);
		return (OrdercomcateVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(OrdercomcateDBParam params)
			throws Exception {
		OrdercomcateDAO dao = (OrdercomcateDAO) DAOFactory.build(OrdercomcateDAO.class,user);
		return dao.query(params);
	}

	public DataPackage doQueryByNameSql(String nameSql,OrdercomcateDBParam params)
			throws Exception {
		OrdercomcateDAO dao = (OrdercomcateDAO) DAOFactory.build(OrdercomcateDAO.class,user);
		return dao.queryByNamedSqlQuery(nameSql, params);
	}

	public Long doQueryOrderamtByAllBrand(String orderid) throws Exception {
		OrdercomcateDAO dao = (OrdercomcateDAO) DAOFactory.build(OrdercomcateDAO.class, user);
		return dao.queryOrderamtByAllBrand(orderid);
	}
	
	/**
     *对客户订购空白SIM卡数量进行统计
     * @param orderid
     * @return
     * @throws Exception
     */
	
	public DataPackage doquerySimamtByOrderID(String orderid) throws Exception {
		OrdercomcateDAO dao = (OrdercomcateDAO) DAOFactory.build(OrdercomcateDAO.class, user);
		OrdercomcateDBParam params = new OrdercomcateDBParam();
		params.setSelectFieldsString("comcategory,simamt");
		params.getQueryConditions().put("orderid", orderid);
		DataPackage dp = dao.queryByNamedSqlQuery("querySimamtByOrderID", params);
		return dp;
	}
	
	public Long doQueryOrderamtByBrand(String orderid, String brand) throws Exception {
		OrdercomcateDAO dao = (OrdercomcateDAO) DAOFactory.build(OrdercomcateDAO.class, user);
		return dao.queryOrderamtByBrand(orderid, brand);
	}
	/**
	 * 商品订购量进行修改,即5.2.12.2	数量调整逻辑
	 */
	public void doAmtadjSave(String recid, String orderamt,String memo) throws Exception {
		try {
			Ordercomcate bo = (Ordercomcate)BOFactory.build(OrdercomcateBO.class,user);
			OrdercomcateVO vo=bo.doFindByPk(Long.valueOf(recid));
			if(vo!=null){
				Comorder comorderBO = (Comorder)BOFactory.build(ComorderBO.class,user);
				String unitage=comorderBO.doGetUnitage(user.getCityid(), vo.getComcategory());
				if(Double.valueOf(orderamt)%Double.valueOf(unitage)>0){
					throw new JOPException("订购量不为订购基数整数倍!");
				}
				
				
				Long oldOrderamt=vo.getOrderamt();
				vo.setOrderamt(Long.valueOf(orderamt));
				Double totalprice=Long.valueOf(orderamt)* vo.getUnitprice();
				vo.setTotalprice(totalprice);
				bo.doUpdate(vo);
				//对订单商品种类的总价进行汇总，更新订单表中应收金额
				OrdercomcateDBParam ordercomcateDBParam=new OrdercomcateDBParam();
				ordercomcateDBParam.set_se_orderid(vo.getOrderid());
				List<OrdercomcateVO> ordercomcateList=bo.doQuery(ordercomcateDBParam).getDatas();
				Double totalpriceSum=0d;
				for(OrdercomcateVO ordercomVO:ordercomcateList){
					totalpriceSum+=ordercomVO.getTotalprice();
				}
				Order orderbo = (Order)BOFactory.build(OrderBO.class,user);
				OrderVO orderVO=orderbo.doFindByPk(vo.getOrderid());
				orderVO.setRecamt(totalpriceSum);
				orderbo.doUpdate(orderVO);
				//实时订购量数据更新
				if("CUSTORDER".equals(vo.getOrdercomtype())){//订单商品类型为客户订购
					Comcategoryrela comcategoryrelaBO= (Comcategoryrela)BOFactory.build(ComcategoryrelaBO.class,user);//商品组合关系BO
					ComcategoryrelaDBParam comcategoryrelaDBParam=new ComcategoryrelaDBParam();
					comcategoryrelaDBParam.set_se_comcategory(vo.getComcategory());
					List<ComcategoryrelaVO> comcategList=comcategoryrelaBO.doQuery(comcategoryrelaDBParam).getDatas();//商品种类
					if(comcategList.size()==0){
						throw new JOPException("商品种类["+vo.getComcategory()+"]组合关系数据不存在");
					}
					ComcategoryrelaVO comcateg=comcategList.get(0);//取第一个商品种类
					if("COMRESSMP".equals(comcateg.getRestype())){
						Long amtadj=Long.valueOf(orderamt)-oldOrderamt;//调整量=调整后订购量-调整前订购量
						if(amtadj!=0){//调整量不等于0则继续
							Sysparam sysparamBO=(Sysparam)BOFactory.build(SysparamBO.class,user);
							String sysparamvalue12=sysparamBO.doFindByID("12", "pboss_fx");
							Realtimeamt realtimeamtBO= (Realtimeamt)BOFactory.build(RealtimeamtBO.class,user);//商品组合关系BO
							RealtimeamtDBParam realtimeamtDBParam=new RealtimeamtDBParam();
							realtimeamtDBParam.set_se_wayid(orderVO.getWayid());
							if("1".equals(sysparamvalue12)){//区分品牌
								realtimeamtDBParam.set_se_brand(comcateg.getBrand());
							}else{
								realtimeamtDBParam.set_se_brand("AllBrand");
							}
							List<RealtimeamtVO> realtimeamtList=realtimeamtBO.doQuery(realtimeamtDBParam).getDatas();
							if(realtimeamtList.size()==0){
								throw new JOPException("合作商实时订购量数据不存在");
							}
							for(RealtimeamtVO realtimeamtVO:realtimeamtList){
								Long nowstock=realtimeamtVO.getNowstock()==null?0:realtimeamtVO.getNowstock();
								
								realtimeamtVO.setNowstock((nowstock+amtadj)<0?0:nowstock+amtadj);//当前库存量=当前库存量+调整量
								if(orderVO.getCreatetime().getMonth()==new Date().getMonth()){//如果订单创建时间在当前月
									Long monordered=realtimeamtVO.getMonordered()==null?0:realtimeamtVO.getMonordered();
									realtimeamtVO.setMonordered(monordered+amtadj<0?0:monordered+amtadj);//当月已订购量=当月已订购量+调整量
								}
								if(orderVO.getCreatetime().getDate()==new Date().getDate()){//如果订单创建时间在当前天
									Long dayordered=realtimeamtVO.getDayordered()==null?0:realtimeamtVO.getDayordered();
									realtimeamtVO.setDayordered(dayordered+amtadj<0?0:dayordered+amtadj);//当天已订购量=当天已订购量+调整量
								}
								realtimeamtVO.setUptime(new Date());
								realtimeamtBO.doUpdate(realtimeamtVO);
							}
						}
					}
					//将订单商品变更数据前后及备注记录到“订单商品订购数量日志[FX_SW_ORDCOMLOG]”表中，并将信息相关信息（如网点名称、商品名称、变更前数量、变更后数量及备注）以以下格式：【网点名称、（商品名称、变更前数量、变更后数量）、备注】
					//保存到“订单商品订购数量日志[FX_SW_ORDCOMLOG]”表中的“其他[OTHERS]”字段中
					Ordcomlog ordcomlogBO = (Ordcomlog)BOFactory.build(OrdcomlogBO.class,user);
					OrdcomlogVO ordcomlogVO=new OrdcomlogVO();
					ordcomlogVO.setOprcode(user.getOprcode());//操作工号
					ordcomlogVO.setOptime(new Date());//操作时间
					ordcomlogVO.setOrderid(vo.getOrderid());//订单编号
					ordcomlogVO.setOrdcomid(vo.getRecid());//订单商品编号
					ordcomlogVO.setAmtb(oldOrderamt);//变更前数量
					ordcomlogVO.setAmta(Long.valueOf(orderamt));//变更后数量
					ordcomlogVO.setMemo(memo);
					String camcategoryName = Code2NameUtils.code2Name("$IM_FXCOMCATEGORY", vo.getComcategory(), user.getCityid());
					String others="["+orderVO.getWayid()+"、("+camcategoryName+","+oldOrderamt+","+orderamt+")、"+memo+"]";
					ordcomlogVO.setOthers(others);
					ordcomlogBO.doCreate(ordcomlogVO);
					//汇总单统计更新逻辑
					Date today = new Date();
					Date ordercreatetime = orderVO.getCreatetime();
					int diff = PublicUtils.compareDate(ordercreatetime, today);//订单创建时间与当前日期相差几天
					boolean isnotsameday = ((diff==0 && ordercreatetime.getDate()!=today.getDate()) || (diff!=0));//是否不是同一天
					
					if("AUTO".equals(orderVO.getOrderave()) && isnotsameday){//订购途径[ORDERAVE]”等于“自动[AUTO]”,订单创建时间不为当天
						Alaordercol alaordercolBO = (Alaordercol)BOFactory.build(AlaordercolBO.class,user);
						AlaordercolDBParam alaordercolDBParam=new AlaordercolDBParam();
						SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
				    	String nowDate = format.format(orderVO.getCreatetime());
						alaordercolDBParam.set_se_coldate(nowDate);
						alaordercolDBParam.set_se_macode(orderVO.getMareacode());
						alaordercolDBParam.set_ne_starlevel(orderVO.getStarlevel().toString());
						alaordercolDBParam.set_se_alarmlevel(orderVO.getAlarmlevel());
						alaordercolDBParam.set_se_brand(comcateg.getBrand());
						DataPackage aladp=alaordercolBO.doQuery(alaordercolDBParam);
						if(null!=aladp && aladp.getDatas().size()>0){
							AlaordercolVO alavo = (AlaordercolVO)aladp.getDatas().get(0);
							alavo.setAmount(alavo.getAmount()+(Long.valueOf(orderamt)-oldOrderamt));
							alavo.setUpdatetime(new Date());
							alaordercolBO.doUpdate(alavo);
						}
					}
				}
			}
		} catch (Exception ex) {
			throw new JOPException(ex.getMessage());
		}
	}
	/**
	 * 查询审核库存检查所需的信息
	 * @param orderids
	 * @return
	 * @throws Exception
	 */
	 public List<OrdercomcateStocksVO> doOrdercomcateStocksQuery(String[] orderids ) throws Exception {
		 OrdercomcateDAO dao = (OrdercomcateDAO) DAOFactory.build(OrdercomcateDAO.class, user);
			return dao.doOrdercomcateStocksQuery(orderids);
	 }

	public DataPackage doQueryEmptySimRealTimeUpdateDayMonthCount(String wayid)
			throws Exception {
		 OrdercomcateDAO dao = (OrdercomcateDAO) DAOFactory.build(OrdercomcateDAO.class, user);
//			return dao.doQueryEmptySimRealTimeUpdateDayMonthCount(wayid);
			OrdercomcateDBParam params = new OrdercomcateDBParam();
			params.setSelectFieldsString("comcategory,count");
			params.getQueryConditions().put("wayid", wayid);

			DataPackage dp = dao.queryByNamedSqlQuery("com.gmcc.pboss.business.sales.doQueryEmptySimRealTimeUpdateDayMonthCount", params);
			return dp;
			
	}

	public DataPackage doQueryEmptySimRealTimeUpdateBuyCount(String wayid)
			throws Exception {
		 OrdercomcateDAO dao = (OrdercomcateDAO) DAOFactory.build(OrdercomcateDAO.class, user);
		 OrdercomcateDBParam params = new OrdercomcateDBParam();
			params.setSelectFieldsString("comcategory,count");
			params.getQueryConditions().put("wayid", wayid);

			DataPackage dp = dao.queryByNamedSqlQuery("com.gmcc.pboss.business.sales.doQueryEmptySimRealTimeUpdateBuyCount", params);
			return dp;
	}
	 
	 //批量触发划扣结果短信 （统计商品种类订购数量）
	 public DataPackage doQueryDataByOrderId (String orderid) throws Exception{
		 OrdercomcateDAO dao = (OrdercomcateDAO) DAOFactory.build(OrdercomcateDAO.class, user); 
		 OrdercomcateDBParam param = new OrdercomcateDBParam ();   
		 param.getQueryConditions().put("ORDERID",orderid);  
		 param.setSelectFieldsString("comcategory,orderamt");
		 param.setSelectFieldsUseVOType(true);
		 param.set_pagesize("0");
		 return dao.queryByNamedSqlQuery("queryDataByOrderId",param);
	 } 
}
