/**
 * auto-generated code
 * Sat Sep 05 15:14:44 CST 2009
 */
 package com.gmcc.pboss.web.resource.comcategoryrela;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.resource.comcategoryrela.ComcategoryrelaDBParam;
import com.gmcc.pboss.business.resource.comcategoryrela.ComcategoryrelaVO;
import com.gmcc.pboss.control.resource.comcategoryrela.Comcategoryrela;
import com.gmcc.pboss.control.resource.comcategoryrela.ComcategoryrelaBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.ui.struts2.BaseAction;

/**
 * <p>Title: ComcategoryrelaAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ComcategoryrelaAction extends BaseAction{
	
	public ComcategoryrelaAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new ComcategoryrelaForm());
		this.setParam(new ComcategoryrelaWebParam());

        //ָ��VO��
        setClsVO(ComcategoryrelaVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"relaid"};
		this.setClsControl(Comcategoryrela.class);
		this.setClsQueryParam(ComcategoryrelaDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	/**
	 * �ж�����/�༭��Ʒ��ʶ��ΨһԼ��
	 * @throws Exception
	 */
	public void checkUnique() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter writer  = null;
		
		try{
			String comid=request.getParameter("comid");
			writer = response.getWriter();
			Comcategoryrela bo=(Comcategoryrela)BOFactory.build(ComcategoryrelaBO.class,super.getDBAccessUser());	
			ComcategoryrelaDBParam param=new ComcategoryrelaDBParam();
			param.set_ne_comid(comid);
			//������Ʒ��ʶ��ѯ��Ʒ������Ϲ�ϵ��
			if(bo.doQuery(param).getDatas().size()>0){
				writer.write("NO");
			}
		}catch(Exception e){
			e.printStackTrace();
			
		}
		
	}
}