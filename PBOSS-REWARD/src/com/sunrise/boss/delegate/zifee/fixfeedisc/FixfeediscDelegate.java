/**
* auto-generated code
* Thu Aug 17 16:39:40 CST 2006
*/
package com.sunrise.boss.delegate.zifee.fixfeedisc;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.business.zifee.fixfeedisc.persistent.PcPsFixfeediscVO;
import com.sunrise.boss.business.zifee.fixfeedisc.persistent.PcPsFixfeediscListVO;
import com.sunrise.boss.business.zifee.fixfeedisc.control.FixfeediscControl;
import com.sunrise.boss.business.zifee.fixfeedisc.control.FixfeediscControlBean;
import java.io.Serializable;
import com.sunrise.boss.ui.commons.User;
/**
 * <p>Title: FixfeediscDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Danny(luozhoujie)
 * @version 1.0
 */
public class FixfeediscDelegate {

    private  FixfeediscControl control;

    public FixfeediscDelegate() throws Exception {
        control = (FixfeediscControl) ControlFactory.build(FixfeediscControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public PcPsFixfeediscVO doCreate(PcPsFixfeediscVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(PcPsFixfeediscVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }
    public PcPsFixfeediscVO doUpdate(PcPsFixfeediscVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public PcPsFixfeediscVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (PcPsFixfeediscVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(PcPsFixfeediscListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }
}
