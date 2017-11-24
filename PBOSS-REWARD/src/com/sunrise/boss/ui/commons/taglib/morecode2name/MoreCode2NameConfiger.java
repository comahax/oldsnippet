package com.sunrise.boss.ui.commons.taglib.morecode2name;

import java.beans.PropertyDescriptor;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.sunrise.boss.common.base.db.BaseListVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.utils.sysinfo.SysInfo;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.ui.commons.User;


public class MoreCode2NameConfiger {

	private static final Logger log = Logger.getRootLogger();

	static HashMap sysMap;
	static HashMap localMap;
	static HashMap dictMap;

	static {
		init(); 
	}

	
	
	public static HashMap getDictMap() {
		return dictMap;
	}


	public static HashMap getLocalMap() {
		return localMap;
	}


	public static HashMap getSysMap() {
		return sysMap;
	}


	/**
	 * 根据配置文件读取list
	 * @param definition
	 * @param dbFlag
	 * @return
	 * @throws Exception
	 */
	public static Map valueList(String definition,
			String dbFlag) throws Exception {
		return valueList(definition,null, dbFlag);
	}
	
	
	public static DataPackage valueList(String definition, String condition,
			String dbFlag, BaseListVO baseListvo) throws Exception {
		return valueList(definition,condition,dbFlag, baseListvo,false);
	}
	
	public static DataPackage valueList(String definition, String condition,
			String dbFlag, BaseListVO baseListvo,boolean isGetAll) throws Exception {
		
		if( localMap.containsKey(definition) ){
			LocalNode localcode = (LocalNode) localMap.get(definition);
			Map items = localcode.getItems();
			Object[] keys = items.keySet().toArray();
			List newlist = new ArrayList();
			for( int i=keys.length-1; i>=0;i-- ){
				Node node = new Node();
				node.setCode( keys[i].toString() );
				node.setName( items.get(keys[i]).toString() );
				newlist.add( node );
			}	
			DataPackage dp = new DataPackage();
			dp.setRowCount( newlist.size() );
			dp.setDatas( newlist );
			
			dp.setPageNo(Integer.valueOf(baseListvo.get_pageno()).intValue());
			dp.setPageSize(Integer.valueOf(baseListvo.get_pagesize()).intValue());
			return dp;
		}
		else if (sysMap.containsKey(definition)) {
			Node node = (Node) sysMap.get(definition);
			
			String voClassName = node.getValueObject();
			String codeProperty = node.getCode();
			String nameProperty = node.getName();
			
			Class voClass = Class.forName(voClassName);
			CommonDelegate commonDelegate = new CommonDelegate(voClass);
			BaseListVO listVO = new BaseListVO();
			BeanUtils.copyProperties( listVO , baseListvo );
			if(isGetAll) listVO.set_pagesize("0");			
			
			if(log.isInfoEnabled()) log.info("options filter " + condition); 
			if(StringUtils.isNotEmpty(condition)) {
				try {
					if(null != condition && !"".equals(condition)){
						String filters[] = condition.split(";");
						for (int i = 0; i < filters.length; i++) {
							String filterPairString = filters[i];
							String[] filterPairArray = filterPairString.split(":");
							
							String conditionName = filterPairArray[0];
							String conValue = null;
							if(filterPairArray.length >1 )
								conValue = filterPairArray[1];
							
							String conditionString = getConditionString(voClass, conditionName,conValue);
							Object conditionValue = castConditionValue(voClass,conditionName, conValue);
							
							listVO.getQueryConditions().put(conditionString, conditionValue);
						}
					}
				} catch (Exception e) {			
					e.printStackTrace();
					if(log.isEnabledFor(Level.ERROR))
						log.error("Invalid filter param. ", e);
				}
			}
			User user =new User();
            if(dbFlag==null||dbFlag.trim().length()<1){
            	dbFlag = SysInfo.COMMON_DB_FLAG;
            }
			user.setCityid(dbFlag);
			
			DataPackage dp = commonDelegate.doQuery(listVO, user);
			if( null != dp && null != dp.getDatas() && dp.getDatas().size() > 0 ){
				Iterator iter = dp.getDatas().iterator();
				List list = new ArrayList();
				while( iter.hasNext() ){
					Object item = iter.next();
					Node thisnode = new Node();
					thisnode.setCode( BeanUtils.getProperty(item,codeProperty) );
					thisnode.setName( BeanUtils.getProperty(item,nameProperty) );
					list.add(thisnode);
				}
                dp.setDatas(list);
			}
			
			return dp;
		} else {
			return new DataPackage();
		}
	}
	
	
	/**
	 * isKeyString 参数true存入map的key类型为字符串
	 * mys
	 */
	public static Map valueList(String definition, String condition,	String dbFlag,boolean isKeyString) throws Exception {
		if( localMap.containsKey(definition) ){
			LocalNode localcode = (LocalNode) localMap.get(definition);
			return localcode.getItems();
		}
		else if (sysMap.containsKey(definition)) {
			Node node = (Node) sysMap.get(definition);
			
			String voClassName = node.getValueObject();
			String codeProperty = node.getCode();
			String nameProperty = node.getName();
			
			Class voClass = Class.forName(voClassName);
			CommonDelegate commonDelegate = new CommonDelegate(voClass);
			BaseListVO listVO = new BaseListVO();
			listVO.set_pagesize("0");			
			
			if(log.isInfoEnabled()) log.info("options filter " + condition); 
			if(StringUtils.isNotEmpty(condition)) {
				try {
					if(null != condition && !"".equals(condition)){
						String filters[] = condition.split(";");
						for (int i = 0; i < filters.length; i++) {
							String filterPairString = filters[i];
							String[] filterPairArray = filterPairString.split(":");
							if(null != filterPairString && !"".equals(filterPairString) 
									&& null != filterPairArray[0] && !"".equals(filterPairArray[0]) ){
								String conditionName = filterPairArray[0];
								String conValue = null;
								if(filterPairArray.length >1 )
									conValue = filterPairArray[1];
								
								String conditionString = getConditionString(voClass, conditionName,conValue);
								Object conditionValue = castConditionValue(voClass,conditionName, conValue);
								
								listVO.getQueryConditions().put(conditionString, conditionValue);
							}
						}
					}
					
					
				} catch (Exception e) {			
					e.printStackTrace();
					if(log.isEnabledFor(Level.ERROR))
						log.error("Invalid filter param. ", e);
				}
			}
			User user = new User();
            if(dbFlag==null||dbFlag.trim().length()<1){
            	dbFlag = SysInfo.COMMON_DB_FLAG;
            }
			user.setCityid(dbFlag);
			
			List data = (List)commonDelegate.doQuery(listVO, user).getDatas();
			Map maplist = new LinkedHashMap();
			for(int i= 0; i< data.size() ; i++) {
				Object object = data.get(i);	
				Object ob=PropertyUtils.getProperty(object, nameProperty);
				String nameValue="";
				if(ob instanceof Long){
					nameValue=((Long)ob).toString();
				}else{
				nameValue = (String)ob;
				}
				Object value = PropertyUtils.getProperty(object, codeProperty);
				
				if(isKeyString){
					maplist.put(value.toString() , nameValue);
				}else{
					maplist.put(value, nameValue);
				}
			}
            data.clear();
            return maplist;
			
		} else {
			return new HashMap();
		}
	}
	
