/**
* auto-generated code
* Fri Aug 03 13:32:29 CST 2007
*/
package com.sunrise.boss.business.cms.personalbusi.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.personalbusi.persistent.PersonalbusiVO;
import com.sunrise.boss.business.cms.personalbusi.persistent.PersonalbusiListVO;

import java.io.Serializable;

/**
 * <p>Title: PersonalbusiControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author WangHua
 * @version 1.0
 */
public interface PersonalbusiControl extends AbstractControl {
    public PersonalbusiVO doCreate(PersonalbusiVO vo, User user)
        throws Exception;

    public void doRemove(PersonalbusiVO vo, User user)
        throws Exception;

    public PersonalbusiVO doUpdate(PersonalbusiVO vo, User user)
        throws Exception;

    public PersonalbusiVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(PersonalbusiListVO params, User user)
        throws Exception;

}
