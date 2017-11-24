/**
* auto-generated code
* Mon Oct 27 10:18:24 CST 2008
*/
package com.sunrise.boss.business.cms.zjty.zjtylvlrwd.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.zjtylvlrwd.persistent.ZjtyLvlrwdVO;
import com.sunrise.boss.business.cms.zjty.zjtylvlrwd.persistent.ZjtyLvlrwdListVO;

import java.io.Serializable;

/**
 * <p>Title: ZjtyLvlrwdControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public interface ZjtyLvlrwdControl extends AbstractControl {
    public ZjtyLvlrwdVO doCreate(ZjtyLvlrwdVO vo, User user)
        throws Exception;

    public void doRemove(ZjtyLvlrwdVO vo, User user)
        throws Exception;

    public ZjtyLvlrwdVO doUpdate(ZjtyLvlrwdVO vo, User user)
        throws Exception;

    public ZjtyLvlrwdVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ZjtyLvlrwdListVO params, User user)
        throws Exception;

}
