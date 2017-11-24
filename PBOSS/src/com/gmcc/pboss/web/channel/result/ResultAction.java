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

		//以下几个方法是必须的
		this.setForm(new ResultForm());
		this.setParam(new ResultDBParam());

        //指定VO类
        setClsVO(ResultVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"streamno"};
		this.setClsControl(Result.class);
		this.setClsQueryParam(ResultDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
}