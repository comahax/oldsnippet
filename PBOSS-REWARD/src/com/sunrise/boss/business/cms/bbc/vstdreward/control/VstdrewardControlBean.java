/**
 * auto-generated code
 * Sun Sep 27 11:45:09 CST 2009
 */
package com.sunrise.boss.business.cms.bbc.vstdreward.control;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.ui.cms.commons.TimeUtil;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.stdreward.persistent.BBCstdrewardDAO;
import com.sunrise.boss.business.cms.bbc.stdreward.persistent.BBCstdrewardVO;
import com.sunrise.boss.business.cms.bbc.stdrewardbj.persistent.BBCstdrewardbjDAO;
import com.sunrise.boss.business.cms.bbc.stdrewardbj.persistent.BBCstdrewardbjVO;
import com.sunrise.boss.business.cms.bbc.vstdreward.persistent.VstdrewardVO;
import com.sunrise.boss.business.cms.bbc.vstdreward.persistent.VstdrewardDAO;
import com.sunrise.boss.business.cms.bbc.vstdreward.persistent.VstdrewardListVO;
import com.sunrise.boss.business.cms.wayaccount.control.WayaccountControl;
import com.sunrise.boss.business.cms.wayaccount.control.WayaccountControlBean;

/**
 * <p>
 * Title: vstdrewardControlBean
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author Jerimy
 * @version 1.0
 */
