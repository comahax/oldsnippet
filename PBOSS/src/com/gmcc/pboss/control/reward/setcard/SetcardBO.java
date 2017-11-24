package com.gmcc.pboss.control.reward.setcard;

import java.io.Serializable;

import com.gmcc.pboss.business.reward.setcard.SetcardDAO;
import com.gmcc.pboss.business.reward.setcard.SetcardDBParam;
import com.gmcc.pboss.business.reward.setcard.SetcardVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>
 * Title: PaymentBO
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2010
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author a-biao
 * @version 1.0
 */
public class SetcardBO extends AbstractControlBean implements Setcard {

	// 如果pagesize为0，表示不分页，只有1页
	private final String NG_PAGESIZE = "0";
	// 已审核状态
	private final String ISCHECKED = "ischecked";
	private final String NOTCHECKED = "notchecked";

	public SetcardVO doCreate(SetcardVO vo) throws Exception {
		try {
			SetcardDAO dao = (SetcardDAO) DAOFactory.build(SetcardDAO.class,
					user);
			return (SetcardVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(SetcardVO vo) throws Exception {
		try {
			SetcardDAO dao = (SetcardDAO) DAOFactory.build(SetcardDAO.class,
					user);
			vo = doFindByPk(vo);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			SetcardDAO dao = (SetcardDAO) DAOFactory.build(SetcardDAO.class,
					user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public SetcardVO doUpdate(SetcardVO vo) throws Exception {
		try {
			SetcardDAO dao = (SetcardDAO) DAOFactory.build(SetcardDAO.class,
					user);
			return (SetcardVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public SetcardVO doFindByPk(Serializable pk) throws Exception {
		try {
			SetcardDAO dao = (SetcardDAO) DAOFactory.build(SetcardDAO.class,
					user);
			return (SetcardVO) dao.findByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public DataPackage doQuery(SetcardDBParam params) throws Exception {
		try {
			SetcardDAO dao = (SetcardDAO) DAOFactory.build(SetcardDAO.class,
					user);
			return dao.query(params);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

}
