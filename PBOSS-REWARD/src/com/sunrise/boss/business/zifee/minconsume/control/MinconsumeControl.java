/**
 * auto-generated code
 * Fri Aug 08 14:58:15 CST 2008
 */
package com.sunrise.boss.business.zifee.minconsume.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.zifee.minconsume.persistent.MinconsumeDAO;
import com.sunrise.boss.business.zifee.minconsume.persistent.MinconsumeVO;
import com.sunrise.boss.business.zifee.minconsume.persistent.MinconsumeListVO;

import java.io.Serializable;

/**
 * <p>
 * Title: MinconsumeControl
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
public interface MinconsumeControl extends AbstractControl {
	public MinconsumeVO doCreate(MinconsumeVO vo, User user) throws Exception;

	public void doRemove(MinconsumeVO vo, User user) throws Exception;

	public MinconsumeVO doUpdate(MinconsumeVO vo, User user) throws Exception;

	public MinconsumeVO doFindByPk(Serializable pk, User user) throws Exception;

	public DataPackage doQuery(MinconsumeListVO params, User user)
			throws Exception;

	public int calcResult(String yxplanid, User user) throws Exception;

	public boolean hasCyclecount(String yxplanid, User user) throws Exception;

	public boolean canRemove(String yxplanid,String effectiveinterval, User user) throws Exception;

	public int getNextIntevalValue(String yxplanid,String effectiveinterval, User user) throws Exception;
}
