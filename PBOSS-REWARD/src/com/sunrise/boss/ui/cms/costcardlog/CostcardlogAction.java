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
           //���¼��������Ǳ���� 
           //ָ��VO�� 
            setVoClass(CostcardlogVO.class);
            //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ����� 
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "logid"; 
    }
}
