/**
 * auto-generated code
 * Mon Mar 01 14:59:35 CST 2010
 */
 package com.gmcc.pboss.web.channel.result;

import com.gmcc.pboss.business.channel.result.ResultVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.channel.result.ResultDBParam;
import com.gmcc.pboss.control.channel.result.Result ;

/**
 * <p>Title: ResultAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class ResultAction extends BaseAction{
	
	public ResultAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new ResultForm());
		this.setParam(new ResultDBParam());

        //ָ��VO��
        setClsVO(ResultVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"streamno"};
		this.setClsControl(Result.class);
		this.setClsQueryParam(ResultDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}