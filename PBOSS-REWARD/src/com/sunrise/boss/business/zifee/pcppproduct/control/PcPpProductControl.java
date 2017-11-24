/**
* auto-generated code
* Wed Aug 16 15:21:29 CST 2006
*/
package com.sunrise.boss.business.zifee.pcppproduct.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.business.zifee.pcppproduct.persistent.PcPpProductVO;
import com.sunrise.boss.business.zifee.pcppproduct.persistent.PcPpProductListVO;
import com.sunrise.boss.ui.commons.User;
import java.io.Serializable;

/**
 * <p>Title: PcPpProductControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Danny(luozhoujie)
 * @version 1.0
 */
public interface PcPpProductControl extends AbstractControl {
    public PcPpProductVO doCreate(PcPpProductVO vo, User user)
        throws Exception;

    public void doRemove(PcPpProductVO vo, User user)
        throws Exception;

    public PcPpProductVO doUpdate(PcPpProductVO vo, User user)
        throws Exception;

    public PcPpProductVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(PcPpProductListVO params, User user)
        throws Exception;

}
