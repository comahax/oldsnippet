/**
 * auto-generated code
 * Fri Oct 23 15:56:45 CST 2009
 */
package com.gmcc.pboss.control.sales.actrepair;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import org.apache.log4j.Logger;

import com.gmcc.pboss.business.sales.actrepair.ActrepairDAO;
import com.gmcc.pboss.business.sales.actrepair.ActrepairDBParam;
import com.gmcc.pboss.business.sales.actrepair.ActrepairVO;
import com.gmcc.pboss.business.sales.noactinfo.NoactinfoDAO;
import com.gmcc.pboss.business.sales.noactinfo.NoactinfoDBParam;
import com.gmcc.pboss.business.sales.noactinfo.NoactinfoVO;
import com.gmcc.pboss.control.sales.noactinfo.Noactinfo;
import com.gmcc.pboss.control.sales.noactinfo.NoactinfoBO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>
 * Title: ActrepairBO
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
 * @author Jerimy
 * @version 1.0
 */
public class ActrepairBO extends AbstractControlBean implements Actrepair {

	/**
	 * 
	 * 
	 */
	private Logger log = Logger.getLogger(ActrepairBO.class);
	public ActrepairVO doCreate(ActrepairVO vo) throws Exception {
		try {
			ActrepairDAO dao = (ActrepairDAO) DAOFactory.build(
					ActrepairDAO.class, user);
			//
			vo.setOprcode(user.getOprcode());
			vo.setRepairtime(new java.util.Date());
			checkInfo(vo);
			return (ActrepairVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(ActrepairVO vo) throws Exception {
		try {
			ActrepairDAO dao = (ActrepairDAO) DAOFactory.build(
					ActrepairDAO.class, user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			ActrepairDAO dao = (ActrepairDAO) DAOFactory.build(
					ActrepairDAO.class, user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ActrepairVO doUpdate(ActrepairVO vo) throws Exception {
		try {
			ActrepairDAO dao = (ActrepairDAO) DAOFactory.build(
					ActrepairDAO.class, user);
			return (ActrepairVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ActrepairVO doFindByPk(Serializable pk) throws Exception {
		ActrepairDAO dao = (ActrepairDAO) DAOFactory.build(ActrepairDAO.class,
				user);
		return (ActrepairVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(ActrepairDBParam params) throws Exception {
		ActrepairDAO dao = (ActrepairDAO) DAOFactory.build(ActrepairDAO.class,
				user);
		return dao.query(params);
	}

	/**
	 * ���ݺ����ѯ���뼤���¼��FX_SN_NOACTINFO��������޼�¼���������ݣ�¼��ʱ��Ϊ��ǰʱ�䣬����ʱ��Ϊ����¼�뼤��ʱ��.��עΪǰ̨������¼��
	 * ������ֻ��һ����¼������¼�������Ϊ����¼�뼤�����ڣ�
	 * ����������һ����¼����¼��ʱ�併��ȡ��һ����¼��������¼������ݣ������¼�������Ϊ����¼�뼤�����ڡ�
	 * �ļ������������Ҫ���ɹ���ʧ����Ϣ��¼������ļ��У���ɺ��ṩ�������ӡ�����ļ���ʽΪ������|��������|��¼ԭ��|����ԭ��|
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public void checkInfo(ActrepairVO vo) throws Exception {
		NoactinfoDAO infoDAO = (NoactinfoDAO) DAOFactory.build(
				NoactinfoDAO.class, user);
		NoactinfoDBParam listVO = new NoactinfoDBParam();
		listVO.set_se_mobileno(vo.getMobileno());
		listVO.set_orderby("creattime");
		listVO.set_desc("1");
		DataPackage result = infoDAO.query(listVO);
		if (result.getRowCount() <= 0) {
			NoactinfoVO infoVO = new NoactinfoVO();
			infoVO.setActivedate(vo.getActivedate());
			infoVO.setMobileno(vo.getMobileno());
			infoVO.setCreattime(new Date());
			infoVO.setMemo("ǰ̨��¼");
			infoDAO.create(infoVO);
		} else {
			Collection col = result.getDatas();
			Iterator it = col.iterator();
			if (it.hasNext()) {
				NoactinfoVO infoVO = (NoactinfoVO) it.next();
				infoVO.setActivedate(vo.getActivedate());
				infoDAO.update(infoVO);
			}
		}
	}
	/**
	 * �Ե���ļ���������ʱ����
	 * @param mobile
	 * @param activedate
	 * @return
	 * @throws Exception
	 */
	
	public boolean doCheckDate(String mobile,Date activedate,String day) throws Exception{
		
		NoactinfoDBParam noactinfoWebParam = new NoactinfoDBParam();	
		noactinfoWebParam.set_se_mobileno(mobile);
		
		Noactinfo noactinfo = (Noactinfo) BOFactory.build(NoactinfoBO.class,
				user);
		DataPackage dp = noactinfo.doQuery(noactinfoWebParam);
		boolean bo = true;
		if (dp != null && dp.getDatas().size() > 0) {
			
			for (Iterator<NoactinfoVO> it = dp.getDatas().iterator(); it
					.hasNext();) {
				NoactinfoVO noactinf = it.next();
				if(noactinf.getActivedate() == null){
					return bo;
				}
				long lon = activedate.getTime()
						- noactinf.getActivedate().getTime();
				lon = Math.abs(lon);// ��ʱ�����о���ֵ��
				long days = lon / (1000 * 60 * 60 * 24);
				if (days <= Long.parseLong(day)) {
					bo = false;
				}
			}
		}
		if(!bo){
			log.info(mobile+"�ú���ļ����¼�Ѿ����ڣ����顣");
		}
		return bo;
	}
	
	
}
