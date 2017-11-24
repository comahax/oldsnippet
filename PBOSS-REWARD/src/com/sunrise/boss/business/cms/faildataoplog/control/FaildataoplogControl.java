/**
* auto-generated code
* Fri Oct 09 16:20:49 CST 2009
*/
package com.sunrise.boss.business.cms.faildataoplog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.faildataoplog.persistent.FaildataoplogVO;
import com.sunrise.boss.business.cms.faildataoplog.persistent.FaildataoplogListVO;

import java.io.Serializable;

/**
 * <p>Title: FaildataoplogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public interface FaildataoplogControl extends AbstractControl {
    public FaildataoplogVO doCreate(FaildataoplogVO vo, User user)
        throws Exception;

    public void doRemove(FaildataoplogVO vo, User user)
        throws Exception;

    public FaildataoplogVO doUpdate(FaildataoplogVO vo, User user)
        throws Exception;

    public FaildataoplogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(FaildataoplogListVO params, User user)
        throws Exception;

}
