/**
* auto-generated code
* Wed Sep 10 11:29:44 CST 2008
*/
package com.sunrise.boss.ui.cms.reward.ruleitem;

import com.sunrise.boss.ui.base.*;
import com.sunrise.boss.business.cms.reward.ruleitem.persistent.RuleitemListVO;
import com.sunrise.boss.business.cms.reward.ruleitem.persistent.RuleitemVO;
import com.sunrise.boss.delegate.cms.reward.ruleitem.RuleitemDelegate;

/**
 * <p>Title: RuleitemAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class RuleitemAction extends BaseDelegateAction {
    public RuleitemAction() {
           //���¼��������Ǳ���� 
           //ָ��VO�� 
            setVoClass(RuleitemVO.class);
            //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ����� 
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "ruleitemid"; 
    }
}
