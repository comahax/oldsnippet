/**
* auto-generated code
* Tue Feb 05 10:11:13 CST 2008
*/
package com.sunrise.boss.business.cms.busicityload.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.busicityload.persistent.BusicityloadVO;
import com.sunrise.boss.business.cms.busicityload.persistent.BusicityloadListVO;

import java.io.Serializable;

/**
 * <p>Title: BusicityloadControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface BusicityloadControl extends AbstractControl {
    public BusicityloadVO doCreate(BusicityloadVO vo, User user)
        throws Exception;

    public void doRemove(BusicityloadVO vo, User user)
        throws Exception;

    public BusicityloadVO doUpdate(BusicityloadVO vo, User user)
        throws Exception;

    public BusicityloadVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(BusicityloadListVO params, User user)
        throws Exception;

}
