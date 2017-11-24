/**
* auto-generated code
* Thu Feb 25 14:28:35 CST 2010
*/
package com.sunrise.boss.business.cms.bbc.hdnetsales.control;

import java.io.Serializable;

import com.sunrise.boss.business.cms.bbc.hdnetsales.persistent.HdnetsalesListVO;
import com.sunrise.boss.business.cms.bbc.hdnetsales.persistent.HdnetsalesVO;
import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: HdnetsalesControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface HdnetsalesControl extends AbstractControl {
    public HdnetsalesVO doCreate(HdnetsalesVO vo, User user)
        throws Exception;

    public void doRemove(HdnetsalesVO vo, User user)
        throws Exception;

    public HdnetsalesVO doUpdate(HdnetsalesVO vo, User user)
        throws Exception;

    public HdnetsalesVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(HdnetsalesListVO params, User user)
        throws Exception;

    public DataPackage doQuery2(Object[] params,Class[] classvo,String[][] joins, User user)
		throws Exception;
}
