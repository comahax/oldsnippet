package com.gmcc.pboss.web.channel.saleway;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.base.dictitem.DictitemVO;
import com.gmcc.pboss.business.channel.busicircle.BusicircleVO;
import com.gmcc.pboss.business.channel.cntycompany.CntycompanyVO;
import com.gmcc.pboss.business.channel.microarea.MicroareaVO;
import com.gmcc.pboss.business.channel.servcent.ServcentVO;
import com.gmcc.pboss.business.channel.way.WayDAO;
import com.gmcc.pboss.business.channel.way.WayDBParam;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.channel.waybusicircle.WaybusicircleDBParam;
import com.gmcc.pboss.business.channel.waybusicircle.WaybusicircleVO;
import com.gmcc.pboss.business.channel.wayprovince.WayprovinceVO;
import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.gmcc.pboss.control.base.dictitem.Dictitem;
import com.gmcc.pboss.control.base.dictitem.DictitemBO;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.channel.busicircle.Busicircle;
import com.gmcc.pboss.control.channel.busicircle.BusicircleBO;
import com.gmcc.pboss.control.channel.cntycompany.Cntycompany;
import com.gmcc.pboss.control.channel.cntycompany.CntycompanyBO;
import com.gmcc.pboss.control.channel.microarea.Microarea;
import com.gmcc.pboss.control.channel.microarea.MicroareaBO;
import com.gmcc.pboss.control.channel.servcent.Servcent;
import com.gmcc.pboss.control.channel.servcent.ServcentBO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.channel.waybusicircle.Waybusicircle;
import com.gmcc.pboss.control.channel.waybusicircle.WaybusicircleBO;
import com.gmcc.pboss.control.channel.wayprovince.Wayprovince;
import com.gmcc.pboss.control.channel.wayprovince.WayprovinceBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;

public class SalewayCheck extends BaseCheckFormat {

	private User user;

	private boolean customeFlag = false;

	private long preLineCount = 0;

	private String resultStr = "";

	private Way delegate;

	private String param75 = "";

	public static String lineHead = "��������|��������|�����������|�ϼ���������|�Ǽ�|������|״̬|���й�˾|�ֹ�˾|"
			+ "������������|΢����|�Ƿ�ֱ��|��������|��������|ҵ̬����|Ӫҵ���|����������|"
			+ "������������|�ּ�|���������|ҵ��Ԥ����|��ϸ��ַ|����γ��|������|ҵ������|"
			+ "ҵ���绰|ҵ���̶��绰|ҵ����������|�ͻ���ַ|�ջ���ϵ��|�ջ���ϵ����|�ջ���֤������|ǩԼ����|"
			+ "��ͬ����|��ͬЭ������|ǩ���ͬʱ��|��ͬЭ����Чʱ��|��ͬ������|Ӫҵִ�ձ��|Ӫҵִ����Ч��|"
			+ "��֤����|��֤��Ѻ��״̬|��֤������|���֧����������|���֧�������˺�|���֧���ʺ�����|"
			+ "���������֤����|ǩԼ״̬|��֤�𽻸���ʽ|��Ӫ��Χ|ȫʡ����|���๺�����������ʺ�|"
			+ "���๺�������˺�����|���๺�����ۿ�������|�����̱���|�Ƿ����B2Mģʽ|�˺�����|���๺���������б�ʶ|���๺����������״̬|��������|����ע����|"
			+ "��Ҫҵ��֧�ŷ�ʽ|�Ƿ������г�ֵƽ̨|ȫ��ͳһ��������|����|������������|�Ƿ���������|ǰ̨Ӫҵ������O��|��Ӫ��ISP���뷽ʽ|�Ƿ����ȫԱ����ģʽ|�Ǽ��ֲ�|��Ȧ����|�Ƿ�TOP����|�����������|������Ȧ����|����������������|������������ϵ��|"
			+ "���õȼ�|˰������|�Ƿ���Ȩ����|";

	public static String lineHead1 = "��������|��������|�����������|�ϼ���������|�Ǽ�|������|״̬|���й�˾|�ֹ�˾|"
			+ "������������|΢����|�Ƿ�ֱ��|��������|��������|ҵ̬����|Ӫҵ���|����������|"
			+ "������������|�ּ�|���������|ҵ��Ԥ����|��ϸ��ַ|����γ��|������|ҵ������|"
			+ "ҵ���绰|ҵ���̶��绰|ҵ����������|�ͻ���ַ|�ջ���ϵ��|�ջ���ϵ����|�ջ���֤������|ǩԼ����|"
			+ "��ͬ����|��ͬЭ������|ǩ���ͬʱ��|��ͬЭ����Чʱ��|��ͬ������|Ӫҵִ�ձ��|Ӫҵִ����Ч��|"
			+ "��֤����|��֤��Ѻ��״̬|��֤������|���֧����������|���֧�������˺�|���֧���ʺ�����|"
			+ "���������֤����|ǩԼ״̬|��֤�𽻸���ʽ|��Ӫ��Χ|ȫʡ����|���๺�����������ʺ�|"
			+ "���๺�������˺�����|���๺�����ۿ�������|�����̱���|�Ƿ����B2Mģʽ|�˺�����|���๺���������б�ʶ|���๺����������״̬|��������|����ע����|"
			+ "��Ҫҵ��֧�ŷ�ʽ|�Ƿ������г�ֵƽ̨|ȫ��ͳһ��������|����|������������|�Ƿ���������|ǰ̨Ӫҵ������O��|��Ӫ��ISP���뷽ʽ|�Ƿ����ȫԱ����ģʽ|�Ǽ��ֲ�|��Ȧ����|�Ƿ�TOP����|�����������|������Ȧ����|����������������|������������ϵ��|"
			+ "���õȼ�|˰������|�Ƿ���Ȩ����|��ע|";

	public static String[] lineArr = StringUtils.splitPreserveAllTokens(
			lineHead, "|");

	// ��������Ϊ0 ����-1
	public static String[] lineArr1 = StringUtils.splitPreserveAllTokens(
			lineHead1, "|");

	public SalewayCheck() {
		// TODO Auto-generated constructor stub
	}

