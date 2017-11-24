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
 * �׿������ʼ����׼���ģʽ
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
		log.info("�׿������ʼ���ģʽΪ\"��׼���ģʽ\"");
		// ��׼���ģʽ
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
							throw new BusinessException("��������Դ�� FX_SW_PARTNERRES �д��� ����IDΪ  "+wayid+" ��������Ʒ���ֶ�Brand��ֵΪ�գ����ʵ��",null);
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
							// ����������Ϊ�գ����պ������͵��ڡ�ALL��������
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
							// ����������Ϊ�գ����պ������͵��ڡ�ALL��������
						}else if((osDatas == null || osDatas.size() <= 0)) {
							// �������������Ͳ�Ϊ�������������պ������͵��ڡ�ALL���ٴβ�ѯ
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
							OrderstdVO osVo = (OrderstdVO)osDatas.get(0);
							double lowestStd = osVo.getLoweststd();
							
							if(activeRate >= lowestStd) {
								arVo.setIsachieve(new Short("1"));
							}else {
								arVo.setIsachieve(new Short("0"));
								// ���δ������
								double stdInActiveQty = stdStock - stdStock*lowestStd;
								// �����
								double difamt = inActiveQty - stdInActiveQty;
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
							log.info("�����׿����������ݣ�"+"[������ʶ:"+wayid+";Ʒ��:"+brand+";������:"+activeRate+";�Ƿ���:"+arVo.getIsachieve()+";�����(�Ѵ��ʱΪnull):"+arVo.getDifamt());
						}else {
							arBo.doUpdate(arVo);
							log.info("�����׿����������ݣ�"+"[������ʶ:"+wayid+";Ʒ��:"+brand+";������:"+activeRate+";�Ƿ���:"+arVo.getIsachieve()+";�����(�Ѵ��ʱΪnull):"+arVo.getDifamt());
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
		
		// ������ID�����Ÿ�������Ӧ�ĸ�Ʒ�ƺ�"����Ʒ��"�ļ�����,������,δ��������Map
		Map<String, Map<PartnerSMPBrandVO, Object[]>> wayidAndActiveRateMap = new HashMap<String, Map<PartnerSMPBrandVO, Object[]>>();
		// �������ID��δ��������Map
		Map<String,Long> wayAndInActiveQty = new HashMap<String,Long>();
		// �������ID�ͻ�׼����Map
		Map<String,Long> wayAndStdStock = new HashMap<String,Long>();
		// �������ID�Ͷ�ӦWayVO��Map
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
					throw new BusinessException("������"+wayid+" �� cityid �ֶ�Ϊ��",null);
				}
				if(_countyid == null || "".equals(_countyid.trim())) {
					throw new BusinessException("������"+wayid+" �� countyid �ֶ�Ϊ��",null);
				}
				if(_cooptype == null || "".equals(_cooptype.trim())) {
	//				throw new Exception("������"+wayid+" �� custtype �ֶ�Ϊ��");
					// ����������Ϊ�գ����պ������͵��ڡ�ALL��������
					olParams.set_se_cooptype("ALL");
				}else {
					olParams.set_se_cooptype(_cooptype);
				}
				if(_starlevel == null || "".equals(_starlevel.toString().trim())) {
					throw new BusinessException("������"+wayid+" �� starlevel �ֶ�Ϊ��",null);
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
					// ����������Ϊ�գ����պ������͵��ڡ�ALL��������
				}else if((olDatas == null || olDatas.size() <= 0)) {
					// �������������Ͳ�Ϊ�������������պ������͵��ڡ�ALL���ٴβ�ѯ
					olParams.set_se_cooptype("ALL");
					olDp = olBo.doQuery(olParams);
					olDatas = olDp.getDatas();
				}
				if(olDatas == null || olDatas.size() <= 0) {
					// �����Ȼ������������һ����¼
					continue;
				}
				OrderuplimitVO olVo = (OrderuplimitVO)olDatas.get(0);
				// ��׼���
				if(olVo.getStdstock()== null) {
					throw new BusinessException("������(����)���ڳ��У�"+user.getCityid()+"; ��������: "+_countyid+"; �������ͣ�"+_cooptype+"; �Ǽ���"+_starlevel+" �Ļ�׼�������Ϊ�գ����ʵ",null);
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
