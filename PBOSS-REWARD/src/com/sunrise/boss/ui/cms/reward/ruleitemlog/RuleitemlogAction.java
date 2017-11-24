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
           //以下几个方法是必须的 
           //指定VO类 
            setVoClass(RuleitemlogVO.class);
            //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称 
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "logid"; 
    }
}
