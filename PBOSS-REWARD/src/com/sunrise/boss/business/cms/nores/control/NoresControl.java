/**
* auto-generated code
* Wed Nov 16 16:25:57 CST 2011
*/
package com.sunrise.boss.business.cms.nores.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.nores.persistent.NoresVO;
import com.sunrise.boss.business.cms.nores.persistent.NoresListVO;

import java.io.Serializable;

/**
 * <p>Title: NoresControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public interface NoresControl extends AbstractControl {
    public NoresVO doCreate(NoresVO vo, User user)
        throws Exception;

    public void doRemove(NoresVO vo, User user)
        throws Exception;

    public NoresVO doUpdate(NoresVO vo, User user)
        throws Exception;

    public NoresVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(NoresListVO params, User user)
        throws Exception;

}
