/**
* auto-generated code
* Thu Aug 17 16:39:40 CST 2006
*/
package com.sunrise.boss.business.zifee.fixfeedisc.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.business.zifee.fixfeedisc.persistent.PcPsFixfeediscVO;
import com.sunrise.boss.business.zifee.fixfeedisc.persistent.PcPsFixfeediscListVO;
import com.sunrise.boss.ui.commons.User;
import java.io.Serializable;

/**
 * <p>Title: FixfeediscControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author Danny(luozhoujie)
 * @version 1.0
 */
public interface FixfeediscControl extends AbstractControl {
    public PcPsFixfeediscVO doCreate(PcPsFixfeediscVO vo, User user)
        throws Exception;

    public void doRemove(PcPsFixfeediscVO vo, User user)
        throws Exception;

    public PcPsFixfeediscVO doUpdate(PcPsFixfeediscVO vo, User user)
        throws Exception;

    public PcPsFixfeediscVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(PcPsFixfeediscListVO params, User user)
        throws Exception;

}
