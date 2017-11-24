package com.gmcc.pboss.web.reward.payment;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gmcc.pboss.business.reward.ltype.LtypeDBParam;
import com.gmcc.pboss.business.reward.ltype.LtypeVO;
import com.gmcc.pboss.business.reward.payway.PaywayDBParam;
import com.gmcc.pboss.business.reward.payway.PaywayVO;
import com.gmcc.pboss.business.reward.stype.StypeDBParam;
import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.gmcc.pboss.common.utils.tools.CheckUtil;
import com.gmcc.pboss.common.utils.tools.DateUtil;
import com.gmcc.pboss.control.reward.ltype.Ltype;
import com.gmcc.pboss.control.reward.ltype.LtypeBO;
import com.gmcc.pboss.control.reward.payway.Payway;
import com.gmcc.pboss.control.reward.payway.PaywayBO;
import com.gmcc.pboss.control.reward.stype.Stype;
import com.gmcc.pboss.control.reward.stype.StypeBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;

public class PaymentCheck extends BaseCheckFormat {

	private final Logger log = LoggerFactory.getLogger(PaymentCheck.class);

	private User user;

	// 查询结果类型： 0 全部, 10 总数, 20数据
	private final int QUERY_TYPE = 20;
	// 如果pagesize为0，表示不分页，只有1页
	private final String NG_PAGESIZE = "0";

	private Map<String, List<String>> stypeMap;
	private Map<String, List<String>> optypeMap;
	private Map<String, List<String>> ltypeMap;
	private List<String> payWayList;

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
		optypeMap = new HashMap<String, List<String>>();
		ltypeMap = new HashMap<String, List<String>>();

		String cityId = user.getCityid();
		if (optypeMap.containsKey(cityId)) {
			return;
		}

		LtypeDBParam ltypeParams = new LtypeDBParam();
		List cityList = new ArrayList();
		cityList.add(cityId);
		cityList.add("GD");
		ltypeParams.set_sin_cityid(cityList);
		ltypeParams.set_pagesize(NG_PAGESIZE);
		ltypeParams.setDataOnly(true);

		// ltypeParams.setSelectFieldsString("optype");
		List fieldList = new ArrayList();
		fieldList.add("optype");
		fieldList.add("ltype");
		ltypeParams.setSelectFields(fieldList);

