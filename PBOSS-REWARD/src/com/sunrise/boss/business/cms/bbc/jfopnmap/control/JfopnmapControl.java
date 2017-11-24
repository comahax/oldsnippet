/**
* auto-generated code
* Thu Sep 18 15:14:41 CST 2008
*/
package com.sunrise.boss.business.cms.bbc.jfopnmap.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.jfopnmap.persistent.JfopnmapVO;
import com.sunrise.boss.business.cms.bbc.jfopnmap.persistent.JfopnmapListVO;

import java.io.Serializable;

/**
 * <p>Title: JfopnmapControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public interface JfopnmapControl extends AbstractControl {
    public JfopnmapVO doCreate(JfopnmapVO vo, User user)
        throws Exception;

    public void doRemove(JfopnmapVO vo, User user)
        throws Exception;

    public JfopnmapVO doUpdate(JfopnmapVO vo, User user)
        throws Exception;

    public JfopnmapVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(JfopnmapListVO params, User user)
        throws Exception;

}