	public static Map valueList(String definition, String condition,	String dbFlag) throws Exception {		
		return valueList(definition,condition,dbFlag,false);
	}

	/**
	 * 根据字段类型,对字符型字段值进行转换
	 * @param voClass
	 * @param field
	 * @param conValue
	 * @return
	 * @throws Exception
	 */
	public static Object castConditionValue(Class voClass, String field, String conValue) throws Exception {
		
		try {
			
			if( field.indexOf("_sk_") == 0 ) {
				field = field.substring(4);
			}
			
			Object obj = voClass.newInstance();
			PropertyDescriptor descriptor = PropertyUtils.getPropertyDescriptor(obj, field);
			Class pType = descriptor.getPropertyType();
			if(pType == String.class)
				return conValue == null ? "" : conValue;
			else if( Long.class.equals(pType) || (pType.isPrimitive() && pType.getName().equals("long") ))
				return  conValue == null ? new Long(0) : new Long(conValue);
			else if( Integer.class.equals(pType) || (pType.isPrimitive() && pType.getName().equals("integer") ))
				return conValue == null ? new Integer(0) : new Integer(conValue);
			else if( Short.class.equals(pType) || (pType.isPrimitive() && pType.getName().equals("short") ))
				return conValue == null ? new Short("0") : new Short(conValue);	
			else
				throw new IllegalArgumentException("Unsupport type of condition field " + field + ".Require String, Long, Short, Integer type."  );
			
		} catch (Exception e) {			 
			throw e;
		}
	}

