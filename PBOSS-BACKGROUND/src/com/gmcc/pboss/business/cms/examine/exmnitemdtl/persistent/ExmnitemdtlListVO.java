package com.gmcc.pboss.business.cms.examine.exmnitemdtl.persistent;

import com.sunrise.jop.infrastructure.db.DBQueryParam;


/**
 * <p>
 * Title: ExmnitemdtlListVO
 * </p>
 * <p>
 * Description: Query Params Object for ExmnitemdtlDAO
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author
 * @version 1.0
 */
public class ExmnitemdtlListVO extends DBQueryParam {
	private String _ne_seqid;
	private String _ne_exmnid;
	private String _ne_exmnstdid;
	private String _se_cityid;
	private String _ne_pseqid;
	private String _nn_pseqid;

	private Double _nnl_largestcrtcl;
	private Double _nnm_leastcrtcl;

	public Double get_nnl_largestcrtcl() {
		return _nnl_largestcrtcl;
	}

	public void set_nnl_largestcrtcl(Double _nnl_largestcrtcl) {
		this._nnl_largestcrtcl = _nnl_largestcrtcl;
	}

	public Double get_nnm_leastcrtcl() {
		return _nnm_leastcrtcl;
	}

	public void set_nnm_leastcrtcl(Double _nnm_leastcrtcl) {
		this._nnm_leastcrtcl = _nnm_leastcrtcl;
	}

	public String get_ne_pseqid() {
		return _ne_pseqid;
	}

	public void set_ne_pseqid(String _ne_pseqid) {
		this._ne_pseqid = _ne_pseqid;
	}

	public String get_ne_seqid() {
		return _ne_seqid;
	}

	public void set_ne_seqid(String _ne_seqid) {
		this._ne_seqid = _ne_seqid;
	}

	public String get_ne_exmnid() {
		return _ne_exmnid;
	}

	public void set_ne_exmnid(String _ne_exmnid) {
		this._ne_exmnid = _ne_exmnid;
	}

	public String get_ne_exmnstdid() {
		return _ne_exmnstdid;
	}

	public void set_ne_exmnstdid(String _ne_exmnstdid) {
		this._ne_exmnstdid = _ne_exmnstdid;
	}

	public String get_se_cityid() {
		return _se_cityid;
	}

	public void set_se_cityid(String _se_cityid) {
		this._se_cityid = _se_cityid;
	}

	public String get_nn_pseqid() {
		return _nn_pseqid;
	}

	public void set_nn_pseqid(String _nn_pseqid) {
		this._nn_pseqid = _nn_pseqid;
	}

}
