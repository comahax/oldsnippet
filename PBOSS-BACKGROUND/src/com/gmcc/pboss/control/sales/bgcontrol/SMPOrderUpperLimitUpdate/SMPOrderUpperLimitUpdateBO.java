package com.gmcc.pboss.control.sales.bgcontrol.SMPOrderUpperLimitUpdate;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.sales.bgbusiness.PartnerSMPBrandVO;
import com.gmcc.pboss.business.sales.orderuplimit.OrderuplimitDBParam;
import com.gmcc.pboss.business.sales.orderuplimit.OrderuplimitVO;
import com.gmcc.pboss.business.sales.stockalarm.StockalarmVO;
import com.gmcc.pboss.business.sales.stockalmfloat.StockalmfloatDBParam;
import com.gmcc.pboss.business.sales.stockalmfloat.StockalmfloatVO;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.sales.orderuplimit.Orderuplimit;
import com.gmcc.pboss.control.sales.orderuplimit.OrderuplimitBO;
import com.gmcc.pboss.control.sales.partnerres.Partnerres;
import com.gmcc.pboss.control.sales.partnerres.PartnerresBO;
import com.gmcc.pboss.control.sales.stockalarm.Stockalarm;
import com.gmcc.pboss.control.sales.stockalarm.StockalarmBO;
import com.gmcc.pboss.control.sales.stockalmfloat.Stockalmfloat;
import com.gmcc.pboss.control.sales.stockalmfloat.StockalmfloatBO;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.exception.BusinessException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class SMPOrderUpperLimitUpdateBO extends AbstractControlBean implements
		SMPOrderUpperLimitUpdate {

	private static Logger log = Logger.getLogger(SMPOrderUpperLimitUpdateBO.class);
	
	public void doProcess() throws Exception {
		
		Sysparam spBo = (SysparamBO)BOFactory.build(SysparamBO.class, user);
		String paramValue = spBo.doFindByID(49L, "pboss_fx");
		if(StringUtils.isEmpty(paramValue))
			throw new BusinessException("系统参数(SystemId=49;ParamType=pboss_fx)不存在,请核实",null);
		if(!PublicUtils.isInteger(paramValue)) 
			throw new BusinessException("系统参数(SystemId=49;ParamType=pboss_fx)的值必须为整数",null);
		log.info("====================网点套卡订购上限更新开始====================");
		int intervalMonth = Integer.parseInt(paramValue);
		// 获取当前月的前N个月的时间范围
		Date[] periodTime = PublicUtils.getMonthPeriod(new Date(), intervalMonth);
		//<网点，品牌，平均激活量>
		Map<PartnerSMPBrandVO, Long> smpActiveAvg = this.getSMPActiveAvg(periodTime[0], periodTime[1], intervalMonth);
		this.updateUpperLimit(smpActiveAvg,intervalMonth);
		log.info("====================网点套卡订购上限更新结束====================");
	}
	
	/**
	 * 获取套卡激活数量平均值
	 * @param begintime
	 * @param endtime
	 * @param intervalMonth
	 * @return
	 * @throws Exception
	 */
	private Map<PartnerSMPBrandVO, Long> getSMPActiveAvg(Date begintime,
			Date endtime, int intervalMonth) throws Exception {

		Partnerres prsBO = (Partnerres)BOFactory.build(PartnerresBO.class, user);
		DataPackage dp = prsBO.doStatSMPActiveQtyInMonths(begintime, endtime, intervalMonth);
		List list = dp.getDatas();
		Map<PartnerSMPBrandVO, Long> result = new HashMap<PartnerSMPBrandVO, Long>();
		if(list != null && list.size() > 0) {
			for(int i=0;i<list.size();i++) {
				Map data = (Map)list.get(i);
				String wayid = (String)data.get("wayid");
				String brand = (String)data.get("brand");
				if(data.get("starlevel") == null || "".equals(data.get("starlevel"))){
					log.info("渠道星级为空，合作商编码[" + data.get("wayid") + "]",null);
					continue;
				}
				Long starlevel = new Long((String)data.get("starlevel"));
				int activeQty = Integer.parseInt((String)data.get("activeQty"));
				PartnerSMPBrandVO psbVO = new PartnerSMPBrandVO(wayid,brand,starlevel);
				// 平均值，四舍五入
				long avgQty = Math.round(((double)activeQty)/intervalMonth);
				result.put(psbVO, avgQty);
			}
		}
		return result;
	}
	
	/**
	 * 自动更新或新增网点库存预警设置
	 * @param smpActiveAvg
	 * @throws Exception
	 */
	private void updateUpperLimit(Map<PartnerSMPBrandVO, Long> smpActiveAvg,int intervalMonth) throws Exception {
		
		Stockalarm saBO = (Stockalarm)BOFactory.build(StockalarmBO.class, user, BOFactory.PROPAGATION_REQUIRES_NEW);
		Way wayBO = (Way)BOFactory.build(WayBO.class, user);
		Orderuplimit olBO = (Orderuplimit)BOFactory.build(OrderuplimitBO.class, user);
		OrderuplimitDBParam olParam = new OrderuplimitDBParam();
		
		for(Iterator<PartnerSMPBrandVO> it = smpActiveAvg.keySet().iterator();it.hasNext();) {
			try {
				PartnerSMPBrandVO psbVO = it.next();
				Long avgQty = smpActiveAvg.get(psbVO);//平均激活量
				Serializable saPk = new StockalarmVO(psbVO.getBrand(),psbVO.getWayid());
				StockalarmVO saVO = saBO.doFindByPk(saPk);
				if(saVO != null && "MANUAL".equals(saVO.getUpdatechannel())) {
					continue;// 如果存在记录，且“更新途径[UPDATECHANNEL]”为“手工[MANUAL]”，则跳过该分销商设置；
				}
				
				//c
				WayVO wayvo = wayBO.doFindByPk(psbVO.getWayid());
				if(wayvo == null){
					throw new BusinessException("渠道基础信息不存在，合作商编码[" + psbVO.getWayid() + "]",null);
				}else if(wayvo.getWaystate()!=1){
					throw new BusinessException("渠道状态无效，合作商编码[" + psbVO.getWayid() + "]",null);
				}
				//d
				Stockalmfloat stockalmfloat = (Stockalmfloat)BOFactory.build(StockalmfloatBO.class, user);
				StockalmfloatDBParam sparam = new StockalmfloatDBParam();
				sparam.set_se_brand(psbVO.getBrand());
				sparam.set_ne_starlevel(""+psbVO.getStarlevel());
				//Serializable sfPk = new StockalmfloatVO(psbVO.getBrand(),Short.parseShort(""+psbVO.getStarlevel()));
				StockalmfloatVO sfVO = null;
				DataPackage sfVODp = stockalmfloat.doQuery(sparam);
				if(null!=sfVODp && sfVODp.getDatas().size()>0){
					sfVO = (StockalmfloatVO)sfVODp.getDatas().get(0);
				}
				
				
				if(sfVO == null) {
					throw new BusinessException("网点库存预警浮动系数不存在，合作商编码[" + psbVO.getWayid() + "]"+"星级["+psbVO.getStarlevel()+"]品牌[" + psbVO.getBrand() + "]",null);
				}
				Double maxstockquotiety = sfVO.getMaxstockquotiety() == null ? 1 : sfVO.getMaxstockquotiety();//最高库存系数
				Double yellowquotiety = sfVO.getYellowquotiety() == null ? 1 : sfVO.getYellowquotiety();//黄色预警系数
				Double redquotiety = sfVO.getRedquotiety() == null ? 1 : sfVO.getRedquotiety();//红色预警系数
				Double actquotiety = sfVO.getActquotiety() == null ? 1 : sfVO.getActquotiety();//平均激活量系数 add by panyonghui
				//e
				Double maxstock = 0D;//无数据则默认最高库存为零
				olParam.set_se_cityid(wayvo.getCityid());
				olParam.set_se_countyid(wayvo.getCountyid());
				olParam.set_ne_starlevel(wayvo.getStarlevel().toString());
				olParam.set_se_brand(psbVO.getBrand());
				olParam.set_se_limitmode("STOCKALARM");
				DataPackage dp = (DataPackage)olBO.doQuery(olParam);
				if(null!=dp && dp.getDatas().size()>0){
					OrderuplimitVO ouvo = (OrderuplimitVO)dp.getDatas().get(0);
					if(null!=ouvo.getMaxstock()){
						maxstock = ouvo.getMaxstock().doubleValue();//星级最高库存
					}
				}
				//f
				//modify by panyonghui
				Double avgValue = avgQty == null ? 0 : avgQty * actquotiety;//平均激活量*平均激活量系数
				Double stdvalue = maxstock > avgValue ? maxstock : avgValue;//基准值（取星级最高库存与平均激活量*平均激活量系数两者最大值）
				if(saVO != null && "AUTO".equals(saVO.getUpdatechannel())) {
					// 如果存在记录，且“更新途径[UPDATECHANNEL]”为“自动[AUTO]”
					saVO.setStdvalue(stdvalue);//基准值（取星级最高库存与平均激活量*平均激活量系数两者最大值）
					saVO.setQuotiety(maxstockquotiety.doubleValue());//浮动系数（即最高库存系数）
					saVO.setMaxstock(((Double)(Math.ceil(stdvalue*maxstockquotiety))).longValue());
					saVO.setAlarmvalue("REDALARM:"+((Double)(Math.ceil(stdvalue*maxstockquotiety*redquotiety))).longValue() + ";YELALARM:"+((Double)(Math.ceil(stdvalue*maxstockquotiety*yellowquotiety))).longValue());
					saVO.setAveactnum(avgQty.doubleValue());
					saVO.setMemo(maxstock>avgValue?"星级规则":intervalMonth+"月平均激活量");
					saVO.setChgtime(new Date());
					saBO.doUpdate(saVO);
					log.info("更新成功一条网点库存预警设置表记录  合作商编码:"+saVO.getWayid()+"  套卡品牌:"+saVO.getBrand());
				}else if(saVO == null){
					// 如果不存在记录，则新增一笔记录到网点库存预警设置表[FX_RU_STOCKALARM]”表，
					saVO = new StockalarmVO();
					saVO.setWayid(psbVO.getWayid());
					saVO.setBrand(psbVO.getBrand());
					saVO.setUpdatechannel("AUTO");
					saVO.setStdvalue(stdvalue);//基准值（取星级最高库存与平均激活量*平均激活量系数两者最大值）
					saVO.setQuotiety(maxstockquotiety.doubleValue());//浮动系数（即最高库存系数）
					saVO.setMaxstock(((Double)(Math.ceil(stdvalue*maxstockquotiety))).longValue());
					saVO.setAlarmvalue("REDALARM:"+((Double)(Math.ceil(stdvalue*maxstockquotiety*redquotiety))).longValue() + ";YELALARM:"+((Double)(Math.ceil(stdvalue*maxstockquotiety*yellowquotiety))).longValue());
					saVO.setAveactnum(avgQty.doubleValue());
					saVO.setMemo(maxstock>avgValue?"星级规则":intervalMonth+"月平均激活量");
					saVO.setChgtime(new Date());
					saBO.doCreate(saVO);
					log.info("新增成功一条网点库存预警设置表记录  合作商编码:"+saVO.getWayid()+"  套卡品牌:"+saVO.getBrand());
				}
			}catch(BusinessException ex) {
				log.info(ex.getMessage());
			}catch(Exception ex) {
				LoggerUtils.error(ex, log);
			}
		}
	}
	
}
