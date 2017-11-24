package com.sunrise.boss.ui.cms.way;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.business.cms.common.AuditUtils;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;

public class BatchAGWayCheck extends BaseCheckFormat {
	public BatchAGWayCheck() {
		super();
	}

	public void checkFile(FormFile file,HashMap parameterMap) throws Exception {
		if (!file.getContentType().equals("text/plain")) {
			throw new Exception("Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		}
	}

	public void checkLine(String line, int rowCount) throws Exception {
		if (null == line || "".equals(line)) {
			return;
		}
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String[] items = line.split("\\|");
		
		// �������
		if (items.length != 29) {
			throw new Exception("�ϴ�������������,ӦΪ29��,��鿴˵������!");
		}
		
		//��������0
		if (items[0].getBytes().length>18 || StringUtils.isEmpty(items[0])){
			throw new Exception("�������볤�ȳ�����ȷ��ΧΪ1~18");
		}else
		{
			if(!AuditUtils.doCheckWayidStyle(items[0].trim()))
			{
				throw new Exception("�������벻���Ϲ淶,Ӧ������ĸ��ͷ,����û���»���");
			}
		}
		
		//��������1
		if(StringUtils.isEmpty(items[1]) || items[1].getBytes().length>256){
			throw new Exception("�������Ʋ���Ϊ���ҳ��Ȳ��ܴ���256");
		}
		
		//�ϼ���������2
		if (!items[2].matches("\\w{1,18}")){
			throw new Exception("�ϼ��������볤�ȳ�����ȷ��ΧΪ1~18");
		}

		//������3
		if (!items[3].matches("\\d{0,2}")){
			throw new Exception("������������ȷΪ0-2λ����");
		}	
		
		//���й�˾4
		if(items[4].getBytes().length>14){
			throw new Exception("���й�˾���Ȳ��ܴ���14");
		}
		
		//�ֹ�˾5
		if(items[5].getBytes().length>14){
			throw new Exception("�ֹ�˾���Ȳ��ܴ���14");
		}
		
		//������������6
		if(items[6].getBytes().length>14){
			throw new Exception("�����������ĳ��Ȳ��ܴ���14");
		}

		//΢����7
		if(items[7].getBytes().length>14){
			throw new Exception("΢���򳤶Ȳ��ܴ���14");
		}
		
		//��������8
		if(items[8].getBytes().length>18){
			throw new Exception("�����������Ȳ��ܴ���18");
		}
		
		//��ϸ��ַ9
		if(items[9].getBytes().length>128){
			throw new Exception("��ϸ��ַ���Ȳ��ܴ���128");
		}

		//����������10-------------------------------------------
		if(StringUtils.isEmpty(items[10]) || items[10].getBytes().length>64){
			throw new Exception("�������������Ȳ���Ϊ���Ҳ��ܴ���64");
		}
		
		//��������ϵ�绰11
		if(items[11].getBytes().length>20){
			throw new Exception("��������ϵ�绰��ʽ����");
		}
		
		//�����˵�������12
		if (!StringUtils.isEmpty(items[12])&&!items[12].matches("[_a-zA-Z\\d\\-\\.]+@[_a-zA-Z\\d\\-]+(\\.[_a-zA-Z\\d\\-]+)+")){
			throw new Exception("�����˵��������ʽ����");
		}
		
		//ҵ����ϵ������13
		if(StringUtils.isEmpty(items[13]) || items[13].getBytes().length>64){
			throw new Exception("ҵ����ϵ����������Ϊ���ҳ��Ȳ��ܴ���64");
		}

		//ҵ����ϵ����ϵ�绰14
		if(items[14].getBytes().length>20){
			throw new Exception("ҵ������ϵ�绰��ʽ����");
		}	
		
		//ҵ����ϵ�˵�������15
		if (!StringUtils.isEmpty(items[15])&&!items[15].matches("[_a-zA-Z\\d\\-\\.]+@[_a-zA-Z\\d\\-]+(\\.[_a-zA-Z\\d\\-]+)+")){
			throw new Exception("ҵ����ϵ�˵��������ʽ����");
		}
		
		//��ͬ����16---------------------------------------------------------------------
		if (!items[16].matches("\\w{1,17}")){
			throw new Exception("��ͬ���볤���д�,��ȷ��Χ1~17");
		}
		
		//��ͬ����17
		if(StringUtils.isEmpty(items[17]) || items[17].getBytes().length>255){
			throw new Exception("��ͬ���Ʋ���Ϊ���ҳ��Ȳ��ܴ���255");
		}
		
		//ǩ���ͬʱ��18
		Date d1=null;
		try {
			d1 = format.parse(items[18]);
		} catch (Exception e) {
			throw new Exception("ǩ���ͬʱ���ʽ���ԣ���ȷ��ʽΪ[yyyy-MM-dd]");
		}

		//��ͬ������19
		Date d2=null;
		try {
			d2 = format.parse(items[19]);
		} catch (Exception e) {
			throw new Exception("��ͬ�����ո�ʽ���ԣ���ȷ��ʽΪ[yyyy-MM-dd]");
		}
		
		//�ж������Ⱥ�
		if (d2.before(d1)){
			throw new Exception("��ͬ�����ո�����ǩ���ͬʱ�䣬��������");
		}

		//���˴���20
		if(items[20].getBytes().length>64){
			throw new Exception("���˴����Ȳ��ܴ���64");
		}
		
		//Ӫҵִ�ձ��21
		if(items[21].getBytes().length>64){
			throw new Exception("Ӫҵִ�ձ�ų��Ȳ��ܴ���64");
		}
		
		//��Ӫ�������ͱ���22
		if (!items[22].matches("\\d{0,2}")){
			throw new Exception("��Ӫ�������ͣ���ȷΪ0-2λ����");
		}
		
		//��Ӫ��Χ23
		if (!items[23].matches("\\d{0,2}")){
			throw new Exception("��Ӫ��Χ����ȷΪ0-2λ����");
		}
		
		//�����ʺ�24------------------------------------------------------
		if (!items[24].matches("\\d{1,6}")){
			throw new Exception("�����ʺų�����ȷΪ1-6λ����");
		}	
		
		//��������25
		if(StringUtils.isEmpty(items[25]) || items[25].getBytes().length>128){
			throw new Exception("�������в�Ϊ�ܿ��ҳ��Ȳ��ܴ���128");
		}
		
		//�����ʺ�26
		if(items[26].getBytes().length>50){
			throw new Exception("�����ʺų��Ȳ��ܴ���50");
		}
		
		//�����˺�����27
		if(items[27].getBytes().length>50){
			throw new Exception("�����˺����Ƴ��Ȳ��ܴ���50");
		}
		
		//���������֤����28
		if(items[28].getBytes().length>32){
			throw new Exception("���������֤���볤�Ȳ��ܴ���32");
		}
		
	}
	
	//test
//	public static void main(String[] args) throws Exception{
//		BatchAGWayCheck check = new BatchAGWayCheck();
//		String str = "JFJMXXXXX|��������|JFJM00000|1|JM|JM|||1|���Ž���·101��|����|020-31647847|abcd@abc.com|����|0726-98564587|abc@xyz.com|45478|���Ժ�ͬ��Ϣ|1990-12-12|2006-01-02|����|abcde12323|1|1|98546|�й�����|123456789|��˾XX�ʻ�|1234567897894587";
//		try{
//			check.checkLine(str,0);
//			System.out.println("ok");
//		}catch(Exception e){
//		    e.printStackTrace();
//		}
//	}
}