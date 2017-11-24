/**
 * auto-generated code
 * Wed Jul 16 15:07:03 CST 2014
 */
package com.gmcc.pboss.web.resource.emptysimbad;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.gmcc.pboss.business.resource.emptysimbad.EmptysimbadVO ;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.sunrise.jop.ui.struts2.WebConstant;
import com.gmcc.pboss.business.resource.emptysimbad.EmptysimbadDBParam;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.control.resource.emptysimbad.Emptysimbad ;
import com.gmcc.pboss.control.resource.emptysimbad.EmptysimbadBO;

/**
 * <p>Title: EmptysimbadAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
public class EmptysimbadAction extends BaseAction{
	
	public EmptysimbadAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new EmptysimbadForm());
		this.setParam(new EmptysimbadDBParam());

        //ָ��VO��
        setClsVO(EmptysimbadVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"emptyno"};
		this.setClsControl(Emptysimbad.class);
		this.setClsQueryParam(EmptysimbadDBParam.class) ;

	}

	public String doSave() throws Exception {
		EmptysimbadForm form = (EmptysimbadForm) getForm();
		Emptysimbad emptysimbad = (Emptysimbad) BOFactory.build(EmptysimbadBO.class, getDBAccessUser());
		EmptysimbadDBParam params = new EmptysimbadDBParam();
		params.set_se_emptyno(form.getEmptyno());
		DataPackage dp = emptysimbad.doQueryComcategory(params);
		if (dp.getDatas() == null || dp.getDatas().size() == 0) {
			addActionError("δ�ҵ��ÿհ�SIM����Ӧ����Ʒ���࣬���顣");
			return WEB_RESULT_CONTENT;
		}
		form.setComcategory(dp.getDatas().get(0).toString());
		form.setOprcode(getDBAccessUser().getOprcode());
		form.setCreatetime(new Date());
		return super.doSave();
	}
	
	public String doTxt() throws Exception {
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		export.setFileName("�հ�SIM������¼�뵼��");
		export.addOutputProperty("emptyno", "�հ�SIM�����к�");
		export.addOutputProperty("comcategory", "��Ʒ����", export.CODE2NAME,
				"$IM_FXCOMCATEGORY");
		export.addOutputProperty("wayid", "��������");
		export.addOutputProperty("wayid", "��������", export.CODE2NAME, "#WAY");
		export.addOutputProperty("createtime", "¼��ʱ��", export.DATE,
				"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("oprcode", "¼���˹���");
		export.voClassArray = new Class[] { EmptysimbadVO.class };

		prepareResponse(export.getFileName());
		export.writeTxtTitle(getResponse().getOutputStream(), new String[] {
				"�հ�SIM�����к�", "��Ʒ����", "��������", "��������", "¼��ʱ��", "¼���˹���" });
		super.ExportQuery(getForm(), getRequest(), getResponse(), user, export);
		return null;
	}
	
	public String doExcel() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		export.setFileName("�հ�SIM������¼�뵼��");
		export.addOutputProperty("emptyno", "�հ�SIM�����к�");
		export.addOutputProperty("comcategory", "��Ʒ����", export.CODE2NAME,
				"$IM_FXCOMCATEGORY");
		export.addOutputProperty("wayid", "��������");
		export.addOutputProperty("wayid", "��������", export.CODE2NAME, "#WAY");
		export.addOutputProperty("createtime", "¼��ʱ��", export.DATE,
				"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("oprcode", "¼���˹���");
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel();
	}
}