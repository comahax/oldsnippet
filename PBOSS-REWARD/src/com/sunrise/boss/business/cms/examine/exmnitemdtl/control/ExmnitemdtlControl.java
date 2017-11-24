/**
* auto-generated code
* Wed Nov 25 11:16:38 CST 2009
*/
package com.sunrise.boss.business.cms.examine.exmnitemdtl.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.examine.exmnitemdtl.persistent.ExmnitemdtlVO;
import com.sunrise.boss.business.cms.examine.exmnitemdtl.persistent.ExmnitemdtlListVO;

import java.io.Serializable;

/**
 * <p>Title: ExmnitemdtlControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface ExmnitemdtlControl extends AbstractControl {
    public ExmnitemdtlVO doCreate(ExmnitemdtlVO vo, User user)
        throws Exception;

    public void doRemove(ExmnitemdtlVO vo, User user)
        throws Exception;

    public ExmnitemdtlVO doUpdate(ExmnitemdtlVO vo, User user)
        throws Exception;

    public ExmnitemdtlVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ExmnitemdtlListVO params, User user)
        throws Exception;
    public boolean doCheckBeingstcrtcl(ExmnitemdtlVO vo, User user)
    throws Exception;
    public void doRemoveDtl(Serializable pk,String cityid, User user)
    throws Exception ;

}
