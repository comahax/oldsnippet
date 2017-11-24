/**
* auto-generated code
* Fri Feb 13 16:49:58 CST 2009
*/
package com.sunrise.boss.ui.cms.zjty.chzjtyempltotal;

import com.sunrise.boss.business.cms.zjty.chzjtyempltotal.persistent.ChZjtyEmpltotalVO;
import com.sunrise.boss.ui.base.BaseDelegateAction;

/**
 * <p>Title: ChZjtyEmpltotalAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wanghua
 * @version 1.0
 */
public class ChZjtyEmpltotalAction extends BaseDelegateAction {
    public ChZjtyEmpltotalAction() {
            setVoClass(ChZjtyEmpltotalVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[2]; 
           pkNameArray[0] = "wayid"; 
           pkNameArray[1] = "yearmonth"; 
    }
}
