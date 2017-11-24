package com.gmcc.pboss.common.export;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunrise.jop.common.utils.lang.Code2NameUtils;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;

/**
 * ͨ�õĵ����� ʾ���� protected ActionForward doExcel(ActionMapping actionMapping,
 * ActionForm actionForm, HttpServletRequest request, HttpServletResponse
 * response, User user) throws Exception { CommonExportBean commonExportBean=
 * new CommonExportBean(user); commonExportBean.setFileName("Ӫҵ���������");
 * commonExportBean.addOutputProperty("wayid","��������",CommonExportBean.CODE2NAME,
 * "#WAY"); commonExportBean.addOutputProperty(0,"business","Ӫҵ��",null,null);
 * commonExportBean.addOutputProperty("busicode","Ӫҵ�����");
 * commonExportBean.addOutputProperty("businame","���"); //������ʾ�����������
 * commonExportBean.appendHeadLine(new String[]{"��������:",user.getOpercode()});
 * commonExportBean.appendEndLine(new String[]{"��������:",user.getWayid()});
 * request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, commonExportBean);
 * return super.doExcel(actionMapping, actionForm, request, response, user); }
 * 
 * @author liminghao
 * 
 */
public class CommonExportBean extends ExportDataCreator {
	public Class[] voClassArray;
	public String queryMethodName = "doList"; // ע�������ѯ��������doList����ΪpublicȨ�޲ſ��Ա��ص�
	private ArrayList titleList = new ArrayList();
	private ArrayList headlineList = new ArrayList();
	private ArrayList endlineList = new ArrayList();
	private String endBody = null;
	public static int EXCELOUT_PAGE_SIZE = 1000;

	public CommonExportBean(User user) {
		super(user);
	}

	protected String codeToName(String propertyName, String code, User user) {
		return null;
	}

	private String codeToName(String propertyName, String formatType,
			Object code, User user) throws Exception {
		if (code == null) {
			return "";
		}
		String name = Code2NameUtils.code2Name(formatType,
				String.valueOf(code), user.getCityid());
		return name;
	}

	protected void queryPages(OutputStream os, Object queryVO, User opr)
			throws Exception {
	}

	protected void writeTitle() {
	}

	protected void beforeWrite(OutputStream os) throws Exception {
		for (Iterator iter = headlineList.iterator(); iter.hasNext();) {
			String[] line = (String[]) iter.next();
			writeLines(os, line);
		}
	}

	protected void afterWrite(OutputStream os) throws Exception {
		for (Iterator iter = endlineList.iterator(); iter.hasNext();) {
			String[] line = (String[]) iter.next();
			writeLines(os, line);
		}

	}

	public void buildExcelPage(BaseVO actionForm, HttpServletRequest request,
			HttpServletResponse response, User user, BaseAction action)
			throws Exception {
		setExcelResponse(response);
		OutputStream os = response.getOutputStream();
		// ת��titleListΪtitle����
		if (titleList != null && titleList.size() != 0) {
			// Object[] object=titleList.toArray();
			title = new String[titleList.size()];
			int i = 0;
			for (Iterator iter = titleList.iterator(); iter.hasNext();) {
				String element = (String) iter.next();
				title[i++] = element;
			}
		}
		// д��ͷ
		writeTitle(os, title);

		// �ص�BaseAction�����ѯд���ݷ���
		action.ExportQuery(actionForm, request, response, user, this);
		os.write("</table>".toString().getBytes());

		StringBuffer sb = new StringBuffer();
		sb.append("<table bordercolor=#A8A8A8>");
		os.write(cvtToGBK(sb.toString()));
		afterWrite(os);
		sb.setLength(0);
		sb.append("</table>");
		if (endBody != null) {
			sb.append(endBody);
		}
		os.write(cvtToGBK(sb.toString()));
	}

	private void setExcelResponse(HttpServletResponse response)
			throws Exception {
		response.setCharacterEncoding("GBK");
		response.setHeader("pragma", "no-cache");
		response.setHeader("Cache-control", "public");
		response.setHeader("Expires", "01 Apr 1995 01:10:10 GMT");
		String fn = "attachment; filename=" + fileName + ".xls";
		response.setHeader("Content-Disposition", new String(
				fn.getBytes("GBK"), "ISO-8859-1"));
		response.setContentType("application/x-msdownload");
		// ָ���ļ�����
		filetype = "EXCEL";
	}

	protected String formatData(PropertyFormat propertyFormat, Object value)
			throws Exception {
		if ("CODE2NAME".equals(propertyFormat.format)) {
			return codeToName(propertyFormat.propertyName,
					propertyFormat.formatType, value, user);
		} else {
			return super.formatData(propertyFormat, value);
		}
	}

	/**
	 * 
	 * @param propertyId
	 *            ��Ӧ���ĵڼ������� ����ѯ����
	 * @param propertyName
	 *            ��������
	 * @param titleCol
	 *            ���ñ��⣬�����˴˷�����Ӧ���ٵ���setTitle�ظ����ñ���
	 * @param format
	 *            String DATE YYYY-MM-DD NUMBER ##.00 CODE2NAME definition
	 */
	public void addOutputProperty(int propertyId, String propertyName,
			String titleCol, String format, String formatType) {
		addOutputProperty(propertyId, propertyName, format, formatType);
		titleList.add(titleCol);
	}

	public void addOutputProperty(String propertyName, String titleCol,
			String format, String formatType) {
		addOutputProperty(0, propertyName, titleCol, format, formatType);
	}

	/**
	 * @param titleCol
	 *            ���ñ��⣬�����˴˷�����Ӧ���ٵ���setTitle�ظ����ñ���
	 */
	public void addOutputProperty(String propertyName, String titleCol) {
		addOutputProperty(0, propertyName, titleCol, null, null);
	}

	/**
	 * ���ļ���β�����һ��
	 * 
	 * @param line
	 *            �������ÿ��Ԫ�ش���ĳ�е�ÿһ��
	 */
	public void appendEndLine(String[] line) {
		endlineList.add(line);
	}

	/**
	 * ���ļ���β�����һЩhtml����
	 * 
	 * @param line
	 *            Ϊ1��
	 */
	public void appendEndBody(String endLine) {
		endBody = endLine;
	}

	/**
	 * ���ļ���ʼ�����һ��
	 * 
	 * @param line
	 *            �������ÿ��Ԫ�ش���ĳ�е�ÿһ��
	 */
	public void appendHeadLine(String[] line) {
		headlineList.add(line);
	}
}
