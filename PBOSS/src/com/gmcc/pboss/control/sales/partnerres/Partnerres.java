/**
 * auto-generated code
 * Tue Oct 20 17:13:30 CST 2009
 */
package com.gmcc.pboss.control.sales.partnerres;

import java.io.Serializable;
import java.util.Date;

import com.gmcc.pboss.business.sales.partnerres.PartnerresDBParam;
import com.gmcc.pboss.business.sales.partnerres.PartnerresVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Partnerres </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public interface Partnerres extends AbstractControl {
    public PartnerresVO doCreate(PartnerresVO vo) throws Exception;

    public void doRemoveByVO(PartnerresVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public PartnerresVO doUpdate(PartnerresVO vo) throws Exception;

    public PartnerresVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(PartnerresDBParam params) throws Exception;
    
    /**
     * ͳ���׿��Ѽ����� 
     * @param countyid
     * @param comcategory
     * @param targetDay
     * @return
     * @throws Exception
     */
    public Integer doStatSMPActiveQty(String countyid,String comcategory,int targetDay) throws Exception;
    /**
     * ͳ���׿���������
     * @param countyid
     * @param comcategory
     * @param targetDay
     * @return
     * @throws Exception
     */
    public Integer doStatSMPSoldQty(String countyid,String comcategory,int targetDay) throws Exception;
    
    /**
     * ��Ʒ��ͳ�Ƹ���������ָ��������ڵ��׿�������,��Ʒ�Ʊ�����ָ������·���ÿ���¶�Ҫ�м�����
     * @param begintime
     * @param endtime
     * @param intervalMonth ����·���
     * @return
     * @throws Exception
     */
    public DataPackage doStatSMPActiveQtyInMonths(Date begintime,Date endtime,int intervalMonth) throws Exception ;
    
    /**
     * ���ֹ�˾��Ʒ��ͳ��ĳ�ֹ�˾���׿���Դ�ܿ��
     * @param isactive
     * @param restype
     * @return
     * @throws Exception
     */
    public DataPackage doStatCountyQty(int isactive,String restype) throws Exception ;
    
    /**
     * ���ֹ�˾��Ʒ��ͳ��ĳ�ֹ�˾ǰdays������ȡ���׿���Դ�� ��̨[��Դ���Ԥ��]ʹ��
     * @param days
     * @param restype
     * @return
     * @throws Exception
     */
    public DataPackage doStatCountyReceivedQty(int days, String restype) throws Exception;
    
    /**
     * ���������̱���[WAYID]������Ʒ��[BRAND]������ͳ�ƣ�ȡ�����㡰�������
     * @return
     * @throws Exception
     */
    public DataPackage doStatWayStdAmount() throws Exception;

    /**
     * ���������̱���[WAYID]�� ����Ʒ��[BRAND]������ͳ�ƣ�ȡ��ָ��ʱ�������㡰�������
     * @param begintime
     * @param endtime
     * @return
     * @throws Exception
     */
    public DataPackage doStatWayLHAmount(Date begintime,Date endtime) throws Exception;
    
    /**
     * ���������̱���[WAYID]�� ����Ʒ��[BRAND]������ͳ�ƣ�ȡ��ָ��ʱ�������㡰����������
     * @param begintime
     * @param endtime
     * @return
     * @throws Exception
     */
    public DataPackage doStatWayActiveAmount(Date begintime,Date endtime) throws Exception;
    
    /**
     * ���������̱���[WAYID]�� ����Ʒ��[BRAND]������ͳ��
     * ����ʱ��ͼ���ʱ����ͬһ��ʱ����ڵ����㡰��������
     * @param begintime
     * @param endtime
     * @return
     * @throws Exception
     */
    public DataPackage doStatActiveAmount_2(Date begintime,Date endtime) throws Exception;
    
    /**
     * ͳ�������̵��ʵĶ����Դ������������
     * @param restype
     * @return
     * @throws Exception
     */
    public DataPackage doStatWayOrderForSnapShot(String restype) throws Exception;
   
    public DataPackage doComcategoryQty(String wayid)throws Exception;
    
    /**
	 * ��ȡ�հ�SIM����ʹ����
	 */
    public DataPackage doEmptySimUseCount(String wayid) throws Exception;
}
