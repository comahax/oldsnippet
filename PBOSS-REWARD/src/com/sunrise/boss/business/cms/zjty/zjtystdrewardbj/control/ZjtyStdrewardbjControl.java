/**
* auto-generated code
* Tue Oct 28 11:34:48 CST 2008
*/
package com.sunrise.boss.business.cms.zjty.zjtystdrewardbj.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.zjtystdrewardbj.persistent.ZjtyStdrewardbjVO;
import com.sunrise.boss.business.cms.zjty.zjtystdrewardbj.persistent.ZjtyStdrewardbjListVO;

import java.io.Serializable;
import java.util.List;

/**
 * <p>Title: ZjtyStdrewardbjControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public interface ZjtyStdrewardbjControl extends AbstractControl {
    public ZjtyStdrewardbjVO doCreate(ZjtyStdrewardbjVO vo, User user)
        throws Exception;

    public void doRemove(ZjtyStdrewardbjVO vo, User user)
        throws Exception;

    public ZjtyStdrewardbjVO doUpdate(ZjtyStdrewardbjVO vo, User user)
        throws Exception;

    public ZjtyStdrewardbjVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ZjtyStdrewardbjListVO params, User user)
        throws Exception;
    
	public void doSave(List list, User user) throws Exception;

	public void doSavecity(List list, User user) throws Exception;
}
