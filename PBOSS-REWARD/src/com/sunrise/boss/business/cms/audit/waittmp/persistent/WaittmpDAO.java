package com.sunrise.boss.business.cms.audit.waittmp.persistent;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sunrise.boss.business.admin.operator.persistent.OperatorDAO;
import com.sunrise.boss.business.admin.operator.persistent.OperatorVO;
import com.sunrise.boss.business.cms.audit.jhsmsrule.persistent.JhSmsRuleDAO;
import com.sunrise.boss.business.cms.audit.jhsmsrule.persistent.JhSmsRuleListVO;
import com.sunrise.boss.business.cms.audit.jhsmsrule.persistent.JhSmsRuleVO;
import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>
 * Title: WaittmpDAO
 * </p>
 * <p>
 * Description: Data Access Object for WaittmpVO
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author liminghao
 * @version 1.0
 */
public class WaittmpDAO extends BaseDAO {

	private final Log log = LogFactory.getLog(WaittmpDAO.class);

	/**
	 * default constructor
	 */
	public WaittmpDAO() {
		super(WaittmpVO.class);
	}

	/**
	 * 
	 * @param type
	 *            短信类型
	 * @param orgCode
	 *            原工号
	 * @param desCode
	 *            目标工号
	 * @param user
	 * @return 成功
	 * @throws Exception
	 */
	public boolean sendDx(int type, String orgCode, String desCode, User user)
			throws Exception {
		// 获取短信内容
		String content = getDxContent(type, user);
		if (StringUtils.isBlank(content)) {
			if (log.isInfoEnabled()) {
				log.info("短信内容为空");
			}
			return false;
		}
		// 根据目标工号查询操作员（sa_so_Operator）表查询出联系电话（contactPhone）字段
		OperatorDAO operatorDAO = (OperatorDAO) DAOFactory.build(
				OperatorDAO.class, user);
		OperatorVO operatorVO = (OperatorVO) operatorDAO.findByPk(desCode);
		if (operatorVO == null) {
			if (log.isInfoEnabled()) {
				log.info("根据目标工号在操作员（sa_so_Operator）表找不到联系电话");
			}
			return false;
		}
		try {
			String recno = operatorVO.getContactphone();
			if (StringUtils.isBlank(recno)) {
				if (log.isInfoEnabled()) {
					log.info("交接工号的联系电话号码为空");
				}
				return false;
			}
			if ( !recno.startsWith("1") || recno.length()!=11) {
				if (log.isInfoEnabled()) {
					log.info("交接工号的联系电话号码错误");
				}
				return false;
			}
			// 拆分短信内容
			List recnolist = split(content, 67);
			// 写短信表
			short i=1;
			for (Iterator iter = recnolist.iterator(); iter.hasNext();) {
				String mes = (String) iter.next();
				WaittmpVO waittmpVO = new WaittmpVO();
				waittmpVO.setSmtype(new Short((short) 101));
				java.sql.Timestamp now = new java.sql.Timestamp(System
						.currentTimeMillis());
				waittmpVO.setCreattime(now);
				waittmpVO.setDealtime(now);
				waittmpVO.setMessage(mes);
				waittmpVO.setSendno(null);
				waittmpVO.setRecno(recno);
				waittmpVO.setSmprior(new Short((short) 100));
				waittmpVO.setSmstatu(new Short((short) 0));
				waittmpVO.setLimitflag(new Short((short) 1));
				waittmpVO.setSndtime("0800-2200");
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(now);
				calendar.add(Calendar.DATE, 1);
				waittmpVO.setDeadtime(new java.sql.Timestamp(calendar
						.getTimeInMillis()));
				waittmpVO.setMaxtimes(new Short((short) 2));
				waittmpVO.setHavetimes(new Short((short) 0));
				waittmpVO.setPknumber(new Short(i++));
				waittmpVO.setPktotal(new Short((short)1 ));
				this.create(waittmpVO);
			}
		} catch (Exception ex) {
			log.error("发送短信失败:" + ex.getMessage());
			return false;
		}
		return true;
	}

