/**
* auto-generated code
* Sun Nov 29 14:14:27 CST 2009
*/
package com.sunrise.boss.delegate.cms.examine.exmnrslt;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.examine.exmnrslt.persistent.ExmnrsltVO;
import com.sunrise.boss.business.cms.examine.exmnrslt.persistent.ExmnrsltListVO;
import com.sunrise.boss.business.cms.examine.exmnrslt.control.ExmnrsltControlBean;
import com.sunrise.boss.business.cms.examine.exmnrslt.control.ExmnrsltControl;

import java.io.Serializable;

/**
 * <p>Title: ExmnrsltDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ExmnrsltDelegate {

    private static ExmnrsltControl control;

    public ExmnrsltDelegate() throws Exception {
        control = (ExmnrsltControl) ControlFactory.build(ExmnrsltControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ExmnrsltVO doCreate(ExmnrsltVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(ExmnrsltVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public ExmnrsltVO doUpdate(ExmnrsltVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ExmnrsltVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ExmnrsltVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ExmnrsltListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }
    /**
	 * 查找考核结果明细列表信息
	 * 
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public DataPackage doQueryExmnrsltInfo(ExmnrsltListVO listVO,User user)
			throws Exception {
		  return control.doQueryExmnrsltInfo(listVO, user);
	}

}
