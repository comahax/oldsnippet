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
 * ������Ϣ��ѯ�ӿ�
 * @author Canigar
 *
 */
public class BookBasicInformationBO extends AbstractControlBean implements BookBasicInformation{ 

	private static Logger logger = Logger.getLogger(BookBasicInformationBO.class);
	
	private static final String OPEN_FLAG = "1";  //����״̬
	
	//step1 �����̻�����Ϣ
	private void doBasicQualification(String wayid) throws Exception{
		Way way = (Way) BOFactory.build(WayBO.class, user);
		WayDBParam params = new WayDBParam();
		params.set_se_wayid(wayid);
		params.set_se_waytype("AG");
		DataPackage dp = way.doQuery(params);
		if(dp.getDatas() == null || dp.getDatas().size() == 0){
			throw new WebSiteException("�ú�����["+wayid+"]������Ϣ������",RetResult.FAILURE);
		}
		user.setCityid(((WayVO)dp.getDatas().get(0)).getCityid());
	}
	
	//step2)	��ȡ������Լ��ģʽ����ѯϵͳ�������ñ�IB_GL_SYSPARAM����ƥ���������Ϊ��pboss_fx����������ʶΪ��45����
//	����������Ҳ���ֵ��Ϊ�գ��򶩹���Լ��ģʽȡ����ֵ�����򶩹���Լ��ģʽĬ��ȡ���¶�����ģʽ����MONDAYLIMIT����
	private String getLimitMode() throws Exception{
		Sysparam sysparam = (Sysparam) BOFactory.build(SysparamBO.class,user);
		String paramvalue = sysparam.doFindByID("45", "pboss_fx");
		if( null != paramvalue && !"".equals(paramvalue.trim()))
			return paramvalue.trim();
		return "MONDAYLIMIT";
	}
	
	//step3 �׿�������Ϣ����/�¶������ƣ�
	private List<BookInfo> doGetOrderInfoByMonthDay(String wayid,String limitMode) throws Exception{
		//�жϿ��� ��/�¶������޿���״̬
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
	
	//step4 �׿�������Ϣ����׼�����ƣ�
	private List<StockInfo> doGetOrderInfoByStdstock(String wayid,String limitMode) throws Exception{
		//�жϿ��� ��׼��濪��״̬
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
			//�ڿ����Ϣ��������ӡ��ڶ���������ӿڷ�����Ϣ
			if(!"AllBrand".equals(vo.getBrand())){
			//if("1".equals(paramValue)) {
				// ����Ʒ��
				info.setOrderStock(order.doGetOrderingStockAmountWithBrand(wayid, vo.getBrand()).intValue());
			}else {
				// ������Ʒ��
				info.setOrderStock(order.doGetOrderingStockAmountNotWithBrand(wayid).intValue());
			}
			info.setBasicStock(vo.getStdstock().intValue());
			info.setNonceStock(vo.getNowstock().intValue());
			info.setNonceMaxStock(vo.getOrderMax().intValue());
			list.add(info);
		}
		return list;
	}
	
//	step5)	Ԥ�������Ϣ
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
					//Ʒ�ƹ�����
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
				//�ڿ����Ϣ��������ӡ��ڶ���������ӿڷ�����Ϣ
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
				monthDayStockInfo.setCanBookNonceMonth(omdsVO.getOrderMaxMonth().intValue());	//���� �ɶ���
				monthDayStockInfo.setBookedNonceMonth(omdsVO.getOrderedMonth().intValue());		//�Ѷ���
				monthDayStockInfo.setSurBookNonceMonth(omdsVO.getOrderRemainMonth().intValue());//ʣ����
				monthDayStockInfo.setCanBookToday(omdsVO.getOrderMaxDay().intValue());			//���� �ɶ���
				monthDayStockInfo.setBookedToday(omdsVO.getOrderedDay().intValue());			//�Ѷ���
				monthDayStockInfo.setSurBookToday(omdsVO.getOrderRemainDay().intValue());		//ʣ����
				monthDayStockInfo.setBasicStock(omdsVO.getStdstock().intValue());				//��׼���
				monthDayStockInfo.setNonceStock(omdsVO.getNowstock().intValue());				//ʵ�ʿ��(��ǰ���)
				monthDayStockInfo.setNonceMaxStock(omdsVO.getOrderMax().intValue());			//��ǰ�������
				monthDayStockInfo.setRefMaxStock(omdsVO.getReferData().intValue());				//��󶩹����ο�
				
				result.add(monthDayStockInfo);
			}
		}
		
		return result;
	}
	
	//step6)	��ֵ��������Ϣ
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
	
	//step7 ��ȡ�׿���������Ϣ
    public List<ActiveInfo> doGetActiveList(String wayid) throws Exception {
    	Comorder comorder = (Comorder)BOFactory.build(ComorderBO.class, user);
    	//��ȡ�׿�Ʒ�Ƽ���
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
			sysparamvalue = "5"; //Ĭ��5����
		}
		return sysparamvalue;
    }
    /**
     * �Զ���ʱ�ν��м��
     * @throws Exception
     */
    private void doCheckLimitTime(String wayid ) throws Exception {

		Way wayBO  = (Way) BOFactory.build(WayBO.class,user);
		WayVO wayVO = wayBO.doFindByPk(wayid);
		ComorderCheck comorderCheckBO = (ComorderCheckBO)BOFactory.build(ComorderCheckBO.class,user);
		comorderCheckBO.checkLimitTime(wayVO);
    }
    /**
	 * �¶����������
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
		result.setMessage("�ɹ�");
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
			result.setMessage("�׿���������Ϣ����.");
			return result;
		}
		// �����������
		String checkMonthBookTimes = this.checkBookTimes(wayid);
		if(!"".equals(checkMonthBookTimes)) {
			result.setRetCode(BookBasicInfo.NOT_PASS);
			result.setMessage(checkMonthBookTimes);
			return result;
		}
		// ����ʱ�μ��
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
