/**
 * auto-generated code
 * Mon Jan 05 11:36:43 CST 2009
 */
package com.sunrise.boss.business.cms.reward.busiwayrellog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.busiwayrellog.persistent.BusiwayrellogVO;
import com.sunrise.boss.business.cms.reward.busiwayrellog.persistent.BusiwayrellogListVO;

import java.io.Serializable;

/**
 * <p>Title: BusiwayrellogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public interface BusiwayrellogControl extends AbstractControl {
	public BusiwayrellogVO doCreate(BusiwayrellogVO vo, User user)
			throws Exception;

	public void doRemove(BusiwayrellogVO vo, User user) throws Exception;

	public BusiwayrellogVO doUpdate(BusiwayrellogVO vo, User user)
			throws Exception;

	public BusiwayrellogVO doFindByPk(Serializable pk, User user)
			throws Exception;

	public DataPackage doQuery(BusiwayrellogListVO params, User user)
			throws Exception;

}
