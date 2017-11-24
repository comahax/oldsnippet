package com.gmcc.pboss.web.channel.saleway;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.base.dictitem.DictitemVO;
import com.gmcc.pboss.business.channel.busicircle.BusicircleVO;
import com.gmcc.pboss.business.channel.cntycompany.CntycompanyVO;
import com.gmcc.pboss.business.channel.microarea.MicroareaVO;
import com.gmcc.pboss.business.channel.servcent.ServcentVO;
import com.gmcc.pboss.business.channel.way.WayDAO;
import com.gmcc.pboss.business.channel.way.WayDBParam;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.channel.waybusicircle.WaybusicircleDBParam;
import com.gmcc.pboss.business.channel.waybusicircle.WaybusicircleVO;
import com.gmcc.pboss.business.channel.wayprovince.WayprovinceVO;
import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.gmcc.pboss.control.base.dictitem.Dictitem;
import com.gmcc.pboss.control.base.dictitem.DictitemBO;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.channel.busicircle.Busicircle;
import com.gmcc.pboss.control.channel.busicircle.BusicircleBO;
import com.gmcc.pboss.control.channel.cntycompany.Cntycompany;
import com.gmcc.pboss.control.channel.cntycompany.CntycompanyBO;
import com.gmcc.pboss.control.channel.microarea.Microarea;
import com.gmcc.pboss.control.channel.microarea.MicroareaBO;
import com.gmcc.pboss.control.channel.servcent.Servcent;
import com.gmcc.pboss.control.channel.servcent.ServcentBO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.channel.waybusicircle.Waybusicircle;
import com.gmcc.pboss.control.channel.waybusicircle.WaybusicircleBO;
import com.gmcc.pboss.control.channel.wayprovince.Wayprovince;
import com.gmcc.pboss.control.channel.wayprovince.WayprovinceBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;

public class SalewayCheck extends BaseCheckFormat {

	private User user;

	private boolean customeFlag = false;

	private long preLineCount = 0;

	private String resultStr = "";

	private Way delegate;

	private String param75 = "";

	public static String lineHead = "渠道编码|渠道名称|零售渠道类别|上级渠道编码|星级|排他性|状态|地市公司|分公司|"
			+ "服务销售中心|微区域|是否直供|区域类型|行政区划|业态类型|营业面积|所属物流商|"
			+ "所属渠道经理|分级|公务机号码|业务预警量|详细地址|地理纬度|地理经度|业主姓名|"
			+ "业主电话|业主固定电话|业主电子信箱|送货地址|收货联系人|收货联系号码|收货人证件号码|签约类型|"
			+ "合同编码|合同协议名称|签署合同时间|合同协议生效时间|合同到期日|营业执照编号|营业执照有效期|"
			+ "保证金金额|保证金押金状态|保证金下限|酬金支付开户银行|酬金支付银行账号|酬金支付帐号名称|"
			+ "开户人身份证号码|签约状态|保证金交付形式|经营范围|全省代码|卡类购销划扣银行帐号|"
			+ "卡类购销划扣账号名称|卡类购销划扣开户银行|合作商编码|是否加入B2M模式|账号类型|卡类购销划扣银行标识|卡类购销划扣银行状态|合作类型|网点注册码|"
			+ "主要业务支撑方式|是否接入空中充值平台|全网统一渠道编码|乡镇|渠道基础类型|是否卖场加盟|前台营业面积（㎡）|运营商ISP接入方式|是否加入全员代理模式|星级分层|商圈类型|是否TOP网点|社会渠道类型|所属商圈编码|连锁加盟渠道属性|连锁加盟渠道系数|"
			+ "信用等级|税务资质|是否授权网点|";

	public static String lineHead1 = "渠道编码|渠道名称|零售渠道类别|上级渠道编码|星级|排他性|状态|地市公司|分公司|"
			+ "服务销售中心|微区域|是否直供|区域类型|行政区划|业态类型|营业面积|所属物流商|"
			+ "所属渠道经理|分级|公务机号码|业务预警量|详细地址|地理纬度|地理经度|业主姓名|"
			+ "业主电话|业主固定电话|业主电子信箱|送货地址|收货联系人|收货联系号码|收货人证件号码|签约类型|"
			+ "合同编码|合同协议名称|签署合同时间|合同协议生效时间|合同到期日|营业执照编号|营业执照有效期|"
			+ "保证金金额|保证金押金状态|保证金下限|酬金支付开户银行|酬金支付银行账号|酬金支付帐号名称|"
			+ "开户人身份证号码|签约状态|保证金交付形式|经营范围|全省代码|卡类购销划扣银行帐号|"
			+ "卡类购销划扣账号名称|卡类购销划扣开户银行|合作商编码|是否加入B2M模式|账号类型|卡类购销划扣银行标识|卡类购销划扣银行状态|合作类型|网点注册码|"
			+ "主要业务支撑方式|是否接入空中充值平台|全网统一渠道编码|乡镇|渠道基础类型|是否卖场加盟|前台营业面积（㎡）|运营商ISP接入方式|是否加入全员代理模式|星级分层|商圈类型|是否TOP网点|社会渠道类型|所属商圈编码|连锁加盟渠道属性|连锁加盟渠道系数|"
			+ "信用等级|税务资质|是否授权网点|备注|";

	public static String[] lineArr = StringUtils.splitPreserveAllTokens(
			lineHead, "|");

	// 渠道类型为0 或者-1
	public static String[] lineArr1 = StringUtils.splitPreserveAllTokens(
			lineHead1, "|");

	public SalewayCheck() {
		// TODO Auto-generated constructor stub
	}

