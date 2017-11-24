/**
* auto-generated code
* Wed Oct 18 14:54:55 CST 2006
*/
package com.sunrise.boss.ui.cms.waycompctlog;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;

import com.sunrise.boss.ui.base.*;
import com.sunrise.boss.business.cms.waycompctlog.persistent.WaycompctlogListVO;
import com.sunrise.boss.business.cms.waycompctlog.persistent.WaycompctlogVO;

/**
 * <p>Title: WaycompctlogAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
public class WaycompctlogAction extends BaseDelegateAction {
    public WaycompctlogAction() {
           //以下几个方法是必须的 
           //指定VO类 
            setVoClass(WaycompctlogVO.class);
            //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称 
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "logid"; 
    }
    protected void setListVO(Object listVO, final ActionForm listForm) {
		try {
			BeanUtils.copyProperties(listVO, listForm);
			String _desc=((BaseActionForm)listForm).get_desc();
			String _orderby=((BaseActionForm)listForm).get_orderby();
			if("".equals(_desc) && "".equals(_orderby) || _desc==null && _orderby==null)
			{
				((WaycompctlogListVO)listVO).set_desc("1");
				((WaycompctlogListVO)listVO).set_orderby("logid");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
