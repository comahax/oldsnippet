/**
 * auto-generated code
 * Tue Oct 13 15:13:34 CST 2009
 */
package com.gmcc.pboss.control.sales.orderresdet;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.gmcc.pboss.business.resource.comcategoryrela.ComcategoryrelaVO;
import com.gmcc.pboss.business.sales.order.OrderVO;
import com.gmcc.pboss.business.sales.orderresdet.OrderresdetDBParam;
import com.gmcc.pboss.business.sales.orderresdet.OrderresdetVO;
import com.gmcc.pboss.common.utils.tools.TiedComInfo;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Orderresdet </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public interface Orderresdet extends AbstractControl {
    public OrderresdetVO doCreate(OrderresdetVO vo) throws Exception;

    public void doRemoveByVO(OrderresdetVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public OrderresdetVO doUpdate(OrderresdetVO vo) throws Exception;

    public OrderresdetVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(OrderresdetDBParam params) throws Exception;
    /**
     * 查询按商品种类，批次，包号分组订单资源明细信息
     * @return
     * @throws Exception
     */
    public DataPackage doQueryOrderresdetGroupView(OrderresdetDBParam param) throws Exception;
    /**
	 * 订单资源抽取
	 * @param orderresdetDBParam
	 * @return 返回信息
	 * @throws Exception
	 */
	public String doResdraw(OrderresdetDBParam orderresdetDBParam,boolean isUpdateOrder) throws Exception;
	/**
	 * 订单资源批量抽取
	 * @param orderresdetDBParam
	 * @return 返回信息
	 * @throws Exception
	 */
	public String doBatchResdraw(Map parameterMap,String orderid) throws Exception;
	
	/**
	 * 处理搭售/赠送的抽取方法
	 * 促销方案匹配：商品资源抽取完成后，调用促销方案（搭售/赠送）接口方法。
	 * 搭售/赠送资源抽取：如果存在搭售/赠送资源，则需要再次进行抽取，抽取逻辑参考上面的充值卡或商品包抽取逻辑。
	 * 同时新增数据到订单商品种类表（FX_SW_ORDERCOMCATE）和订单适用促销方案表（FX_SW_ORDERPLAN）。
	 * @param brandMap 品牌MAP
	 * @param sysparamvalue21 关联配送商参数
	 * @param comcateg 商品种类关系
	 * @param isbatchResdraw TODO
	 * @param comcate 订单商品种类
	 * @param orderresdetBO 订单资源明细BO
	 * @param nosect 所属号段（指定号段和循环号段才有，其他为NULL）
	 * @param isCycsect 是否循环号段查询
	 * @param paramMap 参数MAP类
	 * @return TODO
	 * @throws Exception
	 */
	public  String doTiedComResdraw(List<TiedComInfo> tiedComInfos,String ordercomtype,Map brandMap,String sysparamvalue21,String sysparamvalue38,OrderVO orderVo,ComcategoryrelaVO comcateg, boolean isbatchResdraw) throws Exception;
	
	/**
	 * 批量导出订单明细
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public DataPackage doQueryExp(OrderresdetDBParam params) throws Exception;
}