	public void checkFile(File file, HashMap parameterMap, String contentType)
			throws Exception {
		user = (User) parameterMap.get("user");
		if (!"text/plain".equalsIgnoreCase(contentType)) {
			throw new Exception("要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
		}
	}

	/**
	 * 渠道编码0|渠道名称1|零售渠道类别2|上级渠道编码3|星级4|排他性5|状态6|地市公司7|分公司8|服务销售中心9|
	 * 微区域10|是否直供12|区域类型13|行政区划14|业态类型15|开业时间16|营业面积17|所属物流商18|所属渠道经理19|
	 * 分级20|活动手机号码21|业务预警量22|详细地址23|地理纬度24|地理经度25|业主姓名26|业主电话27|
	 * 业主固定电话28|业主电子信箱29|送货地址30|收货联系人31|收货联系号码32|收货人证件号码33|签约类型34|合同编码35|合同协议名称36|签署合同时间37|合同协议生效时间38|
	 * 合同到期日39|营业执照编号40|营业执照有效期41|保证金押金42|保证金押金状态43|保证金下限44|开户银行45|银行帐号46|开户账号名称47|开户人身份证号码48
	 */
	public void checkLine(String line, int rowCount, User user)
			throws Exception {
//
//		// 查询系统参数
//		Sysparam sysparam = (Sysparam) BOFactory.build(SysparamBO.class, user);
//		String paramvalue = sysparam.doFindByID(new Long("75"), "channel");

		delegate = (WayBO) BOFactory.build(WayBO.class, user);
		//delete by ydr 没有事物
//		WayDAO waydao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		String exceptionMsg = "此渠道为2G渠道，需上传1-6星级值";
		if (!StringUtils.isEmpty(user.getCityid()) && user.getCityid().equalsIgnoreCase("MM")) {
			exceptionMsg += "或6A"; 
		}
		if (rowCount > 10000) {
			throw new Exception("文件行数不能超过10000行");
		}
		if (null == line || "".equals(line)) {
			return;
		}
		Way delegate = (Way) BOFactory.build(WayBO.class, user);
		String[] fields = StringUtils.splitPreserveAllTokens(line, "|");
		for (int i = 0; i < fields.length; i++) {
			fields[i] = fields[i].trim();
		}
		Sysparam sysparamBO = (SysparamBO) BOFactory.build(SysparamBO.class,
				user);
		// 1:退出时需要填写原因 0:不用填写退出原因 空:不用填写退出原因
		param75 = sysparamBO.doFindByID("75", "channel");

		// 检查列数,判断是否自定义新增
		if (rowCount == 1) {
			if ("".equals(fields[0])) {
				throw new Exception("[渠道编码]不能为空");
			}

			if (("1").equals(param75)) {
				if (lineArr1[0].equals(fields[0])) {
					customeFlag = true;
					checkHead(fields, user);
					return;
				} else {
					customeFlag = false;
				}
			} else {
				if (lineArr[0].equals(fields[0])) {
					customeFlag = true;
					checkHead(fields, user);
					return;
				} else {
					customeFlag = false;
				}
			}

		} else if (rowCount > 1 && customeFlag) {
			if (delegate.doFindByPk(fields[0]) == null) {
				throw new Exception("需要更新的渠道编码:" + fields[0] + " 不存在");
			}
			fields = checkLines(fields, user);
			checkParameter(fields, user);
			updatecheck(fields);
			return;
		}
		if ("1".equals(param75)) {
			if (fields.length != 82 && !customeFlag) {
				throw new Exception("上传数据列数不对,应为81列,请查看说明帮助!");
			}
		} else {
			if (fields.length != 81 && !customeFlag) {
				throw new Exception("上传数据列数不对,应为80列,请查看说明帮助!");
			}
		}

		if (delegate.doFindByPk(fields[0]) != null) {
			updatecheck(fields);
			return;
		}
		String rewardkind = "";//社会渠道类型
		String starlevel = "";
		for (int i = 0; i < fields.length; i++) {
			System.out.println("============" + i);
			switch (i) {
			// 渠道编码
			case 0:
				if ("".equals(fields[i])
						|| fields[i].getBytes("GBK").length > 18) {
					throw new Exception("[渠道编号]不能为空或大于18位");
				}
				break;
			// 渠道名称
			case 1:
				if ("".equals(fields[i])
						|| fields[i].getBytes("GBK").length > 256) {
					throw new Exception("[渠道名称]不能为空或大于256位");
				}
				break;
			// 零售渠道类别
			case 2:
				if ("".equals(fields[i])
						|| fields[i].getBytes("GBK").length > 4) {
					throw new Exception("[零售渠道类别]不能为空或大于4位");
				}
				if (!"SAGT".equals(fields[i].trim())
						&& !"PSAL".equals(fields[i].trim())
						&& !"FD".equals(fields[i].trim())
						&& !"FDS".equals(fields[i].trim())
						&& !"VWAY".equals(fields[i].trim())
						&& !"JMQD".equals(fields[i].trim())) {
					throw new Exception("此菜单只能录入[网点类型]的社会渠道");
				}

				break;
			// 上级渠道编码
			case 3:
				if ("".equals(fields[i])
						|| fields[i].getBytes("GBK").length > 18) {
					throw new Exception("[上级渠道编码]不能为空或不能大于18位");
				}
				if (!StringUtils.isBlank(fields[i])) {
					checkUppserwayid(fields[i]);
				}
				break;
			// 星级
			case 4:
				if ("".equals(fields[i])
						|| fields[i].getBytes("GBK").length > 2) {
					throw new Exception("[星级]不能为空或大于2位数字");
				}
				starlevel = fields[i];
				/* start add for BR201306180003_关于渠道子类别星级取值范围需求概要设计  by feng */
				if(starlevel.matches("[1-3]{1}") && !"SAGT".equals(fields[2].trim())){
					throw new Exception("上传[星级]范围为1-3时，零售渠道类别必须为特约代理点(SGAT)。");
				}else if(starlevel.matches("[4-7]{1}") && !"PSAL".equals(fields[2].trim())){
					throw new Exception("上传[星级]范围为4-7时，零售渠道类别必须为指定专营店(PSAL)。");
				}else if(starlevel.matches("[0]{1}") && ("SGAT".equals(fields[2].trim()) || "PSAL".equals(fields[2].trim()))){
					throw new Exception("上传[星级]范围为非1-7时，零售渠道类别可选FD服务店(FD)、FD连锁店(FDS)、虚拟渠道(VWAY)。");
				}else if(starlevel.matches("[8]{1}") && !"JMQD".equals(fields[2].trim())){
					throw new Exception("上传[星级]范围为8时，零售渠道类别必须为:连锁加盟渠道（JMQD）。");
				}else if(starlevel.matches("[9]{1}") && !"PSAL".equals(fields[2].trim())){
					throw new Exception("上传[星级]为9（4G渠道专用星级）时，零售渠道类别必须为:指定专营店（PSAL）。");
				}else if(user.getCityid().equalsIgnoreCase("MM") && starlevel.equals("60") && !"PSAL".equals(fields[2].trim())) {
					throw new Exception("上传[星级]为60（6A）时，零售渠道类别必须为:指定专营店（PSAL）。");
				}
				/* end add for BR201306180003_关于渠道子类别星级取值范围需求概要设计  by feng */
				break;
			// 排他性
			case 5:
				if ("".equals(fields[i])
						|| fields[i].getBytes("GBK").length > 2) {
					throw new Exception("[排他性]不能为空或大于2位数字");
				}
				break;
			// 状态
			case 6:
				if (!customeFlag) {
					
						if ("".equals(fields[i])
								|| !fields[i].matches("[0,1]{1}")) {
							throw new Exception("[状态]不能为空或并只能为0,1数字");
						}
				} else {
					if (!"".equals(fields[i])) {
					
							if ("".equals(fields[i])
									|| !fields[i].matches("[0,1]{1}")) {
								throw new Exception("[状态]不能为空或并只能为0,1数字");
							}
					}
				}
				break;
			// 地市公司
			case 7:
				if (!checkCity(fields[i])) {
					throw new Exception("[地市公司]格式不对,不能为空或大于14位且须与系统一致");
				}
				;
				break;

			// 分公司
			case 8:
				if (!checkCounty(fields[i], fields[i - 1])) {
					throw new Exception("[分公司]格式不对,不能大于14位且须是" + fields[i - 1]
							+ "的下设分公司");
				}
				break;

			// 服务销售中心
			case 9:
				if (!checkSvccode(fields[i], fields[i - 1])) {
					throw new Exception("[服务销售中心]格式不对,不能大于14位且须是"
							+ fields[i - 1] + "的下设服务销售中心");
				}
				break;

			// 微区域
			case 10:
				if (!checkMicroarea(fields[i], fields[i - 1])) {
					throw new Exception("[微区域]格式不对,不能大于14位且须是" + fields[i - 1]
							+ "的下设微区域");
				}
				break;
			/*
			 * // 合作层级 case 11: if (!"".equals(fields[i]) &&
			 * !fields[i].matches("[0-9]{1,2}")) { throw new
			 * Exception("[合作层级]格式不对,正确为2位数字之内"); } break;
			 */
			// 是否直供
			case 11:
				if ("".equals(fields[i]) || !fields[i].matches("[0-9]{1,2}")) {
					throw new Exception("[是否直供]不能为空或大于2位数字");
				}
				break;
			// 区域类型
			case 12:
				if ("".equals(fields[i]) || !fields[i].matches("[0-9]{1,2}")) {
					throw new Exception("[区域类型]不能为空或大于2位数字");
				}
				break;
			// 行政区划
			case 13:
				if (fields[i].getBytes("GBK").length > 18) {
					throw new Exception("[行政区划]不能大于18位");
				}
				break;
			// 业态类型
			case 14:
				if ("".equals(fields[i]) || !fields[i].matches("[0-9]{1,2}")) {
					throw new Exception("[业态类型]格式不对,正确为2位数字之内");
				}
				if (!"ZJ".equals(fields[7])){
					if("16".equals(fields[i])){
	                	//此【卖场加盟厅】业态类型为湛江地市专用，请选择其他业态类型
						throw new Exception("此【卖场加盟厅】业态类型为湛江地市专用，请选择其他业态类型");
					}
				}
				break;
			// 开业时间
			// case 15:
			// try {
			// date.parse(fields[i]);
			// } catch (ParseException pe) {
			// throw new Exception("[开业时间]格式不对,应为yyyy-MM-dd");
			// }
			// break;
			// 营业面积
			case 15:
				if ("".equals(fields[i]) || !fields[i].matches("[0-9]{1,8}")) {
					throw new Exception("[营业面积]不能为空，且只能为小于、等于8位数字");
				}
				break;
			// 所属物流商
			case 16:
				if (fields[i].getBytes("GBK").length > 18) {
					throw new Exception("[所属物流商]不能大于18位");
				}
				break;
			// 所属渠道经理
			// case 18:
			// if ("".equals(fields[i])
			// ||fields[i].getBytes("GBK").length > 18) {
			// throw new Exception("[所属渠道经理]不能为空或大于18位");
			// }
			// break;
			// 分级
			case 18:
				if (fields[i].getBytes("GBK").length > 4) {
					throw new Exception("[分级]格式不对,不能大于4位");
				}
				break;
			// 公务机号码
			case 19:
				if ("".equals(fields[i])
						|| fields[i].getBytes("GBK").length > 12
						|| !StringUtils.isNumeric(fields[i])) {
					throw new Exception("[公务机号码]格式不对,不能大于12位且必须是数字");
				}
				break;
			// 业务预警量
			case 20:
				if (!"".equals(fields[i]) && !fields[i].matches("[0-9]{1,10}")) {
					throw new Exception("[业务预警量]格式不对,正确为10位数字之内");
				}
				break;
			// 详细地址
			case 21:
				if ("".equals(fields[i])
						|| fields[i].getBytes("GBK").length > 128) {
					throw new Exception("[详细地址]不能为空或大于128位");
				}
				break;
			// 地理纬度
			case 22:
				if ("".equals(fields[i])) {
					throw new Exception("[地理纬度]不能为空!");
				}
				if (fields[i].getBytes("GBK").length > 15
						|| (!"".equals(fields[i]) && (!fields[i]
								.matches("[0-9]{1,15}.[0-9]{6}")
								|| new Double(fields[i]).doubleValue() < 18 || new Double(
								fields[i]).doubleValue() > 26))) {
					throw new Exception("[地理纬度]格式不对，长度不能大于15，精确到6位小数，且在18和26之间");
				}
				break;
			// 地理经度
			case 23:
				if ("".equals(fields[i])) {
					throw new Exception("[地理经度]不能为空!");
				}
				if (fields[i].getBytes("GBK").length > 15
						|| (!"".equals(fields[i]) && (!fields[i]
								.matches("[0-9]{1,15}.[0-9]{6}")
								|| new Double(fields[i]).doubleValue() < 100 || new Double(
								fields[i]).doubleValue() > 130))) {
					throw new Exception(
							"[地理经度]格式不对，长度不能大于15，精确到6位小数，且在100和130之间");
				}
				break;
			// 业主姓名
			case 24:
				if ("".equals(fields[i])
						|| fields[i].getBytes("GBK").length > 64) {
					throw new Exception("[业主姓名]格式不对,不能为空或大于64");
				}
				break;
			// 业主电话
			case 25:
				if ("".equals(fields[i])
						|| fields[i].getBytes("GBK").length > 20) {
					throw new Exception("[业主电话]格式不对,不能为空或大于20");
				}
				break;
			// 业主固定电话
			case 26:
				if (fields[i].getBytes("GBK").length > 20) {
					throw new Exception("[业主固定电话]格式不对,不能大于20");
				}
				break;
			// 业主电子信箱
			case 27:
				if (fields[i].getBytes("GBK").length > 128) {
					throw new Exception("[业主电子信箱]格式不对,不能大于128");
				}
				break;
			// 送货地址
			case 28:
				if (fields[i].getBytes("GBK").length > 128) {
					throw new Exception("[送货地址]格式不对,不能大于128");
				}
				break;
			// 收货联系人
			case 29:
				if (fields[i].getBytes("GBK").length > 32) {
					throw new Exception("[收货联系人]格式不对,不能大于32");
				}
				break;
			// 收货联系号码
			case 30:
				if (fields[i].getBytes("GBK").length > 15) {
					throw new Exception("[收货联系号码]格式不对,不能大于15");
				}
				break;
			// 收货人证件号码
			case 31:
				if (fields[i].getBytes("GBK").length > 20) {
					throw new Exception("[收货人证件号码]格式不对,不能大于20");
				}
				break;
			// 签约类型
			case 32:
				if ("".equals(fields[i]) || !fields[i].matches("[0-9]{1,2}")) {
					throw new Exception("[签约类型]不能大于2位");
				}
				break;
			// 合同编码
			case 33:
				if ("".equals(fields[i])
						|| fields[i].getBytes("GBK").length > 40) {
					throw new Exception("[合同编码]格式不对,不能为空或大于40");
				}
				break;
			// 合同协议名称
			case 34:
				if ("".equals(fields[i])
						|| fields[i].getBytes("GBK").length > 255) {
					throw new Exception("[合同协议名称]格式不对,不能为空或大于255");
				}
				break;
			// 签署合同时间
			case 35:
				try {
					date.parse(fields[i]);
				} catch (ParseException pe) {
					throw new Exception("[签署合同时间]格式不对,应为yyyy-MM-dd");
				}
				break;
			// 合同生效日
			case 36:
				try {
					date.parse(fields[i]);
				} catch (ParseException pe) {
					throw new Exception("[合同生效日]格式不对,应为yyyy-MM-dd");
				}
				break;
			// 合同到期日
			case 37:
				try {
					date.parse(fields[i]);
				} catch (ParseException pe) {
					throw new Exception("[合同到期日]格式不对,应为yyyy-MM-dd");
				}
				break;
			// 营业执照编号
			case 38:
				if (!"".equals(fields[i])
						&& fields[i].getBytes("GBK").length > 64) {
					throw new Exception("[营业执照编号]格式不对,不能大于64");
				}
				break;
			// 营业执照有效期
			case 39:
				try {
					if(fields[i] != null && !"".equals(fields[i]))
						date.parse(fields[i]);
				} catch (ParseException pe) {
					throw new Exception("[营业执照有效期]格式不对,应为yyyy-MM-dd");
				}
				break;
			// 保证金押金
			case 40:
				if (!"".equals(fields[i])
						&& !fields[i].matches("[0-9]{1,18}(.?)[0-9]{0,2}")) {
					throw new Exception("[保证金押金]格式不对,正确为最多两位小数的18位数字之内");
				}
				break;
			// 保证金押金状态
			case 41:
				if (!"".equals(fields[i]) && !fields[i].matches("[0-9]{1,2}")) {
					throw new Exception("[保证金押金状态]格式不对,正确为2位数字之内");
				}
				break;
			// 保证金下限
			case 42:
				if (StringUtils.isBlank(fields[i])
						|| !fields[i].matches("[0-9]{1,18}(.?)[0-9]{0,2}")) {
					throw new Exception("[保证金下限]格式不对,正确为最多两位小数的16位数字之内且不能为空");
				}
				break;
			// 开户银行
			case 43:
				if ("".equals(fields[i])
						|| fields[i].getBytes("GBK").length > 128) {
					throw new Exception("[开户银行]格式不对,不能为空或大于128");
				}
				break;
			// 银行帐号
			case 44:
				if ("".equals(fields[i])
						|| fields[i].getBytes("GBK").length > 50) {
					throw new Exception("[银行帐号]格式不对,不能为空或大于50");
				}
				break;
			// 开户账号名称
			case 45:
				if ("".equals(fields[i])
						|| fields[i].getBytes("GBK").length > 128) {
					throw new Exception("[开户账号名称]格式不对,不能为空或大于128");
				}
				break;
			// 开户人身份证号码38
			case 46:
				if (!(15 == fields[i].length() || 18 == fields[i].length())) {
					throw new Exception("[开户人身份证号码]不能为空,长度必须为15位或者18位!");
				}
				break;
			case 47:
				if ("".equals(fields[i]) || !fields[i].matches("[0-9]{1,2}")) {
					throw new Exception("[签约状态]不能为空且必须在2位数字之内");
				}
				break;
			case 48:
				if (!"".equals(fields[i]) && !fields[i].matches("[0-9]{1,2}")) {
					throw new Exception("[保证金交付形式]格式不对,正确为2位数字之内");
				}
				break;
			case 49:
				if ("".equals(fields[i]) || !fields[i].matches("[0-9]{1,3}")) {
					throw new Exception("[经营范围]不能为空且必须在3位数字之内");
				}
				break;
			case 50:
				if (fields[i].getBytes().length > 18) {
					throw new Exception("[全省代码]格式不对,长度不应该大于18位");
				}
				break;
			// deacctno,deacctname,debankname
			case 51:
				if (!"".equals(fields[i])
						&& fields[i].getBytes("GBK").length > 50) {
					throw new Exception("[卡类购销划扣银行账号]格式不对,长度不能超过50");
				}
				break;
			case 52:
				if (!"".equals(fields[i])
						&& fields[i].getBytes("GBK").length > 128) {
					throw new Exception("[卡类购销划扣帐号名称]格式不对,长度不能超过128");
				}
				break;
			case 53:
				if (!"".equals(fields[i])
						&& fields[i].getBytes("GBK").length > 128) {
					throw new Exception("[卡类购销划扣开户银行]格式不对,长度不能超过128");
				}
				break;
			case 54:
				if (!"".equals(fields[i])
						&& fields[i].getBytes("GBK").length > 18) {
					throw new Exception("[合作商编码]格式不对,长度不能超过18");
				}else {
					if (!fields[i].equals("0000") && !"".equals(fields[i])){
						WayDBParam waylistvo = new WayDBParam();
						waylistvo.set_se_waytype("AG");
						waylistvo.set_se_waysubtype("DIS");
						waylistvo.set_ne_waystate("1");
						waylistvo.set_se_wayid(fields[i]);
						// update by ydr 没有事物 delegate
//						if (waydao.query(waylistvo).getRowCount() <= 0) {
						if (delegate.doQuery(waylistvo).getRowCount() <= 0) {
							throw new Exception( "所属合作商编码:" +fields[i]
									+ "不存在或者不是连锁经营合作商");
						}
						}
				}
				break;
			case 55:
				if ("".equals(fields[i]) || !fields[i].matches("[0,1]{1}")) {
					throw new Exception("[是否加入B2M模式]不能为空且只能为0或1");
				}
				break;
			case 56:
				if (!"".equals(fields[i]) && !fields[i].matches("[0-9]{1}")) {
					throw new Exception("[账号类型]只能为一位数字");
				}
				break;
			case 57:
				if (!"".equals(fields[i])
						&& fields[i].getBytes("GBK").length > 32) {
					throw new Exception("[卡类购销划扣银行标识]格式不对,长度不能超过32");
				}
				break;
			case 58:
				if (!"".equals(fields[i]) && !fields[i].matches("[0,1]{1}")) {
					throw new Exception("[卡类购销划扣银行状态]只能为0或1");
				}
				break;
			// 合作类型
			case 59:
				if (fields[i].getBytes("GBK").length > 4) {
					throw new Exception("[合作类型]格式不对,不能大于4位");
				}
				break;
			case 60:
				if (!"".equals(fields[i])
						&& !fields[i].matches("[0-9a-zA-Z]{11}")) {
					throw new Exception("[网点注册码]格式不对,只能为数字和字母且长度为11位");
				}
				break;
			/*case 61:
				if (!customeFlag) {//add by ydr
					if ("".equals(fields[i])) {
						throw new Exception("[是否授权]不能为空");
					}
				}				
				if (!"".equals(fields[i])) {
					if (!"Y".equals(fields[i].trim())
							&& !"N".equals(fields[i].trim())) {
						throw new Exception("[是否授权]格式不对,只能为Y或者N");
					}
				}
				break;*/
			// 主要业务支撑方式
			case 61:
				if (!customeFlag) {
					if (!"99".equals(fields[i])) {
						if ("".equals(fields[i])
								|| !fields[i]
										.matches("[0,1,2,3,4,5,6,7,8,9,99]{1}")) {
							throw new Exception(
									"[主要业务支撑方式]不能为空且只能为0、1、2、3、4、5、6、7、8、9、99中的值");
						}
					}
				}
				break;
			// 是否接入空中充值平台
			case 62:
				if (!customeFlag) {
					if ("".equals(fields[i]) || !fields[i].matches("[0,1]{1}")) {
						throw new Exception("[是否接入空中充值平台]不能为空且只能为0或1");
					}
				} else {
					if (!"".equals(fields[i])) {
						if (!fields[i].matches("[0,1]{1}")) {
							throw new Exception("[是否接入空中充值平台]不能为空且只能为0或1");
						}
					}
				}
				break;
			// 全网统一渠道编码
			case 63:
				if (fields[i].getBytes("GBK").length > 30) {
					throw new Exception("[全网统一渠道编码]格式不对,不能大于30");
				}
				if (fields[i] != null && !"".equals(fields[i])) {
					String uwi = fields[i] == null ? "" : fields[i];
					String wi = fields[0] == null ? "" : fields[0];

					Wayprovince wayprovince = (Wayprovince) BOFactory.build(
							WayprovinceBO.class, user);
					List wList = wayprovince.doQueryWpByWayid(wi);
					List uList = wayprovince.doQueryWpByUniquewayid(uwi);

					if (wList != null && !"".equals(wList) && wList.size() > 0) {
						// 更新
						if (uList != null && !"".equals(uList)
								&& uList.size() > 0) {
							// 存在全网统一渠道编码
							WayprovinceVO wVO1 = (WayprovinceVO) uList.get(0);
							if (wi.equals(wVO1.getWayid())) {
								// 相同wayid记录才能更新

							} else {
								throw new Exception(wVO1.getWayid()
										+ "  已经存在全网统一渠道编码："
										+ wVO1.getUniquewayid() + "");

							}
						} else {
							// 没有“全网统一渠道编码”，可以直接更新

						}
					} else {
						// 新增
						if (uList != null && !"".equals(uList)
								&& uList.size() > 0) {
							// 存在全网统一渠道编码
							WayprovinceVO wVO1 = (WayprovinceVO) uList.get(0);
							throw new Exception(wVO1.getWayid()
									+ "  已经存在全网统一渠道编码：" + wVO1.getUniquewayid()
									+ "");

						} else {
							// 没有“全网统一渠道编码”，可以直接新增

						}

					}
				}
				break;
			// 乡镇
			case 64:
				if (fields[i].getBytes("GBK").length > 30) {
					throw new Exception("[乡镇]格式不对,不能大于30");
				}
				break;
			// 渠道基础类型
			case 65:
				if (!"".equals(fields[i]) && !fields[i].matches("[0,3]{1}")) {
					throw new Exception("[渠道基础类型]格式不对,只能为0,3中的值");
				}
				break;
			// 是否卖场加盟
			case 66:
				if (!"".equals(fields[i]) && !fields[i].matches("[0,1]{1}")) {
					throw new Exception("[是否卖场加盟]格式不对,只能为0、1中的值");
				}
				break;
			// 前台营业面积（㎡）
			case 67:
				if ("".equals(fields[i])) {

				} else {
					int loca = fields[i].indexOf(".");
					if (loca >= 0) {
						// 有小数点
						if (loca == 0 || loca == (fields[i].length() - 1)) {
							// 首位、未位小数
							throw new Exception(
									"[前台营业面积（㎡）]格式不对,整数位不超过8位、小数位不超过2位");
						}
						String strs[] = fields[i].split("\\.");
						if (strs.length > 2) {
							// 多个小数点
							throw new Exception(
									"[前台营业面积（㎡）]格式不对,整数位不超过8位、小数位不超过2位");
						} else {
							// 一个小数点
							if ((strs[0].length() + strs[1].length()) > 10) {
								throw new Exception(
										"[前台营业面积（㎡）]格式不对,整数位不超过8位、小数位不超过2位");
							} else {
								if (!strs[0].matches("[0-9]{1,8}")
										|| !strs[1].matches("[0-9]{1,2}")) {
									throw new Exception(
											"[前台营业面积（㎡）]格式不对,整数位不超过8位、小数位不超过2位");
								}
							}
						}
					} else {// 数字
						if (!fields[i].matches("[0-9]{1,8}")) {
							throw new Exception(
									"[前台营业面积（㎡）]格式不对,整数位不超过8位、小数位不超过2位");
						}
					}
				}
				break;
			// 运营商ISP接入方式
			case 68:
				if (!"".equals(fields[i]) && !fields[i].matches("[0,1,2,3]{1}")) {
					throw new Exception("[运营商ISP接入方式]格式不对,只能为0、1、2、3中的值");
				}
				break;
			// 是否加入全员代理模式
			case 69:
				if (!customeFlag) {
					if ("".equals(fields[i]) || !fields[i].matches("[0,1]{1}")) {
						throw new Exception("[是否加入全员代理模式]不能为空且只能为0或1");
					}
				} else {
					if (!"".equals(fields[i])) {
						if (!fields[i].matches("[0,1]{1}")) {
							throw new Exception("[是否加入全员代理模式]不能为空且只能为0或1");
						}
					}
				}
				break;
			// 星级分层
			case 70:
				if (!customeFlag) {
					if ("".equals(fields[i])
							|| !fields[i].matches("[1,2,3]{1}")) {
						throw new Exception("[星级分层]不能为空且只能为1、2、3");
					}
				} else {
					if (!"".equals(fields[i])) {
						if (!fields[i].matches("[1,2,3]{1}")) {
							throw new Exception("[星级分层]不能为空且只能为1、2、3");
						}
					}
				}
				break;
				
			// 商圈类型
			case 71:
				if (!customeFlag) {
					if ("".equals(fields[i])) {
						throw new Exception("[商圈类型]不能为空");
					}
				}
				if (!"".equals(fields[i])) {
					if (!"99".equals(fields[i]) && !fields[i].matches("[1,5,6,7]{1}")) {
						throw new Exception("[商圈类型]格式不对,只能为1,5,6,7,99");
					}
				}
				break;	
			// 是否TOP网点
			case 72:
				if (!customeFlag) {
					if (!"".equals(fields[i])) {
						if (!fields[i].matches("[0,1]{1}")) {
							throw new Exception("[是否TOP网点]格式不对,只能为0,1");
						}
					}
				}
				break;
			/* star uppdate for (2013)NBBOSS- D0019 渠道优化概要设计     by feng */
			// 社会渠道类型
			case 73:
				if (!customeFlag) {
					rewardkind = fields[i];
					if (fields[i] == null || "".equals(fields[i])) {
						throw new Exception("[社会渠道类型]不能为空");
					}
					if("0".equals(rewardkind)){
						
						if ("7".equals(starlevel)){
							throw new Exception(exceptionMsg);
						}
						if ("8".equals(starlevel)){
							throw new Exception(exceptionMsg);
						}
						if ("9".equals(starlevel)){
							throw new Exception(exceptionMsg);
						}
						if (!"".equals(fields[75]) || !"".equals(fields[76])){
							fields[75]=null;
							fields[76]=null;
							//经评审人员锋超和李艳玲建议直接清空这两个值
							//throw new Exception("只有3G/4G渠道才有【渠道加盟属性】、【渠道加盟系数】的属性值");
						}
					}else if( "1".equals(rewardkind)){
						if (!"7".equals(starlevel) || "60".equals(starlevel)){
							throw new Exception("此渠道为3G渠道，需上传3G渠道专用星级");
						}
						if ("".equals(fields[75]) || null == fields[75] || "".equals(fields[76]) || null == fields[76]){
							throw new Exception("此渠道为3G渠道，则必须上传【社会渠道加盟属性】、【社会渠道加盟系数】2个属性值");
						}
						if ("A+1".equals(fields[75])){
							throw new Exception("此渠道为3G渠道，连锁加盟渠道属性为A+1(专营重要商圈)时，必须为4G渠道类型的");
						}
						if (!"DG".equals(fields[7])){
							if("2Q".equals(fields[75]) || "3Q".equals(fields[75]) || "4Q".equals(fields[75]) || "A3".equals(fields[75]) || "B3".equals(fields[75]) || "C3".equals(fields[75])){
			                	//此【'+wayattr+'】连锁加盟渠道属性为东莞地市专用，请选择其他连锁加盟渠道属性
								throw new Exception("此【"+fields[75]+"】连锁加盟渠道属性为东莞地市专用，请选择其他连锁加盟渠道属性");
							}
						}
					}else if( "2".equals(rewardkind)){
						if (!"8".equals(starlevel) || "60".equals(starlevel)){
							throw new Exception("此渠道为连锁加盟渠道，需上传连锁加盟渠道星级");
						}
						if (!"".equals(fields[75]) || null != fields[75] || !"".equals(fields[76]) || null != fields[76]){
							fields[75]=null;
							fields[76]=null;
							//throw new Exception("此渠道为连锁加盟渠道，则上传【社会渠道加盟属性】、【社会渠道加盟系数】2个属性值");
						}
					}else if( "3".equals(rewardkind)){
						if (!"9".equals(starlevel) || "60".equals(starlevel)){
							throw new Exception("此渠道为4G渠道，需上传4G渠道专用星级");
						}
						if ("".equals(fields[75]) || null == fields[75] || "".equals(fields[76]) || null == fields[76]){
							throw new Exception("此渠道为4G渠道，则必须上传【社会渠道加盟属性】、【社会渠道加盟系数】2个属性值");
						}
//						if (!"A+1".equals(fields[75])){
//							throw new Exception("4G渠道类型的连锁加盟渠道属性必须为A+1 (专营重要商圈)");
//						}
						if (!"DG".equals(fields[7])){
							if("2Q".equals(fields[75]) || "3Q".equals(fields[75]) || "4Q".equals(fields[75]) || "A3".equals(fields[75]) || "B3".equals(fields[75]) || "C3".equals(fields[75])){
			                	//此【'+wayattr+'】连锁加盟渠道属性为东莞地市专用，请选择其他连锁加盟渠道属性
								throw new Exception("此【"+fields[75]+"】连锁加盟渠道属性为东莞地市专用，请选择其他连锁加盟渠道属性");
							}
						}
					}else{
						throw new Exception("社会渠道类型不存在");
					}
				}else{
					rewardkind = fields[i];					
					if(rewardkind != null && !"".equals(rewardkind)){
						if("0".equals(rewardkind)){
							if ("7".equals(starlevel)||"8".equals(starlevel)||"9".equals(starlevel)){
								throw new Exception(exceptionMsg);
							}
							if (!"".equals(fields[75]) || !"".equals(fields[76])){
								fields[75]=null;
								fields[76]=null;
								//经评审人员锋超和李艳玲建议直接清空这两个值
								//throw new Exception("只有3G/4G渠道才有【渠道加盟属性】、【渠道加盟系数】的属性值");
							}
						}else if( "1".equals(rewardkind)){
							if (!"7".equals(starlevel)){
								throw new Exception("此渠道为3G渠道，需上传3G渠道专用星级");
							}
							if ("".equals(fields[75]) || null == fields[75] || "".equals(fields[76]) || null == fields[76]){
								throw new Exception("此渠道为3G渠道，则必须上传【社会渠道加盟属性】、【社会渠道加盟系数】2个属性值");
							}
							if ("A+1".equals(fields[75])){
								throw new Exception("此渠道为3G渠道，连锁加盟渠道属性为A+1(专营重要商圈)时，必须为4G渠道类型");
							}
							if (!"DG".equals(fields[7])){
								if("2Q".equals(fields[75]) || "3Q".equals(fields[75]) || "4Q".equals(fields[75]) || "A3".equals(fields[75]) || "B3".equals(fields[75]) || "C3".equals(fields[75])){
				                	//此【'+wayattr+'】连锁加盟渠道属性为东莞地市专用，请选择其他连锁加盟渠道属性
									throw new Exception("此【"+fields[75]+"】连锁加盟渠道属性为东莞地市专用，请选择其他连锁加盟渠道属性");
								}
							}
						}else if( "2".equals(rewardkind)){
							if (!"8".equals(starlevel)){
								throw new Exception("此渠道为连锁加盟渠道，需上传8[连锁加盟渠道星级]");
							}
							if (!"".equals(fields[75]) || !"".equals(fields[76])){
								fields[75]=null;
								fields[76]=null;
								//经评审人员锋超和李艳玲建议直接清空这两个值
								//throw new Exception("只有3G/4G渠道才有【渠道加盟属性】、【渠道加盟系数】的属性值");
							}
						}else if( "3".equals(rewardkind)){
							if (!"9".equals(starlevel)){
								throw new Exception("此渠道为4G渠道，需上传4G渠道专用星级");
							}
							if ("".equals(fields[75]) || null == fields[75] || "".equals(fields[76]) || null == fields[76]){
								throw new Exception("此渠道为4G渠道，则必须上传【社会渠道加盟属性】、【社会渠道加盟系数】2个属性值");
							}
//							if (!"A+1".equals(fields[75])){
//								throw new Exception("4G渠道类型的连锁加盟渠道属性必须为A+1 (专营重要商圈)");
//							}
							if (!"DG".equals(fields[7])){
								if("2Q".equals(fields[75]) || "3Q".equals(fields[75]) || "4Q".equals(fields[75]) || "A3".equals(fields[75]) || "B3".equals(fields[75]) || "C3".equals(fields[75])){
				                	//此【'+wayattr+'】连锁加盟渠道属性为东莞地市专用，请选择其他连锁加盟渠道属性
									throw new Exception("此【"+fields[75]+"】连锁加盟渠道属性为东莞地市专用，请选择其他连锁加盟渠道属性");
								}
							}
						}else{
							throw new Exception("社会渠道类型不存在");
						}
					}
				}
				break;
			// 所属商圈编码
			case 74:
				if (fields[i] == null || "".equals(fields[i])) {
					if (!customeFlag) {
						throw new Exception("[所属商圈编码]不能为空");
					}
				} else {
					Busicircle busicircle = (Busicircle) BOFactory.build(BusicircleBO.class, user);
					BusicircleVO busicircleVO = busicircle.doFindByPk(fields[i]);
					if (null == busicircleVO) {
						throw new Exception("[所属商圈编码]不是有效所属商圈编码值，请检查");
					}
				}
				break;
			// 连锁加盟渠道属性
			case 75:
				if("1".equals(rewardkind)){
					if (fields[i] == null || "".equals(fields[i])) {
						throw new Exception("[连锁加盟渠道属性]不能为空");
					}else{
						Dictitem dictitem = (Dictitem) BOFactory.build(DictitemBO.class, user);
						DictitemVO vo = new DictitemVO();
						vo.setGroupid("CH_WAYATTR");
						vo.setDictid(fields[75]);
						if (dictitem.doFindByPk(vo) == null) {
							throw new Exception("[连锁加盟渠道属性]值，不存在，请输入有效的连锁加盟渠道属性值");
						}
					}
					if ("A+1".equals(fields[i])){
						throw new Exception("此渠道为3G渠道，只有4G渠道连锁加盟渠道属性才能为A+1 (专营重要商圈)");
					}
					if (!"DG".equals(fields[7])){
						if("2Q".equals(fields[i]) || "3Q".equals(fields[i]) || "4Q".equals(fields[i]) || "A3".equals(fields[i]) || "B3".equals(fields[i]) || "C3".equals(fields[i])){
		                	//此【'+wayattr+'】连锁加盟渠道属性为东莞地市专用，请选择其他连锁加盟渠道属性
							throw new Exception("此【"+fields[75]+"】连锁加盟渠道属性为东莞地市专用，请选择其他连锁加盟渠道属性");
						}
					}
				}else if("3".equals(rewardkind)){
					if (fields[i] == null || "".equals(fields[i])) {
						throw new Exception("[连锁加盟渠道属性]不能为空");
					}else{
						Dictitem dictitem = (Dictitem) BOFactory.build(DictitemBO.class, user);
						DictitemVO vo = new DictitemVO();
						vo.setGroupid("CH_WAYATTR");
						vo.setDictid(fields[75]);
						if (dictitem.doFindByPk(vo) == null) {
							throw new Exception("[连锁加盟渠道属性]值，不存在，请输入有效的连锁加盟渠道属性值");
						}
					}
				}
				break;
			// 连锁加盟渠道系数
			case 76:
				if("1".equals(rewardkind)){
					if (fields[i] == null || "".equals(fields[i])) {
						throw new Exception("[连锁加盟渠道系数]不能为空");
					}
				}else if("3".equals(rewardkind)){
					if (fields[i] == null || "".equals(fields[i])) {
						throw new Exception("[连锁加盟渠道系数]不能为空");
					}
				}
				break;
			// 信用等级
			case 77:
				if(fields[i] == null || "".equals(fields[i])){
					throw new Exception("[信用等级]不能为空");
				}else{
					if (!"".equals(fields[i]) && !fields[i].matches("[0,1,2]{1}")) {
						throw new Exception("[信用等级]格式不对,只能为0、1、2");
					}
				}
				break;
			// 税务资质
			case 78:
				if (fields[i] == null || "".equals(fields[i])) {
					throw new Exception("[税务资质]不能为空");
				} else {
					Dictitem dictitem = (Dictitem) BOFactory.build(DictitemBO.class, user);
					DictitemVO vo = new DictitemVO();
					vo.setGroupid("CH_TAXCERTIFICATE");
					vo.setDictid(fields[78]);
					if (dictitem.doFindByPk(vo) == null) {
						throw new Exception("[税务资质]值只能是0（小规模纳税人）、1（一般纳税人）、2（其他）3种类型");
					}
				}
				break;
			// 是否授权网点
			case 79:
				if (fields[i] == null || "".equals(fields[i])) {
					throw new Exception("[是否授权网点]不能为空");
				} else {
					if (!fields[i].trim().equals("Y") && !fields[i].trim().equals("N")) {
						throw new Exception("[是否授权网点]值只能是N（否）、Y（是）2种类型");
					}
				}
				break;
			/* 请注意于备注信息，每次新增导入字段将其保持放于最后！谢谢     by feng */
			// 备注
			case 80:
				if ("1".equals(param75)) {
					if ("0".equals(fields[6])) {
						if (fields[i] == null || "".equals(fields[i])) {
							throw new Exception("网点退出时，[备注]不能为空，需要填写退出原因");
						}else if (fields[i].getBytes().length>512) {
							throw new Exception("网点退出时，[备注]数据长度不能超出数据库储存长度");
						}
					} 
				} 
				break;
			/* end uppdate for (2013)NBBOSS- D0019 渠道优化概要设计     by feng */
			
			}

		}
		checkParameter(fields, user);
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

	/**
	 * 检查是否是分公司的下设服务销售中心，若出错则拒绝导入
	 * 
	 * @param svccode
	 * @param countyid
	 * @return
	 * @throws Exception
	 */
	private boolean checkSvccode(String svccode, String countyid)
			throws Exception {
		boolean result = true;
		if (StringUtils.isNotBlank(svccode) && StringUtils.isNotBlank(countyid)) {
			if (svccode.getBytes("GBK").length > 14) {
				return false;
			}
			Servcent delegate = (Servcent) BOFactory.build(ServcentBO.class,
					user);
			ServcentVO servcentVO = delegate.doFindByPk(svccode);
			if (servcentVO == null
					|| !countyid.equals(servcentVO.getCountyid())) {
				result = false;
			}
		}
		return result;
	}

	/**
	 * 检查是否是服务销售中心下设的微区域，若出错则拒绝导入
	 * 
	 * @param mareacode
	 * @param svccode
	 * @return
	 * @throws Exception
	 */
	private boolean checkMicroarea(String mareacode, String svccode)
			throws Exception {
		boolean result = true;
		if (StringUtils.isNotBlank(mareacode)
				&& StringUtils.isNotBlank(svccode)) {
			if (svccode.getBytes("GBK").length > 14) {
				return false;
			}
			Microarea delegate = (Microarea) BOFactory.build(MicroareaBO.class,
					user);
			MicroareaVO microareaVO = delegate.doFindByPk(mareacode);
			if (microareaVO == null
					|| !svccode.equals(microareaVO.getSvccode())) {
				result = false;
			}
		}
		return result;
	}

	private void updatecheck(String[] fields) throws Exception {
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		Sysparam sysparamBO = (SysparamBO) BOFactory.build(SysparamBO.class,
				user);
		String exceptionMsg = "此渠道为2G渠道，需上传1-6星级值";
		if (!StringUtils.isEmpty(user.getCityid()) && user.getCityid().equalsIgnoreCase("MM")) {
			exceptionMsg += "或6A"; 
		}
		//delete by ydr 没有事物
//		WayDAO waydao = (WayDAO) DAOFactory.build(WayDAO.class, user);
		// 1:退出时需要填写原因 0:不用填写退出原因 空:不用填写退出原因
		String param75 = sysparamBO.doFindByID("75", "channel");
		
		String rewardkind = "";//社会渠道类型
		String starlevel = "";
		
		/* start add for (2013)NBBOSS- D0019 渠道优化概要设计     by feng */
		WayVO wayVO = delegate.doFindByPk(fields[0]);
		if (wayVO == null) {
			throw new Exception("所需要修改的渠道不存在");
		} else {
			if ("AG".equals(wayVO.getWaytype())) {
				if (!"SAGT".equals(wayVO.getWaysubtype())
						&& !"PSAL".equals(wayVO.getWaysubtype())
						&& !"FD".equals(wayVO.getWaysubtype())
						&& !"FDS".equals(wayVO.getWaysubtype())
						&& !"VWAY".equals(wayVO.getWaysubtype())
						&& !"JMQD".equals(wayVO.getWaysubtype())) {
					throw new Exception("非[网点]类型的渠道不能在此菜单修改");
				}
			} else {
				throw new Exception("非[社会渠道]类型的渠道不能在此菜单修改");
			}
		}
		/* start add for (2013)NBBOSS- D0019 渠道优化概要设计     by feng */
		
		//商圈信息
		Waybusicircle waybusicircleBO = (WaybusicircleBO)BOFactory.build(WaybusicircleBO.class,user);
		WaybusicircleDBParam waybusicircleDBParam = new WaybusicircleDBParam();
		waybusicircleDBParam.set_se_wayid(fields[0]);
		DataPackage WaybusicircleDP = waybusicircleBO.doQuery(waybusicircleDBParam);
		WaybusicircleVO wbVO = new WaybusicircleVO();
		if(WaybusicircleDP != null && !"".equals(WaybusicircleDP)
				&& WaybusicircleDP.getDatas() != null && !"".equals(WaybusicircleDP.getDatas())
				&& WaybusicircleDP.getDatas().size() > 0){
			wbVO = (WaybusicircleVO)WaybusicircleDP.getDatas().get(0);
		}
		
		for (int i = 0; i < fields.length; i++) {
			switch (i) {
			// 渠道编码
			case 0:
				if ("".equals(fields[i])
						|| fields[i].getBytes("GBK").length > 18) {
					throw new Exception("[渠道编号]不能为空或大于18位");
				}
				break;
			// 渠道名称
			case 1:
				if (!"".equals(fields[i])
						&& fields[i].getBytes("GBK").length > 256) {
					throw new Exception("[渠道名称]不能大于256位");
				}
				break;
			// 零售渠道类别
			case 2:
//				Way way = (Way) BOFactory.build(WayBO.class, user);
//				WayVO vo = way.doFindByPk(fields[0].trim());
//				if (vo == null) {
//					throw new Exception("所需要修改的渠道不存在");
//				} else {
//					if ("AG".equals(vo.getWaytype())) {
//						if (!"SAGT".equals(vo.getWaysubtype())
//								&& !"PSAL".equals(vo.getWaysubtype())
//								&& !"FD".equals(vo.getWaysubtype())
//								&& !"FDS".equals(vo.getWaysubtype())
//								&& !"VWAY".equals(vo.getWaysubtype())) {
//							throw new Exception("非[网点]类型的渠道不能在此菜单修改");
//						}
//					} else {
//						throw new Exception("非[社会渠道]类型的渠道不能在此菜单修改");
//					}
//				}
				if (!"".equals(fields[i])
						&& fields[i].getBytes("GBK").length > 4) {
					throw new Exception("[零售渠道类别]不能大于4位");
				} else if (!"".equals(fields[i])
						&& !"SAGT".equals(fields[i].trim())
						&& !"PSAL".equals(fields[i].trim())
						&& !"FD".equals(fields[i].trim())
						&& !"FDS".equals(fields[i].trim())
						&& !"VWAY".equals(fields[i].trim())
						&& !"JMQD".equals(fields[i].trim())) {
					throw new Exception("此菜单只能录入[网点类型]的社会渠道");
				}
				/* start add for BR201306180003_关于渠道子类别星级取值范围需求概要设计  by feng */
				if(!"".equals(fields[i]) && "".equals(fields[4])){
					if(!"SAGT".equals(fields[i]) && wayVO.getStarlevel().toString().matches("[1-3]{1}")){
						throw new Exception("此渠道的星级为1-3之间时，上传[零售渠道类别]只能为特约代理点(SGAT)。");
					}else if(!"PSAL".equals(fields[i]) && wayVO.getStarlevel().toString().matches("[4-7]{1}")){
						throw new Exception("此渠道的星级为4-7之间时，上传[零售渠道类别]只能为指定专营店(PSAL)。");
					}else if(!"JMQD".equals(fields[i]) && wayVO.getStarlevel().toString().matches("[8]{1}")){
						throw new Exception("此渠道的星级为8时，上传[零售渠道类别]只能为连锁加盟渠道(JMQD)。");
					}else if(!"PSAL".equals(fields[i]) && wayVO.getStarlevel().toString().matches("[9]{1}")){
						throw new Exception("此渠道的星级为9时，上传[零售渠道类别]只能为指定专营店(PSAL)。");
					}else if(("SAGT".equals(fields[i]) || "PSAL".equals(fields[i])) && wayVO.getStarlevel().toString().matches("[0]{1}")){
						throw new Exception("此渠道的星级为0，上传[零售渠道类别]只能选择FD服务店(FD)或者FD连锁店(FDS)或者虚拟渠道(VWAY)。");
					}
				}
				/* end add for BR201306180003_关于渠道子类别星级取值范围需求概要设计  by feng */
				break;
			// 上级渠道编码
			case 3:
				if (fields[i].getBytes("GBK").length > 18) {
					throw new Exception("[上级渠道编码]不能大于18位");
				}
				if (!StringUtils.isBlank(fields[i])) {
					checkUppserwayid(fields[i]);
				}
				break;
			// 星级
			case 4:
				if (fields[i].getBytes("GBK").length > 2) {
					throw new Exception("[星级]不能大于2位");
				}
				starlevel = fields[i];
				/* start add for BR201306180003_关于渠道子类别星级取值范围需求概要设计  by feng */
				if(!"".equals(starlevel)){
					if("".equals(fields[2])){
						if(!starlevel.matches("[1-3]{1}") && "SAGT".equals(wayVO.getWaysubtype())){
							throw new Exception("零售渠道类别为特约代理点(SGAT)，上传[星级]范围必须为1-3。");
						}else if((!starlevel.matches("[4-7]{1}") && !starlevel.matches("[9]{1}") ) && "PSAL".equals(wayVO.getWaysubtype())){
							throw new Exception("零售渠道类别为指定专营店(PSAL)，上传[星级]范围必须为4-7 或9。");
						}else if(!starlevel.matches("[8]{1}") && "JMQD".equals(wayVO.getWaysubtype())){
							throw new Exception("零售渠道类别为连锁加盟渠道(JMQD)，上传[星级]范围必须为8。");
						}else if(!starlevel.matches("[0]{1}") && ("FD".equals(wayVO.getWaysubtype()) || "FDS".equals(wayVO.getWaysubtype()) || "VWAY".equals(wayVO.getWaysubtype()))){
							throw new Exception("零售渠道类别为FD服务店(FD)或者FD连锁店(FDS)或者虚拟渠道(VWAY)，上传[星级]范围必须为0。");
						}
					}else{
						if(starlevel.matches("[1-3]{1}") && !"SAGT".equals(fields[2])){
							throw new Exception("上传[星级]范围为1-3时，上传[零售渠道类别]必须为特约代理点(SGAT)。");
						}else if(starlevel.matches("[4-7]{1}") && !"PSAL".equals(fields[2])){
							throw new Exception("上传[星级]范围为4-7时，上传[零售渠道类别]必须为指定专营店(PSAL)。");
						}else if(starlevel.matches("[8]{1}") && !"JMQD".equals(fields[2])){
							throw new Exception("上传[星级]范围为8时，上传[零售渠道类别]必须为连锁加盟渠道(JMQD)。");
						}else if(starlevel.matches("[9]{1}") && !"PSAL".equals(fields[2])){
							throw new Exception("上传[星级]为9时，上传[零售渠道类别]必须为指定专营店(PSAL)。");
						}else if(starlevel.matches("[0]{1}") && ("SAGT".equals(fields[2]) || "PSAL".equals(fields[2]) )){
							throw new Exception("上传[星级]范围必须为0时，上传[零售渠道类别]可以选择FD服务店(FD)或者FD连锁店(FDS)或者虚拟渠道(VWAY)。");
						}else if(user.getCityid().equalsIgnoreCase("MM") && starlevel.equals("60") && !"PSAL".equals(fields[2].trim())) {
							throw new Exception("上传[星级]为60（6A）时，零售渠道类别必须为:指定专营店（PSAL）。");
						}
						//TODO
					}					
				}
				/* end add for BR201306180003_关于渠道子类别星级取值范围需求概要设计  by feng */
				/* start add for (2013)NBBOSS- D0019 渠道优化概要设计     by feng */
				if(!"".equals(starlevel) && "".equals(fields[73])){
					if(0==wbVO.getRewardkind() && ("7".equals(starlevel) || "8".equals(starlevel) || "9".equals(starlevel))){
						throw new Exception("此渠道为2G渠道，需上传2G渠道星级");
					}
					if(1==wbVO.getRewardkind() && !"7".equals(starlevel)){
						throw new Exception("此渠道为3G渠道，需上传3G渠道星级");
					}
					if(2==wbVO.getRewardkind() && !"8".equals(starlevel)){
						throw new Exception("此渠道为连锁加盟渠道，需上传连锁加盟渠道星级");
					}
					if(3==wbVO.getRewardkind() && !"9".equals(starlevel)){
						throw new Exception("此渠道为4G渠道，需上传4G渠道专用星级");
					}
				}
				/* end add for (2013)NBBOSS- D0019 渠道优化概要设计     by feng */				
				break;
			// 排他性
			case 5:
				if (fields[i].getBytes("GBK").length > 2) {
					throw new Exception("[排他性]不能大于2位");
				}
				break;
			// 状态
			case 6:
				if (!customeFlag) {
					
						if ("".equals(fields[i])
								|| !fields[i].matches("[0,1]{1}")) {
							throw new Exception("[状态]不能为空或并只能为0,1数字");
						}
					
				} else {
					if (!"".equals(fields[i])) {
						
							if ("".equals(fields[i])
									|| !fields[i].matches("[0,1]{1}")) {
								throw new Exception("[状态]不能为空或并只能为0,1数字");
							}
						
					}
				}
				break;
			// 地市公司
			case 7:
				if (!"".equals(fields[i]) && !checkCity(fields[i])) {
					throw new Exception("[地市公司]格式不对,不能大于14位且须与系统一致");
				}
				;
				break;

			// 分公司
			case 8:
				if (!"".equals(fields[i])
						&& !checkCounty(fields[i], fields[i - 1])) {
					throw new Exception("[分公司]格式不对,必须与当前登录渠道相同不能大于14位或者必须是"
							+ fields[i - 1] + "的下设分公司");
				}
				break;

			// 服务销售中心
			case 9:
				if (!checkSvccode(fields[i], fields[i - 1])) {
					throw new Exception("[服务销售中心]格式不对,不能大于14位且须是"
							+ fields[i - 1] + "的下设服务销售中心");
				}
				break;

			// 微区域
			case 10:
				if (!checkMicroarea(fields[i], fields[i - 1])) {
					throw new Exception("[微区域]格式不对,不能大于14位且须是" + fields[i - 1]
							+ "的下设微区域");
				}
				break;
			// 是否直供
			case 11:
				if (!"".equals(fields[i]) && !fields[i].matches("[0-9]{1,2}")) {
					throw new Exception("[是否直供]格式不对,正确为2位数字之内");
				}
				break;
			// 区域类型
			case 12:
				if (!"".equals(fields[i]) && !fields[i].matches("[0-9]{1,2}")) {
					throw new Exception("[区域类型]格式不对,正确为2位数字之内");
				}
				break;
			// 行政区划
			case 13:
				if (fields[i].getBytes("GBK").length > 18) {
					throw new Exception("[行政区划]不能大于18位");
				}
				break;
			// 业态类型
			case 14:
				if (!"".equals(fields[i]) && !fields[i].matches("[0-9]{1,2}")) {
					throw new Exception("[业态类型]格式不对,正确为2位数字之内");
				}
				if (!"ZJ".equals(fields[7])){
					if("16".equals(fields[i])){
	                	//此【卖场加盟厅】业态类型为湛江地市专用，请选择其他业态类型
						throw new Exception("此【卖场加盟厅】业态类型为湛江地市专用，请选择其他业态类型");
					}
				}
				break;
			// 开业时间
			// case 15:
			// try {
			// if (!"".equals(fields[i]))
			// date.parse(fields[i]);
			// } catch (ParseException pe) {
			// throw new Exception("[开业时间]格式不对,应为yyyy-MM-dd");
			// }
			// break;
			// 营业面积
			case 15:
				if (!"".equals(fields[i]) && !fields[i].matches("[0-9]{1,8}")) {
					throw new Exception("[营业面积]不能为空，且只能为小于、等于8位数字");
				}
				break;
			// 所属物流商
			case 16:
				if (fields[i].getBytes("GBK").length > 18) {
					throw new Exception("[所属物流商]不能大于18位");
				}
				break;
			// 所属渠道经理
			case 17:
				if (fields[i].getBytes("GBK").length > 18) {
					throw new Exception("[所属渠道经理]不能大于18位");
				}
				break;
			// 分级
			case 18:
				if (fields[i].getBytes("GBK").length > 4) {
					throw new Exception("[分级]格式不对,不能大于4位");
				}
				break;
			// 采集平台捆绑手机号 公务机号码
			case 19:
				if (fields[i].getBytes("GBK").length > 12
						|| !StringUtils.isNumeric(fields[i])) {
					throw new Exception("[公务机号码]格式不对,不能大于12位且必须是数字");
				}
				break;
			// 业务预警量
			case 20:
				if (!"".equals(fields[i]) && !fields[i].matches("[0-9]{1,10}")) {
					throw new Exception("[业务预警量]格式不对,正确为10位数字之内");
				}
				break;
			// 详细地址
			case 21:
				if (fields[i].getBytes("GBK").length > 128) {
					throw new Exception("[详细地址]格式不对,不能大于128");
				}
				break;
			// 地理纬度
			case 22:
				if (fields[i].getBytes("GBK").length > 15
						|| (!"".equals(fields[i]) && (!fields[i]
								.matches("[0-9]{1,15}.[0-9]{6}")
								|| new Double(fields[i]).doubleValue() < 18 || new Double(
								fields[i]).doubleValue() > 26))) {
					throw new Exception("[地理纬度]格式不对，长度不能大于15，精确到6位小数，且在18和26之间");
				}
				break;
			// 地理经度
			case 23:
				if (fields[i].getBytes("GBK").length > 15
						|| (!"".equals(fields[i]) && (!fields[i]
								.matches("[0-9]{1,15}.[0-9]{6}")
								|| new Double(fields[i]).doubleValue() < 100 || new Double(
								fields[i]).doubleValue() > 130))) {
					throw new Exception(
							"[地理经度]格式不对，长度不能大于15，精确到6位小数，且在100和130之间");
				}
				break;
			// 业主姓名
			case 24:
				if (!"".equals(fields[i])
						&& fields[i].getBytes("GBK").length > 64) {
					throw new Exception("[业主姓名]格式不对,不能大于64");
				}
				break;
			// 业主电话
			case 25:
				if (!"".equals(fields[i])
						&& fields[i].getBytes("GBK").length > 20) {
					throw new Exception("[业主电话]格式不对,不能大于20");
				}
				break;
			// 业主固定电话
			case 26:
				if (fields[i].getBytes("GBK").length > 20) {
					throw new Exception("[业主固定电话]格式不对,不能大于20");
				}
				break;
			// 业主电子信箱
			case 27:
				if (fields[i].getBytes("GBK").length > 128) {
					throw new Exception("[业主电子信箱]格式不对,不能大于128");
				}
				break;
			// 送货地址
			case 28:
				if (fields[i].getBytes("GBK").length > 128) {
					throw new Exception("[送货地址]格式不对,不能大于128");
				}
				break;
			// 收货联系人
			case 29:
				if (fields[i].getBytes("GBK").length > 32) {
					throw new Exception("[收货联系人]格式不对,不能大于32");
				}
				break;
			// 收货联系号码
			case 30:
				if (fields[i].getBytes("GBK").length > 15) {
					throw new Exception("[收货联系号码]格式不对,不能大于15");
				}
				break;
			// 收货人证件号码
			case 31:
				if (fields[i].getBytes("GBK").length > 20) {
					throw new Exception("[收货人证件号码]格式不对,不能大于20");
				}
				break;
			// 签约类型
			case 32:
				if (!"".equals(fields[i]) && !fields[i].matches("[0-9]{1,2}")) {
					throw new Exception("[签约类型]格式不对,正确为2位数字之内");
				}
				break;
			// 合同编码
			case 33:
				if (!"".equals(fields[i])
						&& fields[i].getBytes("GBK").length > 40 ) {
					throw new Exception("[合同编码]格式不对,不能大于40");
				}
				break;
			// 合同协议名称
			case 34:
				if (!"".equals(fields[i])
						&& fields[i].getBytes("GBK").length > 255) {
					throw new Exception("[合同协议名称]格式不对,不能大于255");
				}
				break;
			// 签署合同时间
			case 35:
				try {
					if (!"".equals(fields[i]))
						date.parse(fields[i]);
				} catch (ParseException pe) {
					throw new Exception("[签署合同时间]格式不对,应为yyyy-MM-dd");
				}
				break;
			// 合同生效日
			case 36:
				try {
					if (!"".equals(fields[i]))
						date.parse(fields[i]);
				} catch (ParseException pe) {
					throw new Exception("[合同生效日]格式不对,应为yyyy-MM-dd");
				}
				break;
			// 合同到期日
			case 37:
				try {
					if (!"".equals(fields[i]))
						date.parse(fields[i]);
				} catch (ParseException pe) {
					throw new Exception("[合同到期日]格式不对,应为yyyy-MM-dd");
				}
				break;
			// 营业执照编号
			case 38:
				if (!"".equals(fields[i])
						&& fields[i].getBytes("GBK").length > 64) {
					throw new Exception("[营业执照编号]格式不对,不能大于64");
				}
				break;
			// 营业执照有效期
			case 39:
				try {
					if (!"".equals(fields[i]))
						date.parse(fields[i]);
				} catch (ParseException pe) {
					throw new Exception("[营业执照有效期]格式不对,应为yyyy-MM-dd");
				}
				break;
			// 保证金押金
			case 40:
				if (!"".equals(fields[i])
						&& !fields[i].matches("[0-9]{1,18}(.?)[0-9]{0,2}")) {
					throw new Exception("[保证金押金]格式不对,正确为最多两位小数的18位数字之内");
				}
				break;
			// 保证金押金状态
			case 41:
				if (!"".equals(fields[i]) && !fields[i].matches("[0-9]{1,2}")) {
					throw new Exception("[保证金押金状态]格式不对,正确为2位数字之内");
				}
				break;
			// 保证金下限
			case 42:
				if (!"".equals(fields[i])
						&& !fields[i].matches("[0-9]{1,18}(.?)[0-9]{0,2}")) {
					throw new Exception("[保证金下限]格式不对,正确为最多两位小数的16位数字之内");
				}
				break;
			// 开户银行
			case 43:
				if (!"".equals(fields[i])
						&& fields[i].getBytes("GBK").length > 128) {
					throw new Exception("[开户银行]格式不对,不能大于128");
				}
				break;
			// 银行帐号
			case 44:
				if (!"".equals(fields[i])
						&& fields[i].getBytes("GBK").length > 50) {
					throw new Exception("[银行帐号]格式不对,不能大于50");
				}
				break;
			// 开户账号名称
			case 45:
				if (!"".equals(fields[i])
						&& fields[i].getBytes("GBK").length > 128) {
					throw new Exception("[开户账号名称]格式不对,不能大于128");
				}
				break;
			// 开户人身份证号码38
			case 46:
				if (StringUtils.isNotBlank(fields[i])) {
					if (!(15 == fields[i].length() || 18 == fields[i].length())) {
						throw new Exception("[开户人身份证号码]长度必须为15位或者18位!");
					}
				}
				break;
			case 47:
				if (!"".equals(fields[i]) && !fields[i].matches("[0-9]{1,2}")) {
					throw new Exception("[签约状态]格式不对,正确为2位数字之内");
				}
				break;
			case 48:
				if (!"".equals(fields[i]) && !fields[i].matches("[0-9]{1,2}")) {
					throw new Exception("[保证金交付形式]格式不对,正确为2位数字之内");
				}
				break;
			case 49:
				if (!"".equals(fields[i]) && !fields[i].matches("[0-9]{1,3}")) {
					throw new Exception("[经营范围]格式不对,正确为3位数字之内");
				}
				break;
			case 50:
				if (fields[i].getBytes().length > 18) {
					throw new Exception("[全省代码]格式不对,长度不应该大于18位");
				}
				break;
			// deacctno,deacctname,debankname
			case 51:
				if (!"".equals(fields[i])
						&& fields[i].getBytes("GBK").length > 50) {
					throw new Exception("[卡类购销划扣银行账号]格式不对,长度不能超过50");
				}
				break;
			case 52:
				if (!"".equals(fields[i])
						&& fields[i].getBytes("GBK").length > 128) {
					throw new Exception("[卡类购销划扣帐号名称]格式不对,长度不能超过128");
				}
				break;
			case 53:
				if (!"".equals(fields[i])
						&& fields[i].getBytes("GBK").length > 128) {
					throw new Exception("[卡类购销划扣开户银行]格式不对,长度不能超过128");
				}
				break;
			case 54:
				if (!"".equals(fields[i])
						&& fields[i].getBytes("GBK").length > 18) {
					throw new Exception("[合作商编码]格式不对,长度不能超过18");
				}else {
					if (!fields[i].equals("0000") && !"".equals(fields[i])){
						WayDBParam waylistvo = new WayDBParam();
						waylistvo.set_se_waytype("AG");
						waylistvo.set_se_waysubtype("DIS");
						waylistvo.set_ne_waystate("1");
						waylistvo.set_se_wayid(fields[i]);
						//.query(waylistvo)
						if (delegate.doQuery(waylistvo).getRowCount() <= 0) {
							throw new Exception( "所属合作商编码:" +fields[i]
									+ "不存在或者不是连锁经营合作商");
						}
						}
				}
				break;
			case 55:
				if (!"".equals(fields[i]) && !fields[i].matches("[0,1]{1}")) {
					throw new Exception("[是否加入B2M模式]只能为0或1");
				}
				break;
			case 56:
				if (!"".equals(fields[i]) && !fields[i].matches("[0-9]{1}")) {
					throw new Exception("[账号类型]只能为一位数字");
				}
				break;
			case 57:
				if (!"".equals(fields[i])
						&& fields[i].getBytes("GBK").length > 32) {
					throw new Exception("[卡类购销划扣银行标识]格式不对,长度不能超过32");
				}
				break;
			case 58:
				if (!"".equals(fields[i]) && !fields[i].matches("[0,1]{1}")) {
					throw new Exception("[卡类购销划扣银行状态]只能为0或1");
				}
				break;
			// 合作类型
			case 59:
				if (fields[i].getBytes("GBK").length > 4) {
					throw new Exception("[合作类型]格式不对,不能大于4位");
				}
				break;
			// 网点注册码
			case 60:
				if (!"".equals(fields[i])
						&& !fields[i].matches("[0-9a-zA-Z]{11}")) {
					throw new Exception("[网点注册码]格式不对,只能为数字和字母且长度为11位");
				}
				break;

			/*case 61:
				if (!customeFlag) {//add by ydr
					if ("".equals(fields[i])) {
						throw new Exception("[是否授权]不能为空");
					}
				}
				if (!"".equals(fields[i])) {
					if (!"Y".equals(fields[i].trim())
							&& !"N".equals(fields[i].trim())) {
						throw new Exception("[是否授权]格式不对,只能为Y或者N");
					}
				}
				break;*/
			// 主要业务支撑方式
			case 61:
				if (!customeFlag) {
					if (!"99".equals(fields[i])) {
						if ("".equals(fields[i])
								|| !fields[i]
										.matches("[0,1,2,3,4,5,6,7,8,9,99]{1}")) {
							throw new Exception(
									"[主要业务支撑方式]不能为空且只能为0、1、2、3、4、5、6、7、8、9、99中的值");
						}
					}
				}
				break;
			// 是否接入空中充值平台
			case 62:
				if (!customeFlag) {
					if ("".equals(fields[i]) || !fields[i].matches("[0,1]{1}")) {
						throw new Exception("[是否接入空中充值平台]不能为空且只能为0或1");
					}
				} else {
					if (!"".equals(fields[i])) {
						if (!fields[i].matches("[0,1]{1}")) {
							throw new Exception("[是否接入空中充值平台]不能为空且只能为0或1");
						}
					}
				}
				break;
			// 全网统一渠道编码
			case 63:
				if (fields[i].getBytes("GBK").length > 30) {
					throw new Exception("[全网统一渠道编码]格式不对,不能大于30");
				}
				if (fields[i] != null && !"".equals(fields[i])) {
					String uwi = fields[i] == null ? "" : fields[i];
					String wi = fields[0] == null ? "" : fields[0];

					Wayprovince wayprovince = (Wayprovince) BOFactory.build(
							WayprovinceBO.class, user);
					List wList = wayprovince.doQueryWpByWayid(wi);
					List uList = wayprovince.doQueryWpByUniquewayid(uwi);

					if (wList != null && !"".equals(wList) && wList.size() > 0) {
						// 更新
						if (uList != null && !"".equals(uList)
								&& uList.size() > 0) {
							// 存在全网统一渠道编码
							WayprovinceVO wVO1 = (WayprovinceVO) uList.get(0);
							if (wi.equals(wVO1.getWayid())) {
								// 相同wayid记录才能更新

							} else {
								throw new Exception(wVO1.getWayid()
										+ "  已经存在全网统一渠道编码："
										+ wVO1.getUniquewayid() + "");

							}
						} else {
							// 没有“全网统一渠道编码”，可以直接更新

						}
					} else {
						// 新增
						if (uList != null && !"".equals(uList)
								&& uList.size() > 0) {
							// 存在全网统一渠道编码
							WayprovinceVO wVO1 = (WayprovinceVO) uList.get(0);
							throw new Exception(wVO1.getWayid()
									+ "  已经存在全网统一渠道编码：" + wVO1.getUniquewayid()
									+ "");

						} else {
							// 没有“全网统一渠道编码”，可以直接新增

						}

					}
				}
				break;
			// 乡镇
			case 64:
				if (fields[i].getBytes("GBK").length > 30) {
					throw new Exception("[乡镇]格式不对,不能大于30");
				}
				break;
			// 渠道基础类型
			case 65:
				if (!"".equals(fields[i]) && !fields[i].matches("[0,3]{1}")) {
					throw new Exception("[渠道基础类型]格式不对,只能为0,3中的值");
				}
				break;
			// 是否卖场加盟
			case 66:
				if (!"".equals(fields[i]) && !fields[i].matches("[0,1]{1}")) {
					throw new Exception("[是否卖场加盟]格式不对,只能为0、1中的值");
				}
				break;
			// 前台营业面积（㎡）
			case 67:
				if ("".equals(fields[i])) {

				} else {
					int loca = fields[i].indexOf(".");
					if (loca >= 0) {
						// 有小数点
						if (loca == 0 || loca == (fields[i].length() - 1)) {
							// 首位、未位小数
							throw new Exception(
									"[前台营业面积（㎡）]格式不对,整数位不超过8位、小数位不超过2位");
						}
						String strs[] = fields[i].split("\\.");
						if (strs.length > 2) {
							// 多个小数点
							throw new Exception(
									"[前台营业面积（㎡）]格式不对,整数位不超过8位、小数位不超过2位");
						} else {
							// 一个小数点
							if ((strs[0].length() + strs[1].length()) > 10) {
								throw new Exception(
										"[前台营业面积（㎡）]格式不对,整数位不超过8位、小数位不超过2位");
							} else {
								if (!strs[0].matches("[0-9]{1,8}")
										|| !strs[1].matches("[0-9]{1,2}")) {
									throw new Exception(
											"[前台营业面积（㎡）]格式不对,整数位不超过8位、小数位不超过2位");
								}
							}
						}
					} else {// 数字
						if (!fields[i].matches("[0-9]{1,8}")) {
							throw new Exception(
									"[前台营业面积（㎡）]格式不对,整数位不超过8位、小数位不超过2位");
						}
					}
				}
				break;
			// 运营商ISP接入方式
			case 68:
				if (!"".equals(fields[i]) && !fields[i].matches("[0,1,2,3]{1}")) {
					throw new Exception("[运营商ISP接入方式]格式不对,只能为0、1、2、3中的值");
				}
				break;
			// 是否加入全员代理模式
			case 69:
				if (!customeFlag) {
					if ("".equals(fields[i]) || !fields[i].matches("[0,1]{1}")) {
						throw new Exception("[是否加入全员代理模式]不能为空且只能为0或1");
					}
				} else {
					if (!"".equals(fields[i])) {
						if (!fields[i].matches("[0,1]{1}")) {
							throw new Exception("[是否加入全员代理模式]不能为空且只能为0或1");
						}
					}
				}
				break;
			// 星级分层
			case 70:
				if (!customeFlag) {
					if ("".equals(fields[i])
							|| !fields[i].matches("[1,2,3]{1}")) {
						throw new Exception("[星级分层]不能为空且只能为1、2、3");
					}
				} else {
					if (!"".equals(fields[i])) {
						if (!fields[i].matches("[1,2,3]{1}")) {
							throw new Exception("[星级分层]不能为空且只能为1、2、3");
						}
					}
				}
				break;
			// 商圈类型
			case 71:
				if (!customeFlag) {
					if ("".equals(fields[i])) {
						throw new Exception("[商圈类型]不能为空");
					}
					
					if (!"99".equals(fields[i]) && !fields[i].matches("[1,5,6,7]{1}")) {
						throw new Exception("[商圈类型]格式不对，只能为1,5,6,7,99");
					}
				} else {
					if (!"".equals(fields[i])) {
						if (!"99".equals(fields[i]) && !fields[i].matches("[1,5,6,7]{1}")) {
							throw new Exception("[商圈类型]格式不对，只能为1,5,6,7,99");
						}
					}
				}
				break;
			// 是否TOP网点
			case 72:
				if (!customeFlag) {
					if (!fields[i].matches("[0,1]{1}")) {
						throw new Exception("[是否TOP网点]格式不对,只能为0,1");
					}
				}else{
					if (!"".equals(fields[i])) {
						if (!fields[i].matches("[0,1]{1}")) {
							throw new Exception("[是否TOP网点]格式不对,只能为0,1");
						}
					}
				}
				break;
			/* star uppdate for (2013)NBBOSS- D0019 渠道优化概要设计     by feng */
			// 社会渠道类型
			case 73:
				if (!customeFlag) {
					rewardkind = fields[i];
					if (fields[i] == null || "".equals(fields[i])) {
						throw new Exception("[社会渠道类型]不能为空");
					}
					if("0".equals(rewardkind) || "1".equals(rewardkind) || "2".equals(rewardkind)|| "3".equals(rewardkind)){
						if ("0".equals(rewardkind) && 0==wbVO.getRewardkind()){
							if ("7".equals(starlevel) || ("7".equals(wayVO.getStarlevel()) && (null == starlevel || "".equals(starlevel)))){
								throw new Exception(exceptionMsg);
							}
							if ("8".equals(starlevel) || ("8".equals(wayVO.getStarlevel()) && (null == starlevel || "".equals(starlevel)))){
								throw new Exception(exceptionMsg);
							}
							if ("9".equals(starlevel) || ("9".equals(wayVO.getStarlevel()) && (null == starlevel || "".equals(starlevel)))){
								throw new Exception(exceptionMsg);
							}
							if (!"".equals(fields[75]) || !"".equals(fields[76])){
								fields[75]=null;
								fields[76]=null;
								wayVO.setWaymod(null);
								wayVO.setWayattr(null);
								}
						}else if ("0".equals(rewardkind) && 1==wbVO.getRewardkind()){//3G转2G
							if ("7".equals(starlevel) || ("7".equals(wayVO.getStarlevel()) && (null == starlevel || "".equals(starlevel)))){
								throw new Exception("此渠道为3G渠道转变为2G渠道，需上传1-6星级值");
							}
							if ("8".equals(starlevel) || ("8".equals(wayVO.getStarlevel()) && (null == starlevel || "".equals(starlevel)))){
								throw new Exception("此渠道为3G渠道转变为2G渠道，需上传1-6星级值");
							}
							if ("9".equals(starlevel) || ("9".equals(wayVO.getStarlevel()) && (null == starlevel || "".equals(starlevel)))){
								throw new Exception("此渠道为3G渠道转变为2G渠道，需上传1-6星级值");
							}
							if ((fields[75] != null && !"".equals(fields[75])) || (fields[76] != null && !"".equals(fields[76]))){
								fields[75]=null;
								fields[76]=null;
								wayVO.setWaymod(null);
								wayVO.setWayattr(null);
								}
						}else if ("0".equals(rewardkind) && 2==wbVO.getRewardkind()){//连锁加盟渠道转2G
							if ("8".equals(starlevel) || ("8".equals(wayVO.getStarlevel()) && (null == starlevel || "".equals(starlevel)))){
								throw new Exception("此渠道为连锁加盟渠道转2G渠道，需上传1-6星级值");
							}
							if ("9".equals(starlevel) || ("9".equals(wayVO.getStarlevel()) && (null == starlevel || "".equals(starlevel)))){
								throw new Exception("此渠道为连锁加盟渠道转2G渠道，需上传1-6星级值");
							}
							
						}else if ("1".equals(rewardkind) && 0==wbVO.getRewardkind()){//2G转3G
							if (!"7".equals(starlevel) && !"7".equals(wayVO.getStarlevel())){
								throw new Exception("此渠道为2G渠道转变为3G渠道，需上传3G渠道专用星级");
							}
							if ("".equals(fields[75]) || null == fields[75] || "".equals(fields[76]) || null == fields[76]){
								throw new Exception("此渠道为2G渠道转3G渠道，则必须上传【社会渠道加盟属性】、【社会渠道加盟系数】2个属性值");
								}
							if ("A+1".equals(fields[75])){
								throw new Exception("此渠道为2G渠道转变为3G渠道，只有4G渠道连锁加盟渠道属性才能为A+1 (专营重要商圈)");
							}
							if (!"DG".equals(fields[7]) || !"DG".equals(wayVO.getCityid())){
								if("2Q".equals(fields[75]) || "3Q".equals(fields[75]) || "4Q".equals(fields[75]) || "A3".equals(fields[75]) || "B3".equals(fields[75]) || "C3".equals(fields[75])){
				                	//此【'+wayattr+'】连锁加盟渠道属性为东莞地市专用，请选择其他连锁加盟渠道属性
									throw new Exception("此【"+fields[75]+"】连锁加盟渠道属性为东莞地市专用，请选择其他连锁加盟渠道属性");
								}
							}
						}else if ("1".equals(rewardkind) && 1==wbVO.getRewardkind()){//3G转3G要判断星级
							if (!"7".equals(starlevel) && !"7".equals(wayVO.getStarlevel())){
								throw new Exception("此渠道为3G渠道，需上传3G渠道专用星级");
							}
							if ("A+1".equals(fields[75])){
								throw new Exception("此渠道为3G渠道，只有4G渠道连锁加盟渠道属性才能为A+1 (专营重要商圈)");
							}
							if (!"DG".equals(fields[7]) || !"DG".equals(wayVO.getCityid())){
								if("2Q".equals(fields[75]) || "3Q".equals(fields[75]) || "4Q".equals(fields[75]) || "A3".equals(fields[75]) || "B3".equals(fields[75]) || "C3".equals(fields[75])){
				                	//此【'+wayattr+'】连锁加盟渠道属性为东莞地市专用，请选择其他连锁加盟渠道属性
									throw new Exception("此【"+fields[75]+"】连锁加盟渠道属性为东莞地市专用，请选择其他连锁加盟渠道属性");
								}
							}
							
						}else if ("1".equals(rewardkind) && 2==wbVO.getRewardkind()){//连锁加盟渠道转3G
							if (!"7".equals(starlevel) && !"7".equals(wayVO.getStarlevel())){
								throw new Exception("此渠道为连锁加盟渠道转3G渠道，需上传3G渠道专用星级");
							}
							if ("".equals(fields[75]) || null == fields[75] || "".equals(fields[76]) || null == fields[76]){
								throw new Exception("此渠道为连锁加盟渠道转3G渠道，则必须上传【社会渠道加盟属性】、【社会渠道加盟系数】2个属性值");
								}
							if ("A+1".equals(fields[75])){
								throw new Exception("此渠道为连锁加盟渠道转3G渠道，只有4G渠道连锁加盟渠道属性才能为A+1 (专营重要商圈)");
							}
							if (!"DG".equals(fields[7]) || !"DG".equals(wayVO.getCityid())){
								if("2Q".equals(fields[75]) || "3Q".equals(fields[75]) || "4Q".equals(fields[75]) || "A3".equals(fields[75]) || "B3".equals(fields[75]) || "C3".equals(fields[75])){
				                	//此【'+wayattr+'】连锁加盟渠道属性为东莞地市专用，请选择其他连锁加盟渠道属性
									throw new Exception("此【"+fields[75]+"】连锁加盟渠道属性为东莞地市专用，请选择其他连锁加盟渠道属性");
								}
							}
						}else if ("2".equals(rewardkind) && 0==wbVO.getRewardkind()){//此渠道由‘2G渠道’变成‘连锁加盟渠道’
							if (!"8".equals(starlevel) && !"8".equals(wayVO.getStarlevel())){
								throw new Exception("此渠道为2G渠道转变为连锁加盟渠道，需上传8星级值（连锁加盟渠道星级）");
							}
							
						}else if ("2".equals(rewardkind) && 1==wbVO.getRewardkind()){//此渠道由‘3G渠道’变成‘连锁加盟渠道’
							if (!"8".equals(starlevel) && !"8".equals(wayVO.getStarlevel())){
								throw new Exception("此渠道为3G渠道转变为连锁加盟渠道，需上传8星级值（连锁加盟渠道星级）");
							}
							if (!"".equals(fields[75]) || null != fields[75] || !"".equals(fields[76]) || null != fields[76]){
								fields[75]=null;
								fields[76]=null;
								wayVO.setWaymod(null);
								wayVO.setWayattr(null);
							}
							 
						}else if ("2".equals(rewardkind) && 2==wbVO.getRewardkind()){//此渠道由‘连锁加盟渠道’变成‘连锁加盟渠道’要判断星级
							if (!"8".equals(starlevel) && !"8".equals(wayVO.getStarlevel())){
								throw new Exception("此渠道为连锁加盟渠道，需上传8星级值（连锁加盟渠道星级）");
							}
							if (!"".equals(fields[75]) || null != fields[75] || !"".equals(fields[76]) || null != fields[76]){
								fields[75]=null;
								fields[76]=null;
								wayVO.setWaymod(null);
								wayVO.setWayattr(null);
							}
							 
						}else if ("3".equals(rewardkind) && 0==wbVO.getRewardkind()){//2G转4G
							if (!"9".equals(starlevel) && !"9".equals(wayVO.getStarlevel())){
								throw new Exception("此渠道为2G渠道转变为4G渠道，需上传4G渠道专用星级");
							}
							if ("".equals(fields[75]) || null == fields[75] || "".equals(fields[76]) || null == fields[76]){
								throw new Exception("此渠道2G渠道转4G渠道，则必须上传【社会渠道加盟属性】、【社会渠道加盟系数】2个属性值");
							}
//							if (!"A+1".equals(fields[75]) && !"A+1".equals(wayVO.getWayattr())){
//								throw new Exception("此渠道为2G渠道转变为4G渠道，连锁加盟渠道属性必须为A+1 (专营重要商圈)");
//							}
							if (!"DG".equals(fields[7]) || !"DG".equals(wayVO.getCityid())){
								if("2Q".equals(fields[75]) || "3Q".equals(fields[75]) || "4Q".equals(fields[75]) || "A3".equals(fields[75]) || "B3".equals(fields[75]) || "C3".equals(fields[75])){
				                	//此【'+wayattr+'】连锁加盟渠道属性为东莞地市专用，请选择其他连锁加盟渠道属性
									throw new Exception("此【"+fields[75]+"】连锁加盟渠道属性为东莞地市专用，请选择其他连锁加盟渠道属性");
								}
							}
						}else if ("3".equals(rewardkind) && 1==wbVO.getRewardkind()){//3G转4G
							if (!"9".equals(starlevel) && !"9".equals(wayVO.getStarlevel())){
								throw new Exception("此渠道为3G渠道转变为4G渠道，需上传4G渠道专用星级");
							}
//							if (!"A+1".equals(fields[75]) && !"A+1".equals(wayVO.getWayattr())){
//								throw new Exception("此渠道为3G渠道转变为4G渠道，连锁加盟渠道属性必须为A+1 (专营重要商圈)");
//							}
							if (!"DG".equals(fields[7]) || !"DG".equals(wayVO.getCityid())){
								if("2Q".equals(fields[75]) || "3Q".equals(fields[75]) || "4Q".equals(fields[75]) || "A3".equals(fields[75]) || "B3".equals(fields[75]) || "C3".equals(fields[75])){
				                	//此【'+wayattr+'】连锁加盟渠道属性为东莞地市专用，请选择其他连锁加盟渠道属性
									throw new Exception("此【"+fields[75]+"】连锁加盟渠道属性为东莞地市专用，请选择其他连锁加盟渠道属性");
								}
							}
							
						}else if ("3".equals(rewardkind) && 2==wbVO.getRewardkind()){//连锁加盟渠道转4G
							if (!"9".equals(starlevel) && !"9".equals(wayVO.getStarlevel())){
								throw new Exception("此渠道为连锁加盟渠道转变为4G渠道，需上传4G渠道专用星级");
							}
							if ("".equals(fields[75]) || null == fields[75] || "".equals(fields[76]) || null == fields[76]){
								throw new Exception("此渠道连锁加盟渠道转4G渠道，则必须上传【社会渠道加盟属性】、【社会渠道加盟系数】2个属性值");
								}
//							if (!"A+1".equals(fields[75]) && !"A+1".equals(wayVO.getWayattr())){
//								throw new Exception("此渠道为连锁加盟渠道转4G渠道，连锁加盟渠道属性必须为A+1 (专营重要商圈)");
//							}
							if (!"DG".equals(fields[7]) || !"DG".equals(wayVO.getCityid())){
								if("2Q".equals(fields[75]) || "3Q".equals(fields[75]) || "4Q".equals(fields[75]) || "A3".equals(fields[75]) || "B3".equals(fields[75]) || "C3".equals(fields[75])){
				                	//此【'+wayattr+'】连锁加盟渠道属性为东莞地市专用，请选择其他连锁加盟渠道属性
									throw new Exception("此【"+fields[75]+"】连锁加盟渠道属性为东莞地市专用，请选择其他连锁加盟渠道属性");
								}
							}
						}else if ("3".equals(rewardkind) && 3==wbVO.getRewardkind()){//4G转4G要判断星级
							if (!"9".equals(starlevel) && !"9".equals(wayVO.getStarlevel())){
								throw new Exception("此渠道为4G渠道，需上传4G渠道专用星级");
							}
							if ("".equals(fields[75]) || null == fields[75] || "".equals(fields[76]) || null == fields[76]){
								throw new Exception("此渠道为2G渠道转4G渠道，则必须上传【社会渠道加盟属性】、【社会渠道加盟系数】2个属性值");
								}
//							if (!"A+1".equals(fields[75]) && !"A+1".equals(wayVO.getWayattr())){
//								throw new Exception("此渠道为4G渠道，连锁加盟渠道属性必须为A+1 (专营重要商圈)");
//							}
							if (!"DG".equals(fields[7]) || !"DG".equals(wayVO.getCityid())){
								if("2Q".equals(fields[75]) || "3Q".equals(fields[75]) || "4Q".equals(fields[75]) || "A3".equals(fields[75]) || "B3".equals(fields[75]) || "C3".equals(fields[75])){
				                	//此【'+wayattr+'】连锁加盟渠道属性为东莞地市专用，请选择其他连锁加盟渠道属性
									throw new Exception("此【"+fields[75]+"】连锁加盟渠道属性为东莞地市专用，请选择其他连锁加盟渠道属性");
								}
							}
						}else if ("0".equals(rewardkind) && 3==wbVO.getRewardkind()){//4G转2G
							if ("7".equals(starlevel) || ("7".equals(wayVO.getStarlevel()) && (null == starlevel || "".equals(starlevel)))){
								throw new Exception("此渠道为4G渠道转变为2G渠道，需上传1-6星级值");
							}
							if ("8".equals(starlevel) || ("8".equals(wayVO.getStarlevel()) && (null == starlevel || "".equals(starlevel)))){
								throw new Exception("此渠道为4G渠道转变为2G渠道，需上传1-6星级值");
							}
							if ("9".equals(starlevel) || ("9".equals(wayVO.getStarlevel()) && (null == starlevel || "".equals(starlevel)))){
								throw new Exception("此渠道为4G渠道转变为2G渠道，需上传1-6星级值");
							}
							if ((fields[75] != null && !"".equals(fields[75])) || (fields[76] != null && !"".equals(fields[76]))){
								fields[75]=null;
								fields[76]=null;
								wayVO.setWaymod(null);
								wayVO.setWayattr(null);
							}
						}else if ("1".equals(rewardkind) && 3==wbVO.getRewardkind()){//4G转3G
							if (!"7".equals(starlevel) && !"7".equals(wayVO.getStarlevel())){
								throw new Exception("此渠道为4G渠道转3G渠道，需上传3G渠道专用星级");
							}
							if ("".equals(fields[75]) || null == fields[75] || "".equals(fields[76]) || null == fields[76]){
								throw new Exception("连锁加盟渠道转3G渠道，则必须上传【社会渠道加盟属性】、【社会渠道加盟系数】2个属性值");
							}
							if ("A+1".equals(fields[75])){
								throw new Exception("此渠道为4G渠道转3G渠道，只有4G渠道连锁加盟渠道属性才能为A+1 (专营重要商圈)");
							}
							if (!"DG".equals(fields[7]) || !"DG".equals(wayVO.getCityid())){
								if("2Q".equals(fields[75]) || "3Q".equals(fields[75]) || "4Q".equals(fields[75]) || "A3".equals(fields[75]) || "B3".equals(fields[75]) || "C3".equals(fields[75])){
				                	//此【'+wayattr+'】连锁加盟渠道属性为东莞地市专用，请选择其他连锁加盟渠道属性
									throw new Exception("此【"+fields[75]+"】连锁加盟渠道属性为东莞地市专用，请选择其他连锁加盟渠道属性");
								}
							}
						}else if ("2".equals(rewardkind) && 3==wbVO.getRewardkind()){//4G转连锁加盟渠道
							if (!"8".equals(starlevel) && !"8".equals(wayVO.getStarlevel())){
								throw new Exception("此渠道为4G渠道转连锁加盟渠道，需上传连锁加盟渠道专用星级");
							}
							if ((fields[75] != null && !"".equals(fields[75])) || (fields[76] != null && !"".equals(fields[76]))){
								fields[75]=null;
								fields[76]=null;
								wayVO.setWaymod(null);
								wayVO.setWayattr(null);
							}
						}
//						}else{
//							if (!"7".equals(starlevel) && !"7".equals(wayVO.getStarlevel())){
//								throw new Exception("此渠道为3G渠道，需上传3G渠道专用星级");
//							}if (!"8".equals(starlevel) && !"8".equals(wayVO.getStarlevel())){
//								throw new Exception("此渠道为转连锁加盟渠道，需上传锁加盟渠道专用星级");
//							}if (!"9".equals(starlevel) && !"9".equals(wayVO.getStarlevel())){
//								throw new Exception("此渠道为4G渠道转连锁加盟渠道，需上传4G渠道专用星级");
//							}
//						}
					}else{
						throw new Exception("社会渠道类型不存在");
					}
				}else{
					rewardkind = fields[i];					
					if(rewardkind != null && !"".equals(rewardkind)){
						if("0".equals(rewardkind) || "1".equals(rewardkind) || "2".equals(rewardkind) || "3".equals(rewardkind)){
							if ("0".equals(rewardkind) && 0==wbVO.getRewardkind()){
								if ("7".equals(starlevel) || ("7".equals(wayVO.getStarlevel()) && (null == starlevel || "".equals(starlevel)))){
									throw new Exception("此渠道为2G渠道，需上传1-6星级值");
								}
								if ("8".equals(starlevel) || ("8".equals(wayVO.getStarlevel()) && (null == starlevel || "".equals(starlevel)))){
									throw new Exception("此渠道为2G渠道，需上传1-6星级值");
								}
								if ("9".equals(starlevel) || ("9".equals(wayVO.getStarlevel()) && (null == starlevel || "".equals(starlevel)))){
									throw new Exception("此渠道为2G渠道，需上传1-6星级值");
								}
								if (!"".equals(fields[75]) || !"".equals(fields[76])){
									fields[75]=null;
									fields[76]=null;
									wayVO.setWaymod(null);
									wayVO.setWayattr(null);
								}
							}else if ("0".equals(rewardkind) && 1==wbVO.getRewardkind()){//3G转2G
								if ("7".equals(starlevel) || ("7".equals(wayVO.getStarlevel()) && (null == starlevel || "".equals(starlevel)))){
									throw new Exception("此渠道为3G渠道转变为2G渠道，需上传1-6星级值");
								}
								if ("8".equals(starlevel) || ("8".equals(wayVO.getStarlevel()) && (null == starlevel || "".equals(starlevel)))){
									throw new Exception("此渠道为3G渠道转变为2G渠道，需上传1-6星级值");
								}
								if ("9".equals(starlevel) || ("9".equals(wayVO.getStarlevel()) && (null == starlevel || "".equals(starlevel)))){
									throw new Exception("此渠道为3G渠道转变为2G渠道，需上传1-6星级值");
								}
								if ((fields[75] != null && !"".equals(fields[75])) || (fields[76] != null && !"".equals(fields[76]))){
									fields[75]=null;
									fields[76]=null;
									wayVO.setWaymod(null);
									wayVO.setWayattr(null);
									}
							}else if ("0".equals(rewardkind) && 2==wbVO.getRewardkind()){//连锁加盟渠道转2G
								if ("8".equals(starlevel) || ("8".equals(wayVO.getStarlevel()) && (null == starlevel || "".equals(starlevel)))){
									throw new Exception("此渠道为连锁加盟渠道转2G渠道，需上传1-6星级值");
								}
								if ("7".equals(starlevel) || ("7".equals(wayVO.getStarlevel()) && (null == starlevel || "".equals(starlevel)))){
									throw new Exception("此渠道为连锁加盟渠道转2G渠道，需上传1-6星级值");
								}
								if ("9".equals(starlevel) || ("9".equals(wayVO.getStarlevel()) && (null == starlevel || "".equals(starlevel)))){
									throw new Exception("此渠道为连锁加盟渠道转2G渠道，需上传1-6星级值");
								}
								if ((fields[75] != null && !"".equals(fields[75])) || (fields[76] != null && !"".equals(fields[76]))){
									fields[75]=null;
									fields[76]=null;
									wayVO.setWaymod(null);
									wayVO.setWayattr(null);
									}
								
							}else if ("1".equals(rewardkind) && 0==wbVO.getRewardkind()){//2G转3G
								if (!"7".equals(starlevel) && wayVO.getStarlevel()!=7){
									throw new Exception("此渠道为2G渠道转变为3G渠道，需上传3G渠道专用星级");
								}
								if ("".equals(fields[75]) || null == fields[75] || "".equals(fields[76]) || null == fields[76]){
									throw new Exception("此渠道2G渠道转3G渠道，则必须上传【社会渠道加盟属性】、【社会渠道加盟系数】2个属性值");
								}
								if ("A+1".equals(fields[75])){
									throw new Exception("此渠道为2G渠道转3G渠道，只有4G渠道连锁加盟渠道属性才能为A+1 (专营重要商圈)");
								}
								if (!"DG".equals(fields[7]) || !"DG".equals(wayVO.getCityid())){
									if("2Q".equals(fields[75]) || "3Q".equals(fields[75]) || "4Q".equals(fields[75]) || "A3".equals(fields[75]) || "B3".equals(fields[75]) || "C3".equals(fields[75])){
					                	//此【'+wayattr+'】连锁加盟渠道属性为东莞地市专用，请选择其他连锁加盟渠道属性
										throw new Exception("此【"+fields[75]+"】连锁加盟渠道属性为东莞地市专用，请选择其他连锁加盟渠道属性");
									}
								}
							}else if ("1".equals(rewardkind) && 1==wbVO.getRewardkind()){//3G转3G
								if (!"7".equals(starlevel) && !"7".equals(wayVO.getStarlevel())){
									throw new Exception("此渠道为3G渠道，需上传3G渠道专用星级");
								}
								if ("A+1".equals(fields[75])){
									throw new Exception("此渠道为3G渠道，只有4G渠道连锁加盟渠道属性才能为A+1 (专营重要商圈)");
								}
								if (!"DG".equals(fields[7]) || !"DG".equals(wayVO.getCityid())){
									if("2Q".equals(fields[75]) || "3Q".equals(fields[75]) || "4Q".equals(fields[75]) || "A3".equals(fields[75]) || "B3".equals(fields[75]) || "C3".equals(fields[75])){
					                	//此【'+wayattr+'】连锁加盟渠道属性为东莞地市专用，请选择其他连锁加盟渠道属性
										throw new Exception("此【"+fields[75]+"】连锁加盟渠道属性为东莞地市专用，请选择其他连锁加盟渠道属性");
									}
								}
							}else if ("1".equals(rewardkind) && 2==wbVO.getRewardkind()){//连锁加盟渠道转3G
								if (!"7".equals(starlevel) && !"7".equals(wayVO.getStarlevel())){
									throw new Exception("此渠道为连锁加盟渠道转3G渠道，需上传3G渠道专用星级");
								}
								if ("".equals(fields[75]) || null == fields[75] || "".equals(fields[76]) || null == fields[76]){
									throw new Exception("连锁加盟渠道转3G渠道，则必须上传【社会渠道加盟属性】、【社会渠道加盟系数】2个属性值");
								}
								if ("A+1".equals(fields[75])){
									throw new Exception("此渠道为连锁加盟渠道转3G渠道，只有4G渠道连锁加盟渠道属性才能为A+1 (专营重要商圈)");
								}
								if (!"DG".equals(fields[7]) || !"DG".equals(wayVO.getCityid())){
									if("2Q".equals(fields[75]) || "3Q".equals(fields[75]) || "4Q".equals(fields[75]) || "A3".equals(fields[75]) || "B3".equals(fields[75]) || "C3".equals(fields[75])){
					                	//此【'+wayattr+'】连锁加盟渠道属性为东莞地市专用，请选择其他连锁加盟渠道属性
										throw new Exception("此【"+fields[75]+"】连锁加盟渠道属性为东莞地市专用，请选择其他连锁加盟渠道属性");
									}
								}
							}else if ("2".equals(rewardkind) && 0==wbVO.getRewardkind()){//2G转连锁加盟渠道
								
								if (!"8".equals(starlevel) && !"8".equals(wayVO.getStarlevel())){
									throw new Exception("此渠道为2G渠道转变为连锁加盟渠道，需上传8星级值（连锁加盟渠道星级）");
								}
								
							}else if ("2".equals(rewardkind) && 1==wbVO.getRewardkind()){//此渠道由‘3G渠道’变成‘连锁加盟渠道’
								if (!"8".equals(starlevel) && !"8".equals(wayVO.getStarlevel())){
									throw new Exception("此渠道为3G渠道转变为连锁加盟渠道，需上传8星级值（连锁加盟渠道星级）");
								}
								if (!"".equals(fields[75]) || null != fields[75] || !"".equals(fields[76]) || null != fields[76]){
									fields[75]=null;
									fields[76]=null;
									wayVO.setWaymod(null);
									wayVO.setWayattr(null);
								}
								
							}else if ("2".equals(rewardkind) && 2==wbVO.getRewardkind()){//此渠道由‘连锁加盟渠道’变成‘连锁加盟渠道’,要判断星级
								if (!"8".equals(starlevel) && !"8".equals(wayVO.getStarlevel())){
									throw new Exception("此渠道为连锁加盟渠道，需上传8星级值（连锁加盟渠道星级）");
								}
								
							}else if ("3".equals(rewardkind) && 0==wbVO.getRewardkind()){//2G转4G
								if (!"9".equals(starlevel) && !"9".equals(wayVO.getStarlevel())){
									throw new Exception("此渠道为2G渠道转变为4G渠道，需上传4G渠道专用星级");
								}
								if ("".equals(fields[75]) || null == fields[75] || "".equals(fields[76]) || null == fields[76]){
									throw new Exception("此渠道为2G渠道转变为4G渠道，则必须上传【社会渠道加盟属性】、【社会渠道加盟系数】2个属性值");
									}
//								if (!"A+1".equals(fields[75]) && !"A+1".equals(wayVO.getWayattr())){
//									throw new Exception("此渠道为2G渠道转变为4G渠道，连锁加盟渠道属性必须为A+1 (专营重要商圈)");
//								}	
								if (!"DG".equals(fields[7]) || !"DG".equals(wayVO.getCityid())){
									if("2Q".equals(fields[75]) || "3Q".equals(fields[75]) || "4Q".equals(fields[75]) || "A3".equals(fields[75]) || "B3".equals(fields[75]) || "C3".equals(fields[75])){
					                	//此【'+wayattr+'】连锁加盟渠道属性为东莞地市专用，请选择其他连锁加盟渠道属性
										throw new Exception("此【"+fields[75]+"】连锁加盟渠道属性为东莞地市专用，请选择其他连锁加盟渠道属性");
									}
								}
							}else if ("3".equals(rewardkind) && 1==wbVO.getRewardkind()){//3G转4G
								if (!"9".equals(starlevel) && !"9".equals(wayVO.getStarlevel())){
									throw new Exception("此渠道为3G渠道转变为4G渠道，需上传4G渠道专用星级");
								}
//								if (!"A+1".equals(fields[75]) && !"A+1".equals(wayVO.getWayattr())){
//									throw new Exception("此渠道为3G渠道转变为4G渠道，连锁加盟渠道属性必须为A+1 (专营重要商圈)");
//								}
								if (!"DG".equals(fields[7]) || !"DG".equals(wayVO.getCityid())){
									if("2Q".equals(fields[75]) || "3Q".equals(fields[75]) || "4Q".equals(fields[75]) || "A3".equals(fields[75]) || "B3".equals(fields[75]) || "C3".equals(fields[75])){
					                	//此【'+wayattr+'】连锁加盟渠道属性为东莞地市专用，请选择其他连锁加盟渠道属性
										throw new Exception("此【"+fields[75]+"】连锁加盟渠道属性为东莞地市专用，请选择其他连锁加盟渠道属性");
									}
								}
							}else if ("3".equals(rewardkind) && 2==wbVO.getRewardkind()){//连锁加盟渠道转4G
								if (!"9".equals(starlevel) && !"9".equals(wayVO.getStarlevel())){
									throw new Exception("此渠道为连锁加盟渠道转变为4G渠道，需上传4G渠道专用星级");
								}
								if ("".equals(fields[75]) || null == fields[75] || "".equals(fields[76]) || null == fields[76]){
									throw new Exception("此渠道为连锁加盟渠道转变为4G渠道，则必须上传【社会渠道加盟属性】、【社会渠道加盟系数】2个属性值");
									}
//								if (!"A+1".equals(fields[75]) && !"A+1".equals(wayVO.getWayattr())){
//									throw new Exception("此渠道为连锁加盟渠道转变为4G渠道，连锁加盟渠道属性必须为A+1 (专营重要商圈)");
//								}
								if (!"DG".equals(fields[7]) || !"DG".equals(wayVO.getCityid())){
									if("2Q".equals(fields[75]) || "3Q".equals(fields[75]) || "4Q".equals(fields[75]) || "A3".equals(fields[75]) || "B3".equals(fields[75]) || "C3".equals(fields[75])){
					                	//此【'+wayattr+'】连锁加盟渠道属性为东莞地市专用，请选择其他连锁加盟渠道属性
										throw new Exception("此【"+fields[75]+"】连锁加盟渠道属性为东莞地市专用，请选择其他连锁加盟渠道属性");
									}
								}
							}else if ("3".equals(rewardkind) && 3==wbVO.getRewardkind()){//4G转4G，要判断星级
								if (!"9".equals(starlevel) && !"9".equals(wayVO.getStarlevel())){
									throw new Exception("此渠道为连锁加盟渠道转变为4G渠道，需上传4G渠道专用星级");
								}
//								if (!"A+1".equals(fields[75]) && !"A+1".equals(wayVO.getWayattr())){
//									throw new Exception("此渠道为4G渠道，连锁加盟渠道属性必须为A+1 (专营重要商圈)");
//								}
								if (!"DG".equals(fields[7]) || !"DG".equals(wayVO.getCityid())){
									if("2Q".equals(fields[75]) || "3Q".equals(fields[75]) || "4Q".equals(fields[75]) || "A3".equals(fields[75]) || "B3".equals(fields[75]) || "C3".equals(fields[75])){
					                	//此【'+wayattr+'】连锁加盟渠道属性为东莞地市专用，请选择其他连锁加盟渠道属性
										throw new Exception("此【"+fields[75]+"】连锁加盟渠道属性为东莞地市专用，请选择其他连锁加盟渠道属性");
									}
								}
							}else if ("0".equals(rewardkind) && 3==wbVO.getRewardkind()){//4G转2G
								if ("7".equals(starlevel) || ("7".equals(wayVO.getStarlevel()) && (null == starlevel || "".equals(starlevel)))){
									throw new Exception("此渠道为4G渠道转变为2G渠道，需上传1-6星级值");
								}
								if ("8".equals(starlevel) || ("8".equals(wayVO.getStarlevel()) && (null == starlevel || "".equals(starlevel)))){
									throw new Exception("此渠道为4G渠道转变为2G渠道，需上传1-6星级值");
								}
								if ("9".equals(starlevel) || ("9".equals(wayVO.getStarlevel()) && (null == starlevel || "".equals(starlevel)))){
									throw new Exception("此渠道为4G渠道转变为2G渠道，需上传1-6星级值");
								}
								if ((fields[75] != null && !"".equals(fields[75])) || (fields[76] != null && !"".equals(fields[76]))){
									fields[75]=null;
									fields[76]=null;
									wayVO.setWaymod(null);
									wayVO.setWayattr(null);	
									}
							}else if ("1".equals(rewardkind) && 3==wbVO.getRewardkind()){//4G转3G
								if (!"7".equals(starlevel) && !"7".equals(wayVO.getStarlevel())){
									throw new Exception("此渠道为4G渠道转3G渠道，需上传3G渠道专用星级");
								}
								if ("A+1".equals(fields[75])){
									throw new Exception("此渠道为4G渠道转3G渠道，只有4G渠道连锁加盟渠道属性才能为A+1 (专营重要商圈)");
								}
								if (!"DG".equals(fields[7]) || !"DG".equals(wayVO.getCityid())){
									if("2Q".equals(fields[75]) || "3Q".equals(fields[75]) || "4Q".equals(fields[75]) || "A3".equals(fields[75]) || "B3".equals(fields[75]) || "C3".equals(fields[75])){
					                	//此【'+wayattr+'】连锁加盟渠道属性为东莞地市专用，请选择其他连锁加盟渠道属性
										throw new Exception("此【"+fields[75]+"】连锁加盟渠道属性为东莞地市专用，请选择其他连锁加盟渠道属性");
									}
								}
							}else if ("2".equals(rewardkind) && 3==wbVO.getRewardkind()){//4G转连锁加盟渠道
								if (!"8".equals(starlevel) && !"8".equals(wayVO.getStarlevel())){
									throw new Exception("此渠道为4G渠道转连锁加盟渠道，需上传连锁加盟渠道专用星级");
								}
								if ((fields[75] != null && !"".equals(fields[75])) || (fields[76] != null && !"".equals(fields[76]))){
									fields[75]=null;
									fields[76]=null;
									wayVO.setWaymod(null);
									wayVO.setWayattr(null);
								}
							}
//							else{
//								if (!"7".equals(starlevel) && !"7".equals(wayVO.getStarlevel())){
//									throw new Exception("此渠道为3G渠道，需上传3G渠道专用星级");
//								}if (!"8".equals(starlevel) && !"8".equals(wayVO.getStarlevel())){
//									throw new Exception("此渠道为连锁加盟渠道，需上传连锁加盟渠道专用星级");
//								}if (!"9".equals(starlevel) && !"9".equals(wayVO.getStarlevel())){
//									throw new Exception("此渠道为4G渠道，需上传4G渠道专用星级");
//								}
//							}
						}else{
							throw new Exception("社会渠道类型不存在");
						}
					}
				}
				break;
			// 所属商圈编码
			case 74:
				if (fields[i] == null || "".equals(fields[i])) {
					if (!customeFlag) {
						throw new Exception("[所属商圈编码]不能为空");
					}
				} else {
					Busicircle busicircle = (Busicircle) BOFactory.build(BusicircleBO.class, user);
					BusicircleVO busicircleVO = busicircle.doFindByPk(fields[i]);
					if (null == busicircleVO) {
						throw new Exception("[所属商圈编码]不是有效所属商圈编码值，请检查");
					}
				}
				break;
			// 连锁加盟渠道属性
			case 75:
				if("1".equals(rewardkind) && 1==wbVO.getRewardkind()){
					if (fields[i] == null || "".equals(fields[i])) {
						throw new Exception("[连锁加盟渠道属性]不能为空");
					}else{
						Dictitem dictitem = (Dictitem) BOFactory.build(DictitemBO.class, user);
						DictitemVO vo = new DictitemVO();
						vo.setGroupid("CH_WAYATTR");
						vo.setDictid(fields[75]);
						if (dictitem.doFindByPk(vo) == null) {
							throw new Exception("[连锁加盟渠道属性]值，不存在，请输入有效的连锁加盟渠道属性值");
						}
					}
					
						if ("A+1".equals(fields[i])){
							throw new Exception("此渠道为3G渠道，只有4G渠道连锁加盟渠道属性才能为A+1 (专营重要商圈)");
						}
						if (!"DG".equals(fields[7]) || !"DG".equals(wayVO.getCityid())){
							if("2Q".equals(fields[i]) || "3Q".equals(fields[i]) || "4Q".equals(fields[i]) || "A3".equals(fields[i]) || "B3".equals(fields[i]) || "C3".equals(fields[i])){
			                	//此【'+wayattr+'】连锁加盟渠道属性为东莞地市专用，请选择其他连锁加盟渠道属性
								throw new Exception("此【"+fields[75]+"】连锁加盟渠道属性为东莞地市专用，请选择其他连锁加盟渠道属性");
							}
						}
					
				}else if("2".equals(rewardkind) && 0==wbVO.getRewardkind()){
					if (fields[i] != null && !"".equals(fields[i])) {
						throw new Exception("连锁加盟渠道不需要上传【社会渠道加盟属性】或【社会渠道加盟系数】的属性值！如需修改成3G/4G渠道，则需同时提供【星级】、【社会渠道类型】、【连锁加盟渠道属性】、【连锁加盟渠道系数】的属性值");
					}
				}else if("3".equals(rewardkind)){
					if (fields[i] == null || "".equals(fields[i])) {
						throw new Exception("[连锁加盟渠道属性]不能为空");
					}else{
						Dictitem dictitem = (Dictitem) BOFactory.build(DictitemBO.class, user);
						DictitemVO vo = new DictitemVO();
						vo.setGroupid("CH_WAYATTR");
						vo.setDictid(fields[75]);
						if (dictitem.doFindByPk(vo) == null) {
							throw new Exception("[连锁加盟渠道属性]值，不存在，请输入有效的连锁加盟渠道属性值");
						}
					}
				}else if((null==rewardkind || "".equals(rewardkind)) && 0==wbVO.getRewardkind()){
					if (fields[i] != null && !"".equals(fields[i])) {
						throw new Exception("2G渠道不需要上传【社会渠道加盟属性】或【社会渠道加盟系数】的属性值！如需修改成3G/4G渠道，则需同时提供【星级】、【社会渠道类型】、【连锁加盟渠道属性】、【连锁加盟渠道系数】的属性值");
					}
				}
				break;
			// 连锁加盟渠道系数
			case 76:
				if("1".equals(rewardkind)){
					if (fields[i] == null || "".equals(fields[i])) {
						throw new Exception("[连锁加盟渠道系数]不能为空");
					}
				}else if("2".equals(rewardkind)){
					if (fields[i] != null && !"".equals(fields[i])) {
						throw new Exception("连锁加盟渠道不需要上传【社会渠道加盟属性】或【社会渠道加盟系数】的属性值！如需修改成3G/4G渠道，则需同时提供【星级】、【社会渠道类型】、【连锁加盟渠道属性】、【连锁加盟渠道系数】的属性值");
					}
				}else if("3".equals(rewardkind)){
					if (fields[i] == null && "".equals(fields[i])) {
						throw new Exception("[连锁加盟渠道系数]不能为空");					}
				}else if((null==rewardkind || "".equals(rewardkind)) && 0==wbVO.getRewardkind()){
					if (fields[i] != null && !"".equals(fields[i])) {
						throw new Exception("2G渠道不需要上传【社会渠道加盟属性】或【社会渠道加盟系数】的属性值！如需修改成3G/4G渠道，则需同时提供【星级】、【社会渠道类型】、【连锁加盟渠道属性】、【连锁加盟渠道系数】的属性值");
					}
				}
				break;
			// 信用等级
			case 77:
				if (fields[i] == null || "".equals(fields[i])) {
					if (!customeFlag) {
						throw new Exception("[信用等级]不能为空");
					}
				}else{
					Dictitem dictitem = (Dictitem) BOFactory.build(DictitemBO.class, user);
					DictitemVO vo = new DictitemVO();
					vo.setGroupid("CH_CREDITLEVEL");
					vo.setDictid(fields[77]); 
					if (dictitem.doFindByPk(vo) == null) {
						throw new Exception("[信用等级]格式不对,只能为0、1、2");
					}
				}
				break;
			// 税务资质
			case 78:
				if (fields[i] == null || "".equals(fields[i])) {
					if (!customeFlag) {
						throw new Exception("[税务资质]不能为空");
					}
				} else {
					Dictitem dictitem = (Dictitem) BOFactory.build(DictitemBO.class, user);
					DictitemVO vo = new DictitemVO();
					vo.setGroupid("CH_TAXCERTIFICATE");
					vo.setDictid(fields[78]);
					if (dictitem.doFindByPk(vo) == null) {
						throw new Exception("[税务资质]值只能是0（小规模纳税人）、1（一般纳税人）、2（其他）3种类型");
					}
				}
				break;
			// 是否授权网点
			case 79:
				if (fields[i] == null || "".equals(fields[i])) {
					if (!customeFlag) {
						throw new Exception("[是否授权网点]不能为空");
					}
				} else {
					if (!fields[i].trim().equals("Y") && !fields[i].trim().equals("N")) {
						throw new Exception("[是否授权网点]值只能是N（否）、Y（是）2种类型");
					}
				}
				break;
			/* 请注意于备注信息，每次新增导入字段将其保持放于最后！谢谢     by feng */
			// 备注
			case 80:
				if ("1".equals(param75)) {
					if ("0".equals(fields[6])) {
						if (fields[i] == null || "".equals(fields[i])) {
							throw new Exception("网点退出时，[备注]不能为空，需要填写退出原因");
						}else if (fields[i].getBytes().length>512) {
							throw new Exception("网点退出时，[备注]数据长度不能超出数据库储存长度");
						}
					} 
				} 
				break;
			/* end uppdate for (2013)NBBOSS- D0019 渠道优化概要设计     by feng */
			}
		}
	}

	private void checkParameter(String[] fields, User user) throws Exception {
		Dictitem delegate = (Dictitem) BOFactory.build(DictitemBO.class, user);
		DictitemVO vo = new DictitemVO();
		if (!"".equals(fields[32]) && !"null".equals(fields[32])
				&& !"空".equals(fields[32])) {
			// 签约类型
			vo.setGroupid("CH_COMPACTTYPE");
			vo.setDictid(fields[32]);
			if (delegate.doFindByPk(vo) == null) {
				throw new Exception("非法签约类型，请参看说明");
			}
		}
		if (!"".equals(fields[41]) && !"null".equals(fields[41])
				&& !"空".equals(fields[41])) {
			// 保证金押金状态
			vo.setGroupid("CH_BAILSTATUS");
			vo.setDictid(fields[41]);
			if (delegate.doFindByPk(vo) == null) {
				throw new Exception("非法保证金押金状态，请参看说明");
			}
		}
	}

	private String[] checkLines(String[] fields, User user) throws Exception {
		if (preLineCount != fields.length) {
			throw new Exception("自定义文件头与后面的数据列数必须一致!");
		}
		// 系统参数查询
		Sysparam sysparam = (Sysparam)BOFactory.build(SysparamBO.class, user);
		String paramvalue = sysparam.doFindByID(new Long("75"), "channel");
		if ("1".equals(paramvalue)) {
			int cnt = StringUtils.countMatches(lineHead1, "|");
			String checkLine[] = new String[cnt + 1];
			return copyArr(checkLine, resultStr, fields);
		} else {
			int cnt = StringUtils.countMatches(lineHead, "|");
			String checkLine[] = new String[cnt + 1];
			return copyArr(checkLine, resultStr, fields);
		}
		// for(int i=0;i<ccc.length;i++)
		// {
		// System.out.println(i+"_"+ccc[i]);
		// }
	}

	private void checkHead(String[] fields, User user) throws Exception {
		preLineCount = fields.length;
		// 清空结果串上次检查的结果
		this.resultStr = "";
		for (int i = 0; i < fields.length; i++) {
			boolean find = false;

			if (("1".equals(param75))) {
				for (int k = 0; k < lineArr1.length; k++) {
					if ("".equals(fields[i])) {
						throw new Exception("自定义文件头中不允许有空,且最后一行没有竖线");
					}
					if (fields[i].equals(lineArr1[k])) {
						resultStr = resultStr + k + "|";
						find = true;
						continue;
					}
				}
			} else {
				for (int k = 0; k < lineArr.length; k++) {
					if ("".equals(fields[i])) {
						throw new Exception("自定义文件头中不允许有空,且最后一行没有竖线");
					}
					if (fields[i].equals(lineArr[k])) {
						resultStr = resultStr + k + "|";
						find = true;
						continue;
					}
				}
			}

			if (!find) {
				throw new Exception("自定义文件头:" + fields[i] + "不正确!");
			}
		}
	}

	private String[] copyArr(String arr[], String str, String fields[]) {
		String temArr[] = StringUtils.splitPreserveAllTokens(str, "|");
		for (int i = 0; i < temArr.length - 1; i++) {
			int temp = -1;
			temp = new Integer(temArr[i]).intValue();
			arr[temp] = fields[i];
		}
		// 把null值转换成""
		for (int i = 0; i < arr.length; i++) {
			arr[i] = arr[i] == null ? "" : arr[i];
		}
		return arr;
	}

	private void checkUppserwayid(String wayid) throws Exception {
		Way way = (Way) BOFactory.build(WayBO.class, user);
		WayVO upperVO = way.doFindByPkAndCityid(wayid);
		if (upperVO == null) {
			throw new Exception("上级渠道不存在或不是本地市的上级渠道");
		} else {
			if ("ET".equals(upperVO.getWaytype())) {
				if (!"GMPT".equals(upperVO.getWaysubtype())
						&& !"G100".equals(upperVO.getWaysubtype())

				) {
					throw new Exception("录入的上级渠道只能是连锁经营合作商，移动部门/科室或服务厅");
				}
			} else {
				if (!"DIS".equals(upperVO.getWaysubtype())) {
					throw new Exception("网点的上级渠道不能是除[连锁经营合作商]之外的社会渠道");
				}
			}
		}
	}
}
