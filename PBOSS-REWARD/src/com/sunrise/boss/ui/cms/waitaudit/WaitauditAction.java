/**
 * auto-generated code
 * Fri Sep 12 10:00:33 CST 2008
 */
package com.sunrise.boss.ui.cms.waitaudit;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.LabelValueBean;

import com.sunrise.boss.business.cms.rewardadjust.persistent.RewardadjustListVO;
import com.sunrise.boss.business.cms.rewardadjust.persistent.RewardadjustVO;
import com.sunrise.boss.business.cms.waitaudit.persistent.WaitauditVO;
import com.sunrise.boss.business.common.batchlog.persistent.BatchlogVO;
import com.sunrise.boss.business.resmanage.common.pubdef.ResConstant;
import com.sunrise.boss.business.resmanage.task.persistent.TaskVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.delegate.admin.purview.PurviewDelegate;
import com.sunrise.boss.delegate.cms.provincialright.ProvincialrightDelegate;
import com.sunrise.boss.delegate.cms.rewardadjust.RewardadjustDelegate;
import com.sunrise.boss.delegate.cms.waitaudit.WaitauditDelegate;
import com.sunrise.boss.delegate.common.batchlog.BatchlogDelegate;
import com.sunrise.boss.delegate.resmanage.task.TaskDelegate;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.cms.bbc.bbcadjust.BbcadjustTaskBean;
import com.sunrise.boss.ui.cms.bbc.bbcadjust.BbcadjustunpbTaskBean;
import com.sunrise.boss.ui.cms.costcard.BatchTaskBean;
import com.sunrise.boss.ui.cms.reward.disintegral.DisintegralTaskBean;
import com.sunrise.boss.ui.cms.rewardadjust.RewardadjustTaskBean;
import com.sunrise.boss.ui.cms.waystarmonth.WaystarmonthTaskBean;
import com.sunrise.boss.ui.cms.waystarmonth.WaystarmonthstarTaskBean;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;
import com.sunrise.boss.ui.commons.ftp.FtpAccess;
import com.sunrise.boss.ui.commons.ftp.FtpBusUtils;
import com.sunrise.boss.ui.commons.ftp.FtpInfo;
import com.sunrise.boss.ui.resmanage.common.ResPubUtil;

