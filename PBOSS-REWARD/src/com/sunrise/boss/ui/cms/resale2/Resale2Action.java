/**
 * auto-generated code
 * Mon Feb 04 12:03:22 CST 2008
 */
package com.sunrise.boss.ui.cms.resale2;

import com.sunrise.boss.ui.base.*;
import com.sunrise.boss.business.cms.resale2.persistent.Resale2VO;

/**
 * <p>
 * Title: Rule2Action
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
public class Resale2Action extends BaseAction {
	public Resale2Action() {
		// ���¼��������Ǳ����
		// ָ��VO��
		setVoClass(Resale2VO.class);
		// ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
		this.pkNameArray = new String[1];
		pkNameArray[0] = "opnid";
	}
}