	public void checkFile(File file, HashMap parameterMap, String contentType)
			throws Exception {
		user = (User) parameterMap.get("user");
		if (!"text/plain".equalsIgnoreCase(contentType)) {
			throw new Exception("Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		}
	}

	/**
	 * ��������0|��������1|�����������2|�ϼ���������3|�Ǽ�4|������5|״̬6|���й�˾7|�ֹ�˾8|������������9|
	 * ΢����10|�Ƿ�ֱ��12|��������13|��������14|ҵ̬����15|��ҵʱ��16|Ӫҵ���17|����������18|������������19|
	 * �ּ�20|��ֻ�����21|ҵ��Ԥ����22|��ϸ��ַ23|����γ��24|������25|ҵ������26|ҵ���绰27|
	 * ҵ���̶��绰28|ҵ����������29|�ͻ���ַ30|�ջ���ϵ��31|�ջ���ϵ����32|�ջ���֤������33|ǩԼ����34|��ͬ����35|��ͬЭ������36|ǩ���ͬʱ��37|��ͬЭ����Чʱ��38|
	 * ��ͬ������39|Ӫҵִ�ձ��40|Ӫҵִ����Ч��41|��֤��Ѻ��42|��֤��Ѻ��״̬43|��֤������44|��������45|�����ʺ�46|�����˺�����47|���������֤����48
	 */
	public void checkLine(String line, int rowCount, User user)
			throws Exception {
//
//		// ��ѯϵͳ����
//		Sysparam sysparam = (Sysparam) BOFactory.build(SysparamBO.class, user);
//		String paramvalue = sysparam.doFindByID(new Long("75"), "channel");

		delegate = (WayBO) BOFactory.build(WayBO.class, user);
		//delete by ydr û������
//		WayDAO waydao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		String exceptionMsg = "������Ϊ2G���������ϴ�1-6�Ǽ�ֵ";
		if (!StringUtils.isEmpty(user.getCityid()) && user.getCityid().equalsIgnoreCase("MM")) {
			exceptionMsg += "��6A"; 
		}
		if (rowCount > 10000) {
			throw new Exception("�ļ��������ܳ���10000��");
		}
		if (null == line || "".equals(line)) {
			return;
		}
		Way delegate = (Way) BOFactory.build(WayBO.class, user);
		String[] fields = StringUtils.splitPreserveAllTokens(line, "|");
		for (int i = 0; i < fields.length; i++) {
			fields[i] = fields[i].trim();
		}
		Sysparam sysparamBO = (SysparamBO) BOFactory.build(SysparamBO.class,
				user);
		// 1:�˳�ʱ��Ҫ��дԭ�� 0:������д�˳�ԭ�� ��:������д�˳�ԭ��
		param75 = sysparamBO.doFindByID("75", "channel");

		// �������,�ж��Ƿ��Զ�������
		if (rowCount == 1) {
			if ("".equals(fields[0])) {
				throw new Exception("[��������]����Ϊ��");
			}

			if (("1").equals(param75)) {
				if (lineArr1[0].equals(fields[0])) {
					customeFlag = true;
					checkHead(fields, user);
					return;
				} else {
					customeFlag = false;
				}
			} else {
				if (lineArr[0].equals(fields[0])) {
					customeFlag = true;
					checkHead(fields, user);
					return;
				} else {
					customeFlag = false;
				}
			}

		} else if (rowCount > 1 && customeFlag) {
			if (delegate.doFindByPk(fields[0]) == null) {
				throw new Exception("��Ҫ���µ���������:" + fields[0] + " ������");
			}
			fields = checkLines(fields, user);
			checkParameter(fields, user);
			updatecheck(fields);
			return;
		}
		if ("1".equals(param75)) {
			if (fields.length != 82 && !customeFlag) {
				throw new Exception("�ϴ�������������,ӦΪ81��,��鿴˵������!");
			}
		} else {
			if (fields.length != 81 && !customeFlag) {
				throw new Exception("�ϴ�������������,ӦΪ80��,��鿴˵������!");
			}
		}

		if (delegate.doFindByPk(fields[0]) != null) {
			updatecheck(fields);
			return;
		}
		String rewardkind = "";//�����������
		String starlevel = "";
		for (int i = 0; i < fields.length; i++) {
			System.out.println("============" + i);
			switch (i) {
			// ��������
			case 0:
				if ("".equals(fields[i])
						|| fields[i].getBytes("GBK").length > 18) {
					throw new Exception("[�������]����Ϊ�ջ����18λ");
				}
				break;
			// ��������
			case 1:
				if ("".equals(fields[i])
						|| fields[i].getBytes("GBK").length > 256) {
					throw new Exception("[��������]����Ϊ�ջ����256λ");
				}
				break;
			// �����������
			case 2:
				if ("".equals(fields[i])
						|| fields[i].getBytes("GBK").length > 4) {
					throw new Exception("[�����������]����Ϊ�ջ����4λ");
				}
				if (!"SAGT".equals(fields[i].trim())
						&& !"PSAL".equals(fields[i].trim())
						&& !"FD".equals(fields[i].trim())
						&& !"FDS".equals(fields[i].trim())
						&& !"VWAY".equals(fields[i].trim())
						&& !"JMQD".equals(fields[i].trim())) {
					throw new Exception("�˲˵�ֻ��¼��[��������]���������");
				}

				break;
			// �ϼ���������
			case 3:
				if ("".equals(fields[i])
						|| fields[i].getBytes("GBK").length > 18) {
					throw new Exception("[�ϼ���������]����Ϊ�ջ��ܴ���18λ");
				}
				if (!StringUtils.isBlank(fields[i])) {
					checkUppserwayid(fields[i]);
				}
				break;
			// �Ǽ�
			case 4:
				if ("".equals(fields[i])
						|| fields[i].getBytes("GBK").length > 2) {
					throw new Exception("[�Ǽ�]����Ϊ�ջ����2λ����");
				}
				starlevel = fields[i];
				/* start add for BR201306180003_��������������Ǽ�ȡֵ��Χ�����Ҫ���  by feng */
				if(starlevel.matches("[1-3]{1}") && !"SAGT".equals(fields[2].trim())){
					throw new Exception("�ϴ�[�Ǽ�]��ΧΪ1-3ʱ����������������Ϊ��Լ�����(SGAT)��");
				}else if(starlevel.matches("[4-7]{1}") && !"PSAL".equals(fields[2].trim())){
					throw new Exception("�ϴ�[�Ǽ�]��ΧΪ4-7ʱ����������������Ϊָ��רӪ��(PSAL)��");
				}else if(starlevel.matches("[0]{1}") && ("SGAT".equals(fields[2].trim()) || "PSAL".equals(fields[2].trim()))){
					throw new Exception("�ϴ�[�Ǽ�]��ΧΪ��1-7ʱ��������������ѡFD�����(FD)��FD������(FDS)����������(VWAY)��");
				}else if(starlevel.matches("[8]{1}") && !"JMQD".equals(fields[2].trim())){
					throw new Exception("�ϴ�[�Ǽ�]��ΧΪ8ʱ����������������Ϊ:��������������JMQD����");
				}else if(starlevel.matches("[9]{1}") && !"PSAL".equals(fields[2].trim())){
					throw new Exception("�ϴ�[�Ǽ�]Ϊ9��4G����ר���Ǽ���ʱ����������������Ϊ:ָ��רӪ�꣨PSAL����");
				}else if(user.getCityid().equalsIgnoreCase("MM") && starlevel.equals("60") && !"PSAL".equals(fields[2].trim())) {
					throw new Exception("�ϴ�[�Ǽ�]Ϊ60��6A��ʱ����������������Ϊ:ָ��רӪ�꣨PSAL����");
				}
				/* end add for BR201306180003_��������������Ǽ�ȡֵ��Χ�����Ҫ���  by feng */
				break;
			// ������
			case 5:
				if ("".equals(fields[i])
						|| fields[i].getBytes("GBK").length > 2) {
					throw new Exception("[������]����Ϊ�ջ����2λ����");
				}
				break;
			// ״̬
			case 6:
				if (!customeFlag) {
					
						if ("".equals(fields[i])
								|| !fields[i].matches("[0,1]{1}")) {
							throw new Exception("[״̬]����Ϊ�ջ�ֻ��Ϊ0,1����");
						}
				} else {
					if (!"".equals(fields[i])) {
					
							if ("".equals(fields[i])
									|| !fields[i].matches("[0,1]{1}")) {
								throw new Exception("[״̬]����Ϊ�ջ�ֻ��Ϊ0,1����");
							}
					}
				}
				break;
			// ���й�˾
			case 7:
				if (!checkCity(fields[i])) {
					throw new Exception("[���й�˾]��ʽ����,����Ϊ�ջ����14λ������ϵͳһ��");
				}
				;
				break;

			// �ֹ�˾
			case 8:
				if (!checkCounty(fields[i], fields[i - 1])) {
					throw new Exception("[�ֹ�˾]��ʽ����,���ܴ���14λ������" + fields[i - 1]
							+ "������ֹ�˾");
				}
				break;

			// ������������
			case 9:
				if (!checkSvccode(fields[i], fields[i - 1])) {
					throw new Exception("[������������]��ʽ����,���ܴ���14λ������"
							+ fields[i - 1] + "�����������������");
				}
				break;

			// ΢����
			case 10:
				if (!checkMicroarea(fields[i], fields[i - 1])) {
					throw new Exception("[΢����]��ʽ����,���ܴ���14λ������" + fields[i - 1]
							+ "������΢����");
				}
				break;
			/*
			 * // �����㼶 case 11: if (!"".equals(fields[i]) &&
			 * !fields[i].matches("[0-9]{1,2}")) { throw new
			 * Exception("[�����㼶]��ʽ����,��ȷΪ2λ����֮��"); } break;
			 */
			// �Ƿ�ֱ��
			case 11:
				if ("".equals(fields[i]) || !fields[i].matches("[0-9]{1,2}")) {
					throw new Exception("[�Ƿ�ֱ��]����Ϊ�ջ����2λ����");
				}
				break;
			// ��������
			case 12:
				if ("".equals(fields[i]) || !fields[i].matches("[0-9]{1,2}")) {
					throw new Exception("[��������]����Ϊ�ջ����2λ����");
				}
				break;
			// ��������
			case 13:
				if (fields[i].getBytes("GBK").length > 18) {
					throw new Exception("[��������]���ܴ���18λ");
				}
				break;
			// ҵ̬����
			case 14:
				if ("".equals(fields[i]) || !fields[i].matches("[0-9]{1,2}")) {
					throw new Exception("[ҵ̬����]��ʽ����,��ȷΪ2λ����֮��");
				}
				if (!"ZJ".equals(fields[7])){
					if("16".equals(fields[i])){
	                	//�ˡ�������������ҵ̬����Ϊտ������ר�ã���ѡ������ҵ̬����
						throw new Exception("�ˡ�������������ҵ̬����Ϊտ������ר�ã���ѡ������ҵ̬����");
					}
				}
				break;
			// ��ҵʱ��
			// case 15:
			// try {
			// date.parse(fields[i]);
			// } catch (ParseException pe) {
			// throw new Exception("[��ҵʱ��]��ʽ����,ӦΪyyyy-MM-dd");
			// }
			// break;
			// Ӫҵ���
			case 15:
				if ("".equals(fields[i]) || !fields[i].matches("[0-9]{1,8}")) {
					throw new Exception("[Ӫҵ���]����Ϊ�գ���ֻ��ΪС�ڡ�����8λ����");
				}
				break;
			// ����������
			case 16:
				if (fields[i].getBytes("GBK").length > 18) {
					throw new Exception("[����������]���ܴ���18λ");
				}
				break;
			// ������������
			// case 18:
			// if ("".equals(fields[i])
			// ||fields[i].getBytes("GBK").length > 18) {
			// throw new Exception("[������������]����Ϊ�ջ����18λ");
			// }
			// break;
			// �ּ�
			case 18:
				if (fields[i].getBytes("GBK").length > 4) {
					throw new Exception("[�ּ�]��ʽ����,���ܴ���4λ");
				}
				break;
			// ���������
			case 19:
				if ("".equals(fields[i])
						|| fields[i].getBytes("GBK").length > 12
						|| !StringUtils.isNumeric(fields[i])) {
					throw new Exception("[���������]��ʽ����,���ܴ���12λ�ұ���������");
				}
				break;
			// ҵ��Ԥ����
			case 20:
				if (!"".equals(fields[i]) && !fields[i].matches("[0-9]{1,10}")) {
					throw new Exception("[ҵ��Ԥ����]��ʽ����,��ȷΪ10λ����֮��");
				}
				break;
			// ��ϸ��ַ
			case 21:
				if ("".equals(fields[i])
						|| fields[i].getBytes("GBK").length > 128) {
					throw new Exception("[��ϸ��ַ]����Ϊ�ջ����128λ");
				}
				break;
			// ����γ��
			case 22:
				if ("".equals(fields[i])) {
					throw new Exception("[����γ��]����Ϊ��!");
				}
				if (fields[i].getBytes("GBK").length > 15
						|| (!"".equals(fields[i]) && (!fields[i]
								.matches("[0-9]{1,15}.[0-9]{6}")
								|| new Double(fields[i]).doubleValue() < 18 || new Double(
								fields[i]).doubleValue() > 26))) {
					throw new Exception("[����γ��]��ʽ���ԣ����Ȳ��ܴ���15����ȷ��6λС��������18��26֮��");
				}
				break;
			// ������
			case 23:
				if ("".equals(fields[i])) {
					throw new Exception("[������]����Ϊ��!");
				}
				if (fields[i].getBytes("GBK").length > 15
						|| (!"".equals(fields[i]) && (!fields[i]
								.matches("[0-9]{1,15}.[0-9]{6}")
								|| new Double(fields[i]).doubleValue() < 100 || new Double(
								fields[i]).doubleValue() > 130))) {
					throw new Exception(
							"[������]��ʽ���ԣ����Ȳ��ܴ���15����ȷ��6λС��������100��130֮��");
				}
				break;
			// ҵ������
			case 24:
				if ("".equals(fields[i])
						|| fields[i].getBytes("GBK").length > 64) {
					throw new Exception("[ҵ������]��ʽ����,����Ϊ�ջ����64");
				}
				break;
			// ҵ���绰
			case 25:
				if ("".equals(fields[i])
						|| fields[i].getBytes("GBK").length > 20) {
					throw new Exception("[ҵ���绰]��ʽ����,����Ϊ�ջ����20");
				}
				break;
			// ҵ���̶��绰
			case 26:
				if (fields[i].getBytes("GBK").length > 20) {
					throw new Exception("[ҵ���̶��绰]��ʽ����,���ܴ���20");
				}
				break;
			// ҵ����������
			case 27:
				if (fields[i].getBytes("GBK").length > 128) {
					throw new Exception("[ҵ����������]��ʽ����,���ܴ���128");
				}
				break;
			// �ͻ���ַ
			case 28:
				if (fields[i].getBytes("GBK").length > 128) {
					throw new Exception("[�ͻ���ַ]��ʽ����,���ܴ���128");
				}
				break;
			// �ջ���ϵ��
			case 29:
				if (fields[i].getBytes("GBK").length > 32) {
					throw new Exception("[�ջ���ϵ��]��ʽ����,���ܴ���32");
				}
				break;
			// �ջ���ϵ����
			case 30:
				if (fields[i].getBytes("GBK").length > 15) {
					throw new Exception("[�ջ���ϵ����]��ʽ����,���ܴ���15");
				}
				break;
			// �ջ���֤������
			case 31:
				if (fields[i].getBytes("GBK").length > 20) {
					throw new Exception("[�ջ���֤������]��ʽ����,���ܴ���20");
				}
				break;
			// ǩԼ����
			case 32:
				if ("".equals(fields[i]) || !fields[i].matches("[0-9]{1,2}")) {
					throw new Exception("[ǩԼ����]���ܴ���2λ");
				}
				break;
			// ��ͬ����
			case 33:
				if ("".equals(fields[i])
						|| fields[i].getBytes("GBK").length > 40) {
					throw new Exception("[��ͬ����]��ʽ����,����Ϊ�ջ����40");
				}
				break;
			// ��ͬЭ������
			case 34:
				if ("".equals(fields[i])
						|| fields[i].getBytes("GBK").length > 255) {
					throw new Exception("[��ͬЭ������]��ʽ����,����Ϊ�ջ����255");
				}
				break;
			// ǩ���ͬʱ��
			case 35:
				try {
					date.parse(fields[i]);
				} catch (ParseException pe) {
					throw new Exception("[ǩ���ͬʱ��]��ʽ����,ӦΪyyyy-MM-dd");
				}
				break;
			// ��ͬ��Ч��
			case 36:
				try {
					date.parse(fields[i]);
				} catch (ParseException pe) {
					throw new Exception("[��ͬ��Ч��]��ʽ����,ӦΪyyyy-MM-dd");
				}
				break;
			// ��ͬ������
			case 37:
				try {
					date.parse(fields[i]);
				} catch (ParseException pe) {
					throw new Exception("[��ͬ������]��ʽ����,ӦΪyyyy-MM-dd");
				}
				break;
			// Ӫҵִ�ձ��
			case 38:
				if (!"".equals(fields[i])
						&& fields[i].getBytes("GBK").length > 64) {
					throw new Exception("[Ӫҵִ�ձ��]��ʽ����,���ܴ���64");
				}
				break;
			// Ӫҵִ����Ч��
			case 39:
				try {
					if(fields[i] != null && !"".equals(fields[i]))
						date.parse(fields[i]);
				} catch (ParseException pe) {
					throw new Exception("[Ӫҵִ����Ч��]��ʽ����,ӦΪyyyy-MM-dd");
				}
				break;
			// ��֤��Ѻ��
			case 40:
				if (!"".equals(fields[i])
						&& !fields[i].matches("[0-9]{1,18}(.?)[0-9]{0,2}")) {
					throw new Exception("[��֤��Ѻ��]��ʽ����,��ȷΪ�����λС����18λ����֮��");
				}
				break;
			// ��֤��Ѻ��״̬
			case 41:
				if (!"".equals(fields[i]) && !fields[i].matches("[0-9]{1,2}")) {
					throw new Exception("[��֤��Ѻ��״̬]��ʽ����,��ȷΪ2λ����֮��");
				}
				break;
			// ��֤������
			case 42:
				if (StringUtils.isBlank(fields[i])
						|| !fields[i].matches("[0-9]{1,18}(.?)[0-9]{0,2}")) {
					throw new Exception("[��֤������]��ʽ����,��ȷΪ�����λС����16λ����֮���Ҳ���Ϊ��");
				}
				break;
			// ��������
			case 43:
				if ("".equals(fields[i])
						|| fields[i].getBytes("GBK").length > 128) {
					throw new Exception("[��������]��ʽ����,����Ϊ�ջ����128");
				}
				break;
			// �����ʺ�
			case 44:
				if ("".equals(fields[i])
						|| fields[i].getBytes("GBK").length > 50) {
					throw new Exception("[�����ʺ�]��ʽ����,����Ϊ�ջ����50");
				}
				break;
			// �����˺�����
			case 45:
				if ("".equals(fields[i])
						|| fields[i].getBytes("GBK").length > 128) {
					throw new Exception("[�����˺�����]��ʽ����,����Ϊ�ջ����128");
				}
				break;
			// ���������֤����38
			case 46:
				if (!(15 == fields[i].length() || 18 == fields[i].length())) {
					throw new Exception("[���������֤����]����Ϊ��,���ȱ���Ϊ15λ����18λ!");
				}
				break;
			case 47:
				if ("".equals(fields[i]) || !fields[i].matches("[0-9]{1,2}")) {
					throw new Exception("[ǩԼ״̬]����Ϊ���ұ�����2λ����֮��");
				}
				break;
			case 48:
				if (!"".equals(fields[i]) && !fields[i].matches("[0-9]{1,2}")) {
					throw new Exception("[��֤�𽻸���ʽ]��ʽ����,��ȷΪ2λ����֮��");
				}
				break;
			case 49:
				if ("".equals(fields[i]) || !fields[i].matches("[0-9]{1,3}")) {
					throw new Exception("[��Ӫ��Χ]����Ϊ���ұ�����3λ����֮��");
				}
				break;
			case 50:
				if (fields[i].getBytes().length > 18) {
					throw new Exception("[ȫʡ����]��ʽ����,���Ȳ�Ӧ�ô���18λ");
				}
				break;
			// deacctno,deacctname,debankname
			case 51:
				if (!"".equals(fields[i])
						&& fields[i].getBytes("GBK").length > 50) {
					throw new Exception("[���๺�����������˺�]��ʽ����,���Ȳ��ܳ���50");
				}
				break;
			case 52:
				if (!"".equals(fields[i])
						&& fields[i].getBytes("GBK").length > 128) {
					throw new Exception("[���๺�������ʺ�����]��ʽ����,���Ȳ��ܳ���128");
				}
				break;
			case 53:
				if (!"".equals(fields[i])
						&& fields[i].getBytes("GBK").length > 128) {
					throw new Exception("[���๺�����ۿ�������]��ʽ����,���Ȳ��ܳ���128");
				}
				break;
			case 54:
				if (!"".equals(fields[i])
						&& fields[i].getBytes("GBK").length > 18) {
					throw new Exception("[�����̱���]��ʽ����,���Ȳ��ܳ���18");
				}else {
					if (!fields[i].equals("0000") && !"".equals(fields[i])){
						WayDBParam waylistvo = new WayDBParam();
						waylistvo.set_se_waytype("AG");
						waylistvo.set_se_waysubtype("DIS");
						waylistvo.set_ne_waystate("1");
						waylistvo.set_se_wayid(fields[i]);
						// update by ydr û������ delegate
//						if (waydao.query(waylistvo).getRowCount() <= 0) {
						if (delegate.doQuery(waylistvo).getRowCount() <= 0) {
							throw new Exception( "���������̱���:" +fields[i]
									+ "�����ڻ��߲���������Ӫ������");
						}
						}
				}
				break;
			case 55:
				if ("".equals(fields[i]) || !fields[i].matches("[0,1]{1}")) {
					throw new Exception("[�Ƿ����B2Mģʽ]����Ϊ����ֻ��Ϊ0��1");
				}
				break;
			case 56:
				if (!"".equals(fields[i]) && !fields[i].matches("[0-9]{1}")) {
					throw new Exception("[�˺�����]ֻ��Ϊһλ����");
				}
				break;
			case 57:
				if (!"".equals(fields[i])
						&& fields[i].getBytes("GBK").length > 32) {
					throw new Exception("[���๺���������б�ʶ]��ʽ����,���Ȳ��ܳ���32");
				}
				break;
			case 58:
				if (!"".equals(fields[i]) && !fields[i].matches("[0,1]{1}")) {
					throw new Exception("[���๺����������״̬]ֻ��Ϊ0��1");
				}
				break;
			// ��������
			case 59:
				if (fields[i].getBytes("GBK").length > 4) {
					throw new Exception("[��������]��ʽ����,���ܴ���4λ");
				}
				break;
			case 60:
				if (!"".equals(fields[i])
						&& !fields[i].matches("[0-9a-zA-Z]{11}")) {
					throw new Exception("[����ע����]��ʽ����,ֻ��Ϊ���ֺ���ĸ�ҳ���Ϊ11λ");
				}
				break;
			/*case 61:
				if (!customeFlag) {//add by ydr
					if ("".equals(fields[i])) {
						throw new Exception("[�Ƿ���Ȩ]����Ϊ��");
					}
				}				
				if (!"".equals(fields[i])) {
					if (!"Y".equals(fields[i].trim())
							&& !"N".equals(fields[i].trim())) {
						throw new Exception("[�Ƿ���Ȩ]��ʽ����,ֻ��ΪY����N");
					}
				}
				break;*/
			// ��Ҫҵ��֧�ŷ�ʽ
			case 61:
				if (!customeFlag) {
					if (!"99".equals(fields[i])) {
						if ("".equals(fields[i])
								|| !fields[i]
										.matches("[0,1,2,3,4,5,6,7,8,9,99]{1}")) {
							throw new Exception(
									"[��Ҫҵ��֧�ŷ�ʽ]����Ϊ����ֻ��Ϊ0��1��2��3��4��5��6��7��8��9��99�е�ֵ");
						}
					}
				}
				break;
			// �Ƿ������г�ֵƽ̨
			case 62:
				if (!customeFlag) {
					if ("".equals(fields[i]) || !fields[i].matches("[0,1]{1}")) {
						throw new Exception("[�Ƿ������г�ֵƽ̨]����Ϊ����ֻ��Ϊ0��1");
					}
				} else {
					if (!"".equals(fields[i])) {
						if (!fields[i].matches("[0,1]{1}")) {
							throw new Exception("[�Ƿ������г�ֵƽ̨]����Ϊ����ֻ��Ϊ0��1");
						}
					}
				}
				break;
			// ȫ��ͳһ��������
			case 63:
				if (fields[i].getBytes("GBK").length > 30) {
					throw new Exception("[ȫ��ͳһ��������]��ʽ����,���ܴ���30");
				}
				if (fields[i] != null && !"".equals(fields[i])) {
					String uwi = fields[i] == null ? "" : fields[i];
					String wi = fields[0] == null ? "" : fields[0];

					Wayprovince wayprovince = (Wayprovince) BOFactory.build(
							WayprovinceBO.class, user);
					List wList = wayprovince.doQueryWpByWayid(wi);
					List uList = wayprovince.doQueryWpByUniquewayid(uwi);

					if (wList != null && !"".equals(wList) && wList.size() > 0) {
						// ����
						if (uList != null && !"".equals(uList)
								&& uList.size() > 0) {
							// ����ȫ��ͳһ��������
							WayprovinceVO wVO1 = (WayprovinceVO) uList.get(0);
							if (wi.equals(wVO1.getWayid())) {
								// ��ͬwayid��¼���ܸ���

							} else {
								throw new Exception(wVO1.getWayid()
										+ "  �Ѿ�����ȫ��ͳһ�������룺"
										+ wVO1.getUniquewayid() + "");

							}
						} else {
							// û�С�ȫ��ͳһ�������롱������ֱ�Ӹ���

						}
					} else {
						// ����
						if (uList != null && !"".equals(uList)
								&& uList.size() > 0) {
							// ����ȫ��ͳһ��������
							WayprovinceVO wVO1 = (WayprovinceVO) uList.get(0);
							throw new Exception(wVO1.getWayid()
									+ "  �Ѿ�����ȫ��ͳһ�������룺" + wVO1.getUniquewayid()
									+ "");

						} else {
							// û�С�ȫ��ͳһ�������롱������ֱ������

						}

					}
				}
				break;
			// ����
			case 64:
				if (fields[i].getBytes("GBK").length > 30) {
					throw new Exception("[����]��ʽ����,���ܴ���30");
				}
				break;
			// ������������
			case 65:
				if (!"".equals(fields[i]) && !fields[i].matches("[0,3]{1}")) {
					throw new Exception("[������������]��ʽ����,ֻ��Ϊ0,3�е�ֵ");
				}
				break;
			// �Ƿ���������
			case 66:
				if (!"".equals(fields[i]) && !fields[i].matches("[0,1]{1}")) {
					throw new Exception("[�Ƿ���������]��ʽ����,ֻ��Ϊ0��1�е�ֵ");
				}
				break;
			// ǰ̨Ӫҵ������O��
			case 67:
				if ("".equals(fields[i])) {

				} else {
					int loca = fields[i].indexOf(".");
					if (loca >= 0) {
						// ��С����
						if (loca == 0 || loca == (fields[i].length() - 1)) {
							// ��λ��δλС��
							throw new Exception(
									"[ǰ̨Ӫҵ������O��]��ʽ����,����λ������8λ��С��λ������2λ");
						}
						String strs[] = fields[i].split("\\.");
						if (strs.length > 2) {
							// ���С����
							throw new Exception(
									"[ǰ̨Ӫҵ������O��]��ʽ����,����λ������8λ��С��λ������2λ");
						} else {
							// һ��С����
							if ((strs[0].length() + strs[1].length()) > 10) {
								throw new Exception(
										"[ǰ̨Ӫҵ������O��]��ʽ����,����λ������8λ��С��λ������2λ");
							} else {
								if (!strs[0].matches("[0-9]{1,8}")
										|| !strs[1].matches("[0-9]{1,2}")) {
									throw new Exception(
											"[ǰ̨Ӫҵ������O��]��ʽ����,����λ������8λ��С��λ������2λ");
								}
							}
						}
					} else {// ����
						if (!fields[i].matches("[0-9]{1,8}")) {
							throw new Exception(
									"[ǰ̨Ӫҵ������O��]��ʽ����,����λ������8λ��С��λ������2λ");
						}
					}
				}
				break;
			// ��Ӫ��ISP���뷽ʽ
			case 68:
				if (!"".equals(fields[i]) && !fields[i].matches("[0,1,2,3]{1}")) {
					throw new Exception("[��Ӫ��ISP���뷽ʽ]��ʽ����,ֻ��Ϊ0��1��2��3�е�ֵ");
				}
				break;
			// �Ƿ����ȫԱ����ģʽ
			case 69:
				if (!customeFlag) {
					if ("".equals(fields[i]) || !fields[i].matches("[0,1]{1}")) {
						throw new Exception("[�Ƿ����ȫԱ����ģʽ]����Ϊ����ֻ��Ϊ0��1");
					}
				} else {
					if (!"".equals(fields[i])) {
						if (!fields[i].matches("[0,1]{1}")) {
							throw new Exception("[�Ƿ����ȫԱ����ģʽ]����Ϊ����ֻ��Ϊ0��1");
						}
					}
				}
				break;
			// �Ǽ��ֲ�
			case 70:
				if (!customeFlag) {
					if ("".equals(fields[i])
							|| !fields[i].matches("[1,2,3]{1}")) {
						throw new Exception("[�Ǽ��ֲ�]����Ϊ����ֻ��Ϊ1��2��3");
					}
				} else {
					if (!"".equals(fields[i])) {
						if (!fields[i].matches("[1,2,3]{1}")) {
							throw new Exception("[�Ǽ��ֲ�]����Ϊ����ֻ��Ϊ1��2��3");
						}
					}
				}
				break;
				
			// ��Ȧ����
			case 71:
				if (!customeFlag) {
					if ("".equals(fields[i])) {
						throw new Exception("[��Ȧ����]����Ϊ��");
					}
				}
				if (!"".equals(fields[i])) {
					if (!"99".equals(fields[i]) && !fields[i].matches("[1,5,6,7]{1}")) {
						throw new Exception("[��Ȧ����]��ʽ����,ֻ��Ϊ1,5,6,7,99");
					}
				}
				break;	
			// �Ƿ�TOP����
			case 72:
				if (!customeFlag) {
					if (!"".equals(fields[i])) {
						if (!fields[i].matches("[0,1]{1}")) {
							throw new Exception("[�Ƿ�TOP����]��ʽ����,ֻ��Ϊ0,1");
						}
					}
				}
				break;
			/* star uppdate for (2013)NBBOSS- D0019 �����Ż���Ҫ���     by feng */
			// �����������
			case 73:
				if (!customeFlag) {
					rewardkind = fields[i];
					if (fields[i] == null || "".equals(fields[i])) {
						throw new Exception("[�����������]����Ϊ��");
					}
					if("0".equals(rewardkind)){
						
						if ("7".equals(starlevel)){
							throw new Exception(exceptionMsg);
						}
						if ("8".equals(starlevel)){
							throw new Exception(exceptionMsg);
						}
						if ("9".equals(starlevel)){
							throw new Exception(exceptionMsg);
						}
						if (!"".equals(fields[75]) || !"".equals(fields[76])){
							fields[75]=null;
							fields[76]=null;
							//��������Ա�泬�������Ὠ��ֱ�����������ֵ
							//throw new Exception("ֻ��3G/4G�������С������������ԡ�������������ϵ����������ֵ");
						}
					}else if( "1".equals(rewardkind)){
						if (!"7".equals(starlevel) || "60".equals(starlevel)){
							throw new Exception("������Ϊ3G���������ϴ�3G����ר���Ǽ�");
						}
						if ("".equals(fields[75]) || null == fields[75] || "".equals(fields[76]) || null == fields[76]){
							throw new Exception("������Ϊ3G������������ϴ�����������������ԡ����������������ϵ����2������ֵ");
						}
						if ("A+1".equals(fields[75])){
							throw new Exception("������Ϊ3G����������������������ΪA+1(רӪ��Ҫ��Ȧ)ʱ������Ϊ4G�������͵�");
						}
						if (!"DG".equals(fields[7])){
							if("2Q".equals(fields[75]) || "3Q".equals(fields[75]) || "4Q".equals(fields[75]) || "A3".equals(fields[75]) || "B3".equals(fields[75]) || "C3".equals(fields[75])){
			                	//�ˡ�'+wayattr+'������������������Ϊ��ݸ����ר�ã���ѡ����������������������
								throw new Exception("�ˡ�"+fields[75]+"������������������Ϊ��ݸ����ר�ã���ѡ����������������������");
							}
						}
					}else if( "2".equals(rewardkind)){
						if (!"8".equals(starlevel) || "60".equals(starlevel)){
							throw new Exception("������Ϊ�����������������ϴ��������������Ǽ�");
						}
						if (!"".equals(fields[75]) || null != fields[75] || !"".equals(fields[76]) || null != fields[76]){
							fields[75]=null;
							fields[76]=null;
							//throw new Exception("������Ϊ�����������������ϴ�����������������ԡ����������������ϵ����2������ֵ");
						}
					}else if( "3".equals(rewardkind)){
						if (!"9".equals(starlevel) || "60".equals(starlevel)){
							throw new Exception("������Ϊ4G���������ϴ�4G����ר���Ǽ�");
						}
						if ("".equals(fields[75]) || null == fields[75] || "".equals(fields[76]) || null == fields[76]){
							throw new Exception("������Ϊ4G������������ϴ�����������������ԡ����������������ϵ����2������ֵ");
						}
//						if (!"A+1".equals(fields[75])){
//							throw new Exception("4G�������͵����������������Ա���ΪA+1 (רӪ��Ҫ��Ȧ)");
//						}
						if (!"DG".equals(fields[7])){
							if("2Q".equals(fields[75]) || "3Q".equals(fields[75]) || "4Q".equals(fields[75]) || "A3".equals(fields[75]) || "B3".equals(fields[75]) || "C3".equals(fields[75])){
			                	//�ˡ�'+wayattr+'������������������Ϊ��ݸ����ר�ã���ѡ����������������������
								throw new Exception("�ˡ�"+fields[75]+"������������������Ϊ��ݸ����ר�ã���ѡ����������������������");
							}
						}
					}else{
						throw new Exception("����������Ͳ�����");
					}
				}else{
					rewardkind = fields[i];					
					if(rewardkind != null && !"".equals(rewardkind)){
						if("0".equals(rewardkind)){
							if ("7".equals(starlevel)||"8".equals(starlevel)||"9".equals(starlevel)){
								throw new Exception(exceptionMsg);
							}
							if (!"".equals(fields[75]) || !"".equals(fields[76])){
								fields[75]=null;
								fields[76]=null;
								//��������Ա�泬�������Ὠ��ֱ�����������ֵ
								//throw new Exception("ֻ��3G/4G�������С������������ԡ�������������ϵ����������ֵ");
							}
						}else if( "1".equals(rewardkind)){
							if (!"7".equals(starlevel)){
								throw new Exception("������Ϊ3G���������ϴ�3G����ר���Ǽ�");
							}
							if ("".equals(fields[75]) || null == fields[75] || "".equals(fields[76]) || null == fields[76]){
								throw new Exception("������Ϊ3G������������ϴ�����������������ԡ����������������ϵ����2������ֵ");
							}
							if ("A+1".equals(fields[75])){
								throw new Exception("������Ϊ3G����������������������ΪA+1(רӪ��Ҫ��Ȧ)ʱ������Ϊ4G��������");
							}
							if (!"DG".equals(fields[7])){
								if("2Q".equals(fields[75]) || "3Q".equals(fields[75]) || "4Q".equals(fields[75]) || "A3".equals(fields[75]) || "B3".equals(fields[75]) || "C3".equals(fields[75])){
				                	//�ˡ�'+wayattr+'������������������Ϊ��ݸ����ר�ã���ѡ����������������������
									throw new Exception("�ˡ�"+fields[75]+"������������������Ϊ��ݸ����ר�ã���ѡ����������������������");
								}
							}
						}else if( "2".equals(rewardkind)){
							if (!"8".equals(starlevel)){
								throw new Exception("������Ϊ�����������������ϴ�8[�������������Ǽ�]");
							}
							if (!"".equals(fields[75]) || !"".equals(fields[76])){
								fields[75]=null;
								fields[76]=null;
								//��������Ա�泬�������Ὠ��ֱ�����������ֵ
								//throw new Exception("ֻ��3G/4G�������С������������ԡ�������������ϵ����������ֵ");
							}
						}else if( "3".equals(rewardkind)){
							if (!"9".equals(starlevel)){
								throw new Exception("������Ϊ4G���������ϴ�4G����ר���Ǽ�");
							}
							if ("".equals(fields[75]) || null == fields[75] || "".equals(fields[76]) || null == fields[76]){
								throw new Exception("������Ϊ4G������������ϴ�����������������ԡ����������������ϵ����2������ֵ");
							}
//							if (!"A+1".equals(fields[75])){
//								throw new Exception("4G�������͵����������������Ա���ΪA+1 (רӪ��Ҫ��Ȧ)");
//							}
							if (!"DG".equals(fields[7])){
								if("2Q".equals(fields[75]) || "3Q".equals(fields[75]) || "4Q".equals(fields[75]) || "A3".equals(fields[75]) || "B3".equals(fields[75]) || "C3".equals(fields[75])){
				                	//�ˡ�'+wayattr+'������������������Ϊ��ݸ����ר�ã���ѡ����������������������
									throw new Exception("�ˡ�"+fields[75]+"������������������Ϊ��ݸ����ר�ã���ѡ����������������������");
								}
							}
						}else{
							throw new Exception("����������Ͳ�����");
						}
					}
				}
				break;
			// ������Ȧ����
			case 74:
				if (fields[i] == null || "".equals(fields[i])) {
					if (!customeFlag) {
						throw new Exception("[������Ȧ����]����Ϊ��");
					}
				} else {
					Busicircle busicircle = (Busicircle) BOFactory.build(BusicircleBO.class, user);
					BusicircleVO busicircleVO = busicircle.doFindByPk(fields[i]);
					if (null == busicircleVO) {
						throw new Exception("[������Ȧ����]������Ч������Ȧ����ֵ������");
					}
				}
				break;
			// ����������������
			case 75:
				if("1".equals(rewardkind)){
					if (fields[i] == null || "".equals(fields[i])) {
						throw new Exception("[����������������]����Ϊ��");
					}else{
						Dictitem dictitem = (Dictitem) BOFactory.build(DictitemBO.class, user);
						DictitemVO vo = new DictitemVO();
						vo.setGroupid("CH_WAYATTR");
						vo.setDictid(fields[75]);
						if (dictitem.doFindByPk(vo) == null) {
							throw new Exception("[����������������]ֵ�������ڣ���������Ч������������������ֵ");
						}
					}
					if ("A+1".equals(fields[i])){
						throw new Exception("������Ϊ3G������ֻ��4G�������������������Բ���ΪA+1 (רӪ��Ҫ��Ȧ)");
					}
					if (!"DG".equals(fields[7])){
						if("2Q".equals(fields[i]) || "3Q".equals(fields[i]) || "4Q".equals(fields[i]) || "A3".equals(fields[i]) || "B3".equals(fields[i]) || "C3".equals(fields[i])){
		                	//�ˡ�'+wayattr+'������������������Ϊ��ݸ����ר�ã���ѡ����������������������
							throw new Exception("�ˡ�"+fields[75]+"������������������Ϊ��ݸ����ר�ã���ѡ����������������������");
						}
					}
				}else if("3".equals(rewardkind)){
					if (fields[i] == null || "".equals(fields[i])) {
						throw new Exception("[����������������]����Ϊ��");
					}else{
						Dictitem dictitem = (Dictitem) BOFactory.build(DictitemBO.class, user);
						DictitemVO vo = new DictitemVO();
						vo.setGroupid("CH_WAYATTR");
						vo.setDictid(fields[75]);
						if (dictitem.doFindByPk(vo) == null) {
							throw new Exception("[����������������]ֵ�������ڣ���������Ч������������������ֵ");
						}
					}
				}
				break;
			// ������������ϵ��
			case 76:
				if("1".equals(rewardkind)){
					if (fields[i] == null || "".equals(fields[i])) {
						throw new Exception("[������������ϵ��]����Ϊ��");
					}
				}else if("3".equals(rewardkind)){
					if (fields[i] == null || "".equals(fields[i])) {
						throw new Exception("[������������ϵ��]����Ϊ��");
					}
				}
				break;
			// ���õȼ�
			case 77:
				if(fields[i] == null || "".equals(fields[i])){
					throw new Exception("[���õȼ�]����Ϊ��");
				}else{
					if (!"".equals(fields[i]) && !fields[i].matches("[0,1,2]{1}")) {
						throw new Exception("[���õȼ�]��ʽ����,ֻ��Ϊ0��1��2");
					}
				}
				break;
			// ˰������
			case 78:
				if (fields[i] == null || "".equals(fields[i])) {
					throw new Exception("[˰������]����Ϊ��");
				} else {
					Dictitem dictitem = (Dictitem) BOFactory.build(DictitemBO.class, user);
					DictitemVO vo = new DictitemVO();
					vo.setGroupid("CH_TAXCERTIFICATE");
					vo.setDictid(fields[78]);
					if (dictitem.doFindByPk(vo) == null) {
						throw new Exception("[˰������]ֵֻ����0��С��ģ��˰�ˣ���1��һ����˰�ˣ���2��������3������");
					}
				}
				break;
			// �Ƿ���Ȩ����
			case 79:
				if (fields[i] == null || "".equals(fields[i])) {
					throw new Exception("[�Ƿ���Ȩ����]����Ϊ��");
				} else {
					if (!fields[i].trim().equals("Y") && !fields[i].trim().equals("N")) {
						throw new Exception("[�Ƿ���Ȩ����]ֵֻ����N���񣩡�Y���ǣ�2������");
					}
				}
				break;
			/* ��ע���ڱ�ע��Ϣ��ÿ�����������ֶν��䱣�ַ������лл     by feng */
			// ��ע
			case 80:
				if ("1".equals(param75)) {
					if ("0".equals(fields[6])) {
						if (fields[i] == null || "".equals(fields[i])) {
							throw new Exception("�����˳�ʱ��[��ע]����Ϊ�գ���Ҫ��д�˳�ԭ��");
						}else if (fields[i].getBytes().length>512) {
							throw new Exception("�����˳�ʱ��[��ע]���ݳ��Ȳ��ܳ������ݿⴢ�泤��");
						}
					} 
				} 
				break;
			/* end uppdate for (2013)NBBOSS- D0019 �����Ż���Ҫ���     by feng */
			
			}

		}
		checkParameter(fields, user);
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

	/**
	 * ����Ƿ��Ƿֹ�˾����������������ģ���������ܾ�����
	 * 
	 * @param svccode
	 * @param countyid
	 * @return
	 * @throws Exception
	 */
	private boolean checkSvccode(String svccode, String countyid)
			throws Exception {
		boolean result = true;
		if (StringUtils.isNotBlank(svccode) && StringUtils.isNotBlank(countyid)) {
			if (svccode.getBytes("GBK").length > 14) {
				return false;
			}
			Servcent delegate = (Servcent) BOFactory.build(ServcentBO.class,
					user);
			ServcentVO servcentVO = delegate.doFindByPk(svccode);
			if (servcentVO == null
					|| !countyid.equals(servcentVO.getCountyid())) {
				result = false;
			}
		}
		return result;
	}

	/**
	 * ����Ƿ��Ƿ����������������΢������������ܾ�����
	 * 
	 * @param mareacode
	 * @param svccode
	 * @return
	 * @throws Exception
	 */
	private boolean checkMicroarea(String mareacode, String svccode)
			throws Exception {
		boolean result = true;
		if (StringUtils.isNotBlank(mareacode)
				&& StringUtils.isNotBlank(svccode)) {
			if (svccode.getBytes("GBK").length > 14) {
				return false;
			}
			Microarea delegate = (Microarea) BOFactory.build(MicroareaBO.class,
					user);
			MicroareaVO microareaVO = delegate.doFindByPk(mareacode);
			if (microareaVO == null
					|| !svccode.equals(microareaVO.getSvccode())) {
				result = false;
			}
		}
		return result;
	}

	private void updatecheck(String[] fields) throws Exception {
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		Sysparam sysparamBO = (SysparamBO) BOFactory.build(SysparamBO.class,
				user);
		String exceptionMsg = "������Ϊ2G���������ϴ�1-6�Ǽ�ֵ";
		if (!StringUtils.isEmpty(user.getCityid()) && user.getCityid().equalsIgnoreCase("MM")) {
			exceptionMsg += "��6A"; 
		}
		//delete by ydr û������
//		WayDAO waydao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		// 1:�˳�ʱ��Ҫ��дԭ�� 0:������д�˳�ԭ�� ��:������д�˳�ԭ��
		String param75 = sysparamBO.doFindByID("75", "channel");
		
		String rewardkind = "";//�����������
		String starlevel = "";
		
		/* start add for (2013)NBBOSS- D0019 �����Ż���Ҫ���     by feng */
		WayVO wayVO = delegate.doFindByPk(fields[0]);
		if (wayVO == null) {
			throw new Exception("����Ҫ�޸ĵ�����������");
		} else {
			if ("AG".equals(wayVO.getWaytype())) {
				if (!"SAGT".equals(wayVO.getWaysubtype())
						&& !"PSAL".equals(wayVO.getWaysubtype())
						&& !"FD".equals(wayVO.getWaysubtype())
						&& !"FDS".equals(wayVO.getWaysubtype())
						&& !"VWAY".equals(wayVO.getWaysubtype())
						&& !"JMQD".equals(wayVO.getWaysubtype())) {
					throw new Exception("��[����]���͵����������ڴ˲˵��޸�");
				}
			} else {
				throw new Exception("��[�������]���͵����������ڴ˲˵��޸�");
			}
		}
		/* start add for (2013)NBBOSS- D0019 �����Ż���Ҫ���     by feng */
		
		//��Ȧ��Ϣ
		Waybusicircle waybusicircleBO = (WaybusicircleBO)BOFactory.build(WaybusicircleBO.class,user);
		WaybusicircleDBParam waybusicircleDBParam = new WaybusicircleDBParam();
		waybusicircleDBParam.set_se_wayid(fields[0]);
		DataPackage WaybusicircleDP = waybusicircleBO.doQuery(waybusicircleDBParam);
		WaybusicircleVO wbVO = new WaybusicircleVO();
		if(WaybusicircleDP != null && !"".equals(WaybusicircleDP)
				&& WaybusicircleDP.getDatas() != null && !"".equals(WaybusicircleDP.getDatas())
				&& WaybusicircleDP.getDatas().size() > 0){
			wbVO = (WaybusicircleVO)WaybusicircleDP.getDatas().get(0);
		}
		
		for (int i = 0; i < fields.length; i++) {
			switch (i) {
			// ��������
			case 0:
				if ("".equals(fields[i])
						|| fields[i].getBytes("GBK").length > 18) {
					throw new Exception("[�������]����Ϊ�ջ����18λ");
				}
				break;
			// ��������
			case 1:
				if (!"".equals(fields[i])
						&& fields[i].getBytes("GBK").length > 256) {
					throw new Exception("[��������]���ܴ���256λ");
				}
				break;
			// �����������
			case 2:
//				Way way = (Way) BOFactory.build(WayBO.class, user);
//				WayVO vo = way.doFindByPk(fields[0].trim());
//				if (vo == null) {
//					throw new Exception("����Ҫ�޸ĵ�����������");
//				} else {
//					if ("AG".equals(vo.getWaytype())) {
//						if (!"SAGT".equals(vo.getWaysubtype())
//								&& !"PSAL".equals(vo.getWaysubtype())
//								&& !"FD".equals(vo.getWaysubtype())
//								&& !"FDS".equals(vo.getWaysubtype())
//								&& !"VWAY".equals(vo.getWaysubtype())) {
//							throw new Exception("��[����]���͵����������ڴ˲˵��޸�");
//						}
//					} else {
//						throw new Exception("��[�������]���͵����������ڴ˲˵��޸�");
//					}
//				}
				if (!"".equals(fields[i])
						&& fields[i].getBytes("GBK").length > 4) {
					throw new Exception("[�����������]���ܴ���4λ");
				} else if (!"".equals(fields[i])
						&& !"SAGT".equals(fields[i].trim())
						&& !"PSAL".equals(fields[i].trim())
						&& !"FD".equals(fields[i].trim())
						&& !"FDS".equals(fields[i].trim())
						&& !"VWAY".equals(fields[i].trim())
						&& !"JMQD".equals(fields[i].trim())) {
					throw new Exception("�˲˵�ֻ��¼��[��������]���������");
				}
				/* start add for BR201306180003_��������������Ǽ�ȡֵ��Χ�����Ҫ���  by feng */
				if(!"".equals(fields[i]) && "".equals(fields[4])){
					if(!"SAGT".equals(fields[i]) && wayVO.getStarlevel().toString().matches("[1-3]{1}")){
						throw new Exception("���������Ǽ�Ϊ1-3֮��ʱ���ϴ�[�����������]ֻ��Ϊ��Լ�����(SGAT)��");
					}else if(!"PSAL".equals(fields[i]) && wayVO.getStarlevel().toString().matches("[4-7]{1}")){
						throw new Exception("���������Ǽ�Ϊ4-7֮��ʱ���ϴ�[�����������]ֻ��Ϊָ��רӪ��(PSAL)��");
					}else if(!"JMQD".equals(fields[i]) && wayVO.getStarlevel().toString().matches("[8]{1}")){
						throw new Exception("���������Ǽ�Ϊ8ʱ���ϴ�[�����������]ֻ��Ϊ������������(JMQD)��");
					}else if(!"PSAL".equals(fields[i]) && wayVO.getStarlevel().toString().matches("[9]{1}")){
						throw new Exception("���������Ǽ�Ϊ9ʱ���ϴ�[�����������]ֻ��Ϊָ��רӪ��(PSAL)��");
					}else if(("SAGT".equals(fields[i]) || "PSAL".equals(fields[i])) && wayVO.getStarlevel().toString().matches("[0]{1}")){
						throw new Exception("���������Ǽ�Ϊ0���ϴ�[�����������]ֻ��ѡ��FD�����(FD)����FD������(FDS)������������(VWAY)��");
					}
				}
				/* end add for BR201306180003_��������������Ǽ�ȡֵ��Χ�����Ҫ���  by feng */
				break;
			// �ϼ���������
			case 3:
				if (fields[i].getBytes("GBK").length > 18) {
					throw new Exception("[�ϼ���������]���ܴ���18λ");
				}
				if (!StringUtils.isBlank(fields[i])) {
					checkUppserwayid(fields[i]);
				}
				break;
			// �Ǽ�
			case 4:
				if (fields[i].getBytes("GBK").length > 2) {
					throw new Exception("[�Ǽ�]���ܴ���2λ");
				}
				starlevel = fields[i];
				/* start add for BR201306180003_��������������Ǽ�ȡֵ��Χ�����Ҫ���  by feng */
				if(!"".equals(starlevel)){
					if("".equals(fields[2])){
						if(!starlevel.matches("[1-3]{1}") && "SAGT".equals(wayVO.getWaysubtype())){
							throw new Exception("�����������Ϊ��Լ�����(SGAT)���ϴ�[�Ǽ�]��Χ����Ϊ1-3��");
						}else if((!starlevel.matches("[4-7]{1}") && !starlevel.matches("[9]{1}") ) && "PSAL".equals(wayVO.getWaysubtype())){
							throw new Exception("�����������Ϊָ��רӪ��(PSAL)���ϴ�[�Ǽ�]��Χ����Ϊ4-7 ��9��");
						}else if(!starlevel.matches("[8]{1}") && "JMQD".equals(wayVO.getWaysubtype())){
							throw new Exception("�����������Ϊ������������(JMQD)���ϴ�[�Ǽ�]��Χ����Ϊ8��");
						}else if(!starlevel.matches("[0]{1}") && ("FD".equals(wayVO.getWaysubtype()) || "FDS".equals(wayVO.getWaysubtype()) || "VWAY".equals(wayVO.getWaysubtype()))){
							throw new Exception("�����������ΪFD�����(FD)����FD������(FDS)������������(VWAY)���ϴ�[�Ǽ�]��Χ����Ϊ0��");
						}
					}else{
						if(starlevel.matches("[1-3]{1}") && !"SAGT".equals(fields[2])){
							throw new Exception("�ϴ�[�Ǽ�]��ΧΪ1-3ʱ���ϴ�[�����������]����Ϊ��Լ�����(SGAT)��");
						}else if(starlevel.matches("[4-7]{1}") && !"PSAL".equals(fields[2])){
							throw new Exception("�ϴ�[�Ǽ�]��ΧΪ4-7ʱ���ϴ�[�����������]����Ϊָ��רӪ��(PSAL)��");
						}else if(starlevel.matches("[8]{1}") && !"JMQD".equals(fields[2])){
							throw new Exception("�ϴ�[�Ǽ�]��ΧΪ8ʱ���ϴ�[�����������]����Ϊ������������(JMQD)��");
						}else if(starlevel.matches("[9]{1}") && !"PSAL".equals(fields[2])){
							throw new Exception("�ϴ�[�Ǽ�]Ϊ9ʱ���ϴ�[�����������]����Ϊָ��רӪ��(PSAL)��");
						}else if(starlevel.matches("[0]{1}") && ("SAGT".equals(fields[2]) || "PSAL".equals(fields[2]) )){
							throw new Exception("�ϴ�[�Ǽ�]��Χ����Ϊ0ʱ���ϴ�[�����������]����ѡ��FD�����(FD)����FD������(FDS)������������(VWAY)��");
						}else if(user.getCityid().equalsIgnoreCase("MM") && starlevel.equals("60") && !"PSAL".equals(fields[2].trim())) {
							throw new Exception("�ϴ�[�Ǽ�]Ϊ60��6A��ʱ����������������Ϊ:ָ��רӪ�꣨PSAL����");
						}
						//TODO
					}					
				}
				/* end add for BR201306180003_��������������Ǽ�ȡֵ��Χ�����Ҫ���  by feng */
				/* start add for (2013)NBBOSS- D0019 �����Ż���Ҫ���     by feng */
				if(!"".equals(starlevel) && "".equals(fields[73])){
					if(0==wbVO.getRewardkind() && ("7".equals(starlevel) || "8".equals(starlevel) || "9".equals(starlevel))){
						throw new Exception("������Ϊ2G���������ϴ�2G�����Ǽ�");
					}
					if(1==wbVO.getRewardkind() && !"7".equals(starlevel)){
						throw new Exception("������Ϊ3G���������ϴ�3G�����Ǽ�");
					}
					if(2==wbVO.getRewardkind() && !"8".equals(starlevel)){
						throw new Exception("������Ϊ�����������������ϴ��������������Ǽ�");
					}
					if(3==wbVO.getRewardkind() && !"9".equals(starlevel)){
						throw new Exception("������Ϊ4G���������ϴ�4G����ר���Ǽ�");
					}
				}
				/* end add for (2013)NBBOSS- D0019 �����Ż���Ҫ���     by feng */				
				break;
			// ������
			case 5:
				if (fields[i].getBytes("GBK").length > 2) {
					throw new Exception("[������]���ܴ���2λ");
				}
				break;
			// ״̬
			case 6:
				if (!customeFlag) {
					
						if ("".equals(fields[i])
								|| !fields[i].matches("[0,1]{1}")) {
							throw new Exception("[״̬]����Ϊ�ջ�ֻ��Ϊ0,1����");
						}
					
				} else {
					if (!"".equals(fields[i])) {
						
							if ("".equals(fields[i])
									|| !fields[i].matches("[0,1]{1}")) {
								throw new Exception("[״̬]����Ϊ�ջ�ֻ��Ϊ0,1����");
							}
						
					}
				}
				break;
			// ���й�˾
			case 7:
				if (!"".equals(fields[i]) && !checkCity(fields[i])) {
					throw new Exception("[���й�˾]��ʽ����,���ܴ���14λ������ϵͳһ��");
				}
				;
				break;

			// �ֹ�˾
			case 8:
				if (!"".equals(fields[i])
						&& !checkCounty(fields[i], fields[i - 1])) {
					throw new Exception("[�ֹ�˾]��ʽ����,�����뵱ǰ��¼������ͬ���ܴ���14λ���߱�����"
							+ fields[i - 1] + "������ֹ�˾");
				}
				break;

			// ������������
			case 9:
				if (!checkSvccode(fields[i], fields[i - 1])) {
					throw new Exception("[������������]��ʽ����,���ܴ���14λ������"
							+ fields[i - 1] + "�����������������");
				}
				break;

			// ΢����
			case 10:
				if (!checkMicroarea(fields[i], fields[i - 1])) {
					throw new Exception("[΢����]��ʽ����,���ܴ���14λ������" + fields[i - 1]
							+ "������΢����");
				}
				break;
			// �Ƿ�ֱ��
			case 11:
				if (!"".equals(fields[i]) && !fields[i].matches("[0-9]{1,2}")) {
					throw new Exception("[�Ƿ�ֱ��]��ʽ����,��ȷΪ2λ����֮��");
				}
				break;
			// ��������
			case 12:
				if (!"".equals(fields[i]) && !fields[i].matches("[0-9]{1,2}")) {
					throw new Exception("[��������]��ʽ����,��ȷΪ2λ����֮��");
				}
				break;
			// ��������
			case 13:
				if (fields[i].getBytes("GBK").length > 18) {
					throw new Exception("[��������]���ܴ���18λ");
				}
				break;
			// ҵ̬����
			case 14:
				if (!"".equals(fields[i]) && !fields[i].matches("[0-9]{1,2}")) {
					throw new Exception("[ҵ̬����]��ʽ����,��ȷΪ2λ����֮��");
				}
				if (!"ZJ".equals(fields[7])){
					if("16".equals(fields[i])){
	                	//�ˡ�������������ҵ̬����Ϊտ������ר�ã���ѡ������ҵ̬����
						throw new Exception("�ˡ�������������ҵ̬����Ϊտ������ר�ã���ѡ������ҵ̬����");
					}
				}
				break;
			// ��ҵʱ��
			// case 15:
			// try {
			// if (!"".equals(fields[i]))
			// date.parse(fields[i]);
			// } catch (ParseException pe) {
			// throw new Exception("[��ҵʱ��]��ʽ����,ӦΪyyyy-MM-dd");
			// }
			// break;
			// Ӫҵ���
			case 15:
				if (!"".equals(fields[i]) && !fields[i].matches("[0-9]{1,8}")) {
					throw new Exception("[Ӫҵ���]����Ϊ�գ���ֻ��ΪС�ڡ�����8λ����");
				}
				break;
			// ����������
			case 16:
				if (fields[i].getBytes("GBK").length > 18) {
					throw new Exception("[����������]���ܴ���18λ");
				}
				break;
			// ������������
			case 17:
				if (fields[i].getBytes("GBK").length > 18) {
					throw new Exception("[������������]���ܴ���18λ");
				}
				break;
			// �ּ�
			case 18:
				if (fields[i].getBytes("GBK").length > 4) {
					throw new Exception("[�ּ�]��ʽ����,���ܴ���4λ");
				}
				break;
			// �ɼ�ƽ̨�����ֻ��� ���������
			case 19:
				if (fields[i].getBytes("GBK").length > 12
						|| !StringUtils.isNumeric(fields[i])) {
					throw new Exception("[���������]��ʽ����,���ܴ���12λ�ұ���������");
				}
				break;
			// ҵ��Ԥ����
			case 20:
				if (!"".equals(fields[i]) && !fields[i].matches("[0-9]{1,10}")) {
					throw new Exception("[ҵ��Ԥ����]��ʽ����,��ȷΪ10λ����֮��");
				}
				break;
			// ��ϸ��ַ
			case 21:
				if (fields[i].getBytes("GBK").length > 128) {
					throw new Exception("[��ϸ��ַ]��ʽ����,���ܴ���128");
				}
				break;
			// ����γ��
			case 22:
				if (fields[i].getBytes("GBK").length > 15
						|| (!"".equals(fields[i]) && (!fields[i]
								.matches("[0-9]{1,15}.[0-9]{6}")
								|| new Double(fields[i]).doubleValue() < 18 || new Double(
								fields[i]).doubleValue() > 26))) {
					throw new Exception("[����γ��]��ʽ���ԣ����Ȳ��ܴ���15����ȷ��6λС��������18��26֮��");
				}
				break;
			// ������
			case 23:
				if (fields[i].getBytes("GBK").length > 15
						|| (!"".equals(fields[i]) && (!fields[i]
								.matches("[0-9]{1,15}.[0-9]{6}")
								|| new Double(fields[i]).doubleValue() < 100 || new Double(
								fields[i]).doubleValue() > 130))) {
					throw new Exception(
							"[������]��ʽ���ԣ����Ȳ��ܴ���15����ȷ��6λС��������100��130֮��");
				}
				break;
			// ҵ������
			case 24:
				if (!"".equals(fields[i])
						&& fields[i].getBytes("GBK").length > 64) {
					throw new Exception("[ҵ������]��ʽ����,���ܴ���64");
				}
				break;
			// ҵ���绰
			case 25:
				if (!"".equals(fields[i])
						&& fields[i].getBytes("GBK").length > 20) {
					throw new Exception("[ҵ���绰]��ʽ����,���ܴ���20");
				}
				break;
			// ҵ���̶��绰
			case 26:
				if (fields[i].getBytes("GBK").length > 20) {
					throw new Exception("[ҵ���̶��绰]��ʽ����,���ܴ���20");
				}
				break;
			// ҵ����������
			case 27:
				if (fields[i].getBytes("GBK").length > 128) {
					throw new Exception("[ҵ����������]��ʽ����,���ܴ���128");
				}
				break;
			// �ͻ���ַ
			case 28:
				if (fields[i].getBytes("GBK").length > 128) {
					throw new Exception("[�ͻ���ַ]��ʽ����,���ܴ���128");
				}
				break;
			// �ջ���ϵ��
			case 29:
				if (fields[i].getBytes("GBK").length > 32) {
					throw new Exception("[�ջ���ϵ��]��ʽ����,���ܴ���32");
				}
				break;
			// �ջ���ϵ����
			case 30:
				if (fields[i].getBytes("GBK").length > 15) {
					throw new Exception("[�ջ���ϵ����]��ʽ����,���ܴ���15");
				}
				break;
			// �ջ���֤������
			case 31:
				if (fields[i].getBytes("GBK").length > 20) {
					throw new Exception("[�ջ���֤������]��ʽ����,���ܴ���20");
				}
				break;
			// ǩԼ����
			case 32:
				if (!"".equals(fields[i]) && !fields[i].matches("[0-9]{1,2}")) {
					throw new Exception("[ǩԼ����]��ʽ����,��ȷΪ2λ����֮��");
				}
				break;
			// ��ͬ����
			case 33:
				if (!"".equals(fields[i])
						&& fields[i].getBytes("GBK").length > 40 ) {
					throw new Exception("[��ͬ����]��ʽ����,���ܴ���40");
				}
				break;
			// ��ͬЭ������
			case 34:
				if (!"".equals(fields[i])
						&& fields[i].getBytes("GBK").length > 255) {
					throw new Exception("[��ͬЭ������]��ʽ����,���ܴ���255");
				}
				break;
			// ǩ���ͬʱ��
			case 35:
				try {
					if (!"".equals(fields[i]))
						date.parse(fields[i]);
				} catch (ParseException pe) {
					throw new Exception("[ǩ���ͬʱ��]��ʽ����,ӦΪyyyy-MM-dd");
				}
				break;
			// ��ͬ��Ч��
			case 36:
				try {
					if (!"".equals(fields[i]))
						date.parse(fields[i]);
				} catch (ParseException pe) {
					throw new Exception("[��ͬ��Ч��]��ʽ����,ӦΪyyyy-MM-dd");
				}
				break;
			// ��ͬ������
			case 37:
				try {
					if (!"".equals(fields[i]))
						date.parse(fields[i]);
				} catch (ParseException pe) {
					throw new Exception("[��ͬ������]��ʽ����,ӦΪyyyy-MM-dd");
				}
				break;
			// Ӫҵִ�ձ��
			case 38:
				if (!"".equals(fields[i])
						&& fields[i].getBytes("GBK").length > 64) {
					throw new Exception("[Ӫҵִ�ձ��]��ʽ����,���ܴ���64");
				}
				break;
			// Ӫҵִ����Ч��
			case 39:
				try {
					if (!"".equals(fields[i]))
						date.parse(fields[i]);
				} catch (ParseException pe) {
					throw new Exception("[Ӫҵִ����Ч��]��ʽ����,ӦΪyyyy-MM-dd");
				}
				break;
			// ��֤��Ѻ��
			case 40:
				if (!"".equals(fields[i])
						&& !fields[i].matches("[0-9]{1,18}(.?)[0-9]{0,2}")) {
					throw new Exception("[��֤��Ѻ��]��ʽ����,��ȷΪ�����λС����18λ����֮��");
				}
				break;
			// ��֤��Ѻ��״̬
			case 41:
				if (!"".equals(fields[i]) && !fields[i].matches("[0-9]{1,2}")) {
					throw new Exception("[��֤��Ѻ��״̬]��ʽ����,��ȷΪ2λ����֮��");
				}
				break;
			// ��֤������
			case 42:
				if (!"".equals(fields[i])
						&& !fields[i].matches("[0-9]{1,18}(.?)[0-9]{0,2}")) {
					throw new Exception("[��֤������]��ʽ����,��ȷΪ�����λС����16λ����֮��");
				}
				break;
			// ��������
			case 43:
				if (!"".equals(fields[i])
						&& fields[i].getBytes("GBK").length > 128) {
					throw new Exception("[��������]��ʽ����,���ܴ���128");
				}
				break;
			// �����ʺ�
			case 44:
				if (!"".equals(fields[i])
						&& fields[i].getBytes("GBK").length > 50) {
					throw new Exception("[�����ʺ�]��ʽ����,���ܴ���50");
				}
				break;
			// �����˺�����
			case 45:
				if (!"".equals(fields[i])
						&& fields[i].getBytes("GBK").length > 128) {
					throw new Exception("[�����˺�����]��ʽ����,���ܴ���128");
				}
				break;
			// ���������֤����38
			case 46:
				if (StringUtils.isNotBlank(fields[i])) {
					if (!(15 == fields[i].length() || 18 == fields[i].length())) {
						throw new Exception("[���������֤����]���ȱ���Ϊ15λ����18λ!");
					}
				}
				break;
			case 47:
				if (!"".equals(fields[i]) && !fields[i].matches("[0-9]{1,2}")) {
					throw new Exception("[ǩԼ״̬]��ʽ����,��ȷΪ2λ����֮��");
				}
				break;
			case 48:
				if (!"".equals(fields[i]) && !fields[i].matches("[0-9]{1,2}")) {
					throw new Exception("[��֤�𽻸���ʽ]��ʽ����,��ȷΪ2λ����֮��");
				}
				break;
			case 49:
				if (!"".equals(fields[i]) && !fields[i].matches("[0-9]{1,3}")) {
					throw new Exception("[��Ӫ��Χ]��ʽ����,��ȷΪ3λ����֮��");
				}
				break;
			case 50:
				if (fields[i].getBytes().length > 18) {
					throw new Exception("[ȫʡ����]��ʽ����,���Ȳ�Ӧ�ô���18λ");
				}
				break;
			// deacctno,deacctname,debankname
			case 51:
				if (!"".equals(fields[i])
						&& fields[i].getBytes("GBK").length > 50) {
					throw new Exception("[���๺�����������˺�]��ʽ����,���Ȳ��ܳ���50");
				}
				break;
			case 52:
				if (!"".equals(fields[i])
						&& fields[i].getBytes("GBK").length > 128) {
					throw new Exception("[���๺�������ʺ�����]��ʽ����,���Ȳ��ܳ���128");
				}
				break;
			case 53:
				if (!"".equals(fields[i])
						&& fields[i].getBytes("GBK").length > 128) {
					throw new Exception("[���๺�����ۿ�������]��ʽ����,���Ȳ��ܳ���128");
				}
				break;
			case 54:
				if (!"".equals(fields[i])
						&& fields[i].getBytes("GBK").length > 18) {
					throw new Exception("[�����̱���]��ʽ����,���Ȳ��ܳ���18");
				}else {
					if (!fields[i].equals("0000") && !"".equals(fields[i])){
						WayDBParam waylistvo = new WayDBParam();
						waylistvo.set_se_waytype("AG");
						waylistvo.set_se_waysubtype("DIS");
						waylistvo.set_ne_waystate("1");
						waylistvo.set_se_wayid(fields[i]);
						//.query(waylistvo)
						if (delegate.doQuery(waylistvo).getRowCount() <= 0) {
							throw new Exception( "���������̱���:" +fields[i]
									+ "�����ڻ��߲���������Ӫ������");
						}
						}
				}
				break;
			case 55:
				if (!"".equals(fields[i]) && !fields[i].matches("[0,1]{1}")) {
					throw new Exception("[�Ƿ����B2Mģʽ]ֻ��Ϊ0��1");
				}
				break;
			case 56:
				if (!"".equals(fields[i]) && !fields[i].matches("[0-9]{1}")) {
					throw new Exception("[�˺�����]ֻ��Ϊһλ����");
				}
				break;
			case 57:
				if (!"".equals(fields[i])
						&& fields[i].getBytes("GBK").length > 32) {
					throw new Exception("[���๺���������б�ʶ]��ʽ����,���Ȳ��ܳ���32");
				}
				break;
			case 58:
				if (!"".equals(fields[i]) && !fields[i].matches("[0,1]{1}")) {
					throw new Exception("[���๺����������״̬]ֻ��Ϊ0��1");
				}
				break;
			// ��������
			case 59:
				if (fields[i].getBytes("GBK").length > 4) {
					throw new Exception("[��������]��ʽ����,���ܴ���4λ");
				}
				break;
			// ����ע����
			case 60:
				if (!"".equals(fields[i])
						&& !fields[i].matches("[0-9a-zA-Z]{11}")) {
					throw new Exception("[����ע����]��ʽ����,ֻ��Ϊ���ֺ���ĸ�ҳ���Ϊ11λ");
				}
				break;

			/*case 61:
				if (!customeFlag) {//add by ydr
					if ("".equals(fields[i])) {
						throw new Exception("[�Ƿ���Ȩ]����Ϊ��");
					}
				}
				if (!"".equals(fields[i])) {
					if (!"Y".equals(fields[i].trim())
							&& !"N".equals(fields[i].trim())) {
						throw new Exception("[�Ƿ���Ȩ]��ʽ����,ֻ��ΪY����N");
					}
				}
				break;*/
			// ��Ҫҵ��֧�ŷ�ʽ
			case 61:
				if (!customeFlag) {
					if (!"99".equals(fields[i])) {
						if ("".equals(fields[i])
								|| !fields[i]
										.matches("[0,1,2,3,4,5,6,7,8,9,99]{1}")) {
							throw new Exception(
									"[��Ҫҵ��֧�ŷ�ʽ]����Ϊ����ֻ��Ϊ0��1��2��3��4��5��6��7��8��9��99�е�ֵ");
						}
					}
				}
				break;
			// �Ƿ������г�ֵƽ̨
			case 62:
				if (!customeFlag) {
					if ("".equals(fields[i]) || !fields[i].matches("[0,1]{1}")) {
						throw new Exception("[�Ƿ������г�ֵƽ̨]����Ϊ����ֻ��Ϊ0��1");
					}
				} else {
					if (!"".equals(fields[i])) {
						if (!fields[i].matches("[0,1]{1}")) {
							throw new Exception("[�Ƿ������г�ֵƽ̨]����Ϊ����ֻ��Ϊ0��1");
						}
					}
				}
				break;
			// ȫ��ͳһ��������
			case 63:
				if (fields[i].getBytes("GBK").length > 30) {
					throw new Exception("[ȫ��ͳһ��������]��ʽ����,���ܴ���30");
				}
				if (fields[i] != null && !"".equals(fields[i])) {
					String uwi = fields[i] == null ? "" : fields[i];
					String wi = fields[0] == null ? "" : fields[0];

					Wayprovince wayprovince = (Wayprovince) BOFactory.build(
							WayprovinceBO.class, user);
					List wList = wayprovince.doQueryWpByWayid(wi);
					List uList = wayprovince.doQueryWpByUniquewayid(uwi);

					if (wList != null && !"".equals(wList) && wList.size() > 0) {
						// ����
						if (uList != null && !"".equals(uList)
								&& uList.size() > 0) {
							// ����ȫ��ͳһ��������
							WayprovinceVO wVO1 = (WayprovinceVO) uList.get(0);
							if (wi.equals(wVO1.getWayid())) {
								// ��ͬwayid��¼���ܸ���

							} else {
								throw new Exception(wVO1.getWayid()
										+ "  �Ѿ�����ȫ��ͳһ�������룺"
										+ wVO1.getUniquewayid() + "");

							}
						} else {
							// û�С�ȫ��ͳһ�������롱������ֱ�Ӹ���

						}
					} else {
						// ����
						if (uList != null && !"".equals(uList)
								&& uList.size() > 0) {
							// ����ȫ��ͳһ��������
							WayprovinceVO wVO1 = (WayprovinceVO) uList.get(0);
							throw new Exception(wVO1.getWayid()
									+ "  �Ѿ�����ȫ��ͳһ�������룺" + wVO1.getUniquewayid()
									+ "");

						} else {
							// û�С�ȫ��ͳһ�������롱������ֱ������

						}

					}
				}
				break;
			// ����
			case 64:
				if (fields[i].getBytes("GBK").length > 30) {
					throw new Exception("[����]��ʽ����,���ܴ���30");
				}
				break;
			// ������������
			case 65:
				if (!"".equals(fields[i]) && !fields[i].matches("[0,3]{1}")) {
					throw new Exception("[������������]��ʽ����,ֻ��Ϊ0,3�е�ֵ");
				}
				break;
			// �Ƿ���������
			case 66:
				if (!"".equals(fields[i]) && !fields[i].matches("[0,1]{1}")) {
					throw new Exception("[�Ƿ���������]��ʽ����,ֻ��Ϊ0��1�е�ֵ");
				}
				break;
			// ǰ̨Ӫҵ������O��
			case 67:
				if ("".equals(fields[i])) {

				} else {
					int loca = fields[i].indexOf(".");
					if (loca >= 0) {
						// ��С����
						if (loca == 0 || loca == (fields[i].length() - 1)) {
							// ��λ��δλС��
							throw new Exception(
									"[ǰ̨Ӫҵ������O��]��ʽ����,����λ������8λ��С��λ������2λ");
						}
						String strs[] = fields[i].split("\\.");
						if (strs.length > 2) {
							// ���С����
							throw new Exception(
									"[ǰ̨Ӫҵ������O��]��ʽ����,����λ������8λ��С��λ������2λ");
						} else {
							// һ��С����
							if ((strs[0].length() + strs[1].length()) > 10) {
								throw new Exception(
										"[ǰ̨Ӫҵ������O��]��ʽ����,����λ������8λ��С��λ������2λ");
							} else {
								if (!strs[0].matches("[0-9]{1,8}")
										|| !strs[1].matches("[0-9]{1,2}")) {
									throw new Exception(
											"[ǰ̨Ӫҵ������O��]��ʽ����,����λ������8λ��С��λ������2λ");
								}
							}
						}
					} else {// ����
						if (!fields[i].matches("[0-9]{1,8}")) {
							throw new Exception(
									"[ǰ̨Ӫҵ������O��]��ʽ����,����λ������8λ��С��λ������2λ");
						}
					}
				}
				break;
			// ��Ӫ��ISP���뷽ʽ
			case 68:
				if (!"".equals(fields[i]) && !fields[i].matches("[0,1,2,3]{1}")) {
					throw new Exception("[��Ӫ��ISP���뷽ʽ]��ʽ����,ֻ��Ϊ0��1��2��3�е�ֵ");
				}
				break;
			// �Ƿ����ȫԱ����ģʽ
			case 69:
				if (!customeFlag) {
					if ("".equals(fields[i]) || !fields[i].matches("[0,1]{1}")) {
						throw new Exception("[�Ƿ����ȫԱ����ģʽ]����Ϊ����ֻ��Ϊ0��1");
					}
				} else {
					if (!"".equals(fields[i])) {
						if (!fields[i].matches("[0,1]{1}")) {
							throw new Exception("[�Ƿ����ȫԱ����ģʽ]����Ϊ����ֻ��Ϊ0��1");
						}
					}
				}
				break;
			// �Ǽ��ֲ�
			case 70:
				if (!customeFlag) {
					if ("".equals(fields[i])
							|| !fields[i].matches("[1,2,3]{1}")) {
						throw new Exception("[�Ǽ��ֲ�]����Ϊ����ֻ��Ϊ1��2��3");
					}
				} else {
					if (!"".equals(fields[i])) {
						if (!fields[i].matches("[1,2,3]{1}")) {
							throw new Exception("[�Ǽ��ֲ�]����Ϊ����ֻ��Ϊ1��2��3");
						}
					}
				}
				break;
			// ��Ȧ����
			case 71:
				if (!customeFlag) {
					if ("".equals(fields[i])) {
						throw new Exception("[��Ȧ����]����Ϊ��");
					}
					
					if (!"99".equals(fields[i]) && !fields[i].matches("[1,5,6,7]{1}")) {
						throw new Exception("[��Ȧ����]��ʽ���ԣ�ֻ��Ϊ1,5,6,7,99");
					}
				} else {
					if (!"".equals(fields[i])) {
						if (!"99".equals(fields[i]) && !fields[i].matches("[1,5,6,7]{1}")) {
							throw new Exception("[��Ȧ����]��ʽ���ԣ�ֻ��Ϊ1,5,6,7,99");
						}
					}
				}
				break;
			// �Ƿ�TOP����
			case 72:
				if (!customeFlag) {
					if (!fields[i].matches("[0,1]{1}")) {
						throw new Exception("[�Ƿ�TOP����]��ʽ����,ֻ��Ϊ0,1");
					}
				}else{
					if (!"".equals(fields[i])) {
						if (!fields[i].matches("[0,1]{1}")) {
							throw new Exception("[�Ƿ�TOP����]��ʽ����,ֻ��Ϊ0,1");
						}
					}
				}
				break;
			/* star uppdate for (2013)NBBOSS- D0019 �����Ż���Ҫ���     by feng */
			// �����������
			case 73:
				if (!customeFlag) {
					rewardkind = fields[i];
					if (fields[i] == null || "".equals(fields[i])) {
						throw new Exception("[�����������]����Ϊ��");
					}
					if("0".equals(rewardkind) || "1".equals(rewardkind) || "2".equals(rewardkind)|| "3".equals(rewardkind)){
						if ("0".equals(rewardkind) && 0==wbVO.getRewardkind()){
							if ("7".equals(starlevel) || ("7".equals(wayVO.getStarlevel()) && (null == starlevel || "".equals(starlevel)))){
								throw new Exception(exceptionMsg);
							}
							if ("8".equals(starlevel) || ("8".equals(wayVO.getStarlevel()) && (null == starlevel || "".equals(starlevel)))){
								throw new Exception(exceptionMsg);
							}
							if ("9".equals(starlevel) || ("9".equals(wayVO.getStarlevel()) && (null == starlevel || "".equals(starlevel)))){
								throw new Exception(exceptionMsg);
							}
							if (!"".equals(fields[75]) || !"".equals(fields[76])){
								fields[75]=null;
								fields[76]=null;
								wayVO.setWaymod(null);
								wayVO.setWayattr(null);
								}
						}else if ("0".equals(rewardkind) && 1==wbVO.getRewardkind()){//3Gת2G
							if ("7".equals(starlevel) || ("7".equals(wayVO.getStarlevel()) && (null == starlevel || "".equals(starlevel)))){
								throw new Exception("������Ϊ3G����ת��Ϊ2G���������ϴ�1-6�Ǽ�ֵ");
							}
							if ("8".equals(starlevel) || ("8".equals(wayVO.getStarlevel()) && (null == starlevel || "".equals(starlevel)))){
								throw new Exception("������Ϊ3G����ת��Ϊ2G���������ϴ�1-6�Ǽ�ֵ");
							}
							if ("9".equals(starlevel) || ("9".equals(wayVO.getStarlevel()) && (null == starlevel || "".equals(starlevel)))){
								throw new Exception("������Ϊ3G����ת��Ϊ2G���������ϴ�1-6�Ǽ�ֵ");
							}
							if ((fields[75] != null && !"".equals(fields[75])) || (fields[76] != null && !"".equals(fields[76]))){
								fields[75]=null;
								fields[76]=null;
								wayVO.setWaymod(null);
								wayVO.setWayattr(null);
								}
						}else if ("0".equals(rewardkind) && 2==wbVO.getRewardkind()){//������������ת2G
							if ("8".equals(starlevel) || ("8".equals(wayVO.getStarlevel()) && (null == starlevel || "".equals(starlevel)))){
								throw new Exception("������Ϊ������������ת2G���������ϴ�1-6�Ǽ�ֵ");
							}
							if ("9".equals(starlevel) || ("9".equals(wayVO.getStarlevel()) && (null == starlevel || "".equals(starlevel)))){
								throw new Exception("������Ϊ������������ת2G���������ϴ�1-6�Ǽ�ֵ");
							}
							
						}else if ("1".equals(rewardkind) && 0==wbVO.getRewardkind()){//2Gת3G
							if (!"7".equals(starlevel) && !"7".equals(wayVO.getStarlevel())){
								throw new Exception("������Ϊ2G����ת��Ϊ3G���������ϴ�3G����ר���Ǽ�");
							}
							if ("".equals(fields[75]) || null == fields[75] || "".equals(fields[76]) || null == fields[76]){
								throw new Exception("������Ϊ2G����ת3G������������ϴ�����������������ԡ����������������ϵ����2������ֵ");
								}
							if ("A+1".equals(fields[75])){
								throw new Exception("������Ϊ2G����ת��Ϊ3G������ֻ��4G�������������������Բ���ΪA+1 (רӪ��Ҫ��Ȧ)");
							}
							if (!"DG".equals(fields[7]) || !"DG".equals(wayVO.getCityid())){
								if("2Q".equals(fields[75]) || "3Q".equals(fields[75]) || "4Q".equals(fields[75]) || "A3".equals(fields[75]) || "B3".equals(fields[75]) || "C3".equals(fields[75])){
				                	//�ˡ�'+wayattr+'������������������Ϊ��ݸ����ר�ã���ѡ����������������������
									throw new Exception("�ˡ�"+fields[75]+"������������������Ϊ��ݸ����ר�ã���ѡ����������������������");
								}
							}
						}else if ("1".equals(rewardkind) && 1==wbVO.getRewardkind()){//3Gת3GҪ�ж��Ǽ�
							if (!"7".equals(starlevel) && !"7".equals(wayVO.getStarlevel())){
								throw new Exception("������Ϊ3G���������ϴ�3G����ר���Ǽ�");
							}
							if ("A+1".equals(fields[75])){
								throw new Exception("������Ϊ3G������ֻ��4G�������������������Բ���ΪA+1 (רӪ��Ҫ��Ȧ)");
							}
							if (!"DG".equals(fields[7]) || !"DG".equals(wayVO.getCityid())){
								if("2Q".equals(fields[75]) || "3Q".equals(fields[75]) || "4Q".equals(fields[75]) || "A3".equals(fields[75]) || "B3".equals(fields[75]) || "C3".equals(fields[75])){
				                	//�ˡ�'+wayattr+'������������������Ϊ��ݸ����ר�ã���ѡ����������������������
									throw new Exception("�ˡ�"+fields[75]+"������������������Ϊ��ݸ����ר�ã���ѡ����������������������");
								}
							}
							
						}else if ("1".equals(rewardkind) && 2==wbVO.getRewardkind()){//������������ת3G
							if (!"7".equals(starlevel) && !"7".equals(wayVO.getStarlevel())){
								throw new Exception("������Ϊ������������ת3G���������ϴ�3G����ר���Ǽ�");
							}
							if ("".equals(fields[75]) || null == fields[75] || "".equals(fields[76]) || null == fields[76]){
								throw new Exception("������Ϊ������������ת3G������������ϴ�����������������ԡ����������������ϵ����2������ֵ");
								}
							if ("A+1".equals(fields[75])){
								throw new Exception("������Ϊ������������ת3G������ֻ��4G�������������������Բ���ΪA+1 (רӪ��Ҫ��Ȧ)");
							}
							if (!"DG".equals(fields[7]) || !"DG".equals(wayVO.getCityid())){
								if("2Q".equals(fields[75]) || "3Q".equals(fields[75]) || "4Q".equals(fields[75]) || "A3".equals(fields[75]) || "B3".equals(fields[75]) || "C3".equals(fields[75])){
				                	//�ˡ�'+wayattr+'������������������Ϊ��ݸ����ר�ã���ѡ����������������������
									throw new Exception("�ˡ�"+fields[75]+"������������������Ϊ��ݸ����ר�ã���ѡ����������������������");
								}
							}
						}else if ("2".equals(rewardkind) && 0==wbVO.getRewardkind()){//�������ɡ�2G��������ɡ���������������
							if (!"8".equals(starlevel) && !"8".equals(wayVO.getStarlevel())){
								throw new Exception("������Ϊ2G����ת��Ϊ�����������������ϴ�8�Ǽ�ֵ���������������Ǽ���");
							}
							
						}else if ("2".equals(rewardkind) && 1==wbVO.getRewardkind()){//�������ɡ�3G��������ɡ���������������
							if (!"8".equals(starlevel) && !"8".equals(wayVO.getStarlevel())){
								throw new Exception("������Ϊ3G����ת��Ϊ�����������������ϴ�8�Ǽ�ֵ���������������Ǽ���");
							}
							if (!"".equals(fields[75]) || null != fields[75] || !"".equals(fields[76]) || null != fields[76]){
								fields[75]=null;
								fields[76]=null;
								wayVO.setWaymod(null);
								wayVO.setWayattr(null);
							}
							 
						}else if ("2".equals(rewardkind) && 2==wbVO.getRewardkind()){//�������ɡ�����������������ɡ���������������Ҫ�ж��Ǽ�
							if (!"8".equals(starlevel) && !"8".equals(wayVO.getStarlevel())){
								throw new Exception("������Ϊ�����������������ϴ�8�Ǽ�ֵ���������������Ǽ���");
							}
							if (!"".equals(fields[75]) || null != fields[75] || !"".equals(fields[76]) || null != fields[76]){
								fields[75]=null;
								fields[76]=null;
								wayVO.setWaymod(null);
								wayVO.setWayattr(null);
							}
							 
						}else if ("3".equals(rewardkind) && 0==wbVO.getRewardkind()){//2Gת4G
							if (!"9".equals(starlevel) && !"9".equals(wayVO.getStarlevel())){
								throw new Exception("������Ϊ2G����ת��Ϊ4G���������ϴ�4G����ר���Ǽ�");
							}
							if ("".equals(fields[75]) || null == fields[75] || "".equals(fields[76]) || null == fields[76]){
								throw new Exception("������2G����ת4G������������ϴ�����������������ԡ����������������ϵ����2������ֵ");
							}
//							if (!"A+1".equals(fields[75]) && !"A+1".equals(wayVO.getWayattr())){
//								throw new Exception("������Ϊ2G����ת��Ϊ4G���������������������Ա���ΪA+1 (רӪ��Ҫ��Ȧ)");
//							}
							if (!"DG".equals(fields[7]) || !"DG".equals(wayVO.getCityid())){
								if("2Q".equals(fields[75]) || "3Q".equals(fields[75]) || "4Q".equals(fields[75]) || "A3".equals(fields[75]) || "B3".equals(fields[75]) || "C3".equals(fields[75])){
				                	//�ˡ�'+wayattr+'������������������Ϊ��ݸ����ר�ã���ѡ����������������������
									throw new Exception("�ˡ�"+fields[75]+"������������������Ϊ��ݸ����ר�ã���ѡ����������������������");
								}
							}
						}else if ("3".equals(rewardkind) && 1==wbVO.getRewardkind()){//3Gת4G
							if (!"9".equals(starlevel) && !"9".equals(wayVO.getStarlevel())){
								throw new Exception("������Ϊ3G����ת��Ϊ4G���������ϴ�4G����ר���Ǽ�");
							}
//							if (!"A+1".equals(fields[75]) && !"A+1".equals(wayVO.getWayattr())){
//								throw new Exception("������Ϊ3G����ת��Ϊ4G���������������������Ա���ΪA+1 (רӪ��Ҫ��Ȧ)");
//							}
							if (!"DG".equals(fields[7]) || !"DG".equals(wayVO.getCityid())){
								if("2Q".equals(fields[75]) || "3Q".equals(fields[75]) || "4Q".equals(fields[75]) || "A3".equals(fields[75]) || "B3".equals(fields[75]) || "C3".equals(fields[75])){
				                	//�ˡ�'+wayattr+'������������������Ϊ��ݸ����ר�ã���ѡ����������������������
									throw new Exception("�ˡ�"+fields[75]+"������������������Ϊ��ݸ����ר�ã���ѡ����������������������");
								}
							}
							
						}else if ("3".equals(rewardkind) && 2==wbVO.getRewardkind()){//������������ת4G
							if (!"9".equals(starlevel) && !"9".equals(wayVO.getStarlevel())){
								throw new Exception("������Ϊ������������ת��Ϊ4G���������ϴ�4G����ר���Ǽ�");
							}
							if ("".equals(fields[75]) || null == fields[75] || "".equals(fields[76]) || null == fields[76]){
								throw new Exception("������������������ת4G������������ϴ�����������������ԡ����������������ϵ����2������ֵ");
								}
//							if (!"A+1".equals(fields[75]) && !"A+1".equals(wayVO.getWayattr())){
//								throw new Exception("������Ϊ������������ת4G���������������������Ա���ΪA+1 (רӪ��Ҫ��Ȧ)");
//							}
							if (!"DG".equals(fields[7]) || !"DG".equals(wayVO.getCityid())){
								if("2Q".equals(fields[75]) || "3Q".equals(fields[75]) || "4Q".equals(fields[75]) || "A3".equals(fields[75]) || "B3".equals(fields[75]) || "C3".equals(fields[75])){
				                	//�ˡ�'+wayattr+'������������������Ϊ��ݸ����ר�ã���ѡ����������������������
									throw new Exception("�ˡ�"+fields[75]+"������������������Ϊ��ݸ����ר�ã���ѡ����������������������");
								}
							}
						}else if ("3".equals(rewardkind) && 3==wbVO.getRewardkind()){//4Gת4GҪ�ж��Ǽ�
							if (!"9".equals(starlevel) && !"9".equals(wayVO.getStarlevel())){
								throw new Exception("������Ϊ4G���������ϴ�4G����ר���Ǽ�");
							}
							if ("".equals(fields[75]) || null == fields[75] || "".equals(fields[76]) || null == fields[76]){
								throw new Exception("������Ϊ2G����ת4G������������ϴ�����������������ԡ����������������ϵ����2������ֵ");
								}
//							if (!"A+1".equals(fields[75]) && !"A+1".equals(wayVO.getWayattr())){
//								throw new Exception("������Ϊ4G���������������������Ա���ΪA+1 (רӪ��Ҫ��Ȧ)");
//							}
							if (!"DG".equals(fields[7]) || !"DG".equals(wayVO.getCityid())){
								if("2Q".equals(fields[75]) || "3Q".equals(fields[75]) || "4Q".equals(fields[75]) || "A3".equals(fields[75]) || "B3".equals(fields[75]) || "C3".equals(fields[75])){
				                	//�ˡ�'+wayattr+'������������������Ϊ��ݸ����ר�ã���ѡ����������������������
									throw new Exception("�ˡ�"+fields[75]+"������������������Ϊ��ݸ����ר�ã���ѡ����������������������");
								}
							}
						}else if ("0".equals(rewardkind) && 3==wbVO.getRewardkind()){//4Gת2G
							if ("7".equals(starlevel) || ("7".equals(wayVO.getStarlevel()) && (null == starlevel || "".equals(starlevel)))){
								throw new Exception("������Ϊ4G����ת��Ϊ2G���������ϴ�1-6�Ǽ�ֵ");
							}
							if ("8".equals(starlevel) || ("8".equals(wayVO.getStarlevel()) && (null == starlevel || "".equals(starlevel)))){
								throw new Exception("������Ϊ4G����ת��Ϊ2G���������ϴ�1-6�Ǽ�ֵ");
							}
							if ("9".equals(starlevel) || ("9".equals(wayVO.getStarlevel()) && (null == starlevel || "".equals(starlevel)))){
								throw new Exception("������Ϊ4G����ת��Ϊ2G���������ϴ�1-6�Ǽ�ֵ");
							}
							if ((fields[75] != null && !"".equals(fields[75])) || (fields[76] != null && !"".equals(fields[76]))){
								fields[75]=null;
								fields[76]=null;
								wayVO.setWaymod(null);
								wayVO.setWayattr(null);
							}
						}else if ("1".equals(rewardkind) && 3==wbVO.getRewardkind()){//4Gת3G
							if (!"7".equals(starlevel) && !"7".equals(wayVO.getStarlevel())){
								throw new Exception("������Ϊ4G����ת3G���������ϴ�3G����ר���Ǽ�");
							}
							if ("".equals(fields[75]) || null == fields[75] || "".equals(fields[76]) || null == fields[76]){
								throw new Exception("������������ת3G������������ϴ�����������������ԡ����������������ϵ����2������ֵ");
							}
							if ("A+1".equals(fields[75])){
								throw new Exception("������Ϊ4G����ת3G������ֻ��4G�������������������Բ���ΪA+1 (רӪ��Ҫ��Ȧ)");
							}
							if (!"DG".equals(fields[7]) || !"DG".equals(wayVO.getCityid())){
								if("2Q".equals(fields[75]) || "3Q".equals(fields[75]) || "4Q".equals(fields[75]) || "A3".equals(fields[75]) || "B3".equals(fields[75]) || "C3".equals(fields[75])){
				                	//�ˡ�'+wayattr+'������������������Ϊ��ݸ����ר�ã���ѡ����������������������
									throw new Exception("�ˡ�"+fields[75]+"������������������Ϊ��ݸ����ר�ã���ѡ����������������������");
								}
							}
						}else if ("2".equals(rewardkind) && 3==wbVO.getRewardkind()){//4Gת������������
							if (!"8".equals(starlevel) && !"8".equals(wayVO.getStarlevel())){
								throw new Exception("������Ϊ4G����ת�����������������ϴ�������������ר���Ǽ�");
							}
							if ((fields[75] != null && !"".equals(fields[75])) || (fields[76] != null && !"".equals(fields[76]))){
								fields[75]=null;
								fields[76]=null;
								wayVO.setWaymod(null);
								wayVO.setWayattr(null);
							}
						}
//						}else{
//							if (!"7".equals(starlevel) && !"7".equals(wayVO.getStarlevel())){
//								throw new Exception("������Ϊ3G���������ϴ�3G����ר���Ǽ�");
//							}if (!"8".equals(starlevel) && !"8".equals(wayVO.getStarlevel())){
//								throw new Exception("������Ϊת�����������������ϴ�����������ר���Ǽ�");
//							}if (!"9".equals(starlevel) && !"9".equals(wayVO.getStarlevel())){
//								throw new Exception("������Ϊ4G����ת�����������������ϴ�4G����ר���Ǽ�");
//							}
//						}
					}else{
						throw new Exception("����������Ͳ�����");
					}
				}else{
					rewardkind = fields[i];					
					if(rewardkind != null && !"".equals(rewardkind)){
						if("0".equals(rewardkind) || "1".equals(rewardkind) || "2".equals(rewardkind) || "3".equals(rewardkind)){
							if ("0".equals(rewardkind) && 0==wbVO.getRewardkind()){
								if ("7".equals(starlevel) || ("7".equals(wayVO.getStarlevel()) && (null == starlevel || "".equals(starlevel)))){
									throw new Exception("������Ϊ2G���������ϴ�1-6�Ǽ�ֵ");
								}
								if ("8".equals(starlevel) || ("8".equals(wayVO.getStarlevel()) && (null == starlevel || "".equals(starlevel)))){
									throw new Exception("������Ϊ2G���������ϴ�1-6�Ǽ�ֵ");
								}
								if ("9".equals(starlevel) || ("9".equals(wayVO.getStarlevel()) && (null == starlevel || "".equals(starlevel)))){
									throw new Exception("������Ϊ2G���������ϴ�1-6�Ǽ�ֵ");
								}
								if (!"".equals(fields[75]) || !"".equals(fields[76])){
									fields[75]=null;
									fields[76]=null;
									wayVO.setWaymod(null);
									wayVO.setWayattr(null);
								}
							}else if ("0".equals(rewardkind) && 1==wbVO.getRewardkind()){//3Gת2G
								if ("7".equals(starlevel) || ("7".equals(wayVO.getStarlevel()) && (null == starlevel || "".equals(starlevel)))){
									throw new Exception("������Ϊ3G����ת��Ϊ2G���������ϴ�1-6�Ǽ�ֵ");
								}
								if ("8".equals(starlevel) || ("8".equals(wayVO.getStarlevel()) && (null == starlevel || "".equals(starlevel)))){
									throw new Exception("������Ϊ3G����ת��Ϊ2G���������ϴ�1-6�Ǽ�ֵ");
								}
								if ("9".equals(starlevel) || ("9".equals(wayVO.getStarlevel()) && (null == starlevel || "".equals(starlevel)))){
									throw new Exception("������Ϊ3G����ת��Ϊ2G���������ϴ�1-6�Ǽ�ֵ");
								}
								if ((fields[75] != null && !"".equals(fields[75])) || (fields[76] != null && !"".equals(fields[76]))){
									fields[75]=null;
									fields[76]=null;
									wayVO.setWaymod(null);
									wayVO.setWayattr(null);
									}
							}else if ("0".equals(rewardkind) && 2==wbVO.getRewardkind()){//������������ת2G
								if ("8".equals(starlevel) || ("8".equals(wayVO.getStarlevel()) && (null == starlevel || "".equals(starlevel)))){
									throw new Exception("������Ϊ������������ת2G���������ϴ�1-6�Ǽ�ֵ");
								}
								if ("7".equals(starlevel) || ("7".equals(wayVO.getStarlevel()) && (null == starlevel || "".equals(starlevel)))){
									throw new Exception("������Ϊ������������ת2G���������ϴ�1-6�Ǽ�ֵ");
								}
								if ("9".equals(starlevel) || ("9".equals(wayVO.getStarlevel()) && (null == starlevel || "".equals(starlevel)))){
									throw new Exception("������Ϊ������������ת2G���������ϴ�1-6�Ǽ�ֵ");
								}
								if ((fields[75] != null && !"".equals(fields[75])) || (fields[76] != null && !"".equals(fields[76]))){
									fields[75]=null;
									fields[76]=null;
									wayVO.setWaymod(null);
									wayVO.setWayattr(null);
									}
								
							}else if ("1".equals(rewardkind) && 0==wbVO.getRewardkind()){//2Gת3G
								if (!"7".equals(starlevel) && wayVO.getStarlevel()!=7){
									throw new Exception("������Ϊ2G����ת��Ϊ3G���������ϴ�3G����ר���Ǽ�");
								}
								if ("".equals(fields[75]) || null == fields[75] || "".equals(fields[76]) || null == fields[76]){
									throw new Exception("������2G����ת3G������������ϴ�����������������ԡ����������������ϵ����2������ֵ");
								}
								if ("A+1".equals(fields[75])){
									throw new Exception("������Ϊ2G����ת3G������ֻ��4G�������������������Բ���ΪA+1 (רӪ��Ҫ��Ȧ)");
								}
								if (!"DG".equals(fields[7]) || !"DG".equals(wayVO.getCityid())){
									if("2Q".equals(fields[75]) || "3Q".equals(fields[75]) || "4Q".equals(fields[75]) || "A3".equals(fields[75]) || "B3".equals(fields[75]) || "C3".equals(fields[75])){
					                	//�ˡ�'+wayattr+'������������������Ϊ��ݸ����ר�ã���ѡ����������������������
										throw new Exception("�ˡ�"+fields[75]+"������������������Ϊ��ݸ����ר�ã���ѡ����������������������");
									}
								}
							}else if ("1".equals(rewardkind) && 1==wbVO.getRewardkind()){//3Gת3G
								if (!"7".equals(starlevel) && !"7".equals(wayVO.getStarlevel())){
									throw new Exception("������Ϊ3G���������ϴ�3G����ר���Ǽ�");
								}
								if ("A+1".equals(fields[75])){
									throw new Exception("������Ϊ3G������ֻ��4G�������������������Բ���ΪA+1 (רӪ��Ҫ��Ȧ)");
								}
								if (!"DG".equals(fields[7]) || !"DG".equals(wayVO.getCityid())){
									if("2Q".equals(fields[75]) || "3Q".equals(fields[75]) || "4Q".equals(fields[75]) || "A3".equals(fields[75]) || "B3".equals(fields[75]) || "C3".equals(fields[75])){
					                	//�ˡ�'+wayattr+'������������������Ϊ��ݸ����ר�ã���ѡ����������������������
										throw new Exception("�ˡ�"+fields[75]+"������������������Ϊ��ݸ����ר�ã���ѡ����������������������");
									}
								}
							}else if ("1".equals(rewardkind) && 2==wbVO.getRewardkind()){//������������ת3G
								if (!"7".equals(starlevel) && !"7".equals(wayVO.getStarlevel())){
									throw new Exception("������Ϊ������������ת3G���������ϴ�3G����ר���Ǽ�");
								}
								if ("".equals(fields[75]) || null == fields[75] || "".equals(fields[76]) || null == fields[76]){
									throw new Exception("������������ת3G������������ϴ�����������������ԡ����������������ϵ����2������ֵ");
								}
								if ("A+1".equals(fields[75])){
									throw new Exception("������Ϊ������������ת3G������ֻ��4G�������������������Բ���ΪA+1 (רӪ��Ҫ��Ȧ)");
								}
								if (!"DG".equals(fields[7]) || !"DG".equals(wayVO.getCityid())){
									if("2Q".equals(fields[75]) || "3Q".equals(fields[75]) || "4Q".equals(fields[75]) || "A3".equals(fields[75]) || "B3".equals(fields[75]) || "C3".equals(fields[75])){
					                	//�ˡ�'+wayattr+'������������������Ϊ��ݸ����ר�ã���ѡ����������������������
										throw new Exception("�ˡ�"+fields[75]+"������������������Ϊ��ݸ����ר�ã���ѡ����������������������");
									}
								}
							}else if ("2".equals(rewardkind) && 0==wbVO.getRewardkind()){//2Gת������������
								
								if (!"8".equals(starlevel) && !"8".equals(wayVO.getStarlevel())){
									throw new Exception("������Ϊ2G����ת��Ϊ�����������������ϴ�8�Ǽ�ֵ���������������Ǽ���");
								}
								
							}else if ("2".equals(rewardkind) && 1==wbVO.getRewardkind()){//�������ɡ�3G��������ɡ���������������
								if (!"8".equals(starlevel) && !"8".equals(wayVO.getStarlevel())){
									throw new Exception("������Ϊ3G����ת��Ϊ�����������������ϴ�8�Ǽ�ֵ���������������Ǽ���");
								}
								if (!"".equals(fields[75]) || null != fields[75] || !"".equals(fields[76]) || null != fields[76]){
									fields[75]=null;
									fields[76]=null;
									wayVO.setWaymod(null);
									wayVO.setWayattr(null);
								}
								
							}else if ("2".equals(rewardkind) && 2==wbVO.getRewardkind()){//�������ɡ�����������������ɡ���������������,Ҫ�ж��Ǽ�
								if (!"8".equals(starlevel) && !"8".equals(wayVO.getStarlevel())){
									throw new Exception("������Ϊ�����������������ϴ�8�Ǽ�ֵ���������������Ǽ���");
								}
								
							}else if ("3".equals(rewardkind) && 0==wbVO.getRewardkind()){//2Gת4G
								if (!"9".equals(starlevel) && !"9".equals(wayVO.getStarlevel())){
									throw new Exception("������Ϊ2G����ת��Ϊ4G���������ϴ�4G����ר���Ǽ�");
								}
								if ("".equals(fields[75]) || null == fields[75] || "".equals(fields[76]) || null == fields[76]){
									throw new Exception("������Ϊ2G����ת��Ϊ4G������������ϴ�����������������ԡ����������������ϵ����2������ֵ");
									}
//								if (!"A+1".equals(fields[75]) && !"A+1".equals(wayVO.getWayattr())){
//									throw new Exception("������Ϊ2G����ת��Ϊ4G���������������������Ա���ΪA+1 (רӪ��Ҫ��Ȧ)");
//								}	
								if (!"DG".equals(fields[7]) || !"DG".equals(wayVO.getCityid())){
									if("2Q".equals(fields[75]) || "3Q".equals(fields[75]) || "4Q".equals(fields[75]) || "A3".equals(fields[75]) || "B3".equals(fields[75]) || "C3".equals(fields[75])){
					                	//�ˡ�'+wayattr+'������������������Ϊ��ݸ����ר�ã���ѡ����������������������
										throw new Exception("�ˡ�"+fields[75]+"������������������Ϊ��ݸ����ר�ã���ѡ����������������������");
									}
								}
							}else if ("3".equals(rewardkind) && 1==wbVO.getRewardkind()){//3Gת4G
								if (!"9".equals(starlevel) && !"9".equals(wayVO.getStarlevel())){
									throw new Exception("������Ϊ3G����ת��Ϊ4G���������ϴ�4G����ר���Ǽ�");
								}
//								if (!"A+1".equals(fields[75]) && !"A+1".equals(wayVO.getWayattr())){
//									throw new Exception("������Ϊ3G����ת��Ϊ4G���������������������Ա���ΪA+1 (רӪ��Ҫ��Ȧ)");
//								}
								if (!"DG".equals(fields[7]) || !"DG".equals(wayVO.getCityid())){
									if("2Q".equals(fields[75]) || "3Q".equals(fields[75]) || "4Q".equals(fields[75]) || "A3".equals(fields[75]) || "B3".equals(fields[75]) || "C3".equals(fields[75])){
					                	//�ˡ�'+wayattr+'������������������Ϊ��ݸ����ר�ã���ѡ����������������������
										throw new Exception("�ˡ�"+fields[75]+"������������������Ϊ��ݸ����ר�ã���ѡ����������������������");
									}
								}
							}else if ("3".equals(rewardkind) && 2==wbVO.getRewardkind()){//������������ת4G
								if (!"9".equals(starlevel) && !"9".equals(wayVO.getStarlevel())){
									throw new Exception("������Ϊ������������ת��Ϊ4G���������ϴ�4G����ר���Ǽ�");
								}
								if ("".equals(fields[75]) || null == fields[75] || "".equals(fields[76]) || null == fields[76]){
									throw new Exception("������Ϊ������������ת��Ϊ4G������������ϴ�����������������ԡ����������������ϵ����2������ֵ");
									}
//								if (!"A+1".equals(fields[75]) && !"A+1".equals(wayVO.getWayattr())){
//									throw new Exception("������Ϊ������������ת��Ϊ4G���������������������Ա���ΪA+1 (רӪ��Ҫ��Ȧ)");
//								}
								if (!"DG".equals(fields[7]) || !"DG".equals(wayVO.getCityid())){
									if("2Q".equals(fields[75]) || "3Q".equals(fields[75]) || "4Q".equals(fields[75]) || "A3".equals(fields[75]) || "B3".equals(fields[75]) || "C3".equals(fields[75])){
					                	//�ˡ�'+wayattr+'������������������Ϊ��ݸ����ר�ã���ѡ����������������������
										throw new Exception("�ˡ�"+fields[75]+"������������������Ϊ��ݸ����ר�ã���ѡ����������������������");
									}
								}
							}else if ("3".equals(rewardkind) && 3==wbVO.getRewardkind()){//4Gת4G��Ҫ�ж��Ǽ�
								if (!"9".equals(starlevel) && !"9".equals(wayVO.getStarlevel())){
									throw new Exception("������Ϊ������������ת��Ϊ4G���������ϴ�4G����ר���Ǽ�");
								}
//								if (!"A+1".equals(fields[75]) && !"A+1".equals(wayVO.getWayattr())){
//									throw new Exception("������Ϊ4G���������������������Ա���ΪA+1 (רӪ��Ҫ��Ȧ)");
//								}
								if (!"DG".equals(fields[7]) || !"DG".equals(wayVO.getCityid())){
									if("2Q".equals(fields[75]) || "3Q".equals(fields[75]) || "4Q".equals(fields[75]) || "A3".equals(fields[75]) || "B3".equals(fields[75]) || "C3".equals(fields[75])){
					                	//�ˡ�'+wayattr+'������������������Ϊ��ݸ����ר�ã���ѡ����������������������
										throw new Exception("�ˡ�"+fields[75]+"������������������Ϊ��ݸ����ר�ã���ѡ����������������������");
									}
								}
							}else if ("0".equals(rewardkind) && 3==wbVO.getRewardkind()){//4Gת2G
								if ("7".equals(starlevel) || ("7".equals(wayVO.getStarlevel()) && (null == starlevel || "".equals(starlevel)))){
									throw new Exception("������Ϊ4G����ת��Ϊ2G���������ϴ�1-6�Ǽ�ֵ");
								}
								if ("8".equals(starlevel) || ("8".equals(wayVO.getStarlevel()) && (null == starlevel || "".equals(starlevel)))){
									throw new Exception("������Ϊ4G����ת��Ϊ2G���������ϴ�1-6�Ǽ�ֵ");
								}
								if ("9".equals(starlevel) || ("9".equals(wayVO.getStarlevel()) && (null == starlevel || "".equals(starlevel)))){
									throw new Exception("������Ϊ4G����ת��Ϊ2G���������ϴ�1-6�Ǽ�ֵ");
								}
								if ((fields[75] != null && !"".equals(fields[75])) || (fields[76] != null && !"".equals(fields[76]))){
									fields[75]=null;
									fields[76]=null;
									wayVO.setWaymod(null);
									wayVO.setWayattr(null);	
									}
							}else if ("1".equals(rewardkind) && 3==wbVO.getRewardkind()){//4Gת3G
								if (!"7".equals(starlevel) && !"7".equals(wayVO.getStarlevel())){
									throw new Exception("������Ϊ4G����ת3G���������ϴ�3G����ר���Ǽ�");
								}
								if ("A+1".equals(fields[75])){
									throw new Exception("������Ϊ4G����ת3G������ֻ��4G�������������������Բ���ΪA+1 (רӪ��Ҫ��Ȧ)");
								}
								if (!"DG".equals(fields[7]) || !"DG".equals(wayVO.getCityid())){
									if("2Q".equals(fields[75]) || "3Q".equals(fields[75]) || "4Q".equals(fields[75]) || "A3".equals(fields[75]) || "B3".equals(fields[75]) || "C3".equals(fields[75])){
					                	//�ˡ�'+wayattr+'������������������Ϊ��ݸ����ר�ã���ѡ����������������������
										throw new Exception("�ˡ�"+fields[75]+"������������������Ϊ��ݸ����ר�ã���ѡ����������������������");
									}
								}
							}else if ("2".equals(rewardkind) && 3==wbVO.getRewardkind()){//4Gת������������
								if (!"8".equals(starlevel) && !"8".equals(wayVO.getStarlevel())){
									throw new Exception("������Ϊ4G����ת�����������������ϴ�������������ר���Ǽ�");
								}
								if ((fields[75] != null && !"".equals(fields[75])) || (fields[76] != null && !"".equals(fields[76]))){
									fields[75]=null;
									fields[76]=null;
									wayVO.setWaymod(null);
									wayVO.setWayattr(null);
								}
							}
//							else{
//								if (!"7".equals(starlevel) && !"7".equals(wayVO.getStarlevel())){
//									throw new Exception("������Ϊ3G���������ϴ�3G����ר���Ǽ�");
//								}if (!"8".equals(starlevel) && !"8".equals(wayVO.getStarlevel())){
//									throw new Exception("������Ϊ�����������������ϴ�������������ר���Ǽ�");
//								}if (!"9".equals(starlevel) && !"9".equals(wayVO.getStarlevel())){
//									throw new Exception("������Ϊ4G���������ϴ�4G����ר���Ǽ�");
//								}
//							}
						}else{
							throw new Exception("����������Ͳ�����");
						}
					}
				}
				break;
			// ������Ȧ����
			case 74:
				if (fields[i] == null || "".equals(fields[i])) {
					if (!customeFlag) {
						throw new Exception("[������Ȧ����]����Ϊ��");
					}
				} else {
					Busicircle busicircle = (Busicircle) BOFactory.build(BusicircleBO.class, user);
					BusicircleVO busicircleVO = busicircle.doFindByPk(fields[i]);
					if (null == busicircleVO) {
						throw new Exception("[������Ȧ����]������Ч������Ȧ����ֵ������");
					}
				}
				break;
			// ����������������
			case 75:
				if("1".equals(rewardkind) && 1==wbVO.getRewardkind()){
					if (fields[i] == null || "".equals(fields[i])) {
						throw new Exception("[����������������]����Ϊ��");
					}else{
						Dictitem dictitem = (Dictitem) BOFactory.build(DictitemBO.class, user);
						DictitemVO vo = new DictitemVO();
						vo.setGroupid("CH_WAYATTR");
						vo.setDictid(fields[75]);
						if (dictitem.doFindByPk(vo) == null) {
							throw new Exception("[����������������]ֵ�������ڣ���������Ч������������������ֵ");
						}
					}
					
						if ("A+1".equals(fields[i])){
							throw new Exception("������Ϊ3G������ֻ��4G�������������������Բ���ΪA+1 (רӪ��Ҫ��Ȧ)");
						}
						if (!"DG".equals(fields[7]) || !"DG".equals(wayVO.getCityid())){
							if("2Q".equals(fields[i]) || "3Q".equals(fields[i]) || "4Q".equals(fields[i]) || "A3".equals(fields[i]) || "B3".equals(fields[i]) || "C3".equals(fields[i])){
			                	//�ˡ�'+wayattr+'������������������Ϊ��ݸ����ר�ã���ѡ����������������������
								throw new Exception("�ˡ�"+fields[75]+"������������������Ϊ��ݸ����ר�ã���ѡ����������������������");
							}
						}
					
				}else if("2".equals(rewardkind) && 0==wbVO.getRewardkind()){
					if (fields[i] != null && !"".equals(fields[i])) {
						throw new Exception("����������������Ҫ�ϴ�����������������ԡ��������������ϵ����������ֵ�������޸ĳ�3G/4G����������ͬʱ�ṩ���Ǽ�����������������͡��������������������ԡ�����������������ϵ����������ֵ");
					}
				}else if("3".equals(rewardkind)){
					if (fields[i] == null || "".equals(fields[i])) {
						throw new Exception("[����������������]����Ϊ��");
					}else{
						Dictitem dictitem = (Dictitem) BOFactory.build(DictitemBO.class, user);
						DictitemVO vo = new DictitemVO();
						vo.setGroupid("CH_WAYATTR");
						vo.setDictid(fields[75]);
						if (dictitem.doFindByPk(vo) == null) {
							throw new Exception("[����������������]ֵ�������ڣ���������Ч������������������ֵ");
						}
					}
				}else if((null==rewardkind || "".equals(rewardkind)) && 0==wbVO.getRewardkind()){
					if (fields[i] != null && !"".equals(fields[i])) {
						throw new Exception("2G��������Ҫ�ϴ�����������������ԡ��������������ϵ����������ֵ�������޸ĳ�3G/4G����������ͬʱ�ṩ���Ǽ�����������������͡��������������������ԡ�����������������ϵ����������ֵ");
					}
				}
				break;
			// ������������ϵ��
			case 76:
				if("1".equals(rewardkind)){
					if (fields[i] == null || "".equals(fields[i])) {
						throw new Exception("[������������ϵ��]����Ϊ��");
					}
				}else if("2".equals(rewardkind)){
					if (fields[i] != null && !"".equals(fields[i])) {
						throw new Exception("����������������Ҫ�ϴ�����������������ԡ��������������ϵ����������ֵ�������޸ĳ�3G/4G����������ͬʱ�ṩ���Ǽ�����������������͡��������������������ԡ�����������������ϵ����������ֵ");
					}
				}else if("3".equals(rewardkind)){
					if (fields[i] == null && "".equals(fields[i])) {
						throw new Exception("[������������ϵ��]����Ϊ��");					}
				}else if((null==rewardkind || "".equals(rewardkind)) && 0==wbVO.getRewardkind()){
					if (fields[i] != null && !"".equals(fields[i])) {
						throw new Exception("2G��������Ҫ�ϴ�����������������ԡ��������������ϵ����������ֵ�������޸ĳ�3G/4G����������ͬʱ�ṩ���Ǽ�����������������͡��������������������ԡ�����������������ϵ����������ֵ");
					}
				}
				break;
			// ���õȼ�
			case 77:
				if (fields[i] == null || "".equals(fields[i])) {
					if (!customeFlag) {
						throw new Exception("[���õȼ�]����Ϊ��");
					}
				}else{
					Dictitem dictitem = (Dictitem) BOFactory.build(DictitemBO.class, user);
					DictitemVO vo = new DictitemVO();
					vo.setGroupid("CH_CREDITLEVEL");
					vo.setDictid(fields[77]); 
					if (dictitem.doFindByPk(vo) == null) {
						throw new Exception("[���õȼ�]��ʽ����,ֻ��Ϊ0��1��2");
					}
				}
				break;
			// ˰������
			case 78:
				if (fields[i] == null || "".equals(fields[i])) {
					if (!customeFlag) {
						throw new Exception("[˰������]����Ϊ��");
					}
				} else {
					Dictitem dictitem = (Dictitem) BOFactory.build(DictitemBO.class, user);
					DictitemVO vo = new DictitemVO();
					vo.setGroupid("CH_TAXCERTIFICATE");
					vo.setDictid(fields[78]);
					if (dictitem.doFindByPk(vo) == null) {
						throw new Exception("[˰������]ֵֻ����0��С��ģ��˰�ˣ���1��һ����˰�ˣ���2��������3������");
					}
				}
				break;
			// �Ƿ���Ȩ����
			case 79:
				if (fields[i] == null || "".equals(fields[i])) {
					if (!customeFlag) {
						throw new Exception("[�Ƿ���Ȩ����]����Ϊ��");
					}
				} else {
					if (!fields[i].trim().equals("Y") && !fields[i].trim().equals("N")) {
						throw new Exception("[�Ƿ���Ȩ����]ֵֻ����N���񣩡�Y���ǣ�2������");
					}
				}
				break;
			/* ��ע���ڱ�ע��Ϣ��ÿ�����������ֶν��䱣�ַ������лл     by feng */
			// ��ע
			case 80:
				if ("1".equals(param75)) {
					if ("0".equals(fields[6])) {
						if (fields[i] == null || "".equals(fields[i])) {
							throw new Exception("�����˳�ʱ��[��ע]����Ϊ�գ���Ҫ��д�˳�ԭ��");
						}else if (fields[i].getBytes().length>512) {
							throw new Exception("�����˳�ʱ��[��ע]���ݳ��Ȳ��ܳ������ݿⴢ�泤��");
						}
					} 
				} 
				break;
			/* end uppdate for (2013)NBBOSS- D0019 �����Ż���Ҫ���     by feng */
			}
		}
	}

	private void checkParameter(String[] fields, User user) throws Exception {
		Dictitem delegate = (Dictitem) BOFactory.build(DictitemBO.class, user);
		DictitemVO vo = new DictitemVO();
		if (!"".equals(fields[32]) && !"null".equals(fields[32])
				&& !"��".equals(fields[32])) {
			// ǩԼ����
			vo.setGroupid("CH_COMPACTTYPE");
			vo.setDictid(fields[32]);
			if (delegate.doFindByPk(vo) == null) {
				throw new Exception("�Ƿ�ǩԼ���ͣ���ο�˵��");
			}
		}
		if (!"".equals(fields[41]) && !"null".equals(fields[41])
				&& !"��".equals(fields[41])) {
			// ��֤��Ѻ��״̬
			vo.setGroupid("CH_BAILSTATUS");
			vo.setDictid(fields[41]);
			if (delegate.doFindByPk(vo) == null) {
				throw new Exception("�Ƿ���֤��Ѻ��״̬����ο�˵��");
			}
		}
	}

	private String[] checkLines(String[] fields, User user) throws Exception {
		if (preLineCount != fields.length) {
			throw new Exception("�Զ����ļ�ͷ������������������һ��!");
		}
		// ϵͳ������ѯ
		Sysparam sysparam = (Sysparam)BOFactory.build(SysparamBO.class, user);
		String paramvalue = sysparam.doFindByID(new Long("75"), "channel");
		if ("1".equals(paramvalue)) {
			int cnt = StringUtils.countMatches(lineHead1, "|");
			String checkLine[] = new String[cnt + 1];
			return copyArr(checkLine, resultStr, fields);
		} else {
			int cnt = StringUtils.countMatches(lineHead, "|");
			String checkLine[] = new String[cnt + 1];
			return copyArr(checkLine, resultStr, fields);
		}
		// for(int i=0;i<ccc.length;i++)
		// {
		// System.out.println(i+"_"+ccc[i]);
		// }
	}

	private void checkHead(String[] fields, User user) throws Exception {
		preLineCount = fields.length;
		// ��ս�����ϴμ��Ľ��
		this.resultStr = "";
		for (int i = 0; i < fields.length; i++) {
			boolean find = false;

			if (("1".equals(param75))) {
				for (int k = 0; k < lineArr1.length; k++) {
					if ("".equals(fields[i])) {
						throw new Exception("�Զ����ļ�ͷ�в������п�,�����һ��û������");
					}
					if (fields[i].equals(lineArr1[k])) {
						resultStr = resultStr + k + "|";
						find = true;
						continue;
					}
				}
			} else {
				for (int k = 0; k < lineArr.length; k++) {
					if ("".equals(fields[i])) {
						throw new Exception("�Զ����ļ�ͷ�в������п�,�����һ��û������");
					}
					if (fields[i].equals(lineArr[k])) {
						resultStr = resultStr + k + "|";
						find = true;
						continue;
					}
				}
			}

			if (!find) {
				throw new Exception("�Զ����ļ�ͷ:" + fields[i] + "����ȷ!");
			}
		}
	}

	private String[] copyArr(String arr[], String str, String fields[]) {
		String temArr[] = StringUtils.splitPreserveAllTokens(str, "|");
		for (int i = 0; i < temArr.length - 1; i++) {
			int temp = -1;
			temp = new Integer(temArr[i]).intValue();
			arr[temp] = fields[i];
		}
		// ��nullֵת����""
		for (int i = 0; i < arr.length; i++) {
			arr[i] = arr[i] == null ? "" : arr[i];
		}
		return arr;
	}

	private void checkUppserwayid(String wayid) throws Exception {
		Way way = (Way) BOFactory.build(WayBO.class, user);
		WayVO upperVO = way.doFindByPkAndCityid(wayid);
		if (upperVO == null) {
			throw new Exception("�ϼ����������ڻ��Ǳ����е��ϼ�����");
		} else {
			if ("ET".equals(upperVO.getWaytype())) {
				if (!"GMPT".equals(upperVO.getWaysubtype())
						&& !"G100".equals(upperVO.getWaysubtype())

				) {
					throw new Exception("¼����ϼ�����ֻ����������Ӫ�����̣��ƶ�����/���һ������");
				}
			} else {
				if (!"DIS".equals(upperVO.getWaysubtype())) {
					throw new Exception("������ϼ����������ǳ�[������Ӫ������]֮����������");
				}
			}
		}
	}
}
