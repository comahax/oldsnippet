/**
* auto-generated code
* Wed May 15 11:11:32 CST 2013
*/
package com.sunrise.boss.business.cms.et.chzdetsaleinfo.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.et.chzdetsaleinfo.persistent.ChZdEtsaleinfoVO;
import com.sunrise.boss.business.cms.et.chzdetsaleinfo.persistent.ChZdEtsaleinfoListVO;

import java.io.Serializable;

/**
 * <p>Title: ChZdEtsaleinfoControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Qiu Zhi
 * @version 1.0
 */
public interface ChZdEtsaleinfoControl extends AbstractControl {
    public ChZdEtsaleinfoVO doCreate(ChZdEtsaleinfoVO vo, User user)
        throws Exception;

    public void doRemove(ChZdEtsaleinfoVO vo, User user)
        throws Exception;

    public ChZdEtsaleinfoVO doUpdate(ChZdEtsaleinfoVO vo, User user)
        throws Exception;

    public ChZdEtsaleinfoVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ChZdEtsaleinfoListVO params, User user)
        throws Exception;

}
