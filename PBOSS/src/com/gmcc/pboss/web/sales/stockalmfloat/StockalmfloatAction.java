/**
 * auto-generated code
 * Sun May 22 15:19:11 GMT 2011
 */
package com.gmcc.pboss.web.sales.stockalmfloat;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.sales.stockalmfloat.StockalmfloatDBParam;
import com.gmcc.pboss.business.sales.stockalmfloat.StockalmfloatVO;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.control.base.dictitem.DictitemBO;
import com.gmcc.pboss.control.sales.stockalmfloat.Stockalmfloat;
import com.gmcc.pboss.control.sales.stockalmfloat.StockalmfloatBO;
import com.gmcc.pboss.web.base.dictitem.DictitemWebParam;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.db.DBQueryParam;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;

/**
 * <p>
 * Title: StockalmfloatAction
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
 * @author yedaoe
 * @version 1.0
 */
public class StockalmfloatAction extends BaseAction {

	private ArrayList dictitemformlist = null;

	public ArrayList getDictitemformlist() {
		return dictitemformlist;
	}

	public void setDictitemformlist(ArrayList dictitemformlist) {
		this.dictitemformlist = dictitemformlist;
	}

	// ��ת�������������
	public String doImport() throws Exception {
		try {
			DictitemWebParam dictitemwebparam = new DictitemWebParam();
			dictitemwebparam.set_se_groupid("FX_SMPBRAND");
			dictitemwebparam.set_sne_dictid("AllBrand");
			DictitemBO dictitembo = (DictitemBO) BOFactory.build(
					DictitemBO.class, this.getDBAccessUser());
			dictitemformlist = (ArrayList) (dictitembo
					.doQuery(dictitemwebparam).getDatas());
			super.getRequest().getSession().setAttribute("dictitemformlist",
					dictitemformlist);
		} catch (Exception e) {
			e.printStackTrace();
			super.addActionError(e.getMessage());
		}
		return "toImport";
	}

	public StockalmfloatAction() {
		super();

		// ���¼��������Ǳ����
		this.setForm(new StockalmfloatForm());
		this.setParam(new StockalmfloatDBParam());

		// ָ��VO��
		setClsVO(StockalmfloatVO.class);
		// ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
		this.pkNameArray = new String[] { "brand", "wayid" };
		this.setClsControl(Stockalmfloat.class);
		this.setClsQueryParam(StockalmfloatDBParam.class);

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}

