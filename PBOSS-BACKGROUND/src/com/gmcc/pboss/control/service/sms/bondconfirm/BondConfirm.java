package com.gmcc.pboss.control.service.sms.bondconfirm;

import com.sunrise.jop.infrastructure.control.AbstractControl;

/**
 * 
 * 新增【保证金上缴申请单确认】短厅接口逻辑
 * 功能描述：配送商通过回复短信确认结果信息
 * @author dengxingxin
 *
 */
public interface BondConfirm extends AbstractControl {

	/**
	 * 
	 * @param tranData 传输数据
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doConfirm(String tranData)
			throws Exception;
}
