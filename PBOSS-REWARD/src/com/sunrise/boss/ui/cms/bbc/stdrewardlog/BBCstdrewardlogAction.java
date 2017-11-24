package com.sunrise.boss.ui.cms.bbc.stdrewardlog;

import com.sunrise.boss.business.cms.bbc.stdrewardlog.persistent.BBCstdrewardlogVO;
import com.sunrise.boss.ui.base.BaseDelegateAction;

/**
 * <p>
 * Title: BBCstdrewardbjAction
 * </p>
 * <p>
 * Description: 计件酬金上限设置
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
public class BBCstdrewardlogAction extends BaseDelegateAction {

	public BBCstdrewardlogAction() {
		setVoClass(BBCstdrewardlogVO.class);
		this.pkNameArray = new String[1];
		pkNameArray[0] = "logid";
	}
}