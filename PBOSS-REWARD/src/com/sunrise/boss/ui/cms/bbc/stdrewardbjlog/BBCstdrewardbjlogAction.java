package com.sunrise.boss.ui.cms.bbc.stdrewardbjlog;

import com.sunrise.boss.business.cms.bbc.stdrewardbjlog.persistent.BBCstdrewardbjlogVO;
import com.sunrise.boss.ui.base.BaseDelegateAction;

/**
 * <p>
 * Title: BBCstdrewardbjlogAction
 * </p>
 * <p>
 * Description: 
 * </p>
 * <p>
 * Copyright: Copyright (c) 2007
 * </p>
 * <p>
 * Company: SUNRISE Tech Ltd.
 * </p>
 * 
 * @author Linli
 * @version 1.0 2008-08-26
 */
public class BBCstdrewardbjlogAction extends BaseDelegateAction {

	public BBCstdrewardbjlogAction() {
		setVoClass(BBCstdrewardbjlogVO.class);
		this.pkNameArray = new String[1];
		pkNameArray[0] = "logid";
	}
}
