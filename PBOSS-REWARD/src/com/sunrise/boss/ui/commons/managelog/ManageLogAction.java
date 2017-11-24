/**
 * auto-generated code
 * Fri Aug 11 16:47:18 CST 2006
 */
package com.sunrise.boss.ui.commons.managelog;

import com.sunrise.boss.business.common.managelog.persistent.ManageLogVO;
import com.sunrise.boss.ui.base.BaseAction;

/**
 * 
 * @author wgy
 * @version 1.0
 */

public class ManageLogAction extends BaseAction {
	public ManageLogAction() {
		this.voClass = ManageLogVO.class;
		// TODO: 给出主键的名字数组
		this.pkNameArray = new String[1];
		pkNameArray[0] = "logid";

	}
}
