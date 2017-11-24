package com.gmcc.pboss.control.sales.bgcontrol.BookResRelease;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;

import com.gmcc.pboss.business.sales.bgbusiness.BookResRelease.BookResReleaseDAO;
import com.gmcc.pboss.business.sales.smpextramid.SmpextramidDBParam;
import com.gmcc.pboss.business.sales.smpextramid.SmpextramidVO;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.sales.smpextramid.Smpextramid;
import com.gmcc.pboss.control.sales.smpextramid.SmpextramidBO;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class BookResReleaseBO extends AbstractControlBean implements
		BookResRelease {

	private Logger log = Logger.getLogger(BookResReleaseBO.class);
	
	public void doUpdateComPackAndExtra(String batchno, String boxno,SmpextramidVO seVo) throws Exception {
		try {
			BookResReleaseDAO dao = (BookResReleaseDAO)DAOFactory.build(BookResReleaseDAO.class, user);
			dao.updateComPack(batchno, boxno);
			Smpextramid seBo = (Smpextramid)BOFactory.build(SmpextramidBO.class,user);
			seBo.doUpdate(seVo);
		}catch(Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doProcess() throws Exception {
		
		log.info("**************************smpResRelease begin*********************");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Sysparam spBo = (SysparamBO)BOFactory.build(SysparamBO.class, user);
		String spOvertimeMinValue = spBo.doFindByID(28L, "pboss_fx");
		// Ԥ����ʱ������
		String overtimeMinStr = "";
		if(spOvertimeMinValue == null) {
			log.warn("ϵͳ�������ñ���û�в�������Ϊ��pboss_fx����������ʶΪ��28�������ݣ���5 ����");
			overtimeMinStr = "5";
		}else if("".equals(spOvertimeMinValue.trim())) {
			log.warn("ϵͳ�������ñ��� \"Ԥ����ʱ������\"��ֵΪ�գ���5����");
			overtimeMinStr = "5";
		}else {
			overtimeMinStr = spOvertimeMinValue.trim();
		}
		int overtimeMin = Integer.parseInt(overtimeMinStr);
		Smpextramid seBo = (SmpextramidBO)BOFactory.build(SmpextramidBO.class,user);
		BookResRelease brBo = (BookResRelease)BOFactory.build(BookResReleaseBO.class, user, BOFactory.PROPAGATION_REQUIRES_NEW);
		SmpextramidDBParam seParam = new SmpextramidDBParam();
		seParam.set_ne_validflag("1");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MINUTE, -overtimeMin);
		String extratime = format.format(cal.getTime());
		seParam.set_dnm_extratime(extratime);
		seParam.set_pagesize("0");
		seParam.setDataOnly(true);
		DataPackage seDp = seBo.doQuery(seParam);
		Collection seDatas = seDp.getDatas();
		if(seDatas != null && seDatas.size() > 0) {
			List<SmpextramidVO> seList = new ArrayList<SmpextramidVO>(seDatas);
			for(SmpextramidVO seVo : seList) {
				try {
					String batchno = seVo.getBatchno();
					String boxno = seVo.getBoxnum();
					seVo.setValidflag(Short.valueOf("0"));
					brBo.doUpdateComPackAndExtra(batchno, boxno,seVo);
					log.info("������Ϊ"+batchno+",����Ϊ"+boxno+",ԭ��״̬Ϊ\"Ԥ��\"����Ʒ����״̬�޸�Ϊ\"����\"");
				}catch(Exception ex) {
					// Ԥ��д��־����
					LoggerUtils.error(ex, log);
				}
			}
		}
		log.info("**************************smpResRelease end*********************");
	
	}
}
