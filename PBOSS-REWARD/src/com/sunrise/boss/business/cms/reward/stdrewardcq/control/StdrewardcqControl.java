/**
* auto-generated code
* Thu Dec 22 09:33:15 CST 2011
*/
package com.sunrise.boss.business.cms.reward.stdrewardcq.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.stdrewardcq.persistent.StdrewardcqVO;
import com.sunrise.boss.business.cms.reward.stdrewardcq.persistent.StdrewardcqListVO;

import java.io.Serializable;

/**
 * <p>Title: StdrewardcqControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public interface StdrewardcqControl extends AbstractControl {
    public StdrewardcqVO doCreate(StdrewardcqVO vo, User user)
        throws Exception;

    public void doRemove(StdrewardcqVO vo, User user)
        throws Exception;

    public StdrewardcqVO doUpdate(StdrewardcqVO vo, User user)
        throws Exception;

    public StdrewardcqVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(StdrewardcqListVO params, User user)
        throws Exception;
    public DataPackage doQuery2(StdrewardcqListVO params, User user)
    throws Exception;
}
