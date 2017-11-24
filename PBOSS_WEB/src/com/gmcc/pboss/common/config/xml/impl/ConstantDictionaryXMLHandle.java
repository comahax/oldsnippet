package com.gmcc.pboss.common.config.xml.impl;

import java.io.File;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.gmcc.pboss.common.config.xml.IXmlHandle;

/**
 * 从兴公司电子渠道业务部
 * @author tangzhu
 * @date 2009-8-21
 * 所属项目：PBOSS
 * 所属模块：门户网站
 * 描述：固定参数表
 */
public class ConstantDictionaryXMLHandle implements IXmlHandle {
	private static Logger logger = Logger.getLogger(ConstantDictionaryXMLHandle.class);
	public void load(File file, Hashtable hashtable) throws Exception {
		// TODO Auto-generated method stub
		logger.info(">>>解析固定参数配置文件");
		SAXReader reader = new SAXReader();
        Document doc = reader.read(file);
        Element root = doc.getRootElement();
        Element foo;
        
        for(Iterator i = root.elementIterator("CONSTANT"); i.hasNext();){
        	foo = (Element) i.next();
        	String code = foo.attribute("code").getValue().trim();
        	
        	//System.out.println("CODE >>> " + foo.attribute("code").getValue().trim());
        	Map _mv = new LinkedHashMap();
        	for(Iterator j = foo.elementIterator("VALUE"); j.hasNext();){
        		foo = (Element)j.next();
        		String key = foo.attribute("key").getValue().trim();
        		String value = foo.getStringValue().trim();
        		
        		_mv.put(key, value);
//        		System.out.println(
//        				"Key >>> " + foo.attribute("key").getValue().trim() +
//        				" Value >>> " + foo.getStringValue().trim());
        	}//for j
        	
        	hashtable.put(code , _mv);
        }//for i
	}
}
