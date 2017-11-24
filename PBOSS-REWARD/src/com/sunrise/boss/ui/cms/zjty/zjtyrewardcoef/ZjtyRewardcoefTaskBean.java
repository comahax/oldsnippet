package com.sunrise.boss.ui.cms.zjty.zjtyrewardcoef;

import org.apache.commons.beanutils.BeanUtils;

import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.business.cms.zjty.zjtyrewardcoef.persistent.ZjtyRewardcoefVO;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.delegate.cms.zjty.zjtyrewardcoef.ZjtyRewardcoefDelegate;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;
import com.sunrise.pub.tools.StringSplit;

public class ZjtyRewardcoefTaskBean extends BaseBatchTaskBean {

	private ZjtyRewardcoefDelegate delegate;

	public ZjtyRewardcoefTaskBean() throws Exception {
		// TODO Auto-generated constructor stub
		delegate = new ZjtyRewardcoefDelegate();
		super.setBatchName("自建他营酬金系数批量导入日志查询");
		super.setWriteLog(true);
	}

	protected String doStart() {
		return "自建他营酬金系数批量导入结果 \r\n";
	}

	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		String[] content = StringSplit.split(line, "|");

		try {
			if (content.length == 3) {
				ZjtyRewardcoefVO delvo = new ZjtyRewardcoefVO();
				delvo.setEffectiblemonth(content[0]);
				delvo.setCoefid(new Short(content[1]));
				delvo.setWayid(content[2]);
				delvo = delegate.doFindByPk(delvo, user);
				if (delvo != null) {
					delegate.doRemove(delvo, user);
					line = rowCount + "   " + line + "    删除成功";
				}
			}
			if (content.length == 5) {

				ZjtyRewardcoefVO createvo = new ZjtyRewardcoefVO();
				createvo.setEffectiblemonth(content[0]);
				createvo.setCoefid(new Short(content[1]));
				createvo.setWayid(content[2]);
				createvo.setProvidecoef(new Double(content[3]));
				createvo.setResult(content[4]);
				WayVO vo = new WayVO();
				vo.setWayid(createvo.getWayid());
				WayDelegate waydelegate = new WayDelegate();
				vo = waydelegate.doFindByPk(vo.getWayid(), user);

				createvo.setCityid(SessionFactoryRouter.conversionCityid2Num(vo
						.getCityid()));
				createvo.setIspass(new Short("1"));
				ZjtyRewardcoefVO queryvo = (ZjtyRewardcoefVO) BeanUtils
						.cloneBean(createvo);
				if (delegate.doFindByPk(queryvo, user) == null) {
					delegate.doCreate(createvo, user);
					line = rowCount + "   " + line + "    创建成功";
				} else {
					delegate.doUpdate(createvo, user);
					line = rowCount + "   " + line + "    更新成功";
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
