/**
 * 
 */
package com.sunrise.boss.web.common.check;

import java.util.List;

import com.sunrise.boss.business.common.menu.control.Menuitem;
import com.sunrise.boss.business.common.menu.control.MenuitemBO;
import com.sunrise.boss.business.common.menu.persistent.MenuitemDBParam;
import com.sunrise.boss.business.common.menu.persistent.MenuitemVO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DBConstant;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.filter.PermissionChecker;

/**
 * @author He Kun
 *
 */
public class WebPermissionChecker implements PermissionChecker {
	
	public WebPermissionChecker() {		
	}

	/**
	 * 检查指定工号对令牌的访问权限
	 */
	public boolean checkPermission(String permissionId, User user)	throws Exception {
	
		return com.sunrise.boss.common.client.menutoken.PublicService.checkToken(user, permissionId);

	}
	
	/**
	 * 检查指定工号对URI的访问权限
	 */
	public boolean checkURIPermission(String currentURI, User user) throws Exception {
		
		currentURI = currentURI.replaceFirst("/", "").replace("integration.jsp?targetUrl=", ""); //过滤下，得到真正的请求地址
		
		String menuid = null;
		Menuitem menuItem = (Menuitem)BOFactory.build(MenuitemBO.class,DBAccessUser.getCommonUser(user));
		MenuitemDBParam param = new MenuitemDBParam();	
		param.set_se_guiobject(currentURI);
		param.set_ne_region(user.getCityid());
		param.set_ne_status("1");
		param.setDataOnly(true);

		DataPackage dp = menuItem.doQuery(param);
		List list = (List) dp.getDatas();
		if(list != null && list.size()>0 ) {
			MenuitemVO vo = (MenuitemVO)list.get(0);
			menuid = vo.getMenuid();
		}
		if (menuid != null) {
			return com.sunrise.boss.common.client.sso.PublicService.checkMenu(user, menuid);
		}
		// 找不到 menuid 的默认放行
		return true;
	}
	
	public static void main(String[] args) {
		WebPermissionChecker checker = new WebPermissionChecker();
		User user = new User();
		user.setCityid("757");
		try {
			checker.checkPermission("PERM_QUERY", user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
