package com.sunrise.boss.ui.commons.taglib.options.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.sunrise.boss.business.fee.woff.acct.persistent.AcctListVO;
import com.sunrise.boss.business.fee.woff.acct.persistent.AcctVO;
import com.sunrise.boss.common.base.db.BaseListVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.delegate.fee.woff.acct.AcctDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.taglib.code2name.Node;
import com.sunrise.boss.ui.commons.taglib.options.Options;

public class IncDecOptions implements Options{

	public Map valueList(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object valueObject(Object params, Object code, Object name, User user) {
		DataPackage dp = new DataPackage();
		
		try {
			AcctListVO listVO=new AcctListVO();
			BeanUtils.copyProperties(listVO, (BaseListVO)params);
			if( code!=null && !"".equals(code) ) listVO.set_ne_acctid(code.toString());
			if( name!=null && !"".equals(name) ) listVO.set_sk_acctname( name.toString() );
			listVO.set_sql_incdecAcct("this.limitflag like '_0%' ");
			listVO.set_pagesize("10");
			listVO.set_orderby("acctid");
			listVO.set_desc("0");
			
			List addlist = new ArrayList();
			//CommonDelegate delegate = new CommonDelegate(AcctVO.class);
			AcctDelegate delegate = new AcctDelegate();//Ö±½Ó²éÑ¯BOSSCOMMON
			dp = delegate.doQuery(listVO, user);
			if (dp != null && dp.getDatas() != null && dp.getRowCount() > 0) {
				for (Iterator it = dp.getDatas().iterator(); it.hasNext();) {
					AcctVO vo = (AcctVO) it.next();
					Node node = new Node();
					node.setCode(vo.getAcctid().toString());
					node.setName(vo.getAcctname());
					addlist.add(node);
				}
				dp.setDatas(addlist);
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dp;
	}

}
