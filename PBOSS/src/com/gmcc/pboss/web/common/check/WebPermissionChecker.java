/**
 * 
 */
package com.gmcc.pboss.web.common.check;

import com.gmcc.pboss.control.base.operright.Operright;
import com.gmcc.pboss.control.base.operright.OperrightBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.ui.filter.PermissionChecker;

/**
 * @author He Kun
 *
 */
public class WebPermissionChecker implements PermissionChecker {
	
	public WebPermissionChecker() {		
	}

	/**
	 * 检查指定工号对 权限点的访问权限
	 */
	public boolean checkPermission(String oprcode, String permissionId)	throws Exception {
		Operright operright = (Operright) BOFactory.build(OperrightBO.class, DBAccessUser.getInnerUser());
		return operright.doCheckPermission(oprcode, permissionId);		
	}
	
	/**
	 * 检查指定工号对URI的访问权限
	 */
	public boolean checkURIPermission(String oprcode, String currentURI) throws Exception {
		Operright operright = (Operright) BOFactory.build(OperrightBO.class, DBAccessUser.getInnerUser());
		return operright.doCheckURIPermission(oprcode, currentURI);	
	}
	
}
