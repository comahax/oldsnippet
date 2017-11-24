package com.sunrise.boss.ui.commons.taglib.options.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.sunrise.boss.business.admin.dictitem.persistent.DictitemListVO;
import com.sunrise.boss.business.admin.dictitem.persistent.DictitemVO;
import com.sunrise.boss.common.base.db.BaseListVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.taglib.code2name.Node;
import com.sunrise.boss.ui.commons.taglib.options.Options;

public class ReasonOptions implements Options{

	
	private static String CALLFEE="XJ,TK,CZ,YX,ZS,ITJ,IBZ,IBSQ";

	  public Map valueList(User user) {
		  return null;
	  }

	  public Object valueObject(Object params, Object code, Object name, User user){
		  String[] temp=CALLFEE.split(",");
		  List list=new LinkedList();
		  Node node = null;
		  DictitemVO vo = null;
		  Collection dictls = new LinkedList();
		  for(int i=0;i<temp.length;i++){
			  list.add(temp[i]);
		 }
		  DictitemListVO listvo = new DictitemListVO();
			DataPackage dp = new DataPackage();
			try {
				BeanUtils.copyProperties(listvo, (BaseListVO)params);
			} catch (Exception e) {
				e.printStackTrace();
			} 
			listvo.set_se_groupid("IB_EBOXCHGREASON"); 
			listvo.set_snin_dictid(list);
			if( code!=null && !"".equals(code) ) listvo.set_se_dictid( code.toString() );
			if( name!=null && !"".equals(name) ) listvo.set_se_dictname( name.toString() );		
			try {
				CommonDelegate delegate = new CommonDelegate(DictitemVO.class);		
				dp = delegate.doQuery( listvo, user );
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
			return dp;
		}
}
