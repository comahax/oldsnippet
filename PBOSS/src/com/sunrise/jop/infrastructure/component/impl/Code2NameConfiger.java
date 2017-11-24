package com.sunrise.jop.infrastructure.component.impl;

import java.io.InputStream;
import java.util.*;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


public class Code2NameConfiger {

	
	private static final Logger log = Logger.getRootLogger();
	
	public static CacheManager cacheManager;
	public static Cache code2nameCache;
	
	static public HashMap sysMap = new HashMap();
	static public HashMap localMap  = new HashMap();
	
	private static String CODE2NAME_CONFIG_PATH = "/data/code2name.xml";
	
	static {
		init();
	}

	public static String getCodeProperty( String definition ) throws Exception {
		Node node = (Node) sysMap.get(definition);
		return node.getCode();
	}
	
	public static String getNameProperty( String definition ) throws Exception {
		Node node = (Node) sysMap.get(definition);
		return node.getName();
	}

	// ����ע�������Ĳ���XML�ļ�����Ƕ�׵Ĳ��
	final static String SYSCODE_CONFIG_0 = "syscode-config";// �����

	final static String SYSCODE_DYNAMIC_1 = "syscode-dynamic"; // ��һ��

	final static String SYSCODE_LOCAL_1 = "syscode-local"; // ��һ��

	final static String DEFINITION_2 = "definition"; // �ڶ���

	final static String VALUE_OBJECT_2 = "value-object"; // �ڶ���

	final static String CODE_2 = "code"; // �ڶ���

	final static String NAME_2 = "name"; // �ڶ���
	
	final static String ITEMS_2 = "items";// �ڶ���
	
	final static String ITEMVALUE_3 = "itemvalue";// ������

	final static String ITEMVALUE_3_CODE = "code";// ������itemvalue������
//	
	private static void init() {
		sysMap = new HashMap();

		SAXReader saxReader = new SAXReader();
		try {
			InputStream in = Code2NameConfiger.class.getResourceAsStream(CODE2NAME_CONFIG_PATH);
			if(in == null)
				throw new IllegalArgumentException("Can't find code2name.xml file, location: " + CODE2NAME_CONFIG_PATH);
			Document document = saxReader.read(in);

			List dynamicList = document.selectNodes(SYSCODE_CONFIG_0 + "/" + SYSCODE_DYNAMIC_1);
			Iterator iter = dynamicList.iterator();
			while (iter.hasNext()) {
				Element ele = (Element) iter.next();
				String key = ele.element(DEFINITION_2).getStringValue().trim(); //ע�⣬Ҫȥ���ո�
				Node node = new Node();
				node.setValueObject(ele.element(VALUE_OBJECT_2).getStringValue().trim());
				node.setCode(ele.element(CODE_2).getStringValue().trim());
				node.setName(ele.element(NAME_2).getStringValue().trim());
				sysMap.put(key, node);
			}
			
			List locallist = document.selectNodes(SYSCODE_CONFIG_0 + "/" + SYSCODE_LOCAL_1);
			localMap = new HashMap();
	        Iterator iterl = locallist.iterator();
	        while(iterl.hasNext()){
	            Element localElement = (Element)iterl.next();
	            LocalNote local = new LocalNote();
	            Element definition = localElement.element(DEFINITION_2);
	            local.definition = definition.getTextTrim();//ע�⣬Ҫȥ���ո�
	            Iterator iterItems = localElement.element(ITEMS_2).elementIterator(ITEMVALUE_3);
	            Map itemvalue = new LinkedHashMap();
	            while( iterItems.hasNext() ){
	            	Element item = (Element)iterItems.next();
	            	itemvalue.put( item.attribute(ITEMVALUE_3_CODE).getValue() ,item.getTextTrim() );
	            }
	            local.items = itemvalue;
	            localMap.put(local.definition, local);
	            log.info("loaded local syscode :" + local.definition );
	        }

		} catch (DocumentException e) {
			log.fatal("code2name config init error", e);
			e.printStackTrace();
		}
	}
}
