package com.sunrise.boss.ui.commons.taglib;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.business.cms.provincialright.persistent.ProvincialrightListVO;
import com.sunrise.boss.business.cms.provincialright.persistent.ProvincialrightVO;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

public class RewardPurChkTag extends PurChk2Tag {
	private String controlid = "";
	private CommonDelegate delegate;

	public RewardPurChkTag() throws Exception {
		super();
		delegate = new CommonDelegate(ProvincialrightVO.class);

	}

	public int doStartTag() throws JspException {
		return RewardPurChkTag.EVAL_BODY_BUFFERED;
	}

	public int doEndTag() throws JspException {
		JspWriter writer = getPreviousOut();
		boolean isPurview =false;
//		if (controlid.indexOf("CH_PW_REWARD_PROVINCIAL") >= 0) {
//			try {
//				isPurview=checkpur();
//				writer.print(super.changeInputFiled(isPurview));
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		} else {
//			try {
//				isPurview=super.havePurview(controlid);
//				writer.print(super.changeInputFiled(isPurview));
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
			isPurview=super.havePurview(controlid);
			if(!isPurview){
				isPurview=checkpur();
			}
			try {
				writer.print(super.changeInputFiled(isPurview));
			} catch (IOException e) {
				e.printStackTrace();
			}
		return RewardPurChkTag.SKIP_BODY;
	}

	public String getControlid() {
		return controlid;
	}

	public void setControlid(String controlid) {
		if (StringUtils.isNotEmpty(controlid)) {
			this.controlid = controlid;
		}
	}

	protected boolean checkpur() {
		String[] ids; // controlIDs
		String flag; // 与或标志

		if (StringUtils.isNotEmpty(controlid)) {
			if (controlid.indexOf("||") >= 0) {
				ids = controlid.split("\\|\\|");
				flag = "||";
			} else if (controlid.indexOf("&&") >= 0) {
				ids = controlid.split("\\&\\&");
				flag = "&&";
			} else {
				ids = new String[1];
				ids[0] = controlid;
				flag = null;
			}
			User user = (User) pageContext.getSession().getAttribute(
					WebConstant.SESSION_ATTRIBUTE_USER);
			ProvincialrightListVO listVO;
			boolean[] bools = new boolean[ids.length]; // 权限值
			for (int i = 0; i < ids.length; ++i) {
				try {
					listVO = new ProvincialrightListVO();
					listVO.set_se_proopr(user.getOpercode());
					listVO.set_se_rightid(ids[i].trim());
					listVO.set_pagesize("0");
					List list = (List) delegate.doQuery(listVO, user)
							.getDatas();
					bools[i] = list.size() > 0;
				} catch (Exception e) {
					e.printStackTrace();
					bools[i] = false;
				}
			}

			// 合并所有权限值
			if ("||".equals(flag)) {
				boolean result = false;
				for (int i = 0; i < bools.length; ++i) {
					result = result || bools[i];
				}
				return result;
			} else if ("&&".equals(flag)) {
				boolean result = true;
				for (int i = 0; i < bools.length; ++i) {
					result = result && bools[i];
				}
				return result;
			} else {
				return bools[0];
			}

		} else {
			return false;
		}
	}
}
