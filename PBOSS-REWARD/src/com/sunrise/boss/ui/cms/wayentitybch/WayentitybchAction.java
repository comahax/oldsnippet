/**
* auto-generated code
* Sat Aug 26 11:34:28 CST 2006
*/
package com.sunrise.boss.ui.cms.wayentitybch;

import com.sunrise.boss.ui.base.*;
import com.sunrise.boss.business.cms.wayentitybch.persistent.WayentitybchListVO;
import com.sunrise.boss.business.cms.wayentitybch.persistent.WayentitybchVO;
import com.sunrise.boss.delegate.cms.wayentitybch.WayentitybchDelegate;

/**
 * <p>Title: WayentitybchAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
public class WayentitybchAction extends BaseDelegateAction {
    public WayentitybchAction() {
           //���¼��������Ǳ���� 
           //ָ��VO�� 
            setVoClass(WayentitybchVO.class);
            //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ����� 
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "wayid"; 
    }
}
