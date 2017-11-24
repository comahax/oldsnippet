/**
 * auto-generated code
 * Sat Jul 29 16:54:43 CST 2006
 */
package com.sunrise.boss.business.cms.provincialright.control;

import com.sunrise.boss.business.admin.acl.control.ACLControl;
import com.sunrise.boss.business.admin.acl.control.ACLControlBean;
import com.sunrise.boss.business.cms.provincialright.persistent.ProvincialrightDAO;
import com.sunrise.boss.business.cms.provincialright.persistent.ProvincialrightListVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>
 * Title: ProvincialrightControlBean
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @version 1.0 duhuazheng
 */
/**
 * @ejb.bean local-jndi-name="com/sunrise/boss/business/cms/provincialright/control/ProvincialrightControlBean"
 *           name="ProvincialrightControl" view-type="local" type="Stateless"
 * 
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */


public class ProvincialrightControlBean extends AbstractControlBean implements ProvincialrightControl {

	public boolean checkPurview(User user, String purviewId)
			throws Exception {
		ACLControl aclcontrol = (ACLControl) ControlFactory.build(ACLControlBean.class);
		if(aclcontrol.checkPermission(user.getOpercode(), purviewId)){
			return true;
		}
		ProvincialrightDAO dao = (ProvincialrightDAO) DAOFactory.build(ProvincialrightDAO.class, user);
		ProvincialrightListVO listvo = new ProvincialrightListVO();
		listvo.set_se_proopr(user.getOpercode());
		listvo.set_se_rightid(purviewId);
		DataPackage dp = dao.query(listvo);
		if(dp.getDatas()!=null && dp.getDatas().size()!=0){
			return true;
		}else{
			return false;
		}
	}
	
	public DataPackage doQuery(ProvincialrightListVO params, User user)
	throws Exception {
		ProvincialrightDAO dao = (ProvincialrightDAO) DAOFactory.build(
			ProvincialrightDAO.class, user );
	return dao.query(params);
}

}