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
		// TODO: ������������������
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
				"�Ѿ�������ͬ����Ӫ���������ʶ�ͳ�ԱӪ��������ʶ, ������������ԱӪ��������ʶ");
	}

	/**
	 * ��������Ӫ����������
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
	 * ��������Ӫ��������ĳ�Ա(����)
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
		// ����ļ����ʹ�С,���������͵�
		if (inputFile == null || inputFile.getFileSize() == 0) {
			form.setReInfo("�ϴ��ļ�����Ϊ��");
			return (actionMapping.findForward("batch"));
		}
		iCheckFormat.checkFile(inputFile, null);
		// ����ļ�ÿ�и�ʽ
		String result = batchDisposal(inputFile, iCheckFormat,
				YxPlanGroupAction.ADD, user);
		form.setReInfo(result);
		return (actionMapping.findForward("batch"));
	}

	/**
	 * �ϴ�����������Ӫ�������ļ���ɾ����
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
		// ����ļ����ʹ�С,���������͵�
		if (inputFile == null || inputFile.getFileSize() == 0) {
			form.setReInfo("�ϴ��ļ�����Ϊ��");
			return (actionMapping.findForward("batch"));
		}
		iCheckFormat.checkFile(inputFile, null);
		// ����ļ�ÿ�и�ʽ
		String result = batchDisposal(inputFile, iCheckFormat,
				YxPlanGroupAction.DELETE, user);
		form.setReInfo(result);
		return (actionMapping.findForward("batch"));
	}

	/**
	 * �ϴ�����������Ӫ�������ļ���ɾ����
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
	 * �ϴ�����������Ӫ�������ļ�������Ӫ���������ʶ��ѯ��
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
		// ����ļ����ʹ�С,���������͵�
		if (inputFile == null || inputFile.getFileSize() == 0) {
			form.setReInfo("�ϴ��ļ�����Ϊ��");
			return (actionMapping.findForward("batch"));
		}
		iCheckFormat.checkFile(inputFile, null);
		// ����ļ�ÿ�и�ʽ
		String result = batchDisposal(inputFile, iCheckFormat,
				YxPlanGroupAction.QUERY_GROUP, user);
		if(result.startsWith("��")){
			form.setReInfo(result);
		}else{
			form.setReInfo("��ѯ�ɹ�");
			doExport(actionMapping, actionForm, request, response, user,this.QUERY_GROUP);
		}
		return (actionMapping.findForward("batch"));
	}
	//������ѯ(����Ӫ���������ʶ)
	public void doExport(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user,String type) throws Exception {
		CommonExportBean export = new CommonExportBean(user);
		if(type.equals(this.QUERY_GROUP))
			export.setFileName("������ѯ(����Ӫ���������ʶ)���");
		else if(type.equals(this.QUERY_MEM))
			export.setFileName("������ѯ(����Ӫ��������ʶ)���");
		else 
			export.setFileName("ȫ����ѯ���");
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
				"Ӫ���������ʶ", "��������", "Ӫ��������ʶ", "Ӫ����������","" });
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		if(dp.getDatas().size()>0){
			this.ExportQuery(actionMapping, actionForm, request, response, user,
					export);
		}else{
			response.getOutputStream().flush();
		}
	}
	/**
	 * �ϴ�����������Ӫ�������ļ�������Ӫ���������ʶ��ѯ��
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
		// ����ļ����ʹ�С,���������͵�
		if (inputFile == null || inputFile.getFileSize() == 0) {
			form.setReInfo("�ϴ��ļ�����Ϊ��");
			return (actionMapping.findForward("batch"));
		}
		
			iCheckFormat.checkFile(inputFile, null);
		
		// ����ļ�ÿ�и�ʽ
		String result = batchDisposal(inputFile, iCheckFormat,
				YxPlanGroupAction.QUERY_MEM, user);
		if(result.startsWith("��")){
			form.setReInfo(result);
		}else{
			form.setReInfo("��ѯ�ɹ�");
			doExport(actionMapping, actionForm, request, response, user,this.QUERY_GROUP);
		}
		return (actionMapping.findForward("batch"));
	}
	/**
	 * ȫ����ѯ���
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
		// ����ļ����ʹ�С,���������͵�
//		if (inputFile == null || inputFile.getFileSize() == 0) {
//			form.setReInfo("�ϴ��ļ�����Ϊ��");
//			return (actionMapping.findForward("batch"));
//		}
//		iCheckFormat.checkFile(inputFile, null);
		// ����ļ�ÿ�и�ʽ
		String result = batchDisposal(inputFile, iCheckFormat,
				YxPlanGroupAction.QUERY_ALL, user);
		if(result.startsWith("��")){
			form.setReInfo(result);
		}else{
			form.setReInfo("��ѯ�ɹ�");
			doExport(actionMapping, actionForm, request, response, user,this.QUERY_GROUP);
		}
		return (actionMapping.findForward("batch"));
	}
	//����
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
	 * ��������
	 */
	private String batchDisposal(FormFile file, ICheckFormat iCheckFormat,
			String type, User user) throws Exception {
		InputStream stream = file.getInputStream();
		InputStreamReader read = new InputStreamReader(stream, "gbk");
		BufferedReader rin = new BufferedReader(read);
		String line;
		int count = 0;// ��¼��ǰ��鵽������
		StringBuffer result = new StringBuffer("");
		YxPlanGroupDelegate delegate = new YxPlanGroupDelegate();
		StringBuffer queryItems = new StringBuffer();// ���type��������ѯ�Ļ�����װ�ַ���
		try {
			while ((line = rin.readLine()) != null) {
				if (line.trim().length() > 0) {
					++count;
					try {
						// ������ݸ�ʽ
						iCheckFormat.checkLine(line, count);
					} catch (Exception ex) {
						result.append("�� " + count + " ����¼��ʽ����ȷ��"
								+ ex.getMessage() + "\r\n");
						continue;
					}
					// ����ɾ������ѯӪ�����������Ա modify by Linli
					try {
						if (type.equals(YxPlanGroupAction.ADD))
							delegate.doBatchCreate(buildVO(line), user);
						else if (type.equals(YxPlanGroupAction.DELETE))
							delegate.doBatchDelete(buildVO(line), user);
						else if (type.equals(YxPlanGroupAction.QUERY_GROUP))
							//����Ӫ���������ʶ��ѯ����
							queryItems.append(buildVO(line).getGroupyxplan())
									.append(",");
							//����Ӫ��������ʶ��ѯ����
						else if (type.equals(YxPlanGroupAction.QUERY_MEM))
							queryItems.append(buildVO2(line).getMemyxplan())
									.append(",");
					} catch (Exception ex) {
						result.append("�� " + count + " ��" + ex.getMessage()
								+ "\r\n");
					}
				}
			}
			if (type.equals(YxPlanGroupAction.QUERY_GROUP)) {
				try {
					dp = delegate.doBatchQueryGroup(queryItems.substring(0,
							queryItems.length() - 1), user);
				} catch (Exception ex) {
					result.append("\n��ʽ�����²�ѯ��������!"
							+ "\r\n");
				}
			}else if (type.equals(YxPlanGroupAction.QUERY_MEM)) {
				try {
					dp = delegate.doBatchQueryMem(queryItems.substring(0,
							queryItems.length() - 1), user);
				} catch (Exception ex) {
					result.append("\n��ʽ�����²�ѯ��������!"
							+ "\r\n");
				}
			}else if(type.equals(YxPlanGroupAction.QUERY_ALL)) {
				try {
					dp = delegate.doBatchQueryAll(null, user);
				} catch (Exception ex) {
					result.append("\n��ʽ�����²�ѯ��������!"
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
				result.append("��¼��ȫ�������ɹ�");
			else if (type.equals(YxPlanGroupAction.DELETE))
				result.append("��¼��ȫ��ɾ���ɹ�");
			else if (type.equals(YxPlanGroupAction.QUERY_GROUP))
				result.append("��¼��ȫ��(����Ӫ���������ʶ)��ѯ�ɹ�");
			else if (type.equals(YxPlanGroupAction.QUERY_MEM))
				result.append("��¼��ȫ��(����Ӫ��������ʶ)��ѯ�ɹ�");
			else if (type.equals(YxPlanGroupAction.QUERY_ALL))
				result.append("��¼��ȫ����ѯ�ɹ�");
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
