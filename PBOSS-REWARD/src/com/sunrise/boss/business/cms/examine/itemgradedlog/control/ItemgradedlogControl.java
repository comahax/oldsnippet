/**
* auto-generated code
* Sat Nov 28 17:54:36 CST 2009
*/
package com.sunrise.boss.business.cms.examine.itemgradedlog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.examine.itemgradedlog.persistent.ItemgradedlogVO;
import com.sunrise.boss.business.cms.examine.itemgradedlog.persistent.ItemgradedlogListVO;

import java.io.Serializable;

/**
 * <p>Title: ItemgradedlogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface ItemgradedlogControl extends AbstractControl {
    public ItemgradedlogVO doCreate(ItemgradedlogVO vo, User user)
        throws Exception;

    public void doRemove(ItemgradedlogVO vo, User user)
        throws Exception;

    public ItemgradedlogVO doUpdate(ItemgradedlogVO vo, User user)
        throws Exception;

    public ItemgradedlogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ItemgradedlogListVO params, User user)
        throws Exception;

}
