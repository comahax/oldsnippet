/**
* auto-generated code
* Wed Sep 04 21:16:54 CST 2013
*/
package com.sunrise.boss.business.cms.provagent.vchpdrprewardrecord.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.provagent.vchpdrprewardrecord.persistent.VChPdRprewardrecordVO;
import com.sunrise.boss.business.cms.provagent.vchpdrprewardrecord.persistent.VChPdRprewardrecordListVO;

import java.io.Serializable;

/**
 * <p>Title: ChPdRprewardrecordControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public interface VChPdRprewardrecordControl extends AbstractControl {
    public VChPdRprewardrecordVO doCreate(VChPdRprewardrecordVO vo, User user)
        throws Exception;

    public void doRemove(VChPdRprewardrecordVO vo, User user)
        throws Exception;

    public VChPdRprewardrecordVO doUpdate(VChPdRprewardrecordVO vo, User user)
        throws Exception;

    public VChPdRprewardrecordVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(VChPdRprewardrecordListVO params, User user)
        throws Exception;

}
