/**
* auto-generated code
* Mon Feb 16 10:04:47 CST 2009
*/
package com.sunrise.boss.ui.cms.zjty.chzjtyoprtcostlog;

import com.sunrise.boss.business.cms.zjty.chzjtyoprtcostlog.persistent.ChZjtyOprtcostlogVO;
import com.sunrise.boss.ui.base.BaseAction;

/**
 * <p>Title: ChZjtyOprtcostlogAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wanghua
 * @version 1.0
 */
public class ChZjtyOprtcostlogAction extends BaseAction {
    public ChZjtyOprtcostlogAction() {
            setVoClass(ChZjtyOprtcostlogVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "logid"; 
    }
}
