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
    
    //��ѯ������������������Ʒ�ƣ�
	public Long doQueryOrderamtByAllBrand(String orderid) throws Exception;
	
	//��ѯ������������������Ʒ�ƣ�
	public Long doQueryOrderamtByBrand(String orderid, String brand) throws Exception;

    public DataPackage doQueryByNameSql(String nameSql,OrdercomcateDBParam params)
	throws Exception; 
    public void doAmtadjSave(String recid,String orderamt,String memo)throws Exception;
	/**
	 * ��ѯ��˿�����������Ϣ
	 * @param orderids
	 * @return
	 * @throws Exception
	 */
	 public List<OrdercomcateStocksVO> doOrdercomcateStocksQuery(String[] orderids ) throws Exception;
	 
	 /**
	     *�Կͻ������հ�SIM����������ͳ��
	     * @param orderid
	     * @return
	     * @throws Exception
	     */
	 public DataPackage doquerySimamtByOrderID(String orderid) throws Exception ;
	 
	 /**
	  * ������ѯ������FX_SW_ORDER���Ͷ�����Ʒ���ࣨFX_SW_ORDERCOMCATE��ͳ�ƺ����̵��¿հ׿�������
	  * @param wayid
	  * @return
	  * @throws Exception
	  */
	 public DataPackage doQueryEmptySimRealTimeUpdateDayMonthCount(String wayid) throws Exception ;
	 
	 /**
	  * ����������FX_SW_ORDER����������Ʒ�����FX_SW_ORDERCOMCATE���Ժ�����δ������ɵĿհ׿�����ͳ��
	  * @param wayid
	  * @return
	  * @throws Exception
	  */
	 
	 public DataPackage doQueryEmptySimRealTimeUpdateBuyCount(String wayid) throws Exception ;
	 
	 //�����������۽������ ��ͳ����Ʒ���ඩ��������
	 public DataPackage doQueryDataByOrderId (String orderid) throws Exception;
}
