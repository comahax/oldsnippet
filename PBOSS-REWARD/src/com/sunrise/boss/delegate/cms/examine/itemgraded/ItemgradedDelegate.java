/**
* auto-generated code
* Sat Nov 28 17:53:15 CST 2009
*/
package com.sunrise.boss.delegate.cms.examine.itemgraded;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.examine.itemgraded.persistent.ItemgradedVO;
import com.sunrise.boss.business.cms.examine.itemgraded.persistent.ItemgradedListVO;
import com.sunrise.boss.business.cms.examine.itemgraded.control.ItemgradedControlBean;
import com.sunrise.boss.business.cms.examine.itemgraded.control.ItemgradedControl;

import java.io.Serializable;
import java.util.List;

/**
 * <p>Title: ItemgradedDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ItemgradedDelegate {

    private static ItemgradedControl control;

    public ItemgradedDelegate() throws Exception {
        control = (ItemgradedControl) ControlFactory.build(ItemgradedControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ItemgradedVO doCreate(ItemgradedVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(ItemgradedVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public ItemgradedVO doUpdate(ItemgradedVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ItemgradedVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ItemgradedVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ItemgradedListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }
    public void doSubmitAuditInfo(String[] selectArray,String auditor,String curauditor, User user)throws Exception{
    	control.doSubmitAuditInfo(selectArray, auditor, curauditor, user);
    }
    /**
	  * 查找所有可提交的考核项评分标识信息
	  */
	 public List doFindAllSubmitSeqid(User user)throws Exception{
		 return control.doFindAllSubmitSeqid(user);
	 }
	 /**
	  * 
	  * @param selectArray
	  * @param user
	  * @throws Exception
	  */
	 public void doCallbackInfo(String[] selectArray,User user)throws Exception{
		 control.doCallbackInfo(selectArray, user);
	 }
	 public void doRemoveJoinExmnaudit(ItemgradedVO vo, User user)
     throws Exception {
		 control.doRemoveJoinExmnaudit(vo, user);
	 }
	 public DataPackage doGetItemgradedWayInfo(ItemgradedListVO listvo, User user)throws Exception{
		 return control.doGetItemgradedWayInfo(listvo, user);
	 }

}
