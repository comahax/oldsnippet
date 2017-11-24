package com.sunrise.boss.ui.cms.fee.bail;

import java.util.Date;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;


public class BailBatchCheck extends BaseCheckFormat {

	public BailBatchCheck(){
		super();
	}
	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		if (!file.getContentType().equals("text/plain")) {
			throw new Exception("Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		}
	}

	public void checkLine(String line, int rowCount) throws Exception {

		if (rowCount > 10000) {
			throw new Exception("�ļ��������ܳ���10000��");
		}
		if (null == line || "".equals(line)) {
			return;
		}
		String[] items = StringUtils.split(line, "|");
		// �������
		if (items.length != 8) {
			throw new Exception("�ϴ�������������,ӦΪ8��,��鿴˵������!");
		}
		if (items[0].getBytes().length > 18)
			throw new Exception("[��������]���������벻����18");	
		if (items[1].getBytes().length == 0 || "0,1".indexOf(items[1])==-1)
			throw new Exception("[��֤������]����ȷ��ӦΪ����0��1��(0Ӫҵ��֤��,1������֤��)");	

		try { // ���items[2]�Ƿ�Ϊ����
			Double temp = Double.valueOf(items[2]);
			
			if(temp.doubleValue() <= 0)throw new Exception("[���]����ȷ(" + items[2] + "),Ӧ���������ַ���������������!");		
		
		} catch (Exception e) {
			throw new Exception("[���]����ȷ(" + items[2] + "),Ӧ���������ַ���������������!");
		}
		try { // ���items[2]�Ƿ�Ϊ�Ϸ�
						
			if(!(checkAmtFormat(items[2],14))) throw new Exception("[���]��ʽ����(" + items[2] + "),�����������14λ��С������һ����2λ!"); 
			
		} catch (Exception e) {
			throw new Exception("[���]��ʽ����(" + items[2] + "),�����������14λ��С������һ����2λ!"); 
		}
		
		java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyyMMdd");		
		if(items[3].length()>0){
			try{
			  format.parse(items[3]);
			}catch (Exception e){
				throw new Exception("[��������]��ʽ����ȷ��Ӧ��ΪyyyyMMdd");
			}
		}else{
			throw new Exception("[��������]��ȷ������Ϊ�գ�");		
		}
		if (items[4].getBytes().length == 0 || "0,1,2,3,4".indexOf(items[1])==-1)
			throw new Exception("[��֤������]����ȷ��ӦΪ������������һ������0,1,2,3,4��(0��ȡ,1׷��,2�ۿ�,3����,4����)");	
		
		if (items[5].getBytes().length == 0)
			throw new Exception("[�շ�Ա������]Ϊ�գ�Ӧ��Ϊ��");	
		if (items[5].getBytes().length > 15)
			throw new Exception("[�շ�Ա������]���������벻����15");	
		if(items[6].length()>0){
			try{
			  format.parse(items[6]);
			}catch (Exception e){
				throw new Exception("[�շ�����]��ʽ����ȷ��Ӧ��ΪyyyyMMdd");
			}
		}else{
			throw new Exception("[�շ�����]��ȷ������Ϊ�գ�");		
		}
		if (items[7].getBytes().length > 255)
			throw new Exception("[��ע]���������벻����255");	
	}
	public boolean checkAmtFormat(String amt,int length){
		amt=amt.trim();
		if(amt.indexOf(".")!=-1){
			if(amt.indexOf(".")==0) return false;
			if(amt.indexOf(".")>length) return false;
			if((amt.length()-amt.indexOf("."))!=3) return false;
		}else{
			if(amt.length()>length) return false;
		}
		return true;
	}
	

}
