/**
* auto-generated code
* Thu Sep 18 15:19:11 CST 2008
*/
package com.sunrise.boss.delegate.cms.bbc.jfopnmaplog;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.jfopnmaplog.persistent.JfopnmaplogVO;
import com.sunrise.boss.business.cms.bbc.jfopnmaplog.persistent.JfopnmaplogListVO;
import com.sunrise.boss.business.cms.bbc.jfopnmaplog.control.JfopnmaplogControlBean;
import com.sunrise.boss.business.cms.bbc.jfopnmaplog.control.JfopnmaplogControl;

import java.io.Serializable;

/**
 * <p>Title: JfopnmaplogDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public class JfopnmaplogDelegate {

    private static JfopnmaplogControl control;

    public JfopnmaplogDelegate() throws Exception {
        control = (JfopnmaplogControl) ControlFactory.build(JfopnmaplogControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public JfopnmaplogVO doCreate(JfopnmaplogVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(JfopnmaplogVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }
    public JfopnmaplogVO doUpdate(JfopnmaplogVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public JfopnmaplogVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (JfopnmaplogVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(JfopnmaplogListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }
}
