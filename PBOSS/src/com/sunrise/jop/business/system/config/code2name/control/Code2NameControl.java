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
	 * ת�����롣���ڵ����롣
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
	 * ת�����롣��Ҫ��groupid�жϷ��飬���������ֵ�ķ���
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
	 * ��ȡ�����ֵ�ĳ��������в�������Map��ʽ����
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
	 * ����groupCode ��ȡ�����ֵ����б��룬�����б� ��DataPackage��ʽ����
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
	 * ����VOClass ��ȡ���б��룬�����б�
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
