package com.sunrise.boss.ui.zifee.yxplansplitbatch;

import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.pub.tools.PublicUtils;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;



public class YxPlanSplitBatchCheck extends BaseCheckFormat {

	public YxPlanSplitBatchCheck() {
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
		String[] items = line.split("\\|");		
		// �������
		if ( items.length != 5) {
			throw new Exception("�ϴ�������������,ӦΪ5��,��鿴˵������!");
		}
		// ���λ��
		if (items[0].length() != 8) {
			throw new Exception("�������ڲ��ԣ�Ӧ��Ϊ8λ����!");
		}		

		// �������
		try {
			Long temp = Long.valueOf(items[0]);
		} catch (Exception e) {
			throw new Exception("�ϴ����ݵ����������������Ͳ���(" + items[0] + "),Ӧ���������ַ���!");
		}
		//Ʒ�Ʊ�ʶ
		if(!PublicUtils.isInteger(items[1])){
			if(!items[1].trim().startsWith("Brand"))
			{
				throw new Exception("�ϴ����ݵ�Ʒ�Ʊ�ʶ�������Ͳ���(" + items[1] + "),Ӧ���������ַ���������Brand��ͷ���ַ���!");
			}
		}		
		/*
		try { // ���items[2]�Ƿ�Ϊ����
			Long temp = Long.valueOf(items[2]);
		} catch (Exception e) {
			throw new Exception("�ϴ����ݵķ����ʶ�������Ͳ���(" + items[2] + "),Ӧ���������ַ���!");
		}*/
		
		try { // ���items[2]�Ƿ�Ϊ����[��������ͨ����ʹ�÷�]
			Double temp = Double.valueOf(items[2]);
			
			if(temp.doubleValue() <= 0)throw new Exception("�ϴ����ݵĵ�3��[��������ͨ����ʹ�÷�]������Ͳ���(" + items[2] + "),Ӧ���������ַ���������������!");		
		
		} catch (Exception e) {
			throw new Exception("�ϴ����ݵĵ�3��[��������ͨ����ʹ�÷�]������Ͳ���(" + items[2] + "),Ӧ���������ַ���!");
		}
		try { // ���items[2]�Ƿ�Ϊ�Ϸ�
						
			if(!(checkAmtFormat(items[2],14))) throw new Exception("�ϴ����ݵĵ�3��[��������ͨ����ʹ�÷�]����ʽ����(" + items[2] + "),�����������14λ��С������һ����2λ!"); 
			
		} catch (Exception e) {
			throw new Exception("�ϴ����ݵĵ�3��[��������ͨ����ʹ�÷�]����ʽ����(" + items[2] + "),�����������14λ��С������һ����2λ!"); 
		}
		try { // ���items[3]�Ƿ�Ϊ����[��������ͨ����ʹ�÷�]
			Double temp = Double.valueOf(items[3]);
			
			if(temp.doubleValue() <= 0)throw new Exception("�ϴ����ݵĵ�4��[��������ͨ����ʹ�÷�]������Ͳ���(" + items[3] + "),Ӧ���������ַ���������������!");		
		
		} catch (Exception e) {
			throw new Exception("�ϴ����ݵĵ�4��[��������ͨ����ʹ�÷�]������Ͳ���(" + items[3] + "),Ӧ���������ַ���!");
		}
		try { // ���items[3]�Ƿ�Ϊ�Ϸ�
						
			if(!(checkAmtFormat(items[3],14))) throw new Exception("�ϴ����ݵĵ�4��[��������ͨ����ʹ�÷�]����ʽ����(" + items[3] + "),�����������14λ��С������һ����2λ!"); 
			
		} catch (Exception e) {
			throw new Exception("�ϴ����ݵĵ�4��[��������ͨ����ʹ�÷�]����ʽ����(" + items[3] + "),�����������14λ��С������һ����2λ!"); 
		}
		try { // ���items[4]�Ƿ�Ϊ������5��[������;ͨ����ʹ�÷�]
			Double temp = Double.valueOf(items[4]);
			
			if(temp.doubleValue() <= 0)throw new Exception("�ϴ����ݵĵ�5��[������;ͨ����ʹ�÷�]������Ͳ���(" + items[4] + "),Ӧ���������ַ���������������!");		
		
		} catch (Exception e) {
			throw new Exception("�ϴ����ݵĵ�5��[������;ͨ����ʹ�÷�]������Ͳ���(" + items[4] + "),Ӧ���������ַ���!");
		}
		try { // ���items[1]�Ƿ�Ϊ�Ϸ�
						
			if(!(checkAmtFormat(items[4],14))) throw new Exception("�ϴ����ݵĵ�5��[������;ͨ����ʹ�÷�]����ʽ����(" + items[4] + "),�����������14λ��С������һ����2λ!"); 
			
		} catch (Exception e) {
			throw new Exception("�ϴ����ݵĵ�5��[������;ͨ����ʹ�÷�]����ʽ����(" + items[4] + "),�����������14λ��С������һ����2λ!"); 
		}
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
	

	public static void main(String[] args) {
			
		YxPlanSplitBatchCheck check = new YxPlanSplitBatchCheck();
		
	}
}
