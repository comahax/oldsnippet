/**
* auto-generated code
* Thu Dec 24 14:26:30 CST 2009
*/
package com.sunrise.boss.ui.cms.zjty.zjtycompcoeflog;

import com.sunrise.boss.business.cms.zjty.zjtycompcoeflog.persistent.ZjtyCompcoeflogVO;
import com.sunrise.boss.ui.base.BaseAction;

/**
 * <p>Title: ZjtyCompcoeflogAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public class ZjtyCompcoeflogAction extends BaseAction {
    public ZjtyCompcoeflogAction() {
            setVoClass(ZjtyCompcoeflogVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "logid"; 
    }
}
