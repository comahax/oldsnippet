/**
* auto-generated code
* Thu Oct 19 17:09:08 CST 2006
*/
package com.sunrise.boss.ui.rightmanage.roleright;

import com.sunrise.boss.business.rightmanage.roleright.persistent.RolerightVO;
import com.sunrise.boss.ui.base.BaseAction;

/**
 * <p>Title: RolerightAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class RolerightAction extends BaseAction {
    public RolerightAction() {
        this.voClass = RolerightVO.class;
        // TODO: 给出主键的名字数组
        this.pkNameArray=new String[]{"itemid","rightid"};
    }
    
}
