/**
* auto-generated code
* Tue Sep 10 14:37:33 CST 2013
*/
package com.sunrise.boss.ui.cms.provagent.chpdrprewardrecord;

import com.sunrise.boss.business.cms.provagent.chpdrprewardrecord.persistent.ChPdRprewardrecordVO;
import com.sunrise.boss.ui.base.BaseAction;

/**
 * <p>Title: ChPdRprewardrecordAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public class ChPdRprewardrecordAction extends BaseAction {
    public ChPdRprewardrecordAction() {
            setVoClass(ChPdRprewardrecordVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "rpseqid"; 
    }
}
