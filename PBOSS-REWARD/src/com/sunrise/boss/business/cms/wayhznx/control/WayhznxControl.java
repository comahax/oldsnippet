/**
* auto-generated code
* Thu Feb 12 09:35:58 CST 2009
*/
package com.sunrise.boss.business.cms.wayhznx.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.wayhznx.persistent.WayhznxVO;
import com.sunrise.boss.business.cms.wayhznx.persistent.WayhznxListVO;

import java.io.Serializable;

/**
 * <p>Title: WayhznxControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public interface WayhznxControl extends AbstractControl {
    public WayhznxVO doCreate(WayhznxVO vo, User user)
        throws Exception;

    public void doRemove(WayhznxVO vo, User user)
        throws Exception;

    public WayhznxVO doUpdate(WayhznxVO vo, User user)
        throws Exception;

    public WayhznxVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(WayhznxListVO params, User user)
        throws Exception;
    
    public DataPackage doQuery2(Object params[], Class vo[], String joins[][], User user)
    	throws Exception;

}
