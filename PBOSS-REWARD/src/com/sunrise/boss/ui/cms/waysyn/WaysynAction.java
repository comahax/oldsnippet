/**
 * auto-generated code
 * Fri May 16 09:53:52 CST 2008
 */
package com.sunrise.boss.ui.cms.waysyn;

import com.sunrise.boss.ui.base.*;
import com.sunrise.boss.business.cms.waysyn.persistent.WaysynVO;
import com.sunrise.boss.delegate.cms.waysyn.WaysynDelegate;

/**
 * <p>
 * Title: WaysynAction
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
public class WaysynAction extends BaseDelegateAction {
	public WaysynAction() {
		// ���¼��������Ǳ����
		// ָ��VO��
		setVoClass(WaysynVO.class);
		// ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
		this.pkNameArray = new String[1];
		pkNameArray[0] = "itemid";
	}
}
