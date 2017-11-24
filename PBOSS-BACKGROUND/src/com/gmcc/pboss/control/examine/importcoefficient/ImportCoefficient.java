package com.gmcc.pboss.control.examine.importcoefficient;

import com.sunrise.jop.infrastructure.control.AbstractControl;

public interface ImportCoefficient extends AbstractControl{
	
	public void doImport(String exmnperiod) throws Exception;

	/**
	 * 标准卡固定酬金考核系数
	 * @param exmnperiod	考核周期格式（yyyyMMdd)
	 * @param exmnid		考核标识
	 * @throws Exception
	 */
	public void  doStandardImmutable(String exmnperiod,Long exmnid) throws Exception;
	
	/**
	 * 标准卡积分酬金考核系数
	 * @param exmnperiod	考核周期格式（yyyyMMdd)
	 * @param exmnid		考核标识
	 * @throws Exception
	 */
	public void  doStandardIntegral(String exmnperiod,Long exmnid) throws Exception;
	
	
	/**
	 * 标准卡专门津贴考核系数
	 * @param exmnperiod	考核周期格式（yyyyMMdd)
	 * @param exmnid		考核标识
	 * @throws Exception
	 */
	public void  doStandardBaksheesh(String exmnperiod,Long exmnid) throws Exception;
	
	/**
	 * 数据业务基本酬金考核系数
	 * @param exmnperiod	考核周期格式（yyyyMMdd)
	 * @param exmnid		考核标识
	 * @throws Exception
	 */
	public void  doDataOperationBase(String exmnperiod,Long exmnid) throws Exception;
	
	/**
	 * 数据业务奖励酬金考核系数
	 * @param exmnperiod	考核周期格式（yyyyMMdd)
	 * @param exmnid		考核标识
	 * @throws Exception
	 */
	public void  doDataOperationEncouragement(String exmnperiod,Long exmnid) throws Exception;
	
	/**
	 * 服务业务基本酬金考核系数
	 * @param exmnperiod	考核周期格式（yyyyMMdd)
	 * @param exmnid		考核标识
	 * @throws Exception
	 */
	public void  doServerOperationBase(String exmnperiod,Long exmnid) throws Exception;
	
	/**
	 * 服务业务奖励酬金考核系数
	 * @param exmnperiod	考核周期格式（yyyyMMdd)
	 * @param exmnid		考核标识
	 * @throws Exception
	 */
	public void  doServerOperationEncouragement(String exmnperiod,Long exmnid) throws Exception;
	
	/**
	 * 星级酬金考核系数
	 * @param exmnperiod	考核周期格式（yyyyMMdd)
	 * @param exmnid		考核标识
	 * @throws Exception
	 */
	public void  doStarLevel(String exmnperiod,Long exmnid) throws Exception;
	
	
	/**
	 * 项目启动金考核系数
	 * @param exmnperiod	考核周期格式（yyyyMMdd)
	 * @param exmnid		考核标识
	 * @throws Exception
	 */
	public void  doProjectStart(String exmnperiod,Long exmnid) throws Exception;
	
	/**
	 * 合作年限奖考核系数
	 * @param exmnperiod	考核周期格式（yyyyMMdd)
	 * @param exmnid		考核标识
	 * @throws Exception
	 */
	public void  doCooperateAward(String exmnperiod,Long exmnid) throws Exception;
	
	/**
	 * 全部考核系数
	 * @param exmnperiod	考核周期格式（yyyyMMdd)
	 * @param exmnid		考核标识
	 * @throws Exception
	 */
	public void  doAllCoefficient(String exmnperiod,Long exmnid) throws Exception;
	
	public void doAddRewardasse(String exmnperiod,Long exmnid,Integer rewardtype) throws Exception;
}


