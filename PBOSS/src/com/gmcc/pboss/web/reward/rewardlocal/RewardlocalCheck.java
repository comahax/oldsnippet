package com.gmcc.pboss.web.reward.rewardlocal;

import java.io.File;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;

public class RewardlocalCheck extends BaseCheckFormat{

	private String rewardmonth;
	private String rpttype;
	public void checkFile(File file, HashMap parameterMap, String contentType)
	throws Exception {
	if (!"text/plain".equalsIgnoreCase(contentType)) {
		throw new Exception("Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		}
	rewardmonth = (String)parameterMap.get("rewardmonth");
	rpttype = (String)parameterMap.get("rpttype");
	}

	@Override
	public void checkLine(String line, int rowCount) throws Exception {
		// TODO Auto-generated method stub
		String[] items = StringUtils.splitPreserveAllTokens(line, "|");
		if("RPWDLocalRPT".equals(rpttype)){
			if(rowCount>1 ){
				if(items.length< 3 || items[0].trim().length() == 0)
					throw new Exception("��ѡ����ļ���ʽ�������ݱ���>=3��ҵ�һ���Ϊ�գ������м���\"|\"�ֿ�");
			}
		}else{
			if(items.length<=6)
				throw new Exception("��ѡ����ļ���ʽ�������ݱ���>=7������м���\"|\"�ֿ�");
//			if(rowCount>1){
//				if(items[5].trim().length() >0){
//					if(!items[5].trim().matches("\\d{1,2}")){
//						throw new Exception("�Ǽ�������1��2λ������");
//					}
//				}
//			}		
		}				
	}
	
	
}
