/**
* auto-generated code
* Wed Sep 10 14:39:49 CST 2008
*/
package com.sunrise.boss.ui.cms.reward.rulerellog;

import com.sunrise.boss.ui.base.*;
import com.sunrise.boss.business.cms.reward.rulerellog.persistent.RulerellogListVO;
import com.sunrise.boss.business.cms.reward.rulerellog.persistent.RulerellogVO;
import com.sunrise.boss.delegate.cms.reward.rulerellog.RulerellogDelegate;

/**
 * <p>Title: RulerellogAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class RulerellogAction extends BaseDelegateAction {
    public RulerellogAction() {
           //���¼��������Ǳ���� 
           //ָ��VO�� 
            setVoClass(RulerellogVO.class);
            //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ����� 
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "logid"; 
    }
}
