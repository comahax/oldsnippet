package com.sunrise.boss.ui.cms.bbc.mmopn;

import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;

public class BatchMusicForm extends UploadFileForm{
	public BatchMusicForm() {
		super.setCheckFormat(new BatchMusicCheck());
	}

}