	public static String getConditionString(Class voClass,String field,String vlalue) throws Exception {
		try {
			
			if( field.indexOf("_sk_") == 0 ) {
				return field;
			}
			
			Object obj = voClass.newInstance();
			PropertyDescriptor descriptor = PropertyUtils.getPropertyDescriptor(obj, field);
			Class pType = descriptor.getPropertyType();
			
			
			String prefix = "";
			if(pType == String.class)
				prefix =  vlalue == null ? "_sn_" : "_se_" ;
			else if( Number.class.isAssignableFrom(pType))
				prefix =  vlalue == null ? "_nn_" : "_ne_";
			else if(pType.isPrimitive() && pType.getName().equals("long") || pType.getName().equals("integer") || pType.getName().equals("short"))
				prefix =  vlalue == null ? "_nn_" : "_ne_";	
			else
				throw new IllegalArgumentException("Unsupport type of condition field " + field + ".Require String, Long, Short, Integer type."  );
			return prefix + field;
		} catch (Exception e) {			
			throw e;
		}
	}
	
	
	public static void getCondition(String condition,Class voClass,BaseListVO listVO){
		if(StringUtils.isNotEmpty(condition)) {
			try {
				if(null != condition && !"".equals(condition)){
					String filters[] = condition.split(";");
					for (int i = 0; i < filters.length; i++) {
						String filterPairString = filters[i];
						String[] filterPairArray = filterPairString.split(":");
						
						String conditionName = filterPairArray[0];
						String conValue = null;
						if(filterPairArray.length >1 )
							conValue = filterPairArray[1];
						
						String conditionString = getConditionString(voClass, conditionName,conValue);
						Object conditionValue = castConditionValue(voClass,conditionName, conValue);
						
						listVO.getQueryConditions().put(conditionString, conditionValue);
					}
				}
			} catch (Exception e) {			
				e.printStackTrace();
				if(log.isEnabledFor(Level.ERROR))
					log.error("Invalid filter param. ", e);
			}
		}
	}
	
	public static String getCodeProperty( String definition ) throws Exception {
		Node node = (Node) sysMap.get(definition);
		return node.getCode();
	}
	
	public static String getNameProperty( String definition ) throws Exception {
		Node node = (Node) sysMap.get(definition);
		return node.getName();
	}
	
	
	/**
	 * 取自定义字典表的全选翻译名
	 * 
	 * @param definition
	 * @return 全选的翻译名
	 */
	public static String getDictAllNameProperty(String definition) throws Exception {
		DictNode dictnode = (DictNode) dictMap.get("dict");
		if (dictnode.getValue(definition) != null) {
			String[] obj = dictnode.getValue(definition).split("\\|");
			return obj[1];
		}
		return null;
	}

	/**
	 * 取自定义字典表的全选code
	 * @param definition
	 * @return 全选的code
	 */
	public static String getDictAllCodeProperty( String definition ) throws Exception {
		DictNode dictnode= (DictNode)dictMap.get("dict");
		if(null != dictnode.getValue(definition)){
			String[] obj = dictnode.getValue(definition).split("\\|");
			return obj[0];
		}
		return null ;
	}
	
	/**
	 * 取自定义的全选翻译名
	 * @param definition
	 * @return 全选的翻译名
	 */
	public static String getAllNameProperty( String definition ) throws Exception {
		
		if( localMap.containsKey(definition) ){
			LocalNode localnode= (LocalNode)localMap.get(definition);
			return localnode.getAllname();
		}
		else if (sysMap.containsKey(definition)) {
			Node node= (Node)sysMap.get(definition);
			return node.getAllname();
		}
	
		return null;
	}
	
	/**
	 * 取自定义的全选code
	 * @param definition
	 * @return 全选的code
	 */
	public static String getAllCodeProperty( String definition ) throws Exception {
		
		if( localMap.containsKey(definition) ){
			LocalNode localnode= (LocalNode)localMap.get(definition);
			return localnode.getAllcode();
		}
		else if (sysMap.containsKey(definition)) {
			Node node= (Node)sysMap.get(definition);
			return node.getAllcode();
		}
	
		return null;
	}
	
	
	
	// 下面注释描述的层是XML文件里面嵌套的层次
	final static String SYSCODE_CONFIG_0 = "syscode-config";// 第零层

	final static String SYSCODE_DYNAMIC_1 = "syscode-dynamic"; // 第一层

	final static String SYSCODE_LOCAL_1 = "syscode-local"; // 第一层
	
