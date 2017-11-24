/**
 * auto-generated code
 * Mon Mar 23 12:58:46 CST 2015
 */
package com.gmcc.pboss.business.communication.chpwcomsadvinfo;

import com.sunrise.jop.infrastructure.db.AbstractDAO;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: ChPwComsadvinfoDAO</p>
 * <p>Description: Data Access Object for CompanyVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
public class ChPwComsadvinfoDAO extends AbstractDAO {

    /**
     * default constructor
     */
    public ChPwComsadvinfoDAO(){
        super(ChPwComsadvinfoVO.class);
    }

	public DataPackage doQueryOperatorByRoleId(String roleid) throws Exception {
		ChPwComsadvinfoDBParam params = new ChPwComsadvinfoDBParam();
		params.setSelectFieldsString("operid,opername,contactphone,region");
		params.getQueryConditions().put("roleid", roleid);
		return queryByNamedSqlQuery("com.gmcc.pboss.business.communication.chpwcomsadvinfo.QueryOperatorByRoleId", params);
	}

	public DataPackage doCityList(ChPwComsadvinfoDBParam params, String objid) throws Exception {
		params.setSelectFieldsString("advinfoid,title,releasetime,rcvobjtype,smsnotify,releasecode,rvcobjid,state");
		params.getQueryConditions().put("objid", objid);
		return queryByNamedSqlQuery("com.gmcc.pboss.business.communication.chpwcomsadvinfo.doCityList", params);
	}
}
