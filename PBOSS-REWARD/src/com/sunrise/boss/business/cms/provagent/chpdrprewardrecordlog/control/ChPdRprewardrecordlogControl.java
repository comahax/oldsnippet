/**
* auto-generated code
* Sun Sep 08 15:35:41 CST 2013
*/
package com.sunrise.boss.business.cms.provagent.chpdrprewardrecordlog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.provagent.chpdrprewardrecordlog.persistent.ChPdRprewardrecordlogVO;
import com.sunrise.boss.business.cms.provagent.chpdrprewardrecordlog.persistent.ChPdRprewardrecordlogListVO;

import java.io.Serializable;

/**
 * <p>Title: ChPdRprewardrecordlogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public interface ChPdRprewardrecordlogControl extends AbstractControl {
    public ChPdRprewardrecordlogVO doCreate(ChPdRprewardrecordlogVO vo, User user)
        throws Exception;

    public void doRemove(ChPdRprewardrecordlogVO vo, User user)
        throws Exception;

    public ChPdRprewardrecordlogVO doUpdate(ChPdRprewardrecordlogVO vo, User user)
        throws Exception;

    public ChPdRprewardrecordlogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ChPdRprewardrecordlogListVO params, User user)
        throws Exception;

}
