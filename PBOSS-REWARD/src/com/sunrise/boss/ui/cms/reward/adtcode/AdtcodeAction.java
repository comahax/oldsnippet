package com.sunrise.boss.ui.cms.reward.adtcode;

import com.sunrise.boss.business.cms.reward.adtcode.persistent.AdtcodeVO;
import com.sunrise.boss.ui.base.BaseDelegateAction;

/**
 * <p>
 * Title: AdtcodeAction
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2008
 * </p>
 * <p>
 * Company: Maywide Tech Ltd.
 * </p>
 * 
 * @author	Linli
 * @version 1.0
 */
public class AdtcodeAction extends BaseDelegateAction {
	public AdtcodeAction() {
		// 以下几个方法是必须的
		// 指定VO类
		setVoClass(AdtcodeVO.class);
		// 指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
		this.pkNameArray = new String[1];
		pkNameArray[0] = "adtcode";
	}
}
