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

	// 跳转到批量导入界面
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

		// 以下几个方法是必须的
		this.setForm(new StockalmfloatForm());
		this.setParam(new StockalmfloatDBParam());

		// 指定VO类
		setClsVO(StockalmfloatVO.class);
		// 指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
		this.pkNameArray = new String[] { "brand", "wayid" };
		this.setClsControl(Stockalmfloat.class);
		this.setClsQueryParam(StockalmfloatDBParam.class);

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}

	public String doExcel() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("套卡库存预警浮动设置");
		export.appendHeadLine(new String[] { "导出工号:", user.getOprcode() });
		export
				.appendHeadLine(new String[] { "导出时间",
						format.format(new Date()) });
		export.addOutputProperty("recid", "编号");
		export.addOutputProperty("starlevel", "星级", CommonExportBean.CODE2NAME,
				"$CH_STARLEVEL");
		export.addOutputProperty("brand", "套卡品牌", CommonExportBean.CODE2NAME,
				"$FX_SMPBRAND");
		export.addOutputProperty("maxstockquotiety", "最高库存系数");
		export.addOutputProperty("actquotiety", "激活量系数");
		export.addOutputProperty("yellowquotiety", "黄色预警系数");
		export.addOutputProperty("redquotiety", "红色预警系数");
		getParam().set_pagesize("0");
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel();
	}

	@Override
	public String doSave() throws Exception {
		// 根据星级、套卡品牌对网点库存预警浮动表(FX_RU_STOCKALMFLOAT)进行查询，
		// 如果存在数据，则提示“相同记录已经存在，请检查。”并返回。
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
				this.addActionError("相同记录已经存在，请检查");
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
			this.addActionMessage("保存成功!");

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
		// 根据星级、套卡品牌对网点库存预警浮动表(FX_RU_STOCKALMFLOAT)进行查询，
		// 如果存在数据，则提示“相同记录已经存在，请检查。”并返回。
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
				this.addActionError("相同记录已经存在，请检查");
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
			this.addActionMessage("保存成功!");

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
			addActionError("无法获取选中项目！");
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