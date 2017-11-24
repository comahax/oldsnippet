package com.sunrise.boss.ui.commons.combineinput;

import java.util.List;

import com.sunrise.boss.business.common.combineinput.persistent.CombineinputListVO;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: SelectsData </p>
 * <p>Description: 列表框数据获取接口定义 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: Sunrise Tech Ltd.</p>
 * @author Zhang Fengchao
 * @since 1.0
 * @version 1.0
 * @date 2007-11-16
 */
public interface SelectsData {
	public List getType1Collection(CombineinputListVO listVO, User user);
	public List getType2Collection(CombineinputListVO listVO, User user);
	public List getType3Collection(CombineinputListVO listVO, User user);
}
