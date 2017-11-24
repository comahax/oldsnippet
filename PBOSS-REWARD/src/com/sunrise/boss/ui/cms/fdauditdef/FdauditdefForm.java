/**
* auto-generated code
* Thu Jul 26 17:37:14 CST 2007
*/
package com.sunrise.boss.ui.cms.fdauditdef;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.fdauditdef.persistent.FdauditdefVO;

/**
 * <p>Title: FdauditdefForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class FdauditdefForm extends BaseActionForm {
    private String _sk_tablename; 
    private String _sk_tablechname;
    private String _sk_field;
    private String _sk_fieldchname;
    private String _sk_typename;
    private String _sk_typechname;
    private Short _ne_state;

		private String tablename;	//表名
		private String tablechname;	//表中文名
		private String field;		//待审批字段名
		private String fieldchname; //待审批字段中文名
		private Short fieldtype;	//待审批字段类型
		private String pkname;		//主键名
		private Short pktype;		//主键类型
		private String pkname2;		//主键名2
		private Short pktype2;		//主键类型2
		private String typename;	//数据类型名称
		private String typechname;	//数据类型中文名称
		private Short state;        //启用状态

    public String get_sk_tablename(){
        return _sk_tablename;
    }

    public void set_sk_tablename(String _sk_tablename){
        this._sk_tablename = _sk_tablename;
    }
    public String get_sk_tablechname(){
        return _sk_tablechname;
    }

    public void set_sk_tablechname(String _sk_tablechname){
        this._sk_tablechname = _sk_tablechname;
    }
    public String get_sk_field(){
        return _sk_field;
    }

    public void set_sk_field(String _sk_field){
        this._sk_field = _sk_field;
    }
    public String get_sk_fieldchname(){
        return _sk_fieldchname;
    }

    public void set_sk_fieldchname(String _sk_fieldchname){
        this._sk_fieldchname = _sk_fieldchname;
    }
    public String get_sk_typename(){
        return _sk_typename;
    }

    public void set_sk_typename(String _sk_typename){
        this._sk_typename = _sk_typename;
    }
    public String get_sk_typechname(){
        return _sk_typechname;
    }

    public void set_sk_typechname(String _sk_typechname){
        this._sk_typechname = _sk_typechname;
    }

    public Short get_ne_state() {
		return _ne_state;
	}

	public void set_ne_state(Short _ne_state) {
		this._ne_state = _ne_state;
	}
		public  String getTablename() {
        return tablename;
    }
		public void setTablename(String tablename) {
        this.tablename=tablename;
    }
		public  String getTablechname() {
        return tablechname;
    }
		public void setTablechname(String tablechname) {
        this.tablechname=tablechname;
    }
		public  String getField() {
        return field;
    }
		public void setField(String field) {
        this.field=field;
    }
		public  String getFieldchname() {
        return fieldchname;
    }
		public void setFieldchname(String fieldchname) {
        this.fieldchname=fieldchname;
    }
		public  Short getFieldtype() {
        return fieldtype;
    }
		public void setFieldtype(Short fieldtype) {
        this.fieldtype=fieldtype;
    }
		public  String getPkname() {
        return pkname;
    }
		public void setPkname(String pkname) {
        this.pkname=pkname;
    }
		public  Short getPktype() {
        return pktype;
    }
		public void setPktype(Short pktype) {
        this.pktype=pktype;
    }
		public  String getPkname2() {
        return pkname2;
    }
		public void setPkname2(String pkname2) {
        this.pkname2=pkname2;
    }
		public  Short getPktype2() {
        return pktype2;
    }
		public void setPktype2(Short pktype2) {
        this.pktype2=pktype2;
    }
		public  String getTypename() {
        return typename;
    }
		public void setTypename(String typename) {
        this.typename=typename;
    }
		public  String getTypechname() {
        return typechname;
    }
		public void setTypechname(String typechname) {
        this.typechname=typechname;
    }

		public Short getState() {
			return state;
		}

		public void setState(Short state) {
			this.state = state;
		}

		

}

