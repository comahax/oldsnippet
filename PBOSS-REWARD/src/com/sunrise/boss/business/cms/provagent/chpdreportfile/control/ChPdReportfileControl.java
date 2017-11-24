/**
* auto-generated code
* Wed Sep 04 16:27:47 CST 2013
*/
package com.sunrise.boss.business.cms.provagent.chpdreportfile.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.provagent.chpdreportfile.persistent.ChPdReportfileVO;
import com.sunrise.boss.business.cms.provagent.chpdreportfile.persistent.ChPdReportfileListVO;

import java.io.Serializable;

/**
 * <p>Title: ChPdReportfileControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public interface ChPdReportfileControl extends AbstractControl {
    public ChPdReportfileVO doCreate(ChPdReportfileVO vo, User user)
        throws Exception;

    public void doRemove(ChPdReportfileVO vo, User user)
        throws Exception;

    public ChPdReportfileVO doUpdate(ChPdReportfileVO vo, User user)
        throws Exception;

    public ChPdReportfileVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ChPdReportfileListVO params, User user)
        throws Exception;

}
