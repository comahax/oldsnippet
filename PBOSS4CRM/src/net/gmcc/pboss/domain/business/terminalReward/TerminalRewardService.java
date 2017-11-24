package net.gmcc.pboss.domain.business.terminalReward;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import net.gmcc.pboss.common.dynamicds.DynamicSourceHelper;
import net.gmcc.pboss.domain.additional.exception.RequestMessageException;
import net.gmcc.pboss.domain.business.service.BaseB2MService;
import net.gmcc.pboss.utils.DbUtil;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class TerminalRewardService extends BaseB2MService {
	private static final Logger log = Logger.getLogger(TerminalRewardService.class);
	public String queryTerminalReward (String wayid, String remonth){
		//切换回默认数据源
		DynamicSourceHelper.removeDataSurceUser();	
		
		Calendar   cal=Calendar.getInstance();  //取得当前日历 
		int   year=cal.get(Calendar.YEAR);//取得月份  
		int   month=cal.get(Calendar.MONTH)+1;//取得月份  

		StringBuffer sql = new StringBuffer();
		StringBuffer sb = new StringBuffer();
		String terminalReward = "";
		 SimpleDateFormat dateFormat=new SimpleDateFormat("yyyyMM");
		  Date startdate = null;
		  try{
		   startdate = dateFormat.parse(remonth);
		   cal.setTime(startdate);
		   int   yr2=cal.get(Calendar.YEAR);//取得月份  
		   int   month2=cal.get(Calendar.MONTH)+1;//取得月份  
		   int y=year-yr2;
		   if(y>1){
			   log.info("-------------------------[待办系统异步接口:TerminalRewardService]查询月份超过"+y+"年");
		    	 sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?> <Data wayid=\""+wayid+"\" >");
			     sb.append("</Data>");
			     return sb.toString();
		   }
		   if(y==0){
		    if(month-month2>3){
		    	log.info("-------------------------[待办系统异步接口:TerminalRewardService]查询月份超过3个月：-----"+(month-month2));
		    	 sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?> <Data wayid=\""+wayid+"\" >");
			     sb.append("</Data>");
			     return sb.toString();
		    }
		   }
		   if(y==1){
		    int month1=month+(13-month2);
		    if(month1>3){
		    	log.info("-------------------------[待办系统异步接口:TerminalRewardService]查询月份超过3个月：-----"+month1);
		    	 sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?> <Data wayid=\""+wayid+"\" >");
			     sb.append("</Data>");
			     return sb.toString();
		    	
		    }
		   }
		   
		log.info("-------------------------[待办系统异步接口:queryTerminalReward]传过来的wayid："+wayid+"-------remonth："+remonth);	
		
		DbUtil db = new DbUtil();  
		
		sql.append("  select cityid,wayid,opname,type,opmonth,remonth,paysum from ch_zd_waysum ");
		sql.append("  where wayid = ? and remonth= ? ");

		log.info("-------------------------[待办系统异步接口:TerminalRewardService]queryTerminalReward：-----"+sql);
	
//			resultSet=db.query(sql.toString());
//			Context initcontext = new InitialContext();
//			Context context = (Context) initcontext.lookup("java:comp/env");
//			DataSource datasource = (DataSource) context.lookup("oracle.jdbc.driver.OracleDriver");
			Connection cn = db.getConnection();
			PreparedStatement ps = cn.prepareStatement(sql.toString());
			ps.setString(1, wayid);
			ps.setString(2, remonth);
			ResultSet rs = ps.executeQuery();
			
				 sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?> <Data wayid=\""+wayid+"\" >");
					int i = 1; 
			        while(rs.next()) {
			        	sb.append("<Row id=\""+i+"\">");
						sb.append("<CITYID>");
						sb.append(rs.getString(1)!=null?rs.getString(1).toString():"");
						sb.append("</CITYID>");
						sb.append("<WAYID>");
						sb.append(rs.getString(2)!=null?rs.getString(2).toString():"");
						sb.append("</WAYID>");
						sb.append("<OPNAME>");
						sb.append(rs.getString(3)!=null?rs.getString(3).toString():"");
						sb.append("</OPNAME>");
						sb.append("<TYPE>");
						sb.append(rs.getString(4)!=null?rs.getString(4).toString():"");
						sb.append("</TYPE>");
						sb.append("<OPMONTH>");
						sb.append(rs.getString(5)!=null?rs.getString(5).toString():"");
						sb.append("</OPMONTH>");
						sb.append("<REMONTH>");
						sb.append(rs.getString(6)!=null?rs.getString(6).toString():"");
						sb.append("</REMONTH>");
						sb.append("<PAYSUM>");
						sb.append(rs.getString(7)!=null?rs.getString(7).toString():"");
						sb.append("</PAYSUM>");
						sb.append("</Row>");
						i++;
			           
			        }
			        sb.append("</Data>");
			        db.colseAll(rs, ps, cn);
				terminalReward = sb.toString();
			log.info("-------------------------[待办系统异步接口:queryTerminalReward]处理请求：完成-----");	
			log.info("-------------------------[待办系统异步接口:queryTerminalReward]报文："+terminalReward);	
			} catch (DataAccessException ex) {
			// TODO Auto-generated catch block
			log.error("createSQLQuery异常:"+ex.getMessage());
			log.error("-------------------------[待办系统异步接口:TerminalRewardService]处理queryTerminalReward请求：DataAccessException异常");	
			ex.printStackTrace();
			sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?><error><property name=\"code\">001</property><property name=\"describe\">error when check then args</property></error>");
			 return sb.toString();

			} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.error("SQLException异常:"+e.getMessage());
			log.error("-------------------------[待办系统异步接口:TerminalRewardService]处理queryTerminalReward请求：SQLException异常");	
			e.printStackTrace();
			
			sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?><error><property name=\"code\">001</property><property name=\"describe\">error when check then args</property></error>");
			 return sb.toString();
		}catch(ParseException e){
			   e.printStackTrace();
			   sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?><error><property name=\"code\">002</property><property name=\"describe\">请求的日期参数异常</property></error>");
				 return sb.toString();
			   
			  }
		
		return terminalReward;
	}

	@Override
	protected void checkReqBody(Object reqbody) throws RequestMessageException {
		// TODO Auto-generated method stub
		
	}
}
