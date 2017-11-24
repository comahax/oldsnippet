/**
* auto-generated code
* Thu Jul 26 16:12:39 CST 2007
*/
package com.sunrise.boss.ui.cms.fdaudit;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.fdaudit.persistent.FdauditVO;

/**
 * <p>Title: FdauditForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author yuanweihai
 * @version 1.0
 */
public class FdauditForm extends BaseActionForm {
    private String _ne_recno;
    private String _se_tablename;
    private String _se_typename;
    private String _se_pkvalue;
    private String _se_pkvalue2;
    private String _se_field;
    private String _se_fieldvalue;
    private String _ne_auditstatus;
    private String fromURL;

		private Long recno;
		private String tablename;
		private String typename;
		private String pkvalue;
		private String pkvalue2;
		private String field;
		private String fieldvalue;
		private String operid;
		private java.util.Date optime;
		private Short auditstatus;
		private String auditoperid;
		private java.util.Date audittime;
		//private String auditOpr;    //审批的动作（通过/不通过）
		
    public String get_ne_recno(){
        return _ne_recno;
    }

    public void set_ne_recno(String _ne_recno){
        this._ne_recno = _ne_recno;
    }
    public String get_se_tablename(){
        return _se_tablename;
    }

    public void set_se_tablename(String _se_tablename){
        this._se_tablename = _se_tablename;
    }
    public String get_se_typename(){
        return _se_typename;
    }

    public void set_se_typename(String _se_typename){
        this._se_typename = _se_typename;
    }
    public String get_se_pkvalue(){
        return _se_pkvalue;
    }

    public void set_se_pkvalue(String _se_pkvalue){
        this._se_pkvalue = _se_pkvalue;
    }
    public String get_se_pkvalue2(){
        return _se_pkvalue2;
    }

    public void set_se_pkvalue2(String _se_pkvalue2){
        this._se_pkvalue2 = _se_pkvalue2;
    }
    public String get_se_field(){
        return _se_field;
    }

    public void set_se_field(String _se_field){
        this._se_field = _se_field;
    }
    public String get_se_fieldvalue(){
        return _se_fieldvalue;
    }

    public void set_se_fieldvalue(String _se_fieldvalue){
        this._se_fieldvalue = _se_fieldvalue;
    }
    public String get_ne_auditstatus(){
        return _ne_auditstatus;
    }

    public void set_ne_auditstatus(String _ne_auditstatus){
        this._ne_auditstatus = _ne_auditstatus;
    }

		public  Long getRecno() {
        return recno;
    }
		public void setRecno(Long recno) {
        this.recno=recno;
    }
		public  String getTablename() {
        return tablename;
    }
		public void setTablename(String tablename) {
        this.tablename=tablename;
    }
		public  String getTypename() {
        return typename;
    }
		public void setTypename(String typename) {
        this.typename=typename;
    }
		public  String getPkvalue() {
        return pkvalue;
    }
		public void setPkvalue(String pkvalue) {
        this.pkvalue=pkvalue;
    }
		public  String getPkvalue2() {
        return pkvalue2;
    }
		public void setPkvalue2(String pkvalue2) {
        this.pkvalue2=pkvalue2;
    }
		public  String getField() {
        return field;
    }
		public void setField(String field) {
        this.field=field;
    }
		public  String getFieldvalue() {
        return fieldvalue;
    }
		public void setFieldvalue(String fieldvalue) {
        this.fieldvalue=fieldvalue;
    }
		public  String getOperid() {
        return operid;
    }
		public void setOperid(String operid) {
        this.operid=operid;
    }
		public  java.util.Date getOptime() {
        return optime;
    }
		public void setOptime(java.util.Date optime) {
        this.optime=optime;
    }
		public  Short getAuditstatus() {
        return auditstatus;
    }
		public void setAuditstatus(Short auditstatus) {
        this.auditstatus=auditstatus;
    }
		public  String getAuditoperid() {
        return auditoperid;
    }
		public void setAuditoperid(String auditoperid) {
        this.auditoperid=auditoperid;
    }
		public  java.util.Date getAudittime() {
        return audittime;
    }
		public void setAudittime(java.util.Date audittime) {
        this.audittime=audittime;
    }

		public String getFromURL() {
			return fromURL;
		}

		public void setFromURL(String fromURL) {
			this.fromURL = fromURL;
		}


}
