package com.gmcc.pboss.control.examine.importcoefficient;

import com.sunrise.jop.infrastructure.control.AbstractControl;

public interface ImportCoefficient extends AbstractControl{
	
	public void doImport(String exmnperiod) throws Exception;

	/**
	 * ��׼���̶���𿼺�ϵ��
	 * @param exmnperiod	�������ڸ�ʽ��yyyyMMdd)
	 * @param exmnid		���˱�ʶ
	 * @throws Exception
	 */
	public void  doStandardImmutable(String exmnperiod,Long exmnid) throws Exception;
	
	/**
	 * ��׼�����ֳ�𿼺�ϵ��
	 * @param exmnperiod	�������ڸ�ʽ��yyyyMMdd)
	 * @param exmnid		���˱�ʶ
	 * @throws Exception
	 */
	public void  doStandardIntegral(String exmnperiod,Long exmnid) throws Exception;
	
	
	/**
	 * ��׼��ר�Ž�������ϵ��
	 * @param exmnperiod	�������ڸ�ʽ��yyyyMMdd)
	 * @param exmnid		���˱�ʶ
	 * @throws Exception
	 */
	public void  doStandardBaksheesh(String exmnperiod,Long exmnid) throws Exception;
	
	/**
	 * ����ҵ�������𿼺�ϵ��
	 * @param exmnperiod	�������ڸ�ʽ��yyyyMMdd)
	 * @param exmnid		���˱�ʶ
	 * @throws Exception
	 */
	public void  doDataOperationBase(String exmnperiod,Long exmnid) throws Exception;
	
	/**
	 * ����ҵ������𿼺�ϵ��
	 * @param exmnperiod	�������ڸ�ʽ��yyyyMMdd)
	 * @param exmnid		���˱�ʶ
	 * @throws Exception
	 */
	public void  doDataOperationEncouragement(String exmnperiod,Long exmnid) throws Exception;
	
	/**
	 * ����ҵ�������𿼺�ϵ��
	 * @param exmnperiod	�������ڸ�ʽ��yyyyMMdd)
	 * @param exmnid		���˱�ʶ
	 * @throws Exception
	 */
	public void  doServerOperationBase(String exmnperiod,Long exmnid) throws Exception;
	
	/**
	 * ����ҵ������𿼺�ϵ��
	 * @param exmnperiod	�������ڸ�ʽ��yyyyMMdd)
	 * @param exmnid		���˱�ʶ
	 * @throws Exception
	 */
	public void  doServerOperationEncouragement(String exmnperiod,Long exmnid) throws Exception;
	
	/**
	 * �Ǽ���𿼺�ϵ��
	 * @param exmnperiod	�������ڸ�ʽ��yyyyMMdd)
	 * @param exmnid		���˱�ʶ
	 * @throws Exception
	 */
	public void  doStarLevel(String exmnperiod,Long exmnid) throws Exception;
	
	
	/**
	 * ��Ŀ�����𿼺�ϵ��
	 * @param exmnperiod	�������ڸ�ʽ��yyyyMMdd)
	 * @param exmnid		���˱�ʶ
	 * @throws Exception
	 */
	public void  doProjectStart(String exmnperiod,Long exmnid) throws Exception;
	
	/**
	 * �������޽�����ϵ��
	 * @param exmnperiod	�������ڸ�ʽ��yyyyMMdd)
	 * @param exmnid		���˱�ʶ
	 * @throws Exception
	 */
	public void  doCooperateAward(String exmnperiod,Long exmnid) throws Exception;
	
	/**
	 * ȫ������ϵ��
	 * @param exmnperiod	�������ڸ�ʽ��yyyyMMdd)
	 * @param exmnid		���˱�ʶ
	 * @throws Exception
	 */
	public void  doAllCoefficient(String exmnperiod,Long exmnid) throws Exception;
	
	public void doAddRewardasse(String exmnperiod,Long exmnid,Integer rewardtype) throws Exception;
}


