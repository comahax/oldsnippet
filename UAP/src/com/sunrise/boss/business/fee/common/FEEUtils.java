package com.sunrise.boss.business.fee.common;

import java.sql.ResultSet;

import org.apache.log4j.Logger;

import com.sunrise.jop.infrastructure.db.DBAccessUser;


/**

 * ����ҵ�񹤾���,����2��ʹ�õĴ���,д������ͳһ����
 * @author mys

 * 帐务业务工具类,超过2次使用的代码,写在这里统一管理
 * @author panmeifa

 * @version 1.0
 */
public class FEEUtils {

	
	private static Logger log = Logger.getLogger(FEEUtils.class);
	
	/** 获取某个表的sequence  默认-200 为错误码*
	 * @throws Exception 
	 **/
	public static long getSequence(String sequencename, DBAccessUser user) throws Exception{    	
    	
		StringBuffer sqlBuffer = new StringBuffer("select ").append(sequencename);
		sqlBuffer.append(".nextval from dual");
		
		ResultSet rs = null;
		long seq = -200;
		
		try{					
			rs = SqlUtils.getBSQLStatement( sqlBuffer.toString(), user.getDbFlag()).executeQuery();
			
			if( rs != null && rs.next() ){
				seq = rs.getLong(1);
			}
		}catch(Exception ex){
			log.error("获取[" + sequencename + "]序列号出错: " + ex.getMessage(),ex);	
			throw ex;
		}finally{
			if( rs != null ){
				rs.close();
			}
		}
		if(seq < 0){
    		throw new Exception( "获取[" + sequencename + "]序列号出错: " + seq );
    	}
		
		return seq;
    }
	
	

}
