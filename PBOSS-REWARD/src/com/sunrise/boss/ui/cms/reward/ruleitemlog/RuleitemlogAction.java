/**
* auto-generated code
* Wed Sep 10 14:41:39 CST 2008
*/
package com.sunrise.boss.ui.cms.reward.ruleitemlog;

import com.sunrise.boss.ui.base.*;
import com.sunrise.boss.business.cms.reward.ruleitemlog.persistent.RuleitemlogListVO;
import com.sunrise.boss.business.cms.reward.ruleitemlog.persistent.RuleitemlogVO;
import com.sunrise.boss.delegate.cms.reward.ruleitemlog.RuleitemlogDelegate;

/**
 * <p>Title: RuleitemlogAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class RuleitemlogAction extends BaseDelegateAction {
    public RuleitemlogAction() {
           //���¼��������Ǳ���� 
           //ָ��VO�� 
            setVoClass(RuleitemlogVO.class);
            //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ����� 
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "logid"; 
    }
}
