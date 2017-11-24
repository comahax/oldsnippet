/**
 * auto-generated code
 * Fri Oct 20 10:57:25 CST 2006
 */
package com.sunrise.boss.business.zifee.feedisclog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.pub.tools.Sequence;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.zifee.feedisclog.persistent.FeedisclogVO;
import com.sunrise.boss.business.zifee.feedisclog.persistent.FeedisclogDAO;
import com.sunrise.boss.business.zifee.feedisclog.persistent.FeedisclogListVO;
import com.sunrise.boss.business.zifee.yxplan.persistent.YxPlanListVO;
import com.sunrise.boss.business.zifee.yxplan.persistent.YxPlanVO;

/**
 * <p>Title: FeedisclogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author eboxdisc
 * @version 1.0
 */
/**
 * @ejb.bean
 *    local-jndi-name="com/sunrise/boss/business/zifee/feedisclog/control/FeedisclogControlBean"
 *    name="FeedisclogControl"
 *    view-type="local"
 *    type="Stateless"
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class FeedisclogControlBean extends AbstractControlBean implements
		FeedisclogControl {

	public FeedisclogVO doCreate(FeedisclogVO vo, User user) throws Exception {
		try {
			// TODO  set the pk */
			FeedisclogDAO dao = (FeedisclogDAO) DAOFactory.build(
					FeedisclogDAO.class, user);
			return (FeedisclogVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemove(FeedisclogVO vo, User user) throws Exception {
		try {
			FeedisclogDAO dao = (FeedisclogDAO) DAOFactory.build(
					FeedisclogDAO.class, user);
			dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public FeedisclogVO doUpdate(FeedisclogVO vo, User user) throws Exception {
		try {
			FeedisclogDAO dao = (FeedisclogDAO) DAOFactory.build(
					FeedisclogDAO.class, user);
			return (FeedisclogVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public FeedisclogVO doFindByPk(Serializable pk, User user) throws Exception {
		FeedisclogDAO dao = (FeedisclogDAO) DAOFactory.build(
				FeedisclogDAO.class, user);
		return (FeedisclogVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(FeedisclogListVO params, User user)
			throws Exception {
		FeedisclogDAO dao = (FeedisclogDAO) DAOFactory.build(
				FeedisclogDAO.class, user);
		YxPlanListVO yxListVO = new YxPlanListVO();
		//过虑日志记录，其他区域的日志信息不显示，集团统一营销案,全省,市公司,区域标识为空也在查询范围内
		String _sql_areacode = " (areacode is null or  areacode in ('999','','"
				+ user.getCityid() + "')) ";
		yxListVO.set_sql_areacode(_sql_areacode);
		FeedisclogListVO paramListVO = new FeedisclogListVO();
		BeanUtils.copyProperties(paramListVO, params);
		Object[] objs = { paramListVO, yxListVO };
		Class[] classes = { FeedisclogVO.class, YxPlanVO.class };
		String[][] joins = { { "yxplanid", "yxplanid" } };
		return dao.query2(objs, classes, joins);
	}
}
