/**
* auto-generated code
* Wed Apr 04 10:31:36 CST 2007
*/
package com.sunrise.boss.business.cms.reward.rewardtotal.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.pub.tools.Sequence;
import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.admin.dictitem.persistent.DictitemVO;
import com.sunrise.boss.business.cms.reward.rewardtotal.persistent.RewardtotalDAO;
import com.sunrise.boss.business.cms.reward.rewardtotal.persistent.RewardtotalListVO;
import com.sunrise.boss.business.cms.reward.rewardtotal.persistent.RewardtotalVO;
import com.sunrise.boss.business.cms.way.persistent.WayDAO;

/**
 * <p>Title: RvwaycntControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author zhaowen
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/reward/rewardtotal/control/RewardtotalControlBean"
 name="RewardtotalControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class RewardtotalControlBean extends AbstractControlBean
    implements RewardtotalControl {

	public RewardtotalVO doFindByPk(Serializable pk, User user) throws Exception {
		RewardtotalDAO dao = (RewardtotalDAO) DAOFactory.build(RewardtotalDAO.class, user);
        return (RewardtotalVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(RewardtotalListVO params, User user) throws Exception {
		RewardtotalDAO dao = (RewardtotalDAO) DAOFactory.build(RewardtotalDAO.class, user);
        return dao.query(params);
	}

    
}
