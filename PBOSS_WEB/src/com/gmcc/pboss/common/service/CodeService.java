/**
 * 
 */
package com.gmcc.pboss.common.service;


/**
 * @author ywj
 * 2009-9-16
 */
public interface CodeService  {
	
	/**
	 * 根据代码去代码名称
	 * @param codeType
	 * @param code
	 * @return
	 */
	public String getNameByCode(String codeType, String code);
	
	/**
	 * 实现名称到代码的解析:用于系统导入文件
	 * 目前只提供代码表查询
	 * @param codeType
	 * @param name
	 * @return
	 */
	public String getCodeByName(String codeType, String name);
	
}
