package com.gmcc.pboss.common.config;
import java.io.File;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.gmcc.pboss.common.config.xml.IXmlHandle;
import com.gmcc.pboss.common.dictionary.FileDictionary;


public class DataSourceConfigXMLHandle implements IXmlHandle{
	private static Logger logger = Logger.getLogger(DataSourceConfigXMLHandle.class);
	
	private static final String DataSource = "DataSource";
	private static final String UniqueResourceName = "UniqueResourceName";
	private static final String XaDataSourceClassName = "XaDataSourceClassName";
	private static final String URL = "URL";
	private static final String user = "user";
	private static final String password = "password";
	
	public void load(File file, Hashtable hashtable) throws Exception {
		
		logger.info("加载数据元配置文件");
		
		SAXReader reader = new SAXReader();
        Document doc = reader.read(file);
        Element root = doc.getRootElement();
        Element foo;
        
        Map<String,String[]> groupidMap = new HashMap<String,String[]>();
        for(Iterator i = root.elementIterator(DataSource); i.hasNext();){
        	foo = (Element) i.next();
        	String[] array = new String[4];
        	array[0] = foo.elementTextTrim(XaDataSourceClassName);
        	array[1] = foo.elementTextTrim(URL);
        	array[2] = foo.elementTextTrim(user);
        	array[3] = foo.elementTextTrim(password);
        	groupidMap.put(foo.elementTextTrim(UniqueResourceName), array);
        }
        hashtable.put(FileDictionary.DATASOURSE_INFO, groupidMap);
	}

}
