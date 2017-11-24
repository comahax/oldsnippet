/**
* auto-generated code
* Sat Nov 28 17:53:15 CST 2009
*/
package com.sunrise.boss.business.cms.examine.itemgraded.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.examine.itemgraded.persistent.ItemgradedVO;
import com.sunrise.boss.business.cms.examine.itemgraded.persistent.ItemgradedListVO;

import java.io.Serializable;
import java.util.List;

/**
 * <p>Title: ItemgradedControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface ItemgradedControl extends AbstractControl {
    public ItemgradedVO doCreate(ItemgradedVO vo, User user)
        throws Exception;

    public void doRemove(ItemgradedVO vo, User user)
        throws Exception;

    public ItemgradedVO doUpdate(ItemgradedVO vo, User user)
        throws Exception;

    public ItemgradedVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ItemgradedListVO params, User user)
        throws Exception;
    public void doSubmitAuditInfo(String[] selectArray,String auditor,String curauditor, User user)throws Exception;
    public List doFindAllSubmitSeqid(User user)throws Exception;
	 public void doCallbackInfo(String[] selectArray,User user)throws Exception;
	 public void doRemoveJoinExmnaudit(ItemgradedVO vo, User user)
     throws Exception;
	 public DataPackage doGetItemgradedWayInfo(ItemgradedListVO listvo, User user)throws Exception;

}
