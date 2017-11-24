/**
* auto-generated code
* Wed Dec 07 14:34:03 CST 2011
*/
package com.sunrise.boss.business.cms.bbc.unvrcfailday.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.unvrcfailday.persistent.UnvrcfaildayVO;
import com.sunrise.boss.business.cms.bbc.unvrcfailday.persistent.UnvrcfaildayListVO;

import java.io.Serializable;

/**
 * <p>Title: UnvrcfaildayControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
public interface UnvrcfaildayControl extends AbstractControl {
    public UnvrcfaildayVO doCreate(UnvrcfaildayVO vo, User user)
        throws Exception;

    public void doRemove(UnvrcfaildayVO vo, User user)
        throws Exception;

    public UnvrcfaildayVO doUpdate(UnvrcfaildayVO vo, User user)
        throws Exception;

    public UnvrcfaildayVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(UnvrcfaildayListVO params, User user)
        throws Exception;
    
    public DataPackage doQueryWithEmpinfo(UnvrcfaildayListVO params, User user)
        throws Exception;

}
