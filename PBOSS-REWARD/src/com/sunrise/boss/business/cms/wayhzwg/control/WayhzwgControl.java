/**
* auto-generated code
* Thu Feb 12 09:39:32 CST 2009
*/
package com.sunrise.boss.business.cms.wayhzwg.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.wayhzwg.persistent.WayhzwgVO;
import com.sunrise.boss.business.cms.wayhzwg.persistent.WayhzwgListVO;

import java.io.Serializable;

/**
 * <p>Title: WayhzwgControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public interface WayhzwgControl extends AbstractControl {
    public WayhzwgVO doCreate(WayhzwgVO vo, User user)
        throws Exception;

    public void doRemove(WayhzwgVO vo, User user)
        throws Exception;

    public WayhzwgVO doUpdate(WayhzwgVO vo, User user)
        throws Exception;

    public WayhzwgVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(WayhzwgListVO params, User user)
        throws Exception;

}
