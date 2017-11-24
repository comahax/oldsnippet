package com.sunrise.boss.ui.cms.examine.itemgraded;

import java.io.Serializable;

import org.apache.commons.beanutils.BeanUtils;

import com.sunrise.boss.business.cms.examine.itemgraded.persistent.ItemgradedVO;
import com.sunrise.boss.business.common.sysparam.persistent.SysparamVO;
import com.sunrise.boss.delegate.cms.examine.itemgraded.ItemgradedDelegate;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;
import com.sunrise.pub.tools.StringSplit;

public class ItemgradedTaskBean extends BaseBatchTaskBean {

	private ItemgradedDelegate delegate;

	public ItemgradedTaskBean() throws Exception {
		// TODO Auto-generated constructor stub
		delegate = new ItemgradedDelegate();
		super.setBatchName("评分登记批量导入日志查询");
		super.setWriteLog(true);
	}

	protected String doStart() {
		return "评分登记批量导入结果 \r\n";
	}

	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		String[] content = StringSplit.split(line, "|");

		try {	
				ItemgradedDelegate delegate = new ItemgradedDelegate();
				ItemgradedVO itemvo = new ItemgradedVO();
				itemvo.setWayid(content[0]);
				itemvo.setExmnid(new Integer(content[1]));
				itemvo.setExmnstdid(new Integer(content[2]));
				itemvo.setExmnperiod(content[3]);
				itemvo.setPenalmark(new Float(content[4]));
				itemvo.setMemo(content[5]);
				
				CommonDelegate comdelegate = new CommonDelegate(SysparamVO.class);
		    	Serializable pkVO=new SysparamVO();
				BeanUtils.setProperty(pkVO, "systemid","60");
				BeanUtils.setProperty(pkVO, "paramtype","channel");
				SysparamVO sysparamVO=(SysparamVO)comdelegate.doFindByPk(pkVO, user);
				if("0".equals(sysparamVO.getParamvalue()))
					itemvo.setState("1");
				else
					itemvo.setState("99");
				itemvo.setRegistercode(user.getOpercode());
				
				delegate.doCreate(itemvo, user);
				line = rowCount + "   " + line + "    新增成功!";
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
