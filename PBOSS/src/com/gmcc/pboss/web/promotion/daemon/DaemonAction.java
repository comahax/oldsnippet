/**
 * auto-generated code
 * Thu Sep 17 10:37:46 CST 2009
 */
package com.gmcc.pboss.web.promotion.daemon;

import com.gmcc.pboss.business.promotion.daemon.DaemonVO;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.gmcc.pboss.business.promotion.daemon.DaemonDBParam;
import com.gmcc.pboss.control.promotion.daemon.Daemon;

/**
 * <p>Title: DaemonAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class DaemonAction extends BaseAction {

	public DaemonAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new DaemonForm());
		this.setParam(new DaemonWebParam());

		//ָ��VO��
		setClsVO(DaemonVO.class);
		//ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
		this.pkNameArray = new String[] { "seqid" };
		this.setClsControl(Daemon.class);
		this.setClsQueryParam(DaemonDBParam.class);

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}