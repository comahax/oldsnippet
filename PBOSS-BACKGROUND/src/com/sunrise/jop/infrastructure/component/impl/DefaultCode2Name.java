package com.sunrise.jop.infrastructure.component.impl;

import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.collections.map.LinkedMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sunrise.jop.business.system.config.code2name.control.Code2NameBO;
import com.sunrise.jop.business.system.config.code2name.control.Code2NameControl;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.infrastructure.component.Code2Name;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DBQueryParam;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * ��Ҫ�ȶ�ȡcode2name �����ã� ������Ҫ���������ֵ䣬��̬VO���͹̶����������������
 * ������Ҫ�� echcache-config.xml ����������������������ǵ�ʱ����Ʋ����ǲ�ͨ��
 * �����ֵ� ��Чʱ��6Сʱ
 * ��̬VO    �����̼߳�����
 * �̶�����   ���û���
*/
public class DefaultCode2Name implements Code2Name {
	
	private static Log log = LogFactory.getLog("com.sunrise.jop.code2name");
	
	public DefaultCode2Name() {	 	
	}
	
	/**
	 * ����ת��Ϊ����
	 * @param definition  code2name.xml ����Ŀ������
	 * @param codeName
	 * @param nameName
	 * @param codeValue
	 * @return ����
	 */
	public String code2Name(String def, String codeValue,String dbFlag) {
		
		if(codeValue == null) return "";
		String definition = formateDefinition(def);	
		
		try{
			if (def.startsWith("#")) {  
				//��̬���ݣ�����VO��ѯ //Code2NameConfiger.sysMap.containsKey(definition)
				// ����������ֵ������ ��Ҫ�� code2name.xml �������ֵ�VO
				Node node = (Node) Code2NameConfiger.sysMap.get(definition);
				
				if(node == null)
					throw new NullPointerException("Can't find code2name definition " + def);
				Code2NameControl code2NameControl = (Code2NameControl) BOFactory.build(Code2NameBO.class,DBAccessUser.getInnerUser()) ;
	            String value = (String)code2NameControl.doTranslateCode(node.getValueObject(), node
	    					.getCode(), node.getName(), codeValue, dbFlag);
	           
	            if(log.isDebugEnabled())
	            	log.debug("[code2name dictitem]#code:" + codeValue +",value:" + value + ",dbFlag:" + dbFlag);
	           return value;
	           
			}else if(def.startsWith("$") ) {
				
				Node node = (Node) Code2NameConfiger.sysMap.get("$");
				if(node == null)
					throw new NullPointerException("Can't find code2name definition " + def);
				
				Code2NameControl code2NameControl = (Code2NameControl) BOFactory.build(Code2NameBO.class,DBAccessUser.getInnerUser()) ;		
	            String value = (String)code2NameControl.doTranslateCode(node.getValueObject(),definition, node
	    					.getCode(), node.getName(), codeValue, dbFlag);
	            
	            if(log.isDebugEnabled())
	            	log.debug("[code2name table]$code:" + codeValue +",value:" + value + ",dbFlag:" + dbFlag);
	            return value;
				
			}else	if( Code2NameConfiger.localMap.containsKey(definition) ){  //���õĹ̶�����		
				LocalNote localcode = (LocalNote) Code2NameConfiger.localMap.get(definition);
				
				if(localcode == null)
					throw new NullPointerException("Can't find code2name definition " + def);
				
				String value = localcode.getValue(codeValue.toString());
				if(log.isDebugEnabled())
	            	log.debug("[code2name configed]$code:" + codeValue +",value:" + value + ",dbFlag:" + dbFlag);
				
				return value;
			}else{
				if(log.isErrorEnabled())
					log.error("δ֪�� code2name definition " + definition);
				return codeValue;
			}
		}catch (Exception e) {
			if(log.isErrorEnabled()) 
				log.error("����ת��ʱ��������! " + e.getMessage(),e);
			return codeValue;
		}
	}
	
	/**
	 * ��ȡĳ���ֵ�������ݵ����п��ñ�������
	 * @param definition
	 * @param dbFlag
	 */
	public Map valueList(String definition, String dbFlag) {
		return valueList(definition,null, dbFlag);
	}
	
	public Map valueList(String def, String condition, String dbFlag) {	
		return valueList(def, condition, null,dbFlag);
	}
	
