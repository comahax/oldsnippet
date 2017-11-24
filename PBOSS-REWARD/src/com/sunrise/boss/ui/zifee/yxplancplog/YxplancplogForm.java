/**
* auto-generated code
* Sun Sep 23 15:29:50 CST 2007
*/
package com.sunrise.boss.ui.zifee.yxplancplog;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.zifee.yxplancplog.persistent.YxplancplogVO;

/**
 * <p>Title: YxplancplogForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author zeng jianxin
 * @version 1.0
 */
public class YxplancplogForm extends BaseActionForm {
    private String _dnl_createtime;
    private String _dnm_createtime;
    private String _sk_oprcode;
    private String _se_oprtype;
    private String _sk_batchno;
    private String _se_oprresulte;
    private String _se_oprstate;

		private Long logid;
		private java.util.Date createtime;
		private java.util.Date modifytime;
		private String oprcode;
		private String oprtype;
		private Long orgyxplanid;
		private Long newyxplanid;
		private String copyitem;
		private String batchno;
		private String oprresulte;
		private String oprstate;
		private String oprobject;
		private String remark;

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
    public String get_sk_batchno(){
        return _sk_batchno;
    }

    public void set_sk_batchno(String _sk_batchno){
        this._sk_batchno = _sk_batchno;
    }
    public String get_se_oprresulte(){
        return _se_oprresulte;
    }

    public void set_se_oprresulte(String _se_oprresulte){
        this._se_oprresulte = _se_oprresulte;
    }
    public String get_se_oprstate(){
        return _se_oprstate;
    }

    public void set_se_oprstate(String _se_oprstate){
        this._se_oprstate = _se_oprstate;
    }

		public  Long getLogid() {
        return logid;
    }
		public void setLogid(Long logid) {
        this.logid=logid;
    }
		public  java.util.Date getCreatetime() {
        return createtime;
    }
		public void setCreatetime(java.util.Date createtime) {
        this.createtime=createtime;
    }
		public  java.util.Date getModifytime() {
        return modifytime;
    }
		public void setModifytime(java.util.Date modifytime) {
        this.modifytime=modifytime;
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
		public  Long getOrgyxplanid() {
        return orgyxplanid;
    }
		public void setOrgyxplanid(Long orgyxplanid) {
        this.orgyxplanid=orgyxplanid;
    }
		public  Long getNewyxplanid() {
        return newyxplanid;
    }
		public void setNewyxplanid(Long newyxplanid) {
        this.newyxplanid=newyxplanid;
    }
		public  String getCopyitem() {
        return copyitem;
    }
		public void setCopyitem(String copyitem) {
        this.copyitem=copyitem;
    }
		public  String getBatchno() {
        return batchno;
    }
		public void setBatchno(String batchno) {
        this.batchno=batchno;
    }
		public  String getOprresulte() {
        return oprresulte;
    }
		public void setOprresulte(String oprresulte) {
        this.oprresulte=oprresulte;
    }
		public  String getOprstate() {
        return oprstate;
    }
		public void setOprstate(String oprstate) {
        this.oprstate=oprstate;
    }
		public  String getOprobject() {
        return oprobject;
    }
		public void setOprobject(String oprobject) {
        this.oprobject=oprobject;
    }
		public  String getRemark() {
        return remark;
    }
		public void setRemark(String remark) {
        this.remark=remark;
    }

}
