package com.sunrise.boss.ui.cms.chadtsales;

import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.business.cms.chadtsales.persistent.ChAdtSalesListVO;
import com.sunrise.boss.business.cms.chadtsales.persistent.ChAdtSalesVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.delegate.cms.chadtsales.ChAdtSalesDelegate;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;

public class ChAdtSalesTaskBean extends BaseBatchTaskBean {

	public ChAdtSalesTaskBean() {
		super.setBatchName("商圈门店补贴销量达标奖励标准批量设置");
		super.setWriteLog(true);
	}

	protected String doStart() {
		return "商圈门店补贴销量达标奖励标准批量设置 \r\n";
	}

	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		System.out.println(line);
		try {
			ChAdtSalesDelegate chadtsalesdelegate = new ChAdtSalesDelegate();
			ChAdtSalesListVO chadtsaleslistvo = new ChAdtSalesListVO();
			chadtsaleslistvo.set_se_opnid(content[0]);
			chadtsaleslistvo.set_se_wayattr(content[1]);
			chadtsaleslistvo.set_ne_cityid(Short.parseShort(user.getCityid()));
			chadtsaleslistvo.set_se_sales(content[2]);
			DataPackage chadtsalesdp = chadtsalesdelegate.doQuery(chadtsaleslistvo, user);
			
			ChAdtSalesVO chAdtSalesVO  = new ChAdtSalesVO();
			chAdtSalesVO.setCityid(Short.parseShort(user.getCityid()));
			chAdtSalesVO.setOpnid(content[0]);
			chAdtSalesVO.setRewardstd(Double.parseDouble(content[3]));
			chAdtSalesVO.setSales(Long.parseLong(content[2]));
			chAdtSalesVO.setWayattr(content[1]);
			
			
			if (chadtsalesdp.getRowCount() == 0) {
				chadtsalesdelegate.doCreate(chAdtSalesVO, user);
			}else{
				chadtsalesdelegate.doUpdate(chAdtSalesVO, user);
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
