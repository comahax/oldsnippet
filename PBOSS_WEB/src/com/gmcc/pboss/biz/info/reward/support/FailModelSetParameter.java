package com.gmcc.pboss.biz.info.reward.support;

/**
 * 
 * 此接口定义了酬金校验失败查询中的一些属性值是通过外部缓存获取来设置的getter/setter方法
 * 
 */
public interface FailModelSetParameter {

	public String getAdtcode();

	public String getOpnid();

	public String getRewardtypeName();

	public void setRewardtypeName(String rewardtypeName);

	public String getOpnname();

	public void setOpnname(String opnname);

	public String getRemark();

	public void setRemark(String remark);

}
