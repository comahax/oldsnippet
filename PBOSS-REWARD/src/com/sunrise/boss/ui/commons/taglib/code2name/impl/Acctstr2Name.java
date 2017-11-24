/**
 * 
 */
package com.sunrise.boss.ui.commons.taglib.code2name.impl;

import org.apache.log4j.Logger;

import com.sunrise.boss.business.fee.woff.acct.persistent.AcctVO;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.delegate.fee.woff.acct.AcctDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.taglib.code2name.Code2name;
import com.sunrise.pub.tools.StringSplit;

/**
 * @author mys
 */


public class Acctstr2Name implements Code2name {
	
	/**  Logger for this class **/
	private static final Logger log = Logger.getLogger(Acctstr2Name.class);
	public String translate(Object code, User user) throws Exception {
		
		
		if(null == code || "".equals(code.toString().trim())){
			log.info("code is empty!");
			return "";
		}	
		
		String split = ",";
		String[] item = StringSplit.split(code.toString(), split);	
		StringBuffer namestr = new StringBuffer(400).append("");
		
		//CommonDelegate delegate = new CommonDelegate(AcctVO.class);
		AcctDelegate delegate = new AcctDelegate();//÷±Ω”≤È—ØBOSSCOMMON
		for(int i = 0; i < item.length; i++){
			
			try{
				AcctVO avo = (AcctVO) delegate.doFindByPk(new Long(item[i]), user);
				if(null != avo && null != avo.getAcctname() && !"".equals(avo.getAcctname())){
					namestr.append(avo.getAcctname()).append(split);
					continue;
				}			
				
			}catch(Exception ex){			
				log.error("translate(Object, User) - exception error !", ex);			
			}
			namestr.append(item[i]).append(split);	
		}
		return namestr.toString();
			
	}

}
