package com.sunrise.boss.ui.cms.zjty.zjtyrewardcoeflog;

/**
 * auto-generated code
 * Tue May 01 13:34:19 CST 2007
 */


import com.sunrise.boss.business.cms.zjty.zjtyrewardcoeflog.persistent.ZjtyRewardcoeflogVO;


import com.sunrise.boss.ui.base.BaseDelegateAction;


/**
 * <p>
 * Title: ZjtyRewardcoefAction
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
 * @author
 * @version 1.0
 */
public class ZjtyRewardcoeflogAction extends BaseDelegateAction {

	public ZjtyRewardcoeflogAction() {
		// ���¼��������Ǳ����
		// ָ��VO��
		setVoClass(ZjtyRewardcoeflogVO.class);
		// ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
		this.pkNameArray = new String[1];
		pkNameArray[0] = "logid";
	}
}
