/**
 * auto-generated code
 * 2006.08.08
 */
package com.sunrise.boss.business.fee.integral.custinte.persistent;

import org.hibernate.HibernateException;

import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.DataPackage;

/**
 * 
 * Title: VCutsInteDAO Description: Data Access Object for VCutsInteVO Copyright:
 * Copyright (c) 2006 Company: sunrise Tech Ltd.
 * 
 * @author mys
 * @version 1.0
 */
public class VCustInteDAO extends BaseDAO {

	/**
	 * default constructor
	 */
	public VCustInteDAO() {
		super(VCustInteVO.class);
	}
	
	 /** 客户积分查询调用**/
    public DataPackage doQueryInte(CustInteListVO params) throws Exception {		
		
    	if(null != params && null != params.get_ne_custid() && !"".equals(params.get_ne_custid())){		
			try {	

				return queryByNamedSqlQuery("boss.fee.integral.query2inte", params);
					
			} catch (HibernateException ex) {
				if (ex.getCause() != null) {
					throw new Exception(ex.getCause());
				} else {
					throw ex;
				}
			}	
		}	
		return null;
		
	}
}
