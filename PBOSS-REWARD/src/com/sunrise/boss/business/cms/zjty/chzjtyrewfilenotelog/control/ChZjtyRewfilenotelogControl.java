/**
* auto-generated code
* Thu Jul 12 15:25:29 CST 2012
*/
package com.sunrise.boss.business.cms.zjty.chzjtyrewfilenotelog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.chzjtyrewfilenotelog.persistent.ChZjtyRewfilenotelogVO;
import com.sunrise.boss.business.cms.zjty.chzjtyrewfilenotelog.persistent.ChZjtyRewfilenotelogListVO;

import java.io.Serializable;

/**
 * <p>Title: ChZjtyRewfilenotelogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxx
 * @version 1.0
 */
public interface ChZjtyRewfilenotelogControl extends AbstractControl {
    public ChZjtyRewfilenotelogVO doCreate(ChZjtyRewfilenotelogVO vo, User user)
        throws Exception;

    public void doRemove(ChZjtyRewfilenotelogVO vo, User user)
        throws Exception;

    public ChZjtyRewfilenotelogVO doUpdate(ChZjtyRewfilenotelogVO vo, User user)
        throws Exception;

    public ChZjtyRewfilenotelogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ChZjtyRewfilenotelogListVO params, User user)
        throws Exception;

}
