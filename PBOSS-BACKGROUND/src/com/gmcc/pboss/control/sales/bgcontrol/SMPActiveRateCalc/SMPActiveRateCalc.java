package com.gmcc.pboss.control.sales.bgcontrol.SMPActiveRateCalc;

import java.math.BigDecimal;
import java.util.Map;

import com.gmcc.pboss.business.sales.bgbusiness.PartnerSMPBrandVO;
import com.gmcc.pboss.business.sales.noactinfo.NoactinfoDBParam;
import com.gmcc.pboss.business.sales.partnerres.PartnerresDBParam;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

public interface SMPActiveRateCalc extends AbstractControl {

	 /**
     *  <p>����7.5.38 �׿������ʼ���</p>
     *  <p>������Ʒ��</p>
     * 	<p>���պ����̱������ͳ�ƺ�������Դ��FX_SW_PARTNERRES����δ������Ѽ�����׿�����</p>
     * @param activeOrderDay   �Ѽ����׿���������
     * @param activeDay        �Ѽ����׿���������
     * @param inActiveOrderDay δ�����׿���������
     * @return
     */
    public Map<String,String> doStatSMPNotWithBrand(int activeOrderDay,int activeDay,int inActiveOrderDay) throws Exception;
    /**
     * <p>�����׿������ʼ���</p>
     * <p>����Ʒ��</p>
     * <p>���պ����̱��롢�׿�Ʒ�Ʒ���ͳ�ƺ�������Դ��FX_SW_PARTNERRES����δ������Ѽ�����׿�����</p>
     * @param activeOrderDay   �Ѽ����׿���������
     * @param activeDay        �Ѽ����׿���������
     * @param inActiveOrderDay δ�����׿���������
     * @param cityid
     * @return
     * @throws Exception
     */
    public Map<PartnerSMPBrandVO,Long[]> doStatSMPWithBrand(int activeOrderDay,int activeDay,int inActiveOrderDay) throws Exception;
    
    public Map<PartnerSMPBrandVO,BigDecimal> doStatInActiveSMPWithBrand() throws Exception;
    
    /**
     * <pre>
     * ����7.5.38 �׿������ʼ���
     * ����Ʒ��
     * ���ݺ����̱��룬�׿�Ʒ�� ����ͳ�ƺ�������Դ��FX_SW_PARTNERRES����ĳʱ�����ļ������Ͷ�����
     * </pre>
     * @param activeOrderDay �Ѽ����׿���������
     * @param activeDay      �Ѽ����׿���������
     * @param orderDay       ��������������
     * @return
     * @throws Exception
     */
    public Map<PartnerSMPBrandVO,String> doStatActiveAndOrderSMPWithBrand(int activeOrderDay,
			int activeDay,int orderDay) throws Exception ;
    /**
     * <pre>
     * ����7.5.38 �׿������ʼ���
     * ������Ʒ��
     * ���ݺ����̱��� ����ͳ�ƺ�������Դ��FX_SW_PARTNERRES����ĳʱ�����ļ������Ͷ�����
     * </pre>
     * @param activeOrderDay �Ѽ����׿���������
     * @param activeDay      �Ѽ����׿���������
     * @param orderDay       ��������������
     * @return
     * @throws Exception
     */
    public Map<String,String> doStatActiveAndOrderSMPNotWithBrand(int activeOrderDay,
			int activeDay,int orderDay) throws Exception ;
    
    /**
     * <pre>
     * ����7.5.39 �������׿��¶��������� 
     * ����Ʒ��
     * ���ݺ����̱��룬�׿�Ʒ�� �Ժ�������Դ��FX_SW_PARTNERRES�����ݷ���ͳ�����µĶ������ͼ�����
     * </pre> 
     * @param wayid
     * @param brand
     * @param firstDayOfMonth
     * @param endDayOfMonth
     * @return
     * @throws Exception
     */
    public BigDecimal[] doStatOrderAndActiveSMPWithBrand(String wayid,String brand,java.util.Date firstDayOfMonth,java.util.Date endDayOfMonth) throws Exception;
    /**
     * <pre>
     * ����7.5.39 �������׿��¶��������� 
     * ������Ʒ��
     * ���ݺ����̱��� �Ժ�������Դ��FX_SW_PARTNERRES�����ݷ���ͳ�����µĶ������ͼ�����
     * </pre>
     * @param wayid
     * @param firstDayOfMonth
     * @param endDayOfMonth
     * @return
     * @throws Exception
     */
    public BigDecimal[] doStatOrderAndActiveSMPNotWithBrand(String wayid,java.util.Date firstDayOfMonth,java.util.Date endDayOfMonth) throws Exception;
    
    /**
     * ͳ���ϸ��¸����������׿�������
     * @param cityid
     * @return ����������ʶ���������׿���������ӳ��
     * @throws Exception
     */
    public Map<String,BigDecimal> doStatActiveSMPLastMonth() throws Exception;
    
    /**
     * �������׿��������ݸ���
     * @param intervalDay ��������Դ���еĴ���ʱ��ͺ��뼤���¼���еļ���ʱ��ļ������
     * @return
     * @throws Exception
     */
    public int doSMPActiveUpdate(int intervalDay) throws Exception;
    
    /**
	 * ���ղ�ͬģʽ�����׿������ʼ���
	 * @throws Exception
	 */
    public void doSMPActiveRateCalc() throws Exception;
    
    /**
     * ���ϲ�ѯ ��������Դ��FX_SW_PARTNERRES���� ���뼤���¼��FX_SN_NOACTINFO��,
     * ���ͬʱ�������������е�δ������׿�
     * @param param1
     * @param param2
     * @return
     * @throws Exception
     */
    public DataPackage doUnionQuerySmpInfo(PartnerresDBParam param1, NoactinfoDBParam param2) throws Exception;
    
    /**
     * �׿������ʼ������ڷ���
     * @throws Exception
     */
    public void doProcess() throws Exception;
}
