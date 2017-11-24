package com.sunrise.boss.ui.zifee.yxplangroup;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.business.zifee.yxplangroup.persistent.YxPlanGroupListVO;
import com.sunrise.boss.business.zifee.yxplangroup.persistent.YxPlanGroupVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.delegate.zifee.yxplangroup.YxPlanGroupDelegate;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.boss.ui.commons.batch.upload.ICheckFormat;


/**
 * <p>
 * Title: YxPlanGroupAction
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
 * @author Danny(luozhoujie)
 * @version 1.0
 */
public class YxPlanGroupAction extends BaseDelegateAction {

	private static final String ADD = "ADD";

	private static final String DELETE = "DELETE";
	
	private static final String QUERY_GROUP="QUERY_GROUP";
	
	private static final String QUERY_MEM="QUERY_MEM";
	
	private static final String QUERY_ALL="QUERY_ALL";

	private DataPackage dp;

	public YxPlanGroupAction() {
		this.voClass = YxPlanGroupVO.class;
		// TODO: 给出主键的名字数组
		this.pkNameArray = new String[2];
		pkNameArray[0] = "memyxplan";
		pkNameArray[1] = "groupyxplan";
	}

	public ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		YxPlanGroupForm form = (YxPlanGroupForm) actionForm;
		Page.setPageSize(request, form);

		String pk = "";
		if (form.getGroupyxplan() == null) {
			pk = request.getParameter(WebConstant.REQUEST_ATTRIBUTE_PK);
		} else {
			pk = form.getGroupyxplan().toString();
		}
		form.setGroupyxplan(new Long(pk));

		YxPlanGroupListVO listVO = new YxPlanGroupListVO();
		com.sunrise.boss.common.utils.bean.BeanUtils.copyProperties(listVO,
				form);
		listVO.set_ne_groupyxplan(form.getGroupyxplan().toString());

		YxPlanGroupDelegate delegate = new YxPlanGroupDelegate();

