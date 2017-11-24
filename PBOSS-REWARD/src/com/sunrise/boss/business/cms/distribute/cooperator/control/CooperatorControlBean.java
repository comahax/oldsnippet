/**
 * auto-generated code
 * Tue Dec 26 19:35:31 CST 2006
 */
package com.sunrise.boss.business.cms.distribute.cooperator.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bchcontact.control.BchcontactControl;
import com.sunrise.boss.business.cms.bchcontact.control.BchcontactControlBean;
import com.sunrise.boss.business.cms.bchcontact.persistent.BchcontactVO;
import com.sunrise.boss.business.cms.distribute.cooperator.persistent.CooperatorVO;
import com.sunrise.boss.business.cms.distribute.cooperator.persistent.CooperatorDAO;
import com.sunrise.boss.business.cms.distribute.cooperator.persistent.CooperatorListVO;
import com.sunrise.boss.business.cms.distribute.cpbusfeeway.persistent.CpbusfeewayDAO;
import com.sunrise.boss.business.cms.distribute.cpcomsalerl.persistent.CpcomsalerlDAO;
import com.sunrise.boss.business.cms.distribute.cpexam.persistent.CpexamDAO;
import com.sunrise.boss.business.cms.distribute.cpright.persistent.CprightDAO;
import com.sunrise.boss.business.cms.way.control.WayControl;
import com.sunrise.boss.business.cms.way.control.WayControlBean;
import com.sunrise.boss.business.cms.way.persistent.WayDAO;
import com.sunrise.boss.business.cms.way.persistent.WayVO;

/**
 * <p>
 * Title: CooperatorControlBean
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author
 * @version 1.0
 */
