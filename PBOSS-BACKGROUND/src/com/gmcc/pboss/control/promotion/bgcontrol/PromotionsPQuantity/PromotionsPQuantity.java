package com.gmcc.pboss.control.promotion.bgcontrol.PromotionsPQuantity;

import java.math.BigDecimal;
import java.util.Map;

import open.tool.rule.data.VO;

import com.sunrise.jop.infrastructure.control.AbstractControl;

public interface PromotionsPQuantity  extends AbstractControl{

	/**
     * ͳ���ϸ��¸����������׿�������
     * @return
     * @throws Exception
     */
	public Map<String, BigDecimal> doStatActiveSMPLastMonth()
		throws Exception ;
	
	/**
	 * �����������������ѽ�����浽��������������ϸ�����У��������Ѵ���������¼
	 * 
	 * @param srcData
	 * @param pid
	 * @param ruleid
	 * @param cityid
	 * @throws Exception
	 */
	public void doHandlePQuantity(Map<VO, Object> srcData, long pid, long ruleid) throws Exception;
	
	/**
	 * ����������������ڷ���
	 * @param pid ������ʶ
	 * @throws Exception
	 */
	public void doProcess(long pid) throws Exception;
}
