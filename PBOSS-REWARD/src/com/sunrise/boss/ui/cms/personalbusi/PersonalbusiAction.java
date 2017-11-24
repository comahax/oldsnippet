/**
 * auto-generated code
 * Fri Aug 03 13:32:29 CST 2007
 */
package com.sunrise.boss.ui.cms.personalbusi;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.ui.base.*;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.personalbusi.persistent.PersonalbusiListVO;
import com.sunrise.boss.business.cms.personalbusi.persistent.PersonalbusiVO;
import com.sunrise.boss.delegate.cms.personalbusi.PersonalbusiDelegate;

/**
 * <p>
 * Title: PersonalbusiAction
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
 * @author WangHua
 * @version 1.0
 */
public class PersonalbusiAction extends BaseAction {
	public PersonalbusiAction() {
		// 以下几个方法是必须的
		// 指定VO类
		setVoClass(PersonalbusiVO.class);
		// 指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
		this.pkNameArray = new String[1];
		pkNameArray[0] = "itemid";
	}

}
