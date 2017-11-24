/**
* auto-generated code
* Thu Nov 15 12:26:37 CST 2007
*/
package com.sunrise.boss.ui.zifee.feediscmolog;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.zifee.feediscmolog.persistent.FeediscmologVO;

/**
 * <p>Title: FeediscmologForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author zeng jianxin
 * @version 1.0
 */
public class FeediscmologForm extends BaseActionForm {
    private String _dnl_optime;
    private String _dnm_optime;
    private String _se_oprcode;
    private String _se_oprtype;
    private String _se_success;
    private String _ne_yxplanid;
    private String _ne_disctype;
    private String _nnl_discvalue;
    private String _nnm_discvalue;
    private String _sk_discbill;
    private String _sk_excludebill;

		private Long logid;
		private java.util.Date optime;
		private String oprcode;
		private String oprtype;
		private String success;
		private Long discid;
		private Long yxplanid;
		private Short disctype;
		private Double discvalue;
		private Integer presentprio;
		private Byte presentbalanceflag;
		private String discbill;
		private String excludebill;

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
    public String get_se_oprcode(){
        return _se_oprcode;
    }

    public void set_se_oprcode(String _se_oprcode){
        this._se_oprcode = _se_oprcode;
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
    public String get_ne_yxplanid(){
        return _ne_yxplanid;
    }

    public void set_ne_yxplanid(String _ne_yxplanid){
        this._ne_yxplanid = _ne_yxplanid;
    }
    public String get_ne_disctype(){
        return _ne_disctype;
    }

    public void set_ne_disctype(String _ne_disctype){
        this._ne_disctype = _ne_disctype;
    }
    public String get_nnl_discvalue(){
        return _nnl_discvalue;
    }

    public void set_nnl_discvalue(String _nnl_discvalue){
        this._nnl_discvalue = _nnl_discvalue;
    }
    public String get_nnm_discvalue(){
        return _nnm_discvalue;
    }

    public void set_nnm_discvalue(String _nnm_discvalue){
        this._nnm_discvalue = _nnm_discvalue;
    }
    public String get_sk_discbill(){
        return _sk_discbill;
    }

    public void set_sk_discbill(String _sk_discbill){
        this._sk_discbill = _sk_discbill;
    }
    public String get_sk_excludebill(){
        return _sk_excludebill;
    }

    public void set_sk_excludebill(String _sk_excludebill){
        this._sk_excludebill = _sk_excludebill;
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
		public  Long getDiscid() {
        return discid;
    }
		public void setDiscid(Long discid) {
        this.discid=discid;
    }
		public  Long getYxplanid() {
        return yxplanid;
    }
		public void setYxplanid(Long yxplanid) {
        this.yxplanid=yxplanid;
    }
		public  Short getDisctype() {
        return disctype;
    }
		public void setDisctype(Short disctype) {
        this.disctype=disctype;
    }
		public  Double getDiscvalue() {
        return discvalue;
    }
		public void setDiscvalue(Double discvalue) {
        this.discvalue=discvalue;
    }
		public  Integer getPresentprio() {
        return presentprio;
    }
		public void setPresentprio(Integer presentprio) {
        this.presentprio=presentprio;
    }
		public  Byte getPresentbalanceflag() {
        return presentbalanceflag;
    }
		public void setPresentbalanceflag(Byte presentbalanceflag) {
        this.presentbalanceflag=presentbalanceflag;
    }
		public  String getDiscbill() {
        return discbill;
    }
		public void setDiscbill(String discbill) {
        this.discbill=discbill;
    }
		public  String getExcludebill() {
        return excludebill;
    }
		public void setExcludebill(String excludebill) {
        this.excludebill=excludebill;
    }

}
