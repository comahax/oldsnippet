package com.gmcc.pboss.control.sales.bgcontrol.resInfoStat;

import com.sunrise.jop.infrastructure.control.AbstractControl;

/**
 * 网点资源信息统计
 * @author zhangsiwei
 *
 */
public interface ResInfoStat extends AbstractControl {

	/**网点资源信息统计入口参数*/
	public void doProcess() throws Exception;
}
