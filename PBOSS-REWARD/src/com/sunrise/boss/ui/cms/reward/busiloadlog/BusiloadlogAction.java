/**
* auto-generated code
* Fri Feb 15 15:25:15 CST 2008
*/
package com.sunrise.boss.ui.cms.reward.busiloadlog;

import com.sunrise.boss.ui.base.*;
import com.sunrise.boss.business.cms.reward.busiloadlog.persistent.BusiloadlogListVO;
import com.sunrise.boss.business.cms.reward.busiloadlog.persistent.BusiloadlogVO;
import com.sunrise.boss.delegate.cms.reward.busiloadlog.BusiloadlogDelegate;

/**
 * <p>Title: BusiloadlogAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author zeng jianxin
 * @version 1.0
 */
public class BusiloadlogAction extends BaseDelegateAction {
    public BusiloadlogAction() {
           //���¼��������Ǳ���� 
           //ָ��VO�� 
            setVoClass(BusiloadlogVO.class);
            //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ����� 
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "logid"; 
    }
}
