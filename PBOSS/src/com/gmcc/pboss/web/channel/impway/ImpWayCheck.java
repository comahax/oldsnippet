package com.gmcc.pboss.web.channel.impway;

import java.io.File;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.base.dictitem.DictitemVO;
import com.gmcc.pboss.business.channel.cntycompany.CntycompanyVO;
import com.gmcc.pboss.business.channel.way.WayDBParam;
import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.gmcc.pboss.control.base.dictitem.Dictitem;
import com.gmcc.pboss.control.base.dictitem.DictitemBO;
import com.gmcc.pboss.control.channel.cntycompany.Cntycompany;
import com.gmcc.pboss.control.channel.cntycompany.CntycompanyBO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.sunrise.jop.common.utils.lang.Code2NameUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;

public class ImpWayCheck extends BaseCheckFormat {
	private User user;
	@Override
	public void checkFile(File file, HashMap parameterMap, String contentType)
			throws Exception {
		user = (User) parameterMap.get("user");
		if (!"text/plain".equalsIgnoreCase(contentType)) {
			throw new Exception("要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
		}
	}

	@Override
	public void checkLine(String line, int rowCount, User user) throws Exception {
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		if (content.length != 25) {
			throw new Exception("上传列数不正确，应为24列!");
		}
		if(StringUtils.isBlank(content[0]) || content[0].length() > 18) {
			throw new Exception("渠道编码不能为空且长度不能大于18");
		}
		if (StringUtils.isBlank(content[1]) || content[1].getBytes("GBK").length >256) {
			throw new Exception("渠道名称不能为空且长度不能大于256");
		}
		if (StringUtils.isBlank(content[2]) || content[2].length() > 18) {
			throw new Exception("上级渠道编码不能为空且长度不能大于18");
		}
//		if (StringUtils.isBlank(content[5]) || content[5].length() > 14) {
//			throw new Exception("地市公司编码不能为空且长度不能大于14");
//		}
		if (!checkCity(content[5])) {
			throw new Exception("[地市公司]格式不对,不能为空或大于14位且须与系统一致");
		}
		if (!checkCounty(content[6], content[5])) {
			throw new Exception("[分公司]格式不对,不能大于14位且须是" + content[5]
					+ "的下设分公司");
		}
//		if (StringUtils.isBlank(content[6]) || content[6].length() > 14) {
//			throw new Exception("分公司编码不能为空长度不能大于14");
//		}
		if (StringUtils.isBlank(content[11])) {
			throw new Exception("区域类型编码不能为空");
		}
		if (StringUtils.isBlank(content[15]) || !doCheckLatitude(content[15].trim())) {
			throw new Exception("地理纬度不能为空且必须为小数固定长度为6的数字,并且范围在18-26");
		}
		if (StringUtils.isBlank(content[16]) || !doCheckLongtitude(content[16].trim())) {
			throw new Exception("地理经度不能为空且必须为小数固定长度为6的数字,并且范围在100-130");
		}
		if (StringUtils.isBlank(content[17])) {
			throw new Exception("经营模式不能为空");
		}
		if (StringUtils.isBlank(content[20])) {
			throw new Exception("物业来源分类不能为空");
		}
		
		// 判断渠道编码格式
		String path = "^[a-zA-Z][a-zA-z0-9-]{0,18}$";
		Pattern pattern = Pattern.compile(path);
		Matcher matcher = pattern.matcher(content[0]);
		if (!matcher.find()) {
			throw new Exception("渠道编码不符合规则，应该是字母开头，只包括字母和数字");
		}
		if (content[2].trim().equals(content[0].trim())) {
			throw new Exception("上级编码不能同渠道编码一致");
		} 
		if (StringUtils.isNotBlank(content[3]) && !content[3].trim().equals("IMP")) {
			throw new Exception("此菜单只能是入柜商渠道");
		}
		
		if (StringUtils.isNotBlank(content[7])
				&& Code2NameUtils.code2Name("#SERVCENT", content[7].trim(),
						user.getCityid()).equals(content[7].trim())) {
			throw new Exception("服务销售中心【" + content[7] + "】不存在数据，请核实");
		}
		if (StringUtils.isNotBlank(content[8])
				&& Code2NameUtils.code2Name("#MICROAREA", content[8].trim(),
						user.getCityid()).equals(content[8].trim())) {
			throw new Exception("微区域【" + content[8] + "】不存在数据，请核实");
		}
		if (StringUtils.isNotBlank(content[13])
				&& Code2NameUtils.code2Name("#CH_ADIMAREA", content[13].trim(),
						user.getCityid()).equals(content[13].trim())) {
			throw new Exception("行政区划编码【" + content[13] + "】不存在数据，请核实");
		}
		
		Dictitem dictitem = (Dictitem) BOFactory.build(DictitemBO.class, user);
		DictitemVO vo = new DictitemVO();
		if (StringUtils.isNotBlank(content[9])) {
			vo.setGroupid("CH_STARLEVEL");
			vo.setDictid(content[9]);
			if (dictitem.doFindByPk(vo) == null) {
				throw new Exception("星级【" + content[9] + "】固定参数值不存在数据，请核实");
			}
		}
		
		if (StringUtils.isNotBlank(content[10])) {
			vo.setGroupid("CH_BUZTYPE");
			vo.setDictid(content[10]);
			if (dictitem.doFindByPk(vo) == null) {
				throw new Exception("商圈类型编码【" + content[10] + "】固定参数值不存在数据，请核实");
			}
		}
		if (StringUtils.isNotBlank(content[11])) {
			vo.setGroupid("CH_ADTYPE");
			vo.setDictid(content[11]);
			if (dictitem.doFindByPk(vo) == null) {
				throw new Exception("区域类型编码【" + content[11] + "】固定参数值不存在数据，请核实");
			}
		}
		if (StringUtils.isNotBlank(content[17])) {
			vo.setGroupid("CH_RUNMODE");
			vo.setDictid(content[17]);
			if (dictitem.doFindByPk(vo) == null) {
				throw new Exception("经营模式【" + content[17] + "】固定参数值不存在数据，请核实");
			}
		}
		if (StringUtils.isNotBlank(content[18])) {
			vo.setGroupid("CH_ISCONNECTED");
			vo.setDictid(content[18]);
			if (dictitem.doFindByPk(vo) == null) {
				throw new Exception("是否联网【" + content[18] + "】固定参数值不存在数据，请核实");
			}
		}
		if (StringUtils.isNotBlank(content[19])) {
			vo.setGroupid("CH_CONNECTTYPE");
			vo.setDictid(content[19]);
			if (dictitem.doFindByPk(vo) == null) {
				throw new Exception("联网方式【" + content[19] + "】固定参数值不存在数据，请核实");
			}
		}
		if (StringUtils.isNotBlank(content[20])) {
			vo.setGroupid("CH_PRTSOURCE");
			vo.setDictid(content[20]);
			if (dictitem.doFindByPk(vo) == null) {
				throw new Exception("物业来源分类【" + content[20] + "】固定参数值不存在数据，请核实");
			}
		}
		if (StringUtils.isNotBlank(content[21])) {
			vo.setGroupid("CH_DSTISKEYSTEP");
			vo.setDictid(content[21]);
			if (dictitem.doFindByPk(vo) == null) {
				throw new Exception("是否中心渠道【" + content[21] + "】固定参数值不存在数据，请核实");
			}
		}
		if (StringUtils.isNotBlank(content[23])) {
			vo.setGroupid("CH_DSTISKEYSTEP");
			vo.setDictid(content[23]);
			if (dictitem.doFindByPk(vo) == null) {
				throw new Exception("是否共享【" + content[23] + "】固定参数值不存在数据，请核实");
			}
		}
		// 判断是否存在相同的经度纬度
		Way way = (Way) BOFactory.build(WayBO.class, user);
		WayDBParam params = new WayDBParam();
		params.set_se_longtitude(content[16].trim());
		params.set_se_latitude(content[15].trim());
		DataPackage dp = way.doQueryWayByParams(params);
		if (dp != null && dp.getDatas() != null && dp.getDatas().size() > 0) {
			throw new Exception("存在相同地理纬度地理经度，请核实");
		}
		
		if (StringUtils.isNotBlank(content[22])) {
			params = new WayDBParam();
			params.set_se_wayid(content[22].trim());
			params.set_se_waytype("AG");
			params.set_se_waysubtype("DIS");
			params.set_ne_waystate("1");
			dp = way.doQueryWayByParams(params);
			if (dp.getDatas() == null || dp.getDatas().size() == 0) {
				throw new Exception("所属合作商编码【" + content[22].trim() + "】不存在，请核实");
			}
		}
	}
	
	/*
	 * 判断地理纬度
	 * @param decimal 待判断的值
	 */
	public static boolean doCheckLatitude(String dicimal) throws Exception {
		try {
			if (dicimal.indexOf(".") == -1) {
				return false;
			} else {
				if (dicimal.substring(dicimal.indexOf(".") + 1,
						dicimal.length()).length() != 6)
					return false;
			}
			BigDecimal temp = new BigDecimal(dicimal);
			if (temp.doubleValue() < 18 || temp.doubleValue() > 26) {
				return false;
			}
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
	
	/*
	 * 判断地理经度
	 * @param decimal 待判断的值
	 */
	public static boolean doCheckLongtitude(String dicimal) throws Exception {
		try {
			if (dicimal.indexOf(".") == -1) {
				return false;
			} else {
				if (dicimal.substring(dicimal.indexOf(".") + 1,
						dicimal.length()).length() != 6)
					return false;
			}
			BigDecimal temp = new BigDecimal(dicimal);
			if (temp.doubleValue() < 100 || temp.doubleValue() > 130) {
				return false;
			}
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
	/**
	 * 如果地市公司跟上级渠道的地市公司不符，不允许导入
	 * 
	 * @param cityid
	 * @return
	 */
	private boolean checkCity(String cityid) {
		boolean result = true;
		try {
			if (!cityid.equals(user.getCityid())
					|| cityid.getBytes("GBK").length > 14) {
				result = false;
			}
		} catch (Exception e) {
			result = false;
		}
		return result;
	}
	/**
	 * 检查同系统名称是否一致，是否是某地市公司下设分公司，若出错则拒绝导入
	 * 
	 * @param countyid
	 * @return
	 * @throws Exception
	 */
	private boolean checkCounty(String countyid, String cityid)
			throws Exception {
		boolean result = true;

		if (countyid.getBytes("GBK").length > 14) {
			return false;
		}
		Cntycompany delegate = (Cntycompany) BOFactory.build(
				CntycompanyBO.class, user);
		CntycompanyVO cntycompanyVO = delegate.doFindByPk(countyid);
		if (cntycompanyVO == null
				|| !(user.getCityid()).equals(cntycompanyVO.getCitycompid())) {
			result = false;
		}
		return result;
	}
}
