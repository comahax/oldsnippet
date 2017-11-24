/**
* auto-generated code
* Sat Aug 19 17:21:52 CST 2006
*/
package com.sunrise.boss.business.fee.check.incdecrdata.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.fee.persistent.cbincdecrdata.CBIncDecrDataListVO;
import com.sunrise.boss.business.fee.persistent.cbincdecrdata.CBIncDecrDataVO;

import java.io.Serializable;

/**
 * <p>Title: IncDecrDataControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liwenjing
 * @version 1.0
 */
public interface IncDecrDataControl extends AbstractControl {
    public CBIncDecrDataVO doCreate(CBIncDecrDataVO vo, User user)
        throws Exception;

    public void doRemove(CBIncDecrDataVO vo, User user)
        throws Exception;

    public CBIncDecrDataVO doUpdate(CBIncDecrDataVO vo, User user)
        throws Exception;

    public CBIncDecrDataVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(CBIncDecrDataListVO params, User user)
        throws Exception;
//	public CBIncDecrDataVO doSaveOrUpdate(CBIncDecrDataVO vo, User user) 
//	throws Exception;
}
