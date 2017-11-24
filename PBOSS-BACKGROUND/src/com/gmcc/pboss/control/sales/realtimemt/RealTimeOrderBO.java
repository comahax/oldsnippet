package com.gmcc.pboss.control.sales.realtimemt;

import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.gmcc.pboss.business.base.dictitem.DictitemDBParam;
import com.gmcc.pboss.business.base.dictitem.DictitemVO;
import com.gmcc.pboss.business.sales.orderresdet.OrderresdetDAO;
import com.gmcc.pboss.business.sales.partnerres.PartnerresDAO;
import com.gmcc.pboss.business.sales.realtimeamt.RealtimeamtVO;
import com.gmcc.pboss.business.sales.wayassistant.WayassistantDBParam;
import com.gmcc.pboss.business.sales.wayassistant.WayassistantVO;
import com.gmcc.pboss.control.base.dictitem.Dictitem;
import com.gmcc.pboss.control.base.dictitem.DictitemBO;
import com.gmcc.pboss.control.sales.realtimeamt.Realtimeamt;
import com.gmcc.pboss.control.sales.realtimeamt.RealtimeamtBO;
import com.gmcc.pboss.control.sales.wayassistant.Wayassistant;
import com.gmcc.pboss.control.sales.wayassistant.WayassistantBO;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DBQueryParam;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * 套卡实时订购量更新
 * @author wefrogll  
 * @version 1.0 2009-12-29
 * @version 2.0 2010-6-22 by zhangsiwei
 */
public class RealTimeOrderBO extends AbstractControlBean implements RealTimeOrder{
	private final static String BRAND_ALLBRAND = "AllBrand";
	private Log log = LogFactory.getLog(RealTimeOrderBO.class);
	private static final String DAYANDMONTHORDER_STATE_NOTBY_BRAND = "com.gmcc.pboss.business.sales.orderresdet.DAYANDMONTHORDER_STATE_NOTBY_BRAND";
	
	private static final String DAYANDMONTHORDER_STATE_BY_BRAND = "com.gmcc.pboss.business.sales.orderresdet.DAYANDMONTHORDER_STATE_BY_BRAND";
	
	private static final String STORAGE_COUNT_NOTBY_BRAND = "com.gmcc.pboss.business.sales.orderresdet.STORAGE_COUNT_NOTBY_BRAND";
	
	private static final String STORAGE_STATE_NOTBY_BRAND = "com.gmcc.pboss.business.sales.orderresdet.STORAGE_STATE_NOTBY_BRAND";
	
	private static final String STORAGE_COUNT_BY_BRAND = "com.gmcc.pboss.business.sales.orderresdet.STORAGE_COUNT_BY_BRAND";
	
	private static final String STORAGE_STATE_BY_BRAND = "com.gmcc.pboss.business.sales.orderresdet.STORAGE_STATE_BY_BRAND";
	
