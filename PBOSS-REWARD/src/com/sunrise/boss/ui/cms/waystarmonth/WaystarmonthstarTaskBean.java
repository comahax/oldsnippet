package com.sunrise.boss.ui.cms.waystarmonth;


import java.io.Serializable;
import java.util.Date;

import org.apache.commons.beanutils.BeanUtils;

import com.sunrise.boss.business.cms.waitaudit.persistent.WaitauditVO;
import com.sunrise.boss.business.cms.waystarmonth.persistent.WaystarmonthVO;
import com.sunrise.boss.business.common.sysparam.persistent.SysparamVO;
import com.sunrise.boss.delegate.cms.waystarmonth.WaystarmonthDelegate;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;
import com.sunrise.pub.tools.StringSplit;

public class WaystarmonthstarTaskBean extends BaseBatchTaskBean {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private WaystarmonthDelegate delegate;
	private CommonDelegate comdelegate;
	private Short eftmonthtype = new Short("0");
	private Date nowDate;
	
	public WaystarmonthstarTaskBean() throws Exception{
		// TODO Auto-generated constructor stub
		delegate = new WaystarmonthDelegate();
		comdelegate = new CommonDelegate(SysparamVO.class);
		nowDate = new Date();
		super.setBatchName("星级奖励酬金管理日志查询");
		super.setWriteLog(true);
	}
	
	public String doStart() {
		return "渠道网点编码|月份(YYYYMM)|星级|" + "\r\n";
	}
	
	public String doEnd() throws Exception {
        return "";
    }
	
	public Short queryEftmonthtype(User user) throws Exception{
    	Serializable pkVO=new SysparamVO();
		BeanUtils.setProperty(pkVO, "systemid","52");
		BeanUtils.setProperty(pkVO, "paramtype","channel");
		SysparamVO sysparamVO=(SysparamVO)comdelegate.doFindByPk(pkVO, user);
		if(sysparamVO==null){
			eftmonthtype = new Short("-1");
		}else{
			eftmonthtype = new Short(sysparamVO.getParamvalue());
		}
		return eftmonthtype;
	}
	
	public ResultVO processLine(String line, int rowCount, User user, WaitauditVO vo) {
		ResultVO resultVO=new ResultVO();
		String[] content = StringSplit.split(line, "|");
		try{
			if(content.length == 3){
				WaystarmonthVO createvo=new WaystarmonthVO();
				createvo.setWayid(content[0]);
				createvo.setEftmonth(content[1]);
				boolean flag = delegate.doFindByPk(createvo, user) == null;
				createvo.setSlv(new Short(content[2]));
				createvo.setOpcode(vo.getOprcode());
				createvo.setOprtime(nowDate);
				createvo.setEftmonthtype(this.queryEftmonthtype(user));
				if(flag){
					createvo = delegate.doCreate(createvo, user);
					line = rowCount + "   " + line + "    插入成功";
				}else{
					createvo = delegate.doUpdate(createvo, user);
					line = rowCount + "   " + line + "    更新成功";
				}
			}
			resultVO.setInfo(line);
			resultVO.setOk(true);
			
		}catch(Exception e){
			line = rowCount + "   " + line + "    错误信息:" + e.getMessage();
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
		return resultVO;
	}
}
