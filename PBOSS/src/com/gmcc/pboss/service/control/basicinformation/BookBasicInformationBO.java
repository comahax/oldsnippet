package com.gmcc.pboss.service.control.basicinformation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.gmcc.pboss.business.base.dictitem.DictitemVO;
import com.gmcc.pboss.business.channel.way.WayDBParam;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.sales.activerate.ActiverateVO;
import com.gmcc.pboss.business.sales.comorder.ComorderConstant;
import com.gmcc.pboss.business.sales.comorder.OrderCardVO;
import com.gmcc.pboss.business.sales.comorder.OrderMonthdayStockVO;
import com.gmcc.pboss.business.sales.comorder.OrderMonthdayVO;
import com.gmcc.pboss.business.sales.comorder.OrderStdstockVO;
import com.gmcc.pboss.business.sales.comorder.OrderStockalarmVO;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.sales.comorder.Comorder;
import com.gmcc.pboss.control.sales.comorder.ComorderBO;
import com.gmcc.pboss.control.sales.comorder.ComorderCheck;
import com.gmcc.pboss.control.sales.comorder.ComorderCheckBO;
import com.gmcc.pboss.control.sales.order.Order;
import com.gmcc.pboss.control.sales.order.OrderBO;
import com.gmcc.pboss.service.exception.WebSiteException;
import com.gmcc.pboss.service.result.RetResult;
import com.gmcc.pboss.service.result.goods.ActiveInfo;
import com.gmcc.pboss.service.result.goods.BookBasicInfo;
import com.gmcc.pboss.service.result.goods.BookInfo;
import com.gmcc.pboss.service.result.goods.ComresscardOrderInfo;
import com.gmcc.pboss.service.result.goods.MondaystockInfo;
import com.gmcc.pboss.service.result.goods.StockInfo;
import com.gmcc.pboss.service.result.goods.StockalarmInfo;
import com.gmcc.pboss.web.sales.stockalarm.AlarmUtils;
import com.sunrise.jop.common.utils.lang.Code2NameUtils;
import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.exception.business.SaleException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * 基本信息查询接口
 * @author Canigar
 *
 */
public class BookBasicInformationBO extends AbstractControlBean implements BookBasicInformation{ 

	private static Logger logger = Logger.getLogger(BookBasicInformationBO.class);
	
	private static final String OPEN_FLAG = "1";  //启用状态
	
	//step1 合作商基本信息
	private void doBasicQualification(String wayid) throws Exception{
		Way way = (Way) BOFactory.build(WayBO.class, user);
		WayDBParam params = new WayDBParam();
		params.set_se_wayid(wayid);
		params.set_se_waytype("AG");
		DataPackage dp = way.doQuery(params);
		if(dp.getDatas() == null || dp.getDatas().size() == 0){
			throw new WebSiteException("该合作商["+wayid+"]基本信息不存在",RetResult.FAILURE);
		}
		user.setCityid(((WayVO)dp.getDatas().get(0)).getCityid());
	}
	
	//step2)	获取订购量约束模式：查询系统参数配置表（IB_GL_SYSPARAM），匹配参数类型为“pboss_fx”，参数标识为“45”，
//	如果有数据且参数值不为空，则订购量约束模式取参数值；否则订购量约束模式默认取日月订购量模式（即MONDAYLIMIT）。
	private String getLimitMode() throws Exception{
		Sysparam sysparam = (Sysparam) BOFactory.build(SysparamBO.class,user);
		String paramvalue = sysparam.doFindByID("45", "pboss_fx");
		if( null != paramvalue && !"".equals(paramvalue.trim()))
			return paramvalue.trim();
		return "MONDAYLIMIT";
	}
	
	//step3 套卡订购信息（日/月订购限制）
	private List<BookInfo> doGetOrderInfoByMonthDay(String wayid,String limitMode) throws Exception{
		//判断开关 日/月订购上限开关状态
		if( !"MONDAYLIMIT".equals(limitMode))
			return null;
		
		Way way = (Way) BOFactory.build(WayBO.class, user);
		WayVO wayvo = way.doFindByPk(wayid);
		Comorder comorder = (Comorder)BOFactory.build(ComorderBO.class, user);
		List<DictitemVO> brandlist = comorder.doGetBrandList(wayid);
		
		List<OrderMonthdayVO> orderList = comorder.doGetOrderInfoByMonthDay(wayvo,brandlist);
		
		List<BookInfo> list = new ArrayList<BookInfo>();
		for(Iterator<OrderMonthdayVO> itt = orderList.iterator(); itt.hasNext();){
			OrderMonthdayVO vo = itt.next();
			BookInfo info = new BookInfo();
			info.setBrandName(Code2NameUtils.code2Name("$FX_SMPBRAND", vo.getBrand(), user.getCityid()));
			info.setCanBookNonceMonth(vo.getOrderMaxMonth().intValue());
			info.setBookedNonceMonth(vo.getOrderedMonth().intValue());
			info.setSurBookNonceMonth(vo.getOrderRemainMonth().intValue());
			info.setCanBookToday(vo.getOrderMaxDay().intValue());
			info.setBookedToday(vo.getOrderedDay().intValue());
			info.setSurBookToday(vo.getOrderRemainDay().intValue());
			list.add(info);
		}
		return list;
	}
	
