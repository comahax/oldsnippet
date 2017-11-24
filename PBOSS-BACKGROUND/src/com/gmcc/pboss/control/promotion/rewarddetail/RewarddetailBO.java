/**
 * auto-generated code
 * Tue Sep 15 15:37:05 CST 2009
 */
package com.gmcc.pboss.control.promotion.rewarddetail;

import java.io.Serializable;

import com.gmcc.pboss.business.promotion.rewarddetail.RewarddetailDAO;
import com.gmcc.pboss.business.promotion.rewarddetail.RewarddetailDBParam;
import com.gmcc.pboss.business.promotion.rewarddetail.RewarddetailVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: RewarddetailBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/promotions/rewarddetail/control/RewarddetailBO"
*    name="Rewarddetail"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class RewarddetailBO extends AbstractControlBean implements
		Rewarddetail {

	public RewarddetailVO doCreate(RewarddetailVO vo) throws Exception {
		try {
			RewarddetailDAO dao = (RewarddetailDAO) DAOFactory.build(RewarddetailDAO.class, user);
			// TODO set the pk */
			return (RewarddetailVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(RewarddetailVO vo) throws Exception {
		try {
			RewarddetailDAO dao = (RewarddetailDAO) DAOFactory.build(RewarddetailDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			RewarddetailDAO dao = (RewarddetailDAO) DAOFactory.build(RewarddetailDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public RewarddetailVO doUpdate(RewarddetailVO vo) throws Exception {
		try {
			RewarddetailDAO dao = (RewarddetailDAO) DAOFactory.build(RewarddetailDAO.class,user);
			return (RewarddetailVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public RewarddetailVO doFindByPk(Serializable pk) throws Exception {
		RewarddetailDAO dao = (RewarddetailDAO) DAOFactory.build(RewarddetailDAO.class,user);
		return (RewarddetailVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(RewarddetailDBParam params)
			throws Exception {
		RewarddetailDAO dao = (RewarddetailDAO) DAOFactory.build(RewarddetailDAO.class,user);
		return dao.query(params);
	}
}
