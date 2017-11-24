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
	 * ���¶���״̬
	 * @param pkItem	������(��)
	 * @param state		����Ϊ����״̬
	 * @throws Exception
	 */
	public void setOrderState(String[] pkItem,String state) throws Exception;
	
	/**
	 * ������һ������
	 * @param orderid	�������
	 * @return	String[2] ʧ�ܷ���NULL
	 * @throws Exception
	 */
	public String[] doNextProcess(String orderid) throws Exception;
	/**
	 * ������һ������-����һ������
	 * @param orderids �����������
	 * @return
	 * @throws Exception
	 */
	public List<NextProcessResult> doNextProcess(String[] orderids) throws Exception;
	
	/**
	 * �����շ�
	 * @param vo
	 * @throws Exception
	 */
	public void doPay(OrderVO vo) throws Exception;
	
	/**
	 * ��������
	 * @param orderid	�������
	 * @throws Exception
	 */
	public OrderVO doRecorded(String orderid,String bossworkid) throws Exception;
	
//	/**2010-03-30 ȥ��  ��ԭ������ǰ̨������������̨���������� Ϊ���еط�������ʱע�ͣ�
//	 * �����Զ�����
//	 * @param sleepMin ������ʱ�����߷�����
//	 * @throws Exception
//	 */
//	public void autoProcess(int sleepMin) throws Exception;
	
	/**
	 * ��������
	 * @param orderid	�������
	 * @param wayid ����Ա����ID
	 * @param bossworkid
	 *            boss������
	 * bossworkid��0��-1.  ��̨�������������Ϊ0.�����ĵ���Ϊ-1
	 * CRM���ʵ�ʱ��0 ��ʾCRM�����У�BOSS���ʵ�ʱ��0��ʾͨ���Զ�����������-1����ʾ����ʧ�� 
	 * @throws Exception
	 */
	public OrderVO recorded(String orderid,String wayid,String bossworkid) throws Exception;
	
	/**
	 * ʷ������2012��5��26�գ����������������޸ģ����������BOSS���˺�CRM���ˣ������Ժ�д���벻Ҫ��ʹ�ã�
	 * BOSS����recordByBoss2(String orderid, String wayid)��recordByBoss(String orderid, String wayid ,String operid)��
	 * CRM����recordByCRM(String orderid, String wayid)��recordByCRM(String orderid, String wayid, String operid)
	 * ��������(���ã£ϣӣӡ�CRM�ӿ�)
	 * @param orderid	�������
	 * @param wayid ����Ա����ID
	 * @throws Exception
	 */
	@Deprecated
	public OrderVO recordByBoss(String orderid, String wayid) throws Exception;//�˷����м���BOSS��CRM����
	
	public OrderVO recordByBoss2(String orderid, String wayid) throws Exception;//��BOSS����
	/**
	 * BOSS����
	 * @param orderid
	 * @param wayid
	 * @param operid
	 * @return
	 * @throws Exception
	 */
	public OrderVO recordByBoss(String orderid, String wayid ,String operid) throws Exception;//��BOSS����
	/**
	 * CRM����
	 * @param orderid
	 * @param wayid
	 * @return
	 * @throws Exception
	 */
	public OrderVO recordByCRM(String orderid, String wayid) throws Exception;//��CRM���ˣ�CX��HW
	/**
	 * CRM����
	 * @param orderid
	 * @param wayid
	 * @param operid
	 * @return
	 * @throws Exception
	 */
	public OrderVO recordByCRM(String orderid, String wayid, String operid) throws Exception;//��CRM���ˣ�CX��HW
	
	public String[] bossSupplyRecorded(String[] orders,String wayid) throws Exception;
	/**
	 * ��ȡ������
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
     * ��ѯ��װ��˸�����Ϣ����
     * @param orderVO
     * @throws Exception
     */
    public List<AuxiliaryInfoVO> doGetAuxiliaryInfo(OrderVO orderVO)throws Exception;
    /**
     * ��ȡ����������
     * @param wayid
     * @param monthParam
     * @return
     * @throws Exception
     */
    public Long doGetGiveCount(String wayid,String monthParam)throws Exception;
    
    /**
     * ��ȡ�ڶ������(����Ʒ��)
     * @param wayid
     * @param brand
     * @return
     * @throws Exception
     */
    public Long doGetOrderingStockAmountWithBrand(String wayid,String brand) throws Exception;
    
    /**
     * ��ȡ�ڶ������(������Ʒ��)
     * @param wayid
     * @return
     * @throws Exception
     */
    public Long doGetOrderingStockAmountNotWithBrand(String wayid) throws Exception;
    public Map doFindStockInfo(String[] orderids) throws Exception ;
    /**
     * �����ۿ�����
     * @param orderVO
     * @throws Exception
     */
	public void doSmsForSale(OrderVO orderVO) throws Exception ;
	
	public DataPackage doListForAudit(OrderDBParam params) throws Exception;
	
	public void doProcess(DBAccessUser user) throws Exception;
	
	public DataPackage doQueryOrderDisform(OrderDBParam params) throws Exception;
	
	/**
	 * �������Ϻ󣬶���֪ͨ
	 * @param pkItem
	 * @param cancelReason
	 * @param cancelDes
	 * @throws Exception
	 */
	public void doSmsAfterCancel(String[] pkItem, String cancelReason, String cancelDes) throws Exception ;
	
	public List doExcelRes(OrderDBParam orderDBParam) throws Exception ;
	
	//�������ˣ�������¼���ˣ�
	public void doReview(String orderid) throws Exception ;	
	
	/**
	 * �ӿڵ��óɹ���֪ͨ����������ۡ�
	 * @param orderid �������
	 * @throws Exception
	 */
	public void doSendSucInfo(String orderid) throws Exception;
	
	
	
	/**
	 * �ӿڵ���ʧ�ܺ����������������
	 * 
	 * @param orderid
	 *            �������
	 * @param countyid
	 *           	�ֹ�˾
	 * @throws Exception
	 */
	public void doSendFailInfo(String orderid, String countyid)	throws Exception ;
	
	//����ʵ�ս��Ļ�����Ϣ
	public Double getAllActAmt(DataPackage dp) throws Exception;
	
	
	//�������Ʒ�ƵĻ�����Ϣ
	public String getAllBrandInfo(DataPackage dp) throws Exception;
	
	
	//�����������۽������
	public void doDeductSendMsg(OrderVO orderVo, String optype, String result, String reason) throws Exception; 
	
	//����������Ҫ����������
	public boolean doDealAllocateData(String[] items) throws Exception;
	
	//��Ʊ��ӡ
	public JSONArray doAjaxPrint(String orderid) throws Exception;
	
	//ҵ�񵥴�ӡ
	public JSONArray doAjaxPrintBusiness(String orderid,OrderVO orderVO) throws Exception;
	
}
