/**
* auto-generated code
* Wed Nov 18 10:31:12 CST 2009
*/
package com.sunrise.boss.delegate.cms.examine.oprnwayid;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.examine.oprnwayid.persistent.OprnwayidVO;
import com.sunrise.boss.business.cms.examine.oprnwayid.persistent.OprnwayidListVO;
import com.sunrise.boss.business.cms.examine.oprnwayid.control.OprnwayidControlBean;
import com.sunrise.boss.business.cms.examine.oprnwayid.control.OprnwayidControl;

import java.io.Serializable;

/**
 * <p>Title: OprnwayidDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public class OprnwayidDelegate {

    private static OprnwayidControl control;

    public OprnwayidDelegate() throws Exception {
        control = (OprnwayidControl) ControlFactory.build(OprnwayidControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public OprnwayidVO doCreate(OprnwayidVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(OprnwayidVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public OprnwayidVO doUpdate(OprnwayidVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public OprnwayidVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (OprnwayidVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(OprnwayidListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }
    public void doTransf(String oldoperid,String newoperid,User user)throws Exception{
    	control.doTransf(oldoperid, newoperid,user);
    }

}
