/**
* auto-generated code
* Thu Dec 29 14:47:31 CST 2011
*/
package com.sunrise.boss.business.cms.zjty.zjtyassess.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.zjtyassess.persistent.ZjtyAssessVO;
import com.sunrise.boss.business.cms.zjty.zjtyassess.persistent.ZjtyAssessListVO;

import java.io.Serializable;

/**
 * <p>Title: ZjtyAssessControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author qiuzhi
 * @version 1.0
 */
public interface ZjtyAssessControl extends AbstractControl {
    public ZjtyAssessVO doCreate(ZjtyAssessVO vo, User user)
        throws Exception;

    public void doRemove(ZjtyAssessVO vo, User user)
        throws Exception;

    public ZjtyAssessVO doUpdate(ZjtyAssessVO vo, User user)
        throws Exception;

    public ZjtyAssessVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ZjtyAssessListVO params, User user)
        throws Exception;

}
