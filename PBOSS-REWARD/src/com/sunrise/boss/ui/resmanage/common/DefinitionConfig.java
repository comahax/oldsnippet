package com.sunrise.boss.ui.resmanage.common;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.sunrise.boss.business.resmanage.common.pubdef.ResConstant;

public class DefinitionConfig {
	private static final Logger log = Logger.getRootLogger();

	public static HashMap entMap;

	static {
		init();
	}
	
//	 ����ע�������Ĳ���XML�ļ�����Ƕ�׵Ĳ��
	final static String DEFINITION_CONFIG_0 = "definition-config";// �����

	final static String ENTITY_1 = "entity"; // ��һ��
	
	final static String ENTITY_1_NAME = "name"; // ��һ���name����
	
	final static String DELEGATE_2 = "delegate"; // �ڶ���
	
	final static String DEFINITION_2 = "definition"; // �ڶ���

	final static String PROPERTY_2 = "property"; // �ڶ���

	final static String PROPERTY_2_NAME = "name"; // �ڶ���property��name����

	final static String DEPENDENT_3 = "dependent"; // ������

	final static String DEPENDENT_3_NAME = "name"; // ������dependent��name����

	final static String CASE_4 = "case"; // ���Ĳ�
	
	final static String CASE_4_OPRTYPE = "oprtype";// ���Ĳ�case��oprtype����
	
	final static String CASE_4_VALUE = "value";// ���Ĳ�case��value����
	
	private static void init() {
		entMap = new HashMap();
		Map defMap = new HashMap();

		SAXReader saxReader = new SAXReader();
		try {
			InputStream in = DefinitionConfig.class.getResourceAsStream(ResConstant.DEFINITION_FILE_PATH);
			Document document = saxReader.read(in);
			
			List entList = document.selectNodes(DEFINITION_CONFIG_0 + "/" + ENTITY_1);
			Iterator iter = entList.iterator();
			while (iter.hasNext()) {
				Element ele = (Element) iter.next();
				String voName = ele.attribute(ENTITY_1_NAME).getValue();
				String delegateName = "";
				Element delegateEle = ele.element(DELEGATE_2);
				if (delegateEle != null){
					delegateName = delegateEle.getTextTrim();
					entMap.put(voName, delegateName);
				}
				 List propertyList = ele.elements(PROPERTY_2);
				 Iterator iterPro = propertyList.iterator();
				 while (iterPro.hasNext()){
					 Element elem = (Element)iterPro.next();
					 String propertyName = elem.attributeValue(PROPERTY_2_NAME);
					 Element defElem = elem.element(DEFINITION_2);
					 if (defElem != null){
						 String definition = defElem.getTextTrim();
						 entMap.put(voName+"_"+propertyName, definition);
					 }else {
						 Element depentEle = elem.element(DEPENDENT_3);
						 String dependentName = depentEle.attributeValue(DEPENDENT_3_NAME);
						 if ("#".equals(dependentName)){
							 dependentName = propertyName;
						 }
						 Iterator caseIter = depentEle.elementIterator(CASE_4);
						 
						 while (caseIter.hasNext()){
							 Element caseItem = (Element)caseIter.next();
							 String oprtype = caseItem.attributeValue(CASE_4_OPRTYPE);
							 String value = caseItem.attributeValue(CASE_4_VALUE);
							 String definition = caseItem.getTextTrim();
							 defMap.put(dependentName+oprtype+value, definition);
							 defMap.put("dependentName", dependentName);
						 }
						 entMap.put(voName+"_"+propertyName, defMap);
					 }
				 }
			}
		} catch (DocumentException e) {
			log.fatal("definition config init error", e);
			e.printStackTrace();
		}

	}
}
