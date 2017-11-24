/**
 * auto-generated code
 * Tue Nov 08 11:17:28 CST 2011
 */
package com.gmcc.pboss.web.sales.saleplan;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.base.dictitem.DictitemVO;
import com.gmcc.pboss.business.sales.saleplan.SaleplanDBParam;
import com.gmcc.pboss.business.sales.saleplan.SaleplanVO;
import com.gmcc.pboss.business.sales.salesstd.SalesstdDBParam;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.control.base.dictitem.DictitemBO;
import com.gmcc.pboss.control.sales.saleplan.Saleplan;
import com.gmcc.pboss.web.base.dictitem.DictitemWebParam;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;

/**
 * <p>
 * Title: SaleplanAction
 * </p>;
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author
 * @version 1.0
 */
public class SaleplanAction extends BaseAction {

	public SaleplanAction() {
		super();

		// ���¼��������Ǳ����
		this.setForm(new SaleplanForm());
		this.setParam(new SaleplanDBParam());

		// ָ��VO��
		setClsVO(SaleplanVO.class);
		// ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
		this.pkNameArray = new String[] { "recid" };
		this.setClsControl(Saleplan.class);
		this.setClsQueryParam(SaleplanDBParam.class);

	}

	@Override
	public String doSave() throws Exception {

		SaleplanForm saleplanform = (SaleplanForm) this.getForm();
		saleplanform.setCityid(this.getDBAccessUser().getCityid());
		SaleplanDBParam dbparam = (SaleplanDBParam) this.getParam();
		saleplanform.setComcategory(this.changTypeToTb(saleplanform
				.getComcategory()));
		this.setForm(saleplanform);
		dbparam.set_se_cityid(saleplanform.getCityid());
		
		
		
		//begin ����ֹʱ�� ��Ϊxxxx-xx-xx  23:59:59
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String endDate = format.format(saleplanform.getEnddate())+" 23:59:59";
		DateFormat d2 = DateFormat.getDateTimeInstance();
		Date dd = d2.parse(endDate);
		saleplanform.setEnddate(dd);
		//end
		
		dbparam.set_dnm_begindate(saleplanform.getEnddate().toLocaleString());
		dbparam.set_dnl_enddate(saleplanform.getBegindate().toLocaleString());
		String[] str = saleplanform.getComcategory().split(",");

		DataPackage dp = null;

		String reString = null;

		try {
			dp = (DataPackage) executeDlgMethod(METHOD_TYPE_QUERY, dbparam);
			if (this.CMD.equals("EDIT")) {
				if (dp != null && dp.getDatas() != null) {
					for (Iterator<SaleplanVO> it = dp.getDatas().iterator(); it
							.hasNext();) {
						SaleplanVO saleplanvo = it.next();
						if (saleplanvo.getRecid().toString().equals(saleplanform.getRecid().toString())) {

						} else {
							for (int i = 0; i < str.length; i++) {
								boolean bo = saleplanvo.getComcategory()
										.contains(str[i]);
								if (bo == true) {
									saleplanform.setComcategory(this
											.changTypeToPage(saleplanform
													.getComcategory()));
									throw new Exception("[" + str[i]
											+ "]���Żݷ���["
											+ saleplanvo.getPlancode() + "-"
											+ saleplanvo.getPlanname()
											+ "]���Ѵ��ڣ�����");
								}
							}
						}
					}
				}
				reString = super.doSave();
			} else {
				if (dp != null && dp.getDatas() != null) {
					for (Iterator<SaleplanVO> it = dp.getDatas().iterator(); it
							.hasNext();) {
						SaleplanVO saleplanvo = it.next();
						for (int i = 0; i < str.length; i++) {
							boolean bo = saleplanvo.getComcategory().contains(
									str[i]);
							if (bo == true) {
								saleplanform.setComcategory(this
										.changTypeToPage(saleplanform
												.getComcategory()));
								throw new Exception("[" + str[i] + "]���Żݷ���["
										+ saleplanvo.getPlancode() + "-"
										+ saleplanvo.getPlanname()
										+ "]���Ѵ��ڣ�����");
							}
						}
					}
				}
				reString = super.doSave();
			}
		} catch (Exception e) {
			reString = "content";
			this.addActionMessage(e.getMessage());
		}
		return reString;

	}

