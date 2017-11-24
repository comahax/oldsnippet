package com.gmcc.pboss.common.bean;

import java.util.Map;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.atomikos.jdbc.AtomikosDataSourceBean;
import com.gmcc.pboss.common.constant.Constant;
import com.gmcc.pboss.common.util.SecurityPass;

/**
 * 用于加密的自定义DataSourceBean
 * @author zhangsiwei
 *
 */
public class SecurityDataSourceBean extends AtomikosDataSourceBean {

	protected static final String mkey = "70469B26CBF1E575";

	protected static final Log logger = LogFactory.getLog(SecurityDataSourceBean.class);
	
	private static final Map<String,String[]> dataSourceInfo = Constant.getXaProperties();
	
	public void setUniqueResourceName(String uniqueResourceName){
		String[] dataSource = dataSourceInfo.get(uniqueResourceName);
		if(dataSource==null)
			logger.error("数据源配置文件中没有名为:"+uniqueResourceName+"的配置！");
		super.setUniqueResourceName(uniqueResourceName);
		super.setXaDataSourceClassName(dataSource[0]);
		Properties xaProperties = new Properties();
		xaProperties.setProperty("URL", dataSource[1]);
		xaProperties.setProperty("user", dataSource[2]);
		try{
			xaProperties.setProperty("password", new String(SecurityPass.decode(SecurityPass.hex2byte(dataSource[3]), SecurityPass.hex2byte(mkey))));
			logger.debug("Datebase password解密完成!");
		}catch(Exception ex) {
			ex.printStackTrace();
			logger.error("Datebase password decode error:"+ex.getMessage());
		}
		super.setXaProperties(xaProperties);
	}
	
//	@Override
//	public void setXaProperties(Properties xaProperties) {
//		// TODO Auto-generated method stub
//		String password = xaProperties.getProperty("password");
//		try {
//			//进行解密运算
//			password = new String(SecurityPass.decode(SecurityPass.hex2byte(password), SecurityPass.hex2byte(mkey)));
//		}catch(Exception ex) {
//			ex.printStackTrace();
//			logger.error("Datebase password decode error:"+ex.getMessage());
//		}
//		xaProperties.setProperty("password", password);
//		logger.debug("Datebase password解密完成!");
//		super.setXaProperties(xaProperties);
//		
//	}

	
}
