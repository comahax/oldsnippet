/**
* auto-generated code
* Tue Nov 22 15:32:38 CST 2011
*/
package com.sunrise.boss.business.cms.reward.ywjfjlmxb.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.ywjfjlmxb.persistent.YwjfjlmxbVO;
import com.sunrise.boss.business.cms.reward.ywjfjlmxb.persistent.YwjfjlmxbListVO;

import java.io.Serializable;

/**
 * <p>Title: YwjfjlmxbControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public interface YwjfjlmxbControl extends AbstractControl {
    public YwjfjlmxbVO doCreate(YwjfjlmxbVO vo, User user)
        throws Exception;

    public void doRemove(YwjfjlmxbVO vo, User user)
        throws Exception;

    public YwjfjlmxbVO doUpdate(YwjfjlmxbVO vo, User user)
        throws Exception;

    public YwjfjlmxbVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(YwjfjlmxbListVO params, User user,String[] ids)
        throws Exception;
    

}
