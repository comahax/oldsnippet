package com.gmcc.pboss.business.cms.examine.itemgraded.control;


import java.io.Serializable;

import com.gmcc.pboss.business.cms.examine.itemgraded.persistent.ItemgradedListVO;
import com.gmcc.pboss.business.cms.examine.itemgraded.persistent.ItemgradedVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: ItemgradedControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Itemgraded extends AbstractControl {
    public ItemgradedVO doCreate(ItemgradedVO vo)
        throws Exception;

    public void doRemove(ItemgradedVO vo)
        throws Exception;

    public ItemgradedVO doUpdate(ItemgradedVO vo)
        throws Exception;

    public ItemgradedVO doFindByPk(Serializable pk)
        throws Exception;

    public DataPackage doQuery(ItemgradedListVO params)
        throws Exception;

}
