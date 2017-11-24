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
	 * 转换编码值为名称
	 * @param definition
	 * @param codeName
	 * @param nameName
	 * @param codeValue
	 * @return
	 * @throws Exception 
	 */
	String code2Name(String definition,String codeValue,String dbFlag) ;
	
	/**
	 * 获取指定编码的名称列表
	 * @param definition
	 * @return
	 */
	Map valueList(String definition,String dbFlag) ;
	
	/**
	 * 获取指定编码的名称列表
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
	 * 从单表中 获取指定编码的名称列表。由于数据量过大，采用分页的方式获取，一次一页，必须指定页号。
	 * @param definition
	 * @param condition
	 * @param param
	 * @param dbFlag
	 * @return
	 */
	DataPackage valueListPackage(String definition,String condition, DBQueryParam param,  String dbFlag) ;	
}
