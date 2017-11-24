/**
 * 
 */
package com.sunrise.boss.ui.commons.taglib.code2name.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import com.sunrise.boss.business.fee.dgrealprod.balancetype.persistent.BalanceTypeVO;
import com.sunrise.boss.business.fee.woff.eboxunit.persistent.EBoxUnitVO;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.UploadUtil;
import com.sunrise.boss.ui.commons.taglib.code2name.Code2name;

/**
 * @author baiming
 * 
 */
public class RbEbox2Name implements Code2name{

	/** Logger for this class * */
	private static final Logger log = Logger.getLogger(RbEbox2Name.class);

	/**
	 * code 格式为 1|BrandSzx
	 */
	public String translate(Object code, User user) throws Exception {
		
		if(code == null || "".equals(code)){
			return "";
		}
		
		String[] item = UploadUtil.splitLine(code.toString());				
		
		try {
			
			
			Pattern p = Pattern.compile("[1-8]{1}");
			Matcher m = p.matcher(code.toString());
			if(!(m.find() && m.start() == 0)){
				log.info("Matcher can't find!");
				return item[0];
			}			
			CommonDelegate delegate = new CommonDelegate(BalanceTypeVO.class);
			BalanceTypeVO vo = (BalanceTypeVO) delegate.doFindByPk(item[1], user);
			if(null == vo){
				log.info("Balance Type can't find!");
				return item[0];
			}
			Long eboxunitid = (Long) BeanUtils.getProperty(vo, "eboxunitid" + item[0]);
			if(null == eboxunitid){
				return item[0];
			}
			
			CommonDelegate delegate1 = new CommonDelegate(EBoxUnitVO.class);
			EBoxUnitVO euvo = (EBoxUnitVO) delegate1.doFindByPk(eboxunitid, user);
			
			if(null == euvo || null == euvo.getEboxunitname() 
					||"".equals(euvo.getEboxunitname())){
				log.info("EboxUnit can't find or name is empty!");
				return item[0];
			}
			
			return euvo.getEboxunitname();
		} catch (Exception ex) {
			log.error("translate(Object, User) - exception error !", ex);
		}
		
		return item[0];
	}


	/**
	 * code 格式为 1|BrandSzx
	 */
	public String getEboxunitid(Object code, User user) throws Exception {
		
		if(code == null || "".equals(code)){
			return "";
		}
		
		String[] item = UploadUtil.splitLine(code.toString());				
		
		try {			
			
			Pattern p = Pattern.compile("[1-8]{1}");
			Matcher m = p.matcher(code.toString());
			if(!(m.find() && m.start() == 0)){
				log.info("Matcher can't find!");
				return item[0];
			}			
			CommonDelegate delegate = new CommonDelegate(BalanceTypeVO.class);
			BalanceTypeVO vo = (BalanceTypeVO) delegate.doFindByPk(item[1], user);
			if(null == vo){
				log.info("Balance Type can't find!");
				return item[0];
			}
			Long eboxunitid = (Long) BeanUtils.getProperty(vo, "eboxunitid" + item[0]);
			if(null == eboxunitid){
				return item[0];
			}					
			
			return eboxunitid.toString();
		} catch (Exception ex) {
			log.error("translate(Object, User) - exception error !", ex);
		}
		
		return item[0];
	}
	
}
