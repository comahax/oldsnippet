/**
* auto-generated code
* Mon Apr 16 17:14:45 CST 2007
*/
package com.sunrise.boss.ui.cms.servcentlog;

import com.sunrise.boss.ui.base.*;
import com.sunrise.boss.business.cms.servcentlog.persistent.ServcentlogListVO;
import com.sunrise.boss.business.cms.servcentlog.persistent.ServcentlogVO;
import com.sunrise.boss.delegate.cms.servcentlog.ServcentlogDelegate;

/**
 * <p>Title: ServcentlogAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author Ye Daoe
 * @version 1.0
 */
public class ServcentlogAction extends BaseDelegateAction {
    public ServcentlogAction() {
           //���¼��������Ǳ���� 
           //ָ��VO�� 
            setVoClass(ServcentlogVO.class);
            //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ����� 
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "logid"; 
    }
}
