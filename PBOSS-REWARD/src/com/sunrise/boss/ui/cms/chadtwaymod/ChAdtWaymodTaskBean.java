package com.sunrise.boss.ui.cms.chadtwaymod;

import java.io.Serializable;

import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.business.cms.chadtwaymod.persistent.ChAdtWaymodVO;
import com.sunrise.boss.business.cms.way.persistent.WayListVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.delegate.cms.chadtwaymod.ChAdtWaymodDelegate;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;

public class ChAdtWaymodTaskBean extends BaseBatchTaskBean {

	public ChAdtWaymodTaskBean() {
		super.setBatchName("商圈门店补贴调节系数导入");
		super.setWriteLog(true);
	}

	protected String doStart() {
		return "商圈门店补贴调节系数导入 \r\n";
	}

	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		try {
			WayDelegate waydelegate = new WayDelegate();
			WayListVO wayListVO = new WayListVO();
			wayListVO.set_se_wayid(content[0]);
			wayListVO.set_ne_waystate(Short.valueOf("1"));
			wayListVO.set_se_waytype("AG");
			DataPackage waydp = waydelegate.doQuery(wayListVO, user);
			if (waydp.getRowCount() == 0) {
				throw new Exception("渠道编码不存在");
			}
			
			ChAdtWaymodDelegate delegate = new ChAdtWaymodDelegate();
			ChAdtWaymodVO vo = delegate.doFindByPk((Serializable)content[0], user);
			if (vo == null) {
				ChAdtWaymodVO contentVO = new ChAdtWaymodVO();
				contentVO.setWayid(content[0]);
				contentVO.setCityid(Short.parseShort(user.getCityid()));
				contentVO.setVi(Float.parseFloat(content[1]));
				contentVO.setArea(Float.parseFloat(content[2]));
				contentVO.setDoorhead(Float.parseFloat(content[3]));
				contentVO.setBackboard(Float.parseFloat(content[4]));
				contentVO.setPropaganda(Float.parseFloat(content[5]));
				delegate.doCreate(contentVO, user);
			} else {
				vo.setVi(Float.parseFloat(content[1]));
				vo.setArea(Float.parseFloat(content[2]));
				vo.setDoorhead(Float.parseFloat(content[3]));
				vo.setBackboard(Float.parseFloat(content[4]));
				vo.setPropaganda(Float.parseFloat(content[5]));
				delegate.doUpdate(vo, user);
			}
			
			line = rowCount + "   " + line + "    操作成功";
			resultVO.setOk(true);
			resultVO.setInfo(line);
			return resultVO;
		} catch (Exception ex) { // 插入失败
			line = rowCount + "   " + line + "    错误信息:" + ex.getMessage();
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
		return resultVO;
	}

}
