/**
 * auto-generated code
 * Fri Jan 04 15:56:32 CST 2008
 */
package com.sunrise.boss.business.cms.resale.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.resale.persistent.ResaleVO;
import com.sunrise.boss.business.cms.resale.persistent.ResaleListVO;

import java.io.Serializable;

/**
 * <p>
 * Title: ResaleControl
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
public interface ResaleControl extends AbstractControl {
	public ResaleVO doCreate(ResaleVO vo, User user) throws Exception;

	public void doRemove(ResaleVO vo, User user) throws Exception;

	public ResaleVO doUpdate(ResaleVO vo, User user) throws Exception;

	public ResaleVO doFindByPk(Serializable pk, User user) throws Exception;

	public DataPackage doQuery(ResaleListVO params, User user) throws Exception;

	public DataPackage getMobileSequence(String sql,User user) throws Exception;

	public String checkOpnID(String mobile, User user) throws Exception;
}
