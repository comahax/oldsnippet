package com.gmcc.pboss.control.sales.bgcontrol.SMPActiveRateCalc.calcmode.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.sales.activerate.ActiverateVO;
import com.gmcc.pboss.business.sales.bgbusiness.PartnerSMPBrandVO;
import com.gmcc.pboss.business.sales.orderstd.OrderstdDBParam;
import com.gmcc.pboss.business.sales.orderstd.OrderstdVO;
import com.gmcc.pboss.business.sales.orderuplimit.OrderuplimitDBParam;
import com.gmcc.pboss.business.sales.orderuplimit.OrderuplimitVO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.sales.activerate.Activerate;
import com.gmcc.pboss.control.sales.activerate.ActiverateBO;
import com.gmcc.pboss.control.sales.bgcontrol.SMPActiveRateCalc.SMPActiveRateCalc;
import com.gmcc.pboss.control.sales.bgcontrol.SMPActiveRateCalc.calcmode.intf.CalcMode;
import com.gmcc.pboss.control.sales.orderstd.Orderstd;
import com.gmcc.pboss.control.sales.orderstd.OrderstdBO;
import com.gmcc.pboss.control.sales.orderuplimit.Orderuplimit;
import com.gmcc.pboss.control.sales.orderuplimit.OrderuplimitBO;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.exception.BusinessException;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;
/**
 * 套卡激活率计算基准库存模式
 * @author zsw
 * @date 2010-03-18
 */
public class StdStockCalcMode implements CalcMode {

	private Logger log = Logger.getLogger(StdStockCalcMode.class);
	private SMPActiveRateCalc arcBO;
	private static String ALLBRAND = "AllBrand";
	
	public StdStockCalcMode(SMPActiveRateCalc arcBO) {
		this.arcBO = arcBO;
	}
	public void doSMPActiveRateCalc(DBAccessUser user) throws Exception {
		log.info("套卡激活率计算模式为\"基准库存模式\"");
		// 基准库存模式
		Orderuplimit olBo = (OrderuplimitBO)BOFactory.build(OrderuplimitBO.class, user);
		Orderstd osBo = (OrderstdBO)BOFactory.build(OrderstdBO.class, user);
		Way wayBo = (WayBO)BOFactory.build(WayBO.class, user);
		Activerate arBo = (ActiverateBO)BOFactory.build(ActiverateBO.class,user,BOFactory.PROPAGATION_REQUIRES_NEW);
		
		OrderstdDBParam osParam = new OrderstdDBParam();
		
		Map<PartnerSMPBrandVO,Long[]> dataMap = arcBO.doStatSMPWithBrand(-1,-1,-1);
		
		Map<String, Map<PartnerSMPBrandVO, Object[]>> wayidAndActiveRateMap = this.getWayidAndActiveRateMap(dataMap, user);
		
		Set<String> keys = wayidAndActiveRateMap.keySet();
		for(Iterator<String> it = keys.iterator();it.hasNext();) {
			try {
				String wayid = it.next();
				Map<PartnerSMPBrandVO, Object[]> activeRateMap = wayidAndActiveRateMap.get(wayid);
				for(Iterator<PartnerSMPBrandVO> ait = activeRateMap.keySet().iterator();ait.hasNext();) {
					try {
						PartnerSMPBrandVO pbVo = ait.next();
						String brand = pbVo.getBrand();
						if(brand == null || "".equals(brand.trim())) {
							throw new BusinessException("合作商资源表 FX_SW_PARTNERRES 中存在 渠道ID为  "+wayid+" 的数据其品牌字段Brand的值为空，请核实。",null);
						}
						Object[] value = activeRateMap.get(pbVo);
						double activeRate = (Double)value[0];
						long inActiveQty = (Long)value[1];
						long stdStock = (Long)value[2];
						WayVO wayVo = (WayVO)value[3];
						
						String _cityid = wayVo.getCityid();
						String _countyid = wayVo.getCountyid();
						String _cooptype = wayVo.getCusttype();
						Long _starlevel = wayVo.getStarlevel();
						osParam.set_se_cityid(_cityid);
						osParam.set_se_countyid(_countyid);
						if(_cooptype == null || "".equals(_cooptype.trim())) {
							// 若合作类型为空，则按照合作类型等于“ALL”来处理
							osParam.set_se_cooptype("ALL");
						}else {
							osParam.set_se_cooptype(_cooptype);
						}
						osParam.set_ne_starlevel(_starlevel.toString());
						osParam.set_se_brand(brand);
						osParam.set_se_stdtype("ACTRATE");
						osParam.set_pagesize("0");
						osParam.setDataOnly(true);
						DataPackage osDp = osBo.doQuery(osParam);
						List osDatas = osDp.getDatas();
						
						Serializable pkVO = new ActiverateVO();
						BeanUtils.setProperty(pkVO, "wayid", wayid);
						BeanUtils.setProperty(pkVO, "brand", brand);
						ActiverateVO arVo = arBo.doFindByPk(pkVO);
						boolean isNew = arVo == null ? true : false;
						if(isNew) {
							arVo = new ActiverateVO();
							arVo.setWayid(wayid);
							arVo.setBrand(brand);
						}
						if(_cooptype == null || "".equals(_cooptype.trim())) {
							// 若合作类型为空，则按照合作类型等于“ALL”来处理
						}else if((osDatas == null || osDatas.size() <= 0)) {
							// 若渠道合作类型不为空且无数据则按照合作类型等于“ALL”再次查询
							// 如果仍然无数据，是否达标字段取1，达标差距取0。(根据CR_SW20100624_1065427做修改)
								osParam.set_se_cooptype("ALL");
								osDp = osBo.doQuery(osParam);
								osDatas = osDp.getDatas();
						}
						if((osDatas == null || osDatas.size() <= 0)) {
							// 如果仍然无数据，是否达标字段取1，达标差距取0。(根据CR_SW20100624_1065427做修改)
							arVo.setIsachieve(new Short("1"));
							arVo.setDifamt(0L);
						}else {
							OrderstdVO osVo = (OrderstdVO)osDatas.get(0);
							double lowestStd = osVo.getLoweststd();
							
							if(activeRate >= lowestStd) {
								arVo.setIsachieve(new Short("1"));
							}else {
								arVo.setIsachieve(new Short("0"));
								// 达标未激活数
								double stdInActiveQty = stdStock - stdStock*lowestStd;
								// 达标差距
								double difamt = inActiveQty - stdInActiveQty;
								difamt = Math.ceil(difamt);
								arVo.setDifamt((long)difamt);
							}
						}
						
						// 更新时间
						arVo.setChgtime(new Date());
						// 激活率
						arVo.setRate(activeRate);
						if(isNew) {
							arBo.doCreate(arVo);
							log.info("新增套卡激活率数据："+"[渠道标识:"+wayid+";品牌:"+brand+";激活率:"+activeRate+";是否达标:"+arVo.getIsachieve()+";达标差距(已达标时为null):"+arVo.getDifamt());
						}else {
							arBo.doUpdate(arVo);
							log.info("更新套卡激活率数据："+"[渠道标识:"+wayid+";品牌:"+brand+";激活率:"+activeRate+";是否达标:"+arVo.getIsachieve()+";达标差距(已达标时为null):"+arVo.getDifamt());
						}
					}catch(BusinessException ex) {
						log.info(ex.getMessage());
					}catch(Exception ex) {
						LoggerUtils.error(ex, log);
					}
				}
			}catch(Exception ex) {
				LoggerUtils.error(ex, log);
			}
		}

	}
	
