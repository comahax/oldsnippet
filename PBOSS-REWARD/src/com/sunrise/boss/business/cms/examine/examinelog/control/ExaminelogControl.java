/**
* auto-generated code
* Wed Nov 18 16:15:36 CST 2009
*/
package com.sunrise.boss.business.cms.examine.examinelog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.examine.examinelog.persistent.ExaminelogVO;
import com.sunrise.boss.business.cms.examine.examinelog.persistent.ExaminelogListVO;

import java.io.Serializable;

/**
 * <p>Title: ExaminelogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface ExaminelogControl extends AbstractControl {
    public ExaminelogVO doCreate(ExaminelogVO vo, User user)
        throws Exception;

    public void doRemove(ExaminelogVO vo, User user)
        throws Exception;

    public ExaminelogVO doUpdate(ExaminelogVO vo, User user)
        throws Exception;

    public ExaminelogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ExaminelogListVO params, User user)
        throws Exception;

}
