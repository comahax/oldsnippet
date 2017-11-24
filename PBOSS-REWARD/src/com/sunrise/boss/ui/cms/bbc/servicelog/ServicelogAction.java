/**
* auto-generated code
* Sat Dec 03 10:15:10 CST 2011
*/
package com.sunrise.boss.ui.cms.bbc.servicelog;

import com.sunrise.boss.business.cms.bbc.servicelog.persistent.ServicelogVO;
import com.sunrise.boss.ui.base.BaseAction;

/**
 * <p>Title: ServicelogAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public class ServicelogAction extends BaseAction {
    public ServicelogAction() {
            setVoClass(ServicelogVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "logid"; 
    }
}
