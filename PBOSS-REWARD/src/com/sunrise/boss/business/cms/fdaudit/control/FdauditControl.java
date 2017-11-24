/**
* auto-generated code
* Thu Jul 26 16:12:39 CST 2007
*/
package com.sunrise.boss.business.cms.fdaudit.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.fdaudit.persistent.FdauditVO;
import com.sunrise.boss.business.cms.fdaudit.persistent.FdauditListVO;
import com.sunrise.boss.business.cms.fdauditdef.persistent.FdauditdefVO;

import java.io.Serializable;

/**
 * <p>Title: FdauditControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author yuanweihai
 * @version 1.0
 */
public interface FdauditControl extends AbstractControl {
    public FdauditVO doCreate(FdauditVO vo, User user)
        throws Exception;

    public void doRemove(FdauditVO vo, User user)
        throws Exception;

    public FdauditVO doUpdate(FdauditVO vo, User user)
        throws Exception;

    public FdauditVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(FdauditListVO params, User user)
        throws Exception;
    /**
     * 自营渠道管理，零售渠道管理等，相应的要设置字段审批令牌控制
     */
    public boolean businessPurview(String purview,User user)throws Exception;
    /**
     * 字段回填
     * @param purview
     * @param user
     * @return
     * @throws Exception
     */
    public boolean fieldBackfill(FdauditVO vo,FdauditdefVO fdauditdefvo,User user)throws Exception;
    public Object doGetorgVO(Object vo, User user) throws Exception;
}
