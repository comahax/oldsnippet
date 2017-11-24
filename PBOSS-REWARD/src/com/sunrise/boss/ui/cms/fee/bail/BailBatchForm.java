package com.sunrise.boss.ui.cms.fee.bail;

import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;
import com.sunrise.boss.ui.cms.fee.bail.BailBatchCheck;
public class BailBatchForm  extends UploadFileForm {

	private Short oprtype;
	
	public BailBatchForm(){
		this.setCheckFormat(new BailBatchCheck());
	}
	
	public Short getOprtype() {
		return oprtype;
	}

	public void setOprtype(Short oprtype) {
		this.oprtype = oprtype;
	}
}
