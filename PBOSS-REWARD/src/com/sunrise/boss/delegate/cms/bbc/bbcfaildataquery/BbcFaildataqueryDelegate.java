/**
* auto-generated code
* Wed Apr 29 14:17:22 CST 2009
*/
package com.sunrise.boss.delegate.cms.bbc.bbcfaildataquery;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.bbcfaildataquery.persistent.BbcFaildataqueryVO;
import com.sunrise.boss.business.cms.bbc.bbcfaildataquery.persistent.BbcFaildataqueryListVO;
import com.sunrise.boss.business.cms.bbc.bbcfaildataquery.control.BbcFaildataqueryControlBean;
import com.sunrise.boss.business.cms.bbc.bbcfaildataquery.control.BbcFaildataqueryControl;

import java.io.Serializable;

/**
 * <p>Title: BbcFaildataqueryDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public class BbcFaildataqueryDelegate {

    private static BbcFaildataqueryControl control;

    public BbcFaildataqueryDelegate() throws Exception {
        control = (BbcFaildataqueryControl) ControlFactory.build(BbcFaildataqueryControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public BbcFaildataqueryVO doCreate(BbcFaildataqueryVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(BbcFaildataqueryVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }
    public BbcFaildataqueryVO doUpdate(BbcFaildataqueryVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public BbcFaildataqueryVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (BbcFaildataqueryVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(BbcFaildataqueryListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }
    public DataPackage doQuery2(BbcFaildataqueryListVO params, User user)
	    throws Exception {
	    return control.doQuery2(params, user);
}
}
