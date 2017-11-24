/**
* auto-generated code
* Mon Jan 04 14:36:51 CST 2010
*/
package com.sunrise.boss.business.cms.bbc.mmopn.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.mmopn.persistent.MmopnVO;
import com.sunrise.boss.business.cms.bbc.mmopn.persistent.MmopnListVO;

import java.io.Serializable;

/**
 * <p>Title: MmopnControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimyy
 * @version 1.0
 */
public interface MmopnControl extends AbstractControl {
    public MmopnVO doCreate(MmopnVO vo, User user)
        throws Exception;
    public MmopnVO doCreatemusic(MmopnVO vo, User user) throws Exception ;

    public void doRemove(MmopnVO vo, User user)
        throws Exception;

    public MmopnVO doUpdate(MmopnVO vo, User user)
        throws Exception;

    public MmopnVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(MmopnListVO params, User user)
        throws Exception;

}
