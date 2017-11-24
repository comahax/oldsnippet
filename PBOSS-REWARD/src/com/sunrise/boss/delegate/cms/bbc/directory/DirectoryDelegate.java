/**
* auto-generated code
* Tue Mar 12 15:11:57 CST 2013
*/
package com.sunrise.boss.delegate.cms.bbc.directory;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.directory.persistent.DirectoryVO;
import com.sunrise.boss.business.cms.bbc.directory.persistent.DirectoryListVO;
import com.sunrise.boss.business.cms.bbc.directory.control.DirectoryControlBean;
import com.sunrise.boss.business.cms.bbc.directory.control.DirectoryControl;

import java.io.Serializable;

/**
 * <p>Title: DirectoryDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
public class DirectoryDelegate {

    private static DirectoryControl control;

    public DirectoryDelegate() throws Exception {
        control = (DirectoryControl) ControlFactory.build(DirectoryControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public DirectoryVO doCreate(DirectoryVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(DirectoryVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public DirectoryVO doUpdate(DirectoryVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public DirectoryVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (DirectoryVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(DirectoryListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
