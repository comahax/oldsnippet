/**
 * auto-generated code
 * Sat Sep 05 17:12:41 CST 2009
 */
 package com.gmcc.pboss.web.resource.numsortrule;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.resource.numsortrule.NumsortruleDBParam;
import com.gmcc.pboss.business.resource.numsortrule.NumsortruleVO;
import com.gmcc.pboss.business.resource.numtypedef.NumtypedefVO;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.control.resource.numsortrule.Numsortrule;
import com.gmcc.pboss.control.resource.numsortrule.NumsortruleBO;
import com.gmcc.pboss.control.resource.numtypedef.Numtypedef;
import com.gmcc.pboss.control.resource.numtypedef.NumtypedefBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;

/**
 * <p>Title: NumsortruleAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class NumsortruleAction extends BaseAction{
	
	private NumtypedefVO  numtypedef;//号码类型
	public NumtypedefVO getNumtypedef() {
		return numtypedef;
	}

	public void setNumtypedef(NumtypedefVO numtypedef) {
		this.numtypedef = numtypedef;
	}

	public NumsortruleAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new NumsortruleForm());
		this.setParam(new NumsortruleWebParam());

        //指定VO类
        setClsVO(NumsortruleVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"ruleid"};
		this.setClsControl(Numsortrule.class);
		this.setClsQueryParam(NumsortruleDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	
	public String doListByType(){
		try{
			Numtypedef numtypedefBO = (NumtypedefBO)BOFactory.build(NumtypedefBO.class,super.getDBAccessUser());
			Numsortrule numsortruleBO = (NumsortruleBO)BOFactory.build(NumsortruleBO.class,super.getDBAccessUser());
			NumsortruleDBParam params = (NumsortruleDBParam)super.getParam();
			numtypedef = numtypedefBO.doFindByPk(params.get_ne_typeid());//获取号码类型
//			params.set_pagesize("10");//设置每页10条记录
			DataPackage dp = numsortruleBO.doQuery(params);
			super.setDp(dp);
		}catch(Exception e){
			super.addActionError(e.getMessage());
		}
		return "listbytype";
	}
	public String doExcel() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("号码分类规则导出");
		export.appendHeadLine(new String[] { "导出工号:", user.getOprcode() });
		export
				.appendHeadLine(new String[] { "导出时间",
						format.format(new Date()) });
		export.addOutputProperty("ruleexp", "规则表达式");
		NumsortruleDBParam param = (NumsortruleDBParam)super.getParam();
		param.setQueryAll(true);
		
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel();
	}
	
}