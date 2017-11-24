package com.sunrise.jop.infrastructure.component;

import java.util.*;

import com.sunrise.jop.infrastructure.db.*;

/**
 * 
 * @author He Kun
 *
 */
public interface Code2Name {
	
	/**
	 * ת������ֵΪ����
	 * @param definition
	 * @param codeName
	 * @param nameName
	 * @param codeValue
	 * @return
	 * @throws Exception 
	 */
	String code2Name(String definition,String codeValue,String dbFlag) ;
	
	/**
	 * ��ȡָ������������б�
	 * @param definition
	 * @return
	 */
	Map valueList(String definition,String dbFlag) ;
	
	/**
	 * ��ȡָ������������б�
	 * @param definition
	 * @return
	 */
	Map valueList(String definition,String condition,String dbFlag) ;
	
	/**
	 * 
	 * @param def
	 * @param condition
	 * @param param
	 * @param dbFlag
	 * @return
	 */
	Map valueList(String def, String condition,DBQueryParam param, String dbFlag) ;
	/**
	 * �ӵ����� ��ȡָ������������б��������������󣬲��÷�ҳ�ķ�ʽ��ȡ��һ��һҳ������ָ��ҳ�š�
	 * @param definition
	 * @param condition
	 * @param param
	 * @param dbFlag
	 * @return
	 */
	DataPackage valueListPackage(String definition,String condition, DBQueryParam param,  String dbFlag) ;	
}
