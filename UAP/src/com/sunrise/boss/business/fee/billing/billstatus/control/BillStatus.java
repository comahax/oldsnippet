package com.sunrise.boss.business.fee.billing.billstatus.control;

import java.util.List;

import com.sunrise.boss.business.fee.billing.billstatus.persistent.BillStatusDBParam;
import com.sunrise.boss.business.fee.billing.billstatus.persistent.BillStatusVO;
import com.sunrise.boss.business.fee.billing.validbillcyc.persistent.ValidBillCycVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.ui.User;


public interface BillStatus extends AbstractControl {
	
	public String[] doShow(BillStatusDBParam params) throws Exception;

	public List doShowProc(BillStatusDBParam params) throws Exception;

	public void doStart(int type, BillStatusVO vo, User user) throws Exception;

	public String doQueryYueqie(String validbillcyc) throws Exception;

	public BillStatusVO doQueryVO(String phase, String subphase, String validbillcyc, String city) throws Exception;

	public String doQueryConfirmBill(BillStatusDBParam listVO) throws Exception;
	
	public ValidBillCycVO getValidBillCyc(String cityid) throws Exception;
	
	/**
	 * 获取预付费出账过程监控各步骤的状态信息
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public String[] doShowPrepaidFee(BillStatusDBParam params) throws Exception;
}
