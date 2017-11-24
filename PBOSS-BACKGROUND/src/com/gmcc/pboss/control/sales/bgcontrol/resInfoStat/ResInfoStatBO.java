package com.gmcc.pboss.control.sales.bgcontrol.resInfoStat;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import com.gmcc.pboss.business.base.dictitem.DictitemDBParam;
import com.gmcc.pboss.business.base.dictitem.DictitemVO;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.resource.resinfostat.ResinfostatVO;
import com.gmcc.pboss.business.sales.bgbusiness.PartnerSMPBrandVO;
import com.gmcc.pboss.business.sales.bgbusiness.StockAlarmValueVO;
import com.gmcc.pboss.business.sales.orderuplimit.OrderuplimitDBParam;
import com.gmcc.pboss.business.sales.orderuplimit.OrderuplimitVO;
import com.gmcc.pboss.business.sales.stockalarm.StockalarmDBParam;
import com.gmcc.pboss.business.sales.stockalarm.StockalarmVO;
import com.gmcc.pboss.business.sales.wayassistant.WayassistantDBParam;
import com.gmcc.pboss.business.sales.wayassistant.WayassistantVO;
import com.gmcc.pboss.control.base.dictitem.Dictitem;
import com.gmcc.pboss.control.base.dictitem.DictitemBO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.resource.resinfostat.Resinfostat;
import com.gmcc.pboss.control.resource.resinfostat.ResinfostatBO;
import com.gmcc.pboss.control.sales.orderuplimit.Orderuplimit;
import com.gmcc.pboss.control.sales.orderuplimit.OrderuplimitBO;
import com.gmcc.pboss.control.sales.partnerres.Partnerres;
import com.gmcc.pboss.control.sales.partnerres.PartnerresBO;
import com.gmcc.pboss.control.sales.stockalarm.Stockalarm;
import com.gmcc.pboss.control.sales.stockalarm.StockalarmBO;
import com.gmcc.pboss.control.sales.wayassistant.Wayassistant;
import com.gmcc.pboss.control.sales.wayassistant.WayassistantBO;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class ResInfoStatBO extends AbstractControlBean implements ResInfoStat {

	private Logger log = Logger.getLogger(ResInfoStatBO.class);

	public void doProcess() throws Exception {
		// TODO Auto-generated method stub
		log.info("==================================ResInfoStat Begin==================================");
		//Date[] yesterdaytime = PublicUtils.getDatePeriod(new Date(), 1);
		/**
		 * ��ȡ���µ��������������
		 */
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);//��ǰ��
		int month = calendar.get(Calendar.MONTH) + 1;//��ǰ��
		String beginTimeStr = PublicUtils.getMonthBegin(year, month);
		Date beginTime = PublicUtils.UtilStrToDate(beginTimeStr);
		Date endTime = new Date();
		
		// ��ȡ�����Ʒ�ƻ�׼����
		Map<PartnerSMPBrandVO, Long> wayBrandBaseData = this.loadWayBrandBaseData();
				
		// ȡ�����㡰�������
		Map<PartnerSMPBrandVO, Long> wayBrandStkAmount = this.statWayStkAmount(wayBrandBaseData);
				
		// ȡ�����㵱�µġ��������
		Map<PartnerSMPBrandVO, Long> wayBrandLHAmount = this.statWayLHAmount(wayBrandBaseData, beginTime, endTime);
				
		// ȡ�����㵱�µġ���������
		Map<PartnerSMPBrandVO, Long> wayBrandActiveAmount = this
				.statWayActiveAmount(wayBrandBaseData, beginTime,
						endTime);
		//��ȡԤ����Ϣ panyonghui add
		Map<PartnerSMPBrandVO, StockAlarmValueVO> statWayAlarmInfo = this.statWayAlarmInfo(wayBrandBaseData);
		this.createResInfoStat(wayBrandBaseData, wayBrandStkAmount,
				wayBrandLHAmount, wayBrandActiveAmount,statWayAlarmInfo);
		log.info("==================================ResInfoStat End==================================");
	}

	/**
	 * ���������̱���[WAYID]������Ʒ��[BRAND]������ͳ�ƣ�ȡ�����㡰�������
	 * 
	 * @param wayBrandBaseData
	 * @return
	 * @throws Exception
	 */
	private Map<PartnerSMPBrandVO, Long> statWayStkAmount(
			Map<PartnerSMPBrandVO, Long> wayBrandBaseData) throws Exception {

		Map<PartnerSMPBrandVO, Long> result = new HashMap<PartnerSMPBrandVO, Long>();
		result.putAll(wayBrandBaseData);
		Partnerres resBO = (Partnerres) BOFactory.build(PartnerresBO.class,
				user);
		DataPackage dp = resBO.doStatWayStdAmount();
		Map<PartnerSMPBrandVO, Long> wayBrandStkAmount = changeDpToMap(dp);
		// ͳ�Ƴ�����wayid�����ڻ�׼���� wayBrandBaseData�У���Ϊ�䲻���ڿɶ��������㣬������ͳ�ơ�
		for (Iterator<PartnerSMPBrandVO> it = wayBrandStkAmount.keySet()
				.iterator(); it.hasNext();) {
			PartnerSMPBrandVO psbVO = it.next();
			if(result.containsKey(psbVO)) { 
				result.put(psbVO, wayBrandStkAmount.get(psbVO));
			}
		}
		return result;
	}

	/**
	 * ���������̱���[WAYID]�� ����Ʒ��[BRAND]������ͳ�ƣ�ȡ��ָ��ʱ�������㡰�������
	 * @param wayBrandBaseData
	 * @param begintime
	 * @param endtime
	 * @return
	 * @throws Exception
	 * @author panyonghui
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
		// ͳ�Ƴ�����wayid�����ڻ�׼���� wayBrandBaseData�У���Ϊ�䲻���ڿɶ��������㣬������ͳ�ơ�
		for(Iterator<PartnerSMPBrandVO> it = wayBrandLHAmount.keySet().iterator();it.hasNext();) {
			PartnerSMPBrandVO psbVO = it.next();
			if(result.containsKey(psbVO)) {
				result.put(psbVO, wayBrandLHAmount.get(psbVO));
			}
		}
		return result;
	}

	/**
	 * ���������̱���[WAYID]�� ����Ʒ��[BRAND]������ͳ�ƣ�ȡ��ָ��ʱ�������㡰����������
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
		DataPackage dp = resBO.doStatWayActiveAmount(begintime, endtime);
		Map<PartnerSMPBrandVO, Long> wayBrandActionAmount = changeDpToMap(dp);
		// ͳ�Ƴ�����wayid�����ڻ�׼���� wayBrandBaseData�У���Ϊ�䲻���ڿɶ��������㣬������ͳ�ơ�
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
	 * ���������̱���[WAYID]�� ����Ʒ��[BRAND]������ͳ�ƣ�ȡ��Ԥ����Ϣ��
	 * @param wayBrandBaseData
	 * @return
	 * @throws Exception
	 */
	private Map<PartnerSMPBrandVO, StockAlarmValueVO> statWayAlarmInfo(Map<PartnerSMPBrandVO, Long> wayBrandBaseData) throws Exception {
		Stockalarm stockalarmBO = (Stockalarm) BOFactory.build(StockalarmBO.class,user);//������Ԥ������
		Set<PartnerSMPBrandVO> PartnerSMPBrandSet = wayBrandBaseData.keySet();
		Map<PartnerSMPBrandVO, StockAlarmValueVO> alarmResult = new HashMap<PartnerSMPBrandVO, StockAlarmValueVO>();
		for (PartnerSMPBrandVO vo : PartnerSMPBrandSet) {
			String wayid = vo.getWayid();
			String brand = vo.getBrand();
			StockalarmDBParam alarmDBParam = new StockalarmDBParam();
			alarmDBParam.set_se_wayid(wayid);
			alarmDBParam.set_se_brand(brand);
			alarmDBParam.setDataOnly(true);
			alarmDBParam.set_pagesize("0");
			DataPackage dp = stockalarmBO.doQuery(alarmDBParam);
			List<StockalarmVO> list = dp.getDatas();
			if(!list.isEmpty()){//������������¼��߿���Ԥ����ֵ����,��Ԥ����ֵ���Ϊ����ͷ�ֵ��
				StockalarmVO stockalarmVO = list.get(0);
				StockAlarmValueVO stockAlarmValueVO = new StockAlarmValueVO(stockalarmVO.getMaxstock());
				stockAlarmValueVO.setAlarmvalue(stockalarmVO.getAlarmvalue());
				alarmResult.put(vo, stockAlarmValueVO);
			}else {
				/**
				 * ��������ݣ����ݺ����̱����ѯ������CH_PW_WAY����ȡ�ֹ�˾�����ع�˾��ʶCOUNTYID�����Ǽ���
				 * Ȼ����ݵ��б�ʶ���ֹ�˾���Ǽ���Ʒ�ơ�Լ��ģʽ��Ĭ��ȡԤ�����ģʽ����ѯ�������������ñ�FX_RU_ORDERUPLIMIT����
				 * ������������¼��߿���Ԥ����ֵ����.
				 * ��Ԥ����ֵ���Ϊ����ͷ�ֵ��
				 */
				Way wayBO = (Way) BOFactory.build(WayBO.class,user);
				Orderuplimit orderuplimitBO = (Orderuplimit)BOFactory.build(OrderuplimitBO.class,user);
				WayVO wayvo = (WayVO)wayBO.doFindByPk(wayid);
				if(wayvo == null){
					log.info("����[" + wayid + "]��Ϣ�����ڡ�");
					continue;
				}
				if(wayvo.getStarlevel() == null){
					log.info("����[" + wayid + "]���Ǽ���Ϣ�����ڡ�");
					continue;
				}
				OrderuplimitDBParam params = new OrderuplimitDBParam();
				params.set_se_cityid(wayvo.getCityid());
				params.set_se_countyid(wayvo.getCountyid());
				params.set_ne_starlevel(wayvo.getStarlevel().toString());
				params.set_se_brand(brand);
				params.set_se_limitmode("STOCKALARM");//Լ��ģʽ��Ĭ��ȡԤ�����ģʽ��
				params.setDataOnly(true);
				//params.set_pagesize("0");
				DataPackage dPackage = orderuplimitBO.doQuery(params);
				List<OrderuplimitVO> orderuplimitList = dPackage.getDatas();
				if(!orderuplimitList.isEmpty()){
					OrderuplimitVO orderuplimitVO = orderuplimitList.get(0);
					StockAlarmValueVO stockAlarmValueVO = new StockAlarmValueVO(orderuplimitVO.getMaxstock());
					stockAlarmValueVO.setAlarmvalue(orderuplimitVO.getAlarmvalue());
					alarmResult.put(vo, stockAlarmValueVO);
				}else {
					log.info("����[" + wayid +"] Ʒ��[" + brand + "] �޶�Ӧ��Ԥ������");
					continue;
				}
			}
		}
		return alarmResult;
	}

	/**
	 * ��DataPackage �е����� ת���� Map<PartnerSMPBrandVO, Long>
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

	/**
	 * ��ȡ�����Ʒ�ƻ�׼����,���������Բ�����ʽ��ϳ�һ��Map, ����KeyΪ�������Ʒ��VO��, ValueĬ��ȡ0
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
	 * ��ͳ����Ϣ�������������������������Լ����Ԥ����Ϣ����⣨������Դ��Ϣͳ��[IM_FX_RESINFOSTAT]��
	 * 
	 * @param wayBrandBaseData
	 * @param wayBrandStkAmount
	 * @param wayBrandLHAmount
	 * @param wayBrandActiveAmount
	 * @throws Exception
	 */
	private void createResInfoStat(
			Map<PartnerSMPBrandVO, Long> wayBrandBaseData,
			Map<PartnerSMPBrandVO, Long> wayBrandStkAmount,
			Map<PartnerSMPBrandVO, Long> wayBrandLHAmount,
			Map<PartnerSMPBrandVO, Long> wayBrandActiveAmount,
			Map<PartnerSMPBrandVO, StockAlarmValueVO> statWayAlarmInfo) throws Exception {

		Resinfostat risBO = (Resinfostat) BOFactory.build(ResinfostatBO.class,user);

		for (Iterator<PartnerSMPBrandVO> it = wayBrandBaseData.keySet()
				.iterator(); it.hasNext();) {
			try {
				PartnerSMPBrandVO psbVO = it.next();
				StockAlarmValueVO stockAlarmValueVO = statWayAlarmInfo.get(psbVO);//panyonghui add
				if(stockAlarmValueVO == null){
					continue;//ǰ���Ѿ��м�¼��־������Ͳ���Ҫ�ˡ�
				}
				Long stkAmount = wayBrandStkAmount.get(psbVO) == null ? 0 : wayBrandStkAmount.get(psbVO);
				Long lHAmount = wayBrandLHAmount.get(psbVO) == null ? 0 : wayBrandLHAmount.get(psbVO);
				Long activeAmount = wayBrandActiveAmount.get(psbVO) == null ? 0 : wayBrandActiveAmount.get(psbVO);
				ResinfostatVO risVO = new ResinfostatVO();
				risVO.setBrand(psbVO.getBrand());
				risVO.setWayid(psbVO.getWayid());
				risVO.setStatdate(new Date());
				risVO.setKcamount(stkAmount);
				risVO.setLhamount(lHAmount);
				risVO.setJhamount(activeAmount);
				
				this.setResinfostatVO(risVO, stockAlarmValueVO);
				
				risBO.doCreate(risVO);
			} catch (Exception ex) {
				LoggerUtils.error(ex, log);
			}
		}
	}
	
	/**
	 * ����Ԥ������ͷ�ֵ�������������Ϣ
	 * @param risVO
	 * @param vo
	 * @throws Exception
	 * @author panyonghui
	 */
	private void setResinfostatVO(ResinfostatVO risVO,StockAlarmValueVO vo) throws Exception {
		Long maxstock = vo.getMaxstock();//��߿��
		Long stkAmount = risVO.getKcamount();//�����
		String alarmvalueStr = vo.getAlarmvalue();
		
		String [] redLevelAlarmvalue = alarmvalueStr.split(";")[0].split(":");
		String [] yelLevelAlarmvalue = alarmvalueStr.split(";")[1].split(":");
		Long redvalue = Long.parseLong(redLevelAlarmvalue[1]);
		Long yelvalue = Long.parseLong(yelLevelAlarmvalue[1]);
		if(stkAmount > maxstock){//���������>��߿�桱ʱΪ��ɫԤ��
			risVO.setAlarmlevel("BULEALARM");
		}else if(stkAmount > yelvalue && stkAmount <= maxstock){//������ɫ��ֵ<�����<=��߿�桱ʱΪ��ɫԤ��
			risVO.setAlarmlevel("GREENALARM");
		}else if(stkAmount > redvalue && stkAmount <= yelvalue){//������ɫԤ����<�����<=��ɫԤ���ߡ�Ϊ��ɫԤ��
			risVO.setAlarmlevel("YELALARM");
		}else if(stkAmount <= redvalue){//���������<=��ɫԤ���ߡ�ʱΪ��ɫԤ��
			risVO.setAlarmlevel("REDALARM");
		}
		risVO.setRedvalue(redvalue);
		risVO.setYelvalue(yelvalue);
		risVO.setMaxstock(maxstock);
	}

}
