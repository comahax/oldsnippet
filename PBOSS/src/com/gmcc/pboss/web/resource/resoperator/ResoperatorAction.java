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

		//以下几个方法是必须的
		this.setForm(new ResoperatorForm());
		this.setParam(new ResoperatorDBParam());

        //指定VO类
        setClsVO(ResoperatorVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"wayid"};
		this.setClsControl(Resoperator.class);
		this.setClsQueryParam(ResoperatorDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
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
			//查询记录是否已经存在 
			ResoperatorVO vo= resoperator.doFindByPk(form.getWayid());
			
			if (WEB_CMD_NEW.equals(CMD)) {  
				if (null != vo) {
	                setActionMessage("相同记录已经存在，请检查。");
					}
					ResoperatorVO resoperatorVO = new ResoperatorVO ();
					resoperatorVO.setWayid(form.getWayid());
					resoperatorVO.setOperid(form.getOperid());
					resoperatorVO.setCityid(getDBAccessUser().getCityid());
					resoperator.doCreate(resoperatorVO); 
					setActionMessage("新增成功"); 
			}else{   
				vo.setOperid(form.getOperid());
				vo.setCityid(getDBAccessUser().getCityid());
				resoperator.doUpdate(vo);
				
			    setActionMessage("修改成功");
			}
			CMD = WEB_CMD_SAVE;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return WEB_RESULT_CONTENT;
	}
	
}