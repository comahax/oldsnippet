/**
 * auto-generated code
 * Wed Dec 27 14:23:06 CST 2006
 */
package com.sunrise.boss.business.cms.distribute.cpcomsalerl.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.pub.tools.Sequence;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.distribute.cpcomsalerl.persistent.CpcomsalerlVO;
import com.sunrise.boss.business.cms.distribute.cpcomsalerl.persistent.CpcomsalerlDAO;
import com.sunrise.boss.business.cms.distribute.cpcomsalerl.persistent.CpcomsalerlListVO;
import com.sunrise.boss.business.cms.distribute.cooperator.persistent.CooperatorVO;
import com.sunrise.boss.business.cms.distribute.cooperator.persistent.CooperatorDAO;
import com.sunrise.boss.common.exception.business.BusinessException;

/**
 * @ejb.bean local-jndi-name="com/sunrise/boss/business/cms/distribute/cpcomsalerl/control/CpcomsalerlControlBean"
 *           name="CpcomsalerlControl" view-type="local" type="Stateless"
 * 
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class CpcomsalerlControlBean extends AbstractControlBean implements
		CpcomsalerlControl {

	public CpcomsalerlVO doCreate(CpcomsalerlVO vo, User user) throws Exception {
		try {
			// TODO set the pk */
			if (getCooperauid(vo, user)) {
				CpcomsalerlDAO dao = (CpcomsalerlDAO) DAOFactory.build(
						CpcomsalerlDAO.class, user);
				checkIndex(vo,user);
				return (CpcomsalerlVO) dao.create(vo);
			} else {
				throw new BusinessException("", "请输入在分销合作商资料表里存在的[合作商编号]值!");
			}
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemove(CpcomsalerlVO vo, User user) throws Exception {
		try {
			CpcomsalerlDAO dao = (CpcomsalerlDAO) DAOFactory.build(
					CpcomsalerlDAO.class, user);
			dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public CpcomsalerlVO doUpdate(CpcomsalerlVO vo, User user) throws Exception {
		try {
			if (getCooperauid(vo, user)) {
				CpcomsalerlDAO dao = (CpcomsalerlDAO) DAOFactory.build(
						CpcomsalerlDAO.class, user);
				return (CpcomsalerlVO) dao.update(vo);
			} else {
				throw new BusinessException("", "请输入在分销合作商资料表里存在的[合作商编号]值!");
			}
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public CpcomsalerlVO doFindByPk(Serializable pk, User user)
			throws Exception {
		CpcomsalerlDAO dao = (CpcomsalerlDAO) DAOFactory.build(
				CpcomsalerlDAO.class, user);
		return (CpcomsalerlVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(CpcomsalerlListVO params, User user)
			throws Exception {
		CpcomsalerlDAO dao = (CpcomsalerlDAO) DAOFactory.build(
				CpcomsalerlDAO.class, user);
		return dao.query(params);
	}

	private boolean getCooperauid(CpcomsalerlVO vo, User user) throws Exception {
		boolean flag = false;
		CooperatorDAO cpDAO = (CooperatorDAO) DAOFactory.build(
				CooperatorDAO.class, user);
		CooperatorVO cpVO = (CooperatorVO) cpDAO.findByPk(vo.getCooperauid());
		if (cpVO != null) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}
	private void checkIndex(CpcomsalerlVO vo,User user)throws Exception
	{
		CpcomsalerlDAO cpcomsalerlDAO=(CpcomsalerlDAO)DAOFactory.build(CpcomsalerlDAO.class, user);
		CpcomsalerlListVO listVO=new CpcomsalerlListVO();
		listVO.set_se_cooperauid(vo.getCooperauid());
		listVO.set_ne_fxtype(vo.getFxtype().toString());
		listVO.set_ne_comid(vo.getComid().toString());
		if(cpcomsalerlDAO.query(listVO, 10).getRowCount()>0)
		{
			throw new BusinessException("","已存在重复的一组值：[合作商编号][业务类型][商品标识]");
		}
	}
}
