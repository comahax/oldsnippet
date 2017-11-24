/**
* auto-generated code
* Thu Dec 24 16:14:35 CST 2009
*/
package com.sunrise.boss.ui.cms.zjty.zjtybusitosmplog;

import com.sunrise.boss.business.cms.zjty.zjtybusitosmplog.persistent.ZjtyBusitosmplogVO;
import com.sunrise.boss.ui.base.BaseAction;

/**
 * <p>Title: ZjtyBusitosmplogAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public class ZjtyBusitosmplogAction extends BaseAction {
    public ZjtyBusitosmplogAction() {
            setVoClass(ZjtyBusitosmplogVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "logid"; 
    }
}
