/**
* auto-generated code
* Fri Feb 01 14:20:31 CST 2013
*/
package com.sunrise.boss.business.cms.chadtclassplatformtdstd.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.chadtclassplatformtdstd.persistent.ChAdtClassplatformtdstdVO;
import com.sunrise.boss.business.cms.chadtclassplatformtdstd.persistent.ChAdtClassplatformtdstdListVO;

import java.io.Serializable;

/**
 * <p>Title: ChAdtClassplatformtdstdControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author limin
 * @version 1.0
 */
public interface ChAdtClassplatformtdstdControl extends AbstractControl {
    public ChAdtClassplatformtdstdVO doCreate(ChAdtClassplatformtdstdVO vo, User user)
        throws Exception;

    public void doRemove(ChAdtClassplatformtdstdVO vo, User user)
        throws Exception;

    public ChAdtClassplatformtdstdVO doUpdate(ChAdtClassplatformtdstdVO vo, User user)
        throws Exception;

    public ChAdtClassplatformtdstdVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ChAdtClassplatformtdstdListVO params, User user)
        throws Exception;

}
