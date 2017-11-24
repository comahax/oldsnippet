/**
* auto-generated code
* Tue May 01 15:39:58 CST 2007
*/
package com.sunrise.boss.ui.cms.coststatrelative;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.coststatrelative.persistent.CoststatrelativeVO;

/**
 * <p>Title: CoststatrelativeForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author Cai Jianhui
 * @version 1.0
 */
public class CoststatrelativeForm extends BaseActionForm {
    private String _ne_recid;
    private String _ne_statmode;

		private Long recid;
		private Short fnlcostitem;
		private Short statmode;

    public String get_ne_recid(){
        return _ne_recid;
    }

    public void set_ne_recid(String _ne_id){
        this._ne_recid = _ne_id;
    }
    public String get_ne_statmode(){
        return _ne_statmode;
    }

    public void set_ne_statmode(String _ne_statmode){
        this._ne_statmode = _ne_statmode;
    }

		public  Long getRecid() {
        return recid;
    }
		public void setRecid(Long id) {
        this.recid=id;
    }
		public  Short getFnlcostitem() {
        return fnlcostitem;
    }
		public void setFnlcostitem(Short fnlcostitem) {
        this.fnlcostitem=fnlcostitem;
    }
		public  Short getStatmode() {
        return statmode;
    }
		public void setStatmode(Short statmode) {
        this.statmode=statmode;
    }

}
