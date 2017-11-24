/**
 * auto-generated code
 * Thu Apr 05 10:00:59 CST 2007
 */
package com.sunrise.boss.business.cms.adimarea.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.NonUniqueResultException;

import com.sunrise.boss.business.cms.adimarea.persistent.AdimareaDAO;
import com.sunrise.boss.business.cms.adimarea.persistent.AdimareaListVO;
import com.sunrise.boss.business.cms.adimarea.persistent.AdimareaVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>
 * Title: AdimareaControlBean
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
 * @author Ye Daoe
 * @version 1.0
 */
/**
 * @ejb.bean local-jndi-name="com/sunrise/boss/business/cms/adimarea/control/AdimareaControlBean"
 *           name="AdimareaControl" view-type="local" type="Stateless"
 * 
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class AdimareaControlBean extends AbstractControlBean implements
		AdimareaControl {

	public AdimareaVO doCreate(AdimareaVO vo, User user) throws Exception {
		try {
			// TODO set the pk */
			AdimareaDAO dao = (AdimareaDAO) DAOFactory.build(AdimareaDAO.class,
					user);
			if (dao.findByPk(vo.getAdacode()) != null) {
				throw new BusinessException("Adimarea-001", "�������������ظ�!");
			}
			return (AdimareaVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemove(AdimareaVO vo, User user) throws Exception {
		try {
			AdimareaDAO dao = (AdimareaDAO) DAOFactory.build(AdimareaDAO.class,
					user);
			AdimareaListVO listvo = new AdimareaListVO();
			listvo.set_se_uppercode(vo.getAdacode());
			if(dao.query(listvo).getRowCount()>0){
				throw new BusinessException("Adimarea-002", "���¼���������������ɾ�����¼���������!");
			}
			dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public AdimareaVO doUpdate(AdimareaVO vo, User user) throws Exception {
		try {
			AdimareaDAO dao = (AdimareaDAO) DAOFactory.build(AdimareaDAO.class,
					user);
			return (AdimareaVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public AdimareaVO doFindByPk(Serializable pk, User user) throws Exception {
		AdimareaDAO dao = (AdimareaDAO) DAOFactory.build(AdimareaDAO.class,
				user);
		return (AdimareaVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(AdimareaListVO params, User user)
			throws Exception {
		AdimareaDAO dao = (AdimareaDAO) DAOFactory.build(AdimareaDAO.class,
				user);
		return dao.query(params);
	}

	public AdimareaVO doChangeStatus(AdimareaVO vo, User user) throws Exception {
		try {
			AdimareaDAO dao = (AdimareaDAO) DAOFactory.build(AdimareaDAO.class,
					user);
			vo.setStatus(new java.lang.Byte((byte) 1));
			return (AdimareaVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	/**
	 * ���û�������ɾ��һ����¼ʱ,��Ҫ�ж�������¼�Ƿ������¼��������������ݷ�Χ��
	 */
	public boolean judgeIfReasonable(AdimareaListVO params,
			String contentuppercode, User user) throws Exception {
		AdimareaDAO dao = (AdimareaDAO) DAOFactory.build(AdimareaDAO.class,
				user);
		return dao.judgeIfReasonable(params, user.getWayid(), contentuppercode);
	}

	public DataPackage doQueryByOprcode(AdimareaListVO params, User user)
			throws Exception {
		AdimareaDAO dao = (AdimareaDAO) DAOFactory.build(AdimareaDAO.class,
				user);
		try {
			Object obj = dao.ifExistAdacode(params, user.getWayid());
			if (obj == null) {
				throw new BusinessException("Adimarea-003","�����ڵ�����û�ж�Ӧ��������������,��Ȩ�鿴���������Ϣ!");
			} else {
				DataPackage dp = dao.queryByOprcode(params, user.getWayid());
				return dp;
			}
		} catch (NonUniqueResultException e) {
			throw new BusinessException("Adimarea-004", "��¼�����Ƿ�");
		}

	}

	public List doQueryUpperada(String adacode, User user) throws Exception {
		AdimareaDAO dao = (AdimareaDAO) DAOFactory.build(AdimareaDAO.class,
				user);
		List list = dao.doQuerySuberada(adacode);
		List result = new ArrayList();
		for (Iterator it = list.iterator(); it.hasNext();) {
			AdimareaVO vo = (AdimareaVO) it.next();
			if (!StringUtils.equals(adacode, vo.getAdacode())) {
				result.add(vo);
			}
		}
		return result;
	}

	/**
	 * ����Ͻ���˿���
	 */
	public Long doAddupTotalppn(AdimareaListVO listvo, User user)
			throws Exception {
		AdimareaDAO dao = (AdimareaDAO) DAOFactory.build(AdimareaDAO.class,
				user);
		return dao.AddupTotalppn(listvo);
	}

	/**
	 * ���ܳ�ס�˿���
	 */
	public Long doAddupResippn(AdimareaListVO listvo, User user)
			throws Exception {
		AdimareaDAO dao = (AdimareaDAO) DAOFactory.build(AdimareaDAO.class,
				user);
		return dao.AddupResippn(listvo);
	}

	/**
	 * ���������˿���
	 */
	public Long doAddupNonresippn(AdimareaListVO listvo, User user)
			throws Exception {
		AdimareaDAO dao = (AdimareaDAO) DAOFactory.build(AdimareaDAO.class,
				user);
		return dao.AddupNonresippn(listvo);
	}

	/**
	 * ����Ͻ�����
	 */
	public Long doAddupAdarea(AdimareaListVO listvo, User user)
			throws Exception {
		AdimareaDAO dao = (AdimareaDAO) DAOFactory.build(AdimareaDAO.class,
				user);
		return dao.AddupAdarea(listvo);
	}

	/**
	 * ����Ͻ���ƶ��û���
	 */
	public Long doAddupGmccusers(AdimareaListVO listvo, User user)
			throws Exception {
		AdimareaDAO dao = (AdimareaDAO) DAOFactory.build(AdimareaDAO.class,
				user);
		return dao.AddupGmccusers(listvo);
	}

	/**
	 * ����Ͻ����ͨ�û���
	 */
	public Long doAddupCucusers(AdimareaListVO listvo, User user)
			throws Exception {
		AdimareaDAO dao = (AdimareaDAO) DAOFactory.build(AdimareaDAO.class,
				user);
		return dao.AddupCucusers(listvo);
	}

	/**
	 * ����Ͻ�������û���
	 */
	public Long doAddupCtcusers(AdimareaListVO listvo, User user)
			throws Exception {
		AdimareaDAO dao = (AdimareaDAO) DAOFactory.build(AdimareaDAO.class,
				user);
		return dao.AddupCtcusers(listvo);
	}

	/**
	 * ����Ͻ���ƶ��绰�û���
	 */
	public Long doAddupHandphones(AdimareaListVO listvo, User user)
			throws Exception {
		AdimareaDAO dao = (AdimareaDAO) DAOFactory.build(AdimareaDAO.class,
				user);
		return dao.AddupHandphones(listvo);
	}

	/**
	 * ����������������Ϣʱ,ͬʱ�Ѵ�����¼��Ӧ����֯�ṹ��Ϣ�����������������Ϊ��ǰ������ļ�¼��������������.
	 */
	public void doChgAdacodeofOrg(String orgcode, String adacode, User user)
			throws Exception {
		AdimareaDAO dao = (AdimareaDAO) DAOFactory.build(AdimareaDAO.class,
				user);
		dao.ChgAdacodeofOrg(orgcode, adacode, user);
	}

}
