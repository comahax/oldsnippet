package com.gmcc.pboss.control.sales.notice;

import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.gmcc.pboss.BgProcess.sales.notice.DeliverInfo;
import com.gmcc.pboss.business.base.smstmpl.SmstmplVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBQueryParam;
import com.sunrise.jop.infrastructure.db.DataPackage;

public interface DeliverTakeGoodsNotice extends AbstractControl{

	public void doNotice() throws Exception;
	public SmstmplVO doGetSmsTemplete() throws Exception;
	public List<DeliverInfo> doGetDelivers(Date startTime,Date endTime) throws Exception;
	public void doStateComcate(List<DeliverInfo> delivers, Date startTime,Date endTime) throws Exception;
	public void doSmsReplace(List<DeliverInfo> delivers,SmstmplVO smstmp,Date nowDate) throws Exception;
	
	public DataPackage doQueryBySql(String sql,DBQueryParam param) throws Exception;
}
