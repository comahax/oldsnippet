/**
 * auto-generated code
 * 2006.08.08
 */
package com.sunrise.boss.business.fee.integral.custintedeta.persistent;

import org.hibernate.HibernateException;

import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.DataPackage;

/**
 * 
 * Title: VCustInteDetaDAO Description: Data Access Object for VCustInteDetaVO
 * Copyright: Copyright (c) 2006 Company: sunrise Tech Ltd.
 * 
 * @author mys
 * @version 1.0
 */
public class VCustInteDetaDAO extends BaseDAO {

	/**
	 * default constructor
	 */
	public VCustInteDetaDAO() {
		super(VCustInteDetaVO.class);
	}

	 /** �ͻ�����������ѯ AND �ͻ����ֲ�ѯ����--�ͻ�������ϸ�б� **/
    public DataPackage doQueryInteDeta(CustInteDetaListVO params) throws Exception {		
		
    	if(null != params && null != params.get_ne_custid() && !"".equals(params.get_ne_custid())){		
			try {	

				return queryByNamedSqlQuery("boss.fee.integral.query2intedeta", params);
					
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
