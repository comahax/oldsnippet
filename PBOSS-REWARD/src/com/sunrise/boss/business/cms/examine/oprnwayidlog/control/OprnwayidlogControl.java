/**
* auto-generated code
* Wed Nov 18 10:52:23 CST 2009
*/
package com.sunrise.boss.business.cms.examine.oprnwayidlog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.examine.oprnwayidlog.persistent.OprnwayidlogVO;
import com.sunrise.boss.business.cms.examine.oprnwayidlog.persistent.OprnwayidlogListVO;

import java.io.Serializable;

/**
 * <p>Title: OprnwayidlogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public interface OprnwayidlogControl extends AbstractControl {
    public OprnwayidlogVO doCreate(OprnwayidlogVO vo, User user)
        throws Exception;

    public void doRemove(OprnwayidlogVO vo, User user)
        throws Exception;

    public OprnwayidlogVO doUpdate(OprnwayidlogVO vo, User user)
        throws Exception;

    public OprnwayidlogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(OprnwayidlogListVO params, User user)
        throws Exception;

}
