/**
 * auto-generated code
 * Sun Jan 04 10:44:26 CST 2009
 */
package com.sunrise.boss.business.cms.reward.busiwayrel.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.busiwayrel.persistent.BusiwayrelVO;
import com.sunrise.boss.business.cms.reward.busiwayrel.persistent.BusiwayrelListVO;

import java.io.Serializable;

/**
 * <p>
 * Title: BusiwayrelControl
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author LiZhaoLiang
 * @version 1.0
 */
public interface BusiwayrelControl extends AbstractControl {
	public BusiwayrelVO doCreate(BusiwayrelVO vo, User user) throws Exception;

	public void doRemove(BusiwayrelVO vo, User user) throws Exception;

	public BusiwayrelVO doUpdate(BusiwayrelVO vo, User user) throws Exception;

	public BusiwayrelVO doFindByPk(Serializable pk, User user) throws Exception;

	public DataPackage doQuery(BusiwayrelListVO params, User user) throws Exception;

	public String doBatchRemove(BusiwayrelVO vo, User user) throws Exception;

	public String doBatchCreate(BusiwayrelVO vo, User user) throws Exception;

	public boolean checkIsLayer(String opnid, User user) throws Exception;
}
