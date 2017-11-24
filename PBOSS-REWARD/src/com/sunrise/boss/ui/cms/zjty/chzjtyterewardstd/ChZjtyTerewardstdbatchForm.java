/**
 * auto-generated code
 * Mon Apr 08 15:52:02 CST 2013
 */
package com.sunrise.boss.ui.cms.zjty.chzjtyterewardstd;

import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;

public class ChZjtyTerewardstdbatchForm extends UploadFileForm {
	private String _region;
	
	public ChZjtyTerewardstdbatchForm() {
		super.setCheckFormat(new ChZjtyTerewardstdCheck());
	}

	public String get_region() {
		return _region;
	}

	public void set_region(String _region) {
		this._region = _region;
	}
}
