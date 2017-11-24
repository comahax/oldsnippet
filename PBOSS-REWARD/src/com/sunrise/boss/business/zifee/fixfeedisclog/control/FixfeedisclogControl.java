/**
* auto-generated code
* Wed Oct 18 21:00:42 CST 2006
*/
package com.sunrise.boss.business.zifee.fixfeedisclog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.zifee.fixfeedisc.persistent.PcPsFixfeedislogVO;
import com.sunrise.boss.business.zifee.fixfeedisclog.persistent.FixfeedisclogListVO;

import java.io.Serializable;

/**
 * <p>Title: FixfeedisclogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Danny(luozhoujie)
 * @version 1.0
 */
public interface FixfeedisclogControl extends AbstractControl {
    public PcPsFixfeedislogVO doCreate(PcPsFixfeedislogVO vo, User user)
        throws Exception;

    public void doRemove(PcPsFixfeedislogVO vo, User user)
        throws Exception;

    public PcPsFixfeedislogVO doUpdate(PcPsFixfeedislogVO vo, User user)
        throws Exception;

    public PcPsFixfeedislogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(FixfeedisclogListVO params, User user)
        throws Exception;

}
