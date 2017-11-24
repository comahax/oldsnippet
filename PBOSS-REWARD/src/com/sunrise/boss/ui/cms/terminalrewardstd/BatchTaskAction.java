package com.sunrise.boss.ui.cms.terminalrewardstd;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.boss.ui.commons.batch.upload.UploadFileAction;

public class BatchTaskAction extends UploadFileAction {
    public static final String BATCH_TASK_ACTION = "BATCH";
    public static final String UPLOAD_TASK_ACTION = "UPLOAD";

    public ActionForward execute(ActionMapping actionMapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
        if (getCommandString(request).equals(BATCH_TASK_ACTION)){
            try {
                return doProcess(actionMapping, form, request, response);
            }catch (Exception ex) {
                String msg=ex.getMessage();
                if(ex instanceof FileNotFoundException){//屏蔽文件路径
                    msg="系统找不到指定的文件";
                }
                request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, msg);
                return (actionMapping.findForward("error"));
            }
        } else {
            return super.execute(actionMapping, form, request, response);
        }
    }

    protected String getCommandString(HttpServletRequest request) {
        String cmd = request.getParameter(WebConstant.PAGE_ATTRIBUTE_COMMAND);
        return (cmd == null) ? BATCH_TASK_ACTION : cmd;
    }

	/**
	 * 启动bean运行
	 */
	protected ActionForward doProcess(ActionMapping actionMapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String filename = request.getParameter("filename");
		File file = new File(filename);
		if (!file.exists()) {
			throw new Exception("要处理的文件并不存在,请先上传");
		}
		String beanname = request.getParameter("beanname");
		HttpSession session = request.getSession();
		request.setAttribute("show", "true");
		TerminalrewardstdTaskBean bean = (TerminalrewardstdTaskBean) Class.forName(beanname)
				.newInstance();
		BeanUtils.copyProperties(bean, form);
		if (filename != null && filename.trim().equals("")) {
			bean.setFilename(filename);
		}
		
		String region = request.getParameter("region");
		bean.setRegion(region);
		
		User user = (User) request.getSession().getAttribute(WebConstant.SESSION_ATTRIBUTE_USER);
		// changed by liwenjing
		// if(user==null){ //供测试模拟,以后要屏蔽此代码
		// user=new User();
		// user.setLogintime(new Date());
		// user.setOpercode("sunriseOpercode");
		// user.setOpername("sunriseOpername");
		// user.setWayid("sunriseWayid");
		// }
		// 读取表单文件数据,赋值给表单,处理完毕后的表单显示跟上传时的表单一样
		String parameterFileName = filename.replaceFirst("\\.txt$",
				UploadFileAction.PARAMETER + ".txt");
		parameterFileName = parameterFileName.replaceFirst("\\.xls$",
				UploadFileAction.PARAMETER + ".txt");
		FileInputStream in = new FileInputStream(parameterFileName);
		ObjectInputStream oi = new ObjectInputStream(in);
		HashMap parameterMap = (HashMap) oi.readObject();
		parameterMap.put("filename", filename);
		request.setAttribute("parameterMap", parameterMap);
		com.sunrise.boss.common.utils.bean.BeanUtils.copyProperties(form,
				parameterMap);
		oi.close();
		in.close();
		// 删除表单文件
		File parameterFile = new File(parameterFileName);
		parameterFile.delete();
		// 启动线程运行
		bean.setUser(user);
		bean.setParameterMap(parameterMap);
		bean.setForm(form);
		Thread thread = new Thread(bean);
		// 将bean名字放入beanMap,以便准确显示进度
		HashMap beanMap = (HashMap) session.getAttribute("beanMap");
		if (beanMap == null) {// 第一次批量导入时为空
			beanMap = new HashMap();
			session.setAttribute("beanMap", beanMap);
		}
		beanMap.put(beanname, bean);
		thread.start();
		return actionMapping.findForward("success");
	}
}
