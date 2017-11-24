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
           //���¼��������Ǳ���� 
           //ָ��VO�� 
            setVoClass(LogincaseVO.class);
            //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ����� 
           this.pkNameArray = new String[4]; 
           pkNameArray[0] = "cityid";
           pkNameArray[1] = "operid"; 
           pkNameArray[2] = "wayid";
    }
    
    protected User getUser(HttpServletRequest request) {
    	
    	//����Ĭ�ϵ�ϵͳ���ţ������¼��
    	User user = new User();
    	user.setOpercode("SYS");
    	user.setWayid("SYSWAY");
    	user.setCityid("999");
    	user.setLogintime(new Date());

		request.getSession().setAttribute(WebConstant.SESSION_ATTRIBUTE_USER,user);
    	return super.getUser(request);
    }
}

