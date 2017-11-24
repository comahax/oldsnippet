/**
* auto-generated code
* Tue Nov 24 10:57:58 CST 2009
*/
package com.sunrise.boss.ui.cms.examine.exmnperiodlog;

import com.sunrise.boss.business.cms.examine.exmnperiodlog.persistent.ExmnperiodlogVO;
import com.sunrise.boss.ui.base.BaseAction;

/**
 * <p>Title: ExmnperiodlogAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ExmnperiodlogAction extends BaseAction {
    public ExmnperiodlogAction() {
            setVoClass(ExmnperiodlogVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "logid"; 
    }
}
