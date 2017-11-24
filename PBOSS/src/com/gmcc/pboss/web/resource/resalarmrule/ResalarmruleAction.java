package com.gmcc.pboss.web.resource.resalarmrule;


import com.gmcc.pboss.business.resource.comcategoryrela.ComcategoryrelaDBParam;
import com.gmcc.pboss.business.resource.comcategoryrela.ComcategoryrelaVO;
import com.gmcc.pboss.business.resource.resalarmrule.ResalarmruleDBParam;
import com.gmcc.pboss.business.resource.resalarmrule.ResalarmruleVO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.control.resource.comcategoryrela.Comcategoryrela;
import com.gmcc.pboss.control.resource.comcategoryrela.ComcategoryrelaBO;
import com.gmcc.pboss.control.resource.resalarmrule.Resalarmrule;
import com.gmcc.pboss.control.resource.resalarmrule.ResalarmruleBO;


/**
 * <p>Title: ResalarmruleAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class ResalarmruleAction extends BaseAction{
	
	public ResalarmruleAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new ResalarmruleForm());
		this.setParam(new ResalarmruleDBParam());

        //ָ��VO��
        setClsVO(ResalarmruleVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"recid"};
		this.setClsControl(Resalarmrule.class);
		this.setClsQueryParam(ResalarmruleDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}

	@Override
	public String doList() throws Exception {
		// TODO Auto-generated method stub
		ResalarmruleDBParam param = (ResalarmruleDBParam)super.getParam();
		if( null == param.get_se_cityid()){
			param.set_se_cityid(super.getDBAccessUser().getCityid());
		}
		return super.doList();
	}

	@Override
	public String doNew() throws Exception {
		// TODO Auto-generated method stub
		return super.doNew();
	}

	@Override
	public String doSave() throws Exception {
		// TODO Auto-generated method stub
		try{
			ResalarmruleForm form = (ResalarmruleForm) super.getForm();
			Comcategoryrela comcategoryrelaBO = (Comcategoryrela)BOFactory.build(ComcategoryrelaBO.class, super.getDBAccessUser());
			ComcategoryrelaDBParam comcategoryParam = new ComcategoryrelaDBParam();
			comcategoryParam.set_se_comcategory(form.getComcategory());
			DataPackage dp = comcategoryrelaBO.doQuery(comcategoryParam);
			ComcategoryrelaVO comcategoryrelaVO = (ComcategoryrelaVO)dp.getDatas().get(0);
			if("COMRESSMP".equals(comcategoryrelaVO.getRestype())  ){
				if(null == form.getUpactrate())
				throw new Exception("�׿� ���������޲�����Ϊ��");
			}else{//�����Ʒ�������Դ������׿��򼤻��������ֶ����գ�
				form.setUpactrate(null);
			}
			
			Resalarmrule resalarmruleBO = (ResalarmruleBO)BOFactory.build(ResalarmruleBO.class,super.getDBAccessUser());
			ResalarmruleDBParam param = new ResalarmruleDBParam();
			param.set_se_cityid(form.getCityid());
			param.set_se_countyid(form.getCountyid());
			param.set_se_comcategory(form.getComcategory());
			param.setDataOnly(true);
			dp = resalarmruleBO.doQuery(param);
			if( null != dp && null != dp.getDatas() && !dp.getDatas().isEmpty()){
				ResalarmruleVO vo = (ResalarmruleVO)dp.getDatas().get(0);
				if(!vo.getRecid().equals(form.getRecid()))
					throw new Exception("��ͬ��¼�Ѿ����ڣ����顣");
			}
			super.doSave();
		}catch(Exception e){
			e.printStackTrace();
			super.addActionError(e.getMessage());
		}
		return WEB_RESULT_CONTENT;
	}
	
	
}