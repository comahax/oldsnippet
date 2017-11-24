/**
* auto-generated code
* Tue Feb 22 09:29:17 CST 2011
*/
package com.sunrise.boss.ui.cms.chadtdictparam;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.chadtdictparam.persistent.ChAdtDictparamVO;

/**
 * <p>Title: ChAdtDictparamForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public class ChAdtDictparamForm extends BaseActionForm {

    private java.lang.String dkey;
    private java.lang.String dvalue;
    private java.lang.Byte state;
    private java.lang.String type;
    private java.lang.String dicttype;

    private String checked;
    
    public String getChecked() {
		return checked;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}

	public java.lang.String getDkey(){
        return dkey;
    }

    public void setDkey(java.lang.String dkey){
        this.dkey = dkey;
    }
    public java.lang.String getDvalue(){
        return dvalue;
    }

    public void setDvalue(java.lang.String dvalue){
        this.dvalue = dvalue;
    }
    public java.lang.Byte getState(){
        return state;
    }

    public void setState(java.lang.Byte state){
        this.state = state;
    }
    public java.lang.String getType(){
        return type;
    }

    public void setType(java.lang.String type){
        this.type = type;
    }
    public java.lang.String getDicttype(){
        return dicttype;
    }

    public void setDicttype(java.lang.String dicttype){
        this.dicttype = dicttype;
    }


}
