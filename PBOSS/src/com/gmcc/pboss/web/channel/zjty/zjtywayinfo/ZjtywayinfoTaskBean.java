package com.gmcc.pboss.web.channel.zjty.zjtywayinfo;

import java.sql.Date;
import org.apache.commons.beanutils.BeanUtils;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.channel.zjty.zjtywayinfo.ZjtywayinfoVO;
import com.gmcc.pboss.common.batch.processfile.BaseBatchTaskBean;
import com.gmcc.pboss.common.batch.processfile.ResultVO;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.channel.zjty.zjtywayinfo.Zjtywayinfo;
import com.gmcc.pboss.control.channel.zjty.zjtywayinfo.ZjtywayinfoBO;
import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;

public class ZjtywayinfoTaskBean extends BaseBatchTaskBean {
	WayBO delegate;
	Zjtywayinfo zjtywayinfodelegate;
	public ZjtywayinfoTaskBean()  throws Exception {
		try {
			batchName = "自建他营信息管理";
			super.setBatchName("社会网点批量开通");
			super.setWriteLog(true);
		} catch (Exception ex) {
			ex.printStackTrace(System.err);
		}
	}

	protected String doStart() {
		try {
			delegate = (WayBO)BOFactory.build(WayBO.class, user);
			zjtywayinfodelegate = (Zjtywayinfo)BOFactory.build(ZjtywayinfoBO.class, user);
		} catch (Exception e) {
		}
//		BatchzjtywayinfoForm batchForm = (BatchzjtywayinfoForm) form;
		return "渠道|渠道名称|上级渠道|服务厅类别|服务厅级别|子类型|地市公司|分公司|服务销售中心|微区域|星级|经营模式|是否联网|联网方式|物业来源分类|" +
				"商圈类型|区域类型|联系电话|行政区划|地理纬度|地理经度|详细地址|渠道状态|是否中心渠道|合作商编码|是否共享|全网统一渠道编码|乡镇|渠道基础类型|" +
				"是否卖场加盟|前台营业面积（㎡）|有无排队叫号机|有无POS机|有无24小时自助营业厅|有无VIP专席|有无VIP室|G3体验区面积|委托方公司名称|" +
				"工商注册号|法人代表|身份证号码|签约编号|协议签署生效时间|协议截止时间|负责人电话|协议名称|签约时间| "
				+ "\r\n";
	}

	/**
	 * 处理一条记录
	 */
	public ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		String msg = "";
		String[] items = StringUtils.splitPreserveAllTokens(line, "|");
		String op = "";

		ZjtywayinfoForm vo = new ZjtywayinfoForm();
		try {
//			// 渠道编码存在判断
//			WayVO wayVO = null;
//			Way wdelegate = (Way)BOFactory.build(WayBO.class, user);
//			wayVO = wdelegate.doFindByPk(items[0].trim());
//			if (wayVO == null) {
//				throw new Exception( "该渠道:"+ items[0] +" 在系统中不存在。");
//			}
			
			// 增加还是修改判断
			WayVO updateVO = null;
			if (!isNull(items[0])){
				Object obj = delegate.doFindByPk2(items[0].trim());
				if(obj != null){
					updateVO = (WayVO)obj;	
				}
			}
			if (updateVO == null) {
				op = "增加";
				this.buildVO(items, vo);
				ZjtywayinfoVO zjtywayinfoVO = new ZjtywayinfoVO();				
			     BeanUtils.copyProperties(zjtywayinfoVO, vo);				
				zjtywayinfodelegate.doMulsave(zjtywayinfoVO, user);
			} else {
				op = "修改";

				this.buildVO(items, vo);
				ZjtywayinfoVO zjtywayinfoVO = new ZjtywayinfoVO();				
			     BeanUtils.copyProperties(zjtywayinfoVO, vo);		
				zjtywayinfodelegate.doMulupdate(zjtywayinfoVO, user);
			}
			resultVO.setOk(true);
			resultVO.setInfo(showInfo(resultVO, items, rowCount, op));
			return resultVO;
		} catch (Exception ex) { // 插入失败
			msg = ex.getMessage();
			ex.printStackTrace();
			resultVO.setOk(false);
			resultVO.setInfo(showInfo(resultVO, items, rowCount, op) + msg);
			return resultVO;
		}
	}

	/**
	 * 结果文件格式
	 */
	public String showInfo(ResultVO resultVO, String[] items, int rowCount,
			String op) {
		final String COMPART = " | "; // 分隔
		StringBuffer resultStr = new StringBuffer();
		// 序号
		resultStr.append(rowCount).append(COMPART);
		for (int i = 0; i < items.length; i++) {
			resultStr.append(items[i]).append(COMPART);
		}
		resultStr.append(op);
		// 办理结果
		if (resultVO.isOk()) {
			resultStr.append("成功");
		} else {
			resultStr.append("失败");
		}
		resultStr.append(COMPART);
		return resultStr.toString();
	}
