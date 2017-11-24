/**
* auto-generated code
* Tue Nov 17 16:06:35 CST 2009
*/
package com.sunrise.boss.delegate.cms.examine.examinestd;

import java.io.Serializable;

import com.sunrise.boss.business.cms.examine.examinestd.control.ExaminestdControl;
import com.sunrise.boss.business.cms.examine.examinestd.control.ExaminestdControlBean;
import com.sunrise.boss.business.cms.examine.examinestd.persistent.ExaminestdListVO;
import com.sunrise.boss.business.cms.examine.examinestd.persistent.ExaminestdVO;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: ExaminestdDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ExaminestdDelegate {

    private static ExaminestdControl control;

    public ExaminestdDelegate() throws Exception {
        control = (ExaminestdControl) ControlFactory.build(ExaminestdControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ExaminestdVO doCreate(ExaminestdVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(ExaminestdVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public ExaminestdVO doUpdate(ExaminestdVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ExaminestdVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ExaminestdVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ExaminestdListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }
    /**
     * 验证SQL合法
     */
    public int doValidateSQL(String sql, User user)throws Exception{
    	return control.doValidateSQL(sql, user);
    }
    public DataPackage doQueryExaminestdList(String exmnid,ExaminestdListVO params, User user)
    throws Exception {
    return control.doQueryExaminestdList(exmnid, params, user);
}

}
