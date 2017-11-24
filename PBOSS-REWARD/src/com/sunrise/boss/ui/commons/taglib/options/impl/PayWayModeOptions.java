package com.sunrise.boss.ui.commons.taglib.options.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

import org.apache.log4j.Logger;

import com.sunrise.boss.business.admin.dictitem.persistent.DictitemListVO;
import com.sunrise.boss.business.admin.dictitem.persistent.DictitemVO;
import com.sunrise.boss.common.base.db.BaseListVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.taglib.code2name.Node;
import com.sunrise.boss.ui.commons.taglib.options.Options;

/**
 * <p>Title: PayWayModeOptions</p>
 * <p>Description:  支付渠道类型</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author xiefufeng
 * @version 1.0
 */

public class PayWayModeOptions implements Options{
private static final Logger log = Logger.getRootLogger();
	
	public Map valueList(User user) {
		Map map = new LinkedHashMap();
		return map;
	}
	
	public Object valueObject(Object params, Object code, Object name, User user) {
		DictitemListVO listvo = new DictitemListVO();
		DataPackage dp = null;
		Node node = null;
		DictitemVO vo = null;
		
		try{
			BeanUtils.copyProperties(listvo, (BaseListVO)params);
			listvo.set_se_groupid("IB_PAYWAYTYPE"); //支付渠道类型
			if( code!=null && !"".equals(code) ) listvo.set_se_dictid( code.toString() );
			if( name!=null && !"".equals(name) ) listvo.set_se_dictname( name.toString() );
			CommonDelegate delegate = new CommonDelegate(DictitemVO.class);
			dp = delegate.doQuery( listvo, user );
			Collection dictls = new LinkedList();
			
			if( "1".equals(listvo.get_pageno()) ){ //将固定项显示在第一页
				node = new Node();
				node.setCode( "ALL" );
				node.setName( "所有支付渠道类型" );
				dictls.add( node );
			}
			
			if( dp!=null && dp.getDatas() != null){
				Iterator it = dp.getDatas().iterator();
				if( it!=null ){
					while( it.hasNext() ){
						vo = (DictitemVO)it.next();
						node = new Node();
						node.setCode( vo.getDictid() );
						node.setName( vo.getDictname() );
						dictls.add( node );
					}
				}
				dp.getDatas().clear();
				dp.setDatas( dictls );
			}
		}catch(Exception ex){
			ex.printStackTrace();
			if(log.isDebugEnabled()){
				log.debug( " list paywaymode error ", ex );
			}
		}
		
		return dp;
	}
}
