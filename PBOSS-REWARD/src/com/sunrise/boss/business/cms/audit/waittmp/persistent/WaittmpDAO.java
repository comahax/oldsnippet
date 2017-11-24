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
	 *            ��������
	 * @param orgCode
	 *            ԭ����
	 * @param desCode
	 *            Ŀ�깤��
	 * @param user
	 * @return �ɹ�
	 * @throws Exception
	 */
	public boolean sendDx(int type, String orgCode, String desCode, User user)
			throws Exception {
		// ��ȡ��������
		String content = getDxContent(type, user);
		if (StringUtils.isBlank(content)) {
			if (log.isInfoEnabled()) {
				log.info("��������Ϊ��");
			}
			return false;
		}
		// ����Ŀ�깤�Ų�ѯ����Ա��sa_so_Operator�����ѯ����ϵ�绰��contactPhone���ֶ�
		OperatorDAO operatorDAO = (OperatorDAO) DAOFactory.build(
				OperatorDAO.class, user);
		OperatorVO operatorVO = (OperatorVO) operatorDAO.findByPk(desCode);
		if (operatorVO == null) {
			if (log.isInfoEnabled()) {
				log.info("����Ŀ�깤���ڲ���Ա��sa_so_Operator�����Ҳ�����ϵ�绰");
			}
			return false;
		}
		try {
			String recno = operatorVO.getContactphone();
			if (StringUtils.isBlank(recno)) {
				if (log.isInfoEnabled()) {
					log.info("���ӹ��ŵ���ϵ�绰����Ϊ��");
				}
				return false;
			}
			if ( !recno.startsWith("1") || recno.length()!=11) {
				if (log.isInfoEnabled()) {
					log.info("���ӹ��ŵ���ϵ�绰�������");
				}
				return false;
			}
			// ��ֶ�������
			List recnolist = split(content, 67);
			// д���ű�
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
			log.error("���Ͷ���ʧ��:" + ex.getMessage());
			return false;
		}
		return true;
	}

	public boolean sendDx(String content, String orgCode, String desCode,
			User user) throws Exception {
		// ��ȡ��������
		if (StringUtils.isBlank(content)) {
			return true;
		}
		// ����Ŀ�깤�Ų�ѯ����Ա��sa_so_Operator�����ѯ����ϵ�绰��contactPhone���ֶ�
		OperatorDAO operatorDAO = (OperatorDAO) DAOFactory.build(
				OperatorDAO.class, user);
		if (StringUtils.isBlank(desCode)) {
			if (log.isInfoEnabled()) {
				log.info("���ӹ���Ϊ��");
			}
			return false;
		}
		OperatorVO operatorVO = (OperatorVO) operatorDAO.findByPk(desCode);
		if (operatorVO == null) {
			if (log.isInfoEnabled()) {
				log.info("����Ŀ�깤���ڲ���Ա��sa_so_Operator�����Ҳ�����ϵ�绰");
			}
			return false;
		}
		String recno = operatorVO.getContactphone();
		if (StringUtils.isBlank(recno)) {
			if (log.isInfoEnabled()) {
				log.info("���ӹ��ŵ���ϵ�绰����Ϊ��");
			}
			return false;
		}
		if ( !recno.startsWith("1") || recno.length()!=11) {
			if (log.isInfoEnabled()) {
				log.info("���ӹ��ŵ���ϵ�绰�������");
			}
			return false;
		}
		// ��ֶ�������
		List recnolist = split(content, 67);
		// д���ű�
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
	 * ���������ܳ����Ƿ񳬹�len���ַ�,�������
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
	 * ��ȡ��������
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
		jhSmsRuleListVO.set_se_valid("0"); // ��Ч
		// ������ȼ�
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
