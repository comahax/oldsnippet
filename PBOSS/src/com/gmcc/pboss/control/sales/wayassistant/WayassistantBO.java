/**
 * auto-generated code
 * Tue Oct 13 14:18:20 CST 2009
 */
package com.gmcc.pboss.control.sales.wayassistant;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.gmcc.pboss.business.channel.way.WayDAO;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.sales.wayassistant.WayassistantDBParam;
import com.gmcc.pboss.business.sales.wayassistant.WayassistantDAO;
import com.gmcc.pboss.business.sales.wayassistant.WayassistantVO;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

import com.gmcc.pboss.business.channel.way.WayDBParam;

/**
 * <p>
 * Title: WayassistantBO
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
 * @author Yedaoe
 * @version 1.0
 */
public class WayassistantBO extends AbstractControlBean implements Wayassistant {

	public WayassistantVO doCreate(WayassistantVO vo) throws Exception {
		try {
			WayassistantDAO dao = (WayassistantDAO) DAOFactory.build(
					WayassistantDAO.class, user);
			// TODO set the pk */
			return (WayassistantVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(WayassistantVO vo) throws Exception {
		try {
			WayassistantDAO dao = (WayassistantDAO) DAOFactory.build(
					WayassistantDAO.class, user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			WayassistantDAO dao = (WayassistantDAO) DAOFactory.build(
					WayassistantDAO.class, user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public WayassistantVO doUpdate(WayassistantVO vo) throws Exception {
		try {
			WayassistantDAO dao = (WayassistantDAO) DAOFactory.build(
					WayassistantDAO.class, user);
			return (WayassistantVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public WayassistantVO doFindByPk(Serializable pk) throws Exception {
		WayassistantDAO dao = (WayassistantDAO) DAOFactory.build(
				WayassistantDAO.class, user);
		return (WayassistantVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(WayassistantDBParam params) throws Exception {
		WayassistantDAO dao = (WayassistantDAO) DAOFactory.build(
				WayassistantDAO.class, user);
		DataPackage dp = dao.query(params);
		// 实现一个方法把dp中的list中的数据全部补充完属性
		this.fill(dp.getDatas());
		return dp;
	}
	

	public void fill(List dp) throws Exception {
		List list = dp;
		WayBO waybo = (WayBO) BOFactory.build(WayBO.class, user);
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				WayassistantVO wayassistantvo = (WayassistantVO) list.get(i);
				String wayid = wayassistantvo.getWayid();
				WayVO wayvo = waybo.doFindByPk(wayid);
				if (wayvo != null) {
					if (wayvo.getSvccode() != null) {
						wayassistantvo.setSvccode(wayvo.getSvccode());
					}
					if (wayvo.getCountyid() != null) {
						wayassistantvo.setCountyid(wayvo.getCountyid());
					}
					if (wayvo.getWaystate() != null) {
						wayassistantvo.setWaystate(wayvo.getWaystate());
					}
					if (wayvo.getMareacode() != null) {
						wayassistantvo.setMareacode(wayvo.getMareacode());
					}
					if(wayvo.getWayname()!=null){
						wayassistantvo.setWayname(wayvo.getWayname());
						
					}
				}

			}
		}
	}
	
	public DataPackage doQueryCanorder() throws Exception {
		WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		WayDBParam param = new WayDBParam();
		param.setSelectFieldsString("wayid,cityid,countyid,starlevel");
		param.set_pagesize("0");
		param.setDataOnly(true);
		DataPackage dp = dao.queryByNamedSqlQuery("com.gmcc.pboss.business.sales.wayassistant.WayassistantVO.doQueryCanorder",param);
		return dp;
	}
}
