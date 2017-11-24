/**
 * auto-generated code
 * Sat Sep 05 15:14:44 CST 2009
 */
 package com.gmcc.pboss.web.resource.comcategoryrela;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.resource.comcategoryrela.ComcategoryrelaDBParam;
import com.gmcc.pboss.business.resource.comcategoryrela.ComcategoryrelaVO;
import com.gmcc.pboss.control.resource.comcategoryrela.Comcategoryrela;
import com.gmcc.pboss.control.resource.comcategoryrela.ComcategoryrelaBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.ui.struts2.BaseAction;

/**
 * <p>Title: ComcategoryrelaAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ComcategoryrelaAction extends BaseAction{
	
	public ComcategoryrelaAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new ComcategoryrelaForm());
		this.setParam(new ComcategoryrelaWebParam());

        //指定VO类
        setClsVO(ComcategoryrelaVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"relaid"};
		this.setClsControl(Comcategoryrela.class);
		this.setClsQueryParam(ComcategoryrelaDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	/**
	 * 判断新增/编辑商品标识的唯一约束
	 * @throws Exception
	 */
	public void checkUnique() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter writer  = null;
		
		try{
			String comid=request.getParameter("comid");
			writer = response.getWriter();
			Comcategoryrela bo=(Comcategoryrela)BOFactory.build(ComcategoryrelaBO.class,super.getDBAccessUser());	
			ComcategoryrelaDBParam param=new ComcategoryrelaDBParam();
			param.set_ne_comid(comid);
			//根据商品标识查询商品种类组合关系表
			if(bo.doQuery(param).getDatas().size()>0){
				writer.write("NO");
			}
		}catch(Exception e){
			e.printStackTrace();
			
		}
		
	}
}