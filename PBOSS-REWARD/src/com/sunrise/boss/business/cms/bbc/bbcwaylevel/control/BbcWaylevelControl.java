/**
* auto-generated code
* Mon Aug 02 10:12:57 CST 2010
*/
package com.sunrise.boss.business.cms.bbc.bbcwaylevel.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.bbcwaylevel.persistent.BbcWaylevelVO;
import com.sunrise.boss.business.cms.bbc.bbcwaylevel.persistent.BbcWaylevelListVO;

import java.io.Serializable;

/**
 * <p>Title: BbcWaylevelControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface BbcWaylevelControl extends AbstractControl {
    public BbcWaylevelVO doCreate(BbcWaylevelVO vo, User user)
        throws Exception;

    public void doRemove(BbcWaylevelVO vo, User user)
        throws Exception;

    public BbcWaylevelVO doUpdate(BbcWaylevelVO vo, User user)
        throws Exception;

    public BbcWaylevelVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(BbcWaylevelListVO params, User user)
        throws Exception;

}
