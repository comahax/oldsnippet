/**
* auto-generated code
* Sat Aug 26 11:33:48 CST 2006
*/
package com.sunrise.boss.ui.cms.wayagentbch;

import com.sunrise.boss.ui.base.*;
import com.sunrise.boss.business.cms.wayagentbch.persistent.WayagentbchListVO;
import com.sunrise.boss.business.cms.wayagentbch.persistent.WayagentbchVO;
import com.sunrise.boss.delegate.cms.wayagentbch.WayagentbchDelegate;

/**
 * <p>Title: WayagentbchAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
public class WayagentbchAction extends BaseDelegateAction {
    public WayagentbchAction() {
           //以下几个方法是必须的 
           //指定VO类 
            setVoClass(WayagentbchVO.class);
            //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称 
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "wayid"; 
    }
}
