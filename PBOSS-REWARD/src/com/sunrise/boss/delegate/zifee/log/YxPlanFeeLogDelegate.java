/**
* auto-generated code
* Sun Aug 20 11:47:03 CST 2006
*/
package com.sunrise.boss.delegate.zifee.log;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.business.zifee.log.persistent.YxPlanFeeLogVO;
import com.sunrise.boss.business.zifee.log.persistent.YxPlanFeeLogListVO;
import com.sunrise.boss.business.zifee.log.control.YxPlanFeeLogControl;
import com.sunrise.boss.business.zifee.log.control.YxPlanFeeLogControlBean;
import com.sunrise.boss.ui.commons.User;
import java.io.Serializable;

/**
 * <p>Title: YxPlanFeeLogDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Danny(luozhoujie)
 * @version 1.0
 */
public class YxPlanFeeLogDelegate {

    private YxPlanFeeLogControl control;

    public YxPlanFeeLogDelegate() throws Exception {
        control = (YxPlanFeeLogControl) ControlFactory.build(YxPlanFeeLogControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public YxPlanFeeLogVO doCreate(YxPlanFeeLogVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(YxPlanFeeLogVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }
    public YxPlanFeeLogVO doUpdate(YxPlanFeeLogVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public YxPlanFeeLogVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (YxPlanFeeLogVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(YxPlanFeeLogListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }
    /*
     * 记录日志
     */
    public YxPlanFeeLogVO doLog(String oprtype,String oprobject,String oprresult)
    throws Exception {
    	YxPlanFeeLogVO vo = new YxPlanFeeLogVO();
    	User user = new User();
    	vo.setOprcode(user.getOpercode());
    	vo.setOprobject(oprobject);
    	vo.setOprtype(oprtype);    	
    	vo.setOprtime(new java.util.Date());    	
    	if((null==oprresult) || (oprresult.length()==0))
    	{
    		vo.setOprresult("操作成功");
    	}else{
    		vo.setOprresult(oprresult);
    	}
    	return this.doCreate(vo,user);
    }
}
