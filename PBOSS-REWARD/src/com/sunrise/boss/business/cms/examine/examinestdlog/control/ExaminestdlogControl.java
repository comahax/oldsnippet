/**
* auto-generated code
* Wed Nov 18 09:26:48 CST 2009
*/
package com.sunrise.boss.business.cms.examine.examinestdlog.control;

import java.io.Serializable;

import com.sunrise.boss.business.cms.examine.examinestdlog.persistent.ExaminestdlogListVO;
import com.sunrise.boss.business.cms.examine.examinestdlog.persistent.ExaminestdlogVO;
import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: ExaminestdlogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface ExaminestdlogControl extends AbstractControl {
    public ExaminestdlogVO doCreate(ExaminestdlogVO vo, User user)
        throws Exception;

    public void doRemove(ExaminestdlogVO vo, User user)
        throws Exception;

    public ExaminestdlogVO doUpdate(ExaminestdlogVO vo, User user)
        throws Exception;

    public ExaminestdlogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ExaminestdlogListVO params, User user)
        throws Exception;

}
