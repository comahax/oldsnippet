package com.gmcc.pboss.web.promotion.ppzlncom;

import java.io.File;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.base.dictitem.DictitemDBParam;
import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.gmcc.pboss.control.base.dictitem.DictitemBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;

public class PpzlncomCheck extends BaseCheckFormat {

	public PpzlncomCheck() {
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
			throw new Exception("上传数据列数不对, 请查看说明帮助!");
		}

		DictitemBO dictbo = (DictitemBO) BOFactory
				.build(DictitemBO.class, user);
		DictitemDBParam dictparam = new DictitemDBParam();
		dictparam.set_se_groupid("IM_FXCOMCATEGORY");
		dictparam.set_se_dictid(content[0]);
		DataPackage dictdp = dictbo.doQuery(dictparam);
		if (dictdp == null && dictdp.getDatas().size() < 1) {
			throw new Exception("请导入有效的商品类型!");
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
