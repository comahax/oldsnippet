package com.gmcc.pboss.business.cms.examine.examine.persistent;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sunrise.jop.common.utils.lang.SessionUtils;
import com.sunrise.jop.infrastructure.db.AbstractDAO;
import com.sunrise.jop.infrastructure.db.DataPackage;



/**
 * <p>Title: ExamineDAO</p>
 * <p>Description: Data Access Object for ExamineVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ExamineDAO extends AbstractDAO {

    /**
     * default constructor
     */
    public ExamineDAO(){
        super(ExamineVO.class);
    }
    
    
    /**
	  * �Զ���SQL��ѯ  (�����ƣ�)
	  * @param queryString ��ѯ��SQL
	  * @param params	��ѯ����ͬJOP
	  * @param returnType	��ѯ����ֵ��װ�ɵ�BEAN������,
	  * @return ��returnType ����ΪNULLʱ��Ӧ���͵��б�,ΪNULLʱֱ�ӷ���queryBySql(queryString, params)ȡ�õ�ֵ
	  * @throws Exception
	  */
	 public DataPackage queryBySql(String queryString,Object params,Class returnType) throws Exception{
		 DataPackage dp = new DataPackage();
		 SessionFactory factory = SessionUtils.getSessionFactory();
		 Session session = factory.openSession();
		  
		 Connection conn =  session.connection();
		 Statement stmt = conn.createStatement();
		 ResultSet rs = stmt.executeQuery(queryString);
		 List list = new ArrayList();
		 if(null != rs){
			Map columnNameMap = new HashMap();
			 ResultSetMetaData meta = rs.getMetaData();
			 for(int i =1;i<=meta.getColumnCount();i++){
				 columnNameMap.put(meta.getColumnName(i), meta.getColumnName(i));
			 }
			 Set columnKeySet = columnNameMap.keySet();
			 
			 while(rs.next()){
				 Map resultMap = new HashMap();
				 Iterator columnKeyIterator = columnKeySet.iterator();
				 while(columnKeyIterator.hasNext()){
					 String key = (String)columnKeyIterator.next();
					 resultMap.put(key, rs.getString(key));
				 }
				 list.add(resultMap);
			 }
		 }
		 dp.setDatas(list);
		 if( null == returnType)
			 return dp;
		 List colection = new ArrayList();
		 Iterator iterator = dp.getDatas().iterator();
		 while(iterator.hasNext()){
			 Object obj = iterator.next();
			 Object newObj = returnType.newInstance();
			 BeanUtils.copyProperties(newObj, obj);
			 colection.add(newObj);
		 }
		 dp.setDatas(colection);
		 return dp;
	 }
	 
}
