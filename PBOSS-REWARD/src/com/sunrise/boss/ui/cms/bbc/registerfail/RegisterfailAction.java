/**
* auto-generated code
* Fri Dec 09 10:19:02 CST 2011
*/
package com.sunrise.boss.ui.cms.bbc.registerfail;

import com.sunrise.boss.business.cms.bbc.registerfail.persistent.RegisterfailVO;
import com.sunrise.boss.ui.base.BaseAction;

/**
 * <p>Title: RegisterfailAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public class RegisterfailAction extends BaseAction {
    public RegisterfailAction() {
            setVoClass(RegisterfailVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "seq"; 
    }
}
