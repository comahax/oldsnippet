/**
 * auto-generated code
 * Tue Apr 24 17:19:54 CST 2012
 */
package com.gmcc.pboss.control.sales.hisactivetol;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.gmcc.pboss.business.sales.hisactivetol.HisactivetolDAO;
import com.gmcc.pboss.business.sales.hisactivetol.HisactivetolDBParam;
import com.gmcc.pboss.business.sales.hisactivetol.HisactivetolVO;
import com.gmcc.pboss.business.sales.wayassistant.WayassistantDBParam;
import com.gmcc.pboss.business.sales.wayassistant.WayassistantVO;
import com.gmcc.pboss.control.sales.wayassistant.Wayassistant;
import com.gmcc.pboss.control.sales.wayassistant.WayassistantBO;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>
 * Title: HisactivetolBO
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
 * @author dengxingxin
 * @version 1.0
 */
public class HisactivetolBO extends AbstractControlBean implements Hisactivetol {
	private static Logger log = Logger.getLogger(HisactivetolBO.class);

	public HisactivetolVO doCreate(HisactivetolVO vo) throws Exception {
		try {
			HisactivetolDAO dao = (HisactivetolDAO) DAOFactory.build(
					HisactivetolDAO.class, user);
			// TODO set the pk */
			return (HisactivetolVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(HisactivetolVO vo) throws Exception {
		try {
			HisactivetolDAO dao = (HisactivetolDAO) DAOFactory.build(
					HisactivetolDAO.class, user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			HisactivetolDAO dao = (HisactivetolDAO) DAOFactory.build(
					HisactivetolDAO.class, user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public HisactivetolVO doUpdate(HisactivetolVO vo) throws Exception {
		try {
			HisactivetolDAO dao = (HisactivetolDAO) DAOFactory.build(
					HisactivetolDAO.class, user);
			return (HisactivetolVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public HisactivetolVO doFindByPk(Serializable pk) throws Exception {
		HisactivetolDAO dao = (HisactivetolDAO) DAOFactory.build(
				HisactivetolDAO.class, user);
		return (HisactivetolVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(HisactivetolDBParam params) throws Exception {
		HisactivetolDAO dao = (HisactivetolDAO) DAOFactory.build(
				HisactivetolDAO.class, user);
		return dao.query(params);
	}

	public void doProcess(DBAccessUser user) throws Exception {
		Wayassistant wayassistantBO = (WayassistantBO) BOFactory.build(
				WayassistantBO.class, user);

		WayassistantDBParam wayassistantDBParam = new WayassistantDBParam();
		wayassistantDBParam.set_pagesize("0");
		DataPackage wayassistantDP = wayassistantBO
				.doQuery(wayassistantDBParam);

		log.info("---------订购辅助信息--------统计数量-----"
				+ wayassistantDP.getRowCount());
		if (wayassistantDP.getRowCount() > 0) {
			java.util.Calendar c1 = java.util.Calendar.getInstance();
			c1.add(c1.MONTH, -1);
			// 前一个月
			String onetime = PublicUtils
					.formatUtilDate(c1.getTime(), "yyyy-MM")
					+ "-01 00:00:00";

			// 前三个月
			c1 = java.util.Calendar.getInstance();
			c1.add(c1.MONTH, -3);
			String threetime = PublicUtils.formatUtilDate(c1.getTime(),
					"yyyy-MM")
					+ "-01 00:00:00";

			// 前六个月
			c1 = java.util.Calendar.getInstance();
			c1.add(c1.MONTH, -6);
			String sixtime = PublicUtils
					.formatUtilDate(c1.getTime(), "yyyy-MM")
					+ "-01 00:00:00";

			// 当前月
			java.util.Calendar c2 = java.util.Calendar.getInstance();
			String endtime = PublicUtils
					.formatUtilDate(c2.getTime(), "yyyy-MM")
					+ "-01 00:00:00";

			for (int i = 0; i < wayassistantDP.getDatas().size(); i++) {
				WayassistantVO wayassistantVO = (WayassistantVO) wayassistantDP
						.getDatas().get(i);
				String wayid = wayassistantVO.getWayid();
				log.info(i + "-----处理----订购辅助信息-------wayid---开始---" + wayid);
				if (wayid != null && !"".equals(wayid)) {
					log.info("=========最近1个月==========处理=========");
					hisStat(onetime, endtime, wayid, 1);

					log.info("=========最近3个月==========处理=========");
					hisStat(threetime, endtime, wayid, 3);

					log.info("=========最近6个月==========处理=========");
					hisStat(sixtime, endtime, wayid, 6);
				}
				log.info(i + "-----处理----订购辅助信息-------wayid---结束---" + wayid);
			}
		}
	}

	private void hisStat(String begintime, String endtime, String wayid,
			int colunm) {
		try {
			Hisactivetol hisactivetolBO = (HisactivetolBO) BOFactory.build(
					HisactivetolBO.class, user);

			HisactivetolDAO hisactivetolDAO = (HisactivetolDAO) DAOFactory
					.build(HisactivetolDAO.class, user);
			HisactivetolDBParam hisactivetolDBParam = new HisactivetolDBParam();
			hisactivetolDBParam.setDataOnly(true);
			hisactivetolDBParam.setQueryAll(true);
			hisactivetolDBParam.setSelectFieldsString("acttime,brand,count");

			Map<String, String> queryConditions = new HashMap<String, String>();
			queryConditions.put("wayid", wayid);
			queryConditions.put("begintime", begintime);
			queryConditions.put("endtime", endtime);
			hisactivetolDBParam.setQueryConditions(queryConditions);

			DataPackage dp = hisactivetolDAO.queryByNamedSqlQuery(
					"hisactivetolStat", hisactivetolDBParam);
			if (null == dp || null == dp.getDatas() || dp.getDatas().size() < 1) {
				// 不处理
			} else {
				// 分品牌统计
				Map<String, Long> brandMap = new HashMap<String, Long>();// 同一个品牌，不同月份，累加
				for (int i = 0; i < dp.getDatas().size(); i++) {

					try {
						HashMap ooaVO = (HashMap) dp.getDatas().get(i);
						String acttime = (String) ooaVO.get("acttime");
						String brand = (String) ooaVO.get("brand");
						String count = (String) ooaVO.get("count");
						if (brandMap.containsKey(brand)) {// 存在、累加
							long co = brandMap.get(brand).longValue();
							if (count != null && !"".equals(count)) {
								co = co + Long.parseLong(count);
							}
							brandMap.remove(brand);
							brandMap.put(brand, co);
						} else {
							if (count != null && !"".equals(count)) {
								brandMap.put(brand, Long.parseLong(count));
							} else {
								brandMap.put(brand, 0L);
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
						log.error(wayid + "==============处理异常=========="
								+ e.getMessage());
					}
				}

				Iterator iter = brandMap.entrySet().iterator();
				while (iter.hasNext()) {

					try {
						Map.Entry entry = (Map.Entry) iter.next();
						String brand = (String) entry.getKey();
						Long count = (Long) entry.getValue();
						hisactivetolDBParam = new HisactivetolDBParam();
						hisactivetolDBParam.set_se_wayid(wayid);
						hisactivetolDBParam.set_se_brand(brand);
						DataPackage bDP = doQuery(hisactivetolDBParam);
						if (bDP.getRowCount() > 0) {// 更新
							HisactivetolVO hisactivetolVO = (HisactivetolVO) bDP
									.getDatas().get(0);
							if (1 == colunm) {
								hisactivetolVO.setHisactive01(count);
							} else if (3 == colunm) {
								hisactivetolVO.setHisactive03(count);
							} else if (6 == colunm) {
								hisactivetolVO.setHisactive06(count);
							}
							hisactivetolVO.setMemo(begintime + "--" + endtime);

							hisactivetolDAO.update(hisactivetolVO);
						} else {// 新增
							HisactivetolVO hisactivetolVO = new HisactivetolVO();
							hisactivetolVO.setWayid(wayid);
							hisactivetolVO.setBrand(brand);
							hisactivetolVO.setHisactive01(0L);
							hisactivetolVO.setHisactive03(0L);
							hisactivetolVO.setHisactive06(0L);

							if (1 == colunm) {
								hisactivetolVO.setHisactive01(count);
							} else if (3 == colunm) {
								hisactivetolVO.setHisactive03(count);
							} else if (6 == colunm) {
								hisactivetolVO.setHisactive06(count);
							}

							hisactivetolVO.setMemo(begintime + "--" + endtime);

							hisactivetolDAO.create(hisactivetolVO);
						}
					} catch (Exception e) {
						e.printStackTrace();
						log.error(wayid + "==============处理异常=========="
								+ e.getMessage());
					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error(wayid + "==============处理异常==========" + e.getMessage());
		}
	}

	public DataPackage doHisWayDetail(String begintime, String endtime,
			String wayid, String brand) throws Exception {
		DataPackage dp = null;
		Hisactivetol hisactivetolBO = (HisactivetolBO) BOFactory.build(
				HisactivetolBO.class, user);
		try {
			HisactivetolDAO hisactivetolDAO = (HisactivetolDAO) DAOFactory
					.build(HisactivetolDAO.class, user);
			HisactivetolDBParam hisactivetolDBParam = new HisactivetolDBParam();
			hisactivetolDBParam.setDataOnly(true);
			hisactivetolDBParam.setQueryAll(true);
			hisactivetolDBParam
					.setSelectFieldsString("wayid,brand,acttime,comresid");

			Map<String, String> queryConditions = new HashMap<String, String>();
			queryConditions.put("wayid", wayid);
			queryConditions.put("begintime", begintime);
			queryConditions.put("endtime", endtime);
			queryConditions.put("brand", brand);
			hisactivetolDBParam.setQueryConditions(queryConditions);
			dp = hisactivetolDAO.queryByNamedSqlQuery("hisactivetolStatDetail",
					hisactivetolDBParam);

			List list = new ArrayList();
			List listdp = dp.getDatas();
			for (int i = 0; i < listdp.size(); i++) {
				Map map = (Map) listdp.get(i);
				HisactivetolVO hisactivetolVO = new HisactivetolVO();
				hisactivetolVO.setActivetime(map.get("acttime") + "");
				hisactivetolVO.setBrand(map.get("brand") + "");
				hisactivetolVO.setComresid(map.get("comresid") + "");
				hisactivetolVO.setWayid(map.get("wayid") + "");
				list.add(hisactivetolVO);
			}
			dp.setDatas(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dp;
	}

}
