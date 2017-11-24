/**
* auto-generated code
* Sat Nov 28 17:50:09 CST 2009
*/
package com.sunrise.boss.ui.cms.examine.mappinglog;

import com.sunrise.boss.business.cms.examine.mappinglog.persistent.MappinglogVO;
import com.sunrise.boss.ui.base.BaseAction;

/**
 * <p>Title: MappinglogAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class MappinglogAction extends BaseAction {
    public MappinglogAction() {
            setVoClass(MappinglogVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "logid"; 
    }
}
