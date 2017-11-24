/**
* auto-generated code
* Thu Feb 25 14:28:35 CST 2010
*/
package com.sunrise.boss.delegate.cms.bbc.hdnetsales;

import java.io.Serializable;

import com.sunrise.boss.business.cms.bbc.hdnetsales.control.HdnetsalesControl;
import com.sunrise.boss.business.cms.bbc.hdnetsales.control.HdnetsalesControlBean;
import com.sunrise.boss.business.cms.bbc.hdnetsales.persistent.HdnetsalesListVO;
import com.sunrise.boss.business.cms.bbc.hdnetsales.persistent.HdnetsalesVO;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;



/**
 * <p>Title: HdnetsalesDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class HdnetsalesDelegate {

    private static HdnetsalesControl control;

    public HdnetsalesDelegate() throws Exception {
        control = (HdnetsalesControl) ControlFactory.build(HdnetsalesControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public HdnetsalesVO doCreate(HdnetsalesVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(HdnetsalesVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public HdnetsalesVO doUpdate(HdnetsalesVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public HdnetsalesVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (HdnetsalesVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(HdnetsalesListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

	public DataPackage doQuery2(Object[] params,Class[] classvo,String[][] joins, User user)throws Exception {
		return control.doQuery2(params, classvo, joins, user);
	}
	
}
