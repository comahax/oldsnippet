/**
* auto-generated code
* Fri Feb 15 15:21:19 CST 2008
*/
package com.sunrise.boss.ui.cms.reward.busiload;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.reward.busiload.persistent.BusiloadVO;

/**
 * <p>Title: BusiloadForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author zeng jianxin
 * @version 1.0
 */
public class BusiloadForm extends BaseActionForm {
    private String _se_loadinfo;
    private String _se_loadtype;

		private String opnid;
		private String loadinfo;
		private String loadtype;

    public String get_se_loadinfo(){
        return _se_loadinfo;
    }

    public void set_se_loadinfo(String _se_loadinfo){
        this._se_loadinfo = _se_loadinfo;
    }
    public String get_se_loadtype(){
        return _se_loadtype;
    }

    public void set_se_loadtype(String _se_loadtype){
        this._se_loadtype = _se_loadtype;
    }

		public  String getOpnid() {
        return opnid;
    }
		public void setOpnid(String opnid) {
        this.opnid=opnid;
    }
		public  String getLoadinfo() {
        return loadinfo;
    }
		public void setLoadinfo(String loadinfo) {
        this.loadinfo=loadinfo;
    }
		public  String getLoadtype() {
        return loadtype;
    }
		public void setLoadtype(String loadtype) {
        this.loadtype=loadtype;
    }

}
