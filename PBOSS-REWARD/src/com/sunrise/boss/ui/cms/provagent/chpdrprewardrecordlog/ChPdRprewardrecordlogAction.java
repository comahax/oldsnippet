/**
* auto-generated code
* Sun Sep 08 15:35:41 CST 2013
*/
package com.sunrise.boss.ui.cms.provagent.chpdrprewardrecordlog;

import com.sunrise.boss.business.cms.provagent.chpdrprewardrecordlog.persistent.ChPdRprewardrecordlogVO;
import com.sunrise.boss.ui.base.BaseAction;

/**
 * <p>Title: ChPdRprewardrecordlogAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public class ChPdRprewardrecordlogAction extends BaseAction {
    public ChPdRprewardrecordlogAction() {
            setVoClass(ChPdRprewardrecordlogVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "logid"; 
    }
}