	//step4 套卡订购信息（基准库限制）
	private List<StockInfo> doGetOrderInfoByStdstock(String wayid,String limitMode) throws Exception{
		//判断开关 基准库存开关状态
		if( !"STDSTOCK".equals(limitMode))
			return null;
		
		Way way = (Way) BOFactory.build(WayBO.class, user);
		WayVO wayvo = way.doFindByPk(wayid);
		
		Comorder comorder = (Comorder)BOFactory.build(ComorderBO.class, user);
		List<DictitemVO> brandlist = comorder.doGetBrandList(wayid);
		
		List<ActiverateVO> activerateList = comorder.doGetActiveList(wayid,brandlist);
		List<OrderStdstockVO> orderList = comorder.doGetOrderInfoByStdstock(wayvo,brandlist,activerateList);
		
		Sysparam spBO = (Sysparam)BOFactory.build(SysparamBO.class, user);
		String paramValue = spBO.doFindByID("12", "pboss_fx");
		Order order = (Order)BOFactory.build(OrderBO.class, user);
		List<StockInfo> list = new ArrayList<StockInfo>();
		for(Iterator<OrderStdstockVO> itt = orderList.iterator(); itt.hasNext();){
			OrderStdstockVO vo = itt.next();
			StockInfo info = new StockInfo();
			info.setBrandName(Code2NameUtils.code2Name("$FX_SMPBRAND", vo.getBrand(), user.getCityid()));
			//在库存信息对象中添加“在订库存量”接口返回信息
			if(!"AllBrand".equals(vo.getBrand())){
			//if("1".equals(paramValue)) {
				// 区分品牌
				info.setOrderStock(order.doGetOrderingStockAmountWithBrand(wayid, vo.getBrand()).intValue());
			}else {
				// 不区分品牌
				info.setOrderStock(order.doGetOrderingStockAmountNotWithBrand(wayid).intValue());
			}
			info.setBasicStock(vo.getStdstock().intValue());
			info.setNonceStock(vo.getNowstock().intValue());
			info.setNonceMaxStock(vo.getOrderMax().intValue());
			list.add(info);
		}
		return list;
	}
	
//	step5)	预警库存信息
	private List<StockalarmInfo> getAlarmList(String wayid,String limitMode) throws Exception{
		List<StockalarmInfo> result = new ArrayList<StockalarmInfo>();
		if( !"STOCKALARM".equals(limitMode))
			return null;
		Way way = (Way) BOFactory.build(WayBO.class, user);
		WayVO wayvo = way.doFindByPk(wayid);
		Comorder comorder = (Comorder)BOFactory.build(ComorderBO.class, user);
		List<DictitemVO> brandlist = comorder.doGetBrandList(wayid);
		List<OrderStockalarmVO> resulrList = comorder.doGetOrderInfoByStockalarm(wayvo,brandlist);
		Sysparam spBO = (Sysparam)BOFactory.build(SysparamBO.class, user);
		String paramValue = spBO.doFindByID("12", "pboss_fx");
		Order order = (Order)BOFactory.build(OrderBO.class, user);
		if(resulrList != null){
			Map brandMap = Code2NameUtils.valueList("$FX_SMPBRAND", user.getCityid());
			for(OrderStockalarmVO alarmVO : resulrList){
				StockalarmInfo alarmInfo = new StockalarmInfo();
				String brandString = alarmVO.getBrand();
				String brandsName = "";
				if(brandString.indexOf(",")>=0){
					//品牌共享翻译
					String brand2Arr[] = brandString.split(",");
					for(int k=0 ; k<brand2Arr.length ; k++){
						String brand3 = brand2Arr[k];
						brandsName = brandsName + (String)brandMap.get(brand3) + ",";
					}
					if(brandsName.lastIndexOf(",") == (brandsName.length()-1)){
						brandsName = brandsName.substring(0, (brandsName.length()-1));
					}
				}else{
					brandsName = (String)brandMap.get(brandString);
				}
				alarmInfo.setBrandName(brandsName);
				alarmInfo.setAlarmValue(AlarmUtils.alarmCode2Name(alarmVO.getAlarmValue(), user.getCityid()));
				//在库存信息对象中添加“在订库存量”接口返回信息
				if("1".equals(paramValue)) {
					alarmInfo.setOrderStock(order.doGetOrderingStockAmountWithBrand(wayid, alarmVO.getBrand()).intValue());
				}else {
					alarmInfo.setOrderStock(order.doGetOrderingStockAmountNotWithBrand(wayid).intValue());
				}
				alarmInfo.setMaxStock(alarmVO.getMaxStock() == null ? 0:alarmVO.getMaxStock());
				alarmInfo.setNowstock(alarmVO.getNowstock() == null ? 0:alarmVO.getNowstock());
				alarmInfo.setOrderMax(alarmVO.getOrderMax() == null ? 0:alarmVO.getOrderMax());
				result.add(alarmInfo);
			}
		}
		
		return result;
	}
	
