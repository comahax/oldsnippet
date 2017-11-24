/**
* auto-generated code
* Thu Jul 12 15:24:43 CST 2012
*/
package com.sunrise.boss.business.cms.zjty.chzjtyrewfilenote.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.chzjtyrewfilenote.persistent.ChZjtyRewfilenoteVO;
import com.sunrise.boss.business.cms.zjty.chzjtyrewfilenote.persistent.ChZjtyRewfilenoteListVO;

import java.io.Serializable;

/**
 * <p>Title: ChZjtyRewfilenoteControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxx
 * @version 1.0
 */
public interface ChZjtyRewfilenoteControl extends AbstractControl {
    public ChZjtyRewfilenoteVO doCreate(ChZjtyRewfilenoteVO vo, User user)
        throws Exception;

    public void doRemove(ChZjtyRewfilenoteVO vo, User user)
        throws Exception;

    public ChZjtyRewfilenoteVO doUpdate(ChZjtyRewfilenoteVO vo, User user)
        throws Exception;

    public ChZjtyRewfilenoteVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ChZjtyRewfilenoteListVO params, User user)
        throws Exception;

}
