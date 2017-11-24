/**
 * auto-generated code
 * Tue May 01 13:34:19 CST 2007
 */
package com.sunrise.boss.business.cms.operation.control;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.hibernate.Session;

import com.sunrise.boss.business.cms.operation.persistent.OperationDAO;
import com.sunrise.boss.business.cms.operation.persistent.OperationListVO;
import com.sunrise.boss.business.cms.operation.persistent.OperationVO;
import com.sunrise.boss.business.cms.reward.busiload.persistent.BusiloadDAO;
import com.sunrise.boss.business.cms.reward.busiload.persistent.BusiloadVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionUtil;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>
 * Title: OperationControlBean
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
 * @author
 * @version 1.0
 */
/**
 * @ejb.bean local-jndi-name="com/sunrise/boss/business/cms/operation/control/OperationControlBean"
 *           name="OperationControl" view-type="local" type="Stateless"
 * 
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class OperationControlBean extends AbstractControlBean implements
		OperationControl {

	public OperationVO doCreate(OperationVO vo, User user) throws Exception {
		try {
			// TODO set the pk */
			OperationDAO dao = (OperationDAO) DAOFactory.build(
					OperationDAO.class, user);
			if (StringUtils.isEmpty(vo.getParentid())) {
				vo.setParentid("0");
			}
			if (StringUtils.isEmpty(vo.getOpnid())) {
				vo.setOpnid(formatString(vo, user));
			}
			if (dao.findByPk(vo.getOpnid()) != null) {
				throw new BusinessException("", "有相同的记录存在!");
			}
			return (OperationVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemove(OperationVO vo, User user) throws Exception {
		try {
			OperationDAO dao = (OperationDAO) DAOFactory.build(
					OperationDAO.class, user);
			Iterator i = doQueryallsubopn(vo.getOpnid(), user).getDatas()
					.iterator();
			while (i.hasNext()) {
				OperationVO operationVO = (OperationVO) i.next();
				operationVO.setState(new Short((short) -1));
				dao.update(operationVO);
			}
			vo = (OperationVO) dao.findByPk(vo);
			vo.setState(new Short((short) -1));
			dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemovetree(OperationVO vo, User user) throws Exception {
		try {
			OperationDAO dao = (OperationDAO) DAOFactory.build(
					OperationDAO.class, user);
			Iterator i = doQueryallsubopn(vo.getOpnid(), user).getDatas()
					.iterator();
			if (i.hasNext()) {
				throw new BusinessException("",
						"当前业务分类下有业务细项或者有业务层次时,不允许删除该分类!");
			}
			vo = (OperationVO) dao.findByPk(vo.getOpnid());
			vo.setState(new Short((short) 0));
			vo.setEnddate(dao.getCurrentTime());
			dao.update(vo);
		} catch (Exception ex) {
			throw ex;
		}
	}

	public OperationVO doUpdatetree(OperationVO vo, User user) throws Exception {
		OperationDAO dao = (OperationDAO) DAOFactory.build(OperationDAO.class,
				user);
		return (OperationVO) dao.update(vo);
	}

	public OperationVO doUpdate(OperationVO vo, User user) throws Exception {
		try {
			OperationDAO dao = (OperationDAO) DAOFactory.build(
					OperationDAO.class, user);
			if (vo.getState().intValue() == 0) {
				Iterator i = doQueryallsubopn(vo.getOpnid(), user).getDatas()
						.iterator();
				while (i.hasNext()) {
					OperationVO operationVO = (OperationVO) i.next();
					operationVO.setState(new Short((short) 0));
					dao.update(operationVO);
				}
			}
			return (OperationVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public OperationVO doFindByPk(Serializable pk, User user) throws Exception {
		OperationDAO dao = (OperationDAO) DAOFactory.build(OperationDAO.class,
				user);
		return (OperationVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(OperationListVO params, User user)
			throws Exception {
		OperationDAO dao = (OperationDAO) DAOFactory.build(OperationDAO.class,
				user);
		// 不显示已删除的业务类型
		// params.set_nne_state("-1");
		// if(params.get_orderby() == null || "".equals(params.get_orderby())){
		// params.set_orderby("opnid");
		// }
		return dao.query(params);
	}

	public DataPackage doQuerysubtype(String id, User user) throws Exception {
		OperationDAO dao = (OperationDAO) DAOFactory.build(OperationDAO.class,
				user);
		OperationListVO listVO = new OperationListVO();
		listVO.getQueryConditions().put("id", id);
		return dao.queryByNamedSqlQuery("cms.operation.querysubtype", listVO);
	}

	public DataPackage doQueryallsubopn(String id, User user) throws Exception {
		OperationDAO dao = (OperationDAO) DAOFactory.build(OperationDAO.class,
				user);
		OperationListVO listVO = new OperationListVO();
		listVO.getQueryConditions().put("id", id);
		return dao.queryByNamedSqlQuery("cms.operation.allsubopn", listVO);
	}

	/**
	 * 新增 by xy
	 * 
	 * @param rootid
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public DataPackage doQueryopnbyisbusi(String rootid, User user)
			throws Exception {
		OperationDAO dao = (OperationDAO) DAOFactory.build(OperationDAO.class,
				user);
		OperationListVO listVO = new OperationListVO();
		listVO.getQueryConditions().put("rootid", rootid);
		return dao.queryByNamedSqlQuery("cms.operation.opnbyisbusi", listVO);
	}

	public List doQuerybusiload(User user) throws Exception {
		OperationDAO dao = (OperationDAO) DAOFactory.build(OperationDAO.class,
				user);
		Session session = SessionUtil.currentSession(dao.getDbFlag());
		Query query = session.getNamedQuery("cms.operation.querybusiload");
		query.setString("cityid", user.getCityid());
		// OperationListVO listVO = new OperationListVO();
		// listVO.getQueryConditions().put("cityid", user.getCityid());
		// DataPackage
		// dataPackage=dao.queryByNamedSqlQuery("cms.operation.querybusiload",
		// listVO);
		List list = query.list();
		if (list.size() > 0) {
			return doQuerybusiinfo(list, user);
		}
		return null;
	}

	private List doQuerybusiinfo(List busilist, User user) throws Exception {
		OperationDAO dao = (OperationDAO) DAOFactory.build(OperationDAO.class,
				user);
		Session session = SessionUtil.currentSession(dao.getDbFlag());
		List resultlist = new ArrayList();
		Query query;
		for (Iterator it = busilist.iterator(); it.hasNext();) {
			String opnid = (String) it.next();
			query = session.getNamedQuery("cms.operation.querybusiupper");
			query.setString("opnid", opnid);
			List list = query.list();
			String[] temp = new String[list.size()];
			int index = 0;
			for (Iterator iterator = list.iterator(); iterator.hasNext();) {
				Object[] objects = (Object[]) iterator.next();
				// opnid|name
				StringBuffer buffer = new StringBuffer((String) objects[0]);
				temp[index] = buffer.toString();
				index++;
			}
			resultlist.add(temp);
		}
		return resultlist;
	}

	/**
	 * 查询所有业务类型中第五级的个数
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int getFifthlevelcount(User user) throws Exception {
		OperationDAO dao = (OperationDAO) DAOFactory.build(OperationDAO.class,
				user);
		OperationListVO listVO = new OperationListVO();
		return dao.queryByNamedSqlQuery("cms.operation.fifthlevel", listVO, 10)
				.getRowCount();
	}

	/**
	 * 查询某个业务类型的子类型个数
	 * 
	 * @param vo
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int getSubcount(OperationVO vo, User user) throws Exception {
		OperationDAO dao = (OperationDAO) DAOFactory.build(OperationDAO.class,
				user);
		OperationListVO listVO = new OperationListVO();
		listVO.set_se_parentid(vo.getParentid());
		return dao.query(listVO, 10).getRowCount();
	}

	/**
	 * 某个业务类型的级别
	 * 
	 * @param vo
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int getParentlevel(OperationVO vo, User user) throws Exception {
		OperationDAO dao = (OperationDAO) DAOFactory.build(OperationDAO.class,
				user);
		OperationListVO listVO = new OperationListVO();
		listVO.getQueryConditions().put("upperid", vo.getParentid());
		return dao
				.queryByNamedSqlQuery("cms.operation.parentlevel", listVO, 10)
				.getRowCount();
	}

	/**
	 * 补零
	 * 
	 * @param str
	 * @param length
	 * @return
	 */
	public String formatString(OperationVO vo, User user) throws Exception {
		String str = "";
		int level = getParentlevel(vo, user);
		if (level == 4) {
			str = getFifthStr(user);

		} else {
			str = (getSubcount(vo, user) + 1) + "";
			for (int i = str.length(); i < 2; i++) {
				str = "0" + str;
			}
		}
		str = vo.getParentid().substring(0, level * 2) + str;
		for (int j = str.length(); j < 13; j++) {
			str = str + "0";
		}
		str = this.checkOpnid(str, user);

		return str;
	}

	// 检查生成的业务编码在已有的业务编码中是否已经存在了

	private String checkOpnid(String opnid, User user) throws Exception {

		OperationDAO dao = (OperationDAO) DAOFactory.build(OperationDAO.class,
				user);
		OperationListVO operationlistvo = new OperationListVO();
		operationlistvo.set_se_opnid(opnid);
		DataPackage dp = dao.query(operationlistvo);
		if (dp != null && dp.getDatas() != null && dp.getDatas().size() != 0) {
			opnid = (Long.parseLong(opnid) + 1) + "";
			if (opnid.length() != 13) {
				opnid = "0" + opnid;
			}
			this.checkOpnid(opnid, user);
		}
		return opnid;
	}

	public String getFifthStr(User user) throws Exception {
		OperationDAO dao = (OperationDAO) DAOFactory.build(OperationDAO.class,
				user);
		return dao.getFifthStr();
	}

	public List doQueryupper(OperationListVO params, User user)
			throws Exception {
		OperationDAO dao = (OperationDAO) DAOFactory.build(OperationDAO.class,
				user);
		return dao.doQueryupper(params);
	}

	/**
	 * 补充级别
	 * 
	 * @param vo
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public OperationVO getFilllevel(OperationVO vo, User user) throws Exception {
		OperationDAO dao = (OperationDAO) DAOFactory.build(OperationDAO.class,
				user);
		int level = getParentlevel(vo, user);
		DateFormat dftree = new SimpleDateFormat("yyyy-MM-dd");
		Date enddate = dftree.parse("2099-12-31 23:59:59");
		Date startdate = dftree.parse("1990-01-01  00:00:00");
		if (level < 4) {
			switch (level) {
			case 1:
				OperationVO opnvo2 = new OperationVO();
				opnvo2.setOpnid(formatString(vo, user));
				opnvo2.setParentid(vo.getParentid());
				opnvo2.setName(vo.getName());
				opnvo2.setOpnlevel(new Short((short) 2));
				opnvo2.setIsbusi(new Short((short) 0));
				opnvo2.setState(new Short((short) 1));
				opnvo2.setStartdate(startdate);
				opnvo2.setEnddate(enddate);

				dao.create(opnvo2);

				OperationVO opnvo3 = new OperationVO();
				opnvo3.setParentid(opnvo2.getOpnid());
				opnvo3
						.setOpnid(opnvo2.getOpnid().substring(0, 4)
								+ "010000000");
				opnvo3.setOpnlevel(new Short((short) 3));
				opnvo3.setName(vo.getName());
				opnvo3.setIsbusi(new Short((short) 0));
				opnvo3.setState(new Short((short) 1));
				opnvo3.setStartdate(startdate);
				opnvo3.setEnddate(enddate);

				dao.create(opnvo3);

				OperationVO opnvo4 = new OperationVO();
				opnvo4.setParentid(opnvo3.getOpnid());
				opnvo4.setOpnid(opnvo3.getOpnid().substring(0, 6) + "0100000");
				opnvo4.setOpnlevel(new Short((short) 4));
				opnvo4.setName(vo.getName());
				opnvo4.setIsbusi(new Short((short) 0));
				opnvo4.setState(new Short((short) 1));
				opnvo4.setStartdate(startdate);
				opnvo4.setEnddate(enddate);

				dao.create(opnvo4);

				vo.setOpnid(opnvo4.getOpnid().substring(0, 8)
						+ getFifthStr(user));
				vo.setParentid(opnvo4.getOpnid());
				break;
			case 2:
				OperationVO opnvo23 = new OperationVO();
				opnvo23.setOpnid(formatString(vo, user));
				opnvo23.setParentid(vo.getParentid());
				opnvo23.setName(vo.getName());
				opnvo23.setOpnlevel(new Short((short) 3));
				opnvo23.setIsbusi(new Short((short) 0));
				opnvo23.setState(new Short((short) 1));
				opnvo23.setStartdate(startdate);
				opnvo23.setEnddate(enddate);

				dao.create(opnvo23);

				OperationVO opnvo24 = new OperationVO();
				opnvo24.setParentid(opnvo23.getOpnid());
				opnvo24
						.setOpnid(opnvo23.getOpnid().substring(0, 6)
								+ "0100000");
				opnvo24.setOpnlevel(new Short((short) 4));
				opnvo24.setName(vo.getName());
				opnvo24.setIsbusi(new Short((short) 0));
				opnvo24.setState(new Short((short) 1));
				opnvo24.setStartdate(startdate);
				opnvo24.setEnddate(enddate);

				dao.create(opnvo24);

				vo.setOpnid(opnvo24.getOpnid().substring(0, 8)
						+ getFifthStr(user));
				vo.setParentid(opnvo24.getOpnid());
				break;
			case 3:
				OperationVO opnvo34 = new OperationVO();
				opnvo34.setOpnid(formatString(vo, user));
				opnvo34.setParentid(vo.getParentid());
				opnvo34.setName(vo.getName());
				opnvo34.setOpnlevel(new Short((short) 4));
				opnvo34.setIsbusi(new Short((short) 0));
				opnvo34.setState(new Short((short) 1));
				opnvo34.setStartdate(startdate);
				opnvo34.setEnddate(enddate);

				dao.create(opnvo34);

				vo.setOpnid(opnvo34.getOpnid().substring(0, 8)
						+ getFifthStr(user));
				vo.setParentid(opnvo34.getOpnid());
				break;
			}
			vo.setOpnlevel(new Short((short) 5));
			vo.setIsbusi(new Short((short) 1));
			vo.setState(new Short((short) 1));
		} else {
			vo.setOpnid(formatString(vo, user));
			vo.setOpnlevel(new Short((short) 5));
			vo.setIsbusi(new Short((short) 1));
			vo.setState(new Short((short) 1));
		}
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		vo.setEnddate(df.parse(df.format(vo.getEnddate()) + " 23:59:59"));
		vo.setStartdate(df.parse(df.format(vo.getStartdate()) + " 00:00:00"));
		return vo;
	}

	public OperationVO doCreateload(String[] exesys, String[] region,
			String[] starlevel, OperationVO vo, User user) throws Exception {
		try {
			// TODO set the pk */
			OperationDAO dao = (OperationDAO) DAOFactory.build(
					OperationDAO.class, user);
			BusiloadDAO loaddao = (BusiloadDAO) DAOFactory.build(
					BusiloadDAO.class, user);
			if (StringUtils.isEmpty(vo.getParentid())) {
				vo.setParentid("0");
			}
			String parentid = vo.getParentid();
			vo = getFilllevel(vo, user);
			if (dao.findByPk(vo.getOpnid()) != null) {
				throw new BusinessException("", "有相同的记录存在!");
			}
			if (exesys != null) {
				for (int i = 0; i < exesys.length; i++) {
					BusiloadVO loadvo = new BusiloadVO();
					loadvo.setOpnid(vo.getOpnid());
					loadvo.setLoadtype("EXESYS");
					loadvo.setLoadinfo(exesys[i]);
					loaddao.create(loadvo);
				}
			}
			if (region != null) {
				for (int i = 0; i < region.length; i++) {
					BusiloadVO loadvo = new BusiloadVO();
					loadvo.setOpnid(vo.getOpnid());
					loadvo.setLoadtype("CITY");
					loadvo.setLoadinfo(region[i]);
					loaddao.create(loadvo);
				}
			}
			if (starlevel != null) {
				for (int i = 0; i < starlevel.length; i++) {
					BusiloadVO loadvo = new BusiloadVO();
					loadvo.setOpnid(vo.getOpnid());
					loadvo.setLoadtype("STAR");
					loadvo.setLoadinfo(starlevel[i]);
					loaddao.create(loadvo);
				}
			}

			dao.create(vo);
			OperationVO revo = new OperationVO();
			BeanUtils.copyProperties(revo, vo);
			revo.setParentid(parentid);
			return revo;
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public OperationVO doUpdateload(ArrayList dellist, ArrayList addlist,
			OperationVO vo, User user) throws Exception {
		try {

			OperationDAO dao = (OperationDAO) DAOFactory.build(
					OperationDAO.class, user);
			BusiloadDAO loaddao = (BusiloadDAO) DAOFactory.build(
					BusiloadDAO.class, user);
			Iterator addit = addlist.iterator();
			while (addit.hasNext()) {
				loaddao.create((BusiloadVO) addit.next());
			}
			Iterator delit = dellist.iterator();
			while (delit.hasNext()) {
				loaddao.remove((BusiloadVO) delit.next());
			}

			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			vo.setEnddate(sdf.parse(df.format(vo.getEnddate()) + " 23:59:59"));
			vo.setStartdate(sdf.parse(df.format(vo.getStartdate())
					+ " 00:00:00"));
			return (OperationVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public DataPackage doQueryOperation(OperationListVO operationListVO,
			User user) throws Exception {
		OperationDAO dao = (OperationDAO) DAOFactory.build(OperationDAO.class,
				user);
		return dao.doQueryOperation(operationListVO);
	}

	public DataPackage doQueryallsubopn1(OperationListVO list, User user)
			throws Exception {
		OperationDAO dao = (OperationDAO) DAOFactory.build(OperationDAO.class,
				user);
		OperationListVO listVO = new OperationListVO();
		if (list.get_se_parentid() != null
				&& !list.get_se_parentid().equals("")) {
			listVO.set_se_parentid(list.get_se_parentid());
		}
		if (list.get_se_opnid() != null && !list.get_se_opnid().equals("")) {
			listVO.set_se_opnid(list.get_se_opnid());
		}
		if (list.get_sk_name() != null && !list.get_sk_name().equals("")) {
			listVO.set_sk_name(list.get_sk_name());
		}
		if (list.get_ne_opnlevel() != null
				&& !list.get_ne_opnlevel().equals("")) {
			listVO.set_ne_opnlevel(list.get_ne_opnlevel());
		}
		if(list.get_pageno() != null && !list.get_pageno().equals("")){
			listVO.set_pageno(list.get_pageno());
		}
		if(list.get_pagesize() != null && !list.get_pagesize().equals("")){
			listVO.set_pagesize(list.get_pagesize());
		}
		if(listVO.get_se_parentid()!=null && !listVO.get_se_parentid().equals("")){
			listVO.getQueryConditions().put("id", listVO.get_se_parentid());
			
		}
		
		listVO.set_se_parentid(null);
		return dao.queryByNamedSqlQuery("cms.operation.allsubopn", listVO);
	}

	public DataPackage doQueryallfifthopnids(OperationListVO list, User user)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
