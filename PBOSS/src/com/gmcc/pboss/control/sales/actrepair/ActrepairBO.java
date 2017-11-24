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
	 * 根据号码查询号码激活记录表（FX_SN_NOACTINFO），如果无记录则新增数据，录入时间为当前时间，激活时间为界面录入激活时间.备注为前台批量补录；
	 * 如果结果只有一条记录，则更新激活日期为界面录入激活日期；
	 * 如果结果大于一条记录，则按录入时间降序取第一条记录（即最晚录入的数据），更新激活日期为界面录入激活日期。
	 * 文件处理过程中需要将成功和失败信息记录到结果文件中，完成后提供下载链接。结果文件格式为：号码|激活日期|补录原因|出错原因|
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
			infoVO.setMemo("前台补录");
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
	 * 对导入的激活号码进行时间检查
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
				lon = Math.abs(lon);// 对时间差进行绝对值化
				long days = lon / (1000 * 60 * 60 * 24);
				if (days <= Long.parseLong(day)) {
					bo = false;
				}
			}
		}
		if(!bo){
			log.info(mobile+"该号码的激活记录已经存在，请检查。");
		}
		return bo;
	}
	
	
}
