/**
 * auto-generated code
 * Wed Apr 29 14:17:22 CST 2009
 */
package com.sunrise.boss.business.cms.bbc.bbcfaildataquery.control;

import java.io.Serializable;
import java.util.ArrayList;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import com.sunrise.boss.business.cms.nasway.persistent.NaswayDAO;
import com.sunrise.boss.business.cms.nasway.persistent.NaswayListVO;
import com.sunrise.boss.business.cms.nasway.persistent.NaswayVO;
import com.sunrise.boss.business.cms.way.persistent.WayDAO;
import com.sunrise.boss.business.cms.way.persistent.WayVO;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.bbcfaildataquery.persistent.BbcFaildataqueryVO;
import com.sunrise.boss.business.cms.bbc.bbcfaildataquery.persistent.BbcFaildataqueryDAO;
import com.sunrise.boss.business.cms.bbc.bbcfaildataquery.persistent.BbcFaildataqueryListVO;

/**
 * <p>Title: BbcFaildataqueryControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/bbc/bbcfaildataquery/control/BbcFaildataqueryControlBean"
 name="BbcFaildataqueryControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
 */
public class BbcFaildataqueryControlBean extends AbstractControlBean implements
		BbcFaildataqueryControl {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BbcFaildataqueryVO doCreate(BbcFaildataqueryVO vo, User user)
			throws Exception {
		try {
			BbcFaildataqueryDAO dao = (BbcFaildataqueryDAO) DAOFactory.build(
					BbcFaildataqueryDAO.class, user);
			// TODO  set the pk */
			return (BbcFaildataqueryVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemove(BbcFaildataqueryVO vo, User user) throws Exception {
		try {
			BbcFaildataqueryDAO dao = (BbcFaildataqueryDAO) DAOFactory.build(
					BbcFaildataqueryDAO.class, user);
			dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public BbcFaildataqueryVO doUpdate(BbcFaildataqueryVO vo, User user)
			throws Exception {
		try {
			BbcFaildataqueryDAO dao = (BbcFaildataqueryDAO) DAOFactory.build(
					BbcFaildataqueryDAO.class, user);
			return (BbcFaildataqueryVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public BbcFaildataqueryVO doFindByPk(Serializable pk, User user)
			throws Exception {
		BbcFaildataqueryDAO dao = (BbcFaildataqueryDAO) DAOFactory.build(
				BbcFaildataqueryDAO.class, user);
		return (BbcFaildataqueryVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(BbcFaildataqueryListVO params, User user)
			throws Exception {
		BbcFaildataqueryDAO dao = (BbcFaildataqueryDAO) DAOFactory.build(
				BbcFaildataqueryDAO.class, user);
		return dao.doQuery(params);
	}
	
	/**
	 * 批量导出时用的检索
	 */
	public DataPackage doQuery2(BbcFaildataqueryListVO params, User user)
			throws Exception {
		BbcFaildataqueryDAO dao = (BbcFaildataqueryDAO) DAOFactory.build(
				BbcFaildataqueryDAO.class, user);
		int rewardtype = Integer.parseInt(params.get_se_rewardtype());
		DataPackage dp = dao.doQuery(params);
		// 不为9的时候sql中已经翻译了
		if (rewardtype!=9) {
			return dp;
		}
		// 翻译渠道名称
		DataPackage result = new DataPackage();
		ArrayList relist = new ArrayList();
		ArrayList list = (ArrayList)dp.getDatas();
		WayDAO wdao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		NaswayDAO nwdao = (NaswayDAO) DAOFactory.build(NaswayDAO.class, user);
		if (list != null && !list.isEmpty()) {
			for (int i = 0; i < list.size(); i++) {
				BbcFaildataqueryVO vo = (BbcFaildataqueryVO)list.get(i);
				BbcFaildataqueryVO newvo = new BbcFaildataqueryVO();
				BeanUtils.copyProperties(newvo,vo);
				if (0 == newvo.getOssrc()) {
					if (!StringUtils.isBlank(newvo.getWayid())) {
						WayVO wvo = (WayVO)wdao.findByPk(newvo.getWayid());
						if (wvo == null) {
							newvo.setWayname(newvo.getWayid());
						} else {
							if (!StringUtils.isBlank(wvo.getWayname())) {
								newvo.setWayname(wvo.getWayname());
							} else {
								newvo.setWayname(newvo.getWayid());
							}
						}
					}
				} else {
					if (!StringUtils.isBlank(newvo.getWayid())) {
						NaswayListVO lvo = new NaswayListVO();
						lvo.set_se_wayid(newvo.getWayid());
						DataPackage dpn=nwdao.query(lvo,10);
						ArrayList listn = (ArrayList)dpn.getDatas();
						if (listn != null && !listn.isEmpty()) {
							NaswayVO nwvo = (NaswayVO)listn.get(0);
							if (!StringUtils.isBlank(nwvo.getWayname())) {
								newvo.setWayname(nwvo.getWayname());
							} else {
								newvo.setWayname(newvo.getWayid());
							}
						} else {
							newvo.setWayname(newvo.getWayid());
						}
					}
				}
				relist.add(newvo);
			}
		}
		result.setDatas(relist);
		return result;
	}
}
