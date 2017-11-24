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
 * �ñ�ǩ��2�����ԣ� controlid Ȩ�޿��Ƶ����� disableChild ��Ԫ��disabled����
 * 
 * �ñ�ǩ���ã��ж��û��Ƿ���Ȩ�ޣ�����2������3�ֲ�ͬ��ʾ 1.�û���controlid��Ȩ�ޣ���ʾ��ǩ����������
 * 2.�û�ûcontrolid��Ȩ�ޣ�disableChild����Ϊtrue����ǩ���������ݶ����disabled���ԣ����ӱ�ɲ�����
 * 3.�û�ûcontrolid��Ȩ�ޣ�disableChild���Բ�Ϊtrue������ʾ��ǩ������
 * 
 * @author hbm
 * @version 2008-2-19 ��Ӷ���Ƶ��жϣ�����μ����� havePurview��
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
		if (!isPurview) {// ûȨ��
			if(checkDisabled()){
			addDisabled(newBody, "<input");// ��<input>���disabled����
			addDisabled(newBody, "<select");// ��<select>���disabled����
			deleteATag(newBody);// ��<a>ɾ����ֻ��������
			}else{
			newBody.delete(0, newBody.length()-1);
			}
		}
		return newBody.toString();
	}

	/**
	 * ���disableChild�Ƿ�Ϊtrue
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
	 * �ж��û��Ƿ���Ȩ��
	 * 
	 * ������&&��||������ ����֧������� ���磺controlid��ֵ����Ϊ 1A2B3C�� 1A2B3C||5E6F7G��
	 * 1A2B3C&&5E6F7G
	 * 
	 */
	protected boolean havePurview(String controlid) {
		String[] ids; // controlIDs
		String flag; // ����־

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
			boolean[] bools = new boolean[ids.length]; // Ȩ��ֵ
			for (int i = 0; i < ids.length; ++i) {
				try {
					bools[i] = delegate.checkPermission(user.getOpercode(),
							ids[i].trim());
				} catch (Exception e) {
					e.printStackTrace();
					bools[i] = false;
				}
			}

			// �ϲ�����Ȩ��ֵ
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
	 * ����<a href="xxx">test</a>,ɾ��<a href="xxx"></a>ֻ����test
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
				body.delete(thirdPoint, thirdPoint + 4); // ��ɾ��������ַ�
				body.delete(firstPoint, secondPoint); // ��ɾ��ǰ����ַ�
				needLoop = true;
			}
		}
	}

	/**
	 * ��Ŀ���ǩ���disabled����
	 * 
	 * @param body
	 * @param target
	 *            Ŀ���ǩ
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
	 * ����target����λ��
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
