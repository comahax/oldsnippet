package com.gmcc.pboss.common.config;

import java.io.File;
import java.util.Hashtable;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.gmcc.pboss.common.config.xml.IXmlHandle;
import com.gmcc.pboss.common.dictionary.Regex;
import com.gmcc.pboss.common.util.CommonUtil;


public class FileConfigXmlHandle implements IXmlHandle {
	private Logger logger = Logger.getLogger(FileConfigXmlHandle.class);
    public void load(File file, Hashtable hashtable) throws Exception {
    	logger.info("加载文件配置FileConfig.xml，得到所有有配置的配置文件");
        //test
        SAXReader reader = new SAXReader();
        Document doc = reader.read(file);
        Element root = doc.getRootElement();
        Element foo;
        FileConfigBean bean = null;
        
        //通用路径
        String commonPath = root.element("COMMON_PATH").getTextTrim();
        hashtable.put("COMMON_PATH", getPath(commonPath,null));
        
        //日志路径
        String logPath = root.element("LOG_PATH").getTextTrim();
        hashtable.put("LOG_PATH", getPath(logPath,null));
        
        //验证码路径
        String imagePath = root.element("IMAGE_PATH").getTextTrim();
        hashtable.put("IMAGE_PATH", getPath(imagePath,null));
        
        for (Iterator i = root.elementIterator("FILE"); i.hasNext();) {
            foo = (Element) i.next();
            try {
                bean = new FileConfigBean();
                bean.setCode(foo.elementText("CODE"));
                bean.setStatus(Integer.parseInt(foo.elementText("STATUS")));
                bean.setName(foo.elementText("NAME"));
                bean.setPath(getPath(commonPath, foo.elementText("PATH")));
                bean.setType(foo.elementText("TYPE"));
                bean.setUpdateType(foo.elementText("UPDATE_TYPE"));
                bean.setUpdateTime(Integer.parseInt(foo.elementText("UPDATE_TIME")));
                bean.setIsByBranch(Integer.parseInt(foo.elementText("IS_BY_BRANCH")));
                bean.setIsDefault(Integer.parseInt(foo.elementText("IS_DEFAULT")));
                bean.setDefaultBranch(foo.elementText("DEFAULT_BRANCH"));
                bean.setDescription(foo.elementText("DESCRIPT"));
                hashtable.put(bean.getCode(), bean);
                logger.info("已经读取信息>>>" + bean.getCode());
            } 
            catch (Exception e) {
                e.printStackTrace();
                logger.info("加载FileConfig Exception");
            }
        }//for
    }
    /**
     * 组合文件保存路径
     * @param commonPath
     * @param filePath
     * @return
     */
    private String getPath(String path, String filePath){
    	StringBuffer sb = new StringBuffer();
    	sb.append(path);
    	
    	if(!CommonUtil.isEmptyOrNull(path) 
    		&& !path.endsWith(Regex.SKEWLINE))
    		sb.append(Regex.SKEWLINE);
    	
    	
    	if(!CommonUtil.isEmptyOrNull(filePath)){
    		sb.append(filePath);
    		if(!filePath.endsWith(Regex.SKEWLINE)){
    			sb.append(Regex.SKEWLINE);
    		}
    	}
    	
    	return sb.toString();
    }
}
