/**
* auto-generated code
* Thu Sep 18 15:14:41 CST 2008
*/
package com.sunrise.boss.delegate.cms.bbc.jfopnmap;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.jfopnmap.persistent.JfopnmapVO;
import com.sunrise.boss.business.cms.bbc.jfopnmap.persistent.JfopnmapListVO;
import com.sunrise.boss.business.cms.bbc.jfopnmap.control.JfopnmapControlBean;
import com.sunrise.boss.business.cms.bbc.jfopnmap.control.JfopnmapControl;

import java.io.Serializable;

/**
 * <p>Title: JfopnmapDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public class JfopnmapDelegate {

    private static JfopnmapControl control;

    public JfopnmapDelegate() throws Exception {
        control = (JfopnmapControl) ControlFactory.build(JfopnmapControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public JfopnmapVO doCreate(JfopnmapVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(JfopnmapVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }
    public JfopnmapVO doUpdate(JfopnmapVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public JfopnmapVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (JfopnmapVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(JfopnmapListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }
}
