/**
 * auto-generated code
 * Fri Aug 25 11:23:52 CST 2006
 */
package com.sunrise.boss.business.fee.citycompany.persistent;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;


import com.sunrise.jop.infrastructure.db.AbstractDAO;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>
 * Title: CitycompanyDAO
 * </p>
 * <p>
 * Description: Data Access Object for CitycompanyVO
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: Maywide Tech Ltd.
 * </p>
 * 
 * @author yjr
 * @version 1.0
 */
public class CitycompanyDAO extends AbstractDAO {

	/**
	 * default constructor
	 */
	public CitycompanyDAO() {
		super(CitycompanyVO.class);
	}
	
	public String doName2Code(String param) throws Exception{
	
		Session session = super.getSession();
		String sql ="SELECT  *    FROM  CH_PW_CITYCOMPANY  WHERE CITYCOMPNAME =:name";
		SQLQuery  query = session.createSQLQuery(sql);
		
		query.setString("name", param);
		
		query.addEntity(CitycompanyVO.class);
		
		List list =query.list();		
		
		for(Iterator itr = list.iterator();itr.hasNext();){
				CitycompanyVO code = (CitycompanyVO) itr.next();
				System.out.println("------------------code------------------ : "+  code.getCitycompid());
				return code.getCitycompid();
		}
		
		return null;
	}

}
