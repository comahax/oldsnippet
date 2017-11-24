/**
* auto-generated code
* Thu Sep 18 15:19:11 CST 2008
*/
package com.sunrise.boss.business.cms.bbc.jfopnmaplog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.jfopnmaplog.persistent.JfopnmaplogVO;
import com.sunrise.boss.business.cms.bbc.jfopnmaplog.persistent.JfopnmaplogListVO;

import java.io.Serializable;

/**
 * <p>Title: JfopnmaplogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public interface JfopnmaplogControl extends AbstractControl {
    public JfopnmaplogVO doCreate(JfopnmaplogVO vo, User user)
        throws Exception;

    public void doRemove(JfopnmaplogVO vo, User user)
        throws Exception;

    public JfopnmaplogVO doUpdate(JfopnmaplogVO vo, User user)
        throws Exception;

    public JfopnmaplogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(JfopnmaplogListVO params, User user)
        throws Exception;

}
