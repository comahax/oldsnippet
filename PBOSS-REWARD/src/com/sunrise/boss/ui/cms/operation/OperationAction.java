/**
 * auto-generated code
 * Tue May 01 13:34:19 CST 2007
 */
package com.sunrise.boss.ui.cms.operation;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List; 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse; 
import net.sf.ehcache.Cache;
import net.sf.ehcache.Element; 
import org.ajaxanywhere.AAUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping; 
import com.sunrise.boss.business.cms.operation.persistent.OperationListVO;
import com.sunrise.boss.business.cms.operation.persistent.OperationVO;
import com.sunrise.boss.business.cms.reward.busiload.persistent.BusiloadListVO;
import com.sunrise.boss.business.cms.reward.busiload.persistent.BusiloadVO;
import com.sunrise.boss.business.cms.reward.pwdictparam.persistent.PwDictparamVO; 
import com.sunrise.boss.common.base.db.DataPackage; 
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.common.utils.CacheSinglton; 
import com.sunrise.boss.delegate.cms.operation.OperationDelegate;
import com.sunrise.boss.delegate.cms.reward.busiload.BusiloadDelegate;
import com.sunrise.boss.delegate.cms.reward.pwdictparam.PwDictparamDelegate;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.cms.cityrecord.CityrecordForm;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant; 
import com.sunrise.boss.ui.commons.ftp.FtpInfo;

 

