/**
* auto-generated code
* Sun Nov 29 14:14:27 CST 2009
*/
package com.sunrise.boss.business.cms.examine.exmnrslt.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.examine.exmnrslt.persistent.ExmnrsltVO;
import com.sunrise.boss.business.cms.examine.exmnrslt.persistent.ExmnrsltListVO;

import java.io.Serializable;

/**
 * <p>Title: ExmnrsltControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface ExmnrsltControl extends AbstractControl {
    public ExmnrsltVO doCreate(ExmnrsltVO vo, User user)
        throws Exception;

    public void doRemove(ExmnrsltVO vo, User user)
        throws Exception;

    public ExmnrsltVO doUpdate(ExmnrsltVO vo, User user)
        throws Exception;

    public ExmnrsltVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ExmnrsltListVO params, User user)
        throws Exception;
    /**
	 * 查找考核结果明细列表信息
	 * 
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public DataPackage doQueryExmnrsltInfo(ExmnrsltListVO listVO,User user)
			throws Exception ;

}
