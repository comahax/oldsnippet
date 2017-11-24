package com.gmcc.pboss.web.base.rewardsendsms;

import java.io.File;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.base.dictitem.DictitemVO;
import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.gmcc.pboss.control.base.dictitem.Dictitem;
import com.gmcc.pboss.control.base.dictitem.DictitemBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.ui.User;

public class RewardsendsmsCheck extends BaseCheckFormat {
	public void checkFile(File file, HashMap parameterMap, String contentType)
			throws Exception {
		if (!"text/plain".equalsIgnoreCase(contentType)) {
			throw new Exception("要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
		}

	}

	public void checkLine(String line, int rowCount, User user)
			throws Exception {

		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		Dictitem dictitem = (Dictitem) BOFactory.build(DictitemBO.class, user);
		DictitemVO vo = new DictitemVO();
		
		vo.setGroupid("CH_REWARDSMSTYPE");
		vo.setDictid(content[1]);
		
		if (content.length != 3) {
			throw new Exception("上传数据列数不对,应为2列,请查看说明帮助!");
		}
		if (content[0] == null || "".equals(content[0])) {
			throw new Exception("出酬酬金负责人号码不能为空");
		}else if (content[0].length()<11 || content[0].length()>11){
			throw new Exception("出酬酬金负责人号码必须为有效的11位手机号码");
		}
		if (content[1] == null || "".equals(content[1])) {
			throw new Exception("出酬酬金类型不能为空");
		} else if (dictitem.doFindByPk(vo) == null) { 
			throw new Exception("出酬酬金类型【" + content[1] + "】固定参数值不存在数据，请核实");
		}  
		 
		
	}

}
