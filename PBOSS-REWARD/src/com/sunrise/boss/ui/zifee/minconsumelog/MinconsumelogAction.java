/**
* auto-generated code
* Fri Aug 08 15:19:25 CST 2008
*/
package com.sunrise.boss.ui.zifee.minconsumelog;

import com.sunrise.boss.ui.base.*;
import com.sunrise.boss.business.zifee.minconsumelog.persistent.MinconsumelogListVO;
import com.sunrise.boss.business.zifee.minconsumelog.persistent.MinconsumelogVO;

/**
 * <p>Title: MinconsumelogAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class MinconsumelogAction extends BaseDelegateAction {
    public MinconsumelogAction() {
           //���¼��������Ǳ���� 
           //ָ��VO�� 
            setVoClass(MinconsumelogVO.class);
            //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ����� 
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "logid"; 
    }
}
