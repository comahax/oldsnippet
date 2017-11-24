package com.sunrise.boss.ui.commons.taglib.code2name;

import java.beans.PropertyDescriptor;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
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
import com.sunrise.boss.delegate.admin.code2name.Code2NameDelegate;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.ui.commons.User;

/**
 * Code2Name的进化版,由于Code2NameConfiger的所有方法都为static静态方法,无法继承重写,所以用该类
 * 继承父类只是做一个标识而已
 * 优化:
 * 1.可以实现condition的多条件过滤
 * @author Canigar
 *
 */
public class Code2NameConfigerII extends Code2NameConfiger{

	private static final Logger log = Logger.getRootLogger();

	static HashMap sysMap;
	static HashMap localMap;

	static {
		init();
	}

	/**
	 * 根据类型definition和代码code查相应的翻译
	 * @param definition 类型
	 * @param codeValue  code值
	 * @param dbFlag     数据库标识
	 * @return           翻译
	 * @throws Exception
	 */
	public static Object getName(String definition, Object codeValue,
			String dbFlag) throws Exception {
		Code2NameDelegate code2NameDelegate = new Code2NameDelegate();
		if( localMap.containsKey(definition) ){
			LocalNote localcode = (LocalNote) localMap.get(definition);
			return localcode.getValue(codeValue.toString());
		}
		else if (sysMap.containsKey(definition)) {
			Node node = (Node) sysMap.get(definition);
            if(dbFlag==null||dbFlag.trim().length()<1){
            	dbFlag = SysInfo.COMMON_DB_FLAG;
            }
			return code2NameDelegate.translateCode(node.getValueObject(), node
					.getCode(), node.getName(), codeValue, dbFlag);
		} else {
			return codeValue;
		}
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
		
		if( localMap.containsKey(definition) ){
			LocalNote localcode = (LocalNote) localMap.get(definition);
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
			//listVO.set_pagesize("0");			
			
			if(log.isInfoEnabled()) log.info("options filter " + condition); 
			if(StringUtils.isNotEmpty(condition)) {
				try {
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
					
				} catch (Exception e) {			
					e.printStackTrace();
					if(log.isEnabledFor(Level.ERROR))
						log.error("Invalid filter param. ", e);
				}
			}
			
            User usr = new User();
            if(dbFlag==null||dbFlag.trim().length()<1){
            	dbFlag = SysInfo.COMMON_DB_FLAG;
            }
            usr.setCityid(dbFlag);
            listVO.set_orderby(getCodeProperty(definition));
            listVO.set_desc("0");
			DataPackage dp = commonDelegate.doQuery(listVO, usr);
			if( dp.getDatas().size() > 0 ){
				Iterator iter = dp.getDatas().iterator();
				List list = new ArrayList();
				while( iter.hasNext() ){
					Object item = iter.next();
					Node thisnode = new Node();
					thisnode.setCode( BeanUtils.getProperty(item,codeProperty) );
					thisnode.setName( BeanUtils.getProperty(item,nameProperty) );
					list.add( thisnode );
				}
                dp.getDatas().clear();
                dp.setDatas( list );
			}
			
			return dp;
		} else {
			return new DataPackage();
		}
	}
	
	public static Map valueList(String definition, String condition,	String dbFlag) throws Exception {
		
		if( localMap.containsKey(definition) ){
			LocalNote localcode = (LocalNote) localMap.get(definition);
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
					
				} catch (Exception e) {			
					e.printStackTrace();
					if(log.isEnabledFor(Level.ERROR))
						log.error("Invalid filter param. ", e);
				}
			}

