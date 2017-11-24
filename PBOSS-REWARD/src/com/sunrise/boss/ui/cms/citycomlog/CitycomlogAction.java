/**
* auto-generated code
* Tue Oct 17 17:37:23 CST 2006
*/
package com.sunrise.boss.ui.cms.citycomlog;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;

import com.sunrise.boss.ui.base.*;
import com.sunrise.boss.business.cms.citycomlog.persistent.CitycomlogListVO;
import com.sunrise.boss.business.cms.citycomlog.persistent.CitycomlogVO;
import com.sunrise.boss.delegate.cms.citycomlog.CitycomlogDelegate;

/**
 * <p>Title: CitycomlogAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
public class CitycomlogAction extends BaseDelegateAction {
    public CitycomlogAction() {
           //���¼��������Ǳ���� 
           //ָ��VO�� 
            setVoClass(CitycomlogVO.class);
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
				((CitycomlogListVO)listVO).set_desc("1");
				((CitycomlogListVO)listVO).set_orderby("logid");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
