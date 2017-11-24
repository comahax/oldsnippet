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
 * ���˹�˾��������ҵ��
 * @author tangzhu
 * @date 2009-12-24
 * ������Ŀ��PBOSS
 * ����ģ�飺�Ż���վ
 * ������
 */
public class ConstantLoadConfigXMLHandle implements IXmlHandle {
	private static Logger logger = Logger.getLogger(ConstantLoadConfigXMLHandle.class);
	
	public void load(File file, Hashtable hashtable) throws Exception {
		// TODO Auto-generated method stub
		logger.info("���ع̶�������ʶ�����ļ�");
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
