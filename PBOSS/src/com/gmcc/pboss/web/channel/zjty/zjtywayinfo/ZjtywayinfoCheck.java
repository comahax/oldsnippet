package com.gmcc.pboss.web.channel.zjty.zjtywayinfo;

import java.io.File;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections.BidiMap;
import org.apache.commons.collections.bidimap.DualHashBidiMap;

import com.gmcc.pboss.business.base.dictitem.DictitemVO;
import com.gmcc.pboss.business.channel.way.WayDBParam;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.channel.wayprovince.WayprovinceDBParam;
import com.gmcc.pboss.business.channel.wayprovince.WayprovinceVO;
import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.gmcc.pboss.common.utils.tools.CheckUtil;
import com.gmcc.pboss.control.base.dictitem.DictitemBO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.channel.wayprovince.Wayprovince;
import com.gmcc.pboss.control.channel.wayprovince.WayprovinceBO;
import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;


public class ZjtywayinfoCheck extends BaseCheckFormat {

	
	public ZjtywayinfoCheck() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 判断导入文件格式
	 */
	public void checkFile(File file, HashMap parameterMap, String contentType)
		throws Exception {
	if (!"text/plain".equalsIgnoreCase(contentType)) {
		throw new Exception("要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
	}
	}
	
	public void checkLine(String line, int rowCount, User user)
			throws Exception {
		if (null == line || "".equals(line)) {
			return;
		}
//		1渠道|2渠道名称|3上级渠道|4服务厅类别|5服务厅级别|6子类型|7地市公司|8分公司|9服务销售中心|
//		10微区域|11星级|12经营模式|13是否联网|14联网方式|15物业来源分类|16商圈类型|17区域类型|18联系电话|
//		19行政区划|20地理纬度|21地理经度|22详细地址|23渠道状态|24是否中心渠道|25合作商编码|26是否共享|
//		27全网统一渠道编码|28乡镇|29渠道基础类型|30是否卖场加盟|31前台营业面积（㎡）|32有无排队叫号机|
//		33有无POS机|34有无24小时自助营业厅|35有无VIP专席|36有无VIP室|37G3体验区面积|38委托方公司名称|
//		39工商注册号|40法人代表|41身份证号码|42签约编号|43协议签署生效时间|44协议截止时间|

		//1渠道
		String[] items = StringUtils.splitPreserveAllTokens(line, "|");
		// 检查列数
		if (items.length != (48-2)) {
			throw new Exception("上传数据列数不对,应为45列,请查看说明帮助!");
		}		
		// 渠道编码
		if (StringUtils.isBlank(items[0])) {
			throw new Exception("渠道编码不能为空。");
		}
		if (items[0].getBytes("GBK").length > 18) {
			throw new Exception("[渠道编码]长度不能超过18!");
		}
		
		//2渠道名称
		if(StringUtils.isEmpty(items[1])){
			throw new Exception("渠道名称不能为空。");
		}
		
		//3上级渠道
		if(StringUtils.isEmpty(items[2])){
			throw new Exception("上级渠道不能为空。");
		}
		
		
		//4服务厅类别
		if (StringUtils.isNotEmpty(items[3])){
			if (items[4].equals(getDictName("CH_SVBRCHTYPE",items[3],user))){
				throw new Exception("固定参数:[服务厅类别]的值在系统中不存在。");
			}
		}
		
		
		//5服务厅级别
		if(StringUtils.isEmpty(items[4])){
			throw new Exception("服务厅级别不能为空。");
		}
		//6子类型
		if(StringUtils.isNotEmpty(items[5])){
			if(!items[5].equals("ZJTY")){
				throw new Exception("子类型只能是ZJTY。");
			}
		}
//		//7地市公司
//		if (StringUtils.isBlank(items[6])) {
//			throw new Exception("[地市公司]不能为空。");
//		}
//		if (isCityid(items[6])) {
//			throw new Exception("[地市公司]只能为(GZ,SZ,ZH,FS,ST,HZ,ZJ,JM,ZQ,SG,MZ,DG,ZS,MM,SW,CZ,JY,YJ,QY,HY,YF)");
//		}
		//8分公司
		//9服务销售中心
		//10微区域
		//11星级
		if (StringUtils.isNotEmpty(items[10-1])){
			if (items[10-1].equals(getDictName("CH_STARLEVEL",items[10-1],user))){
				throw new Exception("固定参数:[星级]的值在系统中不存在。");
			}
		}
		
		//12经营模式
//		if (StringUtils.isBlank(items[11])) {
//			throw new Exception("[地市公司]不能为空。");
//		}
//		if (!items[11].equals("1")){
//			throw new Exception("经营模式只能是1。");
//		}
		
		//13是否联网
		if (StringUtils.isNotEmpty(items[12-1-1])){
			if (!check(items[12-1-1])){
				throw new Exception("固定参数:[是否联网]的值在系统中不存在。");
			}
		}
		//14联网方式
		if (StringUtils.isNotEmpty(items[13-1-1])){
			if (items[4].equals(getDictName("CH_CONNECTTYPE",items[13-1-1],user))){
				throw new Exception("固定参数:[联网方式]的值在系统中不存在。");
			}
		}
		
		//15物业来源分类
		if(StringUtils.isEmpty(items[14-1-1])){
			throw new Exception("物业来源分类不能为空。");
		}
		if (StringUtils.isNotEmpty(items[14-1-1])){
			if (items[14-1-1].equals(getDictName("CH_PRTSOURCE",items[14-1-1],user))){
				throw new Exception("固定参数:[物业来源分类]的值在系统中不存在。");
			}
		}
		
		//16商圈类型
		if(StringUtils.isEmpty(items[15-1-1])){
			throw new Exception("商圈类型不能为空。");
		}
		//17区域类型
		if(StringUtils.isEmpty(items[16-1-1])){
			throw new Exception("区域类型不能为空。");
		}
		//18联系电话
		if(StringUtils.isNotEmpty(items[17-1-1])){
			try{
			Long tel = Long.valueOf(items[17-1-1]);
			}catch(Exception e){
				throw new Exception("联系电话只能是数字。");			
			}
			
		}
		//19行政区划
		//20地理纬度
		if(StringUtils.isEmpty(items[19-1-1])){
			throw new Exception("地理纬度不能为空。");
		}
		//21地理经度
		if(StringUtils.isEmpty(items[20-1-1])){
			throw new Exception("地理经度不能为空。");
		}
		//22详细地址
		if(StringUtils.isEmpty(items[21-1-1])){
			throw new Exception("详细地址不能为空。");
		}
		//23渠道状态
		if (StringUtils.isNotEmpty(items[22-1-1])){
			if (items[4].equals(getDictName("CH_WAYSTATE",items[22-1-1],user))){
				throw new Exception("固定参数:[渠道状态]的值在系统中不存在。");
			}
		}
		
		
		//24是否中心渠道
		if (StringUtils.isNotEmpty(items[23-1-1])){
			if (!check(items[23-1-1])){
				throw new Exception("固定参数:[是否中心渠道]的值在系统中不存在。");
			}
		}
// <j:selector name="form.chainhead" definition="#WAY" condition="waytype:AG;waysubtype:DIS;waystate:1;cityid:GD" />
		//25合作商编码
		if (StringUtils.isNotEmpty(items[24-1-1])){
			
			WayVO wayvo = new WayVO();
			WayBO waybo = (WayBO) BOFactory.build(WayBO.class, user);
			wayvo.setWayid(items[24-1-1]);
			if (waybo.doFindByPk(wayvo.getWayid()) == null) {
				throw new Exception("合作商编码不存在");
			}

			WayDBParam param = new WayDBParam();
			param.set_se_wayid(items[24-1-1]);
			param.set_se_waytype("AG");
			param.set_se_waysubtype("DIS");
			param.set_se_cityid("GD");
			param.set_ne_waystate("1");
			DataPackage dp = waybo.doQuery(param);
			if (dp == null || dp.getDatas().size() == 0) {
				throw new Exception("该[" + items[24-1-1] + "]不是合作商编码!");
			}
			
		}
		//26是否共享
		if (StringUtils.isNotEmpty(items[25-1-1])){
			if (!check(items[25-1-1])){
				throw new Exception("固定参数:[是否共享]的值在系统中不存在。");
			}
		}
		//27全网统一渠道编码
//		// 全网统一渠道编码存在判断
		if (StringUtils.isNotEmpty(items[26-1-1])){
	//		WayprovinceDelegate delegate = new WayprovinceDelegate();
			Wayprovince  wayprovince=(Wayprovince)BOFactory.build(WayprovinceBO.class,user);
			WayprovinceDBParam wayprovinceListVO = new WayprovinceDBParam();
			wayprovinceListVO.set_se_uniquewayid(items[26-1-1].trim());
			DataPackage dp = wayprovince.doQuery(wayprovinceListVO);
			if(dp.getRowCount()!= 0){
				Iterator it = dp.getDatas().iterator();
				while (it.hasNext()) {
					WayprovinceVO vo = null;
					vo = (WayprovinceVO)it.next();
					if (!items[0].trim().equals(vo.getWayid())) {
						throw new Exception("全网统一渠道编码:"+items[26-1-1]+" 在系统中已存在。");
					}
				}
			}
		}
		//28乡镇
		if (items[27-1-1].getBytes("GBK").length > 30) {
			throw new Exception("[乡镇]长度不能超过30。");
		}
		//29渠道基础类型
		if (StringUtils.isNotEmpty(items[28-1-1])){
			if (items[28-1-1].equals(getDictName("CH_PROVTYPE",items[28-1-1],user))){
				throw new Exception("固定参数:[渠道基础类型]的值在系统中不存在。");
			}
		}
		//30是否卖场加盟
		if (StringUtils.isNotEmpty(items[29-1-1])){
			if (!check(items[29-1-1])){
				throw new Exception("固定参数:[是否卖场加盟]的值在系统中不存在。");
			}
		}
		//31前台营业面积（㎡）
		if (StringUtils.isNotEmpty(items[30-1-1])) {
			if (!CheckUtil.checkDouble(items[30-1-1], 8, 2)) {
				throw new Exception("[前台营业面积（㎡）]整数部分不能超过8,小数部分不能超过2位。");
			}
		}
		
		//32有无排队叫号机
		if (StringUtils.isNotEmpty(items[31-1-1])){
			if (!check(items[31-1-1])){
				throw new Exception("固定参数:[有无排队叫号机]的值在系统中不存在。");
			}
		}
		//33有无POS机
		if (StringUtils.isNotEmpty(items[32-1-1])){
			if (!check(items[32-1-1])){
				throw new Exception("固定参数:[有无POS机]的值在系统中不存在。");
			}
		}
		//34有无24小时自助营业厅
		if (StringUtils.isNotEmpty(items[33-1-1])){
			if (!check(items[33-1-1])){
				throw new Exception("固定参数:[有无24小时自助营业厅]的值在系统中不存在。");
			}
		}
		//35有无VIP专席
		if (StringUtils.isNotEmpty(items[34-1-1])){
			if (!check(items[34-1-1])){
				throw new Exception("固定参数:[有无VIP专席]的值在系统中不存在。");
			}
		}
		
		//36有无VIP室
		if (StringUtils.isNotEmpty(items[35-1-1])){
			if (!check(items[35-1-1])){
				throw new Exception("固定参数:[有无VIP室]的值在系统中不存在。");
			}
		}
		//37G3体验区面积
		if (StringUtils.isNotEmpty(items[36-1-1])) {
			if (!CheckUtil.checkDouble(items[36-1-1], 14, 2)) {
				throw new Exception("[G3体验区面积]整数部分不能超过14,小数部分不能超过2位。");
			}
		}
		//38委托方公司名称
		if(StringUtils.isEmpty(items[37-1-1])){
			throw new Exception("委托方公司名称不能为空。");
		}
		//39工商注册号
		if(StringUtils.isEmpty(items[38-1-1])){
			throw new Exception("工商注册号不能为空。");
		}
		//40法人代表
		if(StringUtils.isEmpty(items[39-1-1])){
			throw new Exception("法人代表不能为空。");
		}
		//41身份证号码
		if(StringUtils.isNotEmpty(items[40-1-1])){
			if(items[40-1-1].length()!=18){
				throw new Exception("身份证号码只能是18位。");
			}
		}
		
		
		//42签约编号
		if(StringUtils.isEmpty(items[41-1-1])){
			throw new Exception("签约编号不能为空。");
		}
		//43协议签署生效时间
		if(StringUtils.isEmpty(items[42-1-1])){
			throw new Exception("协议签署生效时间不能为空。");
		}
		
		try{			
			Date.valueOf(items[42-1-1]);
		}catch(Exception e){
			throw new Exception("协议签署生效时间格式不正确。");
		}
		
		
		//44协议截止时间
		if(StringUtils.isEmpty(items[43-1-1])){
			throw new Exception("协议截至时间不能为空。");
		}
		try{			
			Date.valueOf(items[43-1-1]);
		}catch(Exception e){
			throw new Exception("协议截至时间格式不正确。");
		}
		//45负责人电话
		if(StringUtils.isEmpty(items[44-1-1])){
			throw new Exception("负责人电话不能为空。");
		}
		//46协议名称
		if(StringUtils.isEmpty(items[45-1-1])){
			throw new Exception("协议名称不能为空。");
		}
		//47签约时间
		if(StringUtils.isEmpty(items[46-1-1])){
			throw new Exception("签约时间不能为空。");
		}
		try{			
			Date.valueOf(items[46-1-1]);
		}catch(Exception e){
			throw new Exception("签约时间格式不正确。");
		}

		// 渠道编码存在判断
		WayVO wayVO = null;
//		WayDelegate wdelegate = new WayDelegate();
		Way wdelegate=(Way)BOFactory.build(WayBO.class, user);
		wayVO = wdelegate.doFindByPk(items[2].trim());
		if (wayVO == null) {
			throw new Exception("该渠道:"+ items[2] +" 在系统中不存在。");
		}
	}
	
	private String getDictName(String groupid,String code,User user) throws Exception{
//		CommonDelegate dictitemDelegate = new CommonDelegate(DictitemVO.class);
		DictitemBO dictitemDelegate=(DictitemBO)BOFactory.build(DictitemBO.class, user);
		DictitemVO vo = new DictitemVO();
		vo.setGroupid(groupid);
		vo.setDictid(code);
		vo = (DictitemVO) dictitemDelegate.doFindByPk(vo);
		 return vo == null?code:vo.getDictname();
	}
	
	private boolean check(String code) throws Exception{
		if ("0".equals(code) || "1".equals(code)) {
			return true;
		} else {
			return false;
		}
	}
	
	private static final List<String> list=new ArrayList<String>();
	static{
		list.add("GZ");
		list.add("SZ");
		list.add("ZH");
		list.add("FS");
		list.add("ST");
		list.add("HZ");
		list.add("ZJ");
		list.add("JM");
		list.add("ZQ");
		list.add("SG");
		list.add("MZ");
		list.add("DG");
		list.add("ZS");
		list.add("MM");
		list.add("SW");
		list.add("CZ");
		list.add("JY");
		list.add("YJ");
		list.add("QY");
		list.add("HY");
		list.add("YF");
	}
	
	private boolean isCityid(String cityid){
		
		return list.contains(cityid);
		
	}
	
}
