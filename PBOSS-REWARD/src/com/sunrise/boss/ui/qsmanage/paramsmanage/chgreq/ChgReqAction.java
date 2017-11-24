/**
 * auto-generated code
 * Fri Jul 11 10:08:50 CST 2008
 */
package com.sunrise.boss.ui.qsmanage.paramsmanage.chgreq;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.fee.qsmanage.common.utils.QsUtils;
import com.sunrise.boss.business.qsmanage.paramsmanage.chghis.persistent.ChgHisListVO;
import com.sunrise.boss.business.qsmanage.paramsmanage.chghis.persistent.ChgHisVO;
import com.sunrise.boss.business.qsmanage.paramsmanage.chgreq.persistent.ChgReqListVO;
import com.sunrise.boss.business.qsmanage.paramsmanage.chgreq.persistent.ChgReqVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.common.utils.export.ExcelCodeToName;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.delegate.qsmanage.paramsmanage.chgreq.ChgReqDelegate;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>
 * Title: ChgReqAction
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
 * @author
 * @version 1.0
 */
public class ChgReqAction extends BaseAction {
	public ChgReqAction() {
		this.voClass = ChgReqVO.class;
		this.pkNameArray = new String[] { "reqid" };
	}

	public ActionForward doSave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			ChgReqVO contentVO = new ChgReqVO();
			setSaveVO(contentVO, actionForm);
			String oprt = request.getParameter("OPRT");
			Long oprstate = new Long(oprt);
			contentVO.setOprstate(oprstate);
			contentVO.setOprtime(new Date(System.currentTimeMillis()));
			contentVO.setOprcode(user.getOpercode());
			ChgReqDelegate dt = new ChgReqDelegate();
			dt.doUpdate((ChgReqVO) contentVO, user);
			BeanUtils.copyProperties(actionForm, contentVO);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "审批操作成功!");
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
					"审批操作失败,错误代码:" + e.getMessage());
		}
		return (actionMapping.findForward("content"));
	}

	public ActionForward doBatch(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			Long oprstate = Long.valueOf(request.getParameter("OPRT"));
			ChgReqVO contentVO = new ChgReqVO();
			setSaveVO(contentVO, actionForm);
			if(contentVO.getOprstate().intValue() == 4 && oprstate.intValue() != 3){
				throw new Exception("审批状态为4：审批不通过的请求只能做撤消变更操作！！");
			}
			contentVO.setOprstate(oprstate); 
			contentVO.setOprtime(new Date(System.currentTimeMillis()));
			contentVO.setOprcode(user.getOpercode());
			ChgReqDelegate dt = new ChgReqDelegate();
			dt.doBatch((ChgReqVO) contentVO, user);
			BeanUtils.copyProperties(actionForm, contentVO);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
					"批量审批操作成功!！");
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
					"批量审批失败,错误代码:" + e.getMessage());
		}
		return (actionMapping.findForward("batchcontent"));
	}

	public ActionForward doEdit(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		ChgReqForm form = (ChgReqForm) actionForm;
		getContentVO(request, user, form);
		String command = getCommandString(request);
		((BaseActionForm) actionForm).setCmdState(command);
		request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE,
				WebConstant.COMMAND_STRING_EDIT);

		ExcelCodeToName et = new ExcelCodeToName();
		form.setTabnamestr(et.codeToName("#QS_TABLENAME", form.getTabname(),
				user));
		form.setMainkeystr(et.codeToName("#QS_MAINKEYSTR", form.getTabname(),
				user)); 
		request.setAttribute("tabname", form.getTabname());
		return (actionMapping.findForward("content"));
	}

	public ActionForward doShowdeta(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		Page.setPageSize(request, (BaseActionForm) actionForm);
		Long reqid = new Long(request.getParameter("reqid"));
		CommonDelegate delegate = new CommonDelegate(ChgHisVO.class);
		ChgHisListVO listVO = new ChgHisListVO();
		listVO.set_ne_reqid(reqid.toString());
		DataPackage dp = delegate.doQuery(listVO, user);
		ChgHisVO vo = (ChgHisVO) dp.toList(ChgHisVO.class).get(0);
		List list = QsUtils.getDetaList(vo, user);
		request.setAttribute("tabname", vo.getTabname());
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, list);
		return (actionMapping.findForward("listdeta"));
	}

	public ActionForward doShowbatchdeta(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		
		Page.setPageSize(request, (BaseActionForm) actionForm);
		
		ChgReqForm form = (ChgReqForm) actionForm;
		CommonDelegate delegate = new CommonDelegate(ChgReqVO.class);
		if(form.getReqidstr() == null || "".equals(form.getReqidstr())){
			Long matchid = new Long(request.getParameter("matchid"));
			String tabcode = request.getParameter("tabcode");
			ChgReqListVO listVO = new ChgReqListVO();
			listVO.set_ne_matchid(matchid.toString());
			listVO.set_se_tabname(tabcode);
			DataPackage dp = delegate.doQuery(listVO, user);
			StringBuffer reqstr = new StringBuffer();
			for(int i = 0 ; i < dp.getDatas().size() ; i++){
				ChgReqVO reqvo = (ChgReqVO) dp.toList(ChgReqVO.class).get(i);
				reqstr.append(reqvo.getReqid().toString()).append("~");
			}
			form.setReqidstr(reqstr.toString());
		}
		
		String[] reqids = form.getReqidstr().split("~");
		CommonDelegate hisdele = new CommonDelegate(ChgHisVO.class);
		ChgHisListVO hislist = new ChgHisListVO();
		int index = Integer.valueOf(form.get_pageno()).intValue();
		hislist.set_ne_reqid(reqids[index - 1]);
		DataPackage hisdp = hisdele.doQuery(hislist, user, false);
		ChgHisVO vo = (ChgHisVO) hisdp.toList(ChgHisVO.class).get(0);
		List list = QsUtils.getDetaList(vo, user);
		//构建一个dp来虚拟分页显示====start====
		DataPackage listdp = new DataPackage();
		listdp.setDatas(list);
		listdp.setPageNo(Integer.valueOf(form.get_pageno()).intValue());
		listdp.setPageSize(Integer.valueOf(form.get_pagesize()).intValue());
		listdp.setRowCount(reqids.length * Integer.valueOf(form.get_pagesize()).intValue());
		//虚拟分页显示===============end======
		
		request.setAttribute("tabname", vo.getTabname());
		ChgReqVO reqvodis = (ChgReqVO) delegate.doFindByPk(new Long(reqids[index - 1]), user) ;
		request.setAttribute("oprstate", reqvodis.getOprstate().toString());
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, listdp);
		return (actionMapping.findForward("listbatchdeta"));
	}
	
	
	public ActionForward doShowbatch(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			Page.setPageSize(request, (BaseActionForm) actionForm);
			
			ChgReqForm form = (ChgReqForm) actionForm;
			Long matchid = new Long(request.getParameter("matchid"));
			CommonDelegate delegate = new CommonDelegate(ChgReqVO.class);
			ChgReqListVO listVO = new ChgReqListVO();
				
			listVO.set_ne_matchid(matchid.toString());
			listVO.set_pagesize("0");
			DataPackage dp = delegate.doQuery(listVO, user);
			HashMap hashmap = new HashMap();
			List list = null; 
			
			if(dp == null || dp.getDatas() == null || dp.getDatas().size() == 0){
				throw new Exception("此关联标识" + matchid.toString() + "没有对应的参数变更请求！！");
			}else{
				list = dp.toList(ChgReqVO.class);
			}
			
			for(int i = 0 ; i < list.size() ; i++){
				ChgReqVO vo = (ChgReqVO) list.get(i);
				if(!hashmap.containsKey(vo.getTabname())){//如果map中没有对应的申请记录
					ChgReqInf inf = new ChgReqInf();
					inf.setTabcode(vo.getTabname());
					inf.setOprtype(vo.getOprtype());
					inf.setCount(1);
					inf.setMatchid(vo.getMatchid()); 
					
					hashmap.put(vo.getTabname(), inf);
				}else{//如果map中有对应的申请记录，则把count加1
					ChgReqInf info = (ChgReqInf) hashmap.get(vo.getTabname());
					info.setCount(info.getCount() + 1);
				}
			}
			DataPackage infodp = new DataPackage();
			Collection datas = new ArrayList();
			infodp.setDatas(datas);
			
			Iterator it = hashmap.keySet().iterator();
			while(it.hasNext()){
				String tabcode = it.next().toString();
				ChgReqInf obj = (ChgReqInf) hashmap.get(tabcode);
				infodp.getDatas().add(obj);
			}
			infodp.setPageNo(Integer.valueOf(form.get_pageno()).intValue());
			infodp.setPageSize(hashmap.keySet().size());
			infodp.setRowCount(hashmap.keySet().size());
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, infodp);
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.getMessage());
		}
		
		return actionMapping.findForward("listbatch");
	}
	
	
	public ActionForward doBatchdis(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		String[] selectArray = ((BaseActionForm) actionForm).get_selectitem();
		CommonDelegate delegate = new CommonDelegate(ChgReqVO.class);
		ChgReqVO vo = (ChgReqVO) delegate.doFindByPk(new Long(selectArray[0]), user);
		BeanUtils.copyProperties(actionForm, vo);
		return actionMapping.findForward("batchcontent");
	}
}
