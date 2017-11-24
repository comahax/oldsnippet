/**
* auto-generated code
* Fri Dec 08 11:45:12 CST 2006
*/
package com.sunrise.boss.business.cms.fee.yxfeaprv.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.fee.yxfeaprv.persistent.YxfeaprvVO;
import com.sunrise.boss.business.cms.fee.yxfeaprv.persistent.YxfeaprvListVO;

import java.io.Serializable;

/**
 * <p>Title: YxfeaprvControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Danny(luozhoujie)
 * @version 1.0
 */
public interface YxfeaprvControl extends AbstractControl {
    public YxfeaprvVO doCreate(YxfeaprvVO vo, User user)
        throws Exception;

    public void doRemove(YxfeaprvVO vo, User user)
        throws Exception;

    public YxfeaprvVO doUpdate(YxfeaprvVO vo, User user)
        throws Exception;

    public YxfeaprvVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(YxfeaprvListVO params, User user)
        throws Exception;

}
