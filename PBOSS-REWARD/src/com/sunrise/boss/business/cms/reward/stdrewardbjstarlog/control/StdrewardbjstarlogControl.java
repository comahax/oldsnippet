/**
* auto-generated code
* Sat Oct 10 09:27:09 CST 2009
*/
package com.sunrise.boss.business.cms.reward.stdrewardbjstarlog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.stdrewardbjstarlog.persistent.StdrewardbjstarlogVO;
import com.sunrise.boss.business.cms.reward.stdrewardbjstarlog.persistent.StdrewardbjstarlogListVO;

import java.io.Serializable;

/**
 * <p>Title: StdrewardbjstarlogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public interface StdrewardbjstarlogControl extends AbstractControl {
    public StdrewardbjstarlogVO doCreate(StdrewardbjstarlogVO vo, User user)
        throws Exception;

    public void doRemove(StdrewardbjstarlogVO vo, User user)
        throws Exception;

    public StdrewardbjstarlogVO doUpdate(StdrewardbjstarlogVO vo, User user)
        throws Exception;

    public StdrewardbjstarlogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(StdrewardbjstarlogListVO params, User user)
        throws Exception;

}
