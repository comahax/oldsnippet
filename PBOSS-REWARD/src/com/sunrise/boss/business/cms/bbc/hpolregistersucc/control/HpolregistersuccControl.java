/**
* auto-generated code
* Wed Dec 14 10:29:07 CST 2011
*/
package com.sunrise.boss.business.cms.bbc.hpolregistersucc.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.hpolregistersucc.persistent.HpolregistersuccVO;
import com.sunrise.boss.business.cms.bbc.hpolregistersucc.persistent.HpolregistersuccListVO;

import java.io.Serializable;

/**
 * <p>Title: HpolregistersuccControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public interface HpolregistersuccControl extends AbstractControl {
    public HpolregistersuccVO doCreate(HpolregistersuccVO vo, User user)
        throws Exception;

    public void doRemove(HpolregistersuccVO vo, User user)
        throws Exception;

    public HpolregistersuccVO doUpdate(HpolregistersuccVO vo, User user)
        throws Exception;

    public HpolregistersuccVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(HpolregistersuccListVO params, User user)
        throws Exception;

}
