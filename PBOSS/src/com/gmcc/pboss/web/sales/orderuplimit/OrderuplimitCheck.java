package com.gmcc.pboss.web.sales.orderuplimit;

import java.io.File;
import java.util.HashMap;

import com.gmcc.pboss.business.base.dictitem.DictitemDBParam;
import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.gmcc.pboss.control.base.dictitem.Dictitem;
import com.gmcc.pboss.control.base.dictitem.DictitemBO;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.ui.User;

public class OrderuplimitCheck extends BaseCheckFormat {

	public void checkFile(File file, HashMap parameterMap, String contentType)
			throws Exception {
		if (!"text/plain".equalsIgnoreCase(contentType)) {
			throw new Exception("要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
		}
	}

	public void checkLine(String line, int rowCount, User user)
			throws Exception {
		String[] content = StringUtils.split(line, "|");
		if (content.length != 6) {
			throw new Exception("上传数据列数不对,应为6列,请查看说明帮助!");
		}
		if (StringUtils.isEmpty(content[0])) {
			throw new Exception("公公司不能为空");
		}
		if (StringUtils.isEmpty(content[1])) {
			throw new Exception("星级不能为空");
		}
		if (StringUtils.isEmpty(content[2])) {
			throw new Exception("商品种类不能为空");
		} else if (!checkDictitem(content[2], "IM_FXCOMCATEGORY", user)) {
			throw new Exception("商品种类[" + content[2] + "]不存在");
		}
		if (StringUtils.isEmpty(content[3]) || content[3].length()>10 || !PublicUtils.isInteger(content[3])) {
			throw new Exception("最高库存不能为空且必须是长度小于10位的整数");
		}
		if (StringUtils.isEmpty(content[4]) || content[4].length()>10 || !PublicUtils.isInteger(content[4])) {
			throw new Exception("红色预警不能为空且必须是长度小于10位的整数");
		}
		if (StringUtils.isEmpty(content[5]) || content[5].length()>10 || !PublicUtils.isInteger(content[5])) {
			throw new Exception("黄色预警不能为空且必须是长度小于10位的整数");
		}
		if (new Integer(content[3])<new Integer(content[4]) || new Integer(content[3])<new Integer(content[5])){
			throw new Exception("最高库存不能小于红色预警或黄色预警的值");
		}
	}

	// 检查固定参数类型
	public boolean checkDictitem(String item, String groupid, User user) throws Exception {
		Dictitem delegate = (DictitemBO) BOFactory.build(DictitemBO.class,user);
		DictitemDBParam listVO = new DictitemDBParam();
		listVO.set_se_groupid(groupid);
		listVO.set_se_dictid(item);
		if (delegate.doQuery(listVO).getRowCount() <= 0) {
			return false;
		}
		return true;
	}
}