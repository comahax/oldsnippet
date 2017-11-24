/**
* auto-generated code
* Wed Apr 29 14:17:22 CST 2009
*/
package com.sunrise.boss.business.cms.bbc.bbcfaildataquery.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.bbcfaildataquery.persistent.BbcFaildataqueryVO;
import com.sunrise.boss.business.cms.bbc.bbcfaildataquery.persistent.BbcFaildataqueryListVO;

import java.io.Serializable;

/**
 * <p>Title: BbcFaildataqueryControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public interface BbcFaildataqueryControl extends AbstractControl {
    public BbcFaildataqueryVO doCreate(BbcFaildataqueryVO vo, User user)
        throws Exception;

    public void doRemove(BbcFaildataqueryVO vo, User user)
        throws Exception;

    public BbcFaildataqueryVO doUpdate(BbcFaildataqueryVO vo, User user)
        throws Exception;

    public BbcFaildataqueryVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(BbcFaildataqueryListVO params, User user)
        throws Exception;

    public DataPackage doQuery2(BbcFaildataqueryListVO params, User user)
    	throws Exception;
}