	public void process() throws Exception {
		// TODO Auto-generated method stub
		try{
//			1)
			//boolean isMonDayLimit = false; // 是否"日月订购量模式" 默认为否
			
			// ================根据需求单CR_ZQ20100611_1051316的修改=============
			// 获取订购量约束模式, 查询系统参数配置表（IB_GL_SYSPARAM），匹配参数类型为“pboss_fx”，参数标识为“45”，
			// 如果有数据且参数值不为空，则订购量约束模式取参数值；否则订购量约束模式默认取日月订购量模式（即MONDAYLIMIT）
			/*Sysparam sysparamBO = (SysparamBO)BOFactory.build(SysparamBO.class,user);
			String paramValue = sysparamBO.doFindByID("45", "pboss_fx");
			if("".equals(paramValue) || paramValue == null) {
				paramValue = "MONDAYLIMIT";
			}
			if(paramValue.equals("MONDAYLIMIT"))
				isMonDayLimit = true;*/
//			获取套卡是否区分品牌，查询系统参数配置表（IB_GL_SYSPARAM），匹配参数类型等于“pboss_fx”、参数标识等于“12”，
//			如果有数据且参数值为1则区分品牌，否则不区分品牌。如果区分品牌，则查询代码字典表（SA_DB_DICTITEM）获取品牌集合，
//			大致SQL：select DICTID, DICTNAME from SA_DB_DICTITEM where GROUPID='FX_SMPBRAND' and DICTID<>'AllBrand';
//			 编码DICTID对应品牌标识，名称DICTNAME对应品牌名称。
			Dictitem dictitemBO = (DictitemBO)BOFactory.build(DictitemBO.class,user);
			DictitemDBParam dictitemParam = new DictitemDBParam();
			dictitemParam.setQueryAll(true);
			dictitemParam.setDataOnly(true);
			dictitemParam.set_se_groupid("FX_SMPBRAND");
			dictitemParam.set_sne_dictid(BRAND_ALLBRAND);
			DataPackage dictitemDP = dictitemBO.doQuery(dictitemParam);
			List<DictitemVO> brands = dictitemDP.getDatas();


//			2)查询商品订购辅助信息表（FX_RU_WAYASSISTANT），匹配是否可发起订购为是（即CANORDER=1），对查询结果逐条处理
			Wayassistant wayassistantBO = (WayassistantBO)BOFactory.build(WayassistantBO.class,user);
			WayassistantDBParam wayassistantParam = new WayassistantDBParam();
			wayassistantParam.setQueryAll(true);
			wayassistantParam.setDataOnly(true);
			//wayassistantParam.set_ne_canorder("1");
			DataPackage wayassistantDP =  wayassistantBO.doQuery(wayassistantParam);
			if( null != wayassistantDP && null != wayassistantDP.getDatas() && 0<wayassistantDP.getDatas().size()){
				RealTimeOrder realTimeOrderBO = (RealTimeOrderBO)BOFactory.build(RealTimeOrderBO.class,user);
				List<WayassistantVO> wayassistantList = wayassistantDP.getDatas();
				
				
				for(WayassistantVO wayassistantVO:wayassistantList){
					long s = System.currentTimeMillis();
					try{
						realTimeOrderBO.doUpdateRealtimeOrder(wayassistantVO.getWayid(), brands);
					}catch(Exception e){
						LoggerUtils.error(e,log);
					}
					//System.out.println("======================="+(System.currentTimeMillis()-s));
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new JOPException(e.getMessage());
		}
	}

	/**
	 * 
	 */
	public void doUpdateRealtimeOrder(String wayId,List<DictitemVO> brands) throws Exception {
		try{
//			关联查询订单表（FX_SW_ORDER）和订单资源明细表（FX_SW_ORDERRESDET）统计合作商当月套卡订购量，
			Realtimeamt realtimeamtBO = (RealtimeamtBO)BOFactory.build(RealtimeamtBO.class,user);
			OrderresdetDAO orderresdetDAO = (OrderresdetDAO)DAOFactory.build(OrderresdetDAO.class, user);
			DBQueryParam queryParam = new DBQueryParam();
			queryParam.setQueryAll(true);
			queryParam.setDataOnly(true);
			queryParam.setSelectFieldsString("num");
			queryParam.getQueryConditions().put("WAYID", wayId);
			
//			关联查询订单表（FX_SW_ORDER）、订单商品种类（FX_SW_ORDERRESDET）和商品种类组合关系表（IM_PR_COMCATEGORYRELA）统计合作商当月套卡订购量，
			//Realtimeamt realtimeamtBO = (RealtimeamtBO)BOFactory.build(RealtimeamtBO.class,user);
			PartnerresDAO partnerresDAO = (PartnerresDAO)DAOFactory.build(PartnerresDAO.class, user);
			DBQueryParam queryParam1 = new DBQueryParam();
			queryParam1.setQueryAll(true);
			queryParam1.setDataOnly(true);
			queryParam1.getQueryConditions().put("WAYID", wayId);
			
			//log.info("=========不区分品牌，更新日月订购量、更新库存，开始处理==========");
			doNotByBrand(wayId,brands,realtimeamtBO,orderresdetDAO,queryParam,partnerresDAO,queryParam1);//
			//log.info("=========不区分品牌，更新日月订购量、更新库存，处理结束==========");
			
			//log.info("========= 区分品牌，更新日月订购量、更新库存，开始处理==========");
			doByBrand(wayId,brands,realtimeamtBO,orderresdetDAO,queryParam,partnerresDAO,queryParam1);//
			//log.info("========= 区分品牌，更新日月订购量、更新库存，处理结束==========");
			
			//if(isMonDayLimit){
//				a、	更新日月订购量
//				如果订购量约束模式不是日月订购量模式则跳过本步骤，否则继续。
				//this.doDayAndMonthOrder(wayassistantVO.getWayid(),brands);
			//}else {
//				b、	更新库存量
//				如果订购量约束模式为日月订购量模式则跳过本步骤，否则继续。
				//this.doStorage(wayassistantVO.getWayid(),brands)	;
			//}

		}catch(Exception e){
			LoggerUtils.error(e,log);
			if( null != e.getCause() && null != e.getCause().getMessage())
				throw new JOPException(e.getCause().getMessage());
			throw new JOPException(e.getMessage());
		}
	}
	
	/**
	 * 不区分品牌，更新日月订购量、更新库存<BR>
	 * 
	 * @param wayid	渠道商编码
	 * @param brands	品牌
	 * @throws Exception
	 */
	private void doNotByBrand(String wayid,List<DictitemVO> brands,Realtimeamt realtimeamtBO,
			OrderresdetDAO orderresdetDAO,DBQueryParam queryParam,
			PartnerresDAO partnerresDAO, DBQueryParam queryParam1) throws Exception {//
//		如果不区分品牌则进行统计（统计结果为空时默认统计值取零），然后查询订购量实时记录表（FX_SW_REALTIMEAMT），
//		匹配合作商编码和品牌（取AllBrand），如果存在数据则更新当月已订购量为SQL统计值，更新当天已订购量为0，
//		更新时间取当前系统时间；如果不存在数据，则插入订购量实时记录表一条记录，合作商编码取渠道编码，
//		套卡品牌取AllBrand，当月已订购量取SQL统计值，当天已订购量取0，更新时间取当前系统时间。
		String count = "";
		DataPackage orderesDP = orderresdetDAO.queryByNamedSqlQuery(DAYANDMONTHORDER_STATE_NOTBY_BRAND, queryParam);
		if( null != orderesDP && null != orderesDP.getDatas() && 0<orderesDP.getDatas().size() && orderesDP.getDatas().get(0) != null){
			count = (String)orderesDP.getDatas().get(0);
		}else{
			count = "0";
		}
			RealtimeamtVO realtimeamtVO = new RealtimeamtVO();
			realtimeamtVO.setBrand(BRAND_ALLBRAND);
			realtimeamtVO.setWayid(wayid);
			realtimeamtVO = realtimeamtBO.doFindByPk(realtimeamtVO);
						
//			首先，查询合作商资源表（FX_SW_PARTNERRES）统计合作商未激活套卡数量
			queryParam1.setSelectFieldsString("num");
			DataPackage partnerresDP = partnerresDAO.queryByNamedSqlQuery(STORAGE_COUNT_NOTBY_BRAND, queryParam1);
			long notActive = 0;
			if( null != partnerresDP && null != partnerresDP.getDatas() && 0<partnerresDP.getDatas().size()){
				notActive = Long.parseLong((String) partnerresDP.getDatas().get(0));
//				如果不区分品牌则采用第一条SQL进行统计（统计结果为空时默认统计值取零），将未激活和未订购完成的套卡数量进行合并累加，
//				然后查询订购量实时记录表（FX_SW_REALTIMEAMT），匹配合作商编码和品牌（取AllBrand），
//				如果存在数据则更新当前库存量为SQL统计值，更新时间取当前系统时间；如果不存在数据，则插入订购量实时记录表一条记录
//				，合作商编码取渠道编码，套卡品牌取AllBrand，当前库存量取累加数量，更新时间取当前系统时间。			
						
			}
			
			queryParam1.setSelectFieldsString("num");
			DataPackage numDP = partnerresDAO.queryByNamedSqlQuery(STORAGE_STATE_NOTBY_BRAND, queryParam1);
			String notOrder = "0";
			if( null != numDP && null != numDP.getDatas() && 0<numDP.getDatas().size() && null != numDP.getDatas().get(0)){
				notOrder = (String)numDP.getDatas().get(0);
			}
			log.info("不区分品牌，更新日月订购量、更新库存===" +
					"；wayid："+wayid+
					"；brand："+BRAND_ALLBRAND+
					"；当月订购量："+count+
					"；库存未激活量："+notActive+
					"；未订购完成量："+notOrder);
			if( null != realtimeamtVO){
				realtimeamtVO.setDayordered(new Long(0));
				realtimeamtVO.setMonordered(new Long(count));
				realtimeamtVO.setNowstock(new Long(notOrder)+notActive);// 当前库存量 = 未激活+未订购完成的套卡数量
				realtimeamtVO.setUptime(new Date());
				realtimeamtBO.doUpdate(realtimeamtVO);
			}else{
				realtimeamtVO = new RealtimeamtVO();
				realtimeamtVO.setWayid(wayid);
				realtimeamtVO.setBrand(BRAND_ALLBRAND);
				realtimeamtVO.setMonordered(new Long(count));
				realtimeamtVO.setNowstock(new Long(notOrder)+notActive);// 当前库存量 = 未激活+未订购完成的套卡数量
				realtimeamtVO.setDayordered(new Long(0));
				realtimeamtVO.setUptime(new Date());					
				realtimeamtBO.doCreate(realtimeamtVO);
			}
	}
	
	/**
	 * 区分品牌，更新日月订购量、更新库存<BR>
	 * 
	 * @param wayid	渠道商编码
	 * @param brands	品牌
	 * @throws Exception
	 */
	private void doByBrand(String wayid,List<DictitemVO> brands,Realtimeamt realtimeamtBO,
			OrderresdetDAO orderresdetDAO,DBQueryParam queryParam,
			PartnerresDAO partnerresDAO, DBQueryParam queryParam1) throws Exception {//
//		如果区分品牌则，对品牌集合逐条统计（统计结果为空时默认统计值取零），然后查询订购量实时记录表（FX_SW_REALTIMEAMT），
//		匹配合作商编码和品牌，如果存在数据则更新当月已订购量为SQL统计值，更新当天已订购量为0，更新时间取当前系统时间；
//		如果不存在数据，则插入订购量实时记录表一条记录，合作商编码取渠道编码，套卡品牌取对应品牌编码，
//		当月已订购量取SQL统计值，当天已订购量取0，更新时间取当前系统时间。
		for(DictitemVO dictiemVO:brands){
			//log.info(" wayid ="+wayid+"  brand="+dictiemVO.getDictid());
			queryParam.getQueryConditions().put("BRAND", dictiemVO.getDictid());
			DataPackage numDP = orderresdetDAO.queryByNamedSqlQuery(DAYANDMONTHORDER_STATE_BY_BRAND, queryParam);
			String count = "";
			if( null != numDP && null != numDP.getDatas() && 0<numDP.getDatas().size() && numDP.getDatas().get(0) != null){
				count = (String)numDP.getDatas().get(0);
			}else{
				count = "0";
			}
			RealtimeamtVO realtimeamtVO = new RealtimeamtVO();
			realtimeamtVO.setBrand(dictiemVO.getDictid());
			realtimeamtVO.setWayid(wayid);
			realtimeamtVO = realtimeamtBO.doFindByPk(realtimeamtVO);
			
			queryParam1.setSelectFieldsString("num");
			queryParam1.getQueryConditions().put("BRAND",dictiemVO.getDictid());
			DataPackage partnerresDP = partnerresDAO.queryByNamedSqlQuery(STORAGE_COUNT_BY_BRAND, queryParam1);
			long notActive = 0;
			String notOrder = "0";
			if( null != partnerresDP && null != partnerresDP.getDatas() && 0<partnerresDP.getDatas().size()){
				notActive = Long.parseLong((String) partnerresDP.getDatas().get(0));
//				如果区分品牌则采用第二条SQL对品牌集合逐条统计（统计结果为空时默认统计值取零），将未激活和未订购完成的套卡数量进行合并累加，
//				然后查询订购量实时记录表（FX_SW_REALTIMEAMT），匹配合作商编码和品牌，如果存在数据则更新当前库存量为SQL统计值，
//				更新时间取当前系统时间；如果不存在数据，则插入订购量实时记录表一条记录，合作商编码取渠道编码，
//				套卡品牌取对应品牌，当前库存量取累加数量，更新时间取当前系统时间。
								
			}
			queryParam1.setSelectFieldsString("num");
			numDP = partnerresDAO.queryByNamedSqlQuery(STORAGE_STATE_BY_BRAND, queryParam1);
			if( null != numDP && null != numDP.getDatas() && 0<numDP.getDatas().size() && null != numDP.getDatas().get(0)){
				notOrder = (String) numDP.getDatas().get(0);
			}
			
			log.info("区分品牌，更新日月订购量、更新库存+++" +
					"；wayid："+wayid+
					"；brand："+dictiemVO.getDictid()+
					"；当月订购量："+count+
					"；库存未激活量："+notActive+
					"；未订购完成量："+notOrder);
			if( null != realtimeamtVO){
				realtimeamtVO.setDayordered(new Long(0));
				realtimeamtVO.setMonordered(new Long(count));
				realtimeamtVO.setNowstock(new Long(notOrder)+notActive); // 当前库存量 = 未激活+未订购完成的套卡数量
				realtimeamtVO.setUptime(new Date());
				realtimeamtBO.doUpdate(realtimeamtVO);
			}else{
				realtimeamtVO = new RealtimeamtVO();
				realtimeamtVO.setWayid(wayid);
				realtimeamtVO.setBrand(dictiemVO.getDictid());
				realtimeamtVO.setMonordered(new Long(count));
				realtimeamtVO.setNowstock(new Long(notOrder)+notActive); // 当前库存量 = 未激活+未订购完成的套卡数量
				realtimeamtVO.setDayordered(new Long(0));
				realtimeamtVO.setUptime(new Date());					
				realtimeamtBO.doCreate(realtimeamtVO);
			}
		}
	}

	/**
	 * 更新日月订购量
	 * @param wayid	渠道商编码
	 * @param isBbrand	是否区分品牌 TRUE:Y,FALSE:N
	 * @throws Exception
	 */
	private void doDayAndMonthOrder(String wayid,List<DictitemVO> brands) throws Exception {
//			关联查询订单表（FX_SW_ORDER）和订单资源明细表（FX_SW_ORDERRESDET）统计合作商当月套卡订购量，
		Realtimeamt realtimeamtBO = (RealtimeamtBO)BOFactory.build(RealtimeamtBO.class,user);
		OrderresdetDAO orderresdetDAO = (OrderresdetDAO)DAOFactory.build(OrderresdetDAO.class, user);
		DBQueryParam queryParam = new DBQueryParam();
		queryParam.setQueryAll(true);
		queryParam.setDataOnly(true);
		queryParam.setSelectFieldsString("num");
		queryParam.getQueryConditions().put("WAYID", wayid);
		log.info("================更新日月订购量=======================");
		dayAndMonthOrderNotWithBrand(wayid,realtimeamtBO,orderresdetDAO,queryParam);
		dayAndMonthOrderWithBrand(wayid,brands,realtimeamtBO,orderresdetDAO,queryParam);
	}
	/**
	 * 更新库存
	 * @param wayid	渠道商编码
	 * @param isBbrand	是否区分品牌 TRUE:Y,FALSE:N
	 * @throws Exception
	 */
	private void doStorage(String wayid,List<DictitemVO> brands) throws Exception {
//		关联查询订单表（FX_SW_ORDER）、订单商品种类（FX_SW_ORDERRESDET）和商品种类组合关系表（IM_PR_COMCATEGORYRELA）统计合作商当月套卡订购量，
		Realtimeamt realtimeamtBO = (RealtimeamtBO)BOFactory.build(RealtimeamtBO.class,user);
		PartnerresDAO partnerresDAO = (PartnerresDAO)DAOFactory.build(PartnerresDAO.class, user);
		DBQueryParam queryParam = new DBQueryParam();
		queryParam.setQueryAll(true);
		queryParam.setDataOnly(true);
		queryParam.getQueryConditions().put("WAYID", wayid);
		log.info("================更新库存=======================");
		storageNotWithBrand(wayid,realtimeamtBO,partnerresDAO,queryParam);
		storageWithBrand(wayid,brands,realtimeamtBO,partnerresDAO,queryParam);
	}
	
	/**
	 * 日月订购量更新(不区分品牌)
	 * @param wayid
	 * @param realtimeamtBO
	 * @param orderresdetDAO
	 * @param queryParam
	 * @throws Exception
	 */
	private void dayAndMonthOrderNotWithBrand(String wayid,Realtimeamt realtimeamtBO,OrderresdetDAO orderresdetDAO,DBQueryParam queryParam) throws Exception {
		
//		如果不区分品牌则进行统计（统计结果为空时默认统计值取零），然后查询订购量实时记录表（FX_SW_REALTIMEAMT），
//		匹配合作商编码和品牌（取AllBrand），如果存在数据则更新当月已订购量为SQL统计值，更新当天已订购量为0，
//		更新时间取当前系统时间；如果不存在数据，则插入订购量实时记录表一条记录，合作商编码取渠道编码，
//		套卡品牌取AllBrand，当月已订购量取SQL统计值，当天已订购量取0，更新时间取当前系统时间。
		String count = "";
		DataPackage orderesDP = orderresdetDAO.queryByNamedSqlQuery(DAYANDMONTHORDER_STATE_NOTBY_BRAND, queryParam);
		if( null != orderesDP && null != orderesDP.getDatas() && 0<orderesDP.getDatas().size() && orderesDP.getDatas().get(0) != null){
			count = (String)orderesDP.getDatas().get(0);
		}else{
			count = "0";
		}
			RealtimeamtVO realtimeamtVO = new RealtimeamtVO();
			realtimeamtVO.setBrand(BRAND_ALLBRAND);
			realtimeamtVO.setWayid(wayid);
			realtimeamtVO = realtimeamtBO.doFindByPk(realtimeamtVO);
			if( null != realtimeamtVO){
				realtimeamtVO.setDayordered(new Long(0));
				realtimeamtVO.setMonordered(new Long(count));
				realtimeamtVO.setUptime(new Date());
				realtimeamtBO.doUpdate(realtimeamtVO);
			}else{
				realtimeamtVO = new RealtimeamtVO();
				realtimeamtVO.setWayid(wayid);
				realtimeamtVO.setBrand(BRAND_ALLBRAND);
				realtimeamtVO.setMonordered(new Long(count));
				realtimeamtVO.setDayordered(new Long(0));
				realtimeamtVO.setUptime(new Date());					
				realtimeamtBO.doCreate(realtimeamtVO);
			}
	}
	/**
	 * 日月订购量更新(区分品牌)
	 * @param wayid
	 * @param brands
	 * @param realtimeamtBO
	 * @param orderresdetDAO
	 * @param queryParam
	 * @throws Exception
	 */
	private void dayAndMonthOrderWithBrand(String wayid,
			List<DictitemVO> brands, Realtimeamt realtimeamtBO,
			OrderresdetDAO orderresdetDAO, DBQueryParam queryParam)
			throws Exception {
		
//		如果区分品牌则，对品牌集合逐条统计（统计结果为空时默认统计值取零），然后查询订购量实时记录表（FX_SW_REALTIMEAMT），
//		匹配合作商编码和品牌，如果存在数据则更新当月已订购量为SQL统计值，更新当天已订购量为0，更新时间取当前系统时间；
//		如果不存在数据，则插入订购量实时记录表一条记录，合作商编码取渠道编码，套卡品牌取对应品牌编码，
//		当月已订购量取SQL统计值，当天已订购量取0，更新时间取当前系统时间。
		for(DictitemVO dictiemVO:brands){
			log.info(" wayid ="+wayid+"  brand="+dictiemVO.getDictid());
			queryParam.getQueryConditions().put("BRAND", dictiemVO.getDictid());
			DataPackage numDP = orderresdetDAO.queryByNamedSqlQuery(DAYANDMONTHORDER_STATE_BY_BRAND, queryParam);
			String count = "";
			if( null != numDP && null != numDP.getDatas() && 0<numDP.getDatas().size() && numDP.getDatas().get(0) != null){
				count = (String)numDP.getDatas().get(0);
			}else{
				count = "0";
			}
			RealtimeamtVO realtimeamtVO = new RealtimeamtVO();
			realtimeamtVO.setBrand(dictiemVO.getDictid());
			realtimeamtVO.setWayid(wayid);
			realtimeamtVO = realtimeamtBO.doFindByPk(realtimeamtVO);
			if( null != realtimeamtVO){
				realtimeamtVO.setDayordered(new Long(0));
				realtimeamtVO.setMonordered(new Long(count));
				realtimeamtVO.setUptime(new Date());
				realtimeamtBO.doUpdate(realtimeamtVO);
			}else{
				realtimeamtVO = new RealtimeamtVO();
				realtimeamtVO.setWayid(wayid);
				realtimeamtVO.setBrand(dictiemVO.getDictid());
				realtimeamtVO.setMonordered(new Long(count));
				realtimeamtVO.setDayordered(new Long(0));
				realtimeamtVO.setUptime(new Date());					
				realtimeamtBO.doCreate(realtimeamtVO);
			}
		}
	}
	
	/**
	 * 库存量更新(不区分品牌)
	 * @param wayid
	 * @param realtimeamtBO
	 * @param partnerresDAO
	 * @param queryParam
	 * @throws Exception
	 */
	private void storageNotWithBrand(String wayid, Realtimeamt realtimeamtBO,
			PartnerresDAO partnerresDAO, DBQueryParam queryParam)
			throws Exception {
//		首先，查询合作商资源表（FX_SW_PARTNERRES）统计合作商未激活套卡数量
		queryParam.setSelectFieldsString("num");
		DataPackage partnerresDP = partnerresDAO.queryByNamedSqlQuery(STORAGE_COUNT_NOTBY_BRAND, queryParam);
		if( null != partnerresDP && null != partnerresDP.getDatas() && 0<partnerresDP.getDatas().size()){
			long notActive = Long.parseLong((String) partnerresDP.getDatas().get(0));
//			如果不区分品牌则采用第一条SQL进行统计（统计结果为空时默认统计值取零），将未激活和未订购完成的套卡数量进行合并累加，
//			然后查询订购量实时记录表（FX_SW_REALTIMEAMT），匹配合作商编码和品牌（取AllBrand），
//			如果存在数据则更新当前库存量为SQL统计值，更新时间取当前系统时间；如果不存在数据，则插入订购量实时记录表一条记录
//			，合作商编码取渠道编码，套卡品牌取AllBrand，当前库存量取累加数量，更新时间取当前系统时间。			

			queryParam.setSelectFieldsString("num");
			DataPackage numDP = partnerresDAO.queryByNamedSqlQuery(STORAGE_STATE_NOTBY_BRAND, queryParam);
			String count = "0";
			if( null != numDP && null != numDP.getDatas() && 0<numDP.getDatas().size() && null != numDP.getDatas().get(0)){
				count = (String)numDP.getDatas().get(0);
			}
			RealtimeamtVO realtimeamtVO = new RealtimeamtVO();
			realtimeamtVO.setBrand(BRAND_ALLBRAND);
			realtimeamtVO.setWayid(wayid);
			realtimeamtVO = realtimeamtBO.doFindByPk(realtimeamtVO);
			
			if( null != realtimeamtVO){
				realtimeamtVO.setUptime(new Date());
				realtimeamtVO.setNowstock(new Long(count)+notActive);
				realtimeamtVO.setUptime(new Date());
				realtimeamtBO.doUpdate(realtimeamtVO);
			}else{
				realtimeamtVO = new RealtimeamtVO();
				realtimeamtVO.setBrand(BRAND_ALLBRAND);
				realtimeamtVO.setNowstock(new Long(count)+notActive);
				realtimeamtVO.setWayid(wayid);
				realtimeamtVO.setUptime(new Date());
				realtimeamtBO.doCreate(realtimeamtVO);
			}	
		}
	}
	
	/**
	 * 库存量更新(区分品牌)
	 * @param wayid
	 * @param brands
	 * @param realtimeamtBO
	 * @param partnerresDAO
	 * @param queryParam
	 * @throws Exception
	 */
	private void storageWithBrand(String wayid,List<DictitemVO> brands, Realtimeamt realtimeamtBO,
			PartnerresDAO partnerresDAO, DBQueryParam queryParam)
			throws Exception {
		
		for(DictitemVO dictiemVO:brands){
			log.info(" wayid ="+wayid+"  brand="+dictiemVO.getDictid());
			queryParam.setSelectFieldsString("num");
			queryParam.getQueryConditions().put("BRAND",dictiemVO.getDictid());
			DataPackage partnerresDP = partnerresDAO.queryByNamedSqlQuery(STORAGE_COUNT_BY_BRAND, queryParam);
			if( null != partnerresDP && null != partnerresDP.getDatas() && 0<partnerresDP.getDatas().size()){
				long notActive = Long.parseLong((String) partnerresDP.getDatas().get(0));
//				如果区分品牌则采用第二条SQL对品牌集合逐条统计（统计结果为空时默认统计值取零），将未激活和未订购完成的套卡数量进行合并累加，
//				然后查询订购量实时记录表（FX_SW_REALTIMEAMT），匹配合作商编码和品牌，如果存在数据则更新当前库存量为SQL统计值，
//				更新时间取当前系统时间；如果不存在数据，则插入订购量实时记录表一条记录，合作商编码取渠道编码，
//				套卡品牌取对应品牌，当前库存量取累加数量，更新时间取当前系统时间。

				String count = "0";
				queryParam.setSelectFieldsString("num");
				DataPackage numDP = partnerresDAO.queryByNamedSqlQuery(STORAGE_STATE_BY_BRAND, queryParam);
				if( null != numDP && null != numDP.getDatas() && 0<numDP.getDatas().size() && null != numDP.getDatas().get(0)){
					count = (String) numDP.getDatas().get(0);
				}
				
				RealtimeamtVO realtimeamtVO = new RealtimeamtVO();
				realtimeamtVO.setBrand(dictiemVO.getDictid());
				realtimeamtVO.setWayid(wayid);
				realtimeamtVO = realtimeamtBO.doFindByPk(realtimeamtVO);
				if( null != realtimeamtVO){
					realtimeamtVO.setNowstock(new Long(count)+notActive); // 当前库存量 = 未激活+未订购完成的套卡数量
					realtimeamtVO.setUptime(new Date());
					realtimeamtBO.doUpdate(realtimeamtVO);
				}else{
					realtimeamtVO = new RealtimeamtVO();
					realtimeamtVO.setBrand(dictiemVO.getDictid());
					realtimeamtVO.setWayid(wayid);
					realtimeamtVO.setNowstock(new Long(count)+notActive);
					realtimeamtVO.setUptime(new Date());
					realtimeamtBO.doCreate(realtimeamtVO);
				}	
			}
		}
	}
}
