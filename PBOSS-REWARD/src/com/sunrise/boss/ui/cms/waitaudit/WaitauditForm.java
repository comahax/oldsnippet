/**
* auto-generated code
* Fri Sep 12 10:00:33 CST 2008
*/
package com.sunrise.boss.ui.cms.waitaudit;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.waitaudit.persistent.WaitauditVO;

/**
 * <p>Title: WaitauditForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class WaitauditForm extends BaseActionForm {
    private String _ne_taskid;
    private String _ne_subsystem;
    private String _ne_taskstate;
    private String _se_oprcode;
    private String _se_wayid;
    private String _dnl_createtime;
    private String _dnm_createtime;
    private String _se_auditoprcode;
    private String _se_auditwayid;
    private String _dnl_audittime;
    private String _dnm_audittime;

		private Long taskid;
		private String filecode;
		private Short subsystem;
		private String logfile;
		private Byte taskstate;
		private String oprcode;
		private String wayid;
		private java.util.Date createtime;
		private String auditoprcode;
		private String auditwayid;
		private java.util.Date audittime;
		private Integer totalcount;
		private Integer currentcount;
		private Integer successcount;
		private String resultfile;
		private String memo;

    public String get_ne_taskid(){
        return _ne_taskid;
    }

    public void set_ne_taskid(String _ne_taskid){
        this._ne_taskid = _ne_taskid;
    }
    public String get_ne_subsystem(){
        return _ne_subsystem;
    }

    public void set_ne_subsystem(String _ne_subsystem){
        this._ne_subsystem = _ne_subsystem;
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
    public String get_se_wayid(){
        return _se_wayid;
    }

    public void set_se_wayid(String _se_wayid){
        this._se_wayid = _se_wayid;
    }
    public String get_dnl_createtime(){
        return _dnl_createtime;
    }

    public void set_dnl_createtime(String _dnl_createtime){
        this._dnl_createtime = _dnl_createtime;
    }
    public String get_dnm_createtime(){
        return _dnm_createtime;
    }

    public void set_dnm_createtime(String _dnm_createtime){
        this._dnm_createtime = _dnm_createtime;
    }
    public String get_se_auditoprcode(){
        return _se_auditoprcode;
    }

    public void set_se_auditoprcode(String _se_auditoprcode){
        this._se_auditoprcode = _se_auditoprcode;
    }
    public String get_se_auditwayid(){
        return _se_auditwayid;
    }

    public void set_se_auditwayid(String _se_auditwayid){
        this._se_auditwayid = _se_auditwayid;
    }
    public String get_dnl_audittime(){
        return _dnl_audittime;
    }

    public void set_dnl_audittime(String _dnl_audittime){
        this._dnl_audittime = _dnl_audittime;
    }
    public String get_dnm_audittime(){
        return _dnm_audittime;
    }

    public void set_dnm_audittime(String _dnm_audittime){
        this._dnm_audittime = _dnm_audittime;
    }

		public  Long getTaskid() {
        return taskid;
    }
		public void setTaskid(Long taskid) {
        this.taskid=taskid;
    }
		public  String getFilecode() {
        return filecode;
    }
		public void setFilecode(String filecode) {
        this.filecode=filecode;
    }
		public  Short getSubsystem() {
        return subsystem;
    }
		public void setSubsystem(Short subsystem) {
        this.subsystem=subsystem;
    }
		public  String getLogfile() {
        return logfile;
    }
		public void setLogfile(String logfile) {
        this.logfile=logfile;
    }
		public  Byte getTaskstate() {
        return taskstate;
    }
		public void setTaskstate(Byte taskstate) {
        this.taskstate=taskstate;
    }
		public  String getOprcode() {
        return oprcode;
    }
		public void setOprcode(String oprcode) {
        this.oprcode=oprcode;
    }
		public  String getWayid() {
        return wayid;
    }
		public void setWayid(String wayid) {
        this.wayid=wayid;
    }
		public  java.util.Date getCreatetime() {
        return createtime;
    }
		public void setCreatetime(java.util.Date createtime) {
        this.createtime=createtime;
    }
		public  String getAuditoprcode() {
        return auditoprcode;
    }
		public void setAuditoprcode(String auditoprcode) {
        this.auditoprcode=auditoprcode;
    }
		public  String getAuditwayid() {
        return auditwayid;
    }
		public void setAuditwayid(String auditwayid) {
        this.auditwayid=auditwayid;
    }
		public  java.util.Date getAudittime() {
        return audittime;
    }
		public void setAudittime(java.util.Date audittime) {
        this.audittime=audittime;
    }
		public  Integer getTotalcount() {
        return totalcount;
    }
		public void setTotalcount(Integer totalcount) {
        this.totalcount=totalcount;
    }
		public  Integer getCurrentcount() {
        return currentcount;
    }
		public void setCurrentcount(Integer currentcount) {
        this.currentcount=currentcount;
    }
		public  Integer getSuccesscount() {
        return successcount;
    }
		public void setSuccesscount(Integer successcount) {
        this.successcount=successcount;
    }
		public  String getResultfile() {
        return resultfile;
    }
		public void setResultfile(String resultfile) {
        this.resultfile=resultfile;
    }
		public  String getMemo() {
        return memo;
    }
		public void setMemo(String memo) {
        this.memo=memo;
    }

}