	public String doExcel() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("�׿����Ԥ����������");
		export.appendHeadLine(new String[] { "��������:", user.getOprcode() });
		export
				.appendHeadLine(new String[] { "����ʱ��",
						format.format(new Date()) });
		export.addOutputProperty("recid", "���");
		export.addOutputProperty("starlevel", "�Ǽ�", CommonExportBean.CODE2NAME,
				"$CH_STARLEVEL");
		export.addOutputProperty("brand", "�׿�Ʒ��", CommonExportBean.CODE2NAME,
				"$FX_SMPBRAND");
		export.addOutputProperty("maxstockquotiety", "��߿��ϵ��");
		export.addOutputProperty("actquotiety", "������ϵ��");
		export.addOutputProperty("yellowquotiety", "��ɫԤ��ϵ��");
		export.addOutputProperty("redquotiety", "��ɫԤ��ϵ��");
		getParam().set_pagesize("0");
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel();
	}

	@Override
	public String doSave() throws Exception {
		// �����Ǽ����׿�Ʒ�ƶ�������Ԥ��������(FX_RU_STOCKALMFLOAT)���в�ѯ��
		// ����������ݣ�����ʾ����ͬ��¼�Ѿ����ڣ����顣�������ء�
		try {
			StockalmfloatForm stockalmfloatForm = (StockalmfloatForm) this
					.getForm();

			StockalmfloatDBParam stockalmfloatdbparam = (StockalmfloatDBParam) this
					.getParam();
			stockalmfloatdbparam.set_se_brand(stockalmfloatForm.getBrand());
			stockalmfloatdbparam.set_ne_starlevel(stockalmfloatForm
					.getStarlevel().toString());
			StockalmfloatBO stockalmfloatBO = (StockalmfloatBO) BOFactory
					.build(StockalmfloatBO.class, this.getDBAccessUser());
			DataPackage dp = stockalmfloatBO.doQuery(stockalmfloatdbparam);

			if (dp != null && dp.getDatas() != null && dp.getDatas().size() > 0) {
				this.addActionError("��ͬ��¼�Ѿ����ڣ�����");
				return "content";
			}
			StockalmfloatVO fxrustockalmfloatVO = new StockalmfloatVO();

			fxrustockalmfloatVO.setStarlevel(stockalmfloatForm.getStarlevel());
			fxrustockalmfloatVO.setBrand(stockalmfloatForm.getBrand());
			fxrustockalmfloatVO.setMaxstockquotiety(stockalmfloatForm
					.getMaxstockquotiety());
			fxrustockalmfloatVO.setActquotiety(stockalmfloatForm
					.getActquotiety());
			fxrustockalmfloatVO.setRedquotiety(stockalmfloatForm
					.getRedquotiety());
			fxrustockalmfloatVO.setYellowquotiety(stockalmfloatForm
					.getYellowquotiety());
			stockalmfloatBO.doCreate(fxrustockalmfloatVO);

			CMD = WEB_CMD_SAVE;
			this.addActionMessage("����ɹ�!");

		} catch (Exception e) {
			CMD = WEB_CMD_EDIT;
			throw e;

		}
		return WEB_RESULT_CONTENT;
	}

	@Override
	public String doEdit() throws Exception {
		StockalmfloatBO stockalmfloatBO = (StockalmfloatBO) BOFactory.build(
				StockalmfloatBO.class, this.getDBAccessUser());
		Long pk = Long.parseLong(((StockalmfloatDBParam) this.getParam())
				.get_pk());
		StockalmfloatVO stockalmfloatVO = stockalmfloatBO.doFindByPk(pk);
		BaseVO form = getForm();
		BeanUtils.copyProperties(form, stockalmfloatVO);
		setForm(form);
		return WEB_RESULT_CONTENT;
	}

	public String doUpdate() throws Exception {
		// �����Ǽ����׿�Ʒ�ƶ�������Ԥ��������(FX_RU_STOCKALMFLOAT)���в�ѯ��
		// ����������ݣ�����ʾ����ͬ��¼�Ѿ����ڣ����顣�������ء�
		try {
			StockalmfloatForm stockalmfloatForm = (StockalmfloatForm) this
					.getForm();

			StockalmfloatDBParam stockalmfloatdbparam = (StockalmfloatDBParam) this
					.getParam();
			stockalmfloatdbparam.set_se_brand(stockalmfloatForm.getBrand());
			stockalmfloatdbparam.set_ne_starlevel(stockalmfloatForm
					.getStarlevel().toString());
			StockalmfloatBO stockalmfloatBO = (StockalmfloatBO) BOFactory
					.build(StockalmfloatBO.class, this.getDBAccessUser());
			DataPackage dp = stockalmfloatBO.doQuery(stockalmfloatdbparam);

			if (dp != null && dp.getDatas() != null && dp.getDatas().size() > 0) {
				this.addActionError("��ͬ��¼�Ѿ����ڣ�����");
				CMD = WEB_CMD_EDIT;
				return "content";
			}
			StockalmfloatVO fxrustockalmfloatVO = new StockalmfloatVO();

			fxrustockalmfloatVO.setStarlevel(stockalmfloatForm.getStarlevel());
			fxrustockalmfloatVO.setBrand(stockalmfloatForm.getBrand());
			fxrustockalmfloatVO.setMaxstockquotiety(stockalmfloatForm
					.getMaxstockquotiety());
			fxrustockalmfloatVO.setActquotiety(stockalmfloatForm
					.getActquotiety());
			fxrustockalmfloatVO.setRedquotiety(stockalmfloatForm
					.getRedquotiety());
			fxrustockalmfloatVO.setYellowquotiety(stockalmfloatForm
					.getYellowquotiety());
			fxrustockalmfloatVO.setRecid(stockalmfloatForm.getRecid());

			stockalmfloatBO.doUpdate(fxrustockalmfloatVO);

			CMD = WEB_CMD_SAVE;
			this.addActionMessage("����ɹ�!");

		} catch (Exception e) {
			CMD = WEB_CMD_EDIT;

		}
		return WEB_RESULT_CONTENT;
	}

	@Override
	public String doDelete() throws Exception {
		String[] selectArray = ((DBQueryParam) getParam()).get_selectitem();

		StockalmfloatBO stockalmfloatBO = (StockalmfloatBO) BOFactory
		.build(StockalmfloatBO.class, this.getDBAccessUser());
		if (selectArray == null) {
			addActionError("�޷���ȡѡ����Ŀ��");
			return "list";
		}
		try {
			for (int i = 0; i < selectArray.length; i++) {
					Long id = Long.parseLong(selectArray[i]);
					stockalmfloatBO.doRemoveByPK(id);
			}
		} catch (Exception e) {
			this.addActionError(e.getMessage());
		}
		return doList();
	}

}