/**
 * <p>
 * Title: WaitauditAction
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
public class WaitauditAction extends BaseDelegateAction {

	protected int countrecord;

	protected String filename;

	protected User user;

	protected String resultFile;

	protected int currentrecord;

	protected int fail;

	protected int ok;

	private int count;

	protected boolean isComplete = false;

	protected HashMap parameterMap;// ��ű�����

	protected ActionForm form; // �����Ӧ��form

	protected boolean isWriteLog = false;// �Ƿ�д��־��Ϣ

	protected String batchName = this.getClass().getName();// д��־ʱ��¼������������(�˵���������),Ĭ�ϴ��������

	protected String optype;// д��־ʱ��¼������������,��ʱ����

	protected FtpAccess ftp;
	
	
	private boolean checkPurview;

	public static final Log log = LogFactory.getLog(WaitauditAction.class);

	public WaitauditAction() {
		// ���¼��������Ǳ����
		// ָ��VO��
		setVoClass(WaitauditVO.class);
		// ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
		this.pkNameArray = new String[1];
		pkNameArray[0] = "taskid";
		this.count = 0;
		this.ok = 0;
		this.fail = 0;
	}

	/**
	 * ��ѯ
	 */
	protected ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		WaitauditForm form = (WaitauditForm) actionForm;
		String auditopr = request.getParameter("ISAUDIT");
		if (auditopr != null) {
			form.set_ne_subsystem("2");
		}
		if ("WAYSTARMONTH".equals(auditopr)){
			form.set_ne_subsystem("4");
		}
		if ("WAYSTARMONTHSTAR".equals(auditopr)){
			form.set_ne_subsystem("5");
		}
		if ("DISINTEGRAL".equals(auditopr)){
			form.set_ne_subsystem("6");
		}
		if("UNPB".equals(auditopr)){
			form.set_ne_subsystem("7");
		}
		
		form.set_desc("1");
		form.set_orderby("createtime");
		
	    List auditOption = new ArrayList();
	    auditOption.add(new LabelValueBean("",""));
	    
	    PurviewDelegate purviewDelegate = new PurviewDelegate();
	    ProvincialrightDelegate provincialDelegate = new ProvincialrightDelegate();

	    if(purviewDelegate.checkPurview(user.getOpercode(), "CH_PW_WAITAUDIT_AUDIT") || provincialDelegate.checkPurview(user, "CH_PW_WAITAUDIT_AUDIT")){
	    	auditOption.add(new LabelValueBean("�׿�������������","0"));
	    	auditOption.add(new LabelValueBean("��ֵ��������������","1"));
	    }
	    if(purviewDelegate.checkPurview(user.getOpercode(), "CH_PW_REWARD_ADJUST") || provincialDelegate.checkPurview(user, "CH_PW_REWARD_ADJUST")||
	    		purviewDelegate.checkPurview(user.getOpercode(), "CH_PW_REWARD") || provincialDelegate.checkPurview(user, "CH_PW_REWARD")){
	    	auditOption.add(new LabelValueBean("���������������������","2"));
	    }
	    if(purviewDelegate.checkPurview(user.getOpercode(), "CH_B2M_REWARD_ADJAUDIT") || provincialDelegate.checkPurview(user, "CH_B2M_REWARD_ADJAUDIT")||
	    		purviewDelegate.checkPurview(user.getOpercode(), "CH_B2M_REWARD") || provincialDelegate.checkPurview(user, "CH_B2M_REWARD")){
	    	auditOption.add(new LabelValueBean("��վ��������������","3"));
	    }
	    
	    if(purviewDelegate.checkPurview(user.getOpercode(), "CH_PW_WAITAUDIT_AUDIT") || provincialDelegate.checkPurview(user, "CH_PW_WAITAUDIT_AUDIT")||
	    		purviewDelegate.checkPurview(user.getOpercode(), "CH_PW_REWARD") || provincialDelegate.checkPurview(user, "CH_PW_REWARD")){
	    	auditOption.add(new LabelValueBean("��������Ǽ��·�(����)��������","4"));
	    }
	    if(purviewDelegate.checkPurview(user.getOpercode(), "CH_PW_WAITAUDIT_AUDIT") || provincialDelegate.checkPurview(user, "CH_PW_WAITAUDIT_AUDIT")||
	    		purviewDelegate.checkPurview(user.getOpercode(), "CH_PW_REWARD") || provincialDelegate.checkPurview(user, "CH_PW_REWARD")){
	    	auditOption.add(new LabelValueBean("�Ǽ��������������޸����","5"));
	    }
	    if(purviewDelegate.checkPurview(user.getOpercode(), "CH_PW_WAITAUDIT_AUDIT") || provincialDelegate.checkPurview(user, "CH_PW_WAITAUDIT_AUDIT")||
	    		purviewDelegate.checkPurview(user.getOpercode(), "CH_PW_REWARD") || provincialDelegate.checkPurview(user, "CH_PW_REWARD")){
	    	auditOption.add(new LabelValueBean("������ʵ��ҵ�������������","6"));
	    }
	    if(purviewDelegate.checkPurview(user.getOpercode(), "CH_B2M_REWARD_ADJAUDIT") || provincialDelegate.checkPurview(user, "CH_B2M_REWARD_ADJAUDIT")||
		    	purviewDelegate.checkPurview(user.getOpercode(), "CH_B2M_REWARD") || provincialDelegate.checkPurview(user, "CH_B2M_REWARD")){
		    auditOption.add(new LabelValueBean("ȫԱ�����������������","7"));
		}
	    if(purviewDelegate.checkPurview(user.getOpercode(), "CH_B2M_REWARD_ADJAUDIT") || provincialDelegate.checkPurview(user, "CH_B2M_REWARD_ADJAUDIT")||
	    		purviewDelegate.checkPurview(user.getOpercode(), "CH_B2M_REWARD") || provincialDelegate.checkPurview(user, "CH_B2M_REWARD")){
		    auditOption.add(new LabelValueBean("ȫԱ�������רԱ��������������","8"));
		}

	   
	    request.setAttribute("AUDITOPTION", auditOption);
		return super.doList(actionMapping, actionForm, request, response, user);
	}

	/**
	 * 
	 */
	public synchronized  ActionForward doAudit(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		// ������˹��ţ�������������ʱ��Ϊ��ǰ����˵Ĺ��ţ�����������ʱ�䣻
		// �������״̬�����ͨ����д1��δͨ����д-1��
		// ���¡���ע����Ϣ��
		String msg = "";
		WaitauditForm form= (WaitauditForm)actionForm ;
		WaitauditVO vo = new WaitauditVO();
		try {
			BeanUtils.copyProperties(vo, form);
//			������������Ƶ�����ȥ�ˡ�
//			vo.setAuditoprcode(user.getOpercode());
//			vo.setAuditwayid(user.getWayid());
//			vo.setAudittime(new Date());
	
			if (vo.getTaskstate().shortValue() == -1) {
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
						"������������δ���ͨ��");
				new WaitauditDelegate().doUpdate(vo, user);
				if (vo.getSubsystem().shortValue() == 0) {
					//������׿�����д�����
					TaskDelegate taDel = new TaskDelegate();
					if (vo.getFilecode() != null) {
						TaskVO taVO = (TaskVO) taDel.doFindByPk(new Long(vo
								.getFilecode()), user);
						taVO.setTaskstate(new Integer("4"));
						taVO.setMemo(vo.getMemo());
						taDel.doUpdate(taVO, user);
					} else {
						throw new BusinessException("FILECODE :δ�ҵ�");
					}
				}
				return actionMapping.findForward("content");
			}
			if (vo.getSubsystem().shortValue() == (short) 0) {
				msg = dealResale(vo, user);
			}else 
			{
				//�����״̬������״̬9�����ͨ��������)
				vo.setTaskstate(new Byte("9"));
				new WaitauditDelegate().doUpdate(vo, user);
			}
			
			if (vo.getSubsystem().shortValue() == (short) 1) {
				msg = dealCostcard(vo, user);
				vo.setTotalcount(new Integer(count));
				vo.setSuccesscount(new Integer(ok));
				vo.setCurrentcount(new Integer(count));
				vo.setResultfile(msg);
				msg = "�������������Ѿ����ͨ��,�Ժ����ڽ���ļ����鿴������";
			}
			if (vo.getSubsystem().shortValue() == (short) 2) {
				msg = dealRewardadjust(vo, user);
				vo.setTotalcount(new Integer(count));
				vo.setSuccesscount(new Integer(ok));
				vo.setCurrentcount(new Integer(count));
				vo.setResultfile(msg);
				msg = "�������������Ѿ����ͨ��,�Ժ����ڽ���ļ����鿴������";
			}
			if (vo.getSubsystem().shortValue() == (short) 3) {
				msg = dealBbcadjust(vo, user);
				vo.setTotalcount(new Integer(count));
				vo.setSuccesscount(new Integer(ok));
				vo.setCurrentcount(new Integer(count));
				vo.setResultfile(msg);
				msg = "�������������Ѿ����ͨ��,�Ժ����ڽ���ļ����鿴������";
			}
			if (vo.getSubsystem().shortValue() == (short) 4) {
				msg = dealWaystarmonth(vo, user);
				vo.setTotalcount(new Integer(count));
				vo.setSuccesscount(new Integer(ok));
				vo.setCurrentcount(new Integer(count));
				vo.setResultfile(msg);
				msg = "�������������Ѿ����ͨ��,�Ժ����ڽ���ļ����鿴������";
			}
			if (vo.getSubsystem().shortValue() == (short) 5) {
				msg = dealWaystarmonthstar(vo, user);
				vo.setTotalcount(new Integer(count));
				vo.setSuccesscount(new Integer(ok));
				vo.setCurrentcount(new Integer(count));
				vo.setResultfile(msg);
				msg = "�������������Ѿ����ͨ��,�Ժ����ڽ���ļ����鿴������";
			}
			if (vo.getSubsystem().shortValue() == (short) 6) {
				msg = dealDisintegral(vo, user);
				vo.setTotalcount(new Integer(count));
				vo.setSuccesscount(new Integer(ok));
				vo.setCurrentcount(new Integer(count));
				vo.setResultfile(msg);
				msg = "�������������Ѿ����ͨ��,�Ժ����ڽ���ļ����鿴������";
			}
			if (vo.getSubsystem().shortValue() == (short) 7) {
				msg = dealUnpbreward(vo, user);
				vo.setTotalcount(new Integer(count));
				vo.setSuccesscount(new Integer(ok));
				vo.setCurrentcount(new Integer(count));
				vo.setResultfile(msg);
				msg = "�������������Ѿ����ͨ��,�Ժ����ڽ���ļ����鿴������";
			}
			if (vo.getSubsystem().shortValue() == (short) 8) {
				msg = dealUnpbpersonalreward(vo, user);
				vo.setTotalcount(new Integer(count));
				vo.setSuccesscount(new Integer(ok));
				vo.setCurrentcount(new Integer(count));
				vo.setResultfile(msg);
				msg = "�������������Ѿ����ͨ��,�Ժ����ڽ���ļ����鿴������";
			}
			vo.setAuditoprcode(user.getOpercode());
			vo.setAuditwayid(user.getWayid());
			vo.setAudittime(new Date());
			vo.setTaskstate(new Byte("1"));
			new WaitauditDelegate().doUpdate(vo, user);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, msg);
		} catch (Exception ex) {
			//��������µ���ǰ��״̬��
			vo.setTaskstate(new Byte("0"));
			new WaitauditDelegate().doUpdate(vo, user);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex
					.getMessage());
			log.debug("Exception in doAudit", ex);
			
		}
		return actionMapping.findForward("content");
	}

	// ��������Դ=0���׿�������������
	protected String dealResale(WaitauditVO vo, User user) throws Exception {
		TaskDelegate delegate = new TaskDelegate();
		if (vo.getFilecode() == null) {
			throw new BusinessException("δ��ȡ������ID��Ϣ��");
		}
		TaskVO taskVO = (TaskVO) delegate.doFindByPk(
				new Long(vo.getFilecode()), user);
		if (taskVO == null) {
			throw new BusinessException("������¼�Ѿ�������:TaskVO,taskid=" + vo.getFilecode());
		}
		if (vo.getTaskstate().byteValue() == (byte) 1) {
			taskVO.setTaskstate(new Integer("0"));
		}
		delegate.doUpdate(taskVO, user);
		return "�ѵǼ�������������������" + vo.getFilecode()
				+ "���Ժ����ڡ���Դ����-->����Դ������־��ѯ��-->�������ļ������鿴������";
	}

	// ��������Դ=1����ֵ���������룩
	protected String dealCostcard(WaitauditVO vo, User user) throws Exception {
		//getFile
		String filePath = vo.getLogfile();
		FtpInfo ftpInfo = ResPubUtil.getFtpInfo(user);
		ftp = new FtpAccess(ftpInfo);
		String localPath = FtpBusUtils.getDownloadRealPath(servlet);
		localPath = ftp.downloadFile(localPath, filePath);
		if (localPath == null) {
			throw new BusinessException("��ftp����ʧ��");
		}
		int off = localPath.lastIndexOf(".");
		if (off == -1) {
			throw new BusinessException("����·������ȷ:" + localPath);
		}
		String fileOutPath = localPath.substring(0, off) + "_result.txt";
		log.debug("localPath" + localPath);
		//�����ļ�
		doProcessFile(vo, localPath, fileOutPath, user);
		//�ѽ���ļ��ϴ���FTP������
		String filepath = ftpFile(fileOutPath, user);

		return filepath;
	}

	// ��������Դ=2���������������룩
	protected String dealRewardadjust(WaitauditVO vo, User user)
			throws Exception {
		String filePath = vo.getLogfile();
		FtpInfo ftpInfo = ResPubUtil.getFtpInfo(user);
		ftp = new FtpAccess(ftpInfo);
		String localPath = FtpBusUtils.getDownloadRealPath(servlet);
		localPath = ftp.downloadFile(localPath, filePath);
		if (localPath == null) {
			throw new BusinessException("��ftp����ʧ��");
		}
		int off = localPath.lastIndexOf(".");
		if (off == -1) {
			throw new BusinessException("����·������ȷ:" + localPath);
		}
		String fileOutPath = localPath.substring(0, off) + "_result.txt";
		log.debug("localPath" + localPath);
		//�����ļ�
		doProcessFile(vo, localPath, fileOutPath, user);

		//		�ѽ���ļ��ϴ���FTP������
		String filepath = ftpFile(fileOutPath, user);
		return filepath;
	}
	
	// ��������Դ=3��BBC�������������룩
	protected String dealBbcadjust(WaitauditVO vo, User user)
			throws Exception {
		String filePath = vo.getLogfile();
		FtpInfo ftpInfo = ResPubUtil.getFtpInfo(user);
		ftp = new FtpAccess(ftpInfo);
		String localPath = FtpBusUtils.getDownloadRealPath(servlet);
		localPath = ftp.downloadFile(localPath, filePath);
		if (localPath == null) {
			throw new BusinessException("��ftp����ʧ��");
		}
		int off = localPath.lastIndexOf(".");
		if (off == -1) {
			throw new BusinessException("����·������ȷ:" + localPath);
		}
		String fileOutPath = localPath.substring(0, off) + "_result.txt";
		log.debug("localPath" + localPath);
		//�����ļ�
		doProcessFile(vo, localPath, fileOutPath, user);

		//		�ѽ���ļ��ϴ���FTP������
		String filepath = ftpFile(fileOutPath, user);
		return filepath;
	}
	
	// ��������Դ=4����������Ǽ��·ݣ��������������룩
	private String dealWaystarmonth(WaitauditVO vo, User user) throws Exception {
		String filePath = vo.getLogfile();
		FtpInfo ftpInfo = ResPubUtil.getFtpInfo(user);
		ftp = new FtpAccess(ftpInfo);
		String localPath = FtpBusUtils.getDownloadRealPath(servlet);
		localPath = ftp.downloadFile(localPath, filePath);
		if (localPath == null) {
			throw new BusinessException("��ftp����ʧ��");
		}
		int off = localPath.lastIndexOf(".");
		if (off == -1) {
			throw new BusinessException("����·������ȷ:" + localPath);
		}
		String fileOutPath = localPath.substring(0, off) + "_result.txt";
		log.debug("localPath" + localPath);
		//�����ļ�
		doProcessFile(vo, localPath, fileOutPath, user);

		//		�ѽ���ļ��ϴ���FTP������
		String filepath = ftpFile(fileOutPath, user);
		return filepath;
	}
	
