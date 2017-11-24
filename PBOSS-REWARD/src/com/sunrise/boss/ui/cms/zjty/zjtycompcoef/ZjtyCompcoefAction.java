/**
* auto-generated code
* Thu Dec 24 14:22:12 CST 2009
*/
package com.sunrise.boss.ui.cms.zjty.zjtycompcoef;

import com.sunrise.boss.business.cms.zjty.zjtycompcoef.persistent.ZjtyCompcoefVO;
import com.sunrise.boss.ui.base.BaseDelegateAction;

/**
 * <p>Title: ZjtyCompcoefAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public class ZjtyCompcoefAction extends BaseDelegateAction {
    public ZjtyCompcoefAction() {
            setVoClass(ZjtyCompcoefVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "wayid"; 
    }
}
