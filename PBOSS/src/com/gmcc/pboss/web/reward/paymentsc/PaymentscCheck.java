package com.gmcc.pboss.web.reward.paymentsc;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gmcc.pboss.business.channel.way.WayDBParam;
import com.gmcc.pboss.business.reward.ltype.LtypeDBParam;
import com.gmcc.pboss.business.reward.ltype.LtypeVO;
import com.gmcc.pboss.business.reward.stype.StypeDBParam;
import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.gmcc.pboss.common.utils.tools.CheckUtil;
import com.gmcc.pboss.common.utils.tools.DateUtil;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.reward.ltype.Ltype;
import com.gmcc.pboss.control.reward.ltype.LtypeBO;
import com.gmcc.pboss.control.reward.stype.Stype;
import com.gmcc.pboss.control.reward.stype.StypeBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;

public class PaymentscCheck extends BaseCheckFormat {

	private final Logger log = LoggerFactory.getLogger(PaymentscCheck.class);

	private User user;

	// 查询结果类型： 0 全部, 10 总数, 20数据
	private final int QUERY_TYPE = 20;
	// 如果pagesize为0，表示不分页，只有1页
	private final String NG_PAGESIZE = "0";

	private List<String> optypeList;
	private List<String> ltypeList;
	private List<String> stypeList;
	private List<String> wayList;

	@Override
	public void checkFile(File file, HashMap parameterMap, String contentType)
			throws Exception {
		user = (User) parameterMap.get("user");
		if (!"text/plain".equalsIgnoreCase(contentType)) {
			String msg = "要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件！";
			log.error(msg);
			throw new Exception(msg);
		}
	}

	/**
	 * 获取该地市所有的业务类型名称和酬金大类名称，均去重
	 * 
	 * @return
	 */
	private void getLtypeMap() throws Exception {
		optypeList = new ArrayList<String>();
		ltypeList = new ArrayList<String>();

		String cityId = user.getCityid();

		LtypeDBParam ltypeParams = new LtypeDBParam();
		List cityList = new ArrayList();
		cityList.add(cityId);
		cityList.add("GD");
		ltypeParams.set_sin_cityid(cityList);
		ltypeParams.set_pagesize(NG_PAGESIZE);
		ltypeParams.setDataOnly(true);

		List fieldList = new ArrayList();
		fieldList.add("optype");
		fieldList.add("ltype");
		ltypeParams.setSelectFields(fieldList);

		try {
			Ltype ltype = (Ltype) BOFactory.build(LtypeBO.class, user);
			DataPackage dp = ltype.doQuery(ltypeParams);
			List<LtypeVO> list = (List<LtypeVO>) dp.getDatas();
			if (list != null && list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {
					// 业务类型重复，必须去重
					String optype = list.get(i).getOptype();
					if (!optypeList.contains(optype)) {
						optypeList.add(optype);
					}

					// 酬金大类重复，必须去重
					String ltypeName = list.get(i).getLtype();
					if (!ltypeList.contains(ltypeName)) {
						ltypeList.add(ltypeName);
					}
				}
			}
		} catch (Exception e) {
			String msg = "获取该地市所有的业务类型和酬金大类出错！";
			log.error(msg);
			throw new Exception(msg);
		}
	}

	private List<String> getOptypeList() {
		List<String> list = new ArrayList<String>(5);
		list.add("个人业务");
		list.add("数据业务");
		list.add("集团业务");
		list.add("税金业务");
		list.add("其他业务");

		return list;
	}

	/**
	 * 获取该地市包括省公司的所有酬金小类名称
	 * 
	 * @return
	 */
	private void getStypeList() throws Exception {
		stypeList = new ArrayList<String>();
		String cityId = user.getCityid();

		StypeDBParam stypeParams = new StypeDBParam();
		List cityList = new ArrayList();
		cityList.add(cityId);
		cityList.add("GD");
		stypeParams.set_sin_cityid(cityList);
		stypeParams.set_pagesize(NG_PAGESIZE);
		stypeParams.setDataOnly(true);
		stypeParams.setSelectFieldsString("stype");

		try {
			Stype stype = (Stype) BOFactory.build(StypeBO.class, user);
			DataPackage stypeDp = stype.doQueryStypeBySql(stypeParams,
					QUERY_TYPE);
			// 直接赋值，因为地市包括省公司的所有酬金小类不重复，无需去重
			stypeList = (List<String>) stypeDp.getDatas();
		} catch (Exception e) {
			String msg = "获取该地市包括省公司的所有酬金小类名称出错！";
			log.error(msg);
			throw new Exception(msg);
		}
	}

