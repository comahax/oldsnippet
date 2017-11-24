/**
* auto-generated code
* Mon Jan 29 11:36:20 CST 2007
*/
package com.sunrise.boss.business.cms.distribute.cpexamhistory.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.distribute.cpexamhistory.persistent.CpexamhistoryVO;
import com.sunrise.boss.business.cms.distribute.cpexamhistory.persistent.CpexamhistoryListVO;

import java.io.Serializable;

/**
 * <p>Title: CpexamhistoryControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author Cai Jianhui
 * @version 1.0
 */
public interface CpexamhistoryControl extends AbstractControl {

    public DataPackage doQuery(CpexamhistoryListVO params, User user)
        throws Exception;

}
