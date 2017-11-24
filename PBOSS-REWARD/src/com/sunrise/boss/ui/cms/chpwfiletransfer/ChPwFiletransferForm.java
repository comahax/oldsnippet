/**
* auto-generated code
* Thu Jul 03 15:10:27 CST 2014
*/
package com.sunrise.boss.ui.cms.chpwfiletransfer;

import java.util.ArrayList;
import com.sunrise.boss.ui.base.BaseActionForm;

/**
 * <p>Title: ChPwFiletransferForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public class ChPwFiletransferForm extends BaseActionForm {

    private java.lang.Long seq;
    private java.lang.String cityid;
    private java.lang.Byte state;
    private java.lang.String filepath;
    private java.lang.String filename;
    private java.lang.String remark; 
    private ArrayList _sin_cityid;
	 private String _ne_state;

	 private String _dnm_datadate;//
	 private String _dnl_datadate;//

	
	    
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

	/**
     * @return Returns the _dnm_datadate.
     */
    public String get_dnm_datadate() {
        return this._dnm_datadate;
    }
    /**
     * @param _sk_companyname The _dnm_datadate to set.
     */
    public void set_dnm_datadate(String _dnm_datadate) {
        this._dnm_datadate = _dnm_datadate;
    }

	/**
     * @return Returns the _dnl_datadate.
     */
    public String get_dnl_datadate() {
        return this._dnl_datadate;
    }
    /**
     * @param _sk_companyname The _dnl_datadate to set.
     */
    public void set_dnl_datadate(String _dnl_datadate) {
        this._dnl_datadate = _dnl_datadate;
    }

}
