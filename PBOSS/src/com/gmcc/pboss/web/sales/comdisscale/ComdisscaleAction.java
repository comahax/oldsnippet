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

		// 以下几个方法是必须的
		this.setForm(new ComdisscaleForm());
		this.setParam(new ComdisscaleDBParam());

		// 指定VO类
		setClsVO(ComdisscaleVO.class);
		// 指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
		this.pkNameArray = new String[] { "comcategory" };
		this.setClsControl(Comdisscale.class);
		this.setClsQueryParam(ComdisscaleDBParam.class);

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
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

		// 获取品牌集合
		String brand = "";
		Set<String> brandSet = new HashSet<String>();
		for (int i = 0; i < comcategoryrelaList.size(); i++) {
			brand = comcategoryrelaList.get(i).getBrand();
			if (null != brand && !brandSet.contains(brand)) {
				brandSet.add(brand);
			}
		}

		// 获取品牌和类别的对应关系信息列表
		String comcategory = "";
		String brand2 = "";
		Set<String> comcategorySet = new HashSet<String>();
		List<String> relaInfoList = new ArrayList<String>();
		for (Iterator<String> iter = brandSet.iterator(); iter.hasNext();) {
			// 重置
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

			// 去掉末尾的","
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
						throw new Exception("相同记录已经存在，请检查。");
					}					
				}

			} else {
				// 唯一约束检查，根据分公司、微区域、星级、套卡品牌、商品种类对商品分配比例设置表
				// (FX_RU_COMDISSCALE)进行查询，
				// 如果已经存在数据，则提示“相同记录已经存在，请检查。”并返回。
				boolean bo = cds.isExist(vo);
				if (bo == true) {
					throw new Exception("相同记录已经存在，请检查。");
				}
			}
			// 商品种类品牌对应关系检查：根据套卡品牌和商品种类查询商品种类品牌对应关系表(IM_PR_COMCATEBRAND)，
			// 如果无数据则提示“商品种类和套卡品牌对应关系错误，请检查。”并返回；否则继续。
			boolean bbo = cds.checkRale(vo);
			if (bbo == false) {
				throw new Exception("商品种类和套卡品牌对应关系错误，请检查。");
			}

			// 品牌比例检查：根据分公司、微区域、星级、品牌对商品分配比例设置表
			// (FX_RU_COMDISSCALE)进行查询，将查询结果的分配比例进行合计，
			// 如果合计值加当前值大于1，则提示“该品牌各商品种类分配比例之和大于1，请检查。”并返回。
			if (!cds.checkDisscale(vo)) {
				throw new Exception("该品牌各商品种类分配比例之和大于1，请检查。");
			}

			// 如果有id存在，说明是修改,否则新增
			if (vo.getRecid() != null && !vo.getRecid().toString().equals("")) {
				cds.doUpdate(vo);
			} else {
				cds.doCreate(vo);
			}
			CMD = WEB_CMD_SAVE;
			this.addActionMessage("保存成功!");
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
		export.setFileName("商品分配比例设置");
		export.appendHeadLine(new String[] { "导出工号:", user.getOprcode() });
		export
				.appendHeadLine(new String[] { "导出时间",
						format.format(new Date()) });
		export.addOutputProperty("recid", "编码");
		export.addOutputProperty("countyid", "分公司", export.CODE2NAME,
				"#CNTYCOMPANY");
		export.addOutputProperty("mareacode", "微区域", export.CODE2NAME,
				"#MICROAREA");
		export.addOutputProperty("starlevel", "星级 ", export.CODE2NAME,
				"$CH_STARLEVEL");
		export.addOutputProperty("brand", "套卡品牌", export.CODE2NAME,
				"$FX_SMPBRAND");
		export.addOutputProperty("comcategory", "商品种类", export.CODE2NAME,
				"$IM_FXCOMCATEGORY");
		export.addOutputProperty("disscale", "分配比例");
		getParam().set_pagesize("0");
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel();
	}

	public String doImport() {
		try {
			// 查询品牌信息
			DictitemWebParam dictitemwebparam = new DictitemWebParam();
			dictitemwebparam.set_se_groupid("FX_SMPBRAND");
			dictitemwebparam.set_sne_dictid("AllBrand");
			DictitemBO dictitembo = (DictitemBO) BOFactory.build(
					DictitemBO.class, this.getDBAccessUser());
			ArrayList dictitemformlist = (ArrayList) (dictitembo
					.doQuery(dictitemwebparam).getDatas());
			super.getRequest().getSession().setAttribute("dictitemformlist",
					dictitemformlist);

			// 查询商品种类信息
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
			addActionError("无法获取选中项目！");
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