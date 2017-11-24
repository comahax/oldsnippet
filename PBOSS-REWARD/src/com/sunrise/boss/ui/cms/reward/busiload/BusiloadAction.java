/**
* auto-generated code
* Fri Feb 15 15:21:19 CST 2008
*/
package com.sunrise.boss.ui.cms.reward.busiload;

import com.sunrise.boss.ui.base.*;
import com.sunrise.boss.business.cms.reward.busiload.persistent.BusiloadListVO;
import com.sunrise.boss.business.cms.reward.busiload.persistent.BusiloadVO;
import com.sunrise.boss.delegate.cms.reward.busiload.BusiloadDelegate;

/**
 * <p>Title: BusiloadAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author zeng jianxin
 * @version 1.0
 */
public class BusiloadAction extends BaseDelegateAction {
    public BusiloadAction() {
           //以下几个方法是必须的 
           //指定VO类 
            setVoClass(BusiloadVO.class);
            //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称 
           this.pkNameArray = new String[3]; 
           pkNameArray[0] = "loadinfo"; 
           pkNameArray[1] = "loadtype"; 
           pkNameArray[2] = "opnid"; 
    }
}
