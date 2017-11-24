package com.sunrise.boss.ui.cms.waystrarewardstd;

import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;


import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.delegate.cms.reward.assess.AssessDelegate;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.delegate.cms.waystrarewardstd.WaystrarewardstdDelegate;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;
import com.sunrise.boss.business.cms.reward.assess.persistent.AssessListVO;
import com.sunrise.boss.business.cms.reward.assess.persistent.AssessVO;
import com.sunrise.boss.business.cms.way.persistent.WayListVO;
import com.sunrise.boss.business.cms.waystrarewardstd.persistent.WaystrarewardstdListVO;
import com.sunrise.boss.business.cms.waystrarewardstd.persistent.WaystrarewardstdVO;

public class WaystrarewardstdTaskBean extends BaseBatchTaskBean {
	public WaystrarewardstdTaskBean() throws Exception {
		super.setBatchName("考核分数导入");
		super.setWriteLog(true);
		// TODO Auto-generated constructor stub
	}

	protected String doStart() {
		return "考核分数导入 \r\n";
	}

	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		String msg = "";
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		try {
			
			
			//1、判断渠道编码是否存在,不用判断,否则速度太慢,直接在后台处理,康熠已经确认了
			WayDelegate waydelegate=new WayDelegate();
			WayListVO wayListVO = new WayListVO();
			wayListVO.set_se_wayid(content[0]);
			wayListVO.set_ne_waystate(Short.valueOf("1"));
			wayListVO.set_se_waytype("AG");
			DataPackage waydp = waydelegate.doQuery(wayListVO, user);
			if(waydp.getRowCount()==0){
				throw new Exception("渠道编码不存在");

			}
			
			Set<String> set = new HashSet<String>();
			set.add("-1");
			set.add("0");
			set.add("1");
			set.add("2");
			set.add("3");
			set.add("30");
			set.add("4");
			set.add("5");
			set.add("51");
			set.add("52");
			set.add("53");
			set.add("54");
			set.add("55");
			set.add("6");
			set.add("7");
			set.add("8");
			if(!set.contains(content[2])){
				throw new Exception("酬金类型不存在");	

			}
			
			WaystrarewardstdDelegate waystrarewardstdDelegate=new WaystrarewardstdDelegate();
			WaystrarewardstdListVO listvo=new WaystrarewardstdListVO();
			listvo.set_se_wayid(content[0]);
			listvo.set_ne_cityid(user.getCityid());
			listvo.set_ne_rewardstd(content[1]);
			listvo.set_ne_rewardtype(content[2]);
			DataPackage dp=waystrarewardstdDelegate.doQuery(listvo, user);
			if(dp!=null&&dp.getDatas().size()>0){
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				WaystrarewardstdVO waystrarewardstdVO=new WaystrarewardstdVO();
				waystrarewardstdVO.setWayid(content[0]);
				waystrarewardstdVO.setRewardstd(Double.parseDouble(content[1]));
				waystrarewardstdVO.setRewardtype(Long.parseLong(content[2]));
				waystrarewardstdVO.setRemark(content[3]);
				waystrarewardstdVO.setOpercode(user.getOpercode());
				waystrarewardstdVO.setOpertype("U");
				java.util.Date date = new java.util.Date();
				waystrarewardstdVO.setOpertime(date);
				waystrarewardstdVO.setCityid(new Short(user.getCityid()));
				waystrarewardstdVO.setSeq(((WaystrarewardstdVO)(dp.getDatas().iterator().next())).getSeq());
				
				
				waystrarewardstdDelegate.doUpdate(waystrarewardstdVO, user);
			}
			else{
				
				WaystrarewardstdVO waystrarewardstdVO=new WaystrarewardstdVO();
				waystrarewardstdVO.setWayid(content[0]);
				waystrarewardstdVO.setRewardstd(Double.parseDouble(content[1]));
				waystrarewardstdVO.setRewardtype(Long.parseLong(content[2]));
				waystrarewardstdVO.setRemark(content[3]);
				waystrarewardstdVO.setOpercode(user.getOpercode());
				waystrarewardstdVO.setOpertype("I");
				java.util.Date date = new java.util.Date();
				waystrarewardstdVO.setOpertime(date);
				waystrarewardstdVO.setCityid(new Short(user.getCityid()));
				waystrarewardstdDelegate.doCreate(waystrarewardstdVO, user);
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