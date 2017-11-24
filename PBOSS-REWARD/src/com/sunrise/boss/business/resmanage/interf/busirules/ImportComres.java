package com.sunrise.boss.business.resmanage.interf.busirules;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.beanutils.PropertyUtils;

import com.sunrise.boss.business.resmanage.com.persistent.ComDAO;
import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.ui.commons.User;

public class ImportComres implements Serializable {

	/**
	 * 商品导入，将商品状态修改为抽取态
	 * 
	 * @param comresid
	 * @param comid
	 * @param user
	 * @throws Exception
	 */
//	public void doImportComres(String comresid, Long comid, User user)
//			throws Exception {
//		processComres(comresid, comid, ResConstant.COMSTATE_FETCH, user);
//	}

	/**
	 * 商品导入，将商品状态修改为可售态
	 * 
	 * @param comresid
	 * @param comid
	 * @param user
	 * @throws Exception
	 */
//	public void doUnImportComres(String comresid, Long comid, User user)
//			throws Exception {
//		processComres(comresid, comid, ResConstant.COMSTATE_ONSALE, user);
//	}

	/**
	 * 检查商品资源的渠道及状态是否符合导入操作要求
	 * 
	 * @param comresid
	 * @param comid
	 * @param wayid
	 * @param user
	 * @throws Exception
//	 */
//	public void doImportComresCheck(String comresid, Long comid, String wayid,
//			User user) throws Exception {
//		checkImportComres(comresid, comid, wayid, ResConstant.COMSTATE_ONSALE,
//				user);
//	}

	/**
	 * 检查商品资源的渠道及状态是否符合导入撤单操作要求
	 * 
	 * @param comresid
	 * @param comid
	 * @param wayid
	 * @param user
	 * @throws Exception
	 */
//	public void doUnImportComresCheck(String comresid, Long comid,
//			String wayid, User user) throws Exception {
//		checkImportComres(comresid, comid, wayid, ResConstant.COMSTATE_FETCH,
//				user);
//	}

	/**
	 * 处理商品，将其状态修改为指定状态
	 * 
	 * @param comresid
	 * @param comid
	 * @param oldState
	 * @param newState
	 * @param user
	 * @throws Exception
	 */
	protected void processComres(String comresid, Long comid, Long newState,
			User user) throws Exception {
//		CommonMethod cm = new CommonMethod();

//		Long comclass = cm.getComclass(comid, user);
		Object pk = null;
		BaseDAO dao = null;
		BaseDAO reqlogDAO = null;
		Object vo = null;
		Object reqlogVO = null;

//		if (ResConstant.COMCLASS_ECHONGZHI.equals(comclass)
//				|| ResConstant.COMCLASS_GUACARD.equals(comclass)) {
//			// 刮卡类及电子充值劵（充值卡）
//			pk = new ComrescardVO();
//			reqlogVO = new CzreqlogVO();
//			dao = DAOFactory.build(ComrescardDAO.class, user);
//			reqlogDAO = DAOFactory.build(CzreqlogDAO.class, user);
//
//		} else if (ResConstant.COMCLASS_MOBILEPHONE.equals(comclass)
//				|| ResConstant.COMCLASS_PHONEFITTINGS.equals(comclass)) {
//			// 手机类及手机配件
//			pk = new ComresphoneVO();
//			reqlogVO = new SjreqlogVO();
//			dao = DAOFactory.build(ComresphoneDAO.class, user);
//			reqlogDAO = DAOFactory.build(SjreqlogDAO.class, user);
//
//		} else if (ResConstant.COMCLASS_SMP.equals(comclass)) {
//			// 套卡类
//			pk = new ComressmpVO();
//			reqlogVO = new SmpreqlogVO();
//			dao = DAOFactory.build(ComressmpDAO.class, user);
//			reqlogDAO = DAOFactory.build(SmpreqlogDAO.class, user);
//
//		} else {
//			// 其他资源（商品扩展资源）
//			pk = new OthercomresVO();
//			reqlogVO = new OtherreqlogVO();
//			dao = DAOFactory.build(OthercomresDAO.class, user);
//			reqlogDAO = DAOFactory.build(OtherreqlogDAO.class, user);
//
//		}

		PropertyUtils.setProperty(pk, "comresid", comresid);
		PropertyUtils.setProperty(pk, "comid", comid);
		vo = dao.findByPk((Serializable) pk);
		if (vo == null) {
			throw new BusinessException("error", "该商品类别中不存在此商品标识及编号的商品");
		}
		createReqlog(reqlogVO, vo, reqlogDAO, newState, user);

	}

