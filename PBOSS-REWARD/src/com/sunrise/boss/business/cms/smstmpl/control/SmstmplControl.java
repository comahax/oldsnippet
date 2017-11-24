/**
* auto-generated code
* Thu May 19 20:47:27 CST 2011
*/
package com.sunrise.boss.business.cms.smstmpl.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.smstmpl.persistent.SmstmplVO;
import com.sunrise.boss.business.cms.smstmpl.persistent.SmstmplListVO;

import java.io.Serializable;

/**
 * <p>Title: SmstmplControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yangdaren
 * @version 1.0
 */
public interface SmstmplControl extends AbstractControl {
    public SmstmplVO doCreate(SmstmplVO vo, User user)
        throws Exception;

    public void doRemove(SmstmplVO vo, User user)
        throws Exception;

    public SmstmplVO doUpdate(SmstmplVO vo, User user)
        throws Exception;

    public SmstmplVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(SmstmplListVO params, User user)
        throws Exception;

}
