package com.gmcc.pboss.control.sales.bgcontrol.SMPActiveRateCalc.calcmode.impl;

import java.io.Serializable;
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
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.sales.activerate.Activerate;
import com.gmcc.pboss.control.sales.activerate.ActiverateBO;
import com.gmcc.pboss.control.sales.bgcontrol.SMPActiveRateCalc.SMPActiveRateCalc;
import com.gmcc.pboss.control.sales.bgcontrol.SMPActiveRateCalc.calcmode.intf.CalcMode;
import com.gmcc.pboss.control.sales.orderstd.Orderstd;
import com.gmcc.pboss.control.sales.orderstd.OrderstdBO;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.exception.BusinessException;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;
/**
 * �׿���������ͨ����ģʽ
 * @author zsw
 * @date 2010-03-18
 */
public class GeneralCalcMode implements CalcMode {

	private Logger log = Logger.getLogger(GeneralCalcMode.class);
	
	private static String ALLBRAND = "AllBrand";
	private SMPActiveRateCalc arcBO;
	
	public GeneralCalcMode(SMPActiveRateCalc arcBO) {
		this.arcBO = arcBO;
	}
	public void doSMPActiveRateCalc(DBAccessUser user) throws Exception {
		log.info("�׿������ʼ���ģʽΪ\"��ͨģʽ\"");
		Sysparam spBo = (SysparamBO)BOFactory.build(SysparamBO.class, user);
		
//		String spBrandValue = spBo.doFindByID(12L, "pboss_fx");
		// �Ѽ����׿���������
		String spActiveOrderValue = spBo.doFindByID(32L, "pboss_fx");
		// �Ѽ����׿���������
		String spActiveValue = spBo.doFindByID(33L, "pboss_fx");
		// ��������������
		String spOrderValue = spBo.doFindByID(35L, "pboss_fx");
		
//		String brandValue = "";
//		if(spBrandValue == null) {
//			brandValue = "-1";
//			log.warn("ϵͳ�������ñ���û�в�������Ϊ��pboss_fx����������ʶΪ��12�������ݣ����� ������Ʒ�ơ�����");
//		}else {
//			brandValue = spBrandValue.trim();
//		}
		// �Ѽ����׿���������
		String activeOrderDayValue = "";
		if(spActiveOrderValue == null) {
			activeOrderDayValue = "-1";
			log.warn("ϵͳ�������ñ���û�в�������Ϊ��pboss_fx����������ʶΪ��32�������ݣ��� -1 ����");
		}else {
			activeOrderDayValue = spActiveOrderValue.trim();
			if(!PublicUtils.isInteger(activeOrderDayValue)) {
				throw new BusinessException("ϵͳ�������ñ��� \"�Ѽ����׿���������\" ��ֵ��������",null);
			}
		}
		// �Ѽ����׿���������
		String activeDayValue = "";
		if(spActiveValue == null) {
			activeDayValue = "-1";
			log.warn("ϵͳ�������ñ���û�в�������Ϊ��pboss_fx����������ʶΪ��33�������ݣ��� -1 ����");
		}else {
			activeDayValue = spActiveValue.trim();
			if(!PublicUtils.isInteger(activeDayValue)) {
				throw new BusinessException("ϵͳ�������ñ��� \"�Ѽ����׿���������\" ��ֵ��������",null);
			}
		}
		// ��������������
		String orderDayValue = "";
		if(spOrderValue == null) {
			orderDayValue = "-1";
			log.warn("ϵͳ�������ñ���û�в�������Ϊ��pboss_fx����������ʶΪ��35�������ݣ��� -1 ����");
		}else {
			orderDayValue = spOrderValue.trim();
			if(!PublicUtils.isInteger(orderDayValue)) {
				throw new BusinessException("ϵͳ�������ñ��� \"��������������\" ��ֵ��������",null);
			}
		}
		Integer activeOrderDay = Integer.parseInt(activeOrderDayValue);
		
		Integer activeDay = Integer.parseInt(activeDayValue);

		Integer orderDay = Integer.parseInt(orderDayValue);
		
//		if("1".equals(brandValue.trim())) {
//			log.info("����Ʒ��");
			// ����Ʒ��
			Way wayBo = (WayBO)BOFactory.build(WayBO.class, user);
			Orderstd osBo = (OrderstdBO)BOFactory.build(OrderstdBO.class,user);
			Activerate arBo = (ActiverateBO)BOFactory.build(ActiverateBO.class,user,BOFactory.PROPAGATION_REQUIRES_NEW);
			
			Map<PartnerSMPBrandVO, String> dataMap = 
				arcBO.doStatActiveAndOrderSMPWithBrand(activeOrderDay, activeDay, orderDay);
			
			Map<String, Map<PartnerSMPBrandVO, Object[]>> wayidAndActiveRateMap = this.getWayidAndActiveRateMap(dataMap);
			
			for(Iterator<String> it = wayidAndActiveRateMap.keySet().iterator();it.hasNext();) {
				try {
					String wayid = it.next();
					Map<PartnerSMPBrandVO, Object[]> activeRateMap = wayidAndActiveRateMap.get(wayid);
					
					WayVO wayVo = wayBo.doFindByPk(wayid);
					String _cityid = wayVo.getCityid();
					String _countyid = wayVo.getCountyid();
					String _cooptype = wayVo.getCusttype();
					Long _starlevel = wayVo.getStarlevel();
					
					OrderstdDBParam osParam = new OrderstdDBParam();
					if(_cityid == null || "".equals(_cityid.trim())) {
						throw new BusinessException("������"+wayid+" �� cityid �ֶ�Ϊ��",null);
					}
					if(_countyid == null || "".equals(_countyid.trim())) {
						throw new BusinessException("������"+wayid+" �� countyid �ֶ�Ϊ��",null);
					}
					if(_cooptype == null || "".equals(_cooptype.trim())) {
//						throw new Exception("������"+wayid+" �� custtype �ֶ�Ϊ��");
						// ����������Ϊ�գ����պ������͵��ڡ�ALL��������
						osParam.set_se_cooptype("ALL");
					}else {
						osParam.set_se_cooptype(_cooptype);
					}
					if(_starlevel == null || "".equals(_starlevel.toString().trim())) {
						throw new BusinessException("������"+wayid+" �� starlevel �ֶ�Ϊ��",null);
					}
					for(Iterator<PartnerSMPBrandVO> ait = activeRateMap.keySet().iterator();ait.hasNext();) {
						try {
							PartnerSMPBrandVO pbVo = ait.next();
							String brand = pbVo.getBrand();
							if(brand == null || "".equals(brand.trim())) {
								throw new BusinessException("��������Դ�� FX_SW_PARTNERRES �д��� ����IDΪ  "+wayid+" ��������Ʒ���ֶ�Brand��ֵΪ�գ����ʵ��",null);
							}
							
							Object[] value = activeRateMap.get(pbVo);
							osParam.set_se_cityid(_cityid);
							osParam.set_se_countyid(_countyid);
							osParam.set_ne_starlevel(_starlevel.toString());
							osParam.set_se_brand(brand);
							osParam.set_se_stdtype("ACTRATE");
							osParam.set_pagesize("0");
							osParam.setDataOnly(true);
							DataPackage osDp = osBo.doQuery(osParam);
							List osDatas = osDp.getDatas();
							
							double activeRate = (Double)value[0];
							long orderQuantity = (Long)value[1];
							long activeQuantity = (Long)value[2];
							
							
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
								// ����������Ϊ�գ����պ������͵��ڡ�ALL��������
								
							}else if((osDatas == null || osDatas.size() <= 0)) {
								// �������������Ͳ�Ϊ�������������պ������͵��ڡ�ALL���ٴβ�ѯ��
								// �����Ȼ�����ݣ��Ƿ����ֶ�ȡ1�������ȡ0��(����CR_SW20100624_1065427���޸�)
								osParam.set_se_cooptype("ALL");
								osDp = osBo.doQuery(osParam);
								osDatas = osDp.getDatas();
							}
							if((osDatas == null || osDatas.size() <= 0)) {
								// �����Ȼ�����ݣ��Ƿ����ֶ�ȡ1�������ȡ0��(����CR_SW20100624_1065427���޸�)
								arVo.setIsachieve(new Short("1"));
								arVo.setDifamt(0L);
							}else {
								OrderstdVO osVo = (OrderstdVO)(osDatas.get(0));
								double lowestStd = osVo.getLoweststd();
								if(activeRate >= lowestStd) {
									arVo.setIsachieve(new Short("1"));
									// ���ʱ�����ȡ0
									arVo.setDifamt(0L);
								}else {
									arVo.setIsachieve(new Short("0"));
									double lowestQuantity = orderQuantity*lowestStd;
									// �����
									double difamt = lowestQuantity - activeQuantity;
									difamt = Math.ceil(difamt);
									arVo.setDifamt((long)difamt);
								}
							}
							// ����ʱ��
							arVo.setChgtime(new Date());
							// ������
							arVo.setRate(activeRate);
							
							if(isNew) {
								arBo.doCreate(arVo);
								log.info("�����׿����������ݣ�"+"[������ʶ:"+wayid+";Ʒ��:"+brand+";������:"+activeRate+";�Ƿ���:"+arVo.getIsachieve()+";�����(�Ѵ��ʱΪ0):"+arVo.getDifamt());
							}else {
								arBo.doUpdate(arVo);
								log.info("�����׿����������ݣ�"+"[������ʶ:"+wayid+";Ʒ��:"+brand+";������:"+activeRate+";�Ƿ���:"+arVo.getIsachieve()+";�����(�Ѵ��ʱΪ0):"+arVo.getDifamt());
							}
						}catch(BusinessException ex) {
							log.info(ex.getMessage());
						}catch(Exception ex) {
							LoggerUtils.error(ex, log);
						}
					}
					
				}catch(BusinessException ex) {
					log.info(ex.getMessage());
				}catch(Exception ex) {
					LoggerUtils.error(ex, log);
				}
			}
			
//		}else {
//			log.info("������Ʒ��");
//			// ������Ʒ��
//			Way wayBo = (WayBO)BOFactory.build(WayBO.class, user);
//			Orderstd osBo = (OrderstdBO)BOFactory.build(OrderstdBO.class,user);
//			Activerate arBo = (ActiverateBO)BOFactory.build(ActiverateBO.class,user,BOFactory.PROPAGATION_REQUIRES_NEW);
//			
//			Map<String,String> dataMap = arcBO.doStatActiveAndOrderSMPNotWithBrand(activeOrderDay, activeDay, orderDay);
//			
//			Set<String> keys = dataMap.keySet();
//			for(Iterator<String> it = keys.iterator();it.hasNext();) {
//				try {
//					String wayid = it.next();
//					String[] quantity = dataMap.get(wayid).split("\\|");
//					long orderQuantity = Long.parseLong(quantity[0]);
//					long activeQuantity = Long.parseLong(quantity[1]);
//					double activeRate = (double)activeQuantity/(double)orderQuantity;
//					WayVO wayVo = wayBo.doFindByPk(wayid);
//					String _cityid = wayVo.getCityid();
//					String _countyid = wayVo.getCountyid();
//					String _cooptype = wayVo.getCusttype();
//					Long _starlevel = wayVo.getStarlevel();
//					
//					OrderstdDBParam osParam = new OrderstdDBParam();
//					if(_cityid == null || "".equals(_cityid.trim())) {
//						throw new Exception("������"+wayid+" �� cityid �ֶ�Ϊ��");
//					}
//					if(_countyid == null || "".equals(_countyid.trim())) {
//						throw new Exception("������"+wayid+" �� countyid �ֶ�Ϊ��");
//					}
//					if(_cooptype == null || "".equals(_cooptype.trim())) {
////						throw new Exception("������"+wayid+" �� custtype �ֶ�Ϊ��");
//						// ����������Ϊ�գ����պ������͵��ڡ�ALL��������
//						osParam.set_se_cooptype("ALL");
//					}else {
//						osParam.set_se_cooptype(_cooptype);
//					}
//					if(_starlevel == null || "".equals(_starlevel.toString().trim())) {
//						throw new Exception("������"+wayid+" �� starlevel �ֶ�Ϊ��");
//					}
//					
//					osParam.set_se_cityid(_cityid);
//					osParam.set_se_countyid(_countyid);
//					osParam.set_ne_starlevel(_starlevel.toString());
//					osParam.set_se_brand("AllBrand");
//					osParam.set_se_stdtype("ACTRATE");
//					osParam.set_pagesize("0");
//					osParam.setDataOnly(true);
//					DataPackage osDp = osBo.doQuery(osParam);
//					Collection osDatas = osDp.getDatas();
//					if(_cooptype == null || "".equals(_cooptype.trim())) {
//						if((osDatas == null || osDatas.size() <= 0)) {
//							continue;
//						}
//					}else {
//						// �������������Ͳ�Ϊ�������������պ������͵��ڡ�ALL���ٴβ�ѯ�������Ȼ������������һ����¼
//						if((osDatas == null || osDatas.size() <= 0)) {
//							osParam.set_se_cooptype("ALL");
//							osDp = osBo.doQuery(osParam);
//							osDatas = osDp.getDatas();
//							if(osDatas == null || osDatas.size() <= 0) {
//								continue;
//							}
//						}
//					}
//					OrderstdVO osVo = (OrderstdVO)(new ArrayList(osDatas).get(0));
//					double lowestStd = osVo.getLoweststd();
//					Serializable pkVO = new ActiverateVO();
//					BeanUtils.setProperty(pkVO, "wayid", wayid);
//					BeanUtils.setProperty(pkVO, "brand", "AllBrand");
//					ActiverateVO arVo = arBo.doFindByPk(pkVO);
//					boolean isNew = arVo == null ? true : false;
//					if(isNew) {
//						arVo = new ActiverateVO();
//						arVo.setWayid(wayid);
//						arVo.setBrand("AllBrand");
//					}
//					if(activeRate >= lowestStd) {
//						arVo.setIsachieve(new Short("1"));
//					}else {
//						arVo.setIsachieve(new Short("0"));
//						double lowestQuantity = orderQuantity*lowestStd;
//						// �����
//						double difamt = lowestQuantity - activeQuantity;
//						difamt = Math.ceil(difamt);
//						arVo.setDifamt((long)difamt);
//					}
//					// ����ʱ��
//					arVo.setChgtime(new Date());
//					// ������
//					arVo.setRate(activeRate);
//					if(isNew) {
//						arBo.doCreate(arVo);
//					}else {
//						arBo.doUpdate(arVo);
//					}
//					if(isNew) {
//						log.info("�����׿����������ݣ�"+"[������ʶ:"+wayid+";Ʒ��:AllBrand"+";������:"+activeRate+";�Ƿ���:"+arVo.getIsachieve()+";�����(�Ѵ��ʱΪnull):"+arVo.getDifamt());
//					}else {
//						log.info("�����׿����������ݣ�"+"[������ʶ:"+wayid+";Ʒ��:AllBrand"+";������:"+activeRate+";�Ƿ���:"+arVo.getIsachieve()+";�����(�Ѵ��ʱΪnull):"+arVo.getDifamt());
//					}
//				}catch(Exception ex) {
//					LoggerUtils.error(ex, log);
//				}
//			}
//		}
		
	}
	/**
	 * �����ʼ��㣺�����Ʒ���Լ�������Ʒ�ơ����׿������ʣ�������=�Ѽ�����/��������
	 * ���㡰����Ʒ�ơ�������ʱ��Ҫ����Ʒ���Ѽ������Ͷ������ֱ��ۼӣ�������Ʒ�ơ�����ȡ��AllBrand����
	 * @param dataMap
	 * @return ������ID�����Ÿ�������Ӧ�ĸ�Ʒ�ƺ�"����Ʒ��"�ļ�����,������,��������Map
	 * @throws Exception
	 */
	private Map<String, Map<PartnerSMPBrandVO, Object[]>> getWayidAndActiveRateMap(
			Map<PartnerSMPBrandVO, String> dataMap) throws Exception {
		
		// ������ID�����Ÿ�������Ӧ�ĸ�Ʒ�ƺ�"����Ʒ��"�ļ�����,������,��������Map
		Map<String, Map<PartnerSMPBrandVO, Object[]>> wayidAndActiveRateMap = new HashMap<String, Map<PartnerSMPBrandVO, Object[]>>();
		// �������ID�Ͷ�������Map
		Map<String,Long> wayAndOrderQty = new HashMap<String,Long>();
		// �������ID�ͼ�������Map
		Map<String,Long> wayAndactiveQty = new HashMap<String,Long>();
		
		Set<PartnerSMPBrandVO> keys = dataMap.keySet();
		for(Iterator<PartnerSMPBrandVO> it = keys.iterator();it.hasNext();) {
			PartnerSMPBrandVO pbVo = it.next();
			String wayid = pbVo.getWayid();
			String[] quantity = dataMap.get(pbVo).split("\\|");
			long orderQuantity = Long.parseLong(quantity[0]);
			long activeQuantity = Long.parseLong(quantity[1]);
			double activeRate = (double)activeQuantity/(double)orderQuantity;
			Object[] value = {activeRate,orderQuantity,activeQuantity};
			if(wayidAndActiveRateMap.containsKey(wayid)) {
				Map<PartnerSMPBrandVO, Object[]> activeRateMap = wayidAndActiveRateMap.get(wayid);
				activeRateMap.put(pbVo, value);
			}else {
				Map<PartnerSMPBrandVO,Object[]> activeRateMap = new HashMap<PartnerSMPBrandVO,Object[]>();
				activeRateMap.put(pbVo, value);
				wayidAndActiveRateMap.put(wayid, activeRateMap);
			}
			if(wayAndOrderQty.containsKey(wayid)) {
				long oldOrderQty = wayAndOrderQty.get(wayid);
				long newOrderQty = orderQuantity + oldOrderQty;
				wayAndOrderQty.put(wayid, newOrderQty);
			}else {
				wayAndOrderQty.put(wayid,orderQuantity);
			}
			if(wayAndactiveQty.containsKey(wayid)) {
				long oldActiveQty = wayAndactiveQty.get(wayid);
				long newActiveQty = activeQuantity + oldActiveQty;
				wayAndactiveQty.put(wayid, newActiveQty);
			}else {
				wayAndactiveQty.put(wayid, activeQuantity);
			}
		}
		for(Iterator<String> it = wayAndOrderQty.keySet().iterator();it.hasNext();) {
			String wayid = it.next();
			PartnerSMPBrandVO allBrand_pbVO = new PartnerSMPBrandVO(wayid,ALLBRAND);
			long orderQuantity_AllBrand = wayAndOrderQty.get(wayid);
			long activeQuantity_AllBrand = wayAndactiveQty.get(wayid);
			double activeRate_AllBrand = (double)activeQuantity_AllBrand/(double)orderQuantity_AllBrand;
			Object[] allBrand_value = {activeRate_AllBrand,orderQuantity_AllBrand,activeQuantity_AllBrand};
			Map<PartnerSMPBrandVO,Object[]> activeRateMap = wayidAndActiveRateMap.get(wayid);
			activeRateMap.put(allBrand_pbVO, allBrand_value);
			wayidAndActiveRateMap.put(wayid, activeRateMap);
		}
		return wayidAndActiveRateMap;
	}
	

}
