/**
 * auto-generated code
 * Fri May 25 11:37:59 CST 2012
 */
 package com.gmcc.pboss.web.resource.resoperator;

import java.util.List;

import com.gmcc.pboss.business.channel.custwaytype.CustwaytypeVO;
import com.gmcc.pboss.business.resource.resoperator.ResoperatorVO ;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.resource.resoperator.ResoperatorDBParam;
import com.gmcc.pboss.business.sales.comprice.CompriceDBParam;
import com.gmcc.pboss.business.sales.comprice.CompriceVOHelper;
import com.gmcc.pboss.control.resource.resoperator.Resoperator ;
import com.gmcc.pboss.control.resource.resoperator.ResoperatorBO;
import com.gmcc.pboss.control.sales.comprice.Comprice;
import com.gmcc.pboss.control.sales.comprice.CompriceBO;
import com.gmcc.pboss.web.sales.comprice.CompriceForm;

/**
 * <p>Title: ResoperatorAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ResoperatorAction extends BaseAction{
	
	public ResoperatorAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new ResoperatorForm());
		this.setParam(new ResoperatorDBParam());

        //ָ��VO��
        setClsVO(ResoperatorVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"wayid"};
		this.setClsControl(Resoperator.class);
		this.setClsQueryParam(ResoperatorDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	public String doList () throws Exception{
		try {
			 ResoperatorDBParam params = (ResoperatorDBParam)getParam();
			Resoperator resoperator = (ResoperatorBO) BOFactory.build(
					ResoperatorBO.class, getDBAccessUser());
			DataPackage dp = resoperator.doWayinfo(params);
			this.setDp(dp);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return WEB_RESULT_LIST;
	}
	
	
	public String doSave() throws Exception{  
		try {
			ResoperatorForm form = (ResoperatorForm) getForm();
			Resoperator resoperator = (ResoperatorBO) BOFactory.build(
					ResoperatorBO.class, getDBAccessUser());
			//��ѯ��¼�Ƿ��Ѿ����� 
			ResoperatorVO vo= resoperator.doFindByPk(form.getWayid());
			
			if (WEB_CMD_NEW.equals(CMD)) {  
				if (null != vo) {
	                setActionMessage("��ͬ��¼�Ѿ����ڣ����顣");
					}
					ResoperatorVO resoperatorVO = new ResoperatorVO ();
					resoperatorVO.setWayid(form.getWayid());
					resoperatorVO.setOperid(form.getOperid());
					resoperatorVO.setCityid(getDBAccessUser().getCityid());
					resoperator.doCreate(resoperatorVO); 
					setActionMessage("�����ɹ�"); 
			}else{   
				vo.setOperid(form.getOperid());
				vo.setCityid(getDBAccessUser().getCityid());
				resoperator.doUpdate(vo);
				
			    setActionMessage("�޸ĳɹ�");
			}
			CMD = WEB_CMD_SAVE;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return WEB_RESULT_CONTENT;
	}
	
}