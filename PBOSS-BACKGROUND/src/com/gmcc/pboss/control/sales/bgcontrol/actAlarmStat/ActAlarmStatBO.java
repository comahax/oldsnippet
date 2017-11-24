package com.gmcc.pboss.control.sales.bgcontrol.actAlarmStat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.gmcc.pboss.business.base.dictitem.DictitemDBParam;
import com.gmcc.pboss.business.base.dictitem.DictitemVO;
import com.gmcc.pboss.business.resource.actalarmstat.ActalarmstatVO;
import com.gmcc.pboss.business.sales.bgbusiness.PartnerSMPBrandVO;
import com.gmcc.pboss.business.sales.wayassistant.WayassistantDBParam;
import com.gmcc.pboss.business.sales.wayassistant.WayassistantVO;
import com.gmcc.pboss.control.base.dictitem.Dictitem;
import com.gmcc.pboss.control.base.dictitem.DictitemBO;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.resource.actalarmstat.Actalarmstat;
import com.gmcc.pboss.control.resource.actalarmstat.ActalarmstatBO;
import com.gmcc.pboss.control.sales.partnerres.Partnerres;
import com.gmcc.pboss.control.sales.partnerres.PartnerresBO;
import com.gmcc.pboss.control.sales.wayassistant.Wayassistant;
import com.gmcc.pboss.control.sales.wayassistant.WayassistantBO;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.exception.BusinessException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class ActAlarmStatBO extends AbstractControlBean implements ActAlarmStat {

	private static Logger log = Logger.getLogger(ActAlarmStatBO.class);

	public void doProcess() throws Exception {
		
		log.info("====================================ActAlarmStat Begin====================================");
		String[] statTypes = this.getSysParams();
		// 获取网点和品牌基准数据
		Map<PartnerSMPBrandVO, Long> wayBrandBaseData = this
				.loadWayBrandBaseData();
		Date now = new Date();
		String yearMonth = new SimpleDateFormat("yyyyMM").format(now);
		ActAlarmStat aasBO = (ActAlarmStatBO)BOFactory.build(ActAlarmStatBO.class, user, BOFactory.PROPAGATION_REQUIRES_NEW);
		
		for (String statType : statTypes) {
			try {
				Date[] monthPeriod = PublicUtils.getMonthPeriod(now, Integer
						.parseInt(statType));
	
				// 获取领货量
				Map<PartnerSMPBrandVO, Long> wayLHAmount = this.statWayLHAmount(
						wayBrandBaseData, monthPeriod[0], monthPeriod[1]);
	
				// 获取激活量
				Map<PartnerSMPBrandVO, Long> wayActiveAmount = this
						.statWayActiveAmount(wayBrandBaseData, monthPeriod[0],
								monthPeriod[1]);
	
				// 计算激活率
				Map<PartnerSMPBrandVO, Object[]> actAlarmStatMap = this
						.calcActiveRate(wayBrandBaseData, wayLHAmount,
								wayActiveAmount);
				aasBO.doInsertActAlarmStat(actAlarmStatMap, statType, yearMonth);
				
			}catch(Exception ex) {
				LoggerUtils.error(ex, log);
			}
			
		}
		log.info("====================================ActAlarmStat End====================================");

	}
	
	private String[] getSysParams() throws Exception {
		Sysparam spBo = (SysparamBO) BOFactory.build(SysparamBO.class, user);
		String paramValue = spBo.doFindByID(54L, "pboss_fx");
		if (StringUtils.isEmpty(paramValue)) {
			throw new BusinessException(
					"网点激活量统计方式[SystemId=54,ParamType=pboss_fx]的值不能为空");
		}
		String[] statTypes = StringUtils.split(paramValue, ",");
		for (String statType : statTypes) {
			if (!PublicUtils.isInteger(statType)) {
				throw new BusinessException(
						"网点激活量统计方式[SystemId=54,ParamType=pboss_fx]的值不能为空,"
								+ "且必须为半角逗号分隔的数字字符串");
			}
		}
		return statTypes;
	}

	/**
	 * 获取网点和品牌基准数据,并将二者以并集方式组合成一个Map, 其中Key为“网点和品牌VO”, Value默认取0
	 * 
	 * @return
	 * @throws Exception
	 */
	private Map<PartnerSMPBrandVO, Long> loadWayBrandBaseData()
			throws Exception {

		Wayassistant waBO = (Wayassistant) BOFactory.build(
				WayassistantBO.class, user);
		WayassistantDBParam waParams = new WayassistantDBParam();
		waParams.setSelectFieldsString("wayid");
		waParams.set_ne_canorder("1");
		waParams.set_pagesize("0");
		waParams.setDataOnly(true);
		DataPackage waDp = waBO.doQuery(waParams);
		List<WayassistantVO> waList = waDp.getDatas();

		Dictitem diBO = (Dictitem) BOFactory.build(DictitemBO.class, user);
		DictitemDBParam diParams = new DictitemDBParam();
		diParams.set_se_groupid("FX_SMPBRAND");
		diParams.set_sne_dictid("AllBrand");
		diParams.set_pagesize("0");
		diParams.setDataOnly(true);
		DataPackage diDP = diBO.doQuery(diParams);
		List<DictitemVO> diList = diDP.getDatas();

		String[] brands = new String[diList.size()];
		for (int i = 0; i < brands.length; i++) {
			DictitemVO diVO = diList.get(i);
			String brand = diVO.getDictid();
			brands[i] = brand;
		}

		Map<PartnerSMPBrandVO, Long> result = new HashMap<PartnerSMPBrandVO, Long>();
		for (WayassistantVO waVO : waList) {
			String wayid = waVO.getWayid();
			for (int j = 0; j < brands.length; j++) {
				String brand = brands[j];
				PartnerSMPBrandVO psbVO = new PartnerSMPBrandVO(wayid, brand);
				result.put(psbVO, 0L);
			}
		}
		return result;
	}

	/**
	 * 按“合作商编码[WAYID]” 、“品牌[BRAND]”分组统计，取得指定时间内网点“领货量”
	 * 
	 * @param wayBrandBaseData
	 * @param begintime
	 * @param endtime
	 * @return
	 * @throws Exception
	 */
	private Map<PartnerSMPBrandVO, Long> statWayLHAmount(
			Map<PartnerSMPBrandVO, Long> wayBrandBaseData, Date begintime,
			Date endtime) throws Exception {

		Map<PartnerSMPBrandVO, Long> result = new HashMap<PartnerSMPBrandVO, Long>();
		result.putAll(wayBrandBaseData);
		Partnerres resBO = (Partnerres) BOFactory.build(PartnerresBO.class,
				user);
		DataPackage dp = resBO.doStatWayLHAmount(begintime, endtime);
		Map<PartnerSMPBrandVO, Long> wayBrandLHAmount = changeDpToMap(dp);
		// 统计出来的wayid若不在基准数据 wayBrandBaseData中，视为其不属于可订购的网点，不进行统计。
		for (Iterator<PartnerSMPBrandVO> it = wayBrandLHAmount.keySet()
				.iterator(); it.hasNext();) {
			PartnerSMPBrandVO psbVO = it.next();
			if (result.containsKey(psbVO)) {
				result.put(psbVO, wayBrandLHAmount.get(psbVO));
			}
		}
		return result;
	}

	/**
	 * 按“合作商编码[WAYID]” 、“品牌[BRAND]”分组统计 创建时间和激活时间在同一个时间段内的网点“激活量”
	 * 
	 * @param wayBrandBaseData
	 * @param begintime
	 * @param endtime
	 * @return
	 * @throws Exception
	 */
	private Map<PartnerSMPBrandVO, Long> statWayActiveAmount(
			Map<PartnerSMPBrandVO, Long> wayBrandBaseData, Date begintime,
			Date endtime) throws Exception {

		Map<PartnerSMPBrandVO, Long> result = new HashMap<PartnerSMPBrandVO, Long>();
		result.putAll(wayBrandBaseData);
		Partnerres resBO = (Partnerres) BOFactory.build(PartnerresBO.class,
				user);
		DataPackage dp = resBO.doStatActiveAmount_2(begintime, endtime);
		Map<PartnerSMPBrandVO, Long> wayBrandActionAmount = changeDpToMap(dp);
		// 统计出来的wayid若不在基准数据 wayBrandBaseData中，视为其不属于可订购的网点，不进行统计。
		for (Iterator<PartnerSMPBrandVO> it = wayBrandActionAmount.keySet()
				.iterator(); it.hasNext();) {
			PartnerSMPBrandVO psbVO = it.next();
			if (result.containsKey(psbVO)) {
				result.put(psbVO, wayBrandActionAmount.get(psbVO));
			}
		}
		return result;
	}

	/**
	 * 按合作商，品牌计算激活率：激活量/领货量
	 * 
	 * @param wayBrandBaseData
	 * @param lhAmount
	 * @param activeAmount
	 * @return
	 * @throws Exception
	 */
	private Map<PartnerSMPBrandVO, Object[]> calcActiveRate(
			Map<PartnerSMPBrandVO, Long> wayBrandBaseData,
			Map<PartnerSMPBrandVO, Long> lhAmountMap,
			Map<PartnerSMPBrandVO, Long> activeAmountMap) throws Exception {

		Map<PartnerSMPBrandVO, Object[]> actAlarmStatMap = new HashMap<PartnerSMPBrandVO, Object[]>(
				wayBrandBaseData.size());

		for (Iterator<PartnerSMPBrandVO> it = wayBrandBaseData.keySet()
				.iterator(); it.hasNext();) {
			PartnerSMPBrandVO psbVO = it.next();
			Long lhAmount = lhAmountMap.get(psbVO);
			Long activeAmount = activeAmountMap.get(psbVO);
			Double activeRate = 0.0;
			// 若领货量为0(激活量也肯定为0)，则激活率默认取0;否则取实际计算结果
			if (lhAmount > 0) {
				activeRate = (double) activeAmount / (double) lhAmount;
			}
			Object[] value = new Object[] { lhAmount, activeAmount, activeRate };
			actAlarmStatMap.put(psbVO, value);
		}
		return actAlarmStatMap;
	}

	/**
	 * 保存[网点激活量预警统计]信息
	 * 
	 * @param actAlarmStatMap
	 * @param statType
	 *            统计方式
	 * @param yearMonth
	 *            当前统计年月
	 * @throws Exception
	 */
	public void doInsertActAlarmStat(
			Map<PartnerSMPBrandVO, Object[]> actAlarmStatMap, String statType,
			String yearMonth) throws Exception {

		Actalarmstat aasBO = (Actalarmstat) BOFactory.build(
				ActalarmstatBO.class, user);

		for (Iterator<PartnerSMPBrandVO> it = actAlarmStatMap.keySet()
				.iterator(); it.hasNext();) {
			try {
				PartnerSMPBrandVO psbVO = it.next();
				Object[] value = actAlarmStatMap.get(psbVO);
				Long lhAmount = (Long) value[0];
				Long activeAmount = (Long) value[1];
				Double activeRate = (Double) value[2];
				ActalarmstatVO aasVO = new ActalarmstatVO();
				aasVO.setYearmonth(yearMonth);
				aasVO.setWayid(psbVO.getWayid());
				aasVO.setBrand(psbVO.getBrand());
				aasVO.setLhamount(lhAmount);
				aasVO.setJhamount(activeAmount);
				aasVO.setRate(activeRate);
				aasVO.setStattype(statType);
				aasBO.doCreate(aasVO);
			} catch (Exception ex) {
				LoggerUtils.error(ex, log);
			}
		}
	}

	/**
	 * 将DataPackage 中的数据 转换成 Map<PartnerSMPBrandVO, Long>
	 * 
	 * @param dataPackage
	 * @return
	 * @throws Exception
	 */
	private Map<PartnerSMPBrandVO, Long> changeDpToMap(DataPackage dataPackage)
			throws Exception {
		List list = dataPackage.getDatas();
		Map<PartnerSMPBrandVO, Long> result = new HashMap<PartnerSMPBrandVO, Long>();
		for (int i = 0; list != null && i < list.size(); i++) {
			Map data = (Map) list.get(i);
			String wayid = (String) data.get("wayid");
			String brand = (String) data.get("brand");
			Long stkAmount = Long.parseLong((String) data.get("Qty"));
			PartnerSMPBrandVO vo = new PartnerSMPBrandVO(wayid, brand);
			result.put(vo, stkAmount);
		}
		return result;
	}

}
