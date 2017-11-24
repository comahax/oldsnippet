/**
* auto-generated code
* Thu Dec 13 09:40:05 CST 2007
*/
package com.sunrise.boss.business.resmanage.filedef.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.resmanage.filedef.persistent.FiledefVO;
import com.sunrise.boss.business.resmanage.filedef.persistent.FiledefListVO;

import java.io.Serializable;

/**
 * <p>Title: FiledefControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface FiledefControl extends AbstractControl {
    public FiledefVO doCreate(FiledefVO vo, User user)
        throws Exception;

    public void doRemove(FiledefVO vo, User user)
        throws Exception;

    public FiledefVO doUpdate(FiledefVO vo, User user)
        throws Exception;

    public FiledefVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(FiledefListVO params, User user)
        throws Exception;

}
