/**
* auto-generated code
* Sat Oct 21 11:05:47 CST 2006
*/
package com.sunrise.boss.ui.rightmanage.operator;

import com.sunrise.boss.business.rightmanage.operator.persistent.Operator2VO;
import com.sunrise.boss.ui.base.BaseAction;

/**
 * <p>Title: OperatorAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class OperatorAction extends BaseAction {
    public OperatorAction() {
        this.voClass = Operator2VO.class;
        // TODO: 给出主键的名字数组
        this.pkNameArray=new String[]{"operid"};
    }
}
