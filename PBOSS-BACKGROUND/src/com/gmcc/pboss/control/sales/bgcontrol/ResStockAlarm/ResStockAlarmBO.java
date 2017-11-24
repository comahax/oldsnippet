package com.gmcc.pboss.control.sales.bgcontrol.ResStockAlarm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import com.gmcc.pboss.business.base.dictitem.DictitemDBParam;
import com.gmcc.pboss.business.base.dictitem.DictitemVO;
import com.gmcc.pboss.business.base.operator.OperatorVO;
import com.gmcc.pboss.business.channel.cntycompany.CntycompanyDBParam;
import com.gmcc.pboss.business.channel.cntycompany.CntycompanyVO;
import com.gmcc.pboss.business.channel.way.WayDBParam;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.resource.comcategoryrela.ComcategoryrelaDBParam;
import com.gmcc.pboss.business.resource.resalarminfo.ResalarminfoVO;
import com.gmcc.pboss.business.resource.resalarmrule.ResalarmruleDBParam;
import com.gmcc.pboss.business.resource.resalarmrule.ResalarmruleVO;
import com.gmcc.pboss.business.resource.stkalarmct.StkalarmctDBParam;
import com.gmcc.pboss.business.resource.stkalarmct.StkalarmctVO;
import com.gmcc.pboss.business.sales.bgbusiness.HandlerCountyVO;
import com.gmcc.pboss.business.sales.bgbusiness.SMPCountyBrandVO;
import com.gmcc.pboss.business.sales.comorder.ComorderConstant;
import com.gmcc.pboss.business.sales.orderuplimit.OrderuplimitDBParam;
import com.gmcc.pboss.business.sales.orderuplimit.OrderuplimitVO;
import com.gmcc.pboss.business.sales.stockalarm.StockalarmVO;
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
import com.gmcc.pboss.control.channel.cntycompany.Cntycompany;
import com.gmcc.pboss.control.channel.cntycompany.CntycompanyBO;
import com.gmcc.pboss.control.channel.waitreq.Waitreq;
import com.gmcc.pboss.control.channel.waitreq.WaitreqBO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.communication.pendingtask.Pendingtask;
import com.gmcc.pboss.control.communication.pendingtask.PendingtaskBO;
import com.gmcc.pboss.control.resource.comcategoryrela.Comcategoryrela;
import com.gmcc.pboss.control.resource.comcategoryrela.ComcategoryrelaBO;
import com.gmcc.pboss.control.resource.comrescard.Comrescard;
import com.gmcc.pboss.control.resource.comrescard.ComrescardBO;
import com.gmcc.pboss.control.resource.comressmp.Comressmp;
import com.gmcc.pboss.control.resource.comressmp.ComressmpBO;
import com.gmcc.pboss.control.resource.resalarminfo.Resalarminfo;
import com.gmcc.pboss.control.resource.resalarminfo.ResalarminfoBO;
import com.gmcc.pboss.control.resource.resalarmrule.Resalarmrule;
import com.gmcc.pboss.control.resource.resalarmrule.ResalarmruleBO;
import com.gmcc.pboss.control.resource.stkalarmct.Stkalarmct;
import com.gmcc.pboss.control.resource.stkalarmct.StkalarmctBO;
import com.gmcc.pboss.control.sales.orderuplimit.Orderuplimit;
import com.gmcc.pboss.control.sales.orderuplimit.OrderuplimitBO;
import com.gmcc.pboss.control.sales.partnerres.Partnerres;
import com.gmcc.pboss.control.sales.partnerres.PartnerresBO;
import com.gmcc.pboss.control.sales.stockalarm.Stockalarm;
import com.gmcc.pboss.control.sales.stockalarm.StockalarmBO;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.common.utils.lang.TimeUtils;
import com.sunrise.jop.exception.BusinessException;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.gmcc.pboss.control.sales.wayassistant.Wayassistant;
import com.gmcc.pboss.control.sales.wayassistant.WayassistantBO;
import com.gmcc.pboss.control.sales.stockalarm.Stockalarm;
import com.gmcc.pboss.control.sales.stockalarm.StockalarmBO;
import com.gmcc.pboss.business.sales.stockalarm.StockalarmDBParam;

