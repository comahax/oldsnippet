/**
 * auto-generated code
 * Sat Feb 02 15:13:27 CST 2008
 */
package com.sunrise.boss.ui.cms.reward.disintegral;

import com.sunrise.boss.business.cms.reward.disintegral.persistent.DisintegralVO;
import com.sunrise.boss.ui.base.BaseDelegateAction;

/**
 * <p>
 * Title: DisintegralAction
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: Maywide Tech Ltd.
 * </p>
 * 
 * @author LiZhaoLiang
 * @version 1.0
 */
public class DisintegralAction extends BaseDelegateAction {
	public DisintegralAction() {
		// ���¼��������Ǳ����
		// ָ��VO��
		setVoClass(DisintegralVO.class);
		// ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
		this.pkNameArray = new String[1];
		pkNameArray[0] = "seq";
	}
}