/**
* auto-generated code
* Thu Aug 20 16:16:59 CST 2009
*/
package com.sunrise.boss.ui.cms.reward.montask;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.reward.montask.persistent.MontaskVO;

/**
 * <p>Title: MontaskForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public class MontaskForm extends BaseActionForm {

    private java.lang.Long taskid;
    private java.lang.Long ownertaskid;
    private java.lang.String taskname;
    private java.lang.Short tasklevel;
    private java.lang.Short runorder;
    private java.lang.String type;
    private java.lang.Short state;


    public java.lang.Long getTaskid(){
        return taskid;
    }

    public void setTaskid(java.lang.Long taskid){
        this.taskid = taskid;
    }
    public java.lang.Long getOwnertaskid(){
        return ownertaskid;
    }

    public void setOwnertaskid(java.lang.Long ownertaskid){
        this.ownertaskid = ownertaskid;
    }
    public java.lang.String getTaskname(){
        return taskname;
    }

    public void setTaskname(java.lang.String taskname){
        this.taskname = taskname;
    }
    public java.lang.Short getTasklevel(){
        return tasklevel;
    }

    public void setTasklevel(java.lang.Short tasklevel){
        this.tasklevel = tasklevel;
    }
    public java.lang.Short getRunorder(){
        return runorder;
    }

    public void setRunorder(java.lang.Short runorder){
        this.runorder = runorder;
    }
    public java.lang.String getType(){
        return type;
    }

    public void setType(java.lang.String type){
        this.type = type;
    }
    public java.lang.Short getState(){
        return state;
    }

    public void setState(java.lang.Short state){
        this.state = state;
    }


}
