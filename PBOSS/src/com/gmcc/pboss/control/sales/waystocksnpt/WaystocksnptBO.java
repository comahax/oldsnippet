/**
 * auto-generated code
 * Wed Sep 08 16:30:03 CST 2010
 */
package com.gmcc.pboss.control.sales.waystocksnpt;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.waystocksnpt.RWaystocksnptDAO;
import com.gmcc.pboss.business.sales.waystocksnpt.SWaystocksnptDAO;
import com.gmcc.pboss.business.sales.waystocksnpt.WaystocksnptDAO;
import com.gmcc.pboss.business.sales.waystocksnpt.WaystocksnptDBParam;
import com.gmcc.pboss.business.sales.waystocksnpt.WaystocksnptVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;


/**
 * <p>
 * Title: WaystocksnptBO
 * </p>;
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
 * @author LiZhaoLiang
 * @version 1.0
 */
public class WaystocksnptBO extends AbstractControlBean implements Waystocksnpt {

	public WaystocksnptVO doCreate(WaystocksnptVO vo) throws Exception {
		try {
			WaystocksnptDAO dao = (WaystocksnptDAO) DAOFactory.build(
					WaystocksnptDAO.class, user);
			// TODO set the pk */
			return (WaystocksnptVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(WaystocksnptVO vo) throws Exception {
		try {
			WaystocksnptDAO dao = (WaystocksnptDAO) DAOFactory.build(
					WaystocksnptDAO.class, user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			WaystocksnptDAO dao = (WaystocksnptDAO) DAOFactory.build(
					WaystocksnptDAO.class, user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public WaystocksnptVO doUpdate(WaystocksnptVO vo) throws Exception {
		try {
			WaystocksnptDAO dao = (WaystocksnptDAO) DAOFactory.build(
					WaystocksnptDAO.class, user);
			return (WaystocksnptVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public WaystocksnptVO doFindByPk(Serializable pk) throws Exception {
		WaystocksnptDAO dao = (WaystocksnptDAO) DAOFactory.build(
				WaystocksnptDAO.class, user);
		return (WaystocksnptVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(WaystocksnptDBParam params) throws Exception {
		WaystocksnptDAO dao = (WaystocksnptDAO) DAOFactory.build(
				WaystocksnptDAO.class, user);
		return dao.query(params);
	}

	public DataPackage doQuerySalesSmplist(WaystocksnptDBParam params)
			throws Exception {
		SWaystocksnptDAO dao = (SWaystocksnptDAO) DAOFactory.build(
				SWaystocksnptDAO.class, user);
		return dao.querySaleslistsmp(params);
	}

	public DataPackage doQuerySalesCardlist(WaystocksnptDBParam params)
			throws Exception {
		SWaystocksnptDAO dao = (SWaystocksnptDAO) DAOFactory.build(
				SWaystocksnptDAO.class, user);
		return dao.querySaleslistcard(params);
	}

	public DataPackage doQueryStockSmpRecord(WaystocksnptDBParam params)
			throws Exception {
		RWaystocksnptDAO dao = (RWaystocksnptDAO) DAOFactory.build(
				RWaystocksnptDAO.class, user);
		return dao.queryStockSmpRecord(params);
	}

	public DataPackage doQueryStockCardRecord(WaystocksnptDBParam params)
			throws Exception {
		RWaystocksnptDAO dao = (RWaystocksnptDAO) DAOFactory.build(
				RWaystocksnptDAO.class, user);
		return dao.queryStockCardRecord(params);
	}

	public DataPackage doQuerySalesSmpRecord(WaystocksnptDBParam params)
			throws Exception {
		RWaystocksnptDAO dao = (RWaystocksnptDAO) DAOFactory.build(
				RWaystocksnptDAO.class, user);
		DataPackage dp = dao.querySaleSmpRecord(params);
		return dp;
	}

	public DataPackage doQuerySalesCardRecord(WaystocksnptDBParam params)
			throws Exception {
		RWaystocksnptDAO dao = (RWaystocksnptDAO) DAOFactory.build(
				RWaystocksnptDAO.class, user);
		return dao.querySaleCardRecord(params);
	}

	public DataPackage doQueryActiveSmpList(WaystocksnptDBParam params)
			throws Exception {
		SWaystocksnptDAO dao = (SWaystocksnptDAO) DAOFactory.build(
				SWaystocksnptDAO.class, user);
		return dao.queryActivelistsmp(params);
	}
	
	public DataPackage doQueryActiveSmpList2(WaystocksnptDBParam params)
			throws Exception {
		SWaystocksnptDAO dao = (SWaystocksnptDAO) DAOFactory.build(
				SWaystocksnptDAO.class, user);
		return dao.queryActivelistsmp2(params);
	}

	public DataPackage doQueryActiveSmpRecord(WaystocksnptDBParam params)
			throws Exception {
		RWaystocksnptDAO dao = (RWaystocksnptDAO) DAOFactory.build(
				RWaystocksnptDAO.class, user);
		return dao.queryActiveSmpRecord(params);
	}

	/**
	 * 网点空白SIM卡销售量统计
	 */
	public DataPackage doQuerySaleStatistic(WaystocksnptDBParam params)
			throws Exception {
		SWaystocksnptDAO dao = (SWaystocksnptDAO) DAOFactory.build(
				SWaystocksnptDAO.class, user);
		return dao.querySaleStatistic(params);
	}

	/**
	 * 网点空白SIM卡销售量明细
	 */
	public DataPackage doQuerySaleRecord(WaystocksnptDBParam params)
			throws Exception {
		RWaystocksnptDAO dao = (RWaystocksnptDAO) DAOFactory.build(
				RWaystocksnptDAO.class, user);
		params.setSelectFieldsString("emptyno,stocktime,countyid,svccode,mareacode,orderid,wayid,wayname,starlevel,comcategory,upperwayid,waymagcode,acttime,iccid");
		params.setSelectFieldsUseVOType(true);
		return dao.querySaleRecord(params);
	}

	/**
	 * 网点空白SIM卡使用量统计
	 */
	public DataPackage doQueryUsedStatistic(WaystocksnptDBParam params)
			throws Exception {
		SWaystocksnptDAO dao = (SWaystocksnptDAO) DAOFactory.build(
				SWaystocksnptDAO.class, user);
		return dao.queryUsedStatistic(params);
	}

	/**
	 * 网点空白SIM卡使用量明细
	 */
	public DataPackage doQueryUsedRecord(WaystocksnptDBParam params)
			throws Exception {
		RWaystocksnptDAO dao = (RWaystocksnptDAO) DAOFactory.build(
				RWaystocksnptDAO.class, user);
		params.setSelectFieldsString("emptyno,changetime,countyid,svccode,mareacode,orderid,wayid,wayname,starlevel,comcategory,state,upperwayid");
		params.setSelectFieldsUseVOType(true);
		return dao.queryUsedRecord(params);
	}

	// 网点套卡激活统计批量导出
	public DataPackage doQueryActiveSmpListBatchExp(WaystocksnptDBParam params)
			throws Exception {
		SWaystocksnptDAO dao = (SWaystocksnptDAO) DAOFactory.build(
				SWaystocksnptDAO.class, user);
		return dao.queryActiveSmpListBatchExp(params);
	}

	// 网点充值卡销售量统计批量导出
	public DataPackage doQuerySalesCardlistBatchExp(WaystocksnptDBParam params)
			throws Exception {
		SWaystocksnptDAO dao = (SWaystocksnptDAO) DAOFactory.build(
				SWaystocksnptDAO.class, user);
		return dao.querySalesCardlistBatchExp(params);
	}

	// 网点套卡销售量统计批量导出
	public DataPackage doQuerySalesSmplistBatchExp(WaystocksnptDBParam params)
			throws Exception {
		SWaystocksnptDAO dao = (SWaystocksnptDAO) DAOFactory.build(
				SWaystocksnptDAO.class, user);
		return dao.querySalesSmplistBatchExp(params);
	}
}
