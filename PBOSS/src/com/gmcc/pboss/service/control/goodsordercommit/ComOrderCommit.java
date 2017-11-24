package com.gmcc.pboss.service.control.goodsordercommit;

import java.util.List;

import com.gmcc.pboss.service.result.RetResult;
import com.gmcc.pboss.service.send.ComOrder;
import com.sunrise.jop.infrastructure.control.AbstractControl;

public interface ComOrderCommit extends AbstractControl {

	public RetResult doCheck(String wayid, boolean isQueryDetail, List<ComOrder> comOrderList) throws Exception;
	
}
