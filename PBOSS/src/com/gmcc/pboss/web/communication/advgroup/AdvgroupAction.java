/**
 * auto-generated code
 * Tue Sep 29 10:21:01 CST 2009
 */
 package com.gmcc.pboss.web.communication.advgroup;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.gmcc.pboss.business.channel.employee.EmployeeDBParam;
import com.gmcc.pboss.business.channel.employee.EmployeeVO;
import com.gmcc.pboss.business.communication.advgroup.AdvgroupDBParam;
import com.gmcc.pboss.business.communication.advgroup.AdvgroupVO;
import com.gmcc.pboss.business.communication.advgroup.AdvgroupVOHelper;
import com.gmcc.pboss.business.communication.advgroup.AdvgroupobjinfoVO;
import com.gmcc.pboss.business.communication.advgroupobj.AdvgroupobjDBParam;
import com.gmcc.pboss.business.communication.advgroupobj.AdvgroupobjVO;
import com.gmcc.pboss.control.channel.employee.Employee;
import com.gmcc.pboss.control.channel.employee.EmployeeBO;
import com.gmcc.pboss.control.communication.advgroup.Advgroup;
import com.gmcc.pboss.control.communication.advgroup.AdvgroupBO;
import com.gmcc.pboss.control.communication.advgroupobj.Advgroupobj;
import com.gmcc.pboss.control.communication.advgroupobj.AdvgroupobjBO;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBQueryParam;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.struts2.BaseAction;

