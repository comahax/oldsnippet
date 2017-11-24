/**
* auto-generated code
* Wed Oct 18 16:15:34 CST 2006
*/
package com.sunrise.boss.ui.cms.postinfolog;

import com.sunrise.boss.ui.base.BaseActionForm;

/**
 * <p>Title: PostinfologForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
public class PostinfologForm extends BaseActionForm {
    private String _dnl_optime;
    private String _dnm_optime;
    private String _sk_oprcode;
    private String _se_oprtype;
    private String _se_success;

		private Long logid;
		private java.util.Date optime;
		private String oprcode;
		private String oprtype;
		private String success;
		private Long postid;
		private String postname;
		private Short postkind;
		private Long parentpost;
		private String way;
		private String waykind;
		private java.util.Date startime;
		private java.util.Date overtime;
		private Short status;
		private Short workkind;
		private String purviewmemo;

    public String get_dnl_optime(){
        return _dnl_optime;
    }

    public void set_dnl_optime(String _dnl_optime){
        this._dnl_optime = _dnl_optime;
    }
    public String get_dnm_optime(){
        return _dnm_optime;
    }

    public void set_dnm_optime(String _dnm_optime){
        this._dnm_optime = _dnm_optime;
    }
    public String get_sk_oprcode(){
        return _sk_oprcode;
    }

    public void set_sk_oprcode(String _sk_oprcode){
        this._sk_oprcode = _sk_oprcode;
    }
    public String get_se_oprtype(){
        return _se_oprtype;
    }

    public void set_se_oprtype(String _se_oprtype){
        this._se_oprtype = _se_oprtype;
    }
    public String get_se_success(){
        return _se_success;
    }

    public void set_se_success(String _se_success){
        this._se_success = _se_success;
    }

		public  Long getLogid() {
        return logid;
    }
		public void setLogid(Long logid) {
        this.logid=logid;
    }
		public  java.util.Date getOptime() {
        return optime;
    }
		public void setOptime(java.util.Date optime) {
        this.optime=optime;
    }
		public  String getOprcode() {
        return oprcode;
    }
		public void setOprcode(String oprcode) {
        this.oprcode=oprcode;
    }
		public  String getOprtype() {
        return oprtype;
    }
		public void setOprtype(String oprtype) {
        this.oprtype=oprtype;
    }
		public  String getSuccess() {
        return success;
    }
		public void setSuccess(String success) {
        this.success=success;
    }
		public  Long getPostid() {
        return postid;
    }
		public void setPostid(Long postid) {
        this.postid=postid;
    }
		public  String getPostname() {
        return postname;
    }
		public void setPostname(String postname) {
        this.postname=postname;
    }
		public  Short getPostkind() {
        return postkind;
    }
		public void setPostkind(Short postkind) {
        this.postkind=postkind;
    }
		public  Long getParentpost() {
        return parentpost;
    }
		public void setParentpost(Long parentpost) {
        this.parentpost=parentpost;
    }
		public  String getWay() {
        return way;
    }
		public void setWay(String way) {
        this.way=way;
    }
		public String getWaykind() {
        return waykind;
    }
		public void setWaykind(String waykind) {
        this.waykind=waykind;
    }
		public  java.util.Date getStartime() {
        return startime;
    }
		public void setStartime(java.util.Date startime) {
        this.startime=startime;
    }
		public  java.util.Date getOvertime() {
        return overtime;
    }
		public void setOvertime(java.util.Date overtime) {
        this.overtime=overtime;
    }
		public  Short getStatus() {
        return status;
    }
		public void setStatus(Short status) {
        this.status=status;
    }
		public  Short getWorkkind() {
        return workkind;
    }
		public void setWorkkind(Short workkind) {
        this.workkind=workkind;
    }
		public  String getPurviewmemo() {
        return purviewmemo;
    }
		public void setPurviewmemo(String purviewmemo) {
        this.purviewmemo=purviewmemo;
    }

}
