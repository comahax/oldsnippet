/**
* auto-generated code
* Tue May 01 15:39:58 CST 2007
*/
package com.sunrise.boss.ui.cms.coststatrelative;

import com.sunrise.boss.ui.base.*;
import com.sunrise.boss.business.cms.coststatrelative.persistent.CoststatrelativeListVO;
import com.sunrise.boss.business.cms.coststatrelative.persistent.CoststatrelativeVO;
import com.sunrise.boss.delegate.cms.coststatrelative.CoststatrelativeDelegate;

/**
 * <p>Title: CoststatrelativeAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author Cai Jianhui
 * @version 1.0
 */
public class CoststatrelativeAction extends BaseDelegateAction {
    public CoststatrelativeAction() {
           //以下几个方法是必须的 
           //指定VO类 
            setVoClass(CoststatrelativeVO.class);
            //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称 
           this.pkNameArray = new String[2]; 
           pkNameArray[0] = "fnlcostitem"; 
           pkNameArray[1] = "recid"; 
    }
}
