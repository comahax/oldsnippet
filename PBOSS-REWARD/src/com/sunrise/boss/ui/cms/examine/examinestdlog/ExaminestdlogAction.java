/**
* auto-generated code
* Wed Nov 18 09:26:48 CST 2009
*/
package com.sunrise.boss.ui.cms.examine.examinestdlog;

import com.sunrise.boss.business.cms.examine.examinestdlog.persistent.ExaminestdlogVO;
import com.sunrise.boss.ui.base.BaseAction;

/**
 * <p>Title: ExaminestdlogAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ExaminestdlogAction extends BaseAction {
    public ExaminestdlogAction() {
            setVoClass(ExaminestdlogVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "logid"; 
    }
}
