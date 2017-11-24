package com.gmcc.pboss.service.control.goodspriceradix;

import com.gmcc.pboss.service.result.goods.GoodsInfo;
import com.sunrise.jop.infrastructure.control.AbstractControl;

public interface QueryGoodsPriceRadix extends AbstractControl {

	public GoodsInfo doQuery(String wayid, String comType) throws Exception;
	
}
