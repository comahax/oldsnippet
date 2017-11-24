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
           //以下几个方法是必须的 
           //指定VO类 
            setVoClass(RuleitemVO.class);
            //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称 
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "ruleitemid"; 
    }
}
