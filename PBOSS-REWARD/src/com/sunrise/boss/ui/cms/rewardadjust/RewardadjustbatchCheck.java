package com.sunrise.boss.ui.cms.rewardadjust;


import java.text.SimpleDateFormat;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;
import com.sunrise.pub.tools.StringSplit;

public class RewardadjustbatchCheck extends BaseCheckFormat {
	
	private WayDelegate waydelegate;
	/**
	 * 1.�������
	 * PUNISH:�ۼ�;RETURN:����;BONUS:����;
	 */
	protected static HashMap ADJUSTKIND_MAP=new HashMap();
	/**
	 * 2.��������ʽ
					EFTCURMONTH:��Ӱ�쵱�³��(����"�ۼ�","����"��"����")
					EFTCURORAFTERMONTH
	 */
	protected static HashMap ADJUSTTYPE_MAP=new HashMap();
	/**
	 * 3.����ԭ������
					�ۼ�:
						P-CH:����;P-PTWG:����Υ��;P-YWWG:ҵ��Υ��;P-QTYY ����ԭ��ۼ�
					����:
						R-DKBH:��۲���;R-LSBG:©�㲹��;R-QTYY:����ԭ�򷵻�
					����:
						B-YWJL ҵ����;
	 */
	protected static HashMap REASONTYPE_MAP=new HashMap();
	
	public RewardadjustbatchCheck() throws Exception {
		ADJUSTKIND_MAP.put("PUNISH", "PUNISH");
		ADJUSTKIND_MAP.put("RETURN", "PUNISH");
		ADJUSTKIND_MAP.put("BONUS", "PUNISH");
		ADJUSTKIND_MAP.put("EFTCURORAFTERMONTH", "EFTCURORAFTERMONTH");
		ADJUSTKIND_MAP.put("EFTCURMONTH", "EFTCURMONTH");
		REASONTYPE_MAP.put("P-CH", "P-CH");
		REASONTYPE_MAP.put("P-PTWG", "P-PTWG");
		REASONTYPE_MAP.put("P-YWWG", "P-YWWG");
		REASONTYPE_MAP.put("P-QTYY", "P-QTYY");
		REASONTYPE_MAP.put("R-DKBH", "R-DKBH");
		REASONTYPE_MAP.put("R-LSBG", "R-LSBG");
		REASONTYPE_MAP.put("R-QTYY", "R-QTYY");
		REASONTYPE_MAP.put("B-YWJL", "B-YWJL");
		waydelegate = new WayDelegate();
	}

	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		if (!"text/plain".equalsIgnoreCase(file.getContentType())) {
			throw new BusinessException("","Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		}
	}
	
	public void checkLine(String line, int rowCount, User user) throws Exception {
		
		String[] content =StringSplit.split(line, "|");
		
		if (content.length == 8) {
			;
		}else{
			throw new BusinessException("","����������.Ӧ����7��");
		}

		SimpleDateFormat format=new SimpleDateFormat("yyyyMM");
		format.setLenient(false);
		/**
		 * PUNISH:�ۼ�;RETURN:����;BONUS:����;
		 */
		if(StringUtils.isEmpty(content[0]) || !ADJUSTKIND_MAP.containsKey(content[0]) || content[0].length() >32){
			throw new BusinessException("","����������Ͳ���ȷ!");
		}
		if(StringUtils.isEmpty(content[1]) || content[1].length() >18){
			throw new BusinessException("","������벻��Ϊ��!");
		}
		
		if (StringUtils.isEmpty(content[2])) {
			throw new BusinessException("", "���ý����²��Ϸ�,����Ϊ��!");
		}
		if(content[2].length() != 6){
			throw new BusinessException("", "���ý����²��Ϸ�,���ȱ���Ϊ6λ!");
		}
		
		if(!NumberUtils.isNumber(content[2])){
			throw new BusinessException("", "���ý����²��Ϸ�,ֻ��Ϊ����!");
		}
			
		try {
			format.parse(content[2]);
		} catch (Exception e) {
			throw new BusinessException("", "���ý����²��Ϸ�,ӦΪ6λ��������!");
		}
		String regex = "^([1-9]\\d{3}[0][1-9])|([1-9]\\d{3}[1][0-2])$";
		if (!content[2].matches(regex)) {
			throw new BusinessException("", "���ý����²��Ϸ�,�·ݷ�ΧӦΪ[01-12]!");
		}
		
		try {
			format.parse(content[7]);
		} catch (Exception e) {
			throw new BusinessException("", "������²��Ϸ�,ӦΪ6λ��������!");
		}
		if (!content[7].matches(regex)) {
			throw new BusinessException("", "������²��Ϸ�,�·ݷ�ΧӦΪ[01-12]!");
		}
		
		if(Integer.parseInt(content[2]) < Integer.parseInt(content[7])){
			throw new BusinessException("", "�������Ӧ��С�ڵ������ý�����!");
		}
		
//		 ���У��
		if (StringUtils.isEmpty(content[3]) || !NumberUtils.isNumber(content[3])) {
			throw new BusinessException("", "�������Ϸ�,ӦΪ����,֧����λС��");
		}
		try {
			if (!(checkAmtFormat(content[3], 10)))
				throw new Exception("�������Ϸ�,(" + content[3]
						+ ")�����������10λ������С��������һ����2λ!");
		} catch (Exception e) {
			throw new Exception("�������Ϸ�,(" + content[3]
					+ ")�����������10λ������С��������һ����2λ!");
		}
	
		if(StringUtils.isEmpty(content[4]) || !ADJUSTKIND_MAP.containsKey(content[4]) || content[4].length() >32){
			throw new BusinessException("","������ʽ���Ͳ���ȷ!");
		}
		
		if(StringUtils.isEmpty(content[5]) || !",".equals(content[5].substring(content[5].length()-1)) || content[5].length() >32){
			throw new BusinessException("","����ԭ�����Ͳ���ȷ!");
		}
		if(StringUtils.isEmpty(content[6]) || content[6].length() >500){
			throw new BusinessException("","��ע����ȷ!");
		}
		String[] reasontype = content[5].split(",");
		for (int i=0;i<reasontype.length;i++) {
			if (!REASONTYPE_MAP.containsKey(reasontype[i])) {
				throw new BusinessException("","����ԭ�����Ͳ���ȷ!");
			}
		}

		WayVO wayvo=waydelegate.doFindByPk(content[1], user);
		if(wayvo==null){
			throw new BusinessException("","������벻����");
		}
		if ("RETURN".equals(content[0])||("BONUS".equals(content[0]))) {
			if (!"EFTCURMONTH".equals(content[4])) {
				throw new BusinessException("","'�������'ѡ��'RETURN����'��'BONUS����'ʱ��'������ʽ'������'EFTCURMONTH'��Ӱ�쵱ǰ�³��!");
			}
		}
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
		
