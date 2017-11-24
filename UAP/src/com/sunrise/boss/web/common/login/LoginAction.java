/**
 * 
 */
package com.sunrise.boss.web.common.login;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.sunrise.boss.business.common.menu.control.Menuitem;
import com.sunrise.boss.business.common.menu.control.MenuitemBO;
import com.sunrise.boss.business.common.menu.persistent.MenuitemDBParam;
import com.sunrise.boss.business.common.menu.persistent.MenuitemVO;
import com.sunrise.jop.common.encrypt.MD5;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;

/**
 * @author Windows
 *
 */
public class LoginAction extends BaseAction {
	
	private static Log log = LogFactory.getLog( LoginAction.class);
	private User user;
	private HashMap<String, User> userMap = null; // 临时用户缓存
	/**
	 * 
	 */
	public LoginAction() {
		userMap =  (HashMap<String, User>) LoginUtils.getTmpUser();
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	/**
	 * 准备登陆。用于第一次打开登录页面，login_toLogin.do ,而不是 login.jsp
	 * @return
	 */
	public String doToLogin() {
		
		return "toLogin";
	}
	
	public String doLogin() {
		try {			
			if(user == null) {
				return "error";	
			}else if(StringUtils.isBlank(user.getOprcode()) || StringUtils.isBlank(user.getPassword())) {
				//工号或密码不能为空
				addActionError("工号或密码缺失!");
				return "error";
			}else if(!userMap.containsKey(user.getOprcode())) {
				addActionError("工号不存在!");
				return "error";
			}

			User tmpuser = userMap.get(user.getOprcode()); // 根据输入获取临时工号信息
			if (tmpuser == null) {
				addActionError("工号未配置!");
				return "error";
			}
			MD5 md5 = new MD5();
			String password = md5.getMD5ofStr(user.getPassword());
			
			// 使用MD5加密后匹配密码，一致则登录成功
			if(!password.equals(tmpuser.getPassword())) {
				addActionError("密码错误!");
				return "error";
			}
			// 登录成功，将用户放入会话中
			HttpServletRequest request = ServletActionContext.getRequest();
            user.setCityid(tmpuser.getCityid()); 
			user.setIp( request.getRemoteHost());
			
			ActionContext.getContext().getSession().put(WebConstant.SESSION_ATTRIBUTE_USER, user);	
			// 登记登录日志
			user.setSystem("UAP");
			LoginUtils.saveLoginLog(new Byte("1"), null, user); 
			
			return "success";
			
		}catch(Exception e) {
			//由于内部异常而无法登录
			if(log.isErrorEnabled())
				log.error(e.getMessage(),e);
			addActionError("由于内部异常而无法登录! 原因:" + e.getMessage());//
			return "error";
		}
	}
	
	
	public String doLogout() {
		ActionContext.getContext().getSession().put(WebConstant.SESSION_ATTRIBUTE_USER, null);
		return "logout";
	}
	
	public String doWorkbench()  throws Exception{
		// 读取菜单并组织成Map结构
		User user = (User)super.getDBAccessUser();
		
		Menuitem menuItem = (Menuitem)BOFactory.build(MenuitemBO.class,user);
		MenuitemDBParam param = new MenuitemDBParam();	
	
		param.set_orderby("sortorder");
		param.set_ne_region(user.getCityid());
		param.set_ne_status("1"); //有效状态的菜单
		param.set_pagesize("0");
		param.setDataOnly(true); //只获取数据，不获取总记录数
		DataPackage dp = menuItem.doQuery(param);
		List<MenuitemVO> dataList = dp.getDatas();
		Map menuitems = new HashMap();
		for(MenuitemVO it : dataList){
			menuitems.put(it.getMenuname(), it);
		}
		
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("menuitems", menuitems);
		
		return SUCCESS;
	}

}
