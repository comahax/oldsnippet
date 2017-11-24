/**
* auto-generated code
* Fri Oct 20 01:01:43 CST 2006
*/
package com.sunrise.boss.ui.rightmanage.operright;

import com.sunrise.boss.business.rightmanage.operright.persistent.OperrightVO;
import com.sunrise.boss.ui.base.BaseAction;

/**
 * <p>Title: SaSrOperrightAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class OperrightAction extends BaseAction {
    public OperrightAction() {
        this.voClass = OperrightVO.class;
        // TODO: 给出主键的名字数组
        this.pkNameArray=new String[]{"operid","rightid","status","createdate"};
    }
}
