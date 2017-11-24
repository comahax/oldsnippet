/**
 * auto-generated code
 * Fri Jan 04 15:56:32 CST 2008
 */
package com.sunrise.boss.business.cms.resale.control;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Iterator;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.pub.tools.Sequence;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.resale.persistent.ResaleVO;
import com.sunrise.boss.business.cms.resale.persistent.ResaleDAO;
import com.sunrise.boss.business.cms.resale.persistent.ResaleListVO;

/**
 * <p>
 * Title: ResaleControlBean
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
 * @author
 * @version 1.0
 */
/**
 * @ejb.bean local-jndi-name="com/sunrise/boss/business/cms/resale/control/ResaleControlBean"
 *           name="ResaleControl" view-type="local" type="Stateless"
 * 
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class ResaleControlBean extends AbstractControlBean implements
		ResaleControl {

	public ResaleVO doCreate(ResaleVO vo, User user) throws Exception {
		try {
			ResaleDAO dao = (ResaleDAO) DAOFactory.build(ResaleDAO.class, user);
			return (ResaleVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			if (ex.getMessage().indexOf("unique") != -1) {
				throw new BusinessException("", "对应的记录已存在，不能重复录入!");
			} else {
				throw ex;
			}
		}
	}

	public void doRemove(ResaleVO vo, User user) throws Exception {
		try {
			ResaleDAO dao = (ResaleDAO) DAOFactory.build(ResaleDAO.class, user);
			dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public ResaleVO doUpdate(ResaleVO vo, User user) throws Exception {
		ResaleDAO dao = (ResaleDAO) DAOFactory.build(ResaleDAO.class, user);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		vo.setCalcmonth(sdf.format(vo.getDaytime()));// 设置结算月份
		return (ResaleVO) dao.update(vo);
	}

	public ResaleVO doFindByPk(Serializable pk, User user) throws Exception {
		ResaleDAO dao = (ResaleDAO) DAOFactory.build(ResaleDAO.class, user);
		return (ResaleVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(ResaleListVO params, User user) throws Exception {
		ResaleDAO dao = (ResaleDAO) DAOFactory.build(ResaleDAO.class, user);
		return dao.query(params);
	}

	public DataPackage getMobileSequence(String sql,User user) throws Exception {
		ResaleDAO dao = (ResaleDAO) DAOFactory.build(ResaleDAO.class, user);
		return dao.getMobileSequence(sql);
	}
	public String checkOpnID(String mobile,User user) throws Exception {
		ResaleDAO dao = (ResaleDAO) DAOFactory.build(ResaleDAO.class, user);
		return dao.checkOpnID(mobile);
	}
}
