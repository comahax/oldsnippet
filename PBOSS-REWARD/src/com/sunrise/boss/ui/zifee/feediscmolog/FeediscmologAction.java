/**
* auto-generated code
* Thu Nov 15 12:26:36 CST 2007
*/
package com.sunrise.boss.ui.zifee.feediscmolog;

import com.sunrise.boss.ui.base.*;
import com.sunrise.boss.business.zifee.feediscmolog.persistent.FeediscmologVO;

/**
 * <p>Title: FeediscmologAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author zeng jianxin
 * @version 1.0
 */
public class FeediscmologAction extends BaseDelegateAction {
    public FeediscmologAction() {
           //���¼��������Ǳ���� 
           //ָ��VO�� 
            setVoClass(FeediscmologVO.class);
            //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ����� 
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "logid"; 
    }
}
