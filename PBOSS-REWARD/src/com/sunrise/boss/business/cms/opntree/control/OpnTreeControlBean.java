/**
* auto-generated code
* Wed Dec 31 13:51:34 CST 2008
*/
package com.sunrise.boss.business.cms.opntree.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.pub.tools.Sequence;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.opntree.persistent.OpnTreeVO;
import com.sunrise.boss.business.cms.opntree.persistent.OpnTreeDAO;
import com.sunrise.boss.business.cms.opntree.persistent.OpnTreeListVO;

/**
 * <p>Title: OpnTreeControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/opntree/control/OpnTreeControlBean"
 name="OpnTreeControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class OpnTreeControlBean extends AbstractControlBean implements OpnTreeControl {
	
    public OpnTreeVO doFindByPk(Serializable pk, User user) throws Exception {
        OpnTreeDAO dao = (OpnTreeDAO) DAOFactory.build(OpnTreeDAO.class, user);
        return (OpnTreeVO) dao.findByPk(pk);
    }
    
	public int doQueryDownCount(OpnTreeListVO params, User user) throws Exception {
		OpnTreeDAO dao = (OpnTreeDAO) DAOFactory.build(OpnTreeDAO.class, user);
		return dao.queryDownCount(params, user);
	}
	
	public DataPackage doQueryDownData(OpnTreeListVO params, User user) throws Exception {
		OpnTreeDAO dao = (OpnTreeDAO) DAOFactory.build(OpnTreeDAO.class, user);
		return dao.queryDownData(params, user);
	}
	
	public int doQueryUpCount(OpnTreeListVO params, User user) throws Exception {
		OpnTreeDAO dao = (OpnTreeDAO) DAOFactory.build(OpnTreeDAO.class, user);
		return dao.queryUpCount(params, user);
	}
	
	public DataPackage doQueryUpData(OpnTreeListVO params, User user) throws Exception {
		OpnTreeDAO dao = (OpnTreeDAO) DAOFactory.build(OpnTreeDAO.class, user);
		return dao.queryUpData(params, user);
	}

}
