/**
* auto-generated code
* Sun Aug 27 12:00:09 CST 2006
*/
package com.sunrise.boss.ui.cms.postinfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.ui.base.*;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.boss.business.cms.postinfo.persistent.PostinfoVO;

/**
 * <p>Title: PostinfoAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author yjr
 * @version 1.0
 */
public class PostinfoAction extends BaseDelegateAction {
    public PostinfoAction() {
           //���¼��������Ǳ���� 
           //ָ��VO�� 
            setVoClass(PostinfoVO.class);
            //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ����� 
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "postid"; 
    }
    
	public void onDuplicatePk(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) {
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
				"��ͬ����ĸ�λ��Ϣ�Ѿ�����, ��������������");

	}
}
