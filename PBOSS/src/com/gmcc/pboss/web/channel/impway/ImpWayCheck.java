package com.gmcc.pboss.web.channel.impway;

import java.io.File;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.base.dictitem.DictitemVO;
import com.gmcc.pboss.business.channel.cntycompany.CntycompanyVO;
import com.gmcc.pboss.business.channel.way.WayDBParam;
import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.gmcc.pboss.control.base.dictitem.Dictitem;
import com.gmcc.pboss.control.base.dictitem.DictitemBO;
import com.gmcc.pboss.control.channel.cntycompany.Cntycompany;
import com.gmcc.pboss.control.channel.cntycompany.CntycompanyBO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.sunrise.jop.common.utils.lang.Code2NameUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;

public class ImpWayCheck extends BaseCheckFormat {
	private User user;
	@Override
	public void checkFile(File file, HashMap parameterMap, String contentType)
			throws Exception {
		user = (User) parameterMap.get("user");
		if (!"text/plain".equalsIgnoreCase(contentType)) {
			throw new Exception("Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		}
	}

	@Override
	public void checkLine(String line, int rowCount, User user) throws Exception {
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		if (content.length != 25) {
			throw new Exception("�ϴ���������ȷ��ӦΪ24��!");
		}
		if(StringUtils.isBlank(content[0]) || content[0].length() > 18) {
			throw new Exception("�������벻��Ϊ���ҳ��Ȳ��ܴ���18");
		}
		if (StringUtils.isBlank(content[1]) || content[1].getBytes("GBK").length >256) {
			throw new Exception("�������Ʋ���Ϊ���ҳ��Ȳ��ܴ���256");
		}
		if (StringUtils.isBlank(content[2]) || content[2].length() > 18) {
			throw new Exception("�ϼ��������벻��Ϊ���ҳ��Ȳ��ܴ���18");
		}
//		if (StringUtils.isBlank(content[5]) || content[5].length() > 14) {
//			throw new Exception("���й�˾���벻��Ϊ���ҳ��Ȳ��ܴ���14");
//		}
		if (!checkCity(content[5])) {
			throw new Exception("[���й�˾]��ʽ����,����Ϊ�ջ����14λ������ϵͳһ��");
		}
		if (!checkCounty(content[6], content[5])) {
			throw new Exception("[�ֹ�˾]��ʽ����,���ܴ���14λ������" + content[5]
					+ "������ֹ�˾");
		}
//		if (StringUtils.isBlank(content[6]) || content[6].length() > 14) {
//			throw new Exception("�ֹ�˾���벻��Ϊ�ճ��Ȳ��ܴ���14");
//		}
		if (StringUtils.isBlank(content[11])) {
			throw new Exception("�������ͱ��벻��Ϊ��");
		}
		if (StringUtils.isBlank(content[15]) || !doCheckLatitude(content[15].trim())) {
			throw new Exception("����γ�Ȳ���Ϊ���ұ���ΪС���̶�����Ϊ6������,���ҷ�Χ��18-26");
		}
		if (StringUtils.isBlank(content[16]) || !doCheckLongtitude(content[16].trim())) {
			throw new Exception("�����Ȳ���Ϊ���ұ���ΪС���̶�����Ϊ6������,���ҷ�Χ��100-130");
		}
		if (StringUtils.isBlank(content[17])) {
			throw new Exception("��Ӫģʽ����Ϊ��");
		}
		if (StringUtils.isBlank(content[20])) {
			throw new Exception("��ҵ��Դ���಻��Ϊ��");
		}
		
		// �ж����������ʽ
		String path = "^[a-zA-Z][a-zA-z0-9-]{0,18}$";
		Pattern pattern = Pattern.compile(path);
		Matcher matcher = pattern.matcher(content[0]);
		if (!matcher.find()) {
			throw new Exception("�������벻���Ϲ���Ӧ������ĸ��ͷ��ֻ������ĸ������");
		}
		if (content[2].trim().equals(content[0].trim())) {
			throw new Exception("�ϼ����벻��ͬ��������һ��");
		} 
		if (StringUtils.isNotBlank(content[3]) && !content[3].trim().equals("IMP")) {
			throw new Exception("�˲˵�ֻ�������������");
		}
		
		if (StringUtils.isNotBlank(content[7])
				&& Code2NameUtils.code2Name("#SERVCENT", content[7].trim(),
						user.getCityid()).equals(content[7].trim())) {
			throw new Exception("�����������ġ�" + content[7] + "�����������ݣ����ʵ");
		}
		if (StringUtils.isNotBlank(content[8])
				&& Code2NameUtils.code2Name("#MICROAREA", content[8].trim(),
						user.getCityid()).equals(content[8].trim())) {
			throw new Exception("΢����" + content[8] + "�����������ݣ����ʵ");
		}
		if (StringUtils.isNotBlank(content[13])
				&& Code2NameUtils.code2Name("#CH_ADIMAREA", content[13].trim(),
						user.getCityid()).equals(content[13].trim())) {
			throw new Exception("�����������롾" + content[13] + "�����������ݣ����ʵ");
		}
		
		Dictitem dictitem = (Dictitem) BOFactory.build(DictitemBO.class, user);
		DictitemVO vo = new DictitemVO();
		if (StringUtils.isNotBlank(content[9])) {
			vo.setGroupid("CH_STARLEVEL");
			vo.setDictid(content[9]);
			if (dictitem.doFindByPk(vo) == null) {
				throw new Exception("�Ǽ���" + content[9] + "���̶�����ֵ���������ݣ����ʵ");
			}
		}
		
		if (StringUtils.isNotBlank(content[10])) {
			vo.setGroupid("CH_BUZTYPE");
			vo.setDictid(content[10]);
			if (dictitem.doFindByPk(vo) == null) {
				throw new Exception("��Ȧ���ͱ��롾" + content[10] + "���̶�����ֵ���������ݣ����ʵ");
			}
		}
		if (StringUtils.isNotBlank(content[11])) {
			vo.setGroupid("CH_ADTYPE");
			vo.setDictid(content[11]);
			if (dictitem.doFindByPk(vo) == null) {
				throw new Exception("�������ͱ��롾" + content[11] + "���̶�����ֵ���������ݣ����ʵ");
			}
		}
		if (StringUtils.isNotBlank(content[17])) {
			vo.setGroupid("CH_RUNMODE");
			vo.setDictid(content[17]);
			if (dictitem.doFindByPk(vo) == null) {
				throw new Exception("��Ӫģʽ��" + content[17] + "���̶�����ֵ���������ݣ����ʵ");
			}
		}
		if (StringUtils.isNotBlank(content[18])) {
			vo.setGroupid("CH_ISCONNECTED");
			vo.setDictid(content[18]);
			if (dictitem.doFindByPk(vo) == null) {
				throw new Exception("�Ƿ�������" + content[18] + "���̶�����ֵ���������ݣ����ʵ");
			}
		}
		if (StringUtils.isNotBlank(content[19])) {
			vo.setGroupid("CH_CONNECTTYPE");
			vo.setDictid(content[19]);
			if (dictitem.doFindByPk(vo) == null) {
				throw new Exception("������ʽ��" + content[19] + "���̶�����ֵ���������ݣ����ʵ");
			}
		}
		if (StringUtils.isNotBlank(content[20])) {
			vo.setGroupid("CH_PRTSOURCE");
			vo.setDictid(content[20]);
			if (dictitem.doFindByPk(vo) == null) {
				throw new Exception("��ҵ��Դ���ࡾ" + content[20] + "���̶�����ֵ���������ݣ����ʵ");
			}
		}
		if (StringUtils.isNotBlank(content[21])) {
			vo.setGroupid("CH_DSTISKEYSTEP");
			vo.setDictid(content[21]);
			if (dictitem.doFindByPk(vo) == null) {
				throw new Exception("�Ƿ�����������" + content[21] + "���̶�����ֵ���������ݣ����ʵ");
			}
		}
		if (StringUtils.isNotBlank(content[23])) {
			vo.setGroupid("CH_DSTISKEYSTEP");
			vo.setDictid(content[23]);
			if (dictitem.doFindByPk(vo) == null) {
				throw new Exception("�Ƿ���" + content[23] + "���̶�����ֵ���������ݣ����ʵ");
			}
		}
		// �ж��Ƿ������ͬ�ľ���γ��
		Way way = (Way) BOFactory.build(WayBO.class, user);
		WayDBParam params = new WayDBParam();
		params.set_se_longtitude(content[16].trim());
		params.set_se_latitude(content[15].trim());
		DataPackage dp = way.doQueryWayByParams(params);
		if (dp != null && dp.getDatas() != null && dp.getDatas().size() > 0) {
			throw new Exception("������ͬ����γ�ȵ����ȣ����ʵ");
		}
		
		if (StringUtils.isNotBlank(content[22])) {
			params = new WayDBParam();
			params.set_se_wayid(content[22].trim());
			params.set_se_waytype("AG");
			params.set_se_waysubtype("DIS");
			params.set_ne_waystate("1");
			dp = way.doQueryWayByParams(params);
			if (dp.getDatas() == null || dp.getDatas().size() == 0) {
				throw new Exception("���������̱��롾" + content[22].trim() + "�������ڣ����ʵ");
			}
		}
	}
	
	/*
	 * �жϵ���γ��
	 * @param decimal ���жϵ�ֵ
	 */
	public static boolean doCheckLatitude(String dicimal) throws Exception {
		try {
			if (dicimal.indexOf(".") == -1) {
				return false;
			} else {
				if (dicimal.substring(dicimal.indexOf(".") + 1,
						dicimal.length()).length() != 6)
					return false;
			}
			BigDecimal temp = new BigDecimal(dicimal);
			if (temp.doubleValue() < 18 || temp.doubleValue() > 26) {
				return false;
			}
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
	
	/*
	 * �жϵ�����
	 * @param decimal ���жϵ�ֵ
	 */
	public static boolean doCheckLongtitude(String dicimal) throws Exception {
		try {
			if (dicimal.indexOf(".") == -1) {
				return false;
			} else {
				if (dicimal.substring(dicimal.indexOf(".") + 1,
						dicimal.length()).length() != 6)
					return false;
			}
			BigDecimal temp = new BigDecimal(dicimal);
			if (temp.doubleValue() < 100 || temp.doubleValue() > 130) {
				return false;
			}
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
	/**
	 * ������й�˾���ϼ������ĵ��й�˾��������������
	 * 
	 * @param cityid
	 * @return
	 */
	private boolean checkCity(String cityid) {
		boolean result = true;
		try {
			if (!cityid.equals(user.getCityid())
					|| cityid.getBytes("GBK").length > 14) {
				result = false;
			}
		} catch (Exception e) {
			result = false;
		}
		return result;
	}
	/**
	 * ���ͬϵͳ�����Ƿ�һ�£��Ƿ���ĳ���й�˾����ֹ�˾����������ܾ�����
	 * 
	 * @param countyid
	 * @return
	 * @throws Exception
	 */
	private boolean checkCounty(String countyid, String cityid)
			throws Exception {
		boolean result = true;

		if (countyid.getBytes("GBK").length > 14) {
			return false;
		}
		Cntycompany delegate = (Cntycompany) BOFactory.build(
				CntycompanyBO.class, user);
		CntycompanyVO cntycompanyVO = delegate.doFindByPk(countyid);
		if (cntycompanyVO == null
				|| !(user.getCityid()).equals(cntycompanyVO.getCitycompid())) {
			result = false;
		}
		return result;
	}
}