            Map maplist = new LinkedHashMap();
            User usr = new User();
            if(dbFlag==null||dbFlag.trim().length()<1){
            	dbFlag = SysInfo.COMMON_DB_FLAG;
            }
            usr.setCityid(dbFlag);
            int count = commonDelegate.doCount(listVO, usr);
            if (count <= 30) {
                List data = (List)commonDelegate.doQuery(listVO, usr).getDatas();
                for(int i= 0; i< data.size() ; i++) {
                    Object object = data.get(i);
                    Object ob=PropertyUtils.getProperty(object, nameProperty);
                    String nameValue="";
                    if(ob instanceof Long){
                        nameValue=((Long)ob).toString();
                    }else if(ob instanceof Integer){
                    	nameValue=((Integer)ob).toString();
                    }else{
                    nameValue = (String)ob;
                    }
                    Object value = PropertyUtils.getProperty(object, codeProperty);

                    maplist.put(value , nameValue);
                }
            } else {
                maplist.put("error", "Too More！");
            }
            return maplist;
		} else {
			return new HashMap();
		}
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
			
			if( field.indexOf("_") == 0 ) {
//				int ix2 = field.substring(1).indexOf("_");
//				if( ix2 > 0) {
//					String fd = field.substring(1).substring(ix2 + 1);
//					return fd;
//				}
				return conValue;
			}
			
			Object value = null;
			if(conValue.indexOf(",") != -1){
				String[] values = StringUtils.split(conValue.replaceAll("\\*", "\\%"), ",");
				int regFlag = 0;
				for(int i=0;i<values.length;i++){
					if(values[i].startsWith("!")){
						regFlag++;
					}
				}
				if(regFlag == 0 || regFlag == values.length){
					conValue = conValue.replaceAll("!", "");
					String[] conValues = StringUtils.split(conValue.replaceAll("\\*", "\\%"), ",");
					return value = Arrays.asList(conValues);
				}
			}
			
			Object obj = voClass.newInstance();
			PropertyDescriptor descriptor = PropertyUtils.getPropertyDescriptor(obj, field);
			Class pType = descriptor.getPropertyType();
			if(pType == String.class)
				value = conValue == null ? "" : conValue;
			else if( Number.class.isAssignableFrom(pType))
				value =  conValue == null ? new Long(0) : new Long(conValue);
			else if(pType.isPrimitive() && pType.getName().equals("long") || pType.getName().equals("integer") || pType.getName().equals("byte") || pType.getName().equals("short"))
				value = conValue == null ? new Integer(0) : new Integer(conValue);
			else
				throw new IllegalArgumentException("Unsupport type of condition field " + field + ".Require String, Long, Integer type."  );

			//add List type   by Canigar
			return value;
			
		} catch (Exception e) {
			throw e;
		}
	}

	private static String getConditionString(Class voClass,String field,String vlalue) throws Exception {
		try {
			if( field.indexOf("_") == 0 ) {
				return field;
			}
//			if( field.indexOf("_sk_") == 0 ) {
//				return field;
//			}
//			
//			if( field.indexOf("_nne_") == 0 || field.indexOf("_sne_") == 0 || field.indexOf("_sne_") == 0 ) {
//				return field;
//			}

			Object obj = voClass.newInstance();
			PropertyDescriptor descriptor = PropertyUtils.getPropertyDescriptor(obj, field);
			Class pType = descriptor.getPropertyType();

			String prefix = "";
//			add List type   by Canigar
			if(vlalue.indexOf(",") != -1){
				String[] values = StringUtils.split(vlalue, ",");
				int regFlag = 0;
				for(int i=0;i<values.length;i++){
					if(values[i].startsWith("!")){
						regFlag++;
					}
				}
				if(regFlag == 0){
					//prefix = prefix.substring(0,2);
					prefix = prefix + "_skin_";
				}else if(regFlag == values.length){
					//prefix = prefix.substring(0,2);
					prefix = prefix + "_sknin_";
				}
				return prefix + field;
			}
			
			if(pType == String.class)
				prefix =  vlalue == null ? "_sn_" : "_se_" ;
			else if( Number.class.isAssignableFrom(pType))
				prefix =  vlalue == null ? "_nn_" : "_ne_";
			else if(pType.isPrimitive() && pType.getName().equals("long") || pType.getName().equals("integer") || pType.getName().equals("byte") || pType.getName().equals("short"))
				prefix =  vlalue == null ? "_nn_" : "_ne_";		
			else
				throw new IllegalArgumentException("Unsupport type of condition field " + field + ".Require String, Long, Integer type."  );
			return prefix + field;
			
		} catch (Exception e) {			
			throw e;
		}
	}
	
	public static String getCodeProperty( String definition ) throws Exception {
		Node node = (Node) sysMap.get(definition);
		//if( )
		return node.getCode();
	}
	
	public static String getNameProperty( String definition ) throws Exception {
		Node node = (Node) sysMap.get(definition);
		return node.getName();
	}
	
	// 下面注释描述的层是XML文件里面嵌套的层次
	final static String SYSCODE_CONFIG_0 = "syscode-config";// 第零层

	final static String SYSCODE_DYNAMIC_1 = "syscode-dynamic"; // 第一层

	final static String SYSCODE_LOCAL_1 = "syscode-local"; // 第一层

	final static String DEFINITION_2 = "definition"; // 第二层

	final static String VALUE_OBJECT_2 = "value-object"; // 第二层

	final static String CODE_2 = "code"; // 第二层

	final static String NAME_2 = "name"; // 第二层
	
	final static String ITEMS_2 = "items";// 第二层
	
	final static String ITEMVALUE_3 = "itemvalue";// 第三层

	final static String ITEMVALUE_3_CODE = "code";// 第三层itemvalue的属性
	
	private static void init() {
		sysMap = new HashMap();

		SAXReader saxReader = new SAXReader();
		try {
			InputStream in = Code2NameConfiger.class.getResourceAsStream(SysInfo.CODE2NAME_FILE_PATH);
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
				sysMap.put(key, node);
			}
			
			List locallist = document.selectNodes(SYSCODE_CONFIG_0 + "/" + SYSCODE_LOCAL_1);
			localMap = new HashMap();
	        Iterator iterl = locallist.iterator();
	        while(iterl.hasNext()){
	            Element localElement = (Element)iterl.next();
	            LocalNote local = new LocalNote();
	            Element definition = localElement.element(DEFINITION_2);
	            local.definition = definition.getTextTrim();//注意，要去除空格
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

		} catch (DocumentException e) {
			log.fatal("code2name config init error", e);
			e.printStackTrace();
		}

	}
	
	
}
