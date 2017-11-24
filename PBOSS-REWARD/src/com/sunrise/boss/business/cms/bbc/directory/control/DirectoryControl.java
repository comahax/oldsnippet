/**
* auto-generated code
* Tue Mar 12 15:11:57 CST 2013
*/
package com.sunrise.boss.business.cms.bbc.directory.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.directory.persistent.DirectoryVO;
import com.sunrise.boss.business.cms.bbc.directory.persistent.DirectoryListVO;

import java.io.Serializable;

/**
 * <p>Title: DirectoryControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
public interface DirectoryControl extends AbstractControl {
    public DirectoryVO doCreate(DirectoryVO vo, User user)
        throws Exception;

    public void doRemove(DirectoryVO vo, User user)
        throws Exception;

    public DirectoryVO doUpdate(DirectoryVO vo, User user)
        throws Exception;

    public DirectoryVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(DirectoryListVO params, User user)
        throws Exception;

}
