/**
 * auto-generated code
 * Fri Feb 01 18:09:59 CST 2008
 */
package com.sunrise.boss.business.cms.stdrewardbp.control;

import java.io.Serializable;

import com.sunrise.boss.business.cms.stdrewardbp.persistent.StdrewardbpListVO;
import com.sunrise.boss.business.cms.stdrewardbp.persistent.StdrewardbpVO;
import com.sunrise.boss.business.cms.stdrewardbp.persistent.StdrewardbpdVO;
import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: StdrewardbpControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface StdrewardbpControl extends AbstractControl {
	public StdrewardbpdVO doCreate(StdrewardbpdVO vo, User user) throws Exception;

	public void doRemove(StdrewardbpdVO vo, User user) throws Exception;

	public StdrewardbpdVO doUpdate(StdrewardbpdVO vo, User user) throws Exception;
	public StdrewardbpdVO doUpdate1(StdrewardbpdVO vo, User user) throws Exception;

	public StdrewardbpdVO doFindByPk(Serializable pk, User user)
			throws Exception;
	public StdrewardbpVO doFindByPkstar(Serializable pk, User user)
	throws Exception;

	public DataPackage doQuery(StdrewardbpListVO params, User user)
			throws Exception;

}
