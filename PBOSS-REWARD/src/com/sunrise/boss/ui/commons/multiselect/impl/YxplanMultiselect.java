package com.sunrise.boss.ui.commons.multiselect.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.sunrise.boss.business.zifee.yxplan.persistent.YxPlanListVO;
import com.sunrise.boss.business.zifee.yxplan.persistent.YxPlanVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.delegate.zifee.yxplan.YxPlanDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.multiselect.Multiselect;
import com.sunrise.boss.ui.commons.multiselect.MultiselectData;

/**
 * <p>
 * Title: YxplanMultiselect
 * </p>
 * <p>
 * Description: 营销方案 多选弹出框数据获取实现类
 * </p>
 * <p>
 * Copyright: Copyright (c) 2007
 * </p>
 * <p>
 * Company: Sunrise Tech Ltd.
 * </p>
 * 
 * @author Zhang Fengchao
 * @since 1.0
 * @version 1.0
 * @date 2008-08-28
 */
public class YxplanMultiselect implements Multiselect {
	public Collection getInitSource(User user) throws Exception {
		YxPlanListVO listVO = new YxPlanListVO();
		listVO.set_pageno("1");
		listVO.set_pagesize("50");
		listVO.set_orderby("yxplanid");
		listVO.set_desc("0"); // 升序
		YxPlanDelegate delegate = new YxPlanDelegate();
		DataPackage dp = delegate.doQuery(listVO, user);
		if (null == dp || null == dp.getDatas() || dp.getDatas().size() == 0) {
			return null;
		}

		List list = new ArrayList(dp.getDatas().size());
		for (Iterator iter = dp.getDatas().iterator(); iter.hasNext();) {
			YxPlanVO item = (YxPlanVO) iter.next();
			MultiselectData data = new MultiselectData();
			data.setCode("" + item.getYxplanid());
			data.setName(item.getYxplanid() + "-" + item.getYxplanname());
			list.add(data);
		}
		return list;
	}

	public Collection getInitExist(String[] codes, User user) throws Exception {
		if (codes == null || codes.length == 0) {
			return null;
		}

		YxPlanDelegate delegate = new YxPlanDelegate();
		List list = new ArrayList();
		for (int i = 0; i < codes.length; i++) {
			if (null == codes[i] || codes[i].trim().length() == 0) {
				continue;
			}
			YxPlanVO vo = delegate.doFindByPk(new Long(codes[i].trim()), user);
			if (vo != null) {
				MultiselectData data = new MultiselectData();
				data.setCode("" + vo.getYxplanid());
				data.setName(vo.getYxplanid() + "-" + vo.getYxplanname());
				list.add(data);
			}
		}
		return list;
	}

	public Collection querySource(String code, String name, User user)
			throws Exception {
		YxPlanListVO listVO = new YxPlanListVO();
		listVO.set_ssw_yxplanid(code);
		listVO.set_sk_yxplanname(name);
		listVO.set_pageno("1");
		listVO.set_pagesize("50");
		listVO.set_orderby("yxplanid");
		listVO.set_desc("0"); // 升序

		YxPlanDelegate delegate = new YxPlanDelegate();
		DataPackage dp = delegate.doQuery(listVO, user);
		if (null == dp || null == dp.getDatas() || dp.getDatas().size() == 0) {
			return null;
		}

		List list = new ArrayList(dp.getDatas().size());
		for (Iterator iter = dp.getDatas().iterator(); iter.hasNext();) {
			YxPlanVO item = (YxPlanVO) iter.next();
			MultiselectData data = new MultiselectData();
			data.setCode("" + item.getYxplanid());
			data.setName(item.getYxplanid() + "-" + item.getYxplanname());
			list.add(data);
		}
		return list;
	}

}
