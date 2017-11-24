package com.sunrise.boss.ui.cms.emprole;
import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;

public class BatchEmproleForm extends UploadFileForm{
	public BatchEmproleForm() {
		super.setCheckFormat(new BatchEmproleCheck());
	}

}
