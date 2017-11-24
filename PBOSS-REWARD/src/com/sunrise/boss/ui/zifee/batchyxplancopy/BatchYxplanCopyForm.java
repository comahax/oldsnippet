package com.sunrise.boss.ui.zifee.batchyxplancopy;

import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;

/**
 * @author zengjianxin
 */
public class BatchYxplanCopyForm extends UploadFileForm {

	public BatchYxplanCopyForm() {
		this.setCheckFormat(new BatchYxplanCopyCheck());
	}

}