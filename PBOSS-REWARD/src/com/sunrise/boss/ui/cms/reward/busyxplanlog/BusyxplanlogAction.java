/**
* auto-generated code
* Sat Feb 02 15:15:28 CST 2008
*/
package com.sunrise.boss.ui.cms.reward.busyxplanlog;

import com.sunrise.boss.ui.base.*;
import com.sunrise.boss.business.cms.reward.busyxplanlog.persistent.BusyxplanlogListVO;
import com.sunrise.boss.business.cms.reward.busyxplanlog.persistent.BusyxplanlogVO;
import com.sunrise.boss.delegate.cms.reward.busyxplanlog.BusyxplanlogDelegate;

/**
 * <p>Title: BusyxplanlogAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class BusyxplanlogAction extends BaseDelegateAction {
    public BusyxplanlogAction() {
           //���¼��������Ǳ���� 
           //ָ��VO�� 
            setVoClass(BusyxplanlogVO.class);
            //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ����� 
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "logid"; 
    }
}
