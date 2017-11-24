package com.sunrise.boss.business.cms.bbc.mmopn.control;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.Session;

import com.sunrise.boss.business.cms.bbc.bbcreopnrange.persistent.BbcReopnrangeDAO;
import com.sunrise.boss.business.cms.bbc.bbcreopnrange.persistent.BbcReopnrangeListVO;
import com.sunrise.boss.business.cms.bbc.bbcreopnrange.persistent.BbcReopnrangeVO;
import com.sunrise.boss.business.cms.bbc.jfopnmap.persistent.JfopnmapDAO;
import com.sunrise.boss.business.cms.bbc.jfopnmap.persistent.JfopnmapListVO;
import com.sunrise.boss.business.cms.bbc.jfopnmap.persistent.JfopnmapVO;
import com.sunrise.boss.business.cms.bbc.mmopn.persistent.MmopnDAO;
import com.sunrise.boss.business.cms.bbc.mmopn.persistent.MmopnListVO;
import com.sunrise.boss.business.cms.bbc.mmopn.persistent.MmopnVO;
import com.sunrise.boss.business.cms.bbc.operation.persistent.BBCoperationDAO;
import com.sunrise.boss.business.cms.bbc.operation.persistent.BBCoperationVO;
import com.sunrise.boss.business.cms.bbc.stdreward.persistent.BBCstdrewardDAO;
import com.sunrise.boss.business.cms.bbc.stdreward.persistent.BBCstdrewardListVO;
import com.sunrise.boss.business.cms.bbc.stdreward.persistent.BBCstdrewardVO;
import com.sunrise.boss.business.cms.bbc.stdrewardbj.persistent.BBCstdrewardbjDAO;
import com.sunrise.boss.business.cms.bbc.stdrewardbj.persistent.BBCstdrewardbjListVO;
import com.sunrise.boss.business.cms.bbc.stdrewardbj.persistent.BBCstdrewardbjVO;
import com.sunrise.boss.business.cms.reward.ruleonbusi.persistent.RuleonbusiDAO;
import com.sunrise.boss.business.cms.reward.ruleonbusi.persistent.RuleonbusiListVO;
import com.sunrise.boss.business.cms.reward.ruleonbusi.persistent.RuleonbusiVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionUtil;
import com.sunrise.boss.ui.commons.User;

