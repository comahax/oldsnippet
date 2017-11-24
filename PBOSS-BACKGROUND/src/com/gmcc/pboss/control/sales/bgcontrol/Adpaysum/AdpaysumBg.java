package com.gmcc.pboss.control.sales.bgcontrol.Adpaysum;

import java.util.Map;

import com.sunrise.jop.infrastructure.control.AbstractControl;
/**
 * 垫资订单汇总 后台逻辑之业务Bean接口
 * @author zsw
 *
 */
public interface AdpaysumBg extends AbstractControl {

	/**
	 * <pre>
	 * 获取配送商在指定时间段里的所有订单号
	 * 为避免订单数量过大，导致订单号拼接成字符串时，返回的字符数据溢出，进行分页处理
	 * </pre>
	 * @param begintime 起始时间
	 * @param endtime	终止时间
	 * @param paytype 缴费方式
	 * @param pagesize 分页处理时每页处理的行数
	 * @return 	<配送商,orderid1|orderid2|.....>
	 * @throws Exception
	 */
	public Map<String, String> doGetOrdersOfDisCom(String begintime,
			String endtime, String paytype, int pagesize) throws Exception;
	
	/**
	 * 统计某个时间段里各个配送商的订单金额和退单金额
	 * @param begintime
	 * @param endtime
	 * @param paytype
	 * @return <配送商,订单金额|退单金额>
	 * @throws Exception
	 */
	public Map<String,String> doStatOrderAndUnsubSum(String begintime,
			String endtime, String paytype) throws Exception;
	
	public void doProcess(String[] parameters) throws Exception;
	
	public void doInsertAdpaySumAndDetail(String disCom, String sumValue,
			String begintime, String endtime, Map<String, String> orderMap) throws Exception ;
	
	public void doInsertAdpaySumAndDetail2(String disCom, double orderamt,
			double cancelamt, String begintime, String endtime,
			String orderidsStr) throws Exception;
	
	public void doProcess2(String[] parameters) throws Exception;
}
