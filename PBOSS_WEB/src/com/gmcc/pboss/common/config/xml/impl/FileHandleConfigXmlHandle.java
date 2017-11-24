package com.gmcc.pboss.common.config.xml.impl;

import java.io.File;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.gmcc.pboss.common.config.FileConfigAdapter;
import com.gmcc.pboss.common.config.exception.FileConfigException;
import com.gmcc.pboss.common.config.xml.IXmlHandle;
import com.gmcc.pboss.common.file.bean.FileHandleConfig;
import com.gmcc.pboss.common.file.bean.FileUploadBean;
import com.gmcc.pboss.common.file.bean.ServerInfoBean;
import com.gmcc.pboss.common.util.CommonUtil;

/**
 * 从兴公司电子渠道业务部
 * @author tangzhu
 * @date 2009-10-21
 * 所属项目：PBOSS
 * 所属模块：门户网站
 * 描述：
 */
public class FileHandleConfigXmlHandle implements IXmlHandle {
	
	private static Logger logger = Logger.getLogger(FileHandleConfigXmlHandle.class);
	public void load(File file, Hashtable hashtable) throws Exception {
		// TODO Auto-generated method stub
		logger.info(">>>解析文件处理配置文件");
		SAXReader reader = new SAXReader();
        Document doc = reader.read(file);
        Element root = doc.getRootElement();
       
        FileHandleConfig config = new FileHandleConfig();
        Map uploadFiles = new Hashtable();
        Element foo;
        
        	
    	foo = (Element) root.element("FTP");
    	if(foo != null) {
    		ServerInfoBean ftpInfo = new ServerInfoBean();
    		ftpInfo.setIp(foo.elementText("Address").trim());
    		ftpInfo.setPort(Integer.parseInt(foo.elementText("Port").trim()));
    		ftpInfo.setUsername(foo.elementText("User").trim());
    		ftpInfo.setPassword(foo.elementText("Password").trim());
    		ftpInfo.setWorkdir(foo.elementText("WorkDir").trim());
    		config.setServer(ftpInfo);
    	}
    		
        
        for(Iterator i = root.elementIterator("Uploads"); i.hasNext();){
        	foo = (Element) i.next();
        	
        	Element f;
        	for(Iterator j = foo.elementIterator("File"); j.hasNext();){
        		f = (Element) j.next();
        		
        		FileUploadBean upload = new FileUploadBean();
        		
        		upload.setType(f.elementText("Type").trim());
        		
        		String isNeedLogin = f.elementText("IsNeedLogin").trim();
        		if(!CommonUtil.isEmptyOrNull(isNeedLogin))
        			upload.setNeedLogin(isNeedLogin.equalsIgnoreCase("true"));
        		
        		String isUploadTimesLimit = f.elementText("IsUploadTimesLimit").trim();
        		if(!CommonUtil.isEmptyOrNull(isUploadTimesLimit));
        			upload.setUploadTimesLimit(isUploadTimesLimit.equalsIgnoreCase("true"));
        			
        		if(upload.isUploadTimesLimit())
        			upload.setUploadTotalTimes(Integer.parseInt(f.elementText("UploadTotalTimes")));
        		
	        	upload.setCacheSize(Integer.parseInt(f.elementText("CacheSize")));
	        	upload.setMaxSize(Integer.parseInt(f.elementText("MaxSize")));
	        	upload.setTotalSize(Integer.parseInt(f.elementText("TotalSize")));
	        	upload.setCommonPath(f.elementText("CommonPath"));
	        	upload.setFileSuffix(f.elementText("FileSuffix"));
	        	upload.setRecreateDoc(f.elementText("IsRecreateDoc").equalsIgnoreCase("true"));
	        	upload.setRecreateDocRegular(f.elementText("RecreateDocRegular"));
	        	upload.setRenameFile(f.elementText("IsRenameFile").equalsIgnoreCase("true"));
	        	upload.setRenameRegular(f.elementText("RenameRegular"));
	        	
	        	uploadFiles.put(upload.getType(), upload);
        	}//end for j
        	
        }//end for i
        
        config.setUploadFiles(uploadFiles);
        hashtable.put("FILE_HANDLE", config);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IXmlHandle handle = new FileHandleConfigXmlHandle();
		
		FileConfigAdapter fileConfig;
		FileHandleConfig bean;
		try {
			fileConfig = FileConfigAdapter.init();
			bean = (FileHandleConfig)fileConfig.loadProperty("FILE_HANDLE", "FILE_HANDLE", handle);
			
			System.out.println(bean.getUploadFiles().get("INDAGATE_QUESTIONNAIRE").toString());
		} catch (FileConfigException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
