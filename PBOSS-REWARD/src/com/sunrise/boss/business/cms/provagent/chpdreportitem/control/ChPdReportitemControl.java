/**
* auto-generated code
* Wed Sep 04 16:18:46 CST 2013
*/
package com.sunrise.boss.business.cms.provagent.chpdreportitem.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.provagent.chpdreportitem.persistent.ChPdReportitemVO;
import com.sunrise.boss.business.cms.provagent.chpdreportitem.persistent.ChPdReportitemListVO;

import java.io.Serializable;

/**
 * <p>Title: ChPdReportitemControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public interface ChPdReportitemControl extends AbstractControl {
    public ChPdReportitemVO doCreate(ChPdReportitemVO vo, User user)
        throws Exception;

    public void doRemove(ChPdReportitemVO vo, User user)
        throws Exception;

    public ChPdReportitemVO doUpdate(ChPdReportitemVO vo, User user)
        throws Exception;

    public ChPdReportitemVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ChPdReportitemListVO params, User user)
        throws Exception;

}
