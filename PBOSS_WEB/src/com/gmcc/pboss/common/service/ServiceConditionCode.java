package com.gmcc.pboss.common.service;

public class ServiceConditionCode {
	/**
	 * 酬金渠道编码
	 */
	public static int REWARD_WAY = 101;
	/**
	 * 酬金业务代码
	 */
	public static int REWARD_OPN = 102;
	/**
	 * 酬金月份
	 */
	public static int REWARD_MONTH = 103;
	/**
	 * 酬金月份格式
	 */
	public static int REWARD_MONTH_FORMAT = 104;
	/**
	 * 人员手机号码
	 */
	public static int REWARD_MOBILE = 105;
	/**
	 * 报表类型不能为空
	 */
	public static int REWARD_TYPE = 106;
	/**
	 * 考核渠道编码
	 */
	public static int EXAMINE_WAY = 101;

	// 月度套卡激活登记明细
	/**
	 * 月度套卡激活登记明细-渠道编码
	 */
	public static int REGACTINFO_WAY = 101;

	/**
	 * 月度套卡激活登记明细-月份
	 */
	public static int REGACT_OPRTIME = 102;// 日期
	/**
	 * 月度套卡激活登记明细-月份格式
	 */
	public static int REGACT_OPRTIME_FORMAT = 103;// 日期格式

	/**
	 * 月度套卡激活登记明细-套卡号码
	 */
	public static int REGACT_MOBILE = 104;//
	/**
	 * 销售报表查询 渠道编码
	 */
	public static int SALES_WAY = 101;//
	/**
	 * 销售报表查询 商品种类
	 */
	public static int SALES_COMTYPE = 104;//

	/**
	 * 验证参数对象类型
	 */
	public static int REGACT_PARAMETER_TYPE = 105;

	/**
	 * 验证 daos 有没有被初始化
	 */
	public static int FAIL_DAOS_INIT = 101;//
	/**
	 * 验证 对象是不是 FailModelSetParameter 的实现类
	 */
	public static int FAIL_ASSIGNABLE_FROM = 102;//
	/**
	 * 验证 对象是不是 有效继续 的实现类
	 */
	public static int ASSIGNABLE_FROM = 102;//
	/**
	 * 验证 dao 是不是为NULL
	 */
	public static int FAIL_DAO = 103;//
	
	/**
	 * 验证ID是否为空
	 */
	public static int ID_EMPTY = 200;//
}
