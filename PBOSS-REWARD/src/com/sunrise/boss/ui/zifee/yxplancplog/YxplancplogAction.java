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
           //���¼��������Ǳ���� 
           //ָ��VO�� 
            setVoClass(YxplancplogVO.class);
            //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ����� 
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "logid"; 
    }
}
