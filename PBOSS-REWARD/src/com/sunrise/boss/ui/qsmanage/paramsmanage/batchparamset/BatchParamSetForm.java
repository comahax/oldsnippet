package com.sunrise.boss.ui.qsmanage.paramsmanage.batchparamset;

import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;

public class BatchParamSetForm extends UploadFileForm {

	private static final long serialVersionUID = -4402534739930468587L;
	
	private Long ruleid; 
	
	private String chgreason;


	public String getChgreason() {
		return chgreason;
	}

	public void setChgreason(String chgreason) {
		this.chgreason = chgreason;
	}

	public BatchParamSetForm() {
		this.setCheckFormat(new BatchParamSetCheck());
	}

	public Long getRuleid() {
		return ruleid;
	}

	public void setRuleid(Long ruleid) {
		this.ruleid = ruleid;
		
	}

}
