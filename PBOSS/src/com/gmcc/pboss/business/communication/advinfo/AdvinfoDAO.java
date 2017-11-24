/**
 * auto-generated code
 * Tue Sep 29 10:11:13 CST 2009
 */
package com.gmcc.pboss.business.communication.advinfo;

import com.sunrise.jop.infrastructure.db.AbstractDAO;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>
 * Title: AdvinfoDAO
 * </p>
 * <p>
 * Description: Data Access Object for CompanyVO
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author
 * @version 1.0
 */
public class AdvinfoDAO extends AbstractDAO {

	/**
	 * default constructor
	 */
	public AdvinfoDAO() {
		super(AdvinfoVO.class);
	}

	/**
	 * 查找在线问答相关信息
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public DataPackage doQAOnlineQuery(AdvinfoDBParam params) throws Exception {
		
		params.setSelectFieldsString("advinfoid,title,releasetime,state,wayid,wayname,oprcode,waymagcode,opername");
//		params.setQueryAll(true);
		return queryByNamedSqlQuery("com.gmcc.pboss.business.communication.advinfo.queryQAOnline",params);
	}
	
	public DataPackage doPendTaskQuery(AdvinfoDBParam params, String oprcode) throws Exception {
		params.getQueryConditions().put("oprcode", oprcode);
		return queryByNamedSqlQuery("com.gmcc.pboss.business.communication.advinfo.queryPendingTask",params);
	}
}