	@Override
	public String doEdit() throws Exception {
		((SaleplanDBParam) this.getParam()).set_se_cityid(this.getDBAccessUser()
				.getCityid());
		BaseVO vo = findVOFromDB();
		BaseVO form = getForm();
		BeanUtils.copyProperties(form, vo);
		SaleplanForm saleplanform = (SaleplanForm) form;
		saleplanform.setComcategory(this.changTypeToPage(saleplanform
				.getComcategory()));
		setForm(form);
		this.CMD = WEB_CMD_EDIT;
		return WEB_RESULT_CONTENT;
	}

	@Override
	public String doList() throws Exception {
		((SaleplanDBParam) this.getParam()).set_se_cityid(this.getDBAccessUser()
				.getCityid());
		DataPackage dp = null;
		try {
			dp = (DataPackage) executeDlgMethod(METHOD_TYPE_QUERY, getParam());
			if (dp != null && dp.getDatas() != null) {
				for (Iterator<SaleplanVO> it = dp.getDatas().iterator(); it
						.hasNext();) {
					SaleplanVO saleplanvo = it.next();
					saleplanvo.setComcategory(this.changTypeToPage(saleplanvo
							.getComcategory()));
				}
			}
		} catch (Exception e) {
			this.addActionMessage(e.getMessage());
		}
		setDp(dp);
		return WEB_RESULT_LIST;
	}

	// ����ʱ�����Ʒ�������ת��
	public String changTypeToTb(String comcategory) throws Exception {

		// ������Ʒ������Ϣ
		// ��ѯ��Ʒ������Ϣ
		DictitemWebParam dictitemwebparam = new DictitemWebParam();
		DictitemBO dictitembo = (DictitemBO) BOFactory.build(DictitemBO.class,
				this.getDBAccessUser());
		dictitemwebparam.set_se_groupid("IM_FXCOMCATEGORY");
		ArrayList dictitemformlist2 = (ArrayList) (dictitembo
				.doQuery(dictitemwebparam).getDatas());

		StringBuffer sru = new StringBuffer();
		String scct[] = comcategory.split(",");
		for (int i = 0; i < scct.length; i++) {
			String svalue = scct[i].trim();
			for (int j = 0; j < dictitemformlist2.size(); j++) {
				DictitemVO dictitemvo = (DictitemVO) dictitemformlist2.get(j);
				if (dictitemvo.getDictname().equals(svalue)) {
					if (i == scct.length - 1) {
						sru.append(dictitemvo.getDictid());
					} else {
						sru.append(dictitemvo.getDictid() + ",");
					}
				}
			}
		}
		return sru.toString();
	}

	// ҳ����ʾ��ʱ�����Ʒ�������ת��
	public String changTypeToPage(String comcategory) throws Exception {

		// ������Ʒ������Ϣ
		// ��ѯ��Ʒ������Ϣ
		DictitemWebParam dictitemwebparam = new DictitemWebParam();
		DictitemBO dictitembo = (DictitemBO) BOFactory.build(DictitemBO.class,
				this.getDBAccessUser());
		dictitemwebparam.set_se_groupid("IM_FXCOMCATEGORY");
		ArrayList dictitemformlist2 = (ArrayList) (dictitembo
				.doQuery(dictitemwebparam).getDatas());

		StringBuffer sru = new StringBuffer();
		String scct[] = comcategory.split(",");
		for (int i = 0; i < scct.length; i++) {
			String svalue = scct[i].trim();
			for (int j = 0; j < dictitemformlist2.size(); j++) {
				DictitemVO dictitemvo = (DictitemVO) dictitemformlist2.get(j);
				if (dictitemvo.getDictid().equals(svalue)) {
					if (i == scct.length - 1) {
						sru.append(dictitemvo.getDictname());
					} else {
						sru.append(dictitemvo.getDictname() + ",");
					}
				}
			}
		}
		return sru.toString();
	}

	public String doExcel() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("��Ʒ�����Żݷ���");
		export.appendHeadLine(new String[] { "��������:", user.getOprcode() });
		export
				.appendHeadLine(new String[] { "����ʱ�䣺",
						format.format(new Date()) });
		export.addOutputProperty("recid", "���");
		export.addOutputProperty("plancode", "��������");
		export.addOutputProperty("planname", "��������");
		export.addOutputProperty("begindate", "��������", export.DATE,
				"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("enddate", "��ֹ����", export.DATE,
				"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("comcategory", "��Ʒ����");
		export.addOutputProperty("premode", "�Żݷ�ʽ",export.CODE2NAME, "$FX_PRICEPREMODE");
		export.addOutputProperty("prevalue", "������");
		export.addOutputProperty("memo", "��ע");
		getParam().set_pagesize("0");
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel();
	}

}