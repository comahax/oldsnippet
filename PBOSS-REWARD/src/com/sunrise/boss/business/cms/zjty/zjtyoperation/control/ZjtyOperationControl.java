/**
* auto-generated code
* Thu Oct 23 11:41:56 CST 2008
*/
package com.sunrise.boss.business.cms.zjty.zjtyoperation.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.operation.persistent.OperationListVO;
import com.sunrise.boss.business.cms.zjty.zjtyoperation.persistent.ZjtyOperationVO;
import com.sunrise.boss.business.cms.zjty.zjtyoperation.persistent.ZjtyOperationListVO;

import java.io.Serializable;
import java.util.List;

/**
 * <p>Title: ZjtyOperationControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public interface ZjtyOperationControl extends AbstractControl {
    public ZjtyOperationVO doCreate(ZjtyOperationVO vo, User user)
        throws Exception;

    public void doRemove(ZjtyOperationVO vo, User user)
        throws Exception;

    public ZjtyOperationVO doUpdate(ZjtyOperationVO vo, User user)
        throws Exception;

    public ZjtyOperationVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ZjtyOperationListVO params, User user)
        throws Exception;
    
    public DataPackage doQueryForTree(ZjtyOperationListVO params, User user)
    	throws Exception;
    
	public List doQueryupper(ZjtyOperationListVO params,User user) throws Exception;

}
