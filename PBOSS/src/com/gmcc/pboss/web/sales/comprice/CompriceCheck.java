 package com.gmcc.pboss.web.sales.comprice;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import com.gmcc.pboss.business.base.dictitem.DictitemVO;
import com.gmcc.pboss.business.channel.cntycompany.CntycompanyDBParam;
import com.gmcc.pboss.business.channel.cntycompany.CntycompanyVO;
import com.gmcc.pboss.business.channel.custwaytype.CustwaytypeDBParam;
import com.gmcc.pboss.business.channel.custwaytype.CustwaytypeVO;
import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.gmcc.pboss.control.base.dictitem.Dictitem;
import com.gmcc.pboss.control.base.dictitem.DictitemBO;
import com.gmcc.pboss.control.channel.cntycompany.Cntycompany;
import com.gmcc.pboss.control.channel.cntycompany.CntycompanyBO;
import com.gmcc.pboss.control.channel.custwaytype.Custwaytype;
import com.gmcc.pboss.control.channel.custwaytype.CustwaytypeBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;

public class CompriceCheck extends BaseCheckFormat {

	public void checkFile(File file, HashMap parameterMap, String contentType)
			throws Exception {
		if (!"text/plain".equalsIgnoreCase(contentType)) {
			throw new Exception("Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		}
	}

	public void checkLine(String line, int rowCount, User user)
			throws Exception {

		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		if (content.length != 8) {
			throw new Exception("��" + rowCount + "��:[ " + line
					+ " ] ,��������ȷ,��ȷ����Ϊ7");
		}
		if (StringUtils.isEmpty(content[0])) {
			throw new Exception("��" + rowCount + "��:[ " + line + " ] ,�ֹ�˾����Ϊ��");
		}
		if (StringUtils.isEmpty(content[1])) {
			throw new Exception("��" + rowCount + "��:[ " + line + " ] ,�Ǽ����ܲ���Ϊ��");
		}
		if (StringUtils.isEmpty(content[2])) {
			throw new Exception("��" + rowCount + "��:[ " + line + " ] ,�������Ͳ���Ϊ��");
		}
		if (StringUtils.isEmpty(content[3])) {
			throw new Exception("��" + rowCount + "��:[ " + line + " ] ,��Ʒ���಻��Ϊ��");
		}
		if (StringUtils.isEmpty(content[4])) {
			throw new Exception("��" + rowCount + "��:[ " + line + " ] ,�ۼ����ַ�ʽ����Ϊ��");
		}
		if (StringUtils.isEmpty(content[5])) {
			throw new Exception("��" + rowCount + "��:[ " + line + " ] ,ͳһ�ۼۡ��Թ���˽�ۼۡ����Ƿ��ӡ��Ʊ�ۼ����ַ�ʽ����6�����ݶ�����Ϊ��");
		}
		int pos5 = content[5].trim().indexOf(".");
		
		if (pos5 == -1) { 
			if (content[5].trim().length() > 5)
				throw new Exception("ͳһ�ۼۣ��������ͣ�֧����λС��������λ��󳤶�5λ��С��λ��󳤶�2λ��Ҫ����ڵ���0");
		} else if (pos5 > 5) {
			    throw new Exception("ͳһ�ۼۣ��������ͣ�֧����λС��������λ��󳤶�5λ��С��λ��󳤶�2λ��Ҫ����ڵ���0");
		} else if (content[5].substring(pos5+1,content[5].length()).length()>2){
			    throw new Exception("ͳһ�ۼۣ��������ͣ�֧����λС��������λ��󳤶�5λ��С��λ��󳤶�2λ��Ҫ����ڵ���0");
		}
		checkParameter(content, user);

	}

	/*
	 * 1. ���ϴ�txt�ļ����и�ʽ���ֶ�ֵ��飺 �ֹ�˾������Ϊ�û����е������ֹ�˾ �Ǽ������ݱ���ȡ�Թ̶����� �Ǽ�2��CH_STARLEVEL2��
	 * �������ͣ�������Դ����Ϊ�ֹ�˾�Զ�����������(CH_PW_CUSTWAYTYPE)��ƥ���й�˾��ʶ��CITYCOMPID��Ϊ��ǰ����
	 * ��Ʒ���ࣺ���ݱ���ȡ�Թ̶����� ������Ʒ���ࣨIM_FXCOMCATEGORY�� �ۼ����ַ�ʽ�����ݱ���ȡ�Թ̶�����
	 * ��Ʒ�ۼ����ַ�ʽ��FX_PRICEDIFTYPE�� ͳһ�ۼۣ��������ͣ�֧����λС��������λ��󳤶�5λ��С��λ��󳤶�2λ��Ҫ����ڵ���0
	 * �Թ��ۼ�/��˽�ۼۣ�ͬ�ϡ� ��Ʊ�ۼ�/����Ʊ�ۼۣ�ͬ�ϡ� ע�����ۼ۷�ʽ����������ʱ�������ļ�������������ߣ��������ֶ���Ŀ���ʱͳһ��
	 */

	private void checkParameter(String[] fields, User user) throws Exception {

		Dictitem dictitem = (Dictitem) BOFactory.build(DictitemBO.class, user);
		DictitemVO vo = new DictitemVO();

		if (StringUtils.isNotBlank(fields[0])) {
			// �ֹ�˾
			Cntycompany cntycompany = (Cntycompany) BOFactory.build(
					CntycompanyBO.class, user);
			CntycompanyDBParam cntycompanyDBParam = new CntycompanyDBParam();
			cntycompanyDBParam.set_se_citycompid(user.getCityid());
			cntycompanyDBParam.set_se_countycompid(fields[0]);

			DataPackage dp = cntycompany.doQuery(cntycompanyDBParam);
			List<CntycompanyVO> list = dp.getDatas();

			if (list.isEmpty()) {
				throw new Exception("�Ƿ��ֹ�˾����ο�˵��");
			}
		}

		if (StringUtils.isNotBlank(fields[1])) {
			// �Ǽ�
			vo.setGroupid("CH_STARLEVEL2");
			vo.setDictid(fields[1]);
			if (dictitem.doFindByPk(vo) == null) {
				throw new Exception("�Ƿ��Ǽ�����ο�˵��");
			}
		}

		if (StringUtils.isNotBlank(fields[2])) {
			// ��������

			Custwaytype custwaytype = (Custwaytype) BOFactory.build(
					CustwaytypeBO.class, user);
			CustwaytypeDBParam custwaytypeDBParam = new CustwaytypeDBParam();
			custwaytypeDBParam.set_ne_citycompid(user.getCityid());
			custwaytypeDBParam.set_se_custwaytypecode(fields[2]);

			DataPackage dp = custwaytype.doQuery(custwaytypeDBParam);
			List<CustwaytypeVO> list = dp.getDatas();
			if (list.isEmpty()) {
				throw new Exception("�Ƿ��������ͣ���ο�˵��");
			}
		}

		if (StringUtils.isNotBlank(fields[3])) {
			// ��Ʒ����
			vo.setGroupid("IM_FXCOMCATEGORY");
			vo.setDictid(fields[3]);
			if (dictitem.doFindByPk(vo) == null) {
				throw new Exception("�Ƿ���Ʒ���࣬��ο�˵��");
			}
		}

		if (StringUtils.isNotBlank(fields[4])) {

			vo.setGroupid("FX_PRICEDIFTYPE");
			vo.setDictid(fields[4]);
			DictitemVO dictitemVO = dictitem.doFindByPk(vo);

			// �ۼ����ַ�ʽ
			if (dictitemVO == null) {
				throw new Exception("�Ƿ��ۼ����ַ�ʽ����ο�˵��");
			}

			// ͳһ�ۼ�
			if (("NODIF").equals(dictitemVO.getDictid())) {
				if (StringUtils.isNotBlank(fields[6])) {
					throw new Exception("�����ַ�ʽ�ۼۣ���7�����ݱ���Ϊ�գ�����");
				} 
			}

			// �Թ���˽�ۼ�
			if (("ACCOUNT").equals(dictitemVO.getDictid())) {
				if (StringUtils.isBlank(fields[6])) {
					throw new Exception("�Թ���˽�ۼۣ���7�����ݲ���Ϊ�գ�����");
				}
				if (StringUtils.isNotBlank(fields[6])) {

					int pos6 = fields[6].trim().indexOf(".");
					if (pos6 == -1) {
						if (fields[6].trim().length() > 5)
							throw new Exception(
									"�Թ���˽�ۼۣ��������ͣ�֧����λС��������λ��󳤶�5λ��С��λ��󳤶�2λ��Ҫ����ڵ���0");
					} else if (pos6 > 5 ) {
						   throw new Exception(
								    "�Թ���˽�ۼۣ��������ͣ�֧����λС��������λ��󳤶�5λ��С��λ��󳤶�2λ��Ҫ����ڵ���0");
					} else if (fields[6].substring(pos6+1,fields[6].length()).length()>2) {
						   throw new Exception(
					                "�Թ���˽�ۼۣ��������ͣ�֧����λС��������λ��󳤶�5λ��С��λ��󳤶�2λ��Ҫ����ڵ���0");
					}
				}

			}
			// ���Ƿ��ӡ��Ʊ����
			if (("INVOICE").equals(dictitemVO.getDictid())) {
				if (StringUtils.isBlank(fields[6])) {
					throw new Exception("���Ƿ��ӡ��Ʊ�����ۼۣ���7�в���Ϊ�գ�����");
				}
				if (StringUtils.isNotBlank(fields[6])) {
					int pos6 = fields[6].trim().indexOf(".");
					if (pos6 == -1) {
						if (fields[6].trim().length() > 5)
							throw new Exception(
									"���Ƿ��ӡ��Ʊ���֣��������ͣ�֧����λС��������λ��󳤶�5λ��С��λ��󳤶�2λ��Ҫ����ڵ���0");
					} else if (pos6 > 5 ) {
						    throw new Exception(
								    "���Ƿ��ӡ��Ʊ���֣��������ͣ�֧����λС��������λ��󳤶�5λ��С��λ��󳤶�2λ��Ҫ����ڵ���0");
					} else if (fields[6].substring(pos6+1,fields[6].length()).length()>2) {
						    throw new Exception(
					                 "���Ƿ��ӡ��Ʊ���֣��������ͣ�֧����λС��������λ��󳤶�5λ��С��λ��󳤶�2λ��Ҫ����ڵ���0");
					}  
				}
			}
		}
	}

	private boolean isEmpty(String checkStr) throws Exception {
		if (checkStr != null) {
			return StringUtils.isBlank(checkStr);
		} else {
			throw new Exception("����ַ���Ϊ��!");
		}
	}
}
