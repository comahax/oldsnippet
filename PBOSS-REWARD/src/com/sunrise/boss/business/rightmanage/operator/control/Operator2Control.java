/**
* auto-generated code
* Sat Oct 21 10:49:43 CST 2006
*/
package com.sunrise.boss.business.rightmanage.operator.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.rightmanage.operator.persistent.Operator2VO;
import com.sunrise.boss.business.rightmanage.operator.persistent.Operator2ListVO;

import java.io.Serializable;

/**
 * <p>Title: OperatorControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Operator2Control extends AbstractControl {
    public Operator2VO doCreate(Operator2VO vo, User user)
        throws Exception;

    public void doRemove(Operator2VO vo, User user)
        throws Exception;

    public Operator2VO doUpdate(Operator2VO vo, User user)
        throws Exception;

    public Operator2VO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(Operator2ListVO params, User user)
        throws Exception;

}
