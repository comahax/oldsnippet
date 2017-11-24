package com.gmcc.pboss.control.sales.bgcontrol.saleactivestatistics;

import com.gmcc.pboss.business.sales.activedetail.ActivedetailDAO;
import com.gmcc.pboss.business.sales.comrescarddetail.ComrescarddetailDAO;
import com.gmcc.pboss.business.sales.comressdetail.ComressdetailDAO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;

public class SaleActiveStatisticsBO extends AbstractControlBean implements
		SaleActiveStatistics {

	public void doActiveProcess(String starttime, String endtime) throws Exception {
		ActivedetailDAO dao = (ActivedetailDAO) DAOFactory.build(ActivedetailDAO.class, user);
		dao.doUpdateActivedetail(starttime, endtime);
		
	}

	public void doComrescardProcess(String starttime, String endtime)
			throws Exception {
		ComrescarddetailDAO dao = (ComrescarddetailDAO) DAOFactory.build(ComrescarddetailDAO.class, user);
		dao.doUpdateComrescarddetail(starttime, endtime);
	}

	public void doComressProcess(String starttime, String endtime) throws Exception {
		ComressdetailDAO dao = (ComressdetailDAO) DAOFactory.build(ComressdetailDAO.class, user);
		dao.doUpdateComressdetail(starttime, endtime);
	}
	
	public void doDelComressProcess(String starttime, String endtime) throws Exception {
		ComressdetailDAO dao = (ComressdetailDAO) DAOFactory.build(ComressdetailDAO.class, user);
		dao.doDelComressdetail(starttime, endtime);
	}
	
	public void doDelActiveProcess(String starttime, String endtime) throws Exception {
		ActivedetailDAO dao = (ActivedetailDAO) DAOFactory.build(ActivedetailDAO.class, user);
		dao.doDelActivedetail(starttime, endtime);
		
	}
	public void doDelComrescardProcess(String starttime, String endtime) throws Exception {
		ComrescarddetailDAO dao = (ComrescarddetailDAO) DAOFactory.build(ComrescarddetailDAO.class, user);
		dao.doDelComrescarddetail(starttime, endtime);
	}

}
