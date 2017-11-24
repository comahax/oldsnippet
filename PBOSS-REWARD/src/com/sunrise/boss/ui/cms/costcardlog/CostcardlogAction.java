/**
* auto-generated code
* Fri May 02 07:00:08 CST 2008
*/
package com.sunrise.boss.ui.cms.costcardlog;

import com.sunrise.boss.ui.base.*;
import com.sunrise.boss.business.cms.costcardlog.persistent.CostcardlogListVO;
import com.sunrise.boss.business.cms.costcardlog.persistent.CostcardlogVO;
import com.sunrise.boss.delegate.cms.costcardlog.CostcardlogDelegate;

/**
 * <p>Title: CostcardlogAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class CostcardlogAction extends BaseDelegateAction {
    public CostcardlogAction() {
           //以下几个方法是必须的 
           //指定VO类 
            setVoClass(CostcardlogVO.class);
            //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称 
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "logid"; 
    }
}
