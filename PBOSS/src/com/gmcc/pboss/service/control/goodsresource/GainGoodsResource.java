package com.gmcc.pboss.service.control.goodsresource;

import com.gmcc.pboss.service.result.goods.GoodsResource;
import com.sunrise.jop.infrastructure.control.AbstractControl;

public interface GainGoodsResource extends AbstractControl {

	public GoodsResource doGain(String wayid, String comType, int orderCount) throws Exception;
	
}
