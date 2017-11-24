/**
* auto-generated code
* Wed Nov 02 19:11:53 CST 2011
*/
package com.sunrise.boss.ui.cms.reward.rewardslvlimit;

import com.sunrise.boss.business.cms.reward.rewardslvlimit.persistent.RewardslvlimitVO;
//import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.base.BaseDelegateAction;

/**
 * <p>Title: RewardslvlimitAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
public class RewardslvlimitAction extends BaseDelegateAction {
    public RewardslvlimitAction() {
            setVoClass(RewardslvlimitVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[4]; 
           pkNameArray[0] = "opnid"; 
           pkNameArray[1] = "region"; 
           pkNameArray[2] = "rewardid"; 
           pkNameArray[3] = "slv"; 
    }
}
