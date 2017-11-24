/**
 * auto-generated code
 * Fri Aug 03 13:32:29 CST 2007
 */
package com.sunrise.boss.business.cms.personalbusi.control;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.pub.tools.Sequence;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.personalbusi.persistent.PersonalbusiVO;
import com.sunrise.boss.business.cms.personalbusi.persistent.PersonalbusiDAO;
import com.sunrise.boss.business.cms.personalbusi.persistent.PersonalbusiListVO;

/**
 * <p>
 * Title: PersonalbusiControlBean
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
 * @author WangHua
 * @version 1.0
 */
/**
 * @ejb.bean local-jndi-name="com/sunrise/boss/business/cms/personalbusi/control/PersonalbusiControlBean"
 *           name="PersonalbusiControl" view-type="local" type="Stateless"
 * 
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class PersonalbusiControlBean extends AbstractControlBean implements
		PersonalbusiControl {

	public PersonalbusiVO doCreate(PersonalbusiVO vo, User user)
			throws Exception {
		try {
			// TODO set the pk */
			// 号码与办理时间为逻辑主键
			PersonalbusiListVO listVO = new PersonalbusiListVO();
			String strDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
					.format(vo.getOpntime());
			listVO.set_de_opntime(strDate);
			listVO.set_se_mobile(vo.getMobile());
			DataPackage dp = doQuery(listVO, user);
			if (dp.getRowCount() > 0) {
				throw new BusinessException("", "已经存在相同的记录!");
			}
			PersonalbusiDAO dao = (PersonalbusiDAO) DAOFactory.build(
					PersonalbusiDAO.class, user);
			return (PersonalbusiVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemove(PersonalbusiVO vo, User user) throws Exception {
		try {
			PersonalbusiDAO dao = (PersonalbusiDAO) DAOFactory.build(
					PersonalbusiDAO.class, user);
			dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public PersonalbusiVO doUpdate(PersonalbusiVO vo, User user)
			throws Exception {
		try {
			PersonalbusiDAO dao = (PersonalbusiDAO) DAOFactory.build(
					PersonalbusiDAO.class, user);
			return (PersonalbusiVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public PersonalbusiVO doFindByPk(Serializable pk, User user)
			throws Exception {
		PersonalbusiDAO dao = (PersonalbusiDAO) DAOFactory.build(
				PersonalbusiDAO.class, user);
		return (PersonalbusiVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(PersonalbusiListVO params, User user)
			throws Exception {
		PersonalbusiDAO dao = (PersonalbusiDAO) DAOFactory.build(
				PersonalbusiDAO.class, user);
		return dao.query(params);
	}
}
