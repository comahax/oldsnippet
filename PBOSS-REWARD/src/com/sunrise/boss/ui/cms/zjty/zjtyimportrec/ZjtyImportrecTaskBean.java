package com.sunrise.boss.ui.cms.zjty.zjtyimportrec;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.business.cms.way.persistent.WayListVO;
import com.sunrise.boss.business.cms.zjty.zjtyimportrec.persistent.ZjtyImportrecListVO;
import com.sunrise.boss.business.cms.zjty.zjtyimportrec.persistent.ZjtyImportrecVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.delegate.cms.zjty.zjtyimportrec.ZjtyImportrecDelegate;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;
import com.sunrise.pub.tools.PublicUtils;

public class ZjtyImportrecTaskBean extends BaseBatchTaskBean {
	public ZjtyImportrecTaskBean() throws Exception {
		super.setBatchName("自建他营本地数据批量上传");
		super.setWriteLog(true);
		// TODO Auto-generated constructor stub
	}

	protected String doStart() {
		return "自建他营本地数据批量上传 \r\n";
	}

	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		String msg = "";
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		try {
			
			//判断渠道是否存在，且是否为自建他营的渠道
			//（Select WAYID from ch_pw_way Where    WAYTYPE = 'AG' AND WAYSUBTYPE = 'ZJTY'），但是注意不需要判断渠道是否有效，补算是网点虽然已经失效，但是仍然要允许导入。
			WayDelegate waydelegate=new WayDelegate();
			WayListVO wayListVO = new WayListVO();
			wayListVO.set_se_wayid(content[2]);
			//wayListVO.set_ne_waystate(Short.valueOf("1"));
			wayListVO.set_se_waytype("AG");
			wayListVO.set_se_waysubtype("ZJTY");
			DataPackage waydp = waydelegate.doQuery(wayListVO, user);
			if(waydp.getRowCount()==0){
				throw new Exception("业务发生渠道不存在");

			}
			
			//1.结算月份
			try{
				Date now = new Date();
				String nowstr = PublicUtils.formatUtilDate(now, "yyyyMM");
				if(new Long(content[0])>new Long(nowstr)){
					throw new Exception("结算月份不能大于当前月份");
				}
			}catch (Exception e) {
				throw new Exception("结算月份不正确");
			}
			//4.业务发生时间
			try{
				Date date = PublicUtils.UtilStrToDate(content[3], "yyyy-MM-dd HH:mm:ss");
				Calendar ca = Calendar.getInstance(Locale.CHINA);//当前时间
				Calendar ca2 = Calendar.getInstance();
				ca2.setTime(date);
				if(ca2.after(ca)){
					throw new Exception("业务发生时间不能大于当前系统时间");
				}
			}catch (Exception e) {
				throw new Exception("业务发生时间不正确");
			}
			
//			结算月份|发生业务编码|业务发生渠道|业务发生时间|业务发生工号|业务发生号码|号码发生的业务量|
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ZjtyImportrecDelegate zjtyimportrecDelegate=new ZjtyImportrecDelegate();
			ZjtyImportrecListVO listvo=new ZjtyImportrecListVO();
//			listvo.set_se_calcmonth(content[0]);
			listvo.set_se_opnid(content[1]);
			listvo.set_se_wayid(content[2]);
			listvo.set_de_oprtime(content[3]);
			if(content[5].trim().length()>0){
				listvo.set_se_mobile(content[5]);
			}
			DataPackage dp=zjtyimportrecDelegate.doQuery(listvo, user);
			if(dp!=null&&dp.getDatas().size()>0){
//				zjtybusyxplanVO.setCityid(user.getCityid());
//				zjtybusyxplanVO.setOpnid(content[0]);
//				zjtybusyxplanVO.setYxplanid(Long.parseLong(content[1]));
//				zjtybusyxplanVO.setPlanbusitype(content[2]);				
//				assessVO.setOpercode(user.getOpercode());
//				java.util.Date date = new java.util.Date();
//				assessVO.setOprtime(date);
//				assessVO.setSeq(((AssessVO)(dp.getDatas().iterator().next())).getSeq());
				ZjtyImportrecVO zjtyimportrecVO=new ZjtyImportrecVO();
				zjtyimportrecVO.setCalcmonth(content[0]);
				zjtyimportrecVO.setOpnid(content[1]);
				zjtyimportrecVO.setWayid(content[2]);
				zjtyimportrecVO.setOprtime(format.parse(content[3]));
				zjtyimportrecVO.setOprcode(content[4]);
				zjtyimportrecVO.setSeq(((ZjtyImportrecVO)(dp.getDatas().iterator().next())).getSeq());
				if(content[5]!=null && content[5].length()>0){
					zjtyimportrecVO.setMobile(content[5]);
				}
				if(content[6]!=null && content[6].length()>0){
					zjtyimportrecVO.setBusivalue(Double.parseDouble(content[6]));
				}
				
				zjtyimportrecDelegate.doUpdate(zjtyimportrecVO, user);
			}
			else{
				
				ZjtyImportrecVO zjtyimportrecVO=new ZjtyImportrecVO();
				zjtyimportrecVO.setCalcmonth(content[0]);
				zjtyimportrecVO.setOpnid(content[1]);
				zjtyimportrecVO.setWayid(content[2]);
				zjtyimportrecVO.setOprtime(format.parse(content[3]));
				zjtyimportrecVO.setOprcode(content[4]);
				if(content[5]!=null && content[5].length()>0){
					zjtyimportrecVO.setMobile(content[5]);
				}
				if(content[6]!=null && content[6].length()>0){
					zjtyimportrecVO.setBusivalue(Double.parseDouble(content[6]));
				}
				
				zjtyimportrecDelegate.doCreate(zjtyimportrecVO, user);
			}
			
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