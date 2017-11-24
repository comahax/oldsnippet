/**
 * auto-generated code
 * Tue Oct 13 09:23:33 CST 2009
 */
 package com.gmcc.pboss.web.sales.baseorderamt;

import java.util.List;

import com.gmcc.pboss.business.channel.custwaytype.CustwaytypeVO;
import com.gmcc.pboss.business.sales.baseorderamt.BaseorderamtDBParam;
import com.gmcc.pboss.business.sales.baseorderamt.BaseorderamtVO;
import com.gmcc.pboss.control.sales.baseorderamt.Baseorderamt;
import com.gmcc.pboss.control.sales.baseorderamt.BaseorderamtBO;
import com.gmcc.pboss.control.sales.comprice.Comprice;
import com.gmcc.pboss.control.sales.comprice.CompriceBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.CityMappingUtil;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.struts2.BaseAction;

/**
 * <p>Title: BaseorderamtAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class BaseorderamtAction extends BaseAction{
	
	public BaseorderamtAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new BaseorderamtForm());
		this.setParam(new BaseorderamtWebParam());

        //指定VO类
        setClsVO(BaseorderamtVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"recid"};
		this.setClsControl(Baseorderamt.class);
		this.setClsQueryParam(BaseorderamtDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	
	public String doList() throws Exception{
		String cityid = getDBAccessUser().getCityid();
		getRequest().setAttribute("cityid", cityid);
		BaseorderamtDBParam param = (BaseorderamtDBParam)getParam();
		param.set_se_cityid(cityid);
		
		super.doList();
		return WEB_RESULT_LIST;
	}
	
	public String doNew() throws Exception{
		super.doNew();
		String cityid = getDBAccessUser().getCityid();
		getRequest().setAttribute("cityid", cityid);
		return WEB_RESULT_CONTENT;
	};	
	
	public String doEdit() throws Exception {
		super.doEdit();
		String cityid = getDBAccessUser().getCityid();
		getRequest().setAttribute("cityid", cityid);
		return WEB_RESULT_CONTENT;
	}
	
	public String doSave() throws Exception{
		String cityid = getDBAccessUser().getCityid();
		getRequest().setAttribute("cityid", cityid);
		
		Baseorderamt baseorderamt = (Baseorderamt)BOFactory.build(BaseorderamtBO.class,getDBAccessUser());
		BaseorderamtDBParam param = new BaseorderamtDBParam();
		BaseorderamtForm form = (BaseorderamtForm)getForm();
		param.set_se_cityid(form.getCityid());
		param.set_ne_starlevel(Short.valueOf(form.getStarlevel()));
		
		if (WEB_CMD_EDIT.equals(CMD)) {
			param.set_nne_recid(form.getRecid().toString());
		}
		DataPackage dp = (DataPackage)baseorderamt.doQuery(param);
		if (dp.getRowCount() > 0) {
			addActionError("相同记录已经存在，请检查。");
			return WEB_RESULT_CONTENT;
		}
		
		super.doSave();
		return WEB_RESULT_CONTENT;
	};
	
}