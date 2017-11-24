package com.gmcc.pboss.common.config.xml.impl;

import java.io.File;
import java.util.Hashtable;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.gmcc.pboss.common.bean.URLAuthority;
import com.gmcc.pboss.common.config.xml.IXmlHandle;
import com.gmcc.pboss.common.dictionary.Regex;

/**
 * 从兴公司电子渠道业务部
 * @author tangzhu
 * @date 2009-9-2
 * 所属项目：PBOSS
 * 所属模块：门户网站
 * 描述：解析URL权限配置文件
 */
public class URLAuthorityHandle implements IXmlHandle {
	private static Logger logger = Logger.getLogger(URLAuthorityHandle.class);
	
	public void load(File file, Hashtable hashtable) throws Exception {
		// TODO Auto-generated method stub
		logger.info(">>>解析URL权限配置文件");
		
		SAXReader reader = new SAXReader();
        Document doc = reader.read(file);
        Element root = doc.getRootElement();
        
        URLAuthority bean = new URLAuthority();
        bean.setUnLoginJSP(getURLValue(root, "UNLOGIN_JSP"));
        bean.setUnLoginAction(getURLValue(root, "UNLOGIN_ACTION"));
        bean.setShopMaster(getURLValue(root, "SHOP_MASTER"));
        bean.setShopAssistant(getURLValue(root, "SHOP_ASSISTANT"));
        bean.setDeliveryMan(getURLValue(root, "DELIVERY_MAN"));
        bean.setManager(getURLValue(root, "MANAGER"));
        bean.setMissioner(getURLValue(root, "MISSIONER"));        
        bean.setGdmanager(getURLValue(root, "GD_MANAGER"));
        bean.setCitymanager(getURLValue(root, "CITY_MANAGER"));
        hashtable.put("URL_AUTHORITY", bean);
	}
	
	private String getURLValue(Element root, String type){
		Element foo;
		StringBuffer sb = new StringBuffer();
		for(Iterator i = root.elementIterator(type); i.hasNext();){
			foo = (Element) i.next();
        	for(Iterator j = foo.elementIterator("VALUE"); j.hasNext();){
        		foo = (Element)j.next();
        		String value = foo.getStringValue().trim();
        		sb.append(value);
        		if(j.hasNext())
        			sb.append(Regex.UPRIGHT_LOG);
        	}//for j
        	
        }//for i
		
		//System.out.println( type + ">>>" + sb.toString());
		return sb.toString();
	}

}
