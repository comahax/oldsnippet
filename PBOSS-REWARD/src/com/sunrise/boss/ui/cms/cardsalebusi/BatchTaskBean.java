package com.sunrise.boss.ui.cms.cardsalebusi;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sunrise.boss.business.cms.cardsalebusi.persistent.CardsalebusiListVO;
import com.sunrise.boss.business.cms.cardsalebusi.persistent.CardsalebusiVO;
import com.sunrise.boss.business.cms.operation.persistent.OperationVO;
import com.sunrise.boss.delegate.cms.cardsalebusi.CardsalebusiDelegate;
import com.sunrise.boss.delegate.cms.operation.OperationDelegate;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;

public class BatchTaskBean extends BaseBatchTaskBean {
	private CardsalebusiDelegate delegate;

	private Log log = LogFactory.getLog(BatchTaskBean.class);

	public BatchTaskBean() {
		try {
			super.setWriteLog(true);
			super.setBatchName("套卡激活批量导入");
			delegate = new CardsalebusiDelegate();
		} catch (Exception e) {
			log.error(e);
		}
	}

	protected String doStart() {
		return "序号 | 号码 | 激活时间 | 出错信息" + "\r\n";
	}

	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		String msg = "";
		
		String[] items = StringUtils.splitPreserveAllTokens(line, "|");
		try {
			CardsalebusiVO cardsalebusiVO = setSaveVO(items);
			
			delegate.doCreate(cardsalebusiVO, user);
			resultVO.setOk(true);
			resultVO.setInfo(showInfo(resultVO, items, rowCount));
		} catch (Exception e) {
			log.error(e);
			msg = e.getMessage();
			resultVO.setOk(false);
			resultVO.setInfo(showInfo(resultVO, items, rowCount) + msg);
		}
		return resultVO;
	}

	/**
	 * 号码0|品牌1|建议零售价2|买断价格3|销售折扣4|激活时间5|渠道编码6|业务分类信息编码7
	 */
	private CardsalebusiVO setSaveVO(String[] items) throws Exception {
		CardsalebusiVO cardsalebusiVO = new CardsalebusiVO();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		cardsalebusiVO.setMobile(items[0]);
		if (!"".equals(items[1])) {
			cardsalebusiVO.setBrand(new Long(items[1]));
		}
		if (!"".equals(items[2].trim())) {
			cardsalebusiVO.setRetailprice(new Double(items[2]));
		}
		if (!"".equals(items[3].trim())) {
			cardsalebusiVO.setBuyprice(new Double(items[3]));
		}
		if (!"".equals(items[4].trim())) {
			cardsalebusiVO.setDiscount(new Double(items[4]));
		}
		if (!"".equals(items[5])) {
			cardsalebusiVO.setOpntime(format.parse(items[5]));
		}
		cardsalebusiVO.setWayid(items[6]);

		if (!"".equals(items[1])) {
			OperationDelegate delegate = new OperationDelegate();
			OperationVO vo = delegate.doFindByPk(items[7], user);
			if (vo == null) {
				throw new Exception("业务分类信息编码：" + items[7] + "不存在");
			} else if (delegate.getParentlevel(vo, user) != 4) {
				throw new Exception("业务分类信息编码必须选择第五级");
			}
			cardsalebusiVO.setOpntype(items[7]);
		}
		return cardsalebusiVO;
	}

	/**
	 * 结果文件格式
	 */
	public String showInfo(ResultVO resultVO, String[] items, int rowCount) {
		final String COMPART = " | "; // 分隔
		StringBuffer resultStr = new StringBuffer();
		// 序号
		resultStr.append(rowCount).append(COMPART);
		resultStr.append(items[0]).append(COMPART);
		resultStr.append(items[5]).append(COMPART);
		resultStr.append("增加");
		// 办理结果
		if (resultVO.isOk()) {
			resultStr.append("成功");
		} else {
			resultStr.append("失败");
		}
		resultStr.append(COMPART);
		return resultStr.toString();
	}
}
