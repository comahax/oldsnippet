/**
* auto-generated code
* Wed Aug 27 09:24:49 CST 2008
*/
package com.sunrise.boss.ui.cms.bbc.stdreward;

import com.sunrise.boss.business.cms.bbc.stdreward.persistent.BBCstdrewardVO;
import com.sunrise.boss.ui.base.BaseAction;

/**
 * <p>Title: BBCstdrewardAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class BBCstdrewardAction extends BaseAction {
    public BBCstdrewardAction() {
        this.voClass = BBCstdrewardVO.class;
        // TODO: 给出主键的名字数组
        this.pkNameArray=new String[]{"rewardid"};
    }
}
