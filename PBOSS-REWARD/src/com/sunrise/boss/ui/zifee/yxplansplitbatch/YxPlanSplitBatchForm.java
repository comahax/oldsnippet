package com.sunrise.boss.ui.zifee.yxplansplitbatch;

import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;
import com.sunrise.boss.ui.zifee.yxplansplitbatch.YxPlanSplitBatchCheck;

public class YxPlanSplitBatchForm extends UploadFileForm {

	private Short oprtype;
	
	public YxPlanSplitBatchForm(){
		this.setCheckFormat(new YxPlanSplitBatchCheck());
	}


	public Short getOprtype() {
		return oprtype;
	}

	public void setOprtype(Short oprtype) {
		this.oprtype = oprtype;
	}
	
	 
}