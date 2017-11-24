package com.gmcc.pboss.control.sales.bgcontrol.emptysimrealtimeupdate;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.gmcc.pboss.business.sales.ordercomcate.OrdercomcateStocksVO;
import com.gmcc.pboss.business.sales.partnerres.PartnerresDBParam;
import com.gmcc.pboss.business.sales.simrealtimeamt.SimrealtimeamtDBParam;
import com.gmcc.pboss.business.sales.simrealtimeamt.SimrealtimeamtVO;
import com.gmcc.pboss.business.sales.wayassistant.WayassistantDBParam;
import com.gmcc.pboss.business.sales.wayassistant.WayassistantVO;
import com.gmcc.pboss.control.sales.ordercomcate.Ordercomcate;
import com.gmcc.pboss.control.sales.ordercomcate.OrdercomcateBO;
import com.gmcc.pboss.control.sales.partnerres.Partnerres;
import com.gmcc.pboss.control.sales.partnerres.PartnerresBO;
import com.gmcc.pboss.control.sales.simrealtimeamt.Simrealtimeamt;
import com.gmcc.pboss.control.sales.simrealtimeamt.SimrealtimeamtBO;
import com.gmcc.pboss.control.sales.wayassistant.Wayassistant;
import com.gmcc.pboss.control.sales.wayassistant.WayassistantBO;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class EmptySimRealTimeUpdateBO extends AbstractControlBean implements
		EmptySimRealTimeUpdate {
	
	private static Logger log = Logger.getLogger(EmptySimRealTimeUpdateBO.class);

	public void process() throws Exception {
//		处理逻辑：
//		更新实时订购量
//		查询商品订购辅助信息表（FX_RU_WAYASSISTANT），对查询结果逐条处理，逻辑如下。
		Wayassistant wayassistant = (Wayassistant) BOFactory.build(
				WayassistantBO.class, user);
		DataPackage dp = wayassistant.doQuery(new WayassistantDBParam());
		
		Ordercomcate ordercomcate = (Ordercomcate) BOFactory.build(
				OrdercomcateBO.class, user);
		Partnerres partnerres = (Partnerres) BOFactory.build(
				PartnerresBO.class, user);
		
		Simrealtimeamt simrealtimeamt = (Simrealtimeamt) BOFactory.build(
				SimrealtimeamtBO.class, user);
		
		PartnerresDBParam partnerresDBParam = new PartnerresDBParam();
		
		if(dp.getDatas() !=null && dp.getDatas().size()>0){
			for(Iterator<WayassistantVO> it = dp.getDatas().iterator();it.hasNext();){
				try { 
				WayassistantVO wayassistantVO = it.next();
				log.info("**********开始处理 "+wayassistantVO.getWayid()+"************");
				//a.获取日月订购量
				DataPackage daymonthcountdp = ordercomcate.doQueryEmptySimRealTimeUpdateDayMonthCount(wayassistantVO.getWayid());
//				DataPackage daymonthcountdp = null;
				//b.1统计合作商销售空白卡数量
				DataPackage dpp = partnerres.doComcategoryQty(wayassistantVO.getWayid());
				//b.2 未订购完成的空白卡统计
				DataPackage buycountdp = ordercomcate.doQueryEmptySimRealTimeUpdateBuyCount(wayassistantVO.getWayid());
				
				// 领用量
				List lylList = new ArrayList();
				if (dpp.getDatas() == null || dpp.getDatas().size() == 0) {
					lylList = buycountdp.getDatas();
				}
				if (buycountdp.getDatas() == null || buycountdp.getDatas().size() == 0) {
					lylList = dpp.getDatas();
				}
				if (dpp.getDatas() != null && dpp.getDatas().size() > 0
						&& buycountdp.getDatas() != null
						&& buycountdp.getDatas().size() > 0) {
					List list = dpp.getDatas();
					for (Object object : list) {
						Map map = (Map) object;
						String comcategory = map.get("comcategory").toString();
						int count = Integer.parseInt(map.get("count").toString());
						
						List buycountlist = buycountdp.getDatas();
						for (Object buycount : buycountlist) {
							Map buycountmap = (Map) buycount;
							if (comcategory.equals(buycountmap.get("comcategory").toString())) {
								count += Integer.parseInt(buycountmap.get("count").toString());
								buycountdp.getDatas().remove(buycountmap);
								break;
							}
						}
						Map lylMap = new HashMap();
						lylMap.put("comcategory", count);
						lylList.add(lylMap);
					}
					
					if (buycountdp.getDatas().size() > 0) {
						List buycountlist = buycountdp.getDatas();
						for (Object buycount : buycountlist) {
							lylList.add(buycount);
						}
					}
				}
				
				List daymonthcountList = daymonthcountdp.getDatas();
				for (Object object : lylList) {
					Map map = (Map) object;
					String comcategory = map.get("comcategory").toString();
					Long nowstock = 0l;
					if(map.get("count") != null){
						nowstock = Long.parseLong(map.get("count").toString());
					}
					SimrealtimeamtDBParam simrealtimeamtDBParam = new SimrealtimeamtDBParam();
					simrealtimeamtDBParam.set_se_wayid(wayassistantVO.getWayid());
					simrealtimeamtDBParam.set_se_comcategory(comcategory);
					
					DataPackage dppp = simrealtimeamt.doQuery(simrealtimeamtDBParam);
					SimrealtimeamtVO simrealtimeamtVO = null;
					if(dppp != null && dppp.getDatas() != null && dppp.getDatas().size()>0){//存在就新增更新
						simrealtimeamtVO = (SimrealtimeamtVO)dppp.getDatas().get(0);
						long monordered = 0l;
						for (Object daymonthcount : daymonthcountList) {
							Map daymonthcountMap = (Map) daymonthcount;
							if (comcategory.equals(daymonthcountMap.get("comcategory").toString())) {
								monordered = Long.parseLong(daymonthcountMap.get("count").toString());
								daymonthcountList.remove(daymonthcountMap);
								break;
							}
						}
						simrealtimeamtVO.setMonordered(monordered);
						simrealtimeamtVO.setDayordered(0L);
						simrealtimeamtVO.setNowstock(nowstock);
						simrealtimeamtVO.setUptime(new Date(System.currentTimeMillis()));
						simrealtimeamt.doUpdate(simrealtimeamtVO);
					}else{//不存在就新增
						simrealtimeamtVO = new SimrealtimeamtVO();
						simrealtimeamtVO.setWayid(wayassistantVO.getWayid());
						simrealtimeamtVO.setComcategory(comcategory);
						long monordered = 0l;
						for (Object daymonthcount : daymonthcountList) {
							Map daymonthcountMap = (Map) daymonthcount;
							if (comcategory.equals(daymonthcountMap.get("comcategory").toString())) {
								monordered = Long.parseLong(daymonthcountMap.get("count").toString());
								daymonthcountList.remove(daymonthcountMap);
								break;
							}
						}
						simrealtimeamtVO.setMonordered(monordered);
						simrealtimeamtVO.setDayordered(0L);
						simrealtimeamtVO.setNowstock(nowstock);
						simrealtimeamtVO.setUptime(new Date(System.currentTimeMillis()));
						simrealtimeamt.doCreate(simrealtimeamtVO);
					}
				}
				
				for (Object object : daymonthcountList) {
					Map map = (Map) object;
					String comcategory = map.get("comcategory").toString();
					Long monordered = 0l;
					if(map.get("count") != null){
						monordered = Long.parseLong(map.get("count").toString());
					}
					SimrealtimeamtDBParam simrealtimeamtDBParam = new SimrealtimeamtDBParam();
					simrealtimeamtDBParam.set_se_wayid(wayassistantVO.getWayid());
					simrealtimeamtDBParam.set_se_comcategory(comcategory);
					
					DataPackage dppp = simrealtimeamt.doQuery(simrealtimeamtDBParam);
					SimrealtimeamtVO simrealtimeamtVO = null;
					if(dppp != null && dppp.getDatas() != null && dppp.getDatas().size()>0){//存在就新增更新
						simrealtimeamtVO = (SimrealtimeamtVO)dppp.getDatas().get(0);
						simrealtimeamtVO.setMonordered(monordered);
						simrealtimeamtVO.setDayordered(0L);
						simrealtimeamtVO.setNowstock(0L);
						simrealtimeamtVO.setUptime(new Date(System.currentTimeMillis()));
						simrealtimeamt.doUpdate(simrealtimeamtVO);
					}else{//不存在就新增
						simrealtimeamtVO = new SimrealtimeamtVO();
						simrealtimeamtVO.setWayid(wayassistantVO.getWayid());
						simrealtimeamtVO.setComcategory(comcategory);
						simrealtimeamtVO.setMonordered(monordered);
						simrealtimeamtVO.setDayordered(0L);
						simrealtimeamtVO.setNowstock(0L);
						simrealtimeamtVO.setUptime(new Date(System.currentTimeMillis()));
						simrealtimeamt.doCreate(simrealtimeamtVO);
					}
				}
				log.info("**********处理完毕 "+wayassistantVO.getWayid()+"************");
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					System.out.println(e.getMessage());
					log.info(e.getMessage());
				}
			}
		} 
		
	}

}
