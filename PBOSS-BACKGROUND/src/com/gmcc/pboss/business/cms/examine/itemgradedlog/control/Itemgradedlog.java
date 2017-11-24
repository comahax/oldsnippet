package com.gmcc.pboss.business.cms.examine.itemgradedlog.control;


import java.io.Serializable;

import com.gmcc.pboss.business.cms.examine.itemgradedlog.persistent.ItemgradedlogListVO;
import com.gmcc.pboss.business.cms.examine.itemgradedlog.persistent.ItemgradedlogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: ItemgradedlogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Itemgradedlog extends AbstractControl {
    public ItemgradedlogVO doCreate(ItemgradedlogVO vo)
        throws Exception;

    public void doRemove(ItemgradedlogVO vo)
        throws Exception;

    public ItemgradedlogVO doUpdate(ItemgradedlogVO vo)
        throws Exception;

    public ItemgradedlogVO doFindByPk(Serializable pk)
        throws Exception;

    public DataPackage doQuery(ItemgradedlogListVO params)
        throws Exception;

}
