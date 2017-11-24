/**
* auto-generated code
* Tue Jul 31 17:05:40 CST 2012
*/
package com.sunrise.boss.business.cms.et.chetadtrecord.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.et.chetadtrecord.persistent.ChEtAdtrecordVO;
import com.sunrise.boss.business.cms.et.chetadtrecord.persistent.ChEtAdtrecordListVO;

import java.io.Serializable;

/**
 * <p>Title: ChEtAdtrecordControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public interface ChEtAdtrecordControl extends AbstractControl {
    public ChEtAdtrecordVO doCreate(ChEtAdtrecordVO vo, User user)
        throws Exception;

    public void doRemove(ChEtAdtrecordVO vo, User user)
        throws Exception;

    public ChEtAdtrecordVO doUpdate(ChEtAdtrecordVO vo, User user)
        throws Exception;

    public ChEtAdtrecordVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ChEtAdtrecordListVO params, User user)
        throws Exception;

}
