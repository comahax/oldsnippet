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
 * 通用的导出类 示例： protected ActionForward doExcel(ActionMapping actionMapping,
 * ActionForm actionForm, HttpServletRequest request, HttpServletResponse
 * response, User user) throws Exception { CommonExportBean commonExportBean=
 * new CommonExportBean(user); commonExportBean.setFileName("营业点参数管理");
 * commonExportBean.addOutputProperty("wayid","渠道代码",CommonExportBean.CODE2NAME,
 * "#WAY"); commonExportBean.addOutputProperty(0,"business","营业点",null,null);
 * commonExportBean.addOutputProperty("busicode","营业点代码");
 * commonExportBean.addOutputProperty("businame","简称"); //以下演示不规则行情况
 * commonExportBean.appendHeadLine(new String[]{"导出工号:",user.getOpercode()});
 * commonExportBean.appendEndLine(new String[]{"导出渠道:",user.getWayid()});
 * request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, commonExportBean);
 * return super.doExcel(actionMapping, actionForm, request, response, user); }
 * 
 * @author liminghao
 * 
 */
public class CommonExportBean extends ExportDataCreator {
	public Class[] voClassArray;
	public String queryMethodName = "doList"; // 注意如果查询方法不是doList必须为public权限才可以被回调
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
		// 转换titleList为title数组
		if (titleList != null && titleList.size() != 0) {
			// Object[] object=titleList.toArray();
			title = new String[titleList.size()];
			int i = 0;
			for (Iterator iter = titleList.iterator(); iter.hasNext();) {
				String element = (String) iter.next();
				title[i++] = element;
			}
		}
		// 写表头
		writeTitle(os, title);

		// 回调BaseAction里面查询写数据方法
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
		// 指定文件类型
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
	 *            对应集的第几个对象 多表查询中用
	 * @param propertyName
	 *            属性名字
	 * @param titleCol
	 *            设置标题，调用了此方法不应该再调用setTitle重复设置标题
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
	 *            设置标题，调用了此方法不应该再调用setTitle重复设置标题
	 */
	public void addOutputProperty(String propertyName, String titleCol) {
		addOutputProperty(0, propertyName, titleCol, null, null);
	}

	/**
	 * 在文件结尾处添加一行
	 * 
	 * @param line
	 *            该数组的每个元素代表某行的每一列
	 */
	public void appendEndLine(String[] line) {
		endlineList.add(line);
	}

	/**
	 * 在文件结尾处添加一些html代码
	 * 
	 * @param line
	 *            为1列
	 */
	public void appendEndBody(String endLine) {
		endBody = endLine;
	}

	/**
	 * 在文件起始处添加一行
	 * 
	 * @param line
	 *            该数组的每个元素代表某行的每一列
	 */
	public void appendHeadLine(String[] line) {
		headlineList.add(line);
	}
}
