/**
 * auto-generated code
 * Wed Oct 14 17:29:02 CST 2009
 */
package com.gmcc.pboss.control.sales.disform;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.disform.DisformDBParam;
import com.gmcc.pboss.business.sales.disform.DisformVO;
import com.gmcc.pboss.business.sales.disform.GDisformVO;
import com.gmcc.pboss.business.sales.disform.PDisformVO;
import com.gmcc.pboss.business.sales.order.OrderVO;
import com.gmcc.pboss.business.sales.orderresdet.OrderresdetDBParam;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Disform </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public interface Disform extends AbstractControl {
	
    public DisformVO doCreate(DisformVO vo) throws Exception;

    public void doRemoveByVO(DisformVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public DisformVO doUpdate(DisformVO vo) throws Exception;

    public DisformVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(DisformDBParam params) throws Exception;
    
    public DataPackage doQueryPrint(DisformDBParam params) throws Exception;
    
    public DataPackage doQueryPrintDp(DisformDBParam params) throws Exception;
    
    public String doGetBatchnoBoxnum(PDisformVO vo) throws Exception;
    
    public DataPackage doBatchnoBoxnumDp(OrderresdetDBParam params) throws Exception;
    
    public String doGetMinMaxComresid(PDisformVO vo) throws Exception;
    
    public void doUpdateOrder(DisformVO vo) throws Exception;
    
    public DataPackage doGatherPrintDp(DisformDBParam params) throws Exception;
    
    public Double doQuerySellingprice(GDisformVO vo) throws Exception;
    
    public Long getQueryComprice(String comid) throws Exception;
    
    public DataPackage doQueryDisState(DisformDBParam params) throws Exception;
    
    public DataPackage doQuerySignnum(DisformDBParam params) throws Exception;
    
    public void dosSendMsg(DisformVO updatevo) throws Exception;
    
    //配送单管理-确认签收 (短信)
    public void doComfirmSignMsg(DisformVO disformVO) throws Exception;
    
    //根据系统参数处理订单状态
    public void doDealOrderBySys(String[] selectArray) throws Exception;
    
    //更新订单状态已签收，然后调用下一步方法
    public void doUpdateOrderState(OrderVO ordervo) throws Exception;
    
    // 修改商品订购辅助信息表是否可发起订购值为1
    public void doUpdateWayassistant(OrderVO ordervo) throws Exception;

}
