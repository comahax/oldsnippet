/**
* auto-generated code
* Tue Jul 09 12:03:37 CST 2013
*/
package com.sunrise.boss.business.cms.zjty.chzjtynogotonedetail.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.chzjtynogotonedetail.persistent.ChZjtyNogotonedetailVO;
import com.sunrise.boss.business.cms.zjty.chzjtynogotonedetail.persistent.ChZjtyNogotonedetailListVO;
import java.io.Serializable;

/**
 * <p>Title: ChZjtyNogotonedetailControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
public interface ChZjtyNogotonedetailControl extends AbstractControl {
    public ChZjtyNogotonedetailVO doCreate(ChZjtyNogotonedetailVO vo, User user)
        throws Exception;

    public void doRemove(ChZjtyNogotonedetailVO vo, User user)
        throws Exception;

    public ChZjtyNogotonedetailVO doUpdate(ChZjtyNogotonedetailVO vo, User user)
        throws Exception;

    public ChZjtyNogotonedetailVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ChZjtyNogotonedetailListVO params, User user)
        throws Exception;

    public DataPackage doQueryByView(ChZjtyNogotonedetailListVO params, User user)
        throws Exception;

    public void doDelete(ChZjtyNogotonedetailListVO vo, User user)
        throws Exception;

    public long doFindMaxMark(User user) throws Exception;
}
