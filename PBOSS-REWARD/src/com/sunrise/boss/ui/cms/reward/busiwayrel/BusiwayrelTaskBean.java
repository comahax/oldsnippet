package com.sunrise.boss.ui.cms.reward.busiwayrel;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sunrise.boss.business.cms.reward.busiwayrel.persistent.BusiwayrelVO;

import com.sunrise.boss.delegate.cms.reward.busiwayrel.BusiwayrelDelegate;

import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;
import com.sunrise.pub.tools.StringSplit;

public class BusiwayrelTaskBean extends BaseBatchTaskBean {

	private BusiwayrelDelegate delegate;

	private static final Log log = LogFactory.getLog(BusiwayrelBatchCheck.class);

	private String oprType;

	public String getOprType() {
		return oprType;
	}

	public void setOprType(String oprType) {
		this.oprType = oprType;
	}

	public BusiwayrelTaskBean() throws Exception {
		// TODO Auto-generated constructor stub
		delegate = new BusiwayrelDelegate();
		super.setBatchName("业务需计酬渠道设置导入日志查询");
		super.setWriteLog(true);
	}

	protected String doStart() {
		try {
			if (parameterMap.get("oprType") != null
					&& !"".equals((String) parameterMap.get("oprType"))) {
				setOprType((String) parameterMap.get("oprType"));
			}
			if (log.isInfoEnabled()) {
				log.info(oprType);
			}
		} catch (Exception ex) {
			log.error(ex.getMessage());
		}
		return "业务需计酬渠道设置导入结果 \r\n";
	}

	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		String[] content = StringSplit.split(line, "|");

		try {
			BusiwayrelVO createvo = new BusiwayrelVO();
			if ("1".equals(getOprType())) {
				createvo.setOpnid(content[0]);
				createvo.setWayid(content[1]);
				String str = delegate.doBatchCreate(createvo, user);
				line = rowCount + "   " + line ;
				if (!"".equals(str) && str.length() > 0) {
					line += str+"    新增成功";
				}else
				{
					line+="    新增成功";
				}
			} else if ("3".equals(getOprType())) {
				createvo.setOpnid(content[0]);
				createvo.setWayid(content[1]);
				String str = delegate.doBatchRemove(createvo, user);
				line = rowCount + "   " + line ;
				if (!"".equals(str) && str.length() > 0) {
					line += str+ "    删除成功";
				}else
				{
					line+="     删除成功";
				}
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
