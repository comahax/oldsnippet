/**
 * auto-generated code
 * Fri Sep 12 10:00:32 CST 2008
 */
package com.sunrise.boss.business.cms.waitaudit.control;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;

import com.sunrise.boss.business.cms.waitaudit.persistent.WaitauditDAO;
import com.sunrise.boss.business.cms.waitaudit.persistent.WaitauditListVO;
import com.sunrise.boss.business.cms.waitaudit.persistent.WaitauditVO;
import com.sunrise.boss.business.resmanage.task.persistent.TaskDAO;
import com.sunrise.boss.business.resmanage.task.persistent.TaskVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.ftp.FtpAccess;
import com.sunrise.boss.ui.commons.ftp.FtpInfo;
import com.sunrise.boss.ui.resmanage.common.ResPubUtil;

/**
 * <p>
 * Title: WaitauditControlBean
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: Maywide Tech Ltd.
 * </p>
 * 
 * @author
 * @version 1.0
 */
/**
 * @ejb.bean local-jndi-name="com/sunrise/boss/business/cms/waitaudit/control/WaitauditControlBean"
 *           name="WaitauditControl" view-type="local" type="Stateless"
 * 
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class WaitauditControlBean extends AbstractControlBean implements
		WaitauditControl {

	public WaitauditVO doCreate(WaitauditVO vo, User user) throws Exception {
		try {
			// TODO set the pk */
			WaitauditDAO dao = (WaitauditDAO) DAOFactory.build(
					WaitauditDAO.class, user);
			return (WaitauditVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemove(WaitauditVO vo, User user) throws Exception {
		try {
			WaitauditDAO dao = (WaitauditDAO) DAOFactory.build(
					WaitauditDAO.class, user);
			dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public WaitauditVO doUpdate(WaitauditVO vo, User user) throws Exception {
		try {
			WaitauditDAO dao = (WaitauditDAO) DAOFactory.build(
					WaitauditDAO.class, user);
			return (WaitauditVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public WaitauditVO doFindByPk(Serializable pk, User user) throws Exception {
		WaitauditDAO dao = (WaitauditDAO) DAOFactory.build(WaitauditDAO.class,
				user);
		return (WaitauditVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(WaitauditListVO params, User user)
			throws Exception {
		WaitauditDAO dao = (WaitauditDAO) DAOFactory.build(WaitauditDAO.class,
				user);
		DataPackage dp = dao.query(params);
		Collection col = dp.getDatas();
		TaskDAO taDAO = (TaskDAO) DAOFactory.build(TaskDAO.class, user);
		for (Iterator it = col.iterator(); it.hasNext();) {
			WaitauditVO vo = (WaitauditVO) it.next();
			if (vo.getSubsystem().shortValue() == (short) 0
					&& vo.getFilecode() != null) {
				TaskVO taskVO = (TaskVO) taDAO.findByPk(new Long(vo
						.getFilecode().trim()));
				if (taskVO != null) {
					if (taskVO.getResultfile() != null
							|| taskVO.getCurrentcount() != null
							|| taskVO.getTotalcount() != null
							|| taskVO.getSuccesscount() != null
							|| taskVO.getLogfile() != null) {
						vo.setTotalcount(taskVO.getTotalcount());
						vo.setCurrentcount(taskVO.getCurrentcount());
						vo.setSuccesscount(taskVO.getSuccesscount());
						// 日志／结果文件taskid+_log.txt
						vo.setResultfile(taskVO.getLogfile());
						// 错误文件taskid+_err.txt
						vo.setErrorfile(taskVO.getResultfile());
					}
					if (taskVO.getLogfile() == null) {
						String filepath = fileExists("log" + "_"
								+ taskVO.getTaskid() + ".txt", vo.getTaskid(),
								"log", user);
						if (filepath != null) {
							vo.setResultfile(filepath);
						}
					}
					if (taskVO.getResultfile() == null) {
						String filepath = fileExists("err" + "_"
								+ taskVO.getTaskid() + ".txt", vo.getTaskid(),
								"err", user);
						if (filepath != null) {
							vo.setErrorfile(filepath);
						}
					}
				}
			}
		}
		return dp;
	}

	public static void main(String[] args) throws Exception {
		User user = new User();
		user.setCityid("750");
		WaitauditControlBean s = new WaitauditControlBean();
		// s.fileExists("err_2372.txt",user);
	}

	protected String fileExists(String filename, Long taskid,
			String logOrError, User user) throws Exception {
		FtpInfo fi = ResPubUtil.getFtpInfo(user);
//		String dir = ResPubUtil.getSysparamVO(
//				ResConstant.SysParam_BatchFileDir, user).getParamvalue();
//		if (dir == null || "".equals(dir)) {
//			throw new Exception("资源系统参数没有设置，无法取得批量文件存放目录");
//		}
		FtpAccess fa = new FtpAccess(fi);
		WaitauditDAO dao = (WaitauditDAO) DAOFactory.build(WaitauditDAO.class,
				user);
		// 去审核表查上传目录，拼出日志／结果文件|错误文件路径
		WaitauditVO vo = (WaitauditVO) (dao.findByPk(taskid));
		if (vo != null) {
			String logfile = vo.getLogfile();
			if (logfile == null) {
				return null;
			}
			String destFile = logfile.substring(0, logfile.lastIndexOf("/"));
			// 修改目录使用模式，赋权
			boolean s = fa.ftp.changeWorkingDirectory(destFile);
			if (!s)
				return null;
			fa.ftp.sendCommand("site chmod 777 " + destFile);//
			String file[]=fa.ftp.listNames(filename);
			//System.out.println(file.length);
			if(file==null || file.length==0)
			{
				return null;
			}
			else if( filename.equals(file[0]))
			{
				return destFile+"/"+file[0];
			}
		}
		return null;
	}
}