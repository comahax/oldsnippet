package com.sunrise.boss.ui.cms.wayhznx;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.business.cms.wayhznx.persistent.WayhznxVO;
import com.sunrise.boss.delegate.cms.wayhznx.WayhznxDelegate;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;

public class WayhznxBatchTaskBean extends BaseBatchTaskBean{
	
	private WayhznxDelegate delegate;
 
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	private Date date;

	public WayhznxBatchTaskBean() throws Exception {
		delegate = new WayhznxDelegate();
		date = new Date();
		super.setBatchName("计算合作年限的开始时间设置导入日志查询");
	}
	
	protected String doStart() {
		return "计算合作年限的开始时间设置导入结果 \r\n";
	}
	
	/**
	 * 处理一条记录
	 */
	public ResultVO processLine(String line, int rowCount) {
		if (null == line || "".equals(line)) {
			return null;
		}
		ResultVO resultVO = new ResultVO();
		String[] items = StringUtils.splitPreserveAllTokens(line, "|");
		try{
			boolean isCreate = false; 
			WayhznxVO vo = delegate.doFindByPk(items[0], user);
			if(vo == null){
				isCreate = true;
				vo = new WayhznxVO();
			}
			vo.setWayid(items[0]);
			vo.setCleartime(sdf.parse(items[1]));
			vo.setRemark(items[2]);
			vo.setOprcode(user.getOpercode());
			vo.setOprtime(date);
			
			if(isCreate){
				delegate.doCreate(vo, user);
				line = rowCount + "   " + line + "    创建成功";
			}else{
				delegate.doUpdate(vo, user);
				line = rowCount + "   " + line + "    更新成功";
			}
			
			resultVO.setInfo(line);
			resultVO.setOk(true);
			
		}catch (Exception e) {
			// TODO: handle exception
			line = rowCount + "   " + line + "    错误信息:" + e.getMessage();
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
		return resultVO;
	}
	
}
