/**
 * auto-generated code
 * Fri Jul 09 09:11:20 CST 2010
 */
 package com.gmcc.pboss.web.resource.resalarminfo;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.gmcc.pboss.business.resource.resalarminfo.ResalarminfoVO ;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.resource.resalarminfo.ResalarminfoDBParam;
import com.gmcc.pboss.control.resource.resalarminfo.Resalarminfo ;

/**
 * <p>Title: ResalarminfoAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class ResalarminfoAction extends BaseAction{
	
	public ResalarminfoAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new ResalarminfoForm());
		this.setParam(new ResalarminfoDBParam());

        //指定VO类
        setClsVO(ResalarminfoVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"recid"};
		this.setClsControl(Resalarminfo.class);
		this.setClsQueryParam(ResalarminfoDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}

	@Override
	public String doList() throws Exception {
		// TODO Auto-generated method stub
		try{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			ResalarminfoDBParam param = (ResalarminfoDBParam)super.getParam();
			if( null == param.get_dnl_alarmdate()){
				param.set_dnl_alarmdate(sdf.format(new Date()));
			}
			if(null == param.get_dnm_alarmdate()){
				param.set_dnm_alarmdate(sdf.format(new Date()));
			}
			
			String startTime = param.get_dnl_alarmdate();
			String endTime = param.get_dnm_alarmdate();
			if(!"".equals(param.get_dnl_alarmdate()))
				param.set_dnl_alarmdate(param.get_dnl_alarmdate()+" 00:00:00");
			if(!"".equals(param.get_dnm_alarmdate()))
				param.set_dnm_alarmdate(param.get_dnm_alarmdate()+" 23:59:59");
			super.doList();
			param.set_dnl_alarmdate(startTime);
			param.set_dnm_alarmdate(endTime);
		}catch(Exception e){
			e.printStackTrace();
			super.addActionError(e.getMessage());
		}
		return WEB_RESULT_LIST;
	}
	
	
	
}