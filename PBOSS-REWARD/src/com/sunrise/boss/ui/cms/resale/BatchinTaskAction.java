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
import com.sunrise.boss.business.resmanage.common.pubdef.ResConstant;
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
import com.sunrise.boss.ui.commons.ftp.FtpInfo;
import com.sunrise.boss.ui.resmanage.common.ResPubUtil;
import com.sunrise.boss.ui.resmanage.common.ResUploadFileAction;

public class BatchinTaskAction extends ResUploadFileAction {
	protected void setFilecode(HashMap map, User user) {
		this.filecode = "RESALE_0_0"; // 唯一定义
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
		task.setTaskstate(new Integer(3));// 任务开始先设置未就绪
		task.setCreatetime(new Date(System.currentTimeMillis()));
		task.setOprcode(user.getOpercode());
		task.setWayid(user.getWayid());
		task.setExectime(new Date(System.currentTimeMillis()));
		task.setTaskfilecount(new Short("1"));// 暂时用一个文件
		task.setTotalcount(new Integer(count));
		task.setMemo(memo);

		TaskDelegate taskDelegate = new TaskDelegate();
		TaskVO taskVO = taskDelegate.doRecordTask(task, list, user);

		// 登记任务文件
		TaskfileDelegate taskfileDelegate = new TaskfileDelegate();
		TaskfileVO taskfile = new TaskfileVO();
		taskfile.setTaskid(taskVO.getTaskid());
		taskfile.setFileline(new Integer(count));
		taskfile.setTaskfile(filename);
		taskfile.setUploadtime(new Date(System.currentTimeMillis()));
		taskfileDelegate.doCreate(taskfile, user);

//		taskVO.setTaskstate(new Integer(0));// 更新状态为待处理
		taskDelegate.doUpdate(taskVO, user);

		return taskVO.getTaskid().toString();
	}
	
	/**
	 * 检查文件格式，并返回文件总行数
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
			throw new Exception("要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
		}
		if(file.getFileSize()<=0 && file.getFileData().length<=0)
		{
			throw new Exception("上传的文件数据不能为空!");
		}
		FileitemDelegate fiDelegeate = new FileitemDelegate();
		FileitemListVO listVO = new FileitemListVO();
		listVO.set_se_filecode(getFilecode());
		DataPackage fidp = fiDelegeate.doQuery(listVO, user, false);
		if (fidp.getDatas().size()<=0) {
			throw new Exception("文件编码" + getFilecode() + "没有定义文件数据项，请联系管理员！");
		}

		FiledefDelegate fdefDelegate = new FiledefDelegate();
		FiledefVO fdVo = fdefDelegate.doFindByPk(this.filecode, user);
		int maxLine = 100000;
		if (fdVo != null) {
			maxLine = fdVo.getLinelimit().intValue();
		} else {
			throw new Exception("文件编码" + getFilecode() + "无定义，请联系管理员！");
		}

		FileInputStream fileInputStream = new FileInputStream(filename);
		InputStreamReader read = new InputStreamReader(fileInputStream, "gbk");
		BufferedReader rin = new BufferedReader(read);
		String line;
		int row = 0;// 记录当前检查到的行数

		try {
			while ((line = rin.readLine()) != null) {
				if (line.trim().length() > 0) {
					++row;
					if (row > maxLine) {
						throw new Exception("文件实际行数大于文件所定义的最大行数");
					}
					Iterator iter = fidp.getDatas().iterator();
					String[] items = StringUtils.splitPreserveAllTokens(line, splitFlag);
					if (items.length != fidp.getDatas().size()) {
						throw new Exception("上传数据列数不对,第" + row + "行数据应为"
								+ fidp.getDatas().size() + "列,请查看说明帮助!");
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
	 * 复写父类方法
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
			//登记数据审核表
			WaitauditVO vo=new WaitauditVO();
			//审核状态3
			vo.setTaskstate(new Byte("0"));
			vo.setFilecode(filecode);
			vo.setSubsystem(new Short("0"));
			vo.setLogfile(filename);
			vo.setOprcode(user.getOpercode());
			vo.setWayid(user.getWayid());
			vo.setCreatetime(new Date());
			new WaitauditDelegate().doCreate(vo, user);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,"文件已上传成功，(任务编号:"+filecode+")需要审核通过才被处理。请到【效益监控】->【社会渠道资源审核管理】菜单查看");
			return actionMapping.findForward("success");
		} catch (Exception ex) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex
					.getMessage());
			return actionMapping.findForward("error");
		}
	}
}