/**
* auto-generated code
* Wed Dec 31 13:51:34 CST 2008
*/
package com.sunrise.boss.business.cms.opntree.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.opntree.persistent.OpnTreeVO;
import com.sunrise.boss.business.cms.opntree.persistent.OpnTreeListVO;

import java.io.Serializable;

/**
 * <p>Title: OpnTreeControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public interface OpnTreeControl extends AbstractControl {

    public OpnTreeVO doFindByPk(Serializable pk, User user) throws Exception;
    //´Óµ×²ãÍùÉÏ²ãËÑË÷
    public int doQueryUpCount(OpnTreeListVO params, User user) throws Exception;
    public DataPackage doQueryUpData(OpnTreeListVO params, User user) throws Exception;
    //´ÓÉÏ²ãÍùµ×²ãËÑË÷
    public int doQueryDownCount(OpnTreeListVO params, User user) throws Exception;
    public DataPackage doQueryDownData(OpnTreeListVO params, User user) throws Exception;
    
}
