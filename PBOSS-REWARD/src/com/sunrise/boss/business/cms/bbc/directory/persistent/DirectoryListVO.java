/**
* auto-generated code
* Tue Mar 12 15:11:57 CST 2013
*/
package com.sunrise.boss.business.cms.bbc.directory.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: DirectoryListVO</p>
 * <p>Description: Query Params Object for DirectoryDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
public class DirectoryListVO extends BaseListVO {
    private String _se_firstlevel;
    private String _se_secondlevel;
    private String _se_thirdlevel;
    private String _se_opnid;

    public String get_se_firstlevel(){
        return _se_firstlevel;
    }

    public void set_se_firstlevel(String _se_firstlevel){
        this._se_firstlevel = _se_firstlevel;
    }
    public String get_se_secondlevel(){
        return _se_secondlevel;
    }

    public void set_se_secondlevel(String _se_secondlevel){
        this._se_secondlevel = _se_secondlevel;
    }
    public String get_se_thirdlevel(){
        return _se_thirdlevel;
    }

    public void set_se_thirdlevel(String _se_thirdlevel){
        this._se_thirdlevel = _se_thirdlevel;
    }

    public String get_se_opnid() {
        return _se_opnid;
    }

    public void set_se_opnid(String _se_opnid) {
        this._se_opnid = _se_opnid;
    }

}
