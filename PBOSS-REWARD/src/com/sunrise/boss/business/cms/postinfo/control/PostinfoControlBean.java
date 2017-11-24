/**
 * auto-generated code
 * Sun Aug 27 12:00:09 CST 2006
 */
package com.sunrise.boss.business.cms.postinfo.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.employee.control.EmployeeControl;
import com.sunrise.boss.business.cms.employee.control.EmployeeControlBean;
import com.sunrise.boss.business.cms.postinfo.persistent.PostinfoVO;
import com.sunrise.boss.business.cms.postinfo.persistent.PostinfoDAO;
import com.sunrise.boss.business.cms.postinfo.persistent.PostinfoListVO;

/**
 * <p>
 * Title: PostinfoControlBean
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
 * @author yjr
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/boss/business/cms/postinfo/control/PostinfoControlBean"
*    name="PostinfoControl"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class PostinfoControlBean extends AbstractControlBean implements
		PostinfoControl {

	public PostinfoVO doCreate(PostinfoVO vo, User user) throws Exception {
		try {
			// TODO set the pk */
			PostinfoDAO dao = (PostinfoDAO) DAOFactory.build(PostinfoDAO.class,
					user);
			return (PostinfoVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemove(PostinfoVO vo, User user) throws Exception {
		try {
			PostinfoDAO dao = (PostinfoDAO) DAOFactory.build(PostinfoDAO.class,
					user);

			PostinfoListVO listVO = new PostinfoListVO();
			listVO.set_ne_parentpost(vo.getPostid().toString());
			DataPackage dp = dao.query(listVO);
			if (dp.getDatas().size() > 0)
				throw new BusinessException("", "岗位信息被其他岗位引用，不能删除");

			EmployeeControl employeeControl = (EmployeeControl) ControlFactory
					.build(EmployeeControlBean.class);
			DataPackage post = employeeControl.getByPostinfo(vo.getPostid(),
					user);

			if (post.getDatas().size() > 0)
				throw new BusinessException("", "岗位信息被人员信息表引用，不能删除");

			dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public PostinfoVO doUpdate(PostinfoVO vo, User user) throws Exception {
		try {
			PostinfoDAO dao = (PostinfoDAO) DAOFactory.build(PostinfoDAO.class,
					user);
			return (PostinfoVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public PostinfoVO doFindByPk(Serializable pk, User user) throws Exception {
		PostinfoDAO dao = (PostinfoDAO) DAOFactory.build(PostinfoDAO.class,
				user);
		return (PostinfoVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(PostinfoListVO params, User user)
			throws Exception {
		PostinfoDAO dao = (PostinfoDAO) DAOFactory.build(PostinfoDAO.class,
				user);
		return dao.query(params);
	}
}
