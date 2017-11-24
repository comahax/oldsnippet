package com.sunrise.boss.ui.commons.combineinput;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.common.combineinput.persistent.CombineinputListVO;
import com.sunrise.boss.business.common.combineinput.persistent.CombineinputVO;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: CombineinputAction </p>
 * <p>Description: 联动下拉框动作控制Action </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: Sunrise Tech Ltd.</p>
 * @author Zhang Fengchao
 * @since 1.0
 * @version 1.0
 * @date 2007-11-16
 */
public class CombineinputAction extends Action {
	public static String SINGLE_QUERY_LIMIT = "1000"; //单次查询结果数据限制
	public static int SINGLE_OUT_LIMIT = 50; //单次页面输出限制
	public static int LITTLE_LIMIT = 20; //差值限制
	
	public CombineinputAction() {
	}

	public ActionForward execute(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String cmd = request.getParameter(WebConstant.PAGE_ATTRIBUTE_COMMAND);
		try {
			if (cmd.equalsIgnoreCase("select")) {
				return doSelect(mapping, actionForm, request, response);
			} else if (cmd.equalsIgnoreCase("change")) {
				return doChange(mapping, actionForm, request, response);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex
					.getMessage());
		}
		return (mapping.findForward("success"));
	}

	//初始化
	public ActionForward doSelect(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		CombineinputForm cform=(CombineinputForm)actionForm;
		String return_page="success";
		request.getParameter(CombineinputConstant.DEFINITION);
		try {
			User user = (User) request.getSession().getAttribute(WebConstant.SESSION_ATTRIBUTE_USER);
			String definition = (String) request.getParameter(CombineinputConstant.DEFINITION);
			String originalStr = (String) request.getParameter(CombineinputConstant.ORIGINAL_STR);
			ConfigBean cfg = ConfigMap.getConfigBean(definition);
			String extend1 = (String) request.getParameter("EXTEND1");
			if(cfg.getReturn_page()!=null && !cfg.getReturn_page().equals("")){
				return_page=cfg.getReturn_page();
			}
			String[] originalArray = null;
			if (null != originalStr && originalStr.trim().length() > 0 &&
					!"NULL".equalsIgnoreCase(originalStr.trim())) {
				//String tempStr=new String(originalStr.getBytes("ISO-8859-1"));
				originalArray = splitData(originalStr,cfg.getSymbol_tail(),user);
			}
			request.setAttribute(CombineinputConstant.ORIGINAL_ARRAY, originalArray);
			
			request.setAttribute(CombineinputConstant.DEFINITION, definition);
			request.setAttribute(CombineinputConstant.TITLE, cfg.getTitle());
			request.setAttribute(CombineinputConstant.TYPENAME1, cfg.getTypename1());
			request.setAttribute(CombineinputConstant.TYPENAME2, cfg.getTypename2());
			request.setAttribute(CombineinputConstant.DESCRIPTION, cfg.getDescription());
			request.setAttribute(CombineinputConstant.RELATEFLAG, "" + cfg.isRelateflag());
			request.setAttribute(CombineinputConstant.SYMBOL_MID, cfg.getSymbol_mid());
			request.setAttribute(CombineinputConstant.SYMBOL_TAIL, cfg.getSymbol_tail());
			request.setAttribute("EXTEND1", extend1);
			
			CombineinputListVO listVO = new CombineinputListVO();
			listVO.set_pagesize(SINGLE_QUERY_LIMIT);
			listVO.set_se_extend1(extend1);
			List type1_session = getDatas(listVO, user, definition, CombineinputConstant.TARGET_TYPE1);
			request.getSession().setAttribute(CombineinputConstant.COLLECTION_TYPE1_SESSION, type1_session);
			List type2_session = getDatas(listVO, user, definition, CombineinputConstant.TARGET_TYPE2);
			request.getSession().setAttribute(CombineinputConstant.COLLECTION_TYPE2_SESSION, type2_session);
			
			List type1_out = reformDatas(type1_session, "", "", SINGLE_OUT_LIMIT);
			List type2_out = reformDatas(type2_session, "", "", SINGLE_OUT_LIMIT);
			request.setAttribute(CombineinputConstant.COLLECTION_TYPE1_OUT, type1_out);
			request.setAttribute(CombineinputConstant.COLLECTION_TYPE2_OUT, type2_out);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.getMessage());
		}
		return mapping.findForward(return_page);
	}
	
	//数据交互
	public ActionForward doChange(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try {
			User user = (User) request.getSession().getAttribute(WebConstant.SESSION_ATTRIBUTE_USER);
			List type1_session = (List) request.getSession().getAttribute(CombineinputConstant.COLLECTION_TYPE1_SESSION);
			List type2_session = (List) request.getSession().getAttribute(CombineinputConstant.COLLECTION_TYPE2_SESSION);
			
			String definition = (String) request.getParameter(CombineinputConstant.DEFINITION);
			String prefix_type1 = new String(request.getParameter(CombineinputConstant.PREFIX_TYPE1).getBytes("iso8859_1"));
			String prefix_type2 = new String(request.getParameter(CombineinputConstant.PREFIX_TYPE2).getBytes("iso8859_1"));
			String upid = (String) request.getParameter(CombineinputConstant.UPID);
			String target = (String) request.getParameter(CombineinputConstant.TARGET);
			String extend1 = (String) request.getParameter("EXTEND1");
			prefix_type1 = (prefix_type1 == null)? "":prefix_type1;
			prefix_type2 = (prefix_type2 == null)? "":prefix_type2;
			
			List outCollection = null;
			if (CombineinputConstant.TARGET_TYPE1.equals(target)) {
				outCollection = reformDatas(type1_session, prefix_type1, "", SINGLE_OUT_LIMIT);
				if (outCollection.size() < SINGLE_OUT_LIMIT - LITTLE_LIMIT) {
					CombineinputListVO listVO = new CombineinputListVO();
					listVO.set_ssw_id(prefix_type1);
					listVO.set_se_extend1(extend1);
					type1_session = getDatas(listVO, user, definition, target);
					if (null == type1_session || type1_session.size() == 0) { //if match id nothing, match name
						listVO.set_ssw_id("");
						listVO.set_ssw_name(prefix_type1);
						type1_session = getDatas(listVO, user, definition, target);
					}
					request.getSession().setAttribute(CombineinputConstant.COLLECTION_TYPE1_SESSION, type1_session);
					outCollection = reformDatas(type1_session, prefix_type1, "", SINGLE_OUT_LIMIT);
				}
			} else if (CombineinputConstant.TARGET_TYPE2.equals(target)) {
				outCollection = reformDatas(type2_session, prefix_type2, upid, SINGLE_OUT_LIMIT);
				if (outCollection.size() < SINGLE_OUT_LIMIT - LITTLE_LIMIT) {
					CombineinputListVO listVO = new CombineinputListVO();
					listVO.set_ssw_id(prefix_type2);
					listVO.set_se_upid(upid);
					listVO.set_se_extend1(extend1);
					type2_session = getDatas(listVO, user, definition, target);
					if (null == type2_session || type2_session.size() == 0) { //if match id nothing, match name
						listVO.set_ssw_id("");
						listVO.set_ssw_name(prefix_type2);
						listVO.set_se_extend1(extend1);
						type2_session = getDatas(listVO, user, definition, target);
					}
					request.getSession().setAttribute(CombineinputConstant.COLLECTION_TYPE2_SESSION, type2_session);
					outCollection = reformDatas(type2_session, prefix_type2, upid, SINGLE_OUT_LIMIT);
				}
			} else {
				outCollection = new ArrayList(0);
			}
			
			if (outCollection.size() == 0) {
				return null;
			}
			
			//XML输出流
	        response.setContentType("text/xml; charset=GBK");
	        response.setHeader("Cache-Control","no-cache");
			PrintWriter out = response.getWriter();
			out.println("<?xml version=\"1.0\" encoding=\"gb2312\"?>");
			out.println("<multi-selectlist>");
			for(Iterator iter = outCollection.iterator(); iter.hasNext();) {
				CombineinputVO data = (CombineinputVO) iter.next();
				if (null == data || null == data.getId()) {
					continue;
				}
				String id = data.getId().trim();
				String name = "";
				if (null != data.getName()) {
					name = data.getName().trim();
				}
				
				StringBuffer line = scrabbleData(id,name);
	        	out.println(line.toString());
			}
			out.println("</multi-selectlist>");
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.getMessage());
		}
		return null;
	}
	//将数据的ID和NAME拼凑为界面显示的格式
	protected StringBuffer scrabbleData(String id,String name){
		StringBuffer line =new StringBuffer("");
    	line.append("<select>");
    	line.append("<value>");
    	line.append(id);
    	line.append("</value>");
    	line.append("<text>");
    	line.append(id + " " + name);
    	line.append("</text>");
    	line.append("</select>");
    	return line;
	}
	
	//数据重组
	public List reformDatas(List list, String prefix, String upid, int limit) {
		try {
			if (null == list || list.size() == 0) {
				return new ArrayList(0);
			}
			
			List retList = new ArrayList();
			retList.addAll(list);
			Collections.sort(retList);
			
			boolean prefixMatch = false;
			if (null != prefix && prefix.trim().length() > 0) {
				prefixMatch = true;
			}
			
			boolean upidMatch = false;
			if (null != upid && upid.trim().length() > 0) {
				upidMatch = true;
			}
			
			if (!prefixMatch && !upidMatch) { //no prefix && no upid
				if (retList.size() > limit) {
					retList = retList.subList(0, limit);
				}
				return retList;
			}
			
			//Match prefix and upid
			List retList2 = new ArrayList();
			for(Iterator iter = retList.iterator(); iter.hasNext();) {
				CombineinputVO data = (CombineinputVO) iter.next();
				if (null == data || null == data.getId()) {
					continue;
				}
				if (null == data.getName()) {
					data.setName("");
				}
				if (upidMatch && !upid.trim().equals(data.getUpid())) {
					continue;
				}
				if (prefixMatch) {
					if (!data.getId().startsWith(prefix.trim()) && !data.getName().startsWith(prefix.trim()) ) {
						continue;
					}
				}
				
				retList2.add(data);
			}
			
			if (retList2.size() > limit) {
				retList2 = retList2.subList(0, limit);
			}
			
			return retList2;
		} catch(Exception ex) {
			ex.printStackTrace();
			return new ArrayList(0);
		}
	}
	
	// 查询库表获取数据
	public List getDatas(CombineinputListVO listVO, User user,
			String definition, String target) throws Exception {
		listVO.set_pagesize(SINGLE_QUERY_LIMIT);
		if (listVO.get_ssw_id().trim().length() > 0 || listVO.get_ssw_name().trim().length() > 0) {
			listVO.set_orderby(CombineinputConstant.ORDERBY_ID);
		}
		
		SelectsData selectsData = SelectsDataFactory.build(definition);
		List retList = new ArrayList();
		if (CombineinputConstant.TARGET_TYPE1.equals(target)) {
			retList = selectsData.getType1Collection(listVO, user);
		} else if (CombineinputConstant.TARGET_TYPE2.equals(target)) {
			retList = selectsData.getType2Collection(listVO, user);
		}

		return retList;
	}
	//拆分界面上的数据并按指定格式显示
	protected String[] splitData(String originalStr,String symbol,User user)throws Exception{
		String[] array=null;
		if(originalStr!=null && !originalStr.equals("")){
			array=originalStr.split(symbol);
		}else{
			return new String[0];
		}
		return array;
	}
}
