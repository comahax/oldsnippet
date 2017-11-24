/**
* auto-generated code
* Tue Aug 26 20:17:18 CST 2008
*/
package com.sunrise.boss.business.cms.bbc.stdrewardbj.control;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import com.sunrise.boss.business.cms.bbc.stdreward.control.BBCstdrewardControl;
import com.sunrise.boss.business.cms.bbc.stdreward.control.BBCstdrewardControlBean;
import com.sunrise.boss.business.cms.bbc.stdreward.persistent.BBCstdrewardVO;
import com.sunrise.boss.business.cms.bbc.stdrewardbj.persistent.BBCstdrewardbjDAO;
import com.sunrise.boss.business.cms.bbc.stdrewardbj.persistent.BBCstdrewardbjListVO;
import com.sunrise.boss.business.cms.bbc.stdrewardbj.persistent.BBCstdrewardbjVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: BBCstdrewardbjControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/bbc/stdrewardbj/control/BBCstdrewardbjControlBean"
 name="BBCstdrewardbjControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class BBCstdrewardbjControlBean extends AbstractControlBean
    implements BBCstdrewardbjControl {

	public BBCstdrewardbjVO doCreate(BBCstdrewardbjVO vo, User user) throws Exception {
		try {
			BBCstdrewardbjDAO dao = (BBCstdrewardbjDAO) DAOFactory.build(
					BBCstdrewardbjDAO.class, user);
			return (BBCstdrewardbjVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemove(BBCstdrewardbjVO vo, User user) throws Exception {
		try {
			BBCstdrewardbjDAO dao = (BBCstdrewardbjDAO) DAOFactory.build(
					BBCstdrewardbjDAO.class, user);
			dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public BBCstdrewardbjVO doUpdate(BBCstdrewardbjVO vo, User user) throws Exception {
		try {
			BBCstdrewardbjDAO dao = (BBCstdrewardbjDAO) DAOFactory.build(
					BBCstdrewardbjDAO.class, user);
			return (BBCstdrewardbjVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public BBCstdrewardbjVO doFindByPk(Serializable pk, User user)
			throws Exception {
		BBCstdrewardbjDAO dao = (BBCstdrewardbjDAO) DAOFactory.build(
				BBCstdrewardbjDAO.class, user);
		return (BBCstdrewardbjVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(BBCstdrewardbjListVO params, User user)
			throws Exception {
		BBCstdrewardbjDAO dao = (BBCstdrewardbjDAO) DAOFactory.build(
				BBCstdrewardbjDAO.class, user);
		return dao.query(params);
	}

	/**
	 * 计件酬金标准设置 保存
	 * 
	 * @param list
	 * @param user
	 * @throws Exception
	 */
	public void doSave(List list, User user) throws Exception {
		try {
			if (null == list || list.size() == 0) {
				return;
			}

			BBCstdrewardbjDAO dao = (BBCstdrewardbjDAO) DAOFactory.build(
					BBCstdrewardbjDAO.class, user);
			BBCstdrewardControl bbcstdrewardControl = (BBCstdrewardControl) ControlFactory
					.build(BBCstdrewardControlBean.class);
			for (Iterator iter = list.iterator(); iter.hasNext();) {
				BBCstdrewardbjVO item = (BBCstdrewardbjVO) iter.next();
				BBCstdrewardVO bbcstdrewardVO = new BBCstdrewardVO();
				BeanUtils.copyProperties(bbcstdrewardVO, item);

				//删除操作
				if (item.isDeleteflag()) {
					bbcstdrewardControl.doRemove(bbcstdrewardVO, user);
					
					BBCstdrewardbjListVO listvo = new BBCstdrewardbjListVO();
					listvo.set_ne_rewardid(item.getRewardid());
					
					DataPackage dp = dao.query(listvo);
					Iterator itt = dp.getDatas().iterator();
					while(itt.hasNext()){
						BBCstdrewardbjVO vo = (BBCstdrewardbjVO)itt.next();
						dao.remove(vo);
					}
					
					continue;
				}
				
				//新增或更新操作
				if (null == item.getRewardid()) {
					bbcstdrewardVO = bbcstdrewardControl.doCreate(bbcstdrewardVO, user);
				} else {
					bbcstdrewardVO = bbcstdrewardControl.doUpdate(bbcstdrewardVO, user);
				}

				BBCstdrewardbjVO bbcstdrewardbjVO = new BBCstdrewardbjVO();
				BeanUtils.copyProperties(bbcstdrewardbjVO, item);
				bbcstdrewardbjVO.setRewardid(bbcstdrewardVO.getRewardid());
				if (null == item.getRewardid()) {
					dao.create(bbcstdrewardbjVO);
				} else {
					dao.update(bbcstdrewardbjVO);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}
	
	/**
	 * 市公司计件酬金上限设置 保存
	 * 
	 * @param list
	 * @param user
	 * @throws Exception
	 */
	public void doSavecity(List list, User user) throws Exception {
		try {
			if (null == list || list.size() == 0) {
				return;
			}

			BBCstdrewardbjDAO dao = (BBCstdrewardbjDAO) DAOFactory.build(
					BBCstdrewardbjDAO.class, user);
			for (Iterator iter = list.iterator(); iter.hasNext();) {
				BBCstdrewardbjVO item = (BBCstdrewardbjVO) iter.next();
				BBCstdrewardbjVO vo = new BBCstdrewardbjVO();
				vo.setRegion(user.getCityid());
				vo.setRewardid(item.getRewardid());
				vo.setOssrc(item.getOssrc());
				vo = (BBCstdrewardbjVO) dao.findByPk(vo);
				if (null == vo) {
					item.setRegion(user.getCityid());
					dao.create(item);
				} else {
					BeanUtils.copyProperties(vo, item);
					dao.update(vo);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}
}
