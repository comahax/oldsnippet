package com.sunrise.boss.ui.cms.provagent.vchpdrprewardrecord;

import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;

public class VChPdRprewardrecordbatchForm extends UploadFileForm {
	
	public VChPdRprewardrecordbatchForm() {
		super.setCheckFormat(new VChPdRprewardrecordCheck());
	}
}
