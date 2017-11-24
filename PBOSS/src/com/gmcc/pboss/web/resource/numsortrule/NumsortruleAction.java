/**
 * auto-generated code
 * Sat Sep 05 17:12:41 CST 2009
 */
 package com.gmcc.pboss.web.resource.numsortrule;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.resource.numsortrule.NumsortruleDBParam;
import com.gmcc.pboss.business.resource.numsortrule.NumsortruleVO;
import com.gmcc.pboss.business.resource.numtypedef.NumtypedefVO;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.control.resource.numsortrule.Numsortrule;
import com.gmcc.pboss.control.resource.numsortrule.NumsortruleBO;
import com.gmcc.pboss.control.resource.numtypedef.Numtypedef;
import com.gmcc.pboss.control.resource.numtypedef.NumtypedefBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;

/**
 * <p>Title: NumsortruleAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class NumsortruleAction extends BaseAction{
	
	private NumtypedefVO  numtypedef;//��������
	public NumtypedefVO getNumtypedef() {
		return numtypedef;
	}

	public void setNumtypedef(NumtypedefVO numtypedef) {
		this.numtypedef = numtypedef;
	}

	public NumsortruleAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new NumsortruleForm());
		this.setParam(new NumsortruleWebParam());

        //ָ��VO��
        setClsVO(NumsortruleVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"ruleid"};
		this.setClsControl(Numsortrule.class);
		this.setClsQueryParam(NumsortruleDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	
	public String doListByType(){
		try{
			Numtypedef numtypedefBO = (NumtypedefBO)BOFactory.build(NumtypedefBO.class,super.getDBAccessUser());
			Numsortrule numsortruleBO = (NumsortruleBO)BOFactory.build(NumsortruleBO.class,super.getDBAccessUser());
			NumsortruleDBParam params = (NumsortruleDBParam)super.getParam();
			numtypedef = numtypedefBO.doFindByPk(params.get_ne_typeid());//��ȡ��������
//			params.set_pagesize("10");//����ÿҳ10����¼
			DataPackage dp = numsortruleBO.doQuery(params);
			super.setDp(dp);
		}catch(Exception e){
			super.addActionError(e.getMessage());
		}
		return "listbytype";
	}
	public String doExcel() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("���������򵼳�");
		export.appendHeadLine(new String[] { "��������:", user.getOprcode() });
		export
				.appendHeadLine(new String[] { "����ʱ��",
						format.format(new Date()) });
		export.addOutputProperty("ruleexp", "������ʽ");
		NumsortruleDBParam param = (NumsortruleDBParam)super.getParam();
		param.setQueryAll(true);
		
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel();
	}
	
}