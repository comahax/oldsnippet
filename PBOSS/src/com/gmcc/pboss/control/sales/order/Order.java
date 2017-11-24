/**
 * auto-generated code
 * Mon Oct 12 14:56:43 CST 2009
 */
package com.gmcc.pboss.control.sales.order;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import com.gmcc.pboss.business.sales.order.AuxiliaryInfoVO;
import com.gmcc.pboss.business.sales.order.NextProcessResult;
import com.gmcc.pboss.business.sales.order.OrderDBParam;
import com.gmcc.pboss.business.sales.order.OrderVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Order </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public interface Order extends AbstractControl {
    public OrderVO doCreate(OrderVO vo) throws Exception;

    public void doRemoveByVO(OrderVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public OrderVO doUpdate(OrderVO vo) throws Exception;

    public OrderVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(OrderDBParam params) throws Exception;
    
    public DataPackage doList(OrderDBParam params) throws Exception; 
    
    public String doGetOrderInfo(String orderID) throws Exception;
    
    public void doAudit(String orderid) throws Exception;
    
    public void doBatchAudit(String[] orderids) throws Exception;

    /**
	 * 更新订单状态
	 * @param pkItem	订单号(组)
	 * @param state		更新为的新状态
	 * @throws Exception
	 */
	public void setOrderState(String[] pkItem,String state) throws Exception;
	
	/**
	 * 订单下一步处理
	 * @param orderid	订单编号
	 * @return	String[2] 失败返回NULL
	 * @throws Exception
	 */
	public String[] doNextProcess(String orderid) throws Exception;
	/**
	 * 订单下一步处理-处理一批数据
	 * @param orderids 订单编号数组
	 * @return
	 * @throws Exception
	 */
	public List<NextProcessResult> doNextProcess(String[] orderids) throws Exception;
	
	/**
	 * 订单收费
	 * @param vo
	 * @throws Exception
	 */
	public void doPay(OrderVO vo) throws Exception;
	
	/**
	 * 订单入帐
	 * @param orderid	订单编号
	 * @throws Exception
	 */
	public OrderVO doRecorded(String orderid,String bossworkid) throws Exception;
	
//	/**2010-03-30 去除  （原本用于前台处理，后移至后台独立程序处理 为免有地方引用暂时注释）
//	 * 订单自动处理
//	 * @param sleepMin 无数据时的休眠分钟数
//	 * @throws Exception
//	 */
//	public void autoProcess(int sleepMin) throws Exception;
	
	/**
	 * 订单入帐
	 * @param orderid	订单编号
	 * @param wayid 操作员渠道ID
	 * @param bossworkid
	 *            boss工单号
	 * bossworkid：0或-1.  后台订单处理类调用为0.其他的调用为-1
	 * CRM入帐的时候0 表示CRM入帐中；BOSS入帐的时候0表示通过自动入帐来处理；-1都表示入帐失败 
	 * @throws Exception
	 */
	public OrderVO recorded(String orderid,String wayid,String bossworkid) throws Exception;
	
	/**
	 * 史晓龙：2012年5月26日，这个方法进过多次修改，里面混杂了BOSS入账和CRM入账，建议以后写代码不要再使用，
	 * BOSS改用recordByBoss2(String orderid, String wayid)、recordByBoss(String orderid, String wayid ,String operid)；
	 * CRM改用recordByCRM(String orderid, String wayid)、recordByCRM(String orderid, String wayid, String operid)
	 * 订单入帐(调用ＢＯＳＳ、CRM接口)
	 * @param orderid	订单编号
	 * @param wayid 操作员渠道ID
	 * @throws Exception
	 */
	@Deprecated
	public OrderVO recordByBoss(String orderid, String wayid) throws Exception;//此方法中兼做BOSS和CRM入账
	
	public OrderVO recordByBoss2(String orderid, String wayid) throws Exception;//纯BOSS入账
	/**
	 * BOSS入账
	 * @param orderid
	 * @param wayid
	 * @param operid
	 * @return
	 * @throws Exception
	 */
	public OrderVO recordByBoss(String orderid, String wayid ,String operid) throws Exception;//纯BOSS入账
	/**
	 * CRM入账
	 * @param orderid
	 * @param wayid
	 * @return
	 * @throws Exception
	 */
	public OrderVO recordByCRM(String orderid, String wayid) throws Exception;//纯CRM入账，CX和HW
	/**
	 * CRM入账
	 * @param orderid
	 * @param wayid
	 * @param operid
	 * @return
	 * @throws Exception
	 */
	public OrderVO recordByCRM(String orderid, String wayid, String operid) throws Exception;//纯CRM入账，CX和HW
	
	public String[] bossSupplyRecorded(String[] orders,String wayid) throws Exception;
	/**
	 * 获取订单号
	 * @param date
	 * @throws Exception
	 */
	public String doGetOrderId(Date date) throws Exception;
	
	public String cancleOrder(String[] pkItem, String cancelReason, String cancelDes) throws Exception;
	
	public String doDeletebosssupply(String[] pkItem) throws Exception;
	
	public void doCancle(OrderVO vo) throws Exception;
	
	public DataPackage doQueryAdpaydet(String _ne_sumid) throws Exception;
	
	public Long doQueryOrderedToday(OrderDBParam params,String wayid,String comcategory) throws Exception;
	
	public Long doQueryOrderedMonth(OrderDBParam params,String wayid,String comcategory) throws Exception;
    /**
     * 查询封装审核辅助信息集合
     * @param orderVO
     * @throws Exception
     */
    public List<AuxiliaryInfoVO> doGetAuxiliaryInfo(OrderVO orderVO)throws Exception;
    /**
     * 获取主动放弃数
     * @param wayid
     * @param monthParam
     * @return
     * @throws Exception
     */
    public Long doGetGiveCount(String wayid,String monthParam)throws Exception;
    
    /**
     * 获取在订库存量(区分品牌)
     * @param wayid
     * @param brand
     * @return
     * @throws Exception
     */
    public Long doGetOrderingStockAmountWithBrand(String wayid,String brand) throws Exception;
    
    /**
     * 获取在订库存量(不区分品牌)
     * @param wayid
     * @return
     * @throws Exception
     */
    public Long doGetOrderingStockAmountNotWithBrand(String wayid) throws Exception;
    public Map doFindStockInfo(String[] orderids) throws Exception ;
    /**
     * 发送售卡短信
     * @param orderVO
     * @throws Exception
     */
	public void doSmsForSale(OrderVO orderVO) throws Exception ;
	
	public DataPackage doListForAudit(OrderDBParam params) throws Exception;
	
	public void doProcess(DBAccessUser user) throws Exception;
	
	public DataPackage doQueryOrderDisform(OrderDBParam params) throws Exception;
	
	/**
	 * 订购作废后，短信通知
	 * @param pkItem
	 * @param cancelReason
	 * @param cancelDes
	 * @throws Exception
	 */
	public void doSmsAfterCancel(String[] pkItem, String cancelReason, String cancelDes) throws Exception ;
	
	public List doExcelRes(OrderDBParam orderDBParam) throws Exception ;
	
	//批量复核（单条记录复核）
	public void doReview(String orderid) throws Exception ;	
	
	/**
	 * 接口调用成功后通知网店可以销售。
	 * @param orderid 订单编号
	 * @throws Exception
	 */
	public void doSendSucInfo(String orderid) throws Exception;
	
	
	
	/**
	 * 接口调用失败后短信提醒渠道主管
	 * 
	 * @param orderid
	 *            订单编号
	 * @param countyid
	 *           	分公司
	 * @throws Exception
	 */
	public void doSendFailInfo(String orderid, String countyid)	throws Exception ;
	
	//计算实收金额的汇总信息
	public Double getAllActAmt(DataPackage dp) throws Exception;
	
	
	//计算各个品牌的汇总信息
	public String getAllBrandInfo(DataPackage dp) throws Exception;
	
	
	//批量触发划扣结果短信
	public void doDeductSendMsg(OrderVO orderVo, String optype, String result, String reason) throws Exception; 
	
	//批量处理需要调整的数据
	public boolean doDealAllocateData(String[] items) throws Exception;
	
	//发票打印
	public JSONArray doAjaxPrint(String orderid) throws Exception;
	
	//业务单打印
	public JSONArray doAjaxPrintBusiness(String orderid,OrderVO orderVO) throws Exception;
	
}
