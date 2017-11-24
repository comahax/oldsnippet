package com.gmcc.pboss.control.promotion.bgcontrol.PromotionsPresentingA;

import java.util.Map;

import open.tool.rule.data.VO;

import com.sunrise.jop.infrastructure.control.AbstractControl;

public interface PromotionsPresentingA extends AbstractControl {

	/**
	 * ��������������Ʒ�����������������ڡ�������ϸ[CH_CX_PRESENTINGDTL]�����������Ѵ���������¼
	 * @param srcData
	 * @param pid
	 * @param ruleid
	 * @throws Exception
	 */
	public void doHandlePresentingA(Map<VO, Object> srcData, long pid, long ruleid) 
		throws Exception;
	
	/**
	 * ���ͣ��º󣩴�������ģ����ڷ���
	 * @param pid ������ʶ
	 * @throws Exception
	 */
	public void doProcess(long pid) throws Exception;
}
