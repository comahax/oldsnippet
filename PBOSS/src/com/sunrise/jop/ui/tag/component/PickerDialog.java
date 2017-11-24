/**
 * 
 */
package com.sunrise.jop.ui.tag.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.components.UIBean;

import com.opensymphony.xwork2.util.ValueStack;
import com.sunrise.jop.common.utils.lang.Code2NameUtils;
import com.sunrise.jop.infrastructure.config.CoreConfigInfo;

/**
 * @author He Kun
 *
 */
public class PickerDialog extends UIBean {
	
	private static Log log = LogFactory.getLog(PickerDialog.class);
	
	 final public static String TEMPLATE = "picker";
	
	protected String definition;    
	protected String condition;  //������,ֻ����ָ��������ֵ    
	protected String  dbFlag;    
	protected String readonly ;
    
	public PickerDialog(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
		super(stack, request, response);		
	}

	protected String getDefaultTemplate() {
		return TEMPLATE;
	}

	public static String getTEMPLATE() {
		return TEMPLATE;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getDbFlag() {
		return dbFlag;
	}

	public void setDbFlag(String dbFlag) {
		this.dbFlag = dbFlag;
	}

	public String getDefinition() {
		return definition;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}

	public String getReadonly() {
		return readonly;
	}

	public void setReadonly(String readonly) {
		this.readonly = readonly;
	}
	
	public void evaluateExtraParams() {	
		super.evaluateExtraParams();
		
		addParameter("definition",getDefinition());
		//�����Զ�����ʽ��ֵ//���²�������Ҫ��ӵ���������
		if(condition!=null) {
			String con = (String) getStack().findString( condition);
			if(con == null)
				con = condition;
			addParameter("condition", con);
		}else
			addParameter("condition", "");
		
		if(dbFlag!=null) {
			String dbFlag0 = (String)getStack().findValue( dbFlag ,String.class);
			if( dbFlag0 == null)
				dbFlag0 = dbFlag;
			addParameter("dbFlag", dbFlag0);
		}else
			addParameter("dbFlag", "");
		
		//���²�����Ҫ��ӵ��������У��������Ч��
		if(readonly!=null) {
			addParameter("readonly", getStack().findValue( readonly ,Boolean.class));
		}
	    
		evalueValue();
		
	}
	
	protected void evalueValue() {
		String valueValue = null;
		if(value == null) {
			//���Ը��� name���Լ���ֵ
			String name0 = (String)parameters.get("name");
			if( name0 !=null) {
				String vvv = (String)getStack().findString( name);
				if( !name0.equals(vvv)) { //����ܹ��������Ƽ���󶨵�����ֵ������Ϊvalue��Ĭ��ֵ
					valueValue = vvv;
				}
			}
				
		}else  {
//			��������������� nameValue ��ʾ��hidden��
			valueValue = getStack().findValue(value)!=null ? String.valueOf(getStack().findValue(value)) : null;
		}
		
		if( valueValue !=null) {
			addParameter("nameValue", valueValue);
			
			//������ת��Ϊ���ƣ� ��Ϊ nameText ��ʾ���ı�����
			try {
				//ʹ��Cache�����������棬������������ WebViewInterceptorHandler �У��μ� /jop-aop.xml 
				if(dbFlag == null) dbFlag = CoreConfigInfo.COMMON_DB_NAME;
				String codeName = Code2NameUtils.code2Name(definition,  valueValue , dbFlag);
				
				addParameter("nameText", codeName);  //��ӵ��������У��Ա�jspʹ��			 
			} catch (Exception e) {			 
				if( log.isErrorEnabled())
					log.error("�޷�ת�� picker " + name + " ��ֵ��" + value +" value:" + valueValue);
				addParameter("nameText", value);  //��ӵ��������У��Ա�jspʹ��	
			}		
		}
		
	}
}