	public Map valueList(String def, String condition,DBQueryParam param, String dbFlag) {		
		String definition = formateDefinition(def);	
		Map values = null;
		try{
			if (def.startsWith("#") || def.startsWith("$")) {   
				//��̬���ݣ�����VO��ѯ //Code2NameConfiger.sysMap.containsKey(definition)
				// ����������ֵ������ ��Ҫ�� code2name.xml �������ֵ�VO
				//throw new IllegalArgumentException("�����ͱ����б��ѯ,��Ҫʹ�� pickerDialog�������ʹ�� valueListPackage ������" + def);
				DataPackage dp = valueListPackage(def, condition, param, dbFlag);

				Map maplist = new LinkedHashMap(dp.getDatas().size());
//				
//				//������ת��Ϊ map
				for(int i = 0 ; i < dp.getDatas().size() ; i++ ) {
					Node node = (Node) dp.getDatas().get(i);
					maplist.put(node.getCode(), node.getName());
				}
				
				return maplist;
				
			}else	if( Code2NameConfiger.localMap.containsKey(definition) ){  //���õĹ̶�����		
				LocalNote localcode = (LocalNote) Code2NameConfiger.localMap.get(definition);
				values = localcode.getItems();
				//��ӹ̶������Ĺ���,ֻ֧����CODE:?,?,?������ʽ
				if(!StringUtils.isEmpty(condition)){
					Map conditionMap = new LinkedMap();
					String code = condition;
					if(condition.indexOf(";") != -1){
						code = condition.substring(condition.indexOf("CODE"), condition.indexOf(";"));
					}
					String[] codeArray = StringUtils.split(code, ":");
					String[] codeValues = StringUtils.split(codeArray[1],",");
					for(int i=0;i<codeValues.length;i++){
						if(!StringUtils.isEmpty(values.get(codeValues[i]).toString())){
							conditionMap.put(codeValues[i], values.get(codeValues[i]));
						}
					}
					values = conditionMap;
				}
				
			}else{
				if(log.isErrorEnabled())
					log.error("δ֪�� code2name definition " + definition);				
			}
		}catch (Exception e) {
			if(log.isErrorEnabled()) 
				log.error("����ת��ʱ��������! " + e.getMessage(),e);
			
		}
		return values;
	}
	
	/**
	 * picker ��ҪDataPackage �͵����ݣ���������ҪMap�͵�����
	 */
	public DataPackage valueListPackage(String def, String condition,DBQueryParam param, String dbFlag ){
		
		if (!(def.startsWith("#") || def.startsWith("$")) ) {   
			throw new IllegalArgumentException("�ǵ����ͱ���������ֵ��ѯ����ʹ�� valueList ������" + def);
		}
		DataPackage dp = null;
		String definition = formateDefinition(def);
		try{
			//��̬���ݣ�����VO��ѯ //Code2NameConfiger.sysMap.containsKey(definition)
			// ����������ֵ������ ��Ҫ�� code2name.xml �������ֵ�VO
			Node node = null;
			if( def.startsWith("$")) 
				definition = "$"; //�����ֵ�
			
			node = (Node) Code2NameConfiger.sysMap.get(definition);
			if(node == null) 
				throw new IllegalArgumentException("Definition " + def + " not found in code2name.xml! Notice: if it's fixed param, use $" + definition +"!");
		
			String voClassName = node.getValueObject();
			String codeProperty = node.getCode();
			String nameProperty = node.getName();			
			
			Class voClass = Class.forName(voClassName);

			if(log.isInfoEnabled()) log.info("options filter:" + condition); 
			DBQueryParam listVO = convert2Param(voClass, condition, definition); //��condition�е�������ӵ���ѯ������
			
			//����ʼ�����ڲ�ѯ�����ϵ���������ҳ�룬pagesize�ȸ��ƹ�ȥ��
			if(param == null)
				param = listVO;
			else
				param.getQueryConditions().putAll(listVO.getQueryConditions());
			 
            if(StringUtils.isBlank(param.get_orderby()) )
            	param.set_orderby(getCodeProperty(definition));	//���û�����������У��򰴱���������
            if(StringUtils.isBlank(param.get_desc()) )
            	param.set_desc("0");						//���û����������ʽ������������
            
            
            Code2NameControl code2NameControl = (Code2NameControl) BOFactory.build(Code2NameBO.class, DBAccessUser.getInnerUser());
            
            if(StringUtils.isBlank(dbFlag)) {
            	dbFlag = DBAccessUser.getInnerUser().getCityid(); //���û������dbFlag����ȡuser�е�cityid
            }
			dp = null;
			if( def.startsWith("#")) 
				dp = code2NameControl.doValueListPackage(voClass, codeProperty, nameProperty, param, dbFlag);
			else //�����ֵ�
				dp = code2NameControl.doValueListPackage(formateDefinition(def) , codeProperty, nameProperty, param, dbFlag);
			
//			dp = commonControl.doQuery(param); //��ѯ
			if( dp.getDatas().size() > 0 ){
				Iterator iter = dp.getDatas().iterator();
				List list = new ArrayList(dp.getDatas().size());
				while( iter.hasNext() ){
					Object item = iter.next();
					Node thisnode = new Node();
					thisnode.setCode( String.valueOf( BeanUtils.getProperty(item,codeProperty)) );
					thisnode.setName( String.valueOf( BeanUtils.getProperty(item,nameProperty)) );
					list.add( thisnode );
				}
                dp.getDatas().clear();
                dp.setDatas( list );
			}
			
		}catch (Exception e) {
			if(log.isErrorEnabled()) 
				log.error("valueListPackage ִ��ʱ��������! " + e.getMessage(),e);
		}
		
		if(dp == null) {
			dp = new DataPackage();
			dp.setDatas(new ArrayList(0));
			dp.setRowCount(0);
		}
		return dp;
	}
	
	private String formateDefinition(String definition ) {
		if(definition.startsWith("$") || definition.startsWith("#")) {
			return definition.substring(1);
		}
		return definition;
	}
	
