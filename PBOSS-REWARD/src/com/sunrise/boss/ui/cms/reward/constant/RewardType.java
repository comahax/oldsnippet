package com.sunrise.boss.ui.cms.reward.constant;

/**
 * <p>
 * Title: StdrewardbjAction
 * </p>
 * <p>
 * Description: 酬金类型(CH_REWARDTYPE)
 * </p>
 * <p>
 * Copyright: Copyright (c) 2007
 * </p>
 * <p>
 * Company: SUNRISE Tech Ltd.
 * </p>
 * 
 * @author Zhang Fengchao
 * @version 1.0 2008-03-06
 */

/**
 * 酬金类型(CH_REWARDTYPE)
 * 0	标准卡固定酬金
 * 1	标准卡积分酬金
 * 2	标准卡专门津贴
 * 3	数据业务基本酬金
 * 4	数据业务奖励酬金
 * 5	服务业务基本酬金
 * 6	服务业务奖励酬金
 * 7	星级酬金
 * 8	项目启动金
 */
public class RewardType {
	public final static int CARD_FIXED = 0; //标准卡固定酬金
	public final static int CARD_INTEGRAL = 1; //标准卡积分酬金
	public final static int CARD_ALLOWANCE = 2; //标准卡专门津贴
	public final static int DATA_BASIC = 3; //数据业务基本酬金
	public final static int DATA_ENCOURAGE = 4; //数据业务奖励酬金
	public final static int SERV_BASIC = 5; //服务业务基本酬金
	public final static int SERV_ENCOURAGE = 6; //服务业务奖励酬金
	public final static int START = 7; //星级酬金
	public final static int STARTUP = 8; //项目启动金
	
	public static String getName(int type) {
		switch (type) {
		case 0:
			return "标准卡固定酬金";
		case 1:
			return "标准卡积分酬金";
		case 2:
			return "标准卡专门津贴";
		case 3:
			return "数据业务基本酬金";
		case 4:
			return "数据业务奖励酬金";
		case 5:
			return "服务业务基本酬金";
		case 6:
			return "服务业务奖励酬金";
		case 7:
			return "星级酬金";
		case 8:
			return "项目启动金";
		default:
			return "" + type;
		}
	}
}