//	1渠道|2渠道名称|3上级渠道|4服务厅类别|5服务厅级别|6子类型|7地市公司|8分公司|9服务销售中心|
//	10微区域|11星级|12经营模式|13是否联网|14联网方式|15物业来源分类|16商圈类型|17区域类型|18联系电话|
//	19行政区划|20地理纬度|21地理经度|22详细地址|23渠道状态|24是否中心渠道|25合作商编码|26是否共享|
//	27全网统一渠道编码|28乡镇|29渠道基础类型|30是否卖场加盟|31前台营业面积（㎡）|32有无排队叫号机|
//	33有无POS机|34有无24小时自助营业厅|35有无VIP专席|36有无VIP室|37G3体验区面积|38委托方公司名称|
//	39工商注册号|40法人代表|41身份证号码|42签约编号|43协议签署生效时间|44协议截止时间|
	private void buildVO(String[] items, ZjtywayinfoForm vo) throws Exception {
		if (notNull(items[0]))
			vo.setWayid(items[0]);// 渠道编码
		if (notNull(items[1]))
			vo.setWayname(items[1]);// 渠道名称
		if (notNull(items[2]))
			vo.setUpperwayid(items[2]);// 上级渠道
		if (notNull(items[3]))
			vo.setSvbrchcode(items[3]);// 服务厅类别
		if (notNull(items[4]))
			vo.setBchlevel(items[4]);// 服务厅级别
		if (notNull(items[5]))
			vo.setWaysubtype("ZJTY");// 子类型
//		if (notNull(items[6]))
//			vo.setCityid(items[6]);// 地市公司
		vo.setCityid(user.getCityid());
		if (notNull(items[7-1]))
			vo.setCountyid(items[7-1]);// 分公司
		if (notNull(items[8-1]))
			vo.setSvccode(items[8-1]);// 服务销售中心
		if (notNull(items[9-1]))
			vo.setMareacode(items[9-1]);// 微区域
		if (notNull(items[10-1]))
			vo.setStarlevel(Long.valueOf(items[10-1]));// 星级
//		if (notNull(items[11]))
//			vo.setRunmode(Long.valueOf(items[11]));// 经营模式
		vo.setRunmode(Long.valueOf("1"));
		if (notNull(items[12-1-1]))
			vo.setIsconnected(Long.valueOf(items[12-1-1]));// 是否联网
		if (notNull(items[13-1-1]))
			vo.setConnecttype(Long.valueOf(items[13-1-1]));// 联网方式
		if (notNull(items[14-1-1]))
			vo.setPrtsource(Long.valueOf(items[14-1-1]));// 物业来源分类
		if (notNull(items[15-1-1]))
			vo.setBuztypecode(Short.parseShort(items[15-1-1]));// 商圈类型
		if (notNull(items[16-1-1]))
			vo.setAdtypecode(Short.parseShort(items[16-1-1]));// 区域类型
		if (notNull(items[17-1-1]))
			vo.setBuzphoneno(items[17-1-1]);// 联系电话		
		if (notNull(items[18-1-1]))
			vo.setAdacode(items[18-1-1]);// 行政区划
		if (notNull(items[19-1-1]))
			vo.setLatitude(items[19-1-1]);// 地理纬度
		if (notNull(items[20-1-1]))
			vo.setLongtitude(items[20-1-1]);// 地理经度
		if (notNull(items[21-1-1]))
			vo.setAddress(items[21-1-1]);// 详细地址
		if (notNull(items[22-1-1]))
			vo.setWaystate(Short.parseShort(items[22-1-1]));// 渠道状态
		if (notNull(items[23-1-1]))
			vo.setIscoreway(Long.valueOf(items[23-1-1]));// 是否中心渠道
//		if (notNull(items[24]))
//			vo.setCooperator(Short.parseShort(items[24]));// 合作商编码
		if (notNull(items[24-1-1]))
			vo.setChainhead(items[24-1-1]);// 合作商编码
		if (notNull(items[25-1-1]))
			vo.setIsshare(items[25-1-1]);// 是否共享
		if (notNull(items[26-1-1]))
			vo.setUniquewayid(items[26-1-1]);// 全网统一渠道编码
		if (notNull(items[27-1-1]))
			vo.setTown(items[27-1-1]);// 乡镇
		if (notNull(items[28-1-1]))
			vo.setProvtype(Short.valueOf(items[28-1-1]));// 渠道基础类型
		if (notNull(items[29-1-1]))
			vo.setMobilemall(Short.valueOf(items[29-1-1]));// 是否卖场加盟
		if (notNull(items[30-1-1]))
			vo.setFrontarea(Double.valueOf(items[30-1-1]));// 前台营业面积（㎡）
		if (notNull(items[31-1-1]))
			vo.setHaswaitmach(Short.valueOf(items[31-1-1]));// 有无排队叫号机
		if (notNull(items[32-1-1]))
			vo.setHasposmach(Short.valueOf(items[32-1-1]));// 有无POS机
		if (notNull(items[33-1-1]))
			vo.setHas24mall(Short.valueOf(items[33-1-1]));// 有无24小时自助营业厅
		if (notNull(items[34-1-1]))
			vo.setHasvipseat(Short.valueOf(items[34-1-1]));// 有无VIP专席
		if (notNull(items[35-1-1]))
			vo.setHasviproom(Short.valueOf(items[35-1-1]));// 有无VIP室
		if (notNull(items[36-1-1]))
			vo.setG3area(Double.valueOf(items[36-1-1]));// G3体验区面积
		if (notNull(items[37-1-1]))
			vo.setCompany(items[37-1-1]);// 委托方公司名称
		if (notNull(items[38-1-1]))
			vo.setBusnum(items[38-1-1]);// 工商注册号
		if (notNull(items[39-1-1]))
			vo.setPrincipal(items[39-1-1]);// 法人代表
		if (notNull(items[40-1-1]))
			vo.setCertinum(items[40-1-1]);// 身份证号码
		if (notNull(items[41-1-1]))
			vo.setCompactno(items[41-1-1]);// 签约编号
		if (notNull(items[42-1-1]))
 			vo.setSigntime(Date.valueOf(items[42-1-1]));// 协议签署生效时间
		if (notNull(items[43-1-1]))
			vo.setEndtime(Date.valueOf(items[43-1-1]));// 协议截止时间
		if(notNull(items[44-1-1]))
			vo.setPrincipaltel(items[44-1-1]);//45负责人电话
		if(notNull(items[45-1-1]))
			vo.setCompactname(items[45-1-1]);//46协议名称
		if(notNull(items[46-1-1]))
			vo.setBegintime(Date.valueOf(items[46-1-1]));//47签约时间
	}

	private boolean isNull(String item) {
		return "".equals(item.trim()) || "null".equals(item)
				|| "空".equals(item);
	}

	private boolean notNull(String item) {
		if (item == null) {
			return false;
		}
		if (item.trim().length() > 0) {
			return true;
		} else {
			return false;
		}
	}
}
