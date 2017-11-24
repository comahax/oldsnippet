/**
 * 
 */
package com.sunrise.jop.ui.filter;

/**
 * @author He Kun
 *
 */
public interface PermissionChecker {
	
	boolean checkURIPermission(String oprcode, String currentURI) throws Exception;

	/**
	 *  �ж��Ƿ����ܱ�����Դ
	 */
	boolean checkPermission(String oprcode, String permissionId) throws Exception;

}
