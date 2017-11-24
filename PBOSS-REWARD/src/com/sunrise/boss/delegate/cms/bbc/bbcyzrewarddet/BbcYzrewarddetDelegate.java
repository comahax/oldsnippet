/**
* auto-generated code
* Mon Nov 16 17:27:59 CST 2009
*/
package com.sunrise.boss.delegate.cms.bbc.bbcyzrewarddet;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.bbcyzrewarddet.persistent.BbcYzrewarddetVO;
import com.sunrise.boss.business.cms.bbc.bbcyzrewarddet.persistent.BbcYzrewarddetListVO;
import com.sunrise.boss.business.cms.bbc.bbcyzrewarddet.control.BbcYzrewarddetControlBean;
import com.sunrise.boss.business.cms.bbc.bbcyzrewarddet.control.BbcYzrewarddetControl;

import java.io.Serializable;

/**
 * <p>Title: BbcYzrewarddetDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public class BbcYzrewarddetDelegate {

    private static BbcYzrewarddetControl control;

    public BbcYzrewarddetDelegate() throws Exception {
        control = (BbcYzrewarddetControl) ControlFactory.build(BbcYzrewarddetControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public BbcYzrewarddetVO doCreate(BbcYzrewarddetVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(BbcYzrewarddetVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public BbcYzrewarddetVO doUpdate(BbcYzrewarddetVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public BbcYzrewarddetVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (BbcYzrewarddetVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(BbcYzrewarddetListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
