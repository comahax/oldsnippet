package com.sunrise.boss.ui.cms.zjty.zjtyrewardcoef;

import com.sunrise.boss.ui.cms.zjty.zjtyrewardcoef.upload.AddZjtyRewardcoefCheck;
import com.sunrise.boss.ui.cms.zjty.zjtyrewardcoef.upload.UpdateZjtyRewardcoefCheck;
import com.sunrise.boss.ui.cms.zjty.zjtyrewardcoef.upload.DelZjtyRewardcoefCheck;

import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;

public class ZjtyRewardcoefbatchForm extends UploadFileForm {

	private String oprtype;

	public ZjtyRewardcoefbatchForm() {
		this.setCheckFormat(new AddZjtyRewardcoefCheck());
	}

	public String getOprtype() {
		return oprtype;
	}

	public void setOprtype(String oprtype) {
		this.oprtype = oprtype;
		if (oprtype.equals("0")) {
			this.setCheckFormat(new AddZjtyRewardcoefCheck());
		} else if (oprtype.equals("1")) {
			this.setCheckFormat(new UpdateZjtyRewardcoefCheck());
		} else if (oprtype.equals("2")) {
			this.setCheckFormat(new DelZjtyRewardcoefCheck());
		}
	}

}
