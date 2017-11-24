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
	 * ���ݴ���ȥ��������
	 * @param codeType
	 * @param code
	 * @return
	 */
	public String getNameByCode(String codeType, String code);
	
	/**
	 * ʵ�����Ƶ�����Ľ���:����ϵͳ�����ļ�
	 * Ŀǰֻ�ṩ������ѯ
	 * @param codeType
	 * @param name
	 * @return
	 */
	public String getCodeByName(String codeType, String name);
	
}
