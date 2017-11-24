package com.sunrise.boss.ui.commons.taglib.options.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

import org.apache.log4j.Logger;

import com.sunrise.boss.business.fee.persistent.bank.BankVO;
import com.sunrise.boss.common.base.db.BaseListVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.taglib.code2name.Node;
import com.sunrise.boss.ui.commons.taglib.options.Options;

public class PaywayOptions implements Options{
	private static final Logger log = Logger.getRootLogger();
	
	public Map valueList(User user) {
		Map map = new LinkedHashMap();
		BaseListVO listvo = new BaseListVO();
		BankVO bankvo = null;
		
		try{
			map.put( "ALLBANK", "所有支付渠道" ); //固定选项,表示"所有支付渠道"
			map.put( "FILETYPE", "文件类型" ); //固定选项,表示"文件类型"
			
			CommonDelegate delegate = new CommonDelegate(BankVO.class);
			Iterator it = delegate.doQuery( listvo, user ).getDatas().iterator();
			if( it!=null ){
				while( it.hasNext() ){
					bankvo = (BankVO)it.next();
					map.put( bankvo.getBankid(), bankvo.getBankname() );
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
			if( log.isDebugEnabled() ){
				log.debug( " list paywayid error ", ex );
			}
		}
		return map;
	}
	
	public Object valueObject(Object params, Object code, Object name, User user) {
		BaseListVO listvo = new BaseListVO();
		DataPackage dp = null;
		Node node = null;
		BankVO bankvo = null;
		
		try{
			BeanUtils.copyProperties(listvo, (BaseListVO)params);
			listvo.getQueryConditions().put("_se_bankid",code);
			listvo.getQueryConditions().put("_se_bankname",name);
			CommonDelegate delegate = new CommonDelegate(BankVO.class);
			dp = delegate.doQuery( listvo, user );
			Collection bankls = new LinkedList();
			
			if( "1".equals(listvo.get_pageno()) ){ //将固定项显示在第一页
				node = new Node();
				node.setCode( "ALLBANK" );
				node.setName( "所有支付渠道" );
				bankls.add( node );
				
				node = new Node();
				node.setCode( "FILETYPE" );
				node.setName( "文件类型" );
				bankls.add( node );
			}
			
			if( dp!=null && dp.getDatas() != null){
				Iterator it = dp.getDatas().iterator();
				if( it!=null ){
					while( it.hasNext() ){
						bankvo = (BankVO)it.next();
						node = new Node();
						node.setCode( bankvo.getBankid() );
						node.setName( bankvo.getBankname() );
						bankls.add( node );
					}
				}
				dp.getDatas().clear();
				dp.setDatas( bankls );
			}
		}catch(Exception ex){
			ex.printStackTrace();
			if(log.isDebugEnabled()){
				log.debug( " list paywayid error ", ex );
			}
		}
		
		return dp;
	}
}
