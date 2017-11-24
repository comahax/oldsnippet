package com.sunrise.boss.delegate.resmanage.common.tag;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.sunrise.boss.business.resmanage.common.pubdef.ResConstant;

public class ResCommonChkConfig {
	private static final Logger log = Logger.getRootLogger();
	private static Map dtMap = new HashMap();
	
	final static String DELEGATES_0 = "delegates";
	final static String DELEGATE_1 = "delegate";
	final static String DELEGATE_1_ID = "id"; 
	final static String DELEGATE_1_CLASS = "class"; 	
	final static String METHOD_2 = "method";	
	final static String METHOD_2_NAME = "name"; 
	final static String PARAM_3 = "param";
	final static String PARAM_3_NAME = "name";
	final static String PARAM_3_TYPE = "type";
	
	static {
		init();
	}
	
	private static void init() {
		SAXReader saxReader = new SAXReader();
		try {
			URL url = ResCommonChkConfig.class.getResource(ResConstant.RESCOMMONCHK_FILE_PATH);
			Document document = saxReader.read(url);
			List entList = document.selectNodes(DELEGATES_0 + "/" + DELEGATE_1);
			Iterator iter = entList.iterator();
			while (iter.hasNext()) {
				Node node = new Node();
				Element dtElem = (Element) iter.next();
				String dtCls = dtElem.attribute(DELEGATE_1_CLASS).getValue();
				String id = dtElem.attribute(DELEGATE_1_ID).getValue();
				node.setDelegateCls(dtCls);
				Element methodElem = dtElem.element(METHOD_2);
				String methodName = methodElem.attribute(METHOD_2_NAME).getValue();
				node.setMethodName(methodName);
				
				Iterator paramIter =  methodElem.elementIterator(PARAM_3);
				List paramList = new ArrayList();
				if (paramIter != null){
					 while (paramIter.hasNext()){
						 Element paramElem = (Element)paramIter.next();
						 String paramname = paramElem.attributeValue(PARAM_3_NAME);
						 String value = paramElem.getTextTrim();
						 String type = paramElem.attributeValue(PARAM_3_TYPE);
						 paramList.add(node.new ParamInfo(paramname,value,type));
					 }
				}
				 node.setParamInfos(paramList);
				 dtMap.put(id, node);
			}
		}catch(Exception e){
			log.fatal("rescommonchk config init error", e);
			e.printStackTrace();
		}
	}
	
	public static Object getDtObj(String dtId){
		try {
			if (dtMap.containsKey(dtId)){
				Node node = (Node)dtMap.get(dtId);
				return (Class.forName(node.getDelegateCls())).newInstance();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null;
	}
	
	public static String getMethodName(String dtId){
		if (dtMap.containsKey(dtId)){
			Node node = (Node)dtMap.get(dtId);
			return node.getMethodName();
		}
		return null;
	}
	
	public static List getParamInfos(String dtId){
		if (dtMap.containsKey(dtId)){
			Node node = (Node)dtMap.get(dtId);
			return node.getParamInfos();
		}
		return null;
	}
}
