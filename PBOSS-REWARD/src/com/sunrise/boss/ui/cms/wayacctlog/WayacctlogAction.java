/**
* auto-generated code
* Wed Oct 18 14:55:37 CST 2006
*/
package com.sunrise.boss.ui.cms.wayacctlog;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;

import com.sunrise.boss.ui.base.*;
import com.sunrise.boss.business.cms.areacterlog.persistent.AreacterlogListVO;
import com.sunrise.boss.business.cms.wayacctlog.persistent.WayacctlogListVO;
import com.sunrise.boss.business.cms.wayacctlog.persistent.WayacctlogVO;
import com.sunrise.boss.delegate.cms.wayacctlog.WayacctlogDelegate;

/**
 * <p>Title: WayacctlogAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
public class WayacctlogAction extends BaseDelegateAction {
    public WayacctlogAction() {
           //以下几个方法是必须的 
           //指定VO类 
            setVoClass(WayacctlogVO.class);
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
				((WayacctlogListVO)listVO).set_desc("1");
				((WayacctlogListVO)listVO).set_orderby("logid");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
