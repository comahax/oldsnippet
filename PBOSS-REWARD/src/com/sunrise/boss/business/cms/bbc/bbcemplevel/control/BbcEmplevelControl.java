/**
* auto-generated code
* Wed Aug 04 11:46:50 CST 2010
*/
package com.sunrise.boss.business.cms.bbc.bbcemplevel.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.bbcemplevel.persistent.BbcEmplevelVO;
import com.sunrise.boss.business.cms.bbc.bbcemplevel.persistent.BbcEmplevelListVO;

import java.io.Serializable;

/**
 * <p>Title: BbcEmplevelControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface BbcEmplevelControl extends AbstractControl {
    public BbcEmplevelVO doCreate(BbcEmplevelVO vo, User user)
        throws Exception;

    public void doRemove(BbcEmplevelVO vo, User user)
        throws Exception;

    public BbcEmplevelVO doUpdate(BbcEmplevelVO vo, User user)
        throws Exception;

    public BbcEmplevelVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(BbcEmplevelListVO params, User user)
        throws Exception;

}
