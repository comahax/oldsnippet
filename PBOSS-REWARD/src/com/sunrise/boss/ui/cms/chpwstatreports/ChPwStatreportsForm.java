/**
* auto-generated code
* Thu Jul 03 15:10:27 CST 2014
*/
package com.sunrise.boss.ui.cms.chpwstatreports;

import java.util.ArrayList;
import com.sunrise.boss.ui.base.BaseActionForm;

/**
 * <p>Title: ChPwStatreportsForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public class ChPwStatreportsForm extends BaseActionForm {

    private java.lang.Long seq;
    private java.lang.String cityid;
    private java.lang.Byte state;
    private java.lang.String filepath;
    private java.lang.String filename;
    private java.lang.String remark; 
    private String rewardmonth;
    private ArrayList _sin_cityid;
	 private String _ne_state;

    public java.lang.Long getSeq(){
        return seq;
    }

    public void setSeq(java.lang.Long seq){
        this.seq = seq;
    }
    public java.lang.String getCityid(){
        return cityid;
    }

    public void setCityid(java.lang.String cityid){
        this.cityid = cityid;
    }
    public java.lang.Byte getState(){
        return state;
    }

    public void setState(java.lang.Byte state){
        this.state = state;
    }
    public java.lang.String getFilepath(){
        return filepath;
    }

    public void setFilepath(java.lang.String filepath){
        this.filepath = filepath;
    }
    public java.lang.String getFilename(){
        return filename;
    }

    public void setFilename(java.lang.String filename){
        this.filename = filename;
    }
    public java.lang.String getRemark(){
        return remark;
    }

    public void setRemark(java.lang.String remark){
        this.remark = remark;
    } 
	public String get_ne_state() {
		return _ne_state;
	}

	public void set_ne_state(String _ne_state) {
		this._ne_state = _ne_state;
	}

	public ArrayList get_sin_cityid() {
		return _sin_cityid;
	}

	public void set_sin_cityid(ArrayList _sin_cityid) {
		this._sin_cityid = _sin_cityid;
	}

	public String getRewardmonth() {
		return rewardmonth;
	}

	public void setRewardmonth(String rewardmonth) {
		this.rewardmonth = rewardmonth;
	}


}
