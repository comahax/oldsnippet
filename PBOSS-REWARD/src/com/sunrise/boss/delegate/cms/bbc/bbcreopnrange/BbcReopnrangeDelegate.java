/**
* auto-generated code
* Sun Aug 15 11:34:09 CST 2010
*/
package com.sunrise.boss.delegate.cms.bbc.bbcreopnrange;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.bbcreopnrange.persistent.BbcReopnrangeVO;
import com.sunrise.boss.business.cms.bbc.bbcreopnrange.persistent.BbcReopnrangeListVO;
import com.sunrise.boss.business.cms.bbc.bbcreopnrange.control.BbcReopnrangeControlBean;
import com.sunrise.boss.business.cms.bbc.bbcreopnrange.control.BbcReopnrangeControl;

import java.io.Serializable;

/**
 * <p>Title: BbcReopnrangeDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public class BbcReopnrangeDelegate {

    private static BbcReopnrangeControl control;

    public BbcReopnrangeDelegate() throws Exception {
        control = (BbcReopnrangeControl) ControlFactory.build(BbcReopnrangeControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public BbcReopnrangeVO doCreate(BbcReopnrangeVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(BbcReopnrangeVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public BbcReopnrangeVO doUpdate(BbcReopnrangeVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public BbcReopnrangeVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (BbcReopnrangeVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(BbcReopnrangeListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }
    
    public DataPackage doQueryopnid(BbcReopnrangeListVO params,String opnid, String resertype, User user) throws Exception{
    	 return control.doQueryopnid(params, opnid, resertype, user);
    }

	public DataPackage doQueryrange(BbcReopnrangeListVO params,
			String resertype, User user) throws Exception{
		return control.doQueryrange(params, resertype, user);
	}
}
