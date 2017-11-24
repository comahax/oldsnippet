package com.gmcc.pboss.control.resource.wayrcstat;

import com.gmcc.pboss.business.resource.wayrcstat.WayrcstatDAO;
import com.gmcc.pboss.business.resource.wayrcstat.WayrcstatVO;
import com.gmcc.pboss.business.resource.wayrcstat.WayrcstatVO2;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DBQueryParam;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class WayrcstatBO extends AbstractControlBean implements Wayrcstat {

	// 网点资源信息统计 实时
	public DataPackage doQueryreal(DBQueryParam param) throws Exception {
		WayrcstatDAO dao = (WayrcstatDAO) DAOFactory.build(WayrcstatDAO.class, WayrcstatVO.class, user);
//		param.getQueryConditions().put("cityid_0", user.getCityid());
//		param.getQueryConditions().put("cityid_1", user.getCityid());
//		param.getQueryConditions().put("cityid_2", user.getCityid());
//		param.getQueryConditions().put("cityid_3", user.getCityid());
		return dao.queryReal(param);
	}
	
	// 网点资源信息统计 历史
	public DataPackage doQueryhistory(DBQueryParam param) throws Exception {
		WayrcstatDAO dao = (WayrcstatDAO) DAOFactory.build(WayrcstatDAO.class, WayrcstatVO2.class, user);
//		param.getQueryConditions().put("cityid", user.getCityid());
		return dao.queryHistory(param);
	}
}
