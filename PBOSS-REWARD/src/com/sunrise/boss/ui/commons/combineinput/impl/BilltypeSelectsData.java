package com.sunrise.boss.ui.commons.combineinput.impl;

import java.util.ArrayList;
import java.util.List;

import com.sunrise.boss.business.common.combineinput.persistent.CombineinputListVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.delegate.common.combineinput.CombineinputDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.combineinput.SelectsData;

/**
 * <p>Title: BilltypeSelectsData </p>
 * <p>Description: 帐单类型和帐单科目获取实现类 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: Sunrise Tech Ltd.</p>
 * @author Zhang Fengchao
 * @since 1.0
 * @version 1.0
 * @date 2007-11-16
 */
public class BilltypeSelectsData implements SelectsData {
	/**
	 * 获取帐单类型集合
	 */
	public List getType1Collection(CombineinputListVO listVO, User user) {
		try {
			List retlist = new ArrayList();
			CombineinputDelegate delegate = new CombineinputDelegate();
			DataPackage dp = delegate.queryDictitem(listVO, user);
			if (null == dp || null == dp.getDatas()) {
				return retlist;
			}
			
			retlist.addAll(dp.getDatas());
			return retlist;
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ArrayList(0);
		}
	}
	
	/**
	 * 获取帐单科目集合
	 * SELECT a.acctid, a.acctname, b.vc_filedef from IB_PF_ACCT a, ZW_DFD_BILLFILEFMT b where a.acctid = b.int_acctid(+) and a.acctstate = 1;
	 * SELECT a.acctid, a.acctname, b.vc_filedef FROM IB_PF_ACCT a LEFT OUTER JOIN ZW_DFD_BILLFILEFMT b ON (a.acctid = b.int_acctid) WHERE a.acctstate = 1;
	 */
	public List getType2Collection(CombineinputListVO listVO, User user) {
		try {
			List retlist = new ArrayList();
			CombineinputDelegate delegate = new CombineinputDelegate();
			DataPackage dp = delegate.queryAcctJoin(listVO, user);
			if (null == dp || null == dp.getDatas()) {
				return retlist;
			}
			
			retlist.addAll(dp.getDatas());
			return retlist;
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ArrayList(0);
		}
	}
	
	/**
	 * 尚未用到，留空
	 */
	public List getType3Collection(CombineinputListVO listVO, User user) {
		return new ArrayList(0);
	}
}
