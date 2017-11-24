/**
* auto-generated code
* Wed Nov 18 10:52:23 CST 2009
*/
package com.sunrise.boss.ui.cms.examine.oprnwayidlog;

import com.sunrise.boss.business.cms.examine.oprnwayidlog.persistent.OprnwayidlogVO;
import com.sunrise.boss.ui.base.BaseAction;

/**
 * <p>Title: OprnwayidlogAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public class OprnwayidlogAction extends BaseAction {
    public OprnwayidlogAction() {
            setVoClass(OprnwayidlogVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "logid"; 
    }
}
