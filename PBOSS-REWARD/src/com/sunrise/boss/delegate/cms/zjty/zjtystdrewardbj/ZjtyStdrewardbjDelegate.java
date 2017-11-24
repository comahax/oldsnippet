/**
* auto-generated code
* Tue Oct 28 11:34:48 CST 2008
*/
package com.sunrise.boss.delegate.cms.zjty.zjtystdrewardbj;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.zjtystdrewardbj.persistent.ZjtyStdrewardbjVO;
import com.sunrise.boss.business.cms.zjty.zjtystdrewardbj.persistent.ZjtyStdrewardbjListVO;
import com.sunrise.boss.business.cms.zjty.zjtystdrewardbj.control.ZjtyStdrewardbjControlBean;
import com.sunrise.boss.business.cms.zjty.zjtystdrewardbj.control.ZjtyStdrewardbjControl;

import java.io.Serializable;
import java.util.List;

/**
 * <p>Title: ZjtyStdrewardbjDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public class ZjtyStdrewardbjDelegate {

    private static ZjtyStdrewardbjControl control;

    public ZjtyStdrewardbjDelegate() throws Exception {
        control = (ZjtyStdrewardbjControl) ControlFactory.build(ZjtyStdrewardbjControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public ZjtyStdrewardbjVO doCreate(ZjtyStdrewardbjVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(ZjtyStdrewardbjVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }
    public ZjtyStdrewardbjVO doUpdate(ZjtyStdrewardbjVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public ZjtyStdrewardbjVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ZjtyStdrewardbjVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(ZjtyStdrewardbjListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }
	public void doSave(List list, User user) throws Exception {
		control.doSave(list, user);
	}
	public void doSavecity(List list, User user) throws Exception {
		control.doSavecity(list, user);
	}
}
