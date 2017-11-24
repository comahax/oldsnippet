/**
* auto-generated code
* Thu Sep 11 19:35:20 CST 2008
*/
package com.sunrise.boss.ui.cms.reward.ruleitemrl;

import com.sunrise.boss.ui.base.*;
import com.sunrise.boss.business.cms.reward.ruleitemrl.persistent.RuleitemrlListVO;
import com.sunrise.boss.business.cms.reward.ruleitemrl.persistent.RuleitemrlVO;
import com.sunrise.boss.delegate.cms.reward.ruleitemrl.RuleitemrlDelegate;

/**
 * <p>Title: RuleitemrlAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class RuleitemrlAction extends BaseDelegateAction {
    public RuleitemrlAction() {
           //以下几个方法是必须的 
           //指定VO类 
            setVoClass(RuleitemrlVO.class);
            //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称 
           this.pkNameArray = new String[2]; 
           pkNameArray[0] = "groupid"; 
           pkNameArray[1] = "ruleid"; 
           pkNameArray[1] = "ruleitemid";
    }
}
