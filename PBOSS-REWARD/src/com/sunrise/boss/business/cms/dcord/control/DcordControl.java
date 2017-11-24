/**
* auto-generated code
* Wed Aug 15 12:26:00 CST 2012
*/
package com.sunrise.boss.business.cms.dcord.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.dcord.persistent.DcordVO;
import com.sunrise.boss.business.cms.dcord.persistent.DcordListVO;
import com.sunrise.boss.business.cms.dcord.persistent.VDcordListVO;

import java.io.Serializable;

/**
 * <p>Title: DcordControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
public interface DcordControl extends AbstractControl {
    public DcordVO doCreate(DcordVO vo, User user)
        throws Exception;

    public void doRemove(DcordVO vo, User user)
        throws Exception;

    public DcordVO doUpdate(DcordVO vo, User user)
        throws Exception;

    public DcordVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(DcordListVO params, User user)
        throws Exception;
    
    public DataPackage doQuery(VDcordListVO params, User user) throws Exception;

}
