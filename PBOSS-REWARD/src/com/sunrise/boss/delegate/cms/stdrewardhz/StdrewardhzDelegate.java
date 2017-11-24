/**
* auto-generated code
* Sun Feb 01 17:08:50 CST 2009
*/
package com.sunrise.boss.delegate.cms.stdrewardhz;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.stdreward.persistent.StdrewardVO;
import com.sunrise.boss.business.cms.stdrewardhz.persistent.StdrewardhzVO;
import com.sunrise.boss.business.cms.stdrewardhz.persistent.StdrewardhzListVO;
import com.sunrise.boss.business.cms.stdrewardhz.control.StdrewardhzControlBean;
import com.sunrise.boss.business.cms.stdrewardhz.control.StdrewardhzControl;

import java.io.Serializable;
import java.util.List;

/**
 * <p>Title: StdrewardhzDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public class StdrewardhzDelegate {

    private static StdrewardhzControl control;

    public StdrewardhzDelegate() throws Exception {
        control = (StdrewardhzControl) ControlFactory.build(StdrewardhzControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public StdrewardhzVO doCreate(StdrewardhzVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    } 
    public void doRemove(StdrewardhzVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }
    public StdrewardhzVO doUpdate(StdrewardhzVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public StdrewardhzVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (StdrewardhzVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(StdrewardhzListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }
    public StdrewardVO doSave(StdrewardVO stdrewardvo, List oldStarList, List newStarList, boolean isCity, User user)
    	throws Exception {
    	return control.doSave(stdrewardvo, oldStarList, newStarList, isCity, user);
    }
    public String doQueryHealth(User user) throws Exception{
    	return control.doQueryHealth(user);
    }
    
}
