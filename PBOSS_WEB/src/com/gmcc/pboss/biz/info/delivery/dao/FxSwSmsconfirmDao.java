package com.gmcc.pboss.biz.info.delivery.dao;

import java.util.List;
import java.util.Date;

import com.gmcc.pboss.common.dao.BaseDao;
import com.gmcc.pboss.model.sms.FxSwSmsconfirm;

public interface FxSwSmsconfirmDao extends BaseDao{
	
	public FxSwSmsconfirm getSmsconfirm(String type, String mobileno,String orderid,String state);

}
