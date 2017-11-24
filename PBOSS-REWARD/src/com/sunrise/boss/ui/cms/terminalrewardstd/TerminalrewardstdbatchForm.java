package com.sunrise.boss.ui.cms.terminalrewardstd;



import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;

public class TerminalrewardstdbatchForm extends UploadFileForm {

	public TerminalrewardstdbatchForm() {
		// TODO Auto-generated constructor stub
		super.setCheckFormat(new TerminalrewardstdCheck());
	}

}
