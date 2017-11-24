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
		// ���¼��������Ǳ����
		// ָ��VO��
		setVoClass(AdtcodeVO.class);
		// ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
		this.pkNameArray = new String[1];
		pkNameArray[0] = "adtcode";
	}
}
