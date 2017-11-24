/**
* auto-generated code
* Thu Oct 26 17:37:18 CST 2006
*/
package com.sunrise.boss.business.zifee.yxplansplitvaluelog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.zifee.yxplansplitvaluelog.persistent.YxplanSplitValuelogVO;
import com.sunrise.boss.business.zifee.yxplansplitvaluelog.persistent.YxplanSplitValuelogListVO;

import java.io.Serializable;

/**
 * <p>Title: YxplanSplitValuelogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Danny(luozhoujie)
 * @version 1.0
 */
public interface YxplanSplitValuelogControl extends AbstractControl {
    public YxplanSplitValuelogVO doCreate(YxplanSplitValuelogVO vo, User user)
        throws Exception;

    public void doRemove(YxplanSplitValuelogVO vo, User user)
        throws Exception;

    public YxplanSplitValuelogVO doUpdate(YxplanSplitValuelogVO vo, User user)
        throws Exception;

    public YxplanSplitValuelogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(YxplanSplitValuelogListVO params, User user)
        throws Exception;

}