/**
 * <p>Title: AdvgroupAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class AdvgroupAction extends BaseAction{
	
	public AdvgroupAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new AdvgroupForm());
		this.setParam(new AdvgroupWebParam());

        //指定VO类
        setClsVO(AdvgroupVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"groupid"};
		this.setClsControl(Advgroup.class);
		this.setClsQueryParam(AdvgroupDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	
	public String doList() throws Exception{
		//联合查询
		Advgroup advgroup = (Advgroup)BOFactory.build(AdvgroupBO.class,getDBAccessUser());
		AdvgroupDBParam param = (AdvgroupDBParam)getParam();
		AdvgroupobjDBParam param2 = new AdvgroupobjDBParam();
		param2.set_ne_oid(param.getGroupoid());
		param2.set_orderby("groupoid");
		param2.set_desc("1");
		Class[] clazz = new Class[]{AdvgroupVO.class,AdvgroupobjVO.class};
		Object[] params = new Object[] { param, param2 };
		String[][] joins = new String[][] { { "groupid", "groupid" } };
		
		DataPackage dp = advgroup.doUnionQuery(params, clazz, joins);;
		List<Object[]> unionList = dp.getDatas();
		
		//组合群组人员列表
		Employee employee = (Employee)BOFactory.build(EmployeeBO.class,getDBAccessUser());
		EmployeeDBParam param3 = new EmployeeDBParam();
		DataPackage dp3 = new DataPackage();
		String oname = new String();
		
		List<AdvgroupobjinfoVO> AdvgroupobjinfoList = new ArrayList();
		for(Object[] objs:unionList)
		{
			AdvgroupVO advgroupVO = (AdvgroupVO)objs[0];
			AdvgroupobjVO advgroupobjVO = (AdvgroupobjVO)objs[1];
			
			AdvgroupobjinfoVO advgroupobjinfoVO = new AdvgroupobjinfoVO();
			advgroupobjinfoVO.setGroupid(advgroupVO.getGroupid());
			advgroupobjinfoVO.setGroupname(advgroupVO.getGroupname());
			advgroupobjinfoVO.setOid(advgroupobjVO.getOid());
			
			param3.set_se_employeeid(advgroupobjVO.getOid());
			dp3 = employee.doQuery(param3);
			if(dp3.getRowCount()>0)
			{
				oname = ((List<EmployeeVO>)dp3.getDatas()).get(0).getEmployeename();
				advgroupobjinfoVO.setOname(oname);
			}
			
			AdvgroupobjinfoList.add(advgroupobjinfoVO);
		}
		
		//页面列表显示
		dp.setDatas(AdvgroupobjinfoList);
		setDp(dp);

		return WEB_RESULT_LIST;
	}
	
	public String doEdit() throws Exception{
		super.doEdit();
		AdvgroupVO advgroupVO = (AdvgroupVO) getForm();
		AdvgroupForm form= new AdvgroupForm();
		BeanUtils.copyProperties(form, advgroupVO);
		
		Advgroupobj advgroupobj = (Advgroupobj)BOFactory.build(AdvgroupobjBO.class, getDBAccessUser());
		AdvgroupobjDBParam param = new AdvgroupobjDBParam();
		param.set_ne_groupid(String.valueOf(form.getGroupid()));
		param.set_pagesize("0");
		DataPackage dp = advgroupobj.doQuery(param);
		
		
		Employee employee = (Employee)BOFactory.build(EmployeeBO.class, getDBAccessUser());
		EmployeeDBParam paramEmp = new EmployeeDBParam();
		
		List advgroupobjList = dp.getDatas();
		String objinfo = "";
		String oid = "";
		String oname = new String();
		if(advgroupobjList.size()>0)
		{
			for(int i=0; i<advgroupobjList.size(); i++)
			{
				oid = ((AdvgroupobjVO)advgroupobjList.get(i)).getOid();
				paramEmp.set_se_employeeid(oid);
				DataPackage dpEmp = employee.doQuery(paramEmp);
				if(null!=dpEmp && dpEmp.getDatas().size()>0)
				{
					oname = ((EmployeeVO)dpEmp.getDatas().get(0)).getEmployeename();
				}
				objinfo = objinfo + oid + " " + oname + ",";
			}
		}
		form.setObjinfo(objinfo);
		setForm(form);
		return WEB_RESULT_CONTENT;
	}
	
	public String doSave() throws Exception{
		AdvgroupForm form= (AdvgroupForm) getForm();
		//保存到群组表
		Advgroup advgroup = (Advgroup)BOFactory.build(AdvgroupBO.class, getDBAccessUser());
		
		try{
			AdvgroupDBParam param = new AdvgroupDBParam();
			if(getCMD().equals(WEB_CMD_EDIT)){
				param.set_nne_groupid(String.valueOf(form.getGroupid()));
			}
			param.set_se_groupname(form.getGroupname());
			DataPackage dp = advgroup.doQuery(param);
			if(dp.getRowCount()>0){
				throw new Exception("群组名称已经存在，请重新输入");
			}
			
			Boolean createFlag = null;
			if(getCMD().equals(WEB_CMD_NEW))
			{
				createFlag = true;
			}
			else
			{
				createFlag = false;
			}
			
			AdvgroupVOHelper helper = new AdvgroupVOHelper();
			BeanUtils.copyProperties(helper, form);
			Long groupid = advgroup.doSaveGroup(helper,createFlag);
			form.setGroupid(groupid);
		} catch (Exception e) {
			addActionError(e.getMessage());
			return WEB_RESULT_CONTENT;
			
		}
		
		setActionMessage("保存成功!");
		setCMD(WEB_CMD_SAVE);
		return WEB_RESULT_CONTENT;
	}
	
	//删除群组
	public String doDeleteGroup() throws Exception{
		try{
			//获取所有群组，群组人员列表id为：群组id+";"+群组人员id
			String[] selectArray = ((DBQueryParam) getParam()).get_selectitem();
			Set<String> groupidSet = new HashSet<String>();
			for (int i = 0; i < selectArray.length; i++) {
				groupidSet.add(selectArray[i].split(";")[0]);
			}
			Advgroup advgroup = (Advgroup)BOFactory.build(AdvgroupBO.class, getDBAccessUser());
			advgroup.doDeleteGroup(groupidSet);
		}catch(Exception e){
			this.addActionMessage(e.getMessage());
		}
		return doList();
	}
	
	public String doDeleteGroupobj() throws Exception{
		try{
			//获取群组人员id列表
			String[] selectArray = ((DBQueryParam) getParam()).get_selectitem();
			Set<String> groupidSet = new HashSet<String>();
			List<String> groupoidList = new ArrayList<String>();
			for (int i = 0; i < selectArray.length; i++) {
				groupidSet.add(selectArray[i].split(";")[0]);
				groupoidList.add(selectArray[i].split(";")[1]);
			}
			Advgroup advgroup = (Advgroup)BOFactory.build(AdvgroupBO.class, getDBAccessUser());
			advgroup.doDeleteGroupobj(groupidSet,groupoidList);
		}catch(Exception e){
			this.addActionMessage(e.getMessage());
		}		
		
		return doList();
	}
}