/**
 * auto-generated code
 * Tue Oct 13 12:38:53 CST 2009
 */
package com.gmcc.pboss.control.sales.ordercomcate;

import java.io.Serializable;
import java.util.List;

import com.gmcc.pboss.business.sales.ordercomcate.OrdercomcateDBParam;
import com.gmcc.pboss.business.sales.ordercomcate.OrdercomcateStocksVO;
import com.gmcc.pboss.business.sales.ordercomcate.OrdercomcateVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Ordercomcate </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public interface Ordercomcate extends AbstractControl {
    public OrdercomcateVO doCreate(OrdercomcateVO vo) throws Exception;

    public void doRemoveByVO(OrdercomcateVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public OrdercomcateVO doUpdate(OrdercomcateVO vo) throws Exception;

    public OrdercomcateVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(OrdercomcateDBParam params) throws Exception;
    
    //查询订单订购套数（所有品牌）
	public Long doQueryOrderamtByAllBrand(String orderid) throws Exception;
	
	//查询订单订购套数（单个品牌）
	public Long doQueryOrderamtByBrand(String orderid, String brand) throws Exception;

    public DataPackage doQueryByNameSql(String nameSql,OrdercomcateDBParam params)
	throws Exception; 
    public void doAmtadjSave(String recid,String orderamt,String memo)throws Exception;
	/**
	 * 查询审核库存检查所需的信息
	 * @param orderids
	 * @return
	 * @throws Exception
	 */
	 public List<OrdercomcateStocksVO> doOrdercomcateStocksQuery(String[] orderids ) throws Exception;
	 
	 /**
	     *对客户订购空白SIM卡数量进行统计
	     * @param orderid
	     * @return
	     * @throws Exception
	     */
	 public DataPackage doquerySimamtByOrderID(String orderid) throws Exception ;
	 
	 /**
	  * 关联查询订单表（FX_SW_ORDER）和订单商品种类（FX_SW_ORDERCOMCATE）统计合作商当月空白卡订购量
	  * @param wayid
	  * @return
	  * @throws Exception
	  */
	 public DataPackage doQueryEmptySimRealTimeUpdateDayMonthCount(String wayid) throws Exception ;
	 
	 /**
	  * 关联订单表（FX_SW_ORDER）、订单商品种类表（FX_SW_ORDERCOMCATE）对合作商未订购完成的空白卡进行统计
	  * @param wayid
	  * @return
	  * @throws Exception
	  */
	 
	 public DataPackage doQueryEmptySimRealTimeUpdateBuyCount(String wayid) throws Exception ;
	 
	 //批量触发划扣结果短信 （统计商品种类订购数量）
	 public DataPackage doQueryDataByOrderId (String orderid) throws Exception;
}
