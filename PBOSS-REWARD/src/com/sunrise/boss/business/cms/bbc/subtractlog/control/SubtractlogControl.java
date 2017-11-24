/**
* auto-generated code
* Sat Apr 21 14:16:48 CST 2012
*/
package com.sunrise.boss.business.cms.bbc.subtractlog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.subtractlog.persistent.SubtractlogVO;
import com.sunrise.boss.business.cms.bbc.subtractlog.persistent.SubtractlogListVO;

import java.io.Serializable;

/**
 * <p>Title: SubtractlogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yangdaren
 * @version 1.0
 */
public interface SubtractlogControl extends AbstractControl {
    public SubtractlogVO doCreate(SubtractlogVO vo, User user)
        throws Exception;

    public void doRemove(SubtractlogVO vo, User user)
        throws Exception;

    public SubtractlogVO doUpdate(SubtractlogVO vo, User user)
        throws Exception;

    public SubtractlogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(SubtractlogListVO params, User user)
        throws Exception;

}
