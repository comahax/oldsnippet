package com.gmcc.pboss.web.sales.actrepair;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.channel.waytype.WaytypeVO;
import com.gmcc.pboss.business.sales.actrepair.ActrepairVO;
import com.gmcc.pboss.business.sales.noactinfo.NoactinfoVO;
import com.gmcc.pboss.common.batch.processfile.BaseBatchTaskBean;
import com.gmcc.pboss.common.batch.processfile.ResultVO;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.sales.actrepair.Actrepair;
import com.gmcc.pboss.control.sales.actrepair.ActrepairBO;
import com.gmcc.pboss.control.sales.noactinfo.Noactinfo;
import com.gmcc.pboss.control.sales.noactinfo.NoactinfoBO;
import com.gmcc.pboss.web.sales.noactinfo.NoactinfoWebParam;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class ActrepairTaskBean extends BaseBatchTaskBean {

	public ActrepairTaskBean() throws Exception {
		super.setBatchName("�׿���������������¼");
		// super.setWriteLog(true);
	}

	protected String doStart() {
		return "���|����|��������|��¼ԭ��|����ԭ��|\r\n";
	}

	/**
	 * ����һ����¼
	 */
	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			Actrepair actrepair = (Actrepair) BOFactory.build(
					ActrepairBO.class, user);
			String items[] = StringUtils.splitPreserveAllTokens(line, "|");
			ActrepairVO vo = new ActrepairVO();
			vo.setMobileno(items[0]);
			vo.setActivedate(df.parse(items[1]));
			vo.setCause(items[2]);
			
			
			String mobileno = vo.getMobileno();
			ActrepairWebParam actrepairWebParam = new ActrepairWebParam();
			actrepairWebParam.set_se_mobileno(mobileno);


			NoactinfoVO noactinfoVO = new NoactinfoVO();//������뼤�����Ϣ
			noactinfoVO.setActivedate(vo.getActivedate());
			noactinfoVO.setMemo("ǰ̨��¼");
			noactinfoVO.setCreattime(new Date(System.currentTimeMillis()));
			noactinfoVO.setMobileno(mobileno);
			
			Noactinfo noactinfo = (Noactinfo) BOFactory.build(NoactinfoBO.class,
					user);
			Sysparam sys = (Sysparam) BOFactory.build(SysparamBO.class,user);
			String day = sys.doFindByID("75", "pboss_fx");
			if (day == null || day.equals("")) {
				day = "3";
			}
			boolean bo = actrepair.doCheckDate(mobileno, vo.getActivedate(),day);
			if (bo) {
				noactinfo.doCreate(noactinfoVO);//��Ӽ�������
				actrepair.doCreate(vo);
			} else {
				throw new Exception("�ú���ļ����¼�Ѿ����ڣ����顣");
			}
			
			line = rowCount + "|" + line + "    �ɹ�";
			resultVO.setInfo(line);
			resultVO.setOk(true);
		} catch (Exception e) {
			line = rowCount + "|" + line + "    ����ԭ��:" + e.getMessage();
			e.printStackTrace();
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
		return resultVO;
	}

	public static void main(String[] s) {

	}
}