	private List<MondaystockInfo> getMondaystockInfos(String wayid,String limitMode) throws Exception{
		List<MondaystockInfo> result = new ArrayList<MondaystockInfo>();
		if( !"MONDAYSTOCK".equals(limitMode))
			return null;
		
		Way way = (Way) BOFactory.build(WayBO.class, user);
		WayVO wayvo = way.doFindByPk(wayid);
		Comorder comorder = (Comorder)BOFactory.build(ComorderBO.class, user);
		List<DictitemVO> brandlist = comorder.doGetBrandList(wayid);
		List<ActiverateVO> activerateList = comorder.doGetActiveList(wayid, brandlist);
		List<OrderMonthdayStockVO> orderMonthdayStockList = comorder
			.doGetOrderInfoByMonthdayStock(wayvo, brandlist, activerateList);
		
		if(orderMonthdayStockList != null && !"".equals(orderMonthdayStockList) && orderMonthdayStockList.size() > 0){
			for(int i=0; i<orderMonthdayStockList.size(); i++){
				OrderMonthdayStockVO omdsVO = (OrderMonthdayStockVO)orderMonthdayStockList.get(i);
				MondaystockInfo monthDayStockInfo = new MondaystockInfo();
				monthDayStockInfo.setBrandName(Code2NameUtils.code2Name("$FX_SMPBRAND", omdsVO.getBrand(), user.getCityid()));
				monthDayStockInfo.setCanBookNonceMonth(omdsVO.getOrderMaxMonth().intValue());	//当月 可订购
				monthDayStockInfo.setBookedNonceMonth(omdsVO.getOrderedMonth().intValue());		//已订购
				monthDayStockInfo.setSurBookNonceMonth(omdsVO.getOrderRemainMonth().intValue());//剩余量
				monthDayStockInfo.setCanBookToday(omdsVO.getOrderMaxDay().intValue());			//当天 可订购
				monthDayStockInfo.setBookedToday(omdsVO.getOrderedDay().intValue());			//已订购
				monthDayStockInfo.setSurBookToday(omdsVO.getOrderRemainDay().intValue());		//剩余量
				monthDayStockInfo.setBasicStock(omdsVO.getStdstock().intValue());				//基准库存
				monthDayStockInfo.setNonceStock(omdsVO.getNowstock().intValue());				//实际库存(当前库存)
				monthDayStockInfo.setNonceMaxStock(omdsVO.getOrderMax().intValue());			//当前最大库存量
				monthDayStockInfo.setRefMaxStock(omdsVO.getReferData().intValue());				//最大订购量参考
				
				result.add(monthDayStockInfo);
			}
		}
		
		return result;
	}
	
	//step6)	充值卡订购信息
	public List<ComresscardOrderInfo> doGetComresscardOrderInfos(String wayid) throws Exception{
		List<ComresscardOrderInfo> result = null;
		Way wayBO  = (Way) BOFactory.build(WayBO.class,user);
		WayVO wayVO = wayBO.doFindByPk(wayid);
		Comorder comorder = (Comorder)BOFactory.build(ComorderBO.class, user);
		if(ComorderConstant.MODE_MONDAYLIMIT.equals(comorder.doGetOrderMode())){
			List<OrderCardVO> orderCardVOList = comorder.doGetOrderInfoByCard(wayVO);
			if( null != orderCardVOList ){
				result = new ArrayList<ComresscardOrderInfo>();
				for(OrderCardVO orderCardVO : orderCardVOList){
					ComresscardOrderInfo info = new ComresscardOrderInfo();
					info.setComcategory(Code2NameUtils.code2Name("$IM_FXCOMCATEGORY", orderCardVO.getComcategory(), user.getCityid()));
					info.setOrderedDay(orderCardVO.getOrderedDay());
					info.setOrderedMonth(orderCardVO.getOrderedMonth());
					info.setOrderMaxDay(orderCardVO.getOrderMaxDay());
					info.setOrderMaxMonth(orderCardVO.getOrderMaxMonth());
					info.setOrderRemainDay(orderCardVO.getOrderRemainDay());
					info.setOrderRemainMonth(orderCardVO.getOrderRemainMonth());
					result.add(info);
				}
			}
		}		
		return result;
	}
	
