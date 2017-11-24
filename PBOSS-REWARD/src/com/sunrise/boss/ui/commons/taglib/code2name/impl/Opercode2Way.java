package com.sunrise.boss.ui.commons.taglib.code2name.impl;

import org.apache.log4j.Logger;

import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.business.rightmanage.operator.persistent.Operator2VO;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.taglib.code2name.Code2name;

public class Opercode2Way implements Code2name {

	
	private static final Logger log = Logger.getLogger(Opercode2Way.class);
	
	public String translate(Object code, User user) throws Exception {
		
		
		try {
			
			if(null == code || "".equals(code.toString().trim())){
				log.info("code is empty!");
				return "";
			}			
			
			//工号获取wayid
			CommonDelegate delegate = new CommonDelegate(Operator2VO.class);
			Operator2VO o2vo = (Operator2VO) delegate.doFindByPk(code.toString(), user);
			
			if(null == o2vo || null == o2vo.getOrgid() 
					|| "".equals(o2vo.getOrgid().trim())){
				log.info("Operator2VO or  Orgid can't find/empty!");
				return code.toString();
			}
			
			//wayid 获取 wayname
			CommonDelegate delegate1 = new CommonDelegate(WayVO.class);
			WayVO wayvo = (WayVO) delegate1.doFindByPk(o2vo.getOrgid(), user);
			
			if(null == wayvo || null == wayvo.getWayname() 
					|| "".equals(wayvo.getWayname().trim())){
				log.info("WayVO or  Wayname can't find/empty!");
				return code.toString();
			}
			
			return wayvo.getWayname();
		} catch (Exception ex) {
			log.error("translate(Object, User) - exception error !", ex);
		}		
		
		return "";
		
	}

}
