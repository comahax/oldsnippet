package com.gmcc.pboss.control.sales.bgcontrol.alaOrderCol;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.resource.comcategoryrela.ComcategoryrelaDBParam;
import com.gmcc.pboss.business.sales.alaordercol.AlaordercolDBParam;
import com.gmcc.pboss.business.sales.alaordercol.AlaordercolVO;
import com.gmcc.pboss.business.sales.order.OrderDBParam;
import com.gmcc.pboss.business.sales.order.OrderVO;
import com.gmcc.pboss.business.sales.ordercomcate.OrdercomcateDBParam;
import com.gmcc.pboss.business.sales.ordercomcate.OrdercomcateVO;
import com.gmcc.pboss.business.sales.orderlog.OrderlogDBParam;
import com.gmcc.pboss.business.sales.orderlog.OrderlogVO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.resource.comcategoryrela.Comcategoryrela;
import com.gmcc.pboss.control.resource.comcategoryrela.ComcategoryrelaBO;
import com.gmcc.pboss.control.sales.alaordercol.Alaordercol;
import com.gmcc.pboss.control.sales.alaordercol.AlaordercolBO;
import com.gmcc.pboss.control.sales.order.Order;
import com.gmcc.pboss.control.sales.order.OrderBO;
import com.gmcc.pboss.control.sales.ordercomcate.Ordercomcate;
import com.gmcc.pboss.control.sales.ordercomcate.OrdercomcateBO;
import com.gmcc.pboss.control.sales.orderlog.Orderlog;
import com.gmcc.pboss.control.sales.orderlog.OrderlogBO;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class AlaOrderColBgBO extends AbstractControlBean implements AlaOrderColBg {
	
	private Logger log = Logger.getLogger(AlaOrderColBgBO.class);
	
	public void doProcess(String coldate) throws Exception {
		try {
			//二、载入【品牌和商品种类集合】
			Comcategoryrela comcategoryrela = (Comcategoryrela)BOFactory.build(ComcategoryrelaBO.class, user);
			ComcategoryrelaDBParam cparam = new ComcategoryrelaDBParam();
			cparam.setSelectFieldsString("comcategory,brand");
			cparam.setQueryAll(true);
			DataPackage cdp = comcategoryrela.doLoadComCateAndBrand(cparam);
			List<Map<String, Object>> templist = cdp.getDatas();
			Map<String, String> comCategoryAndBrandMap = new HashMap<String, String>();
			for (Map<String, Object> value : templist) {
				String comCategory = (String) value.get("comcategory");
				String brand = (String) value.get("brand");
				comCategoryAndBrandMap.put(comCategory, brand);
			}
			log.info("已载入【品牌和商品种类集合】");
			
			//三、目标日期数据清理
			Alaordercol bo = (Alaordercol)BOFactory.build(AlaordercolBO.class, user);
			AlaordercolDBParam aparam = new AlaordercolDBParam();
			aparam.set_se_coldate(coldate);
			DataPackage dp = bo.doQuery(aparam);
			if(null!=dp && dp.getDatas().size()>0){
				List<AlaordercolVO> list = dp.getDatas();
				for(AlaordercolVO vo : list){
					bo.doRemoveByVO(vo);
				}
			}
			log.info("已完成目标日期数据清理");
			
			//四、统计分配单
			Ordercomcate ordercomcate = (Ordercomcate)BOFactory.build(OrdercomcateBO.class, user);
			Order order =(Order)BOFactory.build(OrderBO.class, user);
			OrderDBParam oparam = new OrderDBParam();
			Date datetemp = PublicUtils.UtilStrToDate(coldate,"yyyyMMdd");
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String targetDate = format.format(datetemp);
			oparam.set_dnl_createtime(targetDate +" 00:00:00");
			oparam.set_dnm_createtime(targetDate +" 23:59:59");
			oparam.set_se_orderave("AUTO");
			oparam.setQueryAll(true);
			DataPackage dp2 = order.doQuery(oparam);
			if(null!=dp2 && dp2.getDatas().size()>0){
				List<OrderVO> list2 = dp2.getDatas();
				for(OrderVO ordervo : list2){
					//根据订单编号查询订单商品种类表 (FX_SW_ORDERCOMCATE)，获取商品种类、订购量数据，根据商品种类查询品牌和商品种类集合获取品牌，
					//对同品牌的订购量进行合并，然后对各品牌的订购量逐条处理：
					OrdercomcateDBParam ocparam = new OrdercomcateDBParam();
					ocparam.set_se_orderid(ordervo.getOrderid());
					ocparam.setQueryAll(true);
					DataPackage dp3 = ordercomcate.doQuery(ocparam);
					if(null!=dp3 && dp3.getDatas().size()>0){
						Map<String,Long> brandAndOrderamtMap = new HashMap<String, Long>();
						List<OrdercomcateVO> oclist = dp3.getDatas();
						Set<String> brandSet = new HashSet<String>();
						for(OrdercomcateVO ocvo : oclist){
							String comcategory = ocvo.getComcategory();
							Long orderamt = ocvo.getOrderamt();
							String brand = comCategoryAndBrandMap.get(comcategory);
							if(!brandSet.contains(brand)){
								brandSet.add(brand);
								brandAndOrderamtMap.put(brand, ocvo.getOrderamt());
							}else{
								Long oldorderamt = brandAndOrderamtMap.get(brand);
								brandAndOrderamtMap.put(brand, oldorderamt+orderamt);
							}
						}
						//根据合作商编码查询渠道表，获取服务营销中心；
						Way waybo = (Way)BOFactory.build(WayBO.class, user);
						WayVO wayvo = waybo.doFindByPk(ordervo.getWayid());
						String svccode = wayvo.getSvccode();
						if(StringUtils.isBlank(svccode) || StringUtils.isBlank(ordervo.getMareacode())
								|| (ordervo.getStarlevel()==null)){
							log.info("订单"+ordervo.getOrderid()+"因为缺失服务营销中心、微区域、星级相关数据在[统计分配单]步骤中被丢弃");
							continue;
						}
						for (Iterator it = brandSet.iterator(); it.hasNext();) {
							String currntbrand = (String)it.next();
							Long orderamt = brandAndOrderamtMap.get(currntbrand);
							AlaordercolDBParam aparam2 = new AlaordercolDBParam();
							aparam2.set_se_coldate(coldate);
							aparam2.set_se_svccode(svccode);
							aparam2.set_se_macode(ordervo.getMareacode());
							aparam2.set_ne_starlevel(ordervo.getStarlevel().toString());
							aparam2.set_se_alarmlevel(ordervo.getAlarmlevel());
							aparam2.set_se_brand(currntbrand);
							aparam2.setQueryAll(true);
							DataPackage dp4 = bo.doQuery(aparam2);
							if(null!=dp4 && dp4.getDatas().size()>0){
								AlaordercolVO avo = (AlaordercolVO)dp4.getDatas().get(0);
								Long oldamount = avo.getAmount();
								avo.setAmount(oldamount+orderamt);
								avo.setOrderamt(avo.getOrderamt()+1);
								if("CANCEL".equals(ordervo.getOrderstate()))
									avo.setCancelamt(avo.getCancelamt()+1);
								if("FINISHED".equals(ordervo.getOrderstate()))
									avo.setOveramt(avo.getOveramt()+1);
								avo.setUpdatetime(new Date());
								bo.doUpdate(avo);
							}else{
								AlaordercolVO avo = new AlaordercolVO();
								avo.setColdate(coldate);
								avo.setCountyid(ordervo.getCountyid());
								avo.setMacode(ordervo.getMareacode());
								avo.setStarlevel(ordervo.getStarlevel());
								avo.setAlarmlevel(ordervo.getAlarmlevel());
								avo.setSvccode(svccode);
								avo.setBrand(currntbrand);
								avo.setAmount(orderamt);
								avo.setOrderamt(new Integer("1"));
								if("CANCEL".equals(ordervo.getOrderstate()))
									avo.setCancelamt(1);
								else
									avo.setCancelamt(0);
								if("FINISHED".equals(ordervo.getOrderstate()))
									avo.setOveramt(1);
								else
									avo.setOveramt(0);
								avo.setUpdatetime(new Date());
								bo.doCreate(avo);
							}
						}
					}
				}
			}
			log.info("已完成统计分配单");
			
			//五、根据日志更新订单数量
			Orderlog orderlog = (Orderlog)BOFactory.build(OrderlogBO.class, user);
			OrderlogDBParam olparam = new OrderlogDBParam();
			String[] orderstates = { "CANCEL", "FINISHED" };
			List<String> orderstatesList = Arrays.asList(orderstates);
			olparam.set_se_orderave("AUTO");
			olparam.set_sin_orderstate(new ArrayList<String>(orderstatesList));
			olparam.set_dnl_optime(targetDate +" 00:00:00");
			olparam.set_dnm_optime(targetDate +" 23:59:59");
			String bigtargetdate = targetDate +" 23:59:59";
			String smalltargetdate = targetDate +" 00:00:00";
			String sql = "createtime>to_date('" + bigtargetdate + "','yyyy-MM-dd HH24:mi:ss') or createtime < to_date('" + smalltargetdate + "','yyyy-MM-dd HH24:mi:ss')";
			olparam.getQueryConditions().put("_sql_createtime", sql);
			olparam.setQueryAll(true);
			DataPackage oldp = orderlog.doQuery(olparam);
			if(null!=oldp && oldp.getDatas().size()>0){
				List<OrderlogVO> ollist = oldp.getDatas();
				for(OrderlogVO olvo : ollist){
					OrdercomcateDBParam ocparam2 = new OrdercomcateDBParam();
					ocparam2.set_se_orderid(olvo.getOrderid());
					ocparam2.setQueryAll(true);
					DataPackage dp5 = ordercomcate.doQuery(ocparam2);
					if(null!=dp5 && dp5.getDatas().size()>0){
						List<OrdercomcateVO> oclist2 = dp5.getDatas();
						Set<String> brandSet2 = new HashSet<String>();
						for(OrdercomcateVO ocvo : oclist2){
							String comcategory = ocvo.getComcategory();
							String brand = comCategoryAndBrandMap.get(comcategory);
							if(!brandSet2.contains(brand)){
								brandSet2.add(brand);
							}
						}
						//根据合作商编码查询渠道表，获取服务营销中心；
						Way waybo = (Way)BOFactory.build(WayBO.class, user);
						WayVO wayvo = waybo.doFindByPk(olvo.getWayid());
						String svccode = wayvo.getSvccode();
						if(StringUtils.isBlank(svccode) || StringUtils.isBlank(olvo.getMareacode())
								|| (olvo.getStarlevel()==null)){
							log.info("订单"+olvo.getOrderid()+"因为缺失服务营销中心、微区域、星级相关数据在[根据日志更新订单数量]步骤中被丢弃");
							continue;
						}
						for (Iterator it = brandSet2.iterator(); it.hasNext();) {
							String currntbrand = (String)it.next();
							AlaordercolDBParam aparam3 = new AlaordercolDBParam();
							String createtime = PublicUtils.formatUtilDate(olvo.getCreatetime(),"yyyyMMdd");
							aparam3.set_se_coldate(createtime);//订单创建日期
							aparam3.set_se_svccode(svccode);
							aparam3.set_se_macode(olvo.getMareacode());
							aparam3.set_ne_starlevel(olvo.getStarlevel().toString());
							aparam3.set_se_alarmlevel(olvo.getAlarmlevel());
							aparam3.set_se_brand(currntbrand);
							aparam3.setQueryAll(true);
							DataPackage dp6 = bo.doQuery(aparam3);
							if(null!=dp6 && dp6.getDatas().size()>0){
								//状态变更时间
								String statechgtime = PublicUtils.formatUtilDate(olvo.getStatechgtime(),"yyyyMMdd");
								AlaordercolVO avo = (AlaordercolVO)dp6.getDatas().get(0);
								if("CANCEL".equals(olvo.getOrderstate()))
									avo.setCancelamt(avo.getCancelamt()+1);
								//订单状态为已完成且状态变更时间与目标日期为同一天时
								if("FINISHED".equals(olvo.getOrderstate()) && statechgtime.equals(coldate))
									avo.setOveramt(avo.getOveramt()+1);
								avo.setUpdatetime(new Date());
								bo.doUpdate(avo);
							}
						}
					}
				}
			}
			log.info("已完成根据日志更新订单数量");
		} catch (Exception e) {
			LoggerUtils.error(e, log);
		}
	}
	
}
