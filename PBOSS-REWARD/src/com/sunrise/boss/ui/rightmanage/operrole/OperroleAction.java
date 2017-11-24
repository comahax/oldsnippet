/**
* auto-generated code
* Fri Oct 20 20:20:06 CST 2006
*/
package com.sunrise.boss.ui.rightmanage.operrole;

import com.sunrise.boss.business.rightmanage.operrole.persistent.OperroleVO;
import com.sunrise.boss.ui.base.BaseAction;

/**
 * <p>Title: OperroleAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class OperroleAction extends BaseAction {
    public OperroleAction() {
        this.voClass = OperroleVO.class;
        // TODO: 给出主键的名字数组
        this.pkNameArray=new String[]{"operid","roleid","statusdate","status"};
    }
}
