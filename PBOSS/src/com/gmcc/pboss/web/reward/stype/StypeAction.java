package com.gmcc.pboss.web.reward.stype;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.reward.ltype.LtypeDBParam;
import com.gmcc.pboss.business.reward.ltype.LtypeVO;
import com.gmcc.pboss.business.reward.rate.RateVO;
import com.gmcc.pboss.business.reward.stype.StypeDBParam;
import com.gmcc.pboss.business.reward.stype.StypeVO;
import com.gmcc.pboss.business.reward.stype.VstypeVO;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.common.utils.tools.BigDecimalConverter;
import com.gmcc.pboss.control.reward.ltype.Ltype;
import com.gmcc.pboss.control.reward.ltype.LtypeBO;
import com.gmcc.pboss.control.reward.rate.Rate;
import com.gmcc.pboss.control.reward.rate.RateBO;
import com.gmcc.pboss.control.reward.stype.Stype;
import com.gmcc.pboss.control.reward.stype.StypeBO;
import com.sunrise.jop.common.utils.lang.Code2NameUtils;
import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBQueryParam;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;

/**
 * <p>
 * Title: StypeAction
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2010
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author a-biao
 * @version 1.0
 */
public class StypeAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5110893270930908764L;

	public StypeAction() {
		super();

		this.setForm(new StypeForm());
		this.setParam(new StypeDBParam());

		setClsVO(StypeVO.class);
		this.pkNameArray = new String[] { "seq" };
		this.setClsControl(Stype.class);
		this.setClsQueryParam(StypeDBParam.class);

	}

	public String doList() throws Exception {
		// HttpServletRequest request = getRequest();
		// User user = (User)
		// request.getSession().getAttribute(WebConstant.SESSION_ATTRIBUTE_USER);
		Stype stype = (Stype) BOFactory.build(StypeBO.class, getDBAccessUser());

		StypeForm stypeForm = new StypeForm();
		Rate rate = (Rate) BOFactory.build(RateBO.class, getDBAccessUser());

		// 判断收款单位名称唯一性
		RateVO vo = rate.doFindByPk(getDBAccessUser().getCityid());
		if (vo != null) {
			// 将税率除以100插入到税率表（CH_CW_ RATE），
			if (vo.getRate() != null) {
				double dRate = BigDecimalConverter.mul(vo.getRate(), 100);
				dRate = BigDecimalConverter.roundToD(dRate, 2);
				float fRate = BigDecimalConverter.convertsToFloat(dRate);
				stypeForm.setRate(fRate);
			}
		}

		StypeDBParam params = (StypeDBParam) getParam();

		String skLtype = params.get_sk_ltype();
		if (StringUtils.isNotEmpty(skLtype)) {
			params.set_sk_ltype(skLtype.trim());
		}

		String skStype = params.get_sk_stype();
		if (StringUtils.isNotEmpty(skStype)) {
			params.set_sk_stype(skStype.trim());
		}

		ArrayList list = new ArrayList();
		list.add(getDBAccessUser().getCityid());
		list.add("GD");
		params.set_sin_cityid(list);
		// params.set_se_cityid(getDBAccessUser().getCityid());
		DataPackage dp = stype.doQueryBySql(params);
		setDp(dp);
		setForm(stypeForm);
		return "list";
	}

	public String doDelete() throws Exception {
		String[] selectArray = ((DBQueryParam) getParam()).get_selectitem();
		Stype stype = (Stype) BOFactory.build(StypeBO.class, getDBAccessUser());
		for (int i = 0; i < selectArray.length; i++) {
			StypeVO vo = stype.doFindByPk(getSelectedPK(selectArray[i]));
			// 如果删除的记录酬金小类的归属地市CITYID是“GD”，则提示“无法删除省统一的酬金类型”
			if ("GD".equals(vo.getCityid())) {
				super.addActionError("无法删除省统一的酬金类型");
				return "list";
			}

			stype.doRemoveByPK(vo.getSeq());

			StypeDBParam params = new StypeDBParam();
			params.set_se_ltype(vo.getLtype());
			DataPackage dp = stype.doQuery(params);
			// 如果删除的记录业务类型、酬金大类归属地市公司，查询酬金小类表，如果该记录对应的业务类型、酬金大类为零，则删除酬金大类表中对应酬金大类的记录
			if (dp.getDatas().size() == 0) {
				Ltype ltype = (Ltype) BOFactory.build(LtypeBO.class,
						getDBAccessUser());
				LtypeDBParam lparams = new LtypeDBParam();
				lparams.set_se_ltype(vo.getLtype());
				DataPackage ldp = ltype.doQuery(lparams);
				if (ldp.getDatas().size() > 0) {
					LtypeVO lvo = (LtypeVO) ldp.getDatas().get(0);
					ltype.doRemoveByPK(lvo.getSeq());
				}
			}
		}
		return doList();
	}

	/**
	 * 批量删除 <br />
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doBatchDelete() throws Exception {
		User user = (User) getDBAccessUser();
		Stype stype = (Stype) BOFactory.build(StypeBO.class, user);
		StypeDBParam params = (StypeDBParam) getParam();

		String optype = params.get_se_optype();
		String skLtype = params.get_sk_ltype();
		if (StringUtils.isNotEmpty(skLtype)) {
			params.set_sk_ltype(skLtype.trim());
		}
		String skStype = params.get_sk_stype();
		if (StringUtils.isNotEmpty(skStype)) {
			params.set_sk_stype(skStype.trim());
		}

		// 不允许没有查询条件而做全部删除
		if (StringUtils.isEmpty(optype) && StringUtils.isEmpty(skLtype)
				&& StringUtils.isEmpty(skStype)) {
			return doList();
		}

		// 只能删除酬金小类表中地市标识CITYID等于当前地市的记录
		params.set_se_cityid(user.getCityid());

		DataPackage dp = stype.doQueryBySql(params);
		if (dp != null && dp.getDatas() != null) {
			for (int i = 0; i < dp.getDatas().size(); i++) {
				StypeVO vo = (StypeVO) dp.getDatas().get(i);
				// 删除小类
				stype.doRemoveByPK(vo.getSeq());

				StypeDBParam param = new StypeDBParam();
				params.set_se_ltype(vo.getLtype());
				DataPackage dpmin = stype.doQuery(param);
				// 如果删除的记录业务类型、酬金大类归属地市公司，查询酬金小类表，如果该记录对应的业务类型、酬金大类为零，则删除酬金大类表中对应酬金大类的记录
				if (dpmin.getDatas().size() == 0) {
					Ltype ltype = (Ltype) BOFactory.build(LtypeBO.class, user);
					LtypeDBParam lparams = new LtypeDBParam();
					lparams.set_se_ltype(vo.getLtype());
					DataPackage ldp = ltype.doQuery(lparams);
					if (ldp.getDatas().size() > 0) {
						LtypeVO lvo = (LtypeVO) ldp.getDatas().get(0);
						ltype.doRemoveByPK(lvo.getSeq());
					}
				}
			}
		}

		return doList();
	}

	public String doSave() throws Exception {
		StypeForm stypeForm = (StypeForm) getForm();
		Ltype ltype = (Ltype) BOFactory.build(LtypeBO.class, getDBAccessUser());
		Stype stype = (Stype) BOFactory.build(StypeBO.class, getDBAccessUser());
		// Code2NameUtils.code2Name(definition, codeValue, dbFlag);
		String cityname = Code2NameUtils.code2Name("CITYNAME",
				getDBAccessUser().getCityid(), getDBAccessUser().getCityid());
		String tempLtype = stypeForm.getLtype().substring(0, 2).trim();
		String tempStype = stypeForm.getStype().substring(0, 2).trim();
		if (!tempLtype.equals(cityname)) {
			// 业务大类增加地市前缀，插入
			stypeForm.setLtype(cityname + stypeForm.getLtype());
		}
		if (!tempStype.equals(cityname)) {
			// 新增业务小类增加地市前缀（比如广州地市的“30元流量卡酬金”，入库STYPE“广州30元流量卡酬金”）
			stypeForm.setStype(cityname + stypeForm.getStype());
		}
		if (CMD.equals("NEW")) {
			// 业务类型属于“个人业务”，查询酬金大类表（CH_CW_ LTYPE）
			// 对应该地市归属CITYID对应的酬金大类是否达到5个，如果达到5个，
			// 则保存失败，提示“个人业务地市个性化酬金大类不能超过五个”；
			if ("个人业务".equals(stypeForm.getOptype())) {
				LtypeDBParam params = new LtypeDBParam();
				params.set_se_ltype(stypeForm.getLtype());
				params.set_se_cityid(getDBAccessUser().getCityid());
				DataPackage dp = ltype.doQuery(params);
				if (dp != null) {
					if (dp.getDatas().size() >= 5) {
						super.addActionError("个人业务地市个性化酬金大类不能超过五个");
						return "content";
					}
				}
			}

			// 判断是否存在相同的小类
			StypeDBParam stypeparams = new StypeDBParam();
			stypeparams.set_se_stype(stypeForm.getStype());
			// stypeparams.set_se_cityid(getDBAccessUser().getCityid());
			DataPackage stypedp = stype.doQuery(stypeparams);
			if (stypedp.getDatas().size() > 0) {
				StypeVO svo = (StypeVO) stypedp.getDatas().get(0);
				if (svo.getCityid().equals("GD")
						|| svo.getCityid()
								.equals(getDBAccessUser().getCityid())) {
					super.addActionError("【" + stypeForm.getStype()
							+ "】已存在该酬金小类");
					return "content";
				}
			}

			// 判断是否存在相同的大类
			LtypeDBParam ltypeparams = new LtypeDBParam();
			ltypeparams.set_se_optype(stypeForm.getOptype());
			ltypeparams.set_se_ltype(stypeForm.getLtype());
			ltypeparams.set_se_cityid(getDBAccessUser().getCityid());
			DataPackage Ltypedp = ltype.doQuery(ltypeparams);
			// LtypeVO LtypeparamsVo = null;
			if (Ltypedp.getDatas().size() == 0) {
				// 酬金大类不存在酬金大类表中或者归属其他地市，则插入一条记录到酬金大类表
				LtypeVO ltypeVO = new LtypeVO();
				ltypeVO.setLtype(stypeForm.getLtype());
				ltypeVO.setOptype(stypeForm.getOptype());
				ltypeVO.setCityid(getDBAccessUser().getCityid());
				ltypeVO = ltype.doCreate(ltypeVO);
				// BeanUtils.copyProperties(getForm(), ltypeVO);
			}
			StypeVO stypeVO = new StypeVO();
			stypeVO.setLtype(stypeForm.getLtype());
			stypeVO.setStype(stypeForm.getStype());
			stypeVO.setCityid(getDBAccessUser().getCityid());
			stypeVO = stype.doCreate(stypeVO);

		} else if (CMD.equals("EDIT")) {
			// 更新小类
			StypeVO stypeVO = stype.doFindByPk(stypeForm.getSeq());
			stypeVO.setLtype(stypeForm.getLtype());
			stypeVO.setStype(stypeForm.getStype());
			stypeVO.setCityid(getDBAccessUser().getCityid());
			stypeVO = stype.doUpdate(stypeVO);
			// 更新大类
			// LtypeVO ltypeVO = new LtypeVO();
			// ltypeVO.setLtype(stypeForm.getLtype());
			// ltypeVO.setOptype(stypeForm.getOptype());
			// ltypeVO.setCityid(getDBAccessUser().getCityid());
			// ltypeVO = ltype.doUpdate(ltypeVO);
		}

		this.CMD = WEB_CMD_SAVE;
		setActionMessage("操作成功!");
		return "content";
	}

	/**
	 * 保存税率
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doSave2() throws Exception {
		StypeForm stypeForm = (StypeForm) getForm();
		Rate rate = (Rate) BOFactory.build(RateBO.class, getDBAccessUser());

		// 判断收款单位名称唯一性
		RateVO vo = rate.doFindByPk(getDBAccessUser().getCityid());

		Float FRate = stypeForm.getRate();
		if (FRate == null) {
			super.addActionError("对私酬金代扣代缴税率不能为空");
			return "list";
		} else {
			// 将税率除以100插入到税率表（CH_CW_ RATE），
			double dRate = BigDecimalConverter.div(FRate, 100, 4);
			float fRate = BigDecimalConverter.convertsToFloat(dRate);
			stypeForm.setRate(fRate);
		}

		if (vo != null) {
			// BeanUtils.copyProperties(vo, rateForm);
			vo.setCityid(getDBAccessUser().getCityid());
			vo.setRate(stypeForm.getRate());
			vo = rate.doUpdate(vo);
		} else {
			RateVO rateVO = new RateVO();
			// BeanUtils.copyProperties(rateVO, rateForm);
			rateVO.setCityid(getDBAccessUser().getCityid());
			rateVO.setRate(stypeForm.getRate());
			rateVO = rate.doCreate(rateVO);
			// BeanUtils.copyProperties(getForm(), rateVO);
		}

		double dRate = BigDecimalConverter.mul(stypeForm.getRate(), 100);
		dRate = BigDecimalConverter.roundToD(dRate, 2);
		float fRate = BigDecimalConverter.convertsToFloat(dRate);
		stypeForm.setRate(fRate);

		// stypeForm.setRate(stypeForm.getRate()*100);

		setActionMessage("操作成功!");
		return "list";
	}

	public String doExportExcel() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("地市公司基础资料");
		export.appendHeadLine(new String[] { "导出工号:", user.getOprcode() });
		export.appendHeadLine(new String[] { "导出时间", format.format(new Date()) });
		export.addOutputProperty("optype", "业务类型");
		export.addOutputProperty("ltype", "酬金大类");
		export.addOutputProperty("stype", "酬金小类");

		// 设置VO类
		export.voClassArray = new Class[] { VstypeVO.class };

		// 设置查询方法
		export.queryMethodName = "doList";
		StypeDBParam params = (StypeDBParam) super.getParam();
		params.set_pagesize("0");
		super.setParam(params);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel();
	}

	/**
	 * 获取页面选择编辑
	 * 
	 * @param seq
	 * @return
	 */
	private String getStypeId(String seq) {
		String stypeId = "";
		String split = "_";
		String[] array = StringUtils.split(seq, split);
		if (array != null && array.length > 0) {
			stypeId = array[0];
		}

		return stypeId;
	}

	public String doEdit() throws Exception {
		HttpServletRequest request = getRequest();
		// User user = (User)
		// request.getSession().getAttribute(WebConstant.SESSION_ATTRIBUTE_USER);
		String seqId = request.getParameter("param._pk");
		// stypeid = new String(stypeid.getBytes("iso8859-1"),"GBK");

		// seq 为 stype_seq||_||ltype_seq
		String stypeId = getStypeId(seqId);

		StypeForm stypeForm = (StypeForm) getForm();
		Stype stype = (Stype) BOFactory.build(StypeBO.class, getDBAccessUser());
		Ltype ltype = (Ltype) BOFactory.build(LtypeBO.class, getDBAccessUser());
		StypeDBParam params = (StypeDBParam) getParam();
		LtypeDBParam lparams = new LtypeDBParam();

		params.set_ne_seq(stypeId);
		// params.set_se_cityid(getDBAccessUser().getCityid());
		// StypeVO vo = (StypeVO) executeDlgMethod(METHOD_TYPE_FINDBYPK,
		// getSelectedPkVO(stypeid.trim()));
		DataPackage dp = stype.doQuery(params);
		StypeVO vo = null;
		if (dp.getDatas().size() > 0) {
			vo = (StypeVO) dp.getDatas().get(0);
		}
		BeanUtils.copyProperties(stypeForm, vo);
		lparams.set_se_ltype(vo.getLtype());
		DataPackage ldp = ltype.doQuery(lparams);
		LtypeVO lvo = null;
		if (ldp.getDatas().size() > 0) {
			lvo = (LtypeVO) ldp.getDatas().get(0);
		}
		stypeForm.setOptype(lvo.getOptype());
		this.CMD = WEB_CMD_EDIT;
		return "content";
	}

}