	/**
	 * 判断酬金小类是否存在
	 * 
	 * @param stypeName
	 * @return
	 */
	private int directChkStype(String stypeName) throws Exception {
		int size = 0;
		try {
			StypeDBParam params = new StypeDBParam();
			List list = new ArrayList();
			list.add(user.getCityid());
			list.add("GD");
			params.set_sin_cityid(list);
			params.set_se_stype(stypeName);
			params.setCountOnly(true);

			Stype stype = (Stype) BOFactory.build(StypeBO.class, user);
			DataPackage dp = stype.doQuery(params);
			size = dp.getRowCount();
		} catch (Exception e) {
			String msg = "获取该地市包括省公司的所有酬金小类名称出错！";
			log.error(msg);
			throw new Exception(msg);
		}

		return size;
	}

	/**
	 * 获取该地市所有的渠道编码 <br />
	 * “业务类型”属于个人业务、数据业务、税金业务中的一种，需要稽核“渠道编码”是否存在渠道表CH_PW_WAY中
	 * 
	 * @return
	 */
	public void getWayList() throws Exception {
		String cityId = user.getCityid();
		wayList = new ArrayList<String>();

		WayDBParam params = new WayDBParam();
		params.set_pagesize(NG_PAGESIZE);
		params.setDataOnly(true);
		params.setSelectFieldsString("wayid");
		params.getQueryConditions().put("cityid", cityId);

		try {
			Way way = (Way) BOFactory.build(WayBO.class, user);
			DataPackage wayDp = way.doQueryWayIdByCityId(params, user);
			wayList = (List<String>) wayDp.getDatas();
		} catch (Exception e) {
			String msg = "获取该地市所有的渠道编码出错！";
			log.error(msg);
			throw new Exception(msg);
		}
	}

