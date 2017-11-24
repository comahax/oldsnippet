/**
* auto-generated code
* Wed Sep 13 09:14:51 CST 2006
*/
package com.sunrise.boss.delegate.cms.groupopr;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.groupopr.control.GroupoprControl;
import com.sunrise.boss.business.cms.groupopr.control.GroupoprControlBean;
import com.sunrise.boss.business.cms.groupopr.persistent.GroupoprVO;
import com.sunrise.boss.business.cms.groupopr.persistent.GroupoprListVO;

import java.io.Serializable;
import java.util.List;

/**
 * <p>Title: GroupoprDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author yjr
 * @version 1.0
 */
public class GroupoprDelegate {

    private static GroupoprControl control;

    public GroupoprDelegate() throws Exception {
        control = (GroupoprControl) ControlFactory.build(GroupoprControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public GroupoprVO doCreate(GroupoprVO vo, User user )
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(GroupoprVO vo, User user )
        throws Exception {
        control.doRemove(vo, user);
    }
    public GroupoprVO doUpdate(GroupoprVO vo, User user )
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public GroupoprVO doFindByPk(Serializable pk, User user )
        throws Exception {
        return (GroupoprVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(GroupoprListVO params, User user )
        throws Exception {
        return control.doQuery(params, user);
    }
    
    public DataPackage doTranslateDP(DataPackage dp, User user)
       throws Exception {
       return control.doTranslateDP(dp, user);
    }
    public GroupoprVO doFindByListVO(GroupoprListVO listVO, User user)  throws Exception {
        return control.doFindByListVO(listVO, user);
    }
    public List doFindByOprSeq(String oprseq,User user) throws Exception{
    	return control.doFindByOprSeq(oprseq,user);
    }
}
