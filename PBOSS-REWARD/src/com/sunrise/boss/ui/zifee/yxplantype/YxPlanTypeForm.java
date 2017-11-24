package com.sunrise.boss.ui.zifee.yxplantype;
import com.sunrise.boss.ui.base.BaseActionForm;

public class YxPlanTypeForm extends BaseActionForm{
	/** identifier field */
    private Long yxplankindid;

    /** identifier field */
    private Long yxplantypeid;

    /** persistent field */
    private String yxplantypename;
	private String _ne_yxplankindid;
	private String _sk_yxplantypename;
	
    public java.lang.String get_ne_yxplankindid() {
        return this._ne_yxplankindid;
    }

    public void set_ne_yxplankindid(java.lang.String _ne_yxplankindid) {
        this._ne_yxplankindid = _ne_yxplankindid;
    }
    public java.lang.String get_sk_yxplantypename() {
        return this._sk_yxplantypename;
    }

    public void set_sk_yxplantypename(java.lang.String _sk_yxplantypename) {
        this._sk_yxplantypename = _sk_yxplantypename;
    }
    /** full constructor */
    public YxPlanTypeForm(java.lang.Long yxplankindid, java.lang.Long yxplantypeid, java.lang.String yxplantypename) {
        this.yxplankindid = yxplankindid;
        this.yxplantypeid = yxplantypeid;
        this.yxplantypename = yxplantypename;
    }

    /** default constructor */
    public YxPlanTypeForm() {
    }

    public java.lang.Long getYxplankindid() {
        return this.yxplankindid;
    }

    public void setYxplankindid(java.lang.Long yxplankindid) {
        this.yxplankindid = yxplankindid;
    }

    public java.lang.Long getYxplantypeid() {
        return this.yxplantypeid;
    }

    public void setYxplantypeid(java.lang.Long yxplantypeid) {
        this.yxplantypeid = yxplantypeid;
    }

    public java.lang.String getYxplantypename() {
        return this.yxplantypename;
    }

    public void setYxplantypename(java.lang.String yxplantypename) {
        this.yxplantypename = yxplantypename;
    }

}
