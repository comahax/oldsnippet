/**
* auto-generated code
* Tue Oct 17 17:36:16 CST 2006
*/
package com.sunrise.boss.ui.cms.bchtypelog;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;

import com.sunrise.boss.ui.base.*;
import com.sunrise.boss.business.cms.bchtypelog.persistent.BchtypelogListVO;
import com.sunrise.boss.business.cms.bchtypelog.persistent.BchtypelogVO;
import com.sunrise.boss.delegate.cms.bchtypelog.BchtypelogDelegate;

/**
 * <p>Title: BchtypelogAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
public class BchtypelogAction extends BaseDelegateAction {
    public BchtypelogAction() {
           //以下几个方法是必须的 
           //指定VO类 
            setVoClass(BchtypelogVO.class);
            //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称 
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "id"; 
    }
    protected void setListVO(Object listVO, final ActionForm listForm) {
		try {
			BeanUtils.copyProperties(listVO, listForm);
			String _desc=((BaseActionForm)listForm).get_desc();
			String _orderby=((BaseActionForm)listForm).get_orderby();
			if("".equals(_desc) && "".equals(_orderby) || _desc==null && _orderby==null)
			{
				((BchtypelogListVO)listVO).set_desc("1");
				((BchtypelogListVO)listVO).set_orderby("logid");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
