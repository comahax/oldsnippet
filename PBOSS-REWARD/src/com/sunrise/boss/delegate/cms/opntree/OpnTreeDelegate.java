/**
* auto-generated code
* Wed Dec 31 13:51:34 CST 2008
*/
package com.sunrise.boss.delegate.cms.opntree;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.opntree.control.OpnTreeControl;
import com.sunrise.boss.business.cms.opntree.control.OpnTreeControlBean;
import com.sunrise.boss.business.cms.opntree.persistent.OpnTreeVO;
import com.sunrise.boss.business.cms.opntree.persistent.OpnTreeListVO;

import java.io.Serializable;

/**
 * <p>Title: OpnTreeDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public class OpnTreeDelegate {

    private static OpnTreeControl control;

    public OpnTreeDelegate() throws Exception {
        control = (OpnTreeControl) ControlFactory.build(OpnTreeControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    
    public OpnTreeVO doFindByPk(Serializable pk, User user ) throws Exception {
        return (OpnTreeVO) control.doFindByPk(pk, user);
    }
    public int doQueryUpCount(OpnTreeListVO params, User user) throws Exception{
    	return control.doQueryUpCount(params, user);
    }
    public DataPackage doQueryUpData(OpnTreeListVO params, User user) throws Exception{
    	return control.doQueryUpData(params, user);
    }
    public int doQueryDownCount(OpnTreeListVO params, User user) throws Exception{
    	return control.doQueryDownCount(params, user);
    }
    public DataPackage doQueryDownData(OpnTreeListVO params, User user) throws Exception{
    	return control.doQueryDownData(params, user);
    }
}