public class ResStockAlarmBO extends AbstractControlBean implements
		ResStockAlarm {

	private static Logger log = Logger.getLogger(ResStockAlarmBO.class);

	public void doProcess() throws Exception {
		
		log.info("==============================ResStockAlarm Begin==============================");
		Sysparam spBo = (SysparamBO) BOFactory.build(SysparamBO.class, user);
		String paramValue = spBo.doFindByID(55L, "pboss_fx");
		if (StringUtils.isEmpty(paramValue)
				|| (!"0".equals(paramValue) && !"1".equals(paramValue))) {
			throw new BusinessException(
					"ϵͳ����[systemid=55,ParamType=pboss_fx]��ֵ����Ϊ�գ��ұ���Ϊ0��1");
		}
		//Ԥ�����ģʽ
		if ("0".equals(paramValue)) {
			//1) ��ȡĿ�������������ۡ��Ѽ��
			int targetDay = this.getTargetDay();
			//2) ��Դ�������
			Map<String, String> comCateAndResType = this.loadComCateAndResType();
			//4) ��Դ���Ԥ��
			Map<HandlerCountyVO, String> resStockAlarmMap = this.resStockAlarm(
					user.getCityid(), targetDay, comCateAndResType);
			//5) ����Ԥ��֪ͨ
			this.sendAlarmNotice(resStockAlarmMap);
		} 
		//ʵ�ʶ�����ģʽ
		else if ("1".equals(paramValue)) {
			//20110705 ʷ�����޸�
			this.realBookAmountMode();
		}
		log.info("==============================ResStockAlarm End==============================");
	}
	
	//ʵ�ʶ�����ģʽ
	private void realBookAmountMode() throws Exception {
		// 1.��ȡ�ֹ�˾��������
		// 2.��ȡƷ�ƻ�������
		// �������Բ�����ʽ��ϳ�һ��Map, ����Keyװ��"�ֹ�˾��Ʒ��VO",ValueĬ��ȡ0
		//long step1 = System.currentTimeMillis();
		Map<SMPCountyBrandVO, Long> countyBrandBaseData = this.getCountyBrandBaseData(user.getCityid());
		//long step2 = System.currentTimeMillis();
		//System.out.println("��ȡ�ֹ�˾-Ʒ�������ʱ:"+(step2-step1));
		
		// 3.��ȡϵͳ������Ҫ������־�����������ֵ��
		Sysparam spBo = (SysparamBO) BOFactory.build(SysparamBO.class, user);
		//Ԥ�����������
		String alarmReceivedStockDays = spBo.doFindByID(65L, "pboss_fx");
		if (StringUtils.isEmpty(alarmReceivedStockDays)) {// || !PublicUtils.isInteger(alarmReceiveComDays)
			//throw new BusinessException("\"�ֿ��Ԥ�����������\"��ֵ����Ϊ��,�ұ���Ϊ����");
			alarmReceivedStockDays = "7";
		}
		log.info("\"�ֿ��Ԥ�����������\"��ֵΪ"+alarmReceivedStockDays);
		//���Ԥ�����
		String stockAlarmInterval = spBo.doFindByID(57L, "pboss_fx");
		if (StringUtils.isEmpty(stockAlarmInterval)) {//|| !PublicUtils.isInteger(stockAlarmInterval)
			//throw new BusinessException("\"�ֹ�˾���Ԥ�����\"��ֵ����Ϊ��,�ұ���Ϊ����");
			stockAlarmInterval = "0";
		}
		log.info("\"�ֹ�˾���Ԥ�����\"��ֵΪ"+stockAlarmInterval);
		//Ԥ����ɫ
		String roleid_paramVale = spBo.doFindByID(56L, "pboss_fx");
		if (StringUtils.isEmpty(roleid_paramVale)) {
			//throw new BusinessException("ϵͳ����[systemid=56,ParamType=pboss_fx]��ֵ����Ϊ��");
			roleid_paramVale = "";
			log.info("\"�ֹ�˾���Ԥ����ɫ\"��ֵΪ��");
		}else{
			log.info("\"�ֹ�˾���Ԥ����ɫ\"��ֵΪ"+roleid_paramVale);
		}		
		//Ԥ�����ŷ���ʱ��
		String smsSenttimeStr = spBo.doFindByID(58L, "pboss_fx");
		if (StringUtils.isEmpty(smsSenttimeStr)) {
			//throw new BusinessException("ϵͳ����\"���ŷ���֪ͨʱ��\"[systemid=58,ParamType=pboss_fx]��ֵ����Ϊ��");
			smsSenttimeStr = "";
			log.info("\"������̨����֪ͨʱ��\"��ֵΪ��");
		}else{
			log.info("\"������̨����֪ͨʱ��\"��ֵΪ"+smsSenttimeStr);
		}		
		//long step3 = System.currentTimeMillis();
		//System.out.println("��ȡ�Ĵ�ϵͳ������ʱ:"+(step3-step2));
		
		// 4.��ȡ����ʵ�ʿ��   -�����ֹ�˾������Ʒ�ơ�ͳ������ʵ�ʿ��������δ������׿�������
		Map<SMPCountyBrandVO, Long> countyActualStockAmount = 
			this.getCountyActualStockAmount(0,ComorderConstant.RESTYPE_SMP, countyBrandBaseData);
		//long step4 = System.currentTimeMillis();
		//System.out.println("��ȡ����ʵ�ʿ����ʱ:"+(step4-step3));
		
		// 5.��ȡ���������
		Map<SMPCountyBrandVO, Long[]> countyStockUpLimit = this.getCountyStockUpLimit(countyBrandBaseData);
		//long step5 = System.currentTimeMillis();
		//System.out.println("��ȡ�����������ʱ:"+(step5-step4));
		
		// 6.��ȡ�ֿ����
		Map<SMPCountyBrandVO, Long> countyStockAmount =	this.getCountyStockAmout(countyBrandBaseData);
		//long step6 = System.currentTimeMillis();
		//System.out.println("��ȡ�ֿ������ʱ:"+(step6-step5));
		
		// 7.��ȡǰN�������
		Map<SMPCountyBrandVO, Long> countyReceivedStockAmount = 
			this.getCountyReceivedStockAmount(Integer.parseInt(alarmReceivedStockDays), 
					ComorderConstant.RESTYPE_SMP, countyBrandBaseData);
		//long step7 = System.currentTimeMillis();
		//System.out.println("��ȡǰN���������ʱ:"+(step7-step6));
		
		// 8.�������Ԥ������
		Map<SMPCountyBrandVO, Long> alarmMap = creatStkalarmmct(alarmReceivedStockDays,//Ԥ�����������
				stockAlarmInterval,//���Ԥ�����
				roleid_paramVale,//Ԥ����ɫ
				smsSenttimeStr,//Ԥ�����ŷ���ʱ��
				countyBrandBaseData,//2.�ֹ�˾-Ʒ�����
				countyActualStockAmount,//4.����ʵ�ʿ��
				countyStockUpLimit,//5.���������
				countyStockAmount,//6.�ֿ����
				countyReceivedStockAmount);//7.ǰN�������
		//long step8 = System.currentTimeMillis();
		//System.out.println("�������Ԥ��������ʱ:"+(step8-step7));
		
		// ����Ԥ����Ϣ�����ڷ��Ͷ�Ϣ��д����
		Object[] alarmInfo = this.getAlarmInfo(alarmMap);
		//long step9 = System.currentTimeMillis();
		//System.out.println("����Ԥ����Ϣ��ʱ:"+(step9-step8));
		
		// 10.
		//��ȡϵͳ������ָ����ɫ��Ӧ�ġ�����[OPERID]��������ϵ�绰CONTACTPHONE]��
		//key-operid,value-contactphone
		Map<String, String> smsRecieverInfo = this.getSMSRecieverInfo(roleid_paramVale);
		//long step10 = System.currentTimeMillis();
		//System.out.println("��ȡϵͳ������ָ����ɫ��Ӧ�Ĺ���-��ϵ�绰��ʱ:"+(step10-step9));
				
		// 11.���Ͷ��š�д����
		if (!StringUtils.isEmpty((String)alarmInfo[0])) {
			this.sendCountyAlarmNotice(smsSenttimeStr,(String)alarmInfo[0],smsRecieverInfo);
		}
		if (((Set<String>)alarmInfo[1]).size() > 0) {
			this.writePendingTask(smsRecieverInfo,(Set<String>)alarmInfo[1]);
		}
		//long step11 = System.currentTimeMillis();
		//System.out.println("���Ͷ��š�д������ʱ:"+(step11-step10));
	}
	
	/**
	 * 1,2.��ȡ�ֹ�˾��Ʒ�ƻ�׼���ݣ����������Բ�����ʽ��ϳ�һ��Map, ����Keyװ��"�ֹ�˾��Ʒ��VO",ValueĬ��ȡ0
	 * 
	 * @param cityid
	 * @return
	 * @throws Exception
	 */
	private Map<SMPCountyBrandVO, Long> getCountyBrandBaseData(String cityid)
			throws Exception {
		Cntycompany cntyBO = (Cntycompany) BOFactory.build(CntycompanyBO.class,
				user);
		CntycompanyDBParam cntyParams = new CntycompanyDBParam();
		cntyParams.set_se_citycompid(cityid);
		cntyParams.set_pagesize("0");
		cntyParams.setDataOnly(true);
		DataPackage cntyDP = cntyBO.doQuery(cntyParams);
		List<CntycompanyVO> cntyList = cntyDP.getDatas();
		//System.out.println("�ֹ�˾����"+cntyList.size()+",�ֱ�Ϊ"+cntyList.toString());
		//System.out.println("�ֹ�˾����"+cntyList.size());
		
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
		//System.out.println("Ʒ�Ƹ���Ϊ"+brands.length);
		Map<SMPCountyBrandVO, Long> result = new HashMap<SMPCountyBrandVO, Long>();
		// ���ֹ�˾������Ʒ�Ƽ��Ͻ������
		for (CntycompanyVO cntyVO : cntyList) {
			String countyid = cntyVO.getCountycompid();
			for (int j = 0; j < brands.length; j++) {
				String brand = brands[j];
				SMPCountyBrandVO scbVO = new SMPCountyBrandVO(countyid, brand);
				result.put(scbVO, 0L);
			}
		}
		//System.out.println("�ֹ�˾-Ʒ����ϸ���:"+result.size());
		return result;
	}
	
	/**
	 * 2.��ȡ��Ʒ�Ʊ��뼰����
	 * 
	 * @return
	 * @throws Exception
	 */
	private Map<String, String> getBrandCodeAndName() throws Exception {

		Map<String, String> result = new HashMap<String, String>();
		Dictitem diBO = (Dictitem) BOFactory.build(DictitemBO.class, user);
		DictitemDBParam diParams = new DictitemDBParam();
		diParams.set_se_groupid("FX_SMPBRAND");
		diParams.set_sne_dictid("AllBrand");
		diParams.set_pagesize("0");
		diParams.setDataOnly(true);
		DataPackage diDP = diBO.doQuery(diParams);
		List<DictitemVO> diList = diDP.getDatas();
		for (DictitemVO diVO : diList) {
			result.put(diVO.getDictid(), diVO.getDictname());
		}
		return result;
	}
	
	/**
	 * 4.��ȡ�ֹ�˾�����Ʒ����ʵ�ʿ��,��Ӧָ���ֹ�˾ָ��Ʒ��������ʱĬ��ȡ��
	 * 
	 * @param isactive
	 * @param restype
	 * @param countyBrandBaseData
	 * @return
	 * @throws Exception
	 */
	private Map<SMPCountyBrandVO, Long> getCountyActualStockAmount(
			int isactive, String restype,
			Map<SMPCountyBrandVO, Long> countyBrandBaseData) throws Exception {

		Partnerres prsBO = (Partnerres) BOFactory.build(PartnerresBO.class,user);
		DataPackage dp = prsBO.doStatCountyQty(isactive, restype);
		List list = dp.getDatas();
		//System.out.println("��ȡ�ֹ�˾����ʵ�ʿ��,��ѯ����¼"+list.size()+"��");
		Map<SMPCountyBrandVO, Long> countyActualStockAmount = new HashMap<SMPCountyBrandVO, Long>();
		Map<SMPCountyBrandVO, Long> result = new HashMap<SMPCountyBrandVO, Long>();
		// ���ƻ�������
		result.putAll(countyBrandBaseData);

		for (int i = 0; i < list.size(); i++) {
			Map data = (Map) list.get(i);
			String countyid = (String) data.get("countyid");
			String brand = (String) data.get("brand");
			Long actualStockAmount = Long.parseLong((String) data.get("Qty"));
			SMPCountyBrandVO scbVO = new SMPCountyBrandVO(countyid, brand);
			countyActualStockAmount.put(scbVO, actualStockAmount);
		}
		result.putAll(countyActualStockAmount);
		//System.out.println("��ȡ�ֹ�˾����ʵ�ʿ��,�ֹ�˾-Ʒ�ƿ��������"+result.size()+"��");
		return result;
	}
	
	/**
	 *  5.��ȡ���������
	 * @param countyBrandBaseData
	 * @return
	 * @throws Exception
	 */
	private Map<SMPCountyBrandVO, Long[]> getCountyStockUpLimit(Map<SMPCountyBrandVO, Long> countyBrandBaseData) throws Exception {
		//��ȡ�����б�
		Wayassistant wsBO = (Wayassistant)BOFactory.build(WayassistantBO.class, user);
		DataPackage dp = wsBO.doQueryCanorder();
		List list = dp.getDatas();
		//System.out.println("��ȡ���������,�ɶ����������"+list.size());
		Map<SMPCountyBrandVO, Long[]> countyStockUpLimit = new HashMap<SMPCountyBrandVO, Long[]>();
		//int i=0;//������Ԥ�����ñ�(FX_RU_STOCKALARM)�ۼƼ�¼
		//int j=0;//�������������ñ�FX_RU_ORDERUPLIMIT���ۼƼ�¼
		for(Iterator it=list.iterator();it.hasNext();){
			//WayVO way = (WayVO)it.next();
			Map wayinfo = (Map)it.next();
			String wayid = (String)wayinfo.get("wayid");
			String cityid = (String)wayinfo.get("cityid");
			String countyid = (String)wayinfo.get("countyid");
			Long starlevel = (Long)wayinfo.get("starlevel");
			//���ݺ����̱����ѯ������Ԥ�����ñ�(FX_RU_STOCKALARM)
			Stockalarm stockalarm = (Stockalarm)BOFactory.build(StockalarmBO.class, user);
			StockalarmDBParam asparam = new StockalarmDBParam();
			asparam.set_se_wayid(wayid);			
			asparam.setDataOnly(true);
			asparam.set_pagesize("0");
			List stockalarmlist = stockalarm.doQuery(asparam).getDatas();
			//key-brand,value-StockalarmVO
			Map<String,StockalarmVO> stockalarmmap = new HashMap<String,StockalarmVO>();
			if(stockalarmlist.size()>0){
				//i += stockalarmlist.size();
				for(Iterator iter=stockalarmlist.iterator();iter.hasNext();){
					StockalarmVO saVO = (StockalarmVO)iter.next();
						stockalarmmap.put(saVO.getBrand(), saVO);					
				}
			}
			
			//���ݵ��б�ʶ���ֹ�˾�����ع�˾��ʶCOUNTYID�����Ǽ���Լ��ģʽ��Ĭ��ȡԤ�����ģʽ��
			//��ѯ�������������ñ�FX_RU_ORDERUPLIMIT��	
			List uplimitlist = null;
			//�ֹ�˾���Ǽ�����Ϊ������в�ѯ
			if(!StringUtils.isEmpty(countyid) && starlevel!=null){
				Orderuplimit orderuplimit = (Orderuplimit)BOFactory.build(OrderuplimitBO.class, user);
				OrderuplimitDBParam ulparam = new OrderuplimitDBParam();
				ulparam.set_se_cityid(cityid);
				ulparam.set_se_countyid(countyid);
				ulparam.set_ne_starlevel(starlevel.toString());
				ulparam.set_se_limitmode("STOCKALARM");//Ԥ�����ģʽ			
				ulparam.set_pagesize("0");			
				ulparam.setDataOnly(true);
				uplimitlist = orderuplimit.doQuery(ulparam).getDatas();
				//j += uplimitlist.size();				
			}
			else{//�ֹ�˾���Ǽ�Ϊ���򲻽��в�ѯ���������־
				if(StringUtils.isEmpty(countyid)){
					log.info("��ȡ���������:������[��������="+wayid+"]�ķֹ�˾�ֶ�Ϊ��,����ѯ�������������ñ�FX_RU_ORDERUPLIMIT.");
				}
				if(starlevel==null){
					log.info("��ȡ���������:������[��������="+wayid+"]���Ǽ��ֶ�Ϊ��,����ѯ�������������ñ�FX_RU_ORDERUPLIMI.");
				}
			}
			
			
			//��������Ԥ�����ñ����Ѱ������뷵�ؽ��
			for(Iterator italarm=stockalarmlist.iterator();italarm.hasNext();){
				StockalarmVO saVo = (StockalarmVO)italarm.next();
				SMPCountyBrandVO scb = new SMPCountyBrandVO(countyid,saVo.getBrand());
				Long[] amount = new Long[3];
				amount[0] = saVo.getMaxstock();//��ɫԤ��
				String[] alarmvalues = saVo.getAlarmvalue().split(";");
				if(alarmvalues.length!=2){
					throw new Exception("������Ԥ�����ñ�(FX_RU_STOCKALARM)�졢��Ԥ���ֶθ�ʽ����");
				}
				String[] redalarm = alarmvalues[0].split(":");
				String[] yellowalarm = alarmvalues[1].split(":");
				amount[1] = Long.parseLong(redalarm[1]);//��ɫԤ��
				amount[2] = Long.parseLong(yellowalarm[1]);//��ɫԤ��
				if(!countyStockUpLimit.containsKey(scb)){//��Ӧ�ֹ�˾��Ʒ�Ʋ�����
					countyStockUpLimit.put(scb, amount);
				}else{//��Ӧ�ֹ�˾��Ʒ�ƴ���
					Long[] old = countyStockUpLimit.get(scb);
					old[0] += amount[0];
					old[1] += amount[1];
					old[2] += amount[2];
					countyStockUpLimit.put(scb, old);
				}				
			}
			//���������������ñ�Ĳ�ѯ������뷵�ؽ��
			//�����ӦBrand���������-������Ԥ�����ñ�-��ѯ����д���������ٴ���
			//��ѯ�������������ñ�(FX_RU_ORDERUPLIMIT)�����Ϊ��
			if(uplimitlist!=null){
				for(Iterator ituplimit=uplimitlist.iterator();ituplimit.hasNext();){
					OrderuplimitVO ulVo = (OrderuplimitVO)ituplimit.next();
					//��ӦƷ����Ϣ��������Ԥ�����ñ�(FX_RU_STOCKALARM)��ѯʱûҪ��ؼ�¼
					if(!stockalarmmap.containsKey(ulVo.getBrand())){
						SMPCountyBrandVO scb = new SMPCountyBrandVO(countyid,ulVo.getBrand());
						Long[] amount = new Long[3];
						amount[0] = ulVo.getMaxstock();//��ɫԤ��
						String[] alarmvalues = ulVo.getAlarmvalue().split(";");
						if(alarmvalues.length!=2){
							throw new Exception("������Ԥ�����ñ�(FX_RU_STOCKALARM)�졢��Ԥ���ֶθ�ʽ����");
						}
						String[] redalarm = alarmvalues[0].split(":");
						String[] yellowalarm = alarmvalues[1].split(":");
						amount[1] = Long.parseLong(redalarm[1]);//��ɫԤ��
						amount[2] = Long.parseLong(yellowalarm[1]);//��ɫԤ��
						if(!countyStockUpLimit.containsKey(scb)){//��Ӧ�ֹ�˾��Ʒ�Ʋ�����
							countyStockUpLimit.put(scb, amount);
						}else{//��Ӧ�ֹ�˾��Ʒ�ƴ���
							Long[] old = countyStockUpLimit.get(scb);
							old[0] += amount[0];
							old[1] += amount[1];
							old[2] += amount[2];
							countyStockUpLimit.put(scb, old);
						}
					}
				}		
			}
				
		}
		
		//int i=0;//������Ԥ�����ñ�(FX_RU_STOCKALARM)�ۼƼ�¼
		//int j=0;//�������������ñ�FX_RU_ORDERUPLIMIT���ۼƼ�¼
		//System.out.println("��ȡ���������,������Ԥ�����ñ�(FX_RU_STOCKALARM)�ۼƼ�¼"+i);
		//System.out.println("��ȡ���������,�������������ñ�FX_RU_ORDERUPLIMIT���ۼƼ�¼"+j);
		//countyBrandBaseData�������зֹ�˾-Ʒ�����
		//������ؽ��������ĳ�ַֹ�˾-Ʒ����ϣ�������뷵�ؽ��Map�У�value����ȡȫ��
		for(Iterator iterator=countyBrandBaseData.keySet().iterator();iterator.hasNext();){
			SMPCountyBrandVO item = (SMPCountyBrandVO)iterator.next();
			if(countyStockUpLimit.containsKey(item)){//����
				continue;
			}
			else{//������
				countyStockUpLimit.put(item, new Long[]{0L,0L,0L});
			}
		}
		//System.out.println("��ȡ���������,�ֹ�˾-Ʒ�������"+countyBrandBaseData.size());
		//System.out.println("��ȡ���������,���ؼ�¼����"+countyStockUpLimit.size());
		return countyStockUpLimit;
	}

	/**
	 * 6.��ȡ�ֿ����
	 * ���ֹ�˾��Ʒ��ͳ��ĳ�ֹ�˾���׿���Դ�ܿ��,��Ӧָ���ֹ�˾ָ��Ʒ��������ʱĬ��ȡ��
	 * 
	 * @param countyBrandBaseData
	 * @return
	 * @throws Exception
	 */
	private Map<SMPCountyBrandVO, Long> getCountyStockAmout(
			Map<SMPCountyBrandVO, Long> countyBrandBaseData) throws Exception {

		Comressmp crsBO = (Comressmp) BOFactory.build(ComressmpBO.class, user);
		DataPackage dp = crsBO.doStatCountyQty();
		List list = dp.getDatas();
		//System.out.println("��ȡ�ֿ����,��ѯ���ݻ�ü�¼����"+list.size());
		Map<SMPCountyBrandVO, Long> result = new HashMap<SMPCountyBrandVO, Long>();
		// ���ƻ�������
		result.putAll(countyBrandBaseData);
		Map<SMPCountyBrandVO, Long> existData = new HashMap<SMPCountyBrandVO, Long>();
		for (int i = 0; list != null && i < list.size(); i++) {
			Map data = (Map) list.get(i);
			String countyid = (String) data.get("countyid");
			String brand = (String) data.get("brand");
			Long stockAmount = Long.parseLong((String) data.get("Qty"));
			SMPCountyBrandVO vo = new SMPCountyBrandVO(countyid, brand);
			existData.put(vo, stockAmount);
		}
		result.putAll(existData);
		//System.out.println("��ȡ�ֿ����,�ֹ�˾-Ʒ�������"+countyBrandBaseData.size());
		//System.out.println("��ȡ�ֿ����,���ؼ�¼����"+result.size());
		return result;
	}	
	
	/**
	 * 7.��ȡǰN�������
	 * @param days �ֿ��Ԥ�����������
	 * @param restype ��Դ���[�׿�����ֵ��],����̨����ʹ���׿�
	 * @param countyBrandBaseData 
	 * @return
	 * @throws Exception
	 */
	private Map<SMPCountyBrandVO, Long> getCountyReceivedStockAmount(
			int days, String restype, 
			Map<SMPCountyBrandVO, Long> countyBrandBaseData) throws Exception {
		Partnerres prsBO = (Partnerres) BOFactory.build(PartnerresBO.class,user);
		DataPackage dp = prsBO.doStatCountyReceivedQty(days, restype);
		List list = dp.getDatas();
		//System.out.println("��ȡǰN�������,��ѯ���ݻ�ü�¼����"+list.size());
		Map<SMPCountyBrandVO, Long> countyReceivedStockAmount = new HashMap<SMPCountyBrandVO, Long>();
		Map<SMPCountyBrandVO, Long> result = new HashMap<SMPCountyBrandVO, Long>();
		// ���ƻ�������
		result.putAll(countyBrandBaseData);

		for (int i = 0; i < list.size(); i++) {
			Map data = (Map) list.get(i);
			String countyid = (String) data.get("countyid");
			String brand = (String) data.get("brand");
			Long actualStockAmount = Long.parseLong((String) data.get("Qty"));
			SMPCountyBrandVO scbVO = new SMPCountyBrandVO(countyid, brand);
			countyReceivedStockAmount.put(scbVO, actualStockAmount);
		}
		result.putAll(countyReceivedStockAmount);
		//System.out.println("��ȡǰN�������,�ֹ�˾-Ʒ�������"+countyBrandBaseData.size());
		//System.out.println("��ȡǰN�������,���ؼ�¼����"+result.size());
		return result;
	}

	
	// 8.�������Ԥ������
	private  Map<SMPCountyBrandVO, Long> creatStkalarmmct(String alarmReceivedStockDays,//Ԥ�����������
			String stockAlarmInterval,//���Ԥ�����
			String roleid_paramVale,//Ԥ����ɫ
			String smsSenttimeStr,//Ԥ�����ŷ���ʱ��
			Map<SMPCountyBrandVO, Long> countyBrandBaseData,//2.�ֹ�˾-Ʒ�����
			Map<SMPCountyBrandVO, Long> countyActualStockAmount,//4.����ʵ�ʿ��
			Map<SMPCountyBrandVO, Long[]> countyStockUpLimit,//5.���������
			Map<SMPCountyBrandVO, Long> countyStockAmount,//6.�ֿ����
			Map<SMPCountyBrandVO, Long> countyReceivedStockAmount) throws Exception{//7.ǰN�������
		Map<SMPCountyBrandVO, Long> alarmMap = new HashMap<SMPCountyBrandVO, Long>();
		StkalarmctVO stkVO = null;
		Stkalarmct stkalarmmct = (Stkalarmct)BOFactory.build(StkalarmctBO.class, user);
		//int i=0;//�����¼����
		for(Iterator<SMPCountyBrandVO> it=countyBrandBaseData.keySet().iterator();it.hasNext();){
			try{				
				SMPCountyBrandVO scbVO = it.next();
				/*
				 *  ͳ������ȡ��ǰϵͳʱ�䣬�ֹ�˾��Ʒ�ơ��ֿ����������ʵ�ʿ�桢������ɫ��桢�����ɫ��桢
				 *  �����ɫ��桢�����ȡ��һ����ȡ���ݣ���ɫȱ��ȡ�ֿ��������������ɫ��棭����ʵ�ʿ�棩��
				 *  ��ɫȱ��ȡ�ֿ�������������ɫ��棭����ʵ�ʿ�棩��
				 *  ��ɫȱ��ȡ�ֿ�������������ɫ��棭����ʵ�ʿ�棩��֧������ȡ�ֿ����/�������/N����
				 *  �Ƿ�Ԥ������ɫȱ��<0ȡ�ǣ�����ȡ�񣩣��Ƿ�֪ͨ���ա�
				 */
				stkVO = new StkalarmctVO();	
				stkVO.setStatdate(new Date());
				stkVO.setCountyid(scbVO.getCountyid());
				stkVO.setBrand(scbVO.getBrand());
				Long kcamount = countyStockAmount.get(scbVO);//�ֿ����
				stkVO.setKcamount(kcamount);
				Long realstock = countyActualStockAmount.get(scbVO);//����ʵ�ʿ��
				stkVO.setRealstock(realstock);
				Long[] coloralarm = countyStockUpLimit.get(scbVO);//��ɫ����ɫ����ɫ���
				stkVO.setGreenstock(coloralarm[0]);
				stkVO.setRedstock(coloralarm[1]);
				stkVO.setYellowstock(coloralarm[2]);
				Long saleamt = countyReceivedStockAmount.get(scbVO);//�����
				stkVO.setSaleamt(saleamt);
				long greenGap = kcamount-(coloralarm[0]-realstock);//��ɫȱ��
				stkVO.setGreengap(greenGap);//��ɫȱ��
				stkVO.setRedgap(kcamount-(coloralarm[1]-realstock));//��ɫȱ��
				stkVO.setYellowgap(kcamount-(coloralarm[2]-realstock));//��ɫȱ��
				if(saleamt>0){
					stkVO.setSupportday(kcamount*Long.parseLong(alarmReceivedStockDays)/saleamt);
				}else{
					stkVO.setSupportday(0L);
					log.info("����["+scbVO.getCountyid()+","+scbVO.getBrand()+"]ʱ,ǰ"+alarmReceivedStockDays+"�������Ϊ��,��֧��������Ϊ��.");
				}
				//��ɫȱ��С����ʱ��ҪԤ��
				stkVO.setIsalarm(greenGap<0?"1":"0");
				stkalarmmct.doCreate(stkVO);//��Ԥ�����ݱ��浽���ݿ�
				
				//��ɫȱ�ڲ�С����ʱ������Ԥ�������ش�����һ��
				if(greenGap>=0){
					log.info("����["+scbVO.getCountyid()+","+scbVO.getBrand()+"],��ɫȱ�ڲ�С����,����Ԥ��");
					continue;
				}				
				//Ԥ����ɫΪ�գ������־���أ�������һ��
				if("".equals(roleid_paramVale)){
					log.info("����["+scbVO.getCountyid()+","+scbVO.getBrand()+"]����,�ֹ�˾���Ԥ����ɫΪ��");
					continue;
				}
				//Ԥ�����ŷ���ʱ��Ϊ��,�����־��������һ��
				if("".equals(smsSenttimeStr)){
					log.info("����["+scbVO.getCountyid()+","+scbVO.getBrand()+"]����,Ԥ�����ŷ���ʱ��Ϊ��");
					continue;
				}
				//�ֹ�˾���Ԥ�����Ϊ��
				if("0".equals(stockAlarmInterval)){
					stkVO.setIsnotice("1");
				}
				else{//���ݡ��ֹ�˾���Ԥ�������,��ѯ֮ǰ�Ƿ��ѷ���֪ͨ
					//��������ݣ����������������־��������һ��
					boolean isNeedAlarm = this.checkIsNeedAlarm(stockAlarmInterval, scbVO);
					if(isNeedAlarm){
						stkVO.setIsnotice("1");
					}else{
						log.info("����["+scbVO.getCountyid()+","+scbVO.getBrand()+"],�����Ѵ���,����Ҫ�ٴ�Ԥ��");
						continue;
					}
				}
				//i++;
				stkalarmmct.doUpdate(stkVO);
				alarmMap.put(scbVO, stkVO.getKcamount());//��¼Ԥ����Ϣ�����ڶ��ŷ��ͺ�д����
			}
			catch (Exception ex) {
				LoggerUtils.error(ex, log);
			}
		}
		//System.out.println("�������Ԥ������,�����¼����"+i);
		//System.out.println("�������Ԥ������,���ؽ������(���ڶ��ŷ��ͺ�д����)"+alarmMap.size());
		return alarmMap;
	}
	
	//���ݡ��ֹ�˾���Ԥ�������,��ѯ֮ǰN���Ƿ��ѷ���Ԥ��,��ȷ���Ƿ���ҪԤ��
	private boolean checkIsNeedAlarm(String stockAlarmInterval, SMPCountyBrandVO scbVO) throws Exception{
		Stkalarmct sacBO = (Stkalarmct) BOFactory.build(StkalarmctBO.class,user);
		Date[] stockAlarmPeriod = PublicUtils.getDatePeriod(new Date(), Integer
				.parseInt(stockAlarmInterval), true);
		try{
			StkalarmctDBParam sacParams = new StkalarmctDBParam();
			sacParams.set_se_countyid(scbVO.getCountyid());
			sacParams.set_se_brand(scbVO.getBrand());
			sacParams.set_se_isalarm("1");
			sacParams.set_se_isnotice("1");
			sacParams.set_dnl_statdate(PublicUtils.formatUtilDate(stockAlarmPeriod[0], "yyyy-MM-dd HH:mm:ss"));
			sacParams.set_dnm_statdate(PublicUtils.formatUtilDate(stockAlarmPeriod[1], "yyyy-MM-dd HH:mm:ss"));
			sacParams.set_pagesize("0");
			//sacParams.setDataOnly(true);
			sacParams.setCountOnly(true);
			DataPackage dp = sacBO.doQuery(sacParams);
			if(dp.getRowCount()>0){//dp.getDatas().size()>0
				return false;
			}else{
				return true;
			}
		}catch(Exception e){
			LoggerUtils.error(e, log);
		}
		return true;//������ݲ�ѯ�����쳣����Ĭ��Ϊ�棬��ҪԤ��
	}
	
	//����Ԥ����Ϣ�����ڷ��Ͷ��ź�д����
	private Object[] getAlarmInfo(Map<SMPCountyBrandVO, Long> alarmMap) throws Exception {
		Cntycompany cntyBO = (Cntycompany) BOFactory.build(CntycompanyBO.class,	user);
		Object[] result = new Object[2];
		StringBuffer stkAlarmInfo_sb = new StringBuffer("");
		Set<String> countys_set = new HashSet<String>();
		//key-countyName,value-Ԥ����Ϣ
		Map<String,String> count_alarmInfo = new HashMap<String,String>();

		Map<String, String> brandCodeName = this.getBrandCodeAndName();
		Map<String, String> countyCodeName = new HashMap<String,String>();

		for (Iterator<SMPCountyBrandVO> it = alarmMap.keySet().iterator(); it.hasNext();) {
			try {
				SMPCountyBrandVO scbVO = it.next();
				String brandName = brandCodeName.containsKey(scbVO
					.getBrand()) ? brandCodeName.get(scbVO.getBrand()) : scbVO.getBrand();
								
				if(!countyCodeName.containsKey(scbVO.getCountyid())) {
					CntycompanyVO cntyVO = cntyBO.doFindByPk(scbVO.getCountyid());
					String countycompname = !StringUtils.isEmpty(cntyVO
						.getCountycompname()) ? cntyVO.getCountycompname() : cntyVO.getCountycompid(); 
									
					countyCodeName.put(scbVO.getCountyid(), countycompname);
				}
				String countyName = countyCodeName.get(scbVO.getCountyid());
				if(count_alarmInfo.containsKey(countyName)){//Ԥ����Ϣ�а�����ǰ����ķֹ�˾
					StringBuffer info =  new StringBuffer(count_alarmInfo.get(countyName));
					info.append(",").append(brandName).append(alarmMap.get(scbVO));
					count_alarmInfo.put(countyName, info.toString());
				}
				else{//Ԥ����Ϣ�в�������ǰ����ķֹ�˾
					count_alarmInfo.put(countyName, brandName+alarmMap.get(scbVO));
				}
				//stkAlarmInfo_sb.append(countyName).append(",")
				//	.append(brandName).append(",").append(
				//	alarmMap.get(scbVO)).append(";");

				countys_set.add(countyName);
			}catch (Exception ex) {
				LoggerUtils.error(ex, log);
			}
		}
		
		for(Iterator<String> it = count_alarmInfo.keySet().iterator();it.hasNext();){
			String countName = it.next();
			stkAlarmInfo_sb.append(countName).append(":").append(count_alarmInfo.get(countName)).append(";");
		}
		result[0] = stkAlarmInfo_sb.toString();
		result[1] = countys_set;
		return result;
	}
	
	/**
	 * 10.
	 * ��ȡϵͳ������ָ����ɫ��Ӧ�ġ�����[OPERID]��������ϵ�绰CONTACTPHONE]��
	 * 
	 * @return
	 * @throws Exception
	 */
	private Map<String, String> getSMSRecieverInfo(String roleid)
			throws Exception {

		Operrole orBO = (Operrole) BOFactory.build(OperroleBO.class, user);
		List<OperatorVO> oplist = orBO.getOperatorsByRoleId(roleid);
		if (oplist.size() <= 0) {
			throw new BusinessException("û�����ɫ���� [" + roleid + "] ��Ӧ�Ĳ���Ա");
		}
		Map<String, String> smsRecieverInfo = new HashMap<String, String>();
		for (OperatorVO opVO : oplist) {
			smsRecieverInfo.put(opVO.getOperid(), opVO.getContactphone());
		}
		return smsRecieverInfo;
	}
	
	/**
	 *  11.���ͷֹ�˾Ԥ��֪ͨ����
	 * 
	 * @param stkAlarmInfo
	 * @param smsRecieverInfo
	 * @throws Exception
	 */
	private void sendCountyAlarmNotice(String smsSenttimeStr,String stkAlarmInfo,
			Map<String, String> smsRecieverInfo) throws Exception {
		Sysparam spBo = (SysparamBO) BOFactory.build(SysparamBO.class, user);
		Smstmpl smstmplBO = (Smstmpl) BOFactory.build(SmstmplBO.class, user);
		Waitreq waitreqbo = (Waitreq) BOFactory.build(WaitreqBO.class, user);

		String sendno = spBo.doFindByID(7L, "pboss");

		if (StringUtils.isEmpty(sendno)) {
			throw new BusinessException(
					"ϵͳ����\"���ŷ��Ͷ˿�\"[systemid=7,ParamType=pboss]��ֵ����Ϊ��");
		}
		
		//String smsSenttimeStr = spBo.doFindByID(58L, "pboss_fx");
		//if (StringUtils.isEmpty(smsSenttimeStr)) {
		//	throw new BusinessException(
		//			"ϵͳ����\"���ŷ���֪ͨʱ��\"[systemid=58,ParamType=pboss_fx]��ֵ����Ϊ��");
		//}
		String date1 = PublicUtils.formatUtilDate(new Date(), "yyyy-MM-dd");
		String date2 = date1 + " " + smsSenttimeStr;
		Date senttime = PublicUtils.UtilStrToDate(date2, "yyyy-MM-dd HH:mm");

		Map<String, String> replaceKeyValueMap = new HashMap<String, String>();
		replaceKeyValueMap.put("STOCKINFO", stkAlarmInfo);
		String content = smstmplBO.doGenSMS("FX_CTSTOCK_ALARM",
				replaceKeyValueMap);

		Collection<String> recNoCol = smsRecieverInfo.values();
		for (Iterator<String> it = recNoCol.iterator(); it.hasNext();) {
			String recNo = it.next();
			waitreqbo.doInsert3(new Short("3"), content, sendno, recNo,
					senttime);
		}
	}

	/**
	 * 11.д����
	 * 
	 * @param smsRecieverInfo
	 * @param countys
	 * @throws Exception
	 */
	private void writePendingTask(Map<String, String> smsRecieverInfo,
			Set<String> countySet) throws Exception {

		Pendingtask pendingtaskBO = (Pendingtask) BOFactory.build(
				PendingtaskBO.class, user);
		Set<String> operidSet = smsRecieverInfo.keySet();
		StringBuffer operidsb = new StringBuffer("");
		StringBuffer countysb = new StringBuffer("");
		for (Iterator<String> it = operidSet.iterator(); it.hasNext();) {
			operidsb.append(it.next()).append(",");
		}
		for(String countyname : countySet) {
			countysb.append(countyname).append(",");
		}
		String operids = operidsb.substring(0, operidsb.length() - 1);
		String countys = countysb.substring(0,countysb.length() - 1);
		pendingtaskBO.doCreate("���·ֹ�˾���Ԥ��: [" + countys + "]", "", "7",
				operids, new Short("0"), null, new Date(), null);
	}

	
	/**
	 * 1) ��ȡĿ�������������ۡ��Ѽ��
	 * 
	 * @return
	 * @throws Exception
	 */
	private int getTargetDay() throws Exception {
		Sysparam spBo = (SysparamBO) BOFactory.build(SysparamBO.class, user);
		String paramValue = spBo.doFindByID(47L, "pboss_fx");
		// �����Ϸ��Ա��
		boolean inValid = true;
		if (StringUtils.isEmpty(paramValue)) {
			paramValue = "90";
			inValid = false;
		} else {
			try {
				if (Integer.parseInt(paramValue) < 0) {
					paramValue = "90";
					inValid = false;
				}
			} catch (NumberFormatException ex) {
				paramValue = "90";
				inValid = false;
			}
		}
		if (!inValid)
			log.info("��������ݡ�����ֵΪ�ա�����ֵ���Ǵ��ڵ��������������Ŀ������Ĭ��ȡ90;");
		return Integer.parseInt(paramValue);
	}

	/**
	 * 2) ��Դ�������
	 * 
	 * @return
	 * @throws Exception
	 */
	private Map<String, String> loadComCateAndResType() throws Exception {
		Comcategoryrela ccrBO = (Comcategoryrela) BOFactory.build(
				ComcategoryrelaBO.class, user);
		ComcategoryrelaDBParam ccrParam = new ComcategoryrelaDBParam();
		ccrParam.setSelectFieldsString("comcategory,restype");
		ccrParam.set_pagesize("0");
		DataPackage dp = ccrBO.doLoadComCateAndResType(ccrParam);
		List<Map<String, Object>> list = dp.getDatas();
		Map<String, String> resultMap = new HashMap<String, String>();
		for (Map<String, Object> value : list) {
			String comCategory = (String) value.get("comcategory");
			String restype = (String) value.get("restype");
			resultMap.put(comCategory, restype);
		}
		return resultMap;
	}

	/**
	 * 4) ��Դ���Ԥ��
	 * 
	 * @param cityid
	 * @param targetDay
	 * @param comCateAndResType
	 * @return
	 * @throws Exception
	 */
	private Map<HandlerCountyVO, String> resStockAlarm(String cityid,
			int targetDay, Map<String, String> comCateAndResType)
			throws Exception {

		Resalarmrule rarBO = (Resalarmrule) BOFactory.build(
				ResalarmruleBO.class, user);
		ResalarmruleDBParam param = new ResalarmruleDBParam();
		param.set_se_cityid(cityid);
		param.set_pagesize("0");
		DataPackage dp = rarBO.doQuery(param);
		List<ResalarmruleVO> list = dp.getDatas();
		Map<HandlerCountyVO, String> resStockAlarmMap = new HashMap<HandlerCountyVO, String>();

		// �����Ʒ����ID�����Ӧ��Ʒ�������Ƶ�Map
		Map<String, String> comcateCode2Name = new HashMap<String, String>();
		Dictitem dtBO = (Dictitem) BOFactory.build(DictitemBO.class, user);
		DictitemDBParam dtParam = new DictitemDBParam();
		dtParam.set_se_groupid("IM_FXCOMCATEGORY");
		dtParam.set_pagesize("0");
		DataPackage dtDP = dtBO.doQuery(dtParam);
		List<DictitemVO> dtlist = dtDP.getDatas();
		for (DictitemVO dtVO : dtlist) {
			String comcategoryid = dtVO.getDictid();
			String comcategoryname = dtVO.getDictname();
			comcateCode2Name.put(comcategoryid, comcategoryname);
		}
		for (ResalarmruleVO rarVO : list) {
			try {
				String comcategory = rarVO.getComcategory();
				String countyid = rarVO.getCountyid();
				String handlercode = rarVO.getHandlercode();
				// ���������
				Long lowstock = rarVO.getLowstock();
				// ����������
				Double upactrate = rarVO.getUpactrate();
				String restype = comCateAndResType.get(comcategory);
				// �����
				Integer stockQty = 0;
				// Ԥ���ź�
				String alarmsignal = "";

				if ("COMRESSMP".equalsIgnoreCase(restype)) {

					if (upactrate == null)
						throw new BusinessException("���(RECID) = "
								+ rarVO.getRecid() + " ����Դ���Ԥ������ļ���������Ϊ��,���ʵ",
								null);
					if (lowstock == null)
						throw new BusinessException("���(RECID) = "
								+ rarVO.getRecid() + " ����Դ���Ԥ������Ŀ��������Ϊ��,���ʵ",
								null);
					// �׿�
					Comressmp crsBO = (Comressmp) BOFactory.build(
							ComressmpBO.class, user);
					// (a) ͳ�ƿ����
					stockQty = crsBO.doStatSMPStock(countyid, comcategory);

					Partnerres prBO = (Partnerres) BOFactory.build(
							PartnerresBO.class, user);
					// (b) ͳ����������
					Integer soldQty = prBO.doStatSMPSoldQty(countyid,
							comcategory, targetDay);
					if (soldQty == 0) // �����������Ϊ0���򲻴����������
						continue;
					// (c) ͳ���Ѽ�����
					Integer activeQty = prBO.doStatSMPActiveQty(countyid,
							comcategory, targetDay);
					// (d) �����׿�������
					double smpActiveRate = (double) activeQty
							/ (double) soldQty;

					Resalarminfo raiBO = (Resalarminfo) BOFactory.build(
							ResalarminfoBO.class, user);
					ResalarminfoVO raiVO = new ResalarminfoVO();
					raiVO.setAlarmdate(new Date());
					raiVO.setCountyid(countyid);
					raiVO.setComcategory(comcategory);
					raiVO.setStockamt(stockQty.longValue());
					raiVO.setSaledamt(soldQty.longValue());
					raiVO.setActedamt(activeQty.longValue());
					raiVO.setActrate(smpActiveRate);

					// ��������С�ڵ��ڿ���������Ҽ����ʴ��ڵ��ڼ��������ޣ���Ԥ���ź�ȡ��ɫ������ȡ��ɫ
					if (stockQty <= lowstock && smpActiveRate >= upactrate) {
						alarmsignal = "RED";
					} else {
						alarmsignal = "GREEN";
					}
					raiVO.setAlarmsignal(alarmsignal);
					raiBO.doCreate(raiVO);
				} else if ("COMRESCARD".equalsIgnoreCase(restype)) {
					// ��ֵ��
					Comrescard cscBO = (Comrescard) BOFactory.build(
							ComrescardBO.class, user);
					stockQty = cscBO.doStatCardStock(countyid, comcategory);
					Resalarminfo raiBO = (Resalarminfo) BOFactory.build(
							ResalarminfoBO.class, user);
					ResalarminfoVO raiVO = new ResalarminfoVO();
					raiVO.setAlarmdate(new Date());
					raiVO.setCountyid(countyid);
					raiVO.setComcategory(comcategory);
					raiVO.setStockamt(stockQty.longValue());
					// ��������С�ڵ��ڿ���������Ҽ����ʴ��ڵ��ڼ��������ޣ���Ԥ���ź�ȡ��ɫ������ȡ��ɫ
					if (stockQty <= lowstock) {
						alarmsignal = "RED";
					} else {
						alarmsignal = "GREEN";
					}
					raiVO.setAlarmsignal(alarmsignal);
					raiBO.doCreate(raiVO);
				}
				if ("RED".equalsIgnoreCase(alarmsignal)) {
					HandlerCountyVO hcVO = new HandlerCountyVO();
					hcVO.setCountyid(countyid);
					hcVO.setHandlerCode(handlercode);
					if (resStockAlarmMap.containsKey(hcVO)) {
						String oldcomcategorySet = resStockAlarmMap.get(hcVO);
						String newcomcategorySet = oldcomcategorySet
								+ comcateCode2Name.get(comcategory) + ",";
						resStockAlarmMap.put(hcVO, newcomcategorySet);
					} else {
						resStockAlarmMap.put(hcVO, comcateCode2Name
								.get(comcategory)
								+ ",");
					}
				}

			} catch (BusinessException ex) {
				log.info(ex.getMessage());
			} catch (Exception ex) {
				LoggerUtils.error(ex, log);
			}
		}
		return resStockAlarmMap;
	}

	/**
	 * 5) ����Ԥ��֪ͨ
	 * 
	 * @param resStockAlarmMap
	 * @throws Exception
	 */
	private void sendAlarmNotice(Map<HandlerCountyVO, String> resStockAlarmMap)
			throws Exception {

		Operator operBO = (Operator) BOFactory.build(OperatorBO.class, user);
		Smstmpl smstmplBO = (Smstmpl) BOFactory.build(SmstmplBO.class, user);
		Cntycompany ccBO = (Cntycompany) BOFactory.build(CntycompanyBO.class,
				user);
		Waitreq wrBO = (Waitreq) BOFactory.build(WaitreqBO.class, user);

		String today = TimeUtils.formatDate(new Date());
		String[] array = today.split("-");
		String year = array[0];
		String month = array[1];
		String day = array[2];

		for (Iterator<HandlerCountyVO> it = resStockAlarmMap.keySet()
				.iterator(); it.hasNext();) {
			try {
				HandlerCountyVO hcVO = it.next();
				String countyid = hcVO.getCountyid();
				CntycompanyVO ccVO = ccBO.doFindByPk(countyid);
				// �ֹ�˾����
				String countyName = ccVO.getCountycompname();
				String handlercode = hcVO.getHandlerCode();
				String comcategoryset = resStockAlarmMap.get(hcVO);
				comcategoryset = comcategoryset.substring(0, comcategoryset
						.length() - 1);
				OperatorVO operVO = operBO.doFindByPk(handlercode);
				// �����ֻ�����
				String recno = operVO.getContactphone();
				Map<String, String> replaceKeyValueMap = new HashMap<String, String>();
				replaceKeyValueMap.put("COUNTYID", countyName);
				replaceKeyValueMap.put("COMCATESET", comcategoryset);
				replaceKeyValueMap.put("YEAR", year);
				replaceKeyValueMap.put("MONTH", month);
				replaceKeyValueMap.put("DAY", day);

				// ��������
				String smscontent = smstmplBO.doGenSMS("IM_STOCKALARM",
						replaceKeyValueMap);
				wrBO.doInsert(Short.valueOf("3"), smscontent, recno);
			} catch (Exception ex) {
				LoggerUtils.error(ex, log);
			}
		}
	}
}