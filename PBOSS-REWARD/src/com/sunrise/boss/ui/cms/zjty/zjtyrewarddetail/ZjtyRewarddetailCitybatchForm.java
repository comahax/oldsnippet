package com.sunrise.boss.ui.cms.zjty.zjtyrewarddetail;

import com.sunrise.boss.ui.cms.zjty.zjtyrewarddetail.upload.AddZjtyRewarddetailCityCheck;


import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;

public class ZjtyRewarddetailCitybatchForm extends UploadFileForm {

	private String oprtype;

	public ZjtyRewarddetailCitybatchForm() {
		this.setCheckFormat(new AddZjtyRewarddetailCityCheck());
	}

	public String getOprtype() {
		return oprtype;
	}

	public void setOprtype(String oprtype) {
		this.oprtype = oprtype;
		if (oprtype.equals("0")) {
			this.setCheckFormat(new AddZjtyRewarddetailCityCheck());
		}
	}
}