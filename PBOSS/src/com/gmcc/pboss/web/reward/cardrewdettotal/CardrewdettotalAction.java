/**
 * auto-generated code
 * Tue Oct 18 19:25:02 CST 2011
 */
 package com.gmcc.pboss.web.reward.cardrewdettotal;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.reward.cardrewdet.CardrewdetDBParam;
import com.gmcc.pboss.business.reward.cardrewdettotal.CardrewdettotalVO ;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.reward.cardrewdettotal.CardrewdettotalDBParam;
import com.gmcc.pboss.control.reward.cardrewdet.Cardrewdet;
import com.gmcc.pboss.control.reward.cardrewdet.CardrewdetBO;
import com.gmcc.pboss.control.reward.cardrewdettotal.Cardrewdettotal ;
import com.gmcc.pboss.control.reward.cardrewdettotal.CardrewdettotalBO;

/**
 * <p>Title: CardrewdettotalAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class CardrewdettotalAction extends BaseAction{
	
	public CardrewdettotalAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new CardrewdettotalForm());
		this.setParam(new CardrewdettotalDBParam());

        //指定VO类
        setClsVO(CardrewdettotalVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"rowcountid"};
		this.setClsControl(Cardrewdettotal.class);
		this.setClsQueryParam(CardrewdettotalDBParam.class) ;

	}
	public String doShow() throws Exception{
		return "list";
	}
	
	public String doList() throws Exception{
		CardrewdettotalDBParam param=(CardrewdettotalDBParam)getParam();
		Map<String,String> conditionMap = new HashMap<String, String>();
		if(!StringUtils.isEmpty(param.get_dnl_activetime())){
			conditionMap.put("lactive", param.get_dnl_activetime());
		}
		if(!StringUtils.isEmpty(param.get_dnm_activetime())){
			conditionMap.put("mactive", param.get_dnm_activetime());
		}
		if(!StringUtils.isEmpty(param.get_dnl_rechargetime())){
			conditionMap.put("lrecharge", param.get_dnl_rechargetime());
		}
		if(!StringUtils.isEmpty(param.get_dnm_rechargetime())){
			conditionMap.put("mrecharge", param.get_dnm_rechargetime());
		}
		if(!StringUtils.isEmpty(param.get_se_wayid())){
			conditionMap.put("wayid", param.get_se_wayid());
		}
		
		Cardrewdettotal cardrewdet=(Cardrewdettotal)BOFactory.build(CardrewdettotalBO.class, getDBAccessUser());
		param.set_dnl_activetime(null);
		param.set_dnm_activetime(null);
		param.set_dnl_rechargetime(null);
		param.set_dnm_rechargetime(null);
		DataPackage dp=cardrewdet.doQu(conditionMap, param);
		setDp(dp);
		return "list";
	}
	
}