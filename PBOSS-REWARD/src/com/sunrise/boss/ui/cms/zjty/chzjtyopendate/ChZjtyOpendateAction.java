/**
* auto-generated code
* Fri Feb 13 16:55:58 CST 2009
*/
package com.sunrise.boss.ui.cms.zjty.chzjtyopendate;

import com.sunrise.boss.business.cms.zjty.chzjtyopendate.persistent.ChZjtyOpendateVO;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.base.BaseDelegateAction;

/**
 * <p>Title: ChZjtyOpendateAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wanghua
 * @version 1.0
 */
public class ChZjtyOpendateAction extends BaseDelegateAction {
    public ChZjtyOpendateAction() {
            setVoClass(ChZjtyOpendateVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "wayid"; 
    }
}
