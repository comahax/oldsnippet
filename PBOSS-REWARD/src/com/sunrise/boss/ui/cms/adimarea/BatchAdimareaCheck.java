package com.sunrise.boss.ui.cms.adimarea;

import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.delegate.cms.adimarea.AdimareaDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;
import com.sunrise.pub.tools.StringSplit;

public class BatchAdimareaCheck extends BaseCheckFormat {
	public BatchAdimareaCheck() {
		super();
	}

	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		if (!file.getContentType().equals("text/plain")) {
			throw new Exception("Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		}
	}

	public void checkLine(String line, int rowCount, User user)
			throws Exception {
		if (rowCount > 10000) {
			throw new Exception("�ļ��������ܳ���10000��");
		}
		if (null == line || "".equals(line)) {
			return;
		}
		// String[] items = line.split("\\|");
		String[] items = StringUtils.splitPreserveAllTokens(line, "|");
		// �������
		if (items.length != 15) {
			throw new Exception("�ϴ�������������,ӦΪ15��,��鿴˵������!");
		}
		AdimareaDelegate delegate = new AdimareaDelegate();
		if (items[0] == null || "".equals(items[0].trim())
				|| items[0].length() > 18)
			throw new Exception("[������������]����Ϊ�գ�Ҳ���ܴ���18λ!");
		if (delegate.doFindByPk(items[0], user) == null) {// ����
			if (items[1].length() > 64)
				throw new Exception("[������������]���������벻����32����");
			if (!"null".equals(items[2]) && !"��".equals(items[2])
					&& !"".equals(items[2].trim())) {
				try { // ���items[2]�Ƿ�Ϊ����
					Double temp = Double.valueOf(items[2]);
				} catch (Exception e) {
					e.printStackTrace();
					throw new Exception("[�����������ͱ���]���Ͳ���(" + items[2]
							+ "),Ӧ���������ַ���!");
				}
				if (items[2].getBytes().length > 2)
					throw new Exception("[�����������ͱ���]���������벻����2λ");
			}
			if (!"null".equals(items[3]) && !"��".equals(items[3])
					&& !"".equals(items[3].trim())) {
				try { // ���items[3]�Ƿ�Ϊ����
					Double temp = Double.valueOf(items[3]);
				} catch (Exception e) {
					e.printStackTrace();
					throw new Exception("[���������������]���Ͳ���(" + items[3]
							+ "),Ӧ���������ַ���!");
				}
				if (items[3].getBytes().length > 2)
					throw new Exception("[���������������]���������벻����2λ");
			}
			if (items[4].length() > 18)
				throw new Exception("[�ϼ�������������]���������벻����18λ");
			if (!"null".equals(items[5]) && !"��".equals(items[5])
					&& !"".equals(items[5].trim())) {
				try { // ���items[5]�Ƿ�Ϊ����
					Double temp = Double.valueOf(items[5]);
				} catch (Exception e) {
					e.printStackTrace();
					throw new Exception("[����ͳ�����]���Ͳ���(" + items[5]
							+ "),Ӧ���������ַ���!");
				}
				if (items[5].getBytes().length > 4)
					throw new Exception("[����ͳ�����]���������벻����4λ");
			}
			if (!"null".equals(items[6]) && !"��".equals(items[6])
					&& !"".equals(items[6].trim())) { 
			try { // ���items[6]�Ƿ�Ϊ����
				Double temp = Double.valueOf(items[6]);
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("[Ͻ���˿���]���Ͳ���(" + items[6] + "),Ӧ���������ַ���!");
			}
			if (items[6].getBytes().length > 10)
				throw new Exception("[Ͻ���˿���]���������벻����10λ");
			}
			
			if (!"null".equals(items[7]) && !"��".equals(items[7])
					&& !"".equals(items[7].trim())) {
				try { // ���items[7]�Ƿ�Ϊ����
					Double temp = Double.valueOf(items[7]);
				} catch (Exception e) {
					e.printStackTrace();
					throw new Exception("[��ס�˿���]���Ͳ���(" + items[7]
							+ "),Ӧ���������ַ���!");
				}
				if (items[7].getBytes().length > 10)
					throw new Exception("[��ס�˿���]���������벻����10λ");
			}
			if (!"null".equals(items[8]) && !"��".equals(items[8])
					&& !"".equals(items[8].trim())) {
				try { // ���items[8]�Ƿ�Ϊ����
					Double temp = Double.valueOf(items[8]);
				} catch (Exception e) {
					e.printStackTrace();
					throw new Exception("[�����˿���]���Ͳ���(" + items[8]
							+ "),Ӧ���������ַ���!");
				}
				if (items[8].getBytes().length > 10)
					throw new Exception("[�����˿���]���������벻����10λ");
			}
			if (!"null".equals(items[9]) && !"��".equals(items[9])
					&& !"".equals(items[9].trim())) { 
			try { // ���items[9]�Ƿ�Ϊ����
				Double temp = Double.valueOf(items[9]);
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("[Ͻ�����]���Ͳ���(" + items[9] + "),Ӧ���������ַ���!");
			}
			if (items[9].getBytes().length > 16)
				throw new Exception("[Ͻ�����]���������벻����16λ");
			}
			
			if (!"null".equals(items[10]) && !"��".equals(items[10])
					&& !"".equals(items[10].trim())) {
			try { // ���items[10]�Ƿ�Ϊ����
				Double temp = Double.valueOf(items[10]);
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("[Ͻ���˾���֧������]���Ͳ���(" + items[10]
						+ "),Ӧ���������ַ���!");
			}
			if (items[10].getBytes().length > 10)
				throw new Exception("[Ͻ���˾���֧������]���������벻����10λ");
			}
			
			if (!"null".equals(items[11]) && !"��".equals(items[11])
					&& !"".equals(items[11].trim())) {
			try { // ���items[11]�Ƿ�Ϊ����
				Double temp = Double.valueOf(items[11]);
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("[Ͻ���ƶ��û���]���Ͳ���(" + items[11]
						+ "),Ӧ���������ַ���!");
			}
			if (items[11].getBytes().length > 10)
				throw new Exception("[Ͻ���ƶ��û���]���������벻����10λ");
			}
			
			if (!"null".equals(items[12]) && !"��".equals(items[12])
					&& !"".equals(items[12].trim())) {
				try { // ���items[12]�Ƿ�Ϊ����
					Double temp = Double.valueOf(items[12]);
				} catch (Exception e) {
					e.printStackTrace();
					throw new Exception("[Ͻ����ͨ�û���]���Ͳ���(" + items[12]
							+ "),Ӧ���������ַ���!");
				}
				if (items[12].getBytes().length > 10)
					throw new Exception("[Ͻ����ͨ�û���]���������벻����10λ");
			}
			if (!"null".equals(items[13]) && !"��".equals(items[13])
					&& !"".equals(items[13].trim())) {
				try { // ���items[13]�Ƿ�Ϊ����
					Double temp = Double.valueOf(items[13]);
				} catch (Exception e) {
					e.printStackTrace();
					throw new Exception("[Ͻ�������û���]���Ͳ���(" + items[13]
							+ "),Ӧ���������ַ���!");
				}
				if (items[13].getBytes().length > 10)
					throw new Exception("[Ͻ�������û���]���������벻����10λ");
			}
			if (!"null".equals(items[14]) && !"��".equals(items[14])
					&& !"".equals(items[14].trim())) {
				try { // ���items[14]�Ƿ�Ϊ����
					Double temp = Double.valueOf(items[14]);
				} catch (Exception e) {
					e.printStackTrace();
					throw new Exception("[Ͻ���ƶ��绰�û���]���Ͳ���(" + items[14]
							+ "),Ӧ���������ַ���!");
				}
				if (items[14].getBytes().length > 10)
					throw new Exception("[Ͻ���ƶ��绰�û���]���������벻����10λ");
			}
		} else {// �޸�
			if (!"null".equals(items[1]) && !"��".equals(items[1])
					&& !"".equals(items[1].trim())) {
				if (items[1].length() > 64)
					throw new Exception("[������������]���������벻����32����");
			}
			if (!"null".equals(items[2]) && !"��".equals(items[2])
					&& !"".equals(items[2].trim())) {
				try { // ���items[2]�Ƿ�Ϊ����
					Double temp = Double.valueOf(items[2]);
				} catch (Exception e) {
					e.printStackTrace();
					throw new Exception("[�����������ͱ���]���Ͳ���(" + items[2]
							+ "),Ӧ���������ַ���!");
				}
				if (items[2].getBytes().length > 2)
					throw new Exception("[�����������ͱ���]���������벻����2λ");
			}
			if (!"null".equals(items[3]) && !"��".equals(items[3])
					&& !"".equals(items[3].trim())) {
				try { // ���items[3]�Ƿ�Ϊ����
					Double temp = Double.valueOf(items[3]);
				} catch (Exception e) {
					e.printStackTrace();
					throw new Exception("[���������������]���Ͳ���(" + items[3]
							+ "),Ӧ���������ַ���!");
				}
				if (items[3].getBytes().length > 2)
					throw new Exception("[���������������]���������벻����2λ");
			}
			if (!"null".equals(items[4]) && !"��".equals(items[4])
					&& !"".equals(items[4].trim())) {
				if (items[4].length() > 18)
					throw new Exception("[�ϼ�������������]���������벻����18λ");
			}
			if (!"null".equals(items[5]) && !"��".equals(items[5])
					&& !"".equals(items[5].trim())) {
				try { // ���items[5]�Ƿ�Ϊ����
					Double temp = Double.valueOf(items[5]);
				} catch (Exception e) {
					e.printStackTrace();
					throw new Exception("[����ͳ�����]���Ͳ���(" + items[5]
							+ "),Ӧ���������ַ���!");
				}
				if (items[5].getBytes().length > 4)
					throw new Exception("[����ͳ�����]���������벻����4λ");
			}
			if (!"null".equals(items[6]) && !"��".equals(items[6])
					&& !"".equals(items[6].trim())) {
				try { // ���items[6]�Ƿ�Ϊ����
					Double temp = Double.valueOf(items[6]);
				} catch (Exception e) {
					e.printStackTrace();
					throw new Exception("[Ͻ���˿���]���Ͳ���(" + items[6]
							+ "),Ӧ���������ַ���!");
				}
				if (items[6].getBytes().length > 10)
					throw new Exception("[Ͻ���˿���]���������벻����10λ");
			}
			if (!"null".equals(items[7]) && !"��".equals(items[7])
					&& !"".equals(items[7].trim())) {
				try { // ���items[7]�Ƿ�Ϊ����
					Double temp = Double.valueOf(items[7]);
				} catch (Exception e) {
					e.printStackTrace();
					throw new Exception("[��ס�˿���]���Ͳ���(" + items[7]
							+ "),Ӧ���������ַ���!");
				}
				if (items[7].getBytes().length > 10)
					throw new Exception("[��ס�˿���]���������벻����10λ");
			}
			if (!"null".equals(items[8]) && !"��".equals(items[8])
					&& !"".equals(items[8].trim())) {
				try { // ���items[8]�Ƿ�Ϊ����
					Double temp = Double.valueOf(items[8]);
				} catch (Exception e) {
					e.printStackTrace();
					throw new Exception("[�����˿���]���Ͳ���(" + items[8]
							+ "),Ӧ���������ַ���!");
				}
				if (items[8].getBytes().length > 10)
					throw new Exception("[�����˿���]���������벻����10λ");
			}
			if (!"null".equals(items[9]) && !"��".equals(items[9])
					&& !"".equals(items[9].trim())) {
				try { // ���items[9]�Ƿ�Ϊ����
					Double temp = Double.valueOf(items[9]);
				} catch (Exception e) {
					e.printStackTrace();
					throw new Exception("[Ͻ�����]���Ͳ���(" + items[9]
							+ "),Ӧ���������ַ���!");
				}
				if (items[9].getBytes().length > 16)
					throw new Exception("[Ͻ�����]���������벻����16λ");
			}
			if (!"null".equals(items[10]) && !"��".equals(items[10])
					&& !"".equals(items[10].trim())) {
				try { // ���items[10]�Ƿ�Ϊ����
					Double temp = Double.valueOf(items[10]);
				} catch (Exception e) {
					e.printStackTrace();
					throw new Exception("[Ͻ���˾���֧������]���Ͳ���(" + items[10]
							+ "),Ӧ���������ַ���!");
				}
				if (items[10].getBytes().length > 10)
					throw new Exception("[Ͻ���˾���֧������]���������벻����10λ");
			}
			if (!"null".equals(items[11]) && !"��".equals(items[11])
					&& !"".equals(items[11].trim())) {
				try { // ���items[11]�Ƿ�Ϊ����
					Double temp = Double.valueOf(items[11]);
				} catch (Exception e) {
					e.printStackTrace();
					throw new Exception("[Ͻ���ƶ��û���]���Ͳ���(" + items[11]
							+ "),Ӧ���������ַ���!");
				}
				if (items[11].getBytes().length > 10)
					throw new Exception("[Ͻ���ƶ��û���]���������벻����10λ");
			}
			if (!"null".equals(items[12]) && !"��".equals(items[12])
					&& !"".equals(items[12].trim())) {
				try { // ���items[12]�Ƿ�Ϊ����
					Double temp = Double.valueOf(items[12]);
				} catch (Exception e) {
					e.printStackTrace();
					throw new Exception("[Ͻ����ͨ�û���]���Ͳ���(" + items[12]
							+ "),Ӧ���������ַ���!");
				}
				if (items[12].getBytes().length > 10)
					throw new Exception("[Ͻ����ͨ�û���]���������벻����10λ");
			}
			if (!"null".equals(items[13]) && !"��".equals(items[13])
					&& !"".equals(items[13].trim())) {
				try { // ���items[13]�Ƿ�Ϊ����
					Double temp = Double.valueOf(items[13]);
				} catch (Exception e) {
					e.printStackTrace();
					throw new Exception("[Ͻ�������û���]���Ͳ���(" + items[13]
							+ "),Ӧ���������ַ���!");
				}
				if (items[13].getBytes().length > 10)
					throw new Exception("[Ͻ�������û���]���������벻����10λ");
			}
			if (!"null".equals(items[14]) && !"��".equals(items[14])
					&& !"".equals(items[14].trim())) {
				try { // ���items[14]�Ƿ�Ϊ����
					Double temp = Double.valueOf(items[14]);
				} catch (Exception e) {
					e.printStackTrace();
					throw new Exception("[Ͻ���ƶ��绰�û���]���Ͳ���(" + items[14]
							+ "),Ӧ���������ַ���!");
				}
				if (items[14].getBytes().length > 10)
					throw new Exception("[Ͻ���ƶ��绰�û���]���������벻����10λ");
			}
		}
	}
}
