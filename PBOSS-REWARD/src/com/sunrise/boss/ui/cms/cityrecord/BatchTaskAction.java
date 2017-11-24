package com.sunrise.boss.ui.cms.cityrecord;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.chadtdictparam.persistent.ChAdtDictparamListVO;
import com.sunrise.boss.business.cms.chadtdictparam.persistent.ChAdtDictparamVO;
import com.sunrise.boss.business.cms.dictparam.persistent.DictparamListVO;
import com.sunrise.boss.business.cms.dictparam.persistent.DictparamVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.delegate.cms.chadtdictparam.ChAdtDictparamDelegate;
import com.sunrise.boss.delegate.cms.dictparam.DictparamDelegate;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.upload.UploadFileAction;

public class BatchTaskAction extends UploadFileAction {
    public static final String BATCH_TASK_ACTION = "BATCH";
    public static final String UPLOAD_TASK_ACTION = "UPLOAD";

    /**
	 * 建立文件，
	 */
	protected String createFilename(String opercode) throws Exception {
		String type=".txt";
		
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
				+ (calendar.get(Calendar.MONTH) +1) + calendar.get(Calendar.DATE)
				+ calendar.get(Calendar.HOUR) + calendar.get(Calendar.MINUTE)
				+ calendar.get(Calendar.SECOND)
				+ (new java.util.Random()).nextInt(99);

		// String webappPath = getServlet().getInitParameter("uplocation");
		int strLength = location.length();
		String pathSeperator = location.substring(strLength - 1, strLength);
		location = getServlet().getServletConfig().getServletContext()
				.getRealPath(location);
		if(!location.endsWith(pathSeperator)){
			location = location + pathSeperator;
		}
		location=location.replace('\\', '/');
		String file = location + filename + type;
		java.io.File f = new java.io.File(location);
		if (f.exists()) {
			return file;
		} else {
			throw new Exception("存放文件路径错误,请检阅web.xml中uploadlocation的配置(请在web目录下面新建upload文件夹)!");
		}
	}
	
	protected String createFilename(String opercode,String cityidcapital) throws Exception {
		String type=".txt";
		
		String location = servlet.getServletConfig().getInitParameter(
				"uploadlocation");
		if (location == null || location.equals("")) {
			throw new Exception("文件路径没有设置，请检阅web.xml中uploadlocation的配置!");
		}
		String head = cityidcapital+"_"+opercode;
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
		calendar.setTime(new Date());
		if (head == null || head.equals("")) {
			head = "sunrise_";
		} else {
			head += "_";
		}
		
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		
		sf.format(new Date());
		
		String filename = head +sf.format(new Date());
//		String filename = head +cityidcapital+"_"+sf.format(new Date());

		// String webappPath = getServlet().getInitParameter("uplocation");
		int strLength = location.length();
		String pathSeperator = location.substring(strLength - 1, strLength);
		location = getServlet().getServletConfig().getServletContext()
				.getRealPath(location);
		if(!location.endsWith(pathSeperator)){
			location = location + pathSeperator;
		}
		location=location.replace('\\', '/');
		String file = location + filename + type;
		java.io.File f = new java.io.File(location);
		if (f.exists()) {
			return file;
		} else {
			throw new Exception("存放文件路径错误,请检阅web.xml中uploadlocation的配置(请在web目录下面新建upload文件夹)!");
		}
	}
    
    public ActionForward execute(ActionMapping actionMapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {    	
    	HttpSession session = request.getSession();
    	User user = (User) session.getAttribute(WebConstant.SESSION_ATTRIBUTE_USER);
    	String opercode = user.getOpercode();
//    	String newfile = createFilename(opercode); //在服务器的地址,写文件和下载需要用的
    	request.setAttribute("disabled", "true");
    	
    	//防止再起一个thread，设置一个参数（CH_ADT_DICTPARAM），
    	//thread_ch_pw_Rewardrecord ,thread_ch_bbc_Rewardrecord,dvalue的值为1就不让在进入了
    	ChAdtDictparamDelegate de=new  ChAdtDictparamDelegate();
    	ChAdtDictparamListVO listvo=new ChAdtDictparamListVO();
    	if("2".equals(request.getParameter("systemflag"))){
    		listvo.set_se_dkey("thread_ch_pw_rewardrecord");
    		DataPackage dp=de.doQuery(listvo, user);
    		Iterator<ChAdtDictparamVO> it=dp.getDatas().iterator();
    		if(it.hasNext()){
    			if("1".equals(it.next().getDvalue())){
    				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "社会渠道酬金正在发布，请等待完成后再做！");
                    return (actionMapping.findForward("error"));
    			}
    		}
    	}
    	if("3".equals(request.getParameter("systemflag"))){
    		listvo.set_se_dkey("thread_ch_bbc_rewardrecord");
    		DataPackage dp=de.doQuery(listvo, user);
    		Iterator<ChAdtDictparamVO> it=dp.getDatas().iterator();
    		if(it.hasNext()){
    			if("1".equals(it.next().getDvalue())){
    				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "创薪联盟酬金正发布，请等待完成后再做！");
                    return (actionMapping.findForward("error"));
    			}
    		}
    	}
    	
//        if (getCommandString(request).equals(BATCH_TASK_ACTION)){
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
//        } else {
//            return super.execute(actionMapping, form, request, response);
//        }
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
		HttpSession session = request.getSession();
    	User user = (User) session.getAttribute(WebConstant.SESSION_ATTRIBUTE_USER);
    	String opercode = user.getOpercode();

