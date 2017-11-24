/**
* auto-generated code
* Fri Jun 24 11:00:35 CST 2011
*/
package com.sunrise.boss.business.cms.reward.chadtimportrecord.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.chadtimportrecord.persistent.ChadtimportrecordListVO;
import com.sunrise.boss.business.cms.reward.chadtimportrecord.persistent.ChadtimportrecordVO;

import java.io.Serializable;

/**
 * <p>Title: ChAdtImportrecordControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public interface ChadtimportrecordControl extends AbstractControl {
    public ChadtimportrecordVO doCreate(ChadtimportrecordVO vo, User user)
        throws Exception;

    public void doRemove(ChadtimportrecordVO vo, User user)
        throws Exception;

    public ChadtimportrecordVO doUpdate(ChadtimportrecordVO vo, User user)
        throws Exception;

    public ChadtimportrecordVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ChadtimportrecordListVO params, User user)
        throws Exception;

}