/**
 * @ejb.bean local-jndi-name="com/sunrise/boss/business/cms/distribute/cooperator/control/CooperatorControlBean"
 *           name="CooperatorControl" view-type="local" type="Stateless"
 * 
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class CooperatorControlBean extends AbstractControlBean implements
		CooperatorControl {

	public CooperatorVO doCreate(CooperatorVO vo, User user) throws Exception {
		try {
			CooperatorDAO dao = (CooperatorDAO) DAOFactory.build(
					CooperatorDAO.class, user);
			// TODO set the pk */
			// 同步新增渠道表
			WayVO wayVO = new WayVO();
			BeanUtils.copyProperties(wayVO, vo);
			wayVO.setWayid(vo.getCooperauid());
			wayVO.setWayname(vo.getCooperaname());
			wayVO.setShortname(vo.getCpabbrname());
			wayVO.setFunction(vo.getMemo());
			wayVO.setWaymagcode(vo.getCustmanager());
			if (vo.getArea() != null) {
				wayVO.setBuzarea(new Long(vo.getArea().longValue()));
			}
			wayVO.setWaystate(vo.getState());
			// wayVO.setBusicode(vo.getOldcoopera());
			wayVO.setBuzphoneno(vo.getSmsmobileno());
			wayVO.setWaytype("AG");
			wayVO.setWaystate(new Short("1"));
			wayVO.setIsCooperator("true");
			wayVO.setUpperwayid(user.getWayid());
			WayControl wayCtl = (WayControl) ControlFactory
					.build(WayControlBean.class);
			WayVO oldwayvo = (WayVO) wayCtl.doFindByPk(wayVO.getWayid(), user);
			if (oldwayvo == null) {
				wayCtl.doCreate(wayVO, user);
			}
			// 同步新增 渠道网点联系资料
			BchcontactVO bchVO = new BchcontactVO();
			bchVO.setWayid(vo.getCooperauid());
			bchVO.setPrincipal(vo.getServman());
			bchVO.setPrincipaltel(vo.getConntel());
			bchVO.setPrincipalemail(vo.getUsremail());
			bchVO.setLinkman(vo.getConnpers());
			bchVO.setLinkmantel(vo.getBusconntel());
			bchVO.setFax(vo.getConnfaxno());
			bchVO.setZipcode(vo.getZipcode());
			BchcontactControl bchCtl = (BchcontactControl) ControlFactory
					.build(BchcontactControlBean.class);
			if (bchCtl.doFindByPk(bchVO.getWayid(), user) == null) {
				bchCtl.doCreate(bchVO, user);
			}
			return (CooperatorVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public CooperatorVO doCreate1(CooperatorVO vo, User user) throws Exception {
		try {
			CooperatorDAO dao = (CooperatorDAO) DAOFactory.build(
					CooperatorDAO.class, user);
			return (CooperatorVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemove(CooperatorVO vo, User user) throws Exception {
		StringBuffer buffer = new StringBuffer();
		try {
			CooperatorDAO dao = (CooperatorDAO) DAOFactory.build(
					CooperatorDAO.class, user);

			// 与合作商权限表的关联
			if (this.doFindRelInCpright(vo.getCooperauid(), user)) {
				buffer.append("<br>编号为&nbsp;<font color='red'>"
						+ vo.getCooperauid() + "</font>&nbsp;的合作商与权限关联");
			}
			// 与合作商考核信息表的关联
			if (this.doFindRelInCpexam(vo.getCooperauid(), user)) {
				buffer.append("<br>编号为&nbsp;<font color='red'>"
						+ vo.getCooperauid() + "</font>&nbsp;的合作商与考核信息关联");
			}
			// 与合作商商品销售规则表的关联
			if (this.doFindRelInCpcomsalerl(vo.getCooperauid(), user)) {
				buffer.append("<br>编号为&nbsp;<font color='red'>"
						+ vo.getCooperauid() + "</font>&nbsp;的合作商与商品销售规则关联");
			}
			// 与合作商营收渠道表的关联
			if (this.doFindRelInCpbusfeeway(vo.getCooperauid(), user)) {
				buffer.append("<br>编号为&nbsp;<font color='red'>"
						+ vo.getCooperauid() + "</font>&nbsp;的合作商与合作商营收渠道关联");
			}
			if (buffer.toString().length() > 0)
				throw new BusinessException("", buffer.toString());
			dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;

		}
	}

	public CooperatorVO doUpdate(CooperatorVO vo, User user) throws Exception {
		try {
			// 判断是更新还是新增
			boolean isUpdate = true;
			CooperatorDAO dao = (CooperatorDAO) DAOFactory.build(
					CooperatorDAO.class, user);
			// 同步新增/修改渠道表
			WayControl wayCtl = (WayControl) ControlFactory
					.build(WayControlBean.class);
			WayVO wayVO = (WayVO) wayCtl.doFindByPk(vo.getCooperauid(), user);
			if (wayVO == null) {
				wayVO = new WayVO();
				isUpdate = false;
			}
			BeanUtils.copyProperties(wayVO, vo);
			wayVO.setWayid(vo.getCooperauid());
			wayVO.setWayname(vo.getCooperaname());
			wayVO.setShortname(vo.getCocheckname());
			wayVO.setFunction(vo.getMemo());
			wayVO.setWaymagcode(vo.getCustmanager());
			if (vo.getArea() != null) {
				wayVO.setBuzarea(new Long(vo.getArea().longValue()));
			}
			wayVO.setWaystate(vo.getState());
			if (wayVO.getWaytype() == null) {
				wayVO.setWaytype("AG");
			}
			if (wayVO.getWaystate() == null) {
				wayVO.setWaystate(new Short("1"));
			}
			wayVO.setIsCooperator("true");
			if (wayVO.getUpperwayid() == null) {
				wayVO.setUpperwayid(user.getWayid());
			}
			// wayVO.setBusicode(vo.getOldcoopera());
			wayVO.setBuzphoneno(vo.getSmsmobileno());
			if (isUpdate) {
				wayCtl.doUpdate(wayVO, user);
			} else {
				wayCtl.doCreate(wayVO, user);
			}
			isUpdate = true;
			// 同步新增/修改 渠道网点联系资料
			BchcontactControl bchCtl = (BchcontactControl) ControlFactory
					.build(BchcontactControlBean.class);
			BchcontactVO bchVO = (BchcontactVO) bchCtl.doFindByPk(vo
					.getCooperauid(), user);
			if (bchVO == null) {
				bchVO = new BchcontactVO();
				isUpdate = false;
			}
			bchVO.setWayid(vo.getCooperauid());
			bchVO.setPrincipal(vo.getServman());
			bchVO.setPrincipaltel(vo.getConntel());
			bchVO.setPrincipalemail(vo.getUsremail());
			bchVO.setLinkman(vo.getConnpers());
			bchVO.setLinkmantel(vo.getBusconntel());
			bchVO.setFax(vo.getConnfaxno());
			bchVO.setZipcode(vo.getZipcode());
			if (isUpdate) {
				bchCtl.doUpdate(bchVO, user);
			} else {
				bchCtl.doCreate(bchVO, user);
			}
			isUpdate = true;
			return (CooperatorVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public CooperatorVO doUpdate1(CooperatorVO vo, User user) throws Exception {
		try {
			CooperatorDAO dao = (CooperatorDAO) DAOFactory.build(
					CooperatorDAO.class, user);
			return (CooperatorVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public CooperatorVO doFindByPk(Serializable pk, User user) throws Exception {
		CooperatorDAO dao = (CooperatorDAO) DAOFactory.build(
				CooperatorDAO.class, user);
		return (CooperatorVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(CooperatorListVO params, User user)
			throws Exception {
		CooperatorDAO dao = (CooperatorDAO) DAOFactory.build(
				CooperatorDAO.class, user);
		return dao.query(params);
	}

	// 与合作商权限表的关联
	public boolean doFindRelInCpright(Serializable coopID, User user)
			throws Exception {
		CprightDAO dao = (CprightDAO) DAOFactory.build(CprightDAO.class, user);
		return dao.findByProperty("cooperauid", coopID) != null;
	}

	// 与合作商考核信息表的关联
	public boolean doFindRelInCpexam(Serializable coopID, User user)
			throws Exception {
		CpexamDAO dao = (CpexamDAO) DAOFactory.build(CpexamDAO.class, user);
		return dao.findByProperty("cooperauid", coopID) != null;
	}

	// 与合作商商品销售规则表的关联
	public boolean doFindRelInCpcomsalerl(Serializable coopID, User user)
			throws Exception {
		CpcomsalerlDAO dao = (CpcomsalerlDAO) DAOFactory.build(
				CpcomsalerlDAO.class, user);
		return dao.findByProperty("cooperauid", coopID) != null;
	}

	// 与合作商营收渠道表的关联
	public boolean doFindRelInCpbusfeeway(Serializable coopID, User user)
			throws Exception {
		CpbusfeewayDAO dao = (CpbusfeewayDAO) DAOFactory.build(
				CpbusfeewayDAO.class, user);
		return dao.findByProperty("cooperauid", coopID) != null;
	}

	// 查找默认上级渠道
//	public String getUppwayid(User user) throws Exception {
//		WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
//		WayVO vo = (WayVO) dao.findByPk(user.getWayid());
//		if (vo.getUpperwayid() != null) {
//			if ("GDYD".equals(vo.getUpperwayid())) {
//				return user.getWayid();
//			} else {
//				return vo.getUpperwayid();
//			}
//		} else {
//			throw new BusinessException("当前工号的上级渠道不存在!");
//		}
//
//	}
}
