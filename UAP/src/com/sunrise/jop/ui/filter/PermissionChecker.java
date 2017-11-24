/**
 * 
 */
package com.sunrise.jop.ui.filter;

import com.sunrise.jop.ui.User;

/**
 * @author He Kun
 * 
 */
public interface PermissionChecker {

	boolean checkURIPermission(String currentURI, User user) throws Exception;

	/**
	 * 判断是否是受保护资源
	 */
	boolean checkPermission(String permissionId, User user) throws Exception;

}
