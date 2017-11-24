package com.sunrise.boss.ui.cms.resale;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.business.cms.waitaudit.persistent.WaitauditVO;
import com.sunrise.boss.business.resmanage.filedef.persistent.FiledefVO;
import com.sunrise.boss.business.resmanage.fileitem.persistent.FileitemListVO;
import com.sunrise.boss.business.resmanage.fileitem.persistent.FileitemVO;
import com.sunrise.boss.business.resmanage.task.persistent.TaskVO;
import com.sunrise.boss.business.resmanage.taskfile.persistent.TaskfileVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.delegate.cms.waitaudit.WaitauditDelegate;
import com.sunrise.boss.delegate.resmanage.filedef.FiledefDelegate;
import com.sunrise.boss.delegate.resmanage.fileitem.FileitemDelegate;
import com.sunrise.boss.delegate.resmanage.task.TaskDelegate;
import com.sunrise.boss.delegate.resmanage.taskfile.TaskfileDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.boss.ui.commons.batch.upload.ICheckFormat;
import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;
import com.sunrise.boss.ui.resmanage.common.ResUploadFileAction;

public class BatchTaskAction extends ResUploadFileAction {
	protected void setFilecode(HashMap map, User user) {
		this.filecode = "RESALE_0_1"; // Ψһ����
	}

	protected List getParamList(HashMap map, User user) throws Exception {
		List list = new ArrayList();
		addParam(list, "remark", (String) map.get("remark"));
		addParam(list, "cityid", SessionFactoryRouter.conversionCityid(user
				.getCityid()));
		addParam(list, "oprcode", user.getOpercode());
		SimpleDateFormat fs = new SimpleDateFormat("yyyyMMddHHmmss");
		addParam(list, "batchno", user.getCityid() + fs.format(new Date()));
		return list;
	}
	
	/**
	 * 
	 * @param filename
	 * @param count
	 * @param map
	 * @param user
	 * @return
	 * @throws Exception
	 */
	protected String processFile(String filename, int count, HashMap map,
			User user) throws Exception {

		String filecode = getFilecode();
		List list = getParamList(map, user);

		String memo = (String) map.get("memo");

		TaskVO task = new TaskVO();
		task.setFilecode(filecode);
		task.setSubsystem("CH");
		task.setTaskstate(new Integer(3));// ����ʼ������δ����
		task.setCreatetime(new Date(System.currentTimeMillis()));
		task.setOprcode(user.getOpercode());
		task.setWayid(user.getWayid());
		task.setExectime(new Date(System.currentTimeMillis()));
		task.setTaskfilecount(new Short("1"));// ��ʱ��һ���ļ�
		task.setTotalcount(new Integer(count));
		task.setMemo(memo);

		TaskDelegate taskDelegate = new TaskDelegate();
		TaskVO taskVO = taskDelegate.doRecordTask(task, list, user);

		// �Ǽ������ļ�
		TaskfileDelegate taskfileDelegate = new TaskfileDelegate();
		TaskfileVO taskfile = new TaskfileVO();
		taskfile.setTaskid(taskVO.getTaskid());
		taskfile.setFileline(new Integer(count));
		taskfile.setTaskfile(filename);
		taskfile.setUploadtime(new Date(System.currentTimeMillis()));
		taskfileDelegate.doCreate(taskfile, user);

//		taskVO.setTaskstate(new Integer(0));// ����״̬Ϊ������
		taskDelegate.doUpdate(taskVO, user);

		return taskVO.getTaskid().toString();
	}
	
