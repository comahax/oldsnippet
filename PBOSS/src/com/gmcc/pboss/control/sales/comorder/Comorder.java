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
	//��鹩Ӧ����Ϣ
    public WayVO doCheckWay(String wayid) throws Exception;
    //��ȡ�׿�Ʒ�Ƽ���
	public List<DictitemVO> doGetBrandList(String wayid) throws Exception;
    //��ȡ�׿���������Ϣ
    public List<ActiverateVO> doGetActiveList(String wayid,List<DictitemVO> brandlist) throws Exception;
    //�ж��׿�������Ϣ������/�����ơ���׼������ƻ���Ԥ������ģʽ��"MONDAYLIMIT"�������/�����ƣ�"STDSTOCK"����û�׼������ƣ�"STOCKALARM"�����Ԥ����棬"MONDAYSTOCK"���¿�����ģʽ
    public String doGetOrderMode() throws Exception;
	//��ȡ�׿�������Ϣ������/������
    public List<OrderMonthdayVO> doGetOrderInfoByMonthDay(WayVO wayVO,List<DictitemVO> brandlist) throws Exception;
    //�׿�������Ϣ������Ԥ��������ģʽ��
    public List<OrderMonthdayStockalarm> doGetOrderMonthdayStockalarm(List<OrderMonthdayVO> orderMonthdayList,List<OrderStockalarmVO> orderStockalarmList) throws Exception;
    //��ȡ�׿�������Ϣ������׼�������
    public List<OrderStdstockVO> doGetOrderInfoByStdstock(WayVO wayvo,List<DictitemVO> brandlist, List<ActiverateVO> activerateList) throws Exception;
    //��ȡ�׿�������Ϣ����Ԥ�����
    public List<OrderStockalarmVO> doGetOrderInfoByStockalarm(WayVO wayvo,List<DictitemVO> brandlist) throws Exception;
    //��ȡ�׿�������Ϣ�������¿�����ģʽ
    public List<OrderMonthdayStockVO> doGetOrderInfoByMonthdayStock(WayVO wayvo,List<DictitemVO> brandlist, List<ActiverateVO> activerateList) throws Exception;
    //���ó�ֵ��������Ϣ
    public List<OrderCardVO> doGetOrderInfoByCard(WayVO wayVO) throws Exception;
    //��ȡ������Դ����
	public String doGetStorArea(WayVO wayvo) throws Exception;
	//�������
	public Set<String> comOrderCheck(String wayid, List<ComorderVO> comorderList, String storarea) throws Exception;
	//��ȡ��Ʒ������ʾ��Ϣ
	public String doGetOrderHint() throws Exception;
	//��ȡ��Ʒ������Ϣ
	public Double doGetUnitprice(String wayid, String comcategory) throws Exception;
	//��ȡ��Ʒ������Ϣ���Ż�����������ʱ�������������Żݷ�ʽ��ͬʱ��õ��ۡ��Żݷ������룩
	public Map doGetUnitpriceAndPlancode(String wayid, String comcategory) throws Exception;
	//��ȡ��Ʒ������Ϣ(�Żݷ���)
	public Double doGetUnitprice(String wayid, String comcategory, String planCode) throws Exception;
	//��ȡ��������
	public String doGetUnitage(String cityid, String comcategory) throws Exception;
	/**
	 * ��������
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
	//��ȡ�����Ѷ�����
	public Long getMonordered(String wayid ,String begintime,String endtime) throws Exception;
	//��ȡ���������б�
	public List<CustwaytypeVO> doGetCustwaytypeList() throws Exception;
	//ƥ�����������ȡ������
	public Integer getQuantity(String wayid,String prodid,String effectmonth) throws Exception;
	//ƥ�����������ȡ������������ϸ
	public List<IncqttdtlVO> getIncqttdtlList(String wayid,String prodid,String effectmonth)throws Exception;
	//������һ������
	public void doNextProcess(String orderid) throws Exception;
	//��ȡ�������
	public String doGetOrderId() throws Exception;
	//�¶����������
	public void checkMonthBookTimes(String wayid) throws Exception;
	//����ϵͳ������[pboss_fx,63]������Ƿ���������϶���
	public boolean isMixOrderEnabled()throws Exception;
	
	//������Ʒ�����ȡ�����Żݷ���
	public Map<String,String> getSalePlanMap(String comcategory)throws Exception;
	
	//��ÿհ�sim����Ϣ
	public List<OrderEmptyCardVO> getEmptySimInfo(WayVO way) throws Exception;
	public List<OrderCardVO> doGetOrderInfoByEmptyCard(WayVO wayVO) throws Exception;
}