		try {
			List<String> optypeList = new ArrayList<String>();
			List<String> ltypeList = new ArrayList<String>();

			Ltype ltype = (Ltype) BOFactory.build(LtypeBO.class, user);
			DataPackage dp = ltype.doQuery(ltypeParams);
			List<LtypeVO> allList = (List<LtypeVO>) dp.getDatas();
			if (allList.size() > 0) {
				for (int i = 0; i < allList.size(); i++) {
					// 业务类型重复，必须去重
					String optype = allList.get(i).getOptype();
					if (!optypeList.contains(optype)) {
						optypeList.add(optype);
					}

					// 酬金大类重复，必须去重
					String ltypeName = allList.get(i).getLtype();
					if (!ltypeList.contains(ltypeName)) {
						ltypeList.add(ltypeName);
					}
				}

				optypeMap.put(cityId, optypeList);
				ltypeMap.put(cityId, ltypeList);
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
	private void getStypeMap() throws Exception {
		stypeMap = new HashMap<String, List<String>>();
		String cityId = user.getCityid();
		if (!stypeMap.containsKey(cityId)) {
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
				List<String> stypeList = (List<String>) stypeDp.getDatas();
				if (stypeList != null && stypeList.size() > 0) {
					// 直接赋值，因为地市包括省公司的所有酬金小类不重复，无需去重
					stypeMap.put(cityId, stypeList);
				}
			} catch (Exception e) {
				String msg = "获取该地市包括省公司的所有酬金小类名称出错！";
				log.error(msg);
				throw new Exception(msg);
			}
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
	 * 获取该地市所有的收款单位名称与渠道编码<br />
	 * 取消关联判断 2016-01-19
	 * 
	 * @return
	 */
	public List<String> getPaywayList() throws Exception {
		payWayList = new ArrayList<String>();
		String cityId = user.getCityid();

		PaywayDBParam params = new PaywayDBParam();
		params.set_se_cityid(cityId);
		params.set_pagesize(NG_PAGESIZE);
		params.setDataOnly(true);

		List fieldList = new ArrayList();
		fieldList.add("payee");
		fieldList.add("wayid");
		params.setSelectFields(fieldList);

		try {
			Payway payee = (Payway) BOFactory.build(PaywayBO.class, user);
			DataPackage payeeDp = payee.doQuery(params);
			List<PaywayVO> payeeList = (List<PaywayVO>) payeeDp.getDatas();

			for (int i = 0; i < payeeList.size(); i++) {
				PaywayVO vo = payeeList.get(i);

				StringBuilder strb = new StringBuilder();
				strb.append(vo.getPayee());
				strb.append("_");
				strb.append(vo.getWayid());

				String str = strb.toString();
				payWayList.add(str);
			}

		} catch (Exception e) {
			String msg = "获取该地市所有的收款单位名称出错！";
			log.error(msg);
			throw new Exception(msg);
		}

		return payWayList;
	}

	/**
	 * 导入付款数据格式校验 <br />
	 * 
	 * 业务类型|（必填）<br />
	 * 酬金大类|酬金小类|<br />
	 * 收款单位名称|银行账户名称|银行名称|开户行（XX支行）|银行账号|（必填）<br />
	 * 对应报账单号|分公司|<br />
	 * 付款月份|实发金额|（必填）<br />
	 * 批次|对公/对私|备注|结算（出账）月份|<br />
	 * 
	 */
	@Override
	public void checkLine(String line, int rowCount, User user)
			throws Exception {
		// String cityId = user.getCityid();
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		if (content.length != 17) {
			String msg = "上传列数不正确，应为16列!现在为："
					+ String.valueOf(content.length - 1);
			log.error(msg);
			throw new Exception(msg);
		}

		boolean flag = true;

		// 业务类型 content[0]
		String optype = content[0];
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

		// 首行查询，初始化该地市的业务类型和酬金大类Map
		// if (optypeMap == null) {
		// getLtypeMap();
		// }

		// 判断业务类型是否属于该地市已有的类型
		// if (optypeMap.size() > 0) {
		// List<String> optypeList = optypeMap.get(cityId);
		// if (!(optypeList.size() > 0 && optypeList.contains(optype))) {
		// String msg = "[业务类型]不在属于该地市已有的类型；";
		// log.error(msg);
		// throw new Exception(msg);
		// }
		// }

		List<String> allList = getOptypeList();
		if (!allList.contains(optype)) {
			throw new Exception(
					"[业务类型]只能是“个人业务”、“数据业务”、“集团业务”、“税金业务”、“其他业务”中的一种；");
		}

		// 业务类型|酬金大类|酬金小类|收款单位名称|银行账户名称|银行名称|开户行（XX支行）|
		// 银行账号|对应报账单号|分公司|付款月份|实发金额|批次|对公/对私|备注|结算（出账）月份|
		
		// 酬金大类 content[1] 可为空
		String ltypeName = content[1];
		if (StringUtils.isNotBlank(ltypeName)) {
			ltypeName = ltypeName.trim();
			if (ltypeName.getBytes("GBK").length > 128) {
				String msg = "[酬金大类]如果非空则长度不能大于128" + ltypeName;
				log.error(msg);
				throw new Exception(msg);
			}
		}

		// 判断酬金大类名称是否属于该地市已有的类型
		// if (ltypeMap.size() > 0) {
		// List<String> ltypeList = ltypeMap.get(cityId);
		// if (!(ltypeList.size() > 0 && ltypeList.contains(ltypeName))) {
		// String msg = "酬金大类[" + ltypeName + "]不存在，请添加酬金大类后再上传；";
		// log.error(msg);
		// throw new Exception(msg);
		// }
		// }

		// 酬金小类 content[2] 可为空
		String stypeName = content[2];
		if (StringUtils.isNotBlank(stypeName)) {
			stypeName = stypeName.trim();
			if (stypeName.getBytes("GBK").length > 128) {
				String msg = "[酬金小类]不能为空且长度不能大于128: " + stypeName;
				log.error(msg);
				throw new Exception(msg);
			}
		}

		// 首次需要执行该地市的酬金小类数据查询
		// if (stypeMap == null) {
		// getStypeMap();
		// }

		// 判断酬金小类名称是否属于该地市已有的类型
		// int size = stypeMap.size();
		// if (size > 0) {
		// List<String> stypeList = stypeMap.get(cityId);
		// if (!(stypeList.size() > 0 && stypeList.contains(stypeName))) {
		// // 如果从MAP 查不到，直接用小类名称再查一遍
		// size = directChkStype(stypeName);
		// if (size == 0) {
		// String msg = "酬金小类[" + stypeName + "]不存在，请添加酬金小类后再上传；";
		// log.error(msg);
		// throw new Exception(msg);
		// }
		// }
		// }

		// 收款单位名称 content[3]
		String payeeName = content[3];
		if (StringUtils.isBlank(payeeName)) {
			throw new Exception("[收款单位名称]不能为空且长度不能大于128；");
		} else {
			payeeName = payeeName.trim();
			if (payeeName.getBytes("GBK").length > 128) {
				String msg = "[收款单位名称]不能为空且长度不能大于128: " + payeeName;
				log.error(msg);
				throw new Exception(msg);
			}
		}

		// 银行账户名称 content[4] BKACTNAME
		String bankactname = content[4];
		if (StringUtils.isBlank(bankactname)) {
			throw new Exception("[ 银行账户名称]不能为空且长度不能大于256；");
		} else {
			bankactname = bankactname.trim();
			if (bankactname.getBytes("GBK").length > 256) {
				String msg = "[ 银行账户名称]不能为空且长度不能大于256: " + bankactname;
				log.error(msg);
				throw new Exception(msg);
			}
		}

		// 银行名称 content[5]
		String bank = content[5];
		if (StringUtils.isBlank(bank)) {
			throw new Exception("[银行名称]不能为空且长度不能大于256；");
		} else {
			bank = bank.trim();
			if (bank.getBytes("GBK").length > 256) {
				String msg = "[银行名称]不能为空且长度不能大于256: " + bank;
				log.error(msg);
				throw new Exception(msg);
			}
		}

		// 开户行（XX支行）content[6]
		String depostbank = content[6];
		if (StringUtils.isBlank(depostbank)) {
			throw new Exception("[开户行（XX支行）]不能为空且长度不能大于256；");
		} else {
			depostbank = depostbank.trim();
			if (depostbank.getBytes("GBK").length > 256) {
				String msg = "[开户行（XX支行）]不能为空且长度不能大于256: " + depostbank;
				log.error(msg);
				throw new Exception(msg);
			}
		}

		// 银行账号 content[7]
		String account = content[7];
		if (StringUtils.isBlank(account)) {
			throw new Exception("[银行账号]不能为空且长度不能大于64；");
		} else {
			account = account.trim();
			if (account.getBytes("GBK").length > 64) {
				String msg = "[银行账号]不能为空且长度不能大于64: " + account;
				log.error(msg);
				throw new Exception(msg);
			}
		}

		// 对应报账单号 content[8] 可为空
		String billnumber = content[8];
		if (StringUtils.isNotBlank(billnumber)) {
			billnumber = billnumber.trim();
			if (billnumber.getBytes("GBK").length > 80) {
				String msg = "[对应报账单号]如果非空则长度不能大于80: " + billnumber;
				log.error(msg);
				throw new Exception(msg);
			}
		}

		// 分公司 content[9] 可为空
		String countyid = content[9];
		if (StringUtils.isNotBlank(countyid)) {
			countyid = countyid.trim();
			if (countyid.getBytes("GBK").length > 32) {
				String msg = "[分公司]如果非空则长度不能大于32: " + countyid;
				log.error(msg);
				throw new Exception(msg);
			}
		}

		// 付款月份 content[10]
		String payMonth = content[10];
		if (StringUtils.isBlank(payMonth)) {
			throw new Exception("[付款月份]不能为空且只能为6位的yyyyMM格式；");
		} else {
			payMonth = payMonth.trim();
			flag = DateUtil.chkIfYmFormat(payMonth);
			if (!flag) {
				String msg = "[付款月份]格式不对,应为yyyyMM: " + payMonth;
				log.error(msg);
				throw new Exception(msg);
			}
		}

		// 实发金额 content[11] 增加非负的数据判断 18,4
		String paySum = content[11];
		if (StringUtils.isBlank(paySum)) {
			throw new Exception("[实发金额]不能为空且长度不能大于18；");
		} else {
			paySum = paySum.trim();
			flag = CheckUtil.checkDouble(paySum, 14, 4);
			if (!flag || paySum.getBytes("GBK").length > 18) {
				String msg = "[实发金额]必须为数字、小数位不超过4位、总长度不超过 18位： " + paySum;
				log.error(msg);
				throw new Exception(msg);
			}
		}

		// 批次 content[12] 可为空
		String batch = content[12];
		if (StringUtils.isNotBlank(batch)) {
			batch = batch.trim();
			if (batch.getBytes("GBK").length > 32) {
				String msg = "[批次]长度不能大于32: " + batch;
				log.error(msg);
				throw new Exception(msg);
			}
		}

		// 对公/对私 content[13] 可为空
		String pubpri = content[13];
		if (StringUtils.isNotBlank(pubpri)) {
			pubpri = pubpri.trim();
			if (!"对公".equals(pubpri) && !"对私".equals(pubpri)) {
				String msg = "[对公/对私]只能为对公、对私中一种: " + pubpri;
				log.error(msg);
				throw new Exception(msg);
			}
		}

		// 备注 content[14] clob 可为空
		String note = content[14];
		if (StringUtils.isNotBlank(note)) {
			note = note.trim();
			if (note.getBytes("GBK").length > 4000) {
				String msg = "[备注]长度不能大于32: " + note;
				log.error(msg);
				throw new Exception(msg);
			}
		}

		// 结算月份 content[15]
		String calcMonth = content[15];
		if (StringUtils.isNotBlank(calcMonth)) {
			calcMonth = calcMonth.trim();
			flag = DateUtil.chkIfYmFormat(calcMonth);
			if (!flag) {
				String msg = "[结算月份]如果非空则格式应为yyyyMM: " + calcMonth;
				log.error(msg);
				throw new Exception(msg);
			}
		}
	}

}
