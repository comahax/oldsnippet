/**
* auto-generated code
* Wed Aug 16 16:27:53 CST 2006
*/
package com.sunrise.boss.business.fee.check.disputersn.control;

import java.io.Serializable;
import java.util.List;

import com.sunrise.boss.business.fee.check.disputersn.persistent.DisputeReasonListVO;
import com.sunrise.boss.business.fee.check.disputersn.persistent.DisputeReasonVO;
import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: DisputeReasonControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author liwenjing
 * @version 1.0
 */
public interface DisputeReasonControl extends AbstractControl {
    public DisputeReasonVO doCreate(DisputeReasonVO vo, User user)
        throws Exception;

    public void doRemove(DisputeReasonVO vo, User user)
        throws Exception;

    public DisputeReasonVO doUpdate(DisputeReasonVO vo, User user)
        throws Exception;

    public DisputeReasonVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(DisputeReasonListVO params, User user)
        throws Exception;
    public List getAllUpperGrade(User user)
    	throws Exception;
    public List getGrade(int grade,User user) throws Exception;
    public List getLowByRsncode(String rsncode,User user) throws Exception;
}
