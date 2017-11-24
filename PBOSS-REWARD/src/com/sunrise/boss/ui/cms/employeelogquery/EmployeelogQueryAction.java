/**
* auto-generated code
* Mon Feb 21 11:05:09 CST 2011
*/
package com.sunrise.boss.ui.cms.employeelogquery;

import com.sunrise.boss.business.cms.employeelogquery.persistent.EmployeelogQueryVO;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.base.BaseDelegateAction;

/**
 * <p>Title: EmployeelogQueryAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public class EmployeelogQueryAction extends BaseDelegateAction {
    public EmployeelogQueryAction() {
            setVoClass(EmployeelogQueryVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "logid"; 
    }
}
