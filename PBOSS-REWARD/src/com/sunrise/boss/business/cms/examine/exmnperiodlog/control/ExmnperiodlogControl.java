/**
* auto-generated code
* Tue Nov 24 10:57:58 CST 2009
*/
package com.sunrise.boss.business.cms.examine.exmnperiodlog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.examine.exmnperiodlog.persistent.ExmnperiodlogVO;
import com.sunrise.boss.business.cms.examine.exmnperiodlog.persistent.ExmnperiodlogListVO;

import java.io.Serializable;

/**
 * <p>Title: ExmnperiodlogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface ExmnperiodlogControl extends AbstractControl {
    public ExmnperiodlogVO doCreate(ExmnperiodlogVO vo, User user)
        throws Exception;

    public void doRemove(ExmnperiodlogVO vo, User user)
        throws Exception;

    public ExmnperiodlogVO doUpdate(ExmnperiodlogVO vo, User user)
        throws Exception;

    public ExmnperiodlogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ExmnperiodlogListVO params, User user)
        throws Exception;

}
