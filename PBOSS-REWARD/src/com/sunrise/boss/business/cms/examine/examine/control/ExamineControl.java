/**
* auto-generated code
* Wed Nov 18 16:17:06 CST 2009
*/
package com.sunrise.boss.business.cms.examine.examine.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.examine.examine.persistent.ExamineVO;
import com.sunrise.boss.business.cms.examine.examine.persistent.ExamineListVO;

import java.io.Serializable;

/**
 * <p>Title: ExamineControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface ExamineControl extends AbstractControl {
    public ExamineVO doCreate(ExamineVO vo, User user)
        throws Exception;

    public void doRemove(ExamineVO vo, User user)
        throws Exception;

    public ExamineVO doUpdate(ExamineVO vo, User user)
        throws Exception;

    public ExamineVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ExamineListVO params, User user)
        throws Exception;
    public void doRemoveExamine(String selectValue, User user)
    throws Exception;
    public DataPackage doQueryExamineList(ExamineListVO params,User user)throws Exception ;
}
