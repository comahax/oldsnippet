/**
* auto-generated code
* Fri Feb 01 11:50:09 CST 2013
*/
package com.sunrise.boss.ui.cms.chadtclassplatformbrandinfo;

import com.sunrise.boss.business.cms.chadtclassplatformbrandinfo.persistent.ChAdtClassplatformbrandinfoVO;
import com.sunrise.boss.ui.base.BaseAction;

/**
 * <p>Title: ChAdtClassplatformbrandinfoAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author limin
 * @version 1.0
 */
public class ChAdtClassplatformbrandinfoAction extends BaseAction {
    public ChAdtClassplatformbrandinfoAction() {
            setVoClass(ChAdtClassplatformbrandinfoVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "brandid"; 
    }
}
