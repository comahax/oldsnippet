/**
 * auto-generated code
 * Thu Oct 09 16:10:24 CST 2008
 */
package com.sunrise.boss.business.cms.mpsaudit.control;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.pub.tools.Sequence;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.mpsaudit.persistent.MpsauditVO;
import com.sunrise.boss.business.cms.mpsaudit.persistent.MpsauditDAO;
import com.sunrise.boss.business.cms.mpsaudit.persistent.MpsauditListVO;
import com.sunrise.boss.business.common.sysparam.persistent.SysparamDAO;

/**
 * <p>
 * Title: MpsauditControlBean
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
 * @ejb.bean local-jndi-name="com/sunrise/boss/business/cms/mpsaudit/control/MpsauditControlBean"
 *           name="MpsauditControl" view-type="local" type="Stateless"
 * 
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class MpsauditControlBean extends AbstractControlBean implements
		MpsauditControl {

	public MpsauditVO doCreate(MpsauditVO vo, User user) throws Exception {
		try {
			// TODO set the pk */
			MpsauditDAO dao = (MpsauditDAO) DAOFactory.build(MpsauditDAO.class,
					user);
			return (MpsauditVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemove(MpsauditVO vo, User user) throws Exception {
		try {
			MpsauditDAO dao = (MpsauditDAO) DAOFactory.build(MpsauditDAO.class,
					user);
			dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public MpsauditVO doUpdate(MpsauditVO vo, User user) throws Exception {
		try {
			MpsauditDAO dao = (MpsauditDAO) DAOFactory.build(MpsauditDAO.class,
					user);
			return (MpsauditVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public MpsauditVO doFindByPk(Serializable pk, User user) throws Exception {
		MpsauditDAO dao = (MpsauditDAO) DAOFactory.build(MpsauditDAO.class,
				user);
		return (MpsauditVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(MpsauditListVO params, User user)
			throws Exception {
		MpsauditDAO dao = (MpsauditDAO) DAOFactory.build(MpsauditDAO.class,
				user);
		DataPackage dp = dao.query(params);
		SysparamDAO sysDAO = (SysparamDAO) DAOFactory.build(SysparamDAO.class,
				user);
		String str = sysDAO.doFindByID(new Long("51"), "channel");
		if (str != null) {
			Collection col = dp.getDatas();
			double compare = new Double(str).doubleValue();
			for (Iterator it=col.iterator();it.hasNext();) {
				MpsauditVO vo = (MpsauditVO) it.next();
				if (vo.getPercent().doubleValue() < compare) {
					vo.setSuccessFlag("no");
				} else {
					vo.setSuccessFlag("yes");
				}
			}
		}
		return dp;
	}
}