	//step7 获取套卡激活率信息
    public List<ActiveInfo> doGetActiveList(String wayid) throws Exception {
    	Comorder comorder = (Comorder)BOFactory.build(ComorderBO.class, user);
    	//获取套卡品牌集合
		List<DictitemVO> brandlist = comorder.doGetBrandList(wayid);
    	List<ActiverateVO> list1 = comorder.doGetActiveList(wayid, brandlist);
		List<ActiveInfo> list = new ArrayList<ActiveInfo>();
		for(ActiverateVO vo : list1){
			ActiveInfo info = new ActiveInfo();
			info.setBrandName(Code2NameUtils.code2Name("$FX_SMPBRAND", vo.getBrand(), user.getCityid()));
			info.setActRate(vo.getRate());
			info.setFulfilStandard(vo.getIsachieve() == 1?true:false);
			info.setFilStandardGap(vo.getDifamt()==null?0:vo.getDifamt().intValue());
			list.add(info);
		}
		return list;
    }
    
    private String doGetOverTime() throws Exception {
    	Sysparam sysparam = (Sysparam) BOFactory.build(SysparamBO.class,user);
		String sysparamvalue = sysparam.doFindByID("28", "pboss_fx");
		if(StringUtils.isEmpty(sysparamvalue)){
			sysparamvalue = "5"; //默认5分钟
		}
		return sysparamvalue;
    }
    /**
     * 对订购时段进行检查
     * @throws Exception
     */
    private void doCheckLimitTime(String wayid ) throws Exception {

		Way wayBO  = (Way) BOFactory.build(WayBO.class,user);
		WayVO wayVO = wayBO.doFindByPk(wayid);
		ComorderCheck comorderCheckBO = (ComorderCheckBO)BOFactory.build(ComorderCheckBO.class,user);
		comorderCheckBO.checkLimitTime(wayVO);
    }
    /**
	 * 月订购次数检查
	 * 
	 * @return
	 * @throws Exception
	 */
	private String checkBookTimes(String wayid) throws Exception {
		try {
			Comorder cdBO = (Comorder) BOFactory.build(ComorderBO.class, user);
			cdBO.checkMonthBookTimes(wayid);
			return "";
		} catch (SaleException se) {
			return se.getMessage();
		} catch (Exception ex) {
			throw ex;
		}
	}
    
	private BookBasicInfo doReturnSuccVal(String wayid) throws Exception{
		String limitMode = getLimitMode();
		BookBasicInfo result = new BookBasicInfo();
		result.setRetCode(RetResult.SUCCESS);
		result.setMessage("成功");
		result.setBookInfos(this.doGetOrderInfoByMonthDay(wayid,limitMode));
		result.setStockInfos(this.doGetOrderInfoByStdstock(wayid,limitMode));
		result.setStockAlarmInfos(this.getAlarmList(wayid, limitMode));
		result.setMondaystockInfos(this.getMondaystockInfos(wayid, limitMode));
		result.setComresscardOrderInfos(this.doGetComresscardOrderInfos(wayid));
		result.setOverTime(this.doGetOverTime());
		try{
			result.setActiveInfos(this.doGetActiveList(wayid));
		}catch(Exception e){
			result.setRetCode(BookBasicInfo.NOT_PASS);
			result.setMessage("套卡激活率信息错误.");
			return result;
		}
		// 订购次数检查
		String checkMonthBookTimes = this.checkBookTimes(wayid);
		if(!"".equals(checkMonthBookTimes)) {
			result.setRetCode(BookBasicInfo.NOT_PASS);
			result.setMessage(checkMonthBookTimes);
			return result;
		}
		// 订购时段检查
		try{
			this.doCheckLimitTime(wayid);
		}catch(Exception e){
			result.setRetCode(BookBasicInfo.NOT_PASS);
			result.setMessage(e.getMessage());
		}
		
		return result;
	}
	
	public BookBasicInfo doCheck(String wayid) throws Exception{
		try{
			doBasicQualification(wayid);
			return doReturnSuccVal(wayid);
		}catch (Exception e) {
			throw e;
		}
	}
}