	private Map<String, Map<PartnerSMPBrandVO, Object[]>> getWayidAndActiveRateMap(
			Map<PartnerSMPBrandVO, Long[]> dataMap, DBAccessUser user)
			throws Exception {
		
		Way wayBo = (WayBO)BOFactory.build(WayBO.class, user);
		Orderuplimit olBo = (OrderuplimitBO)BOFactory.build(OrderuplimitBO.class, user);
		
		// 以渠道ID分类存放各渠道对应的各品牌和"所有品牌"的激活率,激活量,未激活量的Map
		Map<String, Map<PartnerSMPBrandVO, Object[]>> wayidAndActiveRateMap = new HashMap<String, Map<PartnerSMPBrandVO, Object[]>>();
		// 存放渠道ID和未激活量的Map
		Map<String,Long> wayAndInActiveQty = new HashMap<String,Long>();
		// 存放渠道ID和基准库存的Map
		Map<String,Long> wayAndStdStock = new HashMap<String,Long>();
		// 存放渠道ID和对应WayVO的Map
		Map<String,WayVO> wayVOMap = new HashMap<String,WayVO>();
		
		Set<PartnerSMPBrandVO> keys = dataMap.keySet();
		
		for(Iterator<PartnerSMPBrandVO> it = keys.iterator();it.hasNext();) {
			try {
				PartnerSMPBrandVO pbVo = it.next();
				Long[] activeAndInActiveQty = dataMap.get(pbVo);
				
				long inActiveQty = activeAndInActiveQty[1];
				String wayid = pbVo.getWayid();
				
				String brand = pbVo.getBrand();
				if(!wayVOMap.containsKey(wayid)) {
					WayVO wayVo = wayBo.doFindByPk(wayid);
					wayVOMap.put(wayid, wayVo);
				}
				WayVO wayVo = wayVOMap.get(wayid);
				
				String _cityid = wayVo.getCityid();
				String _countyid = wayVo.getCountyid();
				String _cooptype = wayVo.getCusttype();
				Long _starlevel = wayVo.getStarlevel();
				
				OrderuplimitDBParam olParams = new OrderuplimitDBParam();
				if(_cityid == null || "".equals(_cityid.trim())) {
					throw new BusinessException("渠道："+wayid+" 的 cityid 字段为空",null);
				}
				if(_countyid == null || "".equals(_countyid.trim())) {
					throw new BusinessException("渠道："+wayid+" 的 countyid 字段为空",null);
				}
				if(_cooptype == null || "".equals(_cooptype.trim())) {
	//				throw new Exception("渠道："+wayid+" 的 custtype 字段为空");
					// 若合作类型为空，则按照合作类型等于“ALL”来处理
					olParams.set_se_cooptype("ALL");
				}else {
					olParams.set_se_cooptype(_cooptype);
				}
				if(_starlevel == null || "".equals(_starlevel.toString().trim())) {
					throw new BusinessException("渠道："+wayid+" 的 starlevel 字段为空",null);
				}
				
				olParams.set_se_cityid(_cityid);
				olParams.set_se_countyid(_countyid);
				olParams.set_ne_starlevel(_starlevel.toString());
				olParams.set_se_brand(brand);
				olParams.set_pagesize("0");
				olParams.setDataOnly(true);
				DataPackage olDp = olBo.doQuery(olParams);
				List olDatas = olDp.getDatas();
				if(_cooptype == null || "".equals(_cooptype.trim())) {
					// 若合作类型为空，则按照合作类型等于“ALL”来处理
				}else if((olDatas == null || olDatas.size() <= 0)) {
					// 若渠道合作类型不为空且无数据则按照合作类型等于“ALL”再次查询
					olParams.set_se_cooptype("ALL");
					olDp = olBo.doQuery(olParams);
					olDatas = olDp.getDatas();
				}
				if(olDatas == null || olDatas.size() <= 0) {
					// 如果仍然无数据则处理下一条记录
					continue;
				}
				OrderuplimitVO olVo = (OrderuplimitVO)olDatas.get(0);
				// 基准库存
				if(olVo.getStdstock()== null) {
					throw new BusinessException("合作商(渠道)所在城市："+user.getCityid()+"; 所属区域: "+_countyid+"; 合作类型："+_cooptype+"; 星级："+_starlevel+" 的基准库存数据为空，请核实",null);
				}
				long stdStock = olVo.getStdstock();
				double activeRate = ((double)(stdStock - inActiveQty))/(double)stdStock;
				Object[] value = {activeRate,inActiveQty,stdStock,wayVo};
				if(wayidAndActiveRateMap.containsKey(wayid)) {
					Map<PartnerSMPBrandVO, Object[]> activeRateMap = wayidAndActiveRateMap.get(wayid);
					activeRateMap.put(pbVo, value);
				}else {
					Map<PartnerSMPBrandVO, Object[]> activeRateMap = new HashMap<PartnerSMPBrandVO, Object[]>();
					activeRateMap.put(pbVo, value);
					wayidAndActiveRateMap.put(wayid, activeRateMap);
				}
				if(wayAndInActiveQty.containsKey(wayid)) {
					long oldInActiveQty = wayAndInActiveQty.get(wayid);
					long newInActiveQty = inActiveQty + oldInActiveQty;
					wayAndInActiveQty.put(wayid, newInActiveQty);
				}else {
					wayAndInActiveQty.put(wayid,inActiveQty);
				}
				if(wayAndStdStock.containsKey(wayid)) {
					long oldStdStock = wayAndStdStock.get(wayid);
					long newStdStock = stdStock + oldStdStock;
					wayAndStdStock.put(wayid, newStdStock);
				}else {
					wayAndStdStock.put(wayid, stdStock);
				}
				
			}catch(BusinessException ex) {
				log.info(ex.getMessage());
			}catch(Exception ex) {
				LoggerUtils.error(ex, log);
			}
		}
		
		for(Iterator<String> it = wayAndInActiveQty.keySet().iterator();it.hasNext();) {
			String wayid = it.next();
			WayVO wayVO = wayVOMap.get(wayid);
			PartnerSMPBrandVO allBrand_pbVO = new PartnerSMPBrandVO(wayid,ALLBRAND);
			long inActiveQty_AllBrand = wayAndInActiveQty.get(wayid);
			long stdStock_AllBrand = wayAndStdStock.get(wayid);
			double activeRate_AllBrand = ((double)(stdStock_AllBrand - inActiveQty_AllBrand))/(double)stdStock_AllBrand;
			Object[] value_AllBrand = {activeRate_AllBrand,inActiveQty_AllBrand,stdStock_AllBrand,wayVO};
			Map<PartnerSMPBrandVO,Object[]> activeRateMap = wayidAndActiveRateMap.get(wayid);
			activeRateMap.put(allBrand_pbVO, value_AllBrand);
			wayidAndActiveRateMap.put(wayid, activeRateMap);
		}
		
		return wayidAndActiveRateMap;
	}

}
