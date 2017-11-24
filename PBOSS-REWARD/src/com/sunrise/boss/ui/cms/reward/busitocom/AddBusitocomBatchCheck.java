package com.sunrise.boss.ui.cms.reward.busitocom;

import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.business.cms.provincialright.persistent.ProvincialrightVO;
import com.sunrise.boss.business.cms.way.persistent.WayListVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.delegate.common.CommonDelegate;

import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;
import com.sunrise.boss.ui.commons.User;

public class AddBusitocomBatchCheck extends BaseCheckFormat {

	public AddBusitocomBatchCheck() {
		super();
	}

	private static Date getDefaultDate(int i) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, i);
		return c.getTime();
	}

	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		if (!file.getContentType().equals("text/plain")) {
			throw new Exception("Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		}
	}

	/**
	 * �ļ��е����ݼ��
	 */
	public void checkLine(String line, int rowCount, User user)
			throws Exception {

		if (rowCount > 10000) {
			throw new Exception("�ļ��������ܳ���10000��");
		}
		if (null == line || "".equals(line.trim())) {
			return;
		}

		String[] items = line.split("\\|");
		WayDelegate waydelegate = new WayDelegate();
		WayListVO waylistvo = new WayListVO();
		DataPackage dp;
		
		// �������
		if (items.length != 5) {
			throw new Exception("�ϴ�������������,ӦΪ5��,��鿴˵������!");
		}
		
		//��Ʒ��ʶ
		if (StringUtils.isEmpty(items[0])) {
			throw new BusinessException("", "��1�С���Ʒ��ʶ������Ϊ��!");
		}
		
		if (items[0].length()>18){
			throw new BusinessException("", "��1�С���Ʒ��ʶ�����Ȳ��ܳ���18λ!");
		}
		
		if (!NumberUtils.isNumber(items[0])) {
			throw new BusinessException("", "��1�С���Ʒ��ʶ������Ϊ����");
		}
		
		//ҵ�����
		if (StringUtils.isEmpty(items[1])) {
			throw new BusinessException("", "��2�С�ҵ����롿����Ϊ��!");
		}
		
		if (items[1].length()>18){
			throw new BusinessException("", "��2�С�ҵ����롿���Ȳ��ܳ���18λ!");
		}
		
		if (!NumberUtils.isNumber(items[1])) {
			throw new BusinessException("", "��2�С�ҵ����롿����Ϊ����");
		}
		
		if(items[1].trim().substring(0, 4).equals("0403")){
			ProvincialrightVO rightvo = new ProvincialrightVO();
			rightvo.setProopr(user.getOpercode());
			rightvo.setRightid("CH_PW_TERMINALSELL");
			CommonDelegate delegate = new CommonDelegate(ProvincialrightVO.class);
			rightvo = (ProvincialrightVO) delegate.doFindByPk(rightvo, user);
			if (rightvo == null) {
				throw new BusinessException("","��2�С�ҵ����롿��ǰ���Ų��ܵ���[0403]��ͷ��ҵ��!");
			}
		}
		
		//ҵ�������ʼ�۸�(Ԫ)
		if (StringUtils.isEmpty(items[2])) {
			throw new BusinessException("", "��3�С�ҵ�������ʼ�۸�(Ԫ)������Ϊ��!");
		}
		
		if (items[2].length()>14){
			throw new BusinessException("", "��3�С�ҵ�������ʼ�۸�(Ԫ)�����Ȳ��ܳ���18λ!");
		}
		
		if (!NumberUtils.isNumber(items[2])) {
			throw new BusinessException("", "��3�С�ҵ�������ʼ�۸�(Ԫ)������Ϊ����");
		}
		
		//ҵ���������۸�(Ԫ)
		if (StringUtils.isEmpty(items[3])) {
			throw new BusinessException("", "��4�С�ҵ���������۸�(Ԫ)������Ϊ��!");
		}
		
		if (items[3].length()>14){
			throw new BusinessException("", "��4�С�ҵ���������۸�(Ԫ)�����Ȳ��ܳ���18λ!");
		}
		
		if (!NumberUtils.isNumber(items[3])) {
			throw new BusinessException("", "��4�С�ҵ���������۸�(Ԫ)������Ϊ����");
		}
		
		//ҵ�������
		if (StringUtils.isEmpty(items[4])) {
			throw new BusinessException("", "��5�С�ҵ������롿����Ϊ��!");
		}
		
		if (items[4].length()>32){
			throw new BusinessException("", "��5�С�ҵ������롿���Ȳ��ܳ���32λ!");
		}
		
		if (items[4].equals("MOBILE") || items[4].equals("TDNOTEBOOK")
				|| items[4].equals("TDDATACARD") || items[4].equals("HOMEGW")||items[4].equals("WIRESSPHONE")) {

		} else {
			throw new Exception("��5�С�ҵ������롿��ʽ����ȷ!��鿴����˵��");
		}
	}
	
	public static boolean checkDate(String date) {
		boolean ret = true;
		if (date.length() != 8)
			return false;
		try {
			SimpleDateFormat sd = new SimpleDateFormat("yyyyMMdd");
			sd.parse(date);
		} catch (Exception e) {
			return false;
		}
		return ret;
	}

	public static void main(String[] args) {

		AddBusitocomBatchCheck check = new AddBusitocomBatchCheck();

	}

}
