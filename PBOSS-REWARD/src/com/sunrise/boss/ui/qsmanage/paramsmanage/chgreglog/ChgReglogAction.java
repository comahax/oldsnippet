/**
* auto-generated code
* Fri Jul 11 10:07:46 CST 2008
*/
package com.sunrise.boss.ui.qsmanage.paramsmanage.chgreglog;

import com.sunrise.boss.business.qsmanage.paramsmanage.chgreglog.persistent.ChgReglogVO;
import com.sunrise.boss.ui.base.BaseAction;

/**
 * <p>Title: ChgReglogAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ChgReglogAction extends BaseAction {
    public ChgReglogAction() {
        this.voClass = ChgReglogVO.class;
        // TODO: 给出主键的名字数组
        this.pkNameArray=new String[]{"logid"};
    }
}