    	// 传一个地市标识 ZS
    	String newfile = createFilename(opercode,SessionFactoryRouter.conversionCityid(user.getCityid())); //在服务器的地址,写文件和下载需要用的

		String beanname = request.getParameter("beanname");
		
		request.setAttribute("show", "true");

		Cityrecord4IssueTaskBean bean = (Cityrecord4IssueTaskBean) Class.forName(beanname).newInstance();
		BeanUtils.copyProperties(bean, form);
		bean.setFilename(newfile);
			
		//取得页面传过来的  systemflag,rewardmonth,isflag
		String systemflag = request.getParameter("systemflag");
		String rewardmonth = request.getParameter("rewardmonth");
		String isflag = request.getParameter("isflag");
		
		//可选的参数
		String wayid = request.getParameter("wayid");
		String chainhead = request.getParameter("chainhead");
		//String opnid = request.getParameter("opnid");
		//String approveid = request.getParameter("approveid");
		String mobile = request.getParameter("mobile");
		String countyid = request.getParameter("countyid");
		String taskid = request.getParameter("taskid");
		String sin_opnid = request.getParameter("sin_opnid");
		//向线程传递参数,写到线程的属性中
		bean.setIsflag(isflag);
		bean.setSystemflag(systemflag);
		bean.setRewardmonth(rewardmonth);
		bean.setWayid(wayid);
		bean.setChainhead(chainhead);
		//bean.setApproveid(approveid);
		bean.setCountyid(countyid);
		bean.setTaskid(taskid);
		//bean.setOpnid(opnid);
		bean.setSin_opnid(sin_opnid);
		bean.setMobile(mobile);
		
		user = (User) request.getSession().getAttribute(WebConstant.SESSION_ATTRIBUTE_USER);
		HashMap parameterMap = new HashMap();
		parameterMap.put("filename", "filename");
		request.setAttribute("parameterMap", parameterMap);
		com.sunrise.boss.common.utils.bean.BeanUtils.copyProperties(form,parameterMap);
		
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
		
		//防止再起一个thread，设置一个参数（CH_ADT_DICTPARAM），
    	//thread_ch_pw_Rewardrecord ,thread_ch_bbc_Rewardrecord,dvalue的值为1就不让在进入了
    	try {
			ChAdtDictparamDelegate de11=new  ChAdtDictparamDelegate();
			ChAdtDictparamListVO listvo=new ChAdtDictparamListVO();
			ChAdtDictparamVO vo=new ChAdtDictparamVO();
			if("2".equals(systemflag)){
				listvo.set_se_dkey("thread_ch_pw_rewardrecord");
	    		DataPackage ictparamdp=de11.doQuery(listvo, user);
	    		Iterator<ChAdtDictparamVO> it=ictparamdp.getDatas().iterator();
	    		if(it.hasNext()){
	    			vo=it.next();
	    			vo.setDvalue("1");
	    			de11.doUpdate(vo, user);
	    		}
			}
			if("3".equals(systemflag)){
				listvo.set_se_dkey("thread_ch_bbc_rewardrecord");
	    		DataPackage ictparamdp=de11.doQuery(listvo, user);
	    		Iterator<ChAdtDictparamVO> it=ictparamdp.getDatas().iterator();
	    		if(it.hasNext()){
	    			vo=it.next();
	    			vo.setDvalue("1");
	    			de11.doUpdate(vo, user);
	    		}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		thread.start();
		return actionMapping.findForward("success");
	}
}
