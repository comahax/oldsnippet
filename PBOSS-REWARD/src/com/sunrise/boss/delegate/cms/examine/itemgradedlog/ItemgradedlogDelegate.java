/**
* auto-generated code
* Sat Nov 28 17:54:36 CST 2009
*/
package com.sunrise.boss.delegate.cms.examine.itemgradedlog;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.examine.itemgradedlog.persistent.ItemgradedlogVO;
import com.sunrise.boss.business.cms.examine.itemgradedlog.persistent.ItemgradedlogListVO;
import com.sunrise.boss.business.cms.examine.itemgradedlog.control.ItemgradedlogControlBean;
import com.sunrise.boss.business.cms.examine.itemgradedlog.control.ItemgradedlogControl;

import java.io.Serializable;

/**
 * <p>Title: ItemgradedlogDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ItemgradedlogDelegate {

    private static ItemgradedlogControl control;

    public ItemgradedlogDelegate() throws Exception {
        control = (ItemgradedlogControl) ControlFactory.build(ItemgradedlogControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ItemgradedlogVO doCreate(ItemgradedlogVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(ItemgradedlogVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public ItemgradedlogVO doUpdate(ItemgradedlogVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ItemgradedlogVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ItemgradedlogVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ItemgradedlogListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
