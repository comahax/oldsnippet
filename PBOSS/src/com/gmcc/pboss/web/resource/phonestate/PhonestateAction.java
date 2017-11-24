/**
 * auto-generated code
 * Mon Jul 04 16:25:21 CST 2011
 */
 package com.gmcc.pboss.web.resource.phonestate;

import com.gmcc.pboss.business.resource.phonestate.PhonestateDBParam;
import com.gmcc.pboss.business.resource.phonestate.PhonestateVO;
import com.gmcc.pboss.control.resource.phonestate.Phonestate;
import com.gmcc.pboss.control.resource.phonestate.PhonestateBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.struts2.BaseAction;

/**
 * <p>Title: PhonestateAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author lyl
 * @version 1.0
 */
public class PhonestateAction extends BaseAction{
	
	public PhonestateAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new PhonestateForm());
		this.setParam(new PhonestateDBParam());

        //指定VO类
        setClsVO(PhonestateVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"comresid"};
		this.setClsControl(Phonestate.class);
		this.setClsQueryParam(PhonestateDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	
	public String doList() throws Exception{ 
		try{
			if (this.isQuery){
			Phonestate phonestateBO = (Phonestate) BOFactory.build(PhonestateBO.class, super.getDBAccessUser());
	        PhonestateDBParam params = (PhonestateDBParam)super.getParam(); 
			DataPackage dpTmp = (DataPackage)phonestateBO.doChooseData(params);		
			this.setDp(dpTmp);
			}
		}catch (Exception e) {e.printStackTrace();
			throw new Exception(e);
		}
		
		return WEB_RESULT_LIST;
	}
	private boolean isQuery;// 是否统计标识，默认不查询

	public boolean getIsQuery() {
		return isQuery;
	}

	public void setIsQuery(boolean isQuery) {
		this.isQuery = isQuery;
	}
}