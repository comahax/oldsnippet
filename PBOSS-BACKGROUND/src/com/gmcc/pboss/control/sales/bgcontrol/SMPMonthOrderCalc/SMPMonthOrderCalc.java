package com.gmcc.pboss.control.sales.bgcontrol.SMPMonthOrderCalc;

import java.util.Map;

import com.gmcc.pboss.business.sales.bgbusiness.PartnerSMPBrandVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.ui.User;

public interface SMPMonthOrderCalc extends AbstractControl {

	/**
	 * ɾ��monthָ���·ݵĶ���������
	 * @param destMonth
	 * @return
	 * @throws Exception
	 */
	 public int doDeleteMonthOrder(String destMonth) throws Exception;
	    
	    /**
	     * ��ȡ ��monthsָ���·��з�������ҵ��������������׿�Ʒ�Ƶ��ܼ�����
	     * @param months
	     * @param cityid
	     * @return ӳ���е� key = PartnerSMPBrandVO(��������id���׿�Ʒ��); value = ���·���|�ܼ�����|�����Ǽ�
	     * @throws Exception
	     */
	 public Map<PartnerSMPBrandVO,String> doStatMonthOrder(String[] months) throws Exception;
	 
	 /**
	  * ��������ʵ�ʶ������ͼ�����
	  * @param destMonth Ŀ���·� yyyyMM 
	  * destMonthΪnullֵʱĬ��ȡ��ǰ��
	  * @throws Exception
	  */
	 public void doUpdateLMOrderAndActive(String destMonth) throws Exception;
	 
	 /**
	  * �������¶���������
	  * @param destMonth
	  * @throws Exception
	  */
	 public void doCreateMonthOrder(String destMonth) throws Exception;
	 
	 /**
	  * ���������׿��¶��������㡱��ڷ���
	  * @param destMonth
	  * @throws Exception
	  */
	 public void doProcess(String destMonth) throws Exception;
}
