/**
* auto-generated code
* Tue Jul 09 08:59:10 CST 2013
*/
package com.sunrise.boss.business.cms.zjty.chzjtygotonedetail.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.chzjtygotonedetail.persistent.ChZjtyGotonedetailVO;
import com.sunrise.boss.business.cms.zjty.chzjtygotonedetail.persistent.ChZjtyGotonedetailListVO;
import java.io.Serializable;

/**
 * <p>Title: ChZjtyGotonedetailControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
public interface ChZjtyGotonedetailControl extends AbstractControl {
    public ChZjtyGotonedetailVO doCreate(ChZjtyGotonedetailVO vo, User user)
        throws Exception;

    public void doRemove(ChZjtyGotonedetailVO vo, User user)
        throws Exception;

    public ChZjtyGotonedetailVO doUpdate(ChZjtyGotonedetailVO vo, User user)
        throws Exception;

    public ChZjtyGotonedetailVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ChZjtyGotonedetailListVO params, User user)
        throws Exception;
    
    public DataPackage doQueryByView(ChZjtyGotonedetailListVO params, User user)
        throws Exception;
    
    public void doDelete(ChZjtyGotonedetailListVO params, User user)
        throws Exception;
    
    public long doFindMaxMark(User user) throws Exception;

}
