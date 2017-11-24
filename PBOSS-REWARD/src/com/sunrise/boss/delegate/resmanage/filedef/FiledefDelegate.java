/**
* auto-generated code
* Thu Dec 13 09:40:05 CST 2007
*/
package com.sunrise.boss.delegate.resmanage.filedef;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.resmanage.filedef.persistent.FiledefVO;
import com.sunrise.boss.business.resmanage.filedef.persistent.FiledefListVO;
import com.sunrise.boss.business.resmanage.filedef.control.FiledefControlBean;
import com.sunrise.boss.business.resmanage.filedef.control.FiledefControl;

import java.io.Serializable;

/**
 * <p>Title: FiledefDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class FiledefDelegate {

    private static FiledefControl control;

    public FiledefDelegate() throws Exception {
        control = (FiledefControl) ControlFactory.build(FiledefControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public FiledefVO doCreate(FiledefVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(FiledefVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }
    public FiledefVO doUpdate(FiledefVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public FiledefVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (FiledefVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(FiledefListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }
}
