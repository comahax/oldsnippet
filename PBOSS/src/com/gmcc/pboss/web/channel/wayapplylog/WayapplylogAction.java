/**
 * auto-generated code
 * Mon Nov 23 16:35:24 CST 2009
 */
 package com.gmcc.pboss.web.channel.wayapplylog;

import com.gmcc.pboss.business.channel.wayapplylog.WayapplylogVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.channel.wayapplylog.WayapplylogDBParam;
import com.gmcc.pboss.control.channel.wayapplylog.Wayapplylog ;

/**
 * <p>Title: WayapplylogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public class WayapplylogAction extends BaseAction{
	
	public WayapplylogAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new WayapplylogForm());
		this.setParam(new WayapplylogDBParam());

        //ָ��VO��
        setClsVO(WayapplylogVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Wayapplylog.class);
		this.setClsQueryParam(WayapplylogDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	
	@Override
	public String doList() throws Exception {
		// TODO Auto-generated method stub
		WayapplylogDBParam param = (WayapplylogDBParam) getParam();
		// ����������־���ǵ��б���˲��ؼӵ���ID������
//		param.set_se_cityid(getDBAccessUser().getCityid());
		return super.doList();
	}
}