/**
* auto-generated code
* Sun Sep 23 15:29:50 CST 2007
*/
package com.sunrise.boss.ui.zifee.yxplancplog;

import com.sunrise.boss.ui.base.*;
import com.sunrise.boss.business.zifee.yxplancplog.persistent.YxplancplogListVO;
import com.sunrise.boss.business.zifee.yxplancplog.persistent.YxplancplogVO;
import com.sunrise.boss.delegate.zifee.yxplancplog.YxplancplogDelegate;

/**
 * <p>Title: YxplancplogAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author zeng jianxin
 * @version 1.0
 */
public class YxplancplogAction extends BaseDelegateAction {
    public YxplancplogAction() {
           //以下几个方法是必须的 
           //指定VO类 
            setVoClass(YxplancplogVO.class);
            //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称 
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "logid"; 
    }
}
