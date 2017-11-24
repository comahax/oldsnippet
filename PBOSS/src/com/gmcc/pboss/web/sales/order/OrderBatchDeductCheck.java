package com.gmcc.pboss.web.sales.order;

import java.io.File;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.gmcc.pboss.common.utils.tools.CheckUtil;
import com.sunrise.jop.ui.User;

public class OrderBatchDeductCheck extends BaseCheckFormat{
	String optype = "";
			public OrderBatchDeductCheck() {
				// TODO Auto-generated constructor stub
			}

			public void checkFile(File file, HashMap parameterMap, String contentType)
					throws Exception {
				if (!"text/plain".equalsIgnoreCase(contentType)) {
					throw new Exception("要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
				}
				
				optype = (String)parameterMap.get("optype");
				if(optype == null || "".equals(optype)){
					throw new Exception("处理类型不允许为空，请选择!");
				}
				
			}

			public void checkLine(String line, int rowCount, User user)
					throws Exception {
				String[] content = StringUtils.splitPreserveAllTokens(line, "|");
				if(content.length == 1 || content.length == 4){
					if("BATCHDEDUCT".equals(optype)){
						if (content.length != 1) {
							throw new Exception("[ " + line	+ " ] ,列数不正确,正确列数为1");
						}
					}else if("CASH".equals(optype)){
						if (content.length != 4) {
							throw new Exception("[ " + line	+ " ] ,列数不正确,正确列数为3");
						}
					}
				}else{
					if("BATCHDEDUCT".equals(optype)){
						if (content.length != 1) {
							throw new Exception("[ " + line	+ " ] ,列数不正确,正确列数为1");
						}
					}else if("CASH".equals(optype)){
						if (content.length != 4) {
							throw new Exception("[ " + line	+ " ] ,列数不正确,正确列数为3");
						}
					}
				}
				
				if (!CheckUtil.checkString(content[0],18,false)) {
					throw new Exception("[ " + content[0] + " ] 订单编号要求字符类型，最长18位，且不能为空");
				}  
			}  
		}
