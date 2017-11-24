package com.gmcc.pboss.control.sales.bgcontrol.SellMidClear;

import java.util.Date;

import com.sunrise.jop.infrastructure.control.AbstractControl;

/**
 * 销售中间表清理
 * @author zhangsiwei
 *
 */
public interface SellMidClear extends AbstractControl {

	public void doProcess(Date overdueDate) throws Exception;
}
