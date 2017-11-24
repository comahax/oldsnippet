package com.sunrise.boss.ui.cms.zjty.zjtylvlrwd;

/**
 * auto-generated code
 * Tue May 01 13:34:19 CST 2007
 */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sunrise.boss.business.cms.zjty.zjtylvlrwd.persistent.ZjtyLvlrwdVO;
import com.sunrise.boss.ui.base.BaseDelegateAction;

/**
 * <p>
 * Title: ZjtyOperationAction
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
public class ZjtyLvlrwdAction extends BaseDelegateAction {

	private static final Log log = LogFactory.getLog(ZjtyLvlrwdAction.class);

	public ZjtyLvlrwdAction() {
		// 以下几个方法是必须的
		// 指定VO类
		setVoClass(ZjtyLvlrwdVO.class);
		// 指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
		this.pkNameArray = new String[1];
		pkNameArray[0] = "citylevel";
	}
}
