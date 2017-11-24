package com.sunrise.jop.business.system.config.code2name.control;

import java.util.Map;

import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBQueryParam;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * 
 * @author Windows
 *
 */
public interface Code2NameControl extends AbstractControl {
	/**
	 * 转换编码。用于单表翻译。
	 * @param voName
	 * @param codeName
	 * @param nameName
	 * @param codeValue
	 * @param dbFlag
	 * @return
	 * @throws Exception
	 */
	Object doTranslateCode(String voName, String codeName, String nameName,
			Object codeValue, String dbFlag) throws Exception;
	
	/**
	 * 转换编码。需要按groupid判断分组，用于数据字典的翻译
	 * @param voName
	 * @param groupid
	 * @param codeName
	 * @param nameName
	 * @param codeValue
	 * @param dbFlag
	 * @return
	 * @throws Exception 
	 */
	Object doTranslateCode(String voName, String groupid, String codeName, String nameName, Object codeValue, String dbFlag) throws Exception;
	
	/**
	 * 获取数据字典某个组的所有参数，以Map形式返回
	 * @param groupid
	 * @param codeName
	 * @param nameName
	 * @param param
	 * @param dbFlag
	 * @return
	 * @throws Exception
	 */
	Map doValueList(String groupid, String codeName, String nameName, DBQueryParam param,String dbFlag) throws Exception ;
	
	/**
	 * 根据groupCode 获取数据字典所有编码，名称列表。 以DataPackage形式返回
	 * @param voName
	 * @param codeName
	 * @param nameName
	 * @param param
	 * @param dbFlag
	 * @return
	 * @throws Exception
	 */
	DataPackage doValueListPackage(String groupCoce, String codeName, String nameName, DBQueryParam param,String dbFlag) throws Exception ;
	
	/**
	 * 根据VOClass 获取所有编码，名称列表
	 * @param voClass
	 * @param codeName
	 * @param nameName
	 * @param param
	 * @param dbFlag
	 * @return
	 * @throws Exception
	 */
	DataPackage doValueListPackage(Class voClass, String codeName, String nameName, DBQueryParam param,String dbFlag) throws Exception ;
}
