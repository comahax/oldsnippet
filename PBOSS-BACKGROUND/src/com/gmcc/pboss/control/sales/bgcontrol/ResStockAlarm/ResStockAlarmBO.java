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
					"系统参数[systemid=55,ParamType=pboss_fx]的值不能为空，且必须为0或1");
		}
		//预设规则模式
		if ("0".equals(paramValue)) {
			//1) 获取目标天数（已销售、已激活）
			int targetDay = this.getTargetDay();
			//2) 资源类别载入
			Map<String, String> comCateAndResType = this.loadComCateAndResType();
			//4) 资源库存预警
			Map<HandlerCountyVO, String> resStockAlarmMap = this.resStockAlarm(
					user.getCityid(), targetDay, comCateAndResType);
			//5) 发送预警通知
			this.sendAlarmNotice(resStockAlarmMap);
		} 
		//实际订购量模式
		else if ("1".equals(paramValue)) {
			//20110705 史晓龙修改
			this.realBookAmountMode();
		}
		log.info("==============================ResStockAlarm End==============================");
	}
	
	//实际订购量模式
	private void realBookAmountMode() throws Exception {
		// 1.获取分公司基础数据
		// 2.获取品牌基础数据
		// 将二者以并集方式组合成一个Map, 其中Key装载"分公司和品牌VO",Value默认取0
		//long step1 = System.currentTimeMillis();
		Map<SMPCountyBrandVO, Long> countyBrandBaseData = this.getCountyBrandBaseData(user.getCityid());
		//long step2 = System.currentTimeMillis();
		//System.out.println("获取分公司-品牌组合用时:"+(step2-step1));
		
		// 3.获取系统参数（要求在日志中输出各参数值）
		Sysparam spBo = (SysparamBO) BOFactory.build(SysparamBO.class, user);
		//预警领货量天数
		String alarmReceivedStockDays = spBo.doFindByID(65L, "pboss_fx");
		if (StringUtils.isEmpty(alarmReceivedStockDays)) {// || !PublicUtils.isInteger(alarmReceiveComDays)
			//throw new BusinessException("\"分库存预警领货量天数\"的值不能为空,且必须为整数");
			alarmReceivedStockDays = "7";
		}
		log.info("\"分库存预警领货量天数\"的值为"+alarmReceivedStockDays);
		//库存预警间隔
		String stockAlarmInterval = spBo.doFindByID(57L, "pboss_fx");
		if (StringUtils.isEmpty(stockAlarmInterval)) {//|| !PublicUtils.isInteger(stockAlarmInterval)
			//throw new BusinessException("\"分公司库存预警间隔\"的值不能为空,且必须为整数");
			stockAlarmInterval = "0";
		}
		log.info("\"分公司库存预警间隔\"的值为"+stockAlarmInterval);
		//预警角色
		String roleid_paramVale = spBo.doFindByID(56L, "pboss_fx");
		if (StringUtils.isEmpty(roleid_paramVale)) {
			//throw new BusinessException("系统参数[systemid=56,ParamType=pboss_fx]的值不能为空");
			roleid_paramVale = "";
			log.info("\"分公司库存预警角色\"的值为空");
		}else{
			log.info("\"分公司库存预警角色\"的值为"+roleid_paramVale);
		}		
		//预警短信发送时间
		String smsSenttimeStr = spBo.doFindByID(58L, "pboss_fx");
		if (StringUtils.isEmpty(smsSenttimeStr)) {
			//throw new BusinessException("系统参数\"短信发送通知时间\"[systemid=58,ParamType=pboss_fx]的值不能为空");
			smsSenttimeStr = "";
			log.info("\"分销后台短信通知时间\"的值为空");
		}else{
			log.info("\"分销后台短信通知时间\"的值为"+smsSenttimeStr);
		}		
		//long step3 = System.currentTimeMillis();
		//System.out.println("获取四大系统参数用时:"+(step3-step2));
		
		// 4.获取网点实际库存   -按“分公司”、“品牌”统计网点实际库存量（即未激活的套卡数量）
		Map<SMPCountyBrandVO, Long> countyActualStockAmount = 
			this.getCountyActualStockAmount(0,ComorderConstant.RESTYPE_SMP, countyBrandBaseData);
		//long step4 = System.currentTimeMillis();
		//System.out.println("获取网点实际库存用时:"+(step4-step3));
		
		// 5.获取库存量上限
		Map<SMPCountyBrandVO, Long[]> countyStockUpLimit = this.getCountyStockUpLimit(countyBrandBaseData);
		//long step5 = System.currentTimeMillis();
		//System.out.println("获取库存量上限用时:"+(step5-step4));
		
		// 6.获取仓库存量
		Map<SMPCountyBrandVO, Long> countyStockAmount =	this.getCountyStockAmout(countyBrandBaseData);
		//long step6 = System.currentTimeMillis();
		//System.out.println("获取仓库存量用时:"+(step6-step5));
		
		// 7.获取前N天领货量
		Map<SMPCountyBrandVO, Long> countyReceivedStockAmount = 
			this.getCountyReceivedStockAmount(Integer.parseInt(alarmReceivedStockDays), 
					ComorderConstant.RESTYPE_SMP, countyBrandBaseData);
		//long step7 = System.currentTimeMillis();
		//System.out.println("获取前N天领货量用时:"+(step7-step6));
		
		// 8.创建库存预警数据
		Map<SMPCountyBrandVO, Long> alarmMap = creatStkalarmmct(alarmReceivedStockDays,//预警领货量天数
				stockAlarmInterval,//库存预警间隔
				roleid_paramVale,//预警角色
				smsSenttimeStr,//预警短信发送时间
				countyBrandBaseData,//2.分公司-品牌组合
				countyActualStockAmount,//4.网点实际库存
				countyStockUpLimit,//5.库存量上限
				countyStockAmount,//6.仓库存量
				countyReceivedStockAmount);//7.前N天领货量
		//long step8 = System.currentTimeMillis();
		//System.out.println("创建库存预警数据用时:"+(step8-step7));
		
		// 构造预警信息，用于发送短息和写待办
		Object[] alarmInfo = this.getAlarmInfo(alarmMap);
		//long step9 = System.currentTimeMillis();
		//System.out.println("构造预警信息用时:"+(step9-step8));
		
		// 10.
		//获取系统参数中指定角色对应的“工号[OPERID]”及“联系电话CONTACTPHONE]”
		//key-operid,value-contactphone
		Map<String, String> smsRecieverInfo = this.getSMSRecieverInfo(roleid_paramVale);
		//long step10 = System.currentTimeMillis();
		//System.out.println("获取系统参数中指定角色对应的工号-联系电话用时:"+(step10-step9));
				
		// 11.发送短信、写待办
		if (!StringUtils.isEmpty((String)alarmInfo[0])) {
			this.sendCountyAlarmNotice(smsSenttimeStr,(String)alarmInfo[0],smsRecieverInfo);
		}
		if (((Set<String>)alarmInfo[1]).size() > 0) {
			this.writePendingTask(smsRecieverInfo,(Set<String>)alarmInfo[1]);
		}
		//long step11 = System.currentTimeMillis();
		//System.out.println("发送短信、写待办用时:"+(step11-step10));
	}
	
	/**
	 * 1,2.获取分公司和品牌基准数据，并将二者以并集方式组合成一个Map, 其中Key装载"分公司和品牌VO",Value默认取0
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
		//System.out.println("分公司个数"+cntyList.size()+",分别为"+cntyList.toString());
		//System.out.println("分公司个数"+cntyList.size());
		
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
		//System.out.println("品牌个数为"+brands.length);
		Map<SMPCountyBrandVO, Long> result = new HashMap<SMPCountyBrandVO, Long>();
		// 将分公司集合与品牌集合进行组合
		for (CntycompanyVO cntyVO : cntyList) {
			String countyid = cntyVO.getCountycompid();
			for (int j = 0; j < brands.length; j++) {
				String brand = brands[j];
				SMPCountyBrandVO scbVO = new SMPCountyBrandVO(countyid, brand);
				result.put(scbVO, 0L);
			}
		}
		//System.out.println("分公司-品牌组合个数:"+result.size());
		return result;
	}
	
	/**
	 * 2.获取各品牌编码及名称
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
	 * 4.获取分公司网点的品牌总实际库存,对应指定分公司指定品牌无数据时默认取零
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
		//System.out.println("获取分公司网点实际库存,查询到记录"+list.size()+"条");
		Map<SMPCountyBrandVO, Long> countyActualStockAmount = new HashMap<SMPCountyBrandVO, Long>();
		Map<SMPCountyBrandVO, Long> result = new HashMap<SMPCountyBrandVO, Long>();
		// 复制基础数据
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
		//System.out.println("获取分公司网点实际库存,分公司-品牌可能性组合"+result.size()+"条");
		return result;
	}
	
	/**
	 *  5.获取库存量上限
	 * @param countyBrandBaseData
	 * @return
	 * @throws Exception
	 */
	private Map<SMPCountyBrandVO, Long[]> getCountyStockUpLimit(Map<SMPCountyBrandVO, Long> countyBrandBaseData) throws Exception {
		//获取渠道列表
		Wayassistant wsBO = (Wayassistant)BOFactory.build(WayassistantBO.class, user);
		DataPackage dp = wsBO.doQueryCanorder();
		List list = dp.getDatas();
		//System.out.println("获取库存量上限,可订购网点个数"+list.size());
		Map<SMPCountyBrandVO, Long[]> countyStockUpLimit = new HashMap<SMPCountyBrandVO, Long[]>();
		//int i=0;//网点库存预警设置表(FX_RU_STOCKALARM)累计记录
		//int j=0;//订购量上限设置表（FX_RU_ORDERUPLIMIT）累计记录
		for(Iterator it=list.iterator();it.hasNext();){
			//WayVO way = (WayVO)it.next();
			Map wayinfo = (Map)it.next();
			String wayid = (String)wayinfo.get("wayid");
			String cityid = (String)wayinfo.get("cityid");
			String countyid = (String)wayinfo.get("countyid");
			Long starlevel = (Long)wayinfo.get("starlevel");
			//根据合作商编码查询网点库存预警设置表(FX_RU_STOCKALARM)
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
			
			//根据地市标识、分公司（即县公司标识COUNTYID）、星级、约束模式（默认取预警库存模式）
			//查询订购量上限设置表（FX_RU_ORDERUPLIMIT）	
			List uplimitlist = null;
			//分公司和星级均不为空则进行查询
			if(!StringUtils.isEmpty(countyid) && starlevel!=null){
				Orderuplimit orderuplimit = (Orderuplimit)BOFactory.build(OrderuplimitBO.class, user);
				OrderuplimitDBParam ulparam = new OrderuplimitDBParam();
				ulparam.set_se_cityid(cityid);
				ulparam.set_se_countyid(countyid);
				ulparam.set_ne_starlevel(starlevel.toString());
				ulparam.set_se_limitmode("STOCKALARM");//预警库存模式			
				ulparam.set_pagesize("0");			
				ulparam.setDataOnly(true);
				uplimitlist = orderuplimit.doQuery(ulparam).getDatas();
				//j += uplimitlist.size();				
			}
			else{//分公司或星级为空则不进行查询，并输出日志
				if(StringUtils.isEmpty(countyid)){
					log.info("获取库存量上限:因渠道[渠道编码="+wayid+"]的分公司字段为空,不查询订购量上限设置表FX_RU_ORDERUPLIMIT.");
				}
				if(starlevel==null){
					log.info("获取库存量上限:因渠道[渠道编码="+wayid+"]的星级字段为空,不查询订购量上限设置表FX_RU_ORDERUPLIMI.");
				}
			}
			
			
			//将网点库存预警设置表的找寻结果放入返回结果
			for(Iterator italarm=stockalarmlist.iterator();italarm.hasNext();){
				StockalarmVO saVo = (StockalarmVO)italarm.next();
				SMPCountyBrandVO scb = new SMPCountyBrandVO(countyid,saVo.getBrand());
				Long[] amount = new Long[3];
				amount[0] = saVo.getMaxstock();//绿色预警
				String[] alarmvalues = saVo.getAlarmvalue().split(";");
				if(alarmvalues.length!=2){
					throw new Exception("网点库存预警设置表(FX_RU_STOCKALARM)红、黄预警字段格式错误");
				}
				String[] redalarm = alarmvalues[0].split(":");
				String[] yellowalarm = alarmvalues[1].split(":");
				amount[1] = Long.parseLong(redalarm[1]);//红色预警
				amount[2] = Long.parseLong(yellowalarm[1]);//黄色预警
				if(!countyStockUpLimit.containsKey(scb)){//对应分公司、品牌不存在
					countyStockUpLimit.put(scb, amount);
				}else{//对应分公司、品牌存在
					Long[] old = countyStockUpLimit.get(scb);
					old[0] += amount[0];
					old[1] += amount[1];
					old[2] += amount[2];
					countyStockUpLimit.put(scb, old);
				}				
			}
			//将订购量上限设置表的查询结果放入返回结果
			//如果相应Brand已在上面的-网点库存预警设置表-查询结果中处理过，则不再处理
			//查询订购量上限设置表(FX_RU_ORDERUPLIMIT)结果不为空
			if(uplimitlist!=null){
				for(Iterator ituplimit=uplimitlist.iterator();ituplimit.hasNext();){
					OrderuplimitVO ulVo = (OrderuplimitVO)ituplimit.next();
					//对应品牌信息在网点库存预警设置表(FX_RU_STOCKALARM)查询时没要相关记录
					if(!stockalarmmap.containsKey(ulVo.getBrand())){
						SMPCountyBrandVO scb = new SMPCountyBrandVO(countyid,ulVo.getBrand());
						Long[] amount = new Long[3];
						amount[0] = ulVo.getMaxstock();//绿色预警
						String[] alarmvalues = ulVo.getAlarmvalue().split(";");
						if(alarmvalues.length!=2){
							throw new Exception("网点库存预警设置表(FX_RU_STOCKALARM)红、黄预警字段格式错误");
						}
						String[] redalarm = alarmvalues[0].split(":");
						String[] yellowalarm = alarmvalues[1].split(":");
						amount[1] = Long.parseLong(redalarm[1]);//红色预警
						amount[2] = Long.parseLong(yellowalarm[1]);//黄色预警
						if(!countyStockUpLimit.containsKey(scb)){//对应分公司、品牌不存在
							countyStockUpLimit.put(scb, amount);
						}else{//对应分公司、品牌存在
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
		
		//int i=0;//网点库存预警设置表(FX_RU_STOCKALARM)累计记录
		//int j=0;//订购量上限设置表（FX_RU_ORDERUPLIMIT）累计记录
		//System.out.println("获取库存量上限,网点库存预警设置表(FX_RU_STOCKALARM)累计记录"+i);
		//System.out.println("获取库存量上限,订购量上限设置表（FX_RU_ORDERUPLIMIT）累计记录"+j);
		//countyBrandBaseData包含所有分公司-品牌组合
		//如果返回结果不包含某种分公司-品牌组合，将其放入返回结果Map中，value数组取全零
		for(Iterator iterator=countyBrandBaseData.keySet().iterator();iterator.hasNext();){
			SMPCountyBrandVO item = (SMPCountyBrandVO)iterator.next();
			if(countyStockUpLimit.containsKey(item)){//包含
				continue;
			}
			else{//不包含
				countyStockUpLimit.put(item, new Long[]{0L,0L,0L});
			}
		}
		//System.out.println("获取库存量上限,分公司-品牌组合数"+countyBrandBaseData.size());
		//System.out.println("获取库存量上限,返回记录条数"+countyStockUpLimit.size());
		return countyStockUpLimit;
	}

	/**
	 * 6.获取仓库存量
	 * 按分公司，品牌统计某分公司的套卡资源总库存,对应指定分公司指定品牌无数据时默认取零
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
		//System.out.println("获取仓库存量,查询数据获得记录条数"+list.size());
		Map<SMPCountyBrandVO, Long> result = new HashMap<SMPCountyBrandVO, Long>();
		// 复制基础数据
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
		//System.out.println("获取仓库存量,分公司-品牌组合数"+countyBrandBaseData.size());
		//System.out.println("获取仓库存量,返回记录条数"+result.size());
		return result;
	}	
	
	/**
	 * 7.获取前N天领货量
	 * @param days 分库存预警领货量天数
	 * @param restype 资源类别[套卡、充值卡],本后台程序使用套卡
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
		//System.out.println("获取前N天领货量,查询数据获得记录条数"+list.size());
		Map<SMPCountyBrandVO, Long> countyReceivedStockAmount = new HashMap<SMPCountyBrandVO, Long>();
		Map<SMPCountyBrandVO, Long> result = new HashMap<SMPCountyBrandVO, Long>();
		// 复制基础数据
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
		//System.out.println("获取前N天领货量,分公司-品牌组合数"+countyBrandBaseData.size());
		//System.out.println("获取前N天领货量,返回记录条数"+result.size());
		return result;
	}

	
	// 8.创建库存预警数据
	private  Map<SMPCountyBrandVO, Long> creatStkalarmmct(String alarmReceivedStockDays,//预警领货量天数
			String stockAlarmInterval,//库存预警间隔
			String roleid_paramVale,//预警角色
			String smsSenttimeStr,//预警短信发送时间
			Map<SMPCountyBrandVO, Long> countyBrandBaseData,//2.分公司-品牌组合
			Map<SMPCountyBrandVO, Long> countyActualStockAmount,//4.网点实际库存
			Map<SMPCountyBrandVO, Long[]> countyStockUpLimit,//5.库存量上限
			Map<SMPCountyBrandVO, Long> countyStockAmount,//6.仓库存量
			Map<SMPCountyBrandVO, Long> countyReceivedStockAmount) throws Exception{//7.前N天领货量
		Map<SMPCountyBrandVO, Long> alarmMap = new HashMap<SMPCountyBrandVO, Long>();
		StkalarmctVO stkVO = null;
		Stkalarmct stkalarmmct = (Stkalarmct)BOFactory.build(StkalarmctBO.class, user);
		//int i=0;//插入记录条数
		for(Iterator<SMPCountyBrandVO> it=countyBrandBaseData.keySet().iterator();it.hasNext();){
			try{				
				SMPCountyBrandVO scbVO = it.next();
				/*
				 *  统计日期取当前系统时间，分公司、品牌、仓库存量、网点实际库存、网点绿色库存、网点黄色库存、
				 *  网点红色库存、领货量取上一步获取数据，绿色缺口取仓库存量－（网点绿色库存－网点实际库存），
				 *  黄色缺口取仓库存量－（网点黄色库存－网点实际库存），
				 *  红色缺口取仓库存量－（网点红色库存－网点实际库存），支撑天数取仓库存量/（领货量/N），
				 *  是否预警（绿色缺口<0取是，否则取否），是否通知留空。
				 */
				stkVO = new StkalarmctVO();	
				stkVO.setStatdate(new Date());
				stkVO.setCountyid(scbVO.getCountyid());
				stkVO.setBrand(scbVO.getBrand());
				Long kcamount = countyStockAmount.get(scbVO);//仓库存量
				stkVO.setKcamount(kcamount);
				Long realstock = countyActualStockAmount.get(scbVO);//网点实际库存
				stkVO.setRealstock(realstock);
				Long[] coloralarm = countyStockUpLimit.get(scbVO);//绿色、红色、黄色库存
				stkVO.setGreenstock(coloralarm[0]);
				stkVO.setRedstock(coloralarm[1]);
				stkVO.setYellowstock(coloralarm[2]);
				Long saleamt = countyReceivedStockAmount.get(scbVO);//领货量
				stkVO.setSaleamt(saleamt);
				long greenGap = kcamount-(coloralarm[0]-realstock);//绿色缺口
				stkVO.setGreengap(greenGap);//绿色缺口
				stkVO.setRedgap(kcamount-(coloralarm[1]-realstock));//红色缺口
				stkVO.setYellowgap(kcamount-(coloralarm[2]-realstock));//黄色缺口
				if(saleamt>0){
					stkVO.setSupportday(kcamount*Long.parseLong(alarmReceivedStockDays)/saleamt);
				}else{
					stkVO.setSupportday(0L);
					log.info("处理["+scbVO.getCountyid()+","+scbVO.getBrand()+"]时,前"+alarmReceivedStockDays+"天领货量为零,可支撑天数设为零.");
				}
				//绿色缺口小于零时需要预警
				stkVO.setIsalarm(greenGap<0?"1":"0");
				stkalarmmct.doCreate(stkVO);//将预警数据保存到数据库
				
				//绿色缺口不小于零时，无需预警，返回处理下一条
				if(greenGap>=0){
					log.info("处理["+scbVO.getCountyid()+","+scbVO.getBrand()+"],绿色缺口不小于零,无需预警");
					continue;
				}				
				//预警角色为空，输出日志返回，处理下一条
				if("".equals(roleid_paramVale)){
					log.info("处理["+scbVO.getCountyid()+","+scbVO.getBrand()+"]出错,分公司库存预警角色为空");
					continue;
				}
				//预警短信发送时间为空,输出日志，处理下一条
				if("".equals(smsSenttimeStr)){
					log.info("处理["+scbVO.getCountyid()+","+scbVO.getBrand()+"]出错,预警短信发送时间为空");
					continue;
				}
				//分公司库存预警间隔为零
				if("0".equals(stockAlarmInterval)){
					stkVO.setIsnotice("1");
				}
				else{//根据“分公司库存预警间隔”,查询之前是否已发过通知
					//如果无数据，继续，否则输出日志，处理下一条
					boolean isNeedAlarm = this.checkIsNeedAlarm(stockAlarmInterval, scbVO);
					if(isNeedAlarm){
						stkVO.setIsnotice("1");
					}else{
						log.info("处理["+scbVO.getCountyid()+","+scbVO.getBrand()+"],数据已存在,不需要再次预警");
						continue;
					}
				}
				//i++;
				stkalarmmct.doUpdate(stkVO);
				alarmMap.put(scbVO, stkVO.getKcamount());//记录预警信息，用于短信发送和写待办
			}
			catch (Exception ex) {
				LoggerUtils.error(ex, log);
			}
		}
		//System.out.println("创建库存预警数据,插入记录条数"+i);
		//System.out.println("创建库存预警数据,返回结果条数(用于短信发送和写待办)"+alarmMap.size());
		return alarmMap;
	}
	
	//根据“分公司库存预警间隔”,查询之前N天是否已发过预警,以确定是否需要预警
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
		return true;//如果数据查询出现异常，则默认为真，需要预警
	}
	
	//构造预警信息，用于发送短信和写待办
	private Object[] getAlarmInfo(Map<SMPCountyBrandVO, Long> alarmMap) throws Exception {
		Cntycompany cntyBO = (Cntycompany) BOFactory.build(CntycompanyBO.class,	user);
		Object[] result = new Object[2];
		StringBuffer stkAlarmInfo_sb = new StringBuffer("");
		Set<String> countys_set = new HashSet<String>();
		//key-countyName,value-预警信息
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
				if(count_alarmInfo.containsKey(countyName)){//预警信息中包含当前处理的分公司
					StringBuffer info =  new StringBuffer(count_alarmInfo.get(countyName));
					info.append(",").append(brandName).append(alarmMap.get(scbVO));
					count_alarmInfo.put(countyName, info.toString());
				}
				else{//预警信息中不包含当前处理的分公司
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
	 * 获取系统参数中指定角色对应的“工号[OPERID]”及“联系电话CONTACTPHONE]”
	 * 
	 * @return
	 * @throws Exception
	 */
	private Map<String, String> getSMSRecieverInfo(String roleid)
			throws Exception {

		Operrole orBO = (Operrole) BOFactory.build(OperroleBO.class, user);
		List<OperatorVO> oplist = orBO.getOperatorsByRoleId(roleid);
		if (oplist.size() <= 0) {
			throw new BusinessException("没有与角色编码 [" + roleid + "] 对应的操作员");
		}
		Map<String, String> smsRecieverInfo = new HashMap<String, String>();
		for (OperatorVO opVO : oplist) {
			smsRecieverInfo.put(opVO.getOperid(), opVO.getContactphone());
		}
		return smsRecieverInfo;
	}
	
	/**
	 *  11.发送分公司预警通知短信
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
					"系统参数\"短信发送端口\"[systemid=7,ParamType=pboss]的值不能为空");
		}
		
		//String smsSenttimeStr = spBo.doFindByID(58L, "pboss_fx");
		//if (StringUtils.isEmpty(smsSenttimeStr)) {
		//	throw new BusinessException(
		//			"系统参数\"短信发送通知时间\"[systemid=58,ParamType=pboss_fx]的值不能为空");
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
	 * 11.写待办
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
		pendingtaskBO.doCreate("以下分公司库存预警: [" + countys + "]", "", "7",
				operids, new Short("0"), null, new Date(), null);
	}

	
	/**
	 * 1) 获取目标天数（已销售、已激活）
	 * 
	 * @return
	 * @throws Exception
	 */
	private int getTargetDay() throws Exception {
		Sysparam spBo = (SysparamBO) BOFactory.build(SysparamBO.class, user);
		String paramValue = spBo.doFindByID(47L, "pboss_fx");
		// 参数合法性标记
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
			log.info("如果无数据、参数值为空、参数值不是大于等于零的整数，则目标天数默认取90;");
		return Integer.parseInt(paramValue);
	}

	/**
	 * 2) 资源类别载入
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
	 * 4) 资源库存预警
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

		// 存放商品种类ID和其对应商品种类名称的Map
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
				// 库存量下限
				Long lowstock = rarVO.getLowstock();
				// 激活率上限
				Double upactrate = rarVO.getUpactrate();
				String restype = comCateAndResType.get(comcategory);
				// 库存量
				Integer stockQty = 0;
				// 预警信号
				String alarmsignal = "";

				if ("COMRESSMP".equalsIgnoreCase(restype)) {

					if (upactrate == null)
						throw new BusinessException("编号(RECID) = "
								+ rarVO.getRecid() + " 的资源库存预警规则的激活率上限为空,请核实",
								null);
					if (lowstock == null)
						throw new BusinessException("编号(RECID) = "
								+ rarVO.getRecid() + " 的资源库存预警规则的库存量下限为空,请核实",
								null);
					// 套卡
					Comressmp crsBO = (Comressmp) BOFactory.build(
							ComressmpBO.class, user);
					// (a) 统计库存量
					stockQty = crsBO.doStatSMPStock(countyid, comcategory);

					Partnerres prBO = (Partnerres) BOFactory.build(
							PartnerresBO.class, user);
					// (b) 统计已销售量
					Integer soldQty = prBO.doStatSMPSoldQty(countyid,
							comcategory, targetDay);
					if (soldQty == 0) // 如果已销售量为0，则不处理该条数据
						continue;
					// (c) 统计已激活量
					Integer activeQty = prBO.doStatSMPActiveQty(countyid,
							comcategory, targetDay);
					// (d) 计算套卡激活率
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

					// 如果库存量小于等于库存量下限且激活率大于等于激活率上限，则预警信号取红色，否则取绿色
					if (stockQty <= lowstock && smpActiveRate >= upactrate) {
						alarmsignal = "RED";
					} else {
						alarmsignal = "GREEN";
					}
					raiVO.setAlarmsignal(alarmsignal);
					raiBO.doCreate(raiVO);
				} else if ("COMRESCARD".equalsIgnoreCase(restype)) {
					// 充值卡
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
					// 如果库存量小于等于库存量下限且激活率大于等于激活率上限，则预警信号取红色，否则取绿色
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
	 * 5) 发送预警通知
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
				// 分公司名称
				String countyName = ccVO.getCountycompname();
				String handlercode = hcVO.getHandlerCode();
				String comcategoryset = resStockAlarmMap.get(hcVO);
				comcategoryset = comcategoryset.substring(0, comcategoryset
						.length() - 1);
				OperatorVO operVO = operBO.doFindByPk(handlercode);
				// 接收手机号码
				String recno = operVO.getContactphone();
				Map<String, String> replaceKeyValueMap = new HashMap<String, String>();
				replaceKeyValueMap.put("COUNTYID", countyName);
				replaceKeyValueMap.put("COMCATESET", comcategoryset);
				replaceKeyValueMap.put("YEAR", year);
				replaceKeyValueMap.put("MONTH", month);
				replaceKeyValueMap.put("DAY", day);

				// 短信内容
				String smscontent = smstmplBO.doGenSMS("IM_STOCKALARM",
						replaceKeyValueMap);
				wrBO.doInsert(Short.valueOf("3"), smscontent, recno);
			} catch (Exception ex) {
				LoggerUtils.error(ex, log);
			}
		}
	}
}