package com.sunrise.boss.ui.cms.zjty.constant;

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
 * 80	标准卡销售酬金
 * 81	标准卡激活酬金
 * 82	标准卡客户质量奖
 * 83	服务业务基本酬金
 * 84	服务业务奖励酬金
 * 85	数据业务基本酬金
 * 86	数据业务奖励酬金
 * 87	终端销售基本酬金
 * 88   固定酬金
 */
public class ZjtyRewardType {
	public final static int CARD_FIXED = 80; //标准卡销售酬金
	public final static int CARD_INTEGRAL = 81; //标准卡激活酬金
	public final static int CARD_ALLOWANCE = 82; //标准卡客户质量奖
	public final static int SERV_BASIC = 83; //服务业务基本酬金
	public final static int SERV_ENCOURAGE = 84; //服务业务奖励酬金
	public final static int DATA_BASIC = 85; //数据业务基本酬金
	public final static int DATA_ENCOURAGE = 86; //数据业务奖励酬金
	public final static int CLIENT_BASIC = 87; //终端销售基本酬金
	public final static int FIXED_BASIC = 88; //固定酬金
	
	public static String getName(int type) {
		switch (type) {
		case 80:
			return "标准卡销售酬金";
		case 81:
			return "标准卡激活酬金";
		case 82:
			return "标准卡客户质量奖";
		case 83:
			return "服务业务基本酬金";
		case 84:
			return "服务业务奖励酬金";
		case 85:
			return "数据业务基本酬金";
		case 86:
			return "数据业务奖励酬金";
		case 87:
			return "终端销售基本酬金";
		case 88:
			return "固定酬金";
		default:
			return "" + type;
		}
	}
}
