package com.sunrise.boss.ui.cms.cityrecord;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.business.cms.chadtbusitoapprove.control.ChAdtBusitoapproveControl;
import com.sunrise.boss.business.cms.chadtbusitoapprove.control.ChAdtBusitoapproveControlBean;
import com.sunrise.boss.business.cms.chadtbusitoapprove.persistent.ChAdtBusitoapproveListVO;
import com.sunrise.boss.business.cms.chadtbusitoapprove.persistent.ChAdtBusitoapproveVO;
import com.sunrise.boss.business.cms.cityrecord.control.CityrecordControl;
import com.sunrise.boss.business.cms.cityrecord.control.CityrecordControlBean;
import com.sunrise.boss.business.cms.cityrecord.persistent.CityrecordListVO;
import com.sunrise.boss.business.cms.cityrecord.persistent.CityrecordVO;
import com.sunrise.boss.business.cms.common.CheckUtil;
import com.sunrise.boss.business.cms.operation.control.OperationControl;
import com.sunrise.boss.business.cms.operation.control.OperationControlBean;
import com.sunrise.boss.business.cms.operation.persistent.OperationVO;
import com.sunrise.boss.business.cms.way.persistent.WayListVO;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.delegate.cms.cityrecord.CityrecordDelegate;
import com.sunrise.boss.delegate.cms.operation.OperationDelegate;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;
import com.sunrise.pub.tools.PublicUtils;

public class CityrecordTaskBean extends BaseBatchTaskBean {
	public CityrecordTaskBean() throws Exception {
		super.setBatchName("市公司酬金明细上传批量导入");
		super.setWriteLog(true);
		// TODO Auto-generated constructor stub
	}

