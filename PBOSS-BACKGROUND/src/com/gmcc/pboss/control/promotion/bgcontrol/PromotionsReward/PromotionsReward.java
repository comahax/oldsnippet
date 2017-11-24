package com.gmcc.pboss.control.promotion.bgcontrol.PromotionsReward;

import java.util.Map;

import open.tool.rule.data.VO;

import com.sunrise.jop.infrastructure.control.AbstractControl;

public interface PromotionsReward extends AbstractControl {

	/**
	 * �����������ѽ�����浽�����ϸ���������Ѵ���������¼
	 * @param srcData
	 * @param pid
	 * @param ruleid
	 * @throws Exception
	 */
	public void doHandleReward(Map<VO,Object> srcData, long pid, long ruleid) throws Exception;
	
	/**
	 * ����������ģ����ڷ���
	 * @param pid
	 * @throws Exception
	 */
	public void doProcess(long pid) throws Exception;
}
