package com.sunrise.boss.ui.zifee.yxplansplitvalue;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.zifee.yxplansplitvalue.persistent.YxPlanSplitValueVO;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: YxPlanGroupAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Danny(luozhoujie)
 * @version 1.0
 */

public class YxPlanSplitValueAction extends BaseAction{
	public YxPlanSplitValueAction() {
        this.voClass = YxPlanSplitValueVO.class;
        // TODO: 给出主键的名字数组
        this.pkNameArray = new String[1];
        pkNameArray[0] = "yxplantypeid";
    }
}
