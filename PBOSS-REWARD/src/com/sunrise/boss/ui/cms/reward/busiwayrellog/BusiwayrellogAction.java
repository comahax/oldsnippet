/**
 * auto-generated code
 * Fri Feb 15 15:25:15 CST 2008
 */
package com.sunrise.boss.ui.cms.reward.busiwayrellog;

import com.sunrise.boss.business.cms.reward.busiwayrellog.persistent.BusiwayrellogVO;
import com.sunrise.boss.ui.base.BaseDelegateAction;

/**
 * <p>
 * Title: BusiwayrellogAction
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2009
 * </p>
 * <p>
 * Company: Maywide Tech Ltd.
 * </p>
 * 
 * @author li zhaoliang
 * @version 1.0
 */
public class BusiwayrellogAction extends BaseDelegateAction {
	public BusiwayrellogAction() {
		// ���¼��������Ǳ����
		// ָ��VO��
		setVoClass(BusiwayrellogVO.class);
		// ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
		this.pkNameArray = new String[2];
		pkNameArray[0] = "opnid";
		pkNameArray[1] = "wayid";
	}
}
