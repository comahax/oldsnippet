/**
* auto-generated code
* Tue Sep 10 14:37:33 CST 2013
*/
package com.sunrise.boss.business.cms.provagent.chpdrprewardrecord.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.provagent.chpdrprewardrecord.persistent.ChPdRprewardrecordVO;
import com.sunrise.boss.business.cms.provagent.chpdrprewardrecord.persistent.ChPdRprewardrecordListVO;

import java.io.Serializable;

/**
 * <p>Title: ChPdRprewardrecordControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public interface ChPdRprewardrecordControl extends AbstractControl {
    public ChPdRprewardrecordVO doCreate(ChPdRprewardrecordVO vo, User user)
        throws Exception;

    public void doRemove(ChPdRprewardrecordVO vo, User user)
        throws Exception;

    public ChPdRprewardrecordVO doUpdate(ChPdRprewardrecordVO vo, User user)
        throws Exception;

    public ChPdRprewardrecordVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ChPdRprewardrecordListVO params, User user)
        throws Exception;

}
