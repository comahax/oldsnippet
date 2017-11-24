/**
* auto-generated code
* Sun Aug 27 12:00:09 CST 2006
*/
package com.sunrise.boss.ui.cms.postinfo;

import com.sunrise.boss.ui.base.BaseActionForm;

/**
 * <p>Title: PostinfoForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author yjr
 * @version 1.0
 */
public class PostinfoForm extends BaseActionForm {
	
	private String _ne_postid;
	
	private String _sk_postname;
	
	private String _ne_waykind;
	
	private String _sk_way;
	
    /** identifier field */
    private Long postid;

    /** nullable persistent field */
    private String postname;

    /** nullable persistent field */
    private Short postkind;

    /** nullable persistent field */
    private Long parentpost;

    /** nullable persistent field */
    private String way;

    /** nullable persistent field */
    private String waykind;

    /** nullable persistent field */
    private java.sql.Date startime;

    /** nullable persistent field */
    private java.sql.Date overtime;

    /** nullable persistent field */
    private Short status;

    /** nullable persistent field */
    private Short workkind;

    /** nullable persistent field */
    private String purviewmemo;

	public String get_ne_postid() {
		return _ne_postid;
	}

	public void set_ne_postid(String _ne_postid) {
		this._ne_postid = _ne_postid;
	}

	public String get_sk_postname() {
		return _sk_postname;
	}

	public void set_sk_postname(String _sk_postname) {
		this._sk_postname = _sk_postname;
	}

	public java.sql.Date getOvertime() {
		return overtime;
	}

	public void setOvertime(java.sql.Date overtime) {
		this.overtime = overtime;
	}

	public Long getParentpost() {
		return parentpost;
	}

	public void setParentpost(Long parentpost) {
		this.parentpost = parentpost;
	}

	public Long getPostid() {
		return postid;
	}

	public void setPostid(Long postid) {
		this.postid = postid;
	}

	public Short getPostkind() {
		return postkind;
	}

	public void setPostkind(Short postkind) {
		this.postkind = postkind;
	}

	public String getPostname() {
		return postname;
	}

	public void setPostname(String postname) {
		this.postname = postname;
	}

	public String getPurviewmemo() {
		return purviewmemo;
	}

	public void setPurviewmemo(String purviewmemo) {
		this.purviewmemo = purviewmemo;
	}

	public java.sql.Date getStartime() {
		return startime;
	}

	public void setStartime(java.sql.Date startime) {
		this.startime = startime;
	}

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public String getWay() {
		return way;
	}

	public void setWay(String way) {
		this.way = way;
	}

	public String getWaykind() {
		return waykind;
	}

	public void setWaykind(String waykind) {
		this.waykind = waykind;
	}

	public Short getWorkkind() {
		return workkind;
	}

	public void setWorkkind(Short workkind) {
		this.workkind = workkind;
	}

	public String get_ne_waykind() {
		return _ne_waykind;
	}

	public void set_ne_waykind(String _ne_waykind) {
		this._ne_waykind = _ne_waykind;
	}

	public String get_sk_way() {
		return _sk_way;
	}

	public void set_sk_way(String _sk_way) {
		this._sk_way = _sk_way;
	}
    
    
}
