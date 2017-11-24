package com.sunrise.jop.ui.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sunrise.jop.common.utils.lang.InterfaceUtils;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.ui.filter.PermissionChecker;
import com.sunrise.jop.ui.struts2.WebConstant;

/**
 * �ñ�ǩ��2�����ԣ�
 * permissionId			Ȩ�޿��Ƶ�����
 * disableChild		��Ԫ��disabled����
 * 
 * �ñ�ǩ���ã��ж��û��Ƿ���Ȩ�ޣ�����2������3�ֲ�ͬ��ʾ
 * 1.�û���permid��Ȩ�ޣ���ʾ��ǩ����������
 * 2.�û�ûpermid��Ȩ�ޣ�disableChild����Ϊtrue����ǩ���������ݶ����disabled���ԣ����ӱ�ɲ�����
 * 3.�û�ûpermid��Ȩ�ޣ�disableChild���Բ�Ϊtrue������ʾ��ǩ������
 * 
 * ----------------------------
 * ��Ҫ�������ļ�*.tld������������
 *
	<tag>
		<name>purChk</name>
		<tag-class>com.sunrise.jop.ui.tag.PurChkTag</tag-class>
		<body-content>JSP</body-content>
		<description>Examine that if the user have the permission.</description>
		<attribute>
			<name>permissionId</name>
			<required>true</required>
			<rtexprvalue>true</rtexprvalue>
		</attribute>
		<attribute>
			<name>disableChild</name>
			<required>false</required>
			<rtexprvalue>false</rtexprvalue>
		</attribute>
	</tag>
 * 
 * ----------------------------
 * @author hbm
 *
 */
public class PurChkTag extends BodyTagSupport {
	final static String DISABLED = " disabled ";
	
	private static Log log = LogFactory.getLog(PurChkTag.class);
	private String permissionId;

	private String disableChild = "true"; //Ĭ����Ȩ��ʱ������Ԫ��

	public String getPermid() {
		return permissionId;
	}

	public void setPermid(String permissionId) {
		this.permissionId = permissionId;
	}

	public String getDisableChild() {
		return disableChild;
	}

	public void setDisableChild(String disableChild) {
		this.disableChild = disableChild;
	}

	public PurChkTag() throws Exception {
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
		boolean hasPermission = checkPermission(permissionId);
		if (isDisabled) { //���������Ȩ�޵Ŀؼ�
			if (bodyContent != null) {
				String oldBody = bodyContent.getString();
				JspWriter out = this.getPreviousOut();
				try {
					StringBuffer newBody = new StringBuffer(oldBody.trim());
					if (!hasPermission) {// ûȨ��						
						if(newBody.indexOf("<input" ) >=0)  {
							addDisabled(newBody, "<input");// ��<input>���disabled����
							out.print(newBody);
							
						}else if(newBody.indexOf("<select" ) >=0 ) {
							addDisabled(newBody, "<select");// ��<select>���disabled����	
							out.print(newBody);
							
						}else if( newBody.indexOf("<a" ) >=0) {
							deleteATag(newBody);  // ��<a>ɾ����ֻ��������
							out.print(newBody);
							
						} //else //����html��ǩ������ʾ
							
					}else	//��Ȩ������ʾ
						out.print(newBody);
					
				} catch (IOException e) {
					throw new JspException(e);
				}
			}
		} else {
			if (hasPermission) {// ��Ȩ��
				if (bodyContent != null) {
					JspWriter out = this.getPreviousOut();
					try {
						out.print(bodyContent.getString());
					} catch (IOException e) {
						throw new JspException(e);
					}
				}
			}
		}

		return SKIP_BODY;
	}

	
	/**
	 * ���disableChild�Ƿ�Ϊtrue
	 * @return
	 */
	private boolean checkDisabled() {
		if (disableChild != null && disableChild.equalsIgnoreCase("true")) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * �ж��û��Ƿ���Ȩ��
	 * @param permissionId
	 * @return
	 */
	private boolean checkPermission(String permissionId) {
		DBAccessUser user = (DBAccessUser) pageContext.getSession().getAttribute(WebConstant.SESSION_ATTRIBUTE_USER);
		String oprcode = user.getOprcode();
		boolean hasPermission = false;
		try {
			PermissionChecker checker = (PermissionChecker) InterfaceUtils.getInstance().createImplObject(PermissionChecker.class);
			hasPermission = checker.checkPermission( oprcode , permissionId);
		
		} catch (Exception e) {
			if(log.isWarnEnabled())
				log.warn("PurChkTag ��Ȩʧ��:" + user.getOprcode() +"," + permissionId, e);
			return false;
		}
		if(log.isDebugEnabled())
			log.debug("���Ȩ��:oprcode: " + oprcode + ",permissionId:" + permissionId + ", hasPermission? " + hasPermission );
		
		return hasPermission;
	}

	/**
	 * ����<a href="xxx">test</a>,ɾ��<a href="xxx"></a>ֻ����test
	 * 
	 * @param body
	 */
	private void deleteATag(StringBuffer body) {
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
	private void addDisabled(StringBuffer body, String target) {
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
	
	public static void main(String[] args) {
		
		StringBuffer body =new StringBuffer( "<a href=' \r\n /web/system/module_edit.do?param._pk=ACCTMONITOR_MAG'> \r\nACCTMONITOR_MAG\r\n  </a>");
		int firstPoint = body.toString().toLowerCase().indexOf("<a ");
		if (firstPoint >= 0) {
			int secondPoint = body.indexOf(">", firstPoint + 3) + 1;
			int thirdPoint = body.toString().toLowerCase().indexOf("</a>",
					firstPoint + 3);
			//body.delete(thirdPoint, thirdPoint + 4); // ��ɾ��������ַ�
			//body.delete(firstPoint, secondPoint); // ��ɾ��ǰ����ַ�
			
			body = new StringBuffer( body.substring(secondPoint, thirdPoint).trim());
			
		}
		
		System.out.println(body );
	}
}
