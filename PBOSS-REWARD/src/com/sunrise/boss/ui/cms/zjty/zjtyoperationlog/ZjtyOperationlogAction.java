package com.sunrise.boss.ui.cms.zjty.zjtyoperationlog;

/**
 * auto-generated code
 * Tue May 01 13:34:19 CST 2007
 */
import com.sunrise.boss.business.cms.zjty.zjtyoperationlog.persistent.ZjtyOperationlogVO;
import com.sunrise.boss.ui.base.BaseDelegateAction;

/**
 * <p>
 * Title: OperationAction
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
public class ZjtyOperationlogAction extends BaseDelegateAction {

	public ZjtyOperationlogAction() {
		// ���¼��������Ǳ����
		// ָ��VO��
		setVoClass(ZjtyOperationlogVO.class);
		// ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
		this.pkNameArray = new String[1];
		pkNameArray[0] = "logid";
	}
}
