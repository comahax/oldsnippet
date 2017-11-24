package com.sunrise.boss.ui.cms.zjty.zjtyrewarddetail.upload;

import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.business.cms.way.persistent.WayListVO;
import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.business.cms.zjty.zjtyoperation.persistent.ZjtyOperationListVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.delegate.cms.zjty.zjtyoperation.ZjtyOperationDelegate;

import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;
import com.sunrise.boss.ui.commons.User;

public class AddZjtyRewarddetailCheck extends BaseCheckFormat {

	public AddZjtyRewarddetailCheck() {
		super();
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
		// �������
		if (items.length != 15) {
			throw new Exception("�ϴ�������������,ӦΪ15��,��鿴˵������!");
		}

		if (!doCheckLong(items[0]) || items[0].length() > 14) {
			throw new BusinessException("", "��1��[ҵ����ˮ]����Ϊ�����ҳ��Ȳ��ܴ���14");
		}
//		if (StringUtils.isEmpty(items[1])) {
//			throw new BusinessException("", "��2��[ҵ�����]����Ϊ��");
//		}
		
		if (items[5].trim().equals("89")){
			if (items[1].trim().equals("6401010100001")||items[1].trim().equals("6401010100002")||items[1].trim().equals("6401010100003")){
			}else{
				throw new BusinessException("", "�ϴ�ʧ�ܣ���ҵ��[" + items[1] + "]�����ڡ������նˡ��������!");
			}
		}else if(items[5].trim().equals("90")){
			if (items[1].trim().equals("6501010200003")||items[1].trim().equals("6501010500001")||items[1].trim().equals("6501010500003")){
			}else{
				throw new BusinessException("", "�ϴ�ʧ�ܣ���ҵ��[" + items[1]
				                                					+ "]�����ڡ�G3�ͼ�ͥ�г���Ʒ���ۡ��������!");
			}
		}
		
//		ZjtyOperationDelegate opndelegate = new ZjtyOperationDelegate();
//		DataPackage dp;
//		ZjtyOperationListVO listVO = new ZjtyOperationListVO();
//		listVO.set_se_opnid(items[1]);
//		dp = opndelegate.doQuery(listVO, user);
//		if (dp.getDatas().size() < 1) {
//			throw new BusinessException("", "�ϴ�ʧ�ܣ���ҵ��[" + items[1]
//					+ "]δ�ϼܣ����Ƚ���ҵ���ϼܲ���!");
//		}

		// ��������
		if (StringUtils.isEmpty(items[2])) {
			throw new BusinessException("", "��3��[��������]����Ϊ��");
		}
		WayVO wayvo = waydelegate.doFindByPk(items[2], user);
		if (wayvo == null) {
			throw new BusinessException("", "��3��[��������]������");
		}
		
		WayListVO waylistvo = new WayListVO();
		WayDelegate wayDelegate = new WayDelegate();
		DataPackage dp1;
		waylistvo.set_se_wayid(items[2]);
		waylistvo.set_se_waytype("AG");
		waylistvo.set_se_waysubtype("ZJTY");
		dp1 = wayDelegate.doQuery(waylistvo, user);
		if (dp1.getDatas().size()<=0){
			throw new BusinessException("", "�ϴ�ʧ��,��3��["+items[2]+"]�����Խ���Ӫ����!");
		}
		// �������
		if (items[5].trim().equals("89") || items[5].trim().equals("90")) {
			
		} else {
			throw new Exception("��6��[�������]���ԣ�ֻ��Ϊ89-�������նˡ���90-��G3�ͼ�ͥ�г���Ʒ���ۡ�����֮һ");
		}
		// ����׼
		if (!NumberUtils.isNumber(items[6])) {
			throw new BusinessException("", "��7��[����׼]����Ϊ����");
		}

//		try {
//			if (!(checkAmtFormat(items[6], 12)))
//				throw new Exception("��7��[����׼]��ʽ����(" + items[14]
//						+ "),�����������12λ������С��������һ����2λ!");
//		} catch (Exception e) {
//			throw new Exception("��7��[����׼]��ʽ����(" + items[6]
//					+ "),�����������12λ������С��������һ����2λ!");
//		}

		// �Ƴ귽ʽ
		
			
		if (!NumberUtils.isNumber(items[7])) {
			throw new BusinessException("", "��8��[�Ƴ귽ʽ]����Ϊ����");
		}
		if (items[7].trim().equals("1") || items[7].trim().equals("2")) {
			
		}else{
			throw new Exception("��8��[�Ƴ귽ʽ]���ԣ�ֻ��Ϊ1,2����֮һ");
		}
		if (StringUtils.isEmpty(items[7])) {
			throw new BusinessException("", "��8��[�Ƴ귽ʽ]����Ϊ��");
		}
		// ������ϵ��
		if (items[8].trim().equals("")){
			
		}else if (!NumberUtils.isNumber(items[8])) {
			throw new BusinessException("", "��9��[������ϵ��]����Ϊ����");
		}else if (Double.parseDouble(items[8]) <= 1.2
				&& Double.parseDouble(items[8]) >= 0) {
		}else{
			throw new BusinessException("", "��9��[������ϵ��]����Ϊ0��1.2");
		}
		
		if (items[8].substring(items[8].indexOf('.') + 1).length() > 2) {
			throw new BusinessException("", "������ϵ��������Χ,ֻ֧�ֵ�С�������λ");
		}
		
		// �ۺ�����ϵ��
		if (items[9].trim().equals("")){
			
		}else if (!NumberUtils.isNumber(items[9])) {
			throw new BusinessException("", "��10��[�ۺ�����ϵ��]����Ϊ����");
		}else if (Double.parseDouble(items[9]) <= 1.3
				&& Double.parseDouble(items[9]) >= 1) {
		}else{
			throw new BusinessException("", "��10��[�ۺ�����ϵ��]����Ϊ1��1.3");
		}
		
		if (items[9].substring(items[9].indexOf('.') + 1).length() > 2) {
			throw new BusinessException("", "�ۺ�����ϵ��������Χ,ֻ֧�ֵ�С�������λ");
		}
		// ���ϵ��
		if (items[10].trim().equals("")){
		}else if (!NumberUtils.isNumber(items[10])) {
			throw new BusinessException("", "��11��[���ϵ��]����Ϊ����");
		}else if (Double.parseDouble(items[10]) == 1
				|| Double.parseDouble(items[10]) == 0) {
		}else{
			throw new BusinessException("", "��11��[���ϵ��]����Ϊ0��1");
		}
		//����ϵ��
		if((items[11].trim().equals(""))){
			
		}else if (!NumberUtils.isNumber(items[11])) {
			throw new BusinessException("", "��12��[����ϵ��]����Ϊ����");
		}else if (Double.parseDouble(items[11]) <= 1
				&& Double.parseDouble(items[11]) >= 0.5) {
		}else{
			throw new BusinessException("", "��12��[����ϵ��]����Ϊ0.5-1");
		}
		
		if (items[11].substring(items[11].indexOf('.') + 1).length() > 2) {
			throw new BusinessException("", "����ϵ��������Χ,ֻ֧�ֵ�С�������λ");
		}

		// �����·�
		SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
		if (StringUtils.isEmpty(items[12]) || items[12].length() != 6) {
			throw new BusinessException("", "��13��[������]����Ϊ���ҳ��ȱ���Ϊ6λ");
		}
		try {
			format.parse(items[12]);
		} catch (Exception e) {
			throw new BusinessException("", "��13��[������]��ʽ����ȷ����ȷ�ĸ�ʽӦ��ΪYYYYMM");
		}

		// ���[�Ƴ���]�Ƿ�Ϊ�Ϸ�
		if (items[13].trim().equals("")){
			
		}else if (!NumberUtils.isNumber(items[13])) {
			throw new BusinessException("", "��14��[�Ƴ���]����Ϊ����");
		}
		try {
			if (!(checkAmtFormat(items[13], 12)))
				throw new Exception("��14��[�Ƴ���]��ʽ����(" + items[13]
						+ "),�����������12λ������С��������һ����2λ!");
		} catch (Exception e) {
			throw new Exception("��14��[�Ƴ���]��ʽ����(" + items[13]
					+ "),�����������12λ������С��������һ����2λ!");
		}

		// ���[Ӧ�����]�Ƿ�Ϊ�Ϸ�
		if (StringUtils.isEmpty(items[14]) || !NumberUtils.isNumber(items[14])) {
			throw new BusinessException("", "��15��[Ӧ�����]����Ϊ�ղ��ұ���Ϊ����");
		}
		try {
			if (!(checkAmtFormat(items[14], 12)))
				throw new Exception("��15��[Ӧ�����]��ʽ����(" + items[14]
						+ "),�����������12λ������С��������һ����2λ!");
		} catch (Exception e) {
			throw new Exception("��15��[Ӧ�����]��ʽ����(" + items[14]
					+ "),�����������12λ������С��������һ����2λ!");
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

	public boolean doCheckLong(String number) {
		try {
			Long.parseLong(number);
		} catch (NumberFormatException exception) {
			return false;
		}
		return true;
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

	public static void main(String[] args) {

		AddZjtyRewarddetailCheck check = new AddZjtyRewarddetailCheck();

	}

}
