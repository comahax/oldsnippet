/**
* auto-generated code
* Mon Oct 27 11:56:04 CST 2008
*/
package com.sunrise.boss.business.cms.zjty.zjtycitylvlrwd.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.zjtycitylvlrwd.persistent.ZjtyCitylvlrwdVO;
import com.sunrise.boss.business.cms.zjty.zjtycitylvlrwd.persistent.ZjtyCitylvlrwdListVO;

import java.io.Serializable;

/**
 * <p>Title: ZjtyCitylvlrwdControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public interface ZjtyCitylvlrwdControl extends AbstractControl {
    public ZjtyCitylvlrwdVO doCreate(ZjtyCitylvlrwdVO vo, User user)
        throws Exception;

    public void doRemove(ZjtyCitylvlrwdVO vo, User user)
        throws Exception;

    public ZjtyCitylvlrwdVO doUpdate(ZjtyCitylvlrwdVO vo, User user)
        throws Exception;

    public ZjtyCitylvlrwdVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ZjtyCitylvlrwdListVO params, User user)
        throws Exception;

}
