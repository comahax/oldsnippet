package com.sunrise.boss.ui.cms.terminalrewardstd;

 
import java.util.HashMap; 
import org.apache.commons.lang.StringUtils; 
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.business.cms.common.CheckUtil;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;
 

public class TerminalrewardstdCheck extends BaseCheckFormat {
	private String region;
	public TerminalrewardstdCheck() {
		// TODO Auto-generated constructor stub
	}

	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		region = parameterMap.get("region").toString();
		if (!"text/plain".equalsIgnoreCase(file.getContentType())) {
			throw new BusinessException("",
					"要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
		}
	}

	public void checkLine(String line, int rowCount, User user)
			throws Exception {
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");  
		if (content.length != 7) {
			throw new Exception("上传数据列数不对,应为6列,请查看说明帮助!");
		}
		if (StringUtils.isEmpty(content[0])) {
			throw new BusinessException("", "[终端商品ID]不能为空");
		}
		if ( CheckUtil.isEmpty(content[1])) {
			throw new BusinessException("","[基准价]不能为空");
		}    
		if (StringUtils.isEmpty(content[2])) {
			throw new BusinessException("", "[酬金标准]不能为空"); 
		} 
		if (StringUtils.isEmpty(content[3])) {
			throw new BusinessException("", "[酬金类型]不能为空");
		}
		if (StringUtils.isEmpty(content[4])) {
			throw new BusinessException("", "[计酬类型]不能为空");
		}  
		for (int i = 0; i < content.length - 1; i++) {
			switch (i) {
			case 0:
				if (!CheckUtil.checkString(content[i], 18, true)) {
					throw new Exception("[终端商品ID]不能大于18位");
				}
				break;
			case 1:
				if (content[i] != null && !"".equals(content[i])) {
					if (!CheckUtil.checkDoubleNum(content[i])) {
						throw new Exception("[基准价]只能大于等于0");
					}
				}
				break;
			case 2:
				if (content[i] != null && !"".equals(content[i])) {
					if (!CheckUtil.checkDouble(content[i], 12, 4)) {
						throw new Exception("[酬金标准]整数部分不能超过12位,小数部分不能超过4位");
					}
				}
				break; 
			case 3:
				
				if(region.equals("999")){
				   if (!content[i].trim().matches("(1|2|3|4|11|12|13|14)")) {
					throw new Exception("[酬金类型]格式不对,应该为1、2、3、4、11、12、13、14中的一个数值");
				    }
				}else if(!region.equals("999")){
				   if (!content[i].trim().matches("(1|2|3|4|5|6|11|12|13|14)")) {
					throw new Exception("[酬金类型]格式不对,应该为1、2、3、4、5、6、11、12、13、14中的一个数值");
				    }
				}
				break;
			case 4:
				if (!content[i].trim().matches("[1-2]")) {
					throw new Exception("[计酬类型]格式不对,只能为数字1或2");
				}
				break;
			case 5:
				if (!StringUtils.isEmpty(content[5])) {
					if (!CheckUtil.checkString(content[i], 128, true)) {
						throw new Exception("[备注]不能超过128个字符");
					}
				}
				break;

			}
		}
	}

}