	/**
	 * ����ļ���ʽ���������ļ�������
	 * 
	 * @param filename
	 * @param iCheckFormat
	 * @param user
	 * @return
	 * @throws Exception
	 */
	protected int checkFile(FormFile file, String filename,
			ICheckFormat iCheckFormat, HashMap map, User user) throws Exception {
		if (!file.getContentType().equals("text/plain")) {
			throw new Exception("Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		}
		if(file.getFileSize()<=0 && file.getFileData().length<=0)
		{
			throw new Exception("�ϴ����ļ����ݲ���Ϊ��!");
		}
		FileitemDelegate fiDelegeate = new FileitemDelegate();
		FileitemListVO listVO = new FileitemListVO();
		listVO.set_se_filecode(getFilecode());
		DataPackage fidp = fiDelegeate.doQuery(listVO, user, false);
		if (fidp.getDatas().size()<=0) {
			throw new Exception("�ļ�����" + getFilecode() + "û�ж����ļ����������ϵ����Ա��");
		}

		FiledefDelegate fdefDelegate = new FiledefDelegate();
		FiledefVO fdVo = fdefDelegate.doFindByPk(this.filecode, user);
		int maxLine = 100000;
		if (fdVo != null) {
			maxLine = fdVo.getLinelimit().intValue();
		} else {
			throw new Exception("�ļ�����" + getFilecode() + "�޶��壬����ϵ����Ա��");
		}

		FileInputStream fileInputStream = new FileInputStream(filename);
		InputStreamReader read = new InputStreamReader(fileInputStream, "gbk");
		BufferedReader rin = new BufferedReader(read);
		String line;
		int row = 0;// ��¼��ǰ��鵽������

		try {
			while ((line = rin.readLine()) != null) {
				if (line.trim().length() > 0) {
					++row;
					if (row > maxLine) {
						throw new Exception("�ļ�ʵ�����������ļ���������������");
					}
					Iterator iter = fidp.getDatas().iterator();
					String[] items = StringUtils.splitPreserveAllTokens(line, splitFlag);
					if (items.length != fidp.getDatas().size()) {
						throw new Exception("�ϴ�������������,��" + row + "������ӦΪ"
								+ fidp.getDatas().size() + "��,��鿴˵������!");
					}
					int col = 0;
					while (iter.hasNext()) {
						FileitemVO fileitem = (FileitemVO) iter.next();
						checkItem(row, items[col], fileitem);
						col++;
					}

				}
			}
		} catch (Exception ex) {
			throw ex;
		} finally {
			rin.close();
			read.close();
			fileInputStream.close();
		}

		return row;
	}
	
	
	/**
	 * ��д���෽��
	 */
	public ActionForward execute(ActionMapping actionMapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setContentType(CONTENT_TYPE);
		HttpSession session = request.getSession();
		User user = (User) session
				.getAttribute(WebConstant.SESSION_ATTRIBUTE_USER);

		if (user == null) {
			user = new User();
			user.setOpercode("test");
			user.setWayid("test");
		}

		try {
			UploadFileForm fileForm = (UploadFileForm) form;
			FormFile file = fileForm.getTheFile();
			HashMap map = getParamMapFromRequest(request, user);

			setFilecode(map, user);

			String filename = getFile(file, user);
			int count = checkFile(file, filename, fileForm.getCheckFormat(),
					map, user);
			filename = ftpFile(filename, user);
			String filecode = processFile(filename, count, map, user);

			file.destroy();
			//�Ǽ�������˱�
			WaitauditVO vo=new WaitauditVO();
			//���״̬3
			vo.setTaskstate(new Byte("0"));
			vo.setFilecode(filecode);
			vo.setSubsystem(new Short("0"));
			vo.setLogfile(filename);
			vo.setOprcode(user.getOpercode());
			vo.setWayid(user.getWayid());
			vo.setCreatetime(new Date());
			new WaitauditDelegate().doCreate(vo, user);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,"�ļ����ϴ��ɹ���(������:"+filecode+")��Ҫ���ͨ���ű������뵽��Ч���ء�->�����������Դ��˹����˵��鿴");
			return actionMapping.findForward("success");
		} catch (Exception ex) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex
					.getMessage());
			return actionMapping.findForward("error");
		}
	}
}