package net.gmcc.pboss.utils;

import java.io.FileReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * 服务工具类
 * 
 * 加载SPRING容器BEAN
 * 
 *
 */

public class ServiceUtil  implements ServletContextListener {
	protected static final Logger LOG = Logger.getLogger(ServiceUtil.class);

    public static ApplicationContext ac = null;
	
	/**
	 * 可能是兼容性问题,WAS部署后SPRING会把所有对象释放(好像是接口使用了复杂类所致),放在这里延迟独立LOAD一次.
	 * 在applicationContext.xml加载完后,会执行此类,进行BEAN初始化和存储SPRING容器上下文,所有BEAN对象应该通过此上下文来获取.
	 * 
	 * 使用同步确保ac生成过程只能一个线程处理.
	 * 
	 * @return
	 */
	public synchronized void setApplicationContext(){
		if(ac == null){
			//唯一一个可以在WAS上找到WEB-INF目录的方法:用具体类来获取路径.
			String path = getWebInfPath(ServiceUtil.class.getResource("").getPath());
			String dsFileName = null;
			try {
				//获取数据源文件名
				Properties properties = new Properties();
				LOG.info("开始读取文件 :" + path + "ds.properties" );
				properties.load(new FileReader(path + "ds.properties"));
				dsFileName = (String)properties.get("dsfilename");
				LOG.info("读取文件内容为 : " + dsFileName);
			} catch (Exception e1) {
				LOG.info("读取ds.properties文件出错." + e1.getMessage()+ " #### " + e1.getCause());
			}
			if( StringUtil.checkNullAndBlank(path) && StringUtil.checkNullAndBlank(dsFileName) ){
				SimpleDateFormat simleDateFromat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
				try {
					LOG.info("开始加载对象 : " + simleDateFromat.format( new Date() ));
					ac=new FileSystemXmlApplicationContext("file:" + path + dsFileName );//使用绝对路径
					LOG.info("对象加载完毕 : " + simleDateFromat.format( new Date() ));
				} catch (BeansException e) {
					LOG.info("加载对象出错." + e.getMessage());
				}
			}else{
				//do nothing;
				//log in getWebInfPath()
			}
		}
	}
	
	public String getWebInfPath(String path){
		int pos = path.indexOf("WEB-INF");
		String tmpPath = null;
		
		if(pos >= 0){
			if( ( path.substring(0,3) ).contains(":")){//windows
				// /D:/workspace/HSC_CBS_HW_svn/
				tmpPath = path.substring(1,pos+"WEB-INF".length()+1);
			}else{//其它系统
				tmpPath = path.substring(0,pos+"WEB-INF".length()+1);
			}
		}else{
			LOG.info("路径为:" + path);
			LOG.warn("找不到 WEB-INF 目录,不会加载 ds-default.xml 文件.");
		}
		try {
			//对路径进行解码,得到路径中的中文和空格
			tmpPath = URLDecoder.decode(tmpPath,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tmpPath;
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		ac = null;
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		setApplicationContext();
	}

	
}
