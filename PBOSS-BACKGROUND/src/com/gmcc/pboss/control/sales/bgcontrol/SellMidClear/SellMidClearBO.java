package com.gmcc.pboss.control.sales.bgcontrol.SellMidClear;

import java.util.Date;

import org.apache.log4j.Logger;

import com.gmcc.pboss.business.sales.bgbusiness.SellMidClear.SellMidClearDAO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;

public class SellMidClearBO extends AbstractControlBean implements SellMidClear {

	private static Logger logger = Logger.getLogger(SellMidClearBO.class);
	
	public void doProcess(Date overdueDate) throws Exception {
		
		SellMidClearDAO dao = (SellMidClearDAO)DAOFactory.build(SellMidClearDAO.class, user);
		int deleteRow = dao.deleteOverdueData(overdueDate);
		logger.info("删除了 "+ deleteRow + "条数据");
	}

}