	final static String SYSCODE_DICT_1 = "syscode-dict"; // 第一层

	
	final static String VALUE_OBJECT_2 = "value-object"; // 第二层
	final static String DEFINITION_2 = "definition"; // 第二层
	final static String CODE_2 = "code"; // 第二层
	final static String NAME_2 = "name"; // 第二层	
	final static String ALLCODE_2 = "allcode"; // 第二层	
	final static String ALLNAME_2 = "allname"; // 第二层
	
	
	
	final static String ITEMS_2 = "items";// 第二层
	final static String ITEMVALUE_3 = "itemvalue";// 第三层
	final static String ITEMVALUE_3_CODE = "code";// 第三层itemvalue的属性
	
	final static String ITEMVALUE_2 = "itemvalue"; // 第二层
	final static String ITEMVALUE_3_DEFINITION = "definition"; // 第三层itemvalue的属性
	
	private static void init() {
		sysMap = new HashMap();

		SAXReader saxReader = new SAXReader();
		try {
			InputStream in = MoreCode2NameConfiger.class.getResourceAsStream(SysInfo.MORECODE2NAME_FILE_PATH);
			Document document = saxReader.read(in);

			List dynamicList = document.selectNodes(SYSCODE_CONFIG_0 + "/" + SYSCODE_DYNAMIC_1);
			Iterator iter = dynamicList.iterator();
			while (iter.hasNext()) {
				Element ele = (Element) iter.next();
				String key = ele.element(DEFINITION_2).getStringValue().trim(); //注意，要去除空格
				Node node = new Node();
				node.setValueObject(ele.element(VALUE_OBJECT_2).getStringValue().trim());
				node.setCode(ele.element(CODE_2).getStringValue().trim());
				node.setName(ele.element(NAME_2).getStringValue().trim());
				if(null != ele.element(ALLCODE_2) && !"".equals(ele.element(ALLCODE_2))){
					node.setAllcode(ele.element(ALLCODE_2).getStringValue().trim());
				}
				if(null != ele.element(ALLNAME_2) && !"".equals(ele.element(ALLNAME_2))){
					node.setAllname(ele.element(ALLNAME_2).getStringValue().trim());
				}

				sysMap.put(key, node);
			}
			
			
			
			List locallist = document.selectNodes(SYSCODE_CONFIG_0 + "/" + SYSCODE_LOCAL_1);
			localMap = new HashMap();
	        Iterator iterl = locallist.iterator();
	        while(iterl.hasNext()){
	            Element localElement = (Element)iterl.next();
	            LocalNode local = new LocalNode();
	            Element definition = localElement.element(DEFINITION_2);
	            local.definition = definition.getTextTrim();//注意，要去除空格
	            
	            if(null != localElement.element(ALLCODE_2) && !"".equals(localElement.element(ALLCODE_2))){
	            	local.setAllcode(localElement.element(ALLCODE_2).getStringValue().trim());
				}
				if(null != localElement.element(ALLNAME_2) && !"".equals(localElement.element(ALLNAME_2))){
					local.setAllname(localElement.element(ALLNAME_2).getStringValue().trim());
				}
	            
	            Iterator iterItems = localElement.element(ITEMS_2).elementIterator(ITEMVALUE_3);
	            Map itemvalue = new HashMap();
	            while( iterItems.hasNext() ){
	            	Element item = (Element)iterItems.next();
	            	itemvalue.put( item.attribute(ITEMVALUE_3_CODE).getValue(),item.getTextTrim() );
	            }
	            local.items = itemvalue;
	            localMap.put(local.definition, local);
	            log.info("loaded local syscode :" + local.definition );
	        }

	        
	        List dictlist = document.selectNodes(SYSCODE_CONFIG_0 + "/" + SYSCODE_DICT_1);
	        dictMap = new HashMap();
	        Iterator iter2 = dictlist.iterator();
	        if(iter2.hasNext()){
	            Element localElement = (Element)iter2.next();
	            DictNode dict = new DictNode();
	            
	            Iterator iterItems = localElement.elementIterator(ITEMVALUE_2);
	            Map itemvalue = new HashMap();
	            while( iterItems.hasNext() ){
	            	Element item = (Element)iterItems.next();
	            	itemvalue.put( item.attribute(ITEMVALUE_3_DEFINITION).getValue(),item.getTextTrim() );
	            }
	            dict.dictItems = itemvalue;	  
	            dictMap.put("dict",dict);
	            log.info("loaded dict syscode !");
	        }
		} catch (DocumentException e) {
			log.fatal("code2name config init error", e);
			e.printStackTrace();
		}

	}
	
	
}
