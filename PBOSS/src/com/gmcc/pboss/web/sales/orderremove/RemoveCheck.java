package com.gmcc.pboss.web.sales.orderremove;

import java.io.File;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.base.dictitem.DictitemDBParam;
import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.gmcc.pboss.control.base.dictitem.Dictitem;
import com.gmcc.pboss.control.base.dictitem.DictitemBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.ui.User;

public class RemoveCheck extends BaseCheckFormat{

	@Override
	public void checkFile(File file, HashMap parameterMap, String contentType)
			throws Exception {
		// TODO Auto-generated method stub
		if (!"text/plain".equalsIgnoreCase(contentType)) {
			throw new Exception("要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
		}
	}

	@Override
	public void checkLine(String line, int rowCount ,User user) throws Exception {
		// TODO Auto-generated method stub
//		订单编号要求字符类型，最大长度18位。检查通过则进入下一步，不通过则提示出错文件行和错误描述，终止文件上传。
		String item[] = StringUtils.splitPreserveAllTokens(line,"|");
		if(item.length != 4)
			throw new Exception("上传数据列数不对,应为3列,请查看说明帮助!");
		
		for (int i = 0; i < item.length; i++) {
			
			switch (i) {
			// 渠道编码
			case 0:
				if ("".equals(item[i].trim())
						|| item[i].getBytes("GBK").length > 18) {
					throw new Exception("[订单编号]不能为空或大于18位");
				}
				break;
			
			case 1:
				if ("".equals(item[i].trim())) {
					throw new Exception("[作废原因]不能为空");
				}
				if (!checkDictitem(item[i],"FX_DISUSE",user)) {
					throw new Exception("固定参数[作废原因]的值不正确");
				}
				break;
			}
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
