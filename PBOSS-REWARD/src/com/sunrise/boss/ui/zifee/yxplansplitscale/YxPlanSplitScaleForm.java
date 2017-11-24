package com.sunrise.boss.ui.zifee.yxplansplitscale;

import com.sunrise.boss.ui.base.BaseActionForm;

public class YxPlanSplitScaleForm extends BaseActionForm{
    /** identifier field */
    private Long yxplanid;

    /** identifier field */
    private String yxplanitemid;

    /** identifier field */
    private Long yxplankindid;

    /** identifier field */
    private Long yxplantypeid;

    /** persistent field */
    private Float scale;
    
    private String _ne_yxplanid;
	private String _ne_yxplantypeid;
	private String _ne_yxplankindid;
	private String _ne_yxplanitemid;

	public String get_ne_yxplanid(){
		return this._ne_yxplanid;
	}
	
	public void set_ne_yxplanid(String _ne_yxplanid){
		this._ne_yxplanid = _ne_yxplanid;
	}
	
	public String get_ne_yxplantypeid(){
		return this._ne_yxplantypeid;
	}
	
	public void set_ne_yxplantypeid(String _ne_yxplantypeid){
		this._ne_yxplantypeid = _ne_yxplantypeid;
	}
	
	public String get_ne_yxplankindid(){
		return this._ne_yxplankindid;
	}
	
	public void set_ne_yxplankindid(String _ne_yxplankindid){
		this._ne_yxplankindid = _ne_yxplankindid;
	}
	
	public String get_ne_yxplanitemid(){
		return this._ne_yxplanitemid;
	}
	
	public void set_ne_yxplanitemid(String _ne_yxplanitemid){
		this._ne_yxplanitemid = _ne_yxplanitemid;
	}
	
    /** full constructor */
    public YxPlanSplitScaleForm(java.lang.Long yxplanid, java.lang.String yxplanitemid, java.lang.Long yxplankindid, java.lang.Long yxplantypeid, java.lang.Float scale) {
        this.yxplanid = yxplanid;
        this.yxplanitemid = yxplanitemid;
        this.yxplankindid = yxplankindid;
        this.yxplantypeid = yxplantypeid;
        this.scale = scale;
    }

    /** default constructor */
    public YxPlanSplitScaleForm() {
    }

    public java.lang.Long getYxplanid() {
        return this.yxplanid;
    }

    public void setYxplanid(java.lang.Long yxplanid) {
        this.yxplanid = yxplanid;
    }

    public java.lang.String getYxplanitemid() {
        return this.yxplanitemid;
    }

    public void setYxplanitemid(java.lang.String yxplanitemid) {
        this.yxplanitemid = yxplanitemid;
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

    public java.lang.Float getScale() {
        return this.scale;
    }

    public void setScale(java.lang.Float scale) {
        this.scale = scale;
    }

}
