/**
* auto-generated code
* Sat Nov 28 17:48:47 CST 2009
*/
package com.sunrise.boss.business.cms.examine.mapping.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: MappingListVO</p>
 * <p>Description: Query Params Object for MappingDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class MappingListVO extends BaseListVO {
    private String _ne_seqid;
    private String _ne_exmnid;
    private String _se_cityid;
    private String _nne_seqid;

    public String get_ne_seqid(){
        return _ne_seqid;
    }

    public void set_ne_seqid(String _ne_seqid){
        this._ne_seqid = _ne_seqid;
    }
    public String get_ne_exmnid(){
        return _ne_exmnid;
    }

    public void set_ne_exmnid(String _ne_exmnid){
        this._ne_exmnid = _ne_exmnid;
    }
    public String get_se_cityid(){
        return _se_cityid;
    }

    public void set_se_cityid(String _se_cityid){
        this._se_cityid = _se_cityid;
    }

	public String get_nne_seqid() {
		return _nne_seqid;
	}

	public void set_nne_seqid(String _nne_seqid) {
		this._nne_seqid = _nne_seqid;
	}

}
