/**
* auto-generated code
* Thu Aug 20 16:16:16 CST 2009
*/
package com.sunrise.boss.delegate.cms.reward.taskstate;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.taskstate.persistent.TaskstateVO;
import com.sunrise.boss.business.cms.reward.taskstate.persistent.TaskstateListVO;
import com.sunrise.boss.business.cms.reward.taskstate.control.TaskstateControlBean;
import com.sunrise.boss.business.cms.reward.taskstate.control.TaskstateControl;

import java.io.Serializable;
import java.util.List;

/**
 * <p>Title: TaskstateDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public class TaskstateDelegate {

    private static TaskstateControl control;

    public TaskstateDelegate() throws Exception {
        control = (TaskstateControl) ControlFactory.build(TaskstateControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public String[] doShow(TaskstateListVO params) throws Exception{
		return control.doShow(params);
	}

    public TaskstateVO doCreate(TaskstateVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(TaskstateVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public TaskstateVO doUpdate(TaskstateVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public TaskstateVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (TaskstateVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(TaskstateListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }
    
    public List showProc(TaskstateListVO params) throws Exception{
		return control.showProc(params);
	}
    
    public TaskstateVO doQueryVO(String ownertaskid, String taskid, String rewardmonth, String city) throws Exception{
		return control.queryVO(ownertaskid, taskid, rewardmonth, city);
	}

}
