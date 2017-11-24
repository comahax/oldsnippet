/**
* auto-generated code
* Wed Nov 25 11:16:38 CST 2009
*/
package com.sunrise.boss.business.cms.examine.exmnitemdtl.persistent;

import java.util.List;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: ExmnitemdtlListVO</p>
 * <p>Description: Query Params Object for ExmnitemdtlDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ExmnitemdtlListVO extends BaseListVO {
    private String _ne_seqid;
    private String _ne_exmnid;
    private String _ne_exmnstdid;
    private String _se_cityid;
    private String _ne_pseqid;
    private String _nn_pseqid;
    private List _nin_pseqid;
    public List get_nin_pseqid() {
		return _nin_pseqid;
	}

	public void set_nin_pseqid(List _nin_pseqid) {
		this._nin_pseqid = _nin_pseqid;
	}

	public String get_ne_pseqid() {
		return _ne_pseqid;
	}

	public void set_ne_pseqid(String _ne_pseqid) {
		this._ne_pseqid = _ne_pseqid;
	}

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
    public String get_ne_exmnstdid(){
        return _ne_exmnstdid;
    }

    public void set_ne_exmnstdid(String _ne_exmnstdid){
        this._ne_exmnstdid = _ne_exmnstdid;
    }
    public String get_se_cityid(){
        return _se_cityid;
    }

    public void set_se_cityid(String _se_cityid){
        this._se_cityid = _se_cityid;
    }

	public String get_nn_pseqid() {
		return _nn_pseqid;
	}

	public void set_nn_pseqid(String _nn_pseqid) {
		this._nn_pseqid = _nn_pseqid;
	}

}
