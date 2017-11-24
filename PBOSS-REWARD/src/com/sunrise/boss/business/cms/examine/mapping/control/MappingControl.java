/**
* auto-generated code
* Sat Nov 28 17:48:47 CST 2009
*/
package com.sunrise.boss.business.cms.examine.mapping.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.examine.mapping.persistent.MappingVO;
import com.sunrise.boss.business.cms.examine.mapping.persistent.MappingListVO;

import java.io.Serializable;

/**
 * <p>Title: MappingControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface MappingControl extends AbstractControl {
    public MappingVO doCreate(MappingVO vo, User user)
        throws Exception;

    public void doRemove(MappingVO vo, User user)
        throws Exception;

    public MappingVO doUpdate(MappingVO vo, User user)
        throws Exception;

    public MappingVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(MappingListVO params, User user)
        throws Exception;
    public boolean doCheckBeingMark(MappingVO vo, User user)
    throws Exception;
    public String doQueryToCheck(MappingListVO params,User user) throws Exception ;
    public DataPackage doQueryMappingList(MappingListVO params, User user)
    throws Exception;

}
