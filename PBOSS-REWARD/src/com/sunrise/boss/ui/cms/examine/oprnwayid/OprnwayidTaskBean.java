package com.sunrise.boss.ui.cms.examine.oprnwayid;


import com.sunrise.boss.business.cms.examine.oprnwayid.persistent.OprnwayidListVO;
import com.sunrise.boss.business.cms.examine.oprnwayid.persistent.OprnwayidVO;
import com.sunrise.boss.business.common.sysparam.persistent.SysparamVO;
import com.sunrise.boss.delegate.cms.examine.oprnwayid.OprnwayidDelegate;
import com.sunrise.boss.delegate.common.sysparam.SysparamDelegate;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;
import com.sunrise.pub.tools.StringSplit;

public class OprnwayidTaskBean extends BaseBatchTaskBean {

	private OprnwayidDelegate delegate;

	public OprnwayidTaskBean() throws Exception {
		// TODO Auto-generated constructor stub
		delegate = new OprnwayidDelegate();
		super.setBatchName("渠道授权评分批量导入日志查询");
		super.setWriteLog(true);
	}

	protected String doStart() {
		return "渠道授权评分批量导入结果 \r\n";
	}

	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		String[] content = StringSplit.split(line, "|");

		try {
				OprnwayidListVO listvo = new OprnwayidListVO();
				
				OprnwayidVO vo = new OprnwayidVO();
				vo.setOperid(content[0]);
				vo.setWayid(content[1]);
				listvo.set_se_wayid(content[1]);
				OprnwayidVO rvo = delegate.doFindByPk(vo, user);
				if (rvo == null) {
					SysparamDelegate sysdelegate = new SysparamDelegate();
					SysparamVO sysvo = new SysparamVO();
					sysvo.setSystemid(new Long(9));
					sysvo.setParamtype("pboss");
					sysvo = (SysparamVO) sysdelegate.doFindByPk(sysvo, user);
					if (sysvo != null && sysvo.getParamvalue().equals("1")) {
						if(delegate.doQuery(listvo, user).getDatas().size()>0){
							line = rowCount + "   " + line + "    错误信息:" + "新增失败, 一个被评分渠道只允许关联一个评分工号!";
							resultVO.setInfo(line);
							resultVO.setOk(false);
						}else{
							delegate.doCreate(vo, user);
							line = rowCount + "   " + line + "    新增成功";
							resultVO.setInfo(line);
							resultVO.setOk(true);
						}
					}else{
						delegate.doCreate(vo, user);
						line = rowCount + "   " + line + "    新增成功";
						resultVO.setInfo(line);
						resultVO.setOk(true);
					}
					
				}else{
					line = rowCount + "   " + line + "    错误信息:" + "导入记录在系统已存在!";
					resultVO.setInfo(line);
					resultVO.setOk(false);
				}
		} catch (Exception e) {
			line = rowCount + "   " + line + "    错误信息:" + e.getMessage();
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
		return resultVO;
	}
}