	/**
	 * 导入出账数据上传（市场部）格式校验 <br />
	 * 
	 * 渠道编码|结算月份（出账月份）|业务月份（办理月份）|业务类型|酬金大类|酬金小类|（必填）<br />
	 * 手机号码|IMEI号|<br />
	 * 酬金金额（出账金额）|结算期数（第*期）|（必填）|备注|<br />
	 * 
	 */
	@Override
	public void checkLine(String line, int rowCount, User user)
			throws Exception {

		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		if (content.length != 12) {
			String msg = "上传列数不正确，应为11列!现在为："
					+ String.valueOf(content.length - 1);
			log.error(msg);
			throw new Exception(msg);
		}

		boolean flag = true;

		// 渠道编码 content[0]
		String wayId = content[0];
		if (StringUtils.isBlank(wayId)) {
			throw new Exception("[渠道编码]不能为空且长度不能大于18位；");
		} else {
			wayId = wayId.trim();
			if (wayId.getBytes("GBK").length > 18) {
				String msg = "[渠道编码]长度不能大于18位" + wayId;
				log.error(msg);
				throw new Exception(msg);
			}
		}

		// 结算月份（出账月份） content[1]
		String calcMonth = content[1];
		if (StringUtils.isBlank(calcMonth)) {
			throw new Exception("[结算月份（出账月份）]不能为空且只能为6位的yyyyMM格式；");
		} else {
			calcMonth = calcMonth.trim();
			flag = DateUtil.chkIfYmFormat(calcMonth);
			if (!flag) {
				String msg = "[结算月份（出账月份）]格式不对,应为yyyyMM: " + calcMonth;
				log.error(msg);
				throw new Exception(msg);
			}
		}

		// 业务月份（办理月份） content[2]
		String payMonth = content[2];
		if (StringUtils.isBlank(payMonth)) {
			throw new Exception("[业务月份（办理月份）]不能为空且只能为6位的yyyyMM格式；");
		} else {
			payMonth = payMonth.trim();
			flag = DateUtil.chkIfYmFormat(payMonth);
			if (!flag) {
				String msg = "[业务月份（办理月份）]格式不对,应为yyyyMM: " + payMonth;
				log.error(msg);
				throw new Exception(msg);
			}
		}

		// 业务类型 content[3]
		String optype = content[3];
		if (StringUtils.isBlank(optype)) {
			throw new Exception("[业务类型]不能为空且长度不能大于16；");
		} else {
			optype = optype.trim();
			if (optype.getBytes("GBK").length > 16) {
				String msg = "[业务类型]不能为空且长度不能大于16: " + optype;
				log.error(msg);
				throw new Exception(msg);
			}
		}

		List<String> allList = getOptypeList();
		if (!allList.contains(optype)) {
			throw new Exception(
					"[业务类型]只能是“个人业务”、“数据业务”、“集团业务”、“税金业务”、“其他业务”中的一种；");
		}

		// 判断“业务类型”属于个人业务、数据业务、税金业务中的一种，需要稽核
		if (optype.equals("个人业务") || optype.equals("数据业务")
				|| optype.equals("税金业务")) {
			// 首次需要执行该地市所有的渠道编码
			if (wayList == null) {
				getWayList();
			}

			if (wayList != null && wayList.size() > 0) {
				if (!wayList.contains(wayId)) {
					StringBuilder strb = new StringBuilder();
					strb.append("业务类型为");
					strb.append(optype);
					strb.append("时，渠道编码须是BOSS渠道编码，请检查渠道编码是否正确：");
					strb.append(wayId);

					throw new Exception(strb.toString());
				}
			}
		}

		// 酬金大类 content[4]
		String ltypeName = content[4];
		if (StringUtils.isBlank(ltypeName)) {
			throw new Exception("[酬金大类]不能为空且长度不能大于128；");
		} else {
			ltypeName = ltypeName.trim();
			if (ltypeName.getBytes("GBK").length > 128) {
				String msg = "[酬金大类]不能为空且长度不能大于128: " + ltypeName;
				log.error(msg);
				throw new Exception(msg);
			}
		}

		// 酬金小类 content[5]
		String stypeName = content[5];
		if (StringUtils.isBlank(stypeName)) {
			throw new Exception("[酬金小类]不能为空且长度不能大于128；");
		} else {
			stypeName = stypeName.trim();
			if (stypeName.getBytes("GBK").length > 128) {
				String msg = "[酬金小类]不能为空且长度不能大于128: " + stypeName;
				log.error(msg);
				throw new Exception(msg);
			}
		}

		// 手机号码 content[6]
		String mobile = content[6];
		if (StringUtils.isNotBlank(mobile)) {
			mobile = mobile.trim();
			if (mobile.getBytes("GBK").length > 20) {
				String msg = "[手机号码]如果非空则长度不能大于20: " + mobile;
				log.error(msg);
				throw new Exception(msg);
			}
		}

		// IMEI号 content[7]
		String imei = content[7];
		if (StringUtils.isNotBlank(imei)) {
			imei = imei.trim();
			if (imei.getBytes("GBK").length > 15) {
				String msg = "[IMEI号]不能非空则长度不能大于15: " + imei;
				log.error(msg);
				throw new Exception(msg);
			}
		}

		// 酬金金额 （出账金额）content[8] 数值判断 18,4
		String paySum = content[8];
		if (StringUtils.isBlank(paySum)) {
			throw new Exception("[酬金金额（出账金额）]不能为空且长度不能大于18；");
		} else {
			paySum = paySum.trim();
			flag = CheckUtil.checkDouble(paySum, 14, 4);
			if (!flag || paySum.getBytes("GBK").length > 18) {
				String msg = "[酬金金额（出账金额）]必须为数字、小数位不超过4位、总长度不超过 18位： " + paySum;
				log.error(msg);
				throw new Exception(msg);
			}
		}

		// 结算期数（第*期）content[9]
		String settleperiods = content[9];
		if (StringUtils.isBlank(settleperiods)) {
			throw new Exception("[结算期数]不能为空且长度不能大于400；");
		} else {
			settleperiods = settleperiods.trim();
			if (settleperiods.getBytes("GBK").length > 400) {
				String msg = "[结算期数]不能为空且长度不超过 400： " + settleperiods;
				log.error(msg);
				throw new Exception(msg);
			}
		}

		// 备注 content[10] note
		String note = content[10];
		if (StringUtils.isNotBlank(note)) {
			note = note.trim();
			if (note.getBytes("GBK").length > 4000) {
				String msg = "[备注]如果非空则长度不能大于4000: " + note;
				log.error(msg);
				throw new Exception(msg);
			}
		}
	}
}
