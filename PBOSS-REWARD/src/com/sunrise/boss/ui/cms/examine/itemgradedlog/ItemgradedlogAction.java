/**
* auto-generated code
* Sat Nov 28 17:54:36 CST 2009
*/
package com.sunrise.boss.ui.cms.examine.itemgradedlog;

import com.sunrise.boss.business.cms.examine.itemgradedlog.persistent.ItemgradedlogVO;
import com.sunrise.boss.ui.base.BaseAction;

/**
 * <p>Title: ItemgradedlogAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ItemgradedlogAction extends BaseAction {
    public ItemgradedlogAction() {
            setVoClass(ItemgradedlogVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "logid"; 
    }
}
