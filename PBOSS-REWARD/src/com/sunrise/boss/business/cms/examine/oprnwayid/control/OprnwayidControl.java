/**
* auto-generated code
* Wed Nov 18 10:31:12 CST 2009
*/
package com.sunrise.boss.business.cms.examine.oprnwayid.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.examine.oprnwayid.persistent.OprnwayidVO;
import com.sunrise.boss.business.cms.examine.oprnwayid.persistent.OprnwayidListVO;

import java.io.Serializable;

/**
 * <p>Title: OprnwayidControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public interface OprnwayidControl extends AbstractControl {
    public OprnwayidVO doCreate(OprnwayidVO vo, User user)
        throws Exception;

    public void doRemove(OprnwayidVO vo, User user)
        throws Exception;

    public OprnwayidVO doUpdate(OprnwayidVO vo, User user)
        throws Exception;

    public OprnwayidVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(OprnwayidListVO params, User user)
        throws Exception;
    /**
     * 渠道评分授权交接
     */
    public void doTransf(String oldoperid,String newoperid,User user)throws Exception;

}
