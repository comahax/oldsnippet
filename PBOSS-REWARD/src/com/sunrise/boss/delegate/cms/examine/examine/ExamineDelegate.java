/**
* auto-generated code
* Wed Nov 18 16:17:06 CST 2009
*/
package com.sunrise.boss.delegate.cms.examine.examine;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.examine.examine.persistent.ExamineVO;
import com.sunrise.boss.business.cms.examine.examine.persistent.ExamineListVO;
import com.sunrise.boss.business.cms.examine.examine.control.ExamineControlBean;
import com.sunrise.boss.business.cms.examine.examine.control.ExamineControl;

import java.io.Serializable;

/**
 * <p>Title: ExamineDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ExamineDelegate {

    private static ExamineControl control;

    public ExamineDelegate() throws Exception {
        control = (ExamineControl) ControlFactory.build(ExamineControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ExamineVO doCreate(ExamineVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }
    
    public void doRemove(ExamineVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }
    public void doRemoveExamine(String selectValue, User user)
    throws Exception {
    	control.doRemoveExamine(selectValue, user);
    }
    public ExamineVO doUpdate(ExamineVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ExamineVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ExamineVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ExamineListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }
    public DataPackage doQueryExamineList(ExamineListVO params,User user)throws Exception {
        return control.doQueryExamineList(params, user);
    }

}
