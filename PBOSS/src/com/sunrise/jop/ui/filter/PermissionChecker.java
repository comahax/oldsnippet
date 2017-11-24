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
	 *  判断是否是受保护资源
	 */
	boolean checkPermission(String oprcode, String permissionId) throws Exception;

}
