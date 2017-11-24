package com.sunrise.boss.ui.cms.zjty.zjtyrewardcoef;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;
import com.sunrise.pub.tools.StringSplit;

public class ZjtyRewardcoefbatchCheck extends BaseCheckFormat {

	protected static String[] rewardasstype = new String[] { "0", "1", "2", "3" };

	public ZjtyRewardcoefbatchCheck() {
		// TODO Auto-generated constructor stub
	}

	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		if (!"text/plain".equalsIgnoreCase(file.getContentType())) {
			throw new BusinessException("",
					"要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
		}
	}

	public void checkLine(String line, int rowCount, User user)
			throws Exception {

		String[] content = StringSplit.split(line, "|");
		WayDelegate waydelegate = new WayDelegate();

		if (content.length == 3 || content.length == 5) {
			;
		} else {
			throw new BusinessException("", "参数不完整.最少应有3项或者5项");
		}

		SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
		if (StringUtils.isEmpty(content[0]) || content[0].length() > 6) {
			throw new BusinessException("", "作用月不能为空且长度不能超过6位");
		}
		try {
			format.parse(content[0]);
		} catch (Exception e) {
			throw new BusinessException("", "作用月格式不正确，正确的格式应该为YYYYMM");
		}

		if (StringUtils.isEmpty(content[1])
				|| !NumberUtils.isNumber(content[1])) {
			throw new BusinessException("", "酬金系数不能为空并且必须为数字");
		}
		if (StringUtils.isEmpty(content[1])
				|| !Arrays.asList(rewardasstype).contains(content[1])) {
			throw new BusinessException("", "酬金系数不能为空或者参数不存在");
		}

		if (StringUtils.isEmpty(content[2])) {
			throw new BusinessException("", "渠道代码不能为空");
		}
		WayVO wayvo = waydelegate.doFindByPk(content[2], user);
		if (wayvo == null) {
			throw new BusinessException("", "渠道代码不存在");
		}

		if (content.length == 5) {
			if (StringUtils.isEmpty(content[3])
					|| !NumberUtils.isNumber(content[3])) {
				throw new BusinessException("", "发放系数不能为空并且必须为数字");
			}
			if (content[3].substring(content[3].indexOf('.') + 1).length() > 2) {
				throw new BusinessException("", "发放系数超过范围,只支持到小数点后两位");
			}

			// if(StringUtils.isEmpty(content[4])){
			// throw new BusinessException("","考核结果不能为空");
			// }
		}

		// Double double1=new Double(content[3]);
		// if(double1.doubleValue()<0.0000 || double1.doubleValue()>2){
		// throw new BusinessException("","考核系数格式必须为0.00~2.00");
		//		}
	}
}
