package com.sunrise.boss.business.qsmanage.common;

/**
 * <p>
 * 省级平台固定参数常量
 * </p>
 */
public class Constant {
	public static final Long CHGREQOPRSTATE_SET = new Long(0);//请求状态:设置完成
	public static final Long CHGREQOPRSTATE_TEST = new Long(1);//请求状态:下发测试
	public static final Long CHGREQOPRSTATE_FB = new Long(2);//请求状态:正式发布
	public static final Long CHGREQOPRSTATE_CANCEL= new Long(3);//请求状态:撤销变更
}
