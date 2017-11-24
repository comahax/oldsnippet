/**
* auto-generated code
* Fri Feb 01 12:08:34 CST 2013
*/
package com.sunrise.boss.business.cms.chadtclassplatformtdinfo.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.chadtclassplatformtdinfo.persistent.ChAdtClassplatformtdinfoVO;
import com.sunrise.boss.business.cms.chadtclassplatformtdinfo.persistent.ChAdtClassplatformtdinfoListVO;

import java.io.Serializable;

/**
 * <p>Title: ChAdtClassplatformtdinfoControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author limin
 * @version 1.0
 */
public interface ChAdtClassplatformtdinfoControl extends AbstractControl {
    public ChAdtClassplatformtdinfoVO doCreate(ChAdtClassplatformtdinfoVO vo, User user)
        throws Exception;

    public void doRemove(ChAdtClassplatformtdinfoVO vo, User user)
        throws Exception;

    public ChAdtClassplatformtdinfoVO doUpdate(ChAdtClassplatformtdinfoVO vo, User user)
        throws Exception;

    public ChAdtClassplatformtdinfoVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ChAdtClassplatformtdinfoListVO params, User user)
        throws Exception;

}