		DataPackage dp = delegate.doQueryByGroup(listVO, user);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		return (actionMapping.findForward("list"));
	}

	public void onDuplicatePk(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) {
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
				"已经存在相同编码营销方案组标识和成员营销方案标识, 请输入其他成员营销方案标识");
	}

	/**
	 * 批量导入营销方案分组
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 * @author added by yijianrong
	 */
	public ActionForward doBatch(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {

		return (actionMapping.findForward("batch"));
	}

	/**
	 * 批量新增营销方案组的成员(新增)
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 * @author added by yijianrong
	 */
	public ActionForward doBatchadd(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {

		YxPlanGroupForm form = (YxPlanGroupForm) actionForm;
		FormFile inputFile = form.getInputFile();
		ICheckFormat iCheckFormat = new YxplanGroupCheck(YxPlanGroupAction.ADD);
		// 检查文件类型大小,表单数据类型等
		if (inputFile == null || inputFile.getFileSize() == 0) {
			form.setReInfo("上传文件不能为空");
			return (actionMapping.findForward("batch"));
		}
		iCheckFormat.checkFile(inputFile, null);
		// 检查文件每行格式
		String result = batchDisposal(inputFile, iCheckFormat,
				YxPlanGroupAction.ADD, user);
		form.setReInfo(result);
		return (actionMapping.findForward("batch"));
	}

	/**
	 * 上传并处理批量营销方案文件（删除）
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user5
	 * @return
	 * @throws Exception
	 * @author added by yijianrong
	 */
	public ActionForward doBatchdelete(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		YxPlanGroupForm form = (YxPlanGroupForm) actionForm;
		FormFile inputFile = form.getInputFile();
		ICheckFormat iCheckFormat = new YxplanGroupCheck(
				YxPlanGroupAction.DELETE);
		// 检查文件类型大小,表单数据类型等
		if (inputFile == null || inputFile.getFileSize() == 0) {
			form.setReInfo("上传文件不能为空");
			return (actionMapping.findForward("batch"));
		}
		iCheckFormat.checkFile(inputFile, null);
		// 检查文件每行格式
		String result = batchDisposal(inputFile, iCheckFormat,
				YxPlanGroupAction.DELETE, user);
		form.setReInfo(result);
		return (actionMapping.findForward("batch"));
	}

	/**
	 * 上传并处理批量营销方案文件（删除）
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 * @author added by yijianrong
	 */
	// public ActionForward doUpload(ActionMapping actionMapping,
	// ActionForm actionForm, HttpServletRequest request,
	// HttpServletResponse response, User user) throws Exception {
	// }
	/**
	 * 上传并处理批量营销方案文件（根据营销方案组标识查询）
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 * @author added by Linli
	 */
	public ActionForward doBatchquerygroup(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		YxPlanGroupForm form = (YxPlanGroupForm) actionForm;
		FormFile inputFile = form.getInputFile();
		ICheckFormat iCheckFormat = new YxplanGroupCheck(
				YxPlanGroupAction.QUERY_GROUP);
		// 检查文件类型大小,表单数据类型等
		if (inputFile == null || inputFile.getFileSize() == 0) {
			form.setReInfo("上传文件不能为空");
			return (actionMapping.findForward("batch"));
		}
		iCheckFormat.checkFile(inputFile, null);
		// 检查文件每行格式
		String result = batchDisposal(inputFile, iCheckFormat,
				YxPlanGroupAction.QUERY_GROUP, user);
		if(result.startsWith("第")){
			form.setReInfo(result);
		}else{
			form.setReInfo("查询成功");
			doExport(actionMapping, actionForm, request, response, user,this.QUERY_GROUP);
		}
		return (actionMapping.findForward("batch"));
	}
	//批量查询(根据营销方案组标识)
	public void doExport(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user,String type) throws Exception {
		CommonExportBean export = new CommonExportBean(user);
		if(type.equals(this.QUERY_GROUP))
			export.setFileName("批量查询(根据营销方案组标识)结果");
		else if(type.equals(this.QUERY_MEM))
			export.setFileName("批量查询(根据营销方案标识)结果");
		else 
			export.setFileName("全量查询结果");
		export.queryMethodName = "";
		export.addOutputProperty("groupyxplan");
		export.addOutputProperty("groupname");
		export.addOutputProperty("memyxplan");
		export.addOutputProperty("yxplanname");
		
		response.setCharacterEncoding("GBK");
		response.setHeader("pragma", "no-cache");
		response.setHeader("Cache-control", "public");
		response.setHeader("Expires", "01 Apr 1995 01:10:10 GMT");
		String fn = "attachment; filename=" + export.getFileName() + ".txt";
		response.setHeader("Content-Disposition", new String(
				fn.getBytes("GBK"), "ISO-8859-1"));
		response.setContentType("text/plain;charset=gbk");
		export.writeTxtTitle(response.getOutputStream(), new String[] {
				"营销方案组标识", "分组名称", "营销方案标识", "营销方案名称","" });
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		if(dp.getDatas().size()>0){
			this.ExportQuery(actionMapping, actionForm, request, response, user,
					export);
		}else{
			response.getOutputStream().flush();
		}
	}
	/**
	 * 上传并处理批量营销方案文件（根据营销方案组标识查询）
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 * @author added by Linli
	 */
	public ActionForward doBatchquerymem(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		YxPlanGroupForm form = (YxPlanGroupForm) actionForm;
		FormFile inputFile = form.getInputFile();
		ICheckFormat iCheckFormat = new YxplanGroupCheck(
				YxPlanGroupAction.QUERY_MEM);
		// 检查文件类型大小,表单数据类型等
		if (inputFile == null || inputFile.getFileSize() == 0) {
			form.setReInfo("上传文件不能为空");
			return (actionMapping.findForward("batch"));
		}
		
			iCheckFormat.checkFile(inputFile, null);
		
		// 检查文件每行格式
		String result = batchDisposal(inputFile, iCheckFormat,
				YxPlanGroupAction.QUERY_MEM, user);
		if(result.startsWith("第")){
			form.setReInfo(result);
		}else{
			form.setReInfo("查询成功");
			doExport(actionMapping, actionForm, request, response, user,this.QUERY_GROUP);
		}
		return (actionMapping.findForward("batch"));
	}
	/**
	 * 全量查询结果
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 * @author added by Linli
	 */
	public ActionForward doBatchqueryall(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		YxPlanGroupForm form = (YxPlanGroupForm) actionForm;
		FormFile inputFile = form.getInputFile();
		ICheckFormat iCheckFormat = new YxplanGroupCheck(
				YxPlanGroupAction.QUERY_ALL);
		// 检查文件类型大小,表单数据类型等
//		if (inputFile == null || inputFile.getFileSize() == 0) {
//			form.setReInfo("上传文件不能为空");
//			return (actionMapping.findForward("batch"));
//		}
//		iCheckFormat.checkFile(inputFile, null);
		// 检查文件每行格式
		String result = batchDisposal(inputFile, iCheckFormat,
				YxPlanGroupAction.QUERY_ALL, user);
		if(result.startsWith("第")){
			form.setReInfo(result);
		}else{
			form.setReInfo("查询成功");
			doExport(actionMapping, actionForm, request, response, user,this.QUERY_GROUP);
		}
		return (actionMapping.findForward("batch"));
	}
	//导出
	public void ExportQuery(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user,
			CommonExportBean commonExportBean) throws Exception {
		ArrayList list;
		OutputStream os = response.getOutputStream();
		list = (ArrayList) ((DataPackage) request.getAttribute(WebConstant.PAGE_ATTRIBUTE_LIST)).getDatas();
		if (list != null && !list.isEmpty()){ 
			Iterator itt=list.iterator();
			int rowCount=0;
			char[] KEYWORD_ENTER = { 13, 10 };
			try {
	           if (itt != null) {
	               while (itt.hasNext()) {
	                   rowCount++;
	                   StringBuffer buff = new StringBuffer();
	                   Object ob = itt.next();
	                   Object[] obs=(Object[]) ob;
	                   buff.append(rowCount).append("|");
	                   for(int i=0;i<obs.length;i++){
	                	   buff.append(obs[i]).append("|");
	                   }
	                   String str=buff.toString();
	                   os.write( str.getBytes("GBK") );
	                   os.write( new String(KEYWORD_ENTER).getBytes("GBK"));
	                   os.flush();
	                } // end while
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            os.flush();
	        }
			list.clear();
		}
	}
	/**
	 * 批量处理
	 */
	private String batchDisposal(FormFile file, ICheckFormat iCheckFormat,
			String type, User user) throws Exception {
		InputStream stream = file.getInputStream();
		InputStreamReader read = new InputStreamReader(stream, "gbk");
		BufferedReader rin = new BufferedReader(read);
		String line;
		int count = 0;// 记录当前检查到的行数
		StringBuffer result = new StringBuffer("");
		YxPlanGroupDelegate delegate = new YxPlanGroupDelegate();
		StringBuffer queryItems = new StringBuffer();// 如果type是批量查询的话则组装字符串
		try {
			while ((line = rin.readLine()) != null) {
				if (line.trim().length() > 0) {
					++count;
					try {
						// 检查数据格式
						iCheckFormat.checkLine(line, count);
					} catch (Exception ex) {
						result.append("第 " + count + " 条记录格式不正确："
								+ ex.getMessage() + "\r\n");
						continue;
					}
					// 新增删除跟查询营销方案分组成员 modify by Linli
					try {
						if (type.equals(YxPlanGroupAction.ADD))
							delegate.doBatchCreate(buildVO(line), user);
						else if (type.equals(YxPlanGroupAction.DELETE))
							delegate.doBatchDelete(buildVO(line), user);
						else if (type.equals(YxPlanGroupAction.QUERY_GROUP))
							//根据营销方案组标识查询函数
							queryItems.append(buildVO(line).getGroupyxplan())
									.append(",");
							//根据营销方案标识查询函数
						else if (type.equals(YxPlanGroupAction.QUERY_MEM))
							queryItems.append(buildVO2(line).getMemyxplan())
									.append(",");
					} catch (Exception ex) {
						result.append("第 " + count + " 条" + ex.getMessage()
								+ "\r\n");
					}
				}
			}
			if (type.equals(YxPlanGroupAction.QUERY_GROUP)) {
				try {
					dp = delegate.doBatchQueryGroup(queryItems.substring(0,
							queryItems.length() - 1), user);
				} catch (Exception ex) {
					result.append("\n格式错误导致查询条件出错!"
							+ "\r\n");
				}
			}else if (type.equals(YxPlanGroupAction.QUERY_MEM)) {
				try {
					dp = delegate.doBatchQueryMem(queryItems.substring(0,
							queryItems.length() - 1), user);
				} catch (Exception ex) {
					result.append("\n格式错误导致查询条件出错!"
							+ "\r\n");
				}
			}else if(type.equals(YxPlanGroupAction.QUERY_ALL)) {
				try {
					dp = delegate.doBatchQueryAll(null, user);
				} catch (Exception ex) {
					result.append("\n格式错误导致查询条件出错!"
							+ "\r\n");
				}
			}
		} catch (Exception ex) {
			return result.toString();
		} finally {
			rin.close();
			read.close();
		}
		if (result.toString().equals(""))
			if (type.equals(YxPlanGroupAction.ADD))
				result.append("记录已全部新增成功");
			else if (type.equals(YxPlanGroupAction.DELETE))
				result.append("记录已全部删除成功");
			else if (type.equals(YxPlanGroupAction.QUERY_GROUP))
				result.append("记录已全部(根据营销方案组标识)查询成功");
			else if (type.equals(YxPlanGroupAction.QUERY_MEM))
				result.append("记录已全部(根据营销方案标识)查询成功");
			else if (type.equals(YxPlanGroupAction.QUERY_ALL))
				result.append("记录已全量查询成功");
		return result.toString();
	}

	private YxPlanGroupVO buildVO(String line) {
		YxPlanGroupVO vo = new YxPlanGroupVO();
		String[] items = StringUtils.splitPreserveAllTokens(line, "|");
		vo.setGroupyxplan(new Long(items[0].equals("") ? "0" : items[0]));
		vo.setMemyxplan(new Long(items[1].equals("") ? "0" : items[1]));
		return vo;
	}
	private YxPlanGroupVO buildVO2(String line) {
		YxPlanGroupVO vo = new YxPlanGroupVO();
		String[] items = StringUtils.splitPreserveAllTokens(line, "|");
		vo.setGroupyxplan(new Long(items[1].equals("") ? "0" : items[1]));
		vo.setMemyxplan(new Long(items[0].equals("") ? "0" : items[0]));
		return vo;
	}
}
