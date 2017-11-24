/**
 * auto-generated code
 * Fri Oct 02 10:44:18 CST 2009
 */
package com.gmcc.pboss.business.resource.discomres;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.sunrise.jop.common.utils.lang.SessionUtils;
import com.sunrise.jop.infrastructure.db.AbstractDAO;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: DiscomresDAO</p>
 * <p>Description: Data Access Object for CompanyVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class VDiscomresDAO extends AbstractDAO {

    /**
     * default constructor
     */
    public VDiscomresDAO(){
        super(VDiscomresVO.class);
    }
    public DataPackage doQueryDiscomresInfo(DiscomresDBParam param) throws Exception {
    	param.setSelectFieldsString("recid,disid,discomcode,batchno,boxnum,issutime,comid,comresid,comstate");
		return queryByNamedSqlQuery("com.gmcc.pboss.business.resource.discomres.queryDiscomresList", param);
    }
}
