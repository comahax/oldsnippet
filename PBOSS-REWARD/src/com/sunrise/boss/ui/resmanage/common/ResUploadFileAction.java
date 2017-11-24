package com.sunrise.boss.ui.resmanage.common;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.business.resmanage.common.pubdef.ResConstant;
import com.sunrise.boss.business.resmanage.filedef.persistent.FiledefVO;
import com.sunrise.boss.business.resmanage.fileitem.persistent.FileitemListVO;
import com.sunrise.boss.business.resmanage.fileitem.persistent.FileitemVO;
import com.sunrise.boss.business.resmanage.task.persistent.TaskVO;
import com.sunrise.boss.business.resmanage.taskfile.persistent.TaskfileVO;
import com.sunrise.boss.business.resmanage.taskparam.persistent.TaskparamVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.delegate.resmanage.filedef.FiledefDelegate;
import com.sunrise.boss.delegate.resmanage.fileitem.FileitemDelegate;
import com.sunrise.boss.delegate.resmanage.task.TaskDelegate;
import com.sunrise.boss.delegate.resmanage.taskfile.TaskfileDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.boss.ui.commons.batch.upload.ICheckFormat;
import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;
import com.sunrise.boss.ui.commons.ftp.FtpAccess;
import com.sunrise.boss.ui.commons.ftp.FtpInfo;

public abstract class ResUploadFileAction extends Action {

	static final protected String CONTENT_TYPE = "text/html; charset=GBK";

	protected String filecode;

	protected String splitFlag;
	
	protected Map paramMap;

	public ResUploadFileAction() {
		super();
		this.splitFlag = "|";
	}

	protected abstract void setFilecode(HashMap map, User user);

	protected String getFilecode() {
		return this.filecode;
	}

	protected void setSplitFlag(String splitFlag) {
		this.splitFlag = splitFlag;
	}

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
			FormFile file = fileForm.getTheFile();// 上传的文件
			HashMap map = getParamMapFromRequest(request, user);//将页面表单所输入的参数，保存在Map中
			paramMap =  map;

			setFilecode(map, user);// 设置上传文件类型

			String filename = getFile(file, user);// 将文件内容拷到服务器本地指定的目录里面，并返回本地文件名
			int count = checkFile(file, filename, fileForm.getCheckFormat(),
					map, user);// 检查文件格式，并返回文件总行数
			filename = ftpFile(filename, user);// 上传文件到系统参数指定的主机及目录，返回文件名
			String msg = processFile(filename, count, map, user);// 处理文件

