/**
 * auto-generated code
 * Fri Oct 02 10:38:11 CST 2009
 */
package com.gmcc.pboss.business.resource.resdisform;

import com.sunrise.jop.infrastructure.db.AbstractDAO;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: ResdisformDAO</p>
 * <p>Description: Data Access Object for CompanyVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class ProductDetailDAO extends AbstractDAO {

    /**
     * default constructor
     */
    public ProductDetailDAO(){
        super(ProductDetailVO.class);
    }
    
    
    public DataPackage doQuery(ResdisformDBParam params) throws Exception{
    	return super.queryByNamedSqlQuery("com.gmcc.pboss.business.resource.resdisform.productdetail", params);
    }
    
}
