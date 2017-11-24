/**
* auto-generated code
* Fri Feb 01 11:50:09 CST 2013
*/
package com.sunrise.boss.business.cms.chadtclassplatformbrandinfo.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.chadtclassplatformbrandinfo.persistent.ChAdtClassplatformbrandinfoVO;
import com.sunrise.boss.business.cms.chadtclassplatformbrandinfo.persistent.ChAdtClassplatformbrandinfoListVO;

import java.io.Serializable;

/**
 * <p>Title: ChAdtClassplatformbrandinfoControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author limin
 * @version 1.0
 */
public interface ChAdtClassplatformbrandinfoControl extends AbstractControl {
    public ChAdtClassplatformbrandinfoVO doCreate(ChAdtClassplatformbrandinfoVO vo, User user)
        throws Exception;

    public void doRemove(ChAdtClassplatformbrandinfoVO vo, User user)
        throws Exception;

    public ChAdtClassplatformbrandinfoVO doUpdate(ChAdtClassplatformbrandinfoVO vo, User user)
        throws Exception;

    public ChAdtClassplatformbrandinfoVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ChAdtClassplatformbrandinfoListVO params, User user)
        throws Exception;

}
