package net.gmcc.pboss.utils;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DbUtil {
	protected static final String mkey = "70469B26CBF1E575";
	protected static final Log logger = LogFactory.getLog(DbUtil.class);

	private static ComboPooledDataSource ds = null;  
	
	
	//使用C3P0连接池
	static {
		try {
			logger.info(":::::::::::::::::开始创建数据库连接池:::::::::::::::");
			// 读取配置文件的内容
			DbUtil db = new DbUtil();
			String proFile = "/base.properties";
//			InputStream is = this.getClass().getResourceAsStream(proFile);
			InputStream is = db.getClass().getResourceAsStream(proFile);
			Properties properties = new Properties();
			properties.load(is);
			is.close();
			String url= properties.getProperty("DB_COMMON_db_url");
			String user = properties.getProperty("DB_COMMON_db_user");
			String password = properties.getProperty("DB_COMMON_db_password");
			ds = new ComboPooledDataSource();
			// 设置JDBC的Driver类
			ds.setDriverClass("oracle.jdbc.driver.OracleDriver"); // 参数由 Config
			// 类根据配置文件读取
			// 设置JDBC的URL
			ds.setJdbcUrl(url);
			// 设置数据库的登录用户名
			ds.setUser(user);
			// 设置数据库的登录用户密码
			ds.setPassword(password);
			// 设置连接池的最大连接数
			ds.setMaxPoolSize(200);
			// 设置连接池的最小连接数
			ds.setMinPoolSize(20);
		} catch (PropertyVetoException e) {
			logger.error("数据库连接池创建失败！");
			e.printStackTrace();
		}catch (IOException e) {
			logger.error("读取数据库连接配置文件的内容失败！");
			e.printStackTrace();
		
		}
	}

	public static synchronized Connection getConnection() {
		Connection con = null;
		try {
			con = ds.getConnection();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return con;
	}
	
	
	//获得一个连接 Connection
	public static  Connection getConn(String cityid){
		DbUtil db = new DbUtil();
		Connection conn=null;
		try {
//			  String url="jdbc:oracle:thin:@10.200.25.151:1521:boss20dev"; 
			// 读取配置文件的内容
			String proFile = "/base.properties";
//			InputStream is = this.getClass().getResourceAsStream(proFile);
			InputStream is = db.getClass().getResourceAsStream(proFile);
			Properties properties = new Properties();
			properties.load(is);
			is.close();
			String url= properties.getProperty(cityid + "_db_url");
			String user = properties.getProperty(cityid + "_db_user");
			String password = properties.getProperty(cityid + "_db_password");
			
			//解密
//			try{
//				password = new String(SecurityPass.decode(SecurityPass.hex2byte(password), SecurityPass.hex2byte(mkey)));
//				logger.debug("Datebase password解密完成!");
//			}catch(Exception ex) {
//				ex.printStackTrace();
//				logger.error("Datebase password decode error:"+ex.getMessage());
//			}

//			String url="jdbc:oracle:thin:@(DESCRIPTION=(ENABLE=BROKEN)(FAILOVER=YES)(LOAD_BALANCE=OFF)(ADDRESS_LIST=(ADDRESS=(PROTOCOL=TCP)(HOST=172.10.0.27)(PORT=1521)))(CONNECT_DATA=(SERVER=DEDICATED)(SERVICE_NAME=cxcsdb)(FAILOVER_MODE=(METHOD=BASIC)(type=session)(retries=120)(delay=5))))";
			 
			//COMS测试
			//jdbc:oracle:thin:@172.20.0.16:1521:coms
//			  String user="yjpb"; 
//			  String password="gmcc123"; 
			  
			//CRM测试
//			String url="jdbc:oracle:thin:@172.10.0.27:1521:cxcsdb";
//			  String user="ngcrm_fs"; 
//			  String password="ngcrm_fs"; 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			 conn=DriverManager.getConnection(url,user,password); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			logger.error("驱动没找到"+ e.getMessage());
			System.out.println("驱动没找到");
		} catch (SQLException e) {
			logger.error("连接DB出错"+ e.getMessage());
			System.out.println("连接DB出错");
			e.printStackTrace();
		}
		return conn;
	}

	//关闭DB
	public static void colseAll(ResultSet rs,Statement stmt,Connection conn){
		try {
			if(rs!=null){
				rs.close();
			}
			if(stmt!=null){
				stmt.close();
			}
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e) {
			logger.error("数据库连接关闭出错"+ e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	public static void test() {
		try {
			Context initcontext = new InitialContext();
			Context context = (Context) initcontext.lookup("java:comp/env");
			DataSource datasource = (DataSource) context.lookup("xa-cz-ds");
			Connection cn = datasource.getConnection();
			String sql = "select dictid, dictname from SA_DB_DICTITEM where groupid = ?";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, "CH_GLINE");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString(1) + " ---------- " + rs.getString(2));
			}
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
}
