package com.sunrise.boss.business.resmanage.nosect.control;

import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.NonUniqueResultException;

import com.sunrise.boss.business.resmanage.nosect.persistent.NosectDAO;
import com.sunrise.boss.business.resmanage.nosect.persistent.NosectListVO;
import com.sunrise.boss.business.resmanage.nosect.persistent.NosectVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.BaseLogDAO;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.ui.commons.User;

/**
 * @ejb.bean local-jndi-name="com/sunrise/boss/business/resmanage/nosect/control/NosectControlBean"
 *           name="NosectControl" view-type="local" type="Stateless"
 * 
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class NosectControlBean extends AbstractControlBean implements
		NosectControl {

	public NosectVO doCteate(NosectVO vo, User user) throws Exception {
		try {
			NosectDAO dao = (NosectDAO) DAOFactory.build(NosectDAO.class, user
					.getCityid());
			Long id = (Long) dao.getMaxValue("nosectid");
			if (id == null) {
				id = new Long(0);
			}
			vo.setNosectid(new Long(id.longValue() + 1));
			return (NosectVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public NosectVO doUpdate(NosectVO vo, User user) throws Exception {
		try {
			NosectDAO dao = (NosectDAO) DAOFactory.build(NosectDAO.class, user
					.getCityid());
			return (NosectVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public DataPackage doFindNosect(NosectListVO listVO, User user)
			throws Exception {
		NosectDAO dao = (NosectDAO) DAOFactory.build(NosectDAO.class, user
				.getCityid());
		return dao.query(listVO);
	}

	public int doCheckNosectDuplicate(String beginno, String endno, User user)
			throws Exception {
		NosectDAO dao = (NosectDAO) DAOFactory.build(NosectDAO.class, user);
		String cityid = SessionFactoryRouter.conversionCityid(user.getCityid());
		return dao.checkNosectDuplicate(beginno, endno, cityid);
	}

	public NosectVO doFindByPk(Long nosectid, User user) throws Exception {
		NosectDAO dao = (NosectDAO) DAOFactory.build(NosectDAO.class, user);
		return (NosectVO) dao.findByPk(nosectid);
	}

	private static final Log log = LogFactory.getLog(NosectControlBean.class);

	/**
	 * 通过手机号码查询号段表来判断是属于那个地市.
	 */
	public String doQueryCityID(String mobileNO, User user) throws Exception {
		//
		String str = "";
		NosectDAO dao = (NosectDAO) DAOFactory.build(NosectDAO.class, user);
		NosectVO vo = dao.getNosectByMobileno(mobileNO);
		if (vo == null) {
			throw new Exception("手机号码不存在或者不属于该地市");
		} else if (vo.getBossarea() != null) {
			str = vo.getBossarea();
		}
		return str;
	}
}
