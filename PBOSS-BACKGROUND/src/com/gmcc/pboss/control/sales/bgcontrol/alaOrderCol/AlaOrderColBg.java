package com.gmcc.pboss.control.sales.bgcontrol.alaOrderCol;

import com.sunrise.jop.infrastructure.control.AbstractControl;
/**
 * ��Ԥ�����䵥���ܡ���̨����
 * @author yedaoe
 *
 */
public interface AlaOrderColBg extends AbstractControl {

	/**Ԥ�����䵥������ڷ���*/
	public void doProcess(String coldate) throws Exception;
}
