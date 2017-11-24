package com.sunrise.boss.ui.cms.bbc.constant;

/**
 * <p>
 * </p>
 * <p>
 * Description: BBC网站酬金类型(CH_BBCREWARDTYPE)
 * </p>
 * <p>
 * Copyright: Copyright (c) 2007
 * </p>
 * <p>
 * Company: SUNRISE Tech Ltd.
 * </p>
 * 
 * @author Linli
 * @version 1.0 2008年8月27日13:55:39
 */


/**
 * 酬金类型(CH_BBCREWARDTYPE)
 * 9	销售类基本酬金
 * 10	销售类奖励酬金
 * 11	新增网站活跃客户基本酬金
 * 12	新增网站活跃客户奖励酬金
 * 13	e100活跃客户基本酬金
 * 14	e100活跃客户奖励酬金
 */

public class BBCRewardType {
	public final static int SELL_BASIC = 9; //销售类基本酬金
	public final static int SELL_ENCOURAGE = 10; //销售类奖励酬金
	public final static int ACTV_NEW_BASIC = 11; //新增网站活跃客户基本酬金
	public final static int ACTV_NEW_ENCOURAGE = 12; //新增网站活跃客户奖励酬金
	public final static int ACTV_E100_BASIC = 13; //e100活跃客户基本酬金
	public final static int ACTV_E100_ENCOURAGE = 14; //e100活跃客户奖励酬金
	public static String getName(int type) {
		switch (type) {
		case 9:
			return "销售类基本酬金";
		case 10:
			return "销售类奖励酬金";
		case 11:
			return "新增网站活跃客户基本酬金";
		case 12:
			return "新增网站活跃客户奖励酬金";
		case 13:
			return "e100活跃客户基本酬金";
		case 14:
			return "e100活跃客户奖励酬金";
		default:
			return "" + type;
		}
	}
}
