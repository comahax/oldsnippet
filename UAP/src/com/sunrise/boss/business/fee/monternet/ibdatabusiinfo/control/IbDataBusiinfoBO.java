package com.sunrise.boss.business.fee.monternet.ibdatabusiinfo.control;

import java.io.Serializable;

import com.sunrise.boss.business.fee.monternet.ibdatabusiinfo.persistent.IbDataBusiinfoDAO;
import com.sunrise.boss.business.fee.monternet.ibdatabusiinfo.persistent.IbDataBusiinfoDBParam;
import com.sunrise.boss.business.fee.monternet.ibdatabusiinfo.persistent.IbDataBusiinfoVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: IbDataBusiinfoBO </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 赵武
 * @version 1.0
 */
public class IbDataBusiinfoBO extends AbstractControlBean implements IbDataBusiinfo {

	public IbDataBusiinfoVO doCreate(IbDataBusiinfoVO vo) throws Exception {
		try {
			IbDataBusiinfoDAO dao = (IbDataBusiinfoDAO) DAOFactory.build(IbDataBusiinfoDAO.class, user);
			// TODO set the pk */
			return (IbDataBusiinfoVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(IbDataBusiinfoVO vo) throws Exception {
		try {
			IbDataBusiinfoDAO dao = (IbDataBusiinfoDAO) DAOFactory.build(IbDataBusiinfoDAO.class,user);
			vo = doFindByPk(vo);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			IbDataBusiinfoDAO dao = (IbDataBusiinfoDAO) DAOFactory.build(IbDataBusiinfoDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public IbDataBusiinfoVO doUpdate(IbDataBusiinfoVO vo) throws Exception {
		try {
			IbDataBusiinfoDAO dao = (IbDataBusiinfoDAO) DAOFactory.build(IbDataBusiinfoDAO.class,user);
			return (IbDataBusiinfoVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public IbDataBusiinfoVO doFindByPk(Serializable pk) throws Exception {
		try {
			IbDataBusiinfoDAO dao = (IbDataBusiinfoDAO) DAOFactory.build(IbDataBusiinfoDAO.class,user);
			return (IbDataBusiinfoVO) dao.findByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public DataPackage doQuery(IbDataBusiinfoDBParam params) throws Exception {
		try {
			IbDataBusiinfoDAO dao = (IbDataBusiinfoDAO) DAOFactory.build(IbDataBusiinfoDAO.class,user);
			return dao.query(params);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}		
	}
}
