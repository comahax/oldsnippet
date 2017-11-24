/**
* auto-generated code
* Mon Apr 30 16:49:59 CST 2007
*/
package com.sunrise.boss.ui.admin.logincase;

import java.util.*;

import javax.servlet.http.*;

import com.sunrise.boss.ui.base.*;
import com.sunrise.boss.ui.commons.*;
import com.sunrise.boss.business.admin.logincase.persistent.LogincaseListVO;
import com.sunrise.boss.business.admin.logincase.persistent.LogincaseVO;
import com.sunrise.boss.delegate.admin.logincase.LogincaseDelegate;

/**
 * <p>Title: LogincaseAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
public class LogincaseAction extends BaseDelegateAction {
    public LogincaseAction() {
           //以下几个方法是必须的 
           //指定VO类 
            setVoClass(LogincaseVO.class);
            //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称 
           this.pkNameArray = new String[4]; 
           pkNameArray[0] = "cityid";
           pkNameArray[1] = "operid"; 
           pkNameArray[2] = "wayid";
    }
    
    protected User getUser(HttpServletRequest request) {
    	
    	//建立默认的系统工号，无需登录。
    	User user = new User();
    	user.setOpercode("SYS");
    	user.setWayid("SYSWAY");
    	user.setCityid("999");
    	user.setLogintime(new Date());

		request.getSession().setAttribute(WebConstant.SESSION_ATTRIBUTE_USER,user);
    	return super.getUser(request);
    }
}