/**
 * @ejb.bean local-jndi-name="com/sunrise/boss/business/cms/bbc/mmopn/control/MmopnControlBean"
 *           name="MmopnControl" view-type="local" type="Stateless"
 * 
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class MmopnControlBean extends AbstractControlBean implements
		MmopnControl {
	public static final long sDate = 1259596800000L;

	public static final long eDate = 4070880000000L;

	public static final String MM_RESERTYPE = "1";

	public static final String MUSIC_RESERTYPE = "2";

	private boolean isMusic = false;

	/**
	 * MM业务
	 */
	public MmopnVO doCreate(MmopnVO vo, User user) throws Exception {
		try {
			MmopnVO resulsVO = null;
			int i = 0;
			MmopnDAO dao = (MmopnDAO) DAOFactory.build(MmopnDAO.class, user);
			BbcReopnrangeDAO rangedao = (BbcReopnrangeDAO) DAOFactory.build(
					BbcReopnrangeDAO.class, user);
			BbcReopnrangeListVO listvo = new BbcReopnrangeListVO();
			DataPackage dp = rangedao.getRangeByOpnid(listvo, vo.getOpnid(),
					MM_RESERTYPE);
			if (dp.getRowCount() == 0) {
				String message = "";
				List mmrange = this.getMMusicrange(MM_RESERTYPE, user);
				if (mmrange.size() == 2) {
					throw new Exception("MM应用的业务编码必须在[" + mmrange.get(0) + "到"
							+ mmrange.get(1) + "]之间.");
				} else {
					while (i < mmrange.size()) {
						message = message + "[" + mmrange.get(i) + "到"
								+ mmrange.get(i + 1) + "]";
						i = i + 2;
					}
					throw new Exception("MM应用的业务编码必须在" + message + "之间.");
				}
			}
			if (vo.getState() != null && vo.getState().byteValue() == (byte) 1) {
				MmopnVO dbVO = (MmopnVO) dao.findByPk(vo.getOpnid());
				if (dbVO == null) {
					resulsVO = (MmopnVO) dao.create(vo);
				} else {
					Session session = SessionUtil.currentSession(dao
							.getDbFlag());
					// session.evict(oldVO);
					resulsVO = (MmopnVO) session.merge(vo);
					dao.registerLog("update", resulsVO, user);
					session.flush();
				}
				// 新增业务定义
				createOperation(vo, user);
				// 新增酬金标准,
				Long sequence = createStdreward(vo, user);
				// 新增酬金标准附表
				createOrReplaceStdrewardbj(vo, user, sequence);
				// 新增计费扣月租代码
				createOrReplaceJfopnmap(vo, user);
				// 插入业务规则与业务编码关联
				createRuleonbusi(vo, user);
			} else if (vo.getState() != null
					&& vo.getState().byteValue() == (byte) 0) {
				doRemove(vo, user);
				resulsVO = vo;
			}

			return resulsVO;
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	/**
	 * 音乐
	 * 
	 * @param vo
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public MmopnVO doCreatemusic(MmopnVO vo, User user) throws Exception {
		try {
			setMusic(true);
			MmopnVO resulsVO = null;
			int i = 0;
			MmopnDAO dao = (MmopnDAO) DAOFactory.build(MmopnDAO.class, user);
			BbcReopnrangeDAO rangedao = (BbcReopnrangeDAO) DAOFactory.build(
					BbcReopnrangeDAO.class, user);
			BbcReopnrangeListVO listvo = new BbcReopnrangeListVO();
			DataPackage dp = rangedao.getRangeByOpnid(listvo, vo.getOpnid(),
					MUSIC_RESERTYPE);
			if (dp.getRowCount() == 0) {
				String message = "";
				List musicrange = this.getMMusicrange(MUSIC_RESERTYPE, user);
				if (musicrange.size() == 2) {
					throw new Exception("无线音乐管理的业务编码必须在[" + musicrange.get(0)
							+ "到" + musicrange.get(1) + "]之间.");
				} else {
					while (i < musicrange.size()) {
						message = message + "[" + musicrange.get(i) + "到"
								+ musicrange.get(i + 1) + "]";
						i = i + 2;
					}
					throw new Exception("无线音乐管理的业务编码必须在" + message + "之间.");
				}
			}
			if (vo.getState() != null && vo.getState().byteValue() == (byte) 1) {
				MmopnVO dbVO = (MmopnVO) dao.findByPk(vo.getOpnid());
				if (dbVO == null) {
					resulsVO = (MmopnVO) dao.create(vo);
				} else {
					Session session = SessionUtil.currentSession(dao
							.getDbFlag());
					resulsVO = (MmopnVO) session.merge(vo);
					dao.registerLog("update", resulsVO, user);
					session.flush();
				}
				// 新增业务定义
				createOperation(vo, user);
				// 新增酬金标准,
				Long sequence = createStdreward(vo, user);
				// 新增酬金标准附表
				createOrReplaceStdrewardbj(vo, user, sequence);
				// 新增计费扣月租代码
				createOrReplaceJfopnmap(vo, user);
				// 插入业务规则与业务编码关联
				createRuleonbusi(vo, user);
			} else if (vo.getState() != null
					&& vo.getState().byteValue() == (byte) 0) {
				doRemove(vo, user);
				resulsVO = vo;
			}

			return resulsVO;
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	private void createOperation(MmopnVO vo, User user) throws Exception {
		BBCoperationDAO dao = (BBCoperationDAO) DAOFactory.build(
				BBCoperationDAO.class, user);
		BBCoperationVO copVO = (BBCoperationVO) dao.findByPk(vo.getOpnid());
		if (copVO == null) {
			copVO = new BBCoperationVO();
			copVO.setOpnid(vo.getOpnid());
			copVO.setName(vo.getName());
			copVO.setState(new Short("1"));
			copVO.setStartdate(new Date(sDate));
			copVO.setEnddate(new Date(eDate));
			copVO.setIsbusi(new Short("1"));
			if (isMusic()) {
				copVO.setBusibelong("DATABUSI_V2");
			} else {
				copVO.setBusibelong("DATABUSI2");
			}

			dao.create(copVO);
		} else {
			if (vo.getState().byteValue() == (byte) 1) {
				copVO.setState(new Short("1"));
				dao.update(copVO);
			}

		}
	}

	private Long createStdreward(MmopnVO vo, User user) throws Exception {
		Long sequence = null;
		BBCstdrewardDAO dao = (BBCstdrewardDAO) DAOFactory.build(
				BBCstdrewardDAO.class, user);
		BBCstdrewardListVO params = new BBCstdrewardListVO();
		params.set_sk_rewardname(vo.getOpnid());
		DataPackage dp = dao.query(params);
		if (dp.getRowCount() <= 0) {
			BBCstdrewardVO rewardVO = new BBCstdrewardVO();
			rewardVO.setRewardid(sequence);
			rewardVO.setRewardname(vo.getOpnid() + vo.getName() + "基本酬金");
			rewardVO.setRewardproj(new Short("1"));
			rewardVO.setRewardtype(new Short("9"));
			rewardVO.setStartdate(new Date(sDate));
			rewardVO.setStopdate(new Date(eDate));
			BBCstdrewardVO updateVO = (BBCstdrewardVO) dao.create(rewardVO);
			sequence = updateVO.getRewardid();
		}
		return sequence;

	}

	private void createOrReplaceStdrewardbj(MmopnVO vo, User user, Long sequence)
			throws Exception {
		BBCstdrewardbjDAO dao = (BBCstdrewardbjDAO) DAOFactory.build(
				BBCstdrewardbjDAO.class, user);
		BBCstdrewardbjListVO params = new BBCstdrewardbjListVO();
		params.set_se_opnid(vo.getOpnid());
		DataPackage dp = dao.query(params);
		BBCstdrewardbjVO rewardbjVO = new BBCstdrewardbjVO();
		rewardbjVO.setRegion("999");
		rewardbjVO.setOpnid(vo.getOpnid());
		if (isMusic()) {
			rewardbjVO.setAcctype(new Short("1"));
		} else {
			rewardbjVO.setAcctype(vo.getAcctype());
		}
		rewardbjVO.setRewardstd(vo.getRewardstd());
		rewardbjVO.setIntvmonth(new Integer("0"));
		if (isMusic()) {
			rewardbjVO.setRuleid("BBC_WMUSIC");
		} else {
			rewardbjVO.setRuleid("BBC56");
		}
		if (dp.getRowCount() > 0) {
			batchUpdate(dao, dp, rewardbjVO, user);
		} else {
			if (sequence != null) {
				rewardbjVO.setRewardid(sequence);
			} else {
				throw new Exception("数据错误,REWARDID值未取到");
			}
			batchCreate(dao, rewardbjVO, user);
		}

	}

	private void batchUpdate(BBCstdrewardbjDAO dao, DataPackage dp,
			BBCstdrewardbjVO vo, User user) throws Exception {
		Iterator it = dp.getDatas().iterator();
		while (it.hasNext()) {
			BBCstdrewardbjVO dbVO = (BBCstdrewardbjVO) it.next();
			dbVO.setAcctype(vo.getAcctype());
			dbVO.setRewardstd(vo.getRewardstd());
			dao.update(dbVO);
		}
	}

	private void batchCreate(BBCstdrewardbjDAO dao, BBCstdrewardbjVO vo,
			User user) throws Exception {
		Short ossrc[] = { new Short("0"), new Short("1"), new Short("3") };
		for (int i = 0; i < ossrc.length; i++) {
			BBCstdrewardbjVO bjVO = new BBCstdrewardbjVO();
			BeanUtils.copyProperties(bjVO, vo);
			bjVO.setOssrc(ossrc[i]);
			dao.create(bjVO);
		}
	}

	private void createOrReplaceJfopnmap(MmopnVO vo, User user)
			throws Exception {
		JfopnmapDAO jfDao = (JfopnmapDAO) DAOFactory.build(JfopnmapDAO.class,
				user);
		JfopnmapListVO listVO = new JfopnmapListVO();
		listVO.set_se_opnid(vo.getOpnid());
		DataPackage dp = jfDao.query(listVO);
		JfopnmapVO jfVO = null;
		if (dp.getRowCount() <= 0) {
			jfVO = new JfopnmapVO();
			jfVO.setEntid(vo.getEntid());
			jfVO.setBusiid(vo.getBusiid());
			jfVO.setOpnid(vo.getOpnid());
			// jfVO.setCityid("999");
			Object exists = jfDao.findByPk(jfVO);
			if (exists == null) {
				// jfVO.setOpnid(vo.getOpnid());
				jfVO.setCityid("999");
				jfDao.create(jfVO);
			} else {
				throw new Exception("相同的[企业代码]与[计费业务代码]与[业务代码]已经存在");
			}
		} else {
			jfVO = (JfopnmapVO) getVO(dp);
			// 修改不了主键.只能先删除再新增,新增前先检测
			if (jfVO != null) {
				jfDao.remove(jfVO);
				JfopnmapVO checkVO = new JfopnmapVO();
				checkVO.setEntid(vo.getEntid());
				checkVO.setBusiid(vo.getBusiid());
				Object exists = jfDao.findByPk(checkVO);
				if (exists == null) {
					checkVO.setCityid("999");
					checkVO.setOpnid(vo.getOpnid());
					jfDao.create(checkVO);
				} else {
					throw new Exception("相同的[企业代码]与[计费业务代码]已经存在");
				}
			}
		}

	}

	private void createRuleonbusi(MmopnVO vo, User user) throws Exception {
		RuleonbusiDAO ruleDao = (RuleonbusiDAO) DAOFactory.build(
				RuleonbusiDAO.class, user);
		RuleonbusiListVO params = new RuleonbusiListVO();
		params.set_se_opnid(vo.getOpnid());
		if (ruleDao.query(params).getRowCount() <= 0) {
			RuleonbusiVO ruleVO = new RuleonbusiVO();
			if (isMusic()) {
				ruleVO.setRuleid("BBC_WMUSIC");
			} else {
				ruleVO.setRuleid("BBC56");
			}
			ruleVO.setOpnid(vo.getOpnid());
			ruleDao.create(ruleVO);
		}
	}

	public void doRemove(MmopnVO vo, User user) throws Exception {
		try {
			MmopnDAO dao = (MmopnDAO) DAOFactory.build(MmopnDAO.class, user);
			vo.setState(new Byte("0"));
			dao.update(vo);
			removeOperation(vo, user);
			removeStdreward(vo, user);
			removeStdrewardbj(vo, user);
			removeJfopnmap(vo, user);
			removeRuleonbusi(vo, user);
			// dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	private void removeOperation(MmopnVO vo, User user) throws Exception {
		BBCoperationDAO operDao = (BBCoperationDAO) DAOFactory.build(
				BBCoperationDAO.class, user);
		BBCoperationVO operVO = (BBCoperationVO) operDao
				.findByPk(vo.getOpnid());
		if (operVO != null) {
			operVO.setState(new Short("0"));
			operDao.update(operVO);
		}
	}

	private void removeStdreward(MmopnVO vo, User user) throws Exception {
		BBCstdrewardDAO dao = (BBCstdrewardDAO) DAOFactory.build(
				BBCstdrewardDAO.class, user);
		BBCstdrewardListVO params = new BBCstdrewardListVO();
		params.set_sk_rewardname(vo.getOpnid());
		DataPackage dp = dao.query(params);
		if (dp.getRowCount() > 0) {
			for (Iterator it = dp.getDatas().iterator(); it.hasNext();) {
				BBCstdrewardVO rewardVO = (BBCstdrewardVO) it.next();
				if (rewardVO != null) {
					dao.remove(rewardVO);
				}
			}
		}
	}

	private void removeJfopnmap(MmopnVO vo, User user) throws Exception {
		JfopnmapDAO jfDao = (JfopnmapDAO) DAOFactory.build(JfopnmapDAO.class,
				user);
		JfopnmapListVO listVO = new JfopnmapListVO();
		listVO.set_se_opnid(vo.getOpnid());
		DataPackage dp = jfDao.query(listVO);
		if (dp.getRowCount() > 0) {
			for (Iterator it = dp.getDatas().iterator(); it.hasNext();) {
				JfopnmapVO jfVO = (JfopnmapVO) it.next();
				if (jfVO != null) {
					jfDao.remove(jfVO);
				}
			}
		}
	}

	private void removeRuleonbusi(MmopnVO vo, User user) throws Exception {
		RuleonbusiDAO ruleDao = (RuleonbusiDAO) DAOFactory.build(
				RuleonbusiDAO.class, user);
		RuleonbusiListVO listVO = new RuleonbusiListVO();
		listVO.set_se_opnid(vo.getOpnid());
		DataPackage dp = ruleDao.query(listVO);
		if (dp.getRowCount() > 0) {
			for (Iterator it = dp.getDatas().iterator(); it.hasNext();) {
				RuleonbusiVO ruleVO = (RuleonbusiVO) it.next();
				if (ruleVO != null) {
					ruleDao.remove(ruleVO);
				}
			}
		}
	}

	private void removeStdrewardbj(MmopnVO vo, User user) throws Exception {
		BBCstdrewardbjDAO dao = (BBCstdrewardbjDAO) DAOFactory.build(
				BBCstdrewardbjDAO.class, user);
		BBCstdrewardbjListVO params = new BBCstdrewardbjListVO();
		params.set_se_opnid(vo.getOpnid());
		DataPackage dp = dao.query(params);
		if (dp.getRowCount() > 0) {
			for (Iterator it = dp.getDatas().iterator(); it.hasNext();) {
				BBCstdrewardbjVO rewardVO = (BBCstdrewardbjVO) it.next();
				if (rewardVO != null) {
					dao.remove(rewardVO);
				}
			}
		}
	}

	public MmopnVO doUpdate(MmopnVO vo, User user) throws Exception {
		try {
			MmopnDAO dao = (MmopnDAO) DAOFactory.build(MmopnDAO.class, user);
			return (MmopnVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public MmopnVO doFindByPk(Serializable pk, User user) throws Exception {
		MmopnDAO dao = (MmopnDAO) DAOFactory.build(MmopnDAO.class, user);
		return (MmopnVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(MmopnListVO params, User user) throws Exception {
		MmopnDAO dao = (MmopnDAO) DAOFactory.build(MmopnDAO.class, user);
		return dao.query(params);
	}

	/**
	 * 测试代码
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		MmopnVO vo = new MmopnVO();
		vo.setOpnid("050109999");
		new MmopnControlBean().checkOpnid(vo);
		String startDate = "2009-12-01 00:00:00";
		String endDate = "2099-01-01 00:00:00";
		java.text.SimpleDateFormat sdf = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		Date sDate = sdf.parse(startDate);
		Date eDate = sdf.parse(endDate);
		long s = sDate.getTime();
		long e = eDate.getTime();
		System.out.println(sDate.getTime());
		System.out.println(eDate.getTime());
		System.out.println(new java.util.Date(s));
		System.out.println(new java.util.Date(e));
	}

	private void checkOpnid(MmopnVO vo) throws Exception {
		if (isMusic()) {
			if (vo.getOpnid() != null) {
				if (vo.getOpnid().trim().length() != 9) {
					throw new Exception("无线音乐的业务编码必须在050200001到050202000之间");
				} else if ("050200001".compareTo(vo.getOpnid()) > 0
						|| "050202000".compareTo(vo.getOpnid()) < 0) {
					throw new Exception("无线音乐的业务编码必须在050200001到050202000之间");
				}
			}
		} else {
			if (vo.getOpnid() != null) {
				if (vo.getOpnid().trim().length() != 9) {
					throw new Exception("MM应用的业务编码必须在050100001到050109999之间");
				} else if ("050100001".compareTo(vo.getOpnid()) > 0
						|| "050109999".compareTo(vo.getOpnid()) < 0) {
					throw new Exception("MM应用的业务编码必须在050100001到050109999之间");
				}
			}
		}
	}

	private Object getVO(DataPackage dp) throws Exception {
		if (dp.getRowCount() > 0) {
			Iterator it = dp.getDatas().iterator();
			if (it.hasNext()) {
				return it.next();
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	public boolean isMusic() {
		return isMusic;
	}

	public void setMusic(boolean isMusic) {
		this.isMusic = isMusic;
	}
	
	/**
	 * 查询CH_BBC_REOPNRANGE表中定义的范围, 1-MM业务, 2-无线音乐管理
	 * @param resertype
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public List getMMusicrange(String resertype, User user) throws Exception {
		try {
			List range = new ArrayList();
			BbcReopnrangeVO vo = null;
			BbcReopnrangeDAO rangedao = (BbcReopnrangeDAO) DAOFactory.build(
					BbcReopnrangeDAO.class, user);
			BbcReopnrangeListVO listvo = new BbcReopnrangeListVO();
			DataPackage dp = rangedao.getRangeByResertype(listvo, resertype);
			if (dp.getDatas().size() > 0) {
				for (Iterator iter = dp.getDatas().iterator(); iter.hasNext();) {
					vo = (BbcReopnrangeVO) iter.next();
					range.add(vo.getOpnbegin());
					range.add(vo.getOpnend());
				}
			}
			return range;
		} catch (Exception e) {
			sessionContext.setRollbackOnly();
			throw e;
		}

	}
}
