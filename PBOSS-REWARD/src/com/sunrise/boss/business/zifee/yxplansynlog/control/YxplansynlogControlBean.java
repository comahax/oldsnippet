/**
 * auto-generated code
 * Thu Dec 11 16:31:58 CST 2008
 */
package com.sunrise.boss.business.zifee.yxplansynlog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.pub.tools.Sequence;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.zifee.yxplansynlog.persistent.YxplansynlogVO;
import com.sunrise.boss.business.zifee.yxplansynlog.persistent.YxplansynlogDAO;
import com.sunrise.boss.business.zifee.yxplansynlog.persistent.YxplansynlogListVO;

/**
 * <p>
 * Title: YxplansynlogControlBean
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: Maywide Tech Ltd.
 * </p>
 * 
 * @author Jerimy
 * @version 1.0
 */
/**
 * @ejb.bean local-jndi-name="com/sunrise/boss/business/zifee/yxplansynlog/control/YxplansynlogControlBean"
 *           name="YxplansynlogControl" view-type="local" type="Stateless"
 * 
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class YxplansynlogControlBean extends AbstractControlBean implements
		YxplansynlogControl {

	/**
	 * 
	 */
	private static final long serialVersionUID = -815447019352915085L;

	public YxplansynlogVO doCopysyn(String yxplanid, User user)
			throws Exception {
		YxplansynlogDAO dao = (YxplansynlogDAO) DAOFactory.build(
				YxplansynlogDAO.class, user);
		YxplansynlogVO vo = new YxplansynlogVO();
		vo.setCreatetime(new java.util.Date());
		vo.setModifytime(vo.getCreatetime());
		vo.setOprcode(user.getOpercode());
		vo.setYxplanid(yxplanid);
		vo.setOprstate("0");
		vo.setOprobject("CX");
		return (YxplansynlogVO) dao.create(vo);
	}

	public YxplansynlogVO doCreate(YxplansynlogVO vo, User user)
			throws Exception {
		try {
			// TODO set the pk */
			YxplansynlogDAO dao = (YxplansynlogDAO) DAOFactory.build(
					YxplansynlogDAO.class, user);
			return (YxplansynlogVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemove(YxplansynlogVO vo, User user) throws Exception {
		try {
			YxplansynlogDAO dao = (YxplansynlogDAO) DAOFactory.build(
					YxplansynlogDAO.class, user);
			dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public YxplansynlogVO doUpdate(YxplansynlogVO vo, User user)
			throws Exception {
		try {
			YxplansynlogDAO dao = (YxplansynlogDAO) DAOFactory.build(
					YxplansynlogDAO.class, user);
			return (YxplansynlogVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public YxplansynlogVO doFindByPk(Serializable pk, User user)
			throws Exception {
		YxplansynlogDAO dao = (YxplansynlogDAO) DAOFactory.build(
				YxplansynlogDAO.class, user);
		return (YxplansynlogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(YxplansynlogListVO params, User user)
			throws Exception {
		YxplansynlogDAO dao = (YxplansynlogDAO) DAOFactory.build(
				YxplansynlogDAO.class, user);
		return dao.query(params);
	}
}