/**
 * <p>
 * Title: OperationAction
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
public class OperationAction extends BaseDelegateAction {

	private static final Log log = LogFactory.getLog(OperationAction.class);
	
	public OperationAction() {
		// 以下几个方法是必须的
		// 指定VO类
		setVoClass(OperationVO.class);
		// 指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
		this.pkNameArray = new String[1];
		pkNameArray[0] = "opnid";
	}

	/**
	 * 生成业务类型树，只允许选择第三级
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doSelectopntree(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			String contextPath = request.getContextPath();
			String showtext = "";
			String opnid = (StringUtils.equals("undefined", request
					.getParameter("opnid")) || StringUtils.isEmpty(request
					.getParameter("opnid"))) ? "0" : request
					.getParameter("opnid");
			String topChildrenURI = "selectOperationXml.jsp";
			String opnproxy = "";
			String rootName = null;
			String topAction = "";
			String topChildrenURL = null;
			String rootAdaId = null;
			StringBuffer topChildrenURLBuffer = new StringBuffer(100);
			OperationDelegate delegate = new OperationDelegate();
			OperationVO operationVO = delegate.doFindByPk(opnid, user);
			if (operationVO == null && "0".equals(opnid)) {
				rootName = "业务类型";
				rootAdaId = "0";
				opnproxy = "1";
			} else {
				rootName = operationVO.getName();
				rootAdaId = operationVO.getOpnid().toString();
				if ("0".equals(operationVO.getParentid())) {
					opnproxy = "2";
				} else {
					opnproxy = (delegate.getParentlevel(operationVO, user) + 1)
							+ "";
				}
			}
			topChildrenURLBuffer.append(contextPath).append("/cms/operation/")
					.append(topChildrenURI).append("?parentid=").append(
							rootAdaId).append("&parenttype=opn").append(
							"&function=selectOpn&childrenURL=").append(
							contextPath).append("/cms/operation/").append(
							topChildrenURI).append("&opnproxy=").append(
							opnproxy).append("&opntype=5").append("&times=")
					.append((new Date()).getTime());
			if (!"1".equals(opnproxy)) {
				topAction = "\"javascript:selectOpn('" + rootAdaId + "','"
						+ showtext + "' , 'opn') \"";
			} else {
				topAction = rootAdaId == null ? "" : "\"javascript:void(0) \"";
				showtext = "请选择业务类型";
			}
			// 如果要求输入的级别大于用户所在的级别，则提示下面的信息

			if (Integer.valueOf(opnproxy).intValue() > 6) {
				rootAdaId = operationVO.getOpnid().toString();
				rootName = operationVO.getName();
				topAction = "\"javascript:selectOpn('" + rootAdaId + "','"
						+ showtext + "' , 'opn') \"";
			}

			topChildrenURL = rootAdaId != null ? topChildrenURLBuffer
					.toString() : "";
			request.setAttribute("text", showtext);
			request.setAttribute("rootAdaId", rootAdaId);
			request.setAttribute("opnproxy", opnproxy);
			request.setAttribute("parentType", "opn");
			request.setAttribute("rootName", rootName);
			request.setAttribute("topChildrenURL", topChildrenURL);
			request.setAttribute("topAction", topAction);
		} catch (Exception e) {
			log.error(e);
			request.setAttribute("rootAdaId", null);
		}
		return actionMapping.findForward("selectopntree");
	}

	public ActionForward doSelectopnfifthtree(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {

			String contextPath = request.getContextPath();
			String showtext = "";
			String opnid = (StringUtils.equals("undefined", request
					.getParameter("opnid")) || StringUtils.isEmpty(request
					.getParameter("opnid"))) ? "0" : request
					.getParameter("opnid");
			String topChildrenURI = "selectOperationXml.jsp";
			String opnproxy = "";
			String rootName = null;
			String topAction = "";
			String topChildrenURL = null;
			String rootAdaId = null;
			StringBuffer topChildrenURLBuffer = new StringBuffer(100);
			OperationDelegate delegate = new OperationDelegate();
			OperationVO operationVO = delegate.doFindByPk(opnid, user);
			if (operationVO == null && "0".equals(opnid)) {
				rootName = "业务类型";
				rootAdaId = "0";
				opnproxy = "1";
			} else {
				rootName = operationVO.getName();
				rootAdaId = operationVO.getOpnid().toString();
				if ("0".equals(operationVO.getParentid())) {
					opnproxy = "2";
				} else {
					opnproxy = (delegate.getParentlevel(operationVO, user) + 1)
							+ "";
				}
			}
			topChildrenURLBuffer.append(contextPath).append("/cms/operation/")
					.append(topChildrenURI).append("?parentid=").append(
							rootAdaId).append("&parenttype=opn5").append(
							"&function=selectOpn&childrenURL=").append(
							contextPath).append("/cms/operation/").append(
							topChildrenURI).append("&opnproxy=").append(
							opnproxy).append("&opntype=6").append("&times=")
					.append((new Date()).getTime());
			if (!"1".equals(opnproxy)) {
				topAction = "\"javascript:selectOpn('" + rootAdaId + "','"
						+ showtext + "' , 'opn') \"";
			} else {
				topAction = rootAdaId == null ? "" : "\"javascript:void(0) \"";
				showtext = "请选择业务类型";
			}
			// 如果要求输入的级别大于用户所在的级别，则提示下面的信息

			if (Integer.valueOf(opnproxy).intValue() > 6) {
				rootAdaId = operationVO.getOpnid().toString();
				rootName = operationVO.getName();
				topAction = "\"javascript:selectOpn('" + rootAdaId + "','"
						+ showtext + "' , 'opn') \"";
			}

			topChildrenURL = rootAdaId != null ? topChildrenURLBuffer
					.toString() : "";
			request.setAttribute("text", showtext);
			request.setAttribute("rootAdaId", rootAdaId);
			request.setAttribute("opnproxy", opnproxy);
			request.setAttribute("parentType", "opn5");
			request.setAttribute("rootName", rootName);
			request.setAttribute("topChildrenURL", topChildrenURL);
			request.setAttribute("topAction", topAction);
		} catch (Exception e) {
			log.error(e);
			request.setAttribute("rootAdaId", null);
		}
		return actionMapping.findForward("selectopntree");
	}

	public ActionForward doImport(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		return actionMapping.findForward("batch");
	}

	public ActionForward doListopntree(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		OperationForm form = (OperationForm) actionForm;
		if (StringUtils.isEmpty(form.get_pageno())) {
			form.set_pageno("1");
		}
		form.set_pagesize("20");
		OperationListVO listvo = new OperationListVO();
		BeanUtils.copyProperties(listvo, form);
		listvo.set_ne_isbusi("0");
		OperationDelegate delegate = new OperationDelegate();
		DataPackage package1 = delegate.doQuery(listvo, user);
		form.set_pageno(package1.getPageNo() + "");
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, package1);
		return actionMapping.findForward("opntreelist");
	}
	public ActionForward doListopntree1(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
//		OperationForm form = (OperationForm) actionForm;
//		if (StringUtils.isEmpty(form.get_pageno())) {
//			form.set_pageno("1");
//		}
//		form.set_pagesize("20");
//		OperationListVO listvo = new OperationListVO();
//		BeanUtils.copyProperties(listvo, form);
//		listvo.set_ne_isbusi("0");
//		OperationDelegate delegate = new OperationDelegate();
//		DataPackage package1 = delegate.doQuery(listvo, user);
//		form.set_pageno(package1.getPageNo() + "");
//		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, package1);
		return actionMapping.findForward("opntreelist");
	}
	public ActionForward doQueryallsubopn(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		OperationForm form = (OperationForm) actionForm;
		
		if(form.get_se_parentid() == null || form.get_se_parentid().equals("")){
			return this.doListopntree(actionMapping, actionForm, request, response, user);
		}
		
		
		if (StringUtils.isEmpty(form.get_pageno())) {
			form.set_pageno("1");
		}
		form.set_pagesize("20");
		OperationListVO listvo = new OperationListVO();
		BeanUtils.copyProperties(listvo, form);
//		//listvo.set_ne_isbusi("0");
////		listvo.set_se_opnid(form.get_se_opnid());
////		listvo.set_sk_name(form.get_sk_name());
//		listvo.set_se_parentid(form.get_se_parentid());
////		listvo.set_ne_opnlevel(form.get_ne_opnlevel());
		OperationDelegate delegate = new OperationDelegate();
		DataPackage package1 = delegate.doQueryallsubopn(listvo, user);
		form.set_pageno(package1.getPageNo() + "");
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, package1);
		return actionMapping.findForward("opntreelist");
	}

	public ActionForward doSaveopntree(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		// super.doSave(actionMapping, actionForm, request, response, user);
		SimpleDateFormat format=new SimpleDateFormat("yyyyMMddHHmmss");
		OperationForm form = (OperationForm) actionForm;
		OperationVO vo = new OperationVO();
		BeanUtils.copyProperties(vo, form);
		OperationDelegate delegate = new OperationDelegate();
		OperationVO tmpvo = delegate.doFindByPk(vo.getOpnid(), user);
		if (tmpvo == null) {
			OperationListVO listvo=new OperationListVO();
			listvo.set_se_opnid(vo.getParentid());
			List list=(List)delegate.doQuery(listvo, user).getDatas();
			if(list.size()>0){
				OperationVO operationVO=(OperationVO)list.get(0);
				int level=operationVO.getOpnlevel()==null?0:operationVO.getOpnlevel().intValue();
				vo.setOpnlevel(new Short((level+1)+""));
				//加入第5层级判断
				if(vo.getOpnlevel()==5){
					vo.setIsbusi(new Short("1"));
					vo.setSflag(new Short("1"));
					vo.setStartdate(format.parse("20120101000000"));
				}
			}
			vo.setEnddate(format.parse("20991231235959"));
			delegate.doCreate(vo, user);
			//加入第5层级判断
			request.setAttribute("opnlevel", vo.getOpnlevel().intValue());
			if(vo.getOpnlevel()==5){
				ftpFile(vo, user);
			}
		} else {
			tmpvo.setName(vo.getName());// 只允许修改"业务分类名称"
			//加入第5层级判断,审批编码不可修改,业务归属可以修改
			if(tmpvo.getOpnlevel()==5){
				tmpvo.setBusibelong(vo.getBusibelong());
			}
			delegate.doUpdatetree(tmpvo, user);
			//加入第5层级判断
			request.setAttribute("opnlevel", tmpvo.getOpnlevel().intValue());
		}
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "保存成功");
		return actionMapping.findForward("opntreecontent");
	}
	
	//参考ResUploadFileAction.ftpFile()
	protected String ftpFile(OperationVO vo, User user) throws Exception {
		PwDictparamDelegate pwdictparamDelegate = new PwDictparamDelegate();
		PwDictparamVO pwdictparamVO = pwdictparamDelegate.doFindByPk("PSGMFTP", user);
		if(pwdictparamVO==null){
			throw new Exception("请检查系统公共库CH_PW_DICTPARAM表中主键为PSGMFTP的配置!");
		}
		FtpInfo ftpInfo = new FtpInfo();
		String[] content = pwdictparamVO.getDvalue().split(":");
		if(StringUtils.isEmpty(content[0]) || StringUtils.isEmpty(content[1]) || StringUtils.isEmpty(content[2]) || StringUtils.isEmpty(content[3])){
			throw new Exception("请检查系统公共库CH_PW_DICTPARAM表中主键为PSGMFTP的配置，其中IP地址:端口号:帐号:密码不能为空!");
		}
		ftpInfo.ftpServer = content[0];
		ftpInfo.ftpPort = new Integer(content[1]).intValue();
		ftpInfo.ftpUser = content[2];
		ftpInfo.ftpPwd = content[3];
		//ftpInfo.curSerPath = content[4];
		String dir = "/" + content[4];
		//String dir = "/COMS2PSGM";
		try {
			//加入FTP库表配置，取消地址修正
			FTPClient ftp = new FTPClient();
            ftp.setControlEncoding("GBK");
            if(log.isInfoEnabled()){
            	log.info("ftpServer="+ftpInfo.ftpServer+" ftpPort="+ftpInfo.ftpPort+" ftpUser="+ftpInfo.ftpUser+" ftpPwd="+ftpInfo.ftpPwd);
            }
			ftp.connect(ftpInfo.ftpServer, ftpInfo.ftpPort);
			if(!ftp.login(ftpInfo.ftpUser, ftpInfo.ftpPwd)){
				throw new Exception("User or password error!");
			}
            
//            if (ftpInfo.curSerPath != null && !"".equals(ftpInfo.curSerPath)) {
//                ftp.changeWorkingDirectory(ftpInfo.curSerPath);
//            }
            StringBuffer dirBuffer = new StringBuffer(dir);

    		if (ftp.changeWorkingDirectory(dirBuffer.toString()) == false)
    			if (ftp.makeDirectory(dirBuffer.toString()) == false)
    				throw new Exception("进入目录：" + dirBuffer.toString() + "出错！");

    		ftp.sendCommand("site chmod 777 " + dirBuffer.toString());// 修改目录使用模式，赋权

    		//FTP直接写文件COMS_PSGM_PROV_BIZ_RULE.YYYYMMDDHHMMSS
    		DateFormat format1 = new SimpleDateFormat("yyyyMMddHHmmss");
    		//System.out.println(fa.ftp.printWorkingDirectory());
    		OutputStreamWriter out = new OutputStreamWriter(ftp.appendFileStream(dir + "/COMS_PSGM_PROV_BIZ_RULE." + format1.format(new Date()) ));
    		BufferedWriter pw = new BufferedWriter(out);
    		DateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
    		String temp = vo.getOpnid() + "|" + vo.getName() + "|" + vo.getApproveid() + "|" + format2.format(vo.getStartdate()) + "|" + format2.format(vo.getEnddate()) +"||||||" ;
    		pw.write(temp);
    		pw.flush();
    		pw.close();
    		out.close();
    		ftp.completePendingCommand();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("connect ftp error!:" + ex.getMessage());
        }
		return "";
	}

	public ActionForward doDeleteopntree(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		// super.doDelete(actionMapping, actionForm, request, response, user);
		try{
		String[] selectArray = ((BaseActionForm) actionForm).get_selectitem();
		OperationDelegate delegate = new OperationDelegate();
		for (int i = 0; i < selectArray.length; i++) {
			delegate.doRemovetree((OperationVO) delegate.doFindByPk(
					selectArray[i], user), user);
		}
		}catch(Exception e){
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "删除失败:"+e.getMessage());
		}
		return this.doListopntree(actionMapping, actionForm, request, response,
				user);
	}

	public ActionForward doEdittopntree(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		OperationVO contentVO = (OperationVO)getContentVO(request, user);
		//加入第5层级判断
		if(contentVO.getOpnlevel().intValue()==5){
			request.setAttribute("opnlevel", contentVO.getOpnlevel().intValue());
		}
		BeanUtils.copyProperties(actionForm, contentVO);
		String command = getCommandString(request);
		((BaseActionForm) actionForm).setCmdState(command);
		request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, WebConstant.COMMAND_STRING_EDIT);
		//super.doEdit(actionMapping, actionForm, request, response, user);
		return actionMapping.findForward("opntreecontent");
	}

	public ActionForward doNewtopntree(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		// 新建时设置form的默认值
		OperationForm operationForm= (OperationForm)actionForm;
		
		//判断是否为第5层级
		OperationVO vo = new OperationVO();
		OperationDelegate delegate = new OperationDelegate();
		vo = delegate.doFindByPk(operationForm.get_se_parentid(), user);
		request.setAttribute("opnlevel", (vo.getOpnlevel().intValue()+1));
		
		String s = operationForm.get_se_parentid();
		operationForm.setParentid(s);
		setNewForm(actionForm);
		String command = getCommandString(request);
		((BaseActionForm) actionForm).setCmdState(command);
		request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, WebConstant.COMMAND_STRING_EDIT);
		return actionMapping.findForward("opntreecontent");
	}
	
	public ActionForward doNew(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		super.doNew(actionMapping, actionForm, request, response, user);
		String[] selectstar = {"1","2","3","4","5","6"};
		((OperationForm)actionForm).setSelectstar(selectstar);
		return actionMapping.findForward("content");
	}

	public ActionForward doGetopnid(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		OperationForm form = (OperationForm) actionForm;
		if(!StringUtils.isEmpty(form.getParentid())){
			OperationDelegate delegate = new OperationDelegate();
			OperationVO vo = new OperationVO();
			BeanUtils.copyProperties(vo, form);
			String opnid = delegate.formatString(vo, user);
			form.setOpnid(opnid);
			if (AAUtils.isAjaxRequest(request)) {
				AAUtils.addZonesToRefresh(request, "getopnid");
			}
		}
		return actionMapping.findForward("opntreecontent");
	}

	public ActionForward doSelectopntree2(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			OperationDelegate delegate = new OperationDelegate();
			String contextPath = request.getContextPath();
			OperationForm form = (OperationForm) actionForm;
			String showtext = "";
			String style = request.getParameter("style") == null ? "" : request
					.getParameter("style");
			String city = request.getParameter("city") == null ? "" : request
					.getParameter("city");// 根节点
			String opnid = "";
			//if (StringUtils.isEmpty(city) || "all".equals(city)) {
				opnid = "0";
//			} else {
//				opnid = delegate.doQuerybusiload(user);
//			}
			
			if(!StringUtils.isEmpty(city) && !"all".equals(city)){
				Cache cache = CacheSinglton.getInstance().getCache();
				Element element=new Element(user.getOpercode(),(java.io.Serializable)delegate.doQuerybusiload(user));
				cache.put(element);
			}else{
				Cache cache = CacheSinglton.getInstance().getCache();
				cache.remove(user.getOpercode());
			}
			String topChildrenURI = "selectOperationXml2.jsp";
			String rootName = null;
			String topAction = "";
			String topChildrenURL = null;
			String rootAdaId = null;
			StringBuffer topChildrenURLBuffer = new StringBuffer(100);

			if (StringUtils.isEmpty(opnid)) {
				throw new BusinessException("", "当前工号所在的地市不存在");
			}

			if ("0".equals(opnid)) {
				rootName = "业务类型";
				rootAdaId = "0";
			} else {
				OperationVO operationVO = delegate.doFindByPk(opnid, user);
				if (operationVO == null) {
					throw new BusinessException("", "不存在业务类型");
				}
				rootName = operationVO.getName();
				rootAdaId = operationVO.getOpnid().toString();
			}
			topChildrenURLBuffer.append(contextPath).append("/cms/operation/")
					.append(topChildrenURI).append("?parentid=").append(
							rootAdaId).append("&parenttype=operation").append(
							"&function=selectOpn&childrenURL=").append(
							contextPath).append("/cms/operation/").append(
							topChildrenURI).append("&opntype=").append(style)
					//.append("&city=").append(city)
					.append("&showdisable=").append(form.isShowendopn())
					.append("&times=").append((new Date()).getTime());
			request.getSession().setAttribute("_sk_name",
					form.get_sk_name() == null ? "" : form.get_sk_name());
			request.getSession().setAttribute("_ne_opnid",
					form.get_se_opnid() == null ? "" : form.get_se_opnid());

			if (!"0".equals(rootAdaId)) {
				topAction = "\"javascript:selectOpn('" + rootAdaId + "','"
						+ showtext + "' , 'opn') \"";
			} else {
				topAction = rootAdaId == null ? "" : "\"javascript:void(0) \"";
				showtext = "请选择业务类型";
			}
			topChildrenURL = rootAdaId != null ? topChildrenURLBuffer
					.toString() : "";
			request.setAttribute("text", showtext);
			request.setAttribute("rootAdaId", rootAdaId);
			request.setAttribute("parentType", "operation");
			request.setAttribute("rootName", rootName);
			request.setAttribute("topChildrenURL", topChildrenURL);
			request.setAttribute("topAction", topAction);
		} catch (Exception e) {
			log.error(e);
			request.setAttribute("rootAdaId", null);
			if (e instanceof BusinessException) {
				request.setAttribute("text", ((BusinessException) e)
						.getMessage());
			}
		}
		return actionMapping.findForward("selectopntree2");
	}
	
	public ActionForward doSelectopntree3(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		
		try {
			String contextPath = request.getContextPath();
			String showtext = "";
			String opnid = (StringUtils.equals("undefined", request
					.getParameter("opnid")) || StringUtils.isEmpty(request
					.getParameter("opnid"))) ? "0" : request
					.getParameter("opnid");
			String topChildrenURI = "selectOperationXml.jsp";
			String opnproxy = "";
			String rootName = null;
			String topAction = "";
			String topChildrenURL = null;
			String rootAdaId = null;
			StringBuffer topChildrenURLBuffer = new StringBuffer(100);
			OperationDelegate delegate = new OperationDelegate();
			OperationVO operationVO = delegate.doFindByPk(opnid, user);
			if (operationVO == null && "0".equals(opnid)) {
				rootName = "业务类型";
				rootAdaId = "0";
				opnproxy = "1";
			} else {
				rootName = operationVO.getName();
				rootAdaId = operationVO.getOpnid().toString();
				if ("0".equals(operationVO.getParentid())) {
					opnproxy = "2";
				} else {
					opnproxy = (delegate.getParentlevel(operationVO, user) + 1)
							+ "";
				}
			}
			topChildrenURLBuffer.append(contextPath).append("/cms/operation/")
					.append(topChildrenURI).append("?parentid=").append(
							rootAdaId).append("&parenttype=opn").append(
							"&function=selectOpn&childrenURL=").append(
							contextPath).append("/cms/operation/").append(
							topChildrenURI).append("&opnproxy=").append(
							opnproxy).append("&opntype=5").append("&times=")
					.append((new Date()).getTime());
			if (!"1".equals(opnproxy)) {
				topAction = "\"javascript:selectOpn('" + rootAdaId + "','"
						+ showtext + "' , 'opn') \"";
			} else {
				topAction = rootAdaId == null ? "" : "\"javascript:void(0) \"";
				showtext = "请选择业务类型";
			}
			// 如果要求输入的级别大于用户所在的级别，则提示下面的信息

			if (Integer.valueOf(opnproxy).intValue() > 6) {
				rootAdaId = operationVO.getOpnid().toString();
				rootName = operationVO.getName();
				topAction = "\"javascript:selectOpn('" + rootAdaId + "','"
						+ showtext + "' , 'opn') \"";
			}

			topChildrenURL = rootAdaId != null ? topChildrenURLBuffer
					.toString() : "";
			request.setAttribute("text", showtext);
			request.setAttribute("rootAdaId", rootAdaId);
			request.setAttribute("opnproxy", opnproxy);
			request.setAttribute("parentType", "opn");
			request.setAttribute("rootName", rootName);
			request.setAttribute("topChildrenURL", topChildrenURL);
			request.setAttribute("topAction", topAction);
		} catch (Exception e) {
			log.error(e);
			request.setAttribute("rootAdaId", null);
		}
		return actionMapping.findForward("selectopntree3");
	}

	/**
	 * 保存
	 */
	protected ActionForward doSave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {

		OperationForm form = (OperationForm) actionForm;
		// 判断业务加载地市是否选中全省
		String[] selectcity = form.getSelectcity();
		int citylenght = selectcity == null ? 0 : selectcity.length - 1;
		boolean allcity = false;
		for (int i = 0; i <= citylenght; i++) {
			if ("999".equals(selectcity[i])) {
				allcity = true;
			}
		}
		if (allcity) {
			form.setBusikind(new Short((short) 0));
		} else {
			form.setBusikind(new Short((short) 1));
		}

		OperationVO contentVO = new OperationVO();
		setSaveVO(contentVO, form);

		OperationDelegate delegate = new OperationDelegate();
		OperationVO existObj = new OperationVO();
		if (contentVO.getOpnid() != null) {
			existObj = delegate.doFindByPk(contentVO.getOpnid(), user);
		}
		if (existObj != null) {
			org.apache.commons.beanutils.BeanUtils.copyProperties(existObj,
					contentVO);
			contentVO = existObj;
		}

		try {
			String cmdState = form.getCmdState();
			if (WebConstant.COMMAND_STRING_EDIT.equals(cmdState)) {
				ArrayList dellist = getdelrount(form.getSelectexesys(), form
						.getSelectcity(), form.getSelectstar(),
						form.getOpnid(), user);
				ArrayList addlist = getaddrount(form.getSelectexesys(), form
						.getSelectcity(), form.getSelectstar(),
						form.getOpnid(), user);

				contentVO = delegate.doUpdateload(dellist, addlist, contentVO,
						user);
			} else {

				contentVO = delegate
						.doCreateload(form.getSelectexesys(), form
								.getSelectcity(), form.getSelectstar(),
								contentVO, user);

			}
			BeanUtils.copyProperties(actionForm, contentVO);
			((BaseActionForm) actionForm)
					.setCmdState(WebConstant.COMMAND_STRING_EDIT);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "保存成功");
		} catch (BusinessException e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.toString());
		} catch (Exception e) {
			throw e;
		}

		return (actionMapping.findForward("content"));
	}

	/**
	 * 查询
	 */
	protected ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		Page.setPageSize(request, (BaseActionForm) actionForm);

		try {
			OperationForm form = (OperationForm) actionForm;
			OperationListVO listVO = new OperationListVO();

			setListVO(listVO, form); // 设置好listVO，作为查询条件
			if (listVO.get_dnm_enddate() != null
					&& !"".equals(listVO.get_dnm_enddate())) {
				listVO.set_dnm_enddate(listVO.get_dnm_enddate() + " 23:59:59");
			}
			if (listVO.get_dnl_enddate() != null
					&& !"".equals(listVO.get_dnl_enddate())) {
				listVO.set_dnl_enddate(listVO.get_dnl_enddate() + " 00:00:00");
			}
			if (listVO.get_dnm_startdate() != null
					&& !"".equals(listVO.get_dnm_startdate())) {
				listVO.set_dnm_startdate(listVO.get_dnm_startdate()
						+ " 23:59:59");
			}
			if (listVO.get_dnl_startdate() != null
					&& !"".equals(listVO.get_dnl_startdate())) {
				listVO.set_dnl_startdate(listVO.get_dnl_startdate()
						+ " 00:00:00");
			}
			listVO.set_ne_isbusi("1");

			OperationDelegate delegate = (OperationDelegate) getDelegate();

			DataPackage pack = delegate.doQuery(listVO, user);

			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, pack);
		} catch (BusinessException e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
		} catch (Exception e) {
			throw e;
		}
		return (actionMapping.findForward("list"));
	}

	/**
	 * 编辑
	 */
	protected ActionForward doEdit(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		getContentVO(request, user, actionForm);
		((OperationForm) actionForm).setSelectcity(getOpnstr(
				((OperationForm) actionForm).getOpnid(), "CITY", user));
		((OperationForm) actionForm).setSelectexesys(getOpnstr(
				((OperationForm) actionForm).getOpnid(), "EXESYS", user));
		((OperationForm) actionForm).setSelectstar(getOpnstr(
				((OperationForm) actionForm).getOpnid(), "STAR", user));

		String command = getCommandString(request);
		((BaseActionForm) actionForm).setCmdState(command);
		request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE,
				WebConstant.COMMAND_STRING_EDIT);
		return (actionMapping.findForward("content"));
	}

	protected String[] getOpnstr(String opnid, String loadtype, User user)
			throws Exception {
		BusiloadDelegate loaddelegate = new BusiloadDelegate();

		BusiloadListVO loadlistvo = new BusiloadListVO();
		loadlistvo.set_se_opnid(opnid);
		loadlistvo.set_se_loadtype(loadtype);
		loadlistvo.set_pagesize(null);
		DataPackage dp = loaddelegate.doQuery(loadlistvo, user);
		String[] rtn = new String[dp.getDatas().size()];
		int i = 0;

		for (Iterator it = dp.getDatas().iterator(); it.hasNext(); i++) {
			BusiloadVO vo = (BusiloadVO) it.next();
			rtn[i] = vo.getLoadinfo();
		}
		return rtn;
	}

	protected ArrayList getaddrount(String exesys[], String region[],
			String starlevel[], String opnid, User user) throws Exception {
		ArrayList list = new ArrayList();
		BusiloadDelegate loaddelegate = new BusiloadDelegate();
		// 得到当前全省统一标识下的各类加载信息
		BusiloadListVO loadlistvo = new BusiloadListVO();
		loadlistvo.set_se_opnid(opnid);
		loadlistvo.set_se_loadtype("EXESYS");
		loadlistvo.set_pagesize(null);
		DataPackage exesysdp = loaddelegate.doQuery(loadlistvo, user);
		String[] dbexesys = new String[exesysdp.getDatas().size()];
		int exesysindex = 0;
		for (Iterator exesysit = exesysdp.getDatas().iterator(); exesysit
				.hasNext(); exesysindex++) {
			BusiloadVO exesysvo = (BusiloadVO) exesysit.next();
			dbexesys[exesysindex] = exesysvo.getLoadinfo();

		}

		loadlistvo.set_se_loadtype("CITY");
		DataPackage citydp = loaddelegate.doQuery(loadlistvo, user);
		String[] dbcity = new String[citydp.getDatas().size()];
		int cityindex = 0;
		for (Iterator cityit = citydp.getDatas().iterator(); cityit.hasNext(); cityindex++) {
			BusiloadVO cityvo = (BusiloadVO) cityit.next();
			dbcity[cityindex] = cityvo.getLoadinfo();
		}

		loadlistvo.set_se_loadtype("STAR");
		DataPackage stardp = loaddelegate.doQuery(loadlistvo, user);
		String[] dbstar = new String[stardp.getDatas().size()];
		int starindex = 0;
		for (Iterator starit = stardp.getDatas().iterator(); starit.hasNext(); starindex++) {
			BusiloadVO starvo = (BusiloadVO) starit.next();
			dbstar[starindex] = starvo.getLoadinfo();
		}

		// 将修改后的数据与数据库中的记录进行比对
		int exesyslength = exesys == null ? 0 : exesys.length;
		for (int i = 0; i < exesyslength; i++) {
			boolean flag = false;
			String loadinfo = exesys[i];
			for (int j = 0; j < dbexesys.length; j++) {
				if (dbexesys[j].equals(exesys[i])) {
					flag = true;
				} else {
					loadinfo = exesys[i];
				}
			}
			if (!flag) {
				BusiloadVO createvo = new BusiloadVO();
				createvo.setOpnid(opnid);
				createvo.setLoadtype("EXESYS");
				createvo.setLoadinfo(loadinfo);
				list.add(createvo);
			}
		}
		// -----------业务加载地市------------------

		// 将修改后的数据与数据库中的记录进行比对
		int regionlength = region == null ? 0 : region.length;
		for (int i = 0; i < regionlength; i++) {
			boolean flag = false;
			String loadinfo = region[i];
			for (int j = 0; j < dbcity.length; j++) {
				if (dbcity[j].equals(region[i])) {
					flag = true;

				} else {
					loadinfo = region[i];
				}
			}
			if (!flag) {
				BusiloadVO createvo = new BusiloadVO();
				createvo.setOpnid(opnid);
				createvo.setLoadtype("CITY");
				createvo.setLoadinfo(loadinfo);
				list.add(createvo);
			}
		}
		// ----------业务加载星级-------------------

		// 将修改后的数据与数据库中的记录进行比对
		int starlevellength = starlevel == null ? 0 : starlevel.length;
		for (int i = 0; i < starlevellength; i++) {
			boolean flag = false;
			String loadinfo = starlevel[i];
			for (int j = 0; j < dbstar.length; j++) {
				if (dbstar[j].equals(starlevel[i])) {
					flag = true;

				} else {
					loadinfo = starlevel[i];
				}
			}
			if (!flag) {
				BusiloadVO createvo = new BusiloadVO();
				createvo.setOpnid(opnid);
				createvo.setLoadtype("STAR");
				createvo.setLoadinfo(loadinfo);
				list.add(createvo);
			}
		}

		return list;
	}

	protected ArrayList getdelrount(String exesys[], String region[],
			String starlevel[], String opnid, User user) throws Exception {
		ArrayList list = new ArrayList();
		BusiloadDelegate loaddelegate = new BusiloadDelegate();

		// 得到当前全省统一标识下的各类加载信息
		BusiloadListVO loadlistvo = new BusiloadListVO();
		loadlistvo.set_se_opnid(opnid);
		loadlistvo.set_se_loadtype("EXESYS");
		DataPackage exesysdp = loaddelegate.doQuery(loadlistvo, user);
		String[] dbexesys = new String[exesysdp.getDatas().size()];
		int exesysindex = 0;
		for (Iterator exesysit = exesysdp.getDatas().iterator(); exesysit
				.hasNext(); exesysindex++) {
			BusiloadVO exesysvo = (BusiloadVO) exesysit.next();
			dbexesys[exesysindex] = exesysvo.getLoadinfo();

		}
		loadlistvo.set_se_loadtype("CITY");
		loadlistvo.set_pagesize(null);
		DataPackage citydp = loaddelegate.doQuery(loadlistvo, user);
		String[] dbcity = new String[citydp.getDatas().size()];
		int cityindex = 0;
		for (Iterator cityit = citydp.getDatas().iterator(); cityit.hasNext(); cityindex++) {
			BusiloadVO cityvo = (BusiloadVO) cityit.next();
			dbcity[cityindex] = cityvo.getLoadinfo();
		}

		loadlistvo.set_se_loadtype("STAR");
		DataPackage stardp = loaddelegate.doQuery(loadlistvo, user);
		String[] dbstar = new String[stardp.getDatas().size()];
		int starindex = 0;
		for (Iterator starit = stardp.getDatas().iterator(); starit.hasNext(); starindex++) {
			BusiloadVO starvo = (BusiloadVO) starit.next();
			dbstar[starindex] = starvo.getLoadinfo();
		}

		// --------业务执行系统字段处理--------------
		// 对数据库中的记录与修改后的数据进行比对
		for (int i = 0; i < dbexesys.length; i++) {
			boolean flag = false;
			if (exesys != null) {
				for (int j = 0; j < exesys.length; j++) {
					if (dbexesys[i].equals(exesys[j])) {
						flag = true;

					}
				}
			}
			if (!flag) {
				BusiloadVO removevo = new BusiloadVO();
				removevo.setOpnid(opnid);
				removevo.setLoadtype("EXESYS");
				removevo.setLoadinfo(dbexesys[i]);
				list.add(removevo);
			}
		}

		// -----------业务加载地市------------------
		// 对数据库中的记录与修改后的数据进行比对
		for (int i = 0; i < dbcity.length; i++) {
			boolean flag = false;
			if (region != null) {
				for (int j = 0; j < region.length; j++) {
					if (dbcity[i].equals(region[j])) {
						flag = true;
					}
				}
			}
			if (!flag) {
				BusiloadVO removevo = new BusiloadVO();
				removevo.setOpnid(opnid);
				removevo.setLoadtype("CITY");
				removevo.setLoadinfo(dbcity[i]);
				list.add(removevo);
			}
		}

		// ----------业务加载星级-------------------
		// 对数据库中的记录与修改后的数据进行比对
		for (int i = 0; i < dbstar.length; i++) {
			boolean flag = false;
			if (starlevel != null) {
				for (int j = 0; j < starlevel.length; j++) {
					if (dbstar[i].equals(starlevel[j])) {
						flag = true;
					}
				}
			}
			if (!flag) {
				BusiloadVO removevo = new BusiloadVO();
				removevo.setOpnid(opnid);
				removevo.setLoadtype("STAR");
				removevo.setLoadinfo(dbstar[i]);
				list.add(removevo);
			}
		}
		return list;
	} 
}
