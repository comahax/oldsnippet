/**
 * 
 */
package com.sunrise.boss.business.fee.billing.uapreq.control;

import java.io.Serializable;

import com.sunrise.boss.business.fee.billing.uapreq.persistent.UapReqDBParam;
import com.sunrise.boss.business.fee.billing.uapreq.persistent.UapReqVO;
import com.sunrise.boss.business.fee.billing.uapreq.persistent.UapRuDownloadDBParam;
import com.sunrise.boss.business.fee.billing.uapreq.persistent.UapRuDownloadVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2005
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author panmeifa
 * @version 1.0
 */
public interface UapReq extends AbstractControl {
	public UapReqVO doCreate(UapReqVO vo)
			throws Exception;

	public void doRemove(UapReqVO vo)
	        throws Exception;

	public UapReqVO doUpdate(UapReqVO vo)
			throws Exception;

	public UapReqVO doFindByPk(Serializable pk)
			throws Exception;

	public DataPackage doQuery(UapReqDBParam params)
			throws Exception;
	
	public void doSaveFixfeeReq(UapReqVO vo, String filename)
			throws Exception;
	
	public void doSaveProdReq(UapReqVO vo, String filename)
			throws Exception;
	
	public UapRuDownloadVO getUploadPath(UapRuDownloadDBParam param) 
			throws Exception;
	
	public void doSaveReqAndRu(UapReqVO vo, UapRuDownloadVO uapRuDownloadVO)
			throws Exception;
}
