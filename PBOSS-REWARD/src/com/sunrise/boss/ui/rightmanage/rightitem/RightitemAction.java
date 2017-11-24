/**
* auto-generated code
* Tue Oct 31 14:19:29 CST 2006
*/
package com.sunrise.boss.ui.rightmanage.rightitem;

import com.sunrise.boss.business.rightmanage.rightitem.persistent.RightitemVO;
import com.sunrise.boss.ui.base.BaseAction;

/**
 * <p>Title: RightitemAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class RightitemAction extends BaseAction {
    public RightitemAction() {
        this.voClass = RightitemVO.class;
        // TODO: 给出主键的名字数组
        this.pkNameArray=new String[]{"rightid"};
    }
}
