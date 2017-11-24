/**
* auto-generated code
* Sat Nov 28 17:48:47 CST 2009
*/
package com.sunrise.boss.delegate.cms.examine.mapping;

import java.io.Serializable;

import com.sunrise.boss.business.cms.examine.mapping.control.MappingControl;
import com.sunrise.boss.business.cms.examine.mapping.control.MappingControlBean;
import com.sunrise.boss.business.cms.examine.mapping.persistent.MappingListVO;
import com.sunrise.boss.business.cms.examine.mapping.persistent.MappingVO;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: MappingDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class MappingDelegate {

    private static MappingControl control;

    public MappingDelegate() throws Exception {
        control = (MappingControl) ControlFactory.build(MappingControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public MappingVO doCreate(MappingVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(MappingVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public MappingVO doUpdate(MappingVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public MappingVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (MappingVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(MappingListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }
    public boolean doCheckBeingMark(MappingVO vo, User user)
    throws Exception{
    	return control.doCheckBeingMark(vo, user);
    }
    public String doQueryToCheck(MappingListVO params,User user) throws Exception {
    	return control.doQueryToCheck(params, user);
    }
    public DataPackage doQueryMappingList(MappingListVO params, User user)
    throws Exception {
    	return control.doQueryMappingList(params, user);
    }

}