			file.destroy();

			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, msg);
			return actionMapping.findForward("success");
		} catch (Exception ex) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex
					.getMessage());
			return actionMapping.findForward("error");
		}
	}

	/**
	 * 将文件内容拷到服务器本地指定的目录里面，并返回本地文件名
	 * 
	 * @param file
	 * @param user
	 * @return
	 * @throws Exception
	 */
	protected String getFile(FormFile file, User user) throws Exception {
		String newfile = "";
		try {
			newfile = createFilename(user.getOpercode());
			InputStream ins = file.getInputStream();
			OutputStream outs = new FileOutputStream(newfile);
			int bytesRead = 0;
			byte[] buffer = new byte[8192];
			while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
				outs.write(buffer, 0, bytesRead);
			}
			outs.close();
			ins.close();
		} catch (FileNotFoundException fnfe) {
			throw new Exception("源文件没找到!");
		} catch (IOException ioe) {
			throw new Exception("文件读写错误");
		} catch (Exception e) {
			throw e;
		}
		return newfile;
	}

	/**
	 * 获取页面表单所输入的参数，并保存在Map中
	 * 
	 * @param request
	 * @return map
	 * @throws Exception
	 */
	protected HashMap getParamMapFromRequest(HttpServletRequest request,
			User user) throws Exception {
		Enumeration e = request.getParameterNames();
		HashMap map = new HashMap();
		while (e.hasMoreElements()) {
			String key = e.nextElement().toString();
			String value = request.getParameter(key);
			map.put(key, value);
		}
		map.put("user", user);
		return map;
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

		FileitemDelegate fiDelegeate = new FileitemDelegate();
		FileitemListVO fiListVO = new FileitemListVO();
		fiListVO.set_pagesize("0");
		fiListVO.set_se_filecode(getFilecode());
		fiListVO.set_orderby("itemid");
		DataPackage fidp = fiDelegeate.doQuery(fiListVO, user, false);
		if (fidp.getDatas().size() < 1) {
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
					String[] items = StringUtils.split(line, splitFlag);
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

	// 检查数据项
	protected void checkItem(int row, String item, FileitemVO fileitem)
			throws Exception {
		if (1 != fileitem.getIsnull().intValue()
				&& item.length() > fileitem.getItemlength().intValue()) {
			throw new Exception("第" + row + "行格式有错，[" + item + "]位数过大，应该为"
					+ fileitem.getItemlength() + "位。");
		}
		switch (fileitem.getItemtype().intValue()) {
		case 1:// 数字
			for (int i = 0; i < item.length(); i++) {
				if (item.charAt(i) < '0' || item.charAt(i) > '9') {
					throw new Exception("第" + row + "行格式有错，[" + item
							+ "]应该为数字字符串。");
				}
			}
			break;
		case 2:// 文本

			break;
		case 3:// 时间

			break;
		case 4:// 定值控制

			break;
		default:
			break;
		}
		checkOther(row, item, fileitem);
	}

	// 检查未定义的逻辑限制
	protected void checkOther(int row, String item, FileitemVO fileitem)
			throws Exception {

	}

	/**
	 * 上传文件到系统参数指定的主机及目录，返回文件名
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
			throw new Exception("资源系统参数没有设置，无法取得批量文件存放目录");
		}
		FtpAccess fa = new FtpAccess(fi);

		DateFormat format = new SimpleDateFormat("yyyyMM");
		String dateDir = format.format(new Date(System.currentTimeMillis()));
		String cityid = SessionFactoryRouter.conversionCityid(user.getCityid());
		StringBuffer dirBuffer = new StringBuffer(dir);

		// 进入日期目录
		dirBuffer.append("/").append(dateDir);
		if (fa.ftp.changeWorkingDirectory(dirBuffer.toString()) == false)
			if (fa.ftp.makeDirectory(dirBuffer.toString()) == false)
				throw new Exception("进入目录：" + dirBuffer.toString() + "出错！");

		// 进入市公司标识目录
		dirBuffer.append("/").append(cityid);
		if (fa.ftp.changeWorkingDirectory(dirBuffer.toString()) == false)
			if (fa.ftp.makeDirectory(dirBuffer.toString()) == false)
				throw new Exception("进入目录：" + dirBuffer.toString() + "出错！");

		// 进入渠道目录
		dirBuffer.append("/").append(user.getWayid());
		if (fa.ftp.changeWorkingDirectory(dirBuffer.toString()) == false)
			if (fa.ftp.makeDirectory(dirBuffer.toString()) == false)
				throw new Exception("进入目录：" + dirBuffer.toString() + "出错！");

		// 进入工号目录
		dirBuffer.append("/").append(user.getOpercode());
		if (fa.ftp.changeWorkingDirectory(dirBuffer.toString()) == false)
			if (fa.ftp.makeDirectory(dirBuffer.toString()) == false)
				throw new Exception("进入目录：" + dirBuffer.toString() + "出错！");

		fa.ftp.sendCommand("site chmod 777 " + dirBuffer.toString());// 修改目录使用模式，赋权

		// FTP传送文件
		String newfile = fa.uploadFile(filename, dirBuffer.toString(), false);

		return newfile;
	}

	/**
	 * 取得页面表单输入的参数，并以List返回
	 * 
	 * @param map
	 * @param user
	 * @return
	 * @throws Exception
	 */
	protected List getParamList(HashMap map, User user) throws Exception {
		return null;
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
		task.setSubsystem("IM");
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

		taskVO.setTaskstate(new Integer(0));// 更新状态为待处理
		taskDelegate.doUpdate(taskVO, user);

		return "已登记批量处理任务，任务编号" + taskVO.getTaskid() + "，后台程序将进行处理。";
	}

	/**
	 * 建立文件
	 * 
	 * @param opercode
	 * @return filename
	 * @throws Exception
	 */
	protected String createFilename(String opercode) throws Exception {
		String location = servlet.getServletConfig().getInitParameter(
				"uploadlocation");
		if (location == null || location.equals("")) {
			throw new Exception("文件路径没有设置，请检阅web.xml中uploadlocation的配置!");
		}
		String head = opercode;
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
		calendar.setTime(new Date());
		if (head == null || head.equals("")) {
			head = "sunrise_";
		} else {
			head += "_";
		}
		String filename = head + (calendar.get(Calendar.YEAR) + 1900)
				+ calendar.get(Calendar.MARCH) + calendar.get(Calendar.DATE)
				+ calendar.get(Calendar.HOUR) + calendar.get(Calendar.MINUTE)
				+ calendar.get(Calendar.SECOND)
				+ (new java.util.Random()).nextInt(99);

		// String webappPath = getServlet().getInitParameter("uplocation");
		int strLength = location.length();
		String pathSeperator = location.substring(strLength - 1, strLength);
		location = getServlet().getServletConfig().getServletContext()
				.getRealPath(location);
		if (!location.endsWith(pathSeperator)) {
			location = location + pathSeperator;
		}
		location = location.replace('\\', '/');
		String file = location + filename + ".txt";
		java.io.File f = new java.io.File(location);
		if (f.exists()) {
			return file;
		} else {
			throw new Exception(
					"存放文件路径错误,请检阅web.xml中uploadlocation的配置(请在web目录下面新建upload文件夹)!");
		}
	}

	protected void addParam(List list, String paramCode, String paramValue)
			throws Exception {
		TaskparamVO taskParam = new TaskparamVO();
		taskParam.setParamcode(paramCode.toUpperCase());
		taskParam.setParamvalue(paramValue);
		list.add(taskParam);
	}
}
