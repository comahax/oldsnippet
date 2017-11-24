package com.sunrise.boss.ui.cms.reward.chadtwayspecialreward;

import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.business.cms.reward.chadtwayspecialreward.persistent.ChAdtWayspecialrewardListVO;
import com.sunrise.boss.business.cms.reward.chadtwayspecialreward.persistent.ChAdtWayspecialrewardVO;
import com.sunrise.boss.business.cms.way.persistent.WayListVO;
import com.sunrise.boss.business.cms.waystrarewardstd.persistent.WaystrarewardstdVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.delegate.cms.reward.chadtwayspecialreward.ChAdtWayspecialrewardDelegate;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;

public class ChAdtWayspecialrewardTaskBean extends BaseBatchTaskBean {

	public ChAdtWayspecialrewardTaskBean() {
		super.setBatchName("特殊计酬渠道设置上传");
		super.setWriteLog(true);
	}

	protected String doStart() {
		return "特殊计酬渠道设置上传结果 \r\n";
	}

	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		String msg = "";
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		try {			
			WayDelegate waydelegate=new WayDelegate();
			WayListVO wayListVO = new WayListVO();
			wayListVO.set_se_wayid(content[0]);
//			wayListVO.set_ne_waystate(Short.valueOf("1"));
//			wayListVO.set_se_waytype("AG");
			DataPackage waydp = waydelegate.doQuery(wayListVO, user);
			if(waydp.getRowCount()==0){
				throw new Exception("查询不到渠道信息，渠道无效");
			}
			
			Set<String> set = new HashSet<String>();
			set.add("SN");
			set.add("GM");
			if(!set.contains(content[1])){
				throw new Exception("渠道类型不存在");
			}
			
			ChAdtWayspecialrewardDelegate chadtwayspecialrewardDelegate=new ChAdtWayspecialrewardDelegate();
			ChAdtWayspecialrewardListVO listvo=new ChAdtWayspecialrewardListVO();
			listvo.set_se_wayid(content[0]);
			listvo.set_se_cityid(SessionFactoryRouter.conversionCityid(user.getCityid()));
			DataPackage dp=chadtwayspecialrewardDelegate.doQuery(listvo, user);
			if(dp!=null&&dp.getDatas().size()>0){
				throw new Exception("当前渠道已存在");
			}
			else{
				ChAdtWayspecialrewardVO chadtwayspecialrewardVO=new ChAdtWayspecialrewardVO();
				chadtwayspecialrewardVO.setWayid(content[0]);
				chadtwayspecialrewardVO.setWayspetype(content[1]);
				chadtwayspecialrewardVO.setCityid(SessionFactoryRouter.conversionCityid(user.getCityid()));
				chadtwayspecialrewardVO.setCreatedate(new java.util.Date());
				
				chadtwayspecialrewardDelegate.doCreate(chadtwayspecialrewardVO, user);
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
