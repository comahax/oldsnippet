/**
* auto-generated code
* Sun Nov 29 14:16:41 CST 2009
*/
package com.sunrise.boss.ui.cms.examine.coefrevision;

import com.sunrise.boss.business.cms.examine.coefrevision.persistent.CoefrevisionVO;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.base.BaseDelegateAction;

/**
 * <p>Title: CoefrevisionAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class CoefrevisionAction extends BaseDelegateAction {
    public CoefrevisionAction() {
            setVoClass(CoefrevisionVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "seqid"; 
    }
}
