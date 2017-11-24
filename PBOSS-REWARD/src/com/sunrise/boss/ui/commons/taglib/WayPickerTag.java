package com.sunrise.boss.ui.commons.taglib;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.ajaxanywhere.AAUtils;
import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

public class WayPickerTag extends BodyTagSupport {
	private String id;

	private String property;

	private String readOnly = "false";

	private String disabled = "false";

	private String menuTokenId;

	private String showParent = "false";

	private String showCitycom = "true";

	private String showChild = "true";

	private String style = "";

	private String styleClass = "";

	private String waytype = "";

	private String waysubtype = "";

	public WayPickerTag() {
		// TODO Auto-generated constructor stub
	}

	public int doEndTag() throws JspException {
		StringBuffer sb = new StringBuffer("");
		String tempid = "";
		if (StringUtils.isNotEmpty(id)) {
			tempid = id;
		} else if (StringUtils.isNotEmpty(property)) {
			tempid = property;
		} else {
			throw new JspException("Id或Property属性没有设置");
		}

		String idvalue = pageContext.getRequest().getParameter(tempid);
		String namevalue = pageContext.getRequest().getParameter(
				tempid + "_name");
		if (StringUtils.isNotEmpty(idvalue) && StringUtils.isEmpty(namevalue)) {
			try {
				WayDelegate delegate = new WayDelegate();
				WayVO vo = delegate.doFindByPk(idvalue, (User) pageContext
						.getSession().getAttribute(
								WebConstant.SESSION_ATTRIBUTE_USER));
				if(vo!=null){
					namevalue=idvalue+" "+vo.getWayname();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// if(idvalue!=null) {
		// WayDelegate delegate = new WayDelegate();
		// WayVO wayVO = new WayVO();
		// wayVO.setWayid(idvalue);
		// wayVO = delegate.doFindByPk(wayVO,
		// (User)pageContext.getSession().getAttribute(WebConstant.SESSION_ATTRIBUTE_USER));
		// if(wayVO == null) {
		// idvalue = null;
		// namevalue = null;
		// }else {
		// namevalue =idvalue + " " + wayVO.getWayname();
		// }
		// }
		if (StringUtils.isNotEmpty(this.menuTokenId)) {
			sb
					.append("<input type=\"hidden\" id=\"menuTokenId\" name=\"menuTokenId\" value="
							+ menuTokenId + "/>");
		}
		sb.append("<input type=\"hidden\" id=" + tempid + "  name=" + tempid
				+ "");
		if (StringUtils.isNotEmpty(idvalue)) {
			sb.append(" value='" + idvalue + "'");
		}
		sb.append(" />");
		sb.append("<input type=\"text\" id=\"" + tempid + "_name\" name=\""
				+ tempid
				+ "_name\" class=\"form_input_1x\" onBlur=\"changeName(this,'"
				+ tempid + "')\"");
		if (StringUtils.isNotBlank(styleClass)) {
			sb.append(" class=").append(styleClass);
		}
		if (StringUtils.isNotBlank(style)) {
			sb.append(" style=").append(style);
		}
		if (StringUtils.equals("true", disabled)) {
			sb.append(" disabled ");
		}
		if (StringUtils.equals("true", readOnly)) {
			sb.append(" readOnly=true ");
		}
		if (StringUtils.isNotEmpty(namevalue)) {
			sb.append(" value='" + namevalue + "'");
		}
		// sb.append(" onchange=\" ajaxAnywhere.submitAjax();\"/>");
		sb.append("/>");
		sb
				.append(
						"<input type=\"button\" name=\""
								+ tempid
								+ "_button\" value=\"...\" class=\"clickbutton\" onclick=\"showSelectWay3(document.all(\'" + tempid + "_name\'),'"
								+ tempid + "'," + showParent + ","
								+ showCitycom + ",'" + waytype + "','"
								+ waysubtype + "');\" title=\"点击打开渠道树对话框\"")
				.append(
						" onmouseover=\"this.style.backgroundColor = '#999999';\"")
				.append(" onmouseout=\"this.style.backgroundColor='#EEEEEE';\"");
		if (StringUtils.equals("true", disabled)) {
			sb.append(" disabled");
		}
		sb.append("/>");

		// if(AAUtils.isAjaxRequest(pageContext.getRequest()))
		// AAUtils.addZonesToRefresh(pageContext.getRequest(),"wayPickerZone");
		try {
			pageContext.getOut().write(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}

	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		return EVAL_BODY_BUFFERED;
	}

	public String getDisabled() {
		return disabled;
	}

	public void setDisabled(String disabled) {
		this.disabled = disabled;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMenuTokenId() {
		return menuTokenId;
	}

	public void setMenuTokenId(String menuTokenId) {
		this.menuTokenId = menuTokenId;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getReadOnly() {
		return readOnly;
	}

	public void setReadOnly(String readOnly) {
		this.readOnly = readOnly;
	}

	public String getShowChild() {
		return showChild;
	}

	public void setShowChild(String showChild) {
		this.showChild = showChild;
	}

	public String getShowCitycom() {
		return showCitycom;
	}

	public void setShowCitycom(String showCitycom) {
		this.showCitycom = showCitycom;
	}

	public String getShowParent() {
		return showParent;
	}

	public void setShowParent(String showParent) {
		this.showParent = showParent;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getWaysubtype() {
		return waysubtype;
	}

	public void setWaysubtype(String waysubtype) {
		this.waysubtype = waysubtype;
	}

	public String getWaytype() {
		return waytype;
	}

	public void setWaytype(String waytype) {
		this.waytype = waytype;
	}

	public String getStyleClass() {
		return styleClass;
	}

	public void setStyleClass(String styleClass) {
		this.styleClass = styleClass;
	}

}
