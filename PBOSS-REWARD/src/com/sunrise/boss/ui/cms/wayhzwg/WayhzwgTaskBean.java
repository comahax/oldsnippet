package com.sunrise.boss.ui.cms.wayhzwg;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.beanutils.BeanUtils;
import com.sunrise.boss.business.cms.wayhzwg.persistent.WayhzwgVO;
import com.sunrise.boss.delegate.cms.wayhzwg.WayhzwgDelegate;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;
import com.sunrise.pub.tools.StringSplit;

public class WayhzwgTaskBean extends BaseBatchTaskBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 384641381499210907L;
	private WayhzwgDelegate delegate;

	public WayhzwgTaskBean() throws Exception {
		// TODO Auto-generated constructor stub
		try {
			delegate = new WayhzwgDelegate();
			batchName = "合作年限奖违规数据导入";
			setWriteLog(true);
		} catch (Exception ex) {
			ex.printStackTrace(System.err);
		}
	}

	protected String doStart() {
		return "合作年限奖违规数据导入\r\n";
	}

	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		String[] content = StringSplit.split(line, "|");
		SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
		Date date;
		try {
			WayhzwgVO createvo = new WayhzwgVO();		
			createvo.setWayid(content[0]);		
			date = format.parse(content[1]);
			content[1]=format.format(date);		
			createvo.setWgmonth(content[1]);	
			createvo.setRemark(content[2]);
			
			WayhzwgVO queryvo = (WayhzwgVO) BeanUtils
				.cloneBean(createvo);
			if (delegate.doFindByPk(queryvo, user) == null) {
				createvo.setState(new Short("0"));
				delegate.doCreate(createvo, user);
				line = rowCount + "   " + line + "    新增成功";
			} else {
				queryvo.setRemark(createvo.getRemark());
				delegate.doUpdate(queryvo, user);
				line = rowCount + "   " + line + "    更新成功";
			}
			resultVO.setInfo(line);
			resultVO.setOk(true);
			
		} catch (Exception e) {
			line = rowCount + "   " + line + "    错误信息:" + e.getMessage();
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
		return resultVO;
	}
}
