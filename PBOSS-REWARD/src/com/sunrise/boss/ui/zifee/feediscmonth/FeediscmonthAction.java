/**
* auto-generated code
* Wed Nov 14 16:51:17 CST 2007
*/
package com.sunrise.boss.ui.zifee.feediscmonth;

import com.sunrise.boss.ui.base.*;
import com.sunrise.boss.business.zifee.feediscmonth.persistent.FeediscmonthListVO;
import com.sunrise.boss.business.zifee.feediscmonth.persistent.FeediscmonthVO;

/**
 * <p>Title: FeediscmonthAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author zeng jianxin
 * @version 1.0
 */
public class FeediscmonthAction extends BaseDelegateAction {
    public FeediscmonthAction() {
           //���¼��������Ǳ���� 
           //ָ��VO�� 
            setVoClass(FeediscmonthVO.class);
            //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ����� 
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "discid"; 
    }
}
