/**
* auto-generated code
* Wed Aug 16 16:27:53 CST 2006
*/
package com.sunrise.boss.delegate.fee.check;

import java.io.Serializable;
import java.util.List;

import com.sunrise.boss.business.fee.check.disputersn.control.DisputeReasonControl;
import com.sunrise.boss.business.fee.check.disputersn.control.DisputeReasonControlBean;
import com.sunrise.boss.business.fee.check.disputersn.persistent.DisputeReasonListVO;
import com.sunrise.boss.business.fee.check.disputersn.persistent.DisputeReasonVO;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: DisputeReasonDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author liwenjing
 * @version 1.0
 */
public class DisputeReasonDelegate {

    private static DisputeReasonControl control;

    public DisputeReasonDelegate() throws Exception {
        control = (DisputeReasonControl) ControlFactory.build(DisputeReasonControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public DisputeReasonVO doCreate(DisputeReasonVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(DisputeReasonVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }
    public DisputeReasonVO doUpdate(DisputeReasonVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public DisputeReasonVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (DisputeReasonVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(DisputeReasonListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }
    public List getAllUpperGrade(User user)
	throws Exception{
    	return control.getAllUpperGrade(user);
    }
    public List getGrade(int grade,User user)
	throws Exception{
    	return control.getGrade(grade,user);
    }
    public List getLowByRsncode(String rsncode,User user)
	throws Exception{
    	return control.getLowByRsncode(rsncode, user);
    }
}
