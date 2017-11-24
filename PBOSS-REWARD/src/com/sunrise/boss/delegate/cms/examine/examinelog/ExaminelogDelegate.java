/**
* auto-generated code
* Wed Nov 18 16:15:36 CST 2009
*/
package com.sunrise.boss.delegate.cms.examine.examinelog;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.examine.examinelog.persistent.ExaminelogVO;
import com.sunrise.boss.business.cms.examine.examinelog.persistent.ExaminelogListVO;
import com.sunrise.boss.business.cms.examine.examinelog.control.ExaminelogControlBean;
import com.sunrise.boss.business.cms.examine.examinelog.control.ExaminelogControl;

import java.io.Serializable;

/**
 * <p>Title: ExaminelogDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ExaminelogDelegate {

    private static ExaminelogControl control;

    public ExaminelogDelegate() throws Exception {
        control = (ExaminelogControl) ControlFactory.build(ExaminelogControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ExaminelogVO doCreate(ExaminelogVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(ExaminelogVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public ExaminelogVO doUpdate(ExaminelogVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ExaminelogVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ExaminelogVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ExaminelogListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
