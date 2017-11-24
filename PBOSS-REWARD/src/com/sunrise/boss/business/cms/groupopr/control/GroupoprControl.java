/**
* auto-generated code
* Wed Sep 13 09:14:51 CST 2006
*/
package com.sunrise.boss.business.cms.groupopr.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.groupopr.persistent.GroupoprVO;
import com.sunrise.boss.business.cms.groupopr.persistent.GroupoprListVO;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/**
 * <p>Title: GroupoprControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author yjr
 * @version 1.0
 */
public interface GroupoprControl extends AbstractControl {
    public GroupoprVO doCreate(GroupoprVO vo, User user)
        throws Exception;

    public void doRemove(GroupoprVO vo, User user)
        throws Exception;

    public GroupoprVO doUpdate(GroupoprVO vo, User user)
        throws Exception;

    public GroupoprVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(GroupoprListVO params, User user)
        throws Exception;
    
    public DataPackage doTranslateDP(DataPackage dp, User user) throws Exception;
    
    public GroupoprVO doFindByListVO(GroupoprListVO listVO, User user)  throws Exception;
    
    public List doFindByOprSeq(String oprseq,User user) throws Exception;
    
}
