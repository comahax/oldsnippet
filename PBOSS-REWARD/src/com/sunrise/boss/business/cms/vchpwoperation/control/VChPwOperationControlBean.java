/**
* auto-generated code
* Wed Aug 29 19:13:31 CST 2012
*/
package com.sunrise.boss.business.cms.vchpwoperation.control;

import com.sunrise.boss.business.cms.vchpwoperation.persistent.VChPwOperationDAO;
import com.sunrise.boss.business.cms.vchpwoperation.persistent.VChPwOperationListVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: VChPwOperationControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/vchpwoperation/control/VChPwOperationControlBean"
 name="VChPwOperationControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class VChPwOperationControlBean extends AbstractControlBean
    implements VChPwOperationControl { 

	public DataPackage doQuery(VChPwOperationListVO params, User user)
			throws Exception {
		VChPwOperationDAO dao = (VChPwOperationDAO) DAOFactory.build(VChPwOperationDAO.class, user);
	      return dao.doQueryBusibelong(params);
	} 


}