	private DBQueryParam convert2Param(Class voClass,String condition,String definition) {
		DBQueryParam param = new DBQueryParam();
		if(StringUtils.isNotBlank(condition)) {
			try {
				String filters[] = condition.split(";");
				for (int i = 0; i < filters.length; i++) {
					String filterPairString = filters[i];
					String[] filterPairArray = StringUtils.split(filterPairString, ":");
					
					String conditionName = filterPairArray[0];
					String conValue = null;
					if(filterPairArray.length >1 )
						conValue = filterPairArray[1];
					
					if("CODE".equals(conditionName)) {	//CODEҪת��Ϊ vo���Ӧ�ı���������
						conditionName = getCodeProperty(definition);
					}
					
					if("NAME".equals(conditionName)) {	//NAMEҪת��Ϊ vo���Ӧ�ı���������
						conditionName = getNameProperty(definition);
					}
					
					String conditionString = getConditionString(voClass, conditionName,conValue);
					Object conditionValue = castConditionValue(voClass,conditionName, conValue);
					
					param.getQueryConditions().put(conditionString, conditionValue);
				}
				
			} catch (Exception e) {
				if(log.isErrorEnabled()) log.error("Invalid filter param. ", e);
			}
		}
		return param;
	}
	/**
	 * �����ֶ�����,���ַ����ֶ�ֵ����ת��
	 * @param voClass
	 * @param field
	 * @param conValue
	 * @return
	 * @throws Exception
	 */
	public static Object castConditionValue(Class voClass, String field, String conValue) throws Exception {
		
		try {
			//by hekun, 2008-12-25, �޸İ������ֶβ�ѯ��bug��
			if(field.startsWith("_")) {
				return conValue;
			}
		
			Object value = null;
			Object obj = voClass.newInstance();
			PropertyDescriptor descriptor = PropertyUtils.getPropertyDescriptor(obj, field);
			Class pType = descriptor.getPropertyType();
			if(pType == String.class)
				value = conValue == null ? "" : conValue;
			else if( Number.class.isAssignableFrom(pType))
				value = conValue == null ? new Long(0) : new Long(conValue);
			else if(pType.isPrimitive() && pType.getName().equals("long") || pType.getName().equals("integer") || pType.getName().equals("byte") || pType.getName().equals("short"))
				value = conValue == null ? new Integer(0) : new Integer(conValue);
			else
				throw new IllegalArgumentException("Unsupport type of condition field " + field + ".Require String, Long, Integer type."  );
			
			
			//add List type   by Canigar
			if(conValue.indexOf(",") != -1){
				String[] values = StringUtils.split(conValue, ",");
				int regFlag = 0;
				for(int i=0;i<values.length;i++){
					if(values[i].startsWith("!")){
						regFlag++;
					}
				}
				if(regFlag == 0 || regFlag == values.length){
					conValue = conValue.replaceAll("!", "");
					String[] conValues = StringUtils.split(conValue, ",");
					value = Arrays.asList(conValues);
				}
			}
			
			return value;
		} catch (Exception e) {
			throw e;
		}
	}

	private static String getConditionString(Class voClass,String field,String vlalue) throws Exception {
		try {
//			by hekun, 2008-12-25, �޸İ������ֶβ�ѯ��bug��
			if(field.startsWith("_")) {
				return field;
			}

			Object obj = voClass.newInstance();
			PropertyDescriptor descriptor = PropertyUtils.getPropertyDescriptor(obj, field);
			Class pType = descriptor.getPropertyType();

			
			String prefix = "";
			if(pType == String.class)
				prefix =  vlalue == null ? "_sn_" : "_sk_" ;
			else if( Number.class.isAssignableFrom(pType))
				prefix =  vlalue == null ? "_nn_" : "_ne_";
			else if(pType.isPrimitive() && pType.getName().equals("long") || pType.getName().equals("integer") || pType.getName().equals("byte") || pType.getName().equals("short"))
				prefix =  vlalue == null ? "_nn_" : "_ne_";		
			else
				throw new IllegalArgumentException("Unsupport type of condition field " + field + ".Require String, Long, Integer type."  );
			
			//add List type   by Canigar
			if(vlalue.indexOf(",") != -1){
				String[] values = StringUtils.split(vlalue, ",");
				int regFlag = 0;
				for(int i=0;i<values.length;i++){
					if(values[i].startsWith("!")){
						regFlag++;
					}
				}
				if(regFlag == 0){
					prefix = prefix.substring(0,2);
					prefix = prefix + "in_";
				}else if(regFlag == values.length){
					prefix = prefix.substring(0,2);
					prefix = prefix + "nin_";
				}
			}
			
			return prefix + field;
		} catch (Exception e) {			
			throw e;
		}
	}
	
	public static String getCodeProperty( String definition ) throws Exception {
		Node node = (Node)Code2NameConfiger.sysMap.get(definition);
		return node.getCode();
	}
	
	public static String getNameProperty( String definition ) throws Exception {
		Node node = (Node) Code2NameConfiger.sysMap.get(definition);
		return node.getName();
	}
}
