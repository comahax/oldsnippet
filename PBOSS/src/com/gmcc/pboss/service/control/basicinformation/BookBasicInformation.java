package com.gmcc.pboss.service.control.basicinformation;

import com.gmcc.pboss.service.result.goods.BookBasicInfo;
import com.sunrise.jop.infrastructure.control.AbstractControl;

public interface BookBasicInformation extends AbstractControl {

	public BookBasicInfo doCheck(String wayid) throws Exception;
	
}
