/**
 * auto-generated code
 * Thu Dec 11 16:31:58 CST 2008
 */
package com.sunrise.boss.ui.zifee.yxplansynlog;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.ui.base.*;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.boss.ui.zifee.commons.BatchProcess;
import com.sunrise.boss.business.zifee.yxplan.persistent.YxPlanVO;
import com.sunrise.boss.business.zifee.yxplansynlog.persistent.YxplansynlogVO;
import com.sunrise.boss.delegate.zifee.yxplan.YxPlanDelegate;
import com.sunrise.boss.delegate.zifee.yxplansynlog.YxplansynlogDelegate;
/**
 * <p>
 * Title: YxplansynlogAction
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: Maywide Tech Ltd.
 * </p>
 * 
 * @author Jerimy
 * @version 1.0
 */
public class YxplansynlogAction extends BaseDelegateAction {
	public YxplansynlogAction() {
		// 以下几个方法是必须的
		// 指定VO类
		setVoClass(YxplansynlogVO.class);
		// 指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
		this.pkNameArray = new String[1];
		pkNameArray[0] = "logid";
	}

	/**
	 * 上传并处理批量营销方案文件
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 * @author added by yijianrong
	 */
	public ActionForward doUpload(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {

		YxplansynlogForm form = (YxplansynlogForm) actionForm;
		FormFile inputFile = form.getInputFile();
		if (inputFile == null) {
			request
					.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
							"上传文件不能为空");
			return (actionMapping.findForward("batch"));
		}

		int sum = 0;
		int success = 0;
		int failure = 0;
		String elements = null;
		String restr = null;
		Iterator iterator = BatchProcess.getData(inputFile);
		StringBuffer result = new StringBuffer("");
		StringBuffer tmp = new StringBuffer("");
		YxPlanDelegate delegate = new YxPlanDelegate();

		while (iterator.hasNext()) {
			elements = (String) iterator.next();
			// 检查字串合法性
			String regex = "^\\d{14}$";
			// 返回码为0表示检查通过
			if (elements != null && elements.matches(regex)) {
				try {
					YxPlanVO vo = delegate.doFindByPk(
							new Long(elements.trim()), user);
					if (vo != null) {
						new YxplansynlogDelegate().doCopysyn(elements, user);
					} else {
						restr = "第" + String.valueOf(sum + 1) + "行营销方案对象不存在"
								+ elements;
					}
				} catch (Exception ex) {
					restr = "第" + String.valueOf(sum + 1) + "行插入数据库失败! ";
				}

				if (restr == null) {
					success++;
				} else {
					tmp.append("第").append(sum + 1).append("行记录入库时出现错误！\r\n");
					tmp.append("原因：").append(restr).append("\r\n\r\n");
					failure++;
				}
			} else {
				tmp.append("第").append(sum + 1).append("行,营销方案ID出现错误,必须为数字！\r\n");
				tmp.append("原因：").append("营销方案ID" + elements)
						.append("\r\n\r\n");
				failure++;
			}
			sum++;
		}

		result.append("总共").append(sum).append("条记录，成功").append(success)
				.append("条,失败").append(failure).append("条.\r\n\r\n");
		result.append(tmp.toString());
		form.setReInfo(result.toString());
		return (actionMapping.findForward("success"));
	}
}
