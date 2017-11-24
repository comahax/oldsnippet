/**
* auto-generated code
* Thu Mar 15 09:32:40 CST 2012
*/
package com.sunrise.boss.business.cms.reward.xjjlywjfmx.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.xjjlywjfmx.persistent.XjjlywjfmxVO;
import com.sunrise.boss.business.cms.reward.xjjlywjfmx.persistent.XjjlywjfmxListVO;

import java.io.Serializable;

/**
 * <p>Title: XjjlywjfmxControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public interface XjjlywjfmxControl extends AbstractControl {
    public XjjlywjfmxVO doCreate(XjjlywjfmxVO vo, User user)
        throws Exception;

    public void doRemove(XjjlywjfmxVO vo, User user)
        throws Exception;

    public XjjlywjfmxVO doUpdate(XjjlywjfmxVO vo, User user)
        throws Exception;

    public XjjlywjfmxVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(XjjlywjfmxListVO params, User user)
        throws Exception;

}
