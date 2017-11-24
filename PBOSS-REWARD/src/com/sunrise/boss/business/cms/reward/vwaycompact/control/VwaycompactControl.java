/**
* auto-generated code
* Sat Oct 16 21:22:36 CST 2010
*/
package com.sunrise.boss.business.cms.reward.vwaycompact.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.vwaycompact.persistent.VwaycompactVO;
import com.sunrise.boss.business.cms.reward.vwaycompact.persistent.VwaycompactListVO;

import java.io.Serializable;

/**
 * <p>Title: VwaycompactControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jemy
 * @version 1.0
 */
public interface VwaycompactControl extends AbstractControl {
    public VwaycompactVO doCreate(VwaycompactVO vo, User user)
        throws Exception;

    public void doRemove(VwaycompactVO vo, User user)
        throws Exception;

    public VwaycompactVO doUpdate(VwaycompactVO vo, User user)
        throws Exception;

    public VwaycompactVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(VwaycompactListVO params, User user)
        throws Exception;

}
