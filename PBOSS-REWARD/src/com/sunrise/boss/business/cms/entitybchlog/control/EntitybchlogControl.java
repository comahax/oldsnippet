/**
* auto-generated code
* Wed Oct 18 14:53:55 CST 2006
*/
package com.sunrise.boss.business.cms.entitybchlog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.entitybchlog.persistent.EntitybchlogVO;
import com.sunrise.boss.business.cms.entitybchlog.persistent.EntitybchlogListVO;

import java.io.Serializable;

/**
 * <p>Title: EntitybchlogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
public interface EntitybchlogControl extends AbstractControl {
    public EntitybchlogVO doCreate(EntitybchlogVO vo, User user)
        throws Exception;

    public void doRemove(EntitybchlogVO vo, User user)
        throws Exception;

    public EntitybchlogVO doUpdate(EntitybchlogVO vo, User user)
        throws Exception;

    public EntitybchlogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(EntitybchlogListVO params, User user)
        throws Exception;

}
