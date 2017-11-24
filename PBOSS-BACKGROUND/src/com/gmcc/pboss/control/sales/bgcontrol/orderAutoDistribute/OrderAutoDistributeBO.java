package com.gmcc.pboss.control.sales.bgcontrol.orderAutoDistribute;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.gmcc.pboss.business.base.dictitem.DictitemDBParam;
import com.gmcc.pboss.business.base.dictitem.DictitemVO;
import com.gmcc.pboss.business.base.operator.OperatorDBParam;
import com.gmcc.pboss.business.base.operator.OperatorVO;
import com.gmcc.pboss.business.base.operrole.OperroleDBParam;
import com.gmcc.pboss.business.base.operrole.OperroleVO;
import com.gmcc.pboss.business.base.smstmpl.SmstmplVO;
import com.gmcc.pboss.business.base.sysparam.SysparamDBParam;
import com.gmcc.pboss.business.base.sysparam.SysparamVO;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.resource.comcatebrand.ComcatebrandDBParam;
import com.gmcc.pboss.business.resource.comcatebrand.ComcatebrandVO;
import com.gmcc.pboss.business.resource.stkalarmstat.StkalarmstatVO;
import com.gmcc.pboss.business.sales.bgbusiness.orderAutoDistribute.OrderAutoDistributeDAO;
import com.gmcc.pboss.business.sales.comdisscale.ComdisscaleDBParam;
import com.gmcc.pboss.business.sales.comdisscale.ComdisscaleVO;
import com.gmcc.pboss.business.sales.comorder.ComorderConstant;
import com.gmcc.pboss.business.sales.comorder.ComorderVO;
import com.gmcc.pboss.business.sales.order.OrderVO;
import com.gmcc.pboss.business.sales.orderuplimit.OrderuplimitDBParam;
import com.gmcc.pboss.business.sales.orderuplimit.OrderuplimitVO;
import com.gmcc.pboss.business.sales.realtimeamt.RealtimeamtDBParam;
import com.gmcc.pboss.business.sales.realtimeamt.RealtimeamtVO;
import com.gmcc.pboss.business.sales.stockalarm.StockalarmDBParam;
import com.gmcc.pboss.business.sales.stockalarm.StockalarmVO;
import com.gmcc.pboss.business.sales.stockalmfloat.StockalmfloatVO;
import com.gmcc.pboss.business.sales.wayassistant.WayassistantDBParam;
import com.gmcc.pboss.business.sales.wayassistant.WayassistantVO;
import com.gmcc.pboss.control.base.dictitem.Dictitem;
import com.gmcc.pboss.control.base.dictitem.DictitemBO;
import com.gmcc.pboss.control.base.operator.Operator;
import com.gmcc.pboss.control.base.operator.OperatorBO;
import com.gmcc.pboss.control.base.operrole.Operrole;
import com.gmcc.pboss.control.base.operrole.OperroleBO;
import com.gmcc.pboss.control.base.smstmpl.Smstmpl;
import com.gmcc.pboss.control.base.smstmpl.SmstmplBO;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.channel.waitreq.Waitreq;
import com.gmcc.pboss.control.channel.waitreq.WaitreqBO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.communication.pendingtask.Pendingtask;
import com.gmcc.pboss.control.communication.pendingtask.PendingtaskBO;
import com.gmcc.pboss.control.resource.comcatebrand.ComcatebrandBO;
import com.gmcc.pboss.control.resource.comcategoryrela.Comcategoryrela;
import com.gmcc.pboss.control.resource.comcategoryrela.ComcategoryrelaBO;
import com.gmcc.pboss.control.resource.stkalarmstat.Stkalarmstat;
import com.gmcc.pboss.control.resource.stkalarmstat.StkalarmstatBO;
import com.gmcc.pboss.control.sales.comdisscale.Comdisscale;
import com.gmcc.pboss.control.sales.comdisscale.ComdisscaleBO;
import com.gmcc.pboss.control.sales.comorder.Comorder;
import com.gmcc.pboss.control.sales.comorder.ComorderBO;
import com.gmcc.pboss.control.sales.order.Order;
import com.gmcc.pboss.control.sales.order.OrderBO;
import com.gmcc.pboss.control.sales.orderuplimit.Orderuplimit;
import com.gmcc.pboss.control.sales.orderuplimit.OrderuplimitBO;
import com.gmcc.pboss.control.sales.realtimeamt.Realtimeamt;
import com.gmcc.pboss.control.sales.realtimeamt.RealtimeamtBO;
import com.gmcc.pboss.control.sales.stockalarm.Stockalarm;
import com.gmcc.pboss.control.sales.stockalarm.StockalarmBO;
import com.gmcc.pboss.control.sales.wayassistant.Wayassistant;
import com.gmcc.pboss.control.sales.wayassistant.WayassistantBO;
import com.sunrise.jop.common.utils.lang.Code2NameUtils;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.common.utils.lang.TimeUtils;
import com.sunrise.jop.exception.business.SaleException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class OrderAutoDistributeBO extends AbstractControlBean implements
		OrderAutoDistribute {

	private Logger log = Logger.getLogger(OrderAutoDistributeBO.class);

	// 收集所有订单的商品种类与数量_add by yedaoe
	List<ComorderVO> comorderListForAllOrders = new LinkedList<ComorderVO>();
	// 订单标识,多个订单之间以“/”分隔
	String orderidstr = "";

	public void doProcess() throws Exception {

		// boolean isDifBrand = this.checkBrand();
		Set<String> brandSet = this.getSmpBrandSet();
		this.orderDistribution(brandSet);
		// 删除【累计分配量】和【订单汇总】逻辑
		// this.orderCollection(orderCollection);
	}

	/**
	 * 检查是否区分品牌
	 * 
	 * @return
	 * @throws Exception
	 */
	private boolean checkBrand() throws Exception {
		Sysparam spBo = (SysparamBO) BOFactory.build(SysparamBO.class, user);
		String paramValue = spBo.doFindByID(12L, "pboss_fx");
		if (StringUtils.isEmpty(paramValue))
			throw new Exception("参数[是否区分品牌]未设置");
		if ("1".equals(paramValue))
			return true;
		else
			return false;
	}

	/**
	 * 1) 载入【套卡品牌集合】
	 * 
	 * @param isDifBrand
	 * @return
	 * @throws Exception
	 */
	private Set<String> getSmpBrandSet() throws Exception {
		Dictitem diBO = (Dictitem) BOFactory.build(DictitemBO.class, user);
		DictitemDBParam param = new DictitemDBParam();
		param.set_se_groupid("FX_SMPBRAND");
		param.set_pagesize("0");
		param.setDataOnly(true);
		// if (isDifBrand) {
		param.set_sne_dictid("AllBrand");
		// } else {
		// param.set_se_dictid("AllBrand");
		// }
		DataPackage dp = diBO.doQuery(param);
		Set<String> brandSet = new HashSet();
		List list = dp.getDatas();
		for (int i = 0; i < list.size(); i++) {
			DictitemVO vo = (DictitemVO) list.get(i);
			brandSet.add(vo.getDictid());
		}
		return brandSet;
	}

	/**
	 * 2) 载入【套卡品牌包大小】
	 * 
	 * @return
	 * @throws Exception
	 */
	private Map<String, Integer> getBrandPackSize(Set<String> brandSet)
			throws Exception {
		Sysparam spBo = (SysparamBO) BOFactory.build(SysparamBO.class, user);
		String paramValue = spBo.doFindByID(5L, "pboss_fx");
		if (StringUtils.isEmpty(paramValue))
			throw new Exception("参数[套卡品牌包大小]未设置");
		String[] packSizeArr1 = StringUtils.split(paramValue, "|");
		Map<String, Integer> brandPackSizeMap = new HashMap<String, Integer>();
		for (String packSize : packSizeArr1) {
			String[] packSizeArr2 = StringUtils.splitByWholeSeparator(packSize,
					":");
			try {
				Integer packsize = Integer.parseInt(packSizeArr2[1]);
				if (packsize <= 0)
					throw new Exception();
				brandPackSizeMap.put(packSizeArr2[0], packsize);
			} catch (Exception ex) {
				throw new Exception("参数[套卡品牌包大小]设置错误，要求为大于0的整数");
			}
		}
		// 以品牌集合为基础，对品牌包大小MAP进行逐个匹配，如果匹配失败则输出“参数[套卡品牌包大小]设置错误，
		// 该品牌[XX]未设置包大小”并退出，否则继续。

		for (Iterator<String> it = brandSet.iterator(); it.hasNext();) {
			String brand = it.next();
			if (!brandPackSizeMap.containsKey(brand)) {
				throw new Exception("参数[套卡品牌包大小]设置错误，该品牌[" + brand + "]未设置包大小");
			}
		}

		return brandPackSizeMap;
	}

	/**
	 * 3) 载入【品牌和商品种类集合】
	 * 
	 * @param brandSet
	 *            品牌集合
	 * @return
	 * @throws Exception
	 */
	private Map<String, List<String>> getBrandComcategory(Set<String> brandSet)
			throws Exception {

		// 查询商品种类品牌对应关系表(IM_PR_COMCATEBRAND)，保存品牌和商品种类对应关系。
		ComcatebrandBO comcatebrandBO = (ComcatebrandBO) BOFactory.build(
				ComcatebrandBO.class, user);
		ComcatebrandDBParam comcatdb = new ComcatebrandDBParam();
		comcatdb.setQueryAll(true);
		comcatdb.setDataOnly(true);
		// 查询所有的商品种类品牌对应关系数据，然后与品牌信息进行比较
		DataPackage dp = comcatebrandBO.doQuery(comcatdb);
		Map<String, List<String>> brandComcateMap = new HashMap<String, List<String>>();
		// 与品牌信息进行比较

		if (dp != null && dp.getDatas() != null) {
			List datalist = dp.getDatas();
			for (Iterator<String> it = brandSet.iterator(); it.hasNext();) {
				String brand = it.next();
				List<String> comCateList = new ArrayList<String>();
				for (int i = 0; i < datalist.size(); i++) {
					ComcatebrandVO comc = (ComcatebrandVO) datalist.get(i);
					if (comc.getBrand() != null && brand != null) {
						if (comc.getBrand().equals(brand)) {
							comCateList.add(comc.getComcategory());
						}
					}
				}

				brandComcateMap.put(brand, comCateList);
			}
		}

		return brandComcateMap;
	}

	/**
	 * 4) 载入【商品分配比例设置】
	 * 
	 * @param brandSet
	 *            品牌集合
	 * @return
	 * @throws Exception
	 */
	private List getBrandComDisScale(Set<String> brandSet) throws Exception {

		// 查询商品分配比例设置表 (FX_RU_COMDISSCALE)，如果无数据则输出“商品分配比例未设置”并退出；
		// 否则保存该表数据到集合中，供后续使用。

		Comdisscale cdsBO = (Comdisscale) BOFactory.build(ComdisscaleBO.class,
				user);
		ComdisscaleDBParam params = new ComdisscaleDBParam();
		params.set_pagesize("0");
		params.setDataOnly(true);
		// Map<String, Map<String, Double>> brandComDisScaleMap = new
		// HashMap<String, Map<String, Double>>();
		params.setQueryAll(true);
		params.setDataOnly(true);
		DataPackage dp = cdsBO.doQuery(params);
		if (dp == null || dp.getDatas() == null) {
			throw new Exception("商品分配比例未设置");
		}
		List listdiscale = dp.getDatas();

		// for (Iterator<String> it = brandSet.iterator(); it.hasNext();) {
		// String brand = it.next();
		// Map<String, Double> comDisScaleMap = new TreeMap<String, Double>();
		// for (int i = 0; i < listdiscale.size(); i++) {
		// ComdisscaleVO vo = (ComdisscaleVO) listdiscale.get(i);
		// if(vo.getBrand()!=null && vo.getBrand().equals(brand)){
		// comDisScaleMap.put(vo.getComcategory(), vo.getDisscale());
		// }
		// }
		// brandComDisScaleMap.put(brand, comDisScaleMap);
		// }
		return listdiscale;
	}

	/**
	 * 5) 订单分配
	 * 
	 * @param brandSet
	 * @throws Exception
	 */
	private void orderDistribution(Set<String> brandSet) throws Exception {
		Wayassistant waBO = (Wayassistant) BOFactory.build(
				WayassistantBO.class, user);
		WayassistantDBParam waParams = new WayassistantDBParam();
		waParams.set_ne_canorder("1");
		waParams.set_pagesize("0");
		// waParams.set_se_wayid("TDZS04C102130");
		waParams.setDataOnly(true);
		DataPackage waDp = waBO.doQuery(waParams);
		List waList = waDp.getDatas();
		// 商品分配比例设置
		// Map<String, Map<String, Double>> brandComDisScaleMap = this
		// .getBrandComDisScale(brandSet);
		List brandComDisScaleMap = this.getBrandComDisScale(brandSet);
		// 品牌包大小
		Map<String, Integer> brandPackSizeMap = this.getBrandPackSize(brandSet);
		// 删除【累计分配量】和【订单汇总】逻辑
		// <分公司,预警订单汇总信息>
		// Map<String, AlaordercolVO> orderCollection = new HashMap<String,
		// AlaordercolVO>();

		for (int i = 0; i < waList.size(); i++) {
			try {
				WayassistantVO waVO = (WayassistantVO) waList.get(i);
				String wayid = waVO.getWayid();

				// 获取渠道资料

				WayVO wayvo = this.getWayinfo(wayid);

				// 获取库存量
				Map<String, Long> brandStocks = this.getBrandStocks(wayid,
						brandSet);
				// 获取最高库存和预警阀值
				Map<String, Object[]> maxStockAndAlarmMap = this
						.getMaxStockAndAlarm(wayid, brandSet);

				// 获取商品分配量
				Map<String, Object[]> brandComDisAmountMap = this
						.getBrandComDisAmount(brandStocks, maxStockAndAlarmMap,
								brandComDisScaleMap, brandPackSizeMap, wayvo);
				// 订单分配检查
				brandComDisAmountMap = this.orderDisCheck(brandComDisAmountMap,
						wayid);
				// 删除【累计分配量】和【订单汇总】逻辑
				// 创建订单 和 累计分配量
				this.createOrderAndAccuAmount(brandComDisAmountMap, wayid,
						waVO, brandStocks);
			} catch (Exception ex) {
				LoggerUtils.error(ex, log);
				continue;
			}
		}
		if (comorderListForAllOrders.size() > 0) {
			// 根据comorderListForAllOrders组装出“商品种类1:数量1；商品种类2:数量2；……”
			String comcategoryAndAmountStr = this
					.joinComcategoryAndAmountStr(comorderListForAllOrders);
			Boolean isBatch = (orderidstr.indexOf("/") != (orderidstr.length() - 1));// 是否批量
			// 去掉orderidstr最后面一个"/"
			if (orderidstr.length() > 1)
				orderidstr = orderidstr.substring(0, orderidstr.length() - 1);
			// 如果生成订单比较多,只显示前3条
			String[] content = StringUtils.split(orderidstr, "/");
			if (content.length > 3) {
				orderidstr = content[0] + "/" + content[1] + "/" + content[2];
			}
			// 订单创建短信及待办通知
			this.doCheckForSmsAndTodo(isBatch, comcategoryAndAmountStr,
					orderidstr);
		}
		// 删除【累计分配量】和【订单汇总】逻辑
		// return orderCollection;
	}

	/**
	 * 5)订单分配 -> (a) 获取渠道信息
	 * 
	 * @param wayid
	 * @return
	 * @throws Exception
	 * @throws Exception
	 */
	public WayVO getWayinfo(String wayid) throws Exception {

		// 根据合作商编码查询渠道表(CH_PW_WAY)，如果无数据则输出“合作商[XX]无渠道资料”并返回处理下一条数据；
		// 如果渠道状态无效（即WAYSTATE<>1）则输出日志“合作商[XX]渠道状态无效”，返回处理下一条记录；否则继续。
		// 记录分公司、微区域、星级信息供后续使用。
		Way bo = (Way) BOFactory.build(WayBO.class, user);
		WayVO vo = bo.doFindByPk(wayid);
		if (vo == null) {
			throw new Exception("合作商[" + wayid + "]无渠道资料");
		}
		if (vo.getWaystate() != 1) {
			throw new Exception("合作商[" + wayid + "]渠道状态无效");
		}

		return vo;
	}

	/**
	 * 5)订单分配 -> (b) 获取库存量
	 * 
	 * @param wayid
	 * @param brandSet
	 * @return
	 * @throws Exception
	 */
	private Map<String, Long> getBrandStocks(String wayid, Set<String> brandSet)
			throws Exception {
		Realtimeamt rtBO = (Realtimeamt) BOFactory.build(RealtimeamtBO.class,
				user);
		RealtimeamtDBParam params = new RealtimeamtDBParam();
		params.set_pagesize("0");
		params.setDataOnly(true);
		params.set_se_wayid(wayid);
		DataPackage dp = rtBO.doQuery(params);
		List list = dp.getDatas();
		Map<String, Long> brandStockMap = new HashMap<String, Long>();
		for (Iterator<String> it = brandSet.iterator(); it.hasNext();) {
			brandStockMap.put(it.next(), 0L); // 默认库存量为零
		}
		for (int j = 0; j < list.size(); j++) {
			RealtimeamtVO rtVO = (RealtimeamtVO) list.get(j);
			String brand = rtVO.getBrand();
			Long stock = rtVO.getNowstock();
			if (brandStockMap.containsKey(brand) && stock != null)
				brandStockMap.put(brand, stock);
		}
		return brandStockMap;
	}

	/**
	 * 5) 订单分配 (c) 获取最高库存和预警阀值
	 * 
	 * @param wayid
	 * @return
	 * @throws Exception
	 */
	private Map<String, Object[]> getMaxStockAndAlarm(String wayid,
			Set<String> brandSet) throws Exception {

		try {
			Stockalarm saBO = (Stockalarm) BOFactory.build(StockalarmBO.class,
					user);
			StockalarmDBParam params = new StockalarmDBParam();
			params.set_pagesize("0");
			params.setDataOnly(true);
			params.set_se_wayid(wayid);
			DataPackage dp = saBO.doQuery(params);
			List list = dp.getDatas();
			Map<String, Object[]> maxStockAndAlarmMapTemp1 = new HashMap<String, Object[]>();// 网点库存预警设置表中的对应关系map
			Map<String, Object[]> maxStockAndAlarmMapTemp2 = new HashMap<String, Object[]>();// 订购量上限设置表中的对应关系map
			Map<String, Object[]> maxStockAndAlarmMap = new HashMap<String, Object[]>();// 最终要返回的对应关系map
			if (list.size() > 0) {
				for (int j = 0; j < list.size(); j++) {
					StockalarmVO saVO = (StockalarmVO) list.get(j);
					Object[] objArr = { saVO.getMaxstock(),
							saVO.getAlarmvalue() };
					maxStockAndAlarmMapTemp1.put(saVO.getBrand(), objArr);
				}
			}
			// 然后根据地市标识、分公司（即县公司标识COUNTYID）、星级、约束模式（默认取预警库存模式）
			// 查询订购量上限设置表（FX_RU_ORDERUPLIMIT），获取品牌、最高库存、预警阀值。
			Way wayBO = (Way) BOFactory.build(WayBO.class, user);
			WayVO wayVO = wayBO.doFindByPk(wayid);
			if (wayVO == null)
				throw new Exception("合作商[" + wayid + "]不存在,请核实");
			String cityid = wayVO.getCityid();
			Long starlevel = wayVO.getStarlevel();
			String countyid = wayVO.getCountyid();
			if (StringUtils.isEmpty(cityid))
				throw new Exception("合作商[" + wayid + "]的地市标识 (cityid) 为空");
			if (StringUtils.isEmpty(countyid))
				throw new Exception("合作商[" + wayid + "]的分公司 (countyid) 为空");
			if (starlevel == null)
				throw new Exception("合作商[" + wayid + "]的星级 (starlevel) 为空");

			Orderuplimit olBO = (Orderuplimit) BOFactory.build(
					OrderuplimitBO.class, user);
			OrderuplimitDBParam olParams = new OrderuplimitDBParam();
			olParams.set_se_cityid(cityid);
			olParams.set_se_countyid(countyid);
			olParams.set_ne_starlevel(starlevel + "");
			olParams.set_se_limitmode("STOCKALARM");
			olParams.setDataOnly(true);
			olParams.set_pagesize("0");
			DataPackage olDp = olBO.doQuery(olParams);
			List olList = olDp.getDatas();
			if (olList.size() > 0) {
				for (int i = 0; i < olList.size(); i++) {
					OrderuplimitVO olVO = (OrderuplimitVO) olList.get(i);
					Object[] objArr = { olVO.getMaxstock(),
							olVO.getAlarmvalue() };
					maxStockAndAlarmMapTemp2.put(olVO.getBrand(), objArr);
				}
			}

			Sysparam sysparamBO = (SysparamBO) BOFactory.build(
					SysparamBO.class, user);
			SysparamVO sysparamVO = new SysparamVO();
			sysparamVO.setParamtype("pboss_fx");
			sysparamVO.setSystemid(new Long(73));
			sysparamVO = sysparamBO.doFindByPk(sysparamVO);

			// 以品牌集合为基础，将最高库存和预警阀值进行填充，存在相同品牌时以网点库存预警数据为准
			for (Iterator<String> it = brandSet.iterator(); it.hasNext();) {
				String brandtemp = it.next();

				// 针对套卡品牌为多个的情况的处理
				if (sysparamVO.getParamvalue().toString().equals("1")) {
					// if (maxStockAndAlarmMapTemp1.containsKey(brandtemp)) {
					Object[] obj = checkExit(maxStockAndAlarmMapTemp1,
							brandtemp);
					Object[] obj2 = checkExit(maxStockAndAlarmMapTemp2,
							brandtemp);
					if (null != obj) {
						maxStockAndAlarmMap.put(brandtemp, obj);
					} else {
						if (null != obj2) {
							maxStockAndAlarmMap.put(brandtemp, obj2);
						}
					}

				} else {
					if (maxStockAndAlarmMapTemp1.containsKey(brandtemp)) {
						maxStockAndAlarmMap.put(brandtemp,
								maxStockAndAlarmMapTemp1.get(brandtemp));
					} else {
						if (maxStockAndAlarmMapTemp2.containsKey(brandtemp)) {
							maxStockAndAlarmMap.put(brandtemp,
									maxStockAndAlarmMapTemp2.get(brandtemp));
						}
					}
				}
			}

			if (maxStockAndAlarmMap.size() == 0)
				throw new Exception("合作商编码[" + wayid + "]无预警库存数据");

			return maxStockAndAlarmMap;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * 5) 订单分配 (d) 获取商品分配量
	 * 
	 * @param brandStocks
	 *            品牌库存量集合
	 * @param maxStockAndAlarm
	 *            最高库存和预警阀值
	 * @param brandComDisScale
	 *            商品分配比例设置
	 * @param brandPackSize
	 *            品牌包大小
	 * @param wayid
	 * @return
	 * @throws Exception
	 */
	private Map<String, Object[]> getBrandComDisAmount(
			Map<String, Long> brandStocks,
			Map<String, Object[]> maxStockAndAlarm, List brandComDisScale1,
			Map<String, Integer> brandPackSize, WayVO way) throws Exception {
		String wayid = way.getWayid();
		Map<String, Object[]> brandComDisAmountMap = new HashMap<String, Object[]>();
		Map<String, Map<String, Double>> brandComDisScale = null;
		for (Iterator<String> it = brandStocks.keySet().iterator(); it
				.hasNext();) {
			String brand = it.next();
			// 最大库存量和预警阀值
			Object[] stockAndAlarm = maxStockAndAlarm.get(brand);
			if (stockAndAlarm == null)
				continue;
			// 库存量
			Long stock = brandStocks.get(brand);
			String alarmValue = (String) stockAndAlarm[1];
			String[] arr1 = StringUtils.split(alarmValue, ";");
			// 预警级别和阀值Map
			Map<String, Long> classAndAlarmValue = new TreeMap<String, Long>();
			// 阀值list
			for (String temp : arr1) {
				String[] arr2 = StringUtils.splitByWholeSeparator(temp, ":");
				classAndAlarmValue.put(arr2[0], Long.parseLong(arr2[1]));
			}
			Collection<Long> values = classAndAlarmValue.values();
			Long closelyAlarmValue = this.getCloselyAlarmValue(stock, values);
			if (closelyAlarmValue == null)
				// 当库存量大于所有的预警阀值时不处理该品牌
				continue;
			// 对应预警阀值的预警级别
			String alarmClass = "";
			for (Iterator<String> caIt = classAndAlarmValue.keySet().iterator(); caIt
					.hasNext();) {
				String aClass = caIt.next();
				Long aValue = classAndAlarmValue.get(aClass);
				if (closelyAlarmValue == aValue) {
					alarmClass = aClass;
					break;
				}
			}

			log.info("合作商: " + wayid + "的品牌  [" + brand + "] 最高库存 = "
					+ stockAndAlarm[0] + "; 当前库存 = " + stock);
			// 品牌分配量=最高库存-当前库存
			Long brandDisAmount = (Long) stockAndAlarm[0] - stock;
			if (brandDisAmount <= 0) {
				log.info("合作商: " + wayid + "的品牌  [" + brand + "] 最高库存 "
						+ stockAndAlarm[0] + "小于或等于当前库存 " + stock
						+ ",因此品牌分配量小于或等于0,不需要为该合作商品牌进行分配; ");
				continue;
			}

			// 得到可用的商品比例结果集

			brandComDisScale = this.getSalecale(brandComDisScale1, brand, way);
			if (brandComDisScale == null || brandComDisScale.get(brand) == null) {
				continue;
			}

			if (!brandComDisScale.containsKey(brand)) {
				continue;
			} else {

				if (!brandPackSize.containsKey(brand)) {
					log.info("合作商: " + wayid + " 的品牌[" + brand
							+ "]的\"品牌包大小\"没有设置");
					continue;
				}
				// 总包数=品牌分配量/品牌包大小，向上取整数包(CR_ZQ20100702_1075333)
				double totalPackDouble = Math.ceil((double) brandDisAmount
						/ (double) brandPackSize.get(brand));
				Long totalPack = new Double(totalPackDouble).longValue();
				// 商品种类及其分配比例

				TreeMap<String, Double> comDisScale = (TreeMap<String, Double>) brandComDisScale
						.get(brand);

				// 商品种类及其分配量
				Map<String, Long> comCateDisAmount = new HashMap<String, Long>();
				// 各商品种类包数之和
				Long comCatePackSum = 0L;

				Collection scaleCol = comDisScale.values();
				Object[] scaleArray = scaleCol.toArray();
				Arrays.sort(scaleArray);

				// 最高的分配比例
				Double maxScale = (Double) scaleArray[scaleArray.length - 1];
				if (maxScale == 0.0) {
					// 如果所有商品种类的分配比例都等于0，则将该品牌舍去
					continue;
				}
				// 最高分配比例对应的商品种类
				String comCateforMaxScale = "";

				for (Iterator<String> iterator = comDisScale.keySet()
						.iterator(); iterator.hasNext();) {
					String comCategory = iterator.next();
					Double scale = (Double) comDisScale.get(comCategory);
					if (scale == maxScale)
						comCateforMaxScale = comCategory;
					// 商品种类包数 = 总包数*分配比例 ，取整数位
					Long packAmount = new Double(totalPack * scale).longValue();
					// 分配量=商品种类包数*品牌包大小
					Long disAmount = packAmount * brandPackSize.get(brand);
					comCatePackSum += packAmount;

					comCateDisAmount.put(comCategory, disAmount);
				}
				// 剩余包数=总包数-各商品种类包数，取整数位
				Long remainPackAmount = totalPack - comCatePackSum;

				Long oldDisAmount = comCateDisAmount.get(comCateforMaxScale);
				// 将剩余包数添加到比例最高的商品种类 (从而将剩余包数对应的分配量添加到比例最高的商品种类)
				comCateDisAmount.put(comCateforMaxScale, oldDisAmount
						+ remainPackAmount * brandPackSize.get(brand));

				// 舍弃分配量为零的商品种类
				for (Iterator<String> iter = comCateDisAmount.keySet()
						.iterator(); iter.hasNext();) {
					String comCategory = iter.next();
					Long disAmount = comCateDisAmount.get(comCategory);
					if (disAmount == 0)
						iter.remove();
				}
				Object[] classAndDisAmount = { alarmClass, comCateDisAmount };

				brandComDisAmountMap.put(brand, classAndDisAmount);
			}
		}
		return brandComDisAmountMap;
	}

	/**
	 * 5) 订单分配 (e) 订单分配检查
	 * 
	 * @param brandComDisAmount
	 *            商品种类分配量集合
	 * @return 返回通过检查的商品种类分配量集合
	 * @throws Exception
	 */
	private Map<String, Object[]> orderDisCheck(
			Map<String, Object[]> brandComDisAmount, String wayid)
			throws Exception {
		for (Iterator<String> it = brandComDisAmount.keySet().iterator(); it
				.hasNext();) {
			String brand = it.next();
			Object[] classAndDisAmount = brandComDisAmount.get(brand);
			// 预警级别
			String alarmClass = (String) classAndDisAmount[0];
			// 商品种类及其分配量
			Map<String, Long> comCateDisAmount = (Map<String, Long>) classAndDisAmount[1];
			if (comCateDisAmount.size() <= 0) {
				// 如果该品牌各商品种类的分配量之和为零则将之从集合中删除，返回处理下一品牌数据
				it.remove();
				continue;
			}

			Set<String> comCategory = comCateDisAmount.keySet();
			OrderVO orderVO = this.getLatelyOrdersInComCate(comCategory, wayid);
			if (orderVO == null)
				continue;
			if (!checkIsPass(alarmClass, orderVO)) { // 如果检查不通过，将该品牌从分配集合中去除
				it.remove();
			}
		}
		return brandComDisAmount;
	}

	/**
	 * 5) 订单分配 ->(f) 创建订单 (f) 累计分配量
	 * 
	 * @param brandComDisAmount
	 * @param wayid
	 * @param orderCollection
	 * @param comorderListForAllOrders
	 * @return 累计后的预警订单汇总 Map<分公司,预警订单汇总信息>
	 * @throws Exception
	 */

	private void createOrderAndAccuAmount(
			Map<String, Object[]> brandComDisAmount, String wayid,
			WayassistantVO waVO, Map<String, Long> brandStocks)
			throws Exception {

		if (brandComDisAmount.size() <= 0)
			return;
		Comorder comorder = (Comorder) BOFactory.build(ComorderBO.class, user,
				BOFactory.PROPAGATION_REQUIRES_NEW);
		Way wayBO = (Way) BOFactory.build(WayBO.class, user);
		Order orderBO = (Order) BOFactory.build(OrderBO.class, user);
		Stkalarmstat sasBO = (Stkalarmstat) BOFactory.build(
				StkalarmstatBO.class, user, BOFactory.PROPAGATION_REQUIRES_NEW);
		WayVO wayVO = wayBO.doFindByPk(wayid);
		// 5.2.24.3 修改【创建订单】
		// 逻辑删除订购检查步骤。(CR_ZQ20100702_1075333)

		/*
		 * // 订购资格检查 Wayassistant wayassistant = (Wayassistant) BOFactory.build(
		 * WayassistantBO.class, user); WayassistantVO wayassistantVO =
		 * wayassistant.doFindByPk(wayid); if (null == wayassistantVO) { throw
		 * new SaleException("SALE-103002"); // throw new //
		 * WebSiteException("该合作商订购辅助信息不存在!",RetResult.FAILURE); }
		 */

		wayVO.setPaytype(waVO.getPaytype());
		wayVO.setDelitype(waVO.getDelitype());

		/*
		 * 删除【累计分配量】和【订单汇总】逻辑 BOSS（CR_ZQ_20100908_1167835 PBOSS系统肇庆公司红黄绿分配方案第三期）
		 * 5.2.21 修改【订单自动分配】后台逻辑 // 分公司 String countyid = wayVO.getCountyid(); //
		 * 预警订单汇总信息 AlaordercolVO ocVO = null; if (orderCollection.get(countyid) !=
		 * null) ocVO = orderCollection.get(countyid); else { ocVO = new
		 * AlaordercolVO(); ocVO.setCountyid(countyid);
		 * orderCollection.put(countyid, ocVO); }
		 */

		// 订购资源库区
		String storarea = comorder.doGetStorArea(wayVO);

		for (Iterator<String> it = brandComDisAmount.keySet().iterator(); it
				.hasNext();) {// 按品牌循环
			// 将查到的订购请求列表信息放入订购列表
			String brand = it.next();
			List<ComorderVO> comorderList = new LinkedList<ComorderVO>();
			String orderid = "";
			try {
				orderid = comorder.doGetOrderId();
				Object[] classAndDisAmount = brandComDisAmount.get(brand);
				// 预警级别
				String alarmClass = (String) classAndDisAmount[0];
				// 商品种类及其分配量
				Map<String, Long> comCateDisAmount = (Map<String, Long>) classAndDisAmount[1];
				// 品牌分配量（各商品种类分配量之和）
				Long sumOrderAmount = 0L;
				for (Iterator<String> cdaIt = comCateDisAmount.keySet()
						.iterator(); cdaIt.hasNext();) {// 按商品种类循环
					String comCategory = cdaIt.next();
					Long disAmount = comCateDisAmount.get(comCategory);
					sumOrderAmount = sumOrderAmount + disAmount; // 累计各商品种类分配量之和
					ComorderVO comorderVO = new ComorderVO();
					comorderVO.setComcategory(comCategory);
					comorderVO.setOrderamount(disAmount);
					Double unitprice = comorder.doGetUnitprice(wayid,
							comCategory);
					comorderVO.setUnitprice(unitprice);
					comorderVO.setTotalprice(unitprice * disAmount);
					comorderList.add(comorderVO);
				}

				Set<String> brandSet = null;
				// 删除订购检查步骤。(CR_ZQ20100702_1075333)
				/*
				 * try { //订单检查 brandSet = comorder.comOrderCheck(wayid,
				 * comorderList, storarea); }catch(SaleException e) {
				 * log.info("[订购检查不通过]\t渠道标识: "+wayid+"; 品牌标识: "+brand+":");
				 * log.info(e.getMessage()); continue; }catch(Exception e) {
				 * e.printStackTrace(); continue; }
				 */

				try {
					// 创建订单
					comorder.doBuildOrder(orderid, wayVO, storarea,
							comorderList, brandSet,
							ComorderConstant.ORDERAVE_AUTO, alarmClass);

					StringBuffer comcateInfo = new StringBuffer("");
					for (ComorderVO comoderVO : comorderList) {
						comcateInfo.append(comoderVO.getComcategory()).append(
								":").append(comoderVO.getOrderamount()).append(
								"|");
					}
					log.info("自动分配订单信息: [订单号: " + orderid + "] [合作商编码: "
							+ wayid + "] [分公司: " + wayVO.getCountyid()
							+ "] [星级: " + wayVO.getStarlevel() + "] [预警级别: "
							+ alarmClass + "] [商品种类信息(商品种类:订购数量): ("
							+ comcateInfo + ")");
					// 5.2.24.1 新增【创建预警快照】逻辑 (CR_ZQ20100702_1075333)
					OrderVO orderVO = orderBO.doFindByPk(orderid);
					Date createtime = orderVO.getCreatetime();
					StkalarmstatVO sasVO = new StkalarmstatVO();
					sasVO.setAlarmdate(createtime);
					sasVO.setWayid(wayid);
					sasVO.setBrand(brand);
					sasVO.setAlarmlevel(alarmClass);
					sasVO.setOrderid(orderid);
					sasVO.setCrtstock(brandStocks.get(brand));
					sasBO.doCreate(sasVO);
				} catch (SaleException e) {
					log.info("[创建订单异常]\t渠道标识: " + wayid + "; 品牌标识: " + brand
							+ ":");
					log.info(e.getMessage());
					continue;
				} catch (Exception e) {
					LoggerUtils.error(e, log);
					continue;
				}

				/*
				 * 删除【累计分配量】和【订单汇总】逻辑 BOSS（CR_ZQ_20100908_1167835
				 * PBOSS系统肇庆公司红黄绿分配方案第三期） 5.2.21 修改【订单自动分配】后台逻辑 // (f) 累计分配量 if
				 * ("YELALARM".equalsIgnoreCase(alarmClass)) { // 累计黄色预警订单数 Long
				 * oldYelnum = ocVO.getYelnum(); ocVO.setYelnum(oldYelnum ==
				 * null ? 1L : ++oldYelnum); } else if
				 * ("REDALARM".equalsIgnoreCase(alarmClass)) { // 累计红色预警订单数 Long
				 * oldRednum = ocVO.getRednum(); ocVO.setRednum(oldRednum ==
				 * null ? 1L : ++oldRednum); } if
				 * ("BrandMzone".equalsIgnoreCase(brand)) { // 累计动感地带分配量 Long
				 * oldDgamount = ocVO.getDgamount();
				 * ocVO.setDgamount(oldDgamount == null ? sumOrderAmount :
				 * sumOrderAmount + oldDgamount); } if
				 * ("BrandSzx".equalsIgnoreCase(brand)) { // 累计神州行分配量 Long
				 * oldSzxamount = ocVO.getSzxamount();
				 * ocVO.setSzxamount(oldSzxamount == null ? sumOrderAmount :
				 * sumOrderAmount + oldSzxamount); } if
				 * ("BrandDzk".equalsIgnoreCase(brand)) { // 累计大众卡分配量 Long
				 * oldDzkamount = ocVO.getDzkamount();
				 * ocVO.setDzkamount(oldDzkamount == null ? sumOrderAmount :
				 * sumOrderAmount + oldDzkamount); }
				 */
			} catch (Exception ex) {
				LoggerUtils.error(ex, log);
				continue;
			}
			// 收集所有订单的商品种类与数量对应关系供[订单创建短信及待办通知]使用 add by yedaoe
			comorderListForAllOrders.addAll(comorderList);
			// 收集订单标识以供创建短信及待办通知
			if (StringUtils.isNotBlank(orderid))
				orderidstr += orderid + "/";
		}
		// 删除【累计分配量】和【订单汇总】逻辑
		// return orderCollection;
	}

	/*
	 * 删除【累计分配量】和【订单汇总】逻辑 BOSS（CR_ZQ_20100908_1167835 PBOSS系统肇庆公司红黄绿分配方案第三期）
	 * 5.2.21 修改【订单自动分配】后台逻辑
	 */
	/**
	 * 6) 订单汇总
	 * 
	 * @param orderCollection
	 * @throws Exception
	 */
	// private void orderCollection(Map<String, AlaordercolVO> orderCollection)
	// throws Exception {
	// Alaordercol ocBO = (Alaordercol) BOFactory.build(AlaordercolBO.class,
	// user);
	// for (Iterator<String> it = orderCollection.keySet().iterator(); it
	// .hasNext();) {
	// String countyid = it.next();
	// AlaordercolVO ocVO = orderCollection.get(countyid);
	// ocVO.setColdate(PublicUtils.formatUtilDate(new Date(), "yyyyMMdd"));
	// ocBO.doCreate(ocVO);
	// }
	// }
	private Long getCloselyAlarmValue(Long stock, Collection<Long> alarms) {
		Object[] alarmArray = alarms.toArray();
		Arrays.sort(alarmArray); // 对阀值按由小到大排序
		for (int k = 0; k < alarmArray.length; k++) {
			if (stock <= (Long) alarmArray[k])
				return (Long) alarmArray[k];
		}
		return null;
	}

	/**
	 * 查询指定商品种类最近的订购信息
	 * 
	 * @param comCategory
	 * @return
	 * @throws Exception
	 */
	private OrderVO getLatelyOrdersInComCate(Set<String> comCategory,
			String wayid) throws Exception {
		OrderAutoDistributeDAO dao = (OrderAutoDistributeDAO) DAOFactory.build(
				OrderAutoDistributeDAO.class, user);
		return dao.getLatelyOrdersInComCate(comCategory, wayid);
	}

	private boolean checkIsPass(String alarmClass, OrderVO orderVO)
			throws Exception {

		// 订购途径
		String orderRave = orderVO.getOrderave();
		// 预警级别
		String alarmLevel = orderVO.getAlarmlevel();
		// 是否确认
		Integer confirmflag = orderVO.getConfirmflag();
		// 订单状态
		String orderstate = orderVO.getOrderstate();
		// 订单创建时间
		Date createtime = orderVO.getCreatetime();

		if ("AUTO".equalsIgnoreCase(orderRave)) {
			// 自动分配
			if (alarmClass.equals(alarmLevel)) { // 预警级别相同
				if (confirmflag != null && confirmflag == 1) { // 是否确认为"是"
					if ("FINISHED".equalsIgnoreCase(orderstate)
							|| "CANCEL".equalsIgnoreCase(orderstate)) {
						// 已完成或作废 -> 通过
						return true;
					} else {
						// 其他状态 -> 不通过
						return false;
					}
				} else {
					// 是否确认为"否" 或空

					// 订单创建时间不在当月内,通过
					if (!TimeUtils.inSameMonth(createtime)) {
						return true;
					} else {
						// 订单创建时间不在当月内,不通过
						return false;
					}
				}
			} else { // 预警级别不相同
				if (confirmflag != null && confirmflag == 1) { // 是否确认为"是"
					if ("FINISHED".equalsIgnoreCase(orderstate)
							|| "CANCEL".equalsIgnoreCase(orderstate)) {
						// 已完成或作废 -> 通过
						return true;
					} else {
						// 其他状态 -> 不通过
						return false;
					}
				} else {
					// 是否确认为"否" 或 空 -> 通过
					return true;
				}
			}
		} else {
			// 非“自动分配”
			if ("FINISHED".equalsIgnoreCase(orderstate)
					|| "CANCEL".equalsIgnoreCase(orderstate)) {
				// 已完成或作废 -> 通过
				return true;
			} else {
				// 其他状态 -> 不通过
				return false;
			}
		}
	}

	// 对是否发送短信及待办通知进行检查并发送短信,创建待办
	private void doCheckForSmsAndTodo(Boolean isBatch,
			String comcategoryAndAmountStr, String orderidstr) throws Exception {
		// 第一步:检查[是否启用订单创建通知]
		Sysparam spBo = (SysparamBO) BOFactory.build(SysparamBO.class, user);
		String paramValue1 = spBo.doFindByID(50L, "pboss_fx");
		if (StringUtils.isBlank(paramValue1)
				|| ((!"0".equals(paramValue1)) && (!"1".equals(paramValue1))
						&& (!"2".equals(paramValue1)) && (!"3"
						.equals(paramValue1)))) {
			log.info("[是否启用订单创建通知]参数值设置不正确,无法获取该参数值,或者参数值不为0,1,2,3");
			return;
		}
		if ("0".equals(paramValue1)) {
			return;
		}
		// 第二步:检查[订单创建通知角色]
		String paramValue2 = spBo.doFindByID(51L, "pboss_fx");
		if (StringUtils.isBlank(paramValue2)) {
			log.info("[订单创建通知角色]参数值设置不正确,无法获取该参数值,或者参数值为空");
			return;
		}
		if ("-1".equals(paramValue2)) {
			return;
		}
		// 第三步:获取角色所对应的工号及联系电话
		Operrole operrole = (Operrole) BOFactory.build(OperroleBO.class, user);
		Operator operator = (Operator) BOFactory.build(OperatorBO.class, user);
		OperroleDBParam opparam = new OperroleDBParam();
		opparam.set_se_roleid(paramValue2);
		opparam.set_ne_status("1");
		DataPackage operroledp = operrole.doQuery(opparam);
		if (null == operroledp || operroledp.getDatas().size() == 0) {
			log.info("[订单创建通知角色]参数值(即角色编码)在角色工号表中没有相关联的工号");
			return;
		}
		List<OperroleVO> orlist = operroledp.getDatas();

		List<OperatorVO> oplist = new ArrayList<OperatorVO>();
		for (OperroleVO operrolevo : orlist) {
			OperatorDBParam oparam = new OperatorDBParam();
			oparam.set_se_operid(operrolevo.getOperid());
			oparam.set_ne_status("1");
			DataPackage operatordp = operator.doQuery(oparam);
			if (operatordp.getDatas().size() > 0) {
				oplist.add((OperatorVO) operatordp.getDatas().get(0));
			}
		}
		// 第四步:检查[分销后台短信通知时间]
		String paramValue4 = spBo.doFindByID(58L, "pboss_fx");// 短信发送通知时间
		if (StringUtils.isBlank(paramValue4)) {
			log.info("[分销后台短信通知时间]参数值设置不正确,无法获取该参数值,或者参数值为空");
			return;
		}
		// 第五步:根据“是否启用订单创建通知”进行以下通知组合
		// 默认为0；是否对市公司资源管理员通知；0表示不通知，1表示以短信通知，2表示以待办通知，3表示以短信和待办通知
		Smstmpl smstmplBO = (Smstmpl) BOFactory.build(SmstmplBO.class, user);
		SmstmplVO smstmplBatchVO = smstmplBO
				.doFindByPk("FX_ORDER_CADVICE_BATCH");
		SmstmplVO smstmplSingleVO = smstmplBO
				.doFindByPk("FX_ORDER_CADVICE_SINGLE");
		Waitreq waitreqbo = (Waitreq) BOFactory.build(WaitreqBO.class, user);
		if ("1".equals(paramValue1)) {
			// 获取短信发送号码
			String sendno = "";
			Sysparam sysparam = (Sysparam) BOFactory.build(SysparamBO.class,
					user);
			SysparamDBParam param = new SysparamDBParam();
			param.set_se_paramtype("pboss");
			param.set_ne_systemid("7");
			DataPackage dp = sysparam.doQuery(param);
			if (dp.getRowCount() > 0)
				sendno = ((SysparamVO) dp.getDatas().get(0)).getParamvalue();
			// 获取短信发送时间
			String senttimestr = null;
			param.set_se_paramtype("pboss_fx");
			param.set_ne_systemid("58");
			DataPackage dp2 = sysparam.doQuery(param);
			if (dp2.getRowCount() > 0)
				senttimestr = ((SysparamVO) dp2.getDatas().get(0))
						.getParamvalue();
			String date1 = PublicUtils.formatUtilDate(new Date(), "yyyy-MM-dd");
			String date2 = date1 + " " + senttimestr;
			Date senttime = PublicUtils
					.UtilStrToDate(date2, "yyyy-MM-dd HH:mm");

			if (isBatch && smstmplBatchVO != null) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("COMCATEGORY:AMOUNT", comcategoryAndAmountStr);
				String content = smstmplBO.doGenSMS("FX_ORDER_CADVICE_BATCH",
						map);
				for (OperatorVO vo : oplist) {
					if (StringUtils.isNotBlank(vo.getContactphone())) {
						// waitreqbo.doInsert(new Short("3"), content,
						// vo.getContactphone());//需改为用加上发送时间参数的方法
						waitreqbo.doInsert3(new Short("3"), content, sendno, vo
								.getContactphone(), senttime);
					}
				}
			} else if (isBatch == false && smstmplSingleVO != null) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("COMCATEGORY:AMOUNT", comcategoryAndAmountStr);
				map.put("ORDERID", orderidstr);
				String content = smstmplBO.doGenSMS("FX_ORDER_CADVICE_SINGLE",
						map);

				for (OperatorVO vo : oplist) {
					if (StringUtils.isNotBlank(vo.getContactphone())) {
						// waitreqbo.doInsert(new Short("3"), content,
						// vo.getContactphone());//需改为用加上发送时间参数的方法
						waitreqbo.doInsert3(new Short("3"), content, sendno, vo
								.getContactphone(), senttime);
					}
				}
			}
		} else if ("2".equals(paramValue1)) {
			String opercodestr = "";// 把角色对应的工号用逗号拼接
			for (OperatorVO vo : oplist) {
				String opercode = vo.getOperid();
				opercodestr = opercodestr + opercode + ",";
			}
			opercodestr = opercodestr.substring(0, opercodestr.length() - 1);// 去掉最后一个逗号
			Pendingtask pendingtaskBO = (Pendingtask) BOFactory.build(
					PendingtaskBO.class, user);
			pendingtaskBO.doCreate("已创建订单" + orderidstr, "", "7", opercodestr,
					new Short("0"), null, new Date(), null);
		} else if ("3".equals(paramValue1)) {
			// 获取短信发送号码
			String sendno = "";
			Sysparam sysparam = (Sysparam) BOFactory.build(SysparamBO.class,
					user);
			SysparamDBParam param = new SysparamDBParam();
			param.set_se_paramtype("pboss");
			param.set_ne_systemid("7");
			DataPackage dp = sysparam.doQuery(param);
			if (dp.getRowCount() > 0)
				sendno = ((SysparamVO) dp.getDatas().get(0)).getParamvalue();
			// 获取短信发送时间
			String senttimestr = null;
			param.set_se_paramtype("pboss_fx");
			param.set_ne_systemid("58");
			DataPackage dp2 = sysparam.doQuery(param);
			if (dp2.getRowCount() > 0)
				senttimestr = ((SysparamVO) dp2.getDatas().get(0))
						.getParamvalue();
			String date1 = PublicUtils.formatUtilDate(new Date(), "yyyy-MM-dd");
			String date2 = date1 + " " + senttimestr;
			Date senttime = PublicUtils
					.UtilStrToDate(date2, "yyyy-MM-dd HH:mm");

			// 发短信
			if (isBatch && smstmplBatchVO != null) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("COMCATEGORY:AMOUNT", comcategoryAndAmountStr);
				String content = smstmplBO.doGenSMS("FX_ORDER_CADVICE_BATCH",
						map);
				for (OperatorVO vo : oplist) {
					if (StringUtils.isNotBlank(vo.getContactphone())) {
						// waitreqbo.doInsert(new Short("3"), content,
						// vo.getContactphone());//需改为用加上发送时间参数的方法
						waitreqbo.doInsert3(new Short("3"), content, sendno, vo
								.getContactphone(), senttime);
					}
				}
			} else if (isBatch == false && smstmplSingleVO != null) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("COMCATEGORY:AMOUNT", comcategoryAndAmountStr);
				map.put("ORDERID", orderidstr);
				String content = smstmplBO.doGenSMS("FX_ORDER_CADVICE_SINGLE",
						map);
				for (OperatorVO vo : oplist) {
					if (StringUtils.isNotBlank(vo.getContactphone())) {
						// waitreqbo.doInsert(new Short("3"), content,
						// vo.getContactphone());//需改为用加上发送时间参数的方法
						waitreqbo.doInsert3(new Short("3"), content, sendno, vo
								.getContactphone(), senttime);
					}
				}
			}
			// 写待办
			String opercodestr = "";// 把角色对应的工号用逗号拼接
			for (OperatorVO vo : oplist) {
				String opercode = vo.getOperid();
				opercodestr = opercodestr + opercode + ",";
			}
			opercodestr = opercodestr.substring(0, opercodestr.length() - 1);// 去掉最后一个逗号
			Pendingtask pendingtaskBO = (Pendingtask) BOFactory.build(
					PendingtaskBO.class, user);
			pendingtaskBO.doCreate("已创建订单" + orderidstr, "", "7", opercodestr,
					new Short("0"), null, new Date(), null);
		}
	}

	// 根据comorderListForAllOrders组装出“商品种类1:数量1；商品种类2:数量2；……”
	private String joinComcategoryAndAmountStr(
			List<ComorderVO> comorderListForAllOrders) {
		String cmcategoryAndAmountStr = "";
		Map<String, Long> comcategoryMap = new HashMap<String, Long>();
		// 将相同的商品种类的订单合并
		for (ComorderVO vo : comorderListForAllOrders) {
			String comcategorytemp = vo.getComcategory();
			if (!comcategoryMap.containsKey(comcategorytemp)) {
				comcategoryMap.put(comcategorytemp,
						vo.getOrderamount() == null ? 0 : vo.getOrderamount());
			} else {
				Long orderamounttemp = comcategoryMap.get(comcategorytemp);
				comcategoryMap.put(comcategorytemp,
						(vo.getOrderamount() == null ? 0 : vo.getOrderamount())
								+ orderamounttemp);
			}
		}
		// 组装成所需格式
		for (Iterator it = comcategoryMap.keySet().iterator(); it.hasNext();) {
			String comcategory = (String) it.next();
			cmcategoryAndAmountStr += Code2NameUtils.code2Name(
					"$IM_FXCOMCATEGORY", comcategory, user.getCityid())
					+ ":" + comcategoryMap.get(comcategory) + ";";
			// cmcategoryAndAmountStr += comcategory+ ":" +
			// comcategoryMap.get(comcategory) + ";";
		}
		// 去掉最后一个分号
		if (cmcategoryAndAmountStr.length() > 1)
			cmcategoryAndAmountStr = cmcategoryAndAmountStr.substring(0,
					cmcategoryAndAmountStr.length() - 1);
		return cmcategoryAndAmountStr;
	}

	// 根据分公司、微区域、星级等于合作商星级（STARLEVEL）或所有星级（-1）、品牌查询商品分配比例集合，
	// 如果无数据则输出“合作商[XX] 品牌[YY] 商品分配比例设置无数据”并返回处理下一品牌数据；
	// 如果同时存在合作商星级和所有星级（-1）的数据，则以合作商星级数据为准；保存各商品种类及其分配比例数据。

	public Map<String, Map<String, Double>> getSalecale(List brandComDisScale1,
			String brand, WayVO way) throws Exception {

		Map<String, Map<String, Double>> brandComDisScale = new HashMap<String, Map<String, Double>>();
		Map<String, Double> comDisScaleMap = new TreeMap<String, Double>();

		List<ComdisscaleVO> AfList = new ArrayList<ComdisscaleVO>();
		List<ComdisscaleVO> AfList0 = new ArrayList<ComdisscaleVO>();
		List<ComdisscaleVO> AfList2 = new ArrayList<ComdisscaleVO>();
		// 根据分公司、微区域、星级等于合作商星级（STARLEVEL）或所有星级（-1）、品牌查询商品分配比例集合，
		for (int j = 0; j < brandComDisScale1.size(); j++) {
			ComdisscaleVO comdisscalevo = (ComdisscaleVO) brandComDisScale1
					.get(j);
			if (comdisscalevo.getCountyid() != null
					&& comdisscalevo.getCountyid().equals(way.getCountyid())
					&& comdisscalevo.getMareacode() != null
					&& comdisscalevo.getMareacode().equals(way.getMareacode())
					&& comdisscalevo.getStarlevel() != null
					&& comdisscalevo.getBrand().equals(brand)) {

				if (comdisscalevo.getStarlevel() == Short.parseShort(way
						.getStarlevel().toString())
						|| comdisscalevo.getStarlevel() == Short
								.parseShort("-1")) {
					AfList.add(comdisscalevo);
				}
			}
		}
		if (AfList == null || AfList.size() == 0) {
			throw new Exception("合作商[" + way.getWayid() + "] 品牌[" + brand
					+ "] 商品分配比例设置无数据");
		}

		for (int i = 0; i < AfList.size(); i++) {
			ComdisscaleVO cv = AfList.get(i);
			if (cv.getStarlevel() < 0) {
				AfList0.add(cv);
			} else {
				AfList2.add(cv);
			}
		}

		if (AfList2.size() == 0 && AfList0 != null) {
			// 取所有星级
			for (int i = 0; i < AfList0.size(); i++) {
				ComdisscaleVO vo = AfList0.get(i);
				if (vo.getBrand() != null && vo.getBrand().equals(brand)) {
					comDisScaleMap.put(vo.getComcategory(), vo.getDisscale());
				}
			}
			brandComDisScale.put(brand, comDisScaleMap);
		} else {
			// 取合作商星级
			for (int i = 0; i < AfList2.size(); i++) {
				ComdisscaleVO vo = AfList2.get(i);
				if (vo.getBrand() != null && vo.getBrand().equals(brand)) {
					comDisScaleMap.put(vo.getComcategory(), vo.getDisscale());
				}
			}
			brandComDisScale.put(brand, comDisScaleMap);
		}
		return brandComDisScale;

	}

	public static void main(String[] args) {
		// List<ComorderVO> comorderListForAllOrders = new
		// LinkedList<ComorderVO>();
		// ComorderVO vo1 = new ComorderVO();
		// ComorderVO vo2 = new ComorderVO();
		// ComorderVO vo3 = new ComorderVO();
		// vo1.setComcategory("100DZ");
		// vo1.setOrderamount(20L);
		// vo2.setComcategory("55SZ");
		// vo2.setOrderamount(30L);
		// vo3.setComcategory("100DZ");
		// vo3.setOrderamount(40L);
		// comorderListForAllOrders.add(vo1);
		// comorderListForAllOrders.add(vo2);
		// comorderListForAllOrders.add(vo3);
		OrderAutoDistributeBO bo = new OrderAutoDistributeBO();
		// String result = bo
		// .joinComcategoryAndAmountStr(comorderListForAllOrders);
		// System.out.print(result);
		Map<String, Object[]> maxStockAndAlarmMapTemp1 = new HashMap<String, Object[]>();// 网点库存预警设置表中的对应关系map
		Object aa [] = {1000,123};
		Object bb [] = {1200,123};
		Object cc [] = {478,123};
		maxStockAndAlarmMapTemp1.put("aaa,bbb,ccc",aa);
		maxStockAndAlarmMapTemp1.put("ccc,eee,fff", bb);
		maxStockAndAlarmMapTemp1.put("gggg", cc);

		System.out.println(bo.checkExit(maxStockAndAlarmMapTemp1, "ccc")[0]);

	}

	// 检查品牌集合中是否存在 某特定品牌
	public Object[] checkExit(Map<String, Object[]> maxStockAndAlarmMapTemp,
			String brand) {
		Set<String> keyset = maxStockAndAlarmMapTemp.keySet();
		
		if(keyset.contains(brand)){
			return maxStockAndAlarmMapTemp.get(brand);			
		}			
		
		Object[] bo = null;
		for (Iterator<String> it = keyset.iterator(); it.hasNext();) {
			String str = it.next();
			if (str.contains(",")) {
				String[] strarr = str.split(",");
				for (int i = 0; i < strarr.length; i++) {
					if (strarr[i].equals(brand)) {
						if(bo == null){
							bo = maxStockAndAlarmMapTemp.get(str);							
						}else{
							if(Long.parseLong(maxStockAndAlarmMapTemp.get(str)[0].toString())>Long.parseLong(bo[0].toString())){
								bo = maxStockAndAlarmMapTemp.get(str);
							}
						}
					}
				}
			}
		}
		return bo;
	}

}
