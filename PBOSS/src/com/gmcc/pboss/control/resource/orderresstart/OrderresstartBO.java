/**
 * auto-generated code
 * Sat May 29 15:31:56 CST 2010
 */
package com.gmcc.pboss.control.resource.orderresstart;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.gmcc.pboss.business.resource.orderresstart.OrderresstartDAO;
import com.gmcc.pboss.business.resource.orderresstart.OrderresstartDBParam;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.common.utils.lang.SessionUtils;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: OrderresstartBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yedaoe
 * @version 1.0
 */
public class OrderresstartBO extends AbstractControlBean implements	Orderresstart {
	
	private Logger log = Logger.getLogger(OrderresstartBO.class);
	public DataPackage doComresStat(OrderresstartDBParam param,String comstate,String batchno) throws Exception {
		OrderresstartDAO dao = (OrderresstartDAO) DAOFactory.build(OrderresstartDAO.class,user);
		param.getQueryConditions().put("COMSTATE", comstate);
		param.getQueryConditions().put("BATCHNO", batchno);
		return dao.queryByNamedSqlQuery("com.gmcc.pboss.business.resource.comressmp.orderresstart.comresstat",param);
	}
	
	public DataPackage doComresCardStat(OrderresstartDBParam param,String comstate,String batchno) throws Exception {
		OrderresstartDAO dao = (OrderresstartDAO) DAOFactory.build(OrderresstartDAO.class,user);
		param.getQueryConditions().put("COMSTATE", comstate);
		param.getQueryConditions().put("BATCHNO", batchno);
		return dao.queryByNamedSqlQuery("com.gmcc.pboss.business.resource.comrescard.orderresstart.comresstat",param);
	}
	
	public void doStartSmlp(String batchno) throws Exception {
		Session session  = SessionUtils.currentSession(user.getCityid());
    	Connection conn = session.connection();
    	PreparedStatement stmt = null;
		try {
			String sql1 = "update IM_FX_COMRESSMP set comstate=1 where batchno= ? and comstate= ? ";
			log.info(sql1);
			stmt = conn.prepareStatement(sql1);
			stmt.setString(1, batchno);
			stmt.setString(2, "30");
			stmt.executeUpdate();
			
			String sql2 = "update IM_PR_COMPACK set packstate=1 where batchno= ? and packstate= ? ";
			log.info(sql2);
			stmt = conn.prepareStatement(sql2);
			stmt.setString(1, batchno);
			stmt.setString(2, "30");
			stmt.executeUpdate();
		}catch (Exception ex) {
			ex.printStackTrace();
    		throw new JOPException("∆Ù”√∂©π∫◊ ‘¥ ß∞‹",ex.getCause());
		}finally{
    		if( null != stmt ){
    			try{
    				stmt.close();
    			}catch(Exception ex){
    				ex.printStackTrace();
    				LoggerUtils.error(ex, log);
    			}
    		}
    	}
	}
	
	public void doStartCard(String batchno)throws Exception{
		Session session  = SessionUtils.currentSession(user.getCityid());
    	Connection conn = session.connection();
    	PreparedStatement stmt = null;
		try{
			String sql = "update IM_FX_COMRESCARD set comstate=1 where batchno= ? and comstate= ? ";
			log.info(sql);
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, batchno);
			stmt.setString(2, "30");
			stmt.executeUpdate();
		}catch (Exception ex) {
			ex.printStackTrace();
    		throw new JOPException("∆Ù”√∂©π∫◊ ‘¥ ß∞‹",ex.getCause());
		}finally{
    		if( null != stmt ){
    			try{
    				stmt.close();
    			}catch(Exception ex){
    				ex.printStackTrace();
    				LoggerUtils.error(ex, log);
    			}
    		}
    	}
	}

	public DataPackage doKBSIMStat(OrderresstartDBParam param, String comstate,
			String batchno) throws Exception {
		OrderresstartDAO dao = (OrderresstartDAO) DAOFactory.build(OrderresstartDAO.class,user);
		param.getQueryConditions().put("USESTATE", comstate);
		param.getQueryConditions().put("BATCHNO", batchno);
		return dao.queryByNamedSqlQuery("com.gmcc.pboss.business.resource.emptysim.orderresstart.comresstat",param);
	}

	public void doStartEmptyCard(String batchno) throws Exception {
		Session session  = SessionUtils.currentSession(user.getCityid());
    	Connection conn = session.connection();
    	PreparedStatement stmt = null;
		try{
			String sql = "update IM_FX_EMPTYSIM set usestate=1 where batchno= ? and usestate= ? ";
			log.info(sql);
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, batchno);
			stmt.setString(2, "30");
			stmt.executeUpdate();
		}catch (Exception ex) {
			ex.printStackTrace();
    		throw new JOPException("∆Ù”√∂©π∫◊ ‘¥ ß∞‹",ex.getCause());
		}finally{
    		if( null != stmt ){
    			try{
    				stmt.close();
    			}catch(Exception ex){
    				ex.printStackTrace();
    				LoggerUtils.error(ex, log);
    			}
    		}
    	}
		
	}

}
