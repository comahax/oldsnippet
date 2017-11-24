package com.gmcc.pboss.business.reward.chcwpaymentsend;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

public class VChCwPaymentsendDBParam extends DBQueryParam {
	private String _se_sbatch;

	public String get_se_sbatch() {
		return _se_sbatch;
	}

	public void set_se_sbatch(String _se_sbatch) {
		this._se_sbatch = _se_sbatch;
	}

}
