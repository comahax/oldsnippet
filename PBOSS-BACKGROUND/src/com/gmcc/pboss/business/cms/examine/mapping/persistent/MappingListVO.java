package com.gmcc.pboss.business.cms.examine.mapping.persistent;

import com.sunrise.jop.infrastructure.db.DBQueryParam;


/**
 * <p>Title: MappingListVO</p>
 * <p>Description: Query Params Object for MappingDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class MappingListVO extends DBQueryParam {
    private String _ne_seqid;
    private String _ne_exmnid;
    private String _se_cityid;
    
    private Double _nnl_markll;
    private Double _nl_markul;

    public Double get_nnl_markll() {
		return _nnl_markll;
	}

	public void set_nnl_markll(Double _nnl_markll) {
		this._nnl_markll = _nnl_markll;
	}

	public Double get_nl_markul() {
		return _nl_markul;
	}

	public void set_nl_markul(Double _nl_markul) {
		this._nl_markul = _nl_markul;
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
    public String get_se_cityid(){
        return _se_cityid;
    }

    public void set_se_cityid(String _se_cityid){
        this._se_cityid = _se_cityid;
    }

}
