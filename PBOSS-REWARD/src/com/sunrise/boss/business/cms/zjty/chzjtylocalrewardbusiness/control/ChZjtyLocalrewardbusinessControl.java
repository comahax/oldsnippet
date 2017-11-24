/**
* auto-generated code
* Sat Mar 09 12:10:59 CST 2013
*/
package com.sunrise.boss.business.cms.zjty.chzjtylocalrewardbusiness.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.chzjtylocalrewardbusiness.persistent.ChZjtyLocalrewardbusinessVO;
import com.sunrise.boss.business.cms.zjty.chzjtylocalrewardbusiness.persistent.ChZjtyLocalrewardbusinessListVO;

import java.io.Serializable;

/**
 * <p>Title: ChZjtyLocalrewardbusinessControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface ChZjtyLocalrewardbusinessControl extends AbstractControl {
    public ChZjtyLocalrewardbusinessVO doCreate(ChZjtyLocalrewardbusinessVO vo, User user)
        throws Exception;

    public void doRemove(ChZjtyLocalrewardbusinessVO vo, User user)
        throws Exception;

    public ChZjtyLocalrewardbusinessVO doUpdate(ChZjtyLocalrewardbusinessVO vo, User user)
        throws Exception;

    public ChZjtyLocalrewardbusinessVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ChZjtyLocalrewardbusinessListVO params, User user)
        throws Exception;

    public DataPackage doQueryTotal(ChZjtyLocalrewardbusinessListVO params, User user)
        throws Exception;
}
