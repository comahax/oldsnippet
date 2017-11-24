package com.sunrise.boss.ui.cms.cardsalebusi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;

public class BatchCardsalebusiCheck extends BaseCheckFormat {

	private User user;

	public BatchCardsalebusiCheck() {
		super();
	}

	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		user = (User) parameterMap.get("user");
		if (!file.getContentType().equals("text/plain")) {
			throw new Exception("Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		}
	}

	/**
	 * ����0|Ʒ��1|�������ۼ�2|��ϼ۸�3|�����ۿ�4|����ʱ��5|��������6|ҵ�������Ϣ����7
	 */
	public void checkLine(String line, int rowCount) throws Exception {
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (rowCount > 10000) {
			throw new Exception("�ļ��������ܳ���10000��");
		}
		if (null == line || "".equals(line)) {
			return;
		}
		String[] fields = StringUtils.splitPreserveAllTokens(line, "|");
		// �������
		if (fields.length != 8) {
			throw new Exception("�ϴ�������������,ӦΪ8��,��鿴˵������!");
		}
		for (int i = 0; i < fields.length; i++) {
			switch (i) {
			case 0:
				if (fields[i].trim().equals("") || fields[i].trim().length() > 11 || !StringUtils.isNumeric(fields[0])) {
					throw new Exception("[����]����Ϊ�ջ��ߴ���11λ�ұ���������");
				}
				break;
			case 1:
				if (fields[i].trim().equals("")
						|| (!fields[i].matches("[0-9]")
						&& (new Integer(fields[i]).intValue() < 1 || new Integer(
								fields[i]).intValue() > 3))) {
					throw new Exception("[Ʒ��]����Ϊ���ұ���������1 2 3");
				}
				break;
			case 2:
				if (!fields[i].trim().equals("")
						&& !fields[i].matches("[0-9]{1,16}(.?)[0-9]{0,2}")) {
					throw new Exception("[�������ۼ�]��ʽ����,��ȷΪ�����λС����16λ����֮���Ҳ���Ϊ��");
				}
				break;
			case 3:
				if (!fields[i].trim().equals("")
						&& !fields[i].matches("[0-9]{1,16}(.?)[0-9]{0,2}")) {
					throw new Exception("[��ϼ۸�]��ʽ����,��ȷΪ�����λС����16λ����֮���Ҳ���Ϊ��");
				}
				break;
			case 4:
				if (!fields[i].trim().equals("")
						&& !fields[i].matches("[0-9]{1,16}(.?)[0-9]{0,2}")) {
					throw new Exception("[�����ۿ�]��ʽ����,��ȷΪ�����λС����16λ����֮���Ҳ���Ϊ��");
				}
				break;
			case 5:
				try {
					date.parse(fields[i]);
				} catch (ParseException pe) {
					throw new Exception("[����ʱ��]��ʽ����,ӦΪyyyy-MM-dd HH:mm:ss�Ҳ���Ϊ��");
				}
				break;
			case 6:
				if (fields[i].trim().equals("")
						|| fields[i].trim().length() > 18) {
					throw new Exception("[�������]���ܴ���18λ����Ϊ��");
				}
				break;
			case 7:
				if (fields[i].trim().equals("")
						|| fields[i].trim().length() > 18) {
					throw new Exception("[ҵ�������Ϣ����]���ܴ���18λ����Ϊ��");
				}
				break;

			default:
				break;
			}
		}
	}
}
