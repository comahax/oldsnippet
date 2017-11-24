/**
* auto-generated code
* Mon Sep 15 18:12:26 CST 2008
*/
package com.sunrise.boss.ui.cms.reward.rewardpoolywlog;

import com.sunrise.boss.ui.base.*;
import com.sunrise.boss.business.cms.reward.rewardpoolywlog.persistent.RewardpoolywlogListVO;
import com.sunrise.boss.business.cms.reward.rewardpoolywlog.persistent.RewardpoolywlogVO;
import com.sunrise.boss.delegate.cms.reward.rewardpoolywlog.RewardpoolywlogDelegate;

/**
 * <p>Title: RewardpoolywlogAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class RewardpoolywlogAction extends BaseDelegateAction {
    public RewardpoolywlogAction() {
           //以下几个方法是必须的 
           //指定VO类 
            setVoClass(RewardpoolywlogVO.class);
            //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称 
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "logid"; 
    }
}
