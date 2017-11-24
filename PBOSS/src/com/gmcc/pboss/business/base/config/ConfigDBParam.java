package com.gmcc.pboss.business.base.config;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

public class ConfigDBParam extends DBQueryParam {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6901836512720195231L;
	private String _se_key;
	private String _se_value;

	public ConfigDBParam() {

	}

	public String get_se_key() {
		return _se_key;
	}

	public void set_se_key(String _se_key) {
		this._se_key = _se_key;
	}

	public String get_se_value() {
		return _se_value;
	}

	public void set_se_value(String _se_value) {
		this._se_value = _se_value;
	}

}
