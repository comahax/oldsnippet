/**
* auto-generated code
* Thu Aug 20 16:16:16 CST 2009
*/
package com.sunrise.boss.business.cms.reward.taskstate.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.taskstate.persistent.TaskstateVO;
import com.sunrise.boss.business.cms.reward.taskstate.persistent.TaskstateListVO;

import java.io.Serializable;
import java.util.List;

/**
 * <p>Title: TaskstateControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public interface TaskstateControl extends AbstractControl {
    public TaskstateVO doCreate(TaskstateVO vo, User user)
        throws Exception;

    public void doRemove(TaskstateVO vo, User user)
        throws Exception;

    public TaskstateVO doUpdate(TaskstateVO vo, User user)
        throws Exception;

    public TaskstateVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(TaskstateListVO params, User user)
        throws Exception;
    
    public String[] doShow(TaskstateListVO params) throws Exception;

    public List showProc(TaskstateListVO params) throws Exception;
    
    public TaskstateVO queryVO(String ownertaskid, String taskid, String rewardmonth, String city) throws Exception;
}
