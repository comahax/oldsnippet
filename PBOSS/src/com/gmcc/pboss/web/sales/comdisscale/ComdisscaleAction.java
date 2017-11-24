/**
 * auto-generated code
 * Fri Jun 25 09:24:19 CST 2010
 */
package com.gmcc.pboss.web.sales.comdisscale;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.resource.comcategoryrela.ComcategoryrelaDBParam;
import com.gmcc.pboss.business.resource.comcategoryrela.ComcategoryrelaVO;
import com.gmcc.pboss.business.sales.comdisscale.ComdisscaleDBParam;
import com.gmcc.pboss.business.sales.comdisscale.ComdisscaleVO;
import com.gmcc.pboss.business.sales.stockalmfloat.StockalmfloatDBParam;
import com.gmcc.pboss.business.sales.stockalmfloat.StockalmfloatVO;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.control.base.dictitem.DictitemBO;
import com.gmcc.pboss.control.resource.comcategoryrela.Comcategoryrela;
import com.gmcc.pboss.control.resource.comcategoryrela.ComcategoryrelaBO;
import com.gmcc.pboss.control.sales.comdisscale.Comdisscale;
import com.gmcc.pboss.control.sales.comdisscale.ComdisscaleBO;
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
 * Title: ComdisscaleAction
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
 * @author zhangsiwei
 * @version 1.0
 */
public class ComdisscaleAction extends BaseAction {

	public ComdisscaleAction() {
		super();

		// ���¼��������Ǳ����
		this.setForm(new ComdisscaleForm());
		this.setParam(new ComdisscaleDBParam());

		// ָ��VO��
		setClsVO(ComdisscaleVO.class);
		// ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
		this.pkNameArray = new String[] { "comcategory" };
		this.setClsControl(Comdisscale.class);
		this.setClsQueryParam(ComdisscaleDBParam.class);

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}

	public String doNew() throws Exception {
		super.doNew();
		Comcategoryrela comcategoryrela = (Comcategoryrela) BOFactory.build(
				ComcategoryrelaBO.class, getDBAccessUser());
		ComcategoryrelaDBParam param = new ComcategoryrelaDBParam();
		param.set_pagesize("0");
		DataPackage dp = comcategoryrela.doQuery(param);
		List<ComcategoryrelaVO> comcategoryrelaList = dp.getDatas();

		// ��ȡƷ�Ƽ���
		String brand = "";
		Set<String> brandSet = new HashSet<String>();
		for (int i = 0; i < comcategoryrelaList.size(); i++) {
			brand = comcategoryrelaList.get(i).getBrand();
			if (null != brand && !brandSet.contains(brand)) {
				brandSet.add(brand);
			}
		}

		// ��ȡƷ�ƺ����Ķ�Ӧ��ϵ��Ϣ�б�
		String comcategory = "";
		String brand2 = "";
		Set<String> comcategorySet = new HashSet<String>();
		List<String> relaInfoList = new ArrayList<String>();
		for (Iterator<String> iter = brandSet.iterator(); iter.hasNext();) {
			// ����
			comcategorySet.clear();

			brand = iter.next();
			String relaInfo = brand + ":";
			for (int i = 0; i < comcategoryrelaList.size(); i++) {
				brand2 = comcategoryrelaList.get(i).getBrand();
				if (null != brand && null != brand2 && brand.equals(brand2)) {
					comcategory = comcategoryrelaList.get(i).getComcategory();
					if (!StringUtils.isEmpty(comcategory)) {
						if (!comcategorySet.contains(comcategory)) {
							comcategorySet.add(comcategory);
							relaInfo = relaInfo + comcategory + ",";
						}
					}
				}
			}

			// ȥ��ĩβ��","
			if (relaInfo.substring(relaInfo.length() - 1, relaInfo.length())
					.equals(","))
				relaInfo = relaInfo.substring(0, relaInfo.length() - 1);
			relaInfoList.add(relaInfo);
		}

		ComdisscaleForm form = (ComdisscaleForm) getForm();
		form.setRelaInfoList(relaInfoList);
		return WEB_RESULT_CONTENT;
	};

