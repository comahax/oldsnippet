/**
* auto-generated code
* Sun Feb 03 10:16:15 CST 2008
*/
package com.sunrise.boss.ui.cms.reward.rulelog;

import com.sunrise.boss.ui.base.*;
import com.sunrise.boss.business.cms.reward.rulelog.persistent.RulelogListVO;
import com.sunrise.boss.business.cms.reward.rulelog.persistent.RulelogVO;
import com.sunrise.boss.delegate.cms.reward.rulelog.RulelogDelegate;

/**
 * <p>Title: RulelogAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class RulelogAction extends BaseDelegateAction {
    public RulelogAction() {
           //���¼��������Ǳ���� 
           //ָ��VO�� 
            setVoClass(RulelogVO.class);
            //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ����� 
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "logid"; 
    }
}
