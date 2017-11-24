package com.gmcc.pboss.control.sales.bgcontrol.Adpaysum;

import java.util.Map;

import com.sunrise.jop.infrastructure.control.AbstractControl;
/**
 * ���ʶ������� ��̨�߼�֮ҵ��Bean�ӿ�
 * @author zsw
 *
 */
public interface AdpaysumBg extends AbstractControl {

	/**
	 * <pre>
	 * ��ȡ��������ָ��ʱ���������ж�����
	 * Ϊ���ⶩ���������󣬵��¶�����ƴ�ӳ��ַ���ʱ�����ص��ַ�������������з�ҳ����
	 * </pre>
	 * @param begintime ��ʼʱ��
	 * @param endtime	��ֹʱ��
	 * @param paytype �ɷѷ�ʽ
	 * @param pagesize ��ҳ����ʱÿҳ���������
	 * @return 	<������,orderid1|orderid2|.....>
	 * @throws Exception
	 */
	public Map<String, String> doGetOrdersOfDisCom(String begintime,
			String endtime, String paytype, int pagesize) throws Exception;
	
	/**
	 * ͳ��ĳ��ʱ�������������̵Ķ��������˵����
	 * @param begintime
	 * @param endtime
	 * @param paytype
	 * @return <������,�������|�˵����>
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
