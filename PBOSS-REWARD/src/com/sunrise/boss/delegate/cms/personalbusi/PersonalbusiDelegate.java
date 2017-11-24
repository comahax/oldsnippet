/**
* auto-generated code
* Fri Aug 03 13:32:29 CST 2007
*/
package com.sunrise.boss.delegate.cms.personalbusi;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.personalbusi.control.PersonalbusiControl;
import com.sunrise.boss.business.cms.personalbusi.control.PersonalbusiControlBean;
import com.sunrise.boss.business.cms.personalbusi.persistent.PersonalbusiVO;
import com.sunrise.boss.business.cms.personalbusi.persistent.PersonalbusiListVO;

import java.io.Serializable;

/**
 * <p>Title: PersonalbusiDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author WangHua
 * @version 1.0
 */
public class PersonalbusiDelegate {

    private static PersonalbusiControl control;

    public PersonalbusiDelegate() throws Exception {
        control = (PersonalbusiControl) ControlFactory.build(PersonalbusiControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public PersonalbusiVO doCreate(PersonalbusiVO vo, User user )
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(PersonalbusiVO vo, User user )
        throws Exception {
        control.doRemove(vo, user);
    }
    public PersonalbusiVO doUpdate(PersonalbusiVO vo, User user )
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public PersonalbusiVO doFindByPk(Serializable pk, User user )
        throws Exception {
        return (PersonalbusiVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(PersonalbusiListVO params, User user )
        throws Exception {
        return control.doQuery(params, user);
    }
}
