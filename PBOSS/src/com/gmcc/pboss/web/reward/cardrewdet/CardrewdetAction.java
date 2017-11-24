/**
 * auto-generated code
 * Thu Oct 13 15:54:23 CST 2011
 */
 package com.gmcc.pboss.web.reward.cardrewdet;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.reward.cardrewdet.CardrewdetVO ;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.reward.cardrewdet.CardrewdetDBParam;
import com.gmcc.pboss.control.reward.cardrewdet.Cardrewdet ;
import com.gmcc.pboss.control.reward.cardrewdet.CardrewdetBO;

/**
 * <p>Title: CardrewdetAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class CardrewdetAction extends BaseAction{
	
	public CardrewdetAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new CardrewdetForm());
		this.setParam(new CardrewdetDBParam());

        //指定VO类
        setClsVO(CardrewdetVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"seqid"};
		this.setClsControl(Cardrewdet.class);
		this.setClsQueryParam(CardrewdetDBParam.class) ;

	}
	
	public String doQu() throws Exception{
		CardrewdetDBParam cardrewdetDBParam=(CardrewdetDBParam)getParam();
		Map<String,String> conditionMap = new HashMap<String, String>();
		if(!StringUtils.isEmpty(cardrewdetDBParam.get_dnl_activetime())){
			conditionMap.put("lactive", cardrewdetDBParam.get_dnl_activetime());
		}
		if(!StringUtils.isEmpty(cardrewdetDBParam.get_dnm_activetime())){
			conditionMap.put("mactive", cardrewdetDBParam.get_dnm_activetime());
		}
		if(!StringUtils.isEmpty(cardrewdetDBParam.get_dnl_rechargetime())){
			conditionMap.put("lrecharge", cardrewdetDBParam.get_dnl_rechargetime());
		}
		if(!StringUtils.isEmpty(cardrewdetDBParam.get_dnm_rechargetime())){
			conditionMap.put("mrecharge", cardrewdetDBParam.get_dnm_rechargetime());
		}
		if(!StringUtils.isEmpty(cardrewdetDBParam.get_se_wayid())){
			conditionMap.put("wayid", cardrewdetDBParam.get_se_wayid());
		}
		
		Cardrewdet cardrewdet=(Cardrewdet)BOFactory.build(CardrewdetBO.class, getDBAccessUser());
		DataPackage dp=cardrewdet.doQu(conditionMap, cardrewdetDBParam);
		setDp(dp);
		return "grouybypage";
	}
	
	
}