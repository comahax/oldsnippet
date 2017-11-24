/**
 * auto-generated code
 * Mon Oct 19 19:01:27 CST 2009
 */
package com.gmcc.pboss.control.sales.comorder;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.gmcc.pboss.business.base.dictitem.DictitemVO;
import com.gmcc.pboss.business.channel.custwaytype.CustwaytypeVO;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.sales.activerate.ActiverateVO;
import com.gmcc.pboss.business.sales.comorder.ComorderVO;
import com.gmcc.pboss.business.sales.comorder.OrderCardVO;
import com.gmcc.pboss.business.sales.comorder.OrderEmptyCardVO;
import com.gmcc.pboss.business.sales.comorder.OrderMonthdayStockVO;
import com.gmcc.pboss.business.sales.comorder.OrderMonthdayStockalarm;
import com.gmcc.pboss.business.sales.comorder.OrderMonthdayVO;
import com.gmcc.pboss.business.sales.comorder.OrderStdstockVO;
import com.gmcc.pboss.business.sales.comorder.OrderStockalarmVO;
import com.gmcc.pboss.business.sales.incqttdtl.IncqttdtlVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;

/**
 * <p>Title: Activerate </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Comorder extends AbstractControl {
	//检查供应商信息
    public WayVO doCheckWay(String wayid) throws Exception;
    //获取套卡品牌集合
	public List<DictitemVO> doGetBrandList(String wayid) throws Exception;
    //获取套卡激活率信息
    public List<ActiverateVO> doGetActiveList(String wayid,List<DictitemVO> brandlist) throws Exception;
    //判断套卡订购信息采用日/月限制、基准库存限制或者预警库存的模式，"MONDAYLIMIT"则采用日/月限制，"STDSTOCK"则采用基准库存限制，"STOCKALARM"则采用预警库存，"MONDAYSTOCK"日月库存组合模式
    public String doGetOrderMode() throws Exception;
	//获取套卡订购信息——日/月限制
    public List<OrderMonthdayVO> doGetOrderInfoByMonthDay(WayVO wayVO,List<DictitemVO> brandlist) throws Exception;
    //套卡订购信息（日月预警库存组合模式）
    public List<OrderMonthdayStockalarm> doGetOrderMonthdayStockalarm(List<OrderMonthdayVO> orderMonthdayList,List<OrderStockalarmVO> orderStockalarmList) throws Exception;
    //获取套卡订购信息——基准库存限制
    public List<OrderStdstockVO> doGetOrderInfoByStdstock(WayVO wayvo,List<DictitemVO> brandlist, List<ActiverateVO> activerateList) throws Exception;
    //获取套卡订购信息——预警库存
    public List<OrderStockalarmVO> doGetOrderInfoByStockalarm(WayVO wayvo,List<DictitemVO> brandlist) throws Exception;
    //获取套卡订购信息——日月库存组合模式
    public List<OrderMonthdayStockVO> doGetOrderInfoByMonthdayStock(WayVO wayvo,List<DictitemVO> brandlist, List<ActiverateVO> activerateList) throws Exception;
    //设置充值卡订购信息
    public List<OrderCardVO> doGetOrderInfoByCard(WayVO wayVO) throws Exception;
    //获取订购资源库区
	public String doGetStorArea(WayVO wayvo) throws Exception;
	//订购检查
	public Set<String> comOrderCheck(String wayid, List<ComorderVO> comorderList, String storarea) throws Exception;
	//获取商品订购提示信息
	public String doGetOrderHint() throws Exception;
	//获取商品单价信息
	public Double doGetUnitprice(String wayid, String comcategory) throws Exception;
	//获取商品单价信息（门户、短厅调用时，如果，如果是优惠方式，同时获得单价、优惠方案编码）
	public Map doGetUnitpriceAndPlancode(String wayid, String comcategory) throws Exception;
	//获取商品单价信息(优惠方案)
	public Double doGetUnitprice(String wayid, String comcategory, String planCode) throws Exception;
	//获取订购基数
	public String doGetUnitage(String cityid, String comcategory) throws Exception;
	/**
	 * 订单建立
	 * @param orderid
	 * @param wayVO
	 * @param storarea
	 * @param comorderList
	 * @param brandSet
	 * @param orderave
	 * @param alarmlevel
	 * @return
	 * @throws Exception
	 */
	public void doBuildOrder(String orderid, WayVO wayVO, String storarea, List<ComorderVO> comorderList, Set<String> brandSet, String orderave, String alarmlevel) throws Exception;
	//获取当月已订购量
	public Long getMonordered(String wayid ,String begintime,String endtime) throws Exception;
	//获取合作类型列表
	public List<CustwaytypeVO> doGetCustwaytypeList() throws Exception;
	//匹配促销方案获取提升量
	public Integer getQuantity(String wayid,String prodid,String effectmonth) throws Exception;
	//匹配促销方案获取订货量提升明细
	public List<IncqttdtlVO> getIncqttdtlList(String wayid,String prodid,String effectmonth)throws Exception;
	//订单下一步处理
	public void doNextProcess(String orderid) throws Exception;
	//获取订单编号
	public String doGetOrderId() throws Exception;
	//月订购次数检查
	public void checkMonthBookTimes(String wayid) throws Exception;
	//根据系统参数：[pboss_fx,63]，检查是否允许订购混合订单
	public boolean isMixOrderEnabled()throws Exception;
	
	//根据商品种类获取销售优惠方案
	public Map<String,String> getSalePlanMap(String comcategory)throws Exception;
	
	//获得空白sim卡信息
	public List<OrderEmptyCardVO> getEmptySimInfo(WayVO way) throws Exception;
	public List<OrderCardVO> doGetOrderInfoByEmptyCard(WayVO wayVO) throws Exception;
}
