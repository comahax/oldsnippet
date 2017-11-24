/**
* auto-generated code
* Sat Aug 26 10:46:06 CST 2006
*/
package com.sunrise.boss.ui.cms.waypro;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.bchcontact.persistent.BchcontactListVO;
import com.sunrise.boss.business.cms.bchcontact.persistent.BchcontactVO;
import com.sunrise.boss.business.cms.way.persistent.WayListVO;
import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.business.cms.waycompact.persistent.WaycompactVO;
import com.sunrise.boss.business.cms.waylog.persistent.WaylogVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.delegate.cms.waylog.WaylogDelegate;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: WayseatdetAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
public class WayproAction extends BaseDelegateAction {
	
    public WayproAction() {
           //以下几个方法是必须的 
           //指定VO类 
            setVoClass(WayVO.class);
            //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称 
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "wayid"; 
    }
    
	public ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		Page.setPageSize(request, (BaseActionForm)actionForm);
		try{
			WayproForm form = (WayproForm)actionForm;
			CommonDelegate delegate = new CommonDelegate(WayVO.class);
			WayListVO listvo = new WayListVO();
			setListVO(listvo, form);
			
			List waySubtypeList = new ArrayList();
			waySubtypeList.add("UNPB");
			waySubtypeList.add("DIS");
			
			List upperwayidList = new ArrayList();
			upperwayidList.add("UNPB-----");
			upperwayidList.add("DIS-----");
			
			listvo.getQueryConditions().put("_se_waytype", "AG");
			listvo.getQueryConditions().put("_sin_waysubtype", waySubtypeList);
			listvo.getQueryConditions().put("_sin_upperwayid", upperwayidList);
			
			DataPackage dp = delegate.doQuery(listvo, user);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		}catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.getMessage());
		}
		return actionMapping.findForward("list");
	}
	
	public ActionForward doNew(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		WayproForm form = (WayproForm)actionForm;
		form.setWaystate(new Short("1"));
		form.setSignstatus(new Long("0"));
		form.setStarttime(new Date());
		return super.doNew(actionMapping, form, request, response, user);
	}
  
	public ActionForward doDelete(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		String[] selectArray = ((BaseActionForm) actionForm).get_selectitem();
		CommonDelegate delegate = new CommonDelegate(WayVO.class);
		for(int i=0;i<selectArray.length;i++){
			WayVO vo = (WayVO)delegate.doFindByPk(selectArray[i], user);
			if(vo.getWaystate().shortValue() == 1){
				vo.setWaystate(new Short("0"));
				delegate.doUpdate(vo, user);
			}
		}
		return this.doList(actionMapping, actionForm, request, response, user);
	}
	
	public ActionForward doExcel(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		CommonExportBean export = new CommonExportBean(user);
		export.setFileName("省级渠道信息管理");
		export.addOutputProperty("wayid");
		export.addOutputProperty("wayname");
		export.addOutputProperty("waysubtype", CommonExportBean.CODE2NAME,"#UNV_REWARDKIND");
		export.addOutputProperty("address");
		export.addOutputProperty("createtime",CommonExportBean.DATE,"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("waystate", CommonExportBean.CODE2NAME, "$CH_VALIDFLAG");
		export.addOutputProperty("signstatus", CommonExportBean.CODE2NAME, "$CH_SIGNSTATUS");

		export.addOutputProperty("starttime",CommonExportBean.DATE,"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("disabletime",CommonExportBean.DATE,"yyyy-MM-dd HH:mm:ss");

		export.voClassArray = new Class[] { WayVO.class };
		response.setHeader("pragma", "no-cache");
		response.setHeader("Cache-control", "public");
		response.setHeader("Expires", "01 Apr 1995 01:10:10 GMT");
		String fn = "attachment; filename=" + export.getFileName() + ".txt";
		response.setHeader("Content-Disposition", new String(
				fn.getBytes("GBK"), "ISO-8859-1"));
		response.setContentType("text/plain");
		export.writeTxtTitle(response.getOutputStream(), new String[] {
				"渠道编码", "渠道名称", "渠道子类型", "通讯地址", "注册日期", "渠道状态", "签约状态", "启用日期","停用日期"});
		super.ExportQuery(actionMapping, actionForm, request, response, user,
				export);
		return actionMapping.findForward(null);
	}
	
	public ActionForward doSave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		WayproForm form = (WayproForm)actionForm;
		
		CommonDelegate wDelegate = new CommonDelegate(WayVO.class);
		CommonDelegate bDelegate = new CommonDelegate(BchcontactVO.class);
		CommonDelegate wcDelegate = new CommonDelegate(WaycompactVO.class);
		
		WaylogDelegate wlogd= new WaylogDelegate();
		WaylogVO wlgovo=new WaylogVO();
		try{
			String cmdState = ((BaseActionForm) actionForm).getCmdState();
			if (WebConstant.COMMAND_STRING_EDIT.equals(cmdState)) {// 更新
				
				WayVO wVO = (WayVO) wDelegate.doFindByPk(form.getWayid(), user);
				BchcontactVO bVO = (BchcontactVO)bDelegate.doFindByPk(form.getWayid(), user);
				
				BchcontactListVO bListvo = new BchcontactListVO();
				bListvo.set_pagesize("0");
				bListvo.getQueryConditions().put("_se_principaltel", form.getPrincipaltel());
				bListvo.getQueryConditions().put("_sne_wayid", form.getWayid());
				if(bDelegate.doQuery(bListvo, user).getDatas() != null && bDelegate.doQuery(bListvo, user).getDatas().size() != 0){
					throw new Exception("负责人电话已经存在!");
				}
				if(bVO==null){
					
					bVO=new BchcontactVO();
				}
				
				BeanUtils.copyProperties(wVO, form);
				BeanUtils.copyProperties(bVO, form);
				//  做渠道的日志
				BeanUtils.copyProperties(wlgovo, form);
				wlgovo.setOprcode(user.getOpercode());
				wlgovo.setOptime(new Date());
				wlgovo.setOprtype("update");
				
				bVO.setLinkman(bVO.getPrincipal());
				bVO.setLinkmantel(bVO.getPrincipaltel());
				
				// 保存合同表的信息在专员导入时
				WaycompactVO  wcvo=new WaycompactVO();
				java.util.Date utilDate = new java.util.Date();   
				java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime()); 
				wcvo.setBegintime(sqlDate);
				wcvo.setSigntime(sqlDate);
				
				java.util.Date  date  =  new SimpleDateFormat("yyyy-MM-dd").parse("2099-09-09");      
				java.sql.Date  sqlDate1  =  new java.sql.Date(date.getTime());   
				wcvo.setEndtime(sqlDate1);
				
				wcvo.setWayid(form.getWayid());
				wcvo.setIsunpb(Short.valueOf("1"));
				wcvo.setCompactno("999999");
				wcvo.setCompactname("999999");

				WaycompactVO wcvo2 = (WaycompactVO) wcDelegate.doFindByPk(form.getWayid(), user);
				if(wcvo2==null){
					wcDelegate.doCreate(wcvo, user);
				}else{
					wcDelegate.doUpdate(wcvo, user);
				}
				//做渠道日志
				wlogd.doCreate(wlgovo, user);
				
				wDelegate.doUpdate(wVO, user);
				bDelegate.doUpdate(bVO, user);
				
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "保存成功!");
			}else{
				BchcontactListVO bListvo = new BchcontactListVO();
				bListvo.set_pagesize("0");
				bListvo.getQueryConditions().put("_se_principaltel", form.getPrincipaltel());
				if(bDelegate.doQuery(bListvo, user).getDatas() != null && bDelegate.doQuery(bListvo, user).getDatas().size() != 0){
					throw new Exception("负责人电话已经存在!");
				}
				
				bListvo.getQueryConditions().put("_se_wayid", form.getWayid());
				if(bDelegate.doQuery(bListvo, user).getDatas() != null && bDelegate.doQuery(bListvo, user).getDatas().size() != 0){
					throw new Exception("该渠道编码已经存在!");
				}
					
				WayListVO wListvo = new WayListVO();
				wListvo.set_pagesize("0");
				wListvo.getQueryConditions().put("_se_wayid", form.getWayid());
				if( wDelegate.doQuery(wListvo, user).getDatas() != null &&  wDelegate.doQuery(wListvo, user).getDatas().size() != 0){
					throw new Exception("该渠道编码已经存在!");
				}
				
				BchcontactVO bVO = new BchcontactVO();
				WayVO wVO = new WayVO();
				
				BeanUtils.copyProperties(bVO, form);
				BeanUtils.copyProperties(wVO, form);
				
				
				bVO.setLinkman(bVO.getPrincipal());
				bVO.setLinkmantel(bVO.getPrincipaltel());
				
				if("UNPB".equals(form.getWaysubtype())){
					wVO.setUpperwayid("UNPB-----");
				}else if("DIS".equals(form.getWaysubtype())){
					wVO.setUpperwayid("DIS-----");
				}
				
				wVO.setStarlevel(new Long("3"));
				wVO.setCityid("GD");
				wVO.setWaytype("AG");
				wVO.setCreatetime(new Date());
				
				//  做渠道的日志
				BeanUtils.copyProperties(wlgovo, form);
				wlgovo.setOprcode(user.getOpercode());
				wlgovo.setOptime(new Date());
				wlgovo.setOprtype("create");
				
				
				// 保存合同表的信息在专员导入时
				WaycompactVO  wcvo=new WaycompactVO();
				java.util.Date utilDate = new java.util.Date();   
				java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime()); 
				wcvo.setBegintime(sqlDate);
				wcvo.setSigntime(sqlDate);
				
				java.util.Date  date  =  new SimpleDateFormat("yyyy-MM-dd").parse("2099-09-09");      
				java.sql.Date  sqlDate1  =  new java.sql.Date(date.getTime());   
				wcvo.setEndtime(sqlDate1);
				
				wcvo.setWayid(form.getWayid());
				wcvo.setIsunpb(Short.valueOf("1"));
				wcvo.setCompactno("999999");
				wcvo.setCompactname("999999");

				WaycompactVO wcvo2 = (WaycompactVO) wcDelegate.doFindByPk(form.getWayid(), user);
				if(wcvo2==null){
					wcDelegate.doCreate(wcvo, user);
				}else{
					wcDelegate.doUpdate(wcvo, user);
				}
				
				// 做渠道日志
				wlogd.doCreate(wlgovo, user);
				bDelegate.doCreate(bVO, user);
				wDelegate.doCreate(wVO, user);
				
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "保存成功!");
			}
		}catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.getMessage());
			// TODO: handle exception
		}
		return (actionMapping.findForward("content"));
	}
	
	public ActionForward doEdit(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		WayproForm form = (WayproForm)actionForm;
		String pk = request.getParameter(WebConstant.REQUEST_ATTRIBUTE_PK);
		CommonDelegate wDelegate = new CommonDelegate(WayVO.class);
		CommonDelegate bDelegate = new CommonDelegate(BchcontactVO.class);

		BeanUtils.copyProperties(form, wDelegate.doFindByPk(pk, user));
		if(null!=bDelegate.doFindByPk(pk, user))
		BeanUtils.copyProperties(form, bDelegate.doFindByPk(pk, user));

		String command = getCommandString(request);
		((BaseActionForm) actionForm).setCmdState(command);
		request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, WebConstant.COMMAND_STRING_EDIT);
		return (actionMapping.findForward("content"));
	}
    
}