	/**
	 * 登记状态修改请求表
	 * 
	 * @param reqlog
	 * @param vo
	 * @param logDAO
	 * @param newState
	 * @param user
	 * @param writer
	 * @throws Exception
	 */
	private void createReqlog(Object reqlog, Object vo, BaseDAO reqlogDAO,
			Long newState, User user) throws Exception {
		String comresid = (String) PropertyUtils.getProperty(vo, "comresid");
		Long comid = (Long) PropertyUtils.getProperty(vo, "comid");
		Long comstate = (Long) PropertyUtils.getProperty(vo, "comstate");
		String wayid = (String) PropertyUtils.getProperty(vo, "wayid");
		String batchno = (String) PropertyUtils.getProperty(vo, "batchno");
		Long comsource = (Long) PropertyUtils.getProperty(vo, "comsource");

//		PropertyUtils.setProperty(reqlog, "begno", comresid);
//		PropertyUtils.setProperty(reqlog, "endno", comresid);
//		PropertyUtils.setProperty(reqlog, "restype", getComtype(comid, user));
//		PropertyUtils.setProperty(reqlog, "comid", comid);
//		PropertyUtils.setProperty(reqlog, "num", new Long(1));
//		PropertyUtils.setProperty(reqlog, "inwayid", wayid);
//		PropertyUtils.setProperty(reqlog, "outwayid", wayid);
//		PropertyUtils.setProperty(reqlog, "oldstate", comstate);
//		PropertyUtils.setProperty(reqlog, "newstate", newState);
//		PropertyUtils.setProperty(reqlog, "comsource", comsource);
//		PropertyUtils.setProperty(reqlog, "oprcode", user.getOpercode());
//		PropertyUtils.setProperty(reqlog, "creattime", new Date(System
//				.currentTimeMillis()));
//		PropertyUtils.setProperty(reqlog, "batchno", batchno);
//		PropertyUtils.setProperty(reqlog, "resoprtype",
//				ResConstant.RESOPRTYPE_STATECHANGE);
//		PropertyUtils.setProperty(reqlog, "success", new Long(1));

		reqlogDAO.create(reqlog);

	}

	/**
	 * 根据商品标识取得商品类型
	 * 
	 * @param comid
	 * @param user
	 * @return 商品类型
	 * @throws Exception
	 */
	private Long getComtype(Long comid, User user) throws Exception {
		ComDAO dao = (ComDAO) DAOFactory.build(ComDAO.class, user.getCityid());
		return dao.getComtype(comid);
	}

	/**
	 * 检查商品资源的渠道及状态是否符合操作要求
	 * 
	 * @param comresid
	 * @param comid
	 * @param wayid
	 * @param state
	 * @param user
	 * @throws Exception
	 */
	protected void checkImportComres(String comresid, Long comid, String wayid,
			Long state, User user) throws Exception {
//		CommonMethod cm = new CommonMethod();

//		Long comclass = cm.getComclass(comid, user);
		Object pk = null;
		BaseDAO dao = null;

//		if (ResConstant.COMCLASS_ECHONGZHI.equals(comclass)
//				|| ResConstant.COMCLASS_GUACARD.equals(comclass)) {
//			// 刮卡类及电子充值劵（充值卡）
//			pk = new ComrescardVO();
//			dao = DAOFactory.build(ComrescardDAO.class, user);
//
//		} else if (ResConstant.COMCLASS_MOBILEPHONE.equals(comclass)
//				|| ResConstant.COMCLASS_PHONEFITTINGS.equals(comclass)) {
//			// 手机类及手机配件
//			pk = new ComresphoneVO();
//			dao = DAOFactory.build(ComresphoneDAO.class, user);
//
//		} else if (ResConstant.COMCLASS_SMP.equals(comclass)) {
//			// 套卡类
//			pk = new ComressmpVO();
//			dao = DAOFactory.build(ComressmpDAO.class, user);
//
//		} else {
//			// 其他资源（商品扩展资源）
//			pk = new OthercomresVO();
//			dao = DAOFactory.build(OthercomresDAO.class, user);
//
//		}

		PropertyUtils.setProperty(pk, "comresid", comresid);
		PropertyUtils.setProperty(pk, "comid", comid);
		Object vo = dao.findByPk((Serializable) pk);
		if (vo == null) {
			throw new BusinessException("error", "该商品类别中不存在此商品标识及编号的商品");
		}
		Long comstate = (Long) PropertyUtils.getProperty(vo, "comstate");
		String comwayid = (String) PropertyUtils.getProperty(vo, "wayid");
		if (!state.equals(comstate)) {
			throw new BusinessException("error", "该商品状态与本操作所要求状态不一致");
		}
		if (!wayid.equals(comwayid)) {
			throw new BusinessException("error", "该商品的渠道与该订单资源使用渠道不一致");
		}
	}
}
