package com.sunrise.boss.delegate.cms.audit.waittmp;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.business.cms.audit.waittmp.persistent.WaittmpVO;
import com.sunrise.boss.business.cms.audit.waittmp.persistent.WaittmpListVO;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.audit.waittmp.control.WaittmpControl;
import com.sunrise.boss.business.cms.audit.waittmp.control.WaittmpControlBean;
import java.io.Serializable;

/**
 * @author liminghao
 * @version 1.0
 */
public class WaittmpDelegate {

    private static WaittmpControl control;

    public WaittmpDelegate() throws Exception {
        control = (WaittmpControl) ControlFactory.build(WaittmpControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public WaittmpVO doCreate(WaittmpVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(WaittmpVO vo, User user) throws Exception {
        if (null == vo || null == user) {
            throw new IllegalArgumentException();
        } else {
            control.doRemove(vo, user);
        }
    }
    public WaittmpVO doUpdate(WaittmpVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public WaittmpVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (WaittmpVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(WaittmpListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }
    
    public boolean sendDx(int type,String orgCode,String desCode,User user) throws Exception {
    	return control.sendDx(type, desCode, desCode,user);
    }
}
