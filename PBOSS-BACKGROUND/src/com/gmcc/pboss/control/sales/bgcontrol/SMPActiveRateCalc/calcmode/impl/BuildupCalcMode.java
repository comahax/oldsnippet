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
 * �׿����������ģʽ
 * @author zsw
 * @date 2010-03-18
 */
public class BuildupCalcMode implements CalcMode {

	private Logger log = Logger.getLogger(BuildupCalcMode.class);
	private SMPActiveRateCalc arcBO;
	private static String ALLBRAND = "AllBrand";
	
	public BuildupCalcMode(SMPActiveRateCalc arcBO) {
		this.arcBO = arcBO;
	}
	public void doSMPActiveRateCalc(DBAccessUser user) throws Exception {
		log.info("�׿������ʼ���ģʽΪ\"���ģʽ\"");
		// ֱ���ۼ�ģʽ
		Sysparam spBo = (SysparamBO)BOFactory.build(SysparamBO.class, user);
		
//		String spBrandValue = spBo.doFindByID(12L, "pboss_fx");
		String spActiveOrderValue = spBo.doFindByID(32L, "pboss_fx");
		String spActiveValue = spBo.doFindByID(33L, "pboss_fx");
		String spInActiveValue = spBo.doFindByID(34L, "pboss_fx");
		
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
				throw new Exception("ϵͳ�������ñ��� \"�Ѽ����׿���������\" ��ֵ��������");
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
				throw new Exception("ϵͳ�������ñ��� \"�Ѽ����׿���������\" ��ֵ��������");
			}
		}
		// δ�����׿���������
		String inActiveOrderDayValue = "";
		if(spInActiveValue == null) {
			inActiveOrderDayValue = "-1";
			log.warn("ϵͳ�������ñ���û�в�������Ϊ��pboss_fx����������ʶΪ��34�������ݣ��� -1 ����");
		}else {
			inActiveOrderDayValue = spInActiveValue.trim();
			if(!PublicUtils.isInteger(inActiveOrderDayValue)) {
				throw new Exception("ϵͳ�������ñ��� \"δ�����׿���������\" ��ֵ��������");
			}
		}
		
		Integer intActiveOrderDay = Integer.parseInt(activeOrderDayValue);
		
		Integer intActiveDay = Integer.parseInt(activeDayValue);

		Integer intInactiveOrderDay = Integer.parseInt(inActiveOrderDayValue);
		
