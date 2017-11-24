/**
 * 
 */
package com.gmcc.pboss.client.boss.result;

/**
 * 分销商品销售BOSS退入账 结果包
 * 
 * @author hbm
 *
 */

/*
	回送报文 :
	
	datatrans：ret~说明;[标题;列宽段;]数据段;
	
	数据段格式：工单编号; （BOSS退入账操作产生的工单编号）
	ret=0   操作成功
	ret=1   未找到订单对应的商品资源
	ret=MMM 操作失败，要求在“说明”中描述失败原因
 */
public class CancelAccountResult extends IncomeAccountResult{

}
