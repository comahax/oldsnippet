/**
* auto-generated code
* Wed Dec 14 10:29:07 CST 2011
*/
package com.sunrise.boss.ui.cms.bbc.hpolregistersucc;

import com.sunrise.boss.business.cms.bbc.hpolregistersucc.persistent.HpolregistersuccVO;
import com.sunrise.boss.ui.base.BaseAction;

/**
 * <p>Title: HpolregistersuccAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public class HpolregistersuccAction extends BaseAction {
    public HpolregistersuccAction() {
            setVoClass(HpolregistersuccVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "seq"; 
    }
}
