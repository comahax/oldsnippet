/**
* auto-generated code
* Wed Nov 25 11:16:38 CST 2009
*/
package com.sunrise.boss.delegate.cms.examine.exmnitemdtl;

import java.io.Serializable;

import com.sunrise.boss.business.cms.examine.exmnitemdtl.control.ExmnitemdtlControl;
import com.sunrise.boss.business.cms.examine.exmnitemdtl.control.ExmnitemdtlControlBean;
import com.sunrise.boss.business.cms.examine.exmnitemdtl.persistent.ExmnitemdtlListVO;
import com.sunrise.boss.business.cms.examine.exmnitemdtl.persistent.ExmnitemdtlVO;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: ExmnitemdtlDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ExmnitemdtlDelegate {

    private static ExmnitemdtlControl control;

    public ExmnitemdtlDelegate() throws Exception {
        control = (ExmnitemdtlControl) ControlFactory.build(ExmnitemdtlControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ExmnitemdtlVO doCreate(ExmnitemdtlVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(ExmnitemdtlVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public ExmnitemdtlVO doUpdate(ExmnitemdtlVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ExmnitemdtlVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ExmnitemdtlVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ExmnitemdtlListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }
    public boolean doCheckBeingstcrtcl(ExmnitemdtlVO vo, User user)
    throws Exception{
    	return control.doCheckBeingstcrtcl(vo, user);
    }
    public void doRemoveDtl(Serializable pk,String cityid, User user)
    throws Exception {
    control.doRemoveDtl(pk, cityid,user);
    }

}