//	 ��������Դ=5���Ǽ��������������޸���ˣ�
	private String dealWaystarmonthstar(WaitauditVO vo, User user) throws Exception {
		String filePath = vo.getLogfile();
		FtpInfo ftpInfo = ResPubUtil.getFtpInfo(user);
		ftp = new FtpAccess(ftpInfo);
		String localPath = FtpBusUtils.getDownloadRealPath(servlet);
		localPath = ftp.downloadFile(localPath, filePath);
		if (localPath == null) {
			throw new BusinessException("��ftp����ʧ��");
		}
		int off = localPath.lastIndexOf(".");
		if (off == -1) {
			throw new BusinessException("����·������ȷ:" + localPath);
		}
		String fileOutPath = localPath.substring(0, off) + "_result.txt";
		log.debug("localPath" + localPath);
		//�����ļ�
		doProcessFile(vo, localPath, fileOutPath, user);

		//		�ѽ���ļ��ϴ���FTP������
		String filepath = ftpFile(fileOutPath, user);
		return filepath;
	}
//	 ��������Դ=6�������̻���������ˣ�
	private String dealDisintegral (WaitauditVO vo, User user) throws Exception {
		String filePath = vo.getLogfile();
		FtpInfo ftpInfo = ResPubUtil.getFtpInfo(user);
		ftp = new FtpAccess(ftpInfo);
		String localPath = FtpBusUtils.getDownloadRealPath(servlet);
		localPath = ftp.downloadFile(localPath, filePath);
		if (localPath == null) {
			throw new BusinessException("��ftp����ʧ��");
		}
		int off = localPath.lastIndexOf(".");
		if (off == -1) {
			throw new BusinessException("����·������ȷ:" + localPath);
		}
		String fileOutPath = localPath.substring(0, off) + "_result.txt";
		log.debug("localPath" + localPath);
		//�����ļ�
		doProcessFile(vo, localPath, fileOutPath, user);

		//		�ѽ���ļ��ϴ���FTP������
		String filepath = ftpFile(fileOutPath, user);
		return filepath;
	}
	
	private String dealUnpbreward (WaitauditVO vo, User user) throws Exception {
		String filePath = vo.getLogfile();
		FtpInfo ftpInfo = ResPubUtil.getFtpInfo(user);
		ftp = new FtpAccess(ftpInfo);
		String localPath = FtpBusUtils.getDownloadRealPath(servlet);
		localPath = ftp.downloadFile(localPath, filePath);
		if (localPath == null) {
			throw new BusinessException("��ftp����ʧ��");
		}
		int off = localPath.lastIndexOf(".");
		if (off == -1) {
			throw new BusinessException("����·������ȷ:" + localPath);
		}
		String fileOutPath = localPath.substring(0, off) + "_result.txt";
		log.debug("localPath" + localPath);
		//�����ļ�
		doProcessFile(vo, localPath, fileOutPath, user);

		//		�ѽ���ļ��ϴ���FTP������
		String filepath = ftpFile(fileOutPath, user);
		return filepath;
	}
	
	private String dealUnpbpersonalreward (WaitauditVO vo, User user) throws Exception {
		String filePath = vo.getLogfile();
		FtpInfo ftpInfo = ResPubUtil.getFtpInfo(user);
		ftp = new FtpAccess(ftpInfo);
		String localPath = FtpBusUtils.getDownloadRealPath(servlet);
		localPath = ftp.downloadFile(localPath, filePath);
		if (localPath == null) {
			throw new BusinessException("��ftp����ʧ��");
		}
		int off = localPath.lastIndexOf(".");
		if (off == -1) {
			throw new BusinessException("����·������ȷ:" + localPath);
		}
		String fileOutPath = localPath.substring(0, off) + "_result.txt";
		log.debug("localPath" + localPath);
		//�����ļ�
		doProcessFile(vo, localPath, fileOutPath, user);

		//		�ѽ���ļ��ϴ���FTP������
		String filepath = ftpFile(fileOutPath, user);
		return filepath;
	}


	/**
	 * �����ļ�
	 */
	public void doProcessFile(WaitauditVO vo, String fileInPath,
			String fileOutPath, User user) throws Exception {
		File resultFile = new File(fileOutPath);
		this.resultFile = fileOutPath;
		FileInputStream fileInputStream = new FileInputStream(fileInPath);
		InputStreamReader read = new InputStreamReader(fileInputStream, "gbk");
		BufferedReader rin = new BufferedReader(read);
		FileOutputStream fileOutputStream = new FileOutputStream(resultFile);
		OutputStreamWriter writer = new OutputStreamWriter(fileOutputStream,
				"gbk");
		BufferedWriter fos = new BufferedWriter(writer);
		try {
			String line;
			ResultVO resultVO = new ResultVO();
			int count = 0;
			ok = 0;
			fail = 0;
			currentrecord = 0;

			if (vo.getSubsystem().shortValue() == (short) 1) {
				// �ļ�����ʼ,д�����
				fos.write(new BatchTaskBean().doStart());

				while ((line = rin.readLine()) != null) {
					if (null != line && line.trim().length() > 0) {
						++count;
						try {
							resultVO = new BatchTaskBean().processLine(
									line.trim(), count, user); // �ؼ���������һ����¼
							// д������
							fos.write(resultVO.getInfo() + "\r\n");
						} catch (Exception e) {
							fos.write(count + "|" + line + "|ʧ��|"
									+ e.getMessage() + "\r\n");
						}
						if (resultVO.isOk()) {
							++ok;
							// ����ֶ�
						} else {
							++fail;
						}
						currentrecord++;
					}
					this.count = count;
				}
				// �ļ��������
				fos.write(new BatchTaskBean().doEnd());
			} else if(vo.getSubsystem().shortValue() == (short) 2) {
				RewardadjustTaskBean taskBean = new RewardadjustTaskBean();
				fos.write(taskBean.doStart());

				while ((line = rin.readLine()) != null) {
					if (null != line && line.trim().length() > 0) {
						++count;
						try {
							resultVO = taskBean.processLine(line.trim(), count, user, vo); // �ؼ���������һ����¼
							// д������
							fos.write(resultVO.getInfo() + "\r\n");
						  // �������ݵ��ļ����쳣
						} catch (Exception e) {
							fos.write(count + "|" + line + "|ʧ��|"
									+ e.getMessage() + "\r\n");
						}
						if (resultVO.isOk()) {
							++ok;
							// ����ֶ�
						} else {
							++fail;
						}
						currentrecord++;
					}
					this.count = count;
				}
				// �ļ��������
				fos.write(taskBean.doEnd());
			} else if(vo.getSubsystem().shortValue() == (short) 3) {
				BbcadjustTaskBean taskBean = new BbcadjustTaskBean();
				fos.write(taskBean.doStart());
				while ((line = rin.readLine()) != null) {
					if (null != line && line.trim().length() > 0) {
						++count;
						try {
							resultVO = taskBean.processLine(line.trim(), count, user, vo); // �ؼ���������һ����¼
							// д������
							fos.write(resultVO.getInfo() + "\r\n");
						  // �������ݵ��ļ����쳣
						} catch (Exception e) {
							fos.write(count + "|" + line + "|ʧ��|"
									+ e.getMessage() + "\r\n");
						}
						if (resultVO.isOk()) {
							++ok;
							// ����ֶ�
						} else {
							++fail;
						}
						currentrecord++;
					}
					this.count = count;
				}
				// �ļ��������
				fos.write(taskBean.doEnd());
			} else if(vo.getSubsystem().shortValue() == (short) 4) {
				WaystarmonthTaskBean taskBean = new WaystarmonthTaskBean();
				fos.write(taskBean.doStart());
				while ((line = rin.readLine()) != null) {
					if (null != line && line.trim().length() > 0) {
						++count;
						try {
							resultVO = taskBean.processLine(line.trim(), count, user, vo); // �ؼ���������һ����¼
							// д������
							fos.write(resultVO.getInfo() + "\r\n");
						  // �������ݵ��ļ����쳣
						} catch (Exception e) {
							fos.write(count + "|" + line + "|ʧ��|"
									+ e.getMessage() + "\r\n");
						}
						if (resultVO.isOk()) {
							++ok;
							// ����ֶ�
						} else {
							++fail;
						}
						currentrecord++;
					}
					this.count = count;
				}
				// �ļ��������
				fos.write(taskBean.doEnd());
			}else if(vo.getSubsystem().shortValue() == (short) 5) {
				WaystarmonthstarTaskBean taskBean = new WaystarmonthstarTaskBean();
				fos.write(taskBean.doStart());
				while ((line = rin.readLine()) != null) {
					if (null != line && line.trim().length() > 0) {
						++count;
						try {
							resultVO = taskBean.processLine(line.trim(), count, user, vo); // �ؼ���������һ����¼
							// д������
							fos.write(resultVO.getInfo() + "\r\n");
						  // �������ݵ��ļ����쳣
						} catch (Exception e) {
							fos.write(count + "|" + line + "|ʧ��|"
									+ e.getMessage() + "\r\n");
						}
						if (resultVO.isOk()) {
							++ok;
							// ����ֶ�
						} else {
							++fail;
						}
						currentrecord++;
					}
					this.count = count;
				}
				// �ļ��������
				fos.write(taskBean.doEnd());
			}else if(vo.getSubsystem().shortValue() == (short) 6) {
				DisintegralTaskBean taskBean = new DisintegralTaskBean();
				fos.write(taskBean.doStart());
				while ((line = rin.readLine()) != null) {
					if (null != line && line.trim().length() > 0) {
						++count;
						try {
							resultVO = taskBean.processLine(line.trim(), count, user, vo); // �ؼ���������һ����¼
							// д������
							fos.write(resultVO.getInfo() + "\r\n");
						  // �������ݵ��ļ����쳣
						} catch (Exception e) {
							fos.write(count + "|" + line + "|ʧ��|"
									+ e.getMessage() + "\r\n");
						}
						if (resultVO.isOk()) {
							++ok;
							// ����ֶ�
						} else {
							++fail;
						}
						currentrecord++;
					}
					this.count = count;
				}
				// �ļ��������
				fos.write(taskBean.doEnd());
			}else if(vo.getSubsystem().shortValue() == (short) 7 || vo.getSubsystem().shortValue() == (short) 8) {
				BbcadjustunpbTaskBean taskBean = new BbcadjustunpbTaskBean();
				fos.write(taskBean.doStart());
				while ((line = rin.readLine()) != null) {
					if (null != line && line.trim().length() > 0) {
						++count;
						try {
							resultVO = taskBean.processLine(line.trim(), count, user, vo); // �ؼ���������һ����¼
							// д������
							fos.write(resultVO.getInfo() + "\r\n");
						  // �������ݵ��ļ����쳣
						} catch (Exception e) {
							fos.write(count + "|" + line + "|ʧ��|"
									+ e.getMessage() + "\r\n");
						}
						if (resultVO.isOk()) {
							++ok;
							// ����ֶ�
						} else {
							++fail;
						}
						currentrecord++;
					}
					this.count = count;
				}
				// �ļ��������
				fos.write(taskBean.doEnd());
			}
		  //�ļ�����ʧ���쳣
		} catch (Exception ex) {
			fos.write(ex.getMessage());
			if (log.isErrorEnabled()) {
				log.error(ex.getMessage());
			}
			fail = countrecord;
		} finally {
			rin.close();
			read.close();
			fos.close();
			writer.close();
			this.resultFile = fileOutPath;
			currentrecord = countrecord;
			isComplete = true;
			if (isWriteLog) {
				if (ok == currentrecord) {
					writeLog(batchName, optype, "0");//�ɹ�
				} else if (fail == currentrecord) {
					writeLog(batchName, optype, "1");//ʧ��
				} else {
					writeLog(batchName, optype, "2");//���ֳɹ�
				}
			} else {
				//deleteFile_(fileInPath);
			}
		}
	}

	protected void writeLog(String batchName, String oprtype, String success)
			throws Exception {
		//д��ʷ��¼��Ϣ
		log.debug("׼��д��־.");
		if (isWriteLog) {
			log.debug("д����־");
			BatchlogDelegate batchlogDelegate = new BatchlogDelegate();
			BatchlogVO batchlogVO = new BatchlogVO();
			batchlogVO.setOprcode(user.getOpercode());
			batchlogVO.setOprwayid(user.getWayid());
			batchlogVO.setOptime(new Date());
			batchlogVO.setOprtype(oprtype);
			batchlogVO.setBatchname(batchName);
			try {//�Է�ftp�������Ӱ���¼��־
				ftp = new FtpAccess(FtpInfo.getInstance());
				batchlogVO.setUploadpath(uploadFile(filename, user
						.getOpercode()));
				batchlogVO.setResultpath(uploadFile(resultFile, user
						.getOpercode()));
			} catch (Exception e) {
				log.error(e.getMessage());
			}
			//            batchlogVO.setUploadpath(filename);
			//            batchlogVO.setResultpath(resultFile);
			batchlogVO.setSuccess(success);
			batchlogDelegate.doCreate(batchlogVO, user);
		}
	}

	public String uploadFile(String filename, String oprcode) throws Exception {
		String result = ftp.uploadFile(filename, oprcode, false);
		if (result == null) {
			log.error(("�ϴ��ļ�ʧ�ܣ�" + filename));
		}
		return result;
	}

	/**
	 * �ϴ��ļ���ϵͳ����ָ����������Ŀ¼�������ļ���
	 * 
	 * @param filename
	 * @param user
	 * @return
	 * @throws Exception
	 */
	protected String ftpFile(String filename, User user) throws Exception {
		FtpInfo fi = ResPubUtil.getFtpInfo(user);
		String dir = ResPubUtil.getSysparamVO(
				ResConstant.SysParam_BatchFileDir, user).getParamvalue();
		if (dir == null || "".equals(dir)) {
			throw new Exception("��Դϵͳ����û�����ã��޷�ȡ�������ļ����Ŀ¼");
		}
		FtpAccess fa = new FtpAccess(fi);

		DateFormat format = new SimpleDateFormat("yyyyMM");
		String dateDir = format.format(new Date(System.currentTimeMillis()));
		String cityid = SessionFactoryRouter.conversionCityid(user.getCityid());
		StringBuffer dirBuffer = new StringBuffer(dir);

		// ��������Ŀ¼
		dirBuffer.append("/").append(dateDir);
		if (fa.ftp.changeWorkingDirectory(dirBuffer.toString()) == false)
			if (fa.ftp.makeDirectory(dirBuffer.toString()) == false)
				throw new BusinessException("����Ŀ¼��" + dirBuffer.toString() + "����");
			
		// �����й�˾��ʶĿ¼
		dirBuffer.append("/").append(cityid);
		if (fa.ftp.changeWorkingDirectory(dirBuffer.toString()) == false)
			if (fa.ftp.makeDirectory(dirBuffer.toString()) == false)
				throw new BusinessException("����Ŀ¼��" + dirBuffer.toString() + "����");

		// ��������Ŀ¼
		dirBuffer.append("/").append(user.getWayid());
		if (fa.ftp.changeWorkingDirectory(dirBuffer.toString()) == false)
			if (fa.ftp.makeDirectory(dirBuffer.toString()) == false)
				throw new BusinessException("����Ŀ¼��" + dirBuffer.toString() + "����");

		// ���빤��Ŀ¼
		dirBuffer.append("/").append(user.getOpercode());
		if (fa.ftp.changeWorkingDirectory(dirBuffer.toString()) == false)
			if (fa.ftp.makeDirectory(dirBuffer.toString()) == false)
				throw new BusinessException("����Ŀ¼��" + dirBuffer.toString() + "����");

		fa.ftp.sendCommand("site chmod 777 " + dirBuffer.toString());// �޸�Ŀ¼ʹ��ģʽ����Ȩ

		// FTP�����ļ�
		String newfile = fa.uploadFile(filename, dirBuffer.toString(), false);

		return newfile;
	}

	public ActionForward doDownload(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			String filename = request.getParameter("down");
			if (filename == null || "".equals(filename.trim())) {
				throw new BusinessException("�ļ�·��Ϊ�գ�");
			}
			FtpInfo ftpInfo = ResPubUtil.getFtpInfo(user);
			FtpAccess ftp = new FtpAccess(ftpInfo);
			String localPath = FtpBusUtils.getDownloadRealPath(servlet);
			localPath = ftp.downloadFile(localPath, filename);
			if (localPath == null) {
				throw new BusinessException("����ʧ�ܣ�" + ftp.ftp.getReplyString());
			}
			request.setAttribute("filename", FtpBusUtils.getDownloadFilename(
					servlet, filename));
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
			log.debug("Exception in method doDownload", e);
			return doList(actionMapping, actionForm, request, response, user);
		}
		return (actionMapping.findForward("down"));
	}
	public ActionForward doDisable(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		WaitauditVO contentVO=null;
		try {
			String pk = request.getParameter(WebConstant.REQUEST_ATTRIBUTE_PK);
			if (pk == null)
				throw new NullPointerException("pk is required.");
			contentVO = (WaitauditVO) getContentVO(request, user);
			RewardadjustDelegate delegate = new RewardadjustDelegate();
			RewardadjustListVO listVO = new RewardadjustListVO();
			listVO.set_se_adjsrc("CH_PW_WAITAUDIT");
			listVO.set_ne_adjsrcseq(pk);
			listVO.set_pagesize("0");
			RewardadjustListVO listVOLock = new RewardadjustListVO();
			BeanUtils.copyProperties(listVOLock, listVO);
			listVOLock.set_ne_islock("1");
			DataPackage dp1 = delegate.doQuery(listVO, user);
			DataPackage dp2 = delegate.doQuery(listVOLock, user);
			if(log.isInfoEnabled())
			{
				log.info("pk--------->"+pk);
				log.info("dp1 rowcount---->"+dp1.getRowCount());
				log.info("dp2 rowcount---->"+dp2.getRowCount());
			}
			if (dp1 != null && dp2 != null
					&& dp1.getRowCount() == dp2.getRowCount() && dp1.getRowCount()!=0) {
				
				for(Iterator it=dp1.getDatas().iterator();it.hasNext();)
				{
					RewardadjustVO vo=(RewardadjustVO)it.next();
					vo.setIslock(new Short("-2"));
					delegate.doUpdate(vo, user);
					if(log.isInfoEnabled()){
						log.info("update one record"+vo.getSeq());
					}
				}
				contentVO.setTaskstate(new Byte("-2"));
			} else if(dp1==null || (dp1!=null && dp1.getRowCount()==0)){
				throw new Exception("û�в鵽�������ϵļ�¼");
			}
			else{
				throw new Exception("��̨�������ڽ��г��������������ϣ�");
			}
			
		} catch (Exception ex) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex
					.getMessage());
			return doList(actionMapping, actionForm, request, response, user);
		}
		new WaitauditDelegate().doUpdate(contentVO, user);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "����������ɹ�!");
		return doList(actionMapping, actionForm, request, response, user);
	}
	
}
