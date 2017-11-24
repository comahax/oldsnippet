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
			throw new Exception("要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
		}
	}

	public void checkLine(String line, int rowCount, User user)
			throws Exception {

		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		if (content.length != 8) {
			throw new Exception("第" + rowCount + "行:[ " + line
					+ " ] ,列数不正确,正确列数为7");
		}
		if (StringUtils.isEmpty(content[0])) {
			throw new Exception("第" + rowCount + "行:[ " + line + " ] ,分公司不能为空");
		}
		if (StringUtils.isEmpty(content[1])) {
			throw new Exception("第" + rowCount + "行:[ " + line + " ] ,星级不能不能为空");
		}
		if (StringUtils.isEmpty(content[2])) {
			throw new Exception("第" + rowCount + "行:[ " + line + " ] ,合作类型不能为空");
		}
		if (StringUtils.isEmpty(content[3])) {
			throw new Exception("第" + rowCount + "行:[ " + line + " ] ,商品种类不能为空");
		}
		if (StringUtils.isEmpty(content[4])) {
			throw new Exception("第" + rowCount + "行:[ " + line + " ] ,售价区分方式不能为空");
		}
		if (StringUtils.isEmpty(content[5])) {
			throw new Exception("第" + rowCount + "行:[ " + line + " ] ,统一售价、对公对私售价、按是否打印发票售价区分方式，第6列数据都不能为空");
		}
		int pos5 = content[5].trim().indexOf(".");
		
		if (pos5 == -1) { 
			if (content[5].trim().length() > 5)
				throw new Exception("统一售价：数字类型，支持两位小数，整数位最大长度5位，小数位最大长度2位，要求大于等于0");
		} else if (pos5 > 5) {
			    throw new Exception("统一售价：数字类型，支持两位小数，整数位最大长度5位，小数位最大长度2位，要求大于等于0");
		} else if (content[5].substring(pos5+1,content[5].length()).length()>2){
			    throw new Exception("统一售价：数字类型，支持两位小数，整数位最大长度5位，小数位最大长度2位，要求大于等于0");
		}
		checkParameter(content, user);

	}

	/*
	 * 1. 对上传txt文件进行格式及字段值检查： 分公司：必须为用户地市的下属分公司 星级：数据必须取自固定参数 星级2（CH_STARLEVEL2）
	 * 合作类型：数据来源必须为分公司自定义渠道类别表(CH_PW_CUSTWAYTYPE)，匹配市公司标识（CITYCOMPID）为当前地市
	 * 商品种类：数据必须取自固定参数 分销商品种类（IM_FXCOMCATEGORY） 售价区分方式：数据必须取自固定参数
	 * 商品售价区分方式（FX_PRICEDIFTYPE） 统一售价：数字类型，支持两位小数，整数位最大长度5位，小数位最大长度2位，要求大于等于0
	 * 对公售价/对私售价：同上。 打发票售价/不打发票售价：同上。 注：当售价方式采用无区分时，导入文件最后是两条竖线，方便在字段数目检查时统一。
	 */

	private void checkParameter(String[] fields, User user) throws Exception {

		Dictitem dictitem = (Dictitem) BOFactory.build(DictitemBO.class, user);
		DictitemVO vo = new DictitemVO();

		if (StringUtils.isNotBlank(fields[0])) {
			// 分公司
			Cntycompany cntycompany = (Cntycompany) BOFactory.build(
					CntycompanyBO.class, user);
			CntycompanyDBParam cntycompanyDBParam = new CntycompanyDBParam();
			cntycompanyDBParam.set_se_citycompid(user.getCityid());
			cntycompanyDBParam.set_se_countycompid(fields[0]);

			DataPackage dp = cntycompany.doQuery(cntycompanyDBParam);
			List<CntycompanyVO> list = dp.getDatas();

			if (list.isEmpty()) {
				throw new Exception("非法分公司，请参看说明");
			}
		}

		if (StringUtils.isNotBlank(fields[1])) {
			// 星级
			vo.setGroupid("CH_STARLEVEL2");
			vo.setDictid(fields[1]);
			if (dictitem.doFindByPk(vo) == null) {
				throw new Exception("非法星级，请参看说明");
			}
		}

		if (StringUtils.isNotBlank(fields[2])) {
			// 合作类型

			Custwaytype custwaytype = (Custwaytype) BOFactory.build(
					CustwaytypeBO.class, user);
			CustwaytypeDBParam custwaytypeDBParam = new CustwaytypeDBParam();
			custwaytypeDBParam.set_ne_citycompid(user.getCityid());
			custwaytypeDBParam.set_se_custwaytypecode(fields[2]);

			DataPackage dp = custwaytype.doQuery(custwaytypeDBParam);
			List<CustwaytypeVO> list = dp.getDatas();
			if (list.isEmpty()) {
				throw new Exception("非法合作类型，请参看说明");
			}
		}

		if (StringUtils.isNotBlank(fields[3])) {
			// 商品种类
			vo.setGroupid("IM_FXCOMCATEGORY");
			vo.setDictid(fields[3]);
			if (dictitem.doFindByPk(vo) == null) {
				throw new Exception("非法商品种类，请参看说明");
			}
		}

		if (StringUtils.isNotBlank(fields[4])) {

			vo.setGroupid("FX_PRICEDIFTYPE");
			vo.setDictid(fields[4]);
			DictitemVO dictitemVO = dictitem.doFindByPk(vo);

			// 售价区分方式
			if (dictitemVO == null) {
				throw new Exception("非法售价区分方式，请参看说明");
			}

			// 统一售价
			if (("NODIF").equals(dictitemVO.getDictid())) {
				if (StringUtils.isNotBlank(fields[6])) {
					throw new Exception("无区分方式售价，第7列数据必须为空，请检查");
				} 
			}

			// 对公对私售价
			if (("ACCOUNT").equals(dictitemVO.getDictid())) {
				if (StringUtils.isBlank(fields[6])) {
					throw new Exception("对公对私售价，第7列数据不能为空，请检查");
				}
				if (StringUtils.isNotBlank(fields[6])) {

					int pos6 = fields[6].trim().indexOf(".");
					if (pos6 == -1) {
						if (fields[6].trim().length() > 5)
							throw new Exception(
									"对公对私售价：数字类型，支持两位小数，整数位最大长度5位，小数位最大长度2位，要求大于等于0");
					} else if (pos6 > 5 ) {
						   throw new Exception(
								    "对公对私售价：数字类型，支持两位小数，整数位最大长度5位，小数位最大长度2位，要求大于等于0");
					} else if (fields[6].substring(pos6+1,fields[6].length()).length()>2) {
						   throw new Exception(
					                "对公对私售价：数字类型，支持两位小数，整数位最大长度5位，小数位最大长度2位，要求大于等于0");
					}
				}

			}
			// 按是否打印发票区分
			if (("INVOICE").equals(dictitemVO.getDictid())) {
				if (StringUtils.isBlank(fields[6])) {
					throw new Exception("按是否打印发票区分售价，第7列不能为空，请检查");
				}
				if (StringUtils.isNotBlank(fields[6])) {
					int pos6 = fields[6].trim().indexOf(".");
					if (pos6 == -1) {
						if (fields[6].trim().length() > 5)
							throw new Exception(
									"按是否打印发票区分：数字类型，支持两位小数，整数位最大长度5位，小数位最大长度2位，要求大于等于0");
					} else if (pos6 > 5 ) {
						    throw new Exception(
								    "按是否打印发票区分：数字类型，支持两位小数，整数位最大长度5位，小数位最大长度2位，要求大于等于0");
					} else if (fields[6].substring(pos6+1,fields[6].length()).length()>2) {
						    throw new Exception(
					                 "按是否打印发票区分：数字类型，支持两位小数，整数位最大长度5位，小数位最大长度2位，要求大于等于0");
					}  
				}
			}
		}
	}

	private boolean isEmpty(String checkStr) throws Exception {
		if (checkStr != null) {
			return StringUtils.isBlank(checkStr);
		} else {
			throw new Exception("检查字符串为空!");
		}
	}
}
