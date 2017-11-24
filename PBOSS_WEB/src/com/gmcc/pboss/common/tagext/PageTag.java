package com.gmcc.pboss.common.tagext;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class PageTag extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private boolean previous;
	private boolean next;

	private int size;
	private int current;

	private int first = 1;
	private int last;
	private int rows;
	private String url;

	private String cssClass;

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public boolean isPrevious() {
		return previous;
	}

	public void setPrevious(boolean previous) {
		this.previous = previous;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		this.current = current;
	}

	public int getFirst() {
		return first;
	}

	public void setFirst(int first) {
		this.first = first;
	}

	public int getLast() {
		return last;
	}

	public void setLast(int last) {
		this.last = last;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCssClass() {
		if (cssClass == null)
			return "_page_ul";
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}

	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		try {
			out.println("<ul class=\"" + getCssClass() + "\">");
			if (isPrevious()) {
				out.println("<li><a href=\"" + getUrl() + "?parameter.size=" + getSize() + "&parameter.no=" + getFirst() + "\">��ҳ</a></li>");
				out.println("<li><a href=\"" + getUrl() + "?parameter.size=" + getSize() + "&parameter.no=" + (getCurrent() - 1) + "\">��ҳ</a></li>");
			} else {
				out.println("<li>��ҳ</li>");
				out.println("<li>��ҳ</li>");
			}
			if (isNext()) {
				out.println("<li><a href=\"" + getUrl() + "?parameter.size=" + getSize() + "&parameter.no=" + (getCurrent() + 1) + "\">��ҳ</a></li>");
				out.println("<li><a href=\"" + getUrl() + "?parameter.size=" + getSize() + "&parameter.no=" + getLast() + "\">βҳ</a></li>");
			} else {
				out.println("<li>��ҳ</li>");
				out.println("<li>βҳ</li>");
			}
			out.println("<li>��"+ getRows() +"��,ÿҳ"+getSize()+"��,��"+getCurrent()+"/"+getLast()+"ҳ</li>");
			out.println("</ul>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}

}
