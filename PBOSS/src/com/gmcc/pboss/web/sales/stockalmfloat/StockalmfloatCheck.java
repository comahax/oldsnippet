package com.gmcc.pboss.web.sales.stockalmfloat;

import java.io.File;
import java.util.HashMap;

import com.gmcc.pboss.business.base.dictitem.DictitemDBParam;
import com.gmcc.pboss.business.channel.way.WayDBParam;
import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.gmcc.pboss.control.base.dictitem.Dictitem;
import com.gmcc.pboss.control.base.dictitem.DictitemBO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;

public class StockalmfloatCheck extends BaseCheckFormat {

	public void checkFile(File file, HashMap parameterMap, String contentType)
			throws Exception {
		if (!"text/plain".equalsIgnoreCase(contentType)) {
			throw new Exception("要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
		}
	}

	public void checkLine(String line, int rowCount, User user)
			throws Exception {
//		有两个split的方法
//		String[] fields = StringUtils.splitPreserveAllTokens(line, "|");
//		String[] content = StringUtils.split(line, "|");
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		if (content.length != (6+1)) {
			throw new Exception("上传数据列数不对,应为6列,请查看说明帮助!");
		}
		if (StringUtils.isEmpty(content[0])) {
			throw new Exception("星级不能为空");
		}
		if (StringUtils.isEmpty(content[1])) {
			throw new Exception("套卡品牌不能为空");
		}
		if (StringUtils.isEmpty(content[2])) {
			throw new Exception("最高库存系数不能为空");
		}
		int pos2=content[2].trim().indexOf(".");
		if(pos2==-1){
			if(content[2].trim().length()>3)
				throw new Exception("最高库存系数:数字类型,要求大于零,整数位最多三位,小数位最多两位");
		}else{
			if(pos2>3||(content[2].length()-pos2)>3)
				throw new Exception("最高库存系数:数字类型,要求大于零,整数位最多三位,小数位最多两位");
		}
		if (StringUtils.isEmpty(content[3])) {
			throw new Exception("激活量系数不能为空");
		}
		int pos3=content[3].trim().indexOf(".");
		if(pos3==-1){
			if(content[3].trim().length()>3)
				throw new Exception("激活量系数:数字类型,要求大于零,整数位最多三位,小数位最多两位");
		}else{
			if(pos3>3||(content[3].length()-pos3)>3)
				throw new Exception("激活量系数:数字类型,要求大于零,整数位最多三位,小数位最多两位");
		}
		if (StringUtils.isEmpty(content[4])) {
			throw new Exception("红色预警系数不能为空");
		}
		int pos4=content[4].trim().indexOf(".");
		if(pos4==-1){
			if(content[4].trim().length()>1||Float.parseFloat(content[4].trim())>1||Float.parseFloat(content[4].trim())<0)
				throw new Exception("红色预警系数:数字类型,要求大于零且小于1,小数位最多两位");
		}else{
			if(pos4>1||(content[4].length()-pos4)>3||Float.parseFloat(content[4].trim())>1||Float.parseFloat(content[4].trim())<0)
				throw new Exception("红色预警系数:数字类型,要求大于零且小于1,小数位最多两位");
		}
		if (StringUtils.isEmpty(content[5])) {
			throw new Exception("黄色预警系数不能为空");
		}
		int pos5=content[5].trim().indexOf(".");
		if(pos5==-1){
			if(content[5].trim().length()>1||Float.parseFloat(content[5].trim())>1||Float.parseFloat(content[5].trim())<0)
				throw new Exception("黄色预警系数:数字类型,要求大于零且小于1,小数位最多两位");
		}else{
			if(pos5>1||(content[5].length()-pos5)>3||Float.parseFloat(content[5].trim())>1||Float.parseFloat(content[5].trim())<0)
				throw new Exception("黄色预警系数:数字类型,要求大于零且小于1,小数位最多两位");
		}
		
	}
}