	public boolean sendDx(String content, String orgCode, String desCode,
			User user) throws Exception {
		// 获取短信内容
		if (StringUtils.isBlank(content)) {
			return true;
		}
		// 根据目标工号查询操作员（sa_so_Operator）表查询出联系电话（contactPhone）字段
		OperatorDAO operatorDAO = (OperatorDAO) DAOFactory.build(
				OperatorDAO.class, user);
		if (StringUtils.isBlank(desCode)) {
			if (log.isInfoEnabled()) {
				log.info("交接工号为空");
			}
			return false;
		}
		OperatorVO operatorVO = (OperatorVO) operatorDAO.findByPk(desCode);
		if (operatorVO == null) {
			if (log.isInfoEnabled()) {
				log.info("根据目标工号在操作员（sa_so_Operator）表找不到联系电话");
			}
			return false;
		}
		String recno = operatorVO.getContactphone();
		if (StringUtils.isBlank(recno)) {
			if (log.isInfoEnabled()) {
				log.info("交接工号的联系电话号码为空");
			}
			return false;
		}
		if ( !recno.startsWith("1") || recno.length()!=11) {
			if (log.isInfoEnabled()) {
				log.info("交接工号的联系电话号码错误");
			}
			return false;
		}
		// 拆分短信内容
		List recnolist = split(content, 67);
		// 写短信表
		short i=1;
		for (Iterator iter = recnolist.iterator(); iter.hasNext();) {
			String mes = (String) iter.next();

			WaittmpVO waittmpVO = new WaittmpVO();
			waittmpVO.setSmtype(new Short((short) 101));
			java.sql.Timestamp now = new java.sql.Timestamp(System
					.currentTimeMillis());
			waittmpVO.setCreattime(now);
			waittmpVO.setDealtime(now);
			waittmpVO.setMessage(mes);
			waittmpVO.setSendno(null);
			waittmpVO.setRecno(recno);
			waittmpVO.setSmprior(new Short((short) 100));
			waittmpVO.setSmstatu(new Short((short) 0));
			waittmpVO.setLimitflag(new Short((short) 1));
			waittmpVO.setSndtime("0800-2200");
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(now);
			calendar.add(Calendar.DATE, 1);
			waittmpVO.setDeadtime(new java.sql.Timestamp(calendar
					.getTimeInMillis()));
			waittmpVO.setMaxtimes(new Short((short) 2));
			waittmpVO.setHavetimes(new Short((short) 0));
			waittmpVO.setPknumber(new Short(i++));
			waittmpVO.setPktotal(new Short((short)1 ));
			this.create(waittmpVO);
		}
		return true;
	}

	/**
	 * 短信内容总长度是否超过len个字符,超过拆分
	 */
	private List split(String recno, int length) {
		List list = new ArrayList();
		if (recno.length() < length) {
			list.add(recno);
			return list;
		}
		int beginIndex = 0;
		while (beginIndex + length < recno.length()) {
			list.add(recno.substring(beginIndex, beginIndex + length));
			beginIndex = beginIndex + length;
		}
		if (beginIndex < recno.length()) {
			list.add(recno.substring(beginIndex));
		}
		return list;
	}

	/**
	 * 获取短信内容
	 * 
	 * @throws Exception
	 */
	public String getDxContent(int type, User user) throws Exception {
		// String content = "";
		// StringBuffer sbhql = new StringBuffer();
		// String vOName=JhSmsRuleVO.class.getName();
		// sbhql.append("select SMSCONTENT from "+vOName+" where "+
		// "pri='(select max(pri) from "+vOName+" where valid=1 and
		// type="+type+")'");
		// Session session = SessionUtil.currentSession(getDbFlag());
		// List list = new ArrayList();
		// Query query = session.createQuery(sbhql.toString());
		// list = query.list();
		// if(list.isEmpty()){
		// return null;
		// }else{
		// return list.get(0)+"";
		// }
		JhSmsRuleListVO jhSmsRuleListVO = new JhSmsRuleListVO();
		jhSmsRuleListVO.set_se_type(type + "");
		jhSmsRuleListVO.set_se_valid("0"); // 有效
		// 最大优先级
		jhSmsRuleListVO.set_orderby("pri");
		jhSmsRuleListVO.set_desc("1");
		jhSmsRuleListVO.set_pageno("1");
		jhSmsRuleListVO.set_pagesize("1");

		JhSmsRuleDAO dao = (JhSmsRuleDAO) DAOFactory.build(JhSmsRuleDAO.class,
				user);
		ArrayList list = (ArrayList) dao.query(jhSmsRuleListVO).getDatas();
		if (list.isEmpty()) {
			return null;
		} else {
			return ((JhSmsRuleVO) list.get(0)).getSmscontent();
		}
	}
}
