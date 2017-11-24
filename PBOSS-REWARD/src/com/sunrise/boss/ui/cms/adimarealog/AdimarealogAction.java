/**
* auto-generated code
* Mon Apr 16 17:13:59 CST 2007
*/
package com.sunrise.boss.ui.cms.adimarealog;

import com.sunrise.boss.ui.base.*;
import com.sunrise.boss.business.cms.adimarealog.persistent.AdimarealogListVO;
import com.sunrise.boss.business.cms.adimarealog.persistent.AdimarealogVO;
import com.sunrise.boss.delegate.cms.adimarealog.AdimarealogDelegate;

/**
 * <p>Title: AdimarealogAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author Ye Daoe
 * @version 1.0
 */
public class AdimarealogAction extends BaseDelegateAction {
    public AdimarealogAction() {
           //以下几个方法是必须的 
           //指定VO类 
            setVoClass(AdimarealogVO.class);
            //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称 
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "logid"; 
    }
}
