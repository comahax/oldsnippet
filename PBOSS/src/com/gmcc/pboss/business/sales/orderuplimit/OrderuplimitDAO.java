/**
 * auto-generated code
 * Tue Oct 13 14:30:52 CST 2009
 */
package com.gmcc.pboss.business.sales.orderuplimit;

import java.util.List;
import com.sunrise.jop.infrastructure.db.AbstractDAO;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: OrderuplimitDAO</p>
 * <p>Description: Data Access Object for CompanyVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
public class OrderuplimitDAO extends AbstractDAO {

    /**
     * default constructor
     */
    public OrderuplimitDAO(){
        super(OrderuplimitVO.class);
    }
    
    public List doQueryEmptysimtype(OrderuplimitDBParam params) throws Exception {
    	List list = null;
    	params.setSelectFieldsString("comcategory,dictname");
    	DataPackage dPackage = queryByNamedSqlQuery("pboss.sales.emptysimtype", params);
    	 list = dPackage.getDatas();
    	return list; 
 }
}
