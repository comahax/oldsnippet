package com.gmcc.pboss.web.promotion.ppzlnptnr;

import java.io.File;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.channel.way.WayDBParam;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;

public class PpzlnptnrCheck extends BaseCheckFormat {

	public PpzlnptnrCheck() {
		// TODO Auto-generated constructor stub
	}

	public void checkFile(File file, HashMap parameterMap, String contentType)
			throws Exception {
		if (!"text/plain".equalsIgnoreCase(contentType)) {
			throw new Exception("要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
		}
	}

	public void checkLine(String line, int rowCount, User user)
			throws Exception {
		// TODO Auto-generated method stub
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		if (content.length > 2) {
			throw new Exception("上传数据列数不对,应为1列, 请查看说明帮助!");
		}

		WayVO wayvo = new WayVO();
		WayBO waybo = (WayBO) BOFactory.build(WayBO.class, user);
		wayvo.setWayid(content[0]);
		if (waybo.doFindByPk(wayvo.getWayid()) == null) {
			throw new Exception("渠道编码不存在");
		}

		WayDBParam param = new WayDBParam();
		param.set_se_wayid(content[0]);
		param.set_se_waytype("AG");
		DataPackage dp = waybo.doQuery(param);
		if (dp == null || dp.getDatas().size() == 0) {
			throw new Exception("该渠道[" + content[0] + "]不是社会渠道!");
		}
	}

	private boolean isEmpty(String checkStr) throws Exception {
		if (checkStr != null) {
			return StringUtils.isBlank(checkStr);
		} else {
			throw new Exception("检查字符串为空!");
		}
	}
}
