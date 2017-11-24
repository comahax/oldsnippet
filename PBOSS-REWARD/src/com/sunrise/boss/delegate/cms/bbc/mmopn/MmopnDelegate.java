/**
* auto-generated code
* Mon Jan 04 14:36:52 CST 2010
*/
package com.sunrise.boss.delegate.cms.bbc.mmopn;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.mmopn.persistent.MmopnVO;
import com.sunrise.boss.business.cms.bbc.mmopn.persistent.MmopnListVO;
import com.sunrise.boss.business.cms.bbc.mmopn.control.MmopnControlBean;
import com.sunrise.boss.business.cms.bbc.mmopn.control.MmopnControl;

import java.io.Serializable;

/**
 * <p>Title: MmopnDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimyy
 * @version 1.0
 */
public class MmopnDelegate {

    private static MmopnControl control;

    public MmopnDelegate() throws Exception {
        control = (MmopnControl) ControlFactory.build(MmopnControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public MmopnVO doCreate(MmopnVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }
    public MmopnVO doCreatemusic(MmopnVO vo, User user) throws Exception {
    	return control.doCreatemusic(vo, user);
    }
    public void doRemove(MmopnVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public MmopnVO doUpdate(MmopnVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public MmopnVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (MmopnVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(MmopnListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