//		if("1".equals(brandValue.trim())) {
//			log.info("����Ʒ��");
			// ����Ʒ��
			Way wayBo = (WayBO)BOFactory.build(WayBO.class, user);
			Orderstd osBo = (OrderstdBO)BOFactory.build(OrderstdBO.class,user);
			Activerate arBo = (ActiverateBO)BOFactory.build(ActiverateBO.class,user,BOFactory.PROPAGATION_REQUIRES_NEW);
			
			Map<PartnerSMPBrandVO, Long[]> dataMap = 
				arcBO.doStatSMPWithBrand(intActiveOrderDay, 
						intActiveDay, intInactiveOrderDay);
			
			Map<String, Map<PartnerSMPBrandVO, Object[]>> wayidAndActiveRateMap = this.getWayidAndActiveRateMap(dataMap);
			 
			Set<String> keys = wayidAndActiveRateMap.keySet();
			for(Iterator<String> it = keys.iterator();it.hasNext();) {
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
							long activeQuantity = (Long)value[1];
							long inActiveQuantity = (Long)value[2];
							
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
								if(osDatas == null || osDatas.size() <= 0) {
									arVo.setIsachieve(new Short("1"));
									arVo.setDifamt(0L);
								}
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
									double lowestQuantity = (activeQuantity+inActiveQuantity)*lowestStd;
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
//			Map<String,String> dataMap = arcBO.doStatSMPNotWithBrand(intActiveOrderDay, 
//						intActiveDay, intInactiveOrderDay);
//			
//			Set<String> keys = dataMap.keySet();
//			for(Iterator<String> it = keys.iterator();it.hasNext();) {
//				try {
//					String wayid = it.next();
//					String[] quantity = dataMap.get(wayid).split("\\|");
//					long activeQuantity = Long.parseLong(quantity[0]);
//					long inActiveQuantity = Long.parseLong(quantity[1]);
//					double activeRate = (double)activeQuantity/((double)activeQuantity+(double)inActiveQuantity);
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
//						double lowestQuantity = (activeQuantity+inActiveQuantity)*lowestStd;
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
	 * �����ʼ��㣺�����Ʒ���Լ�������Ʒ�ơ����׿������ʣ�������=�Ѽ�����/���Ѽ�����+δ����������
	 * ���㡰����Ʒ�ơ�������ʱ��Ҫ����Ʒ���Ѽ�������δ�������ֱ��ۼӣ�������Ʒ�ơ�����ȡ��AllBrand����
	 * @param dataMap
	 * @return ������ID�����Ÿ�������Ӧ�ĸ�Ʒ�ƺ�"����Ʒ��"�ļ�����,������,δ��������Map
	 * @throws Exception
	 */
	private Map<String, Map<PartnerSMPBrandVO, Object[]>> getWayidAndActiveRateMap(
			Map<PartnerSMPBrandVO, Long[]> dataMap) throws Exception {
		
		// ������ID�����Ÿ�������Ӧ�ĸ�Ʒ�ƺ�"����Ʒ��"�ļ�����,������,δ��������Map
		Map<String, Map<PartnerSMPBrandVO, Object[]>> wayidAndActiveRateMap = new HashMap<String, Map<PartnerSMPBrandVO, Object[]>>();
		// �������ID��δ��������Map
		Map<String,Long> wayAndInActiveQty = new HashMap<String,Long>();
		// �������ID�ͼ�������Map
		Map<String,Long> wayAndActiveQty = new HashMap<String,Long>();
		
		Set<PartnerSMPBrandVO> keys = dataMap.keySet();
		for(Iterator<PartnerSMPBrandVO> it = keys.iterator();it.hasNext();) {
			PartnerSMPBrandVO pbVo = it.next();
			String wayid = pbVo.getWayid();
			Long[] quantity = dataMap.get(pbVo);
			long activeQuantity = quantity[0];
			long inActiveQuantity = quantity[1];
			double activeRate = (double)activeQuantity/((double)activeQuantity+(double)inActiveQuantity);
			Object[] value = {activeRate,activeQuantity,inActiveQuantity};
			if(wayidAndActiveRateMap.containsKey(wayid)) {
				Map<PartnerSMPBrandVO, Object[]> activeRateMap = wayidAndActiveRateMap.get(wayid);
				activeRateMap.put(pbVo, value);
			}else {
				Map<PartnerSMPBrandVO,Object[]> activeRateMap = new HashMap<PartnerSMPBrandVO,Object[]>();
				activeRateMap.put(pbVo, value);
				wayidAndActiveRateMap.put(wayid, activeRateMap);
			}
			if(wayAndInActiveQty.containsKey(wayid)) {
				long oldInActiveQty = wayAndInActiveQty.get(wayid);
				long newInActiveQty = inActiveQuantity + oldInActiveQty;
				wayAndInActiveQty.put(wayid, newInActiveQty);
			}else {
				wayAndInActiveQty.put(wayid,inActiveQuantity);
			}
			if(wayAndActiveQty.containsKey(wayid)) {
				long oldActiveQty = wayAndActiveQty.get(wayid);
				long newActiveQty = activeQuantity + oldActiveQty;
				wayAndActiveQty.put(wayid, newActiveQty);
			}else {
				wayAndActiveQty.put(wayid, activeQuantity);
			}
		}
		for(Iterator<String> it = wayAndActiveQty.keySet().iterator();it.hasNext();) {
			String wayid = it.next();
			PartnerSMPBrandVO allBrand_pbVO = new PartnerSMPBrandVO(wayid,ALLBRAND);
			long activeQty_AllBrand = wayAndActiveQty.get(wayid);
			long inActiveQty_AllBrand = wayAndInActiveQty.get(wayid);
			double activeRate_AllBrand = (double)activeQty_AllBrand/((double)activeQty_AllBrand+(double)inActiveQty_AllBrand);
			Object[] value_AllBrand = {activeRate_AllBrand,activeQty_AllBrand,inActiveQty_AllBrand};
			Map<PartnerSMPBrandVO,Object[]> activeRateMap = wayidAndActiveRateMap.get(wayid);
			activeRateMap.put(allBrand_pbVO, value_AllBrand);
			wayidAndActiveRateMap.put(wayid, activeRateMap);
		}
		return wayidAndActiveRateMap;
	}

}
