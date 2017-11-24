/**
* auto-generated code
* Tue Dec 29 15:07:40 CST 2009
*/
package com.sunrise.boss.ui.cms.zjty.zjtyrwddtllog;

import com.sunrise.boss.business.cms.zjty.zjtyrwddtllog.persistent.ZjtyRwddtllogVO;
import com.sunrise.boss.ui.base.BaseAction;

/**
 * <p>Title: ZjtyRwddtllogAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public class ZjtyRwddtllogAction extends BaseAction {
    public ZjtyRwddtllogAction() {
            setVoClass(ZjtyRwddtllogVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "logid"; 
    }
}
