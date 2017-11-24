/**
* auto-generated code
* Thu Mar 15 15:06:14 CST 2012
*/
package com.sunrise.boss.ui.cms.reward.adtrewardupload;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.reward.adtrewardupload.persistent.AdtRewarduploadVO;

/**
 * <p>Title: AdtRewarduploadForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Qiu Zhi
 * @version 1.0
 */
public class AdtRewarduploadForm extends BaseActionForm {

    private java.lang.Long taskid;
    private java.lang.String uploadfile;
    private java.lang.Byte taskstate;
    private java.lang.String resultfile;
    private java.lang.String oprcode;
    private java.util.Date uploadtime;
    private java.util.Date endtime;
    private java.lang.Integer totalcount;
    private java.lang.Integer currentcount;
    private java.lang.Integer successcount;
    private java.lang.Integer failcount;
    private java.lang.String mobile;
    private java.lang.Double successsum;

    private String _ne_taskid;
    private String _ne_taskstate;
    private String _se_oprcode;
    private String _dnm_uploadtime;
    private String _dnl_uploadtime;
    private String _se_mobile;

    public java.lang.Long getTaskid(){
        return taskid;
    }

    public void setTaskid(java.lang.Long taskid){
        this.taskid = taskid;
    }
    public java.lang.String getUploadfile(){
        return uploadfile;
    }

    public void setUploadfile(java.lang.String uploadfile){
        this.uploadfile = uploadfile;
    }
    public java.lang.Byte getTaskstate(){
        return taskstate;
    }

    public void setTaskstate(java.lang.Byte taskstate){
        this.taskstate = taskstate;
    }
    public java.lang.String getResultfile(){
        return resultfile;
    }

    public void setResultfile(java.lang.String resultfile){
        this.resultfile = resultfile;
    }
    public java.lang.String getOprcode(){
        return oprcode;
    }

    public void setOprcode(java.lang.String oprcode){
        this.oprcode = oprcode;
    }
    public java.util.Date getUploadtime(){
        return uploadtime;
    }

    public void setUploadtime(java.util.Date uploadtime){
        this.uploadtime = uploadtime;
    }
    public java.util.Date getEndtime(){
        return endtime;
    }

    public void setEndtime(java.util.Date endtime){
        this.endtime = endtime;
    }
    public java.lang.Integer getTotalcount(){
        return totalcount;
    }

    public void setTotalcount(java.lang.Integer totalcount){
        this.totalcount = totalcount;
    }
    public java.lang.Integer getCurrentcount(){
        return currentcount;
    }

    public void setCurrentcount(java.lang.Integer currentcount){
        this.currentcount = currentcount;
    }
    public java.lang.Integer getSuccesscount(){
        return successcount;
    }

    public void setSuccesscount(java.lang.Integer successcount){
        this.successcount = successcount;
    }
    public java.lang.Integer getFailcount(){
        return failcount;
    }

    public java.lang.Double getSuccesssum() {
		return successsum;
	}

	public void setSuccesssum(java.lang.Double successsum) {
		this.successsum = successsum;
	}

	public void setFailcount(java.lang.Integer failcount){
        this.failcount = failcount;
    }
    public java.lang.String getMobile(){
        return mobile;
    }

    public void setMobile(java.lang.String mobile){
        this.mobile = mobile;
    }

    public String get_ne_taskid(){
        return _ne_taskid;
    }

    public void set_ne_taskid(String _ne_taskid){
        this._ne_taskid = _ne_taskid;
    }
    public String get_ne_taskstate(){
        return _ne_taskstate;
    }

    public void set_ne_taskstate(String _ne_taskstate){
        this._ne_taskstate = _ne_taskstate;
    }
    public String get_se_oprcode(){
        return _se_oprcode;
    }

    public void set_se_oprcode(String _se_oprcode){
        this._se_oprcode = _se_oprcode;
    }
    public String get_dnm_uploadtime(){
        return _dnm_uploadtime;
    }

    public void set_dnm_uploadtime(String _dnm_uploadtime){
        this._dnm_uploadtime = _dnm_uploadtime;
    }
    public String get_dnl_uploadtime(){
        return _dnl_uploadtime;
    }

    public void set_dnl_uploadtime(String _dnl_uploadtime){
        this._dnl_uploadtime = _dnl_uploadtime;
    }
    public String get_se_mobile(){
        return _se_mobile;
    }

    public void set_se_mobile(String _se_mobile){
        this._se_mobile = _se_mobile;
    }

}
