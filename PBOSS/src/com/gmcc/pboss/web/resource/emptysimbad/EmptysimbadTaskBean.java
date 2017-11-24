package com.gmcc.pboss.web.resource.emptysimbad;

import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.resource.emptysimbad.EmptysimbadDBParam;
import com.gmcc.pboss.business.resource.emptysimbad.EmptysimbadVO;
import com.gmcc.pboss.common.batch.processfile.BaseBatchTaskBean;
import com.gmcc.pboss.common.batch.processfile.ResultVO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.resource.emptysimbad.Emptysimbad;
import com.gmcc.pboss.control.resource.emptysimbad.EmptysimbadBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class EmptysimbadTaskBean extends BaseBatchTaskBean {

	public EmptysimbadTaskBean() throws Exception {
		super.setBatchName("�հ�SIM����������¼��");
	}

	protected String doStart() {
		return "";
	}

	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		String item[] = StringUtils.splitPreserveAllTokens(line, "|");
		try {
			Emptysimbad emptysimbadBO = (Emptysimbad) BOFactory.build(EmptysimbadBO.class, user);
			EmptysimbadVO badvo = emptysimbadBO.doFindByPk(item[0]);
			if (badvo != null) {
				throw new Exception ("��ͬ��¼�Ѿ����ڣ�����");
			}
			
			EmptysimbadDBParam params = new EmptysimbadDBParam();
			params.set_se_emptyno(item[0]);
			DataPackage dp = emptysimbadBO.doQueryComcategory(params);
			if (dp.getDatas() == null || dp.getDatas().size() == 0) {
				throw new Exception ("δ�ҵ��ÿհ�SIM����Ӧ����Ʒ���࣬���顣");
			}
			
			Way wayBO = (WayBO) BOFactory.build(WayBO.class, user);
			WayVO wayvo = wayBO.doFindByPk(item[1]);
			if (wayvo == null) {
				throw new Exception ("��������["+item[1]+"]������");
			}
			
			EmptysimbadVO vo = new EmptysimbadVO();
			vo.setEmptyno(item[0]);
			vo.setComcategory(dp.getDatas().get(0).toString());
			vo.setWayid(item[1]);
			vo.setCreatetime(new Date());
			vo.setOprcode(user.getOprcode());
			emptysimbadBO.doCreate(vo);
			
			line = rowCount + "   " + line + "    �ɹ�";
			resultVO.setInfo(line);
			resultVO.setOk(true);
		} catch (Exception e) {
			line = rowCount + "   " + line + "    ������Ϣ:" + e.getMessage();
			resultVO.setInfo(line);
			resultVO.setOk(false);
			e.printStackTrace();
		}
		return resultVO;
	}

}
