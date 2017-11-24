package com.sunrise.boss.ui.cms.zjty.chzjtyempltotal;

import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;

public class BatchEmpltotalCheck extends BaseCheckFormat {
	private int operType = 0;
	String[] heads = StringUtils
			.splitPreserveAllTokens(
					"年月|渠道代码|核定编制人数|说明",
					"|");

	public BatchEmpltotalCheck() {
		// TODO Auto-generated constructor stub
	}

	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		this.operType = Integer.parseInt(parameterMap.get("operType")
				.toString());
		if (!"text/plain".equalsIgnoreCase(file.getContentType())) {
			throw new BusinessException("",
					"要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
		}
	}

	public void checkLine(String line, int rowCount, User user)
			throws Exception {
		// TODO Auto-generated method stub
		String[] items = StringUtils.splitPreserveAllTokens(line, "|");
		/*
		 * 根据不同的操作，上传文件列数不同。
		 */
	
		if (this.operType != 2 && items.length != 4) {
			throw new Exception("上传数据列数不对,应为4列,请查看说明帮助!");
			
		} else if (this.operType == 2 && items.length != 2) {
			throw new Exception("上传数据列数不对,应为2列,请查看说明帮助!");
		}
		if(StringUtils.isBlank(items[0]) || StringUtils.isBlank(items[1]))
		{
			throw new Exception("[年月]或[渠道代码]不能为空");
		}
		
		if(this.operType!=2)
		{
			WayDelegate delegate=new WayDelegate();
			WayVO vo=delegate.doFindByPk(items[1], user);
			if(vo==null)
			{
				throw new Exception("渠道表中不存在相关渠道代码的记录："+items[1]);
			}else if(!"AG".equals(vo.getWaytype()) && !"ZJTY".equals(vo.getWaysubtype()))
			{
				throw new Exception("本菜单只提供自建他营类型的渠道录入和修改");
			}
		}
		String regex = "^([1-9]\\d{3}[0][1-9])|([1-9]\\d{3}[1][0-2])$";
		if(!items[0].trim().matches(regex))
		{
			throw new Exception("[年月]格式为[YYYYMM]");
		}
		if(this.operType==0 || this.operType==1)
		{
			if(StringUtils.isNotBlank(items[1]) && items[1].getBytes("GBK").length>32)
			{
				throw new Exception("[渠道代码]长度超过32位");
			}
			if (StringUtils.isEmpty(items[2]) || !NumberUtils.isNumber(items[2])) {
				throw new BusinessException("", "[核定编制数]不合法,应为数字,支持两位小数");
			}
			try {
				if (!(checkAmtFormat((items[2]), 4)))
					throw new Exception("[核定编制数]不合法,(" + items[2]
							+ ")整数部分最多4位，如有小数部分则一定是2位!");
			} catch (Exception e) {
				throw new Exception("[核定编制数]不合法,(" + items[2]
						+ ")整数部分最多4位，如有小数部分则一定是2位!");
			}
			
			if(StringUtils.isNotBlank(items[3]) && items[3].getBytes("GBK").length>32)
			{
				throw new Exception("[说明]长度超过255位");
			}
		}
		
	}


	public static void main(String[] args)throws Exception {
		String regex = "^([1-9]\\d{3}[0][1-9])|([1-9]\\d{3}[1][0-2])$";
		System.out.println("200810".matches(regex));
		System.out.println(StringUtils.isNotBlank(" "));
	}
	
	public boolean checkAmtFormat(String amt, int length) {
		amt = amt.trim();
		if (amt.indexOf(".") != -1) {
			if (amt.indexOf(".") == 0) {
				return false;
			}
			if (amt.indexOf(".") > length) {
				return false;
			}
			if ((amt.length() - amt.indexOf(".")) != 3) {
				return false;
			}
		} else {
			if (amt.length() > length) {
				return false;
			}
		}
		return true;
	}
}
