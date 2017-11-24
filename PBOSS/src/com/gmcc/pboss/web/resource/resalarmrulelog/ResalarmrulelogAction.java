package com.gmcc.pboss.web.resource.resalarmrulelog;


import com.gmcc.pboss.business.resource.resalarmrulelog.ResalarmrulelogDBParam;
import com.gmcc.pboss.business.resource.resalarmrulelog.ResalarmrulelogVO;
import com.gmcc.pboss.control.resource.resalarmrulelog.Resalarmrulelog;
import com.sunrise.jop.ui.struts2.BaseAction ;


/**
 * <p>Title: ResalarmrulelogAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class ResalarmrulelogAction extends BaseAction{
	
	public ResalarmrulelogAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new ResalarmrulelogForm());
		this.setParam(new ResalarmrulelogDBParam());

        //ָ��VO��
        setClsVO(ResalarmrulelogVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"logid"};
		this.setClsControl(Resalarmrulelog.class);
		this.setClsQueryParam(ResalarmrulelogDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}