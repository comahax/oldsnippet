/**
* auto-generated code
* Wed Nov 18 16:15:36 CST 2009
*/
package com.sunrise.boss.ui.cms.examine.examinelog;

import com.sunrise.boss.business.cms.examine.examinelog.persistent.ExaminelogVO;
import com.sunrise.boss.ui.base.BaseAction;

/**
 * <p>Title: ExaminelogAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ExaminelogAction extends BaseAction {
    public ExaminelogAction() {
            setVoClass(ExaminelogVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "logid"; 
    }
}
