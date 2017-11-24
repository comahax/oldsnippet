package com.sunrise.boss.ui.commons.taglib;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.delegate.admin.acl.ACLDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * 该标签有2个属性： controlid 权限控制点属性 disableChild 子元素disabled属性
 * 
 * 该标签作用：判断用户是否有权限，根据2属性有3种不同显示 1.用户有controlid的权限：显示标签体所有内容
 * 2.用户没controlid的权限，disableChild属性为true：标签体所有内容都添加disabled属性，链接变成不可用
 * 3.用户没controlid的权限，disableChild属性不为true：不显示标签体内容
 * 
 * @author hbm
 * @version 2008-2-19 添加多控制点判断（具体参见方法 havePurview）
 * 
 */
public class PurChk2Tag extends BodyTagSupport {
	final static String DISABLED = " disabled ";

	private ACLDelegate delegate;

	private String controlid;

	private String disableChild;

	public String getControlid() {
		return controlid;
	}

	public void setControlid(String controlid) {
		this.controlid = controlid;
	}

	public String getDisableChild() {
		return disableChild;
	}

	public void setDisableChild(String disableChild) {
		this.disableChild = disableChild;
	}

	public PurChk2Tag() throws Exception {
		delegate = new ACLDelegate();
	}

	/**
	 * start tag
	 */
	public int doStartTag() throws JspException {
		return EVAL_BODY_BUFFERED;
	}

	/**
	 * end tag
	 */
	public int doEndTag() throws JspException {
		boolean isDisabled = checkDisabled();
		boolean isPurview = havePurview(controlid);
		if (bodyContent != null) {
			String oldBody = bodyContent.getString();
			JspWriter out = this.getPreviousOut();
			try {
				out.print(changeInputFiled(isPurview));
			} catch (IOException e) {
				throw new JspException(e);
			}
		}

		return SKIP_BODY;
	}

	protected String changeInputFiled(boolean isPurview) {
		StringBuffer newBody = new StringBuffer(bodyContent.getString());
		if (!isPurview) {// 没权限
			if(checkDisabled()){
			addDisabled(newBody, "<input");// 替<input>添加disabled属性
			addDisabled(newBody, "<select");// 替<select>添加disabled属性
			deleteATag(newBody);// 把<a>删除，只留下内容
			}else{
			newBody.delete(0, newBody.length()-1);
			}
		}
		return newBody.toString();
	}

	/**
	 * 检查disableChild是否为true
	 * 
	 * @return
	 */
	protected boolean checkDisabled() {
		if (disableChild != null && disableChild.equalsIgnoreCase("true")) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 判断用户是否有权限
	 * 
	 * 添加与或（&&，||）功能 ，不支持与或并用 例如：controlid的值可以为 1A2B3C， 1A2B3C||5E6F7G，
	 * 1A2B3C&&5E6F7G
	 * 
	 */
	protected boolean havePurview(String controlid) {
		String[] ids; // controlIDs
		String flag; // 与或标志

		if (controlid != null) {
			if (controlid.indexOf("||") >= 0) {
				ids = controlid.split("\\|\\|");
				flag = "||";
			} else if (controlid.indexOf("&&") >= 0) {
				ids = controlid.split("\\&\\&");
				flag = "&&";
			} else {
				ids = new String[1];
				ids[0] = controlid;
				flag = null;
			}

			User user = (User) pageContext.getSession().getAttribute(
					WebConstant.SESSION_ATTRIBUTE_USER);
			boolean[] bools = new boolean[ids.length]; // 权限值
			for (int i = 0; i < ids.length; ++i) {
				try {
					bools[i] = delegate.checkPermission(user.getOpercode(),
							ids[i].trim());
				} catch (Exception e) {
					e.printStackTrace();
					bools[i] = false;
				}
			}

			// 合并所有权限值
			if ("||".equals(flag)) {
				boolean result = false;
				for (int i = 0; i < bools.length; ++i) {
					result = result || bools[i];
				}
				return result;
			} else if ("&&".equals(flag)) {
				boolean result = true;
				for (int i = 0; i < bools.length; ++i) {
					result = result && bools[i];
				}
				return result;
			} else {
				return bools[0];
			}

		} else {
			return false;
		}

	}

	/**
	 * 对于<a href="xxx">test</a>,删除<a href="xxx"></a>只留下test
	 * 
	 * @param body
	 */
	protected void deleteATag(StringBuffer body) {
		boolean needLoop = true;
		while (needLoop) {
			needLoop = false;
			int firstPoint = body.toString().toLowerCase().indexOf("<a ");
			if (firstPoint >= 0) {
				int secondPoint = body.indexOf(">", firstPoint + 3) + 1;
				int thirdPoint = body.toString().toLowerCase().indexOf("</a>",
						firstPoint + 3);
				body.delete(thirdPoint, thirdPoint + 4); // 先删除后面的字符
				body.delete(firstPoint, secondPoint); // 再删除前面的字符
				needLoop = true;
			}
		}
	}

	/**
	 * 替目标标签添加disabled属性
	 * 
	 * @param body
	 * @param target
	 *            目标标签
	 */
	protected void addDisabled(StringBuffer body, String target) {
		boolean needLoop = true;
		int currentPoint = 0;
		while (needLoop) {
			needLoop = false;
			int firstPoint = findPoint(body.toString(), target, currentPoint);
			if (firstPoint >= 0) {
				body.insert(firstPoint, DISABLED);
				currentPoint = firstPoint;
				needLoop = true;
			}
		}
	}

	/**
	 * 查找target所在位置
	 * 
	 * @param body
	 * @param target
	 * @param startPoint
	 * @return
	 */
	private int findPoint(String body, String target, int startPoint) {
		int point = body.toLowerCase().indexOf(target, startPoint);
		if (point >= 0) {
			point += target.length();
		}
		return point;
	}
}
