/**
* auto-generated code
* Mon Sep 15 18:11:42 CST 2008
*/
package com.sunrise.boss.ui.cms.reward.rewardpoolyw;

import com.sunrise.boss.ui.base.*;
import com.sunrise.boss.business.cms.reward.rewardpoolyw.persistent.RewardpoolywListVO;
import com.sunrise.boss.business.cms.reward.rewardpoolyw.persistent.RewardpoolywVO;
import com.sunrise.boss.delegate.cms.reward.rewardpoolyw.RewardpoolywDelegate;

/**
 * <p>Title: RewardpoolywAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class RewardpoolywAction extends BaseDelegateAction {
    public RewardpoolywAction() {
           //以下几个方法是必须的 
           //指定VO类 
            setVoClass(RewardpoolywVO.class);
            //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称 
           this.pkNameArray = new String[3]; 
           pkNameArray[0] = "opnid"; 
           pkNameArray[1] = "region"; 
           pkNameArray[2] = "rewardtype"; 
    }
}
