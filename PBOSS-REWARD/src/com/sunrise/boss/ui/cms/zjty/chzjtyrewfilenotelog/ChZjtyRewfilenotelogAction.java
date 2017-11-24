/**
* auto-generated code
* Thu Jul 12 15:25:29 CST 2012
*/
package com.sunrise.boss.ui.cms.zjty.chzjtyrewfilenotelog;

import com.sunrise.boss.business.cms.zjty.chzjtyrewfilenotelog.persistent.ChZjtyRewfilenotelogVO;
import com.sunrise.boss.ui.base.BaseAction;

/**
 * <p>Title: ChZjtyRewfilenotelogAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxx
 * @version 1.0
 */
public class ChZjtyRewfilenotelogAction extends BaseAction {
    public ChZjtyRewfilenotelogAction() {
            setVoClass(ChZjtyRewfilenotelogVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "logid"; 
    }
}