	protected String doStart() {
		return "市公司酬金明细上传批量导入 \r\n";
	}

	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		String msg = "";
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		try {		
			//1、判断渠道编码是否存在
			WayDelegate waydelegate=new WayDelegate();
			WayListVO wayListVO = new WayListVO();
			wayListVO.set_se_wayid(content[0]);
			wayListVO.set_ne_waystate(Short.valueOf("1"));
			wayListVO.set_se_waytype("AG");
			wayListVO.set_sne_waysubtype("ZJTY");
			DataPackage waydp = waydelegate.doQuery(wayListVO, user);
			if(waydp.getRowCount()==0){
				throw new Exception("渠道编码不存在");
			}
			//2.查询全省统一业务基本信息表(CH_PW_OPERATION)中是否存在该业务编码OPNID
			OperationDelegate odel = new OperationDelegate();
			if(null == odel.doFindByPk(content[1], user)){
				throw new Exception("业务编码不存在");
			}
			
			//3.判断酬金基数是否正确
			Set<String> notjijianset = new HashSet<String>();//非计件业务集合
			notjijianset.add("0701010100004");
			notjijianset.add("0701010100001");
			notjijianset.add("0701010100003");
			notjijianset.add("0701010100002");
			notjijianset.add("0701010100005");
			if(notjijianset.contains(content[1])){
				if(StringUtils.equals(content[1], "0701010100004")){
					if(!StringUtils.equals(content[2], "30")){
						throw new Exception("酬金期数不正确");
					}
				}
				if(StringUtils.equals(content[1], "0701010100001")){
					if(!StringUtils.equals(content[2], "60")){
						throw new Exception("酬金期数不正确");
					}
				}
				if(StringUtils.equals(content[1], "0701010100003")){
					if(!StringUtils.equals(content[2], "54")){
						throw new Exception("酬金期数不正确");
					}
				}
				if(StringUtils.equals(content[1], "0701010100002")){
					if(!StringUtils.equals(content[2], "55")){
						throw new Exception("酬金期数不正确");
					}
				}
				if(StringUtils.equals(content[1], "0701010100005")){
					if(!StringUtils.equals(content[2], "7")){
						throw new Exception("酬金期数不正确");
					}
				}
			}else{
				OperationControl opcontrol = (OperationControl)ControlFactory.build(OperationControlBean.class);
				OperationVO opvo = opcontrol.doFindByPk(content[1], user);
				if("CARD".equals(opvo.getBusibelong())){
					if((!StringUtils.equals("0", content[2])) && (!StringUtils.equals("1", content[2])) &&(!StringUtils.equals("2", content[2]))){
						throw new Exception("酬金期数不正确");
					}
				}
				if("SERV".equals(opvo.getBusibelong())){
					if((!StringUtils.equals("5", content[2])) && (!StringUtils.equals("6", content[2]))){
						throw new Exception("酬金期数不正确");
					}
				}
				if("DATA".equals(opvo.getBusibelong())){
					if((!StringUtils.equals("9", content[2])) && (!StringUtils.equals("10", content[2]))){
						throw new Exception("酬金期数不正确");
					}
				}
			}
			//4.判断手机号码
			Set<String> notjijianset2 = new HashSet<String>();//非计件业务集合
			notjijianset2.add("0701010100004");
			notjijianset2.add("0701010100003");
			notjijianset2.add("0701010100002");
			if(!notjijianset2.contains(content[1])){
				if(StringUtils.isBlank(content[3])){
					throw new Exception("手机号码不可以为空");
				}
			}
			//5.结算月份
			try{
				Date now = new Date();
				String nowstr = PublicUtils.formatUtilDate(now, "yyyyMM");
				if(new Long(content[4])>new Long(nowstr)){
					throw new Exception("结算月份不能大于当前月份");
				}
			}catch (Exception e) {
				throw new Exception("结算月份不正确");
			}
			//6.业务发生时间
			try{
				Date date = PublicUtils.UtilStrToDate(content[5], "yyyy-MM-dd HH:mm:ss");
				Calendar ca = Calendar.getInstance(Locale.CHINA);//当前时间
				Calendar ca2 = Calendar.getInstance();
				ca2.setTime(date);
				if(ca2.after(ca)){
					throw new Exception("业务发生时间不能大于当前系统时间");
				}
			}catch (Exception e) {
				throw new Exception("业务发生时间不正确");
			}
			//7.业务量或业务发生金额
			if(!CheckUtil.checkDouble(content[6],10, 2) ){
				throw new Exception("业务量或业务发生金额必须精确到两位小数");
			}
			if(new Double(content[6])<0){
				throw new Exception("业务量或业务发生金额必须为正数");
			}
			//8.应发酬金合计
			if(!CheckUtil.checkDouble(content[7],10, 2)){
				throw new Exception("应发酬金合计必须精确到两位小数");
			}
			if(new Double(content[7])<0){
				throw new Exception("应发酬金合计必须为正数");
			}
			//9.本期应发酬金
			if(!CheckUtil.checkDouble(content[8],10, 2)){
				throw new Exception("本期应发酬金必须精确到两位小数");
			}
			if(new Double(content[8])<0){
				throw new Exception("本期应发酬金必须为正数");
			}
			//10.审批编码
			if(!"00000".equals(content[9])){
				ChAdtBusitoapproveControl cbcontrol = (ChAdtBusitoapproveControl)ControlFactory.build(ChAdtBusitoapproveControlBean.class);
				ChAdtBusitoapproveListVO cblistvo = new ChAdtBusitoapproveListVO();
				//cblistvo.set_ne_approveid(content[9]);
				cblistvo.set_se_opnid(content[1]);
				cblistvo.set_orderby("apptime");
				cblistvo.set_desc("1");
				DataPackage cbdp = cbcontrol.doQuery(cblistvo, user);
				ChAdtBusitoapproveVO cbvo = new ChAdtBusitoapproveVO();
				if(null!= cbdp && cbdp.getDatas().size()>0){
					List cbdplist = (ArrayList)cbdp.getDatas();
					cbvo = (ChAdtBusitoapproveVO)cbdplist.get(0);
				}else{
					throw new Exception("审批编码"+ content[9]+"不是当前业务最新的审批编码,请根据业务编码在COMS前台界面: 酬金管理->社会渠道业务管理->数据有效性管理->业务与审批编码关系查询,获取最新的审批编码");
				}
				//if(!(Long.valueOf(content[9]).longValue() == cbvo.getApproveid().longValue())){
				if(!content[9].equals(cbvo.getApproveid())){	//审批编码改为string型
					throw new Exception("审批编码"+ content[9]+"不是当前业务最新的审批编码,请根据业务编码在COMS前台界面: 酬金管理->社会渠道业务管理->数据有效性管理->业务与审批编码关系查询,获取最新的审批编码");
				}
			}
			//发布重复判断
			CityrecordControl crcontrol = (CityrecordControl) ControlFactory.build(CityrecordControlBean.class);
			CityrecordListVO listvo = new CityrecordListVO();
			if(StringUtils.isNotBlank(content[3])){//如果MOBILE不为空的计件类业务,根据:用业务编码+业务发生时间+酬金期数+业务发生号码或IMEI号+结算月份
				listvo.set_se_opnid(content[1]);
				//listvo.set_dnl_oprtime(PublicUtils.formatUtilDate(vo.getOprtime(),"yyyy-MM-dd")+" 00:00:00");
				//listvo.set_dnm_oprtime(PublicUtils.formatUtilDate(vo.getOprtime(),"yyyy-MM-dd")+" 23:59:59");
				listvo.set_de_oprtime(content[5]);
				listvo.set_ne_rewardtype(content[2]);
				listvo.set_se_mobile(content[3]);
				listvo.set_se_rewardmonth(content[4]);
				DataPackage dp = crcontrol.doQuery(listvo, user);
				if(null!=dp && dp.getDatas().size()>0){
					throw new Exception("已存在该记录上传明细");
				}
			}else if(StringUtils.isBlank(content[3]) && ("0701010100004".equals(content[1]) || 
					"0701010100003".equals(content[1]) || "0701010100002".equals(content[1]))){//如果MOBILE为空按非计件类业务,则根据:网点编码+业务编码+酬期数+业务发生时间+结算月份
				listvo.set_se_wayid(content[0]);
				listvo.set_se_opnid(content[1]);
				//listvo.set_dnl_oprtime(PublicUtils.formatUtilDate(vo.getOprtime(),"yyyy-MM-dd")+" 00:00:00");
				//listvo.set_dnm_oprtime(PublicUtils.formatUtilDate(vo.getOprtime(),"yyyy-MM-dd")+" 23:59:59");
				listvo.set_de_oprtime(content[5]);
				listvo.set_ne_rewardtype(content[2]);
				listvo.set_se_rewardmonth(content[4]);
				DataPackage dp = crcontrol.doQuery(listvo, user);
				if(null!=dp && dp.getDatas().size()>0){
					throw new Exception("已存在该记录上传明细");
				}
			}
			
			CityrecordDelegate dele = new CityrecordDelegate();
			CityrecordVO vo = new CityrecordVO();
			vo.setIsflag((short)2);
			vo.setOprcode(user.getOpercode());
			vo.setOptime(new Date());
			vo.setSystemflag((short)1);
			vo.setApproveid(null);
			
			vo.setWayid(content[0]);
			vo.setOpnid(content[1]);
			vo.setRewardtype(new Short(content[2]));
			vo.setMobile((content[3]));
			vo.setRewardmonth(content[4]);
			vo.setOprtime(PublicUtils.UtilStrToDate(content[5]));
			vo.setBusivalue(new Double(content[6]));
			vo.setPaysum(new Double(content[7]));
			vo.setPaymoney(new Double(content[8]));
			vo.setApproveid(content[9]);
			
			dele.doCreate(vo, user);
			
			line = rowCount + "   " + line + "    操作成功";
			resultVO.setOk(true);
			resultVO.setInfo(line);
			return resultVO;
			}catch (Exception ex) { // 插入失败
				line = rowCount + "   " + line + "    错误信息:" + ex.getMessage();
				resultVO.setInfo(line);
				resultVO.setOk(false);
			}
			
		return resultVO;
	}


}