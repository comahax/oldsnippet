/**
* auto-generated code
* Wed Sep 02 10:03:26 CST 2009
*/
package com.sunrise.boss.business.cms.bbc.unvrc.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.unvrc.persistent.UnvrcVO;
import com.sunrise.boss.business.cms.bbc.unvrc.persistent.UnvrcListVO;

import java.io.Serializable;

/**
 * <p>Title: UnvrcControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public interface UnvrcControl extends AbstractControl {
    public UnvrcVO doCreate(UnvrcVO vo, User user)
        throws Exception;

    public void doRemove(UnvrcVO vo, User user)
        throws Exception;

    public UnvrcVO doUpdate(UnvrcVO vo, User user)
        throws Exception;

    public UnvrcVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(UnvrcListVO params, User user)
        throws Exception;

}
