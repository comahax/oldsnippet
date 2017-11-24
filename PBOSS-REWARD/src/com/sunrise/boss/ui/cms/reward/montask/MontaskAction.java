/**
* auto-generated code
* Thu Aug 20 16:16:59 CST 2009
*/
package com.sunrise.boss.ui.cms.reward.montask;

import com.sunrise.boss.business.cms.reward.montask.persistent.MontaskVO;
import com.sunrise.boss.ui.base.BaseAction;

/**
 * <p>Title: MontaskAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public class MontaskAction extends BaseAction {
    public MontaskAction() {
            setVoClass(MontaskVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[2]; 
           pkNameArray[0] = "ownertaskid"; 
           pkNameArray[1] = "taskid"; 
    }
}
