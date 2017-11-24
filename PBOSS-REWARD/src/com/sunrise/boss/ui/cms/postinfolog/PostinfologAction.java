/**
* auto-generated code
* Wed Oct 18 16:15:34 CST 2006
*/
package com.sunrise.boss.ui.cms.postinfolog;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;

import com.sunrise.boss.ui.base.*;
import com.sunrise.boss.business.cms.postinfolog.persistent.PostinfologListVO;
import com.sunrise.boss.business.cms.postinfolog.persistent.PostinfologVO;
import com.sunrise.boss.delegate.cms.postinfolog.PostinfologDelegate;

/**
 * <p>Title: PostinfologAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
public class PostinfologAction extends BaseDelegateAction {
    public PostinfologAction() {
           //���¼��������Ǳ���� 
           //ָ��VO�� 
            setVoClass(PostinfologVO.class);
            //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ����� 
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "logid"; 
    }
    protected void setListVO(Object listVO, final ActionForm listForm) {
		try {
			BeanUtils.copyProperties(listVO, listForm);
			String _desc=((BaseActionForm)listForm).get_desc();
			String _orderby=((BaseActionForm)listForm).get_orderby();
			if("".equals(_desc) && "".equals(_orderby) || _desc==null && _orderby==null)
			{
				((PostinfologListVO)listVO).set_desc("1");
				((PostinfologListVO)listVO).set_orderby("logid");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
