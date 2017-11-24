/**
* auto-generated code
* Fri Dec 09 10:02:24 CST 2011
*/
package com.sunrise.boss.ui.cms.bbc.registersucc;

import com.sunrise.boss.business.cms.bbc.registersucc.persistent.RegistersuccVO;
import com.sunrise.boss.ui.base.BaseAction;

/**
 * <p>Title: RegistersuccAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public class RegistersuccAction extends BaseAction {
    public RegistersuccAction() {
            setVoClass(RegistersuccVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "seq"; 
    }
}
