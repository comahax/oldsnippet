/**
* auto-generated code
* Tue Mar 12 15:11:57 CST 2013
*/
package com.sunrise.boss.ui.cms.bbc.directory;

import com.sunrise.boss.business.cms.bbc.directory.persistent.DirectoryVO;
import com.sunrise.boss.ui.base.BaseAction;

/**
 * <p>Title: DirectoryAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
public class DirectoryAction extends BaseAction {
    public DirectoryAction() {
            setVoClass(DirectoryVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "opnid"; 
    }
}