	public String doSave() throws Exception {
		try {
			ComdisscaleForm form = (ComdisscaleForm) getForm();
			ComdisscaleVO vo = new ComdisscaleVO();
			BeanUtils.copyProperties(vo, form);

			Comdisscale cds = (Comdisscale) BOFactory.build(
					ComdisscaleBO.class, getDBAccessUser());
			if (CMD.equals(WEB_CMD_EDIT)) {
				DataPackage dp = cds.isExistb(vo);
				if(dp==null || dp.getDatas() == null || dp.getDatas().size()==0){			
					
				}else{
					ComdisscaleVO comdisscalevo	= (ComdisscaleVO)dp.getDatas().get(0);
					if(!comdisscalevo.getRecid().equals(form.getRecid())){
						throw new Exception("��ͬ��¼�Ѿ����ڣ����顣");
					}					
				}

			} else {
				// ΨһԼ����飬���ݷֹ�˾��΢�����Ǽ����׿�Ʒ�ơ���Ʒ�������Ʒ����������ñ�
				// (FX_RU_COMDISSCALE)���в�ѯ��
				// ����Ѿ��������ݣ�����ʾ����ͬ��¼�Ѿ����ڣ����顣�������ء�
				boolean bo = cds.isExist(vo);
				if (bo == true) {
					throw new Exception("��ͬ��¼�Ѿ����ڣ����顣");
				}
			}
			// ��Ʒ����Ʒ�ƶ�Ӧ��ϵ��飺�����׿�Ʒ�ƺ���Ʒ�����ѯ��Ʒ����Ʒ�ƶ�Ӧ��ϵ��(IM_PR_COMCATEBRAND)��
			// �������������ʾ����Ʒ������׿�Ʒ�ƶ�Ӧ��ϵ�������顣�������أ����������
			boolean bbo = cds.checkRale(vo);
			if (bbo == false) {
				throw new Exception("��Ʒ������׿�Ʒ�ƶ�Ӧ��ϵ�������顣");
			}

			// Ʒ�Ʊ�����飺���ݷֹ�˾��΢�����Ǽ���Ʒ�ƶ���Ʒ����������ñ�
			// (FX_RU_COMDISSCALE)���в�ѯ������ѯ����ķ���������кϼƣ�
			// ����ϼ�ֵ�ӵ�ǰֵ����1������ʾ����Ʒ�Ƹ���Ʒ����������֮�ʹ���1�����顣�������ء�
			if (!cds.checkDisscale(vo)) {
				throw new Exception("��Ʒ�Ƹ���Ʒ����������֮�ʹ���1�����顣");
			}

			// �����id���ڣ�˵�����޸�,��������
			if (vo.getRecid() != null && !vo.getRecid().toString().equals("")) {
				cds.doUpdate(vo);
			} else {
				cds.doCreate(vo);
			}
			CMD = WEB_CMD_SAVE;
			this.addActionMessage("����ɹ�!");
		} catch (Exception e) {
			CMD = WEB_CMD_EDIT;
			addActionError(e.getMessage());
		}
		return WEB_RESULT_CONTENT;
	}

	public String doExcel() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("��Ʒ�����������");
		export.appendHeadLine(new String[] { "��������:", user.getOprcode() });
		export
				.appendHeadLine(new String[] { "����ʱ��",
						format.format(new Date()) });
		export.addOutputProperty("recid", "����");
		export.addOutputProperty("countyid", "�ֹ�˾", export.CODE2NAME,
				"#CNTYCOMPANY");
		export.addOutputProperty("mareacode", "΢����", export.CODE2NAME,
				"#MICROAREA");
		export.addOutputProperty("starlevel", "�Ǽ� ", export.CODE2NAME,
				"$CH_STARLEVEL");
		export.addOutputProperty("brand", "�׿�Ʒ��", export.CODE2NAME,
				"$FX_SMPBRAND");
		export.addOutputProperty("comcategory", "��Ʒ����", export.CODE2NAME,
				"$IM_FXCOMCATEGORY");
		export.addOutputProperty("disscale", "�������");
		getParam().set_pagesize("0");
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel();
	}

	public String doImport() {
		try {
			// ��ѯƷ����Ϣ
			DictitemWebParam dictitemwebparam = new DictitemWebParam();
			dictitemwebparam.set_se_groupid("FX_SMPBRAND");
			dictitemwebparam.set_sne_dictid("AllBrand");
			DictitemBO dictitembo = (DictitemBO) BOFactory.build(
					DictitemBO.class, this.getDBAccessUser());
			ArrayList dictitemformlist = (ArrayList) (dictitembo
					.doQuery(dictitemwebparam).getDatas());
			super.getRequest().getSession().setAttribute("dictitemformlist",
					dictitemformlist);

			// ��ѯ��Ʒ������Ϣ
			dictitemwebparam.set_sne_dictid("%CZ");
			dictitemwebparam.set_se_groupid("IM_FXCOMCATEGORY");
			ArrayList dictitemformlist2 = (ArrayList) (dictitembo
					.doQuery(dictitemwebparam).getDatas());
			super.getRequest().getSession().setAttribute("dictitemformlist2",
					dictitemformlist2);

		} catch (Exception e) {
			e.printStackTrace();
			super.addActionError(e.getMessage());
		}
		return "import";
	}

	@Override
	public String doEdit() throws Exception {
		ComdisscaleBO comdisscalebo = (ComdisscaleBO) BOFactory.build(
				ComdisscaleBO.class, this.getDBAccessUser());
		Long pk = Long.parseLong(((ComdisscaleDBParam) this.getParam())
				.get_pk());
		ComdisscaleVO comdisscalevo = comdisscalebo.doFindByPk(pk);
		BaseVO form = getForm();
		BeanUtils.copyProperties(form, comdisscalevo);
		setForm(form);
		CMD = WEB_CMD_EDIT;
		return WEB_RESULT_CONTENT;
	}

	@Override
	public String doDelete() throws Exception {
		String[] selectArray = ((DBQueryParam) getParam()).get_selectitem();

		ComdisscaleBO comdisscalebo = (ComdisscaleBO) BOFactory.build(
				ComdisscaleBO.class, this.getDBAccessUser());
		if (selectArray == null) {
			addActionError("�޷���ȡѡ����Ŀ��");
			return "list";
		}
		try {
			for (int i = 0; i < selectArray.length; i++) {
				Long id = Long.parseLong(selectArray[i]);
				comdisscalebo.doRemoveByPK(id);
			}
		} catch (Exception e) {
			this.addActionError(e.getMessage());
		}
		return doList();
	}
}