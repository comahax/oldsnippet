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
           //���¼��������Ǳ���� 
           //ָ��VO�� 
            setVoClass(RewardpoolywlogVO.class);
            //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ����� 
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "logid"; 
    }
}