/**
 * @ejb.bean local-jndi-name="com/sunrise/boss/business/cms/bbc/vstdreward/control/VstdrewardControlBean"
 *           name="VstdrewardControl" view-type="local" type="Stateless"
 * 
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class VstdrewardControlBean extends AbstractControlBean implements VstdrewardControl {
	/*
	 * COMMON.CH_BBC_STDREWARD A, COMMON.CH_BBC_STDREWARDBJ B �����͸��¶������ű�A��B
	 */
	public VstdrewardVO doCreate(VstdrewardVO vo, User user) throws Exception {
		try {
			BBCstdrewardDAO stdDAO = (BBCstdrewardDAO) DAOFactory
					.build(BBCstdrewardDAO.class, user);
			BBCstdrewardVO stdVO = new BBCstdrewardVO();
			// Ĭ������Ϊ1
			stdVO.setRewardproj(new Short("1"));
			BeanUtils.copyProperties(stdVO, vo);
			//���ʱ�䲻���ص�
			checkQuJian(vo, user);
			stdVO = (BBCstdrewardVO) stdDAO.create(stdVO);
			BBCstdrewardbjDAO bjDAO = (BBCstdrewardbjDAO) DAOFactory.build(BBCstdrewardbjDAO.class,
					user);
			BBCstdrewardbjVO bjVO = new BBCstdrewardbjVO();
			BeanUtils.copyProperties(bjVO, vo);
			bjVO.setRewardid(stdVO.getRewardid());
			bjVO = (BBCstdrewardbjVO) bjDAO.create(bjVO);
			// ��ֵCOPY��ȥ
			BeanUtils.copyProperties(vo, stdVO);
			BeanUtils.copyProperties(vo, bjVO);
			// TODO set the pk */
			return vo;
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemove(VstdrewardVO vo, User user) throws Exception {
		try {
//			BBCstdrewardDAO stdDAO = (BBCstdrewardDAO) DAOFactory
//					.build(BBCstdrewardDAO.class, user);
//			BBCstdrewardVO stdVO = new BBCstdrewardVO();
//			BeanUtils.copyProperties(stdVO, vo);
//			stdDAO.remove(stdVO);
			BBCstdrewardbjDAO bjDAO = (BBCstdrewardbjDAO) DAOFactory.build(BBCstdrewardbjDAO.class,
					user);
			BBCstdrewardbjVO bjVO = new BBCstdrewardbjVO();
			BeanUtils.copyProperties(bjVO, vo);
			bjDAO.remove(bjVO);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public VstdrewardVO doUpdate(VstdrewardVO vo, User user) throws Exception {
		try {
			BBCstdrewardDAO stdDAO = (BBCstdrewardDAO) DAOFactory
					.build(BBCstdrewardDAO.class, user);
			BBCstdrewardVO stdVO = new BBCstdrewardVO();
			BeanUtils.copyProperties(stdVO, vo);
			stdDAO.update(stdVO);
			BBCstdrewardbjDAO bjDAO = (BBCstdrewardbjDAO) DAOFactory.build(BBCstdrewardbjDAO.class,
					user);
			BBCstdrewardbjVO bjVO = new BBCstdrewardbjVO();
			BeanUtils.copyProperties(bjVO, vo);
			checkQuJian(vo, user);
			bjDAO.update(bjVO);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
		return vo;
	}

	public VstdrewardVO doFindByPk(Serializable pk, User user) throws Exception {
		VstdrewardDAO dao = (VstdrewardDAO) DAOFactory.build(VstdrewardDAO.class, user);
		return (VstdrewardVO) dao.findByPk(pk);
	}
	//ֻ��ѯ�Լ��ļ�¼����ʡ��˾(999)��,�����ʱ��,�й�˾����ǰ��
	public DataPackage doQuery(VstdrewardListVO params, User user) throws Exception {
		VstdrewardDAO dao = (VstdrewardDAO) DAOFactory.build(VstdrewardDAO.class, user);
		return dao.queryRewardTables(params, user);
	}
	//ֻ��ѯ�Լ��ļ�¼����ʡ��˾(999)��,����ʡ��˾��ǰ��,ʡ��˾����ǰ��
	public DataPackage doQueryDesc(VstdrewardListVO params, User user) throws Exception {
		VstdrewardDAO dao = (VstdrewardDAO) DAOFactory.build(VstdrewardDAO.class, user);
		return dao.queryRewardTablesDesc(params, user);
	}
	//ֻ��ѯʡ��˾(999)�ļ�¼
	public DataPackage doQuery2(VstdrewardListVO params, User user) throws Exception {
		VstdrewardDAO dao = (VstdrewardDAO) DAOFactory.build(VstdrewardDAO.class, user);
		return dao.queryRewardTables2(params, user);
	}
	/**
	 * �����������䷶Χ����ǰ���ڵķ�Χ�Ƿ�����ص�.
	 * 
	 * @param vo
	 * @param user
	 * @throws Exception
	 */
	public void checkQuJian(VstdrewardVO vo, User user) throws Exception {

		// ҵ����룬����ҵ��ƽ̨��Դ�������
		VstdrewardListVO listVO = new VstdrewardListVO();
		listVO.set_se_opnid(vo.getOpnid());
		listVO.set_se_region(vo.getRegion());
		if(vo.getOssrc()!=null)
		{
		listVO.set_ne_ossrc(String.valueOf(vo.getOssrc()));
		}
		if(vo.getIntvmonth()!=null)
		{
		listVO.set_ne_intvmonth(String.valueOf(vo.getIntvmonth()));
		}
		Date minC = vo.getStartdate();
		Date maxC = vo.getStopdate();
		Long idC = vo.getRewardid();
		VstdrewardDAO dao = (VstdrewardDAO) DAOFactory.build(VstdrewardDAO.class, user);
		DataPackage dp = dao.queryRewardTables3(listVO, user);
		if (dp.getRowCount() > 0) {
			for (Iterator it = dp.getDatas().iterator(); it.hasNext();) {
				VstdrewardVO tempvo = (VstdrewardVO) it.next();
				Date min =new Date(tempvo.getStartdate().getTime());
				Date max =new Date(tempvo.getStopdate().getTime());
				Long id = tempvo.getRewardid();
				checkExists(min, max, id, minC, maxC, idC);
			}
		}
	}

	public void checkExists(Date min, Date max, Long id, Date minC, Date maxC, Long idC)
			throws Exception {
		if (id.equals(idC)) {
			return;
		}
		if (smallEqual(maxC, min)) {

		} else if (bigThan(maxC, min)) {
			if (smallEqual(maxC, max)) {
				throw new Exception("��ǰ���õĳ���׼�����еĳ���׼ʱ��η����ص�");
			} else if (bigThan(maxC, max)) {
				if (bigEqual(minC, max)) {

				} else if (smallThan(minC, max)) {
					throw new Exception("��ǰ���õĳ���׼�����еĳ���׼ʱ��η����ص�");
				}
			}
		}
	}

	public boolean bigEqual(Date big, Date small) {
		return (big.compareTo(small) == 1 || big.compareTo(small) == 0);
	}

	public boolean bigThan(Date big, Date small) {
		return (big.compareTo(small) == 1);
	}

	public boolean smallThan(Date small, Date big) {
		return (big.compareTo(small) == 1);
	}

	public boolean smallEqual(Date small, Date big) {
		return (big.compareTo(small) == 1 || big.compareTo(small) == 0);
	}

	public static void main(String[] ags) throws Exception {
		VstdrewardControlBean vs = new VstdrewardControlBean();
		String now = "2009-10-14";
		java.text.DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String before = "1982-02-02";
		String equal = "1982-02-02";
		Date beDate = df.parse(before);
		Date noDate = df.parse(now);
		Date eqDate = df.parse(equal);
		System.out.println(vs.bigEqual(beDate, eqDate));
		System.out.println(vs.bigThan(noDate, beDate));
		System.out.println(vs.smallThan(beDate, noDate));
		System.out.println(vs.smallEqual(beDate, eqDate));
		System.out.println(vs.bigThan(new Date(), noDate));

	}
	
}
