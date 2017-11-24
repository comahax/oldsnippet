/**
* auto-generated code
* Wed Nov 25 11:12:10 CST 2009
*/
package com.sunrise.boss.business.cms.examine.exmnitem.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.examine.exmnitem.persistent.ExmnitemVO;
import com.sunrise.boss.business.cms.examine.exmnitem.persistent.ExmnitemListVO;

import java.io.Serializable;

/**
 * <p>Title: ExmnitemControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface ExmnitemControl extends AbstractControl {
    public ExmnitemVO doCreate(ExmnitemVO vo, User user)
        throws Exception;

    public void doRemove(ExmnitemVO vo, User user)
        throws Exception;

    public ExmnitemVO doUpdate(ExmnitemVO vo, User user)
        throws Exception;

    public ExmnitemVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ExmnitemListVO params, User user)
        throws Exception;
    public DataPackage doQueryExmnitemList(ExmnitemListVO params, User user)
    throws Exception ;
    public void doRemoveItem(Serializable pkVO, String itemcityid,User user)
    throws Exception;

}
