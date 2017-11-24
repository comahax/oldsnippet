package com.sunrise.boss.ui.zifee.yxplankind;

import com.sunrise.boss.ui.base.BaseActionForm;

public class YxPlanKindForm extends BaseActionForm{
	/** identifier field */
    private Long yxplankindid;

    /** nullable persistent field */
    private String yxplankindname;
    
	private String _sk_yxplankindname;
	
    public java.lang.String get_sk_yxplankindname() {
        return this._sk_yxplankindname;
    }

    public void set_sk_yxplankindname(java.lang.String _sk_yxplankindname) {
        this._sk_yxplankindname = _sk_yxplankindname;
    }
    /** full constructor */
    public YxPlanKindForm(java.lang.String yxplankindname) {
        this.yxplankindname = yxplankindname;
    }

    /** default constructor */
    public YxPlanKindForm() {
    }

    public java.lang.Long getYxplankindid() {
        return this.yxplankindid;
    }

    public void setYxplankindid(java.lang.Long yxplankindid) {
        this.yxplankindid = yxplankindid;
    }

    public java.lang.String getYxplankindname() {
        return this.yxplankindname;
    }

    public void setYxplankindname(java.lang.String yxplankindname) {
        this.yxplankindname = yxplankindname;
    }
}
