package com.gmcc.pboss.common.config.xml.impl;

import java.io.File;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.gmcc.pboss.common.config.FileConfigAdapter;
import com.gmcc.pboss.common.config.exception.FileConfigException;
import com.gmcc.pboss.common.config.xml.IXmlHandle;

/**
 * 从兴公司电子渠道业务部
 * @author tangzhu
 * @date 2009-12-24
 * 所属项目：PBOSS
 * 所属模块：门户网站
 * 描述：
 */
public class ConstantLoadConfigXMLHandle implements IXmlHandle {
	private static Logger logger = Logger.getLogger(ConstantLoadConfigXMLHandle.class);
	
	public void load(File file, Hashtable hashtable) throws Exception {
		// TODO Auto-generated method stub
		logger.info("加载固定参数标识配置文件");
		SAXReader reader = new SAXReader();
        Document doc = reader.read(file);
        Element root = doc.getRootElement();
        Element foo;
        
        Map<String,String> groupidMap = new HashMap<String,String>();
        for(Iterator i = root.elementIterator("VALUE"); i.hasNext();){
        	foo = (Element) i.next();
        	String name = foo.elementText("NAME").trim();
        	String desc = foo.elementText("DESC").trim();
        	
        	groupidMap.put(name, desc);
        }
        
        hashtable.put("CONSTANT_LOAD", groupidMap);
	}
}
