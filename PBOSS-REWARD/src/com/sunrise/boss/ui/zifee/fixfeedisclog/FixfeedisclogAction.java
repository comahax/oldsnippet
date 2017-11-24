/**
* auto-generated code
* Wed Oct 18 21:00:42 CST 2006
*/
package com.sunrise.boss.ui.zifee.fixfeedisclog;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;

import com.sunrise.boss.business.zifee.fixfeedisc.persistent.PcPsFixfeedislogVO;
import com.sunrise.boss.business.zifee.fixfeedisclog.persistent.FixfeedisclogListVO;
import com.sunrise.boss.common.base.db.BaseListVO;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.BaseDelegateAction;

/**
 * <p>Title: FixfeedisclogAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Danny(luozhoujie)
 * @version 1.0
 */
public class FixfeedisclogAction extends BaseDelegateAction {
    public FixfeedisclogAction() {
        this.voClass = PcPsFixfeedislogVO.class;
        // TODO: 给出主键的名字数组
        this.pkNameArray=new String[1];
        pkNameArray[0] = "logid";
    }
    
    /**
	 * 根据voClass名称获取其ListVO类的一个实例
	 * @return
	 * @throws Exception
	 */
	public BaseListVO getListVO() throws Exception {
		
		String listVoName = "com.sunrise.boss.business.zifee.fixfeedisclog.persistent.FixfeedisclogListVO";	
		Object listVO = Class.forName(listVoName).newInstance();
		return (BaseListVO)listVO;
	}
	
	/**
	 * 根据voClass名称获取其Delegate类的一个实例
	 * @return
	 * @throws Exception
	 */
	public Object getDelegate() throws Exception {
		if(delegateClass!=null)
			return delegateClass.newInstance();
		String delegateClassName = "com.sunrise.boss.delegate.zifee.fixfeedisclog.FixfeedisclogDelegate";
		delegateClass = Class.forName(delegateClassName);
		return delegateClass.newInstance();
		/*
		 * end of add
		 */
	}
	protected void setListVO(Object listVO, final ActionForm listForm) {
		try {
			BeanUtils.copyProperties(listVO, listForm);
			String _desc=((BaseActionForm)listForm).get_desc();
			String _orderby=((BaseActionForm)listForm).get_orderby();
			if("".equals(_desc) && "".equals(_orderby) || _desc==null && _orderby==null)
			{
				((FixfeedisclogListVO)listVO).set_desc("1");
				((FixfeedisclogListVO)listVO).set_orderby("logid");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
