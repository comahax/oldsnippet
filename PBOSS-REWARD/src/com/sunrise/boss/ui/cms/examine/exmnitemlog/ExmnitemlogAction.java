/**
* auto-generated code
* Wed Nov 25 11:14:06 CST 2009
*/
package com.sunrise.boss.ui.cms.examine.exmnitemlog;

import com.sunrise.boss.business.cms.examine.exmnitemlog.persistent.ExmnitemlogVO;
import com.sunrise.boss.ui.base.BaseAction;

/**
 * <p>Title: ExmnitemlogAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ExmnitemlogAction extends BaseAction {
    public ExmnitemlogAction() {
            setVoClass(ExmnitemlogVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "logid"; 
    }